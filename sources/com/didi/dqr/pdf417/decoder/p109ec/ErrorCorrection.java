package com.didi.dqr.pdf417.decoder.p109ec;

import com.didi.dqr.ChecksumException;

/* renamed from: com.didi.dqr.pdf417.decoder.ec.ErrorCorrection */
public final class ErrorCorrection {

    /* renamed from: a */
    private final ModulusGF f18941a = ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        C7881a aVar = new C7881a(this.f18941a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        boolean z = false;
        for (int i3 = i; i3 > 0; i3--) {
            int b = aVar.mo58530b(this.f18941a.mo58515a(i3));
            iArr3[i - i3] = b;
            if (b != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        C7881a b2 = this.f18941a.mo58520b();
        if (iArr2 != null) {
            for (int length : iArr2) {
                int a = this.f18941a.mo58515a((iArr.length - 1) - length);
                ModulusGF modulusGF = this.f18941a;
                b2 = b2.mo58533c(new C7881a(modulusGF, new int[]{modulusGF.mo58523c(0, a), 1}));
            }
        }
        C7881a[] a2 = m14121a(this.f18941a.mo58517a(i, 1), new C7881a(this.f18941a, iArr3), i);
        C7881a aVar2 = a2[0];
        C7881a aVar3 = a2[1];
        int[] a3 = m14119a(aVar2);
        int[] a4 = m14120a(aVar3, aVar2, a3);
        while (i2 < a3.length) {
            int length2 = (iArr.length - 1) - this.f18941a.mo58518b(a3[i2]);
            if (length2 >= 0) {
                iArr[length2] = this.f18941a.mo58523c(iArr[length2], a4[i2]);
                i2++;
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
        return a3.length;
    }

    /* renamed from: a */
    private C7881a[] m14121a(C7881a aVar, C7881a aVar2, int i) throws ChecksumException {
        if (aVar.mo58529b() < aVar2.mo58529b()) {
            C7881a aVar3 = aVar2;
            aVar2 = aVar;
            aVar = aVar3;
        }
        C7881a a = this.f18941a.mo58516a();
        C7881a b = this.f18941a.mo58520b();
        while (true) {
            C7881a aVar4 = r11;
            r11 = aVar;
            aVar = aVar4;
            C7881a aVar5 = b;
            C7881a aVar6 = a;
            a = aVar5;
            if (aVar.mo58529b() < i / 2) {
                int a2 = a.mo58525a(0);
                if (a2 != 0) {
                    int c = this.f18941a.mo58522c(a2);
                    return new C7881a[]{a.mo58532c(c), aVar.mo58532c(c)};
                }
                throw ChecksumException.getChecksumInstance();
            } else if (!aVar.mo58534c()) {
                C7881a a3 = this.f18941a.mo58516a();
                int c2 = this.f18941a.mo58522c(aVar.mo58525a(aVar.mo58529b()));
                while (r11.mo58529b() >= aVar.mo58529b() && !r11.mo58534c()) {
                    int b2 = r11.mo58529b() - aVar.mo58529b();
                    int d = this.f18941a.mo58524d(r11.mo58525a(r11.mo58529b()), c2);
                    a3 = a3.mo58527a(this.f18941a.mo58517a(b2, d));
                    r11 = r11.mo58531b(aVar.mo58526a(b2, d));
                }
                b = a3.mo58533c(a).mo58531b(aVar6).mo58535d();
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    /* renamed from: a */
    private int[] m14119a(C7881a aVar) throws ChecksumException {
        int b = aVar.mo58529b();
        int[] iArr = new int[b];
        int i = 0;
        for (int i2 = 1; i2 < this.f18941a.mo58521c() && i < b; i2++) {
            if (aVar.mo58530b(i2) == 0) {
                iArr[i] = this.f18941a.mo58522c(i2);
                i++;
            }
        }
        if (i == b) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    /* renamed from: a */
    private int[] m14120a(C7881a aVar, C7881a aVar2, int[] iArr) {
        int b = aVar2.mo58529b();
        int[] iArr2 = new int[b];
        for (int i = 1; i <= b; i++) {
            iArr2[b - i] = this.f18941a.mo58524d(i, aVar2.mo58525a(i));
        }
        C7881a aVar3 = new C7881a(this.f18941a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int c = this.f18941a.mo58522c(iArr[i2]);
            iArr3[i2] = this.f18941a.mo58524d(this.f18941a.mo58523c(0, aVar.mo58530b(c)), this.f18941a.mo58522c(aVar3.mo58530b(c)));
        }
        return iArr3;
    }
}
