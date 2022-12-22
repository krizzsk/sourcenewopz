package net.lingala.zip4j.model;

public class Zip64EndOfCentralDirectoryRecord extends ZipHeader {

    /* renamed from: a */
    private long f4967a;

    /* renamed from: b */
    private int f4968b;

    /* renamed from: c */
    private int f4969c;

    /* renamed from: d */
    private int f4970d;

    /* renamed from: e */
    private int f4971e;

    /* renamed from: f */
    private long f4972f;

    /* renamed from: g */
    private long f4973g;

    /* renamed from: h */
    private long f4974h;

    /* renamed from: i */
    private long f4975i = -1;

    /* renamed from: j */
    private byte[] f4976j;

    public long getSizeOfZip64EndCentralDirectoryRecord() {
        return this.f4967a;
    }

    public void setSizeOfZip64EndCentralDirectoryRecord(long j) {
        this.f4967a = j;
    }

    public int getVersionMadeBy() {
        return this.f4968b;
    }

    public void setVersionMadeBy(int i) {
        this.f4968b = i;
    }

    public int getVersionNeededToExtract() {
        return this.f4969c;
    }

    public void setVersionNeededToExtract(int i) {
        this.f4969c = i;
    }

    public int getNumberOfThisDisk() {
        return this.f4970d;
    }

    public void setNumberOfThisDisk(int i) {
        this.f4970d = i;
    }

    public int getNumberOfThisDiskStartOfCentralDirectory() {
        return this.f4971e;
    }

    public void setNumberOfThisDiskStartOfCentralDirectory(int i) {
        this.f4971e = i;
    }

    public long getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() {
        return this.f4972f;
    }

    public void setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(long j) {
        this.f4972f = j;
    }

    public long getTotalNumberOfEntriesInCentralDirectory() {
        return this.f4973g;
    }

    public void setTotalNumberOfEntriesInCentralDirectory(long j) {
        this.f4973g = j;
    }

    public long getSizeOfCentralDirectory() {
        return this.f4974h;
    }

    public void setSizeOfCentralDirectory(long j) {
        this.f4974h = j;
    }

    public long getOffsetStartCentralDirectoryWRTStartDiskNumber() {
        return this.f4975i;
    }

    public void setOffsetStartCentralDirectoryWRTStartDiskNumber(long j) {
        this.f4975i = j;
    }

    public byte[] getExtensibleDataSector() {
        return this.f4976j;
    }

    public void setExtensibleDataSector(byte[] bArr) {
        this.f4976j = bArr;
    }
}
