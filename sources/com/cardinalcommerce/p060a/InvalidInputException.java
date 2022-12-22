package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.InvalidInputException */
public final class InvalidInputException extends ChallengeParameters.cca_continue {
    public InvalidInputException(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public InvalidInputException(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    InvalidInputException(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new InvalidInputException(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new InvalidInputException((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.getErrorDetails r2 = (com.cardinalcommerce.p060a.getErrorDetails) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.getErrorDetails r4 = (com.cardinalcommerce.p060a.getErrorDetails) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.getErrorDetails r5 = (com.cardinalcommerce.p060a.getErrorDetails) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.getErrorDetails r6 = (com.cardinalcommerce.p060a.getErrorDetails) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.getErrorDetails r7 = (com.cardinalcommerce.p060a.getErrorDetails) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.getErrorDetails r1 = (com.cardinalcommerce.p060a.getErrorDetails) r1
            r9 = 24
            int[] r10 = new int[r9]
            int[] r9 = new int[r9]
            r11 = 12
            int[] r12 = new int[r11]
            int[] r13 = new int[r11]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0055
            int[] r5 = r5.configure
            int[] r6 = r6.configure
            goto L_0x006b
        L_0x0055:
            int[] r15 = r7.configure
            com.cardinalcommerce.p060a.getTransactionID.init(r15, r12)
            int[] r5 = r5.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r12, r5, r9)
            int[] r5 = r7.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r12, r5, r12)
            int[] r5 = r6.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r12, r5, r12)
            r5 = r9
            r6 = r12
        L_0x006b:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0076
            int[] r2 = r2.configure
            int[] r4 = r4.configure
            goto L_0x008c
        L_0x0076:
            int[] r8 = r1.configure
            com.cardinalcommerce.p060a.getTransactionID.init(r8, r13)
            int[] r2 = r2.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r13, r2, r10)
            int[] r2 = r1.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r13, r2, r13)
            int[] r2 = r4.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r13, r2, r13)
            r2 = r10
            r4 = r13
        L_0x008c:
            int[] r8 = new int[r11]
            com.cardinalcommerce.p060a.getTransactionID.init(r2, r5, r8)
            int[] r5 = new int[r11]
            com.cardinalcommerce.p060a.getTransactionID.init(r4, r6, r5)
            boolean r6 = com.cardinalcommerce.p060a.setDrawingCacheQuality.init(r11, r8)
            if (r6 == 0) goto L_0x00ac
            boolean r1 = com.cardinalcommerce.p060a.setDrawingCacheQuality.init(r11, r5)
            if (r1 == 0) goto L_0x00a7
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a7:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00ac:
            com.cardinalcommerce.p060a.getTransactionID.init(r8, r12)
            int[] r6 = new int[r11]
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r12, r8, r6)
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r12, r2, r12)
            com.cardinalcommerce.p060a.getTransactionID.getInstance(r6, r6)
            com.cardinalcommerce.p060a.setNextFocusRightId.init(r4, r6, r10)
            int r2 = com.cardinalcommerce.p060a.setDrawingCacheQuality.getInstance((int) r11, (int[]) r12, (int[]) r12, (int[]) r6)
            com.cardinalcommerce.p060a.getTransactionID.configure((int) r2, (int[]) r6)
            com.cardinalcommerce.a.getErrorDetails r4 = new com.cardinalcommerce.a.getErrorDetails
            r4.<init>((int[]) r13)
            int[] r2 = r4.configure
            com.cardinalcommerce.p060a.getTransactionID.init(r5, r2)
            int[] r2 = r4.configure
            int[] r11 = r4.configure
            com.cardinalcommerce.p060a.getTransactionID.init(r2, r6, r11)
            com.cardinalcommerce.a.getErrorDetails r11 = new com.cardinalcommerce.a.getErrorDetails
            r11.<init>((int[]) r6)
            int[] r2 = r4.configure
            int[] r6 = r11.configure
            com.cardinalcommerce.p060a.getTransactionID.init(r12, r2, r6)
            int[] r2 = r11.configure
            com.cardinalcommerce.p060a.setNextFocusRightId.init(r2, r5, r9)
            com.cardinalcommerce.p060a.getTransactionID.cca_continue(r10, r9, r10)
            int[] r2 = r11.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r10, r2)
            com.cardinalcommerce.a.getErrorDetails r2 = new com.cardinalcommerce.a.getErrorDetails
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00fe
            int[] r5 = r2.configure
            int[] r6 = r7.configure
            int[] r7 = r2.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r5, r6, r7)
        L_0x00fe:
            if (r15 != 0) goto L_0x0109
            int[] r5 = r2.configure
            int[] r1 = r1.configure
            int[] r6 = r2.configure
            com.cardinalcommerce.p060a.getTransactionID.Cardinal(r5, r1, r6)
        L_0x0109:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r6 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r1 = 0
            r6[r1] = r2
            com.cardinalcommerce.a.InvalidInputException r1 = new com.cardinalcommerce.a.InvalidInputException
            boolean r7 = r0.getInstance
            r2 = r1
            r5 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.InvalidInputException.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        getErrorDetails geterrordetails = (getErrorDetails) this.init;
        if (geterrordetails.cleanup()) {
            return cca_continue.init();
        }
        getErrorDetails geterrordetails2 = (getErrorDetails) this.configure;
        getErrorDetails geterrordetails3 = (getErrorDetails) this.cca_continue[0];
        int[] iArr = new int[12];
        int[] iArr2 = new int[12];
        int[] iArr3 = new int[12];
        getTransactionID.init(geterrordetails.configure, iArr3);
        int[] iArr4 = new int[12];
        getTransactionID.init(iArr3, iArr4);
        boolean CardinalError = geterrordetails3.CardinalError();
        int[] iArr5 = geterrordetails3.configure;
        if (!CardinalError) {
            getTransactionID.init(geterrordetails3.configure, iArr2);
            iArr5 = iArr2;
        }
        getTransactionID.init(geterrordetails2.configure, iArr5, iArr);
        getTransactionID.getInstance(geterrordetails2.configure, iArr5, iArr2);
        getTransactionID.Cardinal(iArr2, iArr, iArr2);
        getTransactionID.configure(setDrawingCacheQuality.getInstance(12, iArr2, iArr2, iArr2), iArr2);
        getTransactionID.Cardinal(iArr3, geterrordetails2.configure, iArr3);
        getTransactionID.configure(setDrawingCacheQuality.getInstance(12, iArr3, 0), iArr3);
        getTransactionID.configure(setDrawingCacheQuality.init(12, iArr4, 0, iArr), iArr);
        getErrorDetails geterrordetails4 = new getErrorDetails(iArr4);
        getTransactionID.init(iArr2, geterrordetails4.configure);
        getTransactionID.init(geterrordetails4.configure, iArr3, geterrordetails4.configure);
        getTransactionID.init(geterrordetails4.configure, iArr3, geterrordetails4.configure);
        getErrorDetails geterrordetails5 = new getErrorDetails(iArr3);
        getTransactionID.init(iArr3, geterrordetails4.configure, geterrordetails5.configure);
        getTransactionID.Cardinal(geterrordetails5.configure, iArr2, geterrordetails5.configure);
        getTransactionID.init(geterrordetails5.configure, iArr, geterrordetails5.configure);
        getErrorDetails geterrordetails6 = new getErrorDetails(iArr2);
        getTransactionID.cca_continue(geterrordetails.configure, geterrordetails6.configure);
        if (!CardinalError) {
            getTransactionID.Cardinal(geterrordetails6.configure, geterrordetails3.configure, geterrordetails6.configure);
        }
        return new InvalidInputException(cca_continue, geterrordetails4, geterrordetails5, new getAcsTransactionID[]{geterrordetails6}, this.getInstance);
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
