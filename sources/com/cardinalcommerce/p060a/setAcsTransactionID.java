package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.setAcsTransactionID */
public final class setAcsTransactionID implements KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo {

    /* renamed from: a */
    private byte[] f2657a;

    /* renamed from: b */
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f2658b;

    /* renamed from: c */
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo f2659c;

    /* renamed from: d */
    private SecureRandom f2660d;

    /* renamed from: e */
    private boolean f2661e;

    public setAcsTransactionID() {
    }

    public setAcsTransactionID(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, byte[] bArr) {
        this(dHwithSHA384KDFAndSharedInfo, mQVwithSHA256KDFAndSharedInfo, mQVwithSHA256KDFAndSharedInfo, bArr);
    }

    public setAcsTransactionID(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2, byte[] bArr) {
        this.f2659c = dHwithSHA384KDFAndSharedInfo;
        this.f2658b = mQVwithSHA256KDFAndSharedInfo2;
        this.f2657a = new byte[mQVwithSHA256KDFAndSharedInfo.getInstance()];
        mQVwithSHA256KDFAndSharedInfo.cca_continue();
        if (bArr != null) {
            mQVwithSHA256KDFAndSharedInfo.init(bArr, 0, bArr.length);
        }
        mQVwithSHA256KDFAndSharedInfo.configure(this.f2657a, 0);
    }

    public final void Cardinal(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        SecureRandom secureRandom;
        if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
            secureRandom = ((ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF).configure;
        } else {
            secureRandom = KeyAgreementSpi.MQV.cca_continue();
        }
        this.f2660d = secureRandom;
        this.f2659c.Cardinal(z, eCKAEGwithSHA512KDF);
        this.f2661e = z;
    }

    public final int getInstance() {
        int instance = this.f2659c.getInstance();
        return this.f2661e ? (instance - 1) - (this.f2657a.length * 2) : instance;
    }

    public final int configure() {
        int configure = this.f2659c.configure();
        return this.f2661e ? configure : (configure - 1) - (this.f2657a.length * 2);
    }

    public final byte[] Cardinal(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        return this.f2661e ? m1945a(bArr, i, i2) : m1947b(bArr, i, i2);
    }

    /* renamed from: a */
    private byte[] m1945a(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        int instance = this.f2659c.getInstance();
        if (this.f2661e) {
            instance = (instance - 1) - (this.f2657a.length * 2);
        }
        if (i2 <= instance) {
            int instance2 = this.f2659c.getInstance();
            if (this.f2661e) {
                instance2 = (instance2 - 1) - (this.f2657a.length * 2);
            }
            int length = instance2 + 1 + (this.f2657a.length * 2);
            byte[] bArr2 = new byte[length];
            int i3 = length - i2;
            System.arraycopy(bArr, i, bArr2, i3, i2);
            bArr2[i3 - 1] = 1;
            byte[] bArr3 = this.f2657a;
            System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
            int length2 = this.f2657a.length;
            byte[] bArr4 = new byte[length2];
            this.f2660d.nextBytes(bArr4);
            byte[] a = m1946a(bArr4, 0, length2, length - this.f2657a.length);
            for (int length3 = this.f2657a.length; length3 != length; length3++) {
                bArr2[length3] = (byte) (bArr2[length3] ^ a[length3 - this.f2657a.length]);
            }
            System.arraycopy(bArr4, 0, bArr2, 0, this.f2657a.length);
            byte[] bArr5 = this.f2657a;
            byte[] a2 = m1946a(bArr2, bArr5.length, length - bArr5.length, bArr5.length);
            for (int i4 = 0; i4 != this.f2657a.length; i4++) {
                bArr2[i4] = (byte) (bArr2[i4] ^ a2[i4]);
            }
            return this.f2659c.Cardinal(bArr2, 0, length);
        }
        throw new KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo("input data too long");
    }

    /* renamed from: b */
    private byte[] m1947b(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        byte[] bArr2;
        byte[] bArr3;
        byte[] Cardinal = this.f2659c.Cardinal(bArr, i, i2);
        int configure = this.f2659c.configure();
        byte[] bArr4 = new byte[configure];
        boolean z = configure < (this.f2657a.length * 2) + 1;
        if (Cardinal.length <= configure) {
            System.arraycopy(Cardinal, 0, bArr4, configure - Cardinal.length, Cardinal.length);
        } else {
            System.arraycopy(Cardinal, 0, bArr4, 0, configure);
            z = true;
        }
        byte[] bArr5 = this.f2657a;
        byte[] a = m1946a(bArr4, bArr5.length, configure - bArr5.length, bArr5.length);
        int i3 = 0;
        while (true) {
            bArr2 = this.f2657a;
            if (i3 == bArr2.length) {
                break;
            }
            bArr4[i3] = (byte) (bArr4[i3] ^ a[i3]);
            i3++;
        }
        byte[] a2 = m1946a(bArr4, 0, bArr2.length, configure - bArr2.length);
        for (int length = this.f2657a.length; length != configure; length++) {
            bArr4[length] = (byte) (bArr4[length] ^ a2[length - this.f2657a.length]);
        }
        int i4 = 0;
        boolean z2 = false;
        while (true) {
            bArr3 = this.f2657a;
            if (i4 == bArr3.length) {
                break;
            }
            if (bArr3[i4] != bArr4[bArr3.length + i4]) {
                z2 = true;
            }
            i4++;
        }
        int i5 = configure;
        for (int length2 = bArr3.length * 2; length2 != configure; length2++) {
            if ((bArr4[length2] != 0) && (i5 == configure)) {
                i5 = length2;
            }
        }
        boolean z3 = i5 > configure + -1;
        boolean z4 = bArr4[i5] != 1;
        int i6 = i5 + 1;
        if ((z3 | z4) || (z | z2)) {
            for (int i7 = 0; i7 < configure; i7++) {
                bArr4[i7] = 0;
            }
            throw new KeyFactorySpi.ECDH("data wrong");
        }
        int i8 = configure - i6;
        byte[] bArr6 = new byte[i8];
        System.arraycopy(bArr4, i6, bArr6, 0, i8);
        return bArr6;
    }

    /* renamed from: a */
    private byte[] m1946a(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        int instance = this.f2658b.getInstance();
        byte[] bArr3 = new byte[instance];
        byte[] bArr4 = new byte[4];
        this.f2658b.cca_continue();
        int i4 = 0;
        while (i4 < i3 / instance) {
            bArr4[0] = (byte) (i4 >>> 24);
            bArr4[1] = (byte) (i4 >>> 16);
            bArr4[2] = (byte) (i4 >>> 8);
            bArr4[3] = (byte) i4;
            this.f2658b.init(bArr, i, i2);
            this.f2658b.init(bArr4, 0, 4);
            this.f2658b.configure(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i4 * instance, instance);
            i4++;
        }
        int i5 = instance * i4;
        if (i5 < i3) {
            bArr4[0] = (byte) (i4 >>> 24);
            bArr4[1] = (byte) (i4 >>> 16);
            bArr4[2] = (byte) (i4 >>> 8);
            bArr4[3] = (byte) i4;
            this.f2658b.init(bArr, i, i2);
            this.f2658b.init(bArr4, 0, 4);
            this.f2658b.configure(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i5, i3 - i5);
        }
        return bArr2;
    }
}
