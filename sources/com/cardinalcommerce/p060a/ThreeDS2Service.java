package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.ThreeDS2Service */
public final class ThreeDS2Service extends ChallengeParameters.cca_continue {
    public ThreeDS2Service(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public ThreeDS2Service(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    ThreeDS2Service(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    /* renamed from: a */
    private timedout m1824a() {
        timedout timedout = (timedout) this.cca_continue[1];
        if (timedout != null) {
            return timedout;
        }
        getAcsTransactionID[] getacstransactionidArr = this.cca_continue;
        timedout a = m1825a((timedout) this.cca_continue[0], (int[]) null);
        getacstransactionidArr[1] = a;
        return a;
    }

    /* renamed from: a */
    private timedout m1825a(timedout timedout, int[] iArr) {
        timedout timedout2 = (timedout) cca_continue().cleanup();
        if (timedout.CardinalError()) {
            return timedout2;
        }
        timedout timedout3 = new timedout();
        if (iArr == null) {
            iArr = timedout3.cca_continue;
            Transaction.cca_continue(timedout.cca_continue, iArr);
        }
        Transaction.cca_continue(iArr, timedout3.cca_continue);
        Transaction.init(timedout3.cca_continue, timedout2.cca_continue, timedout3.cca_continue);
        return timedout3;
    }

    public final ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
        return this == challengeParameters ? getChallengeTimeout() : valueOf() ? challengeParameters : challengeParameters.valueOf() ? getRequestTimeout() : this.init.cleanup() ? challengeParameters : m1823a(false).getInstance(challengeParameters);
    }

    public final getAcsTransactionID cca_continue(int i) {
        return i == 1 ? m1824a() : super.cca_continue(i);
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (!valueOf() && !this.init.cleanup()) ? m1823a(false).getInstance((ChallengeParameters) this) : this;
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        return this.init.cleanup() ? cca_continue().init() : m1823a(true);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new ThreeDS2Service(cca_continue(), this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new ThreeDS2Service((getSDKAppID) null, sDKVersion, CardinalError());
        }
        throw new IllegalStateException("point not in normal form");
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [com.cardinalcommerce.a.ChallengeParameters] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.cardinalcommerce.p060a.ChallengeParameters getInstance(com.cardinalcommerce.p060a.ChallengeParameters r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r16.valueOf()
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r2 = r17.valueOf()
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0012:
            if (r0 != r1) goto L_0x0019
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x0019:
            com.cardinalcommerce.a.getSDKAppID r3 = r16.cca_continue()
            com.cardinalcommerce.a.getAcsTransactionID r2 = r0.configure
            com.cardinalcommerce.a.timedout r2 = (com.cardinalcommerce.p060a.timedout) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.timedout r4 = (com.cardinalcommerce.p060a.timedout) r4
            com.cardinalcommerce.a.getAcsTransactionID[] r5 = r0.cca_continue
            r6 = 0
            r5 = r5[r6]
            com.cardinalcommerce.a.timedout r5 = (com.cardinalcommerce.p060a.timedout) r5
            com.cardinalcommerce.a.getAcsTransactionID r7 = r17.values()
            com.cardinalcommerce.a.timedout r7 = (com.cardinalcommerce.p060a.timedout) r7
            com.cardinalcommerce.a.getAcsTransactionID r8 = r17.CardinalError()
            com.cardinalcommerce.a.timedout r8 = (com.cardinalcommerce.p060a.timedout) r8
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r6)
            com.cardinalcommerce.a.timedout r1 = (com.cardinalcommerce.p060a.timedout) r1
            r9 = 16
            int[] r9 = new int[r9]
            r10 = 8
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r5.CardinalError()
            if (r14 == 0) goto L_0x0055
            int[] r7 = r7.cca_continue
            int[] r8 = r8.cca_continue
            goto L_0x006b
        L_0x0055:
            int[] r15 = r5.cca_continue
            com.cardinalcommerce.p060a.Transaction.cca_continue(r15, r12)
            int[] r7 = r7.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r12, r7, r11)
            int[] r7 = r5.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r12, r7, r12)
            int[] r7 = r8.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r12, r7, r12)
            r7 = r11
            r8 = r12
        L_0x006b:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0076
            int[] r2 = r2.cca_continue
            int[] r4 = r4.cca_continue
            goto L_0x008c
        L_0x0076:
            int[] r6 = r1.cca_continue
            com.cardinalcommerce.p060a.Transaction.cca_continue(r6, r13)
            int[] r2 = r2.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r13, r2, r9)
            int[] r2 = r1.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r13, r2, r13)
            int[] r2 = r4.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x008c:
            int[] r6 = new int[r10]
            com.cardinalcommerce.p060a.Transaction.cca_continue(r2, r7, r6)
            com.cardinalcommerce.p060a.Transaction.cca_continue(r4, r8, r11)
            boolean r7 = com.cardinalcommerce.p060a.setNextFocusLeftId.getInstance(r6)
            if (r7 == 0) goto L_0x00aa
            boolean r1 = com.cardinalcommerce.p060a.setNextFocusLeftId.getInstance(r11)
            if (r1 == 0) goto L_0x00a5
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a5:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00aa:
            int[] r7 = new int[r10]
            com.cardinalcommerce.p060a.Transaction.cca_continue(r6, r7)
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.Transaction.init(r7, r6, r8)
            com.cardinalcommerce.p060a.Transaction.init(r7, r2, r12)
            com.cardinalcommerce.p060a.Transaction.init((int[]) r8, (int[]) r8)
            com.cardinalcommerce.p060a.setNextFocusLeftId.cca_continue((int[]) r4, (int[]) r8, (int[]) r9)
            int r2 = com.cardinalcommerce.p060a.setNextFocusLeftId.Cardinal(r12, r12, r8)
            com.cardinalcommerce.p060a.Transaction.init((int) r2, (int[]) r8)
            com.cardinalcommerce.a.timedout r4 = new com.cardinalcommerce.a.timedout
            r4.<init>((int[]) r13)
            int[] r2 = r4.cca_continue
            com.cardinalcommerce.p060a.Transaction.cca_continue(r11, r2)
            int[] r2 = r4.cca_continue
            int[] r10 = r4.cca_continue
            com.cardinalcommerce.p060a.Transaction.cca_continue(r2, r8, r10)
            com.cardinalcommerce.a.timedout r10 = new com.cardinalcommerce.a.timedout
            r10.<init>((int[]) r8)
            int[] r2 = r4.cca_continue
            int[] r8 = r10.cca_continue
            com.cardinalcommerce.p060a.Transaction.cca_continue(r12, r2, r8)
            int[] r2 = r10.cca_continue
            com.cardinalcommerce.p060a.Transaction.configure((int[]) r2, (int[]) r11, (int[]) r9)
            int[] r2 = r10.cca_continue
            com.cardinalcommerce.p060a.Transaction.configure(r9, r2)
            com.cardinalcommerce.a.timedout r2 = new com.cardinalcommerce.a.timedout
            r2.<init>((int[]) r6)
            if (r14 != 0) goto L_0x00fb
            int[] r6 = r2.cca_continue
            int[] r5 = r5.cca_continue
            int[] r8 = r2.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r6, r5, r8)
        L_0x00fb:
            if (r15 != 0) goto L_0x0106
            int[] r5 = r2.cca_continue
            int[] r1 = r1.cca_continue
            int[] r6 = r2.cca_continue
            com.cardinalcommerce.p060a.Transaction.init(r5, r1, r6)
        L_0x0106:
            if (r14 == 0) goto L_0x010b
            if (r15 == 0) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            r7 = 0
        L_0x010c:
            com.cardinalcommerce.a.timedout r1 = r0.m1825a(r2, r7)
            r5 = 2
            com.cardinalcommerce.a.getAcsTransactionID[] r6 = new com.cardinalcommerce.p060a.getAcsTransactionID[r5]
            r5 = 0
            r6[r5] = r2
            r2 = 1
            r6[r2] = r1
            com.cardinalcommerce.a.ThreeDS2Service r1 = new com.cardinalcommerce.a.ThreeDS2Service
            boolean r7 = r0.getInstance
            r2 = r1
            r5 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.ThreeDS2Service.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    /* renamed from: a */
    private ThreeDS2Service m1823a(boolean z) {
        timedout timedout = (timedout) this.configure;
        timedout timedout2 = (timedout) this.init;
        timedout timedout3 = (timedout) this.cca_continue[0];
        timedout a = m1824a();
        int[] iArr = new int[8];
        Transaction.cca_continue(timedout.cca_continue, iArr);
        Transaction.init(setNextFocusLeftId.Cardinal(iArr, iArr, iArr) + setNextFocusLeftId.init(a.cca_continue, iArr), iArr);
        int[] iArr2 = new int[8];
        Transaction.Cardinal(timedout2.cca_continue, iArr2);
        int[] iArr3 = new int[8];
        Transaction.init(iArr2, timedout2.cca_continue, iArr3);
        int[] iArr4 = new int[8];
        Transaction.init(iArr3, timedout.cca_continue, iArr4);
        Transaction.Cardinal(iArr4, iArr4);
        int[] iArr5 = new int[8];
        Transaction.cca_continue(iArr3, iArr5);
        Transaction.Cardinal(iArr5, iArr5);
        timedout timedout4 = new timedout(iArr3);
        Transaction.cca_continue(iArr, timedout4.cca_continue);
        Transaction.cca_continue(timedout4.cca_continue, iArr4, timedout4.cca_continue);
        Transaction.cca_continue(timedout4.cca_continue, iArr4, timedout4.cca_continue);
        timedout timedout5 = new timedout(iArr4);
        Transaction.cca_continue(iArr4, timedout4.cca_continue, timedout5.cca_continue);
        Transaction.init(timedout5.cca_continue, iArr, timedout5.cca_continue);
        Transaction.cca_continue(timedout5.cca_continue, iArr5, timedout5.cca_continue);
        timedout timedout6 = new timedout(iArr2);
        if (!setNextFocusLeftId.configure(timedout3.cca_continue)) {
            Transaction.init(timedout6.cca_continue, timedout3.cca_continue, timedout6.cca_continue);
        }
        timedout timedout7 = null;
        if (z) {
            timedout7 = new timedout(iArr5);
            Transaction.init(timedout7.cca_continue, a.cca_continue, timedout7.cca_continue);
            Transaction.Cardinal(timedout7.cca_continue, timedout7.cca_continue);
        }
        return new ThreeDS2Service(cca_continue(), timedout4, timedout5, new getAcsTransactionID[]{timedout6, timedout7}, this.getInstance);
    }
}
