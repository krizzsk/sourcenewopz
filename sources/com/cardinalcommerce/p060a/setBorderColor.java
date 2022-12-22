package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setBorderColor */
public final class setBorderColor extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private getButtonText f2701a = new getButtonText(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

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
        return 233;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new getButtonText(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new getButtonText(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new getHeaderText(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setBorderColor();
    }

    public final ChallengeParameters init() {
        return this.f2701a;
    }

    public setBorderColor() {
        super(233, 74, 0, 0);
        this.getInstance = new getHeaderText(BigInteger.valueOf(0));
        this.Cardinal = new getHeaderText(BigInteger.valueOf(1));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
        this.init = BigInteger.valueOf(4);
        this.cleanup = 6;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i << 2) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            long[] jArr2 = ((getHeaderText) challengeParameters.getWarnings()).cca_continue;
            jArr[i2] = jArr2[0];
            jArr[i2 + 1] = jArr2[1];
            jArr[i2 + 2] = jArr2[2];
            jArr[i2 + 3] = jArr2[3];
            int i4 = i2 + 4;
            long[] jArr3 = ((getHeaderText) challengeParameters.CardinalActionCode()).cca_continue;
            jArr[i4] = jArr3[0];
            jArr[i4 + 1] = jArr3[1];
            jArr[i4 + 2] = jArr3[2];
            jArr[i4 + 3] = jArr3[3];
            i2 = i4 + 4;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[4];
                long[] jArr2 = new long[4];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 4; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 4) + i4] & j);
                    }
                    i2 += 8;
                }
                return new getButtonText(setBorderColor.this, new getHeaderText(jArr), new getHeaderText(jArr2), false);
            }
        };
    }
}
