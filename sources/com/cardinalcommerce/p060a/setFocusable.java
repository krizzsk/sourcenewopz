package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;

/* renamed from: com.cardinalcommerce.a.setFocusable */
public final class setFocusable extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private setProxyAddress f2776a;

    /* renamed from: b */
    private ASN1ObjectIdentifier f2777b;

    /* renamed from: c */
    private byte[][] f2778c;

    /* renamed from: d */
    private byte[][] f2779d;

    /* renamed from: e */
    private byte[] f2780e;
    public setProxyAddress init;

    public setFocusable(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f2776a = new setProxyAddress(0);
        this.init = new setProxyAddress((long) i);
        this.f2778c = setKeyboardNavigationCluster.configure(sArr);
        this.f2779d = setKeyboardNavigationCluster.configure(sArr2);
        this.f2780e = setKeyboardNavigationCluster.init(sArr3);
    }

    public setFocusable(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        if (setthreedsrequestorappurl.Cardinal(0) instanceof setProxyAddress) {
            this.f2776a = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0));
        } else {
            this.f2777b = ASN1ObjectIdentifier.getInstance(setthreedsrequestorappurl.Cardinal(0));
        }
        this.init = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1));
        setThreeDSRequestorAppURL cca_continue = setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl.Cardinal(2));
        this.f2778c = new byte[cca_continue.getInstance()][];
        for (int i = 0; i < cca_continue.getInstance(); i++) {
            this.f2778c[i] = isEnableDFSync.init(cca_continue.Cardinal(i)).cca_continue();
        }
        setThreeDSRequestorAppURL setthreedsrequestorappurl2 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl.Cardinal(3);
        this.f2779d = new byte[setthreedsrequestorappurl2.getInstance()][];
        for (int i2 = 0; i2 < setthreedsrequestorappurl2.getInstance(); i2++) {
            this.f2779d[i2] = isEnableDFSync.init(setthreedsrequestorappurl2.Cardinal(i2)).cca_continue();
        }
        this.f2780e = isEnableDFSync.init(((setThreeDSRequestorAppURL) setthreedsrequestorappurl.Cardinal(4)).Cardinal(0)).cca_continue();
    }

    public final short[][] configure() {
        return setKeyboardNavigationCluster.Cardinal(this.f2779d);
    }

    public final short[] getInstance() {
        return setKeyboardNavigationCluster.Cardinal(this.f2780e);
    }

    public final short[][] init() {
        return setKeyboardNavigationCluster.Cardinal(this.f2778c);
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setProxyAddress setproxyaddress = this.f2776a;
        if (setproxyaddress != null) {
            setforegroundtintblendmode.cca_continue.addElement(setproxyaddress);
        } else {
            setforegroundtintblendmode.cca_continue.addElement(this.f2777b);
        }
        setforegroundtintblendmode.cca_continue.addElement(this.init);
        setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.f2778c;
            if (i2 >= bArr.length) {
                break;
            }
            setforegroundtintblendmode2.cca_continue.addElement(new EdEC(bArr[i2]));
            i2++;
        }
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
        setForegroundTintBlendMode setforegroundtintblendmode3 = new setForegroundTintBlendMode();
        while (true) {
            byte[][] bArr2 = this.f2779d;
            if (i < bArr2.length) {
                setforegroundtintblendmode3.cca_continue.addElement(new EdEC(bArr2[i]));
                i++;
            } else {
                setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode3));
                setForegroundTintBlendMode setforegroundtintblendmode4 = new setForegroundTintBlendMode();
                setforegroundtintblendmode4.cca_continue.addElement(new EdEC(this.f2780e));
                setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode4));
                return new GOST(setforegroundtintblendmode);
            }
        }
    }
}
