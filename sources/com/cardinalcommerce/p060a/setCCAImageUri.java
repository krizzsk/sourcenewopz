package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setCCAImageUri */
public final class setCCAImageUri extends ChallengeParameters.cca_continue {
    public setCCAImageUri(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setCCAImageUri(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setCCAImageUri(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new setCCAImageUri(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setCCAImageUri((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.setImageResource r2 = (com.cardinalcommerce.p060a.setImageResource) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.setImageResource r4 = (com.cardinalcommerce.p060a.setImageResource) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.setImageResource r5 = (com.cardinalcommerce.p060a.setImageResource) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.setImageResource r6 = (com.cardinalcommerce.p060a.setImageResource) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.setImageResource r7 = (com.cardinalcommerce.p060a.setImageResource) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.setImageResource r1 = (com.cardinalcommerce.p060a.setImageResource) r1
            r9 = 14
            int[] r9 = new int[r9]
            r10 = 7
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0054
            int[] r5 = r5.cca_continue
            int[] r6 = r6.cca_continue
            goto L_0x006a
        L_0x0054:
            int[] r15 = r7.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r15, r12)
            int[] r5 = r5.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r12, r5, r11)
            int[] r5 = r7.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r12, r5, r12)
            int[] r5 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x006a:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0075
            int[] r2 = r2.cca_continue
            int[] r4 = r4.cca_continue
            goto L_0x008b
        L_0x0075:
            int[] r8 = r1.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r8, r13)
            int[] r2 = r2.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r13, r2, r9)
            int[] r2 = r1.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r13, r2, r13)
            int[] r2 = r4.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x008b:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.setCCAImageIcon.cca_continue((int[]) r2, (int[]) r5, (int[]) r8)
            com.cardinalcommerce.p060a.setCCAImageIcon.cca_continue((int[]) r4, (int[]) r6, (int[]) r11)
            boolean r5 = com.cardinalcommerce.p060a.setNextFocusDownId.cca_continue(r8)
            if (r5 == 0) goto L_0x00a9
            boolean r1 = com.cardinalcommerce.p060a.setNextFocusDownId.cca_continue(r11)
            if (r1 == 0) goto L_0x00a4
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a4:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00a9:
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r12, r8, r5)
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r12, r2, r12)
            com.cardinalcommerce.p060a.setCCAImageIcon.getInstance(r5, r5)
            com.cardinalcommerce.p060a.setNextFocusDownId.configure(r4, r5, r9)
            int r2 = com.cardinalcommerce.p060a.setNextFocusDownId.init((int[]) r12, (int[]) r12, (int[]) r5)
            com.cardinalcommerce.p060a.setCCAImageIcon.cca_continue((int) r2, (int[]) r5)
            com.cardinalcommerce.a.setImageResource r4 = new com.cardinalcommerce.a.setImageResource
            r4.<init>((int[]) r13)
            int[] r2 = r4.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r11, r2)
            int[] r2 = r4.cca_continue
            int[] r6 = r4.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.cca_continue((int[]) r2, (int[]) r5, (int[]) r6)
            com.cardinalcommerce.a.setImageResource r6 = new com.cardinalcommerce.a.setImageResource
            r6.<init>((int[]) r5)
            int[] r2 = r4.cca_continue
            int[] r5 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.cca_continue((int[]) r12, (int[]) r2, (int[]) r5)
            int[] r2 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.Cardinal(r2, r11, r9)
            int[] r2 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.init(r9, r2)
            com.cardinalcommerce.a.setImageResource r2 = new com.cardinalcommerce.a.setImageResource
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f8
            int[] r5 = r2.cca_continue
            int[] r7 = r7.cca_continue
            int[] r8 = r2.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r5, r7, r8)
        L_0x00f8:
            if (r15 != 0) goto L_0x0103
            int[] r5 = r2.cca_continue
            int[] r1 = r1.cca_continue
            int[] r7 = r2.cca_continue
            com.cardinalcommerce.p060a.setCCAImageIcon.configure(r5, r1, r7)
        L_0x0103:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.setCCAImageUri r8 = new com.cardinalcommerce.a.setCCAImageUri
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCCAImageUri.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        setImageResource setimageresource = (setImageResource) this.init;
        if (setimageresource.cleanup()) {
            return cca_continue.init();
        }
        setImageResource setimageresource2 = (setImageResource) this.configure;
        setImageResource setimageresource3 = (setImageResource) this.cca_continue[0];
        int[] iArr = new int[7];
        int[] iArr2 = new int[7];
        int[] iArr3 = new int[7];
        setCCAImageIcon.configure(setimageresource.cca_continue, iArr3);
        int[] iArr4 = new int[7];
        setCCAImageIcon.configure(iArr3, iArr4);
        boolean CardinalError = setimageresource3.CardinalError();
        int[] iArr5 = setimageresource3.cca_continue;
        if (!CardinalError) {
            setCCAImageIcon.configure(setimageresource3.cca_continue, iArr2);
            iArr5 = iArr2;
        }
        setCCAImageIcon.cca_continue(setimageresource2.cca_continue, iArr5, iArr);
        setCCAImageIcon.init(setimageresource2.cca_continue, iArr5, iArr2);
        setCCAImageIcon.configure(iArr2, iArr, iArr2);
        setCCAImageIcon.cca_continue(setNextFocusDownId.init(iArr2, iArr2, iArr2), iArr2);
        setCCAImageIcon.configure(iArr3, setimageresource2.cca_continue, iArr3);
        setCCAImageIcon.cca_continue(setDrawingCacheQuality.getInstance(7, iArr3, 0), iArr3);
        setCCAImageIcon.cca_continue(setDrawingCacheQuality.init(7, iArr4, 0, iArr), iArr);
        setImageResource setimageresource4 = new setImageResource(iArr4);
        setCCAImageIcon.configure(iArr2, setimageresource4.cca_continue);
        setCCAImageIcon.cca_continue(setimageresource4.cca_continue, iArr3, setimageresource4.cca_continue);
        setCCAImageIcon.cca_continue(setimageresource4.cca_continue, iArr3, setimageresource4.cca_continue);
        setImageResource setimageresource5 = new setImageResource(iArr3);
        setCCAImageIcon.cca_continue(iArr3, setimageresource4.cca_continue, setimageresource5.cca_continue);
        setCCAImageIcon.configure(setimageresource5.cca_continue, iArr2, setimageresource5.cca_continue);
        setCCAImageIcon.cca_continue(setimageresource5.cca_continue, iArr, setimageresource5.cca_continue);
        setImageResource setimageresource6 = new setImageResource(iArr2);
        setCCAImageIcon.cca_continue(setimageresource.cca_continue, setimageresource6.cca_continue);
        if (!CardinalError) {
            setCCAImageIcon.configure(setimageresource6.cca_continue, setimageresource3.cca_continue, setimageresource6.cca_continue);
        }
        return new setCCAImageUri(cca_continue, setimageresource4, setimageresource5, new getAcsTransactionID[]{setimageresource6}, this.getInstance);
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
