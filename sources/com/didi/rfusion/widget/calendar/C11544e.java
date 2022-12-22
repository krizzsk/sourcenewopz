package com.didi.rfusion.widget.calendar;

import android.icu.text.DateFormat;
import com.didi.rfusion.RFusion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.didi.rfusion.widget.calendar.e */
/* compiled from: UtcDates */
class C11544e {

    /* renamed from: a */
    static final String f33484a = "UTC";

    /* renamed from: b */
    static AtomicReference<C11543d> f33485b = new AtomicReference<>();

    /* renamed from: a */
    static void m23560a(C11543d dVar) {
        f33485b.set(dVar);
    }

    /* renamed from: a */
    static C11543d m23556a() {
        C11543d dVar = f33485b.get();
        return dVar == null ? C11543d.m23547a() : dVar;
    }

    private C11544e() {
    }

    /* renamed from: g */
    private static TimeZone m23575g() {
        return TimeZone.getTimeZone(f33484a);
    }

    /* renamed from: h */
    private static android.icu.util.TimeZone m23576h() {
        return android.icu.util.TimeZone.getTimeZone(f33484a);
    }

    /* renamed from: b */
    static Calendar m23564b() {
        Calendar b = m23556a().mo87688b();
        b.set(11, 0);
        b.set(12, 0);
        b.set(13, 0);
        b.set(14, 0);
        b.setTimeZone(m23575g());
        return b;
    }

    /* renamed from: c */
    static Calendar m23567c() {
        return m23559a((Calendar) null);
    }

    /* renamed from: a */
    static Calendar m23559a(Calendar calendar) {
        Calendar instance = Calendar.getInstance(m23575g());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    /* renamed from: b */
    static Calendar m23565b(Calendar calendar) {
        Calendar a = m23559a(calendar);
        Calendar c = m23567c();
        c.set(a.get(1), a.get(2), a.get(5));
        return c;
    }

    /* renamed from: a */
    static long m23553a(long j) {
        Calendar c = m23567c();
        c.setTimeInMillis(j);
        return m23565b(c).getTimeInMillis();
    }

    /* renamed from: a */
    private static DateFormat m23554a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(m23576h());
        return instanceForSkeleton;
    }

    /* renamed from: a */
    private static java.text.DateFormat m23557a(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(m23575g());
        return dateInstance;
    }

    /* renamed from: a */
    static SimpleDateFormat m23558a(String str) {
        return m23563b(str, RFusion.getLocale());
    }

    /* renamed from: b */
    private static SimpleDateFormat m23563b(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(m23575g());
        return simpleDateFormat;
    }

    /* renamed from: a */
    static DateFormat m23555a(Locale locale) {
        return m23554a("yMMMd", locale);
    }

    /* renamed from: b */
    static DateFormat m23561b(Locale locale) {
        return m23554a("MMMd", locale);
    }

    /* renamed from: c */
    static DateFormat m23566c(Locale locale) {
        return m23554a("MMMEd", locale);
    }

    /* renamed from: d */
    static DateFormat m23568d(Locale locale) {
        return m23554a("yMMMEd", locale);
    }

    /* renamed from: d */
    static java.text.DateFormat m23569d() {
        return m23571e(RFusion.getLocale());
    }

    /* renamed from: e */
    static java.text.DateFormat m23571e(Locale locale) {
        return m23557a(2, locale);
    }

    /* renamed from: e */
    static java.text.DateFormat m23570e() {
        return m23573f(RFusion.getLocale());
    }

    /* renamed from: f */
    static java.text.DateFormat m23573f(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) m23571e(locale);
        simpleDateFormat.applyPattern(m23562b(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    /* renamed from: f */
    static java.text.DateFormat m23572f() {
        return m23574g(RFusion.getLocale());
    }

    /* renamed from: g */
    static java.text.DateFormat m23574g(Locale locale) {
        return m23557a(0, locale);
    }

    /* renamed from: b */
    private static String m23562b(String str) {
        int a = m23552a(str, "yY", 1, 0);
        if (a >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int a2 = m23552a(str, str2, 1, a);
        if (a2 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(m23552a(str, str2, -1, a) + 1, a2), " ").trim();
    }

    /* renamed from: a */
    private static int m23552a(String str, String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                do {
                    i2 += i;
                    if (i2 < 0) {
                        break;
                    } else if (i2 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i2) == '\'');
            }
            i2 += i;
        }
        return i2;
    }
}
