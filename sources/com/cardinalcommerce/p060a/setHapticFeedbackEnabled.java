package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setHapticFeedbackEnabled */
public final class setHapticFeedbackEnabled extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private final byte[] f2788a;

    /* renamed from: b */
    private final byte[] f2789b;

    /* renamed from: c */
    private final byte[] f2790c;

    /* renamed from: d */
    private final byte[] f2791d;

    /* renamed from: e */
    private final byte[] f2792e;
    public final int init;

    public setHapticFeedbackEnabled(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.init = i;
        this.f2788a = setForegroundTintBlendMode.cca_continue(bArr);
        this.f2789b = setForegroundTintBlendMode.cca_continue(bArr2);
        this.f2790c = setForegroundTintBlendMode.cca_continue(bArr3);
        this.f2791d = setForegroundTintBlendMode.cca_continue(bArr4);
        this.f2792e = setForegroundTintBlendMode.cca_continue(bArr5);
    }

    public final byte[] Cardinal() {
        return setForegroundTintBlendMode.cca_continue(this.f2791d);
    }

    public final byte[] cca_continue() {
        return setForegroundTintBlendMode.cca_continue(this.f2792e);
    }

    public final byte[] configure() {
        return setForegroundTintBlendMode.cca_continue(this.f2790c);
    }

    public final byte[] getInstance() {
        return setForegroundTintBlendMode.cca_continue(this.f2789b);
    }

    public final byte[] init() {
        return setForegroundTintBlendMode.cca_continue(this.f2788a);
    }

    public setHapticFeedbackEnabled(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        if (!new BigInteger(setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0)).Cardinal).equals(BigInteger.valueOf(0))) {
            throw new IllegalArgumentException("unknown version of sequence");
        } else if (setthreedsrequestorappurl.getInstance() == 2 || setthreedsrequestorappurl.getInstance() == 3) {
            setThreeDSRequestorAppURL cca_continue = setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl.Cardinal(1));
            this.init = new BigInteger(setProxyAddress.Cardinal((Object) cca_continue.Cardinal(0)).Cardinal).intValue();
            this.f2788a = setForegroundTintBlendMode.cca_continue(EdEC.init(cca_continue.Cardinal(1)).cca_continue());
            this.f2789b = setForegroundTintBlendMode.cca_continue(EdEC.init(cca_continue.Cardinal(2)).cca_continue());
            this.f2790c = setForegroundTintBlendMode.cca_continue(EdEC.init(cca_continue.Cardinal(3)).cca_continue());
            this.f2791d = setForegroundTintBlendMode.cca_continue(EdEC.init(cca_continue.Cardinal(4)).cca_continue());
            if (setthreedsrequestorappurl.getInstance() == 3) {
                this.f2792e = setForegroundTintBlendMode.cca_continue(EdEC.getInstance(getType.cca_continue((Object) setthreedsrequestorappurl.Cardinal(2)), true).cca_continue());
            } else {
                this.f2792e = null;
            }
        } else {
            throw new IllegalArgumentException("key sequence wrong size");
        }
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(0));
        setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
        setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) this.init));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2788a));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2789b));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2790c));
        setforegroundtintblendmode2.cca_continue.addElement(new EdEC(this.f2791d));
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
        setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 0, new EdEC(this.f2792e)));
        return new GOST(setforegroundtintblendmode);
    }
}
