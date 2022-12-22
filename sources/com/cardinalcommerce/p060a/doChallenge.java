package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.doChallenge */
public final class doChallenge extends getAcsTransactionID.C1997configure {

    /* renamed from: a */
    private static BigInteger f2529a = setOnClickListener.getWarnings;
    protected int[] init;

    public doChallenge(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2529a) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.init = getAuthenticationRequestParameters.Cardinal(bigInteger);
    }

    protected doChallenge(int[] iArr) {
        this.init = iArr;
    }

    public final BigInteger Cardinal() {
        return setNextFocusLeftId.Cardinal(this.init);
    }

    public final boolean CardinalError() {
        return setNextFocusLeftId.configure(this.init);
    }

    public final int cca_continue() {
        return f2529a.bitLength();
    }

    public final boolean cleanup() {
        return setNextFocusLeftId.getInstance(this.init);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof doChallenge)) {
            return false;
        }
        return setNextFocusLeftId.Cardinal(this.init, ((doChallenge) obj).init);
    }

    public final int hashCode() {
        return f2529a.hashCode() ^ setForegroundTintBlendMode.cca_continue(this.init, 8);
    }

    public doChallenge() {
        this.init = new int[8];
    }

    public final boolean CardinalActionCode() {
        return (this.init[0] & 1) == 1;
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        getAuthenticationRequestParameters.init(this.init, ((doChallenge) getacstransactionid).init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID init() {
        int[] iArr = new int[8];
        getAuthenticationRequestParameters.configure(this.init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        getAuthenticationRequestParameters.Cardinal(this.init, ((doChallenge) getacstransactionid).init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        getAuthenticationRequestParameters.configure(this.init, ((doChallenge) getacstransactionid).init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        int[] iArr = new int[8];
        setAccessibilityTraversalAfter.getInstance(getAuthenticationRequestParameters.f2541a, ((doChallenge) getacstransactionid).init, iArr);
        getAuthenticationRequestParameters.configure(iArr, this.init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID getInstance() {
        int[] iArr = new int[8];
        getAuthenticationRequestParameters.cca_continue(this.init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID configure() {
        int[] iArr = new int[8];
        getAuthenticationRequestParameters.Cardinal(this.init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        int[] iArr = new int[8];
        setAccessibilityTraversalAfter.getInstance(getAuthenticationRequestParameters.f2541a, this.init, iArr);
        return new doChallenge(iArr);
    }

    public final getAcsTransactionID values() {
        int[] iArr = this.init;
        if (setNextFocusLeftId.getInstance(iArr) || setNextFocusLeftId.configure(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        getAuthenticationRequestParameters.Cardinal(iArr, iArr2);
        getAuthenticationRequestParameters.configure(iArr2, iArr, iArr2);
        int[] iArr3 = new int[8];
        getAuthenticationRequestParameters.cca_continue(iArr2, 2, iArr3);
        getAuthenticationRequestParameters.configure(iArr3, iArr2, iArr3);
        int[] iArr4 = new int[8];
        getAuthenticationRequestParameters.cca_continue(iArr3, 2, iArr4);
        getAuthenticationRequestParameters.configure(iArr4, iArr2, iArr4);
        getAuthenticationRequestParameters.cca_continue(iArr4, 6, iArr2);
        getAuthenticationRequestParameters.configure(iArr2, iArr4, iArr2);
        int[] iArr5 = new int[8];
        getAuthenticationRequestParameters.cca_continue(iArr2, 12, iArr5);
        getAuthenticationRequestParameters.configure(iArr5, iArr2, iArr5);
        getAuthenticationRequestParameters.cca_continue(iArr5, 6, iArr2);
        getAuthenticationRequestParameters.configure(iArr2, iArr4, iArr2);
        getAuthenticationRequestParameters.Cardinal(iArr2, iArr4);
        getAuthenticationRequestParameters.configure(iArr4, iArr, iArr4);
        getAuthenticationRequestParameters.cca_continue(iArr4, 31, iArr5);
        getAuthenticationRequestParameters.configure(iArr5, iArr4, iArr2);
        getAuthenticationRequestParameters.cca_continue(iArr5, 32, iArr5);
        getAuthenticationRequestParameters.configure(iArr5, iArr2, iArr5);
        getAuthenticationRequestParameters.cca_continue(iArr5, 62, iArr5);
        getAuthenticationRequestParameters.configure(iArr5, iArr2, iArr5);
        getAuthenticationRequestParameters.cca_continue(iArr5, 4, iArr5);
        getAuthenticationRequestParameters.configure(iArr5, iArr3, iArr5);
        getAuthenticationRequestParameters.cca_continue(iArr5, 32, iArr5);
        getAuthenticationRequestParameters.configure(iArr5, iArr, iArr5);
        getAuthenticationRequestParameters.cca_continue(iArr5, 62, iArr5);
        getAuthenticationRequestParameters.Cardinal(iArr5, iArr3);
        if (setNextFocusLeftId.Cardinal(iArr, iArr3)) {
            return new doChallenge(iArr5);
        }
        return null;
    }
}
