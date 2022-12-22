package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setTransitionAlpha;

/* renamed from: com.cardinalcommerce.a.setScaleY */
public final class setScaleY {

    /* renamed from: a */
    final C2027r f2964a;

    /* renamed from: b */
    private byte[] f2965b;

    /* renamed from: c */
    private byte[] f2966c;
    public final setLeft getInstance;

    /* access modifiers changed from: protected */
    public final byte[] Cardinal() {
        return setForegroundTintBlendMode.cca_continue(this.f2966c);
    }

    protected setScaleY(setLeft setleft) {
        this.getInstance = setleft;
        int i = setleft.getInstance;
        this.f2964a = new C2027r(setleft.f2854a, i);
        this.f2965b = new byte[i];
        this.f2966c = new byte[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo18701a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("secretKeySeed == null");
        } else if (bArr.length != this.getInstance.getInstance) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        } else if (bArr2 == null) {
            throw new NullPointerException("publicSeed == null");
        } else if (bArr2.length == this.getInstance.getInstance) {
            this.f2965b = bArr;
            this.f2966c = bArr2;
        } else {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
    }

    /* renamed from: a */
    private byte[] m2082a(byte[] bArr, int i, int i2, setTransitionAlpha settransitionalpha) {
        int i3 = this.getInstance.getInstance;
        if (bArr == null) {
            throw new NullPointerException("startHash == null");
        } else if (bArr.length != i3) {
            StringBuilder sb = new StringBuilder("startHash needs to be ");
            sb.append(i3);
            sb.append("bytes");
            throw new IllegalArgumentException(sb.toString());
        } else if (settransitionalpha == null) {
            throw new NullPointerException("otsHashAddress == null");
        } else if (settransitionalpha.getInstance() != null) {
            int i4 = i + i2;
            if (i4 > 15) {
                throw new IllegalArgumentException("max chain length must not be greater than w");
            } else if (i2 == 0) {
                return bArr;
            } else {
                byte[] a = m2082a(bArr, i, i2 - 1, settransitionalpha);
                setTransitionAlpha.cca_continue cca_continue = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d);
                cca_continue.cca_continue = settransitionalpha.f3068a;
                cca_continue.configure = settransitionalpha.f3069b;
                cca_continue.init = i4 - 1;
                setTransitionAlpha settransitionalpha2 = new setTransitionAlpha((setTransitionAlpha.cca_continue) cca_continue.init(0), (byte) 0);
                byte[] c = this.f2964a.mo18299c(this.f2966c, settransitionalpha2.getInstance());
                setTransitionAlpha.cca_continue cca_continue2 = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(settransitionalpha2.f2703c)).getInstance(settransitionalpha2.f2704d);
                cca_continue2.cca_continue = settransitionalpha2.f3068a;
                cca_continue2.configure = settransitionalpha2.f3069b;
                cca_continue2.init = settransitionalpha2.f3070f;
                byte[] c2 = this.f2964a.mo18299c(this.f2966c, new setTransitionAlpha((setTransitionAlpha.cca_continue) cca_continue2.init(1), (byte) 0).getInstance());
                byte[] bArr2 = new byte[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr2[i5] = (byte) (a[i5] ^ c2[i5]);
                }
                return this.f2964a.mo18297a(c, bArr2);
            }
        } else {
            throw new NullPointerException("otsHashAddress byte array == null");
        }
    }

    /* access modifiers changed from: protected */
    public final byte[] cca_continue(byte[] bArr, setTransitionAlpha settransitionalpha) {
        setTransitionAlpha.cca_continue cca_continue = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d);
        cca_continue.cca_continue = settransitionalpha.f3068a;
        return this.f2964a.mo18299c(bArr, new setTransitionAlpha(cca_continue, (byte) 0).getInstance());
    }

    /* renamed from: a */
    private byte[] m2081a(int i) {
        if (i >= 0 && i < this.getInstance.f2855b) {
            return this.f2964a.mo18299c(this.f2965b, setVerticalFadingEdgeEnabled.Cardinal((long) i, 32));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    /* access modifiers changed from: protected */
    public final C2130u Cardinal(setTransitionAlpha settransitionalpha) {
        byte[][] bArr = new byte[this.getInstance.f2855b][];
        for (int i = 0; i < this.getInstance.f2855b; i++) {
            setTransitionAlpha.cca_continue cca_continue = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(settransitionalpha.f2703c)).getInstance(settransitionalpha.f2704d);
            cca_continue.cca_continue = settransitionalpha.f3068a;
            cca_continue.configure = i;
            cca_continue.init = settransitionalpha.f3070f;
            settransitionalpha = new setTransitionAlpha((setTransitionAlpha.cca_continue) cca_continue.init(settransitionalpha.f2705e), (byte) 0);
            bArr[i] = m2082a(m2081a(i), 0, 15, settransitionalpha);
        }
        return new C2130u(this.getInstance, bArr);
    }
}
