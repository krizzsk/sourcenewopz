package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.LabelCustomization */
public final class LabelCustomization extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setHeadingTextFontName f2460a = new setHeadingTextFontName(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getAcsSignedContent Cardinal() {
        return new ChallengeStatusReceiver();
    }

    public final boolean CardinalRenderType() {
        return true;
    }

    public final boolean cca_continue(int i) {
        return i == 6;
    }

    public final int configure() {
        return 163;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setHeadingTextFontName(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setHeadingTextFontName(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setTextFontSize(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new LabelCustomization();
    }

    public final ChallengeParameters init() {
        return this.f2460a;
    }

    public LabelCustomization() {
        super(163, 3, 6, 7);
        this.getInstance = new setTextFontSize(BigInteger.valueOf(1));
        this.Cardinal = this.getInstance;
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("04000000000000000000020108A2E0CC0D99F8A5EF"));
        this.init = BigInteger.valueOf(2);
        this.cleanup = 6;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i * 3) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            long[] jArr2 = ((setTextFontSize) challengeParameters.getWarnings()).configure;
            jArr[i2] = jArr2[0];
            jArr[i2 + 1] = jArr2[1];
            jArr[i2 + 2] = jArr2[2];
            int i4 = i2 + 3;
            long[] jArr3 = ((setTextFontSize) challengeParameters.CardinalActionCode()).configure;
            jArr[i4] = jArr3[0];
            jArr[i4 + 1] = jArr3[1];
            jArr[i4 + 2] = jArr3[2];
            i2 = i4 + 3;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[3];
                long[] jArr2 = new long[3];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 3; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 3) + i4] & j);
                    }
                    i2 += 6;
                }
                return new setHeadingTextFontName(LabelCustomization.this, new setTextFontSize(jArr), new setTextFontSize(jArr2), false);
            }
        };
    }
}
