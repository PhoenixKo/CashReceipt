package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cashier {
    private int ID;
    private String Name;
    private String cashDesk;
    private Store store;
    private boolean isAssigned = false;
    private CashDesk myCashDesk;
    private List<Goods> goodsForReceipt;
    public Cashier(int ID, String Name)
    {
        this.ID = ID;
        this.Name = Name;
        this.goodsForReceipt = new ArrayList<>();
    }

    //getters
    public int getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public String getCashDesk() {
        return cashDesk;
    }

    public List<Goods> getGoodsForReceipt() {
        return goodsForReceipt;
    }

    public Store getStore() {
        return store;
    }


    //setters


    public void setStore(Store store) {
        this.store = store;
    }

    public void setMyCashDesk(CashDesk myCashDesk) {
        this.myCashDesk = myCashDesk;
    }



    public void setCashDesk(String cashDesk) {
        this.cashDesk = cashDesk;
    }

    public void useCashDesk()
    {

        if(isAssigned == true) myCashDesk.start();

    }

//    public void createReceipt()
//    {
//        this.receipt = new Receipt();
//    }



    public synchronized void addToReceipt(int ID, int amount) throws CashierNotAssignedADesk
    {
        if(isAssigned == true) {
            for (Goods myGood : store.getGoodsStock()) {

                if (ID == myGood.getID() && myGood.getQuantity() >= amount) {
                    for (int i = 0; i < amount; i++) {
                        goodsForReceipt.add(myGood);
                        //System.out.println(myGood.getQuantity() - amount);
                    }
                    myGood.setQuantity(myGood.getQuantity() - amount);
                }
//                else {
//                    throw new NotEnoughStockException(myGood.getQuantity(), myGood, amount);
//                }
            }
        } else {
            throw new CashierNotAssignedADesk(Name);
        }
    }

    public void removeFromReceipt(int ID) throws NoGoodInReceipt{
        for( Goods myGood : goodsForReceipt)
        {
            if(myGood.getID() == ID)
            {
                this.goodsForReceipt.remove(myGood);
            }
            else {
                throw new NoGoodInReceipt();
            }
        }
    }
}
