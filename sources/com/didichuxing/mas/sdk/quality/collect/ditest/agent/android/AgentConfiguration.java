package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AgentConfiguration {

    /* renamed from: a */
    private boolean f47798a = false;

    /* renamed from: b */
    private int f47799b = 65535;

    /* renamed from: c */
    private boolean f47800c;

    /* renamed from: d */
    private boolean f47801d;

    /* renamed from: e */
    private boolean f47802e = true;

    /* renamed from: f */
    private boolean f47803f = true;

    /* renamed from: g */
    private int f47804g = 2000;

    /* renamed from: h */
    private long f47805h = 500000000;

    /* renamed from: i */
    private long f47806i = 100000000;

    /* renamed from: j */
    private long f47807j = 5000;

    /* renamed from: k */
    private boolean f47808k = false;

    /* renamed from: l */
    private long f47809l = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;

    /* renamed from: m */
    private long f47810m = 10000;

    /* renamed from: n */
    private boolean f47811n = false;

    /* renamed from: o */
    private long f47812o = 10000;

    /* renamed from: p */
    private double f47813p = 0.0d;

    /* renamed from: q */
    private boolean f47814q = false;

    /* renamed from: r */
    private ConcurrentMap<String, Boolean> f47815r;

    public boolean isDisabled() {
        return this.f47798a;
    }

    public void setDisabled(boolean z) {
        this.f47798a = z;
    }

    public int getResponseBodyLimit() {
        return this.f47799b;
    }

    public void setResponseBodyLimit(int i) {
        this.f47799b = i;
    }

    public boolean isApmNetEnable() {
        return !this.f47798a && this.f47800c;
    }

    public void setApmNetEnable(boolean z) {
        this.f47800c = z;
    }

    public boolean isApmUiEnable() {
        return !this.f47798a && this.f47801d;
    }

    public void setApmUiEnable(boolean z) {
        this.f47801d = z;
    }

    public boolean isUploadNetPerf() {
        return this.f47802e;
    }

    public void setUploadNetPerf(boolean z) {
        this.f47802e = z;
    }

    public boolean isUploadErrorDiag() {
        return this.f47803f;
    }

    public void setUploadErrorDiag(boolean z) {
        this.f47803f = z;
    }

    public int getMaxUploadNetErrEventPerDay() {
        return this.f47804g;
    }

    public void setMaxUploadNetErrEventPerDay(int i) {
        this.f47804g = i;
    }

    public long getMaxTrafficPerDay() {
        return this.f47805h;
    }

    public void setMaxTrafficPerDay(long j) {
        this.f47805h = j;
    }

    public long getMaxTrafficFiveMinutes() {
        return this.f47806i;
    }

    public void setMaxTrafficFiveMinutes(long j) {
        this.f47806i = j;
    }

    public long getOverRequestTime() {
        return this.f47807j;
    }

    public void setOverRequestTime(long j) {
        this.f47807j = j;
    }

    public boolean isNetEventLogEnabled() {
        return this.f47808k;
    }

    public void setNetEventLogEnabled(boolean z) {
        this.f47808k = z;
    }

    public long getNetEventLogUploadInterval() {
        return this.f47809l;
    }

    public void setNetEventLogUploadInterval(long j) {
        this.f47809l = j;
    }

    public long getMaxNetEventUploadNum() {
        return this.f47810m;
    }

    public void setMaxNetEventUploadNum(long j) {
        this.f47810m = j;
    }

    public boolean isAllNetUploadEnable() {
        return this.f47811n;
    }

    public void setAllNetUploadEnable(boolean z) {
        this.f47811n = z;
    }

    public long getAllNetUploadLimit() {
        return this.f47812o;
    }

    public void setAllNetUploadLimit(long j) {
        this.f47812o = j;
    }

    public void initWhiteListAllNetCollectMap(String str) {
        if (this.f47815r == null) {
            this.f47815r = new ConcurrentHashMap();
        }
        for (String put : str.split(",")) {
            this.f47815r.put(put, true);
        }
    }

    public void addUploadUrlWhiteList(String str) {
        if (this.f47815r == null) {
            this.f47815r = new ConcurrentHashMap();
        }
        this.f47815r.put(str, true);
    }

    public void addUploadUrlWhiteListAll(Map<String, Boolean> map) {
        if (this.f47815r == null) {
            this.f47815r = new ConcurrentHashMap();
        }
        this.f47815r.putAll(map);
    }

    public boolean isUploadAllUrlEnable() {
        return this.f47814q;
    }

    public void setUploadAllUrlEnable(boolean z) {
        this.f47814q = z;
    }

    public boolean inAllNetUploadWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f47814q) {
            return true;
        }
        ConcurrentMap<String, Boolean> concurrentMap = this.f47815r;
        if (concurrentMap == null) {
            return false;
        }
        for (String str2 : concurrentMap.keySet()) {
            if (str.contains(str2)) {
                Boolean bool = (Boolean) this.f47815r.get(str2);
                if (bool == null || !bool.booleanValue()) {
                    return false;
                }
                return true;
            }
        }
        List<String> uploadURLWhiteList = CustomCollector.getUploadURLWhiteList();
        if (uploadURLWhiteList != null && uploadURLWhiteList.size() > 0) {
            for (String contains : uploadURLWhiteList) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double getExceptionCollectRate() {
        return this.f47813p;
    }

    public void setExceptionCollectRate(double d) {
        this.f47813p = d;
    }

    public void clearUploadUrlPath() {
        ConcurrentMap<String, Boolean> concurrentMap = this.f47815r;
        if (concurrentMap != null && !concurrentMap.isEmpty()) {
            this.f47815r.clear();
        }
    }
}
