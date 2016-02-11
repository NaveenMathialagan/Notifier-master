package exam.vsrk.notifier.Orders.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import exam.vsrk.notifier.MainActivity;
import exam.vsrk.notifier.R;

public class FinalActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(FinalActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Button GO_HOME;
        GO_HOME=(Button)findViewById(R.id.HOME_BTN);
        GO_HOME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FinalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



}
