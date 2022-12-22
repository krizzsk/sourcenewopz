package com.didi.sdk.logging.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class RollingCalendar extends GregorianCalendar {
    private static final long serialVersionUID = 410984041491053080L;

    public long periodsElapsed(long j, long j2) {
        if (j <= j2) {
            return (j2 - j) / TimeUnit.DAYS.toMillis(1);
        }
        throw new IllegalArgumentException("Start cannot come before end");
    }

    public Date getRelativeDate(Date date, int i) {
        setTime(date);
        set(11, 0);
        set(12, 0);
        set(13, 0);
        set(14, 0);
        add(5, i);
        return getTime();
    }

    public Date getNextTriggeringDate(Date date) {
        return getRelativeDate(date, 1);
    }

    public long getNextTriggeringMillis(Date date) {
        return getNextTriggeringDate(date).getTime();
    }
}
