package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getAcsTransactionID;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;

/* renamed from: com.cardinalcommerce.a.getSDKAppID */
public abstract class getSDKAppID {
    public getAcsTransactionID Cardinal;
    public BigInteger cca_continue;
    public int cleanup = 0;
    public setAccessibilityPaneTitle configure;
    public getAcsTransactionID getInstance;
    protected getAcsSignedContent getSDKVersion = null;
    public BigInteger init;
    protected setOnLongClickListener values = null;

    /* renamed from: com.cardinalcommerce.a.getSDKAppID$configure */
    public class C2007configure {
        private getAcsSignedContent cca_continue;
        private int configure;
        public setOnLongClickListener init;

        C2007configure(int i, setOnLongClickListener setonlongclicklistener, getAcsSignedContent getacssignedcontent) {
            this.configure = i;
            this.init = setonlongclicklistener;
            this.cca_continue = getacssignedcontent;
        }

        public final getSDKAppID cca_continue() {
            if (getSDKAppID.this.cca_continue(this.configure)) {
                getSDKAppID instance = getSDKAppID.this.getInstance();
                if (instance != getSDKAppID.this) {
                    synchronized (instance) {
                        instance.cleanup = this.configure;
                        instance.values = this.init;
                        instance.getSDKVersion = this.cca_continue;
                    }
                    return instance;
                }
                throw new IllegalStateException("implementation returned current curve");
            }
            throw new IllegalStateException("unsupported coordinate system");
        }
    }

    /* renamed from: com.cardinalcommerce.a.getSDKAppID$getInstance */
    public static abstract class getInstance extends getSDKAppID {
        public getInstance(BigInteger bigInteger) {
            super(setOnReceiveContentListener.getInstance(bigInteger));
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters getInstance(int i, BigInteger bigInteger) {
            getAcsTransactionID configure = configure(bigInteger);
            getAcsTransactionID values = configure.configure().cca_continue(this.getInstance).init(configure).cca_continue(this.Cardinal).values();
            if (values != null) {
                if (values.CardinalActionCode() != (i == 1)) {
                    values = values.getInstance();
                }
                return configure(configure, values, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public final boolean init(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(getSDKVersion().Cardinal()) < 0;
        }
    }

    protected getSDKAppID(setAccessibilityPaneTitle setaccessibilitypanetitle) {
        this.configure = setaccessibilitypanetitle;
    }

    private void configure(ChallengeParameters[] challengeParametersArr, int i, int i2) {
        if (challengeParametersArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        } else if (i < 0 || i2 < 0 || i > challengeParametersArr.length - i2) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        } else {
            int i3 = 0;
            while (i3 < i2) {
                ChallengeParameters challengeParameters = challengeParametersArr[i + i3];
                if (challengeParameters == null || this == challengeParameters.cca_continue()) {
                    i3++;
                } else {
                    throw new IllegalArgumentException("'points' entries must be null or on this curve");
                }
            }
        }
    }

    public ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
        if (this == challengeParameters.cca_continue()) {
            return challengeParameters;
        }
        if (challengeParameters.valueOf()) {
            return init();
        }
        ChallengeParameters CardinalRenderType = challengeParameters.CardinalRenderType();
        return Cardinal(CardinalRenderType.values().Cardinal(), CardinalRenderType.CardinalError().Cardinal(), CardinalRenderType.getInstance);
    }

    public ChallengeParameters Cardinal(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return configure(configure(bigInteger), configure(bigInteger2), z);
    }

    /* access modifiers changed from: protected */
    public getAcsSignedContent Cardinal() {
        setOnLongClickListener setonlongclicklistener = this.values;
        return setonlongclicklistener instanceof setOnGenericMotionListener ? new set3DSServerTransactionID(this, (setOnGenericMotionListener) setonlongclicklistener) : new completed();
    }

    public getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, final int i) {
        final int configure2 = (configure() + 7) >>> 3;
        final byte[] bArr = new byte[((i * configure2) << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            ChallengeParameters challengeParameters = challengeParametersArr[i3];
            byte[] byteArray = challengeParameters.getWarnings().Cardinal().toByteArray();
            byte[] byteArray2 = challengeParameters.CardinalActionCode().Cardinal().toByteArray();
            int i4 = byteArray.length > configure2 ? 1 : 0;
            int length = byteArray.length - i4;
            int i5 = byteArray2.length > configure2 ? 1 : 0;
            int length2 = byteArray2.length - i5;
            int i6 = i2 + configure2;
            System.arraycopy(byteArray, i4, bArr, i6 - length, length);
            i2 = i6 + configure2;
            System.arraycopy(byteArray2, i5, bArr, i2 - length2, length2);
        }
        return new getMessageVersion() {
            public final ChallengeParameters Cardinal(int i) {
                int i2;
                int i3 = configure2;
                byte[] bArr = new byte[i3];
                byte[] bArr2 = new byte[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = ((i5 ^ i) - 1) >> 31;
                    int i7 = 0;
                    while (true) {
                        i2 = configure2;
                        if (i7 >= i2) {
                            break;
                        }
                        byte b = bArr[i7];
                        byte[] bArr3 = bArr;
                        bArr[i7] = (byte) (b ^ (bArr3[i4 + i7] & i6));
                        bArr2[i7] = (byte) ((bArr3[(i2 + i4) + i7] & i6) ^ bArr2[i7]);
                        i7++;
                    }
                    i4 += i2 << 1;
                }
                getSDKAppID getsdkappid = getSDKAppID.this;
                return getsdkappid.configure(getsdkappid.configure(new BigInteger(1, bArr)), getSDKAppID.this.configure(new BigInteger(1, bArr2)), false);
            }

            public final int getInstance() {
                return i;
            }
        };
    }

    public final int CardinalActionCode() {
        return this.cleanup;
    }

    public final setOnLongClickListener CardinalEnvironment() {
        return this.values;
    }

    public final BigInteger CardinalError() {
        return this.init;
    }

    public final synchronized C2007configure cca_continue() {
        return new C2007configure(this.cleanup, this.values, this.getSDKVersion);
    }

    public boolean cca_continue(int i) {
        return i == 0;
    }

    public final getAcsTransactionID cleanup() {
        return this.getInstance;
    }

    public abstract int configure();

    /* access modifiers changed from: protected */
    public abstract ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z);

