package com.cardinalcommerce.p060a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cardinalcommerce.a.setRotationY */
public final class setRotationY implements setOutlineProvider {

    /* renamed from: a */
    private static final Map<String, setRotationY> f2958a;

    /* renamed from: b */
    private final int f2959b;

    /* renamed from: c */
    private final String f2960c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(m2079a("SHA-256", 32, 16, 67, 10), new setRotationY(1, "XMSS_SHA2_10_256"));
        hashMap.put(m2079a("SHA-256", 32, 16, 67, 16), new setRotationY(2, "XMSS_SHA2_16_256"));
        hashMap.put(m2079a("SHA-256", 32, 16, 67, 20), new setRotationY(3, "XMSS_SHA2_20_256"));
        hashMap.put(m2079a("SHA-512", 64, 16, 131, 10), new setRotationY(4, "XMSS_SHA2_10_512"));
        hashMap.put(m2079a("SHA-512", 64, 16, 131, 16), new setRotationY(5, "XMSS_SHA2_16_512"));
        hashMap.put(m2079a("SHA-512", 64, 16, 131, 20), new setRotationY(6, "XMSS_SHA2_20_512"));
        hashMap.put(m2079a("SHAKE128", 32, 16, 67, 10), new setRotationY(7, "XMSS_SHAKE_10_256"));
        hashMap.put(m2079a("SHAKE128", 32, 16, 67, 16), new setRotationY(8, "XMSS_SHAKE_16_256"));
        hashMap.put(m2079a("SHAKE128", 32, 16, 67, 20), new setRotationY(9, "XMSS_SHAKE_20_256"));
        hashMap.put(m2079a("SHAKE256", 64, 16, 131, 10), new setRotationY(10, "XMSS_SHAKE_10_512"));
        hashMap.put(m2079a("SHAKE256", 64, 16, 131, 16), new setRotationY(11, "XMSS_SHAKE_16_512"));
        hashMap.put(m2079a("SHAKE256", 64, 16, 131, 20), new setRotationY(12, "XMSS_SHAKE_20_512"));
        f2958a = Collections.unmodifiableMap(hashMap);
    }

    private setRotationY(int i, String str) {
        this.f2959b = i;
        this.f2960c = str;
    }

    /* renamed from: a */
    private static String m2079a(String str, int i, int i2, int i3, int i4) {
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
            return sb.toString();
        }
        throw new NullPointerException("algorithmName == null");
    }

    public static setRotationY configure(String str, int i, int i2, int i3, int i4) {
        if (str != null) {
            return f2958a.get(m2079a(str, i, 16, i3, i4));
        }
        throw new NullPointerException("algorithmName == null");
    }

    public final int init() {
        return this.f2959b;
    }

    public final String toString() {
        return this.f2960c;
    }
}
