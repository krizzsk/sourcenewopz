package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setTextFontSize */
public final class setTextFontSize extends getAcsTransactionID.getInstance {
    protected long[] configure;

    public setTextFontSize(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.configure = setTextColor.getInstance(bigInteger);
    }

    protected setTextFontSize(long[] jArr) {
        this.configure = jArr;
    }

    public final BigInteger Cardinal() {
        return setKeepScreenOn.configure(this.configure);
    }

    public final boolean CardinalActionCode() {
        return (this.configure[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setKeepScreenOn.Cardinal(this.configure);
    }

    public final int CardinalRenderType() {
        return setTextColor.cca_continue(this.configure);
    }

    public final int cca_continue() {
        return 163;
    }

    public final boolean cleanup() {
        return setKeepScreenOn.init(this.configure);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof setTextFontSize)) {
            return false;
        }
        return setKeepScreenOn.init(this.configure, ((setTextFontSize) obj).configure);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.configure, 3) ^ 163763;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public setTextFontSize() {
        this.configure = new long[3];
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        setTextColor.Cardinal(this.configure, ((setTextFontSize) getacstransactionid).configure, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID init() {
        long[] jArr = new long[3];
        setTextColor.init(this.configure, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        setTextColor.Cardinal(this.configure, ((setTextFontSize) getacstransactionid).configure, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        setTextColor.init(this.configure, ((setTextFontSize) getacstransactionid).configure, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.configure;
        long[] jArr2 = ((setTextFontSize) getacstransactionid).configure;
        long[] jArr3 = ((setTextFontSize) getacstransactionid2).configure;
        long[] jArr4 = ((setTextFontSize) getacstransactionid3).configure;
        long[] jArr5 = new long[6];
        setTextColor.cca_continue(jArr, jArr2, jArr5);
        setTextColor.cca_continue(jArr3, jArr4, jArr5);
        long[] jArr6 = new long[3];
        setTextColor.cca_continue(jArr5, jArr6);
        return new setTextFontSize(jArr6);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        setTextColor.init(this.configure, ((setTextFontSize) getacstransactionid.getSDKVersion()).configure, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[3];
        setTextColor.configure(this.configure, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.configure;
        long[] jArr2 = ((setTextFontSize) getacstransactionid).configure;
        long[] jArr3 = ((setTextFontSize) getacstransactionid2).configure;
        long[] jArr4 = new long[6];
        setTextColor.values(jArr, jArr4);
        setTextColor.cca_continue(jArr2, jArr3, jArr4);
        long[] jArr5 = new long[3];
        setTextColor.cca_continue(jArr4, jArr5);
        return new setTextFontSize(jArr5);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[3];
        setTextColor.cca_continue(this.configure, i, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[3];
        setTextColor.Cardinal(this.configure, jArr);
        return new setTextFontSize(jArr);
    }

    public final getAcsTransactionID values() {
        long[] jArr = new long[3];
        setTextColor.getInstance(this.configure, jArr);
        return new setTextFontSize(jArr);
    }
}
