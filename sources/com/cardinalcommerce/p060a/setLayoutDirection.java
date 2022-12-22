package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setLayoutDirection */
public final class setLayoutDirection extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private final int f2847a;

    /* renamed from: b */
    private final byte[] f2848b;

    /* renamed from: c */
    private final byte[] f2849c;

    /* renamed from: d */
    private final byte[] f2850d;

    /* renamed from: e */
    private final byte[] f2851e;

    /* renamed from: f */
    private final byte[] f2852f;

    public setLayoutDirection(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f2847a = i;
        this.f2848b = setForegroundTintBlendMode.cca_continue(bArr);
        this.f2849c = setForegroundTintBlendMode.cca_continue(bArr2);
        this.f2850d = setForegroundTintBlendMode.cca_continue(bArr3);
        this.f2851e = setForegroundTintBlendMode.cca_continue(bArr4);
        this.f2852f = setForegroundTintBlendMode.cca_continue(bArr5);
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(0));
        setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
        setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) this.f2847a));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2848b));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2849c));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2850d));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2851e));
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
        setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 0, new EdEC(this.f2852f)));
        return new GOST(setforegroundtintblendmode);
    }
}
