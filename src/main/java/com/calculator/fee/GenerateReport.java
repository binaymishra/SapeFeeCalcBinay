package com.calculator.fee;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class GenerateReport {

    private FeeCalculator feeCalculator;

    public GenerateReport(FeeCalculator feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public String generateReport(List<Transaction> transactions) {
        List<Transaction> report = feeCalculator.calculateFee(transactions);
        StringBuilder sb = new StringBuilder();
        String header = StringUtils.joinWith(",",
                "Client Id",
                "Transaction Type",
                "Transaction Date",
                "Priority",
                "Processing Fee", "\n");
        sb.append(header);
        for (Transaction transaction : report) {
            String data = StringUtils.joinWith(",",
                    transaction.getClientId(),
                    transaction.getTransactionType(),
                    transaction.getTransactionDate(),
                    transaction.getPriorityFlag(),
                    transaction.getFee(), "\n");
            sb.append(data);
        }
        return sb.toString();
    }
}
