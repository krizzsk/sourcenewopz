package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.onContextItemSelected */
public final class onContextItemSelected extends getAcsTransactionID.getInstance {
    protected long[] getInstance;

    public onContextItemSelected(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.getInstance = setVerticalScrollbarThumbDrawable.getInstance(bigInteger);
    }

    protected onContextItemSelected(long[] jArr) {
        this.getInstance = jArr;
    }

    public final boolean CardinalActionCode() {
        return (this.getInstance[0] & 1) != 0;
    }

    public final boolean CardinalError() {
        return setNextFocusForwardId.getInstance(this.getInstance);
    }

    public final int CardinalRenderType() {
        return setVerticalScrollbarThumbDrawable.init(this.getInstance);
    }

    public final int cca_continue() {
        return 571;
    }

    public final boolean cleanup() {
        return setNextFocusForwardId.init(this.getInstance);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof onContextItemSelected)) {
            return false;
        }
        return setNextFocusForwardId.init(this.getInstance, ((onContextItemSelected) obj).getInstance);
    }

    public final getAcsTransactionID getInstance() {
        return this;
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.getInstance(this.getInstance, 9) ^ 5711052;
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        return Cardinal(getacstransactionid, getacstransactionid2, getacstransactionid3);
    }

    public onContextItemSelected() {
        this.getInstance = new long[9];
    }

    public final BigInteger Cardinal() {
        long[] jArr = this.getInstance;
        byte[] bArr = new byte[72];
        for (int i = 0; i < 9; i++) {
            long j = jArr[i];
            if (j != 0) {
                int i2 = (8 - i) << 3;
                setMinimumWidth.getInstance((int) (j >>> 32), bArr, i2);
                setMinimumWidth.getInstance((int) j, bArr, i2 + 4);
            }
        }
        return new BigInteger(1, bArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.cca_continue(this.getInstance, ((onContextItemSelected) getacstransactionid).getInstance, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID init() {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.configure(this.getInstance, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.cca_continue(this.getInstance, ((onContextItemSelected) getacstransactionid).getInstance, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID init(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.configure(this.getInstance, ((onContextItemSelected) getacstransactionid).getInstance, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID Cardinal(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID getacstransactionid3) {
        long[] jArr = this.getInstance;
        long[] jArr2 = ((onContextItemSelected) getacstransactionid).getInstance;
        long[] jArr3 = ((onContextItemSelected) getacstransactionid2).getInstance;
        long[] jArr4 = ((onContextItemSelected) getacstransactionid3).getInstance;
        long[] jArr5 = new long[18];
        setVerticalScrollbarThumbDrawable.getInstance(jArr, jArr2, jArr5);
        setVerticalScrollbarThumbDrawable.getInstance(jArr3, jArr4, jArr5);
        long[] jArr6 = new long[9];
        setVerticalScrollbarThumbDrawable.cca_continue(jArr5, jArr6);
        return new onContextItemSelected(jArr6);
    }

    public final getAcsTransactionID getInstance(getAcsTransactionID getacstransactionid) {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.configure(this.getInstance, ((onContextItemSelected) getacstransactionid.getSDKVersion()).getInstance, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID configure() {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.getInstance(this.getInstance, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        long[] jArr = this.getInstance;
        long[] jArr2 = ((onContextItemSelected) getacstransactionid).getInstance;
        long[] jArr3 = ((onContextItemSelected) getacstransactionid2).getInstance;
        long[] jArr4 = new long[18];
        setVerticalScrollbarThumbDrawable.getSDKVersion(jArr, jArr4);
        setVerticalScrollbarThumbDrawable.getInstance(jArr2, jArr3, jArr4);
        long[] jArr5 = new long[9];
        setVerticalScrollbarThumbDrawable.cca_continue(jArr4, jArr5);
        return new onContextItemSelected(jArr5);
    }

    public final getAcsTransactionID getInstance(int i) {
        if (i <= 0) {
            return this;
        }
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.init(this.getInstance, i, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID getSDKVersion() {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.Cardinal(this.getInstance, jArr);
        return new onContextItemSelected(jArr);
    }

    public final getAcsTransactionID values() {
        long[] jArr = new long[9];
        setVerticalScrollbarThumbDrawable.init(this.getInstance, jArr);
        return new onContextItemSelected(jArr);
    }
}
