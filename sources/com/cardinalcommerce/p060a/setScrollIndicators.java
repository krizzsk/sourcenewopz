package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setScrollIndicators */
public final class setScrollIndicators extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setHorizontalScrollbarTrackDrawable f2971a = new setHorizontalScrollbarTrackDrawable(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getAcsSignedContent Cardinal() {
        return new ChallengeStatusReceiver();
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i * 9) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusForwardId.cca_continue(((onContextItemSelected) challengeParameters.getWarnings()).getInstance, jArr, i2);
            int i4 = i2 + 9;
            setNextFocusForwardId.cca_continue(((onContextItemSelected) challengeParameters.CardinalActionCode()).getInstance, jArr, i4);
            i2 = i4 + 9;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[9];
                long[] jArr2 = new long[9];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 9; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 9) + i4] & j);
                    }
                    i2 += 18;
                }
                return new setHorizontalScrollbarTrackDrawable(setScrollIndicators.this, new onContextItemSelected(jArr), new onContextItemSelected(jArr2), false);
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
        return 571;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setHorizontalScrollbarTrackDrawable(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setHorizontalScrollbarTrackDrawable(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new onContextItemSelected(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setScrollIndicators();
    }

    public final ChallengeParameters init() {
        return this.f2971a;
    }

    public setScrollIndicators() {
        super(571, 2, 5, 10);
        this.getInstance = new onContextItemSelected(BigInteger.valueOf(0));
        this.Cardinal = new onContextItemSelected(BigInteger.valueOf(1));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
        this.init = BigInteger.valueOf(4);
        this.cleanup = 6;
    }
}
