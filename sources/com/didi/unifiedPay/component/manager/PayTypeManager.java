package com.didi.unifiedPay.component.manager;

public class PayTypeManager {
    public static boolean isPlatformPayType(int i) {
        return i == 108 || i == 115 || i == 118 || i == 121 || i == 123 || i == 126 || i == 161;
    }
}
