package com.calculator.fee.model;

public class IntraTransactions {

    private Transaction buy;
    private Transaction sell;

    public IntraTransactions(Transaction buy, Transaction sell) {
        this.buy = buy;
        this.sell = sell;
    }


}
