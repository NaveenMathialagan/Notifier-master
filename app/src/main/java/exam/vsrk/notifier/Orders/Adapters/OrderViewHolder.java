package exam.vsrk.notifier.Orders.Adapters;

/**
 * Created by VSRK on 1/13/2016.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import exam.vsrk.notifier.R;

/**
 * Created by VSRK on 12/22/2015.
 */
public class OrderViewHolder extends RecyclerView.ViewHolder {



    //public TextView textView;
    public TextView item;
    public TextView price;
    public TextView quantity;
    CardView cardView;
    Button delete;
    public OrderViewHolder(View view) {
        super(view);
        this.item = (TextView) view.findViewById(R.id.ITEM_NAME);
        this.price = (TextView) view.findViewById(R.id.ITEM_COST);
        this.quantity = (TextView) view.findViewById(R.id.ITEM_QTY);
        this.delete=(Button) view.findViewById(R.id.delete_btn);

    }
}