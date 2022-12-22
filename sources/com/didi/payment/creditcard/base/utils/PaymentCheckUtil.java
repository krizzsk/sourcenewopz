package com.didi.payment.creditcard.base.utils;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import java.util.Calendar;

public class PaymentCheckUtil {

    /* renamed from: a */
    private static final String[] f30296a = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    public static boolean checkLength(String str, int i, int i2) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        String replaceAllSpace = PaymentTextUtil.replaceAllSpace(str);
        if (replaceAllSpace.length() < i || replaceAllSpace.length() > i2) {
            return false;
        }
        return true;
    }

    public static boolean checkLuhn(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        String replaceAll = str.replaceAll(" ", "");
        int i = 0;
        boolean z = false;
        for (int length = replaceAll.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(replaceAll.substring(length, length + 1));
            if (z && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i += parseInt;
            z = !z;
        }
        if (i % 10 == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replaceAll = str.replaceAll("/", "");
        if (replaceAll.length() == 4) {
            String str2 = 20 + replaceAll.substring(2, 4);
            String substring = replaceAll.substring(0, 2);
            if (!m21262a(substring) || !m21263a(str2, substring)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m21262a(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        for (String equals : f30296a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m21263a(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2) + 1;
        int parseInt = Integer.parseInt(str);
        int parseInt2 = Integer.parseInt(str2);
        if (parseInt > i || (parseInt == i && parseInt2 >= i2)) {
            return true;
        }
        return false;
    }
}
