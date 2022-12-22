package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.BCRSAPublicKey */
public class BCRSAPublicKey implements getSDKReferenceNumber {
    public getSDKAppID Cardinal;
    public BigInteger cca_continue;
    private byte[] configure;
    public BigInteger getInstance;
    private BigInteger getSDKVersion;
    public ChallengeParameters init;

    public BCRSAPublicKey(getSDKAppID getsdkappid, ChallengeParameters challengeParameters, BigInteger bigInteger, BigInteger bigInteger2) {
        this(getsdkappid, challengeParameters, bigInteger, bigInteger2, (byte[]) null);
    }

    public BCRSAPublicKey(getSDKAppID getsdkappid, ChallengeParameters challengeParameters, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.getSDKVersion = null;
        if (getsdkappid == null) {
            throw new NullPointerException("curve");
        } else if (bigInteger != null) {
            this.Cardinal = getsdkappid;
            this.init = getInstance(getsdkappid, challengeParameters);
            this.cca_continue = bigInteger;
            this.getInstance = bigInteger2;
            this.configure = setForegroundTintBlendMode.cca_continue(bArr);
        } else {
            throw new NullPointerException(CampaignValue.f40469b);
        }
    }

    public final synchronized BigInteger configure() {
        if (this.getSDKVersion == null) {
            this.getSDKVersion = this.getInstance.modInverse(this.cca_continue);
        }
        return this.getSDKVersion;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BCRSAPublicKey) {
            BCRSAPublicKey bCRSAPublicKey = (BCRSAPublicKey) obj;
            return this.Cardinal.configure(bCRSAPublicKey.Cardinal) && this.init.init(bCRSAPublicKey.init) && this.cca_continue.equals(bCRSAPublicKey.cca_continue) && this.getInstance.equals(bCRSAPublicKey.getInstance);
        }
    }

    public int hashCode() {
        return (((((this.Cardinal.hashCode() * 37) ^ this.init.hashCode()) * 37) ^ this.cca_continue.hashCode()) * 37) ^ this.getInstance.hashCode();
    }

    public final byte[] init() {
        return setForegroundTintBlendMode.cca_continue(this.configure);
    }

    static ChallengeParameters getInstance(getSDKAppID getsdkappid, ChallengeParameters challengeParameters) {
        if (challengeParameters == null) {
            throw new IllegalArgumentException("Point has null value");
        } else if (getsdkappid.configure(challengeParameters.cca_continue())) {
            ChallengeParameters CardinalRenderType = getsdkappid.Cardinal(challengeParameters).CardinalRenderType();
            if (CardinalRenderType.valueOf()) {
                throw new IllegalArgumentException("Point at infinity");
            } else if (CardinalRenderType.getActionCode()) {
                return CardinalRenderType;
            } else {
                throw new IllegalArgumentException("Point not on curve");
            }
        } else {
            throw new IllegalArgumentException("Point must be on the same curve");
        }
    }
}
