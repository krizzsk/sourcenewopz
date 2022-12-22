package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.openContextMenu */
public final class openContextMenu extends getSDKAppID.Cardinal {

    /* renamed from: a */
    private setFadingEdgeLength f2623a = new setFadingEdgeLength(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getAcsSignedContent Cardinal() {
        return new ChallengeStatusReceiver();
    }

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
                return new setFadingEdgeLength(openContextMenu.this, new unregisterForContextMenu(jArr), new unregisterForContextMenu(jArr2), false);
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
        return 409;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setFadingEdgeLength(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setFadingEdgeLength(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new unregisterForContextMenu(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new openContextMenu();
    }

    public final ChallengeParameters init() {
        return this.f2623a;
    }

    public openContextMenu() {
        super(409, 87, 0, 0);
        this.getInstance = new unregisterForContextMenu(BigInteger.valueOf(0));
        this.Cardinal = new unregisterForContextMenu(BigInteger.valueOf(1));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.init = BigInteger.valueOf(4);
        this.cleanup = 6;
    }
}
