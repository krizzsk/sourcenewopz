package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background.ApplicationStateMonitor;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.BaseMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.MeasurementType;
import java.util.Map;

public class HttpTransactionMeasurement extends BaseMeasurement {

    /* renamed from: a */
    private String f48016a;

    /* renamed from: b */
    private String f48017b;

    /* renamed from: c */
    private double f48018c;

    /* renamed from: d */
    private int f48019d;

    /* renamed from: e */
    private int f48020e;

    /* renamed from: f */
    private long f48021f;

    /* renamed from: g */
    private long f48022g;

    /* renamed from: h */
    private String f48023h;

    /* renamed from: i */
    private String f48024i;

    /* renamed from: j */
    private int f48025j;

    /* renamed from: k */
    private String f48026k;

    /* renamed from: l */
    private boolean f48027l;

    /* renamed from: m */
    private String f48028m;

    /* renamed from: n */
    private String f48029n;

    /* renamed from: o */
    private Exception f48030o;

    /* renamed from: p */
    private Map<String, Object> f48031p;

    /* renamed from: q */
    private int f48032q;

    public HttpTransactionMeasurement(String str, String str2, int i, long j, long j2, long j3, long j4, int i2, String str3) {
        super(MeasurementType.Network);
        this.f48023h = "unknown";
        this.f48024i = "unknown";
        setName(str);
        setStartTime(j);
        setEndTime(j + j2);
        setExclusiveTime(j2);
        this.f48016a = str;
        this.f48017b = str2;
        this.f48019d = i;
        this.f48021f = j3;
        this.f48022g = j4;
        this.f48018c = (double) j2;
        this.f48025j = i2;
        this.f48026k = str3;
        this.f48027l = ApplicationStateMonitor.getInstance().isForegrounded();
        this.f48024i = Agent.getActiveNetworkWanType();
        this.f48023h = Agent.getActiveNetworkCarrier();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpTransactionMeasurement(String str, String str2, int i, int i2, long j, long j2, long j3, long j4, int i3, String str3, String str4, String str5) {
        this(str, str2, i, j, j2, j3, j4, i3, str3);
        this.f48020e = i2;
        this.f48028m = str4;
        this.f48029n = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpTransactionMeasurement(String str, String str2, int i, int i2, int i3, long j, long j2, long j3, long j4, int i4, String str3, Exception exc, Map<String, Object> map) {
        this(str, str2, i2, j, j2, j3, j4, i4, str3);
        this.f48032q = i;
        this.f48020e = i3;
        this.f48030o = exc;
        this.f48031p = map;
    }

    public String getUrl() {
        return this.f48016a;
    }

    public String getHttpMethod() {
        return this.f48017b;
    }

    public double getTotalTime() {
        return this.f48018c;
    }

    public int getStatusCode() {
        return this.f48019d;
    }

    public int getErrorCode() {
        return this.f48020e;
    }

    public long getBytesSent() {
        return this.f48021f;
    }

    public long getBytesReceived() {
        return this.f48022g;
    }

    public void setUrl(String str) {
        this.f48016a = str;
    }

    public String getCarrier() {
        return this.f48023h;
    }

    public String getWanType() {
        return this.f48024i;
    }

    public void setWanType(String str) {
        this.f48024i = str;
    }

    public void setCarrier(String str) {
        this.f48023h = str;
    }

    public int getBusinessId() {
        return this.f48025j;
    }

    public boolean isForeground() {
        return this.f48027l;
    }

    public String getTraceId() {
        return this.f48026k;
    }

    public String getErrCodeClass() {
        return this.f48028m;
    }

    public void setErrCodeClass(String str) {
        this.f48028m = str;
    }

    public String getErrCodeInfo() {
        return this.f48029n;
    }

    public void setErrCodeInfo(String str) {
        this.f48029n = str;
    }

    public Exception getException() {
        return this.f48030o;
    }

    public void setException(Exception exc) {
        this.f48030o = exc;
    }

    public Map<String, Object> getOkHttp3Data() {
        return this.f48031p;
    }

    public void setOkHttp3Data(Map<String, Object> map) {
        this.f48031p = map;
    }

    public int getHttpdns() {
        return this.f48032q;
    }

    public void setHttpdns(int i) {
        this.f48032q = i;
    }

    public String toString() {
        return "HttpTransactionMeasurement{url='" + this.f48016a + '\'' + ", httpMethod='" + this.f48017b + '\'' + ", totalTime=" + this.f48018c + '\'' + ", statusCode=" + this.f48019d + '\'' + ", errorCode=" + this.f48020e + '\'' + ", bytesSent=" + this.f48021f + '\'' + ", bytesReceived=" + this.f48022g + '\'' + ", wan=" + this.f48024i + '\'' + ", carrier=" + this.f48023h + '\'' + ", businessId=" + this.f48025j + '\'' + ", traceId=" + this.f48026k + '\'' + ", forground=" + this.f48027l;
    }
}
