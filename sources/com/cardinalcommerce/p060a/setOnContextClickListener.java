package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.ChallengeParameters;

/* renamed from: com.cardinalcommerce.a.setOnContextClickListener */
public final class setOnContextClickListener extends ChallengeParameters.Cardinal {
    public setOnContextClickListener(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2) {
        this(getsdkappid, getacstransactionid, getacstransactionid2, false);
    }

    public setOnContextClickListener(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2);
        if ((getacstransactionid == null) == (getacstransactionid2 != null ? false : true)) {
            this.getInstance = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    setOnContextClickListener(getSDKAppID getsdkappid, getAcsTransactionID getacstransactionid, getAcsTransactionID getacstransactionid2, getAcsTransactionID[] getacstransactionidArr, boolean z) {
        super(getsdkappid, getacstransactionid, getacstransactionid2, getacstransactionidArr);
        this.getInstance = z;
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
        return new setOnContextClickListener(getsdkappid, getacstransactionid, getacstransactionid2.cca_continue(getacstransactionid3), getacstransactionidArr, this.getInstance);
    }

    public final ChallengeParameters configure() {
        getAcsTransactionID sDKVersion = getSDKVersion();
        if (CardinalEnvironment()) {
            return new setOnContextClickListener((getSDKAppID) null, sDKVersion, CardinalError());
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
            oncontextitemselected2 = (onContextItemSelected) instance3.configure().cca_continue(instance3).cca_continue(oncontextitemselected10).init();
            if (oncontextitemselected2.cleanup()) {
                return new setOnContextClickListener(cca_continue, oncontextitemselected2, setVerticalScrollbarPosition.f3090a, this.getInstance);
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
                return new setOnContextClickListener(cca_continue, oncontextitemselected11, setVerticalScrollbarPosition.f3090a, this.getInstance);
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
        return new setOnContextClickListener(cca_continue, oncontextitemselected2, oncontextitemselected, new getAcsTransactionID[]{oncontextitemselected3}, this.getInstance);
    }

    public final ChallengeParameters getRequestTimeout() {
        long[] jArr;
        if (valueOf()) {
            return this;
        }
        getSDKAppID cca_continue = cca_continue();
        onContextItemSelected oncontextitemselected = (onContextItemSelected) this.configure;
        if (oncontextitemselected.cleanup()) {
            return cca_continue.init();
        }
        onContextItemSelected oncontextitemselected2 = (onContextItemSelected) this.init;
        onContextItemSelected oncontextitemselected3 = (onContextItemSelected) this.cca_continue[0];
        long[] jArr2 = new long[9];
        long[] jArr3 = new long[9];
        long[] instance = oncontextitemselected3.CardinalError() ? null : setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected3.getInstance);
        long[] jArr4 = oncontextitemselected2.getInstance;
        if (instance == null) {
            jArr = oncontextitemselected3.getInstance;
        } else {
            setVerticalScrollbarThumbDrawable.Cardinal(jArr4, instance, jArr2);
            setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected3.getInstance, jArr3);
            jArr4 = jArr2;
            jArr = jArr3;
        }
        long[] jArr5 = new long[9];
        setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected2.getInstance, jArr5);
        setVerticalScrollbarThumbDrawable.init(jArr4, jArr, jArr5);
        if (setNextFocusForwardId.init(jArr5)) {
            return new setOnContextClickListener(cca_continue, new onContextItemSelected(jArr5), setVerticalScrollbarPosition.f3090a, this.getInstance);
        }
        long[] jArr6 = new long[18];
        setVerticalScrollbarThumbDrawable.getInstance(jArr5, jArr4, jArr6);
        onContextItemSelected oncontextitemselected4 = new onContextItemSelected(jArr2);
        setVerticalScrollbarThumbDrawable.getInstance(jArr5, oncontextitemselected4.getInstance);
        onContextItemSelected oncontextitemselected5 = new onContextItemSelected(jArr5);
        if (instance != null) {
            setVerticalScrollbarThumbDrawable.configure(oncontextitemselected5.getInstance, jArr, oncontextitemselected5.getInstance);
        }
        long[] jArr7 = oncontextitemselected.getInstance;
        if (instance != null) {
            setVerticalScrollbarThumbDrawable.Cardinal(jArr7, instance, jArr3);
            jArr7 = jArr3;
        }
        setVerticalScrollbarThumbDrawable.getSDKVersion(jArr7, jArr6);
        setVerticalScrollbarThumbDrawable.cca_continue(jArr6, jArr3);
        setVerticalScrollbarThumbDrawable.init(oncontextitemselected4.getInstance, oncontextitemselected5.getInstance, jArr3);
        return new setOnContextClickListener(cca_continue, oncontextitemselected4, new onContextItemSelected(jArr3), new getAcsTransactionID[]{oncontextitemselected5}, this.getInstance);
    }

