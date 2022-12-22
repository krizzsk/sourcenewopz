package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.EncryptedJWT */
public final class EncryptedJWT extends Container {
    public String configure;

    public EncryptedJWT(String str, getSDKAppID getsdkappid, ChallengeParameters challengeParameters, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(getsdkappid, challengeParameters, bigInteger, bigInteger2, bArr);
        this.configure = str;
    }
}
