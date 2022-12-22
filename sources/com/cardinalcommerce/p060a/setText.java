package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setText */
public final class setText extends ChallengeParameters.cca_continue {
    public setText(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setText(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setText(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new setText(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setText((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.setOnCheckedChangeListener r2 = (com.cardinalcommerce.p060a.setOnCheckedChangeListener) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.setOnCheckedChangeListener r4 = (com.cardinalcommerce.p060a.setOnCheckedChangeListener) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.setOnCheckedChangeListener r5 = (com.cardinalcommerce.p060a.setOnCheckedChangeListener) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.setOnCheckedChangeListener r6 = (com.cardinalcommerce.p060a.setOnCheckedChangeListener) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.setOnCheckedChangeListener r7 = (com.cardinalcommerce.p060a.setOnCheckedChangeListener) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.setOnCheckedChangeListener r1 = (com.cardinalcommerce.p060a.setOnCheckedChangeListener) r1
            r9 = 10
            int[] r9 = new int[r9]
            r10 = 5
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0054
            int[] r5 = r5.getInstance
            int[] r6 = r6.getInstance
            goto L_0x006a
        L_0x0054:
            int[] r15 = r7.getInstance
            com.cardinalcommerce.p060a.setId.cca_continue(r15, r12)
            int[] r5 = r5.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r12, (int[]) r5, (int[]) r11)
            int[] r5 = r7.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r12, (int[]) r5, (int[]) r12)
            int[] r5 = r6.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r12, (int[]) r5, (int[]) r12)
            r5 = r11
            r6 = r12
        L_0x006a:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0075
            int[] r2 = r2.getInstance
            int[] r4 = r4.getInstance
            goto L_0x008b
        L_0x0075:
            int[] r8 = r1.getInstance
            com.cardinalcommerce.p060a.setId.cca_continue(r8, r13)
            int[] r2 = r2.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r13, (int[]) r2, (int[]) r9)
            int[] r2 = r1.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r13, (int[]) r2, (int[]) r13)
            int[] r2 = r4.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r13, (int[]) r2, (int[]) r13)
            r2 = r9
            r4 = r13
        L_0x008b:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.setId.cca_continue(r2, r5, r8)
            com.cardinalcommerce.p060a.setId.cca_continue(r4, r6, r11)
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
            com.cardinalcommerce.p060a.setId.cca_continue(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.setId.init((int[]) r12, (int[]) r8, (int[]) r5)
            com.cardinalcommerce.p060a.setId.init((int[]) r12, (int[]) r2, (int[]) r12)
            com.cardinalcommerce.p060a.setId.Cardinal(r5, r5)
            com.cardinalcommerce.p060a.setScrollContainer.init(r4, r5, r9)
            int r2 = com.cardinalcommerce.p060a.setScrollContainer.cca_continue(r12, r12, r5)
            com.cardinalcommerce.p060a.setId.getInstance((int) r2, (int[]) r5)
            com.cardinalcommerce.a.setOnCheckedChangeListener r4 = new com.cardinalcommerce.a.setOnCheckedChangeListener
            r4.<init>((int[]) r13)
            int[] r2 = r4.getInstance
            com.cardinalcommerce.p060a.setId.cca_continue(r11, r2)
            int[] r2 = r4.getInstance
            int[] r6 = r4.getInstance
            com.cardinalcommerce.p060a.setId.cca_continue(r2, r5, r6)
            com.cardinalcommerce.a.setOnCheckedChangeListener r6 = new com.cardinalcommerce.a.setOnCheckedChangeListener
            r6.<init>((int[]) r5)
            int[] r2 = r4.getInstance
            int[] r5 = r6.getInstance
            com.cardinalcommerce.p060a.setId.cca_continue(r12, r2, r5)
            int[] r2 = r6.getInstance
            com.cardinalcommerce.p060a.setId.configure(r2, r11, r9)
            int[] r2 = r6.getInstance
            com.cardinalcommerce.p060a.setId.init(r9, r2)
            com.cardinalcommerce.a.setOnCheckedChangeListener r2 = new com.cardinalcommerce.a.setOnCheckedChangeListener
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f8
            int[] r5 = r2.getInstance
            int[] r7 = r7.getInstance
            int[] r8 = r2.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r5, (int[]) r7, (int[]) r8)
        L_0x00f8:
            if (r15 != 0) goto L_0x0103
            int[] r5 = r2.getInstance
            int[] r1 = r1.getInstance
            int[] r7 = r2.getInstance
            com.cardinalcommerce.p060a.setId.init((int[]) r5, (int[]) r1, (int[]) r7)
        L_0x0103:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.setText r8 = new com.cardinalcommerce.a.setText
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setText.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        setOnCheckedChangeListener setoncheckedchangelistener = (setOnCheckedChangeListener) this.init;
        if (setoncheckedchangelistener.cleanup()) {
            return cca_continue.init();
        }
        setOnCheckedChangeListener setoncheckedchangelistener2 = (setOnCheckedChangeListener) this.configure;
        setOnCheckedChangeListener setoncheckedchangelistener3 = (setOnCheckedChangeListener) this.cca_continue[0];
        int[] iArr = new int[5];
        setId.cca_continue(setoncheckedchangelistener.getInstance, iArr);
        int[] iArr2 = new int[5];
        setId.cca_continue(iArr, iArr2);
        int[] iArr3 = new int[5];
        setId.cca_continue(setoncheckedchangelistener2.getInstance, iArr3);
        setId.getInstance(setScrollContainer.cca_continue(iArr3, iArr3, iArr3), iArr3);
        setId.init(iArr, setoncheckedchangelistener2.getInstance, iArr);
        setId.getInstance(setDrawingCacheQuality.getInstance(5, iArr, 0), iArr);
        int[] iArr4 = new int[5];
        setId.getInstance(setDrawingCacheQuality.init(5, iArr2, 0, iArr4), iArr4);
        setOnCheckedChangeListener setoncheckedchangelistener4 = new setOnCheckedChangeListener(iArr2);
        setId.cca_continue(iArr3, setoncheckedchangelistener4.getInstance);
        setId.cca_continue(setoncheckedchangelistener4.getInstance, iArr, setoncheckedchangelistener4.getInstance);
        setId.cca_continue(setoncheckedchangelistener4.getInstance, iArr, setoncheckedchangelistener4.getInstance);
        setOnCheckedChangeListener setoncheckedchangelistener5 = new setOnCheckedChangeListener(iArr);
        setId.cca_continue(iArr, setoncheckedchangelistener4.getInstance, setoncheckedchangelistener5.getInstance);
        setId.init(setoncheckedchangelistener5.getInstance, iArr3, setoncheckedchangelistener5.getInstance);
        setId.cca_continue(setoncheckedchangelistener5.getInstance, iArr4, setoncheckedchangelistener5.getInstance);
        setOnCheckedChangeListener setoncheckedchangelistener6 = new setOnCheckedChangeListener(iArr3);
        setId.configure(setoncheckedchangelistener.getInstance, setoncheckedchangelistener6.getInstance);
        if (!setoncheckedchangelistener3.CardinalError()) {
            setId.init(setoncheckedchangelistener6.getInstance, setoncheckedchangelistener3.getInstance, setoncheckedchangelistener6.getInstance);
        }
        return new setText(cca_continue, setoncheckedchangelistener4, setoncheckedchangelistener5, new getAcsTransactionID[]{setoncheckedchangelistener6}, this.getInstance);
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
