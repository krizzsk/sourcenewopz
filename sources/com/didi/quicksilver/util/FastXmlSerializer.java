package com.didi.quicksilver.util;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;

public class FastXmlSerializer implements XmlSerializer {

    /* renamed from: a */
    private static final String[] f33064a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* renamed from: b */
    private static final int f33065b = 8192;

    /* renamed from: c */
    private static String f33066c = "                                                              ";

    /* renamed from: d */
    private final char[] f33067d = new char[8192];

    /* renamed from: e */
    private int f33068e;

    /* renamed from: f */
    private Writer f33069f;

    /* renamed from: g */
    private OutputStream f33070g;

    /* renamed from: h */
    private CharsetEncoder f33071h;

    /* renamed from: i */
    private ByteBuffer f33072i = ByteBuffer.allocate(8192);

    /* renamed from: j */
    private boolean f33073j = false;

    /* renamed from: k */
    private boolean f33074k;

    /* renamed from: l */
    private int f33075l = 0;

    /* renamed from: m */
    private boolean f33076m = true;

    /* renamed from: a */
    private void m23260a(char c) throws IOException {
        int i = this.f33068e;
        if (i >= 8191) {
            flush();
            i = this.f33068e;
        }
        this.f33067d[i] = c;
        this.f33068e = i + 1;
    }

    /* renamed from: a */
    private void m23263a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                m23263a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f33068e;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f33068e;
        }
        str.getChars(i, i + i2, this.f33067d, i5);
        this.f33068e = i5 + i2;
    }

    /* renamed from: a */
    private void m23264a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                m23264a(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f33068e;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f33068e;
        }
        System.arraycopy(cArr, i, this.f33067d, i5, i2);
        this.f33068e = i5 + i2;
    }

    /* renamed from: a */
    private void m23262a(String str) throws IOException {
        m23263a(str, 0, str.length());
    }

    /* renamed from: a */
    private void m23261a(int i) throws IOException {
        int i2 = i * 4;
        if (i2 > f33066c.length()) {
            i2 = f33066c.length();
        }
        m23263a(f33066c, 0, i2);
    }

    /* renamed from: b */
    private void m23265b(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f33064a;
        char length2 = (char) strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i2 < i) {
                    m23263a(str, i2, i - i2);
                }
                i2 = i + 1;
                m23262a(str2);
            }
            i++;
        }
        if (i2 < i) {
            m23263a(str, i2, i - i2);
        }
    }

    /* renamed from: b */
    private void m23266b(char[] cArr, int i, int i2) throws IOException {
        String str;
        String[] strArr = f33064a;
        char length = (char) strArr.length;
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length && (str = strArr[c]) != null) {
                if (i4 < i) {
                    m23264a(cArr, i4, i - i4);
                }
                i4 = i + 1;
                m23262a(str);
            }
            i++;
        }
        if (i4 < i) {
            m23264a(cArr, i4, i - i4);
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        m23260a(' ');
        if (str != null) {
            m23262a(str);
            m23260a(':');
        }
        m23262a(str2);
        m23262a("=\"");
        m23265b(str3);
        m23260a((char) Typography.quote);
        this.f33076m = false;
        return this;
    }

    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        int i = this.f33075l - 1;
        this.f33075l = i;
        if (this.f33074k) {
            m23262a(" />\n");
        } else {
            if (this.f33073j && this.f33076m) {
                m23261a(i);
            }
            m23262a("</");
            if (str != null) {
                m23262a(str);
                m23260a(':');
            }
            m23262a(str2);
            m23262a(">\n");
        }
        this.f33076m = true;
        this.f33074k = false;
        return this;
    }

    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    private void m23259a() throws IOException {
        int position = this.f33072i.position();
        if (position > 0) {
            this.f33072i.flip();
            this.f33070g.write(this.f33072i.array(), 0, position);
            this.f33072i.clear();
        }
    }

    public void flush() throws IOException {
        int i = this.f33068e;
        if (i > 0) {
            if (this.f33070g != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f33067d, 0, i);
                CoderResult encode = this.f33071h.encode(wrap, this.f33072i, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        m23259a();
                        encode = this.f33071h.encode(wrap, this.f33072i, true);
                    } else {
                        m23259a();
                        this.f33070g.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f33069f.write(this.f33067d, 0, i);
            this.f33069f.flush();
            this.f33068e = 0;
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            this.f33073j = true;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.f33071h = Charset.forName(str).newEncoder();
                this.f33070g = outputStream;
            } catch (IllegalCharsetNameException e) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
            } catch (UnsupportedCharsetException e2) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f33069f = writer;
    }

    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : LoginOmegaUtil.NO_EMAIL);
        sb.append("' ?>\n");
        m23262a(sb.toString());
        this.f33076m = true;
    }

    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f33074k) {
            m23262a(">\n");
        }
        if (this.f33073j) {
            m23261a(this.f33075l);
        }
        this.f33075l++;
        m23260a((char) Typography.less);
        if (str != null) {
            m23262a(str);
            m23260a(':');
        }
        m23262a(str2);
        this.f33074k = true;
        this.f33076m = false;
        return this;
    }

    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean z = false;
        if (this.f33074k) {
            m23262a(IMTextUtils.STREET_IMAGE_TAG_END);
            this.f33074k = false;
        }
        m23266b(cArr, i, i2);
        if (this.f33073j) {
            if (cArr[(i + i2) - 1] == 10) {
                z = true;
            }
            this.f33076m = z;
        }
        return this;
    }

    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean z = false;
        if (this.f33074k) {
            m23262a(IMTextUtils.STREET_IMAGE_TAG_END);
            this.f33074k = false;
        }
        m23265b(str);
        if (this.f33073j) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == 10) {
                z = true;
            }
            this.f33076m = z;
        }
        return this;
    }
}
