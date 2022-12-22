package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setAllowClickWhenDisabled */
public final class setAllowClickWhenDisabled extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private final byte[] f2665a;

    /* renamed from: b */
    private final byte[] f2666b;

    public setAllowClickWhenDisabled(byte[] bArr, byte[] bArr2) {
        this.f2665a = setForegroundTintBlendMode.cca_continue(bArr);
        this.f2666b = setForegroundTintBlendMode.cca_continue(bArr2);
    }

    public final byte[] cca_continue() {
        return setForegroundTintBlendMode.cca_continue(this.f2666b);
    }

    public final byte[] configure() {
        return setForegroundTintBlendMode.cca_continue(this.f2665a);
    }

    public setAllowClickWhenDisabled(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        if (new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0)).Cardinal).equals(BigInteger.valueOf(0))) {
            this.f2665a = setForegroundTintBlendMode.cca_continue(EdEC.init(setthreedsrequestorappurl.Cardinal(1)).cca_continue());
            this.f2666b = setForegroundTintBlendMode.cca_continue(EdEC.init(setthreedsrequestorappurl.Cardinal(2)).cca_continue());
            return;
        }
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(0));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.f2665a));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.f2666b));
        return new GOST(setforegroundtintblendmode);
    }
}
