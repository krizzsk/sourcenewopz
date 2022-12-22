package com.p222hp.hpl.sparta;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.p222hp.hpl.sparta.xpath.Step;
import com.p222hp.hpl.sparta.xpath.XPath;
import com.p222hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.Element */
public class Element extends Node {

    /* renamed from: a */
    private static final boolean f53868a = false;

    /* renamed from: b */
    private Node f53869b = null;

    /* renamed from: c */
    private Node f53870c = null;

    /* renamed from: d */
    private Hashtable f53871d = null;

    /* renamed from: e */
    private Vector f53872e = null;

    /* renamed from: f */
    private String f53873f = null;

    /* renamed from: c */
    private void m38538c() {
    }

    public Element(String str) {
        this.f53873f = Sparta.intern(str);
    }

    Element() {
    }

    public Object clone() {
        return cloneElement(true);
    }

    public Element cloneShallow() {
        return cloneElement(false);
    }

    public Element cloneElement(boolean z) {
        Element element = new Element(this.f53873f);
        Vector vector = this.f53872e;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                element.setAttribute(str, (String) this.f53871d.get(str));
            }
        }
        if (z) {
            for (Node node = this.f53869b; node != null; node = node.getNextSibling()) {
                element.appendChild((Node) node.clone());
            }
        }
        return element;
    }

    public String getTagName() {
        return this.f53873f;
    }

    public void setTagName(String str) {
        this.f53873f = Sparta.intern(str);
        mo161689a();
    }

    public Node getFirstChild() {
        return this.f53869b;
    }

    public Node getLastChild() {
        return this.f53870c;
    }

    public Enumeration getAttributeNames() {
        Vector vector = this.f53872e;
        if (vector == null) {
            return Document.f53860a;
        }
        return vector.elements();
    }

    public String getAttribute(String str) {
        Hashtable hashtable = this.f53871d;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    public void setAttribute(String str, String str2) {
        if (this.f53871d == null) {
            this.f53871d = new Hashtable();
            this.f53872e = new Vector();
        }
        if (this.f53871d.get(str) == null) {
            this.f53872e.addElement(str);
        }
        this.f53871d.put(str, str2);
        mo161689a();
    }

    public void removeAttribute(String str) {
        Hashtable hashtable = this.f53871d;
        if (hashtable != null) {
            hashtable.remove(str);
            this.f53872e.removeElement(str);
            mo161689a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161713a(Node node) {
        Element parentNode = node.getParentNode();
        if (parentNode != null) {
            parentNode.m38539e(node);
        }
        node.mo161736c(this.f53870c);
        if (this.f53869b == null) {
            this.f53869b = node;
        }
        node.mo161734a(this);
        this.f53870c = node;
        node.mo161733a(getOwnerDocument());
    }

    public void appendChild(Node node) {
        if (!mo161715b(node)) {
            node = (Element) node.clone();
        }
        mo161713a(node);
        mo161689a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo161715b(Node node) {
        if (node == this) {
            return false;
        }
        Element parentNode = getParentNode();
        if (parentNode == null) {
            return true;
        }
        return parentNode.mo161715b(node);
    }

    /* renamed from: e */
    private boolean m38539e(Node node) {
        for (Node node2 = this.f53869b; node2 != null; node2 = node2.getNextSibling()) {
            if (node2.equals(node)) {
                if (this.f53869b == node2) {
                    this.f53869b = node2.getNextSibling();
                }
                if (this.f53870c == node2) {
                    this.f53870c = node2.getPreviousSibling();
                }
                node2.mo161735b();
                node2.mo161734a((Element) null);
                node2.mo161733a((Document) null);
                return true;
            }
        }
        return false;
    }

    public void removeChild(Node node) throws DOMException {
        if (m38539e(node)) {
            mo161689a();
            return;
        }
        throw new DOMException(8, "Cannot find " + node + " in " + this);
    }

    public void replaceChild(Element element, Node node) throws DOMException {
        m38537a((Node) element, node);
        mo161689a();
    }

    public void replaceChild(Text text, Node node) throws DOMException {
        m38537a((Node) text, node);
        mo161689a();
    }

    /* renamed from: a */
    private void m38537a(Node node, Node node2) throws DOMException {
        for (Node node3 = this.f53869b; node3 != null; node3 = node3.getNextSibling()) {
            if (node3 == node2) {
                if (this.f53869b == node2) {
                    this.f53869b = node;
                }
                if (this.f53870c == node2) {
                    this.f53870c = node;
                }
                node2.mo161737d(node);
                node.mo161734a(this);
                node2.mo161734a((Element) null);
                return;
            }
        }
        throw new DOMException(8, "Cannot find " + node2 + " in " + this);
    }

    /* access modifiers changed from: package-private */
    public void toString(Writer writer) throws IOException {
        for (Node node = this.f53869b; node != null; node = node.getNextSibling()) {
            node.toString(writer);
        }
    }

    public void toXml(Writer writer) throws IOException {
        writer.write(IMTextUtils.STREET_IMAGE_TAG_START + this.f53873f);
        Vector vector = this.f53872e;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                writer.write(" " + str + "=\"");
                htmlEncode(writer, (String) this.f53871d.get(str));
                writer.write(Const.jsQuote);
            }
        }
        if (this.f53869b == null) {
            writer.write("/>");
            return;
        }
        writer.write(IMTextUtils.STREET_IMAGE_TAG_END);
        for (Node node = this.f53869b; node != null; node = node.getNextSibling()) {
            node.toXml(writer);
        }
        writer.write("</" + this.f53873f + IMTextUtils.STREET_IMAGE_TAG_END);
    }

    /* renamed from: a */
    private XPathVisitor m38536a(String str, boolean z) throws XPathException {
        XPath xPath = XPath.get(str);
        if (xPath.isStringValue() == z) {
            return new XPathVisitor(this, xPath);
        }
        String str2 = z ? "evaluates to element not string" : "evaluates to string not element";
        throw new XPathException(xPath, Const.jsQuote + xPath + "\" evaluates to " + str2);
    }

    public Enumeration xpathSelectElements(String str) throws ParseException {
        try {
            return m38536a(str, false).mo161776a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public Enumeration xpathSelectStrings(String str) throws ParseException {
        try {
            return m38536a(str, true).mo161776a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public boolean xpathEnsure(String str) throws ParseException {
        Element element;
        try {
            if (xpathSelectElement(str) != null) {
                return false;
            }
            XPath xPath = XPath.get(str);
            Enumeration steps = xPath.getSteps();
            int i = 0;
            while (steps.hasMoreElements()) {
                steps.nextElement();
                i++;
            }
            int i2 = i - 1;
            Step[] stepArr = new Step[i2];
            Enumeration steps2 = xPath.getSteps();
            for (int i3 = 0; i3 < i2; i3++) {
                stepArr[i3] = (Step) steps2.nextElement();
            }
            Step step = (Step) steps2.nextElement();
            if (i2 == 0) {
                element = this;
            } else {
                String xPath2 = XPath.get(xPath.isAbsolute(), stepArr).toString();
                xpathEnsure(xPath2.toString());
                element = xpathSelectElement(xPath2);
            }
            element.mo161713a(mo161732a(element, step, str));
            return true;
        } catch (XPathException e) {
            throw new ParseException(str, (Throwable) e);
        }
    }

    public Element xpathSelectElement(String str) throws ParseException {
        try {
            return m38536a(str, false).mo161777b();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public String xpathSelectString(String str) throws ParseException {
        try {
            return m38536a(str, true).mo161778c();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Element)) {
            return false;
        }
        Element element = (Element) obj;
        if (!this.f53873f.equals(element.f53873f)) {
            return false;
        }
        Hashtable hashtable = this.f53871d;
        int size = hashtable == null ? 0 : hashtable.size();
        Hashtable hashtable2 = element.f53871d;
        if (size != (hashtable2 == null ? 0 : hashtable2.size())) {
            return false;
        }
        Hashtable hashtable3 = this.f53871d;
        if (hashtable3 != null) {
            Enumeration keys = hashtable3.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                if (!((String) this.f53871d.get(str)).equals((String) element.f53871d.get(str))) {
                    return false;
                }
            }
        }
        Node node = this.f53869b;
        Node node2 = element.f53869b;
        while (node != null) {
            if (!node.equals(node2)) {
                return false;
            }
            node = node.getNextSibling();
            node2 = node2.getNextSibling();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int computeHashCode() {
        int hashCode = this.f53873f.hashCode();
        Hashtable hashtable = this.f53871d;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                hashCode = (((hashCode * 31) + str.hashCode()) * 31) + ((String) this.f53871d.get(str)).hashCode();
            }
        }
        for (Node node = this.f53869b; node != null; node = node.getNextSibling()) {
            hashCode = (hashCode * 31) + node.hashCode();
        }
        return hashCode;
    }
}
