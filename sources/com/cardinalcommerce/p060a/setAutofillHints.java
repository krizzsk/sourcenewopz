package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setAutofillHints */
public final class setAutofillHints extends getThreeDSRequestorAppURL {
    public byte[] Cardinal;
    public byte[] cca_continue;
    public byte[] cleanup;
    public int configure;
    public byte[] getInstance;
    public int init;
    public byte[] values;

    public setAutofillHints(int i, int i2, setBackgroundTintList setbackgroundtintlist, setForegroundTintMode setforegroundtintmode, setForegroundGravity setforegroundgravity, setForegroundGravity setforegroundgravity2, setBackgroundDrawable setbackgrounddrawable) {
        this.configure = i;
        this.init = i2;
        this.cca_continue = setbackgroundtintlist.getInstance();
        this.Cardinal = setforegroundtintmode.cca_continue();
        this.getInstance = setbackgrounddrawable.init();
        this.values = setforegroundgravity.init();
        this.cleanup = setforegroundgravity2.init();
    }

    public setAutofillHints(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.configure = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(0)).Cardinal).intValue();
        this.init = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(1)).Cardinal).intValue();
        this.cca_continue = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(2)).cca_continue();
        this.Cardinal = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(3)).cca_continue();
        this.values = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(4)).cca_continue();
        this.cleanup = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(5)).cca_continue();
        this.getInstance = ((isEnableDFSync) setthreedsrequestorappurl.Cardinal(6)).cca_continue();
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.configure));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.init));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.cca_continue));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.Cardinal));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.values));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.cleanup));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.getInstance));
        return new GOST(setforegroundtintblendmode);
    }
}
