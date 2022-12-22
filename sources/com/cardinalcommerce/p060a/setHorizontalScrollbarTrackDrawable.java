package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setHorizontalScrollbarTrackDrawable */
public final class setHorizontalScrollbarTrackDrawable extends ChallengeParameters.Cardinal {
    public setHorizontalScrollbarTrackDrawable(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setHorizontalScrollbarTrackDrawable(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setHorizontalScrollbarTrackDrawable(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
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
        getAcsTransactionID cca_continue3 = configure2.cca_continue(getacstransactionid2.init(getacstransactionid3));
        getAcsTransactionID init = CardinalActionCode.init();
        getAcsTransactionID Cardinal = init.init(configure3).cca_continue(configure2).Cardinal(cca_continue3, configure, configure3);
        getAcsTransactionID init2 = warnings.init(configure3);
        getAcsTransactionID configure4 = init2.cca_continue(cca_continue3).configure();
        if (configure4.cleanup()) {
            return Cardinal.cleanup() ? challengeParameters.getRequestTimeout() : cca_continue.init();
        }
        if (Cardinal.cleanup()) {
            return new setHorizontalScrollbarTrackDrawable(cca_continue, Cardinal, cca_continue.getWarnings(), this.getInstance);
        }
        getAcsTransactionID init3 = Cardinal.configure().init(init2);
        getAcsTransactionID init4 = Cardinal.init(configure4).init(configure3);
        return new setHorizontalScrollbarTrackDrawable(cca_continue, init3, Cardinal.cca_continue(configure4).configure().Cardinal(cca_continue3, init, init4), new getAcsTransactionID[]{init4}, this.getInstance);
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
        getAcsTransactionID configure = CardinalError ? getacstransactionid3 : getacstransactionid3.configure();
        getAcsTransactionID cca_continue2 = CardinalError ? getacstransactionid2.configure().cca_continue(getacstransactionid2) : getacstransactionid2.cca_continue(getacstransactionid3).init(getacstransactionid2);
        if (cca_continue2.cleanup()) {
            return new setHorizontalScrollbarTrackDrawable(cca_continue, cca_continue2, cca_continue.getWarnings(), this.getInstance);
        }
        getAcsTransactionID configure2 = cca_continue2.configure();
        getAcsTransactionID init = CardinalError ? cca_continue2 : cca_continue2.init(configure);
        getAcsTransactionID configure3 = getacstransactionid2.cca_continue(getacstransactionid).configure();
        if (!CardinalError) {
            getacstransactionid3 = configure.configure();
        }
        return new setHorizontalScrollbarTrackDrawable(cca_continue, configure2, configure3.cca_continue(cca_continue2).cca_continue(configure).init(configure3).cca_continue(getacstransactionid3).cca_continue(configure2).cca_continue(init), new getAcsTransactionID[]{init}, this.getInstance);
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
        return new setHorizontalScrollbarTrackDrawable(getsdkappid, getacstransactionid, getacstransactionid2.cca_continue(getacstransactionid3), getacstransactionidArr, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setHorizontalScrollbarTrackDrawable((getSDKAppID) null, sDKVersion, CardinalError());
        }
        throw new IllegalStateException("point not in normal form");
    }

    public final ChallengeParameters getInstance(ChallengeParameters challengeParameters) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        onContextItemSelected oncontextitemselected;
        onContextItemSelected oncontextitemselected2;
        onContextItemSelected oncontextitemselected3;
        ChallengeParameters challengeParameters2 = challengeParameters;
        if (valueOf()) {
            return challengeParameters2;
        }
        if (challengeParameters.valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        onContextItemSelected oncontextitemselected4 = (onContextItemSelected) this.configure;
        onContextItemSelected oncontextitemselected5 = (onContextItemSelected) challengeParameters.getWarnings();
        if (oncontextitemselected4.cleanup()) {
            return oncontextitemselected5.cleanup() ? cca_continue.init() : challengeParameters2.getInstance((ChallengeParameters) this);
        }
        onContextItemSelected oncontextitemselected6 = (onContextItemSelected) this.init;
        onContextItemSelected oncontextitemselected7 = (onContextItemSelected) this.cca_continue[0];
        onContextItemSelected oncontextitemselected8 = (onContextItemSelected) challengeParameters.CardinalActionCode();
        onContextItemSelected oncontextitemselected9 = (onContextItemSelected) challengeParameters2.cca_continue(0);
        long[] jArr4 = new long[9];
        long[] jArr5 = new long[9];
        long[] jArr6 = new long[9];
        long[] jArr7 = new long[9];
        long[] instance = oncontextitemselected7.CardinalError() ? null : setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected7.getInstance);
        if (instance == null) {
            jArr = oncontextitemselected5.getInstance;
            jArr2 = oncontextitemselected8.getInstance;
        } else {
            setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected5.getInstance, instance, jArr5);
            setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected8.getInstance, instance, jArr7);
            jArr2 = jArr7;
            jArr = jArr5;
        }
        long[] instance2 = oncontextitemselected9.CardinalError() ? null : setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected9.getInstance);
        long[] jArr8 = oncontextitemselected4.getInstance;
        if (instance2 == null) {
            jArr3 = oncontextitemselected6.getInstance;
        } else {
            setVerticalScrollbarThumbDrawable.Cardinal(jArr8, instance2, jArr4);
            setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected6.getInstance, instance2, jArr6);
            jArr8 = jArr4;
            jArr3 = jArr6;
        }
        setVerticalScrollbarThumbDrawable.cca_continue(jArr3, jArr2, jArr6);
        setVerticalScrollbarThumbDrawable.cca_continue(jArr8, jArr, jArr7);
        if (setNextFocusForwardId.init(jArr7)) {
            return setNextFocusForwardId.init(jArr6) ? getRequestTimeout() : cca_continue.init();
        }
        if (oncontextitemselected5.cleanup()) {
            ChallengeParameters CardinalRenderType = CardinalRenderType();
            onContextItemSelected oncontextitemselected10 = (onContextItemSelected) CardinalRenderType.values();
            getAcsTransactionID CardinalError = CardinalRenderType.CardinalError();
            getAcsTransactionID instance3 = CardinalError.cca_continue(oncontextitemselected8).getInstance((getAcsTransactionID) oncontextitemselected10);
            oncontextitemselected2 = (onContextItemSelected) instance3.configure().cca_continue(instance3).cca_continue(oncontextitemselected10);
            if (oncontextitemselected2.cleanup()) {
                return new setHorizontalScrollbarTrackDrawable(cca_continue, oncontextitemselected2, cca_continue.getWarnings(), this.getInstance);
            }
            oncontextitemselected3 = (onContextItemSelected) cca_continue.configure(getSDKReferenceNumber.values);
            oncontextitemselected = (onContextItemSelected) instance3.init(oncontextitemselected10.cca_continue(oncontextitemselected2)).cca_continue(oncontextitemselected2).cca_continue(CardinalError).getInstance((getAcsTransactionID) oncontextitemselected2).cca_continue(oncontextitemselected2);
        } else {
            setVerticalScrollbarThumbDrawable.getInstance(jArr7, jArr7);
            long[] instance4 = setVerticalScrollbarThumbDrawable.getInstance(jArr6);
            setVerticalScrollbarThumbDrawable.Cardinal(jArr8, instance4, jArr4);
            setVerticalScrollbarThumbDrawable.Cardinal(jArr, instance4, jArr5);
            onContextItemSelected oncontextitemselected11 = new onContextItemSelected(jArr4);
            setVerticalScrollbarThumbDrawable.configure(jArr4, jArr5, oncontextitemselected11.getInstance);
            if (oncontextitemselected11.cleanup()) {
                return new setHorizontalScrollbarTrackDrawable(cca_continue, oncontextitemselected11, cca_continue.getWarnings(), this.getInstance);
            }
            onContextItemSelected oncontextitemselected12 = new onContextItemSelected(jArr6);
            setVerticalScrollbarThumbDrawable.Cardinal(jArr7, instance4, oncontextitemselected12.getInstance);
            if (instance2 != null) {
                setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected12.getInstance, instance2, oncontextitemselected12.getInstance);
            }
            long[] jArr9 = new long[18];
            setVerticalScrollbarThumbDrawable.cca_continue(jArr5, jArr7, jArr7);
            setVerticalScrollbarThumbDrawable.getSDKVersion(jArr7, jArr9);
            setVerticalScrollbarThumbDrawable.cca_continue(oncontextitemselected6.getInstance, oncontextitemselected7.getInstance, jArr7);
            setVerticalScrollbarThumbDrawable.getInstance(jArr7, oncontextitemselected12.getInstance, jArr9);
            onContextItemSelected oncontextitemselected13 = new onContextItemSelected(jArr7);
            setVerticalScrollbarThumbDrawable.cca_continue(jArr9, oncontextitemselected13.getInstance);
            if (instance != null) {
                setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected12.getInstance, instance, oncontextitemselected12.getInstance);
            }
            oncontextitemselected2 = oncontextitemselected11;
            oncontextitemselected = oncontextitemselected13;
            oncontextitemselected3 = oncontextitemselected12;
        }
        return new setHorizontalScrollbarTrackDrawable(cca_continue, oncontextitemselected2, oncontextitemselected, new getAcsTransactionID[]{oncontextitemselected3}, this.getInstance);
    }
}
