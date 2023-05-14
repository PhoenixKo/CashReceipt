package com.company;

public class Goods {
    private int ID;
    private String name;
    private double price;
    private String expiration;
    private double stock;
    private int Quantity;

    public Goods(int ID, String Name, double Price, String Expiration)
    {
        this.ID = ID;
        this.name = Name;
        this.price = Price;
        this.expiration = Expiration;
    }

    //getters
    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getExpiration() {
        return this.expiration;
    }

    public double getStock() {
        return stock;
    }

    public int getQuantity()
    {
        return this.Quantity;
    }


    //setters

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public void setQuantity(int quantity) { this.Quantity = quantity;}

    //Overrides
    @Override
    public String toString() {
        return "Goods{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expiration='" + expiration + '\'' +
                '}' + '\n';
    }
}
