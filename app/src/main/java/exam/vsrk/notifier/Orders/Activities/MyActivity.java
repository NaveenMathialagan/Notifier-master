package exam.vsrk.notifier.Orders.Activities;

/**
 * Created by VSRK on 1/12/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import exam.vsrk.notifier.MainActivity;
import exam.vsrk.notifier.R;
import exam.vsrk.notifier.Orders.Adapters.catAdapter;
import exam.vsrk.notifier.Orders.Instances.catagory;


public class MyActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
    Intent intent=new Intent(MyActivity.this, MainActivity.class);
    startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        catagory c=new catagory();
        List<catagory> item=c.initializeData();
        catAdapter adapter = new catAdapter(item,this);
        rv.setAdapter(adapter);
        Button ORDER=(Button)findViewById(R.id.ORDER_BTN);
        ORDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MyActivity.this,InformationActivity.class);
                startActivity(it);
            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

