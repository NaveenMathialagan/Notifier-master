package exam.vsrk.notifier.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import exam.vsrk.notifier.Database.DatabaseHandler;
import exam.vsrk.notifier.Instances.Notify;
import exam.vsrk.notifier.R;

/**
 * Created by VSRK on 12/25/2015.
 */
public class PhoneNotifyAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    SimpleDateFormat sdf;
    Calendar calendar1;
    Calendar calendar2;
    Context mContext;
    RecyclerView tr;
    private int previousPosition = 0;
    DatabaseHandler db;

    List<Notify> contacts;


    public PhoneNotifyAdapter(Context context, List<Notify> contacts) {
        this.contacts = contacts;
        this.mContext = context;
        this.sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        calendar1= Calendar.getInstance();
        calendar2 = Calendar.getInstance();
        db= new DatabaseHandler(this.mContext);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        CustomViewHolder mh = new CustomViewHolder(v);


        return mh;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder feedListRowHolder, final int i) {
        final Notify cn = contacts.get(i);
        // Writing Contacts to log
        if(cn.getNotiType().equals("phone")){
           try{
            String time = sdf.format(new Date());
               int year=Integer.parseInt(time.substring(0,4));
               int month=Integer.parseInt(time.substring(4,6));
               int dat=Integer.parseInt(time.substring(6,8));
               int hour=Integer.parseInt(time.substring(9,11));
               int minit=Integer.parseInt(time.substring(11,13));
               int second=Integer.parseInt(time.substring(13,15));

               calendar2.set(year,month,dat,hour,minit,second);

               int dbhour=Integer.parseInt(cn.getHour());
               int dbminit=Integer.parseInt(cn.getMinit());
               int dbsecond=Integer.parseInt(cn.getSecond());
               int dbdate=Integer.parseInt(cn.getDate());
               int dbmonth=Integer.parseInt(cn.getMonth());
               int dbyear=Integer.parseInt(cn.getYear());

               calendar1.set(dbyear,dbmonth,dbdate,dbhour,dbminit,dbsecond);

                long miliSecondForDate1 = calendar1.getTimeInMillis();
               long miliSecondForDate2 = calendar2.getTimeInMillis();

               long diffInMilis = miliSecondForDate2 - miliSecondForDate1;

               int diffInMinute =(int) diffInMilis / (60 * 1000);

               int diffInHour = (int)diffInMilis / (60 * 60 * 1000);
               if(diffInHour>=8){

                   db.deleteNotify(cn.getHour(),cn.getMinit(),cn.getSecond(),cn.getDate(),mContext);

                   feedListRowHolder.cardView.setVisibility(View.GONE);

                   /* contacts.remove(i);
                   feedListRowHolder.cardView.setVisibility(View.GONE);*/
               }else{

               if(diffInHour==0){

                   feedListRowHolder.time.setText(Html.fromHtml(diffInMinute+" min ago"));
               }
               if (diffInHour>0){
                   feedListRowHolder.time.setText(Html.fromHtml(diffInHour+" hrs ago"));
               }
               if(diffInMinute==0){
                   feedListRowHolder.time.setText(Html.fromHtml("few seconds ago"));

               }
               feedListRowHolder.pack.setText(Html.fromHtml(cn.getApp()));
               feedListRowHolder.title.setText(Html.fromHtml(cn.getTitle()));
               feedListRowHolder.text.setText(Html.fromHtml(cn.getText()));


               Drawable icon = null;
            try {
                icon = mContext.getPackageManager().getApplicationIcon(cn.getPackage());
                feedListRowHolder.imageView.setImageDrawable(icon);

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
               }
           }catch (NullPointerException e){
                e.printStackTrace();
           }
            feedListRowHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // or you can replace **'this'** with your **ActivityName.this**
                    try {
                        Intent i = mContext.getPackageManager().getLaunchIntentForPackage(cn.getPackage());
                        mContext.startActivity(i);

                        db.deleteNotify(cn.getHour(),cn.getMinit(),cn.getSecond(),cn.getDate(),mContext);

                        feedListRowHolder.cardView.setVisibility(View.GONE);

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                    }
                }
            });

        }
        else
            feedListRowHolder.cardView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return (null != contacts ? contacts.size() : 0);
    }


}