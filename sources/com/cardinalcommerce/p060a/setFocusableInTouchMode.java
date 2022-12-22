package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setFocusableInTouchMode */
public final class setFocusableInTouchMode extends getSDKAppID.getInstance {
    public static final BigInteger getWarnings = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* renamed from: a */
    private setImageURI f2781a = new setImageURI(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 6) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setKeepScreenOn.Cardinal(((setCCAElevation) challengeParameters.getWarnings()).cca_continue, iArr, i2);
            int i4 = i2 + 6;
            setKeepScreenOn.Cardinal(((setCCAElevation) challengeParameters.CardinalActionCode()).cca_continue, iArr, i4);
            i2 = i4 + 6;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                int[] iArr = new int[6];
                int[] iArr2 = new int[6];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 6; i5++) {
                        int i6 = iArr[i5];
                        int[] iArr3 = iArr;
                        iArr[i5] = i6 ^ (iArr3[i2 + i5] & i4);
                        iArr2[i5] = iArr2[i5] ^ (iArr3[(i2 + 6) + i5] & i4);
                    }
                    i2 += 12;
                }
                return new setImageURI(setFocusableInTouchMode.this, new setCCAElevation(iArr), new setCCAElevation(iArr2), false);
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
        return new setImageURI(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setImageURI(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setCCAElevation(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setFocusableInTouchMode();
    }

    public final ChallengeParameters init() {
        return this.f2781a;
    }

    public setFocusableInTouchMode() {
        super(getWarnings);
        this.getInstance = new setCCAElevation(new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.Cardinal = new setCCAElevation(new BigInteger(1, setTextDirection.getInstance("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
