package com.p222hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.hp.hpl.sparta.xpath.PositionEqualsExpr */
public class PositionEqualsExpr extends BooleanExpr {

    /* renamed from: a */
    private final int f53965a;

    public PositionEqualsExpr(int i) {
        this.f53965a = i;
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public int getPosition() {
        return this.f53965a;
    }

    public String toString() {
        return Const.jaLeft + this.f53965a + Const.jaRight;
    }
}
