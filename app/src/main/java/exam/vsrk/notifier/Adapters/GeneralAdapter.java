package exam.vsrk.notifier.Adapters;

/**
 * Created by VSRK on 1/12/2016.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import exam.vsrk.notifier.Instances.FeedItem;
import exam.vsrk.notifier.R;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import exam.vsrk.notifier.Instances.FeedItem;
import exam.vsrk.notifier.R;


public class GeneralAdapter extends RecyclerView.Adapter<CustomViewHolder> {


    private List<FeedItem> feedItemList;
    private Context mContext;
    RecyclerView tr;



    public GeneralAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        CustomViewHolder mh = new CustomViewHolder(v);



        return mh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder feedListRowHolder, final int i) {
        final FeedItem feedItem = feedItemList.get(i);
        if (!isPackageInstalled(feedItem.getPack(), mContext)) {
    String url="http://www.thecityshoppers.com/"+feedItem.getIcon();
            if (!TextUtils.isEmpty(feedItem.getIcon())) {
                Picasso.with(mContext)
                        .load(url)
                        .error(R.drawable.ic_launcher)
                        .placeholder(R.drawable.ic_launcher)
                        .into(feedListRowHolder.imageView);
            } else {
                feedListRowHolder.imageView.setImageResource(R.drawable.ic_launcher);
            }
            if (!TextUtils.isEmpty(feedItem.getNotification())) {

                feedListRowHolder.title.setText(feedItem.getDescription());

            } else
                feedListRowHolder.cardView.setVisibility(View.GONE);

            feedListRowHolder.pack.setText(feedItem.getNotification());
            feedListRowHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Dialog dialog = new Dialog(mContext);

                    dialog.setContentView(R.layout.custom_dialog);
                    dialog.setTitle("Details..");
                    TextView details=(TextView) dialog.findViewById(R.id.details);
                    details.setText(feedItem.getDescription());
                    dialog.show();
                }
            });
            feedListRowHolder.text.setVisibility(View.GONE);
        }
        else
            feedListRowHolder.cardView.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {

        return (null != feedItemList ? feedItemList.size() : 0);
    }
    private boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
