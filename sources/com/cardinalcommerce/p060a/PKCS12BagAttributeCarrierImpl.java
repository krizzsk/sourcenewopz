package com.cardinalcommerce.p060a;

import java.io.ByteArrayOutputStream;

/* renamed from: com.cardinalcommerce.a.PKCS12BagAttributeCarrierImpl */
public final class PKCS12BagAttributeCarrierImpl {
    public final ByteArrayOutputStream configure = new ByteArrayOutputStream();

    public final byte[] Cardinal() {
        return this.configure.toByteArray();
    }

    public final void init(long j) {
        this.configure.write((int) ((j >>> 24) & 255));
        this.configure.write((int) ((j >>> 16) & 255));
        this.configure.write((int) ((j >>> 8) & 255));
        this.configure.write((int) (j & 255));
    }
}
