package com.calculator.fee.reader;

import com.calculator.fee.model.Transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.endsWithIgnoreCase;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * @author Binay
 */
public class CsvTransactionReader implements TransactionReader {

    public List<Transaction> read(String file) throws IOException {
        if (endsWithIgnoreCase(file, ".csv")) {
            List<String> lines = Files.readAllLines(Paths.get(file));
            List<Transaction> transactions = new ArrayList<>(lines.size());
            for(int i = 1; i <lines.size(); i++) {
                String line = lines.get(i);
                String[] data = split(line, ",");
                Transaction transaction = new Transaction();
                transaction.setExternalTransactionId(data[0]);
                transaction.setClientId(data[1]);
                transaction.setSecurityId(data[2]);
                transaction.setTransactionType(data[3]);
                transaction.setTransactionDate(data[4]);
                transaction.setMarketValue(data[5]);
                transaction.setPriorityFlag(data[6]);
                transactions.add(transaction);
            }

            return transactions;
        }
        throw new FileNotFoundException("Invalid file = " + file);
    }
}
