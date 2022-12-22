package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setOnDragListener */
public final class setOnDragListener {

    /* renamed from: a */
    BigInteger f2893a;

    /* renamed from: b */
    BigInteger f2894b;

    /* renamed from: c */
    BigInteger f2895c;

    /* renamed from: d */
    BigInteger f2896d;

    /* renamed from: e */
    BigInteger f2897e;

    /* renamed from: f */
    BigInteger f2898f;

    /* renamed from: g */
    BigInteger f2899g;

    /* renamed from: h */
    int f2900h;

    public setOnDragListener(BigInteger bigInteger, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        m2045a(bigIntegerArr, "v1");
        m2045a(bigIntegerArr2, "v2");
        this.f2893a = bigInteger;
        this.f2894b = bigIntegerArr[0];
        this.f2895c = bigIntegerArr[1];
        this.f2896d = bigIntegerArr2[0];
        this.f2897e = bigIntegerArr2[1];
        this.f2898f = bigInteger2;
        this.f2899g = bigInteger3;
        this.f2900h = i;
    }

    /* renamed from: a */
    private static void m2045a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            StringBuilder sb = new StringBuilder("'");
            sb.append(str);
            sb.append("' must consist of exactly 2 (non-null) values");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
