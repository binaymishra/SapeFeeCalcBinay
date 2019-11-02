package com.calculator.fee;

import java.io.IOException;
import java.util.List;


public interface TransactionReader {

    List<Transaction> read(String file) throws IOException;


}
