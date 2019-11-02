package com.calculator.fee;

import java.util.List;

/**
 * @author Binay
 *
 * This inteface will implemented of verious type for fee calculation logic
 */
public interface FeeCalculator {

    List<Transaction> calculateFee(List<Transaction> transactions);
}
