package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.SubjectPublicKeyInfo */
public final class SubjectPublicKeyInfo extends setLocationDataConsentGiven implements getExtendedData {

    /* renamed from: a */
    private final char[] f2484a;

    SubjectPublicKeyInfo(char[] cArr) {
        this.f2484a = cArr;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof SubjectPublicKeyInfo)) {
            return false;
        }
        return setForegroundTintBlendMode.configure(this.f2484a, ((SubjectPublicKeyInfo) setlocationdataconsentgiven).f2484a);
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        setenabledfsync.configure(30);
        setenabledfsync.Cardinal(this.f2484a.length << 1);
        int i = 0;
        while (true) {
            char[] cArr = this.f2484a;
            if (i != cArr.length) {
                char c = cArr[i];
                setenabledfsync.configure((byte) (c >> 8));
                setenabledfsync.configure((byte) c);
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.f2484a.length << 1) + 1 + (this.f2484a.length << 1);
    }

    public final String init() {
        return new String(this.f2484a);
    }

    public final String toString() {
        return init();
    }

    public final int hashCode() {
        char[] cArr = this.f2484a;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }
}
