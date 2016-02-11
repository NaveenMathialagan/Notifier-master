package exam.vsrk.notifier.Orders.Instances;

/**
 * Created by VSRK on 1/13/2016.
 */
public class Orders {

    private String quantity,price,item;

    public Orders(String item_name, String price, String quantity) {
        this.item=item_name;
        this.price=price;
        this.quantity=quantity;
    }

    public Orders() {

    }

    public String getItem() {
        return item;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
