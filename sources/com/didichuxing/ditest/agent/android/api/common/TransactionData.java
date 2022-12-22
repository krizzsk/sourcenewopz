package com.didichuxing.ditest.agent.android.api.common;

public class TransactionData {
    private int businessType;
    private final long bytesReceived;
    private final long bytesSent;
    private final String carrier;
    private String errCodeClass;
    private String errCodeInfo;
    private int errorCode;
    private final Object errorCodeLock = new Object();
    private boolean forground;
    private final String httpMethod;
    private final int statusCode;
    private final long time;
    private final long timestamp;
    private String traceId;
    private final String url;
    private final String wanType;

    public TransactionData(String str, String str2, String str3, long j, int i, int i2, long j2, long j3, String str4, int i3, String str5, boolean z, String str6, String str7) {
        this.url = str;
        this.httpMethod = str2;
        this.carrier = str3;
        this.time = j;
        this.statusCode = i;
        this.errorCode = i2;
        this.bytesSent = j2;
        this.bytesReceived = j3;
        this.wanType = str4;
        this.timestamp = System.currentTimeMillis();
        this.businessType = i3;
        this.traceId = str5;
        this.forground = z;
        this.errCodeClass = str6;
        this.errCodeInfo = str7;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getErrorCode() {
        int i;
        synchronized (this.errorCodeLock) {
            i = this.errorCode;
        }
        return i;
    }

    public void setErrorCode(int i) {
        synchronized (this.errorCodeLock) {
            this.errorCode = i;
        }
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public String getWanType() {
        return this.wanType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getTime() {
        return this.time;
    }

    public TransactionData clone() {
        return new TransactionData(this.url, this.httpMethod, this.carrier, this.time, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.wanType, this.businessType, this.traceId, this.forground, this.errCodeClass, this.errCodeInfo);
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(int i) {
        this.businessType = i;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public boolean isForground() {
        return this.forground;
    }

    public String getErrCodeClass() {
        return this.errCodeClass;
    }

    public void setErrCodeClass(String str) {
        this.errCodeClass = str;
    }

    public String getErrCodeInfo() {
        return this.errCodeInfo;
    }

    public void setErrCodeInfo(String str) {
        this.errCodeInfo = str;
    }

    public String toString() {
        return "TransactionData{timestamp=" + this.timestamp + ", url='" + this.url + '\'' + ", httpMethod='" + this.httpMethod + '\'' + ", carrier='" + this.carrier + '\'' + ", time=" + this.time + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", errorCodeLock=" + this.errorCodeLock + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", wanType='" + this.wanType + '\'' + ", forground=" + this.forground + '}';
    }
}
