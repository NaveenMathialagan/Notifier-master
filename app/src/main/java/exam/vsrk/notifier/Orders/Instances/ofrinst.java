package exam.vsrk.notifier.Orders.Instances;

/**
 * Created by Naveen kumar on 03-03-2016.
 */
public class ofrinst {
   public String ofrname;
    public int ofrrate;

    public ofrinst(){


    }
    public ofrinst(String ofrname, int ofrrate){
       this.ofrname=ofrname;
        this.ofrrate=ofrrate;

    }

    public String getOfrname(){

        return this.ofrname;
    }

    public void setOfrname(String ofrname){

        this.ofrname = ofrname;
    }

    // getting name
    public int getOfrrate(){

        return this.ofrrate;
    }

    // setting name
    public void setOfrrate(int ofrrate){

        this.ofrrate = ofrrate;
    }

}
