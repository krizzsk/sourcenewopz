package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.TextNotEqualsExpr */
public class TextNotEqualsExpr extends TextCompareExpr {
    TextNotEqualsExpr(String str) {
        super(str);
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return toString("!=");
    }
}
