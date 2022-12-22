package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAImageDrawable */
public final class setCCAImageDrawable extends getSDKAppID.getInstance {
    public static final BigInteger getWarnings = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* renamed from: a */
    private setOnScrollChangeListener f2719a = new setOnScrollChangeListener(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i << 3) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusLeftId.cca_continue(((setCCAOnScrollChangeListener) challengeParameters.getWarnings()).configure, iArr, i2);
            int i4 = i2 + 8;
            setNextFocusLeftId.cca_continue(((setCCAOnScrollChangeListener) challengeParameters.CardinalActionCode()).configure, iArr, i4);
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
                return new setOnScrollChangeListener(setCCAImageDrawable.this, new setCCAOnScrollChangeListener(iArr), new setCCAOnScrollChangeListener(iArr2), false);
            }
        };
    }

    public final boolean cca_continue(int i) {
        return i == 2;
    }

    public final int configure() {
        return getWarnings.bitLength();
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setOnScrollChangeListener(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setOnScrollChangeListener(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setCCAOnScrollChangeListener(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setCCAImageDrawable();
    }

    public final ChallengeParameters init() {
        return this.f2719a;
    }

    public setCCAImageDrawable() {
        super(getWarnings);
        this.getInstance = new setCCAOnScrollChangeListener(getSDKReferenceNumber.CardinalError);
        this.Cardinal = new setCCAOnScrollChangeListener(BigInteger.valueOf(7));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
