package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getCause */
public final class getCause extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setTextFontName f2550a = new setTextFontName(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final boolean CardinalRenderType() {
        return false;
    }

    public final boolean cca_continue(int i) {
        return i == 6;
    }

    public final int configure() {
        return 113;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setTextFontName(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setTextFontName(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new SDKRuntimeException(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new getCause();
    }

    public final ChallengeParameters init() {
        return this.f2550a;
    }

    public getCause() {
        super(113, 9, 0, 0);
        this.getInstance = new SDKRuntimeException(new BigInteger(1, setTextDirection.getInstance("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.Cardinal = new SDKRuntimeException(new BigInteger(1, setTextDirection.getInstance("0095E9A9EC9B297BD4BF36E059184F")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("010000000000000108789B2496AF93"));
        this.init = BigInteger.valueOf(2);
        this.cleanup = 6;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i << 1) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            long[] jArr2 = ((SDKRuntimeException) challengeParameters.getWarnings()).init;
            jArr[i2] = jArr2[0];
            jArr[i2 + 1] = jArr2[1];
            int i4 = i2 + 2;
            long[] jArr3 = ((SDKRuntimeException) challengeParameters.CardinalActionCode()).init;
            jArr[i4] = jArr3[0];
            jArr[i4 + 1] = jArr3[1];
            i2 = i4 + 2;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[2];
                long[] jArr2 = new long[2];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 2; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 2) + i4] & j);
                    }
                    i2 += 4;
                }
                return new setTextFontName(getCause.this, new SDKRuntimeException(jArr), new SDKRuntimeException(jArr2), false);
            }
        };
    }
}
