package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getTextBoxCustomization */
public final class getTextBoxCustomization extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setLabelCustomization f2579a = new setLabelCustomization(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getAcsSignedContent Cardinal() {
        return new ChallengeStatusReceiver();
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i * 5) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusUpId.Cardinal(((setTextBoxCustomization) challengeParameters.getWarnings()).init, jArr, i2);
            int i4 = i2 + 5;
            setNextFocusUpId.Cardinal(((setTextBoxCustomization) challengeParameters.CardinalActionCode()).init, jArr, i4);
            i2 = i4 + 5;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[5];
                long[] jArr2 = new long[5];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 5; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 5) + i4] & j);
                    }
                    i2 += 10;
                }
                return new setLabelCustomization(getTextBoxCustomization.this, new setTextBoxCustomization(jArr), new setTextBoxCustomization(jArr2), false);
            }
        };
    }

    public final boolean CardinalRenderType() {
        return true;
    }

    public final boolean cca_continue(int i) {
        return i == 6;
    }

    public final int configure() {
        return 283;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setLabelCustomization(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setLabelCustomization(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setTextBoxCustomization(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new getTextBoxCustomization();
    }

    public final ChallengeParameters init() {
        return this.f2579a;
    }

    public getTextBoxCustomization() {
        super(283, 5, 7, 12);
        this.getInstance = new setTextBoxCustomization(BigInteger.valueOf(0));
        this.Cardinal = new setTextBoxCustomization(BigInteger.valueOf(1));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
        this.init = BigInteger.valueOf(4);
        this.cleanup = 6;
    }
}
