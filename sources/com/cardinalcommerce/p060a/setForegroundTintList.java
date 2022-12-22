package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setForegroundTintList */
public final class setForegroundTintList {

    /* renamed from: a */
    private setBackgroundTintList f2785a;

    /* renamed from: b */
    private setForegroundTintMode f2786b;

    /* renamed from: c */
    private setForegroundTintMode[] f2787c;
    public setForegroundTintMode[] cca_continue;

    public setForegroundTintList(setBackgroundTintList setbackgroundtintlist, setForegroundTintMode setforegroundtintmode) {
        this.f2785a = setbackgroundtintlist;
        this.f2786b = setforegroundtintmode;
        m1986a();
        m1987b();
    }

    /* renamed from: a */
    private void m1986a() {
        int i;
        setForegroundTintMode setforegroundtintmode = this.f2786b;
        int length = setforegroundtintmode.init.length - 1;
        if (setforegroundtintmode.init[length] == 0) {
            length = -1;
        }
        this.f2787c = new setForegroundTintMode[length];
        int i2 = 0;
        while (true) {
            i = length >> 1;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 << 1;
            int[] iArr = new int[(i3 + 1)];
            iArr[i3] = 1;
            this.f2787c[i2] = new setForegroundTintMode(this.f2785a, iArr);
            i2++;
        }
        while (i < length) {
            int i4 = i << 1;
            int[] iArr2 = new int[(i4 + 1)];
            iArr2[i4] = 1;
            setForegroundTintMode setforegroundtintmode2 = new setForegroundTintMode(this.f2785a, iArr2);
            setForegroundTintMode[] setforegroundtintmodeArr = this.f2787c;
            setForegroundTintMode setforegroundtintmode3 = this.f2786b;
            int[] iArr3 = setforegroundtintmode2.init;
            int[] iArr4 = setforegroundtintmode3.init;
            int length2 = iArr4.length - 1;
            while (length2 >= 0 && iArr4[length2] == 0) {
                length2--;
            }
            if (length2 != -1) {
                int length3 = iArr3.length;
                int[] iArr5 = new int[length3];
                int configure = setforegroundtintmode2.getInstance.configure(setForegroundTintMode.m1988a(iArr4));
                System.arraycopy(iArr3, 0, iArr5, 0, length3);
                while (length2 <= setForegroundTintMode.m1991b(iArr5)) {
                    iArr5 = setForegroundTintMode.m1990a(setforegroundtintmode2.mo18523a(setForegroundTintMode.m1993b(iArr4, setForegroundTintMode.m1991b(iArr5) - length2), setforegroundtintmode2.getInstance.Cardinal(setForegroundTintMode.m1988a(iArr5), configure)), iArr5);
                }
                setforegroundtintmodeArr[i] = new setForegroundTintMode(setforegroundtintmode2.getInstance, iArr5);
                i++;
            } else {
                throw new ArithmeticException("Division by zero");
            }
        }
    }

    /* renamed from: b */
    private void m1987b() {
        setForegroundTintMode setforegroundtintmode = this.f2786b;
        int length = setforegroundtintmode.init.length - 1;
        if (setforegroundtintmode.init[length] == 0) {
            length = -1;
        }
        setForegroundTintMode[] setforegroundtintmodeArr = new setForegroundTintMode[length];
        int i = length - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            setforegroundtintmodeArr[i2] = new setForegroundTintMode(this.f2787c[i2]);
        }
        this.cca_continue = new setForegroundTintMode[length];
        while (i >= 0) {
            this.cca_continue[i] = new setForegroundTintMode(this.f2785a, i);
            i--;
        }
        int i3 = 0;
        while (i3 < length) {
            setForegroundTintMode setforegroundtintmode2 = setforegroundtintmodeArr[i3];
            if (((i3 < 0 || i3 > setforegroundtintmode2.Cardinal) ? 0 : setforegroundtintmode2.init[i3]) == 0) {
                int i4 = i3 + 1;
                boolean z = false;
                while (i4 < length) {
                    setForegroundTintMode setforegroundtintmode3 = setforegroundtintmodeArr[i4];
                    if (((i3 < 0 || i3 > setforegroundtintmode3.Cardinal) ? 0 : setforegroundtintmode3.init[i3]) != 0) {
                        setForegroundTintMode setforegroundtintmode4 = setforegroundtintmodeArr[i3];
                        setforegroundtintmodeArr[i3] = setforegroundtintmodeArr[i4];
                        setforegroundtintmodeArr[i4] = setforegroundtintmode4;
                        setForegroundTintMode[] setforegroundtintmodeArr2 = this.cca_continue;
                        setForegroundTintMode setforegroundtintmode5 = setforegroundtintmodeArr2[i3];
                        setforegroundtintmodeArr2[i3] = setforegroundtintmodeArr2[i4];
                        setforegroundtintmodeArr2[i4] = setforegroundtintmode5;
                        i4 = length;
                        z = true;
                    }
                    i4++;
                }
                if (!z) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            setForegroundTintMode setforegroundtintmode6 = setforegroundtintmodeArr[i3];
            int configure = this.f2785a.configure((i3 < 0 || i3 > setforegroundtintmode6.Cardinal) ? 0 : setforegroundtintmode6.init[i3]);
            setforegroundtintmodeArr[i3].configure(configure);
            this.cca_continue[i3].configure(configure);
            for (int i5 = 0; i5 < length; i5++) {
                if (i5 != i3) {
                    setForegroundTintMode setforegroundtintmode7 = setforegroundtintmodeArr[i5];
                    int i6 = (i3 < 0 || i3 > setforegroundtintmode7.Cardinal) ? 0 : setforegroundtintmode7.init[i3];
                    if (i6 != 0) {
                        setForegroundTintMode Cardinal = setforegroundtintmodeArr[i3].Cardinal(i6);
                        setForegroundTintMode Cardinal2 = this.cca_continue[i3].Cardinal(i6);
                        setforegroundtintmodeArr[i5].Cardinal(Cardinal);
                        this.cca_continue[i5].Cardinal(Cardinal2);
                    }
                }
            }
            i3++;
        }
    }
}
