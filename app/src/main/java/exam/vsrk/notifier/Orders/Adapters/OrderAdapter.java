package exam.vsrk.notifier.Orders.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


import exam.vsrk.notifier.Orders.Activities.OrderActivity;
import exam.vsrk.notifier.Orders.Database.DatabaseHandler;
import exam.vsrk.notifier.Orders.Instances.Orders;
import exam.vsrk.notifier.R;

/**
 * Created by VSRK on 1/13/2016.
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {
    private Context mContext;

    List<Orders> feedsList;

    public OrderAdapter(Context context, List<Orders> feedsList) {
        this.feedsList = feedsList;
        this.mContext = context;
        Log.v("SET", "sET");
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_row, viewGroup, false);
        OrderViewHolder mh = new OrderViewHolder(v);


        return mh;
    }

    @Override
    public void onBindViewHolder(final OrderViewHolder viewHolder, int i) {

        if (feedsList.isEmpty()) {
            viewHolder.cardView.setVisibility(View.GONE);
        }

        final Orders cn = feedsList.get(i);
        Log.v("TAGHERE", cn.getItem());
        if (!TextUtils.isEmpty(cn.getItem())) {
            viewHolder.item.setText(Html.fromHtml(cn.getItem()));
        }
        if (!TextUtils.isEmpty(cn.getPrice())) {
            double price_temp = Double.parseDouble(cn.getPrice()) * Double.parseDouble(cn.getQuantity());
            double price = price_temp + 0.2 * price_temp;



            viewHolder.price.setText(Html.fromHtml("Rs." + String.valueOf(price)));
        }
        if (!TextUtils.isEmpty(cn.getQuantity()))
            viewHolder.quantity.setText(Html.fromHtml("Qty: " + cn.getQuantity()));
        if (TextUtils.isEmpty(cn.getItem()) || TextUtils.isEmpty(cn.getPrice()) || TextUtils.isEmpty(cn.getQuantity())) {
            viewHolder.item.setVisibility(View.GONE);
            viewHolder.price.setVisibility(View.GONE);
            viewHolder.quantity.setVisibility(View.GONE);
        }
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(mContext);
                db.delete(cn.getItem());
                //viewHolder.cardView.setVisibility(View.GONE);
                viewHolder.item.setVisibility(View.GONE);
                viewHolder.price.setVisibility(View.GONE);
                viewHolder.quantity.setVisibility(View.GONE);
                viewHolder.delete.setVisibility(View.GONE);

                List<Orders> contacts;
                contacts=db.getAllNotify();
                if(mContext instanceof OrderActivity){
                    ((OrderActivity)mContext).calculateTotal(contacts);

                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != feedsList ? feedsList.size() : 0);
    }



}