package com.calculator.fee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CsvTransactionReaderTest {

    private CsvTransactionReader csvTransactionReader;

    @Before
    public void setUp() {
        csvTransactionReader = new CsvTransactionReader();
    }

    @Test
    public void testCreateCsvTransactionReader() {
        Assert.assertNotNull(csvTransactionReader);
    }

    @Test(expected = IOException.class)
    public void testFileNotFoundNullInput() throws IOException{
        csvTransactionReader.read(null);
    }

    @Test(expected = IOException.class)
    public void testFileNotFoundNullEmptyInput() throws IOException{
        csvTransactionReader.read("");
    }

    @Test
    public void readCsvFile() throws IOException {
        List<Transaction> transactions =  csvTransactionReader.read("Input Data.csv");
        Assert.assertNotNull(transactions);
        Assert.assertFalse(transactions.isEmpty());
        Assert.assertEquals(20, transactions.size());
    }
}
