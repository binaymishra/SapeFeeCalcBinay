package com.calculator.fee;

import java.io.IOException;
import java.util.List;

/**
 * @author Binay
 *
 * This is a Geneic interface. It can be implemented for reading various types of  files.
 *
 */
public interface TransactionReader {

    List<Transaction> read(String file) throws IOException;


}
