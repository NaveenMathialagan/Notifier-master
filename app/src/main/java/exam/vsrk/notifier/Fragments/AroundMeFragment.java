package exam.vsrk.notifier.Fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import exam.vsrk.notifier.Adapters.GeneralAdapter;

import exam.vsrk.notifier.Extras.AppController;
import exam.vsrk.notifier.Gson.Post;
import exam.vsrk.notifier.Instances.FeedItem;
import exam.vsrk.notifier.R;

/**
 * Created by VSRK on 12/22/2015.
 */
public class AroundMeFragment extends android.support.v4.app.Fragment {

    RecyclerView mRecyclerView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeContainer;
    private GeneralAdapter adapter;
    List<Post> posts;
    private List<FeedItem> feedsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.around_feed_list, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = (ProgressBar) v.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        swipeContainer = (SwipeRefreshLayout) v.findViewById(R.id.swipeContainer);
        final String URL_JSON = "http://www.100words100things.in/process.php";
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                call_api(URL_JSON);
                swipeContainer.setRefreshing(false);

            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        call_api(URL_JSON);
        return v;
    }

    public void call_api(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("RESPONSE_LOG", response);

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        Type fooType = new TypeToken<ArrayList<Post>>() {
                        }.getType();
                        List<Post> posts = gson.fromJson(response, fooType);
                        handlePostsList(posts);
                        progressBar.setVisibility(View.GONE);
                        adapter = new GeneralAdapter(getActivity(), feedsList);
                        mRecyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("Something went wrong!");
                Toast.makeText(getActivity(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        });
        int socketTimeout = 30000000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        AppController.getInstance().addToRequestQueue(stringRequest);

    }

    private void handlePostsList(List<Post> posts) {


        this.posts = posts;

        feedsList = new ArrayList<>();

        for (Post post : this.posts) {
            if (post.app_type.equals("Around Me")) {
                FeedItem item = new FeedItem();

                item.setNotification(post.description);
                item.setIcon(post.logo);
                item.setDescription(post.notification);
                item.setAppName(post.appname);
                item.setPack(post.packa);
                feedsList.add(item);
            }
        }

    }
}