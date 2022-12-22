package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setScrollCaptureHint */
public final class setScrollCaptureHint {

    /* renamed from: a */
    String f2969a;

    /* renamed from: b */
    String f2970b;

    public setScrollCaptureHint(String str, String str2) {
        this.f2969a = str;
        this.f2970b = str2;
    }

    /* renamed from: a */
    private static boolean m2086a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof setScrollCaptureHint)) {
            return false;
        }
        setScrollCaptureHint setscrollcapturehint = (setScrollCaptureHint) obj;
        if (setscrollcapturehint != this) {
            return m2086a(this.f2969a, setscrollcapturehint.f2969a) && m2086a(this.f2970b, setscrollcapturehint.f2970b);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f2969a;
        int i = 1;
        int hashCode = str == null ? 1 : str.hashCode();
        String str2 = this.f2970b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + (i * 31);
    }
}
