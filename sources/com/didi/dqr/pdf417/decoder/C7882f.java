package com.didi.dqr.pdf417.decoder;

/* renamed from: com.didi.dqr.pdf417.decoder.f */
/* compiled from: DetectionResultColumn */
class C7882f {

    /* renamed from: a */
    private static final int f18949a = 5;

    /* renamed from: b */
    private final C7878c f18950b;

    /* renamed from: c */
    private final C7879d[] f18951c;

    C7882f(C7878c cVar) {
        this.f18950b = new C7878c(cVar);
        this.f18951c = new C7879d[((cVar.mo58489d() - cVar.mo58488c()) + 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C7879d mo58538a(int i) {
        C7879d dVar;
        C7879d dVar2;
        C7879d c = mo58542c(i);
        if (c != null) {
            return c;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int b = mo58540b(i) - i2;
            if (b >= 0 && (dVar2 = this.f18951c[b]) != null) {
                return dVar2;
            }
            int b2 = mo58540b(i) + i2;
            C7879d[] dVarArr = this.f18951c;
            if (b2 < dVarArr.length && (dVar = dVarArr[b2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo58540b(int i) {
        return i - this.f18950b.mo58488c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo58539a(int i, C7879d dVar) {
        this.f18951c[mo58540b(i)] = dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final C7879d mo58542c(int i) {
        return this.f18951c[mo58540b(i)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C7878c mo58537a() {
        return this.f18950b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C7879d[] mo58541b() {
        return this.f18951c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r11 = this;
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            com.didi.dqr.pdf417.decoder.d[] r1 = r11.f18951c     // Catch:{ all -> 0x0054 }
            int r2 = r1.length     // Catch:{ all -> 0x0054 }
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000b:
            if (r4 >= r2) goto L_0x004c
            r6 = r1[r4]     // Catch:{ all -> 0x0054 }
            r7 = 1
            if (r6 != 0) goto L_0x0023
            java.lang.String r6 = "%3d:    |   %n"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0054 }
            int r8 = r5 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0054 }
            r7[r3] = r5     // Catch:{ all -> 0x0054 }
            r0.format(r6, r7)     // Catch:{ all -> 0x0054 }
            r5 = r8
            goto L_0x0049
        L_0x0023:
            java.lang.String r8 = "%3d: %3d|%3d%n"
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0054 }
            int r10 = r5 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0054 }
            r9[r3] = r5     // Catch:{ all -> 0x0054 }
            int r5 = r6.mo58503h()     // Catch:{ all -> 0x0054 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0054 }
            r9[r7] = r5     // Catch:{ all -> 0x0054 }
            r5 = 2
            int r6 = r6.mo58502g()     // Catch:{ all -> 0x0054 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0054 }
            r9[r5] = r6     // Catch:{ all -> 0x0054 }
            r0.format(r8, r9)     // Catch:{ all -> 0x0054 }
            r5 = r10
        L_0x0049:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x004c:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0054 }
            r0.close()
            return r1
        L_0x0054:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x005f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.C7882f.toString():java.lang.String");
    }
}
