package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setVisibility */
public final class setVisibility extends ChallengeParameters.cca_continue {
    public setVisibility(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setVisibility(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setVisibility(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new setVisibility(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setVisibility((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.setOnTouchListener r2 = (com.cardinalcommerce.p060a.setOnTouchListener) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.setOnTouchListener r4 = (com.cardinalcommerce.p060a.setOnTouchListener) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.setOnTouchListener r5 = (com.cardinalcommerce.p060a.setOnTouchListener) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.setOnTouchListener r6 = (com.cardinalcommerce.p060a.setOnTouchListener) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.setOnTouchListener r7 = (com.cardinalcommerce.p060a.setOnTouchListener) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.setOnTouchListener r1 = (com.cardinalcommerce.p060a.setOnTouchListener) r1
            r9 = 8
            int[] r9 = new int[r9]
            r10 = 4
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
            com.cardinalcommerce.p060a.setOnFocusChangeListener.cca_continue(r15, r12)
            int[] r5 = r5.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r12, r5, r11)
            int[] r5 = r7.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r12, r5, r12)
            int[] r5 = r6.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r12, r5, r12)
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
            com.cardinalcommerce.p060a.setOnFocusChangeListener.cca_continue(r8, r13)
            int[] r2 = r2.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r13, r2, r9)
            int[] r2 = r1.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r13, r2, r13)
            int[] r2 = r4.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x008b:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.setOnFocusChangeListener.getInstance((int[]) r2, (int[]) r5, (int[]) r8)
            com.cardinalcommerce.p060a.setOnFocusChangeListener.getInstance((int[]) r4, (int[]) r6, (int[]) r11)
            boolean r5 = com.cardinalcommerce.p060a.setAccessibilityTraversalBefore.configure(r8)
            if (r5 == 0) goto L_0x00a9
            boolean r1 = com.cardinalcommerce.p060a.setAccessibilityTraversalBefore.configure(r11)
            if (r1 == 0) goto L_0x00a4
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a4:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00a9:
            com.cardinalcommerce.p060a.setOnFocusChangeListener.cca_continue(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r12, r8, r5)
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r12, r2, r12)
            com.cardinalcommerce.p060a.setOnFocusChangeListener.configure(r5, r5)
            com.cardinalcommerce.p060a.setAccessibilityTraversalBefore.configure(r4, r5, r9)
            int r2 = com.cardinalcommerce.p060a.setAccessibilityTraversalBefore.cca_continue(r12, r12, r5)
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init((int) r2, (int[]) r5)
            com.cardinalcommerce.a.setOnTouchListener r4 = new com.cardinalcommerce.a.setOnTouchListener
            r4.<init>((int[]) r13)
            int[] r2 = r4.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.cca_continue(r11, r2)
            int[] r2 = r4.Cardinal
            int[] r6 = r4.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.getInstance((int[]) r2, (int[]) r5, (int[]) r6)
            com.cardinalcommerce.a.setOnTouchListener r6 = new com.cardinalcommerce.a.setOnTouchListener
            r6.<init>((int[]) r5)
            int[] r2 = r4.Cardinal
            int[] r5 = r6.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.getInstance((int[]) r12, (int[]) r2, (int[]) r5)
            int[] r2 = r6.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.configure(r2, r11, r9)
            int[] r2 = r6.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.Cardinal(r9, r2)
            com.cardinalcommerce.a.setOnTouchListener r2 = new com.cardinalcommerce.a.setOnTouchListener
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f8
            int[] r5 = r2.Cardinal
            int[] r7 = r7.Cardinal
            int[] r8 = r2.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r5, r7, r8)
        L_0x00f8:
            if (r15 != 0) goto L_0x0103
            int[] r5 = r2.Cardinal
            int[] r1 = r1.Cardinal
            int[] r7 = r2.Cardinal
            com.cardinalcommerce.p060a.setOnFocusChangeListener.init(r5, r1, r7)
        L_0x0103:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.setVisibility r8 = new com.cardinalcommerce.a.setVisibility
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setVisibility.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        setOnTouchListener setontouchlistener = (setOnTouchListener) this.init;
        if (setontouchlistener.cleanup()) {
            return cca_continue.init();
        }
        setOnTouchListener setontouchlistener2 = (setOnTouchListener) this.configure;
        setOnTouchListener setontouchlistener3 = (setOnTouchListener) this.cca_continue[0];
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        setOnFocusChangeListener.cca_continue(setontouchlistener.Cardinal, iArr3);
        int[] iArr4 = new int[4];
        setOnFocusChangeListener.cca_continue(iArr3, iArr4);
        boolean CardinalError = setontouchlistener3.CardinalError();
        int[] iArr5 = setontouchlistener3.Cardinal;
        if (!CardinalError) {
            setOnFocusChangeListener.cca_continue(setontouchlistener3.Cardinal, iArr2);
            iArr5 = iArr2;
        }
        setOnFocusChangeListener.getInstance(setontouchlistener2.Cardinal, iArr5, iArr);
        setOnFocusChangeListener.cca_continue(setontouchlistener2.Cardinal, iArr5, iArr2);
        setOnFocusChangeListener.init(iArr2, iArr, iArr2);
        setOnFocusChangeListener.init(setAccessibilityTraversalBefore.cca_continue(iArr2, iArr2, iArr2), iArr2);
        setOnFocusChangeListener.init(iArr3, setontouchlistener2.Cardinal, iArr3);
        setOnFocusChangeListener.init(setDrawingCacheQuality.getInstance(4, iArr3, 0), iArr3);
        setOnFocusChangeListener.init(setDrawingCacheQuality.init(4, iArr4, 0, iArr), iArr);
        setOnTouchListener setontouchlistener4 = new setOnTouchListener(iArr4);
        setOnFocusChangeListener.cca_continue(iArr2, setontouchlistener4.Cardinal);
        setOnFocusChangeListener.getInstance(setontouchlistener4.Cardinal, iArr3, setontouchlistener4.Cardinal);
        setOnFocusChangeListener.getInstance(setontouchlistener4.Cardinal, iArr3, setontouchlistener4.Cardinal);
        setOnTouchListener setontouchlistener5 = new setOnTouchListener(iArr3);
        setOnFocusChangeListener.getInstance(iArr3, setontouchlistener4.Cardinal, setontouchlistener5.Cardinal);
        setOnFocusChangeListener.init(setontouchlistener5.Cardinal, iArr2, setontouchlistener5.Cardinal);
        setOnFocusChangeListener.getInstance(setontouchlistener5.Cardinal, iArr, setontouchlistener5.Cardinal);
        setOnTouchListener setontouchlistener6 = new setOnTouchListener(iArr2);
        setOnFocusChangeListener.init(setontouchlistener.Cardinal, setontouchlistener6.Cardinal);
        if (!CardinalError) {
            setOnFocusChangeListener.init(setontouchlistener6.Cardinal, setontouchlistener3.Cardinal, setontouchlistener6.Cardinal);
        }
        return new setVisibility(cca_continue, setontouchlistener4, setontouchlistener5, new getAcsTransactionID[]{setontouchlistener6}, this.getInstance);
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
