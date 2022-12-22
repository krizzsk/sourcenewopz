package com.didi.dqr.common.reedsolomon;

/* renamed from: com.didi.dqr.common.reedsolomon.a */
/* compiled from: GenericGFPoly */
final class C7834a {

    /* renamed from: a */
    private final GenericGF f18585a;

    /* renamed from: b */
    private final int[] f18586b;

    C7834a(GenericGF genericGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f18585a = genericGF;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f18586b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f18586b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.f18586b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo58294a() {
        return this.f18586b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58295b() {
        return this.f18586b.length - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo58299c() {
        return this.f18586b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58291a(int i) {
        int[] iArr = this.f18586b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58296b(int i) {
        if (i == 0) {
            return mo58291a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b : this.f18586b) {
                i2 = GenericGF.m13737b(i2, b);
            }
            return i2;
        }
        int[] iArr = this.f18586b;
        int i3 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            i3 = GenericGF.m13737b(this.f18585a.mo58285c(i, i3), this.f18586b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7834a mo58293a(C7834a aVar) {
        if (!this.f18585a.equals(aVar.f18585a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo58299c()) {
            return aVar;
        } else {
            if (aVar.mo58299c()) {
                return this;
            }
            int[] iArr = this.f18586b;
            int[] iArr2 = aVar.f18586b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = GenericGF.m13737b(iArr2[i - length], iArr[i]);
            }
            return new C7834a(this.f18585a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C7834a mo58297b(C7834a aVar) {
        if (!this.f18585a.equals(aVar.f18585a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo58299c() || aVar.mo58299c()) {
            return this.f18585a.mo58280a();
        } else {
            int[] iArr = this.f18586b;
            int length = iArr.length;
            int[] iArr2 = aVar.f18586b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = GenericGF.m13737b(iArr3[i4], this.f18585a.mo58285c(i2, iArr2[i3]));
                }
            }
            return new C7834a(this.f18585a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C7834a mo58298c(int i) {
        if (i == 0) {
            return this.f18585a.mo58280a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f18586b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f18585a.mo58285c(this.f18586b[i2], i);
        }
        return new C7834a(this.f18585a, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7834a mo58292a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f18585a.mo58280a();
        } else {
            int length = this.f18586b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f18585a.mo58285c(this.f18586b[i3], i2);
            }
            return new C7834a(this.f18585a, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C7834a[] mo58300c(C7834a aVar) {
        if (!this.f18585a.equals(aVar.f18585a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!aVar.mo58299c()) {
            C7834a a = this.f18585a.mo58280a();
            int c = this.f18585a.mo58284c(aVar.mo58291a(aVar.mo58295b()));
            C7834a aVar2 = this;
            while (aVar2.mo58295b() >= aVar.mo58295b() && !aVar2.mo58299c()) {
                int b = aVar2.mo58295b() - aVar.mo58295b();
                int c2 = this.f18585a.mo58285c(aVar2.mo58291a(aVar2.mo58295b()), c);
                C7834a a2 = aVar.mo58292a(b, c2);
                a = a.mo58293a(this.f18585a.mo58281a(b, c2));
                aVar2 = aVar2.mo58293a(a2);
            }
            return new C7834a[]{a, aVar2};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo58295b() * 8);
        for (int b = mo58295b(); b >= 0; b--) {
            int a = mo58291a(b);
            if (a != 0) {
                if (a < 0) {
                    sb.append(" - ");
                    a = -a;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a != 1) {
                    int b2 = this.f18585a.mo58282b(a);
                    if (b2 == 0) {
                        sb.append('1');
                    } else if (b2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(b2);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b);
                    }
                }
            }
        }
        return sb.toString();
    }
}
