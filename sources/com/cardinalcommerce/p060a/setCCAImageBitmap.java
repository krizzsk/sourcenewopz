package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAImageBitmap */
public final class setCCAImageBitmap extends getSDKAppID.getInstance {
    public static final BigInteger CardinalError = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* renamed from: a */
    private setCCAImageUri f2718a = new setCCAImageUri(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 7) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusDownId.init(((setImageResource) challengeParameters.getWarnings()).cca_continue, iArr, i2);
            int i4 = i2 + 7;
            setNextFocusDownId.init(((setImageResource) challengeParameters.CardinalActionCode()).cca_continue, iArr, i4);
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
                return new setCCAImageUri(setCCAImageBitmap.this, new setImageResource(iArr), new setImageResource(iArr2), false);
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
        return new setCCAImageUri(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setCCAImageUri(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new setImageResource(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setCCAImageBitmap();
    }

    public final ChallengeParameters init() {
        return this.f2718a;
    }

    public setCCAImageBitmap() {
        super(CardinalError);
        this.getInstance = new setImageResource(new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.Cardinal = new setImageResource(new BigInteger(1, setTextDirection.getInstance("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
