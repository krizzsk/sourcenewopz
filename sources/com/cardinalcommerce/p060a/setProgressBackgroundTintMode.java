package com.cardinalcommerce.p060a;

import org.apache.commons.p071io.IOUtils;

/* renamed from: com.cardinalcommerce.a.setProgressBackgroundTintMode */
public class setProgressBackgroundTintMode extends setTextMetricsParams {

    /* renamed from: a */
    private static volatile setProgressBackgroundTintMode f2940a = null;

    /* renamed from: b */
    private static int f2941b = 0;

    /* renamed from: c */
    private static int f2942c = 1;

    public static setProgressBackgroundTintMode init() {
        if (f2940a == null) {
            synchronized (setProgressBackgroundTintMode.class) {
                if (f2940a == null) {
                    f2940a = new setProgressBackgroundTintMode();
                }
            }
        }
        return f2940a;
    }

    private setProgressBackgroundTintMode() {
        if (f2940a != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
    }

    public final void Cardinal(String str, String str2) {
        int i = f2941b;
        int i2 = i & 51;
        int i3 = (i ^ 51) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2942c = i4 % 128;
        int i5 = i4 % 2;
        if (getInstance) {
            Cardinal = new setProgressDrawable().Cardinal;
            configure = "EMVCoLoggerV1";
            super.init(str, str2, (String) null);
            int i6 = f2941b;
            int i7 = (i6 ^ 37) + ((i6 & 37) << 1);
            f2942c = i7 % 128;
            int i8 = i7 % 2;
        }
        int i9 = f2942c;
        int i10 = i9 & 89;
        int i11 = i10 + ((i9 ^ 89) | i10);
        f2941b = i11 % 128;
        if (i11 % 2 != 0) {
            int i12 = 77 / 0;
        }
    }

    public final void cca_continue(String str, String str2) {
        int i = (((f2941b + 97) - 1) + 0) - 1;
        f2942c = i % 128;
        int i2 = i % 2;
        if (getInstance) {
            Cardinal = new setProgressDrawable().Cardinal;
            configure = "EMVCoLoggerV1";
            super.configure(str, str2, (String) null);
            int i3 = f2941b;
            int i4 = i3 & 9;
            int i5 = ((i3 ^ 9) | i4) << 1;
            int i6 = -((i3 | 9) & (~i4));
            int i7 = (i5 & i6) + (i6 | i5);
            f2942c = i7 % 128;
            int i8 = i7 % 2;
        }
        int i9 = f2942c;
        int i10 = (i9 & 61) + (i9 | 61);
        f2941b = i10 % 128;
        int i11 = i10 % 2;
    }

    public final void getInstance() {
        int i = f2942c;
        int i2 = ((i | 74) << 1) - (i ^ 74);
        int i3 = ((i2 | -1) << 1) - (i2 ^ -1);
        f2941b = i3 % 128;
        boolean z = i3 % 2 != 0;
        super.configure((String) null);
        if (z) {
            int i4 = 13 / 0;
        }
        int i5 = f2942c;
        int i6 = i5 & 113;
        int i7 = ((((i5 ^ 113) | i6) << 1) - (~(-((i5 | 113) & (~i6))))) - 1;
        f2941b = i7 % 128;
        if ((i7 % 2 != 0 ? '*' : '!') != '!') {
            int i8 = 5 / 0;
        }
    }

    public final setJustificationMode configure() {
        int i = f2941b;
        boolean z = true;
        int i2 = (i ^ 112) + ((i & 112) << 1);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f2942c = i3 % 128;
        int i4 = i3 % 2;
        setJustificationMode configure = super.configure();
        int i5 = f2941b;
        int i6 = (i5 & 111) + (i5 | 111);
        f2942c = i6 % 128;
        if (i6 % 2 == 0) {
            z = false;
        }
        if (z) {
            return configure;
        }
        int i7 = 37 / 0;
        return configure;
    }

    public final void Cardinal() {
        int i = f2942c;
        int i2 = ((i | 81) << 1) - (i ^ 81);
        f2941b = i2 % 128;
        char c = i2 % 2 != 0 ? IOUtils.DIR_SEPARATOR_WINDOWS : '=';
        super.Cardinal();
        if (c == '\\') {
            Object obj = null;
            super.hashCode();
        }
        int i3 = f2942c + 15;
        f2941b = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 1 / 0;
        }
    }

    public final void init(setImageMatrix setimagematrix) {
        int i = f2941b;
        int i2 = i & 119;
        int i3 = (i ^ 119) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2942c = i4 % 128;
        int i5 = i4 % 2;
        String valueOf = String.valueOf(setimagematrix.getInstance);
        String str = setimagematrix.configure;
        if (getInstance) {
            Cardinal = new setProgressDrawable().Cardinal;
            configure = "EMVCoLoggerV1";
            super.configure(valueOf, str, (String) null);
            int i6 = f2941b;
            int i7 = (i6 | 57) << 1;
            int i8 = -(((~i6) & 57) | (i6 & -58));
            int i9 = (i7 & i8) + (i8 | i7);
            f2942c = i9 % 128;
            int i10 = i9 % 2;
        }
        int i11 = f2941b;
        int i12 = ((i11 | 103) << 1) - (i11 ^ 103);
        f2942c = i12 % 128;
        int i13 = i12 % 2;
    }
}
