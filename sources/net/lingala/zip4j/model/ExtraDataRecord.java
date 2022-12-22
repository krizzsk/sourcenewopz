package net.lingala.zip4j.model;

public class ExtraDataRecord extends ZipHeader {

    /* renamed from: a */
    private long f4948a;

    /* renamed from: b */
    private int f4949b;

    /* renamed from: c */
    private byte[] f4950c;

    public long getHeader() {
        return this.f4948a;
    }

    public void setHeader(long j) {
        this.f4948a = j;
    }

    public int getSizeOfData() {
        return this.f4949b;
    }

    public void setSizeOfData(int i) {
        this.f4949b = i;
    }

    public byte[] getData() {
        return this.f4950c;
    }

    public void setData(byte[] bArr) {
        this.f4950c = bArr;
    }
}
