package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.ChallengeStatusReceiver */
public final class ChallengeStatusReceiver extends AuthenticationRequestParameters {
    /* access modifiers changed from: protected */
    public final ChallengeParameters init(ChallengeParameters challengeParameters, BigInteger bigInteger) {
        if (challengeParameters instanceof ChallengeParameters.Cardinal) {
            ChallengeParameters.Cardinal cardinal = (ChallengeParameters.Cardinal) challengeParameters;
            getSDKAppID.Cardinal cardinal2 = (getSDKAppID.Cardinal) cardinal.cca_continue();
            int configure = cardinal2.configure();
            byte byteValue = cardinal2.cleanup().Cardinal().byteValue();
            byte a = C1996g.m1874a((int) byteValue);
            return m1798a(cardinal, C1996g.m1878a(a, C1996g.m1876a(bigInteger, configure, byteValue, cardinal2.CardinalUiType(), a), BigInteger.valueOf(16), C1996g.m1877a(a), byteValue == 0 ? C1996g.f2534a : C1996g.f2535b));
        }
        throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
    }

    /* renamed from: a */
    private static ChallengeParameters.Cardinal m1798a(final ChallengeParameters.Cardinal cardinal, byte[] bArr) {
        getSDKAppID.Cardinal cardinal2 = (getSDKAppID.Cardinal) cardinal.cca_continue();
        final byte byteValue = cardinal2.cleanup().Cardinal().byteValue();
        ChallengeParameters.Cardinal[] cardinalArr = ((initialize) cardinal2.getInstance(cardinal, "bc_wtnaf", new ConfigParameters() {
            public final KeyAgreementSpi.ECKAEGwithSHA512KDF init(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
                if (eCKAEGwithSHA512KDF instanceof initialize) {
                    return eCKAEGwithSHA512KDF;
                }
                initialize initialize = new initialize();
                initialize.getInstance = C1996g.m1879a(cardinal, byteValue);
                return initialize;
            }
        })).getInstance;
        ChallengeParameters.Cardinal[] cardinalArr2 = new ChallengeParameters.Cardinal[cardinalArr.length];
        for (int i = 0; i < cardinalArr.length; i++) {
            cardinalArr2[i] = (ChallengeParameters.Cardinal) cardinalArr[i].getString();
        }
        ChallengeParameters.Cardinal cardinal3 = (ChallengeParameters.Cardinal) cardinal.cca_continue().init();
        int i2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i2++;
            byte b = bArr[length];
            if (b != 0) {
                cardinal3 = (ChallengeParameters.Cardinal) cardinal3.Cardinal(i2).getInstance((ChallengeParameters) b > 0 ? cardinalArr[b >>> 1] : cardinalArr2[(-b) >>> 1]);
                i2 = 0;
            }
        }
        return i2 > 0 ? cardinal3.Cardinal(i2) : cardinal3;
    }
}
