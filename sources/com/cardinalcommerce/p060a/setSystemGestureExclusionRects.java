package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setSystemGestureExclusionRects */
public final class setSystemGestureExclusionRects extends getThreeDSRequestorAppURL {
    public int Cardinal;
    public int cca_continue;
    public byte[] configure;
    public byte[] getInstance;
    public byte[] init;
    public DSASigner.stdDSA values;

    public setSystemGestureExclusionRects(int i, int i2, setBackgroundTintList setbackgroundtintlist, setForegroundTintMode setforegroundtintmode, setForegroundGravity setforegroundgravity, DSASigner.stdDSA stddsa) {
        this.cca_continue = i;
        this.Cardinal = i2;
        this.getInstance = setbackgroundtintlist.getInstance();
        this.init = setforegroundtintmode.cca_continue();
        this.configure = setforegroundgravity.init();
        this.values = stddsa;
    }

    public setSystemGestureExclusionRects(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.cca_continue = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(0)).Cardinal).intValue();
        this.Cardinal = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(1)).Cardinal).intValue();
        this.getInstance = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(2)).cca_continue();
        this.init = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(3)).cca_continue();
        this.configure = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(4)).cca_continue();
        getProxyAddress Cardinal2 = setthreedsrequestorappurl.Cardinal(5);
        this.values = Cardinal2 instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) Cardinal2 : Cardinal2 != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null;
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.cca_continue));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.Cardinal));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.getInstance));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.init));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.configure));
        setforegroundtintblendmode.cca_continue.addElement(this.values);
        return new GOST(setforegroundtintblendmode);
    }
}
