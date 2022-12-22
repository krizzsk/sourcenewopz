package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setImageDrawable */
public final class setImageDrawable extends getSDKAppID.getInstance {
    public static final BigInteger CardinalError = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));

    /* renamed from: a */
    private setImageBitmap f2809a = new setImageBitmap(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 7) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusDownId.init(((setImageIcon) challengeParameters.getWarnings()).init, iArr, i2);
            int i4 = i2 + 7;
            setNextFocusDownId.init(((setImageIcon) challengeParameters.CardinalActionCode()).init, iArr, i4);
            i2 = i4 + 7;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                int[] iArr = new int[7];
                int[] iArr2 = new int[7];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 7; i5++) {
                        int i6 = iArr[i5];
                        int[] iArr3 = iArr;
                        iArr[i5] = i6 ^ (iArr3[i2 + i5] & i4);
                        iArr2[i5] = iArr2[i5] ^ (iArr3[(i2 + 7) + i5] & i4);
                    }
                    i2 += 14;
                }
                return new setImageBitmap(setImageDrawable.this, new setImageIcon(iArr), new setImageIcon(iArr2), false);
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
        return new setImageBitmap(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setImageBitmap(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setImageIcon(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setImageDrawable();
    }

    public final ChallengeParameters init() {
        return this.f2809a;
    }

    public setImageDrawable() {
        super(CardinalError);
        this.getInstance = new setImageIcon(getSDKReferenceNumber.CardinalError);
        this.Cardinal = new setImageIcon(BigInteger.valueOf(5));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
