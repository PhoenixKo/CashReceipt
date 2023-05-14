package com.company;

public class CashierNotAssignedADesk extends Exception {

    private String cashierName;

    public CashierNotAssignedADesk (String cashierName) {this.cashierName = cashierName;}

    @Override
    public String toString() {
        return cashierName + " has not been assigned a cashdesk !!!";
    }
}
