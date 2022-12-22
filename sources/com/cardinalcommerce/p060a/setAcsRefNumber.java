package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import org.bouncycastle.math.p082ec.FixedPointUtil;

/* renamed from: com.cardinalcommerce.a.setAcsRefNumber */
public final class setAcsRefNumber extends AuthenticationRequestParameters {
    /* access modifiers changed from: protected */
    public final ChallengeParameters init(ChallengeParameters challengeParameters, BigInteger bigInteger) {
        getSDKAppID cca_continue = challengeParameters.cca_continue();
        BigInteger values = cca_continue.values();
        int configure = values == null ? cca_continue.configure() + 1 : values.bitLength();
        if (bigInteger.bitLength() <= configure) {
            getSDKAppID cca_continue2 = challengeParameters.cca_continue();
            setAcsSignedContent setacssignedcontent = (setAcsSignedContent) cca_continue2.getInstance(challengeParameters, FixedPointUtil.PRECOMP_NAME, new ConfigParameters(cca_continue2, challengeParameters) {
                private /* synthetic */ ChallengeParameters Cardinal;
                private /* synthetic */ getSDKAppID init;

                {
                    this.init = r1;
                    this.Cardinal = r2;
                }

                private static boolean Cardinal(getMessageVersion getmessageversion, int i) {
                    return getmessageversion != null && getmessageversion.getInstance() >= i;
                }

                public final KeyAgreementSpi.ECKAEGwithSHA512KDF init(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
                    setAcsSignedContent setacssignedcontent = eCKAEGwithSHA512KDF instanceof setAcsSignedContent ? (setAcsSignedContent) eCKAEGwithSHA512KDF : null;
                    getSDKAppID getsdkappid = this.init;
                    BigInteger values = getsdkappid.values();
                    int configure = values == null ? getsdkappid.configure() + 1 : values.bitLength();
                    int i = configure > 250 ? 6 : 5;
                    int i2 = 1 << i;
                    if (getInstance(setacssignedcontent, i2)) {
                        return setacssignedcontent;
                    }
                    int i3 = ((configure + i) - 1) / i;
                    ChallengeParameters[] challengeParametersArr = new ChallengeParameters[(i + 1)];
                    challengeParametersArr[0] = this.Cardinal;
                    for (int i4 = 1; i4 < i; i4++) {
                        challengeParametersArr[i4] = challengeParametersArr[i4 - 1].getInstance(i3);
                    }
                    challengeParametersArr[i] = challengeParametersArr[0].configure(challengeParametersArr[1]);
                    this.init.getInstance(challengeParametersArr);
                    ChallengeParameters[] challengeParametersArr2 = new ChallengeParameters[i2];
                    challengeParametersArr2[0] = challengeParametersArr[0];
                    for (int i5 = i - 1; i5 >= 0; i5--) {
                        ChallengeParameters challengeParameters = challengeParametersArr[i5];
                        int i6 = 1 << i5;
                        for (int i7 = i6; i7 < i2; i7 += i6 << 1) {
                            challengeParametersArr2[i7] = challengeParametersArr2[i7 - i6].getInstance(challengeParameters);
                        }
                    }
                    this.init.getInstance(challengeParametersArr2);
                    setAcsSignedContent setacssignedcontent2 = new setAcsSignedContent();
                    setacssignedcontent2.cca_continue = this.init.Cardinal(challengeParametersArr2, i2);
                    setacssignedcontent2.getInstance = challengeParametersArr[i];
                    setacssignedcontent2.configure = i;
                    return setacssignedcontent2;
                }

                private static boolean getInstance(setAcsSignedContent setacssignedcontent, int i) {
                    return setacssignedcontent != null && Cardinal(setacssignedcontent.cca_continue, i);
                }
            });
            getMessageVersion getmessageversion = setacssignedcontent.cca_continue;
            int i = setacssignedcontent.configure;
            int i2 = ((configure + i) - 1) / i;
            ChallengeParameters init = cca_continue.init();
            int i3 = i * i2;
            int[] cca_continue3 = setDrawingCacheQuality.cca_continue(i3, bigInteger);
            int i4 = i3 - 1;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = 0;
                for (int i7 = i4 - i5; i7 >= 0; i7 -= i2) {
                    int i8 = cca_continue3[i7 >>> 5] >>> (i7 & 31);
                    i6 = ((i6 ^ (i8 >>> 1)) << 1) ^ i8;
                }
                init = init.Cardinal(getmessageversion.Cardinal(i6));
            }
            return init.getInstance(setacssignedcontent.getInstance);
        }
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
