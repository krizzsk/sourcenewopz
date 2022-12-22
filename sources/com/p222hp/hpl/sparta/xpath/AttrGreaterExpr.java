package com.p222hp.hpl.sparta.xpath;

import com.didi.beatles.p099im.access.utils.IMTextUtils;

/* renamed from: com.hp.hpl.sparta.xpath.AttrGreaterExpr */
public class AttrGreaterExpr extends AttrRelationalExpr {
    public AttrGreaterExpr(String str, int i) {
        super(str, i);
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        return toString(IMTextUtils.STREET_IMAGE_TAG_END);
    }
}
