package com.p222hp.hpl.sparta;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: com.hp.hpl.sparta.h */
/* compiled from: ParseCharStream */
class C19750h implements ParseSource {

    /* renamed from: N */
    private static final int f53914N = 255;

    /* renamed from: a */
    public static final int f53915a = 100;

    /* renamed from: b */
    private static final boolean f53916b = true;

    /* renamed from: c */
    private static final boolean f53917c = false;

    /* renamed from: d */
    private static final char[] f53918d = {'.', '-', '_', ':'};

    /* renamed from: e */
    private static final int f53919e = 128;

    /* renamed from: f */
    private static final boolean[] f53920f = new boolean[128];

    /* renamed from: g */
    private static final char[] f53921g = "<!--".toCharArray();

    /* renamed from: h */
    private static final char[] f53922h = "-->".toCharArray();

    /* renamed from: i */
    private static final char[] f53923i = "<?".toCharArray();

    /* renamed from: j */
    private static final char[] f53924j = "?>".toCharArray();

    /* renamed from: k */
    private static final char[] f53925k = "<!DOCTYPE".toCharArray();

    /* renamed from: l */
    private static final char[] f53926l = "<?xml".toCharArray();

    /* renamed from: m */
    private static final char[] f53927m = "encoding".toCharArray();

    /* renamed from: n */
    private static final char[] f53928n = "version".toCharArray();

    /* renamed from: o */
    private static final char[] f53929o = {'_', '.', ':', '-'};

    /* renamed from: p */
    private static final char[] f53930p = "<!".toCharArray();

    /* renamed from: q */
    private static final char[] f53931q = "&#".toCharArray();

    /* renamed from: r */
    private static final char[] f53932r = "<!ENTITY".toCharArray();

    /* renamed from: s */
    private static final char[] f53933s = "NDATA".toCharArray();

    /* renamed from: t */
    private static final char[] f53934t = "SYSTEM".toCharArray();

    /* renamed from: u */
    private static final char[] f53935u = "PUBLIC".toCharArray();

    /* renamed from: v */
    private static final char[] f53936v = "<![CDATA[".toCharArray();

    /* renamed from: w */
    private static final char[] f53937w = "]]>".toCharArray();

    /* renamed from: x */
    private static final char[] f53938x = "/>".toCharArray();

    /* renamed from: y */
    private static final char[] f53939y = "</".toCharArray();

    /* renamed from: A */
    private String f53940A;

    /* renamed from: B */
    private final Reader f53941B;

    /* renamed from: C */
    private final Hashtable f53942C;

    /* renamed from: D */
    private final Hashtable f53943D;

    /* renamed from: E */
    private final ParseLog f53944E;

    /* renamed from: F */
    private final String f53945F;

    /* renamed from: G */
    private int f53946G;

    /* renamed from: H */
    private boolean f53947H;

    /* renamed from: I */
    private final int f53948I;

    /* renamed from: J */
    private final char[] f53949J;

    /* renamed from: K */
    private int f53950K;

    /* renamed from: L */
    private int f53951L;

    /* renamed from: M */
    private boolean f53952M;

    /* renamed from: O */
    private final char[] f53953O;

    /* renamed from: P */
    private int f53954P;

    /* renamed from: Q */
    private final C19744b f53955Q;

    /* renamed from: R */
    private final ParseHandler f53956R;

    /* renamed from: z */
    private String f53957z;

