package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAElevation */
public final class setCCAElevation extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2711a = setFocusableInTouchMode.getWarnings;
    protected int[] cca_continue;

    public setCCAElevation(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2711a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.cca_continue = setCCAId.init(bigInteger);
    }

    protected setCCAElevation(int[] iArr) {
        this.cca_continue = iArr;
    }

    public final BigInteger Cardinal() {
        return setKeepScreenOn.Cardinal(this.cca_continue);
    }

    public final boolean CardinalError() {
        return setKeepScreenOn.cca_continue(this.cca_continue);
    }

    public final int cca_continue() {
        return f2711a.bitLength();
    }

    public final boolean cleanup() {
        return setKeepScreenOn.init(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setCCAElevation)) {
            return false;
        }
        return setKeepScreenOn.Cardinal(this.cca_continue, ((setCCAElevation) obj).cca_continue);
    }

    public final int hashCode() {
        return f2711a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.cca_continue, 6);
    }

    public setCCAElevation() {
        this.cca_continue = new int[6];
    }

    public final boolean CardinalActionCode() {
        return (this.cca_continue[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setCCAId.getInstance(this.cca_continue, ((setCCAElevation) getacstransactionid).cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[6];
        setCCAId.Cardinal(this.cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setCCAId.cca_continue(this.cca_continue, ((setCCAElevation) getacstransactionid).cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setCCAId.init(this.cca_continue, ((setCCAElevation) getacstransactionid).cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setAccessibilityTraversalAfter.getInstance(setCCAId.f2715a, ((setCCAElevation) getacstransactionid).cca_continue, iArr);
        setCCAId.init(iArr, this.cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[6];
        setCCAId.cca_continue(this.cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[6];
        setCCAId.getInstance(this.cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[6];
        setAccessibilityTraversalAfter.getInstance(setCCAId.f2715a, this.cca_continue, iArr);
        return new setCCAElevation(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.cca_continue;
        if (setKeepScreenOn.init(iArr) || setKeepScreenOn.cca_continue(iArr)) {
            return this;
        }
        int[] iArr2 = new int[6];
        int[] iArr3 = new int[6];
        setCCAId.getInstance(iArr, iArr2);
        setCCAId.init(iArr2, iArr, iArr2);
        setCCAId.Cardinal(iArr2, 2, iArr3);
        setCCAId.init(iArr3, iArr2, iArr3);
        setCCAId.Cardinal(iArr3, 4, iArr2);
        setCCAId.init(iArr2, iArr3, iArr2);
        setCCAId.Cardinal(iArr2, 8, iArr3);
        setCCAId.init(iArr3, iArr2, iArr3);
        setCCAId.Cardinal(iArr3, 16, iArr2);
        setCCAId.init(iArr2, iArr3, iArr2);
        setCCAId.Cardinal(iArr2, 32, iArr3);
        setCCAId.init(iArr3, iArr2, iArr3);
        setCCAId.Cardinal(iArr3, 64, iArr2);
        setCCAId.init(iArr2, iArr3, iArr2);
        setCCAId.Cardinal(iArr2, 62, iArr2);
        setCCAId.getInstance(iArr2, iArr3);
        if (setKeepScreenOn.Cardinal(iArr, iArr3)) {
            return new setCCAElevation(iArr2);
        }
        return null;
    }
}
