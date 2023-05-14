package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        List<Goods> goods = new ArrayList<>();
//        List<Cashier> cashiers = new ArrayList<>();
//
//	    Goods apple = new Goods(5,"apple",5,"10/25");
//	    Goods fanta = new Goods(532, "fanta", 10,"5/25");
//
//	    Cashier cashier1 = new Cashier(112,"John", "cashdesk1");
//        Cashier cashier2 = new Cashier(123,"Pavel", "cashdesk2");
//
//        goods.add(apple);
//        goods.add(fanta);
//        cashiers.add(cashier1);
//        cashiers.add(cashier2);
//        Store store = new Store(goods, cashiers);
//
//            cashier1.addToReceipt(apple);
//            cashier1.addToReceipt(apple);
//            cashier1.addToReceipt(fanta);
//            cashier1.addToReceipt(apple);
//            cashier1.useCashDesk();
//
//            cashier2.addToReceipt(apple);
//            cashier2.addToReceipt(fanta);
//            cashier2.addToReceipt(fanta);
//            cashier2.addToReceipt(apple);
//            cashier2.useCashDesk();



        //create Store object.
        Store myStore = new Store();
        //create Cashier objects
        Cashier cashier1 = new Cashier(1832,"Pavel");
        Cashier cashier2 = new Cashier(3801,"Petra");
        //check what hte provider offers
        myStore.checkProviderOfferings();
//        //stock up
        myStore.Buy(561, 10);
        myStore.Buy(12, 51);
        myStore.Buy(3012, 100);
//        //hire cashier
        myStore.HireCashier(cashier1, myStore);
        myStore.HireCashier(cashier2, myStore);
//        //show what is in stock in your shop
       myStore.ShowStock();
       myStore.getGoodsQuantity();
//
//        //cashier checks in items
        myStore.openAndAssignCashDesk(1832, "cashdesk1");
        myStore.openAndAssignCashDesk(3801, "cashdesk2");
////        for(Goods good : myStore.getGoodsStock())
////        {
////            System.out.println(good.getQuantity());
////        }
//
//        //add to receipt
        try {

            cashier1.addToReceipt(561, 1);
            cashier1.addToReceipt(3012,1);
            cashier1.addToReceipt(12,2);
            cashier1.addToReceipt(12,10);
            cashier2.addToReceipt(3012,2);
            cashier2.addToReceipt(561, 3);
            cashier2.addToReceipt(12, 2);
            cashier2.addToReceipt(3012, 3);
            myStore.getGoodsQuantity();
        }  catch (CashierNotAssignedADesk ex)
        {
            System.out.println(ex);
        }
//        catch(NotEnoughStockException e){
//            System.out.println(e);
//        }
//
//
        //use cash desks
          cashier1.useCashDesk();

          cashier2.useCashDesk();
//
//          //get total income for store
//          myStore.getTotalIncome();

    }
}
