package net.lingala.zip4j.model;

import java.util.List;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractFileHeader extends ZipHeader {

    /* renamed from: a */
    private int f4913a;

    /* renamed from: b */
    private byte[] f4914b;

    /* renamed from: c */
    private CompressionMethod f4915c;

    /* renamed from: d */
    private long f4916d;

    /* renamed from: e */
    private long f4917e = 0;

    /* renamed from: f */
    private long f4918f = 0;

    /* renamed from: g */
    private long f4919g = 0;

    /* renamed from: h */
    private int f4920h;

    /* renamed from: i */
    private int f4921i;

    /* renamed from: j */
    private String f4922j;

    /* renamed from: k */
    private boolean f4923k;

    /* renamed from: l */
    private EncryptionMethod f4924l = EncryptionMethod.NONE;

    /* renamed from: m */
    private boolean f4925m;

    /* renamed from: n */
    private Zip64ExtendedInfo f4926n;

    /* renamed from: o */
    private AESExtraDataRecord f4927o;

    /* renamed from: p */
    private boolean f4928p;

    /* renamed from: q */
    private List<ExtraDataRecord> f4929q;

    /* renamed from: r */
    private boolean f4930r;

    public int getVersionNeededToExtract() {
        return this.f4913a;
    }

    public void setVersionNeededToExtract(int i) {
        this.f4913a = i;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.f4914b;
    }

    public void setGeneralPurposeFlag(byte[] bArr) {
        this.f4914b = bArr;
    }

    public CompressionMethod getCompressionMethod() {
        return this.f4915c;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod) {
        this.f4915c = compressionMethod;
    }

    public long getLastModifiedTime() {
        return this.f4916d;
    }

    public void setLastModifiedTime(long j) {
        this.f4916d = j;
    }

    public long getLastModifiedTimeEpoch() {
        return Zip4jUtil.dosToExtendedEpochTme(this.f4916d);
    }

    public long getCrc() {
        return this.f4917e;
    }

    public void setCrc(long j) {
        this.f4917e = j;
    }

    public long getCompressedSize() {
        return this.f4918f;
    }

    public void setCompressedSize(long j) {
        this.f4918f = j;
    }

    public long getUncompressedSize() {
        return this.f4919g;
    }

    public void setUncompressedSize(long j) {
        this.f4919g = j;
    }

    public int getFileNameLength() {
        return this.f4920h;
    }

    public void setFileNameLength(int i) {
        this.f4920h = i;
    }

    public int getExtraFieldLength() {
        return this.f4921i;
    }

    public void setExtraFieldLength(int i) {
        this.f4921i = i;
    }

    public String getFileName() {
        return this.f4922j;
    }

    public void setFileName(String str) {
        this.f4922j = str;
    }

    public boolean isEncrypted() {
        return this.f4923k;
    }

    public void setEncrypted(boolean z) {
        this.f4923k = z;
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.f4924l;
    }

    public void setEncryptionMethod(EncryptionMethod encryptionMethod) {
        this.f4924l = encryptionMethod;
    }

    public boolean isDataDescriptorExists() {
        return this.f4925m;
    }

    public void setDataDescriptorExists(boolean z) {
        this.f4925m = z;
    }

    public Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.f4926n;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.f4926n = zip64ExtendedInfo;
    }

    public AESExtraDataRecord getAesExtraDataRecord() {
        return this.f4927o;
    }

    public void setAesExtraDataRecord(AESExtraDataRecord aESExtraDataRecord) {
        this.f4927o = aESExtraDataRecord;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.f4928p;
    }

    public void setFileNameUTF8Encoded(boolean z) {
        this.f4928p = z;
    }

    public List<ExtraDataRecord> getExtraDataRecords() {
        return this.f4929q;
    }

    public void setExtraDataRecords(List<ExtraDataRecord> list) {
        this.f4929q = list;
    }

    public boolean isDirectory() {
        return this.f4930r;
    }

    public void setDirectory(boolean z) {
        this.f4930r = z;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AbstractFileHeader)) {
            return getFileName().equals(((AbstractFileHeader) obj).getFileName());
        }
        return false;
    }
}
