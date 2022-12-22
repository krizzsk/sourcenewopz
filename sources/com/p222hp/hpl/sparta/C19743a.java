package com.p222hp.hpl.sparta;

/* renamed from: com.hp.hpl.sparta.a */
/* compiled from: BuildDocument */
class C19743a implements ParseHandler, C19746d {

    /* renamed from: a */
    private final ParseLog f53893a;

    /* renamed from: b */
    private Element f53894b;

    /* renamed from: c */
    private final Document f53895c;

    /* renamed from: d */
    private ParseSource f53896d;

    public void endDocument() {
    }

    public void startDocument() {
    }

    public C19743a() {
        this((ParseLog) null);
    }

    public C19743a(ParseLog parseLog) {
        this.f53894b = null;
        this.f53895c = new Document();
        this.f53896d = null;
        this.f53893a = parseLog == null ? DEFAULT_LOG : parseLog;
    }

    public void setParseSource(ParseSource parseSource) {
        this.f53896d = parseSource;
        this.f53895c.setSystemId(parseSource.toString());
    }

    public ParseSource getParseSource() {
        return this.f53896d;
    }

    public String toString() {
        if (this.f53896d == null) {
            return null;
        }
        return "BuildDoc: " + this.f53896d.toString();
    }

    public String getSystemId() {
        ParseSource parseSource = this.f53896d;
        if (parseSource != null) {
            return parseSource.getSystemId();
        }
        return null;
    }

    public int getLineNumber() {
        ParseSource parseSource = this.f53896d;
        if (parseSource != null) {
            return parseSource.getLineNumber();
        }
        return -1;
    }

    /* renamed from: a */
    public Document mo161787a() {
        return this.f53895c;
    }

    public void startElement(Element element) {
        Element element2 = this.f53894b;
        if (element2 == null) {
            this.f53895c.setDocumentElement(element);
        } else {
            element2.appendChild(element);
        }
        this.f53894b = element;
    }

    public void endElement(Element element) {
        this.f53894b = this.f53894b.getParentNode();
    }

    public void characters(char[] cArr, int i, int i2) {
        Element element = this.f53894b;
        if (element.getLastChild() instanceof Text) {
            ((Text) element.getLastChild()).appendData(cArr, i, i2);
        } else {
            element.mo161713a(new Text(new String(cArr, i, i2)));
        }
    }
}
