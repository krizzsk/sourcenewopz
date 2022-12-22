package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAText */
public final class setCCAText extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2735a = setCheckState.CardinalError;
    protected int[] Cardinal;

    public setCCAText(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2735a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        this.Cardinal = setCCAOnFocusChangeListener.init(bigInteger);
    }

    protected setCCAText(int[] iArr) {
        this.Cardinal = iArr;
    }

    public final BigInteger Cardinal() {
        return setScrollContainer.getInstance(this.Cardinal);
    }

    public final boolean CardinalError() {
        return setScrollContainer.Cardinal(this.Cardinal);
    }

    public final int cca_continue() {
        return f2735a.bitLength();
    }

    public final boolean cleanup() {
        return setScrollContainer.init(this.Cardinal);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setCCAText)) {
            return false;
        }
        return setScrollContainer.configure(this.Cardinal, ((setCCAText) obj).Cardinal);
    }

    public final int hashCode() {
        return f2735a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.Cardinal, 5);
    }

    public setCCAText() {
        this.Cardinal = new int[5];
    }

    public final boolean CardinalActionCode() {
        return (this.Cardinal[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setCCAOnFocusChangeListener.init(this.Cardinal, ((setCCAText) getacstransactionid).Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[5];
        setCCAOnFocusChangeListener.getInstance(this.Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setCCAOnFocusChangeListener.getInstance(this.Cardinal, ((setCCAText) getacstransactionid).Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setCCAOnFocusChangeListener.cca_continue(this.Cardinal, ((setCCAText) getacstransactionid).Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[5];
        setAccessibilityTraversalAfter.getInstance(setCCAOnFocusChangeListener.f2729a, ((setCCAText) getacstransactionid).Cardinal, iArr);
        setCCAOnFocusChangeListener.cca_continue(iArr, this.Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[5];
        setCCAOnFocusChangeListener.init(this.Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[5];
        setCCAOnFocusChangeListener.Cardinal(this.Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[5];
        setAccessibilityTraversalAfter.getInstance(setCCAOnFocusChangeListener.f2729a, this.Cardinal, iArr);
        return new setCCAText(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.Cardinal;
        if (setScrollContainer.init(iArr) || setScrollContainer.Cardinal(iArr)) {
            return this;
        }
        int[] iArr2 = new int[5];
        setCCAOnFocusChangeListener.Cardinal(iArr, iArr2);
        setCCAOnFocusChangeListener.cca_continue(iArr2, iArr, iArr2);
        int[] iArr3 = new int[5];
        setCCAOnFocusChangeListener.getInstance(iArr2, 2, iArr3);
        setCCAOnFocusChangeListener.cca_continue(iArr3, iArr2, iArr3);
        setCCAOnFocusChangeListener.getInstance(iArr3, 4, iArr2);
        setCCAOnFocusChangeListener.cca_continue(iArr2, iArr3, iArr2);
        setCCAOnFocusChangeListener.getInstance(iArr2, 8, iArr3);
        setCCAOnFocusChangeListener.cca_continue(iArr3, iArr2, iArr3);
        setCCAOnFocusChangeListener.getInstance(iArr3, 16, iArr2);
        setCCAOnFocusChangeListener.cca_continue(iArr2, iArr3, iArr2);
        setCCAOnFocusChangeListener.getInstance(iArr2, 32, iArr3);
        setCCAOnFocusChangeListener.cca_continue(iArr3, iArr2, iArr3);
        setCCAOnFocusChangeListener.getInstance(iArr3, 64, iArr2);
        setCCAOnFocusChangeListener.cca_continue(iArr2, iArr3, iArr2);
        setCCAOnFocusChangeListener.Cardinal(iArr2, iArr3);
        setCCAOnFocusChangeListener.cca_continue(iArr3, iArr, iArr3);
        setCCAOnFocusChangeListener.getInstance(iArr3, 29, iArr3);
        setCCAOnFocusChangeListener.Cardinal(iArr3, iArr2);
        if (setScrollContainer.configure(iArr, iArr2)) {
            return new setCCAText(iArr3);
        }
        return null;
    }
}
