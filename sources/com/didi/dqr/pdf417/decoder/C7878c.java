package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;

/* renamed from: com.didi.dqr.pdf417.decoder.c */
/* compiled from: BoundingBox */
final class C7878c {

    /* renamed from: a */
    private final BitMatrix f18921a;

    /* renamed from: b */
    private final ResultPoint f18922b;

    /* renamed from: c */
    private final ResultPoint f18923c;

    /* renamed from: d */
    private final ResultPoint f18924d;

    /* renamed from: e */
    private final ResultPoint f18925e;

    /* renamed from: f */
    private final int f18926f;

    /* renamed from: g */
    private final int f18927g;

    /* renamed from: h */
    private final int f18928h;

    /* renamed from: i */
    private final int f18929i;

    C7878c(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z = false;
        boolean z2 = resultPoint == null || resultPoint2 == null;
        z = (resultPoint3 == null || resultPoint4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                resultPoint = new ResultPoint(0.0f, resultPoint3.getY());
                resultPoint2 = new ResultPoint(0.0f, resultPoint4.getY());
            } else if (z) {
                resultPoint3 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint.getY());
                resultPoint4 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint2.getY());
            }
            this.f18921a = bitMatrix;
            this.f18922b = resultPoint;
            this.f18923c = resultPoint2;
            this.f18924d = resultPoint3;
            this.f18925e = resultPoint4;
            this.f18926f = (int) Math.min(resultPoint.getX(), resultPoint2.getX());
            this.f18927g = (int) Math.max(resultPoint3.getX(), resultPoint4.getX());
            this.f18928h = (int) Math.min(resultPoint.getY(), resultPoint3.getY());
            this.f18929i = (int) Math.max(resultPoint2.getY(), resultPoint4.getY());
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    C7878c(C7878c cVar) {
        this.f18921a = cVar.f18921a;
        this.f18922b = cVar.f18922b;
        this.f18923c = cVar.f18923c;
        this.f18924d = cVar.f18924d;
        this.f18925e = cVar.f18925e;
        this.f18926f = cVar.f18926f;
        this.f18927g = cVar.f18927g;
        this.f18928h = cVar.f18928h;
        this.f18929i = cVar.f18929i;
    }

    /* renamed from: a */
    static C7878c m14082a(C7878c cVar, C7878c cVar2) throws NotFoundException {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new C7878c(cVar.f18921a, cVar.f18922b, cVar.f18923c, cVar2.f18924d, cVar2.f18925e);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.dqr.pdf417.decoder.C7878c mo58486a(int r13, int r14, boolean r15) throws com.didi.dqr.NotFoundException {
        /*
            r12 = this;
            com.didi.dqr.ResultPoint r0 = r12.f18922b
            com.didi.dqr.ResultPoint r1 = r12.f18923c
            com.didi.dqr.ResultPoint r2 = r12.f18924d
            com.didi.dqr.ResultPoint r3 = r12.f18925e
            if (r13 <= 0) goto L_0x0029
            if (r15 == 0) goto L_0x000e
            r4 = r0
            goto L_0x000f
        L_0x000e:
            r4 = r2
        L_0x000f:
            float r5 = r4.getY()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x0018
            r5 = 0
        L_0x0018:
            com.didi.dqr.ResultPoint r13 = new com.didi.dqr.ResultPoint
            float r4 = r4.getX()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L_0x0026
            r8 = r13
            goto L_0x002a
        L_0x0026:
            r10 = r13
            r8 = r0
            goto L_0x002b
        L_0x0029:
            r8 = r0
        L_0x002a:
            r10 = r2
        L_0x002b:
            if (r14 <= 0) goto L_0x005b
            if (r15 == 0) goto L_0x0032
            com.didi.dqr.ResultPoint r13 = r12.f18923c
            goto L_0x0034
        L_0x0032:
            com.didi.dqr.ResultPoint r13 = r12.f18925e
        L_0x0034:
            float r0 = r13.getY()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.didi.dqr.common.BitMatrix r14 = r12.f18921a
            int r14 = r14.getHeight()
            if (r0 < r14) goto L_0x004a
            com.didi.dqr.common.BitMatrix r14 = r12.f18921a
            int r14 = r14.getHeight()
            int r0 = r14 + -1
        L_0x004a:
            com.didi.dqr.ResultPoint r14 = new com.didi.dqr.ResultPoint
            float r13 = r13.getX()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L_0x0058
            r9 = r14
            goto L_0x005c
        L_0x0058:
            r11 = r14
            r9 = r1
            goto L_0x005d
        L_0x005b:
            r9 = r1
        L_0x005c:
            r11 = r3
        L_0x005d:
            com.didi.dqr.pdf417.decoder.c r13 = new com.didi.dqr.pdf417.decoder.c
            com.didi.dqr.common.BitMatrix r7 = r12.f18921a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.C7878c.mo58486a(int, int, boolean):com.didi.dqr.pdf417.decoder.c");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58485a() {
        return this.f18926f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58487b() {
        return this.f18927g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58488c() {
        return this.f18928h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo58489d() {
        return this.f18929i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public ResultPoint mo58490e() {
        return this.f18922b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public ResultPoint mo58491f() {
        return this.f18924d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public ResultPoint mo58492g() {
        return this.f18923c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public ResultPoint mo58493h() {
        return this.f18925e;
    }
}
