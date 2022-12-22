package com.microblink.blinkbarcode.results.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* compiled from: line */
public class Date {
    private int IlIllIlIIl;
    private int IllIIIllII;
    private int llIIlIlIIl;

    public Date(int i, int i2, int i3) {
        this.llIIlIlIIl = i;
        this.IlIllIlIIl = i2;
        this.IllIIIllII = i3;
    }

    public static Date parseFromString(String str, String str2) {
        java.util.Date date;
        try {
            date = new SimpleDateFormat(str2, Locale.US).parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        if (date == null) {
            return null;
        }
        Calendar instance = GregorianCalendar.getInstance();
        instance.setTime(date);
        return new Date(instance.get(5), instance.get(2) + 1, instance.get(1));
    }

    public int getDay() {
        return this.llIIlIlIIl;
    }

    public int getMonth() {
        return this.IlIllIlIIl;
    }

    public int getYear() {
        return this.IllIIIllII;
    }

    public String toString() {
        return String.format(Locale.US, "%02d.%02d.%d.", new Object[]{Integer.valueOf(this.llIIlIlIIl), Integer.valueOf(this.IlIllIlIIl), Integer.valueOf(this.IllIIIllII)});
    }
}
