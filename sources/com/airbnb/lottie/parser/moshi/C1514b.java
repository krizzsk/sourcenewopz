package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.CharUtils;

/* renamed from: com.airbnb.lottie.parser.moshi.b */
/* compiled from: JsonUtf8Reader */
final class C1514b extends JsonReader {

    /* renamed from: A */
    private static final int f1633A = 14;

    /* renamed from: B */
    private static final int f1634B = 15;

    /* renamed from: C */
    private static final int f1635C = 16;

    /* renamed from: D */
    private static final int f1636D = 17;

    /* renamed from: E */
    private static final int f1637E = 18;

    /* renamed from: F */
    private static final int f1638F = 0;

    /* renamed from: G */
    private static final int f1639G = 1;

    /* renamed from: H */
    private static final int f1640H = 2;

    /* renamed from: I */
    private static final int f1641I = 3;

    /* renamed from: J */
    private static final int f1642J = 4;

    /* renamed from: K */
    private static final int f1643K = 5;

    /* renamed from: L */
    private static final int f1644L = 6;

    /* renamed from: M */
    private static final int f1645M = 7;

    /* renamed from: g */
    private static final long f1646g = -922337203685477580L;

    /* renamed from: h */
    private static final ByteString f1647h = ByteString.encodeUtf8("'\\");

    /* renamed from: i */
    private static final ByteString f1648i = ByteString.encodeUtf8("\"\\");

    /* renamed from: j */
    private static final ByteString f1649j = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: k */
    private static final ByteString f1650k = ByteString.encodeUtf8("\n\r");

    /* renamed from: l */
    private static final ByteString f1651l = ByteString.encodeUtf8("*/");

    /* renamed from: m */
    private static final int f1652m = 0;

    /* renamed from: n */
    private static final int f1653n = 1;

    /* renamed from: o */
    private static final int f1654o = 2;

    /* renamed from: p */
    private static final int f1655p = 3;

    /* renamed from: q */
    private static final int f1656q = 4;

    /* renamed from: r */
    private static final int f1657r = 5;

    /* renamed from: s */
    private static final int f1658s = 6;

    /* renamed from: t */
    private static final int f1659t = 7;

    /* renamed from: u */
    private static final int f1660u = 8;

    /* renamed from: v */
    private static final int f1661v = 9;

    /* renamed from: w */
    private static final int f1662w = 10;

    /* renamed from: x */
    private static final int f1663x = 11;

    /* renamed from: y */
    private static final int f1664y = 12;

    /* renamed from: z */
    private static final int f1665z = 13;

    /* renamed from: N */
    private final BufferedSource f1666N;

    /* renamed from: O */
    private final Buffer f1667O;

    /* renamed from: P */
    private int f1668P = 0;

    /* renamed from: Q */
    private long f1669Q;

    /* renamed from: R */
    private int f1670R;

    /* renamed from: S */
    private String f1671S;

    C1514b(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f1666N = bufferedSource;
            this.f1667O = bufferedSource.getBuffer();
            mo15468a(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    public void beginArray() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 3) {
            mo15468a(1);
            this.f1622d[this.f1619a - 1] = 0;
            this.f1668P = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
    }

    public void endArray() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 4) {
            this.f1619a--;
            int[] iArr = this.f1622d;
            int i2 = this.f1619a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1668P = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
    }

