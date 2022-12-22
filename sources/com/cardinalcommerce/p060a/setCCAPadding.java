package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAPadding */
public final class setCCAPadding extends getSDKAppID.getInstance {
    public static final BigInteger getWarnings = new BigInteger(1, setTextDirection.getInstance("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: a */
    private Warning f2734a = new Warning(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i << 3) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusLeftId.cca_continue(((getID) challengeParameters.getWarnings()).configure, iArr, i2);
            int i4 = i2 + 8;
            setNextFocusLeftId.cca_continue(((getID) challengeParameters.CardinalActionCode()).configure, iArr, i4);
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
                return new Warning(setCCAPadding.this, new getID(iArr), new getID(iArr2), false);
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
        return new Warning(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new Warning(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new getID(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setCCAPadding();
    }

    public final ChallengeParameters init() {
        return this.f2734a;
    }

    public setCCAPadding() {
        super(getWarnings);
        this.getInstance = new getID(new BigInteger(1, setTextDirection.getInstance("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.Cardinal = new getID(new BigInteger(1, setTextDirection.getInstance("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }
}
