package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.NodeTest */
public abstract class NodeTest {
    public abstract void accept(Visitor visitor) throws XPathException;

    public abstract boolean isStringValue();
}
