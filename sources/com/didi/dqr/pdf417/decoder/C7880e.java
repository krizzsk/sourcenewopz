package com.didi.dqr.pdf417.decoder;

/* renamed from: com.didi.dqr.pdf417.decoder.e */
/* compiled from: DetectionResult */
final class C7880e {

    /* renamed from: a */
    private static final int f18936a = 2;

    /* renamed from: b */
    private final C7876a f18937b;

    /* renamed from: c */
    private final C7882f[] f18938c;

    /* renamed from: d */
    private C7878c f18939d;

    /* renamed from: e */
    private final int f18940e;

    C7880e(C7876a aVar, C7878c cVar) {
        this.f18937b = aVar;
        int a = aVar.mo58477a();
        this.f18940e = a;
        this.f18939d = cVar;
        this.f18938c = new C7882f[(a + 2)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7882f[] mo58508a() {
        m14104a(this.f18938c[0]);
        m14104a(this.f18938c[this.f18940e + 1]);
        int i = 928;
        while (true) {
            int f = m14106f();
            if (f > 0 && f < i) {
                i = f;
            }
        }
        return this.f18938c;
    }

    /* renamed from: a */
    private void m14104a(C7882f fVar) {
        if (fVar != null) {
            ((C7883g) fVar).mo58544a(this.f18937b);
        }
    }

    /* renamed from: f */
    private int m14106f() {
        int g = m14107g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.f18940e + 1; i++) {
            C7879d[] b = this.f18938c[i].mo58541b();
            for (int i2 = 0; i2 < b.length; i2++) {
                if (b[i2] != null && !b[i2].mo58494a()) {
                    m14103a(i, i2, b);
                }
            }
        }
        return g;
    }

    /* renamed from: g */
    private int m14107g() {
        m14108h();
        return m14110j() + m14109i();
    }

    /* renamed from: h */
    private void m14108h() {
        C7882f[] fVarArr = this.f18938c;
        if (fVarArr[0] != null && fVarArr[this.f18940e + 1] != null) {
            C7879d[] b = fVarArr[0].mo58541b();
            C7879d[] b2 = this.f18938c[this.f18940e + 1].mo58541b();
            for (int i = 0; i < b.length; i++) {
                if (!(b[i] == null || b2[i] == null || b[i].mo58503h() != b2[i].mo58503h())) {
                    for (int i2 = 1; i2 <= this.f18940e; i2++) {
                        C7879d dVar = this.f18938c[i2].mo58541b()[i];
                        if (dVar != null) {
                            dVar.mo58497b(b[i].mo58503h());
                            if (!dVar.mo58494a()) {
                                this.f18938c[i2].mo58541b()[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private int m14109i() {
        C7882f[] fVarArr = this.f18938c;
        int i = this.f18940e;
        if (fVarArr[i + 1] == null) {
            return 0;
        }
        C7879d[] b = fVarArr[i + 1].mo58541b();
        int i2 = 0;
        for (int i3 = 0; i3 < b.length; i3++) {
            if (b[i3] != null) {
                int h = b[i3].mo58503h();
                int i4 = 0;
                for (int i5 = this.f18940e + 1; i5 > 0 && i4 < 2; i5--) {
                    C7879d dVar = this.f18938c[i5].mo58541b()[i3];
                    if (dVar != null) {
                        i4 = m14102a(h, i4, dVar);
                        if (!dVar.mo58494a()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: j */
    private int m14110j() {
        C7882f[] fVarArr = this.f18938c;
        if (fVarArr[0] == null) {
            return 0;
        }
        C7879d[] b = fVarArr[0].mo58541b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].mo58503h();
                int i3 = 0;
                for (int i4 = 1; i4 < this.f18940e + 1 && i3 < 2; i4++) {
                    C7879d dVar = this.f18938c[i4].mo58541b()[i2];
                    if (dVar != null) {
                        i3 = m14102a(h, i3, dVar);
                        if (!dVar.mo58494a()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private static int m14102a(int i, int i2, C7879d dVar) {
        if (dVar == null || dVar.mo58494a()) {
            return i2;
        }
        if (!dVar.mo58495a(i)) {
            return i2 + 1;
        }
        dVar.mo58497b(i);
        return 0;
    }

    /* renamed from: a */
    private void m14103a(int i, int i2, C7879d[] dVarArr) {
        C7879d dVar = dVarArr[i2];
        C7879d[] b = this.f18938c[i - 1].mo58541b();
        C7882f[] fVarArr = this.f18938c;
        int i3 = i + 1;
        C7879d[] b2 = fVarArr[i3] != null ? fVarArr[i3].mo58541b() : b;
        C7879d[] dVarArr2 = new C7879d[14];
        dVarArr2[2] = b[i2];
        dVarArr2[3] = b2[i2];
        int i4 = 0;
        if (i2 > 0) {
            int i5 = i2 - 1;
            dVarArr2[0] = dVarArr[i5];
            dVarArr2[4] = b[i5];
            dVarArr2[5] = b2[i5];
        }
        if (i2 > 1) {
            int i6 = i2 - 2;
            dVarArr2[8] = dVarArr[i6];
            dVarArr2[10] = b[i6];
            dVarArr2[11] = b2[i6];
        }
        if (i2 < dVarArr.length - 1) {
            int i7 = i2 + 1;
            dVarArr2[1] = dVarArr[i7];
            dVarArr2[6] = b[i7];
            dVarArr2[7] = b2[i7];
        }
        if (i2 < dVarArr.length - 2) {
            int i8 = i2 + 2;
            dVarArr2[9] = dVarArr[i8];
            dVarArr2[12] = b[i8];
            dVarArr2[13] = b2[i8];
        }
        while (i4 < 14 && !m14105a(dVar, dVarArr2[i4])) {
            i4++;
        }
    }

    /* renamed from: a */
    private static boolean m14105a(C7879d dVar, C7879d dVar2) {
        if (dVar2 == null || !dVar2.mo58494a() || dVar2.mo58501f() != dVar.mo58501f()) {
            return false;
        }
        dVar.mo58497b(dVar2.mo58503h());
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58509b() {
        return this.f18940e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58510c() {
        return this.f18937b.mo58479c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo58511d() {
        return this.f18937b.mo58478b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58507a(C7878c cVar) {
        this.f18939d = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C7878c mo58512e() {
        return this.f18939d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58506a(int i, C7882f fVar) {
        this.f18938c[i] = fVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7882f mo58505a(int i) {
        return this.f18938c[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0085, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0086, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r10 = this;
            com.didi.dqr.pdf417.decoder.f[] r0 = r10.f18938c
            r1 = 0
            r2 = r0[r1]
            r3 = 1
            if (r2 != 0) goto L_0x000d
            int r2 = r10.f18940e
            int r2 = r2 + r3
            r2 = r0[r2]
        L_0x000d:
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r4 = 0
        L_0x0013:
            com.didi.dqr.pdf417.decoder.d[] r5 = r2.mo58541b()     // Catch:{ all -> 0x007e }
            int r5 = r5.length     // Catch:{ all -> 0x007e }
            if (r4 >= r5) goto L_0x0076
            java.lang.String r5 = "CW %3d:"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x007e }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007e }
            r6[r1] = r7     // Catch:{ all -> 0x007e }
            r0.format(r5, r6)     // Catch:{ all -> 0x007e }
            r5 = 0
        L_0x0028:
            int r6 = r10.f18940e     // Catch:{ all -> 0x007e }
            r7 = 2
            int r6 = r6 + r7
            if (r5 >= r6) goto L_0x006c
            com.didi.dqr.pdf417.decoder.f[] r6 = r10.f18938c     // Catch:{ all -> 0x007e }
            r6 = r6[r5]     // Catch:{ all -> 0x007e }
            java.lang.String r8 = "    |   "
            if (r6 != 0) goto L_0x003c
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            r0.format(r8, r6)     // Catch:{ all -> 0x007e }
            goto L_0x0069
        L_0x003c:
            com.didi.dqr.pdf417.decoder.f[] r6 = r10.f18938c     // Catch:{ all -> 0x007e }
            r6 = r6[r5]     // Catch:{ all -> 0x007e }
            com.didi.dqr.pdf417.decoder.d[] r6 = r6.mo58541b()     // Catch:{ all -> 0x007e }
            r6 = r6[r4]     // Catch:{ all -> 0x007e }
            if (r6 != 0) goto L_0x004e
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            r0.format(r8, r6)     // Catch:{ all -> 0x007e }
            goto L_0x0069
        L_0x004e:
            java.lang.String r8 = " %3d|%3d"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x007e }
            int r9 = r6.mo58503h()     // Catch:{ all -> 0x007e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x007e }
            r7[r1] = r9     // Catch:{ all -> 0x007e }
            int r6 = r6.mo58502g()     // Catch:{ all -> 0x007e }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x007e }
            r7[r3] = r6     // Catch:{ all -> 0x007e }
            r0.format(r8, r7)     // Catch:{ all -> 0x007e }
        L_0x0069:
            int r5 = r5 + 1
            goto L_0x0028
        L_0x006c:
            java.lang.String r5 = "%n"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            r0.format(r5, r6)     // Catch:{ all -> 0x007e }
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0076:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x007e }
            r0.close()
            return r1
        L_0x007e:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0089:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.C7880e.toString():java.lang.String");
    }
}
