package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Goods> goodsStock;
    private List<Cashier> cashierList;
    private List<CashDesk> storeCashDesk;
    private List<Receipt> receiptList;
    private List<Goods> soldGoods;
    private CashDesk cashDesk;
    private Provider provider = new Provider("John");
    private double TotalIncome = 0;




    public Store()  {
        goodsStock = new ArrayList<>();
        cashierList = new ArrayList<>();
        storeCashDesk = new ArrayList<>();
        soldGoods = new ArrayList<>();
        receiptList = new ArrayList<>();
    }

    //get the cashDesks
    public List<CashDesk> getStoreCashDesk() {
        return storeCashDesk;
    }

    //get the stocked goods
    public List<Goods> getGoodsStock() {
        return goodsStock;
    }

    //add cashier to our store
    public void HireCashier(Cashier cashier, Store store)
    {
        cashier.setStore(store);
        this.cashierList.add(cashier);
    }

    //get the receipt list


    public List<Receipt> getReceiptList() {
        return receiptList;
    }



    public void Buy(int ID, int amount)
    {

            goodsStock.add(provider.sellGood(ID));
        provider.getGood(ID).setQuantity(amount);
        System.out.println("Stocked { " + "Good ID : " + ID + " Amount : " + amount);
    }

    //increase the price of all good by certain value
    public void incrasePricesForProfit(double Value)
    {
        for(Goods good : goodsStock)
        {
            good.setPrice(good.getPrice() + Value);
        }
    }

    public void ShowStock()
    {
        System.out.println(goodsStock.toString());
    }

    public void checkProviderOfferings()
    {
        provider.showProvderGoods();
    }

    public boolean openAndAssignCashDesk(int cashierID, String cashDeskName)
    {
        for(Cashier cashier : cashierList)
        {
            if(cashierID == cashier.getID())
            {

                CashDesk myCashdesk = new CashDesk(cashier, cashDeskName);
                cashier.setMyCashDesk(myCashdesk);
                cashier.setAssigned(true);
                cashier.setCashDesk(cashDeskName);
               this.cashDesk = myCashdesk ;
            }
        }
        return true;
    }

    public void getIssuedReceiptsAmount()
    {
        System.out.println(" Total issued receipts at this moment : " + receiptList.size());
    }

    public void getTotalIncome()
    {
        if(!cashDesk.cashDeskThread.isAlive() ) {
            for (Receipt receipt : this.receiptList) {
                this.TotalIncome += receipt.TotalPrice();
            }
            System.out.println(Math.round(this.TotalIncome));
        }
    }

    public void getGoodsQuantity()
    {
        for(Goods good : goodsStock)
        {
            System.out.println(good.getName() + " : "+ good.getQuantity());
        }
    }
}
