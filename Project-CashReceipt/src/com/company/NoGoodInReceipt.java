package com.company;

public class NoGoodInReceipt extends Exception{

    public NoGoodInReceipt () {}

    @Override
    public String toString() {
        return " No such good exist in receipt";
    }
}
