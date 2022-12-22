package com.p222hp.hpl.sparta;

import com.p222hp.hpl.sparta.xpath.AllElementTest;
import com.p222hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.p222hp.hpl.sparta.xpath.AttrExistsExpr;
import com.p222hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.p222hp.hpl.sparta.xpath.AttrLessExpr;
import com.p222hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.p222hp.hpl.sparta.xpath.AttrTest;
import com.p222hp.hpl.sparta.xpath.BooleanExpr;
import com.p222hp.hpl.sparta.xpath.ElementTest;
import com.p222hp.hpl.sparta.xpath.ParentNodeTest;
import com.p222hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.p222hp.hpl.sparta.xpath.Step;
import com.p222hp.hpl.sparta.xpath.TextEqualsExpr;
import com.p222hp.hpl.sparta.xpath.TextExistsExpr;
import com.p222hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.p222hp.hpl.sparta.xpath.TextTest;
import com.p222hp.hpl.sparta.xpath.ThisNodeTest;
import com.p222hp.hpl.sparta.xpath.TrueExpr;
import com.p222hp.hpl.sparta.xpath.Visitor;
import com.p222hp.hpl.sparta.xpath.XPath;
import com.p222hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.XPathVisitor */
class XPathVisitor implements Visitor {

    /* renamed from: a */
    private static final Boolean f53883a = new Boolean(true);

    /* renamed from: b */
    private static final Boolean f53884b = new Boolean(false);

    /* renamed from: c */
    private final C19748f f53885c;

    /* renamed from: d */
    private Vector f53886d;

    /* renamed from: e */
    private Enumeration f53887e;

    /* renamed from: f */
    private Object f53888f;

    /* renamed from: g */
    private final BooleanStack f53889g;

    /* renamed from: h */
    private Node f53890h;

    /* renamed from: i */
    private boolean f53891i;

    /* renamed from: j */
    private XPath f53892j;

    private XPathVisitor(XPath xPath, Node node) throws XPathException {
        this.f53885c = new C19748f();
        this.f53886d = new Vector();
        this.f53887e = null;
        this.f53888f = null;
        this.f53889g = new BooleanStack();
        this.f53892j = xPath;
        this.f53890h = node;
        Vector vector = new Vector(1);
        this.f53886d = vector;
        vector.addElement(this.f53890h);
        Enumeration steps = xPath.getSteps();
        while (steps.hasMoreElements()) {
            Step step = (Step) steps.nextElement();
            this.f53891i = step.isMultiLevel();
            this.f53887e = null;
            step.getNodeTest().accept(this);
            this.f53887e = this.f53885c.mo161797a();
            this.f53886d.removeAllElements();
            BooleanExpr predicate = step.getPredicate();
            while (this.f53887e.hasMoreElements()) {
                this.f53888f = this.f53887e.nextElement();
                predicate.accept(this);
                if (this.f53889g.pop().booleanValue()) {
                    this.f53886d.addElement(this.f53888f);
                }
            }
        }
    }

    public XPathVisitor(Element element, XPath xPath) throws XPathException {
        this(xPath, (Node) element);
        if (xPath.isAbsolute()) {
            throw new XPathException(xPath, "Cannot use element as context node for absolute xpath");
        }
    }

    public XPathVisitor(Document document, XPath xPath) throws XPathException {
        this(xPath, (Node) document);
    }

    public void visit(ThisNodeTest thisNodeTest) {
        this.f53885c.mo161800b();
        this.f53885c.mo161798a(this.f53890h, 1);
    }

    public void visit(ParentNodeTest parentNodeTest) throws XPathException {
        this.f53885c.mo161800b();
        Element parentNode = this.f53890h.getParentNode();
        if (parentNode != null) {
            this.f53885c.mo161798a(parentNode, 1);
            return;
        }
        throw new XPathException(this.f53892j, "Illegal attempt to apply \"..\" to node with no parent.");
    }

