package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.SignatureSpi;
import com.google.common.base.Ascii;

/* renamed from: com.cardinalcommerce.a.BCECGOST3410PublicKey */
public final class BCECGOST3410PublicKey extends SignatureSpi.ecDetDSA224 {

    /* renamed from: e */
    private static final int[] f2223e = new int[64];

    /* renamed from: a */
    private int[] f2224a = new int[8];

    /* renamed from: b */
    private int[] f2225b = new int[16];

    /* renamed from: c */
    private int f2226c;

    /* renamed from: d */
    private int[] f2227d = new int[68];

    static {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            f2223e[i2] = (2043430169 >>> (32 - i2)) | (2043430169 << i2);
            i2++;
        }
        for (i = 16; i < 64; i++) {
            int i3 = i % 32;
            f2223e[i] = (2055708042 >>> (32 - i3)) | (2055708042 << i3);
        }
    }

    public BCECGOST3410PublicKey() {
        cca_continue();
    }

    private BCECGOST3410PublicKey(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        super(bCECGOST3410PublicKey);
        m1767a(bCECGOST3410PublicKey);
    }

    /* renamed from: a */
    private void m1767a(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        int[] iArr = bCECGOST3410PublicKey.f2224a;
        int[] iArr2 = this.f2224a;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = bCECGOST3410PublicKey.f2225b;
        int[] iArr4 = this.f2225b;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.f2226c = bCECGOST3410PublicKey.f2226c;
    }

    public final void cca_continue() {
        super.cca_continue();
        int[] iArr = this.f2224a;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.f2226c = 0;
    }

    public final void cca_continue(setPaddingRelative setpaddingrelative) {
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey) setpaddingrelative;
        super.getInstance(bCECGOST3410PublicKey);
        m1767a(bCECGOST3410PublicKey);
    }

    /* access modifiers changed from: protected */
    public final void cca_continue(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.f2225b;
        int i5 = this.f2226c;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.f2226c = i6;
        if (i6 >= 16) {
            cleanup();
        }
    }

    public final String configure() {
        return "SM3";
    }

    public final int getInstance() {
        return 32;
    }

    public final setPaddingRelative init() {
        return new BCECGOST3410PublicKey(this);
    }

    /* access modifiers changed from: protected */
    public final void init(long j) {
        int i = this.f2226c;
        if (i > 14) {
            this.f2225b[i] = 0;
            this.f2226c = i + 1;
            cleanup();
        }
        while (true) {
            int i2 = this.f2226c;
            if (i2 < 14) {
                this.f2225b[i2] = 0;
                this.f2226c = i2 + 1;
            } else {
                int[] iArr = this.f2225b;
                int i3 = i2 + 1;
                this.f2226c = i3;
                iArr[i2] = (int) (j >>> 32);
                this.f2226c = i3 + 1;
                iArr[i3] = (int) j;
                return;
            }
        }
    }

    public final int configure(byte[] bArr, int i) {
        values();
        int[] iArr = this.f2224a;
        for (int instance : iArr) {
            setMinimumWidth.getInstance(instance, bArr, i);
            i += 4;
        }
        cca_continue();
        return 32;
    }

    /* access modifiers changed from: protected */
    public final void cleanup() {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            this.f2227d[i2] = this.f2225b[i2];
            i2++;
        }
        for (int i3 = 16; i3 < 68; i3++) {
            int[] iArr = this.f2227d;
            int i4 = iArr[i3 - 3];
            int i5 = (i4 >>> 17) | (i4 << 15);
            int i6 = iArr[i3 - 13];
            int i7 = i5 ^ (iArr[i3 - 16] ^ iArr[i3 - 9]);
            iArr[i3] = (((i7 ^ ((i7 << 15) | (i7 >>> 17))) ^ ((i7 << 23) | (i7 >>> 9))) ^ ((i6 >>> 25) | (i6 << 7))) ^ iArr[i3 - 6];
        }
        int[] iArr2 = this.f2224a;
        int i8 = iArr2[0];
        int i9 = iArr2[1];
        int i10 = iArr2[2];
        int i11 = iArr2[3];
        int i12 = iArr2[4];
        int i13 = iArr2[5];
        int i14 = iArr2[6];
        int i15 = iArr2[7];
        int i16 = 0;
        for (i = 16; i16 < i; i = 16) {
            int i17 = (i8 << 12) | (i8 >>> 20);
            int i18 = i17 + i12 + f2223e[i16];
            int i19 = (i18 << 7) | (i18 >>> 25);
            int[] iArr3 = this.f2227d;
            int i20 = iArr3[i16];
            int i21 = ((i12 ^ i13) ^ i14) + i15 + i19 + i20;
            int i22 = (i9 << 9) | (i9 >>> 23);
            int i23 = (i13 << 19) | (i13 >>> 13);
            int i24 = i21 ^ ((i21 << 9) | (i21 >>> 23));
            i16++;
            i13 = i12;
            i12 = i24 ^ ((i21 << 17) | (i21 >>> 15));
            i11 = i10;
            i10 = i22;
            i15 = i14;
            i14 = i23;
            i9 = i8;
            i8 = ((i8 ^ i9) ^ i10) + i11 + (i19 ^ i17) + (i20 ^ iArr3[i16 + 4]);
        }
        int i25 = i15;
        int i26 = i13;
        int i27 = i14;
        int i28 = i12;
        int i29 = i11;
        int i30 = i10;
        int i31 = i9;
        int i32 = i8;
        int i33 = 16;
        while (i33 < 64) {
            int i34 = (i32 << 12) | (i32 >>> 20);
            int i35 = i34 + i28 + f2223e[i33];
            int i36 = (i35 << 7) | (i35 >>> 25);
            int[] iArr4 = this.f2227d;
            int i37 = iArr4[i33];
            int i38 = ((i32 & i31) | (i32 & i30) | (i31 & i30)) + i29 + (i36 ^ i34);
            int i39 = ((i28 & i26) | ((~i28) & i27)) + i25 + i36 + i37;
            int i40 = (i31 >>> 23) | (i31 << 9);
            int i41 = (i26 << 19) | (i26 >>> 13);
            i33++;
            i26 = i28;
            i28 = (i39 ^ ((i39 << 9) | (i39 >>> 23))) ^ ((i39 << 17) | (i39 >>> 15));
            i29 = i30;
            i30 = i40;
            i31 = i32;
            i32 = i38 + (i37 ^ iArr4[i33 + 4]);
            int i42 = i41;
            i25 = i27;
            i27 = i42;
        }
        int[] iArr5 = this.f2224a;
        iArr5[0] = i32 ^ iArr5[0];
        iArr5[1] = iArr5[1] ^ i31;
        iArr5[2] = iArr5[2] ^ i30;
        iArr5[3] = iArr5[3] ^ i29;
        iArr5[4] = iArr5[4] ^ i28;
        iArr5[5] = iArr5[5] ^ i26;
        iArr5[6] = i27 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i25;
        this.f2226c = 0;
    }
}
