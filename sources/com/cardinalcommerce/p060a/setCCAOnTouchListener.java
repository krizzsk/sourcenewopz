package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAOnTouchListener */
public final class setCCAOnTouchListener extends getSDKAppID.getInstance {
    public static final BigInteger CardinalError = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));

    /* renamed from: a */
    private setElevation f2733a = new setElevation(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 5) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setScrollContainer.getInstance(((setOnCheckedChangeListener) challengeParameters.getWarnings()).getInstance, iArr, i2);
            int i4 = i2 + 5;
            setScrollContainer.getInstance(((setOnCheckedChangeListener) challengeParameters.CardinalActionCode()).getInstance, iArr, i4);
            i2 = i4 + 5;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                int[] iArr = new int[5];
                int[] iArr2 = new int[5];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 5; i5++) {
                        int i6 = iArr[i5];
                        int[] iArr3 = iArr;
                        iArr[i5] = i6 ^ (iArr3[i2 + i5] & i4);
                        iArr2[i5] = iArr2[i5] ^ (iArr3[(i2 + 5) + i5] & i4);
                    }
                    i2 += 10;
                }
                return new setElevation(setCCAOnTouchListener.this, new setOnCheckedChangeListener(iArr), new setOnCheckedChangeListener(iArr2), false);
            }
        };
    }

    public final boolean cca_continue(int i) {
        return i == 2;
    }

    public final int configure() {
        return CardinalError.bitLength();
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setElevation(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setElevation(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setOnCheckedChangeListener(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setCCAOnTouchListener();
    }

    public final ChallengeParameters init() {
        return this.f2733a;
    }

    public setCCAOnTouchListener() {
        super(CardinalError);
        this.getInstance = new setOnCheckedChangeListener(new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.Cardinal = new setOnCheckedChangeListener(new BigInteger(1, setTextDirection.getInstance("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("0100000000000000000000351EE786A818F3A1A16B"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
