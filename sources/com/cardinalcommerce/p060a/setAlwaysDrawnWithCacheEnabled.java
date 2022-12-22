package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.text.Typography;
import okio.internal.BufferKt;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p071io.IOUtils;

/* renamed from: com.cardinalcommerce.a.setAlwaysDrawnWithCacheEnabled */
abstract class setAlwaysDrawnWithCacheEnabled {

    /* renamed from: b */
    private static boolean[] f2669b;

    /* renamed from: c */
    private static boolean[] f2670c;

    /* renamed from: d */
    private static boolean[] f2671d;

    /* renamed from: e */
    private static boolean[] f2672e;
    protected static boolean[] getInstance;
    protected int Cardinal;

    /* renamed from: a */
    private String f2673a;
    protected char cca_continue;
    protected final boolean cleanup;
    protected final C2031configure configure = new C2031configure();

    /* renamed from: f */
    private Object f2674f;

    /* renamed from: g */
    private boolean f2675g;
    protected final boolean getSDKVersion;

    /* renamed from: h */
    private boolean f2676h;

    /* renamed from: i */
    private boolean f2677i;
    protected String init;

    /* renamed from: j */
    private boolean f2678j;

    /* renamed from: k */
    private boolean f2679k;

    /* renamed from: l */
    private boolean f2680l;

    /* renamed from: m */
    private boolean f2681m;

    /* renamed from: n */
    private boolean f2682n;
    protected final boolean values;

    /* access modifiers changed from: protected */
    public abstract void Cardinal() throws setCertificate, IOException;

    /* access modifiers changed from: protected */
    public abstract void CardinalError() throws setCertificate, IOException;

    /* access modifiers changed from: package-private */
    public abstract void cleanup() throws IOException;

    /* access modifiers changed from: protected */
    public abstract Object configure(boolean[] zArr) throws setCertificate, IOException;

    /* access modifiers changed from: protected */
    public abstract void configure() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void init(boolean[] zArr) throws IOException;

