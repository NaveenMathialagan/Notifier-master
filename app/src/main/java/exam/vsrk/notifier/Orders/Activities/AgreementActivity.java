package exam.vsrk.notifier.Orders.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import exam.vsrk.notifier.R;

/**
 * Created by vsramkishore on 25/1/16.
 */
public class AgreementActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstancestate) {
       super.onCreate(savedInstancestate);
       setContentView(R.layout.page_agreement);
        Button b=(Button)findViewById(R.id.agreed);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AgreementActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });

    }


}
