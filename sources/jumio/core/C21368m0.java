package jumio.core;

/* renamed from: jumio.core.m0 */
/* compiled from: SVGParserHelper */
public class C21368m0 {

    /* renamed from: e */
    public static final double[] f59647e = new double[128];

    /* renamed from: a */
    public char f59648a;

    /* renamed from: b */
    public CharSequence f59649b;

    /* renamed from: c */
    public int f59650c;

    /* renamed from: d */
    public int f59651d;

    static {
        int i = 0;
        while (true) {
            double[] dArr = f59647e;
            if (i < dArr.length) {
                dArr[i] = Math.pow(10.0d, (double) i);
                i++;
            } else {
                return;
            }
        }
    }

    public C21368m0(CharSequence charSequence, int i) {
        this.f59649b = charSequence;
        this.f59650c = i;
        this.f59651d = charSequence.length();
        this.f59648a = charSequence.charAt(i);
    }

    /* renamed from: a */
    public void mo175838a() {
        this.f59648a = mo175842d();
    }

    /* renamed from: b */
    public float mo175840b() {
        mo175844f();
        float c = mo175841c();
        mo175843e();
        return c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r5 = mo175842d();
        r15.f59648a = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r5 == '.') goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r5 == 'E') goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r5 == 'e') goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        switch(r5) {
            case 48: goto L_0x0028;
            case 49: goto L_0x0038;
            case 50: goto L_0x0038;
            case 51: goto L_0x0038;
            case 52: goto L_0x0038;
            case 53: goto L_0x0038;
            case 54: goto L_0x0038;
            case 55: goto L_0x0038;
            case 56: goto L_0x0038;
            case 57: goto L_0x0038;
            default: goto L_0x0037;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        return 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r5 = 0;
        r11 = 0;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r5 >= 9) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        r5 = r5 + 1;
        r12 = (r12 * 10) + (r15.f59648a - '0');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        r13 = mo175842d();
        r15.f59648a = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        switch(r13) {
            case 48: goto L_0x003b;
            case 49: goto L_0x003b;
            case 50: goto L_0x003b;
            case 51: goto L_0x003b;
            case 52: goto L_0x003b;
            case 53: goto L_0x003b;
            case 54: goto L_0x003b;
            case 55: goto L_0x003b;
            case 56: goto L_0x003b;
            case 57: goto L_0x003b;
            default: goto L_0x0052;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        r5 = 0;
        r11 = 0;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c1, code lost:
        r1 = mo175842d();
        r15.f59648a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c7, code lost:
        switch(r1) {
            case 48: goto L_0x00c1;
            case 49: goto L_0x00cb;
            case 50: goto L_0x00cb;
            case 51: goto L_0x00cb;
            case 52: goto L_0x00cb;
            case 53: goto L_0x00cb;
            case 54: goto L_0x00cb;
            case 55: goto L_0x00cb;
            case 56: goto L_0x00cb;
            case 57: goto L_0x00cb;
            default: goto L_0x00ca;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00cb, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00cd, code lost:
        if (r4 >= 3) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00cf, code lost:
        r4 = r4 + 1;
        r1 = (r1 * 10) + (r15.f59648a - '0');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d8, code lost:
        r2 = mo175842d();
        r15.f59648a = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00de, code lost:
        switch(r2) {
            case 48: goto L_0x00cc;
            case 49: goto L_0x00cc;
            case 50: goto L_0x00cc;
            case 51: goto L_0x00cc;
            case 52: goto L_0x00cc;
            case 53: goto L_0x00cc;
            case 54: goto L_0x00cc;
            case 55: goto L_0x00cc;
            case 56: goto L_0x00cc;
            case 57: goto L_0x00cc;
            default: goto L_0x00e1;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e1, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0071 A[LOOP_START, PHI: r11 
      PHI: (r11v6 int) = (r11v0 int), (r11v7 int) binds: [B:32:0x006f, B:34:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f A[LOOP_START, PHI: r5 r11 r12 
      PHI: (r5v4 int) = (r5v1 int), (r5v5 int) binds: [B:82:0x007f, B:40:0x0092] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 int) = (r11v2 int), (r11v4 int) binds: [B:82:0x007f, B:40:0x0092] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r12v4 int) = (r12v0 int), (r12v5 int) binds: [B:82:0x007f, B:40:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float mo175841c() {
        /*
            r15 = this;
            char r0 = r15.f59648a
            r1 = 45
            r2 = 43
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L_0x0010
            if (r0 == r1) goto L_0x000e
            r0 = 1
            goto L_0x0017
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            char r5 = r15.mo175842d()
            r15.f59648a = r5
        L_0x0017:
            char r5 = r15.f59648a
            r6 = 101(0x65, float:1.42E-43)
            r7 = 9
            r8 = 69
            r9 = 46
            r10 = 0
            switch(r5) {
                case 46: goto L_0x0058;
                case 47: goto L_0x0025;
                case 48: goto L_0x0028;
                case 49: goto L_0x0038;
                case 50: goto L_0x0038;
                case 51: goto L_0x0038;
                case 52: goto L_0x0038;
                case 53: goto L_0x0038;
                case 54: goto L_0x0038;
                case 55: goto L_0x0038;
                case 56: goto L_0x0038;
                case 57: goto L_0x0038;
                default: goto L_0x0025;
            }
        L_0x0025:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        L_0x0028:
            char r5 = r15.mo175842d()
            r15.f59648a = r5
            if (r5 == r9) goto L_0x0053
            if (r5 == r8) goto L_0x0053
            if (r5 == r6) goto L_0x0053
            switch(r5) {
                case 48: goto L_0x0028;
                case 49: goto L_0x0038;
                case 50: goto L_0x0038;
                case 51: goto L_0x0038;
                case 52: goto L_0x0038;
                case 53: goto L_0x0038;
                case 54: goto L_0x0038;
                case 55: goto L_0x0038;
                case 56: goto L_0x0038;
                case 57: goto L_0x0038;
                default: goto L_0x0037;
            }
        L_0x0037:
            return r10
        L_0x0038:
            r5 = 0
            r11 = 0
            r12 = 0
        L_0x003b:
            if (r5 >= r7) goto L_0x0047
            int r5 = r5 + 1
            int r12 = r12 * 10
            char r13 = r15.f59648a
            int r13 = r13 + -48
            int r12 = r12 + r13
            goto L_0x0049
        L_0x0047:
            int r11 = r11 + 1
        L_0x0049:
            char r13 = r15.mo175842d()
            r15.f59648a = r13
            switch(r13) {
                case 48: goto L_0x003b;
                case 49: goto L_0x003b;
                case 50: goto L_0x003b;
                case 51: goto L_0x003b;
                case 52: goto L_0x003b;
                case 53: goto L_0x003b;
                case 54: goto L_0x003b;
                case 55: goto L_0x003b;
                case 56: goto L_0x003b;
                case 57: goto L_0x003b;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0056
        L_0x0053:
            r5 = 0
            r11 = 0
            r12 = 0
        L_0x0056:
            r13 = 1
            goto L_0x005c
        L_0x0058:
            r5 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x005c:
            char r14 = r15.f59648a
            if (r14 != r9) goto L_0x0095
            char r9 = r15.mo175842d()
            r15.f59648a = r9
            switch(r9) {
                case 48: goto L_0x006f;
                case 49: goto L_0x007f;
                case 50: goto L_0x007f;
                case 51: goto L_0x007f;
                case 52: goto L_0x007f;
                case 53: goto L_0x007f;
                case 54: goto L_0x007f;
                case 55: goto L_0x007f;
                case 56: goto L_0x007f;
                case 57: goto L_0x007f;
                default: goto L_0x0069;
            }
        L_0x0069:
            if (r13 != 0) goto L_0x0095
            r15.mo175839a(r9)
            return r10
        L_0x006f:
            if (r5 != 0) goto L_0x007f
        L_0x0071:
            char r9 = r15.mo175842d()
            r15.f59648a = r9
            int r11 = r11 + -1
            switch(r9) {
                case 48: goto L_0x0071;
                case 49: goto L_0x007f;
                case 50: goto L_0x007f;
                case 51: goto L_0x007f;
                case 52: goto L_0x007f;
                case 53: goto L_0x007f;
                case 54: goto L_0x007f;
                case 55: goto L_0x007f;
                case 56: goto L_0x007f;
                case 57: goto L_0x007f;
                default: goto L_0x007c;
            }
        L_0x007c:
            if (r13 != 0) goto L_0x0095
            return r10
        L_0x007f:
            if (r5 >= r7) goto L_0x008c
            int r5 = r5 + 1
            int r12 = r12 * 10
            char r9 = r15.f59648a
            int r9 = r9 + -48
            int r12 = r12 + r9
            int r11 = r11 + -1
        L_0x008c:
            char r9 = r15.mo175842d()
            r15.f59648a = r9
            switch(r9) {
                case 48: goto L_0x007f;
                case 49: goto L_0x007f;
                case 50: goto L_0x007f;
                case 51: goto L_0x007f;
                case 52: goto L_0x007f;
                case 53: goto L_0x007f;
                case 54: goto L_0x007f;
                case 55: goto L_0x007f;
                case 56: goto L_0x007f;
                case 57: goto L_0x007f;
                default: goto L_0x0095;
            }
        L_0x0095:
            char r5 = r15.f59648a
            if (r5 == r8) goto L_0x009c
            if (r5 == r6) goto L_0x009c
            goto L_0x00e2
        L_0x009c:
            char r5 = r15.mo175842d()
            r15.f59648a = r5
            if (r5 == r2) goto L_0x00ae
            if (r5 == r1) goto L_0x00ad
            switch(r5) {
                case 48: goto L_0x00bb;
                case 49: goto L_0x00bb;
                case 50: goto L_0x00bb;
                case 51: goto L_0x00bb;
                case 52: goto L_0x00bb;
                case 53: goto L_0x00bb;
                case 54: goto L_0x00bb;
                case 55: goto L_0x00bb;
                case 56: goto L_0x00bb;
                case 57: goto L_0x00bb;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            r15.mo175839a(r5)
            return r10
        L_0x00ad:
            r3 = 0
        L_0x00ae:
            char r1 = r15.mo175842d()
            r15.f59648a = r1
            switch(r1) {
                case 48: goto L_0x00bb;
                case 49: goto L_0x00bb;
                case 50: goto L_0x00bb;
                case 51: goto L_0x00bb;
                case 52: goto L_0x00bb;
                case 53: goto L_0x00bb;
                case 54: goto L_0x00bb;
                case 55: goto L_0x00bb;
                case 56: goto L_0x00bb;
                case 57: goto L_0x00bb;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            r15.mo175839a(r1)
            return r10
        L_0x00bb:
            char r1 = r15.f59648a
            switch(r1) {
                case 48: goto L_0x00c1;
                case 49: goto L_0x00cb;
                case 50: goto L_0x00cb;
                case 51: goto L_0x00cb;
                case 52: goto L_0x00cb;
                case 53: goto L_0x00cb;
                case 54: goto L_0x00cb;
                case 55: goto L_0x00cb;
                case 56: goto L_0x00cb;
                case 57: goto L_0x00cb;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            goto L_0x00e2
        L_0x00c1:
            char r1 = r15.mo175842d()
            r15.f59648a = r1
            switch(r1) {
                case 48: goto L_0x00c1;
                case 49: goto L_0x00cb;
                case 50: goto L_0x00cb;
                case 51: goto L_0x00cb;
                case 52: goto L_0x00cb;
                case 53: goto L_0x00cb;
                case 54: goto L_0x00cb;
                case 55: goto L_0x00cb;
                case 56: goto L_0x00cb;
                case 57: goto L_0x00cb;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            goto L_0x00e2
        L_0x00cb:
            r1 = 0
        L_0x00cc:
            r2 = 3
            if (r4 >= r2) goto L_0x00d8
            int r4 = r4 + 1
            int r1 = r1 * 10
            char r2 = r15.f59648a
            int r2 = r2 + -48
            int r1 = r1 + r2
        L_0x00d8:
            char r2 = r15.mo175842d()
            r15.f59648a = r2
            switch(r2) {
                case 48: goto L_0x00cc;
                case 49: goto L_0x00cc;
                case 50: goto L_0x00cc;
                case 51: goto L_0x00cc;
                case 52: goto L_0x00cc;
                case 53: goto L_0x00cc;
                case 54: goto L_0x00cc;
                case 55: goto L_0x00cc;
                case 56: goto L_0x00cc;
                case 57: goto L_0x00cc;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            r4 = r1
        L_0x00e2:
            if (r3 != 0) goto L_0x00e5
            int r4 = -r4
        L_0x00e5:
            int r4 = r4 + r11
            if (r0 != 0) goto L_0x00e9
            int r12 = -r12
        L_0x00e9:
            float r0 = m42145a(r12, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21368m0.mo175841c():float");
    }

    /* renamed from: d */
    public final char mo175842d() {
        int i = this.f59650c;
        int i2 = this.f59651d;
        if (i < i2) {
            this.f59650c = i + 1;
        }
        int i3 = this.f59650c;
        if (i3 == i2) {
            return 0;
        }
        return this.f59649b.charAt(i3);
    }

    /* renamed from: e */
    public void mo175843e() {
        while (true) {
            int i = this.f59650c;
            if (i < this.f59651d) {
                char charAt = this.f59649b.charAt(i);
                if (charAt == 9 || charAt == 10 || charAt == ' ' || charAt == ',') {
                    mo175838a();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    public void mo175844f() {
        while (true) {
            int i = this.f59650c;
            if (i < this.f59651d && Character.isWhitespace(this.f59649b.charAt(i))) {
                mo175838a();
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo175839a(char c) {
        throw new RuntimeException("Unexpected char '" + c + "'.");
    }

    /* renamed from: a */
    public static float m42145a(int i, int i2) {
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        if (i2 == 0) {
            return (float) i;
        }
        if (i >= 67108864) {
            i++;
        }
        return (float) (i2 > 0 ? ((double) i) * f59647e[i2] : ((double) i) / f59647e[-i2]);
    }
}
