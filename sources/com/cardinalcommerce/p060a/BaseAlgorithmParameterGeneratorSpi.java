package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.BaseAlgorithmParameterGeneratorSpi */
public final class BaseAlgorithmParameterGeneratorSpi implements KeyFactorySpi.C1979EC {

    /* renamed from: a */
    private DigestSignatureSpi.SHA3_512 f2312a;

    /* renamed from: b */
    private SecureRandom f2313b;

    public final void getInstance(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        if (!z) {
            this.f2312a = (DigestSignatureSpi.SHA3_384) eCKAEGwithSHA512KDF;
        } else if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
            ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
            this.f2313b = sHA224WithRSAEncryption.configure;
            this.f2312a = (DigestSignatureSpi.SHA512_224) sHA224WithRSAEncryption.getInstance;
        } else {
            this.f2313b = KeyAgreementSpi.MQV.cca_continue();
            this.f2312a = (DigestSignatureSpi.SHA512_224) eCKAEGwithSHA512KDF;
        }
    }

    public final BigInteger cca_continue() {
        return this.f2312a.cca_continue.configure;
    }

    public final BigInteger[] configure(byte[] bArr) {
        BigInteger configure;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger = new BigInteger(1, bArr2);
        DigestSignatureSpi.SHA512_256 sha512_256 = this.f2312a.cca_continue;
        do {
            configure = setSelected.configure(sha512_256.configure.bitLength(), this.f2313b);
        } while (configure.compareTo(sha512_256.configure) >= 0);
        BigInteger mod = sha512_256.getInstance.modPow(configure, sha512_256.cca_continue).mod(sha512_256.configure);
        return new BigInteger[]{mod, configure.multiply(bigInteger).add(((DigestSignatureSpi.SHA512_224) this.f2312a).configure.multiply(mod)).mod(sha512_256.configure)};
    }

    public final boolean init(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, bArr2);
        DigestSignatureSpi.SHA512_256 sha512_256 = this.f2312a.cca_continue;
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) >= 0 || sha512_256.configure.compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || sha512_256.configure.compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger modPow = bigInteger3.modPow(sha512_256.configure.subtract(new BigInteger("2")), sha512_256.configure);
        return sha512_256.getInstance.modPow(bigInteger2.multiply(modPow).mod(sha512_256.configure), sha512_256.cca_continue).multiply(((DigestSignatureSpi.SHA3_384) this.f2312a).getInstance.modPow(sha512_256.configure.subtract(bigInteger).multiply(modPow).mod(sha512_256.configure), sha512_256.cca_continue)).mod(sha512_256.cca_continue).mod(sha512_256.configure).equals(bigInteger);
    }
}
