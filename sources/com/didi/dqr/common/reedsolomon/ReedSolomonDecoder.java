package com.didi.dqr.common.reedsolomon;

public final class ReedSolomonDecoder {

    /* renamed from: a */
    private final GenericGF f18582a;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.f18582a = genericGF;
    }

    public void decode(int[] iArr, int i) throws ReedSolomonException {
        C7834a aVar = new C7834a(this.f18582a, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < i; i3++) {
            GenericGF genericGF = this.f18582a;
            int b = aVar.mo58296b(genericGF.mo58279a(genericGF.getGeneratorBase() + i3));
            iArr2[(i - 1) - i3] = b;
            if (b != 0) {
                z = false;
            }
        }
        if (!z) {
            C7834a[] a = m13747a(this.f18582a.mo58281a(i, 1), new C7834a(this.f18582a, iArr2), i);
            C7834a aVar2 = a[0];
            C7834a aVar3 = a[1];
            int[] a2 = m13745a(aVar2);
            int[] a3 = m13746a(aVar3, a2);
            while (i2 < a2.length) {
                int length = (iArr.length - 1) - this.f18582a.mo58282b(a2[i2]);
                if (length >= 0) {
                    iArr[length] = GenericGF.m13737b(iArr[length], a3[i2]);
                    i2++;
                } else {
                    throw new ReedSolomonException("Bad error location");
                }
            }
        }
    }

    /* renamed from: a */
    private C7834a[] m13747a(C7834a aVar, C7834a aVar2, int i) throws ReedSolomonException {
        if (aVar.mo58295b() < aVar2.mo58295b()) {
            C7834a aVar3 = aVar2;
            aVar2 = aVar;
            aVar = aVar3;
        }
        C7834a a = this.f18582a.mo58280a();
        C7834a b = this.f18582a.mo58283b();
        do {
            C7834a aVar4 = r11;
            r11 = aVar;
            aVar = aVar4;
            C7834a aVar5 = b;
            C7834a aVar6 = a;
            a = aVar5;
            if (aVar.mo58295b() < i / 2) {
                int a2 = a.mo58291a(0);
                if (a2 != 0) {
                    int c = this.f18582a.mo58284c(a2);
                    return new C7834a[]{a.mo58298c(c), aVar.mo58298c(c)};
                }
                throw new ReedSolomonException("sigmaTilde(0) was zero");
            } else if (!aVar.mo58299c()) {
                C7834a a3 = this.f18582a.mo58280a();
                int c2 = this.f18582a.mo58284c(aVar.mo58291a(aVar.mo58295b()));
                while (r11.mo58295b() >= aVar.mo58295b() && !r11.mo58299c()) {
                    int b2 = r11.mo58295b() - aVar.mo58295b();
                    int c3 = this.f18582a.mo58285c(r11.mo58291a(r11.mo58295b()), c2);
                    a3 = a3.mo58293a(this.f18582a.mo58281a(b2, c3));
                    r11 = r11.mo58293a(aVar.mo58292a(b2, c3));
                }
                b = a3.mo58297b(a).mo58293a(aVar6);
            } else {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
        } while (r11.mo58295b() < aVar.mo58295b());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    /* renamed from: a */
    private int[] m13745a(C7834a aVar) throws ReedSolomonException {
        int b = aVar.mo58295b();
        int i = 0;
        if (b == 1) {
            return new int[]{aVar.mo58291a(1)};
        }
        int[] iArr = new int[b];
        for (int i2 = 1; i2 < this.f18582a.getSize() && i < b; i2++) {
            if (aVar.mo58296b(i2) == 0) {
                iArr[i] = this.f18582a.mo58284c(i2);
                i++;
            }
        }
        if (i == b) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    /* renamed from: a */
    private int[] m13746a(C7834a aVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f18582a.mo58284c(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int c2 = this.f18582a.mo58285c(iArr[i3], c);
                    i2 = this.f18582a.mo58285c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                }
            }
            iArr2[i] = this.f18582a.mo58285c(aVar.mo58296b(c), this.f18582a.mo58284c(i2));
            if (this.f18582a.getGeneratorBase() != 0) {
                iArr2[i] = this.f18582a.mo58285c(iArr2[i], c);
            }
        }
        return iArr2;
    }
}
