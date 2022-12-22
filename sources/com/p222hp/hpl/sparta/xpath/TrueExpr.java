package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.TrueExpr */
public class TrueExpr extends BooleanExpr {

    /* renamed from: a */
    static final TrueExpr f53981a = new TrueExpr();

    public String toString() {
        return "";
    }

    private TrueExpr() {
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) {
        booleanExprVisitor.visit(this);
    }
}
