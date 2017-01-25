package exam.vsrk.notifier.Orders.Instances;

/**
 * Created by VSRK on 1/12/2016.
 */
import java.util.ArrayList;
import java.util.List;

import exam.vsrk.notifier.R;

/**
 * Created by Naveen kumar on 10-01-2016.
 */
public class catagory {
    public String name;
    public int photoId;

    public catagory(){

    }
    catagory(String name, int photoId) {
        this.name = name;

        this.photoId = photoId;
    }


    private List<catagory> cat;

    // This method creates an ArrayLis
    // t that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    public List initializeData(){
        cat = new ArrayList<catagory>();
        cat.add(new catagory("Offers today",  R.drawable.kfc));
        cat.add(new catagory("Chicken",  R.drawable.kfc));
        cat.add(new catagory("Bucket", R.drawable.kfc));
        cat.add(new catagory("BoneLess", R.drawable.kfc));
        cat.add(new catagory("Rollers", R.drawable.kfc));
        cat.add(new catagory("Rice Bowlz", R.drawable.kfc));
        cat.add(new catagory("Burgers", R.drawable.kfc));
        cat.add(new catagory("Box Meal", R.drawable.kfc));
        cat.add(new catagory("A la carte", R.drawable.kfc));
//        cat.add(new catagory("Krushers", R.drawable.kfc));
  //      cat.add(new catagory("Dessert", R.drawable.kfc));

        return cat;
    }
}