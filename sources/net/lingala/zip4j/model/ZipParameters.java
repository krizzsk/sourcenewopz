package net.lingala.zip4j.model;

import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class ZipParameters {

    /* renamed from: a */
    private CompressionMethod f4997a = CompressionMethod.DEFLATE;

    /* renamed from: b */
    private CompressionLevel f4998b = CompressionLevel.NORMAL;

    /* renamed from: c */
    private boolean f4999c = false;

    /* renamed from: d */
    private EncryptionMethod f5000d = EncryptionMethod.NONE;

    /* renamed from: e */
    private boolean f5001e = true;

    /* renamed from: f */
    private boolean f5002f = true;

    /* renamed from: g */
    private AesKeyStrength f5003g = AesKeyStrength.KEY_STRENGTH_256;

    /* renamed from: h */
    private AesVersion f5004h = AesVersion.TWO;

    /* renamed from: i */
    private boolean f5005i = true;

    /* renamed from: j */
    private long f5006j;

    /* renamed from: k */
    private String f5007k;

    /* renamed from: l */
    private String f5008l;

    /* renamed from: m */
    private long f5009m = System.currentTimeMillis();

    /* renamed from: n */
    private long f5010n = -1;

    /* renamed from: o */
    private boolean f5011o = true;

    /* renamed from: p */
    private boolean f5012p = true;

    /* renamed from: q */
    private String f5013q;

    /* renamed from: r */
    private String f5014r;

    /* renamed from: s */
    private SymbolicLinkAction f5015s = SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY;

    /* renamed from: t */
    private ExcludeFileFilter f5016t;

    /* renamed from: u */
    private boolean f5017u;

    public enum SymbolicLinkAction {
        INCLUDE_LINK_ONLY,
        INCLUDE_LINKED_FILE_ONLY,
        INCLUDE_LINK_AND_LINKED_FILE
    }

    public ZipParameters() {
    }

    public ZipParameters(ZipParameters zipParameters) {
        this.f4997a = zipParameters.getCompressionMethod();
        this.f4998b = zipParameters.getCompressionLevel();
        this.f4999c = zipParameters.isEncryptFiles();
        this.f5000d = zipParameters.getEncryptionMethod();
        this.f5001e = zipParameters.isReadHiddenFiles();
        this.f5002f = zipParameters.isReadHiddenFolders();
        this.f5003g = zipParameters.getAesKeyStrength();
        this.f5004h = zipParameters.getAesVersion();
        this.f5005i = zipParameters.isIncludeRootFolder();
        this.f5006j = zipParameters.getEntryCRC();
        this.f5007k = zipParameters.getDefaultFolderPath();
        this.f5008l = zipParameters.getFileNameInZip();
        this.f5009m = zipParameters.getLastModifiedFileTime();
        this.f5010n = zipParameters.getEntrySize();
        this.f5011o = zipParameters.isWriteExtendedLocalFileHeader();
        this.f5012p = zipParameters.isOverrideExistingFilesInZip();
        this.f5013q = zipParameters.getRootFolderNameInZip();
        this.f5014r = zipParameters.getFileComment();
        this.f5015s = zipParameters.getSymbolicLinkAction();
        this.f5016t = zipParameters.getExcludeFileFilter();
        this.f5017u = zipParameters.isUnixMode();
    }

    public CompressionMethod getCompressionMethod() {
        return this.f4997a;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod) {
        this.f4997a = compressionMethod;
    }

    public boolean isEncryptFiles() {
        return this.f4999c;
    }

    public void setEncryptFiles(boolean z) {
        this.f4999c = z;
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.f5000d;
    }

    public void setEncryptionMethod(EncryptionMethod encryptionMethod) {
        this.f5000d = encryptionMethod;
    }

    public CompressionLevel getCompressionLevel() {
        return this.f4998b;
    }

    public void setCompressionLevel(CompressionLevel compressionLevel) {
        this.f4998b = compressionLevel;
    }

    public boolean isReadHiddenFiles() {
        return this.f5001e;
    }

    public void setReadHiddenFiles(boolean z) {
        this.f5001e = z;
    }

    public boolean isReadHiddenFolders() {
        return this.f5002f;
    }

    public void setReadHiddenFolders(boolean z) {
        this.f5002f = z;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public AesKeyStrength getAesKeyStrength() {
        return this.f5003g;
    }

    public void setAesKeyStrength(AesKeyStrength aesKeyStrength) {
        this.f5003g = aesKeyStrength;
    }

    public AesVersion getAesVersion() {
        return this.f5004h;
    }

    public void setAesVersion(AesVersion aesVersion) {
        this.f5004h = aesVersion;
    }

    public boolean isIncludeRootFolder() {
        return this.f5005i;
    }

    public void setIncludeRootFolder(boolean z) {
        this.f5005i = z;
    }

    public long getEntryCRC() {
        return this.f5006j;
    }

    public void setEntryCRC(long j) {
        this.f5006j = j;
    }

    public String getDefaultFolderPath() {
        return this.f5007k;
    }

    public void setDefaultFolderPath(String str) {
        this.f5007k = str;
    }

    public String getFileNameInZip() {
        return this.f5008l;
    }

    public void setFileNameInZip(String str) {
        this.f5008l = str;
    }

    public long getLastModifiedFileTime() {
        return this.f5009m;
    }

    public void setLastModifiedFileTime(long j) {
        if (j > 0) {
            this.f5009m = j;
        }
    }

    public long getEntrySize() {
        return this.f5010n;
    }

    public void setEntrySize(long j) {
        this.f5010n = j;
    }

    public boolean isWriteExtendedLocalFileHeader() {
        return this.f5011o;
    }

    public void setWriteExtendedLocalFileHeader(boolean z) {
        this.f5011o = z;
    }

    public boolean isOverrideExistingFilesInZip() {
        return this.f5012p;
    }

    public void setOverrideExistingFilesInZip(boolean z) {
        this.f5012p = z;
    }

    public String getRootFolderNameInZip() {
        return this.f5013q;
    }

    public void setRootFolderNameInZip(String str) {
        this.f5013q = str;
    }

    public String getFileComment() {
        return this.f5014r;
    }

    public void setFileComment(String str) {
        this.f5014r = str;
    }

    public SymbolicLinkAction getSymbolicLinkAction() {
        return this.f5015s;
    }

    public void setSymbolicLinkAction(SymbolicLinkAction symbolicLinkAction) {
        this.f5015s = symbolicLinkAction;
    }

    public ExcludeFileFilter getExcludeFileFilter() {
        return this.f5016t;
    }

    public void setExcludeFileFilter(ExcludeFileFilter excludeFileFilter) {
        this.f5016t = excludeFileFilter;
    }

    public boolean isUnixMode() {
        return this.f5017u;
    }

    public void setUnixMode(boolean z) {
        this.f5017u = z;
    }
}
