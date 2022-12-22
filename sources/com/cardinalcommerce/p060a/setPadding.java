package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setPadding */
public final class setPadding extends getSDKAppID.getInstance {
    public static final BigInteger CardinalError = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* renamed from: a */
    private setCCAButtonDrawable f2910a = new setCCAButtonDrawable(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 6) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setKeepScreenOn.Cardinal(((setCCAOnCheckedChangeListener) challengeParameters.getWarnings()).cca_continue, iArr, i2);
            int i4 = i2 + 6;
            setKeepScreenOn.Cardinal(((setCCAOnCheckedChangeListener) challengeParameters.CardinalActionCode()).cca_continue, iArr, i4);
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
                return new setCCAButtonDrawable(setPadding.this, new setCCAOnCheckedChangeListener(iArr), new setCCAOnCheckedChangeListener(iArr2), false);
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
        return new setCCAButtonDrawable(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setCCAButtonDrawable(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setCCAOnCheckedChangeListener(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setPadding();
    }

    public final ChallengeParameters init() {
        return this.f2910a;
    }

    public setPadding() {
        super(CardinalError);
        this.getInstance = new setCCAOnCheckedChangeListener(getSDKReferenceNumber.CardinalError);
        this.Cardinal = new setCCAOnCheckedChangeListener(BigInteger.valueOf(3));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
