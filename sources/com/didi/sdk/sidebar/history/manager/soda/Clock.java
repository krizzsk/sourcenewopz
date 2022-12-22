package com.didi.sdk.sidebar.history.manager.soda;

import java.util.concurrent.TimeUnit;

public class Clock {

    /* renamed from: a */
    static int f37383a;

    /* renamed from: b */
    static long f37384b;

    /* renamed from: c */
    static long f37385c = System.currentTimeMillis();

    /* renamed from: d */
    private static final long[] f37386d = new long[100];

    /* renamed from: a */
    static void m26593a(long j) {
        long[] jArr = f37386d;
        int i = f37383a;
        f37383a = i + 1;
        jArr[i % jArr.length] = j;
    }

    /* renamed from: a */
    static long m26592a() {
        int min = Math.min(f37383a + 1, f37386d.length);
        long j = 0;
        for (int i = 0; i < min; i++) {
            j += f37386d[i];
        }
        return (j / ((long) min)) >> 1;
    }

    public static void updateServiceTime(long j) {
        f37384b = j + TimeUnit.MILLISECONDS.toSeconds(m26592a());
        f37385c = System.currentTimeMillis();
    }

    public static long timeAtSeconds() {
        long j = f37384b;
        if (j == 0) {
            return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        }
        return j + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - f37385c);
    }
}
