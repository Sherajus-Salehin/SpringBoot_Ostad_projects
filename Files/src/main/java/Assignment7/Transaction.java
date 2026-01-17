package Assignment7;

public class Transaction {
    private final String id;
    private String type;
    private double amount;
    private String description;
    private String date;
    public Transaction(String id, double amount, String type, String description, String date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.date = date;
    }
    public Transaction() {
        id="0";
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
    public String toString(){
        return id+"\t"+type+"\t"+amount+"\t"+description+"\t"+date;
    }


}
