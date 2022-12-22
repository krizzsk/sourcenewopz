package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;

/* renamed from: com.cardinalcommerce.a.r */
final class C2027r {

    /* renamed from: a */
    private final KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f2634a;

    /* renamed from: b */
    private final int f2635b;

    protected C2027r(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, int i) {
        if (mQVwithSHA256KDFAndSharedInfo != null) {
            this.f2634a = mQVwithSHA256KDFAndSharedInfo;
            this.f2635b = i;
            return;
        }
        throw new NullPointerException("digest == null");
    }

    /* renamed from: a */
    private byte[] m1924a(int i, byte[] bArr, byte[] bArr2) {
        byte[] Cardinal = setVerticalFadingEdgeEnabled.Cardinal((long) i, this.f2635b);
        this.f2634a.init(Cardinal, 0, Cardinal.length);
        this.f2634a.init(bArr, 0, bArr.length);
        this.f2634a.init(bArr2, 0, bArr2.length);
        int i2 = this.f2635b;
        byte[] bArr3 = new byte[i2];
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.f2634a;
        if (mQVwithSHA256KDFAndSharedInfo instanceof KeyPairGeneratorSpi.ECDH) {
            ((KeyPairGeneratorSpi.ECDH) mQVwithSHA256KDFAndSharedInfo).getInstance(bArr3, 0, i2);
        } else {
            mQVwithSHA256KDFAndSharedInfo.configure(bArr3, 0);
        }
        return bArr3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] mo18297a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f2635b;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i) {
            return m1924a(0, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final byte[] mo18298b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f2635b;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == i * 2) {
            return m1924a(1, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong in length");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final byte[] mo18299c(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f2635b) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == 32) {
            return m1924a(3, bArr, bArr2);
        } else {
            throw new IllegalArgumentException("wrong address length");
        }
    }
}
