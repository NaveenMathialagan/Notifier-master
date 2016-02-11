package exam.vsrk.notifier.Orders.Activities;

/**
 * Created by VSRK on 1/12/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.github.amlcurran.showcaseview.targets.Target;

import java.util.List;

import exam.vsrk.notifier.Orders.Adapters.ItemAdapter;
import exam.vsrk.notifier.R;
import exam.vsrk.notifier.Orders.Instances.itemsnam;


public class Item extends AppCompatActivity {
    public Button goback,cart,ORDER_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent = getIntent();
        String item = intent.getStringExtra("cat");
        int pos = intent.getIntExtra("catpos", 0);
        Log.d("Item", item);
        Log.d("Position", pos + " ");
        goback = (Button) findViewById(R.id.gb);
        cart = (Button) findViewById(R.id.ac);
        ORDER_BTN = (Button) findViewById(R.id.ORDER_BTN);
        ORDER_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Item.this, InformationActivity.class);
                startActivity(it);
            }
        });
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv1);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        List<itemsnam> items = null;
        itemsnam i = new itemsnam();
        if (item.equals("Chicken")) {

            items = i.Chicken();
        }
        if (item.equals("Bucket")) {

            items = i.Bucket();
        }
        if (item.equals("BoneLess")) {

            items = i.boneless();
        }
        if (item.equals("Rollers")) {

            items = i.rollers();
        }
        if (item.equals("Rice Bowlz")) {

            items = i.ricebowlz();
        }
        if (item.equals("Burgers")) {

            items = i.Burgers();
        }
        if (item.equals("Box Meal")) {

            items = i.boxmeal();
        }
        if (item.equals("A la carte")) {

            items = i.Alacarte();
        }
      /*  if(item.equals("Krushers")){

            items=i.krushers();
        }
        if(item.equals("Dessert")){

            items=i.dessert();
        }*/


        ItemAdapter adapter = new ItemAdapter(items, this, cart);
        rv.setAdapter(adapter);
        Target homeTarget = new Target() {
            @Override
            public Point getPoint() {
                // Get approximate position of home icon's center
                int actionBarSize = getSupportActionBar().getHeight();
                int x = actionBarSize / 2;
                int y = actionBarSize / 2;
                return new Point(x, y);
            }
        };

        if(isFirstTime()) {
            new ShowcaseView.Builder(this)

                    .setTarget(homeTarget)
                    .setStyle(R.style.CustomShowcaseTheme2)
                    .setContentTitle("Instruction")
                    .setContentText("Click on the Item to select it and then add it to cart and checkout.")
                    .hideOnTouchOutside()
                    .build();


        }
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
    public void goback(View v){
        Intent intent=new Intent(this,MyActivity.class);
        this.startActivity(intent);
    }
    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }
}

