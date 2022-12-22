package com.p222hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.hp.hpl.sparta.xpath.SimpleStreamTokenizer */
public class SimpleStreamTokenizer {
    public static final int TT_EOF = -1;
    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;

    /* renamed from: a */
    private static final int f53966a = -5;

    /* renamed from: b */
    private static final int f53967b = -6;

    /* renamed from: c */
    private final StringBuffer f53968c = new StringBuffer();

    /* renamed from: d */
    private int f53969d;

    /* renamed from: e */
    private final Reader f53970e;

    /* renamed from: f */
    private final int[] f53971f = new int[256];

    /* renamed from: g */
    private boolean f53972g;

    /* renamed from: h */
    private char f53973h;
    public int nval = Integer.MIN_VALUE;
    public String sval = "";
    public int ttype = Integer.MIN_VALUE;

    public String toString() {
        int i = this.ttype;
        if (i != -3) {
            if (i == -2) {
                return Integer.toString(this.nval);
            }
            if (i == -1) {
                return "(EOF)";
            }
            if (i != 34) {
                if (i != 39) {
                    return "'" + ((char) this.ttype) + "'";
                }
                return "'" + this.sval + "'";
            }
        }
        return Const.jsQuote + this.sval + Const.jsQuote;
    }

    public SimpleStreamTokenizer(Reader reader) throws IOException {
        this.f53972g = false;
        this.f53973h = 0;
        this.f53970e = reader;
        for (int i = 0; i < this.f53971f.length; i = (char) (i + 1)) {
            if ((65 <= i && i <= 90) || ((97 <= i && i <= 122) || i == 45)) {
                this.f53971f[i] = -3;
            } else if (48 <= i && i <= 57) {
                this.f53971f[i] = -2;
            } else if (i < 0 || i > 32) {
                this.f53971f[i] = i;
            } else {
                this.f53971f[i] = -5;
            }
        }
        nextToken();
    }

    public void ordinaryChar(char c) {
        this.f53971f[c] = c;
    }

    public void wordChars(char c, char c2) {
        while (c <= c2) {
            this.f53971f[c] = -3;
            c = (char) (c + 1);
        }
    }

    public int nextToken() throws IOException {
        int read;
        char c;
        boolean z;
        boolean z2;
        int i;
        if (this.f53972g) {
            this.f53972g = false;
            return this.ttype;
        }
        this.ttype = this.f53969d;
        do {
            boolean z3 = false;
            do {
                read = this.f53970e.read();
                if (read != -1) {
                    c = this.f53971f[read];
                } else if (this.f53973h == 0) {
                    c = -1;
                } else {
                    throw new IOException("Unterminated quote");
                }
                z = this.f53973h == 0 && c == -5;
                if (z3 || z) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
            } while (z);
            if (c == 39 || c == 34) {
                char c2 = this.f53973h;
                if (c2 == 0) {
                    this.f53973h = (char) c;
                } else if (c2 == c) {
                    this.f53973h = 0;
                }
            }
            char c3 = this.f53973h;
            if (c3 != 0) {
                c = c3;
            }
            z2 = z3 || !(((i = this.ttype) < -1 || i == 39 || i == 34) && this.ttype == c);
            if (z2) {
                int i2 = this.ttype;
                if (i2 == -3) {
                    this.sval = this.f53968c.toString();
                    this.f53968c.setLength(0);
                } else if (i2 == -2) {
                    this.nval = Integer.parseInt(this.f53968c.toString());
                    this.f53968c.setLength(0);
                } else if (i2 == 34 || i2 == 39) {
                    this.sval = this.f53968c.toString().substring(1, this.f53968c.length() - 1);
                    this.f53968c.setLength(0);
                }
                if (c != -5) {
                    this.f53969d = c == -6 ? read : c;
                }
            }
            if (c == -3 || c == -2 || c == 34 || c == 39) {
                this.f53968c.append((char) read);
                continue;
            }
        } while (!z2);
        return this.ttype;
    }

    public void pushBack() {
        this.f53972g = true;
    }
}
