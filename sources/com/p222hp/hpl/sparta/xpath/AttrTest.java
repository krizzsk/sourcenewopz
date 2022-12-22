package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.AttrTest */
public class AttrTest extends NodeTest {

    /* renamed from: a */
    private final String f53962a;

    public boolean isStringValue() {
        return true;
    }

    AttrTest(String str) {
        this.f53962a = str;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getAttrName() {
        return this.f53962a;
    }

    public String toString() {
        return "@" + this.f53962a;
    }
}
