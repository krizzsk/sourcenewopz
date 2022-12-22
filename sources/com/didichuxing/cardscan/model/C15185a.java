package com.didichuxing.cardscan.model;

import java.util.Calendar;

/* renamed from: com.didichuxing.cardscan.model.a */
public class C15185a {
    /* renamed from: a */
    public static String m33173a(String str) {
        return m33174a(str, true, (CardType) null);
    }

    /* renamed from: a */
    public static String m33174a(String str, boolean z, CardType cardType) {
        String d = z ? m33178d(str) : str;
        if (cardType == null) {
            cardType = CardType.fromCardNumber(d);
        }
        int numberLength = cardType.numberLength();
        return d.length() == numberLength ? numberLength == 16 ? m33177c(d) : numberLength == 15 ? m33176b(d) : str : str;
    }

    /* renamed from: a */
    public static boolean m33175a(int i, int i2) {
        if (i < 1 || 12 < i) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        int i3 = instance.get(1);
        int i4 = instance.get(2) + 1;
        if (i2 < i3) {
            return false;
        }
        return (i2 != i3 || i >= i4) && i2 <= i3 + 15;
    }

    /* renamed from: b */
    private static String m33176b(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            if (i == 4 || i == 10) {
                sb.append(' ');
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /* renamed from: c */
    private static String m33177c(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append(' ');
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /* renamed from: d */
    private static String m33178d(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
