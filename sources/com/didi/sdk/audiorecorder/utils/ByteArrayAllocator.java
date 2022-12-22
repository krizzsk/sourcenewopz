package com.didi.sdk.audiorecorder.utils;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ByteArrayAllocator {

    /* renamed from: a */
    private static final int f35564a = 10;

    /* renamed from: b */
    private static final int f35565b = 3000;

    /* renamed from: c */
    private static AtomicInteger f35566c = new AtomicInteger(0);

    /* renamed from: d */
    private static AtomicLong f35567d = new AtomicLong(0);

    private ByteArrayAllocator() {
    }

    public static byte[] allocate(int i) {
        byte[] bArr = null;
        if (!m25168b()) {
            return null;
        }
        try {
            bArr = new byte[i];
            m25167a();
            return bArr;
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                bArr = new byte[i];
                m25167a();
                return bArr;
            } catch (OutOfMemoryError unused2) {
                f35566c.incrementAndGet();
                f35567d.set(SystemClock.elapsedRealtime());
                return bArr;
            }
        }
    }

    /* renamed from: a */
    private static void m25167a() {
        if (f35566c.get() != 0) {
            f35566c.set(0);
        }
    }

    /* renamed from: b */
    private static boolean m25168b() {
        if (f35566c.get() <= 10) {
            return true;
        }
        long j = f35567d.get();
        if (j == 0 || SystemClock.elapsedRealtime() - j > 3000) {
            return true;
        }
        return false;
    }
}
