package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.getSeverity */
public final class getSeverity extends ChallengeParameters.cca_continue {
    public getSeverity(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public getSeverity(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    getSeverity(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new getSeverity(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new getSeverity((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.DirectoryServerID r2 = (com.cardinalcommerce.p060a.DirectoryServerID) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.DirectoryServerID r4 = (com.cardinalcommerce.p060a.DirectoryServerID) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.DirectoryServerID r5 = (com.cardinalcommerce.p060a.DirectoryServerID) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.DirectoryServerID r6 = (com.cardinalcommerce.p060a.DirectoryServerID) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.DirectoryServerID r7 = (com.cardinalcommerce.p060a.DirectoryServerID) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.DirectoryServerID r1 = (com.cardinalcommerce.p060a.DirectoryServerID) r1
            r9 = 17
            int[] r10 = new int[r9]
            int[] r11 = new int[r9]
            int[] r12 = new int[r9]
            int[] r13 = new int[r9]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0053
            int[] r5 = r5.configure
            int[] r6 = r6.configure
            goto L_0x0069
        L_0x0053:
            int[] r15 = r7.configure
            com.cardinalcommerce.p060a.getValue.init(r15, r12)
            int[] r5 = r5.configure
            com.cardinalcommerce.p060a.getValue.init(r12, r5, r11)
            int[] r5 = r7.configure
            com.cardinalcommerce.p060a.getValue.init(r12, r5, r12)
            int[] r5 = r6.configure
            com.cardinalcommerce.p060a.getValue.init(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x0069:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0074
            int[] r2 = r2.configure
            int[] r4 = r4.configure
            goto L_0x008a
        L_0x0074:
            int[] r8 = r1.configure
            com.cardinalcommerce.p060a.getValue.init(r8, r13)
            int[] r2 = r2.configure
            com.cardinalcommerce.p060a.getValue.init(r13, r2, r10)
            int[] r2 = r1.configure
            com.cardinalcommerce.p060a.getValue.init(r13, r2, r13)
            int[] r2 = r4.configure
            com.cardinalcommerce.p060a.getValue.init(r13, r2, r13)
            r2 = r10
            r4 = r13
        L_0x008a:
            int[] r8 = new int[r9]
            com.cardinalcommerce.p060a.getValue.configure(r2, r5, r8)
            com.cardinalcommerce.p060a.getValue.configure(r4, r6, r11)
            boolean r5 = com.cardinalcommerce.p060a.setDrawingCacheQuality.init(r9, r8)
            if (r5 == 0) goto L_0x00a8
            boolean r1 = com.cardinalcommerce.p060a.setDrawingCacheQuality.init(r9, r11)
            if (r1 == 0) goto L_0x00a3
            com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
            return r1
        L_0x00a3:
            com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
            return r1
        L_0x00a8:
            com.cardinalcommerce.p060a.getValue.init(r8, r12)
            int[] r5 = new int[r9]
            com.cardinalcommerce.p060a.getValue.init(r12, r8, r5)
            com.cardinalcommerce.p060a.getValue.init(r12, r2, r12)
            com.cardinalcommerce.p060a.getValue.init(r4, r5, r10)
            com.cardinalcommerce.a.DirectoryServerID r4 = new com.cardinalcommerce.a.DirectoryServerID
            r4.<init>((int[]) r13)
            int[] r2 = r4.configure
            com.cardinalcommerce.p060a.getValue.init(r11, r2)
            int[] r2 = r4.configure
            int[] r6 = r4.configure
            com.cardinalcommerce.p060a.getValue.cca_continue(r2, r5, r6)
            int[] r2 = r4.configure
            int[] r6 = r4.configure
            com.cardinalcommerce.p060a.getValue.configure(r2, r12, r6)
            int[] r2 = r4.configure
            int[] r6 = r4.configure
            com.cardinalcommerce.p060a.getValue.configure(r2, r12, r6)
            com.cardinalcommerce.a.DirectoryServerID r6 = new com.cardinalcommerce.a.DirectoryServerID
            r6.<init>((int[]) r5)
            int[] r2 = r4.configure
            int[] r5 = r6.configure
            com.cardinalcommerce.p060a.getValue.configure(r12, r2, r5)
            int[] r2 = r6.configure
            com.cardinalcommerce.p060a.getValue.init(r2, r11, r11)
            int[] r2 = r6.configure
            com.cardinalcommerce.p060a.getValue.configure(r11, r10, r2)
            com.cardinalcommerce.a.DirectoryServerID r2 = new com.cardinalcommerce.a.DirectoryServerID
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00fb
            int[] r5 = r2.configure
            int[] r7 = r7.configure
            int[] r8 = r2.configure
            com.cardinalcommerce.p060a.getValue.init(r5, r7, r8)
        L_0x00fb:
            if (r15 != 0) goto L_0x0106
            int[] r5 = r2.configure
            int[] r1 = r1.configure
            int[] r7 = r2.configure
            com.cardinalcommerce.p060a.getValue.init(r5, r1, r7)
        L_0x0106:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.getSeverity r8 = new com.cardinalcommerce.a.getSeverity
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.getSeverity.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        DirectoryServerID directoryServerID = (DirectoryServerID) this.init;
        if (directoryServerID.cleanup()) {
            return cca_continue.init();
        }
        DirectoryServerID directoryServerID2 = (DirectoryServerID) this.configure;
        DirectoryServerID directoryServerID3 = (DirectoryServerID) this.cca_continue[0];
        int[] iArr = new int[17];
        int[] iArr2 = new int[17];
        int[] iArr3 = new int[17];
        getValue.init(directoryServerID.configure, iArr3);
        int[] iArr4 = new int[17];
        getValue.init(iArr3, iArr4);
        boolean CardinalError = directoryServerID3.CardinalError();
        int[] iArr5 = directoryServerID3.configure;
        if (!CardinalError) {
            getValue.init(directoryServerID3.configure, iArr2);
            iArr5 = iArr2;
        }
        getValue.configure(directoryServerID2.configure, iArr5, iArr);
        getValue.cca_continue(directoryServerID2.configure, iArr5, iArr2);
        getValue.init(iArr2, iArr, iArr2);
        setDrawingCacheQuality.getInstance(17, iArr2, iArr2, iArr2);
        getValue.cca_continue(iArr2);
        getValue.init(iArr3, directoryServerID2.configure, iArr3);
        setDrawingCacheQuality.getInstance(17, iArr3, 0);
        getValue.cca_continue(iArr3);
        setDrawingCacheQuality.init(17, iArr4, 0, iArr);
        getValue.cca_continue(iArr);
        DirectoryServerID directoryServerID4 = new DirectoryServerID(iArr4);
        getValue.init(iArr2, directoryServerID4.configure);
        getValue.configure(directoryServerID4.configure, iArr3, directoryServerID4.configure);
        getValue.configure(directoryServerID4.configure, iArr3, directoryServerID4.configure);
        DirectoryServerID directoryServerID5 = new DirectoryServerID(iArr3);
        getValue.configure(iArr3, directoryServerID4.configure, directoryServerID5.configure);
        getValue.init(directoryServerID5.configure, iArr2, directoryServerID5.configure);
        getValue.configure(directoryServerID5.configure, iArr, directoryServerID5.configure);
        DirectoryServerID directoryServerID6 = new DirectoryServerID(iArr2);
        getValue.configure(directoryServerID.configure, directoryServerID6.configure);
        if (!CardinalError) {
            getValue.init(directoryServerID6.configure, directoryServerID3.configure, directoryServerID6.configure);
        }
        return new getSeverity(cca_continue, directoryServerID4, directoryServerID5, new getAcsTransactionID[]{directoryServerID6}, this.getInstance);
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
