package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setVerticalScrollbarTrackDrawable */
public final class setVerticalScrollbarTrackDrawable extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setHorizontalScrollbarThumbDrawable f3094a = new setHorizontalScrollbarThumbDrawable(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i * 7) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextClusterForwardId.cca_continue(((unregisterForContextMenu) challengeParameters.getWarnings()).cca_continue, jArr, i2);
            int i4 = i2 + 7;
            setNextClusterForwardId.cca_continue(((unregisterForContextMenu) challengeParameters.CardinalActionCode()).cca_continue, jArr, i4);
            i2 = i4 + 7;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[7];
                long[] jArr2 = new long[7];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 7; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 7) + i4] & j);
                    }
                    i2 += 14;
                }
                return new setHorizontalScrollbarThumbDrawable(setVerticalScrollbarTrackDrawable.this, new unregisterForContextMenu(jArr), new unregisterForContextMenu(jArr2), false);
            }
        };
    }

    public final boolean CardinalRenderType() {
        return false;
    }

    public final boolean cca_continue(int i) {
        return i == 6;
    }

    public final int configure() {
        return 409;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setHorizontalScrollbarThumbDrawable(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setHorizontalScrollbarThumbDrawable(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new unregisterForContextMenu(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setVerticalScrollbarTrackDrawable();
    }

    public final ChallengeParameters init() {
        return this.f3094a;
    }

    public setVerticalScrollbarTrackDrawable() {
        super(409, 87, 0, 0);
        this.getInstance = new unregisterForContextMenu(BigInteger.valueOf(1));
        this.Cardinal = new unregisterForContextMenu(new BigInteger(1, setTextDirection.getInstance("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173"));
        this.init = BigInteger.valueOf(2);
        this.cleanup = 6;
    }
}
