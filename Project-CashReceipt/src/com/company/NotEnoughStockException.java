package com.company;

public class NotEnoughStockException extends Exception {

    private double quantity;
    private Goods goods;
    public int amount;

    public NotEnoughStockException() {}

    public NotEnoughStockException(double Quantity, Goods good, int amount)
    {
        this.quantity = Quantity;
        this.goods = good;
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "NotEnoughStockException : " + goods.toString() + " does not have enough stock. Current stock : " + goods.getQuantity() +
                " You are trying to buy(amount) : " + this.amount ;
    }
}
