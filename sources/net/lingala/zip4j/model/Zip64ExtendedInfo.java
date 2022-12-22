package net.lingala.zip4j.model;

public class Zip64ExtendedInfo extends ZipHeader {

    /* renamed from: a */
    private int f4977a;

    /* renamed from: b */
    private long f4978b = -1;

    /* renamed from: c */
    private long f4979c = -1;

    /* renamed from: d */
    private long f4980d = -1;

    /* renamed from: e */
    private int f4981e = -1;

    public int getSize() {
        return this.f4977a;
    }

    public void setSize(int i) {
        this.f4977a = i;
    }

    public long getCompressedSize() {
        return this.f4978b;
    }

    public void setCompressedSize(long j) {
        this.f4978b = j;
    }

    public long getUncompressedSize() {
        return this.f4979c;
    }

    public void setUncompressedSize(long j) {
        this.f4979c = j;
    }

    public long getOffsetLocalHeader() {
        return this.f4980d;
    }

    public void setOffsetLocalHeader(long j) {
        this.f4980d = j;
    }

    public int getDiskNumberStart() {
        return this.f4981e;
    }

    public void setDiskNumberStart(int i) {
        this.f4981e = i;
    }
}
