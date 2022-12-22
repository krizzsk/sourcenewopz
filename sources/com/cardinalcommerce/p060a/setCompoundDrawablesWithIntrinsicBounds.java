package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setCompoundDrawablesWithIntrinsicBounds */
public final class setCompoundDrawablesWithIntrinsicBounds {

    /* renamed from: a */
    private static int f2747a = 0;

    /* renamed from: b */
    private static int f2748b = 1;
    public char[] Cardinal = setHeight.cca_continue;
    public boolean cca_continue = false;
    public char[] configure = setHeight.cca_continue;
    public char[] getInstance = setHeight.cca_continue;
    public char[] init = setHeight.cca_continue;
    public char[] values;

    public final char[] configure() {
        int i = f2748b;
        int i2 = (((i & -106) | ((~i) & 105)) - (~((i & 105) << 1))) - 1;
        f2747a = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = this.values;
        int i4 = f2748b;
        int i5 = (i4 & -58) | ((~i4) & 57);
        int i6 = -(-((i4 & 57) << 1));
        int i7 = (i5 & i6) + (i6 | i5);
        f2747a = i7 % 128;
        if (i7 % 2 == 0) {
            return cArr;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return cArr;
    }
}