    public final ChallengeParameters Cardinal(ChallengeParameters challengeParameters) {
        if (valueOf()) {
            return challengeParameters;
        }
        if (challengeParameters.valueOf()) {
            return getRequestTimeout();
        }
        getSDKAppID cca_continue = cca_continue();
        onContextItemSelected oncontextitemselected = (onContextItemSelected) this.configure;
        if (oncontextitemselected.cleanup()) {
            return challengeParameters;
        }
        onContextItemSelected oncontextitemselected2 = (onContextItemSelected) challengeParameters.getWarnings();
        onContextItemSelected oncontextitemselected3 = (onContextItemSelected) challengeParameters.cca_continue(0);
        if (oncontextitemselected2.cleanup() || !oncontextitemselected3.CardinalError()) {
            return getRequestTimeout().getInstance(challengeParameters);
        }
        onContextItemSelected oncontextitemselected4 = (onContextItemSelected) this.init;
        onContextItemSelected oncontextitemselected5 = (onContextItemSelected) this.cca_continue[0];
        onContextItemSelected oncontextitemselected6 = (onContextItemSelected) challengeParameters.CardinalActionCode();
        long[] jArr = new long[9];
        long[] jArr2 = new long[9];
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected.getInstance, jArr);
        setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected4.getInstance, jArr2);
        setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected5.getInstance, jArr3);
        setVerticalScrollbarThumbDrawable.configure(oncontextitemselected4.getInstance, oncontextitemselected5.getInstance, jArr4);
        setVerticalScrollbarThumbDrawable.init(jArr3, jArr2, jArr4);
        long[] instance = setVerticalScrollbarThumbDrawable.getInstance(jArr3);
        setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected6.getInstance, instance, jArr3);
        setVerticalScrollbarThumbDrawable.cca_continue(jArr3, jArr2, jArr3);
        long[] jArr5 = new long[18];
        setVerticalScrollbarThumbDrawable.getInstance(jArr3, jArr4, jArr5);
        setVerticalScrollbarThumbDrawable.values(jArr, instance, jArr5);
        setVerticalScrollbarThumbDrawable.cca_continue(jArr5, jArr3);
        setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected2.getInstance, instance, jArr);
        setVerticalScrollbarThumbDrawable.cca_continue(jArr, jArr4, jArr2);
        setVerticalScrollbarThumbDrawable.getInstance(jArr2, jArr2);
        if (setNextFocusForwardId.init(jArr2)) {
            return setNextFocusForwardId.init(jArr3) ? challengeParameters.getRequestTimeout() : cca_continue.init();
        }
        if (setNextFocusForwardId.init(jArr3)) {
            return new setOnContextClickListener(cca_continue, new onContextItemSelected(jArr3), setVerticalScrollbarPosition.f3090a, this.getInstance);
        }
        onContextItemSelected oncontextitemselected7 = new onContextItemSelected();
        setVerticalScrollbarThumbDrawable.getInstance(jArr3, oncontextitemselected7.getInstance);
        setVerticalScrollbarThumbDrawable.configure(oncontextitemselected7.getInstance, jArr, oncontextitemselected7.getInstance);
        onContextItemSelected oncontextitemselected8 = new onContextItemSelected(jArr);
        setVerticalScrollbarThumbDrawable.configure(jArr3, jArr2, oncontextitemselected8.getInstance);
        setVerticalScrollbarThumbDrawable.Cardinal(oncontextitemselected8.getInstance, instance, oncontextitemselected8.getInstance);
        onContextItemSelected oncontextitemselected9 = new onContextItemSelected(jArr2);
        setVerticalScrollbarThumbDrawable.cca_continue(jArr3, jArr2, oncontextitemselected9.getInstance);
        setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected9.getInstance, oncontextitemselected9.getInstance);
        for (int i = 0; i < 18; i++) {
            jArr5[i] = 0;
        }
        setVerticalScrollbarThumbDrawable.getInstance(oncontextitemselected9.getInstance, jArr4, jArr5);
        setVerticalScrollbarThumbDrawable.configure(oncontextitemselected6.getInstance, jArr4);
        setVerticalScrollbarThumbDrawable.getInstance(jArr4, oncontextitemselected8.getInstance, jArr5);
        setVerticalScrollbarThumbDrawable.cca_continue(jArr5, oncontextitemselected9.getInstance);
        return new setOnContextClickListener(cca_continue, oncontextitemselected7, oncontextitemselected9, new getAcsTransactionID[]{oncontextitemselected8}, this.getInstance);
    }
}
