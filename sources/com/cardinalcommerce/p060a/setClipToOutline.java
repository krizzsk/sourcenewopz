package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.setAlpha;
import com.cardinalcommerce.p060a.setPivotX;

/* renamed from: com.cardinalcommerce.a.setClipToOutline */
public final class setClipToOutline implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public CipherSpi.PKCS1v1_5Padding configure;
    public CipherSpi.PKCS1v1_5Padding getInstance;

    setClipToOutline() {
    }

    static setY init(setScaleY setscaley, C2130u uVar, setPivotX setpivotx) {
        int i;
        if (uVar != null) {
            int i2 = setscaley.getInstance.f2855b;
            byte[][] a = uVar.mo18830a();
            setY[] setyArr = new setY[a.length];
            for (int i3 = 0; i3 < a.length; i3++) {
                setyArr[i3] = new setY(0, a[i3]);
            }
            setPivotX.Cardinal cardinal = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx.f2703c)).getInstance(setpivotx.f2704d);
            cardinal.getInstance = setpivotx.f2919a;
            cardinal.Cardinal = 0;
            cardinal.cca_continue = setpivotx.f2921f;
            setPivotX setpivotx2 = new setPivotX((setPivotX.Cardinal) cardinal.init(setpivotx.f2705e), (byte) 0);
            while (true) {
                setPivotX setpivotx3 = setpivotx2;
                if (i2 <= 1) {
                    return setyArr[0];
                }
                int i4 = 0;
                while (true) {
                    i = i2 / 2;
                    if (i4 >= i) {
                        break;
                    }
                    setPivotX.Cardinal cardinal2 = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx3.f2703c)).getInstance(setpivotx3.f2704d);
                    cardinal2.getInstance = setpivotx3.f2919a;
                    cardinal2.Cardinal = setpivotx3.f2920b;
                    cardinal2.cca_continue = i4;
                    setpivotx3 = new setPivotX((setPivotX.Cardinal) cardinal2.init(setpivotx3.f2705e), (byte) 0);
                    int i5 = i4 * 2;
                    setyArr[i4] = init(setscaley, setyArr[i5], setyArr[i5 + 1], setpivotx3);
                    i4++;
                }
                if (i2 % 2 == 1) {
                    setyArr[i] = setyArr[i2 - 1];
                }
                i2 = (int) Math.ceil(((double) i2) / 2.0d);
                setPivotX.Cardinal cardinal3 = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx3.f2703c)).getInstance(setpivotx3.f2704d);
                cardinal3.getInstance = setpivotx3.f2919a;
                cardinal3.Cardinal = setpivotx3.f2920b + 1;
                cardinal3.cca_continue = setpivotx3.f2921f;
                setpivotx2 = new setPivotX((setPivotX.Cardinal) cardinal3.init(setpivotx3.f2705e), (byte) 0);
            }
        } else {
            throw new NullPointerException("publicKey == null");
        }
    }

    static setY init(setScaleY setscaley, setY sety, setY sety2, setBottom setbottom) {
        if (sety == null) {
            throw new NullPointerException("left == null");
        } else if (sety2 == null) {
            throw new NullPointerException("right == null");
        } else if (sety.init == sety2.init) {
            byte[] Cardinal = setscaley.Cardinal();
            if (setbottom instanceof setPivotX) {
                setPivotX setpivotx = (setPivotX) setbottom;
                setPivotX.Cardinal cardinal = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx.f2703c)).getInstance(setpivotx.f2704d);
                cardinal.getInstance = setpivotx.f2919a;
                cardinal.Cardinal = setpivotx.f2920b;
                cardinal.cca_continue = setpivotx.f2921f;
                setbottom = new setPivotX((setPivotX.Cardinal) cardinal.init(0), (byte) 0);
            } else if (setbottom instanceof setAlpha) {
                setAlpha setalpha = (setAlpha) setbottom;
                setAlpha.getInstance getinstance = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha.f2703c)).getInstance(setalpha.f2704d);
                getinstance.getInstance = setalpha.f2667a;
                getinstance.cca_continue = setalpha.f2668b;
                setbottom = new setAlpha((setAlpha.getInstance) getinstance.init(0), (byte) 0);
            }
            byte[] c = setscaley.f2964a.mo18299c(Cardinal, setbottom.getInstance());
            if (setbottom instanceof setPivotX) {
                setPivotX setpivotx2 = (setPivotX) setbottom;
                setPivotX.Cardinal cardinal2 = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx2.f2703c)).getInstance(setpivotx2.f2704d);
                cardinal2.getInstance = setpivotx2.f2919a;
                cardinal2.Cardinal = setpivotx2.f2920b;
                cardinal2.cca_continue = setpivotx2.f2921f;
                setbottom = new setPivotX((setPivotX.Cardinal) cardinal2.init(1), (byte) 0);
            } else if (setbottom instanceof setAlpha) {
                setAlpha setalpha2 = (setAlpha) setbottom;
                setAlpha.getInstance getinstance2 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha2.f2703c)).getInstance(setalpha2.f2704d);
                getinstance2.getInstance = setalpha2.f2667a;
                getinstance2.cca_continue = setalpha2.f2668b;
                setbottom = new setAlpha((setAlpha.getInstance) getinstance2.init(1), (byte) 0);
            }
            byte[] c2 = setscaley.f2964a.mo18299c(Cardinal, setbottom.getInstance());
            if (setbottom instanceof setPivotX) {
                setPivotX setpivotx3 = (setPivotX) setbottom;
                setPivotX.Cardinal cardinal3 = (setPivotX.Cardinal) ((setPivotX.Cardinal) new setPivotX.Cardinal().Cardinal(setpivotx3.f2703c)).getInstance(setpivotx3.f2704d);
                cardinal3.getInstance = setpivotx3.f2919a;
                cardinal3.Cardinal = setpivotx3.f2920b;
                cardinal3.cca_continue = setpivotx3.f2921f;
                setbottom = new setPivotX((setPivotX.Cardinal) cardinal3.init(2), (byte) 0);
            } else if (setbottom instanceof setAlpha) {
                setAlpha setalpha3 = (setAlpha) setbottom;
                setAlpha.getInstance getinstance3 = (setAlpha.getInstance) ((setAlpha.getInstance) new setAlpha.getInstance().Cardinal(setalpha3.f2703c)).getInstance(setalpha3.f2704d);
                getinstance3.getInstance = setalpha3.f2667a;
                getinstance3.cca_continue = setalpha3.f2668b;
                setbottom = new setAlpha((setAlpha.getInstance) getinstance3.init(2), (byte) 0);
            }
            byte[] c3 = setscaley.f2964a.mo18299c(Cardinal, setbottom.getInstance());
            int i = setscaley.getInstance.getInstance;
            byte[] bArr = new byte[(i * 2)];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) (sety.getInstance()[i2] ^ c2[i2]);
            }
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3 + i] = (byte) (sety2.getInstance()[i3] ^ c3[i3]);
            }
            return new setY(sety.init, setscaley.f2964a.mo18298b(c, bArr));
        } else {
            throw new IllegalStateException("height of both nodes must be equal");
        }
    }

    public setClipToOutline(CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding, CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding2) {
        if (pKCS1v1_5Padding == null) {
            throw new NullPointerException("staticPublicKey cannot be null");
        } else if (pKCS1v1_5Padding2 == null) {
            throw new NullPointerException("ephemeralPublicKey cannot be null");
        } else if (pKCS1v1_5Padding.configure.equals(pKCS1v1_5Padding2.configure)) {
            this.configure = pKCS1v1_5Padding;
            this.getInstance = pKCS1v1_5Padding2;
        } else {
            throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
        }
    }
}