    public void visit(AllElementTest allElementTest) {
        Vector vector = this.f53886d;
        this.f53885c.mo161800b();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Element) {
                m38552a((Element) nextElement);
            } else if (nextElement instanceof Document) {
                m38550a((Document) nextElement);
            }
        }
    }

    /* renamed from: a */
    private void m38550a(Document document) {
        Element documentElement = document.getDocumentElement();
        this.f53885c.mo161798a(documentElement, 1);
        if (this.f53891i) {
            m38552a(documentElement);
        }
    }

    /* renamed from: a */
    private void m38552a(Element element) {
        int i = 0;
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild instanceof Element) {
                i++;
                this.f53885c.mo161798a(firstChild, i);
                if (this.f53891i) {
                    m38552a((Element) firstChild);
                }
            }
        }
    }

    public void visit(TextTest textTest) {
        Vector vector = this.f53886d;
        this.f53885c.mo161800b();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Element) {
                for (Node firstChild = ((Element) nextElement).getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                    if (firstChild instanceof Text) {
                        this.f53885c.mo161799a(((Text) firstChild).getData());
                    }
                }
            }
        }
    }

    public void visit(ElementTest elementTest) {
        String tagName = elementTest.getTagName();
        Vector vector = this.f53886d;
        int size = vector.size();
        this.f53885c.mo161800b();
        for (int i = 0; i < size; i++) {
            Object elementAt = vector.elementAt(i);
            if (elementAt instanceof Element) {
                m38553a((Element) elementAt, tagName);
            } else if (elementAt instanceof Document) {
                m38551a((Document) elementAt, tagName);
            }
        }
    }

    /* renamed from: a */
    private void m38551a(Document document, String str) {
        Element documentElement = document.getDocumentElement();
        if (documentElement != null) {
            if (documentElement.getTagName() == str) {
                this.f53885c.mo161798a(documentElement, 1);
            }
            if (this.f53891i) {
                m38553a(documentElement, str);
            }
        }
    }

    /* renamed from: a */
    private void m38553a(Element element, String str) {
        int i = 0;
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild instanceof Element) {
                Element element2 = (Element) firstChild;
                if (element2.getTagName() == str) {
                    i++;
                    this.f53885c.mo161798a(element2, i);
                }
                if (this.f53891i) {
                    m38553a(element2, str);
                }
            }
        }
    }

    public void visit(AttrTest attrTest) {
        String attribute;
        Vector vector = this.f53886d;
        this.f53885c.mo161800b();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Node node = (Node) elements.nextElement();
            if ((node instanceof Element) && (attribute = ((Element) node).getAttribute(attrTest.getAttrName())) != null) {
                this.f53885c.mo161799a(attribute);
            }
        }
    }

    public void visit(TrueExpr trueExpr) {
        this.f53889g.push(f53883a);
    }

    public void visit(AttrExistsExpr attrExistsExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            String attribute = ((Element) obj).getAttribute(attrExistsExpr.getAttrName());
            this.f53889g.push(attribute != null && attribute.length() > 0 ? f53883a : f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(AttrEqualsExpr attrEqualsExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            this.f53889g.push(attrEqualsExpr.getAttrValue().equals(((Element) obj).getAttribute(attrEqualsExpr.getAttrName())) ? f53883a : f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(AttrNotEqualsExpr attrNotEqualsExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            this.f53889g.push(attrNotEqualsExpr.getAttrValue().equals(((Element) obj).getAttribute(attrNotEqualsExpr.getAttrName())) ^ true ? f53883a : f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(AttrLessExpr attrLessExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            this.f53889g.push((((double) Long.parseLong(((Element) obj).getAttribute(attrLessExpr.getAttrName()))) > attrLessExpr.getAttrValue() ? 1 : (((double) Long.parseLong(((Element) obj).getAttribute(attrLessExpr.getAttrName()))) == attrLessExpr.getAttrValue() ? 0 : -1)) < 0 ? f53883a : f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(AttrGreaterExpr attrGreaterExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            this.f53889g.push((((double) Long.parseLong(((Element) obj).getAttribute(attrGreaterExpr.getAttrName()))) > attrGreaterExpr.getAttrValue() ? 1 : (((double) Long.parseLong(((Element) obj).getAttribute(attrGreaterExpr.getAttrName()))) == attrGreaterExpr.getAttrValue() ? 0 : -1)) > 0 ? f53883a : f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(TextExistsExpr textExistsExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            for (Node firstChild = ((Element) obj).getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild instanceof Text) {
                    this.f53889g.push(f53883a);
                    return;
                }
            }
            this.f53889g.push(f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(TextEqualsExpr textEqualsExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            Node firstChild = ((Element) obj).getFirstChild();
            while (firstChild != null) {
                if (!(firstChild instanceof Text) || !((Text) firstChild).getData().equals(textEqualsExpr.getValue())) {
                    firstChild = firstChild.getNextSibling();
                } else {
                    this.f53889g.push(f53883a);
                    return;
                }
            }
            this.f53889g.push(f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(TextNotEqualsExpr textNotEqualsExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            Node firstChild = ((Element) obj).getFirstChild();
            while (firstChild != null) {
                if (!(firstChild instanceof Text) || ((Text) firstChild).getData().equals(textNotEqualsExpr.getValue())) {
                    firstChild = firstChild.getNextSibling();
                } else {
                    this.f53889g.push(f53883a);
                    return;
                }
            }
            this.f53889g.push(f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test attribute of document");
    }

    public void visit(PositionEqualsExpr positionEqualsExpr) throws XPathException {
        Object obj = this.f53888f;
        if (obj instanceof Element) {
            this.f53889g.push(this.f53885c.mo161796a((Node) (Element) obj) == positionEqualsExpr.getPosition() ? f53883a : f53884b);
            return;
        }
        throw new XPathException(this.f53892j, "Cannot test position of document");
    }

    /* renamed from: a */
    public Enumeration mo161776a() {
        return this.f53886d.elements();
    }

    /* renamed from: b */
    public Element mo161777b() {
        if (this.f53886d.size() == 0) {
            return null;
        }
        return (Element) this.f53886d.elementAt(0);
    }

    /* renamed from: c */
    public String mo161778c() {
        if (this.f53886d.size() == 0) {
            return null;
        }
        return this.f53886d.elementAt(0).toString();
    }

    /* renamed from: com.hp.hpl.sparta.XPathVisitor$BooleanStack */
    private static class BooleanStack {
        private Item top_;

        private BooleanStack() {
            this.top_ = null;
        }

        /* renamed from: com.hp.hpl.sparta.XPathVisitor$BooleanStack$Item */
        private static class Item {
            final Boolean bool;
            final Item prev;

            Item(Boolean bool2, Item item) {
                this.bool = bool2;
                this.prev = item;
            }
        }

        /* access modifiers changed from: package-private */
        public void push(Boolean bool) {
            this.top_ = new Item(bool, this.top_);
        }

        /* access modifiers changed from: package-private */
        public Boolean pop() {
            Boolean bool = this.top_.bool;
            this.top_ = this.top_.prev;
            return bool;
        }
    }
}
