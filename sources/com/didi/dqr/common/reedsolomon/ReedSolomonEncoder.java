package com.didi.dqr.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder {

    /* renamed from: a */
    private final GenericGF f18583a;

    /* renamed from: b */
    private final List<C7834a> f18584b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f18583a = genericGF;
        ArrayList arrayList = new ArrayList();
        this.f18584b = arrayList;
        arrayList.add(new C7834a(genericGF, new int[]{1}));
    }

    /* renamed from: a */
    private C7834a m13748a(int i) {
        if (i >= this.f18584b.size()) {
            List<C7834a> list = this.f18584b;
            C7834a aVar = list.get(list.size() - 1);
            for (int size = this.f18584b.size(); size <= i; size++) {
                GenericGF genericGF = this.f18583a;
                aVar = aVar.mo58297b(new C7834a(genericGF, new int[]{1, genericGF.mo58279a((size - 1) + genericGF.getGeneratorBase())}));
                this.f18584b.add(aVar);
            }
        }
        return this.f18584b.get(i);
    }

    public void encode(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                C7834a a = m13748a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] a2 = new C7834a(this.f18583a, iArr2).mo58292a(i, 1).mo58300c(a)[1].mo58294a();
                int length2 = i - a2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(a2, 0, iArr, length + length2, a2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
