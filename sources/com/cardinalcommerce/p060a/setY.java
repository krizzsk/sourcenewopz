package com.cardinalcommerce.p060a;

import java.io.Serializable;

/* renamed from: com.cardinalcommerce.a.setY */
public final class setY implements Serializable {
    private final byte[] configure;
    final int init;

    protected setY(int i, byte[] bArr) {
        this.init = i;
        this.configure = bArr;
    }

    public final byte[] getInstance() {
        return setVerticalFadingEdgeEnabled.cca_continue(this.configure);
    }

    /* access modifiers changed from: protected */
    public final setY init() {
        return new setY(this.init, getInstance());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new setY(this.init, getInstance());
    }
}
