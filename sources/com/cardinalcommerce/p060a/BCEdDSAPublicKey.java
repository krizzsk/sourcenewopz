package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.BCEdDSAPublicKey */
public final class BCEdDSAPublicKey implements KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo {

    /* renamed from: e */
    private static final BigInteger f2284e = BigInteger.valueOf(0);

    /* renamed from: f */
    private static final BigInteger f2285f = BigInteger.valueOf(1);

    /* renamed from: g */
    private static final BigInteger f2286g = BigInteger.valueOf(2);

    /* renamed from: a */
    private DigestSignatureSpi.SHA3_224 f2287a;

    /* renamed from: b */
    private SecureRandom f2288b;

    /* renamed from: c */
    private boolean f2289c;

    /* renamed from: d */
    private int f2290d;

    public final int configure() {
        return this.f2289c ? ((this.f2290d + 7) / 8) * 2 : (this.f2290d - 1) / 8;
    }

    public final int getInstance() {
        return this.f2289c ? (this.f2290d - 1) / 8 : ((this.f2290d + 7) / 8) * 2;
    }

    public final void Cardinal(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        SecureRandom secureRandom;
        if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
            ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
            this.f2287a = (DigestSignatureSpi.SHA3_224) sHA224WithRSAEncryption.getInstance;
            secureRandom = sHA224WithRSAEncryption.configure;
        } else {
            this.f2287a = (DigestSignatureSpi.SHA3_224) eCKAEGwithSHA512KDF;
            secureRandom = KeyAgreementSpi.MQV.cca_continue();
        }
        this.f2288b = secureRandom;
        this.f2289c = z;
        this.f2290d = this.f2287a.configure.init.bitLength();
        if (z) {
            if (!(this.f2287a instanceof DigestSignatureSpi.SHA384)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(this.f2287a instanceof DigestSignatureSpi.SHA3_256)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    public final byte[] Cardinal(byte[] bArr, int i, int i2) {
        int i3;
        BigInteger configure;
        if (this.f2287a != null) {
            boolean z = this.f2289c;
            if (z) {
                i3 = ((this.f2290d - 1) + 7) / 8;
            } else {
                i3 = z ? (this.f2290d - 1) / 8 : ((this.f2290d + 7) / 8) * 2;
            }
            if (i2 <= i3) {
                BigInteger bigInteger = this.f2287a.configure.init;
                if (this.f2287a instanceof DigestSignatureSpi.SHA3_256) {
                    int i4 = i2 / 2;
                    byte[] bArr2 = new byte[i4];
                    byte[] bArr3 = new byte[i4];
                    System.arraycopy(bArr, i, bArr2, 0, i4);
                    System.arraycopy(bArr, i + i4, bArr3, 0, i4);
                    return setSelected.cca_continue(new BigInteger(1, bArr2).modPow(bigInteger.subtract(f2285f).subtract(((DigestSignatureSpi.SHA3_256) this.f2287a).cca_continue), bigInteger).multiply(new BigInteger(1, bArr3)).mod(bigInteger));
                }
                if (!(i == 0 && i2 == bArr.length)) {
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(bArr, i, bArr4, 0, i2);
                    bArr = bArr4;
                }
                BigInteger bigInteger2 = new BigInteger(1, bArr);
                if (bigInteger2.compareTo(bigInteger) < 0) {
                    DigestSignatureSpi.SHA384 sha384 = (DigestSignatureSpi.SHA384) this.f2287a;
                    int bitLength = bigInteger.bitLength();
                    while (true) {
                        configure = setSelected.configure(bitLength, this.f2288b);
                        if (!configure.equals(f2284e) && configure.compareTo(bigInteger.subtract(f2286g)) <= 0) {
                            break;
                        }
                    }
                    BigInteger modPow = this.f2287a.configure.configure.modPow(configure, bigInteger);
                    BigInteger mod = bigInteger2.multiply(sha384.Cardinal.modPow(configure, bigInteger)).mod(bigInteger);
                    byte[] byteArray = modPow.toByteArray();
                    byte[] byteArray2 = mod.toByteArray();
                    int i5 = this.f2289c ? ((this.f2290d + 7) / 8) * 2 : (this.f2290d - 1) / 8;
                    byte[] bArr5 = new byte[i5];
                    int i6 = i5 / 2;
                    if (byteArray.length > i6) {
                        System.arraycopy(byteArray, 1, bArr5, i6 - (byteArray.length - 1), byteArray.length - 1);
                    } else {
                        System.arraycopy(byteArray, 0, bArr5, i6 - byteArray.length, byteArray.length);
                    }
                    if (byteArray2.length > i6) {
                        System.arraycopy(byteArray2, 1, bArr5, i5 - (byteArray2.length - 1), byteArray2.length - 1);
                    } else {
                        System.arraycopy(byteArray2, 0, bArr5, i5 - byteArray2.length, byteArray2.length);
                    }
                    return bArr5;
                }
                throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input too large for ElGamal cipher.\n");
            }
            throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input too large for ElGamal cipher.\n");
        }
        throw new IllegalStateException("ElGamal engine not initialised");
    }
}
