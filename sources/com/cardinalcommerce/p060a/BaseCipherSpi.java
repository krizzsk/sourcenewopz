package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.BaseCipherSpi */
public final class BaseCipherSpi implements KeyPairGeneratorSpi.ECDSA {

    /* renamed from: a */
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f2314a;

    /* renamed from: b */
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo f2315b;

    /* renamed from: c */
    private SecureRandom f2316c;

    /* renamed from: d */
    private int f2317d;

    /* renamed from: e */
    private int f2318e;

    /* renamed from: f */
    private int f2319f;

    /* renamed from: g */
    private int f2320g;
    public KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo getInstance;

    /* renamed from: h */
    private byte[] f2321h;

    /* renamed from: i */
    private byte[] f2322i;

    /* renamed from: j */
    private byte[] f2323j;

    /* renamed from: k */
    private byte f2324k;

    /* renamed from: com.cardinalcommerce.a.BaseCipherSpi$ErasableOutputStream */
    public final class ErasableOutputStream implements X931SignatureSpi {
        private static final BigInteger Cardinal = BigInteger.valueOf(0);
        private SecureRandom configure;
        private BigInteger getInstance;

        public final BigInteger Cardinal() {
            int bitLength = this.getInstance.bitLength();
            while (true) {
                BigInteger configure2 = setSelected.configure(bitLength, this.configure);
                if (!configure2.equals(Cardinal) && configure2.compareTo(this.getInstance) < 0) {
                    return configure2;
                }
            }
        }

        public final void cca_continue(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
            throw new IllegalStateException("Operation not supported");
        }

        public final boolean getInstance() {
            return false;
        }

        public final void init(BigInteger bigInteger, SecureRandom secureRandom) {
            this.getInstance = bigInteger;
            this.configure = secureRandom;
        }
    }

    public BaseCipherSpi(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2, int i, byte b) {
        this.f2315b = dHwithSHA384KDFAndSharedInfo;
        this.getInstance = mQVwithSHA256KDFAndSharedInfo;
        this.f2314a = mQVwithSHA256KDFAndSharedInfo2;
        this.f2317d = mQVwithSHA256KDFAndSharedInfo.getInstance();
        this.f2318e = mQVwithSHA256KDFAndSharedInfo2.getInstance();
        this.f2319f = i;
        this.f2321h = new byte[i];
        this.f2322i = new byte[(i + 8 + this.f2317d)];
        this.f2324k = b;
    }

    public final void cca_continue(byte[] bArr, int i, int i2) {
        this.getInstance.init(bArr, i, i2);
    }

    public final void init(byte b) {
        this.getInstance.Cardinal(b);
    }

