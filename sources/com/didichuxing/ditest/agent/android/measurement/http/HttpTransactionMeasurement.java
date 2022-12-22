package com.didichuxing.ditest.agent.android.measurement.http;

import com.didichuxing.ditest.agent.android.Agent;
import com.didichuxing.ditest.agent.android.background.ApplicationStateMonitor;
import com.didichuxing.ditest.agent.android.measurement.BaseMeasurement;
import com.didichuxing.ditest.agent.android.measurement.MeasurementType;
import java.util.Map;

public class HttpTransactionMeasurement extends BaseMeasurement {
    private int businessId;
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private String errCodeClass;
    private String errCodeInfo;
    private int errorCode;
    private Exception exception;
    private boolean foreground;
    private String httpMethod;
    private int httpdns;
    private Map<String, Object> okHttp3Data;
    private int statusCode;
    private double totalTime;
    private String traceId;
    private String url;
    private String wanType;

    public HttpTransactionMeasurement(String str, String str2, int i, long j, long j2, long j3, long j4, int i2, String str3) {
        super(MeasurementType.Network);
        this.carrier = "unknown";
        this.wanType = "unknown";
        setName(str);
        setStartTime(j);
        setEndTime(j + j2);
        setExclusiveTime(j2);
        this.url = str;
        this.httpMethod = str2;
        this.statusCode = i;
        this.bytesSent = j3;
        this.bytesReceived = j4;
        this.totalTime = (double) j2;
        this.businessId = i2;
        this.traceId = str3;
        this.foreground = ApplicationStateMonitor.getInstance().isForegrounded();
        this.wanType = Agent.getActiveNetworkWanType();
        this.carrier = Agent.getActiveNetworkCarrier();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpTransactionMeasurement(String str, String str2, int i, int i2, long j, long j2, long j3, long j4, int i3, String str3, String str4, String str5) {
        this(str, str2, i, j, j2, j3, j4, i3, str3);
        this.errorCode = i2;
        this.errCodeClass = str4;
        this.errCodeInfo = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpTransactionMeasurement(String str, String str2, int i, int i2, int i3, long j, long j2, long j3, long j4, int i4, String str3, Exception exc, Map<String, Object> map) {
        this(str, str2, i2, j, j2, j3, j4, i4, str3);
        this.httpdns = i;
        this.errorCode = i3;
        this.exception = exc;
        this.okHttp3Data = map;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public double getTotalTime() {
        return this.totalTime;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getWanType() {
        return this.wanType;
    }

    public void setWanType(String str) {
        this.wanType = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public int getBusinessId() {
        return this.businessId;
    }

    public boolean isForeground() {
        return this.foreground;
    }

    public String getTraceId() {
        return this.traceId;
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

    public Exception getException() {
        return this.exception;
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }

    public Map<String, Object> getOkHttp3Data() {
        return this.okHttp3Data;
    }

    public void setOkHttp3Data(Map<String, Object> map) {
        this.okHttp3Data = map;
    }

    public int getHttpdns() {
        return this.httpdns;
    }

    public void setHttpdns(int i) {
        this.httpdns = i;
    }

    public String toString() {
        return "HttpTransactionMeasurement{url='" + this.url + '\'' + ", httpMethod='" + this.httpMethod + '\'' + ", totalTime=" + this.totalTime + '\'' + ", statusCode=" + this.statusCode + '\'' + ", errorCode=" + this.errorCode + '\'' + ", bytesSent=" + this.bytesSent + '\'' + ", bytesReceived=" + this.bytesReceived + '\'' + ", wan=" + this.wanType + '\'' + ", carrier=" + this.carrier + '\'' + ", businessId=" + this.businessId + '\'' + ", traceId=" + this.traceId + '\'' + ", forground=" + this.foreground;
    }
}
