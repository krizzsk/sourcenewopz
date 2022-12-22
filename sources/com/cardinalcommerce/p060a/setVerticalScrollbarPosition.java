package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setVerticalScrollbarPosition */
public final class setVerticalScrollbarPosition extends getSDKAppID.Cardinal {

    /* renamed from: a */
    static final onContextItemSelected f3090a;

    /* renamed from: c */
    private static onContextItemSelected f3091c;

    /* renamed from: b */
    private setOnContextClickListener f3092b = new setOnContextClickListener(this, (getAcsTransactionID) null, (getAcsTransactionID) null);

    static {
        onContextItemSelected oncontextitemselected = new onContextItemSelected(new BigInteger(1, setTextDirection.getInstance("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        f3091c = oncontextitemselected;
        f3090a = (onContextItemSelected) oncontextitemselected.values();
    }

    public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final long[] jArr = new long[((i * 9) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            setNextFocusForwardId.cca_continue(((onContextItemSelected) challengeParameters.getWarnings()).getInstance, jArr, i2);
            int i4 = i2 + 9;
            setNextFocusForwardId.cca_continue(((onContextItemSelected) challengeParameters.CardinalActionCode()).getInstance, jArr, i4);
            i2 = i4 + 9;
        }
        return new getMessageVersion() {
            public final int getInstance() {
                return i;
            }

            public final ChallengeParameters Cardinal(int i) {
                long[] jArr = new long[9];
                long[] jArr2 = new long[9];
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 9; i4++) {
                        long j2 = jArr[i4];
                        long[] jArr3 = jArr;
                        jArr[i4] = j2 ^ (jArr3[i2 + i4] & j);
                        jArr2[i4] = jArr2[i4] ^ (jArr3[(i2 + 9) + i4] & j);
                    }
                    i2 += 18;
                }
                return new setOnContextClickListener(setVerticalScrollbarPosition.this, new onContextItemSelected(jArr), new onContextItemSelected(jArr2), false);
            }
        };
    }

    public final boolean CardinalRenderType() {
        return false;
    }

    public final boolean cca_continue(int i) {
        return i == 6;
    }

    public final int configure() {
        return 571;
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        return new setOnContextClickListener(this, getacstransactionid, getacstransactionid2, z);
    }

    public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        return new setOnContextClickListener(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
    }

    public final getAcsTransactionID configure(BigInteger bigInteger) {
        return new onContextItemSelected(bigInteger);
    }

    public final getSDKAppID getInstance() {
        return new setVerticalScrollbarPosition();
    }

    public final ChallengeParameters init() {
        return this.f3092b;
    }

    public setVerticalScrollbarPosition() {
        super(571, 2, 5, 10);
        this.getInstance = new onContextItemSelected(BigInteger.valueOf(1));
        this.Cardinal = f3091c;
        this.cca_continue = new BigInteger(1, setTextDirection.getInstance("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
        this.init = BigInteger.valueOf(2);
        this.cleanup = 6;
    }
}
