package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setDefaultFocusHighlightEnabled */
public final class setDefaultFocusHighlightEnabled {

    /* renamed from: a */
    private int f2750a;

    /* renamed from: b */
    private int f2751b;

    /* renamed from: c */
    private int f2752c;

    /* renamed from: d */
    private short[][][] f2753d;

    /* renamed from: e */
    private short[][][] f2754e;

    /* renamed from: f */
    private short[][] f2755f;

    /* renamed from: g */
    private short[] f2756g;

    public setDefaultFocusHighlightEnabled(byte b, byte b2, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        byte b3 = b & 255;
        this.f2750a = b3;
        byte b4 = b2 & 255;
        this.f2751b = b4;
        this.f2752c = b4 - b3;
        this.f2753d = sArr;
        this.f2754e = sArr2;
        this.f2755f = sArr3;
        this.f2756g = sArr4;
    }

    public final short[][][] Cardinal() {
        return this.f2754e;
    }

    public final short[][] cca_continue() {
        return this.f2755f;
    }

    public final short[][][] configure() {
        return this.f2753d;
    }

    public final short[] init() {
        return this.f2756g;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof setDefaultFocusHighlightEnabled)) {
            setDefaultFocusHighlightEnabled setdefaultfocushighlightenabled = (setDefaultFocusHighlightEnabled) obj;
            if (this.f2750a != setdefaultfocushighlightenabled.f2750a || this.f2751b != setdefaultfocushighlightenabled.f2751b || this.f2752c != setdefaultfocushighlightenabled.f2752c || !setKeyboardNavigationCluster.Cardinal(this.f2753d, setdefaultfocushighlightenabled.configure()) || !setKeyboardNavigationCluster.Cardinal(this.f2754e, setdefaultfocushighlightenabled.Cardinal()) || !setKeyboardNavigationCluster.configure(this.f2755f, setdefaultfocushighlightenabled.cca_continue()) || !setKeyboardNavigationCluster.configure(this.f2756g, setdefaultfocushighlightenabled.init())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = ((((this.f2750a * 37) + this.f2751b) * 37) + this.f2752c) * 37;
        short[][][] sArr = this.f2753d;
        int i2 = 0;
        for (int i3 = 0; i3 != sArr.length; i3++) {
            int i4 = i2 * 257;
            short[][] sArr2 = sArr[i3];
            int i5 = 0;
            for (int i6 = 0; i6 != sArr2.length; i6++) {
                i5 = (i5 * 257) + setForegroundTintBlendMode.init(sArr2[i6]);
            }
            i2 = i4 + i5;
        }
        int i7 = (i + i2) * 37;
        short[][][] sArr3 = this.f2754e;
        int i8 = 0;
        for (int i9 = 0; i9 != sArr3.length; i9++) {
            int i10 = i8 * 257;
            short[][] sArr4 = sArr3[i9];
            int i11 = 0;
            for (int i12 = 0; i12 != sArr4.length; i12++) {
                i11 = (i11 * 257) + setForegroundTintBlendMode.init(sArr4[i12]);
            }
            i8 = i10 + i11;
        }
        int i13 = (i7 + i8) * 37;
        short[][] sArr5 = this.f2755f;
        int i14 = 0;
        for (int i15 = 0; i15 != sArr5.length; i15++) {
            i14 = (i14 * 257) + setForegroundTintBlendMode.init(sArr5[i15]);
        }
        return ((i13 + i14) * 37) + setForegroundTintBlendMode.init(this.f2756g);
    }
}
