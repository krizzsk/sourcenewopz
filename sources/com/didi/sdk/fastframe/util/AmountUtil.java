package com.didi.sdk.fastframe.util;

import java.math.BigDecimal;

public class AmountUtil {
    public static String fenToYuan(long j) {
        if (j <= 0) {
            return "0";
        }
        BigDecimal divide = new BigDecimal(j).divide(new BigDecimal("100"), 2, 4);
        if (j % 100 == 0) {
            return divide.setScale(0, 1).toString();
        }
        if (j % 10 == 0) {
            return divide.setScale(1, 1).toString();
        }
        return divide.toString();
    }

    public static String getDiscountInteger(int i) {
        return new BigDecimal(String.valueOf(i)).divide(new BigDecimal("10"), 0, 1).toString();
    }

    public static String getDiscountDecimal(int i) {
        return new BigDecimal(String.valueOf(i)).divide(new BigDecimal("10"), 1, 1).remainder(new BigDecimal("1")).multiply(new BigDecimal("10")).setScale(0, 1).toString();
    }
}
