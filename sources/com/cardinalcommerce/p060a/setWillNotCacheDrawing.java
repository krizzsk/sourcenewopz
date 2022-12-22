package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setWillNotCacheDrawing */
public final class setWillNotCacheDrawing extends getThreeDSRequestorAppURL {
    public final DSASigner.stdDSA Cardinal;

    /* renamed from: a */
    private final setProxyAddress f3098a;
    public final int cca_continue;
    public final int configure;

    public setWillNotCacheDrawing(int i, int i2, DSASigner.stdDSA stddsa) {
        this.f3098a = new setProxyAddress(0);
        this.cca_continue = i;
        this.configure = i2;
        this.Cardinal = stddsa;
    }

    public setWillNotCacheDrawing(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.f3098a = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0));
        this.cca_continue = new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1)).Cardinal).intValue();
        this.configure = new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(2)).Cardinal).intValue();
        getProxyAddress Cardinal2 = setthreedsrequestorappurl.Cardinal(3);
        this.Cardinal = Cardinal2 instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) Cardinal2 : Cardinal2 != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null;
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(this.f3098a);
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.cca_continue));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.configure));
        setforegroundtintblendmode.cca_continue.addElement(this.Cardinal);
        return new GOST(setforegroundtintblendmode);
    }
}
