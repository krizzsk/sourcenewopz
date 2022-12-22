package com.cardinalcommerce.p060a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cardinalcommerce.a.m */
final class C2020m implements setOutlineProvider {

    /* renamed from: a */
    private static final Map<String, C2020m> f2611a;

    /* renamed from: b */
    private final int f2612b;

    /* renamed from: c */
    private final String f2613c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(m1918b("SHA-256", 32, 16, 67), new C2020m(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(m1918b("SHA-512", 64, 16, 131), new C2020m(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(m1918b("SHAKE128", 32, 16, 67), new C2020m(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(m1918b("SHAKE256", 64, 16, 131), new C2020m(67108868, "WOTSP_SHAKE256_W16"));
        f2611a = Collections.unmodifiableMap(hashMap);
    }

    private C2020m(int i, String str) {
        this.f2612b = i;
        this.f2613c = str;
    }

    /* renamed from: a */
    protected static C2020m m1917a(String str, int i, int i2, int i3) {
        if (str != null) {
            return f2611a.get(m1918b(str, i, 16, i3));
        }
        throw new NullPointerException("algorithmName == null");
    }

    /* renamed from: b */
    private static String m1918b(String str, int i, int i2, int i3) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("-");
            sb.append(i);
            sb.append("-");
            sb.append(i2);
            sb.append("-");
            sb.append(i3);
            return sb.toString();
        }
        throw new NullPointerException("algorithmName == null");
    }

    public final int init() {
        return this.f2612b;
    }

    public final String toString() {
        return this.f2613c;
    }
}
