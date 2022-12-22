package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class LocalFileHeader extends AbstractFileHeader {

    /* renamed from: a */
    private byte[] f4958a;

    /* renamed from: b */
    private long f4959b;

    /* renamed from: c */
    private boolean f4960c;

    public LocalFileHeader() {
        setSignature(HeaderSignature.LOCAL_FILE_HEADER);
    }

    public byte[] getExtraField() {
        return this.f4958a;
    }

    public void setExtraField(byte[] bArr) {
        this.f4958a = bArr;
    }

    public long getOffsetStartOfData() {
        return this.f4959b;
    }

    public void setOffsetStartOfData(long j) {
        this.f4959b = j;
    }

    public boolean isWriteCompressedSizeInZip64ExtraRecord() {
        return this.f4960c;
    }

    public void setWriteCompressedSizeInZip64ExtraRecord(boolean z) {
        this.f4960c = z;
    }
}
