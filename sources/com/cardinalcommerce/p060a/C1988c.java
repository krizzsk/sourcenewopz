package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.c */
final class C1988c {

    /* renamed from: a */
    final BigInteger f2512a;

    /* renamed from: b */
    final int f2513b;

    public C1988c(BigInteger bigInteger, int i) {
        if (i >= 0) {
            this.f2512a = bigInteger;
            this.f2513b = i;
            return;
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1988c)) {
            return false;
        }
        C1988c cVar = (C1988c) obj;
        return this.f2512a.equals(cVar.f2512a) && this.f2513b == cVar.f2513b;
    }

    public final int hashCode() {
        return this.f2512a.hashCode() ^ this.f2513b;
    }

    /* renamed from: a */
    public final C1988c mo18164a(C1988c cVar) {
        if (this.f2513b == cVar.f2513b) {
            return new C1988c(this.f2512a.add(cVar.f2512a), this.f2513b);
        }
        throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
    }

    /* renamed from: a */
    public final BigInteger mo18165a() {
        C1988c cVar = new C1988c(getSDKReferenceNumber.values, 1);
        int i = this.f2513b;
        if (i >= 0) {
            int i2 = cVar.f2513b;
            if (i != i2) {
                cVar = new C1988c(cVar.f2512a.shiftLeft(i - i2), i);
            }
            C1988c a = mo18164a(cVar);
            return a.f2512a.shiftRight(a.f2513b);
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public final String toString() {
        int i = this.f2513b;
        if (i == 0) {
            return this.f2512a.toString();
        }
        BigInteger shiftRight = this.f2512a.shiftRight(i);
        BigInteger subtract = this.f2512a.subtract(shiftRight.shiftLeft(this.f2513b));
        if (this.f2512a.signum() == -1) {
            subtract = getSDKReferenceNumber.values.shiftLeft(this.f2513b).subtract(subtract);
        }
        if (shiftRight.signum() == -1 && !subtract.equals(getSDKReferenceNumber.CardinalError)) {
            shiftRight = shiftRight.add(getSDKReferenceNumber.values);
        }
        String obj = shiftRight.toString();
        char[] cArr = new char[this.f2513b];
        String bigInteger = subtract.toString(2);
        int length = bigInteger.length();
        int i2 = this.f2513b - length;
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = '0';
        }
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i2 + i4] = bigInteger.charAt(i4);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(obj);
        stringBuffer.append(".");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
