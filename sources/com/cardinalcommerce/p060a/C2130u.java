package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.u */
final class C2130u {

    /* renamed from: a */
    private final byte[][] f3104a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[][] mo18830a() {
        return setVerticalFadingEdgeEnabled.Cardinal(this.f3104a);
    }

    protected C2130u(setLeft setleft, byte[][] bArr) {
        if (setleft == null) {
            throw new NullPointerException("params == null");
        } else if (setVerticalFadingEdgeEnabled.configure(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        } else if (bArr.length == setleft.f2855b) {
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i].length == setleft.getInstance) {
                    i++;
                } else {
                    throw new IllegalArgumentException("wrong publicKey format");
                }
            }
            this.f3104a = setVerticalFadingEdgeEnabled.Cardinal(bArr);
        } else {
            throw new IllegalArgumentException("wrong publicKey size");
        }
    }
}
