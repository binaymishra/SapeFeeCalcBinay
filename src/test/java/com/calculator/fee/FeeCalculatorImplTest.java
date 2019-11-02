package com.calculator.fee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class FeeCalculatorImplTest {

    final static Logger LOGGER = LoggerFactory.getLogger(FeeCalculatorImplTest.class);

    private FeeCalculator feeCalculator;

    @Before
    public void setUp() {
        feeCalculator = new FeeCalculatorImpl();
    }


    @Test
    public void feeCalculator() {
        Assert.assertNotNull(feeCalculator);
    }

    @Test
    public void calculateFeeFor_Intraday_transactions() {

        List<Transaction> transactions = new ArrayList<>();

        Transaction transactionBuy  = new Transaction();
        transactionBuy.setClientId("GS");
        transactionBuy.setSecurityId("ICICI");
        transactionBuy.setTransactionDate("23-11-13");
        transactionBuy.setTransactionType("BUY");

        Transaction transactionSell = new Transaction();
        transactionSell.setClientId("GS");
        transactionSell.setSecurityId("ICICI");
        transactionSell.setTransactionDate("23-11-13");
        transactionSell.setTransactionType("SELL");


        transactions.add(transactionBuy);
        transactions.add(transactionSell);

        List<Transaction> report = feeCalculator.calculateFee(transactions);

        Assert.assertEquals(BigDecimal.valueOf(5.0), report.get(0).getFee());
        Assert.assertEquals(BigDecimal.valueOf(5.0), report.get(1).getFee());

    }

    @Test
    public void calculateFeeFor_high_priority_transactions() {

        List<Transaction> transactions = new ArrayList<>();

        //SAPEXTXN1,GS,ICICI,BUY,23-11-13,101.9,Y

        Transaction transaction;

        transaction = new Transaction();
        transaction.setExternalTransactionId("SAPEXTXN1");
        transaction.setClientId("GS");
        transaction.setSecurityId("ICICI");
        transaction.setTransactionType("BUY");
        transaction.setTransactionDate("23-11-13");
        transaction.setMarketValue("101.9");
        transaction.setPriorityFlag("Y");

        transactions.add(transaction);

        transaction = new Transaction();
        transaction.setExternalTransactionId("SAPEXTXN1");
        transaction.setClientId("JP");
        transaction.setSecurityId("ICICP");
        transaction.setTransactionType("BUY");
        transaction.setTransactionDate("23-11-13");
        transaction.setMarketValue("101.9");
        transaction.setPriorityFlag("Y");

        transactions.add(transaction);

        List<Transaction> report = feeCalculator.calculateFee(transactions);

        Assert.assertEquals(BigDecimal.valueOf(500.0), report.get(0).getFee());
        Assert.assertEquals(BigDecimal.valueOf(500.0), report.get(1).getFee());

    }

    @Test
    public void calculateFeeFor_normal_priority_transactions_Sell_or_Withdraw() {

        List<Transaction> transactions = new ArrayList<>();

        //SAPEXTXN1,GS,ICICI,BUY,23-11-13,101.9,Y

        Transaction transaction;

        transaction = new Transaction();
        transaction.setExternalTransactionId("SAPEXTXN1");
        transaction.setClientId("GS");
        transaction.setSecurityId("ICICI");
        transaction.setTransactionType("Withdraw");
        transaction.setTransactionDate("23-11-13");
        transaction.setMarketValue("101.9");
        transaction.setPriorityFlag("N");

        transactions.add(transaction);

        transaction = new Transaction();
        transaction.setExternalTransactionId("SAPEXTXN1");
        transaction.setClientId("JP");
        transaction.setSecurityId("ICICP");
        transaction.setTransactionType("SELL");
        transaction.setTransactionDate("23-11-13");
        transaction.setMarketValue("101.9");
        transaction.setPriorityFlag("N");

        transactions.add(transaction);

        List<Transaction> report = feeCalculator.calculateFee(transactions);

        Assert.assertEquals(BigDecimal.valueOf(100.0), report.get(0).getFee());
        Assert.assertEquals(BigDecimal.valueOf(100.0), report.get(1).getFee());

    }

    @Test
    public void calculateFeeFor_normal_priority_transactions_Buy_or_Deposit() {

        List<Transaction> transactions = new ArrayList<>();

        //SAPEXTXN1,GS,ICICI,BUY,23-11-13,101.9,Y

        Transaction transaction;

        transaction = new Transaction();
        transaction.setExternalTransactionId("SAPEXTXN1");
        transaction.setClientId("GS");
        transaction.setSecurityId("ICICI");
        transaction.setTransactionType("Deposit");
        transaction.setTransactionDate("23-11-13");
        transaction.setMarketValue("101.9");
        transaction.setPriorityFlag("N");

        transactions.add(transaction);

        transaction = new Transaction();
        transaction.setExternalTransactionId("SAPEXTXN1");
        transaction.setClientId("JP");
        transaction.setSecurityId("ICICP");
        transaction.setTransactionType("Buy");
        transaction.setTransactionDate("23-11-13");
        transaction.setMarketValue("101.9");
        transaction.setPriorityFlag("N");

        transactions.add(transaction);

        List<Transaction> report = feeCalculator.calculateFee(transactions);

        Assert.assertEquals(BigDecimal.valueOf(50.0), report.get(0).getFee());
        Assert.assertEquals(BigDecimal.valueOf(50.0), report.get(1).getFee());

        LOGGER.trace(report.get(0).toString());

    }
}
