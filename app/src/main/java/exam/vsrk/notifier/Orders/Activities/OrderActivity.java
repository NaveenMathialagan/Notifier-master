package exam.vsrk.notifier.Orders.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exam.vsrk.notifier.Extras.AppController;
import exam.vsrk.notifier.Orders.Database.DatabaseHandler;
import exam.vsrk.notifier.Orders.Adapters.OrderAdapter;
import exam.vsrk.notifier.Orders.Instances.Orders;
import exam.vsrk.notifier.R;

public class OrderActivity extends AppCompatActivity {

    String UPLOAD_URL="http://www.thecityshoppers.com/order.php";
    String SAVED_NAME,SAVED_ADDRESS,SAVED_PHONE;
    double total;
    TextView tv;
    List<Orders> contacts;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanseState)
    {
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_order);
        db=new DatabaseHandler(this);
        tv=(TextView)findViewById(R.id.tot_amt);
        OrderAdapter adapter;


        RecyclerView mrecyclerView;
        mrecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));


        contacts=db.getAllNotify();
        calculateTotal(contacts);
        adapter = new OrderAdapter(this,contacts);
        mrecyclerView.setAdapter(adapter);

        Button ORDER=(Button)findViewById(R.id.FINAL_ORDER);
        ORDER.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                contacts=db.getAllNotify();
                if (contacts.isEmpty()||contacts.size()==0) {

                    Toast.makeText(OrderActivity.this,"Please Select the Item",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(OrderActivity.this,MyActivity.class);
                    startActivity(i);
                }else{
                    uploadDetails();

                }
            }
        });

    }

    public void calculateTotal(List<Orders> contacts) {
        double total=0;
        for(int k=0;k<contacts.size();k++)
        {
            double price_temp = Double.parseDouble(contacts.get(k).getPrice()) * Double.parseDouble(contacts.get(k).getQuantity());
            double price = price_temp + 0.2 * price_temp;
            total=total+price;


        }
        if(total>1200)
        {
            total+=100;
        }
        else
        total+=60;

        if (total==60){
            tv.setText("Total Amount Payable: Rs.0");
   }else {
    tv.setText("Total Amount Payable: Rs." + String.valueOf(Math.round(total)));
   }

    }

    public void uploadDetails()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        SAVED_NAME = pref.getString("name", null);
        SAVED_ADDRESS = pref.getString("address", null);
        SAVED_PHONE = pref.getString("phone", null);

        StringRequest postRequest = new StringRequest(Request.Method.POST,UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(),
                                "Your Order is Sucessesfully Placed",
                                Toast.LENGTH_LONG).show();
                         DatabaseHandler db=new DatabaseHandler(OrderActivity.this);
                         db.truncate();
                        Intent intent=new Intent(OrderActivity.this,FinalActivity.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),
                        "Failed to Order, Check your connection", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                List<Orders> ordersList;
                DatabaseHandler db = new DatabaseHandler(OrderActivity.this);
                ordersList = db.getAllNotify();
                StringBuilder sb=new StringBuilder();
                StringBuilder sb1=new StringBuilder();
                StringBuilder sb2=new StringBuilder();

                for(int k=0;k<ordersList.size();k++)
                {

                    double price_temp=Double.parseDouble(ordersList.get(k).getPrice())*Double.parseDouble(ordersList.get(k).getQuantity());
                    double price= price_temp+0.2*price_temp;

                    sb.append(ordersList.get(k).getItem() + ",");
                    sb1.append(String.valueOf(price)+",");
                    sb2.append(ordersList.get(k).getQuantity()+",");

                }

                Map<String, String> params = new HashMap<String, String>();


                    params.put("name", SAVED_NAME);
                    params.put("phone", SAVED_PHONE);
                    params.put("address",SAVED_ADDRESS);
                    params.put("ITEM_NAME",sb.toString());
                    params.put("price",sb1.toString());
                    params.put("quantity",sb2.toString());

                return params;

            }
        };

        AppController.getInstance().addToRequestQueue(postRequest);


}

}






