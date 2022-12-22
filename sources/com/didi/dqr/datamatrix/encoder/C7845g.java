package com.didi.dqr.datamatrix.encoder;

import com.didi.dqr.Dimension;
import java.nio.charset.StandardCharsets;

/* renamed from: com.didi.dqr.datamatrix.encoder.g */
/* compiled from: EncoderContext */
final class C7845g {

    /* renamed from: a */
    int f18648a;

    /* renamed from: b */
    private final String f18649b;

    /* renamed from: c */
    private SymbolShapeHint f18650c;

    /* renamed from: d */
    private Dimension f18651d;

    /* renamed from: e */
    private Dimension f18652e;

    /* renamed from: f */
    private final StringBuilder f18653f;

    /* renamed from: g */
    private int f18654g;

    /* renamed from: h */
    private SymbolInfo f18655h;

    /* renamed from: i */
    private int f18656i;

    C7845g(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            char c = (char) (bytes[i] & 255);
            if (c != '?' || str.charAt(i) == '?') {
                sb.append(c);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f18649b = sb.toString();
        this.f18650c = SymbolShapeHint.FORCE_NONE;
        this.f18653f = new StringBuilder(str.length());
        this.f18654g = -1;
    }

    /* renamed from: a */
    public void mo58346a(SymbolShapeHint symbolShapeHint) {
        this.f18650c = symbolShapeHint;
    }

    /* renamed from: a */
    public void mo58345a(Dimension dimension, Dimension dimension2) {
        this.f18651d = dimension;
        this.f18652e = dimension2;
    }

    /* renamed from: a */
    public String mo58342a() {
        return this.f18649b;
    }

    /* renamed from: a */
    public void mo58344a(int i) {
        this.f18656i = i;
    }

    /* renamed from: b */
    public char mo58348b() {
        return this.f18649b.charAt(this.f18648a);
    }

    /* renamed from: c */
    public char mo58350c() {
        return this.f18649b.charAt(this.f18648a);
    }

    /* renamed from: d */
    public StringBuilder mo58352d() {
        return this.f18653f;
    }

    /* renamed from: a */
    public void mo58347a(String str) {
        this.f18653f.append(str);
    }

    /* renamed from: a */
    public void mo58343a(char c) {
        this.f18653f.append(c);
    }

    /* renamed from: e */
    public int mo58353e() {
        return this.f18653f.length();
    }

    /* renamed from: f */
    public int mo58354f() {
        return this.f18654g;
    }

    /* renamed from: b */
    public void mo58349b(int i) {
        this.f18654g = i;
    }

    /* renamed from: g */
    public void mo58355g() {
        this.f18654g = -1;
    }

    /* renamed from: h */
    public boolean mo58356h() {
        return this.f18648a < m13845m();
    }

    /* renamed from: m */
    private int m13845m() {
        return this.f18649b.length() - this.f18656i;
    }

    /* renamed from: i */
    public int mo58357i() {
        return m13845m() - this.f18648a;
    }

    /* renamed from: j */
    public SymbolInfo mo58358j() {
        return this.f18655h;
    }

    /* renamed from: k */
    public void mo58359k() {
        mo58351c(mo58353e());
    }

    /* renamed from: c */
    public void mo58351c(int i) {
        SymbolInfo symbolInfo = this.f18655h;
        if (symbolInfo == null || i > symbolInfo.getDataCapacity()) {
            this.f18655h = SymbolInfo.lookup(i, this.f18650c, this.f18651d, this.f18652e, true);
        }
    }

    /* renamed from: l */
    public void mo58360l() {
        this.f18655h = null;
    }
}
