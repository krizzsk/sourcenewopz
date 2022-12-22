package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setOnClickListener */
public final class setOnClickListener extends getSDKAppID.getInstance {
    public static final BigInteger getWarnings = new BigInteger(1, setTextDirection.getInstance("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* renamed from: a */
    private close f2891a = new close(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i << 3) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusLeftId.cca_continue(((doChallenge) challengeParameters.getWarnings()).init, iArr, i2);
            int i4 = i2 + 8;
            setNextFocusLeftId.cca_continue(((doChallenge) challengeParameters.CardinalActionCode()).init, iArr, i4);
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
                return new close(setOnClickListener.this, new doChallenge(iArr), new doChallenge(iArr2), false);
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
        return new close(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new close(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new doChallenge(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setOnClickListener();
    }

    public final ChallengeParameters init() {
        return this.f2891a;
    }

    public setOnClickListener() {
        super(getWarnings);
        this.getInstance = new doChallenge(new BigInteger(1, setTextDirection.getInstance("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.Cardinal = new doChallenge(new BigInteger(1, setTextDirection.getInstance("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
