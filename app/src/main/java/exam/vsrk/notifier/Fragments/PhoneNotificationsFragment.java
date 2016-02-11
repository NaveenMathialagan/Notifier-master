package exam.vsrk.notifier.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;

import java.util.List;

import exam.vsrk.notifier.Adapters.AppNotifyAdapter;
import exam.vsrk.notifier.Database.DatabaseHandler;
import exam.vsrk.notifier.Instances.Notify;
import exam.vsrk.notifier.Adapters.PhoneNotifyAdapter;
import exam.vsrk.notifier.R;

/**
 * Created by VSRK on 12/25/2015.
 */
public class PhoneNotificationsFragment extends android.support.v4.app.Fragment {
    SwipeRefreshLayout swipeContainer;

    PhoneNotifyAdapter adapter;
    List<Notify> contacts;
    RecyclerView mrecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.feed_list, container, false);

        mrecyclerView=(RecyclerView) v.findViewById(R.id.recycler_view);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DatabaseHandler db=new DatabaseHandler(getActivity());
        contacts=db.getAllNotify();
        swipeContainer = (SwipeRefreshLayout) v.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                DatabaseHandler db=new DatabaseHandler(getActivity());
                contacts=db.getAllNotify();
                adapter = new PhoneNotifyAdapter(getActivity(),contacts);
                mrecyclerView.setAdapter(adapter);
                swipeContainer.setRefreshing(false);

            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        adapter = new PhoneNotifyAdapter(getActivity(),contacts);
        mrecyclerView.setAdapter(adapter);
      /*  Target homeTarget = new Target() {
            @Override
            public Point getPoint() {
                // Get approximate position of home icon's center
                int actionBarSize = getSupportActionBar().getHeight();
                int x = actionBarSize / 2;
                int y = actionBarSize / 2;
                return new Point(x, y);
            }
        };*/
        if(isFirstTime()) {
            new ShowcaseView.Builder(getActivity())

                    .setStyle(R.style.CustomShowcaseTheme2)
                    .setContentTitle("Instruction")
                    .setContentText("Long click on the phone notification to delete it..")
                    .hideOnTouchOutside()
                    .build();


        }

        return v;
    }

    private boolean isFirstTime()
    {
        Context mContext=null;
        SharedPreferences preferences = this.getActivity().getPreferences(mContext.MODE_PRIVATE);
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

