package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.getHeadingTextColor */
public final class getHeadingTextColor extends ChallengeParameters.Cardinal {
    public getHeadingTextColor(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public getHeadingTextColor(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    getHeadingTextColor(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
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
        getAcsTransactionID warnings = challengeParameters.getWarnings();
        getAcsTransactionID cca_continue2 = challengeParameters.cca_continue(0);
        if (warnings.cleanup() || !cca_continue2.CardinalError()) {
            return getRequestTimeout().getInstance(challengeParameters);
        }
        getAcsTransactionID getacstransactionid2 = this.init;
        getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
        getAcsTransactionID CardinalActionCode = challengeParameters.CardinalActionCode();
        getAcsTransactionID configure = getacstransactionid.configure();
        getAcsTransactionID configure2 = getacstransactionid2.configure();
        getAcsTransactionID configure3 = getacstransactionid3.configure();
        getAcsTransactionID cca_continue3 = configure3.cca_continue(configure2).cca_continue(getacstransactionid2.init(getacstransactionid3));
        getAcsTransactionID Cardinal = CardinalActionCode.init(configure3).cca_continue(configure2).Cardinal(cca_continue3, configure, configure3);
        getAcsTransactionID init = warnings.init(configure3);
        getAcsTransactionID configure4 = init.cca_continue(cca_continue3).configure();
        if (configure4.cleanup()) {
            return Cardinal.cleanup() ? challengeParameters.getRequestTimeout() : cca_continue.init();
        }
        if (Cardinal.cleanup()) {
            return new getHeadingTextColor(cca_continue, Cardinal, cca_continue.getWarnings().values(), this.getInstance);
        }
        getAcsTransactionID init2 = Cardinal.configure().init(init);
        getAcsTransactionID init3 = Cardinal.init(configure4).init(configure3);
        return new getHeadingTextColor(cca_continue, init2, Cardinal.cca_continue(configure4).configure().Cardinal(cca_continue3, CardinalActionCode.init(), init3), new getAcsTransactionID[]{init3}, this.getInstance);
    }

    public final boolean CardinalConfigurationParameters() {
        getAcsTransactionID warnings = getWarnings();
        return !warnings.cleanup() && CardinalActionCode().CardinalActionCode() != warnings.CardinalActionCode();
    }

    public final getAcsTransactionID CardinalError() {
        getAcsTransactionID getacstransactionid = this.configure;
        getAcsTransactionID getacstransactionid2 = this.init;
        if (valueOf() || getacstransactionid.cleanup()) {
            return getacstransactionid2;
        }
        getAcsTransactionID init = getacstransactionid2.cca_continue(getacstransactionid).init(getacstransactionid);
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
        if (valueOf()) {
            return challengeParameters;
        }
        if (challengeParameters.valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        getAcsTransactionID getacstransactionid7 = this.configure;
        getAcsTransactionID warnings = challengeParameters.getWarnings();
        if (getacstransactionid7.cleanup()) {
            return warnings.cleanup() ? cca_continue.init() : challengeParameters.getInstance((ChallengeParameters) this);
        }
        getAcsTransactionID getacstransactionid8 = this.init;
        getAcsTransactionID getacstransactionid9 = this.cca_continue[0];
        getAcsTransactionID CardinalActionCode = challengeParameters.CardinalActionCode();
        getAcsTransactionID cca_continue2 = challengeParameters.cca_continue(0);
        boolean CardinalError = getacstransactionid9.CardinalError();
        if (!CardinalError) {
            getacstransactionid2 = warnings.init(getacstransactionid9);
            getacstransactionid = CardinalActionCode.init(getacstransactionid9);
        } else {
            getacstransactionid2 = warnings;
            getacstransactionid = CardinalActionCode;
        }
        boolean CardinalError2 = cca_continue2.CardinalError();
        if (!CardinalError2) {
            getacstransactionid7 = getacstransactionid7.init(cca_continue2);
            getacstransactionid3 = getacstransactionid8.init(cca_continue2);
        } else {
            getacstransactionid3 = getacstransactionid8;
        }
        getAcsTransactionID cca_continue3 = getacstransactionid3.cca_continue(getacstransactionid);
        getAcsTransactionID cca_continue4 = getacstransactionid7.cca_continue(getacstransactionid2);
        if (cca_continue4.cleanup()) {
            return cca_continue3.cleanup() ? getRequestTimeout() : cca_continue.init();
        }
        if (warnings.cleanup()) {
            ChallengeParameters CardinalRenderType = CardinalRenderType();
            getAcsTransactionID values = CardinalRenderType.values();
            getAcsTransactionID CardinalError3 = CardinalRenderType.CardinalError();
            getAcsTransactionID instance = CardinalError3.cca_continue(CardinalActionCode).getInstance(values);
            getacstransactionid5 = instance.configure().cca_continue(instance).cca_continue(values).init();
            if (getacstransactionid5.cleanup()) {
                return new getHeadingTextColor(cca_continue, getacstransactionid5, cca_continue.getWarnings().values(), this.getInstance);
            }
            getAcsTransactionID cca_continue5 = instance.init(values.cca_continue(getacstransactionid5)).cca_continue(getacstransactionid5).cca_continue(CardinalError3).getInstance(getacstransactionid5).cca_continue(getacstransactionid5);
            getacstransactionid6 = cca_continue.configure(getSDKReferenceNumber.values);
            getacstransactionid4 = cca_continue5;
        } else {
            getAcsTransactionID configure = cca_continue4.configure();
            getAcsTransactionID init = cca_continue3.init(getacstransactionid7);
            getAcsTransactionID init2 = cca_continue3.init(getacstransactionid2);
            getAcsTransactionID init3 = init.init(init2);
            if (init3.cleanup()) {
                return new getHeadingTextColor(cca_continue, init3, cca_continue.getWarnings().values(), this.getInstance);
            }
            getAcsTransactionID init4 = cca_continue3.init(configure);
            getAcsTransactionID init5 = !CardinalError2 ? init4.init(cca_continue2) : init4;
            getAcsTransactionID cca_continue6 = init2.cca_continue(configure).cca_continue(init5, getacstransactionid8.cca_continue(getacstransactionid9));
            if (!CardinalError) {
                init5 = init5.init(getacstransactionid9);
            }
            getacstransactionid5 = init3;
            getacstransactionid4 = cca_continue6;
            getacstransactionid6 = init5;
        }
        return new getHeadingTextColor(cca_continue, getacstransactionid5, getacstransactionid4, new getAcsTransactionID[]{getacstransactionid6}, this.getInstance);
    }

    public final ChallengeParameters getRequestTimeout() {
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        getAcsTransactionID getacstransactionid = this.configure;
        if (getacstransactionid.cleanup()) {
            return cca_continue.init();
        }
        getAcsTransactionID getacstransactionid2 = this.init;
        getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
        boolean CardinalError = getacstransactionid3.CardinalError();
        getAcsTransactionID init = CardinalError ? getacstransactionid2 : getacstransactionid2.init(getacstransactionid3);
        getAcsTransactionID configure = CardinalError ? getacstransactionid3 : getacstransactionid3.configure();
        getAcsTransactionID cca_continue2 = getacstransactionid2.configure().cca_continue(init).cca_continue(configure);
        if (cca_continue2.cleanup()) {
            return new getHeadingTextColor(cca_continue, cca_continue2, cca_continue.getWarnings().values(), this.getInstance);
        }
        getAcsTransactionID configure2 = cca_continue2.configure();
        getAcsTransactionID init2 = CardinalError ? cca_continue2 : cca_continue2.init(configure);
        if (!CardinalError) {
            getacstransactionid = getacstransactionid.init(getacstransactionid3);
        }
        return new getHeadingTextColor(cca_continue, configure2, getacstransactionid.cca_continue(cca_continue2, init).cca_continue(configure2).cca_continue(init2), new getAcsTransactionID[]{init2}, this.getInstance);
    }

    public final ChallengeParameters getString() {
        if (valueOf()) {
            return this;
        }
        getAcsTransactionID getacstransactionid = this.configure;
        if (getacstransactionid.cleanup()) {
            return this;
        }
        getAcsTransactionID getacstransactionid2 = this.init;
        getAcsTransactionID getacstransactionid3 = this.cca_continue[0];
        getSDKAppID getsdkappid = this.Cardinal;
        getAcsTransactionID[] getacstransactionidArr = {getacstransactionid3};
        return new getHeadingTextColor(getsdkappid, getacstransactionid, getacstransactionid2.cca_continue(getacstransactionid3), getacstransactionidArr, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new getHeadingTextColor((getSDKAppID) null, sDKVersion, CardinalError());
        }
        throw new IllegalStateException("point not in normal form");
    }
}
