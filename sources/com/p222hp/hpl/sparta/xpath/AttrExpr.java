package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.AttrExpr */
public abstract class AttrExpr extends BooleanExpr {

    /* renamed from: a */
    private final String f53960a;

    AttrExpr(String str) {
        this.f53960a = str;
    }

    public String getAttrName() {
        return this.f53960a;
    }

    public String toString() {
        return "@" + this.f53960a;
    }
}
