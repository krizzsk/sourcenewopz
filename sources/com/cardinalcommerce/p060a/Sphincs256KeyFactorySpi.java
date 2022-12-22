package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.CipherSpi;
import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;

/* renamed from: com.cardinalcommerce.a.Sphincs256KeyFactorySpi */
public final class Sphincs256KeyFactorySpi extends DHParameterSpec {
    public final BigInteger Cardinal;

    /* renamed from: a */
    private final BigInteger f2481a;

    /* renamed from: b */
    private final int f2482b;

    /* renamed from: c */
    private CipherSpi.NoPadding f2483c;

    public Sphincs256KeyFactorySpi(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, 0, 0);
    }

    private Sphincs256KeyFactorySpi(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, int i2) {
        super(bigInteger, bigInteger3, i2);
        this.Cardinal = bigInteger2;
        this.f2481a = bigInteger4;
        this.f2482b = i;
    }

    public final CipherSpi init() {
        return new CipherSpi(getP(), getG(), this.Cardinal, this.f2482b, getL(), this.f2481a, this.f2483c);
    }

    public Sphincs256KeyFactorySpi(CipherSpi cipherSpi) {
        this(cipherSpi.Cardinal, cipherSpi.getInstance, cipherSpi.configure, cipherSpi.cca_continue, cipherSpi.init, cipherSpi.getSDKVersion);
        this.f2483c = cipherSpi.getWarnings;
    }
}
