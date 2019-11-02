package com.calculator.fee;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateReportTest {

    private GenerateReport generateReport;


    @Before
    public void setUp() {
        generateReport = new GenerateReport(new FeeCalculatorImpl());
    }

    @Test
    public void createGenerateReport() {
        Assert.assertNotNull(generateReport);
    }

    @Test
    public void generateReport(){
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

        String csv = generateReport.generateReport(transactions);

        Assert.assertFalse(StringUtils.isBlank(csv));;

    }
}
