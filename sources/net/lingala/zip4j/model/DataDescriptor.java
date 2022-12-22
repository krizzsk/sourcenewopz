package net.lingala.zip4j.model;

public class DataDescriptor extends ZipHeader {

    /* renamed from: a */
    private long f4935a;

    /* renamed from: b */
    private long f4936b;

    /* renamed from: c */
    private long f4937c;

    public long getCrc() {
        return this.f4935a;
    }

    public void setCrc(long j) {
        this.f4935a = j;
    }

    public long getCompressedSize() {
        return this.f4936b;
    }

    public void setCompressedSize(long j) {
        this.f4936b = j;
    }

    public long getUncompressedSize() {
        return this.f4937c;
    }

    public void setUncompressedSize(long j) {
        this.f4937c = j;
    }
}
