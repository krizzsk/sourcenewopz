package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.g */
final class C1996g {

    /* renamed from: a */
    public static final C2012h[] f2534a;

    /* renamed from: b */
    public static final C2012h[] f2535b;

    /* renamed from: c */
    private static final BigInteger f2536c = getSDKReferenceNumber.values.negate();

    /* renamed from: d */
    private static final BigInteger f2537d = getSDKReferenceNumber.CardinalEnvironment.negate();

    /* renamed from: e */
    private static final BigInteger f2538e = getSDKReferenceNumber.CardinalUiType.negate();

    /* renamed from: f */
    private static byte[][] f2539f = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};

    /* renamed from: g */
    private static byte[][] f2540g = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};

    static {
        BigInteger bigInteger = f2536c;
        f2534a = new C2012h[]{null, new C2012h(getSDKReferenceNumber.values, getSDKReferenceNumber.CardinalError), null, new C2012h(f2538e, f2536c), null, new C2012h(bigInteger, bigInteger), null, new C2012h(getSDKReferenceNumber.values, f2536c), null};
        BigInteger bigInteger2 = getSDKReferenceNumber.values;
        f2535b = new C2012h[]{null, new C2012h(getSDKReferenceNumber.values, getSDKReferenceNumber.CardinalError), null, new C2012h(f2538e, getSDKReferenceNumber.values), null, new C2012h(f2536c, getSDKReferenceNumber.values), null, new C2012h(bigInteger2, bigInteger2), null};
    }

    C1996g() {
    }

    /* renamed from: a */
    public static byte m1874a(int i) {
        return (byte) (i == 0 ? -1 : 1);
    }

    /* renamed from: a */
    private static C1988c m1875a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b, int i, int i2) {
        int i3 = ((i + 5) / 2) + 10;
        BigInteger multiply = bigInteger2.multiply(bigInteger.shiftRight(((i - i3) - 2) + b));
        BigInteger add = multiply.add(bigInteger3.multiply(multiply.shiftRight(i)));
        int i4 = i3 - 10;
        BigInteger shiftRight = add.shiftRight(i4);
        if (add.testBit(i4 - 1)) {
            shiftRight = shiftRight.add(getSDKReferenceNumber.values);
        }
        return new C1988c(shiftRight, 10);
    }

    /* renamed from: a */
    public static BigInteger m1877a(byte b) {
        return BigInteger.valueOf(b == 1 ? 6 : 10);
    }

    /* renamed from: a */
    private static BigInteger[] m1880a(byte b, int i, boolean z) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        if (b == 1 || b == -1) {
            if (z) {
                bigInteger = getSDKReferenceNumber.CardinalEnvironment;
                bigInteger2 = BigInteger.valueOf((long) b);
            } else {
                bigInteger = getSDKReferenceNumber.CardinalError;
                bigInteger2 = getSDKReferenceNumber.values;
            }
            int i2 = 1;
            while (i2 < i) {
                i2++;
                BigInteger bigInteger3 = bigInteger2;
                bigInteger2 = (b == 1 ? bigInteger2 : bigInteger2.negate()).subtract(bigInteger.shiftLeft(1));
                bigInteger = bigInteger3;
            }
            return new BigInteger[]{bigInteger, bigInteger2};
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    /* renamed from: a */
    public static BigInteger[] m1881a(getSDKAppID.Cardinal cardinal) {
        int i;
        if (cardinal.CardinalRenderType()) {
            int configure = cardinal.configure();
            int intValue = cardinal.cleanup().Cardinal().intValue();
            byte a = m1874a(intValue);
            BigInteger CardinalError = cardinal.CardinalError();
            if (CardinalError != null) {
                if (CardinalError.equals(getSDKReferenceNumber.CardinalEnvironment)) {
                    i = 1;
                } else if (CardinalError.equals(getSDKReferenceNumber.CardinalRenderType)) {
                    i = 2;
                }
                BigInteger[] a2 = m1880a(a, (configure + 3) - intValue, false);
                if (a == 1) {
                    a2[0] = a2[0].negate();
                    a2[1] = a2[1].negate();
                }
                return new BigInteger[]{getSDKReferenceNumber.values.add(a2[1]).shiftRight(i), getSDKReferenceNumber.values.add(a2[0]).shiftRight(i).negate()};
            }
            throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011a, code lost:
        if (r7.f2512a.compareTo(com.cardinalcommerce.p060a.getSDKReferenceNumber.values.shiftLeft(r7.f2513b)) >= 0) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x012b, code lost:
        if (r5.f2512a.compareTo(f2537d.shiftLeft(r5.f2513b)) < 0) goto L_0x012d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.p060a.C2012h m1876a(java.math.BigInteger r11, int r12, byte r13, java.math.BigInteger[] r14, byte r15) {
        /*
            r0 = 0
            r1 = 1
            if (r15 != r1) goto L_0x000d
            r2 = r14[r0]
            r3 = r14[r1]
            java.math.BigInteger r2 = r2.add(r3)
            goto L_0x0015
        L_0x000d:
            r2 = r14[r0]
            r3 = r14[r1]
            java.math.BigInteger r2 = r2.subtract(r3)
        L_0x0015:
            java.math.BigInteger[] r3 = m1880a(r15, r12, r1)
            r3 = r3[r1]
            r5 = r14[r0]
            r9 = 10
            r4 = r11
            r6 = r3
            r7 = r13
            r8 = r12
            com.cardinalcommerce.a.c r10 = m1875a(r4, r5, r6, r7, r8, r9)
            r5 = r14[r1]
            com.cardinalcommerce.a.c r12 = m1875a(r4, r5, r6, r7, r8, r9)
            int r13 = r10.f2513b
            int r3 = r12.f2513b
            if (r3 != r13) goto L_0x0181
            r13 = -1
            if (r15 == r1) goto L_0x0041
            if (r15 != r13) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "mu must be 1 or -1"
            r11.<init>(r12)
            throw r11
        L_0x0041:
            java.math.BigInteger r3 = r10.mo18165a()
            java.math.BigInteger r4 = r12.mo18165a()
            com.cardinalcommerce.a.c r5 = new com.cardinalcommerce.a.c
            java.math.BigInteger r6 = r10.f2512a
            int r7 = r10.f2513b
            java.math.BigInteger r7 = r3.shiftLeft(r7)
            java.math.BigInteger r6 = r6.subtract(r7)
            int r7 = r10.f2513b
            r5.<init>(r6, r7)
            com.cardinalcommerce.a.c r6 = new com.cardinalcommerce.a.c
            java.math.BigInteger r7 = r12.f2512a
            int r8 = r12.f2513b
            java.math.BigInteger r8 = r4.shiftLeft(r8)
            java.math.BigInteger r7 = r7.subtract(r8)
            int r12 = r12.f2513b
            r6.<init>(r7, r12)
            com.cardinalcommerce.a.c r12 = r5.mo18164a(r5)
            if (r15 != r1) goto L_0x007a
            com.cardinalcommerce.a.c r12 = r12.mo18164a(r6)
            goto L_0x008b
        L_0x007a:
            com.cardinalcommerce.a.c r7 = new com.cardinalcommerce.a.c
            java.math.BigInteger r8 = r6.f2512a
            java.math.BigInteger r8 = r8.negate()
            int r9 = r6.f2513b
            r7.<init>(r8, r9)
            com.cardinalcommerce.a.c r12 = r12.mo18164a(r7)
        L_0x008b:
            com.cardinalcommerce.a.c r7 = r6.mo18164a(r6)
            com.cardinalcommerce.a.c r7 = r7.mo18164a(r6)
            com.cardinalcommerce.a.c r6 = r7.mo18164a(r6)
            if (r15 != r1) goto L_0x00af
            com.cardinalcommerce.a.c r8 = new com.cardinalcommerce.a.c
            java.math.BigInteger r9 = r7.f2512a
            java.math.BigInteger r9 = r9.negate()
            int r7 = r7.f2513b
            r8.<init>(r9, r7)
            com.cardinalcommerce.a.c r7 = r5.mo18164a(r8)
            com.cardinalcommerce.a.c r5 = r5.mo18164a(r6)
            goto L_0x00c4
        L_0x00af:
            com.cardinalcommerce.a.c r7 = r5.mo18164a(r7)
            com.cardinalcommerce.a.c r8 = new com.cardinalcommerce.a.c
            java.math.BigInteger r9 = r6.f2512a
            java.math.BigInteger r9 = r9.negate()
            int r6 = r6.f2513b
            r8.<init>(r9, r6)
            com.cardinalcommerce.a.c r5 = r5.mo18164a(r8)
        L_0x00c4:
            java.math.BigInteger r6 = com.cardinalcommerce.p060a.getSDKReferenceNumber.values
            java.math.BigInteger r8 = r12.f2512a
            int r9 = r12.f2513b
            java.math.BigInteger r6 = r6.shiftLeft(r9)
            int r6 = r8.compareTo(r6)
            if (r6 < 0) goto L_0x00e7
            java.math.BigInteger r6 = f2536c
            java.math.BigInteger r8 = r7.f2512a
            int r9 = r7.f2513b
            java.math.BigInteger r6 = r6.shiftLeft(r9)
            int r6 = r8.compareTo(r6)
            if (r6 >= 0) goto L_0x00e5
            goto L_0x00f7
        L_0x00e5:
            r6 = 1
            goto L_0x00fb
        L_0x00e7:
            java.math.BigInteger r6 = com.cardinalcommerce.p060a.getSDKReferenceNumber.CardinalEnvironment
            java.math.BigInteger r8 = r5.f2512a
            int r9 = r5.f2513b
            java.math.BigInteger r6 = r6.shiftLeft(r9)
            int r6 = r8.compareTo(r6)
            if (r6 < 0) goto L_0x00fa
        L_0x00f7:
            r8 = r15
            r6 = 0
            goto L_0x00fc
        L_0x00fa:
            r6 = 0
        L_0x00fb:
            r8 = 0
        L_0x00fc:
            java.math.BigInteger r9 = f2536c
            java.math.BigInteger r10 = r12.f2512a
            int r12 = r12.f2513b
            java.math.BigInteger r12 = r9.shiftLeft(r12)
            int r12 = r10.compareTo(r12)
            if (r12 >= 0) goto L_0x011d
            java.math.BigInteger r12 = com.cardinalcommerce.p060a.getSDKReferenceNumber.values
            java.math.BigInteger r5 = r7.f2512a
            int r7 = r7.f2513b
            java.math.BigInteger r12 = r12.shiftLeft(r7)
            int r12 = r5.compareTo(r12)
            if (r12 < 0) goto L_0x0130
            goto L_0x012d
        L_0x011d:
            java.math.BigInteger r12 = f2537d
            java.math.BigInteger r13 = r5.f2512a
            int r5 = r5.f2513b
            java.math.BigInteger r12 = r12.shiftLeft(r5)
            int r12 = r13.compareTo(r12)
            if (r12 >= 0) goto L_0x012f
        L_0x012d:
            int r12 = -r15
            byte r8 = (byte) r12
        L_0x012f:
            r13 = r6
        L_0x0130:
            long r12 = (long) r13
            java.math.BigInteger r12 = java.math.BigInteger.valueOf(r12)
            java.math.BigInteger r12 = r3.add(r12)
            long r5 = (long) r8
            java.math.BigInteger r13 = java.math.BigInteger.valueOf(r5)
            java.math.BigInteger r13 = r4.add(r13)
            com.cardinalcommerce.a.h r15 = new com.cardinalcommerce.a.h
            r15.<init>(r12, r13)
            java.math.BigInteger r12 = r15.f2590a
            java.math.BigInteger r12 = r2.multiply(r12)
            java.math.BigInteger r11 = r11.subtract(r12)
            r12 = 2
            java.math.BigInteger r12 = java.math.BigInteger.valueOf(r12)
            r13 = r14[r1]
            java.math.BigInteger r12 = r12.multiply(r13)
            java.math.BigInteger r13 = r15.f2591b
            java.math.BigInteger r12 = r12.multiply(r13)
            java.math.BigInteger r11 = r11.subtract(r12)
            r12 = r14[r1]
            java.math.BigInteger r13 = r15.f2590a
            java.math.BigInteger r12 = r12.multiply(r13)
            r13 = r14[r0]
            java.math.BigInteger r14 = r15.f2591b
            java.math.BigInteger r13 = r13.multiply(r14)
            java.math.BigInteger r12 = r12.subtract(r13)
            com.cardinalcommerce.a.h r13 = new com.cardinalcommerce.a.h
            r13.<init>(r11, r12)
            return r13
        L_0x0181:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "lambda0 and lambda1 do not have same scale"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C1996g.m1876a(java.math.BigInteger, int, byte, java.math.BigInteger[], byte):com.cardinalcommerce.a.h");
    }

    /* renamed from: a */
    public static byte[] m1878a(byte b, C2012h hVar, BigInteger bigInteger, BigInteger bigInteger2, C2012h[] hVarArr) {
        BigInteger subtract;
        boolean z;
        if (b == 1 || b == -1) {
            BigInteger multiply = hVar.f2590a.multiply(hVar.f2590a);
            BigInteger multiply2 = hVar.f2590a.multiply(hVar.f2591b);
            BigInteger shiftLeft = hVar.f2591b.multiply(hVar.f2591b).shiftLeft(1);
            if (b == 1) {
                subtract = multiply.add(multiply2);
            } else if (b == -1) {
                subtract = multiply.subtract(multiply2);
            } else {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            int bitLength = subtract.add(shiftLeft).bitLength();
            byte[] bArr = new byte[(bitLength > 30 ? bitLength + 4 + 4 : 38)];
            BigInteger shiftRight = bigInteger.shiftRight(1);
            BigInteger bigInteger3 = hVar.f2590a;
            BigInteger bigInteger4 = hVar.f2591b;
            int i = 0;
            while (true) {
                if (bigInteger3.equals(getSDKReferenceNumber.CardinalError) && bigInteger4.equals(getSDKReferenceNumber.CardinalError)) {
                    return bArr;
                }
                if (bigInteger3.testBit(0)) {
                    BigInteger mod = bigInteger3.add(bigInteger4.multiply(bigInteger2)).mod(bigInteger);
                    if (mod.compareTo(shiftRight) >= 0) {
                        mod = mod.subtract(bigInteger);
                    }
                    byte intValue = (byte) mod.intValue();
                    bArr[i] = intValue;
                    if (intValue < 0) {
                        intValue = (byte) (-intValue);
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        bigInteger3 = bigInteger3.subtract(hVarArr[intValue].f2590a);
                        bigInteger4 = bigInteger4.subtract(hVarArr[intValue].f2591b);
                    } else {
                        bigInteger3 = bigInteger3.add(hVarArr[intValue].f2590a);
                        bigInteger4 = bigInteger4.add(hVarArr[intValue].f2591b);
                    }
                } else {
                    bArr[i] = 0;
                }
                BigInteger shiftRight2 = bigInteger3.shiftRight(1);
                BigInteger add = b == 1 ? bigInteger4.add(shiftRight2) : bigInteger4.subtract(shiftRight2);
                i++;
                BigInteger negate = bigInteger3.shiftRight(1).negate();
                bigInteger3 = add;
                bigInteger4 = negate;
            }
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
    }

    /* renamed from: a */
    public static ChallengeParameters.Cardinal[] m1879a(ChallengeParameters.Cardinal cardinal, byte b) {
        byte[][] bArr = b == 0 ? f2539f : f2540g;
        ChallengeParameters.Cardinal[] cardinalArr = new ChallengeParameters.Cardinal[((bArr.length + 1) >>> 1)];
        cardinalArr[0] = cardinal;
        int length = bArr.length;
        for (int i = 3; i < length; i += 2) {
            int i2 = i >>> 1;
            byte[] bArr2 = bArr[i];
            ChallengeParameters.Cardinal cardinal2 = (ChallengeParameters.Cardinal) cardinal.cca_continue().init();
            ChallengeParameters.Cardinal cardinal3 = (ChallengeParameters.Cardinal) cardinal.getString();
            int i3 = 0;
            for (int length2 = bArr2.length - 1; length2 >= 0; length2--) {
                i3++;
                byte b2 = bArr2[length2];
                if (b2 != 0) {
                    cardinal2 = (ChallengeParameters.Cardinal) cardinal2.Cardinal(i3).getInstance((ChallengeParameters) b2 > 0 ? cardinal : cardinal3);
                    i3 = 0;
                }
            }
            if (i3 > 0) {
                cardinal2 = cardinal2.Cardinal(i3);
            }
            cardinalArr[i2] = cardinal2;
        }
        cardinal.cca_continue().getInstance(cardinalArr);
        return cardinalArr;
    }
}
