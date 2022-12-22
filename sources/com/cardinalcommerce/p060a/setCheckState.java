package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCheckState */
public final class setCheckState extends getSDKAppID.getInstance {
    public static final BigInteger CardinalError = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* renamed from: a */
    private setCCAVisibility f2742a = new setCCAVisibility(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 5) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setScrollContainer.getInstance(((setCCAText) challengeParameters.getWarnings()).Cardinal, iArr, i2);
            int i4 = i2 + 5;
            setScrollContainer.getInstance(((setCCAText) challengeParameters.CardinalActionCode()).Cardinal, iArr, i4);
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
                return new setCCAVisibility(setCheckState.this, new setCCAText(iArr), new setCCAText(iArr2), false);
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
        return new setCCAVisibility(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setCCAVisibility(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setCCAText(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setCheckState();
    }

    public final ChallengeParameters init() {
        return this.f2742a;
    }

    public setCheckState() {
        super(CardinalError);
        this.getInstance = new setCCAText(new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.Cardinal = new setCCAText(new BigInteger(1, setTextDirection.getInstance("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("0100000000000000000001F4C8F927AED3CA752257"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
