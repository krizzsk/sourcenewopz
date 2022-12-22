package com.cardinalcommerce.p060a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cardinalcommerce.a.setScaleX */
public final class setScaleX implements setOutlineProvider {

    /* renamed from: a */
    private static final Map<String, setScaleX> f2961a;

    /* renamed from: b */
    private final int f2962b;

    /* renamed from: c */
    private final String f2963c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 20, 2), new setScaleX(1, "XMSSMT_SHA2_20/2_256"));
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 20, 4), new setScaleX(2, "XMSSMT_SHA2_20/4_256"));
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 40, 2), new setScaleX(3, "XMSSMT_SHA2_40/2_256"));
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 40, 2), new setScaleX(4, "XMSSMT_SHA2_40/4_256"));
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 40, 4), new setScaleX(5, "XMSSMT_SHA2_40/8_256"));
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 60, 8), new setScaleX(6, "XMSSMT_SHA2_60/3_256"));
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 60, 6), new setScaleX(7, "XMSSMT_SHA2_60/6_256"));
        hashMap.put(m2080a("SHA-256", 32, 16, 67, 60, 12), new setScaleX(8, "XMSSMT_SHA2_60/12_256"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 20, 2), new setScaleX(9, "XMSSMT_SHA2_20/2_512"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 20, 4), new setScaleX(10, "XMSSMT_SHA2_20/4_512"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 40, 2), new setScaleX(11, "XMSSMT_SHA2_40/2_512"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 40, 4), new setScaleX(12, "XMSSMT_SHA2_40/4_512"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 40, 8), new setScaleX(13, "XMSSMT_SHA2_40/8_512"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 60, 3), new setScaleX(14, "XMSSMT_SHA2_60/3_512"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 60, 6), new setScaleX(15, "XMSSMT_SHA2_60/6_512"));
        hashMap.put(m2080a("SHA-512", 64, 16, 131, 60, 12), new setScaleX(16, "XMSSMT_SHA2_60/12_512"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 20, 2), new setScaleX(17, "XMSSMT_SHAKE_20/2_256"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 20, 4), new setScaleX(18, "XMSSMT_SHAKE_20/4_256"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 40, 2), new setScaleX(19, "XMSSMT_SHAKE_40/2_256"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 40, 4), new setScaleX(20, "XMSSMT_SHAKE_40/4_256"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 40, 8), new setScaleX(21, "XMSSMT_SHAKE_40/8_256"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 60, 3), new setScaleX(22, "XMSSMT_SHAKE_60/3_256"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 60, 6), new setScaleX(23, "XMSSMT_SHAKE_60/6_256"));
        hashMap.put(m2080a("SHAKE128", 32, 16, 67, 60, 12), new setScaleX(24, "XMSSMT_SHAKE_60/12_256"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 20, 2), new setScaleX(25, "XMSSMT_SHAKE_20/2_512"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 20, 4), new setScaleX(26, "XMSSMT_SHAKE_20/4_512"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 40, 2), new setScaleX(27, "XMSSMT_SHAKE_40/2_512"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 40, 4), new setScaleX(28, "XMSSMT_SHAKE_40/4_512"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 40, 8), new setScaleX(29, "XMSSMT_SHAKE_40/8_512"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 60, 3), new setScaleX(30, "XMSSMT_SHAKE_60/3_512"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 60, 6), new setScaleX(31, "XMSSMT_SHAKE_60/6_512"));
        hashMap.put(m2080a("SHAKE256", 64, 16, 131, 60, 12), new setScaleX(32, "XMSSMT_SHAKE_60/12_512"));
        f2961a = Collections.unmodifiableMap(hashMap);
    }

    private setScaleX(int i, String str) {
        this.f2962b = i;
        this.f2963c = str;
    }

    /* renamed from: a */
    private static String m2080a(String str, int i, int i2, int i3, int i4, int i5) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("-");
            sb.append(i);
            sb.append("-");
            sb.append(i2);
            sb.append("-");
            sb.append(i3);
            sb.append("-");
            sb.append(i4);
            sb.append("-");
            sb.append(i5);
            return sb.toString();
        }
        throw new NullPointerException("algorithmName == null");
    }

    public static setScaleX init(String str, int i, int i2, int i3, int i4, int i5) {
        if (str != null) {
            return f2961a.get(m2080a(str, i, i2, i3, i4, i5));
        }
        throw new NullPointerException("algorithmName == null");
    }

    public final int init() {
        return this.f2962b;
    }

    public final String toString() {
        return this.f2963c;
    }
}
