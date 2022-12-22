package com.p222hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.f */
/* compiled from: XPathVisitor */
class C19748f {

    /* renamed from: a */
    private static final Integer f53901a = new Integer(1);

    /* renamed from: b */
    private static final Integer f53902b = new Integer(2);

    /* renamed from: c */
    private static final Integer f53903c = new Integer(3);

    /* renamed from: d */
    private static final Integer f53904d = new Integer(4);

    /* renamed from: e */
    private static final Integer f53905e = new Integer(5);

    /* renamed from: f */
    private static final Integer f53906f = new Integer(6);

    /* renamed from: g */
    private static final Integer f53907g = new Integer(7);

    /* renamed from: h */
    private static final Integer f53908h = new Integer(8);

    /* renamed from: i */
    private static final Integer f53909i = new Integer(9);

    /* renamed from: j */
    private static final Integer f53910j = new Integer(10);

    /* renamed from: k */
    private final Vector f53911k = new Vector();

    /* renamed from: l */
    private Hashtable f53912l = new Hashtable();

    C19748f() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Enumeration mo161797a() {
        return this.f53911k.elements();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo161800b() {
        this.f53911k.removeAllElements();
        this.f53912l.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161799a(String str) {
        this.f53911k.addElement(str);
    }

    /* renamed from: b */
    private static Integer m38565b(Node node) {
        return new Integer(System.identityHashCode(node));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161798a(Node node, int i) {
        Integer num;
        this.f53911k.addElement(node);
        switch (i) {
            case 1:
                num = f53901a;
                break;
            case 2:
                num = f53902b;
                break;
            case 3:
                num = f53903c;
                break;
            case 4:
                num = f53904d;
                break;
            case 5:
                num = f53905e;
                break;
            case 6:
                num = f53906f;
                break;
            case 7:
                num = f53907g;
                break;
            case 8:
                num = f53908h;
                break;
            case 9:
                num = f53909i;
                break;
            case 10:
                num = f53910j;
                break;
            default:
                num = new Integer(i);
                break;
        }
        this.f53912l.put(m38565b(node), num);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo161796a(Node node) {
        return ((Integer) this.f53912l.get(m38565b(node))).intValue();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration elements = this.f53911k.elements();
            while (elements.hasMoreElements()) {
                Object nextElement = elements.nextElement();
                if (nextElement instanceof String) {
                    stringBuffer.append("String(" + nextElement + ") ");
                } else {
                    Node node = (Node) nextElement;
                    stringBuffer.append("Node(" + node.toXml() + ")[" + this.f53912l.get(m38565b(node)) + "] ");
                }
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
}
