package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class FileHeader extends AbstractFileHeader {

    /* renamed from: a */
    private int f4951a;

    /* renamed from: b */
    private int f4952b = 0;

    /* renamed from: c */
    private int f4953c;

    /* renamed from: d */
    private byte[] f4954d;

    /* renamed from: e */
    private byte[] f4955e;

    /* renamed from: f */
    private long f4956f;

    /* renamed from: g */
    private String f4957g;

    public FileHeader() {
        setSignature(HeaderSignature.CENTRAL_DIRECTORY);
    }

    public int getVersionMadeBy() {
        return this.f4951a;
    }

    public void setVersionMadeBy(int i) {
        this.f4951a = i;
    }

    public int getFileCommentLength() {
        return this.f4952b;
    }

    public void setFileCommentLength(int i) {
        this.f4952b = i;
    }

    public int getDiskNumberStart() {
        return this.f4953c;
    }

    public void setDiskNumberStart(int i) {
        this.f4953c = i;
    }

    public byte[] getInternalFileAttributes() {
        return this.f4954d;
    }

    public void setInternalFileAttributes(byte[] bArr) {
        this.f4954d = bArr;
    }

    public byte[] getExternalFileAttributes() {
        return this.f4955e;
    }

    public void setExternalFileAttributes(byte[] bArr) {
        this.f4955e = bArr;
    }

    public long getOffsetLocalHeader() {
        return this.f4956f;
    }

    public void setOffsetLocalHeader(long j) {
        this.f4956f = j;
    }

    public String getFileComment() {
        return this.f4957g;
    }

    public void setFileComment(String str) {
        this.f4957g = str;
    }

    public String toString() {
        return getFileName();
    }
}
