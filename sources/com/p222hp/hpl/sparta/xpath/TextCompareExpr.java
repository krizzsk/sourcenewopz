package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.TextCompareExpr */
public abstract class TextCompareExpr extends BooleanExpr {

    /* renamed from: a */
    private final String f53977a;

    TextCompareExpr(String str) {
        this.f53977a = str;
    }

    public String getValue() {
        return this.f53977a;
    }

    /* access modifiers changed from: protected */
    public String toString(String str) {
        return "[text()" + str + "'" + this.f53977a + "']";
    }
}
