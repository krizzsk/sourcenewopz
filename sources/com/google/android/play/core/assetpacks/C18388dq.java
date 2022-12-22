package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.dq */
final class C18388dq {

    /* renamed from: a */
    private final int f53043a;

    /* renamed from: b */
    private final String f53044b;

    /* renamed from: c */
    private final long f53045c;

    /* renamed from: d */
    private final long f53046d;

    /* renamed from: e */
    private final int f53047e;

    C18388dq() {
    }

    C18388dq(int i, String str, long j, long j2, int i2) {
        this();
        this.f53043a = i;
        this.f53044b = str;
        this.f53045c = j;
        this.f53046d = j2;
        this.f53047e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo149015a() {
        return this.f53043a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo149016b() {
        return this.f53044b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo149017c() {
        return this.f53045c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo149018d() {
        return this.f53046d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo149019e() {
        return this.f53047e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r7.f53044b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.C18388dq
            r2 = 0
            if (r1 == 0) goto L_0x0046
            com.google.android.play.core.assetpacks.dq r8 = (com.google.android.play.core.assetpacks.C18388dq) r8
            int r1 = r7.f53043a
            int r3 = r8.mo149015a()
            if (r1 != r3) goto L_0x0046
            java.lang.String r1 = r7.f53044b
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r8.mo149016b()
            if (r1 != 0) goto L_0x0046
            goto L_0x0029
        L_0x001e:
            java.lang.String r3 = r8.mo149016b()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0029
            goto L_0x0046
        L_0x0029:
            long r3 = r7.f53045c
            long r5 = r8.mo149017c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            long r3 = r7.f53046d
            long r5 = r8.mo149018d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            int r1 = r7.f53047e
            int r8 = r8.mo149019e()
            if (r1 != r8) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C18388dq.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.f53043a ^ 1000003) * 1000003;
        String str = this.f53044b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f53045c;
        long j2 = this.f53046d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f53047e;
    }

    public String toString() {
        int i = this.f53043a;
        String str = this.f53044b;
        long j = this.f53045c;
        long j2 = this.f53046d;
        int i2 = this.f53047e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
