package com.cardinalcommerce.p060a;

import java.io.Serializable;

/* renamed from: com.cardinalcommerce.a.setTransformationMethod */
public final class setTransformationMethod implements Serializable {
    private static int cca_continue = 0;
    private static int getInstance = 1;
    public boolean Cardinal = true;
    public String configure = "";

    public final boolean getInstance() {
        int i = cca_continue;
        int i2 = ((i ^ 91) - (~(-(-((i & 91) << 1))))) - 1;
        getInstance = i2 % 128;
        int i3 = i2 % 2;
        boolean z = this.Cardinal;
        int i4 = getInstance;
        int i5 = i4 & 25;
        int i6 = (i4 | 25) & (~i5);
        int i7 = i5 << 1;
        int i8 = ((i6 | i7) << 1) - (i6 ^ i7);
        cca_continue = i8 % 128;
        if (i8 % 2 == 0) {
            return z;
        }
        int i9 = 60 / 0;
        return z;
    }

    public final void getInstance(String str) {
        int i = getInstance;
        boolean z = true;
        int i2 = (((i | 64) << 1) - (i ^ 64)) - 1;
        cca_continue = i2 % 128;
        int i3 = i2 % 2;
        if (!(!this.configure.equals(""))) {
            int i4 = cca_continue;
            int i5 = ((i4 & -66) | ((~i4) & 65)) + ((i4 & 65) << 1);
            getInstance = i5 % 128;
            int i6 = i5 % 2;
            this.configure = str;
            int i7 = cca_continue;
            int i8 = (i7 ^ 87) + ((i7 & 87) << 1);
            getInstance = i8 % 128;
            int i9 = i8 % 2;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.configure);
        sb.append(",");
        sb.append(str);
        this.configure = sb.toString();
        int i10 = getInstance;
        int i11 = i10 & 37;
        int i12 = ((i10 | 37) & (~i11)) + (i11 << 1);
        cca_continue = i12 % 128;
        if (i12 % 2 == 0) {
            z = false;
        }
        if (z) {
            int i13 = 62 / 0;
        }
    }
}
