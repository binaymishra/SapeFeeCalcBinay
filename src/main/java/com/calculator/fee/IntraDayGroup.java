package com.calculator.fee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IntraDayGroup {

    public String key = "";
    public List<Transaction> transaction = new ArrayList<>();
    public BigDecimal fee = BigDecimal.ZERO;

}
