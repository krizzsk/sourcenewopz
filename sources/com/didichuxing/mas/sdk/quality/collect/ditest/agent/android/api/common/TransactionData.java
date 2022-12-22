package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common;

public class TransactionData {

    /* renamed from: a */
    private final long f47918a;

    /* renamed from: b */
    private final String f47919b;

    /* renamed from: c */
    private final String f47920c;

    /* renamed from: d */
    private final String f47921d;

    /* renamed from: e */
    private final long f47922e;

    /* renamed from: f */
    private final int f47923f;

    /* renamed from: g */
    private int f47924g;

    /* renamed from: h */
    private final Object f47925h = new Object();

    /* renamed from: i */
    private final long f47926i;

    /* renamed from: j */
    private final long f47927j;

    /* renamed from: k */
    private final String f47928k;

    /* renamed from: l */
    private int f47929l;

    /* renamed from: m */
    private String f47930m;

    /* renamed from: n */
    private boolean f47931n;

    /* renamed from: o */
    private String f47932o;

    /* renamed from: p */
    private String f47933p;

    public TransactionData(String str, String str2, String str3, long j, int i, int i2, long j2, long j3, String str4, int i3, String str5, boolean z, String str6, String str7) {
        this.f47919b = str;
        this.f47920c = str2;
        this.f47921d = str3;
        this.f47922e = j;
        this.f47923f = i;
        this.f47924g = i2;
        this.f47926i = j2;
        this.f47927j = j3;
        this.f47928k = str4;
        this.f47918a = System.currentTimeMillis();
        this.f47929l = i3;
        this.f47930m = str5;
        this.f47931n = z;
        this.f47932o = str6;
        this.f47933p = str7;
    }

    public String getUrl() {
        return this.f47919b;
    }

    public String getHttpMethod() {
        return this.f47920c;
    }

    public String getCarrier() {
        return this.f47921d;
    }

    public int getStatusCode() {
        return this.f47923f;
    }

    public int getErrorCode() {
        int i;
        synchronized (this.f47925h) {
            i = this.f47924g;
        }
        return i;
    }

    public void setErrorCode(int i) {
        synchronized (this.f47925h) {
            this.f47924g = i;
        }
    }

    public long getBytesSent() {
        return this.f47926i;
    }

    public long getBytesReceived() {
        return this.f47927j;
    }

    public String getWanType() {
        return this.f47928k;
    }

    public long getTimestamp() {
        return this.f47918a;
    }

    public long getTime() {
        return this.f47922e;
    }

    public TransactionData clone() {
        return new TransactionData(this.f47919b, this.f47920c, this.f47921d, this.f47922e, this.f47923f, this.f47924g, this.f47926i, this.f47927j, this.f47928k, this.f47929l, this.f47930m, this.f47931n, this.f47932o, this.f47933p);
    }

    public int getBusinessType() {
        return this.f47929l;
    }

    public void setBusinessType(int i) {
        this.f47929l = i;
    }

    public String getTraceId() {
        return this.f47930m;
    }

    public void setTraceId(String str) {
        this.f47930m = str;
    }

    public boolean isForground() {
        return this.f47931n;
    }

    public String getErrCodeClass() {
        return this.f47932o;
    }

    public void setErrCodeClass(String str) {
        this.f47932o = str;
    }

    public String getErrCodeInfo() {
        return this.f47933p;
    }

    public void setErrCodeInfo(String str) {
        this.f47933p = str;
    }

    public String toString() {
        return "TransactionData{timestamp=" + this.f47918a + ", url='" + this.f47919b + '\'' + ", httpMethod='" + this.f47920c + '\'' + ", carrier='" + this.f47921d + '\'' + ", time=" + this.f47922e + ", statusCode=" + this.f47923f + ", errorCode=" + this.f47924g + ", errorCodeLock=" + this.f47925h + ", bytesSent=" + this.f47926i + ", bytesReceived=" + this.f47927j + ", wanType='" + this.f47928k + '\'' + ", forground=" + this.f47931n + '}';
    }
}
