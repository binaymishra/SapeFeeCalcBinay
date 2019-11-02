package com.calculator.fee;

import java.util.List;

/**
 *
 */
public interface FeeCalculator {

    List<Transaction> calculateFee(List<Transaction> transactions);
}