    /* renamed from: e */
    private static boolean m38619e(char c) {
        if (c == 183 || c == 903 || c == 1600 || c == 3654 || c == 3782 || c == 12293 || c == 720 || c == 721 || c == 12445 || c == 12446) {
            return true;
        }
        switch (c) {
            case 12337:
            case 12338:
            case 12339:
            case 12340:
            case 12341:
                return true;
            default:
                switch (c) {
                    case 12540:
                    case 12541:
                    case 12542:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo161803b() {
        return "";
    }

    public C19750h(String str, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, (Reader) null, cArr, parseLog, str2, parseHandler);
    }

    public C19750h(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, reader, (char[]) null, parseLog, str2, parseHandler);
    }

    public C19750h(String str, Reader reader, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        String str3;
        this.f53940A = null;
        this.f53942C = new Hashtable();
        this.f53943D = new Hashtable();
        this.f53946G = -2;
        this.f53947H = false;
        this.f53948I = 1024;
        this.f53950K = 0;
        this.f53951L = 0;
        this.f53952M = false;
        this.f53953O = new char[255];
        this.f53954P = -1;
        this.f53954P = 1;
        this.f53955Q = null;
        this.f53944E = parseLog == null ? DEFAULT_LOG : parseLog;
        if (str2 == null) {
            str3 = null;
        } else {
            str3 = str2.toLowerCase();
        }
        this.f53945F = str3;
        this.f53942C.put("lt", IMTextUtils.STREET_IMAGE_TAG_START);
        this.f53942C.put("gt", IMTextUtils.STREET_IMAGE_TAG_END);
        this.f53942C.put("amp", ParamKeys.SIGN_AND);
        this.f53942C.put("apos", "'");
        this.f53942C.put("quot", Const.jsQuote);
        if (cArr != null) {
            this.f53949J = cArr;
            this.f53950K = 0;
            this.f53951L = cArr.length;
            this.f53952M = true;
            this.f53941B = null;
        } else {
            this.f53941B = reader;
            this.f53949J = new char[1024];
            m38616d();
        }
        this.f53957z = str;
        this.f53956R = parseHandler;
        parseHandler.setParseSource(this);
        m38636v();
        this.f53956R.startDocument();
        Element X = m38599X();
        String str4 = this.f53940A;
        if (str4 != null && !str4.equals(X.getTagName())) {
            this.f53944E.warning("DOCTYPE name \"" + this.f53940A + "\" not same as tag name, \"" + X.getTagName() + "\" of root element", this.f53957z, getLineNumber());
        }
        while (m38630p()) {
            m38631q();
        }
        Reader reader2 = this.f53941B;
        if (reader2 != null) {
            reader2.close();
        }
        this.f53956R.endDocument();
    }

    public String toString() {
        return this.f53957z;
    }

    public String getSystemId() {
        return this.f53957z;
    }

    public int getLineNumber() {
        return this.f53954P;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo161802a() {
        return this.f53946G;
    }

    /* renamed from: d */
    private int m38616d() throws IOException {
        if (this.f53952M) {
            return -1;
        }
        if (this.f53951L == this.f53949J.length) {
            this.f53951L = 0;
            this.f53950K = 0;
        }
        Reader reader = this.f53941B;
        char[] cArr = this.f53949J;
        int i = this.f53951L;
        int read = reader.read(cArr, i, cArr.length - i);
        if (read <= 0) {
            this.f53952M = true;
            return -1;
        }
        this.f53951L += read;
        return read;
    }

    /* renamed from: a */
    private int m38604a(int i) throws IOException {
        int i2;
        int i3;
        if (this.f53952M) {
            return -1;
        }
        int i4 = 0;
        if (this.f53949J.length - this.f53950K < i) {
            int i5 = 0;
            while (true) {
                i2 = this.f53950K;
                int i6 = i2 + i5;
                i3 = this.f53951L;
                if (i6 >= i3) {
                    break;
                }
                char[] cArr = this.f53949J;
                cArr[i5] = cArr[i2 + i5];
                i5++;
            }
            int i7 = i3 - i2;
            this.f53951L = i7;
            this.f53950K = 0;
            i4 = i7;
        }
        int d = m38616d();
        if (d != -1) {
            return i4 + d;
        }
        if (i4 == 0) {
            return -1;
        }
        return i4;
    }

    /* renamed from: e */
    private final char m38618e() throws ParseException, IOException {
        if (this.f53950K < this.f53951L || m38616d() != -1) {
            if (this.f53949J[this.f53950K] == 10) {
                this.f53954P++;
            }
            char[] cArr = this.f53949J;
            int i = this.f53950K;
            this.f53950K = i + 1;
            return cArr[i];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: f */
    private final char m38620f() throws ParseException, IOException {
        if (this.f53950K < this.f53951L || m38616d() != -1) {
            return this.f53949J[this.f53950K];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: a */
    private final void m38605a(char c) throws ParseException, IOException {
        char e = m38618e();
        if (e != c) {
            throw new ParseException(this, e, c);
        }
    }

    /* renamed from: b */
    private final boolean m38610b(char c) throws ParseException, IOException {
        if (this.f53950K < this.f53951L || m38616d() != -1) {
            return this.f53949J[this.f53950K] == c;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: a */
    private final char m38602a(char c, char c2) throws ParseException, IOException {
        char e = m38618e();
        if (e == c || e == c2) {
            return e;
        }
        throw new ParseException(this, e, new char[]{c, c2});
    }

    /* renamed from: a */
    private final char m38603a(char c, char c2, char c3, char c4) throws ParseException, IOException {
        char e = m38618e();
        if (e == c || e == c2 || e == c3 || e == c4) {
            return e;
        }
        throw new ParseException(this, e, new char[]{c, c2, c3, c4});
    }

    /* renamed from: b */
    private final boolean m38611b(char c, char c2) throws ParseException, IOException {
        if (this.f53950K >= this.f53951L && m38616d() == -1) {
            return false;
        }
        char c3 = this.f53949J[this.f53950K];
        if (c3 == c || c3 == c2) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private final boolean m38612b(char c, char c2, char c3, char c4) throws ParseException, IOException {
        if (this.f53950K >= this.f53951L && m38616d() == -1) {
            return false;
        }
        char c5 = this.f53949J[this.f53950K];
        if (c5 == c || c5 == c2 || c5 == c3 || c5 == c4) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static final boolean m38607a(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private final void m38621g() throws ParseException, IOException {
        m38603a(' ', 9, CharUtils.f5620CR, 10);
        while (m38612b(' ', 9, CharUtils.f5620CR, 10)) {
            m38618e();
        }
    }

    /* renamed from: h */
    private final boolean m38622h() throws ParseException, IOException {
        return m38612b(' ', 9, CharUtils.f5620CR, 10);
    }

    static {
        for (char c = 0; c < 128; c = (char) (c + 1)) {
            f53920f[c] = m38617d(c);
        }
    }

    /* renamed from: i */
    private boolean m38623i() throws ParseException, IOException {
        char f = m38620f();
        return f < 128 ? f53920f[f] : m38617d(f);
    }

    /* renamed from: c */
    private static boolean m38615c(char c) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c)) != -1;
    }

    /* renamed from: d */
    private static boolean m38617d(char c) {
        return Character.isDigit(c) || m38615c(c) || m38607a(c, f53918d) || m38619e(c);
    }

    /* renamed from: j */
    private final String m38624j() throws ParseException, IOException {
        this.f53953O[0] = m38625k();
        int i = 1;
        StringBuffer stringBuffer = null;
        while (m38623i()) {
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f53953O, 0, i);
                } else {
                    stringBuffer.append(this.f53953O, 0, i);
                }
                i = 0;
            }
            this.f53953O[i] = m38618e();
            i++;
        }
        if (stringBuffer == null) {
            return Sparta.intern(new String(this.f53953O, 0, i));
        }
        stringBuffer.append(this.f53953O, 0, i);
        return stringBuffer.toString();
    }

    /* renamed from: k */
    private char m38625k() throws ParseException, IOException {
        char e = m38618e();
        if (m38615c(e) || e == '_' || e == ':') {
            return e;
        }
        throw new ParseException(this, e, "letter, underscore, colon");
    }

    /* renamed from: l */
    private final String m38626l() throws ParseException, IOException {
        char a = m38602a('\'', (char) Typography.quote);
        StringBuffer stringBuffer = new StringBuffer();
        while (!m38610b(a)) {
            if (m38590O()) {
                stringBuffer.append(m38589N());
            } else if (m38587L()) {
                stringBuffer.append(m38586K());
            } else {
                stringBuffer.append(m38618e());
            }
        }
        m38605a(a);
        return stringBuffer.toString();
    }

    /* renamed from: m */
    private final boolean m38627m() throws ParseException, IOException {
        return m38611b('\'', Typography.quote);
    }

    /* renamed from: n */
    private final void m38628n() throws ParseException, IOException {
        char e = m38618e();
        while (m38620f() != e) {
            m38618e();
        }
        m38605a(e);
    }

    /* renamed from: o */
    private final void m38629o() throws ParseException, IOException {
        m38628n();
    }

    /* renamed from: p */
    private boolean m38630p() throws ParseException, IOException {
        return m38633s() || m38635u() || m38622h();
    }

    /* renamed from: q */
    private void m38631q() throws ParseException, IOException {
        if (m38633s()) {
            m38632r();
        } else if (m38635u()) {
            m38634t();
        } else if (m38622h()) {
            m38621g();
        } else {
            throw new ParseException(this, "expecting comment or processing instruction or space");
        }
    }

    /* renamed from: r */
    private final void m38632r() throws ParseException, IOException {
        m38606a(f53921g);
        while (!m38613b(f53922h)) {
            m38618e();
        }
        m38606a(f53922h);
    }

    /* renamed from: s */
    private final boolean m38633s() throws ParseException, IOException {
        return m38613b(f53921g);
    }

    /* renamed from: t */
    private final void m38634t() throws ParseException, IOException {
        m38606a(f53923i);
        while (!m38613b(f53924j)) {
            m38618e();
        }
        m38606a(f53924j);
    }

    /* renamed from: u */
    private final boolean m38635u() throws ParseException, IOException {
        return m38613b(f53923i);
    }

    /* renamed from: v */
    private void m38636v() throws ParseException, EncodingMismatchException, IOException {
        if (m38639y()) {
            m38638x();
        }
        while (m38630p()) {
            m38631q();
        }
        if (m38637w()) {
            m38581F();
            while (m38630p()) {
                m38631q();
            }
        }
    }

    /* renamed from: w */
    private boolean m38637w() throws ParseException, IOException {
        return m38613b(f53925k);
    }

    /* renamed from: x */
    private void m38638x() throws ParseException, EncodingMismatchException, IOException {
        m38606a(f53926l);
        m38577B();
        if (m38622h()) {
            m38621g();
        }
        if (m38640z()) {
            String A = m38576A();
            if (this.f53945F != null && !A.toLowerCase().equals(this.f53945F)) {
                throw new EncodingMismatchException(this.f53957z, A, this.f53945F);
            }
        }
        while (!m38613b(f53924j)) {
            m38618e();
        }
        m38606a(f53924j);
    }

    /* renamed from: y */
    private boolean m38639y() throws ParseException, IOException {
        return m38613b(f53926l);
    }

    /* renamed from: z */
    private boolean m38640z() throws ParseException, IOException {
        return m38613b(f53927m);
    }

    /* renamed from: A */
    private String m38576A() throws ParseException, IOException {
        m38606a(f53927m);
        m38578C();
        char a = m38602a('\'', (char) Typography.quote);
        StringBuffer stringBuffer = new StringBuffer();
        while (!m38610b(a)) {
            stringBuffer.append(m38618e());
        }
        m38605a(a);
        return stringBuffer.toString();
    }

    /* renamed from: B */
    private void m38577B() throws ParseException, IOException {
        m38621g();
        m38606a(f53928n);
        m38578C();
        char a = m38602a('\'', (char) Typography.quote);
        m38580E();
        m38605a(a);
    }

    /* renamed from: C */
    private final void m38578C() throws ParseException, IOException {
        if (m38622h()) {
            m38621g();
        }
        m38605a('=');
        if (m38622h()) {
            m38621g();
        }
    }

    /* renamed from: D */
    private boolean m38579D() throws ParseException, IOException {
        char f = m38620f();
        return Character.isDigit(f) || ('a' <= f && f <= 'z') || (('Z' <= f && f <= 'Z') || m38607a(f, f53929o));
    }

    /* renamed from: E */
    private void m38580E() throws ParseException, IOException {
        m38618e();
        while (m38579D()) {
            m38618e();
        }
    }

    /* renamed from: F */
    private void m38581F() throws ParseException, IOException {
        m38606a(f53925k);
        m38621g();
        this.f53940A = m38624j();
        if (m38622h()) {
            m38621g();
            if (!m38610b((char) Typography.greater) && !m38610b((char) VersionRange.LEFT_CLOSED)) {
                this.f53947H = true;
                m38593R();
                if (m38622h()) {
                    m38621g();
                }
            }
        }
        if (m38610b((char) VersionRange.LEFT_CLOSED)) {
            m38618e();
            while (!m38610b((char) VersionRange.RIGHT_CLOSED)) {
                if (m38583H()) {
                    m38582G();
                } else {
                    m38584I();
                }
            }
            m38605a((char) VersionRange.RIGHT_CLOSED);
            if (m38622h()) {
                m38621g();
            }
        }
        m38605a((char) Typography.greater);
    }

    /* renamed from: G */
    private void m38582G() throws ParseException, IOException {
        if (m38590O()) {
            m38589N();
        } else {
            m38621g();
        }
    }

    /* renamed from: H */
    private boolean m38583H() throws ParseException, IOException {
        return m38590O() || m38622h();
    }

    /* renamed from: I */
    private void m38584I() throws ParseException, IOException {
        if (m38635u()) {
            m38634t();
        } else if (m38633s()) {
            m38632r();
        } else if (m38592Q()) {
            m38591P();
        } else if (m38613b(f53930p)) {
            while (!m38610b((char) Typography.greater)) {
                if (m38611b('\'', Typography.quote)) {
                    char e = m38618e();
                    while (!m38610b(e)) {
                        m38618e();
                    }
                    m38605a(e);
                } else {
                    m38618e();
                }
            }
            m38605a((char) Typography.greater);
        } else {
            throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
        }
    }

    /* renamed from: J */
    private char m38585J() throws ParseException, IOException {
        int i;
        m38606a(f53931q);
        if (m38610b('x')) {
            m38618e();
            i = 16;
        } else {
            i = 10;
        }
        int i2 = 0;
        while (!m38610b(';')) {
            int i3 = i2 + 1;
            this.f53953O[i2] = m38618e();
            if (i3 >= 255) {
                this.f53944E.warning("Tmp buffer overflow on readCharRef", this.f53957z, getLineNumber());
                return ' ';
            }
            i2 = i3;
        }
        m38605a(';');
        String str = new String(this.f53953O, 0, i2);
        try {
            return (char) Integer.parseInt(str, i);
        } catch (NumberFormatException unused) {
            ParseLog parseLog = this.f53944E;
            StringBuilder sb = new StringBuilder();
            sb.append(Const.jsQuote);
            sb.append(str);
            sb.append("\" is not a valid ");
            sb.append(i == 16 ? "hexadecimal" : "decimal");
            sb.append(" number");
            parseLog.warning(sb.toString(), this.f53957z, getLineNumber());
            return ' ';
        }
    }

    /* renamed from: K */
    private final char[] m38586K() throws ParseException, IOException {
        if (!m38613b(f53931q)) {
            return m38588M().toCharArray();
        }
        return new char[]{m38585J()};
    }

    /* renamed from: L */
    private final boolean m38587L() throws ParseException, IOException {
        return m38610b((char) Typography.amp);
    }

    /* renamed from: M */
    private String m38588M() throws ParseException, IOException {
        m38605a((char) Typography.amp);
        String j = m38624j();
        String str = (String) this.f53942C.get(j);
        if (str == null) {
            if (this.f53947H) {
                ParseLog parseLog = this.f53944E;
                parseLog.warning(ParamKeys.SIGN_AND + j + "; not found -- possibly defined in external DTD)", this.f53957z, getLineNumber());
            } else {
                ParseLog parseLog2 = this.f53944E;
                parseLog2.warning("No declaration of &" + j + ";", this.f53957z, getLineNumber());
            }
            str = "";
        }
        m38605a(';');
        return str;
    }

    /* renamed from: N */
    private String m38589N() throws ParseException, IOException {
        m38605a('%');
        String j = m38624j();
        String str = (String) this.f53943D.get(j);
        if (str == null) {
            ParseLog parseLog = this.f53944E;
            parseLog.warning("No declaration of %" + j + ";", this.f53957z, getLineNumber());
            str = "";
        }
        m38605a(';');
        return str;
    }

    /* renamed from: O */
    private boolean m38590O() throws ParseException, IOException {
        return m38610b('%');
    }

    /* renamed from: P */
    private void m38591P() throws ParseException, IOException {
        String str;
        String str2;
        m38606a(f53932r);
        m38621g();
        if (m38610b('%')) {
            m38605a('%');
            m38621g();
            String j = m38624j();
            m38621g();
            if (m38627m()) {
                str2 = m38626l();
            } else {
                str2 = m38593R();
            }
            this.f53943D.put(j, str2);
        } else {
            String j2 = m38624j();
            m38621g();
            if (m38627m()) {
                str = m38626l();
            } else if (m38594S()) {
                str = m38593R();
                if (m38622h()) {
                    m38621g();
                }
                if (m38613b(f53933s)) {
                    m38606a(f53933s);
                    m38621g();
                    m38624j();
                }
            } else {
                throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
            }
            this.f53942C.put(j2, str);
        }
        if (m38622h()) {
            m38621g();
        }
        m38605a((char) Typography.greater);
    }

    /* renamed from: Q */
    private boolean m38592Q() throws ParseException, IOException {
        return m38613b(f53932r);
    }

    /* renamed from: R */
    private String m38593R() throws ParseException, IOException {
        if (m38613b(f53934t)) {
            m38606a(f53934t);
        } else if (m38613b(f53935u)) {
            m38606a(f53935u);
            m38621g();
            m38629o();
        } else {
            throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
        }
        m38621g();
        m38628n();
        return "(WARNING: external ID not read)";
    }

    /* renamed from: S */
    private boolean m38594S() throws ParseException, IOException {
        return m38613b(f53934t) || m38613b(f53935u);
    }

    /* renamed from: a */
    private final void m38606a(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f53951L - this.f53950K >= length || m38604a(length) > 0) {
            char[] cArr2 = this.f53949J;
            int i = this.f53951L;
            this.f53946G = cArr2[i - 1];
            if (i - this.f53950K >= length) {
                int i2 = 0;
                while (i2 < length) {
                    if (this.f53949J[this.f53950K + i2] == cArr[i2]) {
                        i2++;
                    } else {
                        throw new ParseException(this, new String(this.f53949J, this.f53950K, length), cArr);
                    }
                }
                this.f53950K += length;
                return;
            }
            throw new ParseException(this, "end of XML file", cArr);
        }
        this.f53946G = -1;
        throw new ParseException(this, "end of XML file", cArr);
    }

    /* renamed from: b */
    private final boolean m38613b(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f53951L - this.f53950K >= length || m38604a(length) > 0) {
            char[] cArr2 = this.f53949J;
            int i = this.f53951L;
            this.f53946G = cArr2[i - 1];
            if (i - this.f53950K < length) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f53949J[this.f53950K + i2] != cArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        this.f53946G = -1;
        return false;
    }

    /* renamed from: T */
    private String m38595T() throws ParseException, IOException {
        char a = m38602a('\'', (char) Typography.quote);
        StringBuffer stringBuffer = new StringBuffer();
        while (!m38610b(a)) {
            if (m38587L()) {
                stringBuffer.append(m38586K());
            } else {
                stringBuffer.append(m38618e());
            }
        }
        m38605a(a);
        return stringBuffer.toString();
    }

    /* renamed from: U */
    private void m38596U() throws ParseException, IOException {
        int i;
        loop0:
        while (true) {
            i = 0;
            while (!m38610b((char) Typography.less) && !m38610b((char) Typography.amp) && !m38613b(f53937w)) {
                this.f53953O[i] = m38618e();
                if (this.f53953O[i] == 13 && m38620f() == 10) {
                    this.f53953O[i] = m38618e();
                }
                i++;
                if (i == 255) {
                    this.f53956R.characters(this.f53953O, 0, 255);
                }
            }
        }
        if (i > 0) {
            this.f53956R.characters(this.f53953O, 0, i);
        }
    }

    /* renamed from: V */
    private void m38597V() throws ParseException, IOException {
        m38606a(f53936v);
        StringBuffer stringBuffer = null;
        int i = 0;
        while (!m38613b(f53937w)) {
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f53953O, 0, i);
                } else {
                    stringBuffer.append(this.f53953O, 0, i);
                }
                i = 0;
            }
            this.f53953O[i] = m38618e();
            i++;
        }
        m38606a(f53937w);
        if (stringBuffer != null) {
            stringBuffer.append(this.f53953O, 0, i);
            char[] charArray = stringBuffer.toString().toCharArray();
            this.f53956R.characters(charArray, 0, charArray.length);
            return;
        }
        this.f53956R.characters(this.f53953O, 0, i);
    }

    /* renamed from: W */
    private boolean m38598W() throws ParseException, IOException {
        return m38613b(f53936v);
    }

    /* renamed from: X */
    private final Element m38599X() throws ParseException, IOException {
        Element element = new Element();
        boolean a = m38608a(element);
        this.f53956R.startElement(element);
        if (a) {
            m38601Z();
            m38614c(element);
        }
        this.f53956R.endElement(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ParseLog mo161804c() {
        return this.f53944E;
    }

    /* renamed from: a */
    private boolean m38608a(Element element) throws ParseException, IOException {
        m38605a((char) Typography.less);
        element.setTagName(m38624j());
        while (m38622h()) {
            m38621g();
            if (!m38611b(IOUtils.DIR_SEPARATOR_UNIX, Typography.greater)) {
                m38609b(element);
            }
        }
        if (m38622h()) {
            m38621g();
        }
        boolean b = m38610b((char) Typography.greater);
        if (b) {
            m38605a((char) Typography.greater);
        } else {
            m38606a(f53938x);
        }
        return b;
    }

    /* renamed from: b */
    private void m38609b(Element element) throws ParseException, IOException {
        String j = m38624j();
        m38578C();
        String T = m38595T();
        if (element.getAttribute(j) != null) {
            ParseLog parseLog = this.f53944E;
            parseLog.warning("Element " + this + " contains attribute " + j + "more than once", this.f53957z, getLineNumber());
        }
        element.setAttribute(j, T);
    }

    /* renamed from: c */
    private void m38614c(Element element) throws ParseException, IOException {
        m38606a(f53939y);
        String j = m38624j();
        if (!j.equals(element.getTagName())) {
            ParseLog parseLog = this.f53944E;
            parseLog.warning("end tag (" + j + ") does not match begin tag (" + element.getTagName() + ")", this.f53957z, getLineNumber());
        }
        if (m38622h()) {
            m38621g();
        }
        m38605a((char) Typography.greater);
    }

    /* renamed from: Y */
    private boolean m38600Y() throws ParseException, IOException {
        return m38613b(f53939y);
    }

    /* renamed from: Z */
    private void m38601Z() throws ParseException, IOException {
        m38596U();
        boolean z = true;
        while (z) {
            if (!m38600Y()) {
                if (m38587L()) {
                    char[] K = m38586K();
                    this.f53956R.characters(K, 0, K.length);
                } else if (m38598W()) {
                    m38597V();
                } else if (m38635u()) {
                    m38634t();
                } else if (m38633s()) {
                    m38632r();
                } else if (m38610b((char) Typography.less)) {
                    m38599X();
                }
                m38596U();
            }
            z = false;
            m38596U();
        }
    }
}
