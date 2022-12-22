package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAOnCheckedChangeListener */
public final class setCCAOnCheckedChangeListener extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2726a = setPadding.CardinalError;
    protected int[] cca_continue;

    public setCCAOnCheckedChangeListener(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2726a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.cca_continue = setButtonDrawable.cca_continue(bigInteger);
    }

    protected setCCAOnCheckedChangeListener(int[] iArr) {
        this.cca_continue = iArr;
    }

    public final BigInteger Cardinal() {
        return setKeepScreenOn.Cardinal(this.cca_continue);
    }

    public final boolean CardinalError() {
        return setKeepScreenOn.cca_continue(this.cca_continue);
    }

    public final int cca_continue() {
        return f2726a.bitLength();
    }

    public final boolean cleanup() {
        return setKeepScreenOn.init(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setCCAOnCheckedChangeListener)) {
            return false;
        }
        return setKeepScreenOn.Cardinal(this.cca_continue, ((setCCAOnCheckedChangeListener) obj).cca_continue);
    }

    public final int hashCode() {
        return f2726a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.cca_continue, 6);
    }

    public setCCAOnCheckedChangeListener() {
        this.cca_continue = new int[6];
    }

    public final boolean CardinalActionCode() {
        return (this.cca_continue[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setButtonDrawable.Cardinal(this.cca_continue, ((setCCAOnCheckedChangeListener) getacstransactionid).cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[6];
        setButtonDrawable.Cardinal(this.cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setButtonDrawable.getInstance(this.cca_continue, ((setCCAOnCheckedChangeListener) getacstransactionid).cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setButtonDrawable.configure(this.cca_continue, ((setCCAOnCheckedChangeListener) getacstransactionid).cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[6];
        setAccessibilityTraversalAfter.getInstance(setButtonDrawable.f2708a, ((setCCAOnCheckedChangeListener) getacstransactionid).cca_continue, iArr);
        setButtonDrawable.configure(iArr, this.cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[6];
        setButtonDrawable.getInstance(this.cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[6];
        setButtonDrawable.configure(this.cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[6];
        setAccessibilityTraversalAfter.getInstance(setButtonDrawable.f2708a, this.cca_continue, iArr);
        return new setCCAOnCheckedChangeListener(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.cca_continue;
        if (setKeepScreenOn.init(iArr) || setKeepScreenOn.cca_continue(iArr)) {
            return this;
        }
        int[] iArr2 = new int[6];
        setButtonDrawable.configure(iArr, iArr2);
        setButtonDrawable.configure(iArr2, iArr, iArr2);
        int[] iArr3 = new int[6];
        setButtonDrawable.configure(iArr2, iArr3);
        setButtonDrawable.configure(iArr3, iArr, iArr3);
        int[] iArr4 = new int[6];
        setButtonDrawable.Cardinal(iArr3, 3, iArr4);
        setButtonDrawable.configure(iArr4, iArr3, iArr4);
        setButtonDrawable.Cardinal(iArr4, 2, iArr4);
        setButtonDrawable.configure(iArr4, iArr2, iArr4);
        setButtonDrawable.Cardinal(iArr4, 8, iArr2);
        setButtonDrawable.configure(iArr2, iArr4, iArr2);
        setButtonDrawable.Cardinal(iArr2, 3, iArr4);
        setButtonDrawable.configure(iArr4, iArr3, iArr4);
        int[] iArr5 = new int[6];
        setButtonDrawable.Cardinal(iArr4, 16, iArr5);
        setButtonDrawable.configure(iArr5, iArr2, iArr5);
        setButtonDrawable.Cardinal(iArr5, 35, iArr2);
        setButtonDrawable.configure(iArr2, iArr5, iArr2);
        setButtonDrawable.Cardinal(iArr2, 70, iArr5);
        setButtonDrawable.configure(iArr5, iArr2, iArr5);
        setButtonDrawable.Cardinal(iArr5, 19, iArr2);
        setButtonDrawable.configure(iArr2, iArr4, iArr2);
        setButtonDrawable.Cardinal(iArr2, 20, iArr2);
        setButtonDrawable.configure(iArr2, iArr4, iArr2);
        setButtonDrawable.Cardinal(iArr2, 4, iArr2);
        setButtonDrawable.configure(iArr2, iArr3, iArr2);
        setButtonDrawable.Cardinal(iArr2, 6, iArr2);
        setButtonDrawable.configure(iArr2, iArr3, iArr2);
        setButtonDrawable.configure(iArr2, iArr2);
        setButtonDrawable.configure(iArr2, iArr3);
        if (setKeepScreenOn.Cardinal(iArr, iArr3)) {
            return new setCCAOnCheckedChangeListener(iArr2);
        }
        return null;
    }
}
