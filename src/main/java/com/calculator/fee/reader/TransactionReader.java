package com.calculator.fee.reader;

import com.calculator.fee.model.Transaction;

import java.io.IOException;
import java.util.List;


public interface TransactionReader {

    List<Transaction> read(String file) throws IOException;


}
