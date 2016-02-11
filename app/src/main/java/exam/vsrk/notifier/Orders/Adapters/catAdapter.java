package exam.vsrk.notifier.Orders.Adapters;

/**
 * Created by VSRK on 1/12/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import exam.vsrk.notifier.Orders.Activities.Item;
import exam.vsrk.notifier.R;
import exam.vsrk.notifier.Orders.Instances.catagory;


/**
 * Created by Naveen kumar on 10-01-2016.
 */
public class catAdapter extends RecyclerView.Adapter<catAdapter.catViewHolder>{
    List<catagory> catagories;
    Context c;
    public catAdapter(List<catagory> catagories, Context c)
    {
        this.c=c;
        this.catagories =catagories;
    }
    public static class catViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView catName;
        ImageView catPhoto;

        catViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            catName = (TextView)itemView.findViewById(R.id.cat_name);
            catPhoto = (ImageView)itemView.findViewById(R.id.cat_photo);

        }
    }
    @Override
    public catViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.catagory, viewGroup, false);
        catViewHolder pvh = new catViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final catViewHolder catViewHolder, final int i) {
        catViewHolder.catName.setText(catagories.get(i).name);
        catViewHolder.catPhoto.setImageResource(catagories.get(i).photoId);
        catViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST","Clicked");
                Log.d("Naveen", "onClick " +i);
                Log.d("Naveen",catViewHolder.catName.getText().toString());

                Intent intent=new Intent(c,Item.class);
                intent.putExtra("cat",catViewHolder.catName.getText().toString());
                intent.putExtra("catpos",i);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return catagories.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}