package com.cardinalcommerce.p060a;

import java.security.spec.AlgorithmParameterSpec;

/* renamed from: com.cardinalcommerce.a.getErrorMessage */
public class getErrorMessage implements AlgorithmParameterSpec {
    public int Cardinal;

    /* renamed from: a */
    private byte[] f2556a;

    /* renamed from: b */
    private byte[] f2557b;

    /* renamed from: c */
    private byte[] f2558c;

    /* renamed from: d */
    private boolean f2559d;
    public int getInstance;

    public getErrorMessage(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, bArr2, i, -1, (byte[]) null, (byte) 0);
    }

    public getErrorMessage(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3) {
        this(bArr, bArr2, i, i2, bArr3, (byte) 0);
    }

    private getErrorMessage(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3, byte b) {
        if (bArr != null) {
            byte[] bArr4 = new byte[bArr.length];
            this.f2556a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        } else {
            this.f2556a = null;
        }
        if (bArr2 != null) {
            byte[] bArr5 = new byte[bArr2.length];
            this.f2557b = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        } else {
            this.f2557b = null;
        }
        this.Cardinal = i;
        this.getInstance = i2;
        this.f2558c = setForegroundTintBlendMode.cca_continue(bArr3);
        this.f2559d = false;
    }

    public final byte[] Cardinal() {
        return setForegroundTintBlendMode.cca_continue(this.f2558c);
    }

    public final boolean configure() {
        return false;
    }

    public final byte[] getInstance() {
        return setForegroundTintBlendMode.cca_continue(this.f2556a);
    }

    public final byte[] init() {
        return setForegroundTintBlendMode.cca_continue(this.f2557b);
    }
}
