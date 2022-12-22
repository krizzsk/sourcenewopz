package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.runtimeError */
public final class runtimeError extends getSDKAppID.getInstance {
    public static final BigInteger getWarnings = setNextFocusLeftId.Cardinal(Transaction.f2487a);

    /* renamed from: a */
    private ThreeDS2Service f2637a = new ThreeDS2Service(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i << 3) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusLeftId.cca_continue(((timedout) challengeParameters.getWarnings()).cca_continue, iArr, i2);
            int i4 = i2 + 8;
            setNextFocusLeftId.cca_continue(((timedout) challengeParameters.CardinalActionCode()).cca_continue, iArr, i4);
            i2 = i4 + 8;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                int[] iArr = new int[8];
                int[] iArr2 = new int[8];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 8; i5++) {
                        int i6 = iArr[i5];
                        int[] iArr3 = iArr;
                        iArr[i5] = i6 ^ (iArr3[i2 + i5] & i4);
                        iArr2[i5] = iArr2[i5] ^ (iArr3[(i2 + 8) + i5] & i4);
                    }
                    i2 += 16;
                }
                return new ThreeDS2Service(runtimeError.this, new timedout(iArr), new timedout(iArr2), false);
            }
        };
    }

    public final boolean cca_continue(int i) {
        return i == 4;
    }

    public final int configure() {
        return getWarnings.bitLength();
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new ThreeDS2Service(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new ThreeDS2Service(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new timedout(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new runtimeError();
    }

    public final ChallengeParameters init() {
        return this.f2637a;
    }

    public runtimeError() {
        super(getWarnings);
        this.getInstance = new timedout(new BigInteger(1, setTextDirection.getInstance("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144")));
        this.Cardinal = new timedout(new BigInteger(1, setTextDirection.getInstance("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.init = BigInteger.valueOf(8);
        this.cleanup = 4;
    }
}
