package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setWillNotDraw */
public final class setWillNotDraw extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private final byte[] f3099a;

    /* renamed from: b */
    private final byte[] f3100b;

    public setWillNotDraw(byte[] bArr, byte[] bArr2) {
        this.f3099a = setForegroundTintBlendMode.cca_continue(bArr);
        this.f3100b = setForegroundTintBlendMode.cca_continue(bArr2);
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(0));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.f3099a));
        setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.f3100b));
        return new GOST(setforegroundtintblendmode);
    }
}
