package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.icu.text.DateIntervalFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.text.format.DateFormat;
import androidx.core.util.Pair;
import com.didi.rfusion.RFusion;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.didi.rfusion.widget.calendar.a */
/* compiled from: DateStrings */
class C11540a {

    /* renamed from: a */
    private static final String f33469a = "yMMMM";

    private C11540a() {
    }

    /* renamed from: a */
    static String m23523a(Context context, long j) {
        if (Build.VERSION.SDK_INT >= 24) {
            DateIntervalFormat instance = DateIntervalFormat.getInstance(f33469a, RFusion.getLocale());
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j);
            return instance.format(instance2, instance2, new StringBuffer(), new FieldPosition(0)).toString();
        } else if (Build.VERSION.SDK_INT >= 18) {
            return new SimpleDateFormat(DateFormat.getBestDateTimePattern(RFusion.getLocale(), f33469a), RFusion.getLocale()).format(new Date(j));
        } else {
            return DateFormat.getDateFormat(context).format(new Date(j));
        }
    }

    /* renamed from: a */
    static String m23520a(long j) {
        return m23522a(j, RFusion.getLocale());
    }

    /* renamed from: a */
    static String m23522a(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C11544e.m23555a(locale).format(new Date(j));
        }
        return C11544e.m23571e(locale).format(new Date(j));
    }

    /* renamed from: b */
    static String m23524b(long j) {
        return m23525b(j, RFusion.getLocale());
    }

    /* renamed from: b */
    static String m23525b(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C11544e.m23561b(locale).format(new Date(j));
        }
        return C11544e.m23573f(locale).format(new Date(j));
    }

    /* renamed from: c */
    static String m23526c(long j) {
        return m23527c(j, RFusion.getLocale());
    }

    /* renamed from: c */
    static String m23527c(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C11544e.m23566c(locale).format(new Date(j));
        }
        return C11544e.m23574g(locale).format(new Date(j));
    }

    /* renamed from: d */
    static String m23528d(long j) {
        return m23529d(j, RFusion.getLocale());
    }

    /* renamed from: d */
    static String m23529d(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C11544e.m23568d(locale).format(new Date(j));
        }
        return C11544e.m23574g(locale).format(new Date(j));
    }

    /* renamed from: e */
    static String m23530e(long j) {
        return m23521a(j, (SimpleDateFormat) null);
    }

    /* renamed from: a */
    static String m23521a(long j, SimpleDateFormat simpleDateFormat) {
        java.util.Calendar b = C11544e.m23564b();
        java.util.Calendar c = C11544e.m23567c();
        c.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (b.get(1) == c.get(1)) {
            return m23524b(j);
        }
        return m23520a(j);
    }

    /* renamed from: a */
    static Pair<String, String> m23518a(Long l, Long l2) {
        return m23519a(l, l2, (SimpleDateFormat) null);
    }

    /* renamed from: a */
    static Pair<String, String> m23519a(Long l, Long l2, SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return Pair.create(null, null);
        }
        if (l == null) {
            return Pair.create(null, m23521a(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return Pair.create(m23521a(l.longValue(), simpleDateFormat), null);
        }
        java.util.Calendar b = C11544e.m23564b();
        java.util.Calendar c = C11544e.m23567c();
        c.setTimeInMillis(l.longValue());
        java.util.Calendar c2 = C11544e.m23567c();
        c2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        } else if (c.get(1) != c2.get(1)) {
            return Pair.create(m23522a(l.longValue(), RFusion.getLocale()), m23522a(l2.longValue(), RFusion.getLocale()));
        } else {
            if (c.get(1) == b.get(1)) {
                return Pair.create(m23525b(l.longValue(), RFusion.getLocale()), m23525b(l2.longValue(), RFusion.getLocale()));
            }
            return Pair.create(m23525b(l.longValue(), RFusion.getLocale()), m23522a(l2.longValue(), RFusion.getLocale()));
        }
    }
}
