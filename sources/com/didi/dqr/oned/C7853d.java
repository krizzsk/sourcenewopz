package com.didi.dqr.oned;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.ReaderException;
import com.didi.dqr.Result;
import com.didi.dqr.common.BitArray;

/* renamed from: com.didi.dqr.oned.d */
/* compiled from: UPCEANExtensionSupport */
final class C7853d {

    /* renamed from: a */
    private static final int[] f18773a = {1, 1, 2};

    /* renamed from: b */
    private final C7851b f18774b = new C7851b();

    /* renamed from: c */
    private final C7852c f18775c = new C7852c();

    C7853d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Result mo58380a(int i, BitArray bitArray, int i2) throws NotFoundException {
        int[] a = UPCEANReader.m13920a(bitArray, i2, false, f18773a);
        try {
            return this.f18775c.mo58379a(i, bitArray, a);
        } catch (ReaderException unused) {
            return this.f18774b.mo58378a(i, bitArray, a);
        }
    }
}
