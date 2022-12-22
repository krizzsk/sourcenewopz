package com.didi.sdk.logging.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CachingDateFormatter {

    /* renamed from: a */
    private long f36649a;

    /* renamed from: b */
    private String f36650b;

    /* renamed from: c */
    private final SimpleDateFormat f36651c;

    public CachingDateFormatter(String str) {
        this(str, Locale.getDefault());
    }

    public CachingDateFormatter(String str, Locale locale) {
        this.f36649a = -1;
        this.f36650b = null;
        this.f36651c = new SimpleDateFormat(str, locale);
    }

    public final String format(long j) {
        String str;
        synchronized (this) {
            if (j != this.f36649a) {
                this.f36649a = j;
                this.f36650b = this.f36651c.format(new Date(j));
            }
            str = this.f36650b;
        }
        return str;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.f36651c.setTimeZone(timeZone);
    }
}
