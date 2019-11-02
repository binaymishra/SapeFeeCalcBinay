package com.calculator.fee;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class FeeCalculatorImpl implements FeeCalculator{

    @Override
    public List<Transaction> calculateFee(List<Transaction> transactions) {

        List<Transaction> report = new ArrayList<>();

        //2.1 Intraday transactions
       Map<String, IntraDayGroup> groupMap = new HashMap<>();

        for (Transaction transaction : transactions) {

            String key = StringUtils.joinWith("_",
                    transaction.getClientId(),
                    transaction.getSecurityId(),
                    transaction.getTransactionDate());

            IntraDayGroup intraDayGroup = groupMap.get(key);

            if(null == intraDayGroup) {
                intraDayGroup = new IntraDayGroup();
                intraDayGroup.key = key;
                groupMap.put(key, intraDayGroup);
            }

            intraDayGroup.transaction.add(transaction);
        }

        for (IntraDayGroup intraDayGroup : groupMap.values()) {

            if (intraDayGroup.transaction.size() == 2) {

                intraDayGroup.fee.add(BigDecimal.valueOf(10.0));
                BigDecimal temp_fee0 = intraDayGroup.transaction.get(0).getFee();
                BigDecimal temp_fee1 = intraDayGroup.transaction.get(1).getFee();

                intraDayGroup.transaction.get(0).setFee(temp_fee0.add(BigDecimal.valueOf(5.0)));
                intraDayGroup.transaction.get(1).setFee(temp_fee1.add(BigDecimal.valueOf(5.0)));

                transactions.remove(intraDayGroup.transaction.get(0)); // Intra-day transactions are removed from main list
                transactions.remove(intraDayGroup.transaction.get(1)); // Intra-day transactions are removed from main list

                report.add(intraDayGroup.transaction.get(0));
                report.add(intraDayGroup.transaction.get(1));
            }
        }

       // 2.2 Normal transactions
        for (Transaction transaction : transactions) {
           if("Y".equalsIgnoreCase(transaction.getPriorityFlag())) {
               BigDecimal temp = transaction.getFee();
               transaction.setFee(temp.add(BigDecimal.valueOf(500.0)));
               report.add(transaction);
           } else if ("N".equalsIgnoreCase(transaction.getPriorityFlag())){
               if ("sell".equalsIgnoreCase(transaction.getTransactionType())
                       || "withdraw".equalsIgnoreCase(transaction.getTransactionType())) {
                   BigDecimal temp = transaction.getFee();
                   transaction.setFee(temp.add(BigDecimal.valueOf(100.0)));
                   report.add(transaction);
               } else if("buy".equalsIgnoreCase(transaction.getTransactionType())
                       || "deposit".equalsIgnoreCase(transaction.getTransactionType())) {
                   BigDecimal temp = transaction.getFee();
                   transaction.setFee(temp.add(BigDecimal.valueOf(50.0)));
                   report.add(transaction);
               }
           }
            report.add(transaction); // Unprocessed
        }

        return report;

    }
}
