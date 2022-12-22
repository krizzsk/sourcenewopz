package com.didi.dqr.pdf417;

public final class PDF417ResultMetadata {

    /* renamed from: a */
    private int f18867a;

    /* renamed from: b */
    private String f18868b;

    /* renamed from: c */
    private boolean f18869c;

    /* renamed from: d */
    private int f18870d = -1;

    /* renamed from: e */
    private String f18871e;

    /* renamed from: f */
    private String f18872f;

    /* renamed from: g */
    private String f18873g;

    /* renamed from: h */
    private long f18874h = -1;

    /* renamed from: i */
    private long f18875i = -1;

    /* renamed from: j */
    private int f18876j = -1;

    /* renamed from: k */
    private int[] f18877k;

    public int getSegmentIndex() {
        return this.f18867a;
    }

    public void setSegmentIndex(int i) {
        this.f18867a = i;
    }

    public String getFileId() {
        return this.f18868b;
    }

    public void setFileId(String str) {
        this.f18868b = str;
    }

    @Deprecated
    public int[] getOptionalData() {
        return this.f18877k;
    }

    @Deprecated
    public void setOptionalData(int[] iArr) {
        this.f18877k = iArr;
    }

    public boolean isLastSegment() {
        return this.f18869c;
    }

    public void setLastSegment(boolean z) {
        this.f18869c = z;
    }

    public int getSegmentCount() {
        return this.f18870d;
    }

    public void setSegmentCount(int i) {
        this.f18870d = i;
    }

    public String getSender() {
        return this.f18871e;
    }

    public void setSender(String str) {
        this.f18871e = str;
    }

    public String getAddressee() {
        return this.f18872f;
    }

    public void setAddressee(String str) {
        this.f18872f = str;
    }

    public String getFileName() {
        return this.f18873g;
    }

    public void setFileName(String str) {
        this.f18873g = str;
    }

    public long getFileSize() {
        return this.f18874h;
    }

    public void setFileSize(long j) {
        this.f18874h = j;
    }

    public int getChecksum() {
        return this.f18876j;
    }

    public void setChecksum(int i) {
        this.f18876j = i;
    }

    public long getTimestamp() {
        return this.f18875i;
    }

    public void setTimestamp(long j) {
        this.f18875i = j;
    }
}
