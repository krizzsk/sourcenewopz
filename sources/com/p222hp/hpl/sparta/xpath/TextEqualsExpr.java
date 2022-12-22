package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.TextEqualsExpr */
public class TextEqualsExpr extends TextCompareExpr {
    TextEqualsExpr(String str) {
        super(str);
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return toString("=");
    }
}
