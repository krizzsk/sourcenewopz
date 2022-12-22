package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.p */
final class C2025p implements setContentCaptureSession {

    /* renamed from: a */
    private setAccessibilityPaneTitle f2624a;

    /* renamed from: b */
    private setContentDescription f2625b;

    C2025p(setAccessibilityPaneTitle setaccessibilitypanetitle, setContentDescription setcontentdescription) {
        this.f2624a = setaccessibilitypanetitle;
        this.f2625b = setcontentdescription;
    }

    public final BigInteger Cardinal() {
        return this.f2624a.Cardinal();
    }

    public final setContentDescription configure() {
        return this.f2625b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2025p)) {
            return false;
        }
        C2025p pVar = (C2025p) obj;
        return this.f2624a.equals(pVar.f2624a) && this.f2625b.equals(pVar.f2625b);
    }

    public final int getInstance() {
        return this.f2624a.getInstance() * this.f2625b.configure();
    }

    public final int hashCode() {
        return this.f2624a.hashCode() ^ Integer.rotateLeft(this.f2625b.hashCode(), 16);
    }
}
