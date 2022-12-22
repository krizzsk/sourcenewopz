package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.SignatureSpi;

/* renamed from: com.cardinalcommerce.a.BCECGOST3410PrivateKey */
public final class BCECGOST3410PrivateKey extends SignatureSpi.ecDSASha3_512 {
    public BCECGOST3410PrivateKey() {
    }

    private BCECGOST3410PrivateKey(BCECGOST3410PrivateKey bCECGOST3410PrivateKey) {
        super(bCECGOST3410PrivateKey);
    }

    public final void cca_continue() {
        super.cca_continue();
        this.configure = 7640891576956012808L;
        this.getInstance = -4942790177534073029L;
        this.cca_continue = 4354685564936845355L;
        this.init = -6534734903238641935L;
        this.Cardinal = 5840696475078001361L;
        this.getWarnings = -7276294671716946913L;
        this.CardinalError = 2270897969802886507L;
        this.getSDKVersion = 6620516959819538809L;
    }

    public final void cca_continue(setPaddingRelative setpaddingrelative) {
        configure((BCECGOST3410PrivateKey) setpaddingrelative);
    }

    public final String configure() {
        return "SHA-512";
    }

    public final int getInstance() {
        return 64;
    }

    public final setPaddingRelative init() {
        return new BCECGOST3410PrivateKey(this);
    }

    public final int configure(byte[] bArr, int i) {
        CardinalError();
        long j = this.configure;
        setMinimumWidth.getInstance((int) (j >>> 32), bArr, i);
        setMinimumWidth.getInstance((int) j, bArr, i + 4);
        long j2 = this.getInstance;
        int i2 = i + 8;
        setMinimumWidth.getInstance((int) (j2 >>> 32), bArr, i2);
        setMinimumWidth.getInstance((int) j2, bArr, i2 + 4);
        long j3 = this.cca_continue;
        int i3 = i + 16;
        setMinimumWidth.getInstance((int) (j3 >>> 32), bArr, i3);
        setMinimumWidth.getInstance((int) j3, bArr, i3 + 4);
        long j4 = this.init;
        int i4 = i + 24;
        setMinimumWidth.getInstance((int) (j4 >>> 32), bArr, i4);
        setMinimumWidth.getInstance((int) j4, bArr, i4 + 4);
        long j5 = this.Cardinal;
        int i5 = i + 32;
        setMinimumWidth.getInstance((int) (j5 >>> 32), bArr, i5);
        setMinimumWidth.getInstance((int) j5, bArr, i5 + 4);
        long j6 = this.getWarnings;
        int i6 = i + 40;
        setMinimumWidth.getInstance((int) (j6 >>> 32), bArr, i6);
        setMinimumWidth.getInstance((int) j6, bArr, i6 + 4);
        long j7 = this.CardinalError;
        int i7 = i + 48;
        setMinimumWidth.getInstance((int) (j7 >>> 32), bArr, i7);
        setMinimumWidth.getInstance((int) j7, bArr, i7 + 4);
        long j8 = this.getSDKVersion;
        int i8 = i + 56;
        setMinimumWidth.getInstance((int) (j8 >>> 32), bArr, i8);
        setMinimumWidth.getInstance((int) j8, bArr, i8 + 4);
        cca_continue();
        return 64;
    }
}
