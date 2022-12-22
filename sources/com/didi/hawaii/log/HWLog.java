package com.didi.hawaii.log;

import com.didi.hawaii.basic.ApolloHawaii;

public final class HWLog {

    /* renamed from: BM */
    public static final int f23444BM = 1;
    public static final String BUFFER_ID = "hawaii";
    public static final byte TYPE_ORDER_ROUTE_PB = 1;
    public static final byte TYPE_OTHER = Byte.MAX_VALUE;
    public static final byte TYPE_TRAFFIC_PB = 3;

    /* renamed from: a */
    private static int f23445a = 4;

    /* renamed from: b */
    private static int f23446b = 4;

    /* renamed from: c */
    private static int f23447c = 4;

    /* renamed from: d */
    private static int f23448d = 4;

    /* renamed from: e */
    private static final String f23449e = "HWLog";

    /* renamed from: f */
    private static final boolean f23450f = ApolloHawaii.isUseOneLogger();

    /* renamed from: g */
    private static final String[] f23451g = {"", "UnKnown/", "V/", "D/", "I/", "W/", "E/"};

    /* renamed from: h */
    private static HWLogCallback f23452h = null;

    /* renamed from: a */
    private static boolean m16757a(int i, int i2) {
        return i >= i2;
    }

    public static void setCallback(HWLogCallback hWLogCallback) {
    }

    private HWLog() {
    }

    public static void initControlLevel(int i, int i2, int i3, int i4) {
        f23445a = i;
        f23446b = i2;
        f23447c = i3;
        f23448d = i4;
    }

    public static int getJniLogControl() {
        return f23448d;
    }

    public static boolean jniLogOpen() {
        return f23448d <= 6;
    }

    /* renamed from: v */
    public static void m16762v(int i, String str, String str2) {
        m16755a(i, 2, str, str2);
    }

    /* renamed from: d */
    public static void m16758d(int i, String str, String str2) {
        m16755a(i, 3, str, str2);
    }

    /* renamed from: d */
    public static void m16759d(String str, String str2) {
        m16758d(1, str, str2);
    }

    /* renamed from: i */
    public static void m16761i(String str, String str2) {
        m16755a(1, 4, str, str2);
    }

    /* renamed from: w */
    public static void m16763w(int i, String str, String str2) {
        m16755a(i, 5, str, str2);
    }

    /* renamed from: e */
    public static void m16760e(int i, String str, String str2) {
        m16755a(i, 6, str, str2);
    }

    public static void printNative(int i, String str) {
        HWLogCallback hWLogCallback = f23452h;
        if (hWLogCallback == null) {
            C8943c.m16783c(str);
        } else {
            m16756a("JNI", i, str, hWLogCallback);
        }
    }

    public static void binary_i(byte b, byte[] bArr, long j) {
        m16754a(b, 4, bArr, j);
    }

    /* renamed from: a */
    private static void m16755a(int i, int i2, String str, String str2) {
        HWLogCallback hWLogCallback = f23452h;
        if (hWLogCallback != null) {
            m16756a(str, i, str2, hWLogCallback);
        } else if (m16757a(i2, f23446b)) {
            C8943c.m16779a(str, str2);
        }
    }

    /* renamed from: a */
    private static void m16756a(String str, int i, String str2, HWLogCallback hWLogCallback) {
        if (i == 1 && f23450f) {
            hWLogCallback.onLog(str2);
        }
    }

    /* renamed from: a */
    private static void m16754a(byte b, int i, byte[] bArr, long j) {
        if (m16757a(i, f23447c)) {
            C8941a.m16768a(bArr, b, j);
        }
    }
}
