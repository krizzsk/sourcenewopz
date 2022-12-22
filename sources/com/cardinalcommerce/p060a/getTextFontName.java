package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getTextFontName */
public final class getTextFontName extends getAcsTransactionID.getInstance {
    protected long[] cca_continue;

    public getTextFontName(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.cca_continue = getCornerRadius.Cardinal(bigInteger);
    }

    protected getTextFontName(long[] jArr) {
        this.cca_continue = jArr;
    }

    public final BigInteger Cardinal() {
        return setKeepScreenOn.configure(this.cca_continue);
    }

    public final boolean CardinalActionCode() {
        return (this.cca_continue[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setKeepScreenOn.Cardinal(this.cca_continue);
    }

    public final int CardinalRenderType() {
        return getCornerRadius.init(this.cca_continue);
    }

    public final int cca_continue() {
        return 131;
    }

    public final boolean cleanup() {
        return setKeepScreenOn.init(this.cca_continue);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof getTextFontName)) {
            return false;
        }
        return setKeepScreenOn.init(this.cca_continue, ((getTextFontName) obj).cca_continue);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.cca_continue, 3) ^ 131832;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public getTextFontName() {
        this.cca_continue = new long[3];
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        getCornerRadius.configure(this.cca_continue, ((getTextFontName) getacstransactionid).cca_continue, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID init() {
        long[] jArr = new long[3];
        getCornerRadius.configure(this.cca_continue, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        getCornerRadius.configure(this.cca_continue, ((getTextFontName) getacstransactionid).cca_continue, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        getCornerRadius.Cardinal(this.cca_continue, ((getTextFontName) getacstransactionid).cca_continue, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((getTextFontName) getacstransactionid).cca_continue;
        long[] jArr3 = ((getTextFontName) getacstransactionid2).cca_continue;
        long[] jArr4 = ((getTextFontName) getacstransactionid3).cca_continue;
        long[] jArr5 = new long[5];
        getCornerRadius.cca_continue(jArr, jArr2, jArr5);
        getCornerRadius.cca_continue(jArr3, jArr4, jArr5);
        long[] jArr6 = new long[3];
        getCornerRadius.init(jArr5, jArr6);
        return new getTextFontName(jArr6);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[3];
        getCornerRadius.Cardinal(this.cca_continue, ((getTextFontName) getacstransactionid.getSDKVersion()).cca_continue, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[3];
        getCornerRadius.cca_continue(this.cca_continue, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.cca_continue;
        long[] jArr2 = ((getTextFontName) getacstransactionid).cca_continue;
        long[] jArr3 = ((getTextFontName) getacstransactionid2).cca_continue;
        long[] jArr4 = new long[5];
        getCornerRadius.getWarnings(jArr, jArr4);
        getCornerRadius.cca_continue(jArr2, jArr3, jArr4);
        long[] jArr5 = new long[3];
        getCornerRadius.init(jArr4, jArr5);
        return new getTextFontName(jArr5);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[3];
        getCornerRadius.getInstance(this.cca_continue, i, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[3];
        getCornerRadius.Cardinal(this.cca_continue, jArr);
        return new getTextFontName(jArr);
    }

    public final getAcsTransactionID values() {
        long[] jArr = new long[3];
        getCornerRadius.getInstance(this.cca_continue, jArr);
        return new getTextFontName(jArr);
    }
}
