package com.p222hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.p222hp.hpl.sparta.Sparta;

/* renamed from: com.hp.hpl.sparta.xpath.AttrCompareExpr */
public abstract class AttrCompareExpr extends AttrExpr {

    /* renamed from: a */
    private final String f53959a;

    AttrCompareExpr(String str, String str2) {
        super(str);
        this.f53959a = Sparta.intern(str2);
    }

    public String getAttrValue() {
        return this.f53959a;
    }

    /* access modifiers changed from: protected */
    public String toString(String str) {
        return Const.jaLeft + super.toString() + str + "'" + this.f53959a + "']";
    }
}
