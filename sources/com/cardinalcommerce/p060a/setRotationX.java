package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.setTransitionAlpha;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.cardinalcommerce.a.setRotationX */
public class setRotationX implements Serializable {
    private final Map<Integer, setTouchDelegate> getInstance = new TreeMap();

    setRotationX() {
    }

    setRotationX(setTranslationY settranslationy, long j, byte[] bArr, byte[] bArr2) {
        for (long j2 = 0; j2 < j; j2++) {
            configure(settranslationy, j2, bArr, bArr2);
        }
    }

    private void configure(setTranslationY settranslationy, long j, byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4;
        setTranslationY settranslationy2 = settranslationy;
        long j2 = j;
        byte[] bArr5 = bArr;
        byte[] bArr6 = bArr2;
        setStateListAnimator setstatelistanimator = settranslationy2.Cardinal;
        int i = setstatelistanimator.Cardinal;
        long j3 = j2 >> i;
        long j4 = (1 << i) - 1;
        int i2 = (int) (j2 & j4);
        setTransitionAlpha.cca_continue cca_continue = (setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().getInstance(j3);
        cca_continue.cca_continue = i2;
        byte b = 0;
        long j5 = j3;
        setTransitionAlpha settransitionalpha = new setTransitionAlpha(cca_continue, (byte) 0);
        int i3 = (1 << i) - 1;
        if (i2 < i3) {
            if (this.getInstance.get(0) == null || i2 == 0) {
                this.getInstance.put(0, new setTouchDelegate(setstatelistanimator, bArr5, bArr6, settransitionalpha));
            }
            Cardinal(0, bArr5, bArr6, settransitionalpha);
        }
        long j6 = j5;
        int i4 = 1;
        while (i4 < settranslationy2.configure) {
            int i5 = (int) (j6 & j4);
            j6 >>= i;
            setTransitionAlpha.cca_continue cca_continue2 = (setTransitionAlpha.cca_continue) ((setTransitionAlpha.cca_continue) new setTransitionAlpha.cca_continue().Cardinal(i4)).getInstance(j6);
            cca_continue2.cca_continue = i5;
            setTransitionAlpha settransitionalpha2 = new setTransitionAlpha(cca_continue2, b);
            if (i5 >= i3 || !setVerticalFadingEdgeEnabled.configure(j2, i, i4)) {
                bArr4 = bArr;
                bArr3 = bArr2;
            } else {
                if (this.getInstance.get(Integer.valueOf(i4)) == null) {
                    bArr4 = bArr;
                    bArr3 = bArr2;
                    this.getInstance.put(Integer.valueOf(i4), new setTouchDelegate(settranslationy2.Cardinal, bArr4, bArr3, settransitionalpha2));
                } else {
                    bArr4 = bArr;
                    bArr3 = bArr2;
                }
                Cardinal(i4, bArr4, bArr3, settransitionalpha2);
            }
            i4++;
            settranslationy2 = settranslationy;
            byte[] bArr7 = bArr4;
            byte[] bArr8 = bArr3;
            b = 0;
        }
    }

    private setTouchDelegate Cardinal(int i, byte[] bArr, byte[] bArr2, setTransitionAlpha settransitionalpha) {
        return this.getInstance.put(Integer.valueOf(i), new setTouchDelegate(this.getInstance.get(Integer.valueOf(i)), bArr, bArr2, settransitionalpha));
    }

    public final setRotationX cca_continue(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        setRotationX setrotationx = new setRotationX();
        for (Integer next : this.getInstance.keySet()) {
            setrotationx.getInstance.put(next, new setTouchDelegate(this.getInstance.get(next), setCameraDistance.Cardinal(aSN1ObjectIdentifier)));
        }
        return setrotationx;
    }
}
