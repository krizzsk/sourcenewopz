package com.cardinalcommerce.p060a;

import java.security.PrivateKey;
import java.util.Arrays;

/* renamed from: com.cardinalcommerce.a.setRenderEffect */
public final class setRenderEffect implements PrivateKey {
    private short[][] Cardinal;
    private short[][] cca_continue;
    public int[] configure;
    private short[] getInstance;
    public setDefaultFocusHighlightEnabled[] init;
    private short[] values;

    public setRenderEffect(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, setDefaultFocusHighlightEnabled[] setdefaultfocushighlightenabledArr) {
        this.Cardinal = sArr;
        this.getInstance = sArr2;
        this.cca_continue = sArr3;
        this.values = sArr4;
        this.configure = iArr;
        this.init = setdefaultfocushighlightenabledArr;
    }

    public final short[][] Cardinal() {
        return this.Cardinal;
    }

    public final short[] cca_continue() {
        return this.getInstance;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] getEncoded() {
        /*
            r8 = this;
            com.cardinalcommerce.a.setFitsSystemWindows r7 = new com.cardinalcommerce.a.setFitsSystemWindows
            short[][] r1 = r8.Cardinal
            short[] r2 = r8.getInstance
            short[][] r3 = r8.cca_continue
            short[] r4 = r8.values
            int[] r5 = r8.configure
            com.cardinalcommerce.a.setDefaultFocusHighlightEnabled[] r6 = r8.init
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 0
            com.cardinalcommerce.a.DSASigner$stdDSA r1 = new com.cardinalcommerce.a.DSASigner$stdDSA     // Catch:{ IOException -> 0x0025 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers.getInstance     // Catch:{ IOException -> 0x0025 }
            com.cardinalcommerce.a.ECGOST$Mappings r3 = com.cardinalcommerce.p060a.ECGOST.Mappings.Cardinal     // Catch:{ IOException -> 0x0025 }
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0025 }
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r2 = new com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x0025 }
            r2.<init>(r1, r7)     // Catch:{ IOException -> 0x0025 }
            byte[] r0 = r2.getEncoded()     // Catch:{  }
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setRenderEffect.getEncoded():byte[]");
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final short[] getInstance() {
        return this.values;
    }

    public final short[][] init() {
        return this.cca_continue;
    }

    public setRenderEffect(setBackground setbackground) {
        this(setbackground.cca_continue(), setbackground.init(), setbackground.configure(), setbackground.getInstance(), setbackground.init, setbackground.Cardinal);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof setRenderEffect)) {
            return false;
        }
        setRenderEffect setrendereffect = (setRenderEffect) obj;
        boolean z = (((setKeyboardNavigationCluster.configure(this.Cardinal, setrendereffect.Cardinal()) && setKeyboardNavigationCluster.configure(this.cca_continue, setrendereffect.init())) && setKeyboardNavigationCluster.configure(this.getInstance, setrendereffect.cca_continue())) && setKeyboardNavigationCluster.configure(this.values, setrendereffect.getInstance())) && Arrays.equals(this.configure, setrendereffect.configure);
        setDefaultFocusHighlightEnabled[] setdefaultfocushighlightenabledArr = this.init;
        if (setdefaultfocushighlightenabledArr.length != setrendereffect.init.length) {
            return false;
        }
        for (int length = setdefaultfocushighlightenabledArr.length - 1; length >= 0; length--) {
            z &= this.init[length].equals(setrendereffect.init[length]);
        }
        return z;
    }

    public final int hashCode() {
        int length = this.init.length * 37;
        short[][] sArr = this.Cardinal;
        int i = 0;
        for (int i2 = 0; i2 != sArr.length; i2++) {
            i = (i * 257) + setForegroundTintBlendMode.init(sArr[i2]);
        }
        int init2 = (((length + i) * 37) + setForegroundTintBlendMode.init(this.getInstance)) * 37;
        short[][] sArr2 = this.cca_continue;
        int i3 = 0;
        for (int i4 = 0; i4 != sArr2.length; i4++) {
            i3 = (i3 * 257) + setForegroundTintBlendMode.init(sArr2[i4]);
        }
        int init3 = ((((init2 + i3) * 37) + setForegroundTintBlendMode.init(this.values)) * 37) + setForegroundTintBlendMode.cca_continue(this.configure);
        for (int length2 = this.init.length - 1; length2 >= 0; length2--) {
            init3 = (init3 * 37) + this.init[length2].hashCode();
        }
        return init3;
    }
}
