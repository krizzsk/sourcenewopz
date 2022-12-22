package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;

/* renamed from: com.cardinalcommerce.a.Payload */
public final class Payload implements KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo {

    /* renamed from: a */
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f2468a;

    /* renamed from: b */
    private byte[] f2469b;

    /* renamed from: c */
    private byte[] f2470c;

    /* renamed from: d */
    private int f2471d;

    public Payload() {
    }

    public static EncryptedJWT Cardinal(String str) {
        BCRSAPublicKey cca_continue = KeyAgreementSpi.DHwithRFC2631KDF.cca_continue(str);
        if (cca_continue == null) {
            try {
                cca_continue = KeyAgreementSpi.DHwithRFC2631KDF.init(new ASN1ObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (cca_continue == null) {
            return null;
        }
        return new EncryptedJWT(str, cca_continue.Cardinal, cca_continue.init, cca_continue.cca_continue, cca_continue.getInstance, cca_continue.init());
    }

    public Payload(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this.f2468a = mQVwithSHA256KDFAndSharedInfo;
        this.f2471d = mQVwithSHA256KDFAndSharedInfo.getInstance();
    }

    public final void getInstance(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        if (eCKAEGwithSHA512KDF instanceof DigestSignatureSpi.noneRSA) {
            DigestSignatureSpi.noneRSA nonersa = (DigestSignatureSpi.noneRSA) eCKAEGwithSHA512KDF;
            this.f2469b = nonersa.configure();
            this.f2470c = nonersa.getInstance();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }

    public final int init(byte[] bArr, int i, int i2) throws KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo, IllegalArgumentException {
        int i3;
        int i4;
        if (bArr.length - i2 >= 0) {
            byte[] bArr2 = new byte[this.f2471d];
            byte[] bArr3 = new byte[4];
            this.f2468a.cca_continue();
            if (i2 > this.f2471d) {
                int i5 = 1;
                i4 = 0;
                while (true) {
                    bArr3[0] = (byte) (i5 >>> 24);
                    bArr3[1] = (byte) (i5 >>> 16);
                    bArr3[2] = (byte) (i5 >>> 8);
                    bArr3[3] = (byte) i5;
                    this.f2468a.init(bArr3, 0, 4);
                    KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.f2468a;
                    byte[] bArr4 = this.f2469b;
                    mQVwithSHA256KDFAndSharedInfo.init(bArr4, 0, bArr4.length);
                    KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.f2468a;
                    byte[] bArr5 = this.f2470c;
                    mQVwithSHA256KDFAndSharedInfo2.init(bArr5, 0, bArr5.length);
                    this.f2468a.configure(bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i4, this.f2471d);
                    int i6 = this.f2471d;
                    i4 += i6;
                    i3 = i5 + 1;
                    if (i5 >= i2 / i6) {
                        break;
                    }
                    i5 = i3;
                }
            } else {
                i4 = 0;
                i3 = 1;
            }
            if (i4 < i2) {
                bArr3[0] = (byte) (i3 >>> 24);
                bArr3[1] = (byte) (i3 >>> 16);
                bArr3[2] = (byte) (i3 >>> 8);
                bArr3[3] = (byte) i3;
                this.f2468a.init(bArr3, 0, 4);
                KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo3 = this.f2468a;
                byte[] bArr6 = this.f2469b;
                mQVwithSHA256KDFAndSharedInfo3.init(bArr6, 0, bArr6.length);
                KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo4 = this.f2468a;
                byte[] bArr7 = this.f2470c;
                mQVwithSHA256KDFAndSharedInfo4.init(bArr7, 0, bArr7.length);
                this.f2468a.configure(bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i4, i2 - i4);
            }
            return i2;
        }
        throw new KeyFactorySpi.ECDSA("output buffer too small");
    }
}
