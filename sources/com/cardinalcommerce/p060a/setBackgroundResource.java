package com.cardinalcommerce.p060a;

import java.security.spec.KeySpec;

/* renamed from: com.cardinalcommerce.a.setBackgroundResource */
public class setBackgroundResource implements KeySpec {

    /* renamed from: a */
    private short[][] f2698a;

    /* renamed from: b */
    private short[][] f2699b;

    /* renamed from: c */
    private short[] f2700c;
    public int init;

    public setBackgroundResource(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.init = i;
        this.f2698a = sArr;
        this.f2699b = sArr2;
        this.f2700c = sArr3;
    }

    public final short[] Cardinal() {
        return this.f2700c;
    }

    public final short[][] cca_continue() {
        return this.f2699b;
    }

    public final short[][] getInstance() {
        return this.f2698a;
    }
}
