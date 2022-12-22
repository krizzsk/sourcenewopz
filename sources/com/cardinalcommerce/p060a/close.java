package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.close */
public final class close extends ChallengeParameters.cca_continue {
    public close(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public close(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    close(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new close(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new close((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.doChallenge r2 = (com.cardinalcommerce.p060a.doChallenge) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.doChallenge r4 = (com.cardinalcommerce.p060a.doChallenge) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.doChallenge r5 = (com.cardinalcommerce.p060a.doChallenge) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.doChallenge r6 = (com.cardinalcommerce.p060a.doChallenge) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.doChallenge r7 = (com.cardinalcommerce.p060a.doChallenge) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.doChallenge r1 = (com.cardinalcommerce.p060a.doChallenge) r1
            r9 = 16
            int[] r9 = new int[r9]
            r10 = 8
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0055
            int[] r5 = r5.init
            int[] r6 = r6.init
            goto L_0x006b
        L_0x0055:
            int[] r15 = r7.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r15, r12)
            int[] r5 = r5.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r12, r5, r11)
            int[] r5 = r7.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r12, r5, r12)
            int[] r5 = r6.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x006b:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0076
            int[] r2 = r2.init
            int[] r4 = r4.init
            goto L_0x008c
        L_0x0076:
            int[] r8 = r1.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r8, r13)
            int[] r2 = r2.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r13, r2, r9)
            int[] r2 = r1.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r13, r2, r13)
            int[] r2 = r4.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x008c:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r2, r5, r8)
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r4, r6, r11)
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
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r12, r8, r5)
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r12, r2, r12)
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.cca_continue((int[]) r5, (int[]) r5)
            com.cardinalcommerce.p060a.setNextFocusLeftId.cca_continue((int[]) r4, (int[]) r5, (int[]) r9)
            int r2 = com.cardinalcommerce.p060a.setNextFocusLeftId.Cardinal(r12, r12, r5)
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.cca_continue((int) r2, (int[]) r5)
            com.cardinalcommerce.a.doChallenge r4 = new com.cardinalcommerce.a.doChallenge
            r4.<init>((int[]) r13)
            int[] r2 = r4.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r11, r2)
            int[] r2 = r4.init
            int[] r6 = r4.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r2, r5, r6)
            com.cardinalcommerce.a.doChallenge r6 = new com.cardinalcommerce.a.doChallenge
            r6.<init>((int[]) r5)
            int[] r2 = r4.init
            int[] r5 = r6.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.Cardinal(r12, r2, r5)
            int[] r2 = r6.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.getInstance(r2, r11, r9)
            int[] r2 = r6.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.init(r9, r2)
            com.cardinalcommerce.a.doChallenge r2 = new com.cardinalcommerce.a.doChallenge
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f9
            int[] r5 = r2.init
            int[] r7 = r7.init
            int[] r8 = r2.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r5, r7, r8)
        L_0x00f9:
            if (r15 != 0) goto L_0x0104
            int[] r5 = r2.init
            int[] r1 = r1.init
            int[] r7 = r2.init
            com.cardinalcommerce.p060a.getAuthenticationRequestParameters.configure(r5, r1, r7)
        L_0x0104:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.close r8 = new com.cardinalcommerce.a.close
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.close.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        doChallenge dochallenge = (doChallenge) this.init;
        if (dochallenge.cleanup()) {
            return cca_continue.init();
        }
        doChallenge dochallenge2 = (doChallenge) this.configure;
        doChallenge dochallenge3 = (doChallenge) this.cca_continue[0];
        int[] iArr = new int[8];
        int[] iArr2 = new int[8];
        int[] iArr3 = new int[8];
        getAuthenticationRequestParameters.Cardinal(dochallenge.init, iArr3);
        int[] iArr4 = new int[8];
        getAuthenticationRequestParameters.Cardinal(iArr3, iArr4);
        boolean CardinalError = dochallenge3.CardinalError();
        int[] iArr5 = dochallenge3.init;
        if (!CardinalError) {
            getAuthenticationRequestParameters.Cardinal(dochallenge3.init, iArr2);
            iArr5 = iArr2;
        }
        getAuthenticationRequestParameters.Cardinal(dochallenge2.init, iArr5, iArr);
        getAuthenticationRequestParameters.init(dochallenge2.init, iArr5, iArr2);
        getAuthenticationRequestParameters.configure(iArr2, iArr, iArr2);
        getAuthenticationRequestParameters.cca_continue(setNextFocusLeftId.Cardinal(iArr2, iArr2, iArr2), iArr2);
        getAuthenticationRequestParameters.configure(iArr3, dochallenge2.init, iArr3);
        getAuthenticationRequestParameters.cca_continue(setDrawingCacheQuality.getInstance(8, iArr3, 0), iArr3);
        getAuthenticationRequestParameters.cca_continue(setDrawingCacheQuality.init(8, iArr4, 0, iArr), iArr);
        doChallenge dochallenge4 = new doChallenge(iArr4);
        getAuthenticationRequestParameters.Cardinal(iArr2, dochallenge4.init);
        getAuthenticationRequestParameters.Cardinal(dochallenge4.init, iArr3, dochallenge4.init);
        getAuthenticationRequestParameters.Cardinal(dochallenge4.init, iArr3, dochallenge4.init);
        doChallenge dochallenge5 = new doChallenge(iArr3);
        getAuthenticationRequestParameters.Cardinal(iArr3, dochallenge4.init, dochallenge5.init);
        getAuthenticationRequestParameters.configure(dochallenge5.init, iArr2, dochallenge5.init);
        getAuthenticationRequestParameters.Cardinal(dochallenge5.init, iArr, dochallenge5.init);
        doChallenge dochallenge6 = new doChallenge(iArr2);
        getAuthenticationRequestParameters.getInstance(dochallenge.init, dochallenge6.init);
        if (!CardinalError) {
            getAuthenticationRequestParameters.configure(dochallenge6.init, dochallenge3.init, dochallenge6.init);
        }
        return new close(cca_continue, dochallenge4, dochallenge5, new getAcsTransactionID[]{dochallenge6}, this.getInstance);
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
