package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setCCAVisibility */
public final class setCCAVisibility extends ChallengeParameters.cca_continue {
    public setCCAVisibility(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setCCAVisibility(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setCCAVisibility(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new setCCAVisibility(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setCCAVisibility((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.setCCAText r2 = (com.cardinalcommerce.p060a.setCCAText) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.setCCAText r4 = (com.cardinalcommerce.p060a.setCCAText) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.setCCAText r5 = (com.cardinalcommerce.p060a.setCCAText) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.setCCAText r6 = (com.cardinalcommerce.p060a.setCCAText) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.setCCAText r7 = (com.cardinalcommerce.p060a.setCCAText) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.setCCAText r1 = (com.cardinalcommerce.p060a.setCCAText) r1
            r9 = 10
            int[] r9 = new int[r9]
            r10 = 5
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0054
            int[] r5 = r5.Cardinal
            int[] r6 = r6.Cardinal
            goto L_0x006a
        L_0x0054:
            int[] r15 = r7.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.Cardinal(r15, r12)
            int[] r5 = r5.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r12, r5, r11)
            int[] r5 = r7.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r12, r5, r12)
            int[] r5 = r6.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x006a:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0075
            int[] r2 = r2.Cardinal
            int[] r4 = r4.Cardinal
            goto L_0x008b
        L_0x0075:
            int[] r8 = r1.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.Cardinal(r8, r13)
            int[] r2 = r2.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r13, r2, r9)
            int[] r2 = r1.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r13, r2, r13)
            int[] r2 = r4.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x008b:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.getInstance((int[]) r2, (int[]) r5, (int[]) r8)
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.getInstance((int[]) r4, (int[]) r6, (int[]) r11)
            boolean r5 = com.cardinalcommerce.p060a.setScrollContainer.init(r8)
            if (r5 == 0) goto L_0x00a9
            boolean r1 = com.cardinalcommerce.p060a.setScrollContainer.init(r11)
            if (r1 == 0) goto L_0x00a4
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a4:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00a9:
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.Cardinal(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r12, r8, r5)
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r12, r2, r12)
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.init((int[]) r5, (int[]) r5)
            com.cardinalcommerce.p060a.setScrollContainer.init(r4, r5, r9)
            int r2 = com.cardinalcommerce.p060a.setScrollContainer.cca_continue(r12, r12, r5)
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.init((int) r2, (int[]) r5)
            com.cardinalcommerce.a.setCCAText r4 = new com.cardinalcommerce.a.setCCAText
            r4.<init>((int[]) r13)
            int[] r2 = r4.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.Cardinal(r11, r2)
            int[] r2 = r4.Cardinal
            int[] r6 = r4.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.getInstance((int[]) r2, (int[]) r5, (int[]) r6)
            com.cardinalcommerce.a.setCCAText r6 = new com.cardinalcommerce.a.setCCAText
            r6.<init>((int[]) r5)
            int[] r2 = r4.Cardinal
            int[] r5 = r6.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.getInstance((int[]) r12, (int[]) r2, (int[]) r5)
            int[] r2 = r6.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.Cardinal(r2, r11, r9)
            int[] r2 = r6.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.configure(r9, r2)
            com.cardinalcommerce.a.setCCAText r2 = new com.cardinalcommerce.a.setCCAText
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f8
            int[] r5 = r2.Cardinal
            int[] r7 = r7.Cardinal
            int[] r8 = r2.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r5, r7, r8)
        L_0x00f8:
            if (r15 != 0) goto L_0x0103
            int[] r5 = r2.Cardinal
            int[] r1 = r1.Cardinal
            int[] r7 = r2.Cardinal
            com.cardinalcommerce.p060a.setCCAOnFocusChangeListener.cca_continue(r5, r1, r7)
        L_0x0103:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.setCCAVisibility r8 = new com.cardinalcommerce.a.setCCAVisibility
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCCAVisibility.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        setCCAText setccatext = (setCCAText) this.init;
        if (setccatext.cleanup()) {
            return cca_continue.init();
        }
        setCCAText setccatext2 = (setCCAText) this.configure;
        setCCAText setccatext3 = (setCCAText) this.cca_continue[0];
        int[] iArr = new int[5];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        setCCAOnFocusChangeListener.Cardinal(setccatext.Cardinal, iArr3);
        int[] iArr4 = new int[5];
        setCCAOnFocusChangeListener.Cardinal(iArr3, iArr4);
        boolean CardinalError = setccatext3.CardinalError();
        int[] iArr5 = setccatext3.Cardinal;
        if (!CardinalError) {
            setCCAOnFocusChangeListener.Cardinal(setccatext3.Cardinal, iArr2);
            iArr5 = iArr2;
        }
        setCCAOnFocusChangeListener.getInstance(setccatext2.Cardinal, iArr5, iArr);
        setCCAOnFocusChangeListener.init(setccatext2.Cardinal, iArr5, iArr2);
        setCCAOnFocusChangeListener.cca_continue(iArr2, iArr, iArr2);
        setCCAOnFocusChangeListener.init(setScrollContainer.cca_continue(iArr2, iArr2, iArr2), iArr2);
        setCCAOnFocusChangeListener.cca_continue(iArr3, setccatext2.Cardinal, iArr3);
        setCCAOnFocusChangeListener.init(setDrawingCacheQuality.getInstance(5, iArr3, 0), iArr3);
        setCCAOnFocusChangeListener.init(setDrawingCacheQuality.init(5, iArr4, 0, iArr), iArr);
        setCCAText setccatext4 = new setCCAText(iArr4);
        setCCAOnFocusChangeListener.Cardinal(iArr2, setccatext4.Cardinal);
        setCCAOnFocusChangeListener.getInstance(setccatext4.Cardinal, iArr3, setccatext4.Cardinal);
        setCCAOnFocusChangeListener.getInstance(setccatext4.Cardinal, iArr3, setccatext4.Cardinal);
        setCCAText setccatext5 = new setCCAText(iArr3);
        setCCAOnFocusChangeListener.getInstance(iArr3, setccatext4.Cardinal, setccatext5.Cardinal);
        setCCAOnFocusChangeListener.cca_continue(setccatext5.Cardinal, iArr2, setccatext5.Cardinal);
        setCCAOnFocusChangeListener.getInstance(setccatext5.Cardinal, iArr, setccatext5.Cardinal);
        setCCAText setccatext6 = new setCCAText(iArr2);
        setCCAOnFocusChangeListener.cca_continue(setccatext.Cardinal, setccatext6.Cardinal);
        if (!CardinalError) {
            setCCAOnFocusChangeListener.cca_continue(setccatext6.Cardinal, setccatext3.Cardinal, setccatext6.Cardinal);
        }
        return new setCCAVisibility(cca_continue, setccatext4, setccatext5, new getAcsTransactionID[]{setccatext6}, this.getInstance);
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
