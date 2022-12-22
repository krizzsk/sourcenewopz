package com.didi.beatles.p099im.manager;

import android.support.p003v4.media.session.PlaybackStateCompat;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.manager.IMBusinessManager */
public class IMBusinessManager {
    public static final int IM_PRODUCTID_BEALES = 259;
    public static final int IM_PRODUCTID_CP = 283;
    public static final int IM_PRODUCTID_QUICK = 260;
    public static final int IM_PRODUCTID_QUICK_DRIVER = 2601;
    public static final int IM_PRODUCTID_SPECIAL = 258;
    public static final int IM_PRODUCTID_TAXI = 257;
    public static final int IM_PRODUCTID_TDC = 276;
    public static final int IM_PRODUCTID_T_DRIVER = 268;
    public static final int IM_PRODUCTID_UBERPP = 281;
    public static final int IM_PRODUCTID_UBERX = 280;

    /* renamed from: a */
    private static long f9235a = 256;

    /* renamed from: b */
    private static long f9236b = 128;

    /* renamed from: c */
    private static long f9237c = 64;

    /* renamed from: d */
    private static long f9238d = 32;

    /* renamed from: e */
    private static long f9239e = 16;

    /* renamed from: f */
    private static long f9240f = 8;

    /* renamed from: g */
    private static long f9241g = 18014398509481984L;

    /* renamed from: h */
    private static long f9242h = 33;

    /* renamed from: i */
    private static long f9243i = 34;

    /* renamed from: j */
    private static long f9244j = 562949953421312L;

    /* renamed from: k */
    private static long f9245k = 281474976710656L;

    /* renamed from: l */
    private static long f9246l = 4222124650659840L;

    /* renamed from: m */
    private static long f9247m = 281474976710656L;

    /* renamed from: n */
    private static long f9248n = (281474976710656L - 1);

    /* renamed from: o */
    private static final long f9249o = 9218868437227405312L;

    /* renamed from: p */
    private static final long f9250p = 4503599627370496L;

    public static int getBusinessId(long j) {
        if (j < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            return 259;
        }
        long j2 = (j & f9249o) / f9250p;
        long j3 = f9235a;
        if (j2 == j3) {
            return 259;
        }
        if (j2 == f9237c) {
            return 258;
        }
        if (j2 == f9236b) {
            return 260;
        }
        if (j2 == f9238d) {
            return 257;
        }
        if (j2 == f9239e) {
            return 280;
        }
        if (j2 == j3) {
            return 268;
        }
        if (j2 == f9240f) {
            return 281;
        }
        if (j2 == f9242h) {
            return 283;
        }
        if (j2 == f9243i) {
            return 276;
        }
        return (int) j2;
    }

    public static long generateSid(int i, long j) {
        long j2 = (j >> 48) != 1 ? 50 : 49;
        long a = m6244a(i);
        if (a != 0) {
            return (j & f9248n) | (a * f9250p) | (1 << ((int) (j2 - 1)));
        }
        return -1;
    }

    public static long generateSid(int i, long j, boolean z) {
        long j2 = z ? 50 : 49;
        long a = m6244a(i);
        if (a != 0) {
            return (j & f9248n) | (a * f9250p) | (1 << ((int) (j2 - 1)));
        }
        IMLog.m6632e("IMEngine", "The businessId is 0 while generate sid !");
        return -1;
    }

    /* renamed from: a */
    private static long m6244a(int i) {
        if (i == 268) {
            return f9241g;
        }
        if (i == 276) {
            return f9243i;
        }
        if (i == 283) {
            return f9242h;
        }
        if (i == 280) {
            return f9239e;
        }
        if (i == 281) {
            return f9240f;
        }
        switch (i) {
            case 257:
                return f9238d;
            case 258:
                return f9237c;
            case 259:
                return f9235a;
            case 260:
                return f9236b;
            default:
                return (long) i;
        }
    }
}
