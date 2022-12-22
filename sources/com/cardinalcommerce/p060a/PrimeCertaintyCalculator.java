package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;

/* renamed from: com.cardinalcommerce.a.PrimeCertaintyCalculator */
public final class PrimeCertaintyCalculator implements KeyFactorySpi.ECMQV {

    /* renamed from: a */
    private final KeyFactorySpi.ECMQV f2473a;

    /* renamed from: b */
    private PSSSignatureSpi.SHA512withRSA f2474b;

    PrimeCertaintyCalculator() {
    }

    public PrimeCertaintyCalculator(KeyFactorySpi.ECMQV ecmqv) {
        this.f2473a = ecmqv;
    }

    public final void getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        this.f2474b = (PSSSignatureSpi.SHA512withRSA) eCKAEGwithSHA512KDF;
    }

    public final int configure() {
        return this.f2473a.configure() << 1;
    }

    public final void configure(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF, byte[] bArr, int i) {
        PSSSignatureSpi.SHA3_512withRSA sHA3_512withRSA = (PSSSignatureSpi.SHA3_512withRSA) eCKAEGwithSHA512KDF;
        this.f2473a.getInstance(this.f2474b.cca_continue);
        this.f2473a.configure(sHA3_512withRSA.init, bArr, i);
        this.f2473a.getInstance(this.f2474b.getInstance);
        this.f2473a.configure(sHA3_512withRSA.getInstance, bArr, i + this.f2473a.configure());
    }
}
