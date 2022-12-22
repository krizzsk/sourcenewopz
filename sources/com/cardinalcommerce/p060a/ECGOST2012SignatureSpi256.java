package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.google.common.base.Ascii;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.ECGOST2012SignatureSpi256 */
public final class ECGOST2012SignatureSpi256 implements KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo {

    /* renamed from: a */
    private static final BigInteger f2401a = BigInteger.valueOf(16);

    /* renamed from: b */
    private static final BigInteger f2402b = BigInteger.valueOf(6);

    /* renamed from: c */
    private static byte[] f2403c = {Ascii.f53594SO, 3, 5, 8, 9, 4, 2, Ascii.f53593SI, 0, Ascii.f53584CR, 11, 6, 7, 10, Ascii.f53586FF, 1};

    /* renamed from: d */
    private static byte[] f2404d = {8, Ascii.f53593SI, 6, 1, 5, 2, 11, Ascii.f53586FF, 3, 4, Ascii.f53584CR, 10, Ascii.f53594SO, 9, 0, 7};

    /* renamed from: e */
    private KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo f2405e;

    /* renamed from: f */
    private boolean f2406f;

    /* renamed from: g */
    private int f2407g;

    /* renamed from: h */
    private int f2408h = 0;

    /* renamed from: i */
    private BigInteger f2409i;

    public ECGOST2012SignatureSpi256(KeyAgreementSpi.DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
        this.f2405e = dHwithSHA384KDFAndSharedInfo;
    }

    /* renamed from: a */
    private static byte[] m1803a(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    /* renamed from: a */
    private byte[] m1804a(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        int i3 = this.f2407g;
        int i4 = (i3 + 7) / 8;
        byte[] bArr2 = new byte[i4];
        int i5 = 1;
        int i6 = this.f2408h + 1;
        int i7 = (i3 + 13) / 16;
        int i8 = 0;
        while (i8 < i7) {
            if (i8 > i7 - i2) {
                int i9 = i7 - i8;
                System.arraycopy(bArr, (i + i2) - i9, bArr2, i4 - i7, i9);
            } else {
                System.arraycopy(bArr, i, bArr2, i4 - (i8 + i2), i2);
            }
            i8 += i2;
        }
        for (int i10 = i4 - (i7 * 2); i10 != i4; i10 += 2) {
            byte b = bArr2[(i4 - i7) + (i10 / 2)];
            byte[] bArr3 = f2403c;
            bArr2[i10] = (byte) (bArr3[b & Ascii.f53593SI] | (bArr3[(b & 255) >>> 4] << 4));
            bArr2[i10 + 1] = b;
        }
        int i11 = i4 - (i2 * 2);
        bArr2[i11] = (byte) (bArr2[i11] ^ i6);
        int i12 = i4 - 1;
        bArr2[i12] = (byte) ((bArr2[i12] << 4) | 6);
        int i13 = 8 - ((this.f2407g - 1) % 8);
        if (i13 != 8) {
            bArr2[0] = (byte) (bArr2[0] & (255 >>> i13));
            bArr2[0] = (byte) ((128 >>> i13) | bArr2[0]);
            i5 = 0;
        } else {
            bArr2[0] = 0;
            bArr2[1] = (byte) (bArr2[1] | 128);
        }
        return this.f2405e.Cardinal(bArr2, i5, i4 - i5);
    }

    /* renamed from: b */
    private byte[] m1805b(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        byte[] Cardinal = this.f2405e.Cardinal(bArr, i, i2);
        int i3 = (this.f2407g + 13) / 16;
        BigInteger bigInteger = new BigInteger(1, Cardinal);
        if (!bigInteger.mod(f2401a).equals(f2402b)) {
            if (this.f2409i.subtract(bigInteger).mod(f2401a).equals(f2402b)) {
                bigInteger = this.f2409i.subtract(bigInteger);
            } else {
                throw new KeyFactorySpi.ECDH("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        byte[] a = m1803a(bigInteger);
        if ((a[a.length - 1] & Ascii.f53593SI) == 6) {
            a[a.length - 1] = (byte) (((a[a.length - 1] & 255) >>> 4) | (f2404d[(a[a.length - 2] & 255) >> 4] << 4));
            byte[] bArr2 = f2403c;
            a[0] = (byte) (bArr2[a[1] & Ascii.f53593SI] | (bArr2[(a[1] & 255) >>> 4] << 4));
            int i4 = 0;
            boolean z = false;
            byte b = 1;
            for (int length = a.length - 1; length >= a.length - (i3 * 2); length -= 2) {
                byte[] bArr3 = f2403c;
                byte b2 = bArr3[a[length] & Ascii.f53593SI] | (bArr3[(a[length] & 255) >>> 4] << 4);
                int i5 = length - 1;
                if (((a[i5] ^ b2) & 255) != 0) {
                    if (!z) {
                        b = (a[i5] ^ b2) & 255;
                        i4 = i5;
                        z = true;
                    } else {
                        throw new KeyFactorySpi.ECDH("invalid tsums in block");
                    }
                }
            }
            a[i4] = 0;
            int length2 = (a.length - i4) / 2;
            byte[] bArr4 = new byte[length2];
            for (int i6 = 0; i6 < length2; i6++) {
                bArr4[i6] = a[(i6 * 2) + i4 + 1];
            }
            this.f2408h = b - 1;
            return bArr4;
        }
        throw new KeyFactorySpi.ECDH("invalid forcing byte in block");
    }

    public final byte[] Cardinal(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
        return this.f2406f ? m1804a(bArr, i, i2) : m1805b(bArr, i, i2);
    }

    public final int configure() {
        int configure = this.f2405e.configure();
        return this.f2406f ? configure : (configure + 1) / 2;
    }

    public final int getInstance() {
        int instance = this.f2405e.getInstance();
        return this.f2406f ? (instance + 1) / 2 : instance;
    }

    public final void Cardinal(boolean z, KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
        ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption = eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption ? (ISOSignatureSpi.WhirlpoolWithRSAEncryption) ((ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF).getInstance : (ISOSignatureSpi.WhirlpoolWithRSAEncryption) eCKAEGwithSHA512KDF;
        this.f2405e.Cardinal(z, eCKAEGwithSHA512KDF);
        BigInteger bigInteger = whirlpoolWithRSAEncryption.configure;
        this.f2409i = bigInteger;
        this.f2407g = bigInteger.bitLength();
        this.f2406f = z;
    }
}
