package com.p222hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.AllElementTest */
public class AllElementTest extends NodeTest {

    /* renamed from: a */
    static final AllElementTest f53958a = new AllElementTest();

    public boolean isStringValue() {
        return false;
    }

    public String toString() {
        return "*";
    }

    private AllElementTest() {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
