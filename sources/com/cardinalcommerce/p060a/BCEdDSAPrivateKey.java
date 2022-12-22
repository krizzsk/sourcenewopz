package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.BCEdDSAPrivateKey */
public final class BCEdDSAPrivateKey implements KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo {

    /* renamed from: a */
    private static final BigInteger f2280a = BigInteger.valueOf(1);

    /* renamed from: b */
    private KeyAgreementSpi.X25519withSHA256CKDF f2281b = new KeyAgreementSpi.X25519withSHA256CKDF();

    /* renamed from: c */
    private ISOSignatureSpi.WhirlpoolWithRSAEncryption f2282c;

    /* renamed from: d */
    private SecureRandom f2283d;

    public final int configure() {
        return this.f2281b.Cardinal();
    }

    public final int getInstance() {
        return this.f2281b.init();
    }

    public final void Cardinal(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption;
        SecureRandom cca_continue;
        KeyAgreementSpi.X25519withSHA256CKDF x25519withSHA256CKDF = this.f2281b;
        boolean z2 = eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption;
        if (z2) {
            whirlpoolWithRSAEncryption = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) ((ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF).getInstance;
        } else {
            whirlpoolWithRSAEncryption = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) eCKAEGwithSHA512KDF;
        }
        x25519withSHA256CKDF.init = whirlpoolWithRSAEncryption;
        x25519withSHA256CKDF.configure = z;
        if (z2) {
            ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
            this.f2282c = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) sHA224WithRSAEncryption.getInstance;
            cca_continue = sHA224WithRSAEncryption.configure;
        } else {
            this.f2282c = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) eCKAEGwithSHA512KDF;
            cca_continue = KeyAgreementSpi.MQV.cca_continue();
        }
        this.f2283d = cca_continue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r6 = (com.cardinalcommerce.p060a.PSSSignatureSpi.SHA224withRSA) r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] Cardinal(byte[] r6, int r7, int r8) {
        /*
            r5 = this;
            com.cardinalcommerce.a.ISOSignatureSpi$WhirlpoolWithRSAEncryption r0 = r5.f2282c
            if (r0 == 0) goto L_0x00a1
            com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA256CKDF r0 = r5.f2281b
            int r1 = r0.init()
            r2 = 1
            int r1 = r1 + r2
            java.lang.String r3 = "input too large for RSA cipher."
            if (r8 > r1) goto L_0x009b
            int r1 = r0.init()
            int r1 = r1 + r2
            if (r8 != r1) goto L_0x0022
            boolean r1 = r0.configure
            if (r1 == 0) goto L_0x001c
            goto L_0x0022
        L_0x001c:
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo r6 = new com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo
            r6.<init>(r3)
            throw r6
        L_0x0022:
            if (r7 != 0) goto L_0x0027
            int r1 = r6.length
            if (r8 == r1) goto L_0x002e
        L_0x0027:
            byte[] r1 = new byte[r8]
            r4 = 0
            java.lang.System.arraycopy(r6, r7, r1, r4, r8)
            r6 = r1
        L_0x002e:
            java.math.BigInteger r7 = new java.math.BigInteger
            r7.<init>(r2, r6)
            com.cardinalcommerce.a.ISOSignatureSpi$WhirlpoolWithRSAEncryption r6 = r0.init
            java.math.BigInteger r6 = r6.configure
            int r6 = r7.compareTo(r6)
            if (r6 >= 0) goto L_0x0095
            com.cardinalcommerce.a.ISOSignatureSpi$WhirlpoolWithRSAEncryption r6 = r5.f2282c
            boolean r8 = r6 instanceof com.cardinalcommerce.p060a.PSSSignatureSpi.SHA224withRSA
            if (r8 == 0) goto L_0x0088
            com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA r6 = (com.cardinalcommerce.p060a.PSSSignatureSpi.SHA224withRSA) r6
            java.math.BigInteger r8 = r6.getInstance
            if (r8 == 0) goto L_0x0088
            java.math.BigInteger r6 = r6.configure
            java.math.BigInteger r0 = f2280a
            java.math.BigInteger r1 = r6.subtract(r0)
            java.security.SecureRandom r2 = r5.f2283d
            java.math.BigInteger r0 = com.cardinalcommerce.p060a.setSelected.init(r0, r1, r2)
            java.math.BigInteger r1 = r0.modPow(r8, r6)
            java.math.BigInteger r1 = r1.multiply(r7)
            java.math.BigInteger r1 = r1.mod(r6)
            com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA256CKDF r2 = r5.f2281b
            java.math.BigInteger r1 = r2.cca_continue(r1)
            java.math.BigInteger r0 = r0.modInverse(r6)
            java.math.BigInteger r0 = r1.multiply(r0)
            java.math.BigInteger r0 = r0.mod(r6)
            java.math.BigInteger r6 = r0.modPow(r8, r6)
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0080
            goto L_0x008e
        L_0x0080:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "RSA engine faulty decryption/signing detected"
            r6.<init>(r7)
            throw r6
        L_0x0088:
            com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA256CKDF r6 = r5.f2281b
            java.math.BigInteger r0 = r6.cca_continue(r7)
        L_0x008e:
            com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA256CKDF r6 = r5.f2281b
            byte[] r6 = r6.configure(r0)
            return r6
        L_0x0095:
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo r6 = new com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo
            r6.<init>(r3)
            throw r6
        L_0x009b:
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo r6 = new com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo
            r6.<init>(r3)
            throw r6
        L_0x00a1:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "RSA engine not initialised"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.BCEdDSAPrivateKey.Cardinal(byte[], int, int):byte[]");
    }
}
