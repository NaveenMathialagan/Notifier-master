package exam.vsrk.notifier.Fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import exam.vsrk.notifier.Adapters.AppNotifyAdapter;
import exam.vsrk.notifier.Database.DatabaseHandler;
import exam.vsrk.notifier.Instances.Notify;
import exam.vsrk.notifier.R;

/**
 * Created by VSRK on 12/22/2015.
 */
public class AppNotificationsFragment extends android.support.v4.app.Fragment {
    SwipeRefreshLayout swipeContainer;
    RecyclerView mrecyclerView;
    AppNotifyAdapter adapter;
    List<Notify> contacts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.feed_list, container, false);
        mrecyclerView=(RecyclerView) v.findViewById(R.id.recycler_view);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        swipeContainer = (SwipeRefreshLayout) v.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                DatabaseHandler db=new DatabaseHandler(getActivity());
                contacts=db.getAllNotify();
                adapter = new AppNotifyAdapter(getActivity(),contacts);
                mrecyclerView.setAdapter(adapter);
                swipeContainer.setRefreshing(false);

            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        DatabaseHandler db=new DatabaseHandler(getActivity());
        contacts=db.getAllNotify();
        adapter = new AppNotifyAdapter(getActivity(),contacts);
        mrecyclerView.setAdapter(adapter);
        return v;
    }
}
