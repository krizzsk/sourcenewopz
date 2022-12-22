package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.completed */
public final class completed extends AuthenticationRequestParameters {
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.cardinalcommerce.p060a.ChallengeParameters init(com.cardinalcommerce.p060a.ChallengeParameters r12, java.math.BigInteger r13) {
        /*
            r11 = this;
            int r0 = r13.bitLength()
            int r0 = com.cardinalcommerce.p060a.createTransaction.Cardinal((int) r0)
            r1 = 16
            int r0 = java.lang.Math.min(r1, r0)
            r1 = 2
            int r0 = java.lang.Math.max(r1, r0)
            r1 = 1
            com.cardinalcommerce.a.cancelled r2 = com.cardinalcommerce.p060a.createTransaction.Cardinal((com.cardinalcommerce.p060a.ChallengeParameters) r12, (int) r0, (boolean) r1)
            com.cardinalcommerce.a.ChallengeParameters[] r3 = r2.configure
            com.cardinalcommerce.a.ChallengeParameters[] r2 = r2.cca_continue
            int[] r13 = com.cardinalcommerce.p060a.createTransaction.getInstance(r0, r13)
            com.cardinalcommerce.a.getSDKAppID r12 = r12.cca_continue()
            com.cardinalcommerce.a.ChallengeParameters r12 = r12.init()
            int r4 = r13.length
            r5 = 65535(0xffff, float:9.1834E-41)
            if (r4 <= r1) goto L_0x0065
            int r4 = r4 + -1
            r12 = r13[r4]
            int r6 = r12 >> 16
            r12 = r12 & r5
            int r7 = java.lang.Math.abs(r6)
            if (r6 >= 0) goto L_0x003d
            r6 = r2
            goto L_0x003e
        L_0x003d:
            r6 = r3
        L_0x003e:
            int r8 = r7 << 2
            int r9 = r1 << r0
            if (r8 >= r9) goto L_0x0060
            byte[] r8 = com.cardinalcommerce.p060a.C1995f.f2531a
            byte r8 = r8[r7]
            int r9 = r0 - r8
            int r8 = r8 - r1
            int r8 = r1 << r8
            r7 = r7 ^ r8
            int r0 = r0 - r1
            int r0 = r1 << r0
            int r0 = r0 - r1
            int r7 = r7 << r9
            int r7 = r7 + r1
            int r0 = r0 >>> r1
            r0 = r6[r0]
            int r7 = r7 >>> r1
            r6 = r6[r7]
            com.cardinalcommerce.a.ChallengeParameters r0 = r0.getInstance((com.cardinalcommerce.p060a.ChallengeParameters) r6)
            int r12 = r12 - r9
            goto L_0x0081
        L_0x0060:
            int r0 = r7 >>> 1
            r0 = r6[r0]
            goto L_0x0081
        L_0x0065:
            if (r4 <= 0) goto L_0x0086
            int r4 = r4 + -1
            r0 = r13[r4]
            int r6 = r0 >> 16
            r0 = r0 & r5
            int r7 = java.lang.Math.abs(r6)
            if (r6 >= 0) goto L_0x0076
            r6 = r2
            goto L_0x0077
        L_0x0076:
            r6 = r3
        L_0x0077:
            int r7 = r7 >>> r1
            r6 = r6[r7]
            com.cardinalcommerce.a.ChallengeParameters r12 = r12.Cardinal((com.cardinalcommerce.p060a.ChallengeParameters) r6)
            r10 = r0
            r0 = r12
            r12 = r10
        L_0x0081:
            com.cardinalcommerce.a.ChallengeParameters r12 = r0.getInstance((int) r12)
            goto L_0x0065
        L_0x0086:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.completed.init(com.cardinalcommerce.a.ChallengeParameters, java.math.BigInteger):com.cardinalcommerce.a.ChallengeParameters");
    }
}
