package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.google.common.base.Ascii;

/* renamed from: com.cardinalcommerce.a.setBackgroundTintList */
public final class setBackgroundTintList {
    public int configure = 0;
    public int getInstance;

    /* renamed from: a */
    private static String m1978a(int i) {
        if (i == 0) {
            return "0";
        }
        String str = ((byte) (i & 1)) == 1 ? "1" : "";
        int i2 = i >>> 1;
        int i3 = 1;
        while (i2 != 0) {
            if (((byte) (i2 & 1)) == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("+x^");
                sb.append(i3);
                str = sb.toString();
            }
            i2 >>>= 1;
            i3++;
        }
        return str;
    }

    public final int Cardinal(int i, int i2) {
        return DSASigner.dsaSha3_384.getInstance(i, i2, this.getInstance);
    }

    public final boolean Cardinal(int i) {
        int i2 = this.configure;
        return i2 == 31 ? i >= 0 : i >= 0 && i < (1 << i2);
    }

    public final String cca_continue(int i) {
        String str = "";
        for (int i2 = 0; i2 < this.configure; i2++) {
            byte b = ((byte) i) & 1;
            str = (b == 0 ? "0" : "1").concat(String.valueOf(str));
            i >>>= 1;
        }
        return str;
    }

    public final int configure(int i) {
        return cca_continue(i, (1 << this.configure) - 2);
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof setBackgroundTintList)) {
            setBackgroundTintList setbackgroundtintlist = (setBackgroundTintList) obj;
            return this.configure == setbackgroundtintlist.configure && this.getInstance == setbackgroundtintlist.getInstance;
        }
    }

    public final byte[] getInstance() {
        return DSASigner.dsaSha3_384.Cardinal(this.getInstance);
    }

    public final int hashCode() {
        return this.getInstance;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Finite Field GF(2^");
        sb.append(this.configure);
        sb.append(") = GF(2)[X]/<");
        sb.append(m1978a(this.getInstance));
        sb.append("> ");
        return sb.toString();
    }

    public setBackgroundTintList(byte[] bArr) {
        if (bArr.length == 4) {
            byte b = ((bArr[3] & 255) << Ascii.CAN) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
            this.getInstance = b;
            if (DSASigner.dsaSha3_384.init(b)) {
                this.configure = DSASigner.dsaSha3_384.getInstance(this.getInstance);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    public final int cca_continue(int i, int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i2 < 0) {
            i = cca_continue(i, (1 << this.configure) - 2);
            i2 = -i2;
        }
        int i3 = 1;
        while (i2 != 0) {
            if ((i2 & 1) == 1) {
                i3 = DSASigner.dsaSha3_384.getInstance(i3, i, this.getInstance);
            }
            i = DSASigner.dsaSha3_384.getInstance(i, i, this.getInstance);
            i2 >>>= 1;
        }
        return i3;
    }
}
