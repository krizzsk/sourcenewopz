package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.AlgorithmParameterGeneratorSpi */
public final class AlgorithmParameterGeneratorSpi extends setRequestTimeout {
    public AlgorithmParameterGeneratorSpi(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        int i = this.init ? 96 : 64;
        int i2 = this.cca_continue;
        byte[] bArr = this.getInstance;
        setenabledfsync.cca_continue(i, i2);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
