package com.didi.dqr.common;

import java.util.List;

public final class DecoderResult {

    /* renamed from: a */
    private final byte[] f18527a;

    /* renamed from: b */
    private int f18528b;

    /* renamed from: c */
    private final String f18529c;

    /* renamed from: d */
    private final List<byte[]> f18530d;

    /* renamed from: e */
    private final String f18531e;

    /* renamed from: f */
    private Integer f18532f;

    /* renamed from: g */
    private Integer f18533g;

    /* renamed from: h */
    private Object f18534h;

    /* renamed from: i */
    private final int f18535i;

    /* renamed from: j */
    private final int f18536j;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        int i3;
        this.f18527a = bArr;
        if (bArr == null) {
            i3 = 0;
        } else {
            i3 = bArr.length * 8;
        }
        this.f18528b = i3;
        this.f18529c = str;
        this.f18530d = list;
        this.f18531e = str2;
        this.f18535i = i2;
        this.f18536j = i;
    }

    public byte[] getRawBytes() {
        return this.f18527a;
    }

    public int getNumBits() {
        return this.f18528b;
    }

    public void setNumBits(int i) {
        this.f18528b = i;
    }

    public String getText() {
        return this.f18529c;
    }

    public List<byte[]> getByteSegments() {
        return this.f18530d;
    }

    public String getECLevel() {
        return this.f18531e;
    }

    public Integer getErrorsCorrected() {
        return this.f18532f;
    }

    public void setErrorsCorrected(Integer num) {
        this.f18532f = num;
    }

    public Integer getErasures() {
        return this.f18533g;
    }

    public void setErasures(Integer num) {
        this.f18533g = num;
    }

    public Object getOther() {
        return this.f18534h;
    }

    public void setOther(Object obj) {
        this.f18534h = obj;
    }

    public boolean hasStructuredAppend() {
        return this.f18535i >= 0 && this.f18536j >= 0;
    }

    public int getStructuredAppendParity() {
        return this.f18535i;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.f18536j;
    }
}
