package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Receipt {
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final AtomicInteger receiptCount = new AtomicInteger(0);
    private int ID;
    private List<Cashier> cashierToReceipt;
    private List<Goods> receiptGoods;
    private Store store;
    private double totalReceiptValue = 0;
    private double totalReceiptAmount = 0;
    private Cashier cashier;
    Date dateNow = new Date();
    SimpleDateFormat myDate = new SimpleDateFormat("E yyyy.MM.dd 'at' hh-mm-ss a zzz");


    public Receipt() {};

    public Receipt(Cashier cashier)
        {

            cashierToReceipt = new ArrayList<>();
            this.cashier = cashier;
            cashierToReceipt.add(cashier);
            receiptGoods = new ArrayList<>();
            this.ID = count.incrementAndGet();
            this.totalReceiptAmount = receiptCount.incrementAndGet();
            myDate.format(dateNow);


        }

        public double TotalPrice()
        {
            for(Goods good : receiptGoods)
            {
                totalReceiptValue += good.getPrice();
            }
            return Math.round(totalReceiptValue);

        }



    public void setReceiptGoods(List<Goods> receiptGoods) {
        this.receiptGoods = receiptGoods;
    }


    public List<Goods> getReceiptGoods() {
        return receiptGoods;
    }

    public int getID() {
        return ID;
    }



    @Override
    public String toString() {
        return "Receipt{ID - " + this.ID + System.lineSeparator() + "Created -" + myDate.format(dateNow) + " Created by - " + this.cashier.getName() +
                System.lineSeparator() + receiptGoods.toString() + '\n' +" RECEIPT TOTAL PRICE - " + TotalPrice() ;
    }
}
