package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;

/* renamed from: com.cardinalcommerce.a.setFitsSystemWindows */
public final class setFitsSystemWindows extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private setProxyAddress f2769a;

    /* renamed from: b */
    private ASN1ObjectIdentifier f2770b;

    /* renamed from: c */
    private byte[][] f2771c;
    public setDefaultFocusHighlightEnabled[] configure;

    /* renamed from: d */
    private byte[] f2772d;

    /* renamed from: e */
    private byte[][] f2773e;

    /* renamed from: f */
    private byte[] f2774f;

    /* renamed from: g */
    private byte[] f2775g;

    public setFitsSystemWindows(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        setThreeDSRequestorAppURL setthreedsrequestorappurl2 = setthreedsrequestorappurl;
        int i = 0;
        if (setthreedsrequestorappurl2.Cardinal(0) instanceof setProxyAddress) {
            this.f2769a = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl2.Cardinal(0));
        } else {
            this.f2770b = ASN1ObjectIdentifier.getInstance(setthreedsrequestorappurl2.Cardinal(0));
        }
        setThreeDSRequestorAppURL setthreedsrequestorappurl3 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl2.Cardinal(1);
        this.f2771c = new byte[setthreedsrequestorappurl3.getInstance()][];
        for (int i2 = 0; i2 < setthreedsrequestorappurl3.getInstance(); i2++) {
            this.f2771c[i2] = ((isEnableDFSync) setthreedsrequestorappurl3.Cardinal(i2)).cca_continue();
        }
        this.f2772d = ((isEnableDFSync) ((setThreeDSRequestorAppURL) setthreedsrequestorappurl2.Cardinal(2)).Cardinal(0)).cca_continue();
        setThreeDSRequestorAppURL setthreedsrequestorappurl4 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl2.Cardinal(3);
        this.f2773e = new byte[setthreedsrequestorappurl4.getInstance()][];
        for (int i3 = 0; i3 < setthreedsrequestorappurl4.getInstance(); i3++) {
            this.f2773e[i3] = ((isEnableDFSync) setthreedsrequestorappurl4.Cardinal(i3)).cca_continue();
        }
        this.f2774f = ((isEnableDFSync) ((setThreeDSRequestorAppURL) setthreedsrequestorappurl2.Cardinal(4)).Cardinal(0)).cca_continue();
        this.f2775g = ((isEnableDFSync) ((setThreeDSRequestorAppURL) setthreedsrequestorappurl2.Cardinal(5)).Cardinal(0)).cca_continue();
        setThreeDSRequestorAppURL setthreedsrequestorappurl5 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl2.Cardinal(6);
        byte[][][][] bArr = new byte[setthreedsrequestorappurl5.getInstance()][][][];
        byte[][][][] bArr2 = new byte[setthreedsrequestorappurl5.getInstance()][][][];
        byte[][][] bArr3 = new byte[setthreedsrequestorappurl5.getInstance()][][];
        byte[][] bArr4 = new byte[setthreedsrequestorappurl5.getInstance()][];
        int i4 = 0;
        while (i4 < setthreedsrequestorappurl5.getInstance()) {
            setThreeDSRequestorAppURL setthreedsrequestorappurl6 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl5.Cardinal(i4);
            setThreeDSRequestorAppURL setthreedsrequestorappurl7 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl6.Cardinal(i);
            bArr[i4] = new byte[setthreedsrequestorappurl7.getInstance()][][];
            for (int i5 = 0; i5 < setthreedsrequestorappurl7.getInstance(); i5++) {
                setThreeDSRequestorAppURL setthreedsrequestorappurl8 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl7.Cardinal(i5);
                bArr[i4][i5] = new byte[setthreedsrequestorappurl8.getInstance()][];
                for (int i6 = 0; i6 < setthreedsrequestorappurl8.getInstance(); i6++) {
                    bArr[i4][i5][i6] = ((isEnableDFSync) setthreedsrequestorappurl8.Cardinal(i6)).cca_continue();
                }
            }
            setThreeDSRequestorAppURL setthreedsrequestorappurl9 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl6.Cardinal(1);
            bArr2[i4] = new byte[setthreedsrequestorappurl9.getInstance()][][];
            for (int i7 = 0; i7 < setthreedsrequestorappurl9.getInstance(); i7++) {
                setThreeDSRequestorAppURL setthreedsrequestorappurl10 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl9.Cardinal(i7);
                bArr2[i4][i7] = new byte[setthreedsrequestorappurl10.getInstance()][];
                for (int i8 = 0; i8 < setthreedsrequestorappurl10.getInstance(); i8++) {
                    bArr2[i4][i7][i8] = ((isEnableDFSync) setthreedsrequestorappurl10.Cardinal(i8)).cca_continue();
                }
            }
            setThreeDSRequestorAppURL setthreedsrequestorappurl11 = (setThreeDSRequestorAppURL) setthreedsrequestorappurl6.Cardinal(2);
            bArr3[i4] = new byte[setthreedsrequestorappurl11.getInstance()][];
            for (int i9 = 0; i9 < setthreedsrequestorappurl11.getInstance(); i9++) {
                bArr3[i4][i9] = ((isEnableDFSync) setthreedsrequestorappurl11.Cardinal(i9)).cca_continue();
            }
            bArr4[i4] = ((isEnableDFSync) setthreedsrequestorappurl6.Cardinal(3)).cca_continue();
            i4++;
            i = 0;
        }
        int length = this.f2775g.length - 1;
        this.configure = new setDefaultFocusHighlightEnabled[length];
        int i10 = 0;
        while (i10 < length) {
            byte[] bArr5 = this.f2775g;
            int i11 = i10 + 1;
            this.configure[i10] = new setDefaultFocusHighlightEnabled(bArr5[i10], bArr5[i11], setKeyboardNavigationCluster.getInstance(bArr[i10]), setKeyboardNavigationCluster.getInstance(bArr2[i10]), setKeyboardNavigationCluster.Cardinal(bArr3[i10]), setKeyboardNavigationCluster.Cardinal(bArr4[i10]));
            i10 = i11;
        }
    }

    public setFitsSystemWindows(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, setDefaultFocusHighlightEnabled[] setdefaultfocushighlightenabledArr) {
        this.f2769a = new setProxyAddress(1);
        this.f2771c = setKeyboardNavigationCluster.configure(sArr);
        this.f2772d = setKeyboardNavigationCluster.init(sArr2);
        this.f2773e = setKeyboardNavigationCluster.configure(sArr3);
        this.f2774f = setKeyboardNavigationCluster.init(sArr4);
        this.f2775g = setKeyboardNavigationCluster.Cardinal(iArr);
        this.configure = setdefaultfocushighlightenabledArr;
    }

    public final short[][] Cardinal() {
        return setKeyboardNavigationCluster.Cardinal(this.f2771c);
    }

    public final short[][] configure() {
        return setKeyboardNavigationCluster.Cardinal(this.f2773e);
    }

    public final short[] getInstance() {
        return setKeyboardNavigationCluster.Cardinal(this.f2772d);
    }

    public final short[] init() {
        return setKeyboardNavigationCluster.Cardinal(this.f2774f);
    }

    public final int[] cca_continue() {
        byte[] bArr = this.f2775g;
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setProxyAddress setproxyaddress = this.f2769a;
        if (setproxyaddress != null) {
            setforegroundtintblendmode.cca_continue.addElement(setproxyaddress);
        } else {
            setforegroundtintblendmode.cca_continue.addElement(this.f2770b);
        }
        setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
        int i = 0;
        while (true) {
            byte[][] bArr = this.f2771c;
            if (i >= bArr.length) {
                break;
            }
            setforegroundtintblendmode2.cca_continue.addElement(new EdEC(bArr[i]));
            i++;
        }
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
        setForegroundTintBlendMode setforegroundtintblendmode3 = new setForegroundTintBlendMode();
        setforegroundtintblendmode3.cca_continue.addElement(new EdEC(this.f2772d));
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode3));
        setForegroundTintBlendMode setforegroundtintblendmode4 = new setForegroundTintBlendMode();
        int i2 = 0;
        while (true) {
            byte[][] bArr2 = this.f2773e;
            if (i2 >= bArr2.length) {
                break;
            }
            setforegroundtintblendmode4.cca_continue.addElement(new EdEC(bArr2[i2]));
            i2++;
        }
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode4));
        setForegroundTintBlendMode setforegroundtintblendmode5 = new setForegroundTintBlendMode();
        setforegroundtintblendmode5.cca_continue.addElement(new EdEC(this.f2774f));
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode5));
        setForegroundTintBlendMode setforegroundtintblendmode6 = new setForegroundTintBlendMode();
        setforegroundtintblendmode6.cca_continue.addElement(new EdEC(this.f2775g));
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode6));
        setForegroundTintBlendMode setforegroundtintblendmode7 = new setForegroundTintBlendMode();
        for (int i3 = 0; i3 < this.configure.length; i3++) {
            setForegroundTintBlendMode setforegroundtintblendmode8 = new setForegroundTintBlendMode();
            byte[][][] Cardinal = setKeyboardNavigationCluster.Cardinal(this.configure[i3].configure());
            setForegroundTintBlendMode setforegroundtintblendmode9 = new setForegroundTintBlendMode();
            for (int i4 = 0; i4 < Cardinal.length; i4++) {
                setForegroundTintBlendMode setforegroundtintblendmode10 = new setForegroundTintBlendMode();
                for (byte[] edEC : Cardinal[i4]) {
                    setforegroundtintblendmode10.cca_continue.addElement(new EdEC(edEC));
                }
                setforegroundtintblendmode9.cca_continue.addElement(new GOST(setforegroundtintblendmode10));
            }
            setforegroundtintblendmode8.cca_continue.addElement(new GOST(setforegroundtintblendmode9));
            byte[][][] Cardinal2 = setKeyboardNavigationCluster.Cardinal(this.configure[i3].Cardinal());
            setForegroundTintBlendMode setforegroundtintblendmode11 = new setForegroundTintBlendMode();
            for (int i5 = 0; i5 < Cardinal2.length; i5++) {
                setForegroundTintBlendMode setforegroundtintblendmode12 = new setForegroundTintBlendMode();
                for (byte[] edEC2 : Cardinal2[i5]) {
                    setforegroundtintblendmode12.cca_continue.addElement(new EdEC(edEC2));
                }
                setforegroundtintblendmode11.cca_continue.addElement(new GOST(setforegroundtintblendmode12));
            }
            setforegroundtintblendmode8.cca_continue.addElement(new GOST(setforegroundtintblendmode11));
            byte[][] configure2 = setKeyboardNavigationCluster.configure(this.configure[i3].cca_continue());
            setForegroundTintBlendMode setforegroundtintblendmode13 = new setForegroundTintBlendMode();
            for (byte[] edEC3 : configure2) {
                setforegroundtintblendmode13.cca_continue.addElement(new EdEC(edEC3));
            }
            setforegroundtintblendmode8.cca_continue.addElement(new GOST(setforegroundtintblendmode13));
            setforegroundtintblendmode8.cca_continue.addElement(new EdEC(setKeyboardNavigationCluster.init(this.configure[i3].init())));
            setforegroundtintblendmode7.cca_continue.addElement(new GOST(setforegroundtintblendmode8));
        }
        setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode7));
        return new GOST(setforegroundtintblendmode);
    }
}
