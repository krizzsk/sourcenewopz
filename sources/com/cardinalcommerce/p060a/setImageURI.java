package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setImageURI */
public final class setImageURI extends ChallengeParameters.cca_continue {
    public setImageURI(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setImageURI(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setImageURI(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new setImageURI(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setImageURI((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.setCCAElevation r2 = (com.cardinalcommerce.p060a.setCCAElevation) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.setCCAElevation r4 = (com.cardinalcommerce.p060a.setCCAElevation) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.setCCAElevation r5 = (com.cardinalcommerce.p060a.setCCAElevation) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.setCCAElevation r6 = (com.cardinalcommerce.p060a.setCCAElevation) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.setCCAElevation r7 = (com.cardinalcommerce.p060a.setCCAElevation) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.setCCAElevation r1 = (com.cardinalcommerce.p060a.setCCAElevation) r1
            r9 = 12
            int[] r9 = new int[r9]
            r10 = 6
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
            com.cardinalcommerce.p060a.setCCAId.getInstance(r15, r12)
            int[] r5 = r5.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r12, r5, r11)
            int[] r5 = r7.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r12, r5, r12)
            int[] r5 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r12, r5, r12)
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
            com.cardinalcommerce.p060a.setCCAId.getInstance(r8, r13)
            int[] r2 = r2.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r13, r2, r9)
            int[] r2 = r1.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r13, r2, r13)
            int[] r2 = r4.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x008b:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.setCCAId.cca_continue(r2, r5, r8)
            com.cardinalcommerce.p060a.setCCAId.cca_continue(r4, r6, r11)
            boolean r5 = com.cardinalcommerce.p060a.setKeepScreenOn.init((int[]) r8)
            if (r5 == 0) goto L_0x00a9
            boolean r1 = com.cardinalcommerce.p060a.setKeepScreenOn.init((int[]) r11)
            if (r1 == 0) goto L_0x00a4
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a4:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00a9:
            com.cardinalcommerce.p060a.setCCAId.getInstance(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.setCCAId.init(r12, r8, r5)
            com.cardinalcommerce.p060a.setCCAId.init(r12, r2, r12)
            com.cardinalcommerce.p060a.setCCAId.cca_continue(r5, r5)
            com.cardinalcommerce.p060a.setKeepScreenOn.getInstance(r4, r5, r9)
            int r2 = com.cardinalcommerce.p060a.setKeepScreenOn.Cardinal((int[]) r12, (int[]) r12, (int[]) r5)
            com.cardinalcommerce.p060a.setCCAId.init((int) r2, (int[]) r5)
            com.cardinalcommerce.a.setCCAElevation r4 = new com.cardinalcommerce.a.setCCAElevation
            r4.<init>((int[]) r13)
            int[] r2 = r4.cca_continue
            com.cardinalcommerce.p060a.setCCAId.getInstance(r11, r2)
            int[] r2 = r4.cca_continue
            int[] r6 = r4.cca_continue
            com.cardinalcommerce.p060a.setCCAId.cca_continue(r2, r5, r6)
            com.cardinalcommerce.a.setCCAElevation r6 = new com.cardinalcommerce.a.setCCAElevation
            r6.<init>((int[]) r5)
            int[] r2 = r4.cca_continue
            int[] r5 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAId.cca_continue(r12, r2, r5)
            int[] r2 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAId.configure(r2, r11, r9)
            int[] r2 = r6.cca_continue
            com.cardinalcommerce.p060a.setCCAId.configure(r9, r2)
            com.cardinalcommerce.a.setCCAElevation r2 = new com.cardinalcommerce.a.setCCAElevation
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f8
            int[] r5 = r2.cca_continue
            int[] r7 = r7.cca_continue
            int[] r8 = r2.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r5, r7, r8)
        L_0x00f8:
            if (r15 != 0) goto L_0x0103
            int[] r5 = r2.cca_continue
            int[] r1 = r1.cca_continue
            int[] r7 = r2.cca_continue
            com.cardinalcommerce.p060a.setCCAId.init(r5, r1, r7)
        L_0x0103:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.setImageURI r8 = new com.cardinalcommerce.a.setImageURI
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setImageURI.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        setCCAElevation setccaelevation = (setCCAElevation) this.init;
        if (setccaelevation.cleanup()) {
            return cca_continue.init();
        }
        setCCAElevation setccaelevation2 = (setCCAElevation) this.configure;
        setCCAElevation setccaelevation3 = (setCCAElevation) this.cca_continue[0];
        int[] iArr = new int[6];
        int[] iArr2 = new int[6];
        int[] iArr3 = new int[6];
        setCCAId.getInstance(setccaelevation.cca_continue, iArr3);
        int[] iArr4 = new int[6];
        setCCAId.getInstance(iArr3, iArr4);
        boolean CardinalError = setccaelevation3.CardinalError();
        int[] iArr5 = setccaelevation3.cca_continue;
        if (!CardinalError) {
            setCCAId.getInstance(setccaelevation3.cca_continue, iArr2);
            iArr5 = iArr2;
        }
        setCCAId.cca_continue(setccaelevation2.cca_continue, iArr5, iArr);
        setCCAId.getInstance(setccaelevation2.cca_continue, iArr5, iArr2);
        setCCAId.init(iArr2, iArr, iArr2);
        setCCAId.init(setKeepScreenOn.Cardinal(iArr2, iArr2, iArr2), iArr2);
        setCCAId.init(iArr3, setccaelevation2.cca_continue, iArr3);
        setCCAId.init(setDrawingCacheQuality.getInstance(6, iArr3, 0), iArr3);
        setCCAId.init(setDrawingCacheQuality.init(6, iArr4, 0, iArr), iArr);
        setCCAElevation setccaelevation4 = new setCCAElevation(iArr4);
        setCCAId.getInstance(iArr2, setccaelevation4.cca_continue);
        setCCAId.cca_continue(setccaelevation4.cca_continue, iArr3, setccaelevation4.cca_continue);
        setCCAId.cca_continue(setccaelevation4.cca_continue, iArr3, setccaelevation4.cca_continue);
        setCCAElevation setccaelevation5 = new setCCAElevation(iArr3);
        setCCAId.cca_continue(iArr3, setccaelevation4.cca_continue, setccaelevation5.cca_continue);
        setCCAId.init(setccaelevation5.cca_continue, iArr2, setccaelevation5.cca_continue);
        setCCAId.cca_continue(setccaelevation5.cca_continue, iArr, setccaelevation5.cca_continue);
        setCCAElevation setccaelevation6 = new setCCAElevation(iArr2);
        setCCAId.init(setccaelevation.cca_continue, setccaelevation6.cca_continue);
        if (!CardinalError) {
            setCCAId.init(setccaelevation6.cca_continue, setccaelevation3.cca_continue, setccaelevation6.cca_continue);
        }
        return new setImageURI(cca_continue, setccaelevation4, setccaelevation5, new getAcsTransactionID[]{setccaelevation6}, this.getInstance);
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
