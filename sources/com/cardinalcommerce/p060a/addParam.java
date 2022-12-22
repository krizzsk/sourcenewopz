package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.addParam */
public final class addParam implements get3DSServerTransactionID {

    /* renamed from: a */
    private getAcsTransactionID f2507a;

    public addParam(getAcsTransactionID getacstransactionid) {
        this.f2507a = getacstransactionid;
    }

    public final ChallengeParameters cca_continue(ChallengeParameters challengeParameters) {
        return challengeParameters.getInstance(this.f2507a);
    }
}