    /* access modifiers changed from: protected */
    public abstract ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z);

    public abstract getAcsTransactionID configure(BigInteger bigInteger);

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof getSDKAppID) && configure((getSDKAppID) obj);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract ChallengeParameters getInstance(int i, BigInteger bigInteger);

    /* access modifiers changed from: protected */
    public abstract getSDKAppID getInstance();

    public final void getInstance(ChallengeParameters[] challengeParametersArr) {
        init(challengeParametersArr, 0, challengeParametersArr.length, (getAcsTransactionID) null);
    }

    public final setAccessibilityPaneTitle getSDKVersion() {
        return this.configure;
    }

    public final getAcsTransactionID getWarnings() {
        return this.Cardinal;
    }

    public abstract ChallengeParameters init();

    public abstract boolean init(BigInteger bigInteger);

    public final synchronized getAcsSignedContent valueOf() {
        if (this.getSDKVersion == null) {
            this.getSDKVersion = Cardinal();
        }
        return this.getSDKVersion;
    }

    public final BigInteger values() {
        return this.cca_continue;
    }

    /* renamed from: com.cardinalcommerce.a.getSDKAppID$Cardinal */
    public static abstract class Cardinal extends getSDKAppID {
        private BigInteger[] getWarnings;

        public final ChallengeParameters Cardinal(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            getAcsTransactionID configure = configure(bigInteger);
            getAcsTransactionID configure2 = configure(bigInteger2);
            int CardinalActionCode = CardinalActionCode();
            if (CardinalActionCode == 5 || CardinalActionCode == 6) {
                if (!configure.cleanup()) {
                    configure2 = configure2.getInstance(configure).cca_continue(configure);
                } else if (!configure2.configure().equals(getWarnings())) {
                    throw new IllegalArgumentException();
                }
            }
            return configure(configure, configure2, z);
        }

        public boolean CardinalRenderType() {
            if (this.cca_continue == null || this.init == null || !this.Cardinal.CardinalError()) {
                return false;
            }
            return this.getInstance.cleanup() || this.getInstance.CardinalError();
        }

        /* access modifiers changed from: package-private */
        public final synchronized BigInteger[] CardinalUiType() {
            if (this.getWarnings == null) {
                this.getWarnings = C1996g.m1881a(this);
            }
            return this.getWarnings;
        }

        /* access modifiers changed from: protected */
        public final getAcsTransactionID cca_continue(getAcsTransactionID getacstransactionid) {
            getAcsTransactionID getacstransactionid2;
            if (getacstransactionid.cleanup()) {
                return getacstransactionid;
            }
            getAcsTransactionID configure = configure(getSDKReferenceNumber.CardinalError);
            int configure2 = configure();
            Random random = new Random();
            do {
                getAcsTransactionID configure3 = configure(new BigInteger(configure2, random));
                getAcsTransactionID getacstransactionid3 = getacstransactionid;
                getacstransactionid2 = configure;
                for (int i = 1; i < configure2; i++) {
                    getAcsTransactionID configure4 = getacstransactionid3.configure();
                    getacstransactionid2 = getacstransactionid2.configure().cca_continue(configure4.init(configure3));
                    getacstransactionid3 = configure4.cca_continue(getacstransactionid);
                }
                if (!getacstransactionid3.cleanup()) {
                    return null;
                }
            } while (getacstransactionid2.configure().cca_continue(getacstransactionid2).cleanup());
            return getacstransactionid2;
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters getInstance(int i, BigInteger bigInteger) {
            getAcsTransactionID getacstransactionid;
            getAcsTransactionID configure = configure(bigInteger);
            if (configure.cleanup()) {
                getacstransactionid = getWarnings().values();
            } else {
                getAcsTransactionID cca_continue = cca_continue(configure.configure().getSDKVersion().init(getWarnings()).cca_continue(cleanup()).cca_continue(configure));
                if (cca_continue != null) {
                    if (cca_continue.CardinalActionCode() != (i == 1)) {
                        cca_continue = cca_continue.init();
                    }
                    int CardinalActionCode = CardinalActionCode();
                    getacstransactionid = (CardinalActionCode == 5 || CardinalActionCode == 6) ? cca_continue.cca_continue(configure) : cca_continue.init(configure);
                } else {
                    getacstransactionid = null;
                }
            }
            if (getacstransactionid != null) {
                return configure(configure, getacstransactionid, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public final boolean init(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= configure();
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Cardinal(int r6, int r7, int r8, int r9) {
            /*
                r5 = this;
                if (r7 == 0) goto L_0x004c
                r0 = 2
                r1 = 1
                r2 = 3
                r3 = 0
                if (r8 != 0) goto L_0x001f
                if (r9 != 0) goto L_0x0017
                int[] r8 = new int[r2]
                r8[r3] = r3
                r8[r1] = r7
                r8[r0] = r6
                com.cardinalcommerce.a.setContentCaptureSession r6 = com.cardinalcommerce.p060a.setOnReceiveContentListener.Cardinal(r8)
                goto L_0x0035
            L_0x0017:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k3 must be 0 if k2 == 0"
                r6.<init>(r7)
                throw r6
            L_0x001f:
                if (r8 <= r7) goto L_0x0044
                if (r9 <= r8) goto L_0x003c
                r4 = 5
                int[] r4 = new int[r4]
                r4[r3] = r3
                r4[r1] = r7
                r4[r0] = r8
                r4[r2] = r9
                r7 = 4
                r4[r7] = r6
                com.cardinalcommerce.a.setContentCaptureSession r6 = com.cardinalcommerce.p060a.setOnReceiveContentListener.Cardinal(r4)
            L_0x0035:
                r5.<init>(r6)
                r6 = 0
                r5.getWarnings = r6
                return
            L_0x003c:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k3 must be > k2"
                r6.<init>(r7)
                throw r6
            L_0x0044:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k2 must be > k1"
                r6.<init>(r7)
                throw r6
            L_0x004c:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k1 must be > 0"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.getSDKAppID.Cardinal.<init>(int, int, int, int):void");
        }
    }

    /* renamed from: com.cardinalcommerce.a.getSDKAppID$cca_continue */
    public static class cca_continue extends Cardinal {
        private int CardinalActionCode;
        private int CardinalError;
        private ChallengeParameters.C1893init CardinalRenderType;
        int getWarnings;
        private int valueOf;

        private cca_continue(int i, int i2, int i3, int i4, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.getWarnings = i;
            this.CardinalError = i2;
            this.CardinalActionCode = i3;
            this.valueOf = i4;
            this.cca_continue = bigInteger;
            this.init = bigInteger2;
            this.CardinalRenderType = new ChallengeParameters.C1893init(this, (getAcsTransactionID) null, (getAcsTransactionID) null, false);
            this.getInstance = getacstransactionid;
            this.Cardinal = getacstransactionid2;
            this.cleanup = 6;
        }

        public cca_continue(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public cca_continue(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        private boolean getRequestTimeout() {
            return this.CardinalActionCode == 0 && this.valueOf == 0;
        }

        /* access modifiers changed from: protected */
        public final getAcsSignedContent Cardinal() {
            return CardinalRenderType() ? new ChallengeStatusReceiver() : super.Cardinal();
        }

        public final boolean cca_continue(int i) {
            return i == 0 || i == 1 || i == 6;
        }

        public final int configure() {
            return this.getWarnings;
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
            return new ChallengeParameters.C1893init(this, getacstransactionid, getacstransactionid2, z);
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
            return new ChallengeParameters.C1893init(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
        }

        public final getAcsTransactionID configure(BigInteger bigInteger) {
            return new getAcsTransactionID.C1998init(this.getWarnings, this.CardinalError, this.CardinalActionCode, this.valueOf, bigInteger);
        }

        /* access modifiers changed from: protected */
        public final getSDKAppID getInstance() {
            return new cca_continue(this.getWarnings, this.CardinalError, this.CardinalActionCode, this.valueOf, this.getInstance, this.Cardinal, this.cca_continue, this.init);
        }

        public final ChallengeParameters init() {
            return this.CardinalRenderType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public cca_continue(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.getWarnings = i;
            this.CardinalError = i2;
            this.CardinalActionCode = i3;
            this.valueOf = i4;
            this.cca_continue = bigInteger3;
            this.init = bigInteger4;
            this.CardinalRenderType = new ChallengeParameters.C1893init(this, (getAcsTransactionID) null, (getAcsTransactionID) null, false);
            this.getInstance = new getAcsTransactionID.C1998init(this.getWarnings, this.CardinalError, this.CardinalActionCode, this.valueOf, bigInteger);
            this.Cardinal = new getAcsTransactionID.C1998init(this.getWarnings, this.CardinalError, this.CardinalActionCode, this.valueOf, bigInteger2);
            this.cleanup = 6;
        }

        public final getMessageVersion Cardinal(ChallengeParameters[] challengeParametersArr, int i) {
            final int i2 = (this.getWarnings + 63) >>> 6;
            final int[] iArr = getRequestTimeout() ? new int[]{this.CardinalError} : new int[]{this.CardinalError, this.CardinalActionCode, this.valueOf};
            final long[] jArr = new long[((i * i2) << 1)];
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                ChallengeParameters challengeParameters = challengeParametersArr[i4];
                C1995f fVar = ((getAcsTransactionID.C1998init) challengeParameters.getWarnings()).Cardinal;
                System.arraycopy(fVar.f2533b, 0, jArr, i3, fVar.f2533b.length);
                int i5 = i3 + i2;
                C1995f fVar2 = ((getAcsTransactionID.C1998init) challengeParameters.CardinalActionCode()).Cardinal;
                System.arraycopy(fVar2.f2533b, 0, jArr, i5, fVar2.f2533b.length);
                i3 = i5 + i2;
            }
            final int i6 = i;
            return new getMessageVersion() {
                public final int getInstance() {
                    return i6;
                }

                public final ChallengeParameters Cardinal(int i) {
                    int i2;
                    int i3 = i2;
                    long[] jArr = new long[i3];
                    long[] jArr2 = new long[i3];
                    int i4 = 0;
                    for (int i5 = 0; i5 < i6; i5++) {
                        long j = (long) (((i5 ^ i) - 1) >> 31);
                        int i6 = 0;
                        while (true) {
                            i2 = i2;
                            if (i6 >= i2) {
                                break;
                            }
                            long j2 = jArr[i6];
                            long[] jArr3 = jArr;
                            jArr[i6] = j2 ^ (jArr3[i4 + i6] & j);
                            jArr2[i6] = jArr2[i6] ^ (jArr3[(i2 + i4) + i6] & j);
                            i6++;
                        }
                        i4 += i2 << 1;
                    }
                    return new ChallengeParameters.C1893init(cca_continue.this, new getAcsTransactionID.C1998init(cca_continue.this.getWarnings, iArr, new C1995f(jArr)), new getAcsTransactionID.C1998init(cca_continue.this.getWarnings, iArr, new C1995f(jArr2)), false);
                }
            };
        }
    }

    /* renamed from: com.cardinalcommerce.a.getSDKAppID$init */
    public static class C2008init extends getInstance {
        private BigInteger CardinalError;
        private BigInteger getWarnings;
        private ChallengeParameters.C1892configure valueOf;

        private C2008init(BigInteger bigInteger, BigInteger bigInteger2, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.getWarnings = bigInteger;
            this.CardinalError = bigInteger2;
            this.valueOf = new ChallengeParameters.C1892configure(this, (getAcsTransactionID) null, (getAcsTransactionID) null, false);
            this.getInstance = getacstransactionid;
            this.Cardinal = getacstransactionid2;
            this.cca_continue = bigInteger3;
            this.init = bigInteger4;
            this.cleanup = 4;
        }

        public C2008init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, (BigInteger) null);
        }

        public final boolean cca_continue(int i) {
            return i == 0 || i == 1 || i == 2 || i == 4;
        }

        public final int configure() {
            return this.getWarnings.bitLength();
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
            return new ChallengeParameters.C1892configure(this, getacstransactionid, getacstransactionid2, z);
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
            return new ChallengeParameters.C1892configure(this, getacstransactionid, getacstransactionid2, getacstransactionidArr, z);
        }

        public final getAcsTransactionID configure(BigInteger bigInteger) {
            return new getAcsTransactionID.Cardinal(this.getWarnings, this.CardinalError, bigInteger);
        }

        /* access modifiers changed from: protected */
        public final getSDKAppID getInstance() {
            return new C2008init(this.getWarnings, this.CardinalError, this.getInstance, this.Cardinal, this.cca_continue, this.init);
        }

        public final ChallengeParameters init() {
            return this.valueOf;
        }

        public C2008init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.getWarnings = bigInteger;
            this.CardinalError = getAcsTransactionID.Cardinal.getInstance(bigInteger);
            this.valueOf = new ChallengeParameters.C1892configure(this, (getAcsTransactionID) null, (getAcsTransactionID) null, false);
            this.getInstance = new getAcsTransactionID.Cardinal(this.getWarnings, this.CardinalError, bigInteger2);
            this.Cardinal = new getAcsTransactionID.Cardinal(this.getWarnings, this.CardinalError, bigInteger3);
            this.cca_continue = bigInteger4;
            this.init = bigInteger5;
            this.cleanup = 4;
        }

        public final ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
            int CardinalActionCode;
            if (this == challengeParameters.cca_continue() || CardinalActionCode() != 2 || challengeParameters.valueOf() || ((CardinalActionCode = challengeParameters.cca_continue().CardinalActionCode()) != 2 && CardinalActionCode != 3 && CardinalActionCode != 4)) {
                return super.Cardinal(challengeParameters);
            }
            return new ChallengeParameters.C1892configure(this, new getAcsTransactionID.Cardinal(this.getWarnings, this.CardinalError, challengeParameters.configure.Cardinal()), new getAcsTransactionID.Cardinal(this.getWarnings, this.CardinalError, challengeParameters.init.Cardinal()), new getAcsTransactionID[]{new getAcsTransactionID.Cardinal(this.getWarnings, this.CardinalError, challengeParameters.cca_continue[0].Cardinal())}, challengeParameters.getInstance);
        }
    }

    public final KeyAgreementSpi.ECKAEGwithSHA512KDF getInstance(ChallengeParameters challengeParameters, String str) {
        Hashtable hashtable;
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        if (challengeParameters == null || this != challengeParameters.cca_continue()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        synchronized (challengeParameters) {
            hashtable = challengeParameters.CardinalError;
        }
        if (hashtable == null) {
            return null;
        }
        synchronized (hashtable) {
            eCKAEGwithSHA512KDF = (KeyAgreementSpi.ECKAEGwithSHA512KDF) hashtable.get(str);
        }
        return eCKAEGwithSHA512KDF;
    }

    public final KeyAgreementSpi.ECKAEGwithSHA512KDF getInstance(ChallengeParameters challengeParameters, String str, ConfigParameters configParameters) {
        Hashtable hashtable;
        KeyAgreementSpi.ECKAEGwithSHA512KDF init2;
        if (challengeParameters == null || this != challengeParameters.cca_continue()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        synchronized (challengeParameters) {
            hashtable = challengeParameters.CardinalError;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                challengeParameters.CardinalError = hashtable;
            }
        }
        synchronized (hashtable) {
            KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF = (KeyAgreementSpi.ECKAEGwithSHA512KDF) hashtable.get(str);
            init2 = configParameters.init(eCKAEGwithSHA512KDF);
            if (init2 != eCKAEGwithSHA512KDF) {
                hashtable.put(str, init2);
            }
        }
        return init2;
    }

    public final void init(ChallengeParameters[] challengeParametersArr, int i, int i2, getAcsTransactionID getacstransactionid) {
        configure(challengeParametersArr, i, i2);
        int i3 = this.cleanup;
        if (i3 != 0 && i3 != 5) {
            getAcsTransactionID[] getacstransactionidArr = new getAcsTransactionID[i2];
            int[] iArr = new int[i2];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i + i5;
                ChallengeParameters challengeParameters = challengeParametersArr[i6];
                if (challengeParameters != null && (getacstransactionid != null || !challengeParameters.CardinalEnvironment())) {
                    getacstransactionidArr[i4] = challengeParameters.cca_continue(0);
                    iArr[i4] = i6;
                    i4++;
                }
            }
            if (i4 != 0) {
                getDeviceData.configure(getacstransactionidArr, i4, getacstransactionid);
                for (int i7 = 0; i7 < i4; i7++) {
                    int i8 = iArr[i7];
                    challengeParametersArr[i8] = challengeParametersArr[i8].cca_continue(getacstransactionidArr[i7]);
                }
            }
        } else if (getacstransactionid != null) {
            throw new IllegalArgumentException("'iso' not valid for affine coordinates");
        }
    }

    public final ChallengeParameters configure(byte[] bArr) {
        ChallengeParameters challengeParameters;
        int configure2 = (configure() + 7) / 8;
        byte b = bArr[0];
        boolean z = true;
        if (b != 0) {
            if (b == 2 || b == 3) {
                if (bArr.length == configure2 + 1) {
                    challengeParameters = getInstance((int) b & 1, setSelected.cca_continue(bArr, 1, configure2));
                    if (!challengeParameters.getInstance(true, true)) {
                        throw new IllegalArgumentException("Invalid point");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
            } else if (b != 4) {
                if (b != 6 && b != 7) {
                    StringBuilder sb = new StringBuilder("Invalid point encoding 0x");
                    sb.append(Integer.toString(b, 16));
                    throw new IllegalArgumentException(sb.toString());
                } else if (bArr.length == (configure2 * 2) + 1) {
                    BigInteger cca_continue2 = setSelected.cca_continue(bArr, 1, configure2);
                    BigInteger cca_continue3 = setSelected.cca_continue(bArr, configure2 + 1, configure2);
                    boolean testBit = cca_continue3.testBit(0);
                    if (b != 7) {
                        z = false;
                    }
                    if (testBit == z) {
                        challengeParameters = Cardinal(cca_continue2, cca_continue3, false);
                        if (!challengeParameters.getActionCode()) {
                            throw new IllegalArgumentException("Invalid point coordinates");
                        }
                    } else {
                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
            } else if (bArr.length == (configure2 * 2) + 1) {
                challengeParameters = Cardinal(setSelected.cca_continue(bArr, 1, configure2), setSelected.cca_continue(bArr, configure2 + 1, configure2), false);
                if (!challengeParameters.getActionCode()) {
                    throw new IllegalArgumentException("Invalid point coordinates");
                }
            } else {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
        } else if (bArr.length == 1) {
            challengeParameters = init();
        } else {
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b == 0 || !challengeParameters.valueOf()) {
            return challengeParameters;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public final boolean configure(getSDKAppID getsdkappid) {
        if (this != getsdkappid) {
            return getsdkappid != null && this.configure.equals(getsdkappid.configure) && this.getInstance.Cardinal().equals(getsdkappid.getInstance.Cardinal()) && this.Cardinal.Cardinal().equals(getsdkappid.Cardinal.Cardinal());
        }
        return true;
    }

    public int hashCode() {
        return (this.configure.hashCode() ^ Integer.rotateLeft(this.getInstance.Cardinal().hashCode(), 8)) ^ Integer.rotateLeft(this.Cardinal.Cardinal().hashCode(), 16);
    }
}
