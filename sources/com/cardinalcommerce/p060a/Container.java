package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* renamed from: com.cardinalcommerce.a.Container */
public class Container implements AlgorithmParameterSpec {
    public ChallengeParameters Cardinal;

    /* renamed from: a */
    private byte[] f2350a;
    public BigInteger cca_continue;
    public BigInteger getInstance;
    public getSDKAppID init;

    public Container(getSDKAppID getsdkappid, ChallengeParameters challengeParameters, BigInteger bigInteger) {
        this.init = getsdkappid;
        this.Cardinal = challengeParameters.CardinalRenderType();
        this.getInstance = bigInteger;
        this.cca_continue = BigInteger.valueOf(1);
        this.f2350a = null;
    }

    public Container(getSDKAppID getsdkappid, ChallengeParameters challengeParameters, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.init = getsdkappid;
        this.Cardinal = challengeParameters.CardinalRenderType();
        this.getInstance = bigInteger;
        this.cca_continue = bigInteger2;
        this.f2350a = bArr;
    }

    public final byte[] getInstance() {
        return this.f2350a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Container)) {
            return false;
        }
        Container container = (Container) obj;
        if (!this.init.configure(container.init) || !this.Cardinal.init(container.Cardinal)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.init.hashCode() ^ this.Cardinal.hashCode();
    }
}
