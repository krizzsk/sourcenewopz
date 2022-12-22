package com.didi.entrega.customer.foundation.rpc;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.concurrent.TimeUnit;

public class Clock {

    /* renamed from: a */
    static int f19947a;

    /* renamed from: b */
    static long f19948b;

    /* renamed from: c */
    static long f19949c = System.currentTimeMillis();

    /* renamed from: d */
    private static final long[] f19950d = new long[100];

    /* renamed from: e */
    private static Logger f19951e = LogService.getLogger("Clock");

    public static void updateServiceTime(long j) {
        Logger logger = f19951e;
        logger.debug("updateServiceTime: " + j, new Object[0]);
        f19948b = j + TimeUnit.MILLISECONDS.toSeconds(m14773a());
        f19949c = System.currentTimeMillis();
    }

    public static long timeOffsetSeconds() {
        return f19948b - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public static long timeAtSeconds() {
        long j;
        long j2 = f19948b;
        if (j2 == 0) {
            j = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        } else {
            j = j2 + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - f19949c);
        }
        Logger logger = f19951e;
        logger.debug("currentTimeAtSeconds: " + j, new Object[0]);
        return j;
    }

    /* renamed from: a */
    static void m14774a(long j) {
        long[] jArr = f19950d;
        int i = f19947a;
        f19947a = i + 1;
        jArr[i % jArr.length] = j;
    }

    /* renamed from: a */
    static long m14773a() {
        int min = Math.min(f19947a + 1, f19950d.length);
        long j = 0;
        for (int i = 0; i < min; i++) {
            j += f19950d[i];
        }
        return (j / ((long) min)) >> 1;
    }
}
