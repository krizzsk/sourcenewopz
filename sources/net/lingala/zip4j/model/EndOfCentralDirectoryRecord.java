package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class EndOfCentralDirectoryRecord extends ZipHeader {

    /* renamed from: a */
    private int f4940a;

    /* renamed from: b */
    private int f4941b;

    /* renamed from: c */
    private int f4942c;

    /* renamed from: d */
    private int f4943d;

    /* renamed from: e */
    private int f4944e;

    /* renamed from: f */
    private long f4945f;

    /* renamed from: g */
    private long f4946g;

    /* renamed from: h */
    private String f4947h = "";

    public EndOfCentralDirectoryRecord() {
        setSignature(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
    }

    public int getNumberOfThisDisk() {
        return this.f4940a;
    }

    public void setNumberOfThisDisk(int i) {
        this.f4940a = i;
    }

    public int getNumberOfThisDiskStartOfCentralDir() {
        return this.f4941b;
    }

    public void setNumberOfThisDiskStartOfCentralDir(int i) {
        this.f4941b = i;
    }

    public int getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() {
        return this.f4942c;
    }

    public void setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(int i) {
        this.f4942c = i;
    }

    public int getTotalNumberOfEntriesInCentralDirectory() {
        return this.f4943d;
    }

    public void setTotalNumberOfEntriesInCentralDirectory(int i) {
        this.f4943d = i;
    }

    public int getSizeOfCentralDirectory() {
        return this.f4944e;
    }

    public void setSizeOfCentralDirectory(int i) {
        this.f4944e = i;
    }

    public long getOffsetOfStartOfCentralDirectory() {
        return this.f4945f;
    }

    public void setOffsetOfStartOfCentralDirectory(long j) {
        this.f4945f = j;
    }

    public long getOffsetOfEndOfCentralDirectory() {
        return this.f4946g;
    }

    public void setOffsetOfEndOfCentralDirectory(long j) {
        this.f4946g = j;
    }

    public String getComment() {
        return this.f4947h;
    }

    public void setComment(String str) {
        if (str != null) {
            this.f4947h = str;
        }
    }
}
