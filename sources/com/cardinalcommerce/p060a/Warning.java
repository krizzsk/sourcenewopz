package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.Warning */
public final class Warning extends ChallengeParameters.cca_continue {
    public Warning(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public Warning(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    Warning(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new Warning(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new Warning((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.getID r2 = (com.cardinalcommerce.p060a.getID) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.getID r4 = (com.cardinalcommerce.p060a.getID) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.getID r5 = (com.cardinalcommerce.p060a.getID) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.getID r6 = (com.cardinalcommerce.p060a.getID) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.getID r7 = (com.cardinalcommerce.p060a.getID) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.getID r1 = (com.cardinalcommerce.p060a.getID) r1
            r9 = 16
            int[] r9 = new int[r9]
            r10 = 8
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0055
            int[] r5 = r5.configure
            int[] r6 = r6.configure
            goto L_0x006b
        L_0x0055:
            int[] r15 = r7.configure
            com.cardinalcommerce.p060a.ErrorMessage.configure(r15, r12)
            int[] r5 = r5.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r12, (int[]) r5, (int[]) r11)
            int[] r5 = r7.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r12, (int[]) r5, (int[]) r12)
            int[] r5 = r6.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r12, (int[]) r5, (int[]) r12)
            r5 = r11
            r6 = r12
        L_0x006b:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0076
            int[] r2 = r2.configure
            int[] r4 = r4.configure
            goto L_0x008c
        L_0x0076:
            int[] r8 = r1.configure
            com.cardinalcommerce.p060a.ErrorMessage.configure(r8, r13)
            int[] r2 = r2.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r13, (int[]) r2, (int[]) r9)
            int[] r2 = r1.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r13, (int[]) r2, (int[]) r13)
            int[] r2 = r4.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r13, (int[]) r2, (int[]) r13)
            r2 = r9
            r4 = r13
        L_0x008c:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.ErrorMessage.configure(r2, r5, r8)
            com.cardinalcommerce.p060a.ErrorMessage.configure(r4, r6, r11)
            boolean r5 = com.cardinalcommerce.p060a.setNextFocusLeftId.getInstance(r8)
            if (r5 == 0) goto L_0x00aa
            boolean r1 = com.cardinalcommerce.p060a.setNextFocusLeftId.getInstance(r11)
            if (r1 == 0) goto L_0x00a5
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a5:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00aa:
            com.cardinalcommerce.p060a.ErrorMessage.configure(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r12, (int[]) r8, (int[]) r5)
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r12, (int[]) r2, (int[]) r12)
            com.cardinalcommerce.p060a.ErrorMessage.cca_continue(r5, r5)
            com.cardinalcommerce.p060a.setNextFocusLeftId.cca_continue((int[]) r4, (int[]) r5, (int[]) r9)
            int r2 = com.cardinalcommerce.p060a.setNextFocusLeftId.Cardinal(r12, r12, r5)
            com.cardinalcommerce.p060a.ErrorMessage.getInstance((int) r2, (int[]) r5)
            com.cardinalcommerce.a.getID r4 = new com.cardinalcommerce.a.getID
            r4.<init>((int[]) r13)
            int[] r2 = r4.configure
            com.cardinalcommerce.p060a.ErrorMessage.configure(r11, r2)
            int[] r2 = r4.configure
            int[] r6 = r4.configure
            com.cardinalcommerce.p060a.ErrorMessage.configure(r2, r5, r6)
            com.cardinalcommerce.a.getID r6 = new com.cardinalcommerce.a.getID
            r6.<init>((int[]) r5)
            int[] r2 = r4.configure
            int[] r5 = r6.configure
            com.cardinalcommerce.p060a.ErrorMessage.configure(r12, r2, r5)
            int[] r2 = r6.configure
            com.cardinalcommerce.p060a.ErrorMessage.cca_continue(r2, r11, r9)
            int[] r2 = r6.configure
            com.cardinalcommerce.p060a.ErrorMessage.getInstance((int[]) r9, (int[]) r2)
            com.cardinalcommerce.a.getID r2 = new com.cardinalcommerce.a.getID
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f9
            int[] r5 = r2.configure
            int[] r7 = r7.configure
            int[] r8 = r2.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r5, (int[]) r7, (int[]) r8)
        L_0x00f9:
            if (r15 != 0) goto L_0x0104
            int[] r5 = r2.configure
            int[] r1 = r1.configure
            int[] r7 = r2.configure
            com.cardinalcommerce.p060a.ErrorMessage.Cardinal((int[]) r5, (int[]) r1, (int[]) r7)
        L_0x0104:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.Warning r8 = new com.cardinalcommerce.a.Warning
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.Warning.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        getID getid = (getID) this.init;
        if (getid.cleanup()) {
            return cca_continue.init();
        }
        getID getid2 = (getID) this.configure;
        getID getid3 = (getID) this.cca_continue[0];
        int[] iArr = new int[8];
        int[] iArr2 = new int[8];
        int[] iArr3 = new int[8];
        ErrorMessage.configure(getid.configure, iArr3);
        int[] iArr4 = new int[8];
        ErrorMessage.configure(iArr3, iArr4);
        boolean CardinalError = getid3.CardinalError();
        int[] iArr5 = getid3.configure;
        if (!CardinalError) {
            ErrorMessage.configure(getid3.configure, iArr2);
            iArr5 = iArr2;
        }
        ErrorMessage.configure(getid2.configure, iArr5, iArr);
        ErrorMessage.getInstance(getid2.configure, iArr5, iArr2);
        ErrorMessage.Cardinal(iArr2, iArr, iArr2);
        ErrorMessage.getInstance(setNextFocusLeftId.Cardinal(iArr2, iArr2, iArr2), iArr2);
        ErrorMessage.Cardinal(iArr3, getid2.configure, iArr3);
        ErrorMessage.getInstance(setDrawingCacheQuality.getInstance(8, iArr3, 0), iArr3);
        ErrorMessage.getInstance(setDrawingCacheQuality.init(8, iArr4, 0, iArr), iArr);
        getID getid4 = new getID(iArr4);
        ErrorMessage.configure(iArr2, getid4.configure);
        ErrorMessage.configure(getid4.configure, iArr3, getid4.configure);
        ErrorMessage.configure(getid4.configure, iArr3, getid4.configure);
        getID getid5 = new getID(iArr3);
        ErrorMessage.configure(iArr3, getid4.configure, getid5.configure);
        ErrorMessage.Cardinal(getid5.configure, iArr2, getid5.configure);
        ErrorMessage.configure(getid5.configure, iArr, getid5.configure);
        getID getid6 = new getID(iArr2);
        ErrorMessage.Cardinal(getid.configure, getid6.configure);
        if (!CardinalError) {
            ErrorMessage.Cardinal(getid6.configure, getid3.configure, getid6.configure);
        }
        return new Warning(cca_continue, getid4, getid5, new getAcsTransactionID[]{getid6}, this.getInstance);
    }

    public final ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
        if (this == challengeParameters) {
            return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
        }
        if (valueOf()) {
            return challengeParameters;
        }
        if (challengeParameters.valueOf()) {
            return getRequestTimeout();
        }
        return this.init.cleanup() ? challengeParameters : getRequestTimeout().getInstance(challengeParameters);
    }
}
