package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setHasTransientState */
public final class setHasTransientState extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private final setProxyAddress f2793a;
    public final int configure;
    public final DSASigner.stdDSA getInstance;

    public setHasTransientState(int i, DSASigner.stdDSA stddsa) {
        this.f2793a = new setProxyAddress(0);
        this.configure = i;
        this.getInstance = stddsa;
    }

    public setHasTransientState(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.f2793a = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0));
        this.configure = new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1)).Cardinal).intValue();
        getProxyAddress Cardinal = setthreedsrequestorappurl.Cardinal(2);
        this.getInstance = Cardinal instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) Cardinal : Cardinal != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal)) : null;
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(this.f2793a);
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.configure));
        setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
        return new GOST(setforegroundtintblendmode);
    }
}