    public final void cca_continue(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF2;
        ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption;
        if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
            ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
            eCKAEGwithSHA512KDF2 = sHA224WithRSAEncryption.getInstance;
            this.f2316c = sHA224WithRSAEncryption.configure;
        } else {
            if (z) {
                this.f2316c = KeyAgreementSpi.MQV.cca_continue();
            }
            eCKAEGwithSHA512KDF2 = eCKAEGwithSHA512KDF;
        }
        if (eCKAEGwithSHA512KDF2 instanceof PSSSignatureSpi.PSSwithRSA) {
            whirlpoolWithRSAEncryption = null;
            this.f2315b.Cardinal(z, eCKAEGwithSHA512KDF);
        } else {
            whirlpoolWithRSAEncryption = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) eCKAEGwithSHA512KDF2;
            this.f2315b.Cardinal(z, eCKAEGwithSHA512KDF2);
        }
        int bitLength = whirlpoolWithRSAEncryption.configure.bitLength() - 1;
        this.f2320g = bitLength;
        if (bitLength >= (this.f2317d * 8) + (this.f2319f * 8) + 9) {
            this.f2323j = new byte[((bitLength + 7) / 8)];
            this.getInstance.cca_continue();
            return;
        }
        throw new IllegalArgumentException("key too small for specified hash and salt lengths");
    }

    public final byte[] Cardinal() throws KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA512KDFAndSharedInfo {
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
        byte[] bArr = this.f2322i;
        mQVwithSHA256KDFAndSharedInfo.configure(bArr, (bArr.length - this.f2317d) - this.f2319f);
        if (this.f2319f != 0) {
            this.f2316c.nextBytes(this.f2321h);
            byte[] bArr2 = this.f2321h;
            byte[] bArr3 = this.f2322i;
            int length = bArr3.length;
            int i = this.f2319f;
            System.arraycopy(bArr2, 0, bArr3, length - i, i);
        }
        int i2 = this.f2317d;
        byte[] bArr4 = new byte[i2];
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.getInstance;
        byte[] bArr5 = this.f2322i;
        mQVwithSHA256KDFAndSharedInfo2.init(bArr5, 0, bArr5.length);
        this.getInstance.configure(bArr4, 0);
        byte[] bArr6 = this.f2323j;
        int length2 = bArr6.length;
        int i3 = this.f2319f;
        int i4 = this.f2317d;
        bArr6[(((length2 - i3) - 1) - i4) - 1] = 1;
        System.arraycopy(this.f2321h, 0, bArr6, ((bArr6.length - i3) - i4) - 1, i3);
        byte[] a = m1785a(bArr4, 0, i2, (this.f2323j.length - this.f2317d) - 1);
        for (int i5 = 0; i5 != a.length; i5++) {
            byte[] bArr7 = this.f2323j;
            bArr7[i5] = (byte) (bArr7[i5] ^ a[i5]);
        }
        byte[] bArr8 = this.f2323j;
        bArr8[0] = (byte) (bArr8[0] & (255 >> ((bArr8.length << 3) - this.f2320g)));
        int length3 = bArr8.length;
        int i6 = this.f2317d;
        System.arraycopy(bArr4, 0, bArr8, (length3 - i6) - 1, i6);
        byte[] bArr9 = this.f2323j;
        bArr9[bArr9.length - 1] = this.f2324k;
        byte[] Cardinal = this.f2315b.Cardinal(bArr9, 0, bArr9.length);
        byte[] bArr10 = this.f2323j;
        for (int i7 = 0; i7 != bArr10.length; i7++) {
            bArr10[i7] = 0;
        }
        return Cardinal;
    }

    public final boolean init(byte[] bArr) {
        KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
        byte[] bArr2 = this.f2322i;
        mQVwithSHA256KDFAndSharedInfo.configure(bArr2, (bArr2.length - this.f2317d) - this.f2319f);
        try {
            byte[] Cardinal = this.f2315b.Cardinal(bArr, 0, bArr.length);
            System.arraycopy(Cardinal, 0, this.f2323j, this.f2323j.length - Cardinal.length, Cardinal.length);
            byte[] bArr3 = this.f2323j;
            if (bArr3[bArr3.length - 1] != this.f2324k) {
                for (int i = 0; i != bArr3.length; i++) {
                    bArr3[i] = 0;
                }
                return false;
            }
            int length = bArr3.length;
            int i2 = this.f2317d;
            byte[] a = m1785a(bArr3, (length - i2) - 1, i2, (bArr3.length - i2) - 1);
            for (int i3 = 0; i3 != a.length; i3++) {
                byte[] bArr4 = this.f2323j;
                bArr4[i3] = (byte) (bArr4[i3] ^ a[i3]);
            }
            byte[] bArr5 = this.f2323j;
            bArr5[0] = (byte) (bArr5[0] & (255 >> ((bArr5.length << 3) - this.f2320g)));
            int i4 = 0;
            while (true) {
                byte[] bArr6 = this.f2323j;
                int length2 = bArr6.length;
                int i5 = this.f2317d;
                int i6 = this.f2319f;
                if (i4 != ((length2 - i5) - i6) - 2) {
                    if (bArr6[i4] != 0) {
                        for (int i7 = 0; i7 != bArr6.length; i7++) {
                            bArr6[i7] = 0;
                        }
                        return false;
                    }
                    i4++;
                } else if (bArr6[((bArr6.length - i5) - i6) - 2] != 1) {
                    for (int i8 = 0; i8 != bArr6.length; i8++) {
                        bArr6[i8] = 0;
                    }
                    return false;
                } else {
                    byte[] bArr7 = this.f2322i;
                    System.arraycopy(bArr6, ((bArr6.length - i6) - i5) - 1, bArr7, bArr7.length - i6, i6);
                    KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.getInstance;
                    byte[] bArr8 = this.f2322i;
                    mQVwithSHA256KDFAndSharedInfo2.init(bArr8, 0, bArr8.length);
                    KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo3 = this.getInstance;
                    byte[] bArr9 = this.f2322i;
                    mQVwithSHA256KDFAndSharedInfo3.configure(bArr9, bArr9.length - this.f2317d);
                    int length3 = this.f2323j.length;
                    int i9 = this.f2317d;
                    int i10 = (length3 - i9) - 1;
                    int length4 = this.f2322i.length - i9;
                    while (true) {
                        byte[] bArr10 = this.f2322i;
                        if (length4 == bArr10.length) {
                            for (int i11 = 0; i11 != bArr10.length; i11++) {
                                bArr10[i11] = 0;
                            }
                            byte[] bArr11 = this.f2323j;
                            for (int i12 = 0; i12 != bArr11.length; i12++) {
                                bArr11[i12] = 0;
                            }
                            return true;
                        } else if ((this.f2323j[i10] ^ bArr10[length4]) != 0) {
                            for (int i13 = 0; i13 != bArr10.length; i13++) {
                                bArr10[i13] = 0;
                            }
                            byte[] bArr12 = this.f2323j;
                            for (int i14 = 0; i14 != bArr12.length; i14++) {
                                bArr12[i14] = 0;
                            }
                            return false;
                        } else {
                            i10++;
                            length4++;
                        }
                    }
                }
            }
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private byte[] m1785a(byte[] bArr, int i, int i2, int i3) {
        int i4;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[this.f2318e];
        byte[] bArr4 = new byte[4];
        this.f2314a.cca_continue();
        int i5 = 0;
        while (true) {
            i4 = this.f2318e;
            if (i5 >= i3 / i4) {
                break;
            }
            bArr4[0] = (byte) (i5 >>> 24);
            bArr4[1] = (byte) (i5 >>> 16);
            bArr4[2] = (byte) (i5 >>> 8);
            bArr4[3] = (byte) i5;
            this.f2314a.init(bArr, i, i2);
            this.f2314a.init(bArr4, 0, 4);
            this.f2314a.configure(bArr3, 0);
            int i6 = this.f2318e;
            System.arraycopy(bArr3, 0, bArr2, i5 * i6, i6);
            i5++;
        }
        if (i4 * i5 < i3) {
            bArr4[0] = (byte) (i5 >>> 24);
            bArr4[1] = (byte) (i5 >>> 16);
            bArr4[2] = (byte) (i5 >>> 8);
            bArr4[3] = (byte) i5;
            this.f2314a.init(bArr, i, i2);
            this.f2314a.init(bArr4, 0, 4);
            this.f2314a.configure(bArr3, 0);
            int i7 = this.f2318e;
            System.arraycopy(bArr3, 0, bArr2, i5 * i7, i3 - (i5 * i7));
        }
        return bArr2;
    }
}
