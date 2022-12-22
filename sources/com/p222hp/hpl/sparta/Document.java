package com.p222hp.hpl.sparta;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.p222hp.hpl.sparta.Sparta;
import com.p222hp.hpl.sparta.xpath.Step;
import com.p222hp.hpl.sparta.xpath.XPath;
import com.p222hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.Document */
public class Document extends Node {

    /* renamed from: a */
    static final Enumeration f53860a = new C19747e();

    /* renamed from: b */
    private static final boolean f53861b = false;

    /* renamed from: c */
    private static final Integer f53862c = new Integer(1);

    /* renamed from: d */
    private Element f53863d;

    /* renamed from: e */
    private String f53864e;

    /* renamed from: f */
    private Sparta.Cache f53865f;

    /* renamed from: g */
    private Vector f53866g;

    /* renamed from: h */
    private final Hashtable f53867h;

    /* renamed from: com.hp.hpl.sparta.Document$Observer */
    public interface Observer {
        void update(Document document);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161690a(XPath xPath) throws XPathException {
    }

    Document(String str) {
        this.f53863d = null;
        this.f53865f = Sparta.m38549a();
        this.f53866g = new Vector();
        this.f53867h = null;
        this.f53864e = str;
    }

    public Document() {
        this.f53863d = null;
        this.f53865f = Sparta.m38549a();
        this.f53866g = new Vector();
        this.f53867h = null;
        this.f53864e = "MEMORY";
    }

    public Object clone() {
        Document document = new Document(this.f53864e);
        document.f53863d = (Element) this.f53863d.clone();
        return document;
    }

    public String getSystemId() {
        return this.f53864e;
    }

    public void setSystemId(String str) {
        this.f53864e = str;
        mo161689a();
    }

    public String toString() {
        return this.f53864e;
    }

    public Element getDocumentElement() {
        return this.f53863d;
    }

    public void setDocumentElement(Element element) {
        this.f53863d = element;
        element.mo161733a(this);
        mo161689a();
    }

    /* renamed from: a */
    private XPathVisitor m38532a(String str, boolean z) throws XPathException {
        if (str.charAt(0) != '/') {
            str = "/" + str;
        }
        return mo161688a(XPath.get(str), z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public XPathVisitor mo161688a(XPath xPath, boolean z) throws XPathException {
        if (xPath.isStringValue() == z) {
            return new XPathVisitor(this, xPath);
        }
        String str = z ? "evaluates to element not string" : "evaluates to string not element";
        throw new XPathException(xPath, Const.jsQuote + xPath + "\" evaluates to " + str);
    }

    public Enumeration xpathSelectElements(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            XPath xPath = XPath.get(str);
            mo161690a(xPath);
            return mo161688a(xPath, false).mo161776a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public Enumeration xpathSelectStrings(String str) throws ParseException {
        try {
            return m38532a(str, true).mo161776a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public Element xpathSelectElement(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            XPath xPath = XPath.get(str);
            mo161690a(xPath);
            return mo161688a(xPath, false).mo161777b();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public String xpathSelectString(String str) throws ParseException {
        try {
            return m38532a(str, true).mo161778c();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public boolean xpathEnsure(String str) throws ParseException {
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
            Enumeration steps2 = xPath.getSteps();
            Step step = (Step) steps2.nextElement();
            int i2 = i - 1;
            Step[] stepArr = new Step[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                stepArr[i3] = (Step) steps2.nextElement();
            }
            if (this.f53863d == null) {
                setDocumentElement(mo161732a((Element) null, step, str));
            } else {
                if (xpathSelectElement("/" + step) == null) {
                    throw new ParseException("Existing root element <" + this.f53863d.getTagName() + "...> does not match first step \"" + step + "\" of \"" + str);
                }
            }
            if (i2 == 0) {
                return true;
            }
            return this.f53863d.xpathEnsure(XPath.get(false, stepArr).toString());
        } catch (XPathException e) {
            throw new ParseException(str, (Throwable) e);
        }
    }

    /* renamed from: com.hp.hpl.sparta.Document$Index */
    public class Index implements Observer {
        private final String attrName_;
        private transient Sparta.Cache dict_ = null;
        private final XPath xpath_;

        Index(XPath xPath) throws XPathException {
            this.attrName_ = xPath.getIndexingAttrName();
            this.xpath_ = xPath;
            Document.this.addObserver(this);
        }

        public synchronized Enumeration get(String str) throws ParseException {
            Vector vector;
            if (this.dict_ == null) {
                regenerate();
            }
            vector = (Vector) this.dict_.get(str);
            return vector == null ? Document.f53860a : vector.elements();
        }

        public synchronized int size() throws ParseException {
            if (this.dict_ == null) {
                regenerate();
            }
            return this.dict_.size();
        }

        public synchronized void update(Document document) {
            this.dict_ = null;
        }

        private void regenerate() throws ParseException {
            try {
                this.dict_ = Sparta.m38549a();
                Enumeration a = Document.this.mo161688a(this.xpath_, false).mo161776a();
                while (a.hasMoreElements()) {
                    Element element = (Element) a.nextElement();
                    String attribute = element.getAttribute(this.attrName_);
                    Vector vector = (Vector) this.dict_.get(attribute);
                    if (vector == null) {
                        vector = new Vector(1);
                        this.dict_.put(attribute, vector);
                    }
                    vector.addElement(element);
                }
            } catch (XPathException e) {
                throw new ParseException("XPath problem", (Throwable) e);
            }
        }
    }

    public boolean xpathHasIndex(String str) {
        return this.f53865f.get(str) != null;
    }

    public Index xpathGetIndex(String str) throws ParseException {
        try {
            Index index = (Index) this.f53865f.get(str);
            if (index != null) {
                return index;
            }
            Index index2 = new Index(XPath.get(str));
            this.f53865f.put(str, index2);
            return index2;
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public void addObserver(Observer observer) {
        this.f53866g.addElement(observer);
    }

    public void deleteObserver(Observer observer) {
        this.f53866g.removeElement(observer);
    }

    public void toString(Writer writer) throws IOException {
        this.f53863d.toString(writer);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo161689a() {
        Enumeration elements = this.f53866g.elements();
        while (elements.hasMoreElements()) {
            ((Observer) elements.nextElement()).update(this);
        }
    }

    public void toXml(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.f53863d.toXml(writer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Document)) {
            return false;
        }
        return this.f53863d.equals(((Document) obj).f53863d);
    }

    /* access modifiers changed from: protected */
    public int computeHashCode() {
        return this.f53863d.hashCode();
    }
}
