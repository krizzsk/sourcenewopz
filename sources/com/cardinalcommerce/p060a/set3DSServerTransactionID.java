package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.set3DSServerTransactionID */
public final class set3DSServerTransactionID extends AuthenticationRequestParameters {

    /* renamed from: a */
    private getSDKAppID f2655a;

    /* renamed from: b */
    private setOnGenericMotionListener f2656b;

    public set3DSServerTransactionID(getSDKAppID getsdkappid, setOnGenericMotionListener setongenericmotionlistener) {
        if (getsdkappid.values() != null) {
            this.f2655a = getsdkappid;
            this.f2656b = setongenericmotionlistener;
            return;
        }
        throw new IllegalArgumentException("Need curve with known group order");
    }

    /* access modifiers changed from: protected */
    public final ChallengeParameters init(ChallengeParameters challengeParameters, BigInteger bigInteger) {
        if (this.f2655a.configure(challengeParameters.cca_continue())) {
            BigInteger[] init = this.f2656b.init(bigInteger.mod(challengeParameters.cca_continue().values()));
            return getDeviceData.getInstance(challengeParameters, init[0], this.f2656b.cca_continue(), init[1]);
        }
        throw new IllegalStateException();
    }
}
