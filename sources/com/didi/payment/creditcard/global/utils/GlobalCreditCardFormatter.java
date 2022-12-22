package com.didi.payment.creditcard.global.utils;

public class GlobalCreditCardFormatter {
    public static String formatCreditCardNumber(String str) {
        return str.replaceAll("\\d{4}", "$0 ").replaceFirst("\\d{4}", "$0 ").replaceFirst("\\d{6}", "$0 ");
    }

    public static String formatCreditCardNumberInBrief(String str) {
        if (str == null || str.length() < 10) {
            return "";
        }
        return str.substring(0, 6).concat(str.substring(str.length() - 4));
    }

    public static String formatExpireDate(String str) {
        return str.replaceAll("\\d{2}", "$0/");
    }

    public static String removeSymbols(String str) {
        return str.replaceAll("[^\\w\\s]", "");
    }
}
