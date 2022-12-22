package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setChallengeTimeout */
public final class setChallengeTimeout extends setLocationDataConsentGiven {

    /* renamed from: a */
    private static final byte[] f2737a = {-1};

    /* renamed from: b */
    private static final byte[] f2738b = {0};

    /* renamed from: d */
    private static setChallengeTimeout f2739d = new setChallengeTimeout(false);

    /* renamed from: e */
    private static setChallengeTimeout f2740e = new setChallengeTimeout(true);

    /* renamed from: c */
    private final byte[] f2741c;

    private setChallengeTimeout(boolean z) {
        this.f2741c = z ? f2737a : f2738b;
    }

    private setChallengeTimeout(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        } else if (bArr[0] == 0) {
            this.f2741c = f2738b;
        } else if ((bArr[0] & 255) == 255) {
            this.f2741c = f2737a;
        } else {
            this.f2741c = setForegroundTintBlendMode.cca_continue(bArr);
        }
    }

    public static setChallengeTimeout Cardinal(Object obj) {
        if (obj == null || (obj instanceof setChallengeTimeout)) {
            return (setChallengeTimeout) obj;
        }
        StringBuilder sb = new StringBuilder("illegal object in getInstance: ");
        sb.append(obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    static setChallengeTimeout m1981a(byte[] bArr) {
        if (bArr.length == 1) {
            return bArr[0] == 0 ? f2739d : (bArr[0] & 255) == 255 ? f2740e : new setChallengeTimeout(bArr);
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static setChallengeTimeout cca_continue(boolean z) {
        return z ? f2740e : f2739d;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        return (setlocationdataconsentgiven instanceof setChallengeTimeout) && this.f2741c[0] == ((setChallengeTimeout) setlocationdataconsentgiven).f2741c[0];
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return 3;
    }

    public final int hashCode() {
        return this.f2741c[0];
    }

    public final boolean init() {
        return this.f2741c[0] != 0;
    }

    public final String toString() {
        return this.f2741c[0] != 0 ? "TRUE" : "FALSE";
    }

    public static setChallengeTimeout cca_continue(getType gettype) {
        setLocationDataConsentGiven values = gettype.getInstance != null ? gettype.getInstance.values() : null;
        return values instanceof setChallengeTimeout ? Cardinal((Object) values) : m1981a(((isEnableDFSync) values).cca_continue());
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.f2741c;
        setenabledfsync.configure(1);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }
}
