package exam.vsrk.notifier.Orders.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Button ORDER_BTN;
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        ORDER_BTN=(Button) findViewById(R.id.FINAL_ORDER);

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



        }
    }



