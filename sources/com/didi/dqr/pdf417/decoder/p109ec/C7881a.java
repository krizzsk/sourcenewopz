package com.didi.dqr.pdf417.decoder.p109ec;

/* renamed from: com.didi.dqr.pdf417.decoder.ec.a */
/* compiled from: ModulusPoly */
final class C7881a {

    /* renamed from: a */
    private final ModulusGF f18947a;

    /* renamed from: b */
    private final int[] f18948b;

    C7881a(ModulusGF modulusGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f18947a = modulusGF;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f18948b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f18948b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.f18948b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo58528a() {
        return this.f18948b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58529b() {
        return this.f18948b.length - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo58534c() {
        return this.f18948b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58525a(int i) {
        int[] iArr = this.f18948b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58530b(int i) {
        if (i == 0) {
            return mo58525a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b : this.f18948b) {
                i2 = this.f18947a.mo58519b(i2, b);
            }
            return i2;
        }
        int[] iArr = this.f18948b;
        int i3 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            ModulusGF modulusGF = this.f18947a;
            i3 = modulusGF.mo58519b(modulusGF.mo58524d(i, i3), this.f18948b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7881a mo58527a(C7881a aVar) {
        if (!this.f18947a.equals(aVar.f18947a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (mo58534c()) {
            return aVar;
        } else {
            if (aVar.mo58534c()) {
                return this;
            }
            int[] iArr = this.f18948b;
            int[] iArr2 = aVar.f18948b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = this.f18947a.mo58519b(iArr2[i - length], iArr[i]);
            }
            return new C7881a(this.f18947a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C7881a mo58531b(C7881a aVar) {
        if (!this.f18947a.equals(aVar.f18947a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (aVar.mo58534c()) {
            return this;
        } else {
            return mo58527a(aVar.mo58535d());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C7881a mo58533c(C7881a aVar) {
        if (!this.f18947a.equals(aVar.f18947a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (mo58534c() || aVar.mo58534c()) {
            return this.f18947a.mo58516a();
        } else {
            int[] iArr = this.f18948b;
            int length = iArr.length;
            int[] iArr2 = aVar.f18948b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    ModulusGF modulusGF = this.f18947a;
                    iArr3[i4] = modulusGF.mo58519b(iArr3[i4], modulusGF.mo58524d(i2, iArr2[i3]));
                }
            }
            return new C7881a(this.f18947a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C7881a mo58535d() {
        int length = this.f18948b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f18947a.mo58523c(0, this.f18948b[i]);
        }
        return new C7881a(this.f18947a, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C7881a mo58532c(int i) {
        if (i == 0) {
            return this.f18947a.mo58516a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f18948b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f18947a.mo58524d(this.f18948b[i2], i);
        }
        return new C7881a(this.f18947a, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7881a mo58526a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f18947a.mo58516a();
        } else {
            int length = this.f18948b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f18947a.mo58524d(this.f18948b[i3], i2);
            }
            return new C7881a(this.f18947a, iArr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo58529b() * 8);
        for (int b = mo58529b(); b >= 0; b--) {
            int a = mo58525a(b);
            if (a != 0) {
                if (a < 0) {
                    sb.append(" - ");
                    a = -a;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a != 1) {
                    sb.append(a);
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
