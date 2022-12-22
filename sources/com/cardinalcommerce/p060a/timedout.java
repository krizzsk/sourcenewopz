package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.timedout */
public final class timedout extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f3102a = runtimeError.getWarnings;

    /* renamed from: b */
    private static final int[] f3103b = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};
    protected int[] cca_continue;

    public timedout(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f3102a) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.cca_continue = Transaction.init(bigInteger);
    }

    protected timedout(int[] iArr) {
        this.cca_continue = iArr;
    }

    public final BigInteger Cardinal() {
        return setNextFocusLeftId.Cardinal(this.cca_continue);
    }

    public final boolean CardinalError() {
        return setNextFocusLeftId.configure(this.cca_continue);
    }

    public final int cca_continue() {
        return f3102a.bitLength();
    }

    public final boolean cleanup() {
        return setNextFocusLeftId.getInstance(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof timedout)) {
            return false;
        }
        return setNextFocusLeftId.Cardinal(this.cca_continue, ((timedout) obj).cca_continue);
    }

    public final int hashCode() {
        return f3102a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.cca_continue, 8);
    }

    public timedout() {
        this.cca_continue = new int[8];
    }

    public final boolean CardinalActionCode() {
        return (this.cca_continue[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        Transaction.Cardinal(this.cca_continue, ((timedout) getacstransactionid).cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[8];
        Transaction.getInstance(this.cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        Transaction.cca_continue(this.cca_continue, ((timedout) getacstransactionid).cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        Transaction.init(this.cca_continue, ((timedout) getacstransactionid).cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        setAccessibilityTraversalAfter.getInstance(Transaction.f2487a, ((timedout) getacstransactionid).cca_continue, iArr);
        Transaction.init(iArr, this.cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[8];
        Transaction.init(this.cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[8];
        Transaction.cca_continue(this.cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[8];
        setAccessibilityTraversalAfter.getInstance(Transaction.f2487a, this.cca_continue, iArr);
        return new timedout(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.cca_continue;
        if (setNextFocusLeftId.getInstance(iArr) || setNextFocusLeftId.configure(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        Transaction.cca_continue(iArr, iArr2);
        Transaction.init(iArr2, iArr, iArr2);
        Transaction.cca_continue(iArr2, iArr2);
        Transaction.init(iArr2, iArr, iArr2);
        int[] iArr3 = new int[8];
        Transaction.cca_continue(iArr2, iArr3);
        Transaction.init(iArr3, iArr, iArr3);
        int[] iArr4 = new int[8];
        Transaction.configure(iArr3, 3, iArr4);
        Transaction.init(iArr4, iArr2, iArr4);
        Transaction.configure(iArr4, 4, iArr2);
        Transaction.init(iArr2, iArr3, iArr2);
        Transaction.configure(iArr2, 4, iArr4);
        Transaction.init(iArr4, iArr3, iArr4);
        Transaction.configure(iArr4, 15, iArr3);
        Transaction.init(iArr3, iArr4, iArr3);
        Transaction.configure(iArr3, 30, iArr4);
        Transaction.init(iArr4, iArr3, iArr4);
        Transaction.configure(iArr4, 60, iArr3);
        Transaction.init(iArr3, iArr4, iArr3);
        Transaction.configure(iArr3, 11, iArr4);
        Transaction.init(iArr4, iArr2, iArr4);
        Transaction.configure(iArr4, 120, iArr2);
        Transaction.init(iArr2, iArr3, iArr2);
        Transaction.cca_continue(iArr2, iArr2);
        Transaction.cca_continue(iArr2, iArr3);
        if (setNextFocusLeftId.Cardinal(iArr, iArr3)) {
            return new timedout(iArr2);
        }
        Transaction.init(iArr2, f3103b, iArr2);
        Transaction.cca_continue(iArr2, iArr3);
        if (setNextFocusLeftId.Cardinal(iArr, iArr3)) {
            return new timedout(iArr2);
        }
        return null;
    }
}
