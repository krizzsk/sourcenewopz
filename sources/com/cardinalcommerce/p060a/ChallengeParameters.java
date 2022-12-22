package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getAcsTransactionID;
import com.cardinalcommerce.p060a.getSDKAppID;
import java.math.BigInteger;
import java.util.Hashtable;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.ChallengeParameters */
public abstract class ChallengeParameters {
    private static getAcsTransactionID[] getSDKVersion = new getAcsTransactionID[0];
    public getSDKAppID Cardinal;
    protected Hashtable CardinalError;
    public getAcsTransactionID[] cca_continue;
    public getAcsTransactionID configure;
    public boolean getInstance;
    public getAcsTransactionID init;

    protected ChallengeParameters(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr) {
        this.CardinalError = null;
        this.Cardinal = getsdkappid;
        this.configure = getacstransactionid;
        this.init = getacstransactionid2;
        this.cca_continue = getacstransactionidArr;
    }

    public ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
        return getRequestTimeout().getInstance(challengeParameters);
    }

    /* access modifiers changed from: protected */
    public abstract boolean Cardinal();

    public final getAcsTransactionID CardinalActionCode() {
        return this.init;
    }

    /* access modifiers changed from: protected */
    public abstract boolean CardinalConfigurationParameters();

    public getAcsTransactionID CardinalError() {
        return this.init;
    }

    /* access modifiers changed from: protected */
    public final getAcsTransactionID[] CardinalUiType() {
        return this.cca_continue;
    }

    public getAcsTransactionID cca_continue(int i) {
        if (i < 0) {
            return null;
        }
        getAcsTransactionID[] getacstransactionidArr = this.cca_continue;
        if (i >= getacstransactionidArr.length) {
            return null;
        }
        return getacstransactionidArr[i];
    }

    public final getSDKAppID cca_continue() {
        return this.Cardinal;
    }

    /* access modifiers changed from: protected */
    public final int cleanup() {
        getSDKAppID getsdkappid = this.Cardinal;
        if (getsdkappid == null) {
            return 0;
        }
        return getsdkappid.CardinalActionCode();
    }

    /* access modifiers changed from: protected */
    public abstract ChallengeParameters configure();

    public abstract ChallengeParameters configure(ChallengeParameters challengeParameters);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChallengeParameters)) {
            return false;
        }
        return init((ChallengeParameters) obj);
    }

    public final boolean getActionCode() {
        return getInstance(false, true);
    }

    public ChallengeParameters getChallengeTimeout() {
        return Cardinal(this);
    }

    public ChallengeParameters getInstance(int i) {
        if (i >= 0) {
            ChallengeParameters challengeParameters = this;
            while (true) {
                i--;
                if (i < 0) {
                    return challengeParameters;
                }
                challengeParameters = challengeParameters.getRequestTimeout();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    public abstract ChallengeParameters getInstance(ChallengeParameters challengeParameters);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = r2.Cardinal.values();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getInstance() {
        /*
            r2 = this;
            java.math.BigInteger r0 = com.cardinalcommerce.p060a.getSDKReferenceNumber.values
            com.cardinalcommerce.a.getSDKAppID r1 = r2.Cardinal
            java.math.BigInteger r1 = r1.CardinalError()
            boolean r0 = r0.equals(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            com.cardinalcommerce.a.getSDKAppID r0 = r2.Cardinal
            java.math.BigInteger r0 = r0.values()
            if (r0 == 0) goto L_0x0025
            com.cardinalcommerce.a.ChallengeParameters r0 = com.cardinalcommerce.p060a.getDeviceData.cca_continue(r2, r0)
            boolean r0 = r0.valueOf()
            if (r0 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r0 = 0
            return r0
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.ChallengeParameters.getInstance():boolean");
    }

    public abstract ChallengeParameters getRequestTimeout();

    public abstract ChallengeParameters getString();

    public final getAcsTransactionID getWarnings() {
        return this.configure;
    }

    public final ChallengeParameters init() {
        return CardinalRenderType().configure();
    }

    /* access modifiers changed from: package-private */
    public final boolean setRequestTimeout() {
        return getInstance(false, false);
    }

    public final boolean valueOf() {
        if (this.configure == null || this.init == null) {
            return true;
        }
        getAcsTransactionID[] getacstransactionidArr = this.cca_continue;
        return getacstransactionidArr.length > 0 && getacstransactionidArr[0].cleanup();
    }

    public final getAcsTransactionID values() {
        return this.configure;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected ChallengeParameters(com.cardinalcommerce.p060a.getSDKAppID r7, com.cardinalcommerce.p060a.getAcsTransactionID r8, com.cardinalcommerce.p060a.getAcsTransactionID r9) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0005
            r1 = 0
            goto L_0x0009
        L_0x0005:
            int r1 = r7.CardinalActionCode()
        L_0x0009:
            if (r1 == 0) goto L_0x0045
            r2 = 5
            if (r1 == r2) goto L_0x0045
            java.math.BigInteger r2 = com.cardinalcommerce.p060a.getSDKReferenceNumber.values
            com.cardinalcommerce.a.getAcsTransactionID r2 = r7.configure((java.math.BigInteger) r2)
            r3 = 1
            if (r1 == r3) goto L_0x0040
            r4 = 2
            if (r1 == r4) goto L_0x0040
            r5 = 3
            if (r1 == r5) goto L_0x0037
            r5 = 4
            if (r1 == r5) goto L_0x002c
            r4 = 6
            if (r1 != r4) goto L_0x0024
            goto L_0x0040
        L_0x0024:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "unknown coordinate system"
            r7.<init>(r8)
            throw r7
        L_0x002c:
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r4]
            r1[r0] = r2
            com.cardinalcommerce.a.getAcsTransactionID r0 = r7.cleanup()
            r1[r3] = r0
            goto L_0x0047
        L_0x0037:
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r5]
            r1[r0] = r2
            r1[r3] = r2
            r1[r4] = r2
            goto L_0x0047
        L_0x0040:
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = new com.cardinalcommerce.p060a.getAcsTransactionID[r3]
            r1[r0] = r2
            goto L_0x0047
        L_0x0045:
            com.cardinalcommerce.a.getAcsTransactionID[] r1 = getSDKVersion
        L_0x0047:
            r6.<init>(r7, r8, r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.ChallengeParameters.<init>(com.cardinalcommerce.a.getSDKAppID, com.cardinalcommerce.a.getAcsTransactionID, com.cardinalcommerce.a.getAcsTransactionID):void");
    }

    /* renamed from: com.cardinalcommerce.a.ChallengeParameters$Cardinal */
    public static abstract class Cardinal extends ChallengeParameters {
        public Cardinal(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
            super(getsdkappid, getacstransactionid, getacstransactionid2);
        }

        public Cardinal(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr) {
            super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        }

        public final Cardinal Cardinal(int i) {
            ChallengeParameters configure;
            if (valueOf()) {
                return this;
            }
            getSDKAppID cca_continue = cca_continue();
            int CardinalActionCode = cca_continue.CardinalActionCode();
            getAcsTransactionID getacstransactionid = this.configure;
            if (CardinalActionCode != 0) {
                if (CardinalActionCode != 1) {
                    if (CardinalActionCode != 5) {
                        if (CardinalActionCode != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                getAcsTransactionID getacstransactionid2 = this.init;
                getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
                configure = cca_continue.configure(getacstransactionid.getInstance(i), getacstransactionid2.getInstance(i), new getAcsTransactionID[]{getacstransactionid3.getInstance(i)}, this.getInstance);
                return (Cardinal) configure;
            }
            configure = cca_continue.configure(getacstransactionid.getInstance(i), this.init.getInstance(i), this.getInstance);
            return (Cardinal) configure;
        }

        public final ChallengeParameters Cardinal(getAcsTransactionID getacstransactionid) {
            if (valueOf()) {
                return this;
            }
            int cleanup = cleanup();
            if (cleanup != 5 && cleanup != 6) {
                return ChallengeParameters.super.Cardinal(getacstransactionid);
            }
            getAcsTransactionID warnings = getWarnings();
            return cca_continue().configure(warnings, CardinalActionCode().cca_continue(warnings).init(getacstransactionid).cca_continue(warnings), CardinalUiType(), this.getInstance);
        }

        /* access modifiers changed from: protected */
        public final boolean Cardinal() {
            getAcsTransactionID getacstransactionid;
            getAcsTransactionID getacstransactionid2;
            getSDKAppID cca_continue = cca_continue();
            getAcsTransactionID getacstransactionid3 = this.configure;
            getAcsTransactionID cleanup = cca_continue.cleanup();
            getAcsTransactionID warnings = cca_continue.getWarnings();
            int CardinalActionCode = cca_continue.CardinalActionCode();
            if (CardinalActionCode == 6) {
                getAcsTransactionID getacstransactionid4 = this.cca_continue[0];
                boolean CardinalError = getacstransactionid4.CardinalError();
                if (getacstransactionid3.cleanup()) {
                    getAcsTransactionID configure = this.init.configure();
                    if (!CardinalError) {
                        warnings = warnings.init(getacstransactionid4.configure());
                    }
                    return configure.equals(warnings);
                }
                getAcsTransactionID getacstransactionid5 = this.init;
                getAcsTransactionID configure2 = getacstransactionid3.configure();
                if (CardinalError) {
                    getacstransactionid2 = getacstransactionid5.configure().cca_continue(getacstransactionid5).cca_continue(cleanup);
                    getacstransactionid = configure2.configure().cca_continue(warnings);
                } else {
                    getAcsTransactionID configure3 = getacstransactionid4.configure();
                    getAcsTransactionID configure4 = configure3.configure();
                    getacstransactionid2 = getacstransactionid5.cca_continue(getacstransactionid4).Cardinal(getacstransactionid5, cleanup, configure3);
                    getacstransactionid = configure2.cca_continue(warnings, configure4);
                }
                return getacstransactionid2.init(configure2).equals(getacstransactionid);
            }
            getAcsTransactionID getacstransactionid6 = this.init;
            getAcsTransactionID init = getacstransactionid6.cca_continue(getacstransactionid3).init(getacstransactionid6);
            if (CardinalActionCode != 0) {
                if (CardinalActionCode == 1) {
                    getAcsTransactionID getacstransactionid7 = this.cca_continue[0];
                    if (!getacstransactionid7.CardinalError()) {
                        getAcsTransactionID init2 = getacstransactionid7.init(getacstransactionid7.configure());
                        init = init.init(getacstransactionid7);
                        cleanup = cleanup.init(getacstransactionid7);
                        warnings = warnings.init(init2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return init.equals(getacstransactionid3.cca_continue(cleanup).init(getacstransactionid3.configure()).cca_continue(warnings));
        }

        public final ChallengeParameters configure(ChallengeParameters challengeParameters) {
            return challengeParameters.valueOf() ? this : getInstance(challengeParameters.getString());
        }

        public final ChallengeParameters getInstance(getAcsTransactionID getacstransactionid) {
            if (valueOf()) {
                return this;
            }
            int cleanup = cleanup();
            if (cleanup == 5) {
                getAcsTransactionID warnings = getWarnings();
                getAcsTransactionID CardinalActionCode = CardinalActionCode();
                return cca_continue().configure(warnings, CardinalActionCode.cca_continue(warnings).getInstance(getacstransactionid).cca_continue(warnings.init(getacstransactionid)), CardinalUiType(), this.getInstance);
            } else if (cleanup != 6) {
                return ChallengeParameters.super.getInstance(getacstransactionid);
            } else {
                getAcsTransactionID warnings2 = getWarnings();
                getAcsTransactionID CardinalActionCode2 = CardinalActionCode();
                getAcsTransactionID getacstransactionid2 = CardinalUiType()[0];
                getAcsTransactionID init = warnings2.init(getacstransactionid.configure());
                getAcsTransactionID cca_continue = CardinalActionCode2.cca_continue(warnings2).cca_continue(init);
                getAcsTransactionID init2 = getacstransactionid2.init(getacstransactionid);
                return cca_continue().configure(init, cca_continue, new getAcsTransactionID[]{init2}, this.getInstance);
            }
        }

        /* access modifiers changed from: protected */
        public final boolean getInstance() {
            BigInteger CardinalError = this.Cardinal.CardinalError();
            if (getSDKReferenceNumber.CardinalEnvironment.equals(CardinalError)) {
                return ((getAcsTransactionID.getInstance) CardinalRenderType().getSDKVersion().cca_continue(this.Cardinal.cleanup())).CardinalRenderType() == 0;
            }
            if (!getSDKReferenceNumber.CardinalRenderType.equals(CardinalError)) {
                return ChallengeParameters.super.getInstance();
            }
            ChallengeParameters CardinalRenderType = CardinalRenderType();
            getAcsTransactionID sDKVersion = CardinalRenderType.getSDKVersion();
            getAcsTransactionID cca_continue = ((getSDKAppID.Cardinal) this.Cardinal).cca_continue(sDKVersion.cca_continue(this.Cardinal.cleanup()));
            if (cca_continue == null) {
                return false;
            }
            getAcsTransactionID init = sDKVersion.init(cca_continue);
            if (CardinalRenderType.CardinalEnvironment()) {
                getAcsTransactionID cca_continue2 = init.cca_continue(CardinalRenderType.CardinalError()).cca_continue(this.Cardinal.cleanup());
                return ((getAcsTransactionID.getInstance) cca_continue2).CardinalRenderType() == 0 || ((getAcsTransactionID.getInstance) cca_continue2.cca_continue(sDKVersion)).CardinalRenderType() == 0;
            }
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* renamed from: com.cardinalcommerce.a.ChallengeParameters$cca_continue */
    public static abstract class cca_continue extends ChallengeParameters {
        public cca_continue(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
            super(getsdkappid, getacstransactionid, getacstransactionid2);
        }

        public cca_continue(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr) {
            super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        }

        /* access modifiers changed from: protected */
        public final boolean Cardinal() {
            getAcsTransactionID getacstransactionid = this.configure;
            getAcsTransactionID getacstransactionid2 = this.init;
            getAcsTransactionID cleanup = this.Cardinal.cleanup();
            getAcsTransactionID warnings = this.Cardinal.getWarnings();
            getAcsTransactionID configure = getacstransactionid2.configure();
            int cleanup2 = cleanup();
            if (cleanup2 != 0) {
                if (cleanup2 == 1) {
                    getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
                    if (!getacstransactionid3.CardinalError()) {
                        getAcsTransactionID configure2 = getacstransactionid3.configure();
                        getAcsTransactionID init = getacstransactionid3.init(configure2);
                        configure = configure.init(getacstransactionid3);
                        cleanup = cleanup.init(configure2);
                        warnings = warnings.init(init);
                    }
                } else if (cleanup2 == 2 || cleanup2 == 3 || cleanup2 == 4) {
                    getAcsTransactionID getacstransactionid4 = this.cca_continue[0];
                    if (!getacstransactionid4.CardinalError()) {
                        getAcsTransactionID configure3 = getacstransactionid4.configure();
                        getAcsTransactionID configure4 = configure3.configure();
                        getAcsTransactionID init2 = configure3.init(configure4);
                        cleanup = cleanup.init(configure4);
                        warnings = warnings.init(init2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return configure.equals(getacstransactionid.configure().cca_continue(cleanup).init(getacstransactionid).cca_continue(warnings));
        }

        public final ChallengeParameters configure(ChallengeParameters challengeParameters) {
            return challengeParameters.valueOf() ? this : getInstance(challengeParameters.getString());
        }

        /* access modifiers changed from: protected */
        public final boolean CardinalConfigurationParameters() {
            if (CardinalEnvironment()) {
                return CardinalError().CardinalActionCode();
            }
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* renamed from: com.cardinalcommerce.a.ChallengeParameters$configure */
    public static class C1892configure extends cca_continue {
        public C1892configure(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
            super(getsdkappid, getacstransactionid, getacstransactionid2);
            if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
                this.getInstance = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        C1892configure(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
            super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
            this.getInstance = z;
        }

        private getAcsTransactionID configure(getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
            getAcsTransactionID cleanup = cca_continue().cleanup();
            if (cleanup.cleanup() || getacstransactionid.CardinalError()) {
                return cleanup;
            }
            if (getacstransactionid2 == null) {
                getacstransactionid2 = getacstransactionid.configure();
            }
            getAcsTransactionID configure = getacstransactionid2.configure();
            getAcsTransactionID instance = cleanup.getInstance();
            return instance.getWarnings() < cleanup.getWarnings() ? configure.init(instance).getInstance() : configure.init(cleanup);
        }

        public final ChallengeParameters getString() {
            if (valueOf()) {
                return this;
            }
            getSDKAppID cca_continue = cca_continue();
            return cca_continue.CardinalActionCode() != 0 ? new C1892configure(cca_continue, this.configure, this.init.getInstance(), this.cca_continue, this.getInstance) : new C1892configure(cca_continue, this.configure, this.init.getInstance(), this.getInstance);
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters configure() {
            getAcsTransactionID sDKVersion = getSDKVersion();
            if (CardinalEnvironment()) {
                return new C1892configure((getSDKAppID) null, sDKVersion, CardinalError(), false);
            }
            throw new IllegalStateException("point not in normal form");
        }

        public final getAcsTransactionID cca_continue(int i) {
            if (i != 1 || 4 != cleanup()) {
                return super.cca_continue(i);
            }
            getAcsTransactionID getacstransactionid = this.cca_continue[1];
            if (getacstransactionid != null) {
                return getacstransactionid;
            }
            getAcsTransactionID[] getacstransactionidArr = this.cca_continue;
            getAcsTransactionID configure = configure(this.cca_continue[0], (getAcsTransactionID) null);
            getacstransactionidArr[1] = configure;
            return configure;
        }

        /* JADX WARNING: type inference failed for: r17v0, types: [com.cardinalcommerce.a.ChallengeParameters] */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0123, code lost:
            if (r1 == r6) goto L_0x0125;
         */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.cardinalcommerce.p060a.ChallengeParameters getInstance(com.cardinalcommerce.p060a.ChallengeParameters r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                boolean r2 = r16.valueOf()
                if (r2 == 0) goto L_0x000b
                return r1
            L_0x000b:
                boolean r2 = r17.valueOf()
                if (r2 == 0) goto L_0x0012
                return r0
            L_0x0012:
                if (r0 != r1) goto L_0x0019
                com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
                return r1
            L_0x0019:
                com.cardinalcommerce.a.getSDKAppID r3 = r16.cca_continue()
                int r2 = r3.CardinalActionCode()
                com.cardinalcommerce.a.getAcsTransactionID r4 = r0.configure
                com.cardinalcommerce.a.getAcsTransactionID r5 = r0.init
                com.cardinalcommerce.a.getAcsTransactionID r6 = r1.configure
                com.cardinalcommerce.a.getAcsTransactionID r7 = r1.init
                if (r2 == 0) goto L_0x01dd
                r8 = 1
                r9 = 0
                if (r2 == r8) goto L_0x0145
                r10 = 4
                r11 = 2
                if (r2 == r11) goto L_0x003e
                if (r2 != r10) goto L_0x0036
                goto L_0x003e
            L_0x0036:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x003e:
                com.cardinalcommerce.a.getAcsTransactionID[] r12 = r0.cca_continue
                r12 = r12[r9]
                com.cardinalcommerce.a.getAcsTransactionID[] r1 = r1.cca_continue
                r1 = r1[r9]
                boolean r13 = r12.CardinalError()
                if (r13 != 0) goto L_0x00a5
                boolean r15 = r12.equals(r1)
                if (r15 == 0) goto L_0x00a5
                com.cardinalcommerce.a.getAcsTransactionID r1 = r4.Cardinal(r6)
                com.cardinalcommerce.a.getAcsTransactionID r7 = r5.Cardinal(r7)
                boolean r13 = r1.cleanup()
                if (r13 == 0) goto L_0x0070
                boolean r1 = r7.cleanup()
                if (r1 == 0) goto L_0x006b
                com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
                return r1
            L_0x006b:
                com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
                return r1
            L_0x0070:
                com.cardinalcommerce.a.getAcsTransactionID r13 = r1.configure()
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.init(r13)
                com.cardinalcommerce.a.getAcsTransactionID r6 = r6.init(r13)
                com.cardinalcommerce.a.getAcsTransactionID r13 = r4.Cardinal(r6)
                com.cardinalcommerce.a.getAcsTransactionID r5 = r13.init(r5)
                com.cardinalcommerce.a.getAcsTransactionID r13 = r7.configure()
                com.cardinalcommerce.a.getAcsTransactionID r13 = r13.Cardinal(r4)
                com.cardinalcommerce.a.getAcsTransactionID r6 = r13.Cardinal(r6)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.Cardinal(r6)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.init(r7)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.Cardinal(r5)
                com.cardinalcommerce.a.getAcsTransactionID r1 = r1.init(r12)
                r5 = r4
                r4 = r6
            L_0x00a2:
                r14 = 0
                goto L_0x0125
            L_0x00a5:
                if (r13 == 0) goto L_0x00a8
                goto L_0x00b8
            L_0x00a8:
                com.cardinalcommerce.a.getAcsTransactionID r15 = r12.configure()
                com.cardinalcommerce.a.getAcsTransactionID r6 = r15.init(r6)
                com.cardinalcommerce.a.getAcsTransactionID r15 = r15.init(r12)
                com.cardinalcommerce.a.getAcsTransactionID r7 = r15.init(r7)
            L_0x00b8:
                boolean r15 = r1.CardinalError()
                if (r15 == 0) goto L_0x00bf
                goto L_0x00cf
            L_0x00bf:
                com.cardinalcommerce.a.getAcsTransactionID r14 = r1.configure()
                com.cardinalcommerce.a.getAcsTransactionID r4 = r14.init(r4)
                com.cardinalcommerce.a.getAcsTransactionID r14 = r14.init(r1)
                com.cardinalcommerce.a.getAcsTransactionID r5 = r14.init(r5)
            L_0x00cf:
                com.cardinalcommerce.a.getAcsTransactionID r6 = r4.Cardinal(r6)
                com.cardinalcommerce.a.getAcsTransactionID r7 = r5.Cardinal(r7)
                boolean r14 = r6.cleanup()
                if (r14 == 0) goto L_0x00ed
                boolean r1 = r7.cleanup()
                if (r1 == 0) goto L_0x00e8
                com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
                return r1
            L_0x00e8:
                com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
                return r1
            L_0x00ed:
                com.cardinalcommerce.a.getAcsTransactionID r14 = r6.configure()
                com.cardinalcommerce.a.getAcsTransactionID r8 = r14.init(r6)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r14.init(r4)
                com.cardinalcommerce.a.getAcsTransactionID r9 = r7.configure()
                com.cardinalcommerce.a.getAcsTransactionID r9 = r9.cca_continue(r8)
                com.cardinalcommerce.a.getAcsTransactionID r11 = r4.cca_continue(r4)
                com.cardinalcommerce.a.getAcsTransactionID r9 = r9.Cardinal(r11)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.Cardinal(r9)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.init(r7, r8, r5)
                if (r13 != 0) goto L_0x0118
                com.cardinalcommerce.a.getAcsTransactionID r5 = r6.init(r12)
                goto L_0x0119
            L_0x0118:
                r5 = r6
            L_0x0119:
                if (r15 != 0) goto L_0x0120
                com.cardinalcommerce.a.getAcsTransactionID r1 = r5.init(r1)
                goto L_0x0121
            L_0x0120:
                r1 = r5
            L_0x0121:
                r5 = r4
                r4 = r9
                if (r1 != r6) goto L_0x00a2
            L_0x0125:
                if (r2 != r10) goto L_0x0135
                com.cardinalcommerce.a.getAcsTransactionID r2 = r0.configure(r1, r14)
                r6 = 2
                com.cardinalcommerce.a.getAcsTransactionID[] r6 = new com.cardinalcommerce.p060a.getAcsTransactionID[r6]
                r7 = 0
                r6[r7] = r1
                r8 = 1
                r6[r8] = r2
                goto L_0x013c
            L_0x0135:
                r7 = 0
                r8 = 1
                com.cardinalcommerce.a.getAcsTransactionID[] r2 = new com.cardinalcommerce.p060a.getAcsTransactionID[r8]
                r2[r7] = r1
                r6 = r2
            L_0x013c:
                com.cardinalcommerce.a.ChallengeParameters$configure r1 = new com.cardinalcommerce.a.ChallengeParameters$configure
                boolean r7 = r0.getInstance
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r1
            L_0x0145:
                com.cardinalcommerce.a.getAcsTransactionID[] r2 = r0.cca_continue
                r8 = 0
                r2 = r2[r8]
                com.cardinalcommerce.a.getAcsTransactionID[] r1 = r1.cca_continue
                r1 = r1[r8]
                boolean r8 = r2.CardinalError()
                boolean r9 = r1.CardinalError()
                if (r8 == 0) goto L_0x0159
                goto L_0x015d
            L_0x0159:
                com.cardinalcommerce.a.getAcsTransactionID r7 = r7.init(r2)
            L_0x015d:
                if (r9 == 0) goto L_0x0160
                goto L_0x0164
            L_0x0160:
                com.cardinalcommerce.a.getAcsTransactionID r5 = r5.init(r1)
            L_0x0164:
                com.cardinalcommerce.a.getAcsTransactionID r7 = r7.Cardinal(r5)
                if (r8 == 0) goto L_0x016b
                goto L_0x016f
            L_0x016b:
                com.cardinalcommerce.a.getAcsTransactionID r6 = r6.init(r2)
            L_0x016f:
                if (r9 == 0) goto L_0x0172
                goto L_0x0176
            L_0x0172:
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.init(r1)
            L_0x0176:
                com.cardinalcommerce.a.getAcsTransactionID r6 = r6.Cardinal(r4)
                boolean r10 = r6.cleanup()
                if (r10 == 0) goto L_0x0190
                boolean r1 = r7.cleanup()
                if (r1 == 0) goto L_0x018b
                com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
                return r1
            L_0x018b:
                com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
                return r1
            L_0x0190:
                if (r8 == 0) goto L_0x0194
                r2 = r1
                goto L_0x019b
            L_0x0194:
                if (r9 == 0) goto L_0x0197
                goto L_0x019b
            L_0x0197:
                com.cardinalcommerce.a.getAcsTransactionID r2 = r2.init(r1)
            L_0x019b:
                com.cardinalcommerce.a.getAcsTransactionID r1 = r6.configure()
                com.cardinalcommerce.a.getAcsTransactionID r8 = r1.init(r6)
                com.cardinalcommerce.a.getAcsTransactionID r1 = r1.init(r4)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r7.configure()
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.init(r2)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.Cardinal(r8)
                com.cardinalcommerce.a.getAcsTransactionID r9 = r1.cca_continue(r1)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.Cardinal(r9)
                com.cardinalcommerce.a.getAcsTransactionID r6 = r6.init(r4)
                com.cardinalcommerce.a.getAcsTransactionID r1 = r1.Cardinal(r4)
                com.cardinalcommerce.a.getAcsTransactionID r5 = r1.init(r7, r5, r8)
                com.cardinalcommerce.a.getAcsTransactionID r1 = r8.init(r2)
                com.cardinalcommerce.a.ChallengeParameters$configure r8 = new com.cardinalcommerce.a.ChallengeParameters$configure
                r2 = 1
                com.cardinalcommerce.a.getAcsTransactionID[] r7 = new com.cardinalcommerce.p060a.getAcsTransactionID[r2]
                r2 = 0
                r7[r2] = r1
                boolean r1 = r0.getInstance
                r2 = r8
                r4 = r6
                r6 = r7
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r8
            L_0x01dd:
                com.cardinalcommerce.a.getAcsTransactionID r1 = r6.Cardinal(r4)
                com.cardinalcommerce.a.getAcsTransactionID r2 = r7.Cardinal(r5)
                boolean r7 = r1.cleanup()
                if (r7 == 0) goto L_0x01fb
                boolean r1 = r2.cleanup()
                if (r1 == 0) goto L_0x01f6
                com.cardinalcommerce.a.ChallengeParameters r1 = r16.getRequestTimeout()
                return r1
            L_0x01f6:
                com.cardinalcommerce.a.ChallengeParameters r1 = r3.init()
                return r1
            L_0x01fb:
                com.cardinalcommerce.a.getAcsTransactionID r1 = r2.getInstance((com.cardinalcommerce.p060a.getAcsTransactionID) r1)
                com.cardinalcommerce.a.getAcsTransactionID r2 = r1.configure()
                com.cardinalcommerce.a.getAcsTransactionID r2 = r2.Cardinal(r4)
                com.cardinalcommerce.a.getAcsTransactionID r2 = r2.Cardinal(r6)
                com.cardinalcommerce.a.getAcsTransactionID r4 = r4.Cardinal(r2)
                com.cardinalcommerce.a.getAcsTransactionID r1 = r1.init(r4)
                com.cardinalcommerce.a.getAcsTransactionID r1 = r1.Cardinal(r5)
                com.cardinalcommerce.a.ChallengeParameters$configure r4 = new com.cardinalcommerce.a.ChallengeParameters$configure
                boolean r5 = r0.getInstance
                r4.<init>(r3, r2, r1, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.ChallengeParameters.C1892configure.getInstance(com.cardinalcommerce.a.ChallengeParameters):com.cardinalcommerce.a.ChallengeParameters");
        }

        public final ChallengeParameters getRequestTimeout() {
            getAcsTransactionID getacstransactionid;
            getAcsTransactionID getacstransactionid2;
            getAcsTransactionID getacstransactionid3;
            if (valueOf()) {
                return this;
            }
            getSDKAppID cca_continue = cca_continue();
            getAcsTransactionID getacstransactionid4 = this.init;
            if (getacstransactionid4.cleanup()) {
                return cca_continue.init();
            }
            int CardinalActionCode = cca_continue.CardinalActionCode();
            getAcsTransactionID getacstransactionid5 = this.configure;
            if (CardinalActionCode == 0) {
                getAcsTransactionID configure = getacstransactionid5.configure();
                getAcsTransactionID instance = configure.cca_continue(configure).cca_continue(configure).cca_continue(cca_continue().cleanup()).getInstance(getacstransactionid4.cca_continue(getacstransactionid4));
                getAcsTransactionID Cardinal = instance.configure().Cardinal(getacstransactionid5.cca_continue(getacstransactionid5));
                return new C1892configure(cca_continue, Cardinal, instance.init(getacstransactionid5.Cardinal(Cardinal)).Cardinal(getacstransactionid4), this.getInstance);
            } else if (CardinalActionCode == 1) {
                getAcsTransactionID getacstransactionid6 = this.cca_continue[0];
                boolean CardinalError = getacstransactionid6.CardinalError();
                getAcsTransactionID cleanup = cca_continue.cleanup();
                if (!cleanup.cleanup() && !CardinalError) {
                    cleanup = cleanup.init(getacstransactionid6.configure());
                }
                getAcsTransactionID configure2 = getacstransactionid5.configure();
                getAcsTransactionID cca_continue2 = cleanup.cca_continue(configure2.cca_continue(configure2).cca_continue(configure2));
                getAcsTransactionID init = CardinalError ? getacstransactionid4 : getacstransactionid4.init(getacstransactionid6);
                getAcsTransactionID configure3 = CardinalError ? getacstransactionid4.configure() : init.init(getacstransactionid4);
                getAcsTransactionID init2 = getacstransactionid5.init(configure3);
                getAcsTransactionID cca_continue3 = init2.cca_continue(init2);
                getAcsTransactionID cca_continue4 = cca_continue3.cca_continue(cca_continue3);
                getAcsTransactionID Cardinal2 = cca_continue2.configure().Cardinal(cca_continue4.cca_continue(cca_continue4));
                getAcsTransactionID cca_continue5 = init.cca_continue(init);
                getAcsTransactionID init3 = Cardinal2.init(cca_continue5);
                getAcsTransactionID cca_continue6 = configure3.cca_continue(configure3);
                getAcsTransactionID init4 = cca_continue4.Cardinal(Cardinal2).init(cca_continue2);
                getAcsTransactionID configure4 = cca_continue6.configure();
                getAcsTransactionID Cardinal3 = init4.Cardinal(configure4.cca_continue(configure4));
                if (CardinalError) {
                    getacstransactionid = cca_continue6.cca_continue(cca_continue6);
                } else {
                    getacstransactionid = cca_continue5.configure();
                }
                return new C1892configure(cca_continue, init3, Cardinal3, new getAcsTransactionID[]{getacstransactionid.cca_continue(getacstransactionid).init(init)}, this.getInstance);
            } else if (CardinalActionCode == 2) {
                getAcsTransactionID getacstransactionid7 = this.cca_continue[0];
                boolean CardinalError2 = getacstransactionid7.CardinalError();
                getAcsTransactionID configure5 = getacstransactionid4.configure();
                getAcsTransactionID configure6 = configure5.configure();
                getAcsTransactionID cleanup2 = cca_continue.cleanup();
                getAcsTransactionID instance2 = cleanup2.getInstance();
                if (instance2.Cardinal().equals(BigInteger.valueOf(3))) {
                    getAcsTransactionID configure7 = CardinalError2 ? getacstransactionid7 : getacstransactionid7.configure();
                    getAcsTransactionID init5 = getacstransactionid5.cca_continue(configure7).init(getacstransactionid5.Cardinal(configure7));
                    getacstransactionid2 = init5.cca_continue(init5).cca_continue(init5);
                    getAcsTransactionID init6 = configure5.init(getacstransactionid5);
                    getAcsTransactionID cca_continue7 = init6.cca_continue(init6);
                    getacstransactionid3 = cca_continue7.cca_continue(cca_continue7);
                } else {
                    getAcsTransactionID configure8 = getacstransactionid5.configure();
                    getAcsTransactionID cca_continue8 = configure8.cca_continue(configure8).cca_continue(configure8);
                    if (!CardinalError2) {
                        if (!cleanup2.cleanup()) {
                            getAcsTransactionID configure9 = getacstransactionid7.configure().configure();
                            if (instance2.getWarnings() < cleanup2.getWarnings()) {
                                getacstransactionid2 = cca_continue8.Cardinal(configure9.init(instance2));
                            } else {
                                cleanup2 = configure9.init(cleanup2);
                            }
                        } else {
                            getacstransactionid2 = cca_continue8;
                        }
                        getAcsTransactionID init7 = getacstransactionid5.init(configure5);
                        getAcsTransactionID cca_continue9 = init7.cca_continue(init7);
                        getacstransactionid3 = cca_continue9.cca_continue(cca_continue9);
                    }
                    getacstransactionid2 = cca_continue8.cca_continue(cleanup2);
                    getAcsTransactionID init72 = getacstransactionid5.init(configure5);
                    getAcsTransactionID cca_continue92 = init72.cca_continue(init72);
                    getacstransactionid3 = cca_continue92.cca_continue(cca_continue92);
                }
                getAcsTransactionID Cardinal4 = getacstransactionid2.configure().Cardinal(getacstransactionid3.cca_continue(getacstransactionid3));
                getAcsTransactionID init8 = getacstransactionid3.Cardinal(Cardinal4).init(getacstransactionid2);
                getAcsTransactionID cca_continue10 = configure6.cca_continue(configure6);
                getAcsTransactionID cca_continue11 = cca_continue10.cca_continue(cca_continue10);
                getAcsTransactionID Cardinal5 = init8.Cardinal(cca_continue11.cca_continue(cca_continue11));
                getAcsTransactionID cca_continue12 = getacstransactionid4.cca_continue(getacstransactionid4);
                if (!CardinalError2) {
                    cca_continue12 = cca_continue12.init(getacstransactionid7);
                }
                return new C1892configure(cca_continue, Cardinal4, Cardinal5, new getAcsTransactionID[]{cca_continue12}, this.getInstance);
            } else if (CardinalActionCode == 4) {
                return getInstance(true);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public final ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
            if (this == challengeParameters) {
                return getChallengeTimeout();
            }
            if (valueOf()) {
                return challengeParameters;
            }
            if (challengeParameters.valueOf()) {
                return getRequestTimeout();
            }
            getAcsTransactionID getacstransactionid = this.init;
            if (getacstransactionid.cleanup()) {
                return challengeParameters;
            }
            getSDKAppID cca_continue = cca_continue();
            int CardinalActionCode = cca_continue.CardinalActionCode();
            if (CardinalActionCode != 0) {
                return (CardinalActionCode != 4 ? getRequestTimeout() : getInstance(false)).getInstance(challengeParameters);
            }
            getAcsTransactionID getacstransactionid2 = this.configure;
            getAcsTransactionID getacstransactionid3 = challengeParameters.configure;
            getAcsTransactionID getacstransactionid4 = challengeParameters.init;
            getAcsTransactionID Cardinal = getacstransactionid3.Cardinal(getacstransactionid2);
            getAcsTransactionID Cardinal2 = getacstransactionid4.Cardinal(getacstransactionid);
            if (Cardinal.cleanup()) {
                return Cardinal2.cleanup() ? getChallengeTimeout() : this;
            }
            getAcsTransactionID configure = Cardinal.configure();
            getAcsTransactionID Cardinal3 = configure.init(getacstransactionid2.cca_continue(getacstransactionid2).cca_continue(getacstransactionid3)).Cardinal(Cardinal2.configure());
            if (Cardinal3.cleanup()) {
                return cca_continue.init();
            }
            getAcsTransactionID sDKVersion = Cardinal3.init(Cardinal).getSDKVersion();
            getAcsTransactionID init = Cardinal3.init(sDKVersion).init(Cardinal2);
            getAcsTransactionID Cardinal4 = getacstransactionid.cca_continue(getacstransactionid).init(configure).init(Cardinal).init(sDKVersion).Cardinal(init);
            getAcsTransactionID cca_continue2 = Cardinal4.Cardinal(init).init(init.cca_continue(Cardinal4)).cca_continue(getacstransactionid3);
            return new C1892configure(cca_continue, cca_continue2, getacstransactionid2.Cardinal(cca_continue2).init(Cardinal4).Cardinal(getacstransactionid), this.getInstance);
        }

        public final ChallengeParameters getChallengeTimeout() {
            if (valueOf()) {
                return this;
            }
            getAcsTransactionID getacstransactionid = this.init;
            if (getacstransactionid.cleanup()) {
                return this;
            }
            getSDKAppID cca_continue = cca_continue();
            int CardinalActionCode = cca_continue.CardinalActionCode();
            if (CardinalActionCode != 0) {
                return CardinalActionCode != 4 ? getRequestTimeout().getInstance((ChallengeParameters) this) : getInstance(false).getInstance((ChallengeParameters) this);
            }
            getAcsTransactionID getacstransactionid2 = this.configure;
            getAcsTransactionID cca_continue2 = getacstransactionid.cca_continue(getacstransactionid);
            getAcsTransactionID configure = cca_continue2.configure();
            getAcsTransactionID configure2 = getacstransactionid2.configure();
            getAcsTransactionID cca_continue3 = configure2.cca_continue(configure2).cca_continue(configure2).cca_continue(cca_continue().cleanup());
            getAcsTransactionID Cardinal = getacstransactionid2.cca_continue(getacstransactionid2).cca_continue(getacstransactionid2).init(configure).Cardinal(cca_continue3.configure());
            if (Cardinal.cleanup()) {
                return cca_continue().init();
            }
            getAcsTransactionID sDKVersion = Cardinal.init(cca_continue2).getSDKVersion();
            getAcsTransactionID init = Cardinal.init(sDKVersion).init(cca_continue3);
            getAcsTransactionID Cardinal2 = configure.configure().init(sDKVersion).Cardinal(init);
            getAcsTransactionID cca_continue4 = Cardinal2.Cardinal(init).init(init.cca_continue(Cardinal2)).cca_continue(getacstransactionid2);
            return new C1892configure(cca_continue, cca_continue4, getacstransactionid2.Cardinal(cca_continue4).init(Cardinal2).Cardinal(getacstransactionid), this.getInstance);
        }

        public final ChallengeParameters getInstance(int i) {
            getAcsTransactionID getacstransactionid;
            int i2 = i;
            if (i2 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            } else if (i2 == 0 || valueOf()) {
                return this;
            } else {
                if (i2 == 1) {
                    return getRequestTimeout();
                }
                getSDKAppID cca_continue = cca_continue();
                getAcsTransactionID getacstransactionid2 = this.init;
                if (getacstransactionid2.cleanup()) {
                    return cca_continue.init();
                }
                int CardinalActionCode = cca_continue.CardinalActionCode();
                getAcsTransactionID cleanup = cca_continue.cleanup();
                getAcsTransactionID getacstransactionid3 = this.configure;
                getAcsTransactionID configure = this.cca_continue.length <= 0 ? cca_continue.configure(getSDKReferenceNumber.values) : this.cca_continue[0];
                if (!configure.CardinalError() && CardinalActionCode != 0) {
                    if (CardinalActionCode != 1) {
                        getacstransactionid = null;
                        if (CardinalActionCode != 2) {
                            if (CardinalActionCode == 4) {
                                getAcsTransactionID getacstransactionid4 = this.cca_continue[1];
                                if (getacstransactionid4 == null) {
                                    getAcsTransactionID[] getacstransactionidArr = this.cca_continue;
                                    cleanup = configure(this.cca_continue[0], (getAcsTransactionID) null);
                                    getacstransactionidArr[1] = cleanup;
                                } else {
                                    cleanup = getacstransactionid4;
                                }
                            } else {
                                throw new IllegalStateException("unsupported coordinate system");
                            }
                        }
                    } else {
                        getacstransactionid = configure.configure();
                        getacstransactionid3 = getacstransactionid3.init(configure);
                        getacstransactionid2 = getacstransactionid2.init(getacstransactionid);
                    }
                    cleanup = configure(configure, getacstransactionid);
                }
                int i3 = 0;
                getAcsTransactionID getacstransactionid5 = cleanup;
                getAcsTransactionID getacstransactionid6 = getacstransactionid2;
                getAcsTransactionID getacstransactionid7 = getacstransactionid3;
                getAcsTransactionID getacstransactionid8 = getacstransactionid5;
                while (i3 < i2) {
                    if (getacstransactionid6.cleanup()) {
                        return cca_continue.init();
                    }
                    getAcsTransactionID configure2 = getacstransactionid7.configure();
                    getAcsTransactionID cca_continue2 = configure2.cca_continue(configure2).cca_continue(configure2);
                    getAcsTransactionID cca_continue3 = getacstransactionid6.cca_continue(getacstransactionid6);
                    getAcsTransactionID init = cca_continue3.init(getacstransactionid6);
                    getAcsTransactionID init2 = getacstransactionid7.init(init);
                    getAcsTransactionID cca_continue4 = init2.cca_continue(init2);
                    getAcsTransactionID configure3 = init.configure();
                    getAcsTransactionID cca_continue5 = configure3.cca_continue(configure3);
                    if (!getacstransactionid8.cleanup()) {
                        cca_continue2 = cca_continue2.cca_continue(getacstransactionid8);
                        getAcsTransactionID init3 = cca_continue5.init(getacstransactionid8);
                        getacstransactionid8 = init3.cca_continue(init3);
                    }
                    getAcsTransactionID Cardinal = cca_continue2.configure().Cardinal(cca_continue4.cca_continue(cca_continue4));
                    getacstransactionid6 = cca_continue2.init(cca_continue4.Cardinal(Cardinal)).Cardinal(cca_continue5);
                    configure = configure.CardinalError() ? cca_continue3 : cca_continue3.init(configure);
                    i3++;
                    getacstransactionid7 = Cardinal;
                }
                if (CardinalActionCode == 0) {
                    getAcsTransactionID sDKVersion = configure.getSDKVersion();
                    getAcsTransactionID configure4 = sDKVersion.configure();
                    return new C1892configure(cca_continue, getacstransactionid7.init(configure4), getacstransactionid6.init(configure4.init(sDKVersion)), this.getInstance);
                } else if (CardinalActionCode == 1) {
                    return new C1892configure(cca_continue, getacstransactionid7.init(configure), getacstransactionid6, new getAcsTransactionID[]{configure.init(configure.configure())}, this.getInstance);
                } else if (CardinalActionCode == 2) {
                    return new C1892configure(cca_continue, getacstransactionid7, getacstransactionid6, new getAcsTransactionID[]{configure}, this.getInstance);
                } else if (CardinalActionCode == 4) {
                    return new C1892configure(cca_continue, getacstransactionid7, getacstransactionid6, new getAcsTransactionID[]{configure, getacstransactionid8}, this.getInstance);
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
        }

        private C1892configure getInstance(boolean z) {
            getAcsTransactionID getacstransactionid = this.configure;
            getAcsTransactionID getacstransactionid2 = this.init;
            getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
            getAcsTransactionID getacstransactionid4 = this.cca_continue[1];
            getAcsTransactionID getacstransactionid5 = null;
            if (getacstransactionid4 == null) {
                getAcsTransactionID[] getacstransactionidArr = this.cca_continue;
                getAcsTransactionID configure = configure(this.cca_continue[0], (getAcsTransactionID) null);
                getacstransactionidArr[1] = configure;
                getacstransactionid4 = configure;
            }
            getAcsTransactionID configure2 = getacstransactionid.configure();
            getAcsTransactionID cca_continue = configure2.cca_continue(configure2).cca_continue(configure2).cca_continue(getacstransactionid4);
            getAcsTransactionID cca_continue2 = getacstransactionid2.cca_continue(getacstransactionid2);
            getAcsTransactionID init = cca_continue2.init(getacstransactionid2);
            getAcsTransactionID init2 = getacstransactionid.init(init);
            getAcsTransactionID cca_continue3 = init2.cca_continue(init2);
            getAcsTransactionID Cardinal = cca_continue.configure().Cardinal(cca_continue3.cca_continue(cca_continue3));
            getAcsTransactionID configure3 = init.configure();
            getAcsTransactionID cca_continue4 = configure3.cca_continue(configure3);
            getAcsTransactionID Cardinal2 = cca_continue.init(cca_continue3.Cardinal(Cardinal)).Cardinal(cca_continue4);
            if (z) {
                getAcsTransactionID init3 = cca_continue4.init(getacstransactionid4);
                getacstransactionid5 = init3.cca_continue(init3);
            }
            if (!getacstransactionid3.CardinalError()) {
                cca_continue2 = cca_continue2.init(getacstransactionid3);
            }
            return new C1892configure(cca_continue(), Cardinal, Cardinal2, new getAcsTransactionID[]{cca_continue2, getacstransactionid5}, this.getInstance);
        }
    }

    /* renamed from: com.cardinalcommerce.a.ChallengeParameters$init */
    public static class C1893init extends Cardinal {
        public C1893init(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
            super(getsdkappid, getacstransactionid, getacstransactionid2);
            if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
                if (getacstransactionid != null) {
                    getAcsTransactionID.C1998init.getInstance(this.configure, this.init);
                    if (getsdkappid != null) {
                        getAcsTransactionID.C1998init.getInstance(this.configure, this.Cardinal.cleanup());
                    }
                }
                this.getInstance = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        C1893init(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
            super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
            this.getInstance = z;
        }

        public final ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
            if (valueOf()) {
                return challengeParameters;
            }
            if (challengeParameters.valueOf()) {
                return getRequestTimeout();
            }
            getSDKAppID cca_continue = cca_continue();
            getAcsTransactionID getacstransactionid = this.configure;
            if (getacstransactionid.cleanup()) {
                return challengeParameters;
            }
            if (cca_continue.CardinalActionCode() != 6) {
                return getRequestTimeout().getInstance(challengeParameters);
            }
            getAcsTransactionID getacstransactionid2 = challengeParameters.configure;
            getAcsTransactionID getacstransactionid3 = challengeParameters.cca_continue[0];
            if (getacstransactionid2.cleanup() || !getacstransactionid3.CardinalError()) {
                return getRequestTimeout().getInstance(challengeParameters);
            }
            getAcsTransactionID getacstransactionid4 = this.init;
            getAcsTransactionID getacstransactionid5 = this.cca_continue[0];
            getAcsTransactionID getacstransactionid6 = challengeParameters.init;
            getAcsTransactionID configure = getacstransactionid.configure();
            getAcsTransactionID configure2 = getacstransactionid4.configure();
            getAcsTransactionID configure3 = getacstransactionid5.configure();
            getAcsTransactionID cca_continue2 = cca_continue.cleanup().init(configure3).cca_continue(configure2).cca_continue(getacstransactionid4.init(getacstransactionid5));
            getAcsTransactionID init = getacstransactionid6.init();
            getAcsTransactionID Cardinal = cca_continue.cleanup().cca_continue(init).init(configure3).cca_continue(configure2).Cardinal(cca_continue2, configure, configure3);
            getAcsTransactionID init2 = getacstransactionid2.init(configure3);
            getAcsTransactionID configure4 = init2.cca_continue(cca_continue2).configure();
            if (configure4.cleanup()) {
                return Cardinal.cleanup() ? challengeParameters.getRequestTimeout() : cca_continue.init();
            }
            if (Cardinal.cleanup()) {
                return new C1893init(cca_continue, Cardinal, cca_continue.getWarnings().values(), this.getInstance);
            }
            getAcsTransactionID init3 = Cardinal.configure().init(init2);
            getAcsTransactionID init4 = Cardinal.init(configure4).init(configure3);
            return new C1893init(cca_continue, init3, Cardinal.cca_continue(configure4).configure().Cardinal(cca_continue2, init, init4), new getAcsTransactionID[]{init4}, this.getInstance);
        }

        /* access modifiers changed from: protected */
        public final boolean CardinalConfigurationParameters() {
            getAcsTransactionID warnings = getWarnings();
            if (warnings.cleanup()) {
                return false;
            }
            getAcsTransactionID CardinalActionCode = CardinalActionCode();
            int cleanup = cleanup();
            return (cleanup == 5 || cleanup == 6) ? CardinalActionCode.CardinalActionCode() != warnings.CardinalActionCode() : CardinalActionCode.getInstance(warnings).CardinalActionCode();
        }

        public final getAcsTransactionID CardinalError() {
            int cleanup = cleanup();
            if (cleanup != 5 && cleanup != 6) {
                return this.init;
            }
            getAcsTransactionID getacstransactionid = this.configure;
            getAcsTransactionID getacstransactionid2 = this.init;
            if (valueOf() || getacstransactionid.cleanup()) {
                return getacstransactionid2;
            }
            getAcsTransactionID init = getacstransactionid2.cca_continue(getacstransactionid).init(getacstransactionid);
            if (6 != cleanup) {
                return init;
            }
            getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
            return !getacstransactionid3.CardinalError() ? init.getInstance(getacstransactionid3) : init;
        }

        public final ChallengeParameters getInstance(ChallengeParameters challengeParameters) {
            getAcsTransactionID getacstransactionid;
            getAcsTransactionID getacstransactionid2;
            getAcsTransactionID getacstransactionid3;
            getAcsTransactionID getacstransactionid4;
            getAcsTransactionID getacstransactionid5;
            getAcsTransactionID getacstransactionid6;
            ChallengeParameters challengeParameters2 = challengeParameters;
            if (valueOf()) {
                return challengeParameters2;
            }
            if (challengeParameters.valueOf()) {
                return this;
            }
            getSDKAppID cca_continue = cca_continue();
            int CardinalActionCode = cca_continue.CardinalActionCode();
            getAcsTransactionID getacstransactionid7 = this.configure;
            getAcsTransactionID getacstransactionid8 = challengeParameters2.configure;
            if (CardinalActionCode == 0) {
                getAcsTransactionID getacstransactionid9 = this.init;
                getAcsTransactionID getacstransactionid10 = challengeParameters2.init;
                getAcsTransactionID cca_continue2 = getacstransactionid7.cca_continue(getacstransactionid8);
                getAcsTransactionID cca_continue3 = getacstransactionid9.cca_continue(getacstransactionid10);
                if (cca_continue2.cleanup()) {
                    return cca_continue3.cleanup() ? getRequestTimeout() : cca_continue.init();
                }
                getAcsTransactionID instance = cca_continue3.getInstance(cca_continue2);
                getAcsTransactionID cca_continue4 = instance.configure().cca_continue(instance).cca_continue(cca_continue2).cca_continue(cca_continue.cleanup());
                return new C1893init(cca_continue, cca_continue4, instance.init(getacstransactionid7.cca_continue(cca_continue4)).cca_continue(cca_continue4).cca_continue(getacstransactionid9), this.getInstance);
            } else if (CardinalActionCode == 1) {
                getAcsTransactionID getacstransactionid11 = this.init;
                getAcsTransactionID getacstransactionid12 = this.cca_continue[0];
                getAcsTransactionID getacstransactionid13 = challengeParameters2.init;
                getAcsTransactionID getacstransactionid14 = challengeParameters2.cca_continue[0];
                boolean CardinalError = getacstransactionid14.CardinalError();
                getAcsTransactionID cca_continue5 = getacstransactionid12.init(getacstransactionid13).cca_continue(CardinalError ? getacstransactionid11 : getacstransactionid11.init(getacstransactionid14));
                getAcsTransactionID cca_continue6 = getacstransactionid12.init(getacstransactionid8).cca_continue(CardinalError ? getacstransactionid7 : getacstransactionid7.init(getacstransactionid14));
                if (cca_continue6.cleanup()) {
                    return cca_continue5.cleanup() ? getRequestTimeout() : cca_continue.init();
                }
                getAcsTransactionID configure = cca_continue6.configure();
                getAcsTransactionID init = configure.init(cca_continue6);
                if (!CardinalError) {
                    getacstransactionid12 = getacstransactionid12.init(getacstransactionid14);
                }
                getAcsTransactionID cca_continue7 = cca_continue5.cca_continue(cca_continue6);
                getAcsTransactionID cca_continue8 = cca_continue7.Cardinal(cca_continue5, configure, cca_continue.cleanup()).init(getacstransactionid12).cca_continue(init);
                getAcsTransactionID init2 = cca_continue6.init(cca_continue8);
                if (!CardinalError) {
                    configure = configure.init(getacstransactionid14);
                }
                return new C1893init(cca_continue, init2, cca_continue5.Cardinal(getacstransactionid7, cca_continue6, getacstransactionid11).Cardinal(configure, cca_continue7, cca_continue8), new getAcsTransactionID[]{init.init(getacstransactionid12)}, this.getInstance);
            } else if (CardinalActionCode != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (getacstransactionid7.cleanup()) {
                return getacstransactionid8.cleanup() ? cca_continue.init() : challengeParameters2.getInstance((ChallengeParameters) this);
            } else {
                getAcsTransactionID getacstransactionid15 = this.init;
                getAcsTransactionID getacstransactionid16 = this.cca_continue[0];
                getAcsTransactionID getacstransactionid17 = challengeParameters2.init;
                getAcsTransactionID getacstransactionid18 = challengeParameters2.cca_continue[0];
                boolean CardinalError2 = getacstransactionid16.CardinalError();
                if (!CardinalError2) {
                    getacstransactionid2 = getacstransactionid8.init(getacstransactionid16);
                    getacstransactionid = getacstransactionid17.init(getacstransactionid16);
                } else {
                    getacstransactionid2 = getacstransactionid8;
                    getacstransactionid = getacstransactionid17;
                }
                boolean CardinalError3 = getacstransactionid18.CardinalError();
                if (!CardinalError3) {
                    getacstransactionid7 = getacstransactionid7.init(getacstransactionid18);
                    getacstransactionid3 = getacstransactionid15.init(getacstransactionid18);
                } else {
                    getacstransactionid3 = getacstransactionid15;
                }
                getAcsTransactionID cca_continue9 = getacstransactionid3.cca_continue(getacstransactionid);
                getAcsTransactionID cca_continue10 = getacstransactionid7.cca_continue(getacstransactionid2);
                if (cca_continue10.cleanup()) {
                    return cca_continue9.cleanup() ? getRequestTimeout() : cca_continue.init();
                }
                if (getacstransactionid8.cleanup()) {
                    ChallengeParameters CardinalRenderType = CardinalRenderType();
                    getAcsTransactionID values = CardinalRenderType.values();
                    getAcsTransactionID CardinalError4 = CardinalRenderType.CardinalError();
                    getAcsTransactionID instance2 = CardinalError4.cca_continue(getacstransactionid17).getInstance(values);
                    getacstransactionid4 = instance2.configure().cca_continue(instance2).cca_continue(values).cca_continue(cca_continue.cleanup());
                    if (getacstransactionid4.cleanup()) {
                        return new C1893init(cca_continue, getacstransactionid4, cca_continue.getWarnings().values(), this.getInstance);
                    }
                    getacstransactionid6 = instance2.init(values.cca_continue(getacstransactionid4)).cca_continue(getacstransactionid4).cca_continue(CardinalError4).getInstance(getacstransactionid4).cca_continue(getacstransactionid4);
                    getacstransactionid5 = cca_continue.configure(getSDKReferenceNumber.values);
                } else {
                    getAcsTransactionID configure2 = cca_continue10.configure();
                    getAcsTransactionID init3 = cca_continue9.init(getacstransactionid7);
                    getAcsTransactionID init4 = cca_continue9.init(getacstransactionid2);
                    getAcsTransactionID init5 = init3.init(init4);
                    if (init5.cleanup()) {
                        return new C1893init(cca_continue, init5, cca_continue.getWarnings().values(), this.getInstance);
                    }
                    getAcsTransactionID init6 = cca_continue9.init(configure2);
                    getAcsTransactionID init7 = !CardinalError3 ? init6.init(getacstransactionid18) : init6;
                    getAcsTransactionID cca_continue11 = init4.cca_continue(configure2).cca_continue(init7, getacstransactionid15.cca_continue(getacstransactionid16));
                    if (!CardinalError2) {
                        init7 = init7.init(getacstransactionid16);
                    }
                    getacstransactionid4 = init5;
                    getAcsTransactionID getacstransactionid19 = cca_continue11;
                    getacstransactionid5 = init7;
                    getacstransactionid6 = getacstransactionid19;
                }
                return new C1893init(cca_continue, getacstransactionid4, getacstransactionid6, new getAcsTransactionID[]{getacstransactionid5}, this.getInstance);
            }
        }

        public final ChallengeParameters getRequestTimeout() {
            getAcsTransactionID getacstransactionid;
            if (valueOf()) {
                return this;
            }
            getSDKAppID cca_continue = cca_continue();
            getAcsTransactionID getacstransactionid2 = this.configure;
            if (getacstransactionid2.cleanup()) {
                return cca_continue.init();
            }
            int CardinalActionCode = cca_continue.CardinalActionCode();
            if (CardinalActionCode == 0) {
                getSDKAppID getsdkappid = cca_continue;
                getAcsTransactionID cca_continue2 = this.init.getInstance(getacstransactionid2).cca_continue(getacstransactionid2);
                getAcsTransactionID cca_continue3 = cca_continue2.configure().cca_continue(cca_continue2).cca_continue(getsdkappid.cleanup());
                return new C1893init(getsdkappid, cca_continue3, getacstransactionid2.cca_continue(cca_continue3, cca_continue2.init()), this.getInstance);
            } else if (CardinalActionCode == 1) {
                getSDKAppID getsdkappid2 = cca_continue;
                getAcsTransactionID getacstransactionid3 = this.init;
                getAcsTransactionID getacstransactionid4 = this.cca_continue[0];
                boolean CardinalError = getacstransactionid4.CardinalError();
                getAcsTransactionID init = CardinalError ? getacstransactionid2 : getacstransactionid2.init(getacstransactionid4);
                if (!CardinalError) {
                    getacstransactionid3 = getacstransactionid3.init(getacstransactionid4);
                }
                getAcsTransactionID configure = getacstransactionid2.configure();
                getAcsTransactionID cca_continue4 = configure.cca_continue(getacstransactionid3);
                getAcsTransactionID configure2 = init.configure();
                getAcsTransactionID cca_continue5 = cca_continue4.cca_continue(init);
                getAcsTransactionID Cardinal = cca_continue5.Cardinal(cca_continue4, configure2, getsdkappid2.cleanup());
                return new C1893init(getsdkappid2, init.init(Cardinal), configure.configure().Cardinal(init, Cardinal, cca_continue5), new getAcsTransactionID[]{init.init(configure2)}, this.getInstance);
            } else if (CardinalActionCode == 6) {
                getAcsTransactionID getacstransactionid5 = this.init;
                getAcsTransactionID getacstransactionid6 = this.cca_continue[0];
                boolean CardinalError2 = getacstransactionid6.CardinalError();
                getAcsTransactionID init2 = CardinalError2 ? getacstransactionid5 : getacstransactionid5.init(getacstransactionid6);
                getAcsTransactionID configure3 = CardinalError2 ? getacstransactionid6 : getacstransactionid6.configure();
                getAcsTransactionID cleanup = cca_continue.cleanup();
                getAcsTransactionID init3 = CardinalError2 ? cleanup : cleanup.init(configure3);
                getAcsTransactionID cca_continue6 = getacstransactionid5.configure().cca_continue(init2).cca_continue(init3);
                if (cca_continue6.cleanup()) {
                    return new C1893init(cca_continue, cca_continue6, cca_continue.getWarnings().values(), this.getInstance);
                }
                getAcsTransactionID configure4 = cca_continue6.configure();
                getAcsTransactionID init4 = CardinalError2 ? cca_continue6 : cca_continue6.init(configure3);
                getAcsTransactionID warnings = cca_continue.getWarnings();
                getSDKAppID getsdkappid3 = cca_continue;
                if (warnings.getWarnings() < (cca_continue.configure() >> 1)) {
                    getAcsTransactionID configure5 = getacstransactionid5.cca_continue(getacstransactionid2).configure();
                    getacstransactionid = configure5.cca_continue(cca_continue6).cca_continue(configure3).init(configure5).cca_continue(warnings.CardinalError() ? init3.cca_continue(configure3).configure() : init3.cca_continue(warnings, configure3.configure())).cca_continue(configure4);
                    if (!cleanup.cleanup()) {
                        if (!cleanup.CardinalError()) {
                            getacstransactionid = getacstransactionid.cca_continue(cleanup.init().init(init4));
                        }
                        return new C1893init(getsdkappid3, configure4, getacstransactionid, new getAcsTransactionID[]{init4}, this.getInstance);
                    }
                } else {
                    if (!CardinalError2) {
                        getacstransactionid2 = getacstransactionid2.init(getacstransactionid6);
                    }
                    getacstransactionid = getacstransactionid2.cca_continue(cca_continue6, init2).cca_continue(configure4);
                }
                getacstransactionid = getacstransactionid.cca_continue(init4);
                return new C1893init(getsdkappid3, configure4, getacstransactionid, new getAcsTransactionID[]{init4}, this.getInstance);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public final ChallengeParameters getString() {
            if (valueOf()) {
                return this;
            }
            getAcsTransactionID getacstransactionid = this.configure;
            if (getacstransactionid.cleanup()) {
                return this;
            }
            int cleanup = cleanup();
            if (cleanup == 0) {
                return new C1893init(this.Cardinal, getacstransactionid, this.init.cca_continue(getacstransactionid), this.getInstance);
            } else if (cleanup == 1) {
                getAcsTransactionID getacstransactionid2 = this.init;
                getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
                return new C1893init(this.Cardinal, getacstransactionid, getacstransactionid2.cca_continue(getacstransactionid), new getAcsTransactionID[]{getacstransactionid3}, this.getInstance);
            } else if (cleanup == 5) {
                return new C1893init(this.Cardinal, getacstransactionid, this.init.init(), this.getInstance);
            } else if (cleanup == 6) {
                getAcsTransactionID getacstransactionid4 = this.init;
                getAcsTransactionID getacstransactionid5 = this.cca_continue[0];
                return new C1893init(this.Cardinal, getacstransactionid, getacstransactionid4.cca_continue(getacstransactionid5), new getAcsTransactionID[]{getacstransactionid5}, this.getInstance);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        /* access modifiers changed from: protected */
        public final ChallengeParameters configure() {
            getAcsTransactionID sDKVersion = getSDKVersion();
            if (CardinalEnvironment()) {
                return new C1893init((getSDKAppID) null, sDKVersion, CardinalError(), false);
            }
            throw new IllegalStateException("point not in normal form");
        }
    }

    public final getAcsTransactionID getSDKVersion() {
        if (CardinalEnvironment()) {
            return this.configure;
        }
        throw new IllegalStateException("point not in normal form");
    }

    public final boolean CardinalEnvironment() {
        getSDKAppID getsdkappid = this.Cardinal;
        int CardinalActionCode = getsdkappid == null ? 0 : getsdkappid.CardinalActionCode();
        return CardinalActionCode == 0 || CardinalActionCode == 5 || valueOf() || this.cca_continue[0].CardinalError();
    }

    public final ChallengeParameters CardinalRenderType() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID getsdkappid = this.Cardinal;
        int CardinalActionCode = getsdkappid == null ? 0 : getsdkappid.CardinalActionCode();
        if (CardinalActionCode == 0 || CardinalActionCode == 5) {
            return this;
        }
        getAcsTransactionID cca_continue2 = cca_continue(0);
        return cca_continue2.CardinalError() ? this : cca_continue(cca_continue2.getSDKVersion());
    }

    /* access modifiers changed from: package-private */
    public final ChallengeParameters cca_continue(getAcsTransactionID getacstransactionid) {
        getSDKAppID getsdkappid = this.Cardinal;
        int CardinalActionCode = getsdkappid == null ? 0 : getsdkappid.CardinalActionCode();
        if (CardinalActionCode != 1) {
            if (CardinalActionCode == 2 || CardinalActionCode == 3 || CardinalActionCode == 4) {
                getAcsTransactionID configure2 = getacstransactionid.configure();
                return this.Cardinal.configure(this.configure.init(configure2), this.init.init(configure2.init(getacstransactionid)), this.getInstance);
            } else if (CardinalActionCode != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return this.Cardinal.configure(this.configure.init(getacstransactionid), this.init.init(getacstransactionid), this.getInstance);
    }

    /* access modifiers changed from: package-private */
    public final boolean getInstance(final boolean z, final boolean z2) {
        return valueOf() || !((removeParam) this.Cardinal.getInstance(this, "bc_validity", new ConfigParameters() {
            public final KeyAgreementSpi.ECKAEGwithSHA512KDF init(KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
                removeParam removeparam = eCKAEGwithSHA512KDF instanceof removeParam ? (removeParam) eCKAEGwithSHA512KDF : null;
                if (removeparam == null) {
                    removeparam = new removeParam();
                }
                if (removeparam.getInstance()) {
                    return removeparam;
                }
                if (!removeparam.cca_continue()) {
                    if (z || ChallengeParameters.this.Cardinal()) {
                        removeparam.cca_continue = true;
                    } else {
                        removeparam.Cardinal = true;
                        return removeparam;
                    }
                }
                if (z2 && !removeparam.configure()) {
                    if (!ChallengeParameters.this.getInstance()) {
                        removeparam.Cardinal = true;
                        return removeparam;
                    }
                    removeparam.getInstance = true;
                }
                return removeparam;
            }
        })).getInstance();
    }

    public ChallengeParameters getInstance(getAcsTransactionID getacstransactionid) {
        if (valueOf()) {
            return this;
        }
        return this.Cardinal.configure(this.configure.init(getacstransactionid), this.init, this.cca_continue, this.getInstance);
    }

    public ChallengeParameters Cardinal(getAcsTransactionID getacstransactionid) {
        if (valueOf()) {
            return this;
        }
        return this.Cardinal.configure(this.configure, this.init.init(getacstransactionid), this.cca_continue, this.getInstance);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean init(com.cardinalcommerce.p060a.ChallengeParameters r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.cardinalcommerce.a.getSDKAppID r1 = r8.Cardinal
            com.cardinalcommerce.a.getSDKAppID r2 = r9.Cardinal
            r3 = 1
            if (r1 != 0) goto L_0x000d
            r4 = 1
            goto L_0x000e
        L_0x000d:
            r4 = 0
        L_0x000e:
            if (r2 != 0) goto L_0x0012
            r5 = 1
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            boolean r6 = r8.valueOf()
            boolean r7 = r9.valueOf()
            if (r6 != 0) goto L_0x0068
            if (r7 == 0) goto L_0x0020
            goto L_0x0068
        L_0x0020:
            if (r4 == 0) goto L_0x0027
            if (r5 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r1 = r8
            goto L_0x004e
        L_0x0027:
            if (r4 == 0) goto L_0x002e
            com.cardinalcommerce.a.ChallengeParameters r9 = r9.CardinalRenderType()
            goto L_0x0025
        L_0x002e:
            if (r5 == 0) goto L_0x0035
            com.cardinalcommerce.a.ChallengeParameters r1 = r8.CardinalRenderType()
            goto L_0x004e
        L_0x0035:
            boolean r2 = r1.configure((com.cardinalcommerce.p060a.getSDKAppID) r2)
            if (r2 != 0) goto L_0x003c
            return r0
        L_0x003c:
            r2 = 2
            com.cardinalcommerce.a.ChallengeParameters[] r2 = new com.cardinalcommerce.p060a.ChallengeParameters[r2]
            r2[r0] = r8
            com.cardinalcommerce.a.ChallengeParameters r9 = r1.Cardinal(r9)
            r2[r3] = r9
            r1.getInstance(r2)
            r1 = r2[r0]
            r9 = r2[r3]
        L_0x004e:
            com.cardinalcommerce.a.getAcsTransactionID r2 = r1.configure
            com.cardinalcommerce.a.getAcsTransactionID r4 = r9.configure
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0067
            com.cardinalcommerce.a.getAcsTransactionID r1 = r1.CardinalError()
            com.cardinalcommerce.a.getAcsTransactionID r9 = r9.CardinalError()
            boolean r9 = r1.equals(r9)
            if (r9 == 0) goto L_0x0067
            return r3
        L_0x0067:
            return r0
        L_0x0068:
            if (r6 == 0) goto L_0x0077
            if (r7 == 0) goto L_0x0077
            if (r4 != 0) goto L_0x0076
            if (r5 != 0) goto L_0x0076
            boolean r9 = r1.configure((com.cardinalcommerce.p060a.getSDKAppID) r2)
            if (r9 == 0) goto L_0x0077
        L_0x0076:
            return r3
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.ChallengeParameters.init(com.cardinalcommerce.a.ChallengeParameters):boolean");
    }

    public int hashCode() {
        getSDKAppID getsdkappid = this.Cardinal;
        int i = getsdkappid == null ? 0 : ~getsdkappid.hashCode();
        if (valueOf()) {
            return i;
        }
        ChallengeParameters CardinalRenderType = CardinalRenderType();
        return (i ^ (CardinalRenderType.configure.hashCode() * 17)) ^ (CardinalRenderType.CardinalError().hashCode() * 257);
    }

    public String toString() {
        if (valueOf()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(VersionRange.LEFT_OPEN);
        stringBuffer.append(this.configure);
        stringBuffer.append(',');
        stringBuffer.append(this.init);
        for (getAcsTransactionID append : this.cca_continue) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(VersionRange.RIGHT_OPEN);
        return stringBuffer.toString();
    }

    public final byte[] configure(boolean z) {
        if (valueOf()) {
            return new byte[1];
        }
        ChallengeParameters CardinalRenderType = CardinalRenderType();
        byte[] CardinalEnvironment = CardinalRenderType.configure.CardinalEnvironment();
        if (z) {
            byte[] bArr = new byte[(CardinalEnvironment.length + 1)];
            bArr[0] = (byte) (CardinalRenderType.CardinalConfigurationParameters() ? 3 : 2);
            System.arraycopy(CardinalEnvironment, 0, bArr, 1, CardinalEnvironment.length);
            return bArr;
        }
        byte[] CardinalEnvironment2 = CardinalRenderType.CardinalError().CardinalEnvironment();
        byte[] bArr2 = new byte[(CardinalEnvironment.length + CardinalEnvironment2.length + 1)];
        bArr2[0] = 4;
        System.arraycopy(CardinalEnvironment, 0, bArr2, 1, CardinalEnvironment.length);
        System.arraycopy(CardinalEnvironment2, 0, bArr2, CardinalEnvironment.length + 1, CardinalEnvironment2.length);
        return bArr2;
    }

    public final ChallengeParameters configure(BigInteger bigInteger) {
        return this.Cardinal.valueOf().configure(this, bigInteger);
    }
}