    public void beginObject() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 1) {
            mo15468a(3);
            this.f1668P = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    public void endObject() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 2) {
            this.f1619a--;
            this.f1621c[this.f1619a] = null;
            int[] iArr = this.f1622d;
            int i2 = this.f1619a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f1668P = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
    }

    public boolean hasNext() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    public JsonReader.Token peek() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        switch (i) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: a */
    private int m1438a() throws IOException {
        int i = this.f1620b[this.f1619a - 1];
        if (i == 1) {
            this.f1620b[this.f1619a - 1] = 2;
        } else if (i == 2) {
            int a = m1440a(true);
            this.f1667O.readByte();
            if (a != 44) {
                if (a == 59) {
                    m1449f();
                } else if (a == 93) {
                    this.f1668P = 4;
                    return 4;
                } else {
                    throw mo15467a("Unterminated array");
                }
            }
        } else if (i == 3 || i == 5) {
            this.f1620b[this.f1619a - 1] = 4;
            if (i == 5) {
                int a2 = m1440a(true);
                this.f1667O.readByte();
                if (a2 != 44) {
                    if (a2 == 59) {
                        m1449f();
                    } else if (a2 == 125) {
                        this.f1668P = 2;
                        return 2;
                    } else {
                        throw mo15467a("Unterminated object");
                    }
                }
            }
            int a3 = m1440a(true);
            if (a3 == 34) {
                this.f1667O.readByte();
                this.f1668P = 13;
                return 13;
            } else if (a3 == 39) {
                this.f1667O.readByte();
                m1449f();
                this.f1668P = 12;
                return 12;
            } else if (a3 != 125) {
                m1449f();
                if (m1445b((int) (char) a3)) {
                    this.f1668P = 14;
                    return 14;
                }
                throw mo15467a("Expected name");
            } else if (i != 5) {
                this.f1667O.readByte();
                this.f1668P = 2;
                return 2;
            } else {
                throw mo15467a("Expected name");
            }
        } else if (i == 4) {
            this.f1620b[this.f1619a - 1] = 5;
            int a4 = m1440a(true);
            this.f1667O.readByte();
            if (a4 != 58) {
                if (a4 == 61) {
                    m1449f();
                    if (this.f1666N.request(1) && this.f1667O.getByte(0) == 62) {
                        this.f1667O.readByte();
                    }
                } else {
                    throw mo15467a("Expected ':'");
                }
            }
        } else if (i == 6) {
            this.f1620b[this.f1619a - 1] = 7;
        } else if (i == 7) {
            if (m1440a(false) == -1) {
                this.f1668P = 18;
                return 18;
            }
            m1449f();
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int a5 = m1440a(true);
        if (a5 == 34) {
            this.f1667O.readByte();
            this.f1668P = 9;
            return 9;
        } else if (a5 != 39) {
            if (!(a5 == 44 || a5 == 59)) {
                if (a5 == 91) {
                    this.f1667O.readByte();
                    this.f1668P = 3;
                    return 3;
                } else if (a5 != 93) {
                    if (a5 != 123) {
                        int b = m1442b();
                        if (b != 0) {
                            return b;
                        }
                        int c = m1446c();
                        if (c != 0) {
                            return c;
                        }
                        if (m1445b((int) this.f1667O.getByte(0))) {
                            m1449f();
                            this.f1668P = 10;
                            return 10;
                        }
                        throw mo15467a("Expected value");
                    }
                    this.f1667O.readByte();
                    this.f1668P = 1;
                    return 1;
                } else if (i == 1) {
                    this.f1667O.readByte();
                    this.f1668P = 4;
                    return 4;
                }
            }
            if (i == 1 || i == 2) {
                m1449f();
                this.f1668P = 7;
                return 7;
            }
            throw mo15467a("Unexpected value");
        } else {
            m1449f();
            this.f1667O.readByte();
            this.f1668P = 8;
            return 8;
        }
    }

    /* renamed from: b */
    private int m1442b() throws IOException {
        String str;
        String str2;
        int i;
        byte b = this.f1667O.getByte(0);
        if (b == 116 || b == 84) {
            i = 5;
            str2 = "true";
            str = "TRUE";
        } else if (b == 102 || b == 70) {
            i = 6;
            str2 = SDKConsts.BOOLEAN_FALSE;
            str = "FALSE";
        } else if (b != 110 && b != 78) {
            return 0;
        } else {
            i = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.f1666N.request((long) i3)) {
                return 0;
            }
            byte b2 = this.f1667O.getByte((long) i2);
            if (b2 != str2.charAt(i2) && b2 != str.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.f1666N.request((long) (length + 1)) && m1445b((int) this.f1667O.getByte((long) length))) {
            return 0;
        }
        this.f1667O.skip((long) length);
        this.f1668P = i;
        return i;
    }

    /* renamed from: c */
    private int m1446c() throws IOException {
        byte b;
        boolean z = true;
        int i = 0;
        long j = 0;
        int i2 = 0;
        char c = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i3 = i2 + 1;
            if (!this.f1666N.request((long) i3)) {
                break;
            }
            b = this.f1667O.getByte((long) i2);
            if (b != 43) {
                if (b != 69 && b != 101) {
                    if (b != 45) {
                        if (b != 46) {
                            if (b >= 48 && b <= 57) {
                                if (c == z || c == 0) {
                                    j = (long) (-(b - 48));
                                    i = 0;
                                    c = 2;
                                } else {
                                    if (c == 2) {
                                        if (j == 0) {
                                            return i;
                                        }
                                        long j2 = (10 * j) - ((long) (b - 48));
                                        int i4 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                                        z2 &= i4 > 0 || (i4 == 0 && j2 < j);
                                        j = j2;
                                    } else if (c == 3) {
                                        i = 0;
                                        c = 4;
                                    } else if (c == 5 || c == 6) {
                                        i = 0;
                                        c = 7;
                                    }
                                    i = 0;
                                }
                            }
                        } else if (c != 2) {
                            return i;
                        } else {
                            c = 3;
                        }
                    } else if (c == 0) {
                        c = 1;
                        z3 = true;
                    } else if (c != 5) {
                        return i;
                    }
                    i2 = i3;
                    z = true;
                } else if (c != 2 && c != 4) {
                    return i;
                } else {
                    c = 5;
                    i2 = i3;
                    z = true;
                }
            } else if (c != 5) {
                return i;
            }
            c = 6;
            i2 = i3;
            z = true;
        }
        if (m1445b((int) b)) {
            return 0;
        }
        if (c == 2 && z2 && ((j != Long.MIN_VALUE || z3) && (j != 0 || !z3))) {
            if (!z3) {
                j = -j;
            }
            this.f1669Q = j;
            this.f1667O.skip((long) i2);
            this.f1668P = 16;
            return 16;
        } else if (c != 2 && c != 4 && c != 7) {
            return 0;
        } else {
            this.f1670R = i2;
            this.f1668P = 17;
            return 17;
        }
    }

    /* renamed from: b */
    private boolean m1445b(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (!(i == 47 || i == 61)) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m1449f();
        return false;
    }

    public String nextName() throws IOException {
        String str;
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 14) {
            str = m1447d();
        } else if (i == 13) {
            str = m1441a(f1648i);
        } else if (i == 12) {
            str = m1441a(f1647h);
        } else if (i == 15) {
            str = this.f1671S;
        } else {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.f1668P = 0;
        this.f1621c[this.f1619a - 1] = str;
        return str;
    }

    public int selectName(JsonReader.Options options) throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return m1439a(this.f1671S, options);
        }
        int select = this.f1666N.select(options.doubleQuoteSuffix);
        if (select != -1) {
            this.f1668P = 0;
            this.f1621c[this.f1619a - 1] = options.strings[select];
            return select;
        }
        String str = this.f1621c[this.f1619a - 1];
        String nextName = nextName();
        int a = m1439a(nextName, options);
        if (a == -1) {
            this.f1668P = 15;
            this.f1671S = nextName;
            this.f1621c[this.f1619a - 1] = str;
        }
        return a;
    }

    public void skipName() throws IOException {
        if (!this.f1624f) {
            int i = this.f1668P;
            if (i == 0) {
                i = m1438a();
            }
            if (i == 14) {
                m1448e();
            } else if (i == 13) {
                m1444b(f1648i);
            } else if (i == 12) {
                m1444b(f1647h);
            } else if (i != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            this.f1668P = 0;
            this.f1621c[this.f1619a - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    /* renamed from: a */
    private int m1439a(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.strings[i])) {
                this.f1668P = 0;
                this.f1621c[this.f1619a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 10) {
            str = m1447d();
        } else if (i == 9) {
            str = m1441a(f1648i);
        } else if (i == 8) {
            str = m1441a(f1647h);
        } else if (i == 11) {
            str = this.f1671S;
            this.f1671S = null;
        } else if (i == 16) {
            str = Long.toString(this.f1669Q);
        } else if (i == 17) {
            str = this.f1667O.readUtf8((long) this.f1670R);
        } else {
            throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
        }
        this.f1668P = 0;
        int[] iArr = this.f1622d;
        int i2 = this.f1619a - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* renamed from: b */
    private int m1443b(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.strings[i])) {
                this.f1668P = 0;
                int[] iArr = this.f1622d;
                int i2 = this.f1619a - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
        }
        return -1;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 5) {
            this.f1668P = 0;
            int[] iArr = this.f1622d;
            int i2 = this.f1619a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f1668P = 0;
            int[] iArr2 = this.f1622d;
            int i3 = this.f1619a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 16) {
            this.f1668P = 0;
            int[] iArr = this.f1622d;
            int i2 = this.f1619a - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f1669Q;
        }
        if (i == 17) {
            this.f1671S = this.f1667O.readUtf8((long) this.f1670R);
        } else if (i == 9) {
            this.f1671S = m1441a(f1648i);
        } else if (i == 8) {
            this.f1671S = m1441a(f1647h);
        } else if (i == 10) {
            this.f1671S = m1447d();
        } else if (i != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.f1668P = 11;
        try {
            double parseDouble = Double.parseDouble(this.f1671S);
            if (this.f1623e || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.f1671S = null;
                this.f1668P = 0;
                int[] iArr2 = this.f1622d;
                int i3 = this.f1619a - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f1671S + " at path " + getPath());
        }
    }

    /* renamed from: a */
    private String m1441a(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.f1666N.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw mo15467a("Unterminated string");
            } else if (this.f1667O.getByte(indexOfElement) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f1667O.readUtf8(indexOfElement));
                this.f1667O.readByte();
                sb.append(m1452i());
            } else if (sb == null) {
                String readUtf8 = this.f1667O.readUtf8(indexOfElement);
                this.f1667O.readByte();
                return readUtf8;
            } else {
                sb.append(this.f1667O.readUtf8(indexOfElement));
                this.f1667O.readByte();
                return sb.toString();
            }
        }
    }

    /* renamed from: d */
    private String m1447d() throws IOException {
        long indexOfElement = this.f1666N.indexOfElement(f1649j);
        return indexOfElement != -1 ? this.f1667O.readUtf8(indexOfElement) : this.f1667O.readUtf8();
    }

    /* renamed from: b */
    private void m1444b(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.f1666N.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw mo15467a("Unterminated string");
            } else if (this.f1667O.getByte(indexOfElement) == 92) {
                this.f1667O.skip(indexOfElement + 1);
                m1452i();
            } else {
                this.f1667O.skip(indexOfElement + 1);
                return;
            }
        }
    }

    /* renamed from: e */
    private void m1448e() throws IOException {
        long indexOfElement = this.f1666N.indexOfElement(f1649j);
        Buffer buffer = this.f1667O;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public int nextInt() throws IOException {
        String str;
        int i = this.f1668P;
        if (i == 0) {
            i = m1438a();
        }
        if (i == 16) {
            long j = this.f1669Q;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.f1668P = 0;
                int[] iArr = this.f1622d;
                int i3 = this.f1619a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.f1669Q + " at path " + getPath());
        }
        if (i == 17) {
            this.f1671S = this.f1667O.readUtf8((long) this.f1670R);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                str = m1441a(f1648i);
            } else {
                str = m1441a(f1647h);
            }
            this.f1671S = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.f1668P = 0;
                int[] iArr2 = this.f1622d;
                int i4 = this.f1619a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
        }
        this.f1668P = 11;
        try {
            double parseDouble = Double.parseDouble(this.f1671S);
            int i5 = (int) parseDouble;
            if (((double) i5) == parseDouble) {
                this.f1671S = null;
                this.f1668P = 0;
                int[] iArr3 = this.f1622d;
                int i6 = this.f1619a - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new JsonDataException("Expected an int but was " + this.f1671S + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f1671S + " at path " + getPath());
        }
    }

    public void close() throws IOException {
        this.f1668P = 0;
        this.f1620b[0] = 8;
        this.f1619a = 1;
        this.f1667O.clear();
        this.f1666N.close();
    }

    public void skipValue() throws IOException {
        if (!this.f1624f) {
            int i = 0;
            do {
                int i2 = this.f1668P;
                if (i2 == 0) {
                    i2 = m1438a();
                }
                if (i2 == 3) {
                    mo15468a(1);
                } else if (i2 == 1) {
                    mo15468a(3);
                } else {
                    if (i2 == 4) {
                        i--;
                        if (i >= 0) {
                            this.f1619a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i2 == 2) {
                        i--;
                        if (i >= 0) {
                            this.f1619a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i2 == 14 || i2 == 10) {
                        m1448e();
                    } else if (i2 == 9 || i2 == 13) {
                        m1444b(f1648i);
                    } else if (i2 == 8 || i2 == 12) {
                        m1444b(f1647h);
                    } else if (i2 == 17) {
                        this.f1667O.skip((long) this.f1670R);
                    } else if (i2 == 18) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.f1668P = 0;
                }
                i++;
                this.f1668P = 0;
            } while (i != 0);
            int[] iArr = this.f1622d;
            int i3 = this.f1619a - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f1621c[this.f1619a - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.f1667O.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.f1666N.request(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        m1449f();
        r3 = r6.f1667O.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r6.f1667O.readByte();
        r6.f1667O.readByte();
        m1450g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.f1667O.readByte();
        r6.f1667O.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (m1451h() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw mo15467a("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        m1449f();
        m1450g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m1440a(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            okio.BufferedSource r2 = r6.f1666N
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x0082
            okio.Buffer r2 = r6.f1667O
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L_0x0080
            r2 = 32
            if (r1 == r2) goto L_0x0080
            r2 = 13
            if (r1 == r2) goto L_0x0080
            r2 = 9
            if (r1 != r2) goto L_0x0025
            goto L_0x0080
        L_0x0025:
            okio.Buffer r2 = r6.f1667O
            int r3 = r3 + -1
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            okio.BufferedSource r3 = r6.f1666N
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.m1449f()
            okio.Buffer r3 = r6.f1667O
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            okio.Buffer r1 = r6.f1667O
            r1.readByte()
            okio.Buffer r1 = r6.f1667O
            r1.readByte()
            r6.m1450g()
            goto L_0x0001
        L_0x005c:
            okio.Buffer r1 = r6.f1667O
            r1.readByte()
            okio.Buffer r1 = r6.f1667O
            r1.readByte()
            boolean r1 = r6.m1451h()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.mo15467a((java.lang.String) r7)
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007f
            r6.m1449f()
            r6.m1450g()
            goto L_0x0001
        L_0x007f:
            return r1
        L_0x0080:
            r1 = r3
            goto L_0x0002
        L_0x0082:
            if (r7 != 0) goto L_0x0086
            r7 = -1
            return r7
        L_0x0086:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.C1514b.m1440a(boolean):int");
    }

    /* renamed from: f */
    private void m1449f() throws IOException {
        if (!this.f1623e) {
            throw mo15467a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: g */
    private void m1450g() throws IOException {
        long indexOfElement = this.f1666N.indexOfElement(f1650k);
        Buffer buffer = this.f1667O;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    /* renamed from: h */
    private boolean m1451h() throws IOException {
        long indexOf = this.f1666N.indexOf(f1651l);
        boolean z = indexOf != -1;
        Buffer buffer = this.f1667O;
        buffer.skip(z ? indexOf + ((long) f1651l.size()) : buffer.size());
        return z;
    }

    public String toString() {
        return "JsonReader(" + this.f1666N + ")";
    }

    /* renamed from: i */
    private char m1452i() throws IOException {
        int i;
        int i2;
        if (this.f1666N.request(1)) {
            byte readByte = this.f1667O.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return CharUtils.f5620CR;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.f1623e) {
                    return (char) readByte;
                }
                throw mo15467a("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.f1666N.request(4)) {
                char c = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    byte b = this.f1667O.getByte((long) i3);
                    char c2 = (char) (c << 4);
                    if (b < 48 || b > 57) {
                        if (b >= 97 && b <= 102) {
                            i = b - 97;
                        } else if (b < 65 || b > 70) {
                            throw mo15467a("\\u" + this.f1667O.readUtf8(4));
                        } else {
                            i = b - 65;
                        }
                        i2 = i + 10;
                    } else {
                        i2 = b - 48;
                    }
                    c = (char) (c2 + i2);
                }
                this.f1667O.skip(4);
                return c;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw mo15467a("Unterminated escape sequence");
        }
    }
}
