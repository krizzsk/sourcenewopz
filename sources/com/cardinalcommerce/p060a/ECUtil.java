package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import java.math.BigInteger;
import org.bouncycastle.crypto.signers.PSSSigner;

/* renamed from: com.cardinalcommerce.a.ECUtil */
public final class ECUtil implements KeyPairGeneratorSpi.ECDSA {

    /* renamed from: a */
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo f2429a;

    /* renamed from: b */
    private ISOSignatureSpi.WhirlpoolWithRSAEncryption f2430b;

    /* renamed from: c */
    private int f2431c;

    /* renamed from: d */
    private int f2432d;

    /* renamed from: e */
    private byte[] f2433e;
    public KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo init;

    public ECUtil(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this(dHwithSHA384KDFAndSharedInfo, mQVwithSHA256KDFAndSharedInfo, (byte) 0);
    }

    private ECUtil(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, byte b) {
        this.f2429a = dHwithSHA384KDFAndSharedInfo;
        this.init = mQVwithSHA256KDFAndSharedInfo;
        Integer init2 = X931SignatureSpi.SHA512_256WithRSAEncryption.init(mQVwithSHA256KDFAndSharedInfo);
        if (init2 != null) {
            this.f2431c = init2.intValue();
            return;
        }
        StringBuilder sb = new StringBuilder("no valid trailer for digest: ");
        sb.append(mQVwithSHA256KDFAndSharedInfo.configure());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private void m1812a(int i) {
        int i2;
        int instance = this.init.getInstance();
        if (i == 188) {
            byte[] bArr = this.f2433e;
            i2 = (bArr.length - instance) - 1;
            this.init.configure(bArr, i2);
            byte[] bArr2 = this.f2433e;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr3 = this.f2433e;
            int length = (bArr3.length - instance) - 2;
            this.init.configure(bArr3, length);
            byte[] bArr4 = this.f2433e;
            bArr4[bArr4.length - 2] = (byte) (i >>> 8);
            bArr4[bArr4.length - 1] = (byte) i;
            i2 = length;
        }
        this.f2433e[0] = 107;
        for (int i3 = i2 - 2; i3 != 0; i3--) {
            this.f2433e[i3] = -69;
        }
        this.f2433e[i2 - 1] = -70;
    }

    /* renamed from: a */
    private static void m1813a(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public final void cca_continue(byte[] bArr, int i, int i2) {
        this.init.init(bArr, i, i2);
    }

    public final void init(byte b) {
        this.init.Cardinal(b);
    }

    public final void cca_continue(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) eCKAEGwithSHA512KDF;
        this.f2430b = whirlpoolWithRSAEncryption;
        this.f2429a.Cardinal(z, whirlpoolWithRSAEncryption);
        int bitLength = this.f2430b.configure.bitLength();
        this.f2432d = bitLength;
        this.f2433e = new byte[((bitLength + 7) / 8)];
        this.init.cca_continue();
    }

    public final byte[] Cardinal() throws KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo {
        m1812a(this.f2431c);
        KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo = this.f2429a;
        byte[] bArr = this.f2433e;
        BigInteger bigInteger = new BigInteger(1, dHwithSHA384KDFAndSharedInfo.Cardinal(bArr, 0, bArr.length));
        m1813a(this.f2433e);
        return setSelected.Cardinal(setSelected.init(this.f2430b.configure), bigInteger.min(this.f2430b.configure.subtract(bigInteger)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
        if ((r4.intValue() & 15) == 12) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean init(byte[] r4) {
        /*
            r3 = this;
            r0 = 0
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo r1 = r3.f2429a     // Catch:{ Exception -> 0x005c }
            int r2 = r4.length     // Catch:{ Exception -> 0x005c }
            byte[] r4 = r1.Cardinal(r4, r0, r2)     // Catch:{ Exception -> 0x005c }
            r3.f2433e = r4     // Catch:{ Exception -> 0x005c }
            java.math.BigInteger r4 = new java.math.BigInteger
            r1 = 1
            byte[] r2 = r3.f2433e
            r4.<init>(r1, r2)
            int r1 = r4.intValue()
            r1 = r1 & 15
            r2 = 12
            if (r1 != r2) goto L_0x001d
            goto L_0x002d
        L_0x001d:
            com.cardinalcommerce.a.ISOSignatureSpi$WhirlpoolWithRSAEncryption r1 = r3.f2430b
            java.math.BigInteger r1 = r1.configure
            java.math.BigInteger r4 = r1.subtract(r4)
            int r1 = r4.intValue()
            r1 = r1 & 15
            if (r1 != r2) goto L_0x005c
        L_0x002d:
            int r0 = r3.f2431c
            r3.m1812a((int) r0)
            byte[] r0 = r3.f2433e
            int r0 = r0.length
            byte[] r4 = com.cardinalcommerce.p060a.setSelected.Cardinal(r0, r4)
            byte[] r0 = r3.f2433e
            boolean r0 = com.cardinalcommerce.p060a.setForegroundTintBlendMode.init(r0, r4)
            int r1 = r3.f2431c
            r2 = 15052(0x3acc, float:2.1092E-41)
            if (r1 != r2) goto L_0x0054
            if (r0 != 0) goto L_0x0054
            byte[] r0 = r3.f2433e
            int r1 = r0.length
            int r1 = r1 + -2
            r2 = 64
            r0[r1] = r2
            boolean r0 = com.cardinalcommerce.p060a.setForegroundTintBlendMode.init(r0, r4)
        L_0x0054:
            byte[] r1 = r3.f2433e
            m1813a((byte[]) r1)
            m1813a((byte[]) r4)
        L_0x005c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.ECUtil.init(byte[]):boolean");
    }
}
