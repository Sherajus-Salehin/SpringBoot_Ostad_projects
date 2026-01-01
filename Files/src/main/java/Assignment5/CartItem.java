package Assignment5;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CartItem {
    Random r=new Random();
    int id=r.nextInt(10);
    private final int productId= id;
    private int quantity;
    private double unitPrice;
    private boolean addedToCArt;
    private String name;

    public CartItem( String name,double unitPrice, int quantity, boolean addedToCArt){
        this.name=name;
        this.unitPrice=unitPrice;
        this.quantity=quantity;
        this.addedToCArt=addedToCArt;
    }

    boolean addOrRemove(){
        if(addedToCArt){
            addedToCArt=false;
            quantity=0;
            return false;

        }else {
            addedToCArt=true;
            quantity=1;
            return true;

        }
    }
    double totalPayable(){
        return (quantity*unitPrice);
    }

    void incrementQuantity(){
        quantity++;
    }
    void decrementQuantity(){
        int tempCalculation=quantity-1;
        if(tempCalculation<1) System.err.println("Added item's quantity cannot be less than 1");
        else {
            quantity=tempCalculation;
        }
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public boolean isAddedToCArt() {
        return addedToCArt;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setAddedToCArt(boolean addedToCArt) {
        this.addedToCArt = addedToCArt;
    }

    public void setName(String name) {
        this.name = name;
    }
}
