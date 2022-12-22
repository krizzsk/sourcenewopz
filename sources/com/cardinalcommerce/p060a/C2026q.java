package com.cardinalcommerce.p060a;

import javax.crypto.SecretKey;
import org.apache.commons.p071io.IOUtils;

/* renamed from: com.cardinalcommerce.a.q */
final class C2026q {

    /* renamed from: a */
    static C2026q f2626a = null;

    /* renamed from: g */
    private static int f2627g = 0;

    /* renamed from: h */
    private static int f2628h = 1;

    /* renamed from: b */
    int f2629b = 0;

    /* renamed from: c */
    setImageTintBlendMode f2630c;

    /* renamed from: d */
    SecretKey f2631d;

    /* renamed from: e */
    char[] f2632e;

    /* renamed from: f */
    char[] f2633f;

    private C2026q() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1 == null) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.cardinalcommerce.p060a.C2026q m1921a() {
        /*
            java.lang.Class<com.cardinalcommerce.a.q> r0 = com.cardinalcommerce.p060a.C2026q.class
            monitor-enter(r0)
            int r1 = f2628h     // Catch:{ all -> 0x006f }
            r2 = r1 & 89
            r1 = r1 | 89
            int r1 = -r1
            int r1 = -r1
            r3 = r2 | r1
            r4 = 1
            int r3 = r3 << r4
            r1 = r1 ^ r2
            int r3 = r3 - r1
            int r1 = r3 % 128
            f2627g = r1     // Catch:{ all -> 0x006f }
            int r3 = r3 % 2
            r1 = 19
            if (r3 == 0) goto L_0x001e
            r2 = 19
            goto L_0x0020
        L_0x001e:
            r2 = 16
        L_0x0020:
            r3 = 0
            if (r2 == r1) goto L_0x0028
            com.cardinalcommerce.a.q r1 = f2626a     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x004b
            goto L_0x002d
        L_0x0028:
            com.cardinalcommerce.a.q r1 = f2626a     // Catch:{ all -> 0x006f }
            int r2 = r3.length     // Catch:{ all -> 0x006d }
            if (r1 != 0) goto L_0x004b
        L_0x002d:
            com.cardinalcommerce.a.q r1 = new com.cardinalcommerce.a.q     // Catch:{ all -> 0x006f }
            r1.<init>()     // Catch:{ all -> 0x006f }
            f2626a = r1     // Catch:{ all -> 0x006f }
            int r1 = f2627g     // Catch:{ all -> 0x006f }
            r2 = r1 & 45
            r1 = r1 ^ 45
            r1 = r1 | r2
            int r2 = r2 + r1
            int r1 = r2 % 128
            f2628h = r1     // Catch:{ all -> 0x006f }
            int r2 = r2 % 2
            r1 = 21
            if (r2 != 0) goto L_0x0049
            r2 = 21
            goto L_0x004b
        L_0x0049:
            r2 = 15
        L_0x004b:
            com.cardinalcommerce.a.q r1 = f2626a     // Catch:{ all -> 0x006f }
            int r2 = f2628h     // Catch:{ all -> 0x006f }
            r5 = r2 ^ 81
            r2 = r2 & 81
            int r2 = r2 << r4
            r6 = r5 | r2
            int r6 = r6 << r4
            r2 = r2 ^ r5
            int r6 = r6 - r2
            int r2 = r6 % 128
            f2627g = r2     // Catch:{ all -> 0x006f }
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x0062
            r4 = 0
        L_0x0062:
            if (r4 == 0) goto L_0x0066
            monitor-exit(r0)
            return r1
        L_0x0066:
            super.hashCode()     // Catch:{ all -> 0x006b }
            monitor-exit(r0)
            return r1
        L_0x006b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x006f }
        L_0x006d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x006f }
        L_0x006f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2026q.m1921a():com.cardinalcommerce.a.q");
    }

    /* renamed from: b */
    public final char[] mo18295b() {
        int i = f2628h;
        int i2 = ((i | 109) << 1) - (i ^ 109);
        f2627g = i2 % 128;
        if ((i2 % 2 != 0 ? 'E' : IOUtils.DIR_SEPARATOR_WINDOWS) == '\\') {
            return this.f2632e;
        }
        int i3 = 18 / 0;
        return this.f2632e;
    }

    /* renamed from: c */
    public final char[] mo18296c() {
        char[] cArr;
        int i = f2627g;
        int i2 = ((i | 69) << 1) - (i ^ 69);
        f2628h = i2 % 128;
        Object obj = null;
        if ((i2 % 2 == 0 ? 'B' : IOUtils.DIR_SEPARATOR_WINDOWS) != 'B') {
            cArr = this.f2633f;
        } else {
            cArr = this.f2633f;
            super.hashCode();
        }
        int i3 = f2627g;
        int i4 = (((i3 & -46) | ((~i3) & 45)) - (~(-(-((i3 & 45) << 1))))) - 1;
        f2628h = i4 % 128;
        if ((i4 % 2 == 0 ? '!' : '+') != '!') {
            return cArr;
        }
        super.hashCode();
        return cArr;
    }
}
