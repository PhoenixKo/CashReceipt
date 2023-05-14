package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CashDesk implements Runnable {
    private  List<Cashier> cashDeskCashier;
    private  List<Receipt> receiptList;
    private List<Goods> goodsList;
    private  Cashier cashier;
    private  String threadName;
    private  Receipt receipt;
    private Store store;
    Thread cashDeskThread;






    public CashDesk(Cashier cashier, String threadName)
    {
        this.threadName = threadName;
        this.cashier = cashier;
        goodsList = new ArrayList<>();
        //goodsList = goods; , List<Goods> goods
        cashDeskCashier = new ArrayList<>();
        this.cashier = cashier;
        cashDeskCashier.add(this.cashier);
        receiptList = new ArrayList<>();


    }


    public String getThreadName() {
        return threadName;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void CreateReceipt()
    {
        Receipt receipt = new Receipt(this.cashier);
        this.receipt = receipt;
        receiptList.add(receipt);
        receipt.setReceiptGoods(cashier.getGoodsForReceipt());
        cashier.getStore().getReceiptList().add(receipt);

    }

    public void run()
    {
        try {
            System.out.println(cashier.getName() + " started working on " + this.threadName);


                    CreateReceipt();

                    List<String> lines = Arrays.asList(receipt.toString() + System.lineSeparator());
                    Path file = Paths.get("Receipt " + receipt.getID() + " " + receipt.myDate.format(receipt.dateNow) + ".txt");
                    Files.write(file, lines, Charset.forName("UTF-8"));
 
                System.out.println(cashier.getName() + " finished working on " + this.threadName);
                cashier.getStore().getIssuedReceiptsAmount();


        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void start()
    {
        System.out.println("Starting " + threadName + " used by " + cashier.getName());

        if(cashDeskThread  == null)
        {
            cashDeskThread = new Thread(this, threadName);
            cashDeskThread.start();
        }
    }
}
