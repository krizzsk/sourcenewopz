package com.didichuxing.mlcp.drtc.utils;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.didichuxing.mlcp.drtc.utils.b */
/* compiled from: ByteArrayAllocator */
public final class C15917b {

    /* renamed from: a */
    private static AtomicInteger f48450a = new AtomicInteger(0);

    /* renamed from: b */
    private static AtomicLong f48451b = new AtomicLong(0);

    /* renamed from: a */
    public static byte[] m34719a(int i) {
        byte[] bArr = null;
        if (!m34720b()) {
            return null;
        }
        try {
            bArr = new byte[i];
            m34718a();
            return bArr;
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                bArr = new byte[i];
                m34718a();
                return bArr;
            } catch (OutOfMemoryError unused2) {
                f48450a.incrementAndGet();
                f48451b.set(SystemClock.elapsedRealtime());
                return bArr;
            }
        }
    }

    /* renamed from: b */
    private static boolean m34720b() {
        if (f48450a.get() <= 10) {
            return true;
        }
        long j = f48451b.get();
        if (j == 0 || SystemClock.elapsedRealtime() - j > 3000) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m34718a() {
        if (f48450a.get() != 0) {
            f48450a.set(0);
        }
    }
}
