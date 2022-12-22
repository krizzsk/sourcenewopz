package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getProgressView */
public final class getProgressView extends getSDKAppID.getInstance {
    public static final BigInteger getWarnings = new BigInteger(1, setTextDirection.getInstance("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: a */
    private setVisibility f2572a = new setVisibility(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final boolean cca_continue(int i) {
        return i == 2;
    }

    public final int configure() {
        return getWarnings.bitLength();
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setVisibility(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setVisibility(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setOnTouchListener(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new getProgressView();
    }

    public final ChallengeParameters init() {
        return this.f2572a;
    }

    public getProgressView() {
        super(getWarnings);
        this.getInstance = new setOnTouchListener(new BigInteger(1, setTextDirection.getInstance("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.Cardinal = new setOnTouchListener(new BigInteger(1, setTextDirection.getInstance("E87579C11079F43DD824993C2CEE5ED3")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFE0000000075A30D1B9038A115"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i << 2) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            int[] iArr2 = ((setOnTouchListener) challengeParameters.getWarnings()).Cardinal;
            iArr[i2] = iArr2[0];
            iArr[i2 + 1] = iArr2[1];
            iArr[i2 + 2] = iArr2[2];
            iArr[i2 + 3] = iArr2[3];
            int i4 = i2 + 4;
            int[] iArr3 = ((setOnTouchListener) challengeParameters.CardinalActionCode()).Cardinal;
            iArr[i4] = iArr3[0];
            iArr[i4 + 1] = iArr3[1];
            iArr[i4 + 2] = iArr3[2];
            iArr[i4 + 3] = iArr3[3];
            i2 = i4 + 4;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                int[] iArr = new int[4];
                int[] iArr2 = new int[4];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 4; i5++) {
                        int i6 = iArr[i5];
                        int[] iArr3 = iArr;
                        iArr[i5] = i6 ^ (iArr3[i2 + i5] & i4);
                        iArr2[i5] = iArr2[i5] ^ (iArr3[(i2 + 4) + i5] & i4);
                    }
                    i2 += 8;
                }
                return new setVisibility(getProgressView.this, new setOnTouchListener(iArr), new setOnTouchListener(iArr2), false);
            }
        };
    }
}
