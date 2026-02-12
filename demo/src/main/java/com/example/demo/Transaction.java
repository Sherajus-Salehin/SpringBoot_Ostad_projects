package com.example.demo;

public class Transaction {
    private String id;
    private double amount;
    private String type;

    public Transaction(String id, double amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }
}
