package exam.vsrk.notifier.Orders.Adapters;

/**
 * Created by VSRK on 1/12/2016.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import exam.vsrk.notifier.Orders.Database.DatabaseHandler;
import exam.vsrk.notifier.Instances.Notify;
import exam.vsrk.notifier.Orders.Instances.Orders;
import exam.vsrk.notifier.R;
import exam.vsrk.notifier.Orders.Instances.itemsnam;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    List<itemsnam> item;
    Context c;
    Button cart;
    int click=0;
    int color;

    ArrayList<Integer> stateList = new ArrayList<Integer>();

    public ItemAdapter(List<itemsnam> item, Context c, Button cart){
        this.c=c;
        this.item = item;
        this.cart=cart;
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView ItemName;
        TextView ItemRate;
        TextView ItemQty;
        TextView rs,qtytxt;
        Button p,m,cartbutton;
        CheckBox c;
        ItemViewHolder(View itemView,Button cartbutton) {
            super(itemView);
            this.cartbutton=cartbutton;


            cv = (CardView)itemView.findViewById(R.id.cv1);

            ItemName = (TextView)itemView.findViewById(R.id.item_name);
            ItemRate = (TextView)itemView.findViewById(R.id.item_rate);
            ItemQty = (TextView)itemView.findViewById(R.id.qty);
            rs=(TextView) itemView.findViewById(R.id.rs);
            qtytxt=(TextView)itemView.findViewById(R.id.qtytxt);
            p=(Button)itemView.findViewById(R.id.plus);
            m=(Button)itemView.findViewById(R.id.minus);


        }
        public int getPos()
        {
            return getAdapterPosition();
        }
    }



    //public static class ItemViewHolder extends RecyclerView.ViewHolder
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item, viewGroup, false);


        ItemViewHolder pvh = new ItemViewHolder(v,cart);

        return pvh;
        // return pv;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder ItemViewHolder,final int i) {

        ItemViewHolder.ItemName.setText(item.get(i).iname);

        ItemViewHolder.ItemRate.setText(item.get(i).rs+" ");
        ItemViewHolder.ItemQty.setText(item.get(i).qty+" ");

        ItemViewHolder.p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.get(i).qty =item.get(i).qty+1;
                ItemViewHolder.ItemQty.setText(item.get(i).qty+" ");
            }
        });

        ItemViewHolder.m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.get(i).qty>1){
                    item.get(i).qty =item.get(i).qty-1;
                    ItemViewHolder.ItemQty.setText( item.get(i).qty +" ");
                }
            }
        });


                ItemViewHolder.cv.setOnClickListener(new View.OnClickListener() {
                    int ch=0;
                    int cc;
                    @Override
                    public void onClick(View v) {
                        for(int k=0;k<stateList.size();k++) {
                            if(stateList.get(k)==i) {
                                cc=k;
                                ch=1;
                            }
                            else
                                ch=0;

                        }
                        if(ch==0)
                        {
                                Log.v("CLICKED_INDEX", item.get(i).iname);
                                ItemViewHolder.cv.setCardBackgroundColor(Color.parseColor("#d32f2f"));
                                color = Color.TRANSPARENT;
                                Drawable background = ItemViewHolder.cv.getBackground();
                                if (background instanceof ColorDrawable)
                                    color = ((ColorDrawable) background).getColor();
                                ItemViewHolder.ItemName.setTextColor(Color.WHITE);
                                ItemViewHolder.ItemQty.setTextColor(Color.WHITE);
                                ItemViewHolder.ItemRate.setTextColor(Color.WHITE);
                                ItemViewHolder.rs.setTextColor(Color.WHITE);
                                ItemViewHolder.qtytxt.setTextColor(Color.WHITE);
                                Log.v("POSITION", String.valueOf(i));
                                stateList.add(i);

                            }
                        else
                            {
                                ItemViewHolder.cv.setCardBackgroundColor(Color.WHITE);
                                color = Color.TRANSPARENT;
                                Drawable background = ItemViewHolder.cv.getBackground();
                                if (background instanceof ColorDrawable)
                                    color = ((ColorDrawable) background).getColor();
                                ItemViewHolder.ItemName.setTextColor(Color.BLACK);
                                ItemViewHolder.ItemQty.setTextColor(Color.BLACK);
                                ItemViewHolder.ItemRate.setTextColor(Color.BLACK);
                                ItemViewHolder.rs.setTextColor(Color.BLACK);
                                ItemViewHolder.qtytxt.setTextColor(Color.BLACK);
                                Log.v("POSITION", String.valueOf(i));
                                stateList.remove(cc);

                            }




                    }
                });

           ItemViewHolder.cartbutton.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View view) {
                   for(int j=0;j<stateList.size();j++)
                   {
                       Log.v("MARKED_POS",String.valueOf(stateList.get(j)));
                       String ITEM_NAME= item.get(stateList.get(j)).iname;
                       String PRICE= String.valueOf(item.get(stateList.get(j)).rs);
                       String QUANTITY= String.valueOf(item.get(stateList.get(j)).qty);
                       DatabaseHandler db=new DatabaseHandler(c);
                       db.addNotify(new Orders(ITEM_NAME,PRICE,QUANTITY));



                   }
                   Toast.makeText(c,"Items Added to Cart",Toast.LENGTH_LONG).show();
               }
           });


    }

    @Override
    public int getItemCount() {
        return item.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
