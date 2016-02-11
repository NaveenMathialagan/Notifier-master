package exam.vsrk.notifier.Orders.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import exam.vsrk.notifier.Extras.AppController;
import exam.vsrk.notifier.MainActivity;
import exam.vsrk.notifier.R;

public class InformationActivity extends AppCompatActivity {

    String SAVED_NAME,SAVED_ADDRESS,SAVED_PHONE;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(InformationActivity.this, MyActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        final EditText name, address, phone;
        Button ORDER_BTN,CANCEL_ORDER;
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        ORDER_BTN=(Button) findViewById(R.id.FINAL_ORDER);
        CANCEL_ORDER= (Button) findViewById(R.id.CANCEL_ORDER);

        SAVED_NAME = pref.getString("name", null);
        SAVED_ADDRESS = pref.getString("address", null);
        SAVED_PHONE = pref.getString("phone", null);
        try {


            if (!SAVED_NAME.equals("") && !SAVED_ADDRESS.equals("") && !SAVED_PHONE.equals("")) {
                name.setText(SAVED_NAME);
                address.setText(SAVED_ADDRESS);
                phone.setText(SAVED_PHONE);
            }
        }catch (NullPointerException exc)
        {
            exc.printStackTrace();
        }

            ORDER_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.getText().toString().equals("") && !address.getText().toString().equals("") && (phone.getText().toString().length() == 10)) {

                    editor.putString("name", name.getText().toString());
                    editor.putString("address", address.getText().toString());
                    editor.putString("phone", phone.getText().toString());
                    editor.commit();
                    Intent intent=new Intent(InformationActivity.this,OrderActivity.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(InformationActivity.this, "Please fill in all the details and Make Sure you have entered valid 10 digit mobile no", Toast.LENGTH_LONG).show();

                }

            }
        });

    CANCEL_ORDER.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Calendar c = Calendar.getInstance();
        int hours = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);


        if (hours <= 16 && minutes <= 30)

        {


            String UPLOAD_URL = "http://100words100things.in/deleteorder.php";

        StringRequest postRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(InformationActivity.this, "Your Order is deleted", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InformationActivity.this, "Check Your Connection", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("phone", phone.getText().toString());

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(postRequest);
    }
        else
        {
            Toast.makeText(InformationActivity.this,"Sorry Order cannot be cancelled after 4.30pm",Toast.LENGTH_SHORT).show();
        }
    }
});
        }
    }



