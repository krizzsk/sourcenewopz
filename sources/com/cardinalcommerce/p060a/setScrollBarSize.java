package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.setScrollBarSize */
public final class setScrollBarSize implements PublicKey {
    public int Cardinal;
    private short[] cca_continue;
    private short[][] getInstance;
    private short[][] init;

    public setScrollBarSize(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.Cardinal = i;
        this.getInstance = sArr;
        this.init = sArr2;
        this.cca_continue = sArr3;
    }

    public final short[] cca_continue() {
        return setForegroundTintBlendMode.Cardinal(this.cca_continue);
    }

    public final short[][] configure() {
        short[][] sArr = new short[this.init.length][];
        int i = 0;
        while (true) {
            short[][] sArr2 = this.init;
            if (i == sArr2.length) {
                return sArr;
            }
            sArr[i] = setForegroundTintBlendMode.Cardinal(sArr2[i]);
            i++;
        }
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public final byte[] getEncoded() {
        return setDrawingCacheEnabled.init(new DSASigner.stdDSA(PQCObjectIdentifiers.getInstance, ECGOST.Mappings.Cardinal), new setFocusable(this.Cardinal, this.getInstance, this.init, this.cca_continue));
    }

    public final String getFormat() {
        return "X.509";
    }

    public final short[][] init() {
        return this.getInstance;
    }

    public setScrollBarSize(setBackgroundResource setbackgroundresource) {
        this(setbackgroundresource.init, setbackgroundresource.getInstance(), setbackgroundresource.cca_continue(), setbackgroundresource.Cardinal());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof setScrollBarSize)) {
            setScrollBarSize setscrollbarsize = (setScrollBarSize) obj;
            return this.Cardinal == setscrollbarsize.Cardinal && setKeyboardNavigationCluster.configure(this.getInstance, setscrollbarsize.init()) && setKeyboardNavigationCluster.configure(this.init, setscrollbarsize.configure()) && setKeyboardNavigationCluster.configure(this.cca_continue, setscrollbarsize.cca_continue());
        }
    }

    public final int hashCode() {
        int i = this.Cardinal * 37;
        short[][] sArr = this.getInstance;
        int i2 = 0;
        for (int i3 = 0; i3 != sArr.length; i3++) {
            i2 = (i2 * 257) + setForegroundTintBlendMode.init(sArr[i3]);
        }
        int i4 = (i + i2) * 37;
        short[][] sArr2 = this.init;
        int i5 = 0;
        for (int i6 = 0; i6 != sArr2.length; i6++) {
            i5 = (i5 * 257) + setForegroundTintBlendMode.init(sArr2[i6]);
        }
        return ((i4 + i5) * 37) + setForegroundTintBlendMode.init(this.cca_continue);
    }
}
