package com.p222hp.hpl.sparta.xpath;

import com.p222hp.hpl.sparta.Sparta;

/* renamed from: com.hp.hpl.sparta.xpath.ElementTest */
public class ElementTest extends NodeTest {

    /* renamed from: a */
    private final String f53963a;

    public boolean isStringValue() {
        return false;
    }

    ElementTest(String str) {
        this.f53963a = Sparta.intern(str);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getTagName() {
        return this.f53963a;
    }

    public String toString() {
        return this.f53963a;
    }
}
