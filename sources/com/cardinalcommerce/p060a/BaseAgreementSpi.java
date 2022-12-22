package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import com.google.common.base.Ascii;
import org.bouncycastle.crypto.signers.PSSSigner;

/* renamed from: com.cardinalcommerce.a.BaseAgreementSpi */
public final class BaseAgreementSpi implements KeyPairGeneratorSpi.ECDSA {

    /* renamed from: a */
    private KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo f2304a;

    /* renamed from: b */
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo f2305b;

    /* renamed from: c */
    private int f2306c = 188;

    /* renamed from: d */
    private int f2307d;

    /* renamed from: e */
    private byte[] f2308e;

    /* renamed from: f */
    private byte[] f2309f;

    /* renamed from: g */
    private int f2310g;

    /* renamed from: h */
    private byte[] f2311h;

    public BaseAgreementSpi(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo, KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
        this.f2305b = dHwithSHA384KDFAndSharedInfo;
        this.f2304a = mQVwithSHA256KDFAndSharedInfo;
    }

    /* renamed from: a */
    private static void m1782a(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    /* renamed from: a */
    private boolean m1783a(byte[] bArr, byte[] bArr2) {
        int i = this.f2310g;
        byte[] bArr3 = this.f2309f;
        boolean z = true;
        if (i > bArr3.length) {
            if (bArr3.length > bArr2.length) {
                z = false;
            }
            for (int i2 = 0; i2 != this.f2309f.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    z = false;
                }
            }
        } else {
            if (i != bArr2.length) {
                z = false;
            }
            for (int i3 = 0; i3 != bArr2.length; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    z = false;
                }
            }
        }
        return z;
    }

    public final void cca_continue(byte[] bArr, int i, int i2) {
        while (i2 > 0 && this.f2310g < this.f2309f.length) {
            init(bArr[i]);
            i++;
            i2--;
        }
        this.f2304a.init(bArr, i, i2);
        this.f2310g += i2;
    }

    public final void init(byte b) {
        this.f2304a.Cardinal(b);
        int i = this.f2310g;
        byte[] bArr = this.f2309f;
        if (i < bArr.length) {
            bArr[i] = b;
        }
        this.f2310g++;
    }

    public final boolean init(byte[] bArr) {
        try {
            byte[] Cardinal = this.f2305b.Cardinal(bArr, 0, bArr.length);
            if (((Cardinal[0] & 192) ^ 64) != 0) {
                return m1784b(Cardinal);
            }
            if (((Cardinal[Cardinal.length - 1] & Ascii.f53593SI) ^ Ascii.f53586FF) != 0) {
                return m1784b(Cardinal);
            }
            int i = 2;
            if (((Cardinal[Cardinal.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
                i = 1;
            } else {
                byte b = ((Cardinal[Cardinal.length - 2] & 255) << 8) | (Cardinal[Cardinal.length - 1] & 255);
                Integer init = X931SignatureSpi.SHA512_256WithRSAEncryption.init(this.f2304a);
                if (init != null) {
                    int intValue = init.intValue();
                    if (!(b == intValue || (intValue == 15052 && b == 16588))) {
                        throw new IllegalStateException("signer initialised with wrong digest for trailer ".concat(String.valueOf(b)));
                    }
                } else {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                }
            }
            int i2 = 0;
            while (i2 != Cardinal.length && ((Cardinal[i2] & Ascii.f53593SI) ^ 10) != 0) {
                i2++;
            }
            int i3 = i2 + 1;
            int instance = this.f2304a.getInstance();
            byte[] bArr2 = new byte[instance];
            int length = (Cardinal.length - i) - instance;
            int i4 = length - i3;
            if (i4 <= 0) {
                return m1784b(Cardinal);
            }
            if ((Cardinal[0] & 32) != 0) {
                this.f2304a.configure(bArr2, 0);
                boolean z = true;
                for (int i5 = 0; i5 != instance; i5++) {
                    int i6 = length + i5;
                    Cardinal[i6] = (byte) (Cardinal[i6] ^ bArr2[i5]);
                    if (Cardinal[i6] != 0) {
                        z = false;
                    }
                }
                if (!z) {
                    return m1784b(Cardinal);
                }
                byte[] bArr3 = new byte[i4];
                this.f2311h = bArr3;
                System.arraycopy(Cardinal, i3, bArr3, 0, bArr3.length);
            } else if (this.f2310g > i4) {
                return m1784b(Cardinal);
            } else {
                this.f2304a.cca_continue();
                this.f2304a.init(Cardinal, i3, i4);
                this.f2304a.configure(bArr2, 0);
                boolean z2 = true;
                for (int i7 = 0; i7 != instance; i7++) {
                    int i8 = length + i7;
                    Cardinal[i8] = (byte) (Cardinal[i8] ^ bArr2[i7]);
                    if (Cardinal[i8] != 0) {
                        z2 = false;
                    }
                }
                if (!z2) {
                    return m1784b(Cardinal);
                }
                byte[] bArr4 = new byte[i4];
                this.f2311h = bArr4;
                System.arraycopy(Cardinal, i3, bArr4, 0, bArr4.length);
            }
            if (this.f2310g != 0 && !m1783a(this.f2309f, this.f2311h)) {
                return m1784b(Cardinal);
            }
            m1782a(this.f2309f);
            m1782a(Cardinal);
            this.f2310g = 0;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void cca_continue(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption = (ISOSignatureSpi.WhirlpoolWithRSAEncryption) eCKAEGwithSHA512KDF;
        this.f2305b.Cardinal(z, whirlpoolWithRSAEncryption);
        int bitLength = whirlpoolWithRSAEncryption.configure.bitLength();
        this.f2307d = bitLength;
        byte[] bArr = new byte[((bitLength + 7) / 8)];
        this.f2308e = bArr;
        int i = this.f2306c;
        int length = bArr.length;
        if (i == 188) {
            this.f2309f = new byte[((length - this.f2304a.getInstance()) - 2)];
        } else {
            this.f2309f = new byte[((length - this.f2304a.getInstance()) - 3)];
        }
        this.f2304a.cca_continue();
        this.f2310g = 0;
        byte[] bArr2 = this.f2309f;
        for (int i2 = 0; i2 != bArr2.length; i2++) {
            bArr2[i2] = 0;
        }
        byte[] bArr3 = this.f2311h;
        if (bArr3 != null) {
            for (int i3 = 0; i3 != bArr3.length; i3++) {
                bArr3[i3] = 0;
            }
        }
        this.f2311h = null;
    }

    public final byte[] Cardinal() throws KeyAgreementSpi.MQVwithSHA1KDFAndSharedInfo {
        int i;
        int i2;
        int i3;
        byte b;
        int instance = this.f2304a.getInstance();
        if (this.f2306c == 188) {
            byte[] bArr = this.f2308e;
            i = (bArr.length - instance) - 1;
            this.f2304a.configure(bArr, i);
            byte[] bArr2 = this.f2308e;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i2 = 8;
        } else {
            i2 = 16;
            byte[] bArr3 = this.f2308e;
            int length = (bArr3.length - instance) - 2;
            this.f2304a.configure(bArr3, length);
            byte[] bArr4 = this.f2308e;
            int i4 = this.f2306c;
            bArr4[bArr4.length - 2] = (byte) (i4 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i4;
            i = length;
        }
        int i5 = this.f2310g;
        int i6 = ((((instance + i5) << 3) + i2) + 4) - this.f2307d;
        if (i6 > 0) {
            int i7 = i5 - ((i6 + 7) / 8);
            b = 96;
            i3 = i - i7;
            System.arraycopy(this.f2309f, 0, this.f2308e, i3, i7);
            this.f2311h = new byte[i7];
        } else {
            b = 64;
            i3 = i - i5;
            System.arraycopy(this.f2309f, 0, this.f2308e, i3, i5);
            this.f2311h = new byte[this.f2310g];
        }
        int i8 = i3 - 1;
        if (i8 > 0) {
            for (int i9 = i8; i9 != 0; i9--) {
                this.f2308e[i9] = -69;
            }
            byte[] bArr5 = this.f2308e;
            bArr5[i8] = (byte) (bArr5[i8] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (b | bArr5[0]);
        } else {
            byte[] bArr6 = this.f2308e;
            bArr6[0] = 10;
            bArr6[0] = (byte) (b | bArr6[0]);
        }
        KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo = this.f2305b;
        byte[] bArr7 = this.f2308e;
        byte[] Cardinal = dHwithSHA384KDFAndSharedInfo.Cardinal(bArr7, 0, bArr7.length);
        byte[] bArr8 = this.f2309f;
        byte[] bArr9 = this.f2311h;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.f2310g = 0;
        byte[] bArr10 = this.f2309f;
        for (int i10 = 0; i10 != bArr10.length; i10++) {
            bArr10[i10] = 0;
        }
        byte[] bArr11 = this.f2308e;
        for (int i11 = 0; i11 != bArr11.length; i11++) {
            bArr11[i11] = 0;
        }
        return Cardinal;
    }

    /* renamed from: b */
    private boolean m1784b(byte[] bArr) {
        this.f2310g = 0;
        byte[] bArr2 = this.f2309f;
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = 0;
        }
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr[i2] = 0;
        }
        return false;
    }
}
