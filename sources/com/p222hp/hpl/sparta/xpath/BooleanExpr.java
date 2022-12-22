package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.BooleanExpr */
public abstract class BooleanExpr {
    public abstract void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException;
}
