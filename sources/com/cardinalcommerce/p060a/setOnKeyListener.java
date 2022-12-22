package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setOnKeyListener */
public final class setOnKeyListener implements setOnGenericMotionListener {

    /* renamed from: a */
    private setOnDragListener f2904a;

    /* renamed from: b */
    private get3DSServerTransactionID f2905b;

    /* renamed from: a */
    private static BigInteger m2047a(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        boolean z = bigInteger2.signum() < 0;
        BigInteger multiply = bigInteger.multiply(bigInteger2.abs());
        boolean testBit = multiply.testBit(i - 1);
        BigInteger shiftRight = multiply.shiftRight(i);
        if (testBit) {
            shiftRight = shiftRight.add(getSDKReferenceNumber.values);
        }
        return z ? shiftRight.negate() : shiftRight;
    }

    public final get3DSServerTransactionID cca_continue() {
        return this.f2905b;
    }

    public setOnKeyListener(getSDKAppID getsdkappid, setOnDragListener setondraglistener) {
        this.f2904a = setondraglistener;
        this.f2905b = new addParam(getsdkappid.configure(setondraglistener.f2893a));
    }

    public final BigInteger[] init(BigInteger bigInteger) {
        int i = this.f2904a.f2900h;
        BigInteger a = m2047a(bigInteger, this.f2904a.f2898f, i);
        BigInteger a2 = m2047a(bigInteger, this.f2904a.f2899g, i);
        setOnDragListener setondraglistener = this.f2904a;
        return new BigInteger[]{bigInteger.subtract(a.multiply(setondraglistener.f2894b).add(a2.multiply(setondraglistener.f2896d))), a.multiply(setondraglistener.f2895c).add(a2.multiply(setondraglistener.f2897e)).negate()};
    }
}
