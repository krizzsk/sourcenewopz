package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.ByteUtils */
public class ByteUtils extends Base64 {
    public ChallengeParameters Cardinal;

    public ByteUtils(ChallengeParameters challengeParameters, Container container) {
        super(container);
        if (challengeParameters.cca_continue() != null) {
            this.Cardinal = challengeParameters.CardinalRenderType();
        } else {
            this.Cardinal = challengeParameters;
        }
    }
}
