package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.i */
final class C2013i implements setAccessibilityPaneTitle {

    /* renamed from: a */
    private BigInteger f2592a;

    C2013i(BigInteger bigInteger) {
        this.f2592a = bigInteger;
    }

    public final BigInteger Cardinal() {
        return this.f2592a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2013i)) {
            return false;
        }
        return this.f2592a.equals(((C2013i) obj).f2592a);
    }

    public final int getInstance() {
        return 1;
    }

    public final int hashCode() {
        return this.f2592a.hashCode();
    }
}
