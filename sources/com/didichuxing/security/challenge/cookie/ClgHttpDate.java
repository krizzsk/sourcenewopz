package com.didichuxing.security.challenge.cookie;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ClgHttpDate {
    public static final long MAX_DATE = 253402300799999L;
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");

    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f48979a = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(ClgHttpDate.UTC);
            return simpleDateFormat;
        }
    };

    /* renamed from: b */
    private static final String[] f48980b;

    /* renamed from: c */
    private static final DateFormat[] f48981c;

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f48980b = strArr;
        f48981c = new DateFormat[strArr.length];
    }

    public static Date parse(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f48979a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f48980b) {
            int length = f48980b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = f48981c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f48980b[i], Locale.US);
                    dateFormat.setTimeZone(UTC);
                    f48981c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    public static String format(Date date) {
        return f48979a.get().format(date);
    }

    private ClgHttpDate() {
    }
}
