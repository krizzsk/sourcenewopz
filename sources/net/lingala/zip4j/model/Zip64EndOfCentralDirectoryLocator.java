package net.lingala.zip4j.model;

public class Zip64EndOfCentralDirectoryLocator extends ZipHeader {

    /* renamed from: a */
    private int f4964a;

    /* renamed from: b */
    private long f4965b;

    /* renamed from: c */
    private int f4966c;

    public int getNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord() {
        return this.f4964a;
    }

    public void setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(int i) {
        this.f4964a = i;
    }

    public long getOffsetZip64EndOfCentralDirectoryRecord() {
        return this.f4965b;
    }

    public void setOffsetZip64EndOfCentralDirectoryRecord(long j) {
        this.f4965b = j;
    }

    public int getTotalNumberOfDiscs() {
        return this.f4966c;
    }

    public void setTotalNumberOfDiscs(int i) {
        this.f4966c = i;
    }
}
