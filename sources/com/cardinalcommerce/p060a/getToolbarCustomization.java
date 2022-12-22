package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getToolbarCustomization */
public final class getToolbarCustomization extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setToolbarCustomization f2581a = new setToolbarCustomization(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

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
        return 239;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setToolbarCustomization(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setToolbarCustomization(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setButtonText(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new getToolbarCustomization();
    }

    public final ChallengeParameters init() {
        return this.f2581a;
    }

    public getToolbarCustomization() {
        super(239, 158, 0, 0);
        this.getInstance = new setButtonText(BigInteger.valueOf(0));
        this.Cardinal = new setButtonText(BigInteger.valueOf(1));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.init = BigInteger.valueOf(4);
        this.cleanup = 6;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i << 2) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            long[] jArr2 = ((setButtonText) challengeParameters.getWarnings()).cca_continue;
            jArr[i2] = jArr2[0];
            jArr[i2 + 1] = jArr2[1];
            jArr[i2 + 2] = jArr2[2];
            jArr[i2 + 3] = jArr2[3];
            int i4 = i2 + 4;
            long[] jArr3 = ((setButtonText) challengeParameters.CardinalActionCode()).cca_continue;
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
                return new setToolbarCustomization(getToolbarCustomization.this, new setButtonText(jArr), new setButtonText(jArr2), false);
            }
        };
    }
}
