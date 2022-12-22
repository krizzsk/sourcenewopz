package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.removeParam */
final class removeParam implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    boolean Cardinal = false;
    boolean cca_continue = false;
    boolean getInstance = false;

    removeParam() {
    }

    /* access modifiers changed from: package-private */
    public final boolean cca_continue() {
        return this.cca_continue;
    }

    /* access modifiers changed from: package-private */
    public final boolean configure() {
        return this.getInstance;
    }

    /* access modifiers changed from: package-private */
    public final boolean getInstance() {
        return this.Cardinal;
    }
}
