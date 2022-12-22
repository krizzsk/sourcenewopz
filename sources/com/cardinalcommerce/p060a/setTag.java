package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.setTag */
public final class setTag implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public DigestSignatureSpi.MD2 configure;
    public DigestSignatureSpi.MD2 getInstance;

    public setTag() {
    }

    public setTag(DigestSignatureSpi.MD2 md2, DigestSignatureSpi.MD2 md22, DigestSignatureSpi digestSignatureSpi) {
        if (md2 == null) {
            throw new NullPointerException("staticPrivateKey cannot be null");
        } else if (md22 != null) {
            BCRSAPublicKey bCRSAPublicKey = md2.init;
            if (bCRSAPublicKey.equals(md22.init)) {
                new DigestSignatureSpi(bCRSAPublicKey.init.configure(md22.Cardinal), bCRSAPublicKey);
                this.configure = md2;
                this.getInstance = md22;
                return;
            }
            throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
        } else {
            throw new NullPointerException("ephemeralPrivateKey cannot be null");
        }
    }
}