    static {
        boolean[] zArr = new boolean[126];
        getInstance = zArr;
        boolean[] zArr2 = new boolean[126];
        f2669b = zArr2;
        boolean[] zArr3 = new boolean[126];
        f2670c = zArr3;
        boolean[] zArr4 = new boolean[126];
        f2671d = zArr4;
        boolean[] zArr5 = new boolean[126];
        f2672e = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public setAlwaysDrawnWithCacheEnabled(int i) {
        boolean z = false;
        this.f2675g = (i & 4) > 0;
        this.cleanup = (i & 2) > 0;
        this.getSDKVersion = (i & 1) > 0;
        this.f2679k = (i & 8) > 0;
        this.f2681m = (i & 16) > 0;
        this.values = (i & 32) > 0;
        this.f2676h = (i & 64) > 0;
        this.f2680l = (i & 128) > 0;
        this.f2677i = (i & 768) != 768;
        this.f2678j = (i & 512) == 0;
        this.f2682n = (i & 1024) > 0 ? true : z;
    }

    public final void getInstance() throws setCertificate {
        if (!this.f2679k) {
            int length = this.init.length();
            for (int i = 0; i < length; i++) {
                char charAt = this.init.charAt(i);
                if (charAt >= 0) {
                    if (charAt <= 31) {
                        throw new setCertificate(this.Cardinal + i, 0, Character.valueOf(charAt));
                    } else if (charAt == 127 && this.f2682n) {
                        throw new setCertificate(this.Cardinal + i, 0, Character.valueOf(charAt));
                    }
                }
            }
        }
    }

    public final void init() throws setCertificate {
        int length = this.init.length();
        if (length != 1) {
            if (length != 2) {
                char charAt = this.init.charAt(0);
                char charAt2 = this.init.charAt(1);
                if (charAt == '-') {
                    char charAt3 = this.init.charAt(2);
                    if (charAt2 == '0' && charAt3 >= '0' && charAt3 <= '9') {
                        throw new setCertificate(this.Cardinal, 6, this.init);
                    }
                } else if (charAt == '0' && charAt2 >= '0' && charAt2 <= '9') {
                    throw new setCertificate(this.Cardinal, 6, this.init);
                }
            } else if (this.init.equals("00")) {
                throw new setCertificate(this.Cardinal, 6, this.init);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Number cca_continue() throws setCertificate {
        if (!this.values) {
            init();
        }
        if (!this.f2680l) {
            return Float.valueOf(Float.parseFloat(this.init));
        }
        if (this.init.length() > 18) {
            return new BigDecimal(this.init);
        }
        return Double.valueOf(Double.parseDouble(this.init));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
        throw new com.cardinalcommerce.p060a.setCertificate(r5.Cardinal, 0, java.lang.Character.valueOf(r5.cca_continue));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0105, code lost:
        r0 = configure(f2672e);
        r5.f2674f = r0;
        r6 = r6.init(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T getInstance(com.cardinalcommerce.p060a.setWebViewRenderProcessClient<T> r6) throws com.cardinalcommerce.p060a.setCertificate {
        /*
            r5 = this;
            r0 = -1
            r5.Cardinal = r0
            r5.configure()     // Catch:{ IOException -> 0x0152 }
        L_0x0006:
            char r0 = r5.cca_continue     // Catch:{ IOException -> 0x0152 }
            r1 = 9
            if (r0 == r1) goto L_0x014d
            r1 = 10
            if (r0 == r1) goto L_0x014d
            r1 = 0
            r2 = 1
            switch(r0) {
                case 13: goto L_0x014d;
                case 32: goto L_0x014d;
                case 34: goto L_0x0112;
                case 39: goto L_0x0112;
                case 45: goto L_0x0105;
                case 78: goto L_0x00c8;
                case 91: goto L_0x00c3;
                case 93: goto L_0x00b4;
                case 102: goto L_0x0088;
                case 110: goto L_0x0060;
                case 116: goto L_0x0033;
                case 123: goto L_0x002d;
                case 125: goto L_0x00b4;
                default: goto L_0x0015;
            }     // Catch:{ IOException -> 0x0152 }
        L_0x0015:
            switch(r0) {
                case 48: goto L_0x0105;
                case 49: goto L_0x0105;
                case 50: goto L_0x0105;
                case 51: goto L_0x0105;
                case 52: goto L_0x0105;
                case 53: goto L_0x0105;
                case 54: goto L_0x0105;
                case 55: goto L_0x0105;
                case 56: goto L_0x0105;
                case 57: goto L_0x0105;
                case 58: goto L_0x00b4;
                default: goto L_0x0018;
            }     // Catch:{ IOException -> 0x0152 }
        L_0x0018:
            boolean[] r0 = f2672e     // Catch:{ IOException -> 0x0152 }
            r5.init(r0)     // Catch:{ IOException -> 0x0152 }
            boolean r0 = r5.cleanup     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x0023
            goto L_0x0115
        L_0x0023:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            java.lang.String r1 = r5.init     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r2, r1)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x002d:
            java.lang.Object r6 = r5.m1952b(r6)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x0033:
            boolean[] r0 = f2672e     // Catch:{ IOException -> 0x0152 }
            r5.init(r0)     // Catch:{ IOException -> 0x0152 }
            java.lang.String r0 = "true"
            java.lang.String r3 = r5.init     // Catch:{ IOException -> 0x0152 }
            boolean r0 = r0.equals(r3)     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x004a
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x004a:
            boolean r0 = r5.cleanup     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = r5.init     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x0056:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            java.lang.String r1 = r5.init     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r2, r1)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x0060:
            boolean[] r0 = f2672e     // Catch:{ IOException -> 0x0152 }
            r5.init(r0)     // Catch:{ IOException -> 0x0152 }
            java.lang.String r0 = "null"
            java.lang.String r3 = r5.init     // Catch:{ IOException -> 0x0152 }
            boolean r0 = r0.equals(r3)     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x0072
            r6 = r1
            goto L_0x011b
        L_0x0072:
            boolean r0 = r5.cleanup     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x007e
            java.lang.String r0 = r5.init     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x007e:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            java.lang.String r1 = r5.init     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r2, r1)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x0088:
            boolean[] r0 = f2672e     // Catch:{ IOException -> 0x0152 }
            r5.init(r0)     // Catch:{ IOException -> 0x0152 }
            java.lang.String r0 = "false"
            java.lang.String r3 = r5.init     // Catch:{ IOException -> 0x0152 }
            boolean r0 = r0.equals(r3)     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x009f
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x009f:
            boolean r0 = r5.cleanup     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x00aa
            java.lang.String r0 = r5.init     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x00aa:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            java.lang.String r1 = r5.init     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r2, r1)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x00b4:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            r1 = 0
            char r2 = r5.cca_continue     // Catch:{ IOException -> 0x0152 }
            java.lang.Character r2 = java.lang.Character.valueOf(r2)     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r1, r2)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x00c3:
            java.lang.Object r6 = r5.m1950a(r6)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x00c8:
            boolean[] r0 = f2672e     // Catch:{ IOException -> 0x0152 }
            r5.init(r0)     // Catch:{ IOException -> 0x0152 }
            boolean r0 = r5.f2675g     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x00fb
            java.lang.String r0 = "NaN"
            java.lang.String r3 = r5.init     // Catch:{ IOException -> 0x0152 }
            boolean r0 = r0.equals(r3)     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x00e6
            r0 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x00e6:
            boolean r0 = r5.cleanup     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x00f1
            java.lang.String r0 = r5.init     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x00f1:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            java.lang.String r1 = r5.init     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r2, r1)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x00fb:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            java.lang.String r1 = r5.init     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r2, r1)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x0105:
            boolean[] r0 = f2672e     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r0 = r5.configure(r0)     // Catch:{ IOException -> 0x0152 }
            r5.f2674f = r0     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
            goto L_0x011b
        L_0x0112:
            r5.CardinalError()     // Catch:{ IOException -> 0x0152 }
        L_0x0115:
            java.lang.String r0 = r5.init     // Catch:{ IOException -> 0x0152 }
            java.lang.Object r6 = r6.init((java.lang.Object) r0)     // Catch:{ IOException -> 0x0152 }
        L_0x011b:
            boolean r0 = r5.f2677i     // Catch:{ IOException -> 0x0152 }
            if (r0 == 0) goto L_0x0148
            boolean r0 = r5.f2678j     // Catch:{ IOException -> 0x0152 }
            r3 = 26
            if (r0 != 0) goto L_0x0134
        L_0x0125:
            char r0 = r5.cca_continue     // Catch:{ IOException -> 0x0152 }
            r4 = 32
            if (r0 > r4) goto L_0x0134
            char r0 = r5.cca_continue     // Catch:{ IOException -> 0x0152 }
            if (r0 != r3) goto L_0x0130
            goto L_0x0134
        L_0x0130:
            r5.cleanup()     // Catch:{ IOException -> 0x0152 }
            goto L_0x0125
        L_0x0134:
            char r0 = r5.cca_continue     // Catch:{ IOException -> 0x0152 }
            if (r0 != r3) goto L_0x0139
            goto L_0x0148
        L_0x0139:
            com.cardinalcommerce.a.setCertificate r6 = new com.cardinalcommerce.a.setCertificate     // Catch:{ IOException -> 0x0152 }
            int r0 = r5.Cardinal     // Catch:{ IOException -> 0x0152 }
            int r0 = r0 - r2
            char r1 = r5.cca_continue     // Catch:{ IOException -> 0x0152 }
            java.lang.Character r1 = java.lang.Character.valueOf(r1)     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r0, r2, r1)     // Catch:{ IOException -> 0x0152 }
            throw r6     // Catch:{ IOException -> 0x0152 }
        L_0x0148:
            r5.init = r1
            r5.f2674f = r1
            return r6
        L_0x014d:
            r5.configure()     // Catch:{ IOException -> 0x0152 }
            goto L_0x0006
        L_0x0152:
            r6 = move-exception
            com.cardinalcommerce.a.setCertificate r0 = new com.cardinalcommerce.a.setCertificate
            int r1 = r5.Cardinal
            r0.<init>(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setAlwaysDrawnWithCacheEnabled.getInstance(com.cardinalcommerce.a.setWebViewRenderProcessClient):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final Number getInstance(String str) throws setCertificate {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int length = str.length();
        boolean z3 = false;
        if (str.charAt(0) == '-') {
            i2 = 20;
            if (this.values || length < 3 || str.charAt(1) != '0') {
                i = 1;
                z = true;
            } else {
                throw new setCertificate(this.Cardinal, 6, str);
            }
        } else if (this.values || length < 2 || str.charAt(0) != '0') {
            i2 = 19;
            i = 0;
            z = false;
        } else {
            throw new setCertificate(this.Cardinal, 6, str);
        }
        if (length < i2) {
            z2 = false;
        } else if (length > i2) {
            return new BigInteger(str, 10);
        } else {
            length--;
            z2 = true;
        }
        long j = 0;
        while (i < length) {
            j = (j * 10) + ((long) ('0' - str.charAt(i)));
            i++;
        }
        if (z2) {
            int i3 = (j > BufferKt.OVERFLOW_ZONE ? 1 : (j == BufferKt.OVERFLOW_ZONE ? 0 : -1));
            if (i3 <= 0 && (i3 < 0 || (!z ? str.charAt(i) > '7' : str.charAt(i) > '8'))) {
                z3 = true;
            }
            if (z3) {
                return new BigInteger(str, 10);
            }
            j = (j * 10) + ((long) ('0' - str.charAt(i)));
        }
        if (!z) {
            long j2 = -j;
            if (!this.f2681m || j2 > 2147483647L) {
                return Long.valueOf(j2);
            }
            return Integer.valueOf((int) j2);
        } else if (!this.f2681m || j < -2147483648L) {
            return Long.valueOf(j);
        } else {
            return Integer.valueOf((int) j);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r5 == ':') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r5 == ']') goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r5 == '}') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (r4 == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r7.f2676h == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        throw new com.cardinalcommerce.p060a.setCertificate(r7.Cardinal, 0, java.lang.Character.valueOf(r7.cca_continue));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        configure();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        return r8.init(r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T m1950a(com.cardinalcommerce.p060a.setWebViewRenderProcessClient<T> r8) throws com.cardinalcommerce.p060a.setCertificate, java.io.IOException {
        /*
            r7 = this;
            java.lang.Object r0 = r8.configure()
            char r1 = r7.cca_continue
            r2 = 91
            if (r1 != r2) goto L_0x00ad
            r7.configure()
            char r1 = r7.cca_continue
            r2 = 44
            r3 = 0
            if (r1 != r2) goto L_0x0027
            boolean r1 = r7.f2676h
            if (r1 == 0) goto L_0x0019
            goto L_0x0027
        L_0x0019:
            com.cardinalcommerce.a.setCertificate r8 = new com.cardinalcommerce.a.setCertificate
            int r0 = r7.Cardinal
            char r1 = r7.cca_continue
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0027:
            r1 = 1
        L_0x0028:
            r4 = 0
        L_0x0029:
            char r5 = r7.cca_continue
            r6 = 9
            if (r5 == r6) goto L_0x00a8
            r6 = 10
            if (r5 == r6) goto L_0x00a8
            r6 = 13
            if (r5 == r6) goto L_0x00a8
            r6 = 26
            if (r5 == r6) goto L_0x009c
            r6 = 32
            if (r5 == r6) goto L_0x00a8
            if (r5 == r2) goto L_0x0082
            r6 = 58
            if (r5 == r6) goto L_0x0074
            r6 = 93
            if (r5 == r6) goto L_0x0057
            r4 = 125(0x7d, float:1.75E-43)
            if (r5 == r4) goto L_0x0074
            boolean[] r4 = f2669b
            java.lang.Object r4 = r7.m1951a(r8, r4)
            r8.Cardinal(r0, r4)
            goto L_0x0028
        L_0x0057:
            if (r4 == 0) goto L_0x006c
            boolean r1 = r7.f2676h
            if (r1 == 0) goto L_0x005e
            goto L_0x006c
        L_0x005e:
            com.cardinalcommerce.a.setCertificate r8 = new com.cardinalcommerce.a.setCertificate
            int r0 = r7.Cardinal
            char r1 = r7.cca_continue
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x006c:
            r7.configure()
            java.lang.Object r8 = r8.init((java.lang.Object) r0)
            return r8
        L_0x0074:
            com.cardinalcommerce.a.setCertificate r8 = new com.cardinalcommerce.a.setCertificate
            int r0 = r7.Cardinal
            char r1 = r7.cca_continue
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0082:
            if (r4 == 0) goto L_0x0097
            boolean r4 = r7.f2676h
            if (r4 == 0) goto L_0x0089
            goto L_0x0097
        L_0x0089:
            com.cardinalcommerce.a.setCertificate r8 = new com.cardinalcommerce.a.setCertificate
            int r0 = r7.Cardinal
            char r1 = r7.cca_continue
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0097:
            r7.configure()
            r4 = 1
            goto L_0x0029
        L_0x009c:
            com.cardinalcommerce.a.setCertificate r8 = new com.cardinalcommerce.a.setCertificate
            int r0 = r7.Cardinal
            int r0 = r0 - r1
            r1 = 3
            java.lang.String r2 = "EOF"
            r8.<init>(r0, r1, r2)
            throw r8
        L_0x00a8:
            r7.configure()
            goto L_0x0029
        L_0x00ad:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Internal Error"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setAlwaysDrawnWithCacheEnabled.m1950a(com.cardinalcommerce.a.setWebViewRenderProcessClient):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        throw new com.cardinalcommerce.p060a.setCertificate(r2.Cardinal, 0, java.lang.Character.valueOf(r2.cca_continue));
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m1951a(com.cardinalcommerce.p060a.setWebViewRenderProcessClient<?> r3, boolean[] r4) throws com.cardinalcommerce.p060a.setCertificate, java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            char r0 = r2.cca_continue
            r1 = 9
            if (r0 == r1) goto L_0x00ea
            r1 = 10
            if (r0 == r1) goto L_0x00ea
            r1 = 1
            switch(r0) {
                case 13: goto L_0x00ea;
                case 32: goto L_0x00ea;
                case 34: goto L_0x00e4;
                case 39: goto L_0x00e4;
                case 45: goto L_0x00df;
                case 78: goto L_0x00ac;
                case 91: goto L_0x00a1;
                case 93: goto L_0x0092;
                case 102: goto L_0x0071;
                case 110: goto L_0x0051;
                case 116: goto L_0x0030;
                case 123: goto L_0x0025;
                case 125: goto L_0x0092;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 48: goto L_0x00df;
                case 49: goto L_0x00df;
                case 50: goto L_0x00df;
                case 51: goto L_0x00df;
                case 52: goto L_0x00df;
                case 53: goto L_0x00df;
                case 54: goto L_0x00df;
                case 55: goto L_0x00df;
                case 56: goto L_0x00df;
                case 57: goto L_0x00df;
                case 58: goto L_0x0092;
                default: goto L_0x0011;
            }
        L_0x0011:
            r2.init(r4)
            boolean r3 = r2.cleanup
            if (r3 == 0) goto L_0x001b
            java.lang.String r3 = r2.init
            return r3
        L_0x001b:
            com.cardinalcommerce.a.setCertificate r3 = new com.cardinalcommerce.a.setCertificate
            int r4 = r2.Cardinal
            java.lang.String r0 = r2.init
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0025:
            java.lang.String r4 = r2.f2673a
            com.cardinalcommerce.a.setWebViewRenderProcessClient r3 = r3.cca_continue(r4)
            java.lang.Object r3 = r2.m1952b(r3)
            return r3
        L_0x0030:
            r2.init(r4)
            java.lang.String r3 = r2.init
            java.lang.String r4 = "true"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0040
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            return r3
        L_0x0040:
            boolean r3 = r2.cleanup
            if (r3 == 0) goto L_0x0047
            java.lang.String r3 = r2.init
            return r3
        L_0x0047:
            com.cardinalcommerce.a.setCertificate r3 = new com.cardinalcommerce.a.setCertificate
            int r4 = r2.Cardinal
            java.lang.String r0 = r2.init
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0051:
            r2.init(r4)
            java.lang.String r3 = r2.init
            java.lang.String r4 = "null"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0060
            r3 = 0
            return r3
        L_0x0060:
            boolean r3 = r2.cleanup
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = r2.init
            return r3
        L_0x0067:
            com.cardinalcommerce.a.setCertificate r3 = new com.cardinalcommerce.a.setCertificate
            int r4 = r2.Cardinal
            java.lang.String r0 = r2.init
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0071:
            r2.init(r4)
            java.lang.String r3 = r2.init
            java.lang.String r4 = "false"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0081
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            return r3
        L_0x0081:
            boolean r3 = r2.cleanup
            if (r3 == 0) goto L_0x0088
            java.lang.String r3 = r2.init
            return r3
        L_0x0088:
            com.cardinalcommerce.a.setCertificate r3 = new com.cardinalcommerce.a.setCertificate
            int r4 = r2.Cardinal
            java.lang.String r0 = r2.init
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0092:
            com.cardinalcommerce.a.setCertificate r3 = new com.cardinalcommerce.a.setCertificate
            int r4 = r2.Cardinal
            r0 = 0
            char r1 = r2.cca_continue
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r3.<init>(r4, r0, r1)
            throw r3
        L_0x00a1:
            java.lang.String r4 = r2.f2673a
            com.cardinalcommerce.a.setWebViewRenderProcessClient r3 = r3.init((java.lang.String) r4)
            java.lang.Object r3 = r2.m1950a(r3)
            return r3
        L_0x00ac:
            r2.init(r4)
            boolean r3 = r2.f2675g
            if (r3 == 0) goto L_0x00d5
            java.lang.String r3 = r2.init
            java.lang.String r4 = "NaN"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00c4
            r3 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            return r3
        L_0x00c4:
            boolean r3 = r2.cleanup
            if (r3 == 0) goto L_0x00cb
            java.lang.String r3 = r2.init
            return r3
        L_0x00cb:
            com.cardinalcommerce.a.setCertificate r3 = new com.cardinalcommerce.a.setCertificate
            int r4 = r2.Cardinal
            java.lang.String r0 = r2.init
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00d5:
            com.cardinalcommerce.a.setCertificate r3 = new com.cardinalcommerce.a.setCertificate
            int r4 = r2.Cardinal
            java.lang.String r0 = r2.init
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00df:
            java.lang.Object r3 = r2.configure(r4)
            return r3
        L_0x00e4:
            r2.CardinalError()
            java.lang.String r3 = r2.init
            return r3
        L_0x00ea:
            r2.configure()
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setAlwaysDrawnWithCacheEnabled.m1951a(com.cardinalcommerce.a.setWebViewRenderProcessClient, boolean[]):java.lang.Object");
    }

    /* renamed from: b */
    private <T> T m1952b(setWebViewRenderProcessClient<T> setwebviewrenderprocessclient) throws setCertificate, IOException {
        if (this.cca_continue == '{') {
            Object cca_continue2 = setwebviewrenderprocessclient.cca_continue();
            boolean z = false;
            while (true) {
                configure();
                char c = this.cca_continue;
                if (!(c == 9 || c == 10 || c == 13 || c == ' ')) {
                    if (c != ',') {
                        if (c != ':' && c != '[' && c != ']' && c != '{') {
                            if (c != '}') {
                                if (c == '\"' || c == '\'') {
                                    CardinalError();
                                } else {
                                    init(f2670c);
                                    if (!this.cleanup) {
                                        throw new setCertificate(this.Cardinal, 1, this.init);
                                    }
                                }
                                String str = this.init;
                                getWarnings();
                                char c2 = this.cca_continue;
                                if (c2 == ':') {
                                    Cardinal();
                                    this.f2673a = str;
                                    setwebviewrenderprocessclient.cca_continue(cca_continue2, str, m1951a(setwebviewrenderprocessclient, f2671d));
                                    this.f2673a = null;
                                    getWarnings();
                                    char c3 = this.cca_continue;
                                    if (c3 == '}') {
                                        configure();
                                        return setwebviewrenderprocessclient.init(cca_continue2);
                                    } else if (c3 == 26) {
                                        throw new setCertificate(this.Cardinal - 1, 3, (Object) null);
                                    } else if (c3 != ',') {
                                        throw new setCertificate(this.Cardinal - 1, 1, Character.valueOf(this.cca_continue));
                                    }
                                } else if (c2 == 26) {
                                    throw new setCertificate(this.Cardinal - 1, 3, (Object) null);
                                } else {
                                    throw new setCertificate(this.Cardinal - 1, 0, Character.valueOf(this.cca_continue));
                                }
                            } else if (!z || this.f2676h) {
                                configure();
                                return setwebviewrenderprocessclient.init(cca_continue2);
                            } else {
                                throw new setCertificate(this.Cardinal, 0, Character.valueOf(this.cca_continue));
                            }
                        }
                    } else if (z && !this.f2676h) {
                        throw new setCertificate(this.Cardinal, 0, Character.valueOf(this.cca_continue));
                    }
                    z = true;
                }
            }
            throw new setCertificate(this.Cardinal, 0, Character.valueOf(this.cca_continue));
        }
        throw new RuntimeException("Internal Error");
    }

    /* access modifiers changed from: protected */
    public final void values() throws setCertificate, IOException {
        char c = this.cca_continue;
        while (true) {
            configure();
            char c2 = this.cca_continue;
            if (c2 == '\"' || c2 == '\'') {
                char c3 = this.cca_continue;
                if (c == c3) {
                    configure();
                    this.init = this.configure.toString();
                    return;
                }
                this.configure.configure(c3);
            } else if (c2 != '\\') {
                if (c2 != 127) {
                    switch (c2) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                            if (this.f2679k) {
                                continue;
                            } else {
                                throw new setCertificate(this.Cardinal, 0, Character.valueOf(this.cca_continue));
                            }
                        case 26:
                            throw new setCertificate(this.Cardinal - 1, 3, (Object) null);
                    }
                } else if (this.f2679k) {
                    continue;
                } else if (this.f2682n) {
                    throw new setCertificate(this.Cardinal, 0, Character.valueOf(this.cca_continue));
                }
                this.configure.configure(this.cca_continue);
            } else {
                configure();
                char c4 = this.cca_continue;
                if (c4 == '\"') {
                    this.configure.configure(Typography.quote);
                } else if (c4 == '\'') {
                    this.configure.configure('\'');
                } else if (c4 == '/') {
                    this.configure.configure(IOUtils.DIR_SEPARATOR_UNIX);
                } else if (c4 == '\\') {
                    this.configure.configure(IOUtils.DIR_SEPARATOR_WINDOWS);
                } else if (c4 == 'b') {
                    this.configure.configure(8);
                } else if (c4 == 'f') {
                    this.configure.configure(12);
                } else if (c4 == 'n') {
                    this.configure.configure(10);
                } else if (c4 == 'r') {
                    this.configure.configure(CharUtils.f5620CR);
                } else if (c4 == 'x') {
                    this.configure.configure(m1949a(2));
                } else if (c4 == 't') {
                    this.configure.configure(9);
                } else if (c4 == 'u') {
                    this.configure.configure(m1949a(4));
                }
            }
        }
    }

    /* renamed from: a */
    private char m1949a(int i) throws setCertificate, IOException {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 << 4;
            configure();
            char c = this.cca_continue;
            if (c > '9' || c < '0') {
                char c2 = this.cca_continue;
                if (c2 > 'F' || c2 < 'A') {
                    char c3 = this.cca_continue;
                    if (c3 >= 'a' && c3 <= 'f') {
                        i2 = c3 - 'a';
                    } else if (this.cca_continue == 26) {
                        throw new setCertificate(this.Cardinal, 3, "EOF");
                    } else {
                        throw new setCertificate(this.Cardinal, 4, Character.valueOf(this.cca_continue));
                    }
                } else {
                    i2 = c2 - 'A';
                }
                i3 = i2 + 10;
            } else {
                i3 = c - '0';
            }
            i4 = i6 + i3;
        }
        return (char) i4;
    }

    /* access modifiers changed from: protected */
    public final void getSDKVersion() throws IOException {
        while (true) {
            char c = this.cca_continue;
            if (c >= '0' && c <= '9') {
                cleanup();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void cca_continue(boolean[] zArr) throws IOException {
        while (true) {
            char c = this.cca_continue;
            if (c == 26) {
                return;
            }
            if (c < 0 || c >= '~' || !zArr[c]) {
                cleanup();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void getWarnings() throws IOException {
        while (true) {
            char c = this.cca_continue;
            if (c <= ' ' && c != 26) {
                cleanup();
            } else {
                return;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.setAlwaysDrawnWithCacheEnabled$configure */
    public static class C2031configure {
        private char[] configure = new char[15];
        int init = -1;

        public final void configure(char c) {
            int i = this.init + 1;
            this.init = i;
            char[] cArr = this.configure;
            if (cArr.length <= i) {
                char[] cArr2 = new char[((cArr.length << 1) + 1)];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.configure = cArr2;
            }
            this.configure[this.init] = c;
        }

        public final String toString() {
            return new String(this.configure, 0, this.init + 1);
        }
    }
}
