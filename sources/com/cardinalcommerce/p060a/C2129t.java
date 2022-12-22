package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.t */
final class C2129t implements setContentDescription {

    /* renamed from: a */
    private int[] f3101a;

    public final int configure() {
        int[] iArr = this.f3101a;
        return iArr[iArr.length - 1];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2129t)) {
            return false;
        }
        return setForegroundTintBlendMode.cca_continue(this.f3101a, ((C2129t) obj).f3101a);
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.cca_continue(this.f3101a);
    }

    C2129t(int[] iArr) {
        int[] iArr2;
        if (iArr == null) {
            iArr2 = null;
        } else {
            int[] iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr2 = iArr3;
        }
        this.f3101a = iArr2;
    }

    public final int[] cca_continue() {
        int[] iArr = this.f3101a;
        if (iArr == null) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }
}
