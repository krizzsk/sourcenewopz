package com.microblink.blinkbarcode.results.date;

import java.util.Calendar;
import java.util.Locale;

/* compiled from: line */
public final class DateUtils {
    public static boolean isDatePassed(Date date) {
        Date llIIlIlIIl = llIIlIlIIl();
        int[] iArr = {llIIlIlIIl.getYear(), llIIlIlIIl.getMonth(), llIIlIlIIl.getDay()};
        int[] iArr2 = {date.getYear(), date.getMonth(), date.getDay()};
        for (int i = 0; i < 3; i++) {
            int i2 = iArr[i];
            int i3 = iArr2[i];
            if (i3 < i2) {
                return true;
            }
            if (i3 > i2) {
                return false;
            }
        }
        return false;
    }

    private static Date llIIlIlIIl() {
        Calendar instance = Calendar.getInstance();
        return new Date(instance.get(5), instance.get(2) + 1, instance.get(1));
    }

    public static int yearsPassedFrom(Date date) {
        Date llIIlIlIIl = llIIlIlIIl();
        Locale locale = Locale.US;
        return (Integer.parseInt(String.format(locale, "%04d%02d%02d", new Object[]{Integer.valueOf(llIIlIlIIl.getYear()), Integer.valueOf(llIIlIlIIl.getMonth()), Integer.valueOf(llIIlIlIIl.getDay())})) - Integer.parseInt(String.format(locale, "%04d%02d%02d", new Object[]{Integer.valueOf(date.getYear()), Integer.valueOf(date.getMonth()), Integer.valueOf(date.getDay())}))) / 10000;
    }
}
