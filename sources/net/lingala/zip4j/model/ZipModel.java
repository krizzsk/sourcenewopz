package net.lingala.zip4j.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZipModel implements Cloneable {

    /* renamed from: a */
    private List<LocalFileHeader> f4983a = new ArrayList();

    /* renamed from: b */
    private List<DataDescriptor> f4984b = new ArrayList();

    /* renamed from: c */
    private ArchiveExtraDataRecord f4985c = new ArchiveExtraDataRecord();

    /* renamed from: d */
    private CentralDirectory f4986d = new CentralDirectory();

    /* renamed from: e */
    private EndOfCentralDirectoryRecord f4987e = new EndOfCentralDirectoryRecord();

    /* renamed from: f */
    private Zip64EndOfCentralDirectoryLocator f4988f = new Zip64EndOfCentralDirectoryLocator();

    /* renamed from: g */
    private Zip64EndOfCentralDirectoryRecord f4989g = new Zip64EndOfCentralDirectoryRecord();

    /* renamed from: h */
    private boolean f4990h;

    /* renamed from: i */
    private long f4991i = -1;

    /* renamed from: j */
    private File f4992j;

    /* renamed from: k */
    private boolean f4993k = false;

    /* renamed from: l */
    private boolean f4994l;

    /* renamed from: m */
    private long f4995m;

    /* renamed from: n */
    private long f4996n;

    public List<LocalFileHeader> getLocalFileHeaders() {
        return this.f4983a;
    }

    public void setLocalFileHeaders(List<LocalFileHeader> list) {
        this.f4983a = list;
    }

    public List<DataDescriptor> getDataDescriptors() {
        return this.f4984b;
    }

    public void setDataDescriptors(List<DataDescriptor> list) {
        this.f4984b = list;
    }

    public CentralDirectory getCentralDirectory() {
        return this.f4986d;
    }

    public void setCentralDirectory(CentralDirectory centralDirectory) {
        this.f4986d = centralDirectory;
    }

    public EndOfCentralDirectoryRecord getEndOfCentralDirectoryRecord() {
        return this.f4987e;
    }

    public void setEndOfCentralDirectoryRecord(EndOfCentralDirectoryRecord endOfCentralDirectoryRecord) {
        this.f4987e = endOfCentralDirectoryRecord;
    }

    public ArchiveExtraDataRecord getArchiveExtraDataRecord() {
        return this.f4985c;
    }

    public void setArchiveExtraDataRecord(ArchiveExtraDataRecord archiveExtraDataRecord) {
        this.f4985c = archiveExtraDataRecord;
    }

    public boolean isSplitArchive() {
        return this.f4990h;
    }

    public void setSplitArchive(boolean z) {
        this.f4990h = z;
    }

    public File getZipFile() {
        return this.f4992j;
    }

    public void setZipFile(File file) {
        this.f4992j = file;
    }

    public Zip64EndOfCentralDirectoryLocator getZip64EndOfCentralDirectoryLocator() {
        return this.f4988f;
    }

    public void setZip64EndOfCentralDirectoryLocator(Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator) {
        this.f4988f = zip64EndOfCentralDirectoryLocator;
    }

    public Zip64EndOfCentralDirectoryRecord getZip64EndOfCentralDirectoryRecord() {
        return this.f4989g;
    }

    public void setZip64EndOfCentralDirectoryRecord(Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord) {
        this.f4989g = zip64EndOfCentralDirectoryRecord;
    }

    public boolean isZip64Format() {
        return this.f4993k;
    }

    public void setZip64Format(boolean z) {
        this.f4993k = z;
    }

    public boolean isNestedZipFile() {
        return this.f4994l;
    }

    public void setNestedZipFile(boolean z) {
        this.f4994l = z;
    }

    public long getStart() {
        return this.f4995m;
    }

    public void setStart(long j) {
        this.f4995m = j;
    }

    public long getEnd() {
        return this.f4996n;
    }

    public void setEnd(long j) {
        this.f4996n = j;
    }

    public long getSplitLength() {
        return this.f4991i;
    }

    public void setSplitLength(long j) {
        this.f4991i = j;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
