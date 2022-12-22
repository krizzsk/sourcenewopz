package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.ButtonType */
public final class ButtonType extends getSDKAppID.getInstance {
    public static final BigInteger getWarnings = new BigInteger(1, setTextDirection.getInstance("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: a */
    private getSeverity f2335a = new getSeverity(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    public final boolean cca_continue(int i) {
        return i == 2;
    }

    public final int configure() {
        return getWarnings.bitLength();
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new getSeverity(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new getSeverity(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new DirectoryServerID(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new ButtonType();
    }

    public final ChallengeParameters init() {
        return this.f2335a;
    }

    public ButtonType() {
        super(getWarnings);
        this.getInstance = new DirectoryServerID(new BigInteger(1, setTextDirection.getInstance("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.Cardinal = new DirectoryServerID(new BigInteger(1, setTextDirection.getInstance("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.init = BigInteger.valueOf(1);
        this.cleanup = 2;
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int[] iArr = new int[((i * 17) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            System.arraycopy(((DirectoryServerID) challengeParameters.getWarnings()).configure, 0, iArr, i2, 17);
            int i4 = i2 + 17;
            System.arraycopy(((DirectoryServerID) challengeParameters.CardinalActionCode()).configure, 0, iArr, i4, 17);
            i2 = i4 + 17;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                int[] iArr = new int[17];
                int[] iArr2 = new int[17];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = ((i3 ^ i) - 1) >> 31;
                    for (int i5 = 0; i5 < 17; i5++) {
                        int i6 = iArr[i5];
                        int[] iArr3 = iArr;
                        iArr[i5] = i6 ^ (iArr3[i2 + i5] & i4);
                        iArr2[i5] = iArr2[i5] ^ (iArr3[(i2 + 17) + i5] & i4);
                    }
                    i2 += 34;
                }
                return new getSeverity(ButtonType.this, new DirectoryServerID(iArr), new DirectoryServerID(iArr2), false);
            }
        };
    }
}
