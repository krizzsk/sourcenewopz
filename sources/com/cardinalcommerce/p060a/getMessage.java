package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.getMessage */
public final class getMessage extends getSDKAppID.getInstance {
    public static final BigInteger CardinalError = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* renamed from: a */
    private InvalidInputException f2568a = new InvalidInputException(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final boolean cca_continue(int i) {
        return i == 2;
    }

    public final int configure() {
        return CardinalError.bitLength();
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new InvalidInputException(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new InvalidInputException(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new getErrorDetails(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new getMessage();
    }

    public final ChallengeParameters init() {
        return this.f2568a;
    }

    public getMessage() {
        super(CardinalError);
        this.getInstance = new getErrorDetails(new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.Cardinal = new getErrorDetails(new BigInteger(1, setTextDirection.getInstance("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 12) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            System.arraycopy(((getErrorDetails) challengeParameters.getWarnings()).configure, 0, iArr, i2, 12);
            int i4 = i2 + 12;
            System.arraycopy(((getErrorDetails) challengeParameters.CardinalActionCode()).configure, 0, iArr, i4, 12);
            i2 = i4 + 12;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                int[] iArr = new int[12];
                int[] iArr2 = new int[12];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 12; i5++) {
                        int i6 = iArr[i5];
                        int[] iArr3 = iArr;
                        iArr[i5] = i6 ^ (iArr3[i2 + i5] & i4);
                        iArr2[i5] = iArr2[i5] ^ (iArr3[(i2 + 12) + i5] & i4);
                    }
                    i2 += 24;
                }
                return new InvalidInputException(getMessage.this, new getErrorDetails(iArr), new getErrorDetails(iArr2), false);
            }
        };
    }
}
