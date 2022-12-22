package com.didi.soda.customer.foundation.rpc;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.concurrent.TimeUnit;

public class Clock {

    /* renamed from: a */
    static int f40969a;

    /* renamed from: b */
    static long f40970b;

    /* renamed from: c */
    static long f40971c = System.currentTimeMillis();

    /* renamed from: d */
    private static final long[] f40972d = new long[100];

    /* renamed from: e */
    private static Logger f40973e = LogService.getLogger("Clock");

    public static void updateServiceTime(long j) {
        Logger logger = f40973e;
        logger.debug("updateServiceTime: " + j, new Object[0]);
        f40970b = j + TimeUnit.MILLISECONDS.toSeconds(m29116a());
        f40971c = System.currentTimeMillis();
    }

    public static long timeOffsetSeconds() {
        return f40970b - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public static long timeAtSeconds() {
        long j;
        long j2 = f40970b;
        if (j2 == 0) {
            j = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        } else {
            j = j2 + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - f40971c);
        }
        Logger logger = f40973e;
        logger.debug("currentTimeAtSeconds: " + j, new Object[0]);
        return j;
    }

    /* renamed from: a */
    static void m29117a(long j) {
        long[] jArr = f40972d;
        int i = f40969a;
        f40969a = i + 1;
        jArr[i % jArr.length] = j;
    }

    /* renamed from: a */
    static long m29116a() {
        int min = Math.min(f40969a + 1, f40972d.length);
        long j = 0;
        for (int i = 0; i < min; i++) {
            j += f40972d[i];
        }
        return (j / ((long) min)) >> 1;
    }
}
