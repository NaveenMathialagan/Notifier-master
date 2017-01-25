package exam.vsrk.notifier.Orders.Instances;

/**
 * Created by VSRK on 1/12/2016.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
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
import java.util.ArrayList;
import java.util.List;

import exam.vsrk.notifier.Extras.AppController;
import exam.vsrk.notifier.MainActivity;
import exam.vsrk.notifier.Orders.Activities.Item;
import exam.vsrk.notifier.Orders.Adapters.ItemAdapter;

/**
 * Created by Naveen kumar on 10-01-2016.
 */
public class itemsnam {
   public String iname;
  public int rs;
    Context c;
    Button b;
    RecyclerView rv;

    private List<ofrinst> ofrinsts;
   public int qty;
   public List<gson> gson;
    public itemsnam(){


    }
    public itemsnam(String iname,int rs,int qty){
        this.iname=iname;
        this.rs=rs;
        this.qty=qty;
    }
    private List<itemsnam> cat;


    public List Chicken(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Hot Wings-2pc",40,1));
        cat.add(new itemsnam("Hot & Crispy-2pc",139,1));
        cat.add(new itemsnam("Hot & Crispy-4pc",269,1));
        cat.add(new itemsnam("Hot & Crispy-6pc",399,1));

        cat.add(new itemsnam("Fiery Grilled-2pc",139,1));
        cat.add(new itemsnam("Fiery Grilled-4pc",269,1));
        cat.add(new itemsnam("Fiery Grilled-6pc",399,1));


        return cat;
    }
    public List Bucket(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Strips-3pc",99,1));
        cat.add(new itemsnam("Strips-3pc with Meal",159,1));
        cat.add(new itemsnam("Wings-5pc",99,1));
        cat.add(new itemsnam("Wings-5pc with Meal",159,1));
        cat.add(new itemsnam("Med.Popcorn",99,1));
        cat.add(new itemsnam("Med.Popcorn with Meal",159,1));
        cat.add(new itemsnam("Mingles Variety Bucket",199,1));
        cat.add(new itemsnam("Mingles Variety Bucket with Meal",299,1));
        cat.add(new itemsnam("Hot & Crispy-8pc",499,1));
        cat.add(new itemsnam("Fiery Grilled-8pc",499,1));
        cat.add(new itemsnam("Boneless Strips with 4 Dips-12pc",449,1));
        return cat;
    }
    public List Alacarte(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Extra Condiments",15,1));
        cat.add(new itemsnam("Hash Brown with dip-2pc",49,1));
        cat.add(new itemsnam("Hot & Crispy-1pc",75,1));
        cat.add(new itemsnam("Fiery Grilled-1pc",75,1));
        cat.add(new itemsnam("Add-on Fries & Pepsi",60,1));
        cat.add(new itemsnam("Regular Fries",50,1));
        cat.add(new itemsnam("Medium Fries",60,1));
        cat.add(new itemsnam("Large Fries",70,1));
        cat.add(new itemsnam("Regular Pepsi",45,1));
        cat.add(new itemsnam("Medium Pepsi",55,1));
        cat.add(new itemsnam("Large Pepsi",59,1));
        return cat;
    }
    public List boneless(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Popcorn Chicken Regular",59,1));
        cat.add(new itemsnam("Popcorn Chicken Medium",99,1));
        cat.add(new itemsnam("Popcorn Chicken Large",149,1));
        cat.add(new itemsnam("Boneless Strips-3pc",99,1));
        cat.add(new itemsnam("Boneless Strips-6pc",195,1));
        return cat;
    }
    public List ricebowlz(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Krispy Potato",85,1));
        cat.add(new itemsnam("Krispy Potato with Pepsi",85,1));
        cat.add(new itemsnam("Chicken Popcorn",95,1));
        cat.add(new itemsnam("Chicken Popcorn with Pepsi",125,1));
        cat.add(new itemsnam("Fiery Grilled",125,1));
        cat.add(new itemsnam("Fiery Grilled with Pepsi",155,1));
        return cat;
    }
    public List Burgers(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("O.M.G Burger",49,1));
        cat.add(new itemsnam("Potato Krisper",29,1));
        cat.add(new itemsnam("Potato Krisper with Meal",89,1));
        cat.add(new itemsnam("Chicken Snacker",40,1));
        cat.add(new itemsnam("Chicken Snacker with Meal",100,1));
        cat.add(new itemsnam("Cheezy Crunch",75,1));
        cat.add(new itemsnam("Cheezy Crunch with Meal",135,1));
        cat.add(new itemsnam("Chicken Rockin",79,1));
        cat.add(new itemsnam("Chicken Rockin with Meal",139,1));
        cat.add(new itemsnam("Paneer Zinger",109,1));
        cat.add(new itemsnam("Paneer Zinger with Meal",169,1));
        cat.add(new itemsnam("Chicken Zinger",119,1));
        cat.add(new itemsnam("Chicken Zinger with Meal",179,1));
        cat.add(new itemsnam("O.M.G Burger",49,1));
        return cat;
    }
    public List boxmeal(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Veg Crunch Box",185,1));
        cat.add(new itemsnam("Chicken Rock Box",209,1));
        return cat;
    }
    public List rollers(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("O.M.G Roller",59,1));
        cat.add(new itemsnam("Cheezy Crunch Wrap",69,1));
        return cat;
    }


