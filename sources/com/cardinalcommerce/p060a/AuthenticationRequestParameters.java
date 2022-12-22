package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.AuthenticationRequestParameters */
public abstract class AuthenticationRequestParameters implements getAcsSignedContent {
    /* access modifiers changed from: protected */
    public abstract ChallengeParameters init(ChallengeParameters challengeParameters, BigInteger bigInteger);

    public final ChallengeParameters configure(ChallengeParameters challengeParameters, BigInteger bigInteger) {
        int signum = bigInteger.signum();
        if (signum == 0 || challengeParameters.valueOf()) {
            return challengeParameters.cca_continue().init();
        }
        ChallengeParameters init = init(challengeParameters, bigInteger.abs());
        if (signum <= 0) {
            init = init.getString();
        }
        if (init.setRequestTimeout()) {
            return init;
        }
        throw new IllegalStateException("Invalid result");
    }
}
