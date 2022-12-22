package com.p222hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.hp.hpl.sparta.xpath.AttrRelationalExpr */
public abstract class AttrRelationalExpr extends AttrExpr {

    /* renamed from: a */
    private final int f53961a;

    AttrRelationalExpr(String str, int i) {
        super(str);
        this.f53961a = i;
    }

    public double getAttrValue() {
        return (double) this.f53961a;
    }

    /* access modifiers changed from: protected */
    public String toString(String str) {
        return Const.jaLeft + super.toString() + str + "'" + this.f53961a + "']";
    }
}
