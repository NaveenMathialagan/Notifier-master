package exam.vsrk.notifier;

import android.location.Address;
import android.location.Geocoder;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import exam.vsrk.notifier.Adapters.PagerAdapter;
import exam.vsrk.notifier.Database.DatabaseHandler;
import exam.vsrk.notifier.Orders.Activities.MyActivity;


public class MainActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler=new DatabaseHandler(this);
   /* GPSTracker gps;
    Geocoder geocoder;
    List<Address> addresses;*/
    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
       if (Settings.Secure.getString(this.getContentResolver(),"enabled_notification_listeners").contains(getApplicationContext().getPackageName()))
        {

        } else {
            Toast.makeText(MainActivity.this,"Please Turn on Notification Access for Notifier",Toast.LENGTH_LONG).show();
            startActivity(new Intent(
                    "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }}
        catch (NullPointerException e){

        }
        Button KFC_ORDER=(Button)findViewById(R.id.KFC_BTN);
        KFC_ORDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TAG_CLICKED","clicked");
                Intent it=new Intent(MainActivity.this,MyActivity.class);
                startActivity(it);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("INSTALLED APPS"));
        tabLayout.addTab(tabLayout.newTab().setText("AROUND ME"));
//        tabLayout.addTab(tabLayout.newTab().setText("OTHER APP NOTIFICATIONS"));
        tabLayout.addTab(tabLayout.newTab().setText("OTHER APPS"));
        tabLayout.addTab(tabLayout.newTab().setText("PHONE NOTIFICATIONS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, new IntentFilter("Msg"));


    }


    private BroadcastReceiver onNotice= new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

}