public void offer(final Context c, final Button b, final RecyclerView rv) {

    this.c = c;
    this.b=b;
    this.rv=rv;

    cat = new ArrayList<itemsnam>();

    String url="http://www.thecityshoppers.com/offer.php";

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Log.v("Noti", response);
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    Type fooType = new TypeToken<ArrayList<gson>>() {
                    }.getType();
                    List<gson> post = gson.fromJson(response, fooType);
                    handlePostsList(post);
                    if(ofrinsts.size()==0||ofrinsts.isEmpty()){
                        Toast.makeText(c,"No Offers Today",Toast.LENGTH_LONG).show();
                    }else {
                        for (int i = 0; i < ofrinsts.size(); i++) {


                            Log.v("Noti", ofrinsts.get(i).getOfrname());
                            Log.v("Noti", ofrinsts.get(i).getOfrrate() + "");
                            cat.add(new itemsnam(ofrinsts.get(i).getOfrname(), ofrinsts.get(i).getOfrrate(), 1));

                        }
                        ItemAdapter adapter = new ItemAdapter(cat, c, b);
                        rv.setAdapter(adapter);
                    }

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
              Toast.makeText(c,"Check your Internet connection",Toast.LENGTH_SHORT).show();
            System.out.println("Something went wrong!");
            // Toast.makeText(, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            error.printStackTrace();

        }


    });

    int socketTimeout = 30000000;
    RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    stringRequest.setRetryPolicy(policy);
    AppController.getInstance().addToRequestQueue(stringRequest);



}

    private void handlePostsList(List<gson> posts) {

        this.gson = posts;
        ofrinsts = new ArrayList<>();
        for (gson g : this.gson)
        {
            ofrinst item=new ofrinst();
            item.setOfrname(g.offer_name);
            item.setOfrrate(Integer.parseInt(g.offer_rate));
            Log.d("Noti","Offer name"+g.offer_name);
            Log.d("Noti","Offer rate"+Integer.parseInt(g.offer_rate));

            ofrinsts.add(item);
         }

        }


  /*  public List krushers(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Krushers Lime Soda",29,1));
        cat.add(new itemsnam("Kold Koffee",49,1));
        cat.add(new itemsnam("Fruitzers Alphonso Mini",49,1));
        cat.add(new itemsnam("Fruitzers Alphonso Regular",95,1));
        cat.add(new itemsnam("Fruitzers Strawberry Mini",49,1));
        cat.add(new itemsnam("Fruitzers Strawberry Regular",95,1));
        cat.add(new itemsnam("Brownie Blast Mini",59,1));
        cat.add(new itemsnam("Brownie Blast Regular",109,1));
        cat.add(new itemsnam("Crunchy Choco Lash Mini",59,1));
        cat.add(new itemsnam("Crunchy Choco Lash Regular",99,1));
        cat.add(new itemsnam("Crunchy Chocopeanut Bolt Mini",59,1));
        cat.add(new itemsnam("Crunchy Chocopeanut Bolt Regular",99,1));
        cat.add(new itemsnam("Sparkling Virgin Mojito Regular",59,1));
        cat.add(new itemsnam("Sparkling Vanilla Blue Regular",59,1));
        return cat;
    }
    public List dessert(){
        cat = new ArrayList<itemsnam>();
        cat.add(new itemsnam("Soft Serve-1pc",16,1));
        cat.add(new itemsnam("Brownie Sundae",59,1));
        return cat;
    }*/

}
