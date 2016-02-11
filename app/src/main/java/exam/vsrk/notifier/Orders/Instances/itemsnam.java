package exam.vsrk.notifier.Orders.Instances;

/**
 * Created by VSRK on 1/12/2016.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naveen kumar on 10-01-2016.
 */
public class itemsnam {
   public String iname;
  public int rs;
   public int qty;
    public itemsnam(){


    }
    public itemsnam(String iname,int rs,int qty){
        this.iname=iname;
        this.rs=rs;
        this.qty=qty;
    }
    private List<itemsnam> cat=null;


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
