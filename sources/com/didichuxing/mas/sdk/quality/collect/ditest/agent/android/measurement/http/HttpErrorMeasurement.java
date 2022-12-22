package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.BaseMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.MeasurementType;
import java.util.Map;

public class HttpErrorMeasurement extends BaseMeasurement {

    /* renamed from: a */
    private String f48011a;

    /* renamed from: b */
    private int f48012b;

    /* renamed from: c */
    private String f48013c;

    /* renamed from: d */
    private String f48014d;

    /* renamed from: e */
    private Map<String, String> f48015e;

    public HttpErrorMeasurement(String str, int i) {
        super(MeasurementType.HttpError);
        setUrl(str);
        setName(str);
        setHttpStatusCode(i);
        setStartTime(System.currentTimeMillis());
    }

    public void setUrl(String str) {
        this.f48011a = str;
    }

    public void setHttpStatusCode(int i) {
        this.f48012b = i;
    }

    public void setResponseBody(String str) {
        this.f48013c = str;
    }

    public void setStackTrace(String str) {
        this.f48014d = str;
    }

    public void setParams(Map<String, String> map) {
        this.f48015e = map;
    }

    public String getUrl() {
        return this.f48011a;
    }

    public int getHttpStatusCode() {
        return this.f48012b;
    }

    public String getResponseBody() {
        return this.f48013c;
    }

    public String getStackTrace() {
        return this.f48014d;
    }

    public Map<String, String> getParams() {
        return this.f48015e;
    }
}
