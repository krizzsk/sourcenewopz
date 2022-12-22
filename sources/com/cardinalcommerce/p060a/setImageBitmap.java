package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setImageBitmap */
public final class setImageBitmap extends ChallengeParameters.cca_continue {
    public setImageBitmap(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setImageBitmap(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setImageBitmap(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
    }

    public final ChallengeParameters getChallengeTimeout() {
        return (valueOf() || this.init.cleanup()) ? this : getRequestTimeout().getInstance((ChallengeParameters) this);
    }

    public final ChallengeParameters getString() {
        return valueOf() ? this : new setImageBitmap(this.Cardinal, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setImageBitmap((getSDKAppID) null, sDKVersion, CardinalError());
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
            com.cardinalcommerce.a.setImageIcon r2 = (com.cardinalcommerce.p060a.setImageIcon) r2
            com.cardinalcommerce.a.getAcsTransactionID r4 = r0.init
            com.cardinalcommerce.a.setImageIcon r4 = (com.cardinalcommerce.p060a.setImageIcon) r4
            com.cardinalcommerce.a.getAcsTransactionID r5 = r17.values()
            com.cardinalcommerce.a.setImageIcon r5 = (com.cardinalcommerce.p060a.setImageIcon) r5
            com.cardinalcommerce.a.getAcsTransactionID r6 = r17.CardinalError()
            com.cardinalcommerce.a.setImageIcon r6 = (com.cardinalcommerce.p060a.setImageIcon) r6
            com.cardinalcommerce.a.getAcsTransactionID[] r7 = r0.cca_continue
            r8 = 0
            r7 = r7[r8]
            com.cardinalcommerce.a.setImageIcon r7 = (com.cardinalcommerce.p060a.setImageIcon) r7
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.cca_continue((int) r8)
            com.cardinalcommerce.a.setImageIcon r1 = (com.cardinalcommerce.p060a.setImageIcon) r1
            r9 = 14
            int[] r9 = new int[r9]
            r10 = 7
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r7.CardinalError()
            if (r14 == 0) goto L_0x0054
            int[] r5 = r5.init
            int[] r6 = r6.init
            goto L_0x006a
        L_0x0054:
            int[] r15 = r7.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r15, r12)
            int[] r5 = r5.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r12, r5, r11)
            int[] r5 = r7.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r12, r5, r12)
            int[] r5 = r6.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x006a:
            boolean r15 = r1.CardinalError()
            if (r15 == 0) goto L_0x0075
            int[] r2 = r2.init
            int[] r4 = r4.init
            goto L_0x008b
        L_0x0075:
            int[] r8 = r1.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r8, r13)
            int[] r2 = r2.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r13, r2, r9)
            int[] r2 = r1.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r13, r2, r13)
            int[] r2 = r4.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x008b:
            int[] r8 = new int[r10]
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r2, r5, r8)
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r4, r6, r11)
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
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r8, r12)
            int[] r5 = new int[r10]
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r12, r8, r5)
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r12, r2, r12)
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.cca_continue(r5, r5)
            com.cardinalcommerce.p060a.setNextFocusDownId.configure(r4, r5, r9)
            int r2 = com.cardinalcommerce.p060a.setNextFocusDownId.init((int[]) r12, (int[]) r12, (int[]) r5)
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.configure((int) r2, (int[]) r5)
            com.cardinalcommerce.a.setImageIcon r4 = new com.cardinalcommerce.a.setImageIcon
            r4.<init>((int[]) r13)
            int[] r2 = r4.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r11, r2)
            int[] r2 = r4.init
            int[] r6 = r4.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r2, r5, r6)
            com.cardinalcommerce.a.setImageIcon r6 = new com.cardinalcommerce.a.setImageIcon
            r6.<init>((int[]) r5)
            int[] r2 = r4.init
            int[] r5 = r6.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.Cardinal(r12, r2, r5)
            int[] r2 = r6.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.configure((int[]) r2, (int[]) r11, (int[]) r9)
            int[] r2 = r6.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.configure((int[]) r9, (int[]) r2)
            com.cardinalcommerce.a.setImageIcon r2 = new com.cardinalcommerce.a.setImageIcon
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x00f8
            int[] r5 = r2.init
            int[] r7 = r7.init
            int[] r8 = r2.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r5, r7, r8)
        L_0x00f8:
            if (r15 != 0) goto L_0x0103
            int[] r5 = r2.init
            int[] r1 = r1.init
            int[] r7 = r2.init
            com.cardinalcommerce.p060a.setCCAFocusableInTouchMode.init(r5, r1, r7)
        L_0x0103:
            r1 = 1
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r1]
            r5 = 0
            r1[r5] = r2
            com.cardinalcommerce.a.setImageBitmap r8 = new com.cardinalcommerce.a.setImageBitmap
            boolean r7 = r0.getInstance
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setImageBitmap.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        setImageIcon setimageicon = (setImageIcon) this.init;
        if (setimageicon.cleanup()) {
            return cca_continue.init();
        }
        setImageIcon setimageicon2 = (setImageIcon) this.configure;
        setImageIcon setimageicon3 = (setImageIcon) this.cca_continue[0];
        int[] iArr = new int[7];
        setCCAFocusableInTouchMode.Cardinal(setimageicon.init, iArr);
        int[] iArr2 = new int[7];
        setCCAFocusableInTouchMode.Cardinal(iArr, iArr2);
        int[] iArr3 = new int[7];
        setCCAFocusableInTouchMode.Cardinal(setimageicon2.init, iArr3);
        setCCAFocusableInTouchMode.configure(setNextFocusDownId.init(iArr3, iArr3, iArr3), iArr3);
        setCCAFocusableInTouchMode.init(iArr, setimageicon2.init, iArr);
        setCCAFocusableInTouchMode.configure(setDrawingCacheQuality.getInstance(7, iArr, 0), iArr);
        int[] iArr4 = new int[7];
        setCCAFocusableInTouchMode.configure(setDrawingCacheQuality.init(7, iArr2, 0, iArr4), iArr4);
        setImageIcon setimageicon4 = new setImageIcon(iArr2);
        setCCAFocusableInTouchMode.Cardinal(iArr3, setimageicon4.init);
        setCCAFocusableInTouchMode.Cardinal(setimageicon4.init, iArr, setimageicon4.init);
        setCCAFocusableInTouchMode.Cardinal(setimageicon4.init, iArr, setimageicon4.init);
        setImageIcon setimageicon5 = new setImageIcon(iArr);
        setCCAFocusableInTouchMode.Cardinal(iArr, setimageicon4.init, setimageicon5.init);
        setCCAFocusableInTouchMode.init(setimageicon5.init, iArr3, setimageicon5.init);
        setCCAFocusableInTouchMode.Cardinal(setimageicon5.init, iArr4, setimageicon5.init);
        setImageIcon setimageicon6 = new setImageIcon(iArr3);
        setCCAFocusableInTouchMode.init(setimageicon.init, setimageicon6.init);
        if (!setimageicon3.CardinalError()) {
            setCCAFocusableInTouchMode.init(setimageicon6.init, setimageicon3.init, setimageicon6.init);
        }
        return new setImageBitmap(cca_continue, setimageicon4, setimageicon5, new getAcsTransactionID[]{setimageicon6}, this.getInstance);
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
