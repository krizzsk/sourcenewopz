package com.didichuxing.ditest.agent.android;

import androidx.work.PeriodicWorkRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AgentConfiguration {
    private ConcurrentMap<String, Boolean> allNetCollectUrlMap;
    private boolean allNetUploadEnable = false;
    private long allNetUploadLimit = 10000;
    private boolean disabled = false;
    private double exceptionCollectRate = 0.0d;
    private boolean isApmNetEnable;
    private boolean isApmUiEnable;
    private long maxNetEventUploadNum = 10000;
    private long maxTrafficFiveMinutes = 100000000;
    private long maxTrafficPerDay = 500000000;
    private int maxUploadNetErrEventPerDay = 2000;
    private boolean netEventLogEnabled = false;
    private long netEventLogUploadInterval = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
    private long overRequestTime = 5000;
    private int responseBodyLimit = 65535;
    private boolean uploadAllUrlEnable = false;
    private boolean uploadErrorDiag = true;
    private boolean uploadNetPerf = true;

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean z) {
        this.disabled = z;
    }

    public int getResponseBodyLimit() {
        return this.responseBodyLimit;
    }

    public void setResponseBodyLimit(int i) {
        this.responseBodyLimit = i;
    }

    public boolean isApmNetEnable() {
        return !this.disabled && this.isApmNetEnable;
    }

    public void setApmNetEnable(boolean z) {
        this.isApmNetEnable = z;
    }

    public boolean isApmUiEnable() {
        return !this.disabled && this.isApmUiEnable;
    }

    public void setApmUiEnable(boolean z) {
        this.isApmUiEnable = z;
    }

    public boolean isUploadNetPerf() {
        return this.uploadNetPerf;
    }

    public void setUploadNetPerf(boolean z) {
        this.uploadNetPerf = z;
    }

    public boolean isUploadErrorDiag() {
        return this.uploadErrorDiag;
    }

    public void setUploadErrorDiag(boolean z) {
        this.uploadErrorDiag = z;
    }

    public int getMaxUploadNetErrEventPerDay() {
        return this.maxUploadNetErrEventPerDay;
    }

    public void setMaxUploadNetErrEventPerDay(int i) {
        this.maxUploadNetErrEventPerDay = i;
    }

    public long getMaxTrafficPerDay() {
        return this.maxTrafficPerDay;
    }

    public void setMaxTrafficPerDay(long j) {
        this.maxTrafficPerDay = j;
    }

    public long getMaxTrafficFiveMinutes() {
        return this.maxTrafficFiveMinutes;
    }

    public void setMaxTrafficFiveMinutes(long j) {
        this.maxTrafficFiveMinutes = j;
    }

    public long getOverRequestTime() {
        return this.overRequestTime;
    }

    public void setOverRequestTime(long j) {
        this.overRequestTime = j;
    }

    public boolean isNetEventLogEnabled() {
        return this.netEventLogEnabled;
    }

    public void setNetEventLogEnabled(boolean z) {
        this.netEventLogEnabled = z;
    }

    public long getNetEventLogUploadInterval() {
        return this.netEventLogUploadInterval;
    }

    public void setNetEventLogUploadInterval(long j) {
        this.netEventLogUploadInterval = j;
    }

    public long getMaxNetEventUploadNum() {
        return this.maxNetEventUploadNum;
    }

    public void setMaxNetEventUploadNum(long j) {
        this.maxNetEventUploadNum = j;
    }

    public boolean isAllNetUploadEnable() {
        return this.allNetUploadEnable;
    }

    public void setAllNetUploadEnable(boolean z) {
        this.allNetUploadEnable = z;
    }

    public long getAllNetUploadLimit() {
        return this.allNetUploadLimit;
    }

    public void setAllNetUploadLimit(long j) {
        this.allNetUploadLimit = j;
    }

    public void initWhiteListAllNetCollectMap(String str) {
        if (this.allNetCollectUrlMap == null) {
            this.allNetCollectUrlMap = new ConcurrentHashMap();
        }
        for (String put : str.split(",")) {
            this.allNetCollectUrlMap.put(put, true);
        }
    }

    public void addUploadUrlWhiteList(String str) {
        if (this.allNetCollectUrlMap == null) {
            this.allNetCollectUrlMap = new ConcurrentHashMap();
        }
        this.allNetCollectUrlMap.put(str, true);
    }

    public void addUploadUrlWhiteListAll(Map<String, Boolean> map) {
        if (this.allNetCollectUrlMap == null) {
            this.allNetCollectUrlMap = new ConcurrentHashMap();
        }
        this.allNetCollectUrlMap.putAll(map);
    }

    public boolean isUploadAllUrlEnable() {
        return this.uploadAllUrlEnable;
    }

    public void setUploadAllUrlEnable(boolean z) {
        this.uploadAllUrlEnable = z;
    }

    public boolean inAllNetUploadWhiteList(String str) {
        if (this.uploadAllUrlEnable) {
            return true;
        }
        ConcurrentMap<String, Boolean> concurrentMap = this.allNetCollectUrlMap;
        if (concurrentMap == null) {
            return false;
        }
        for (String str2 : concurrentMap.keySet()) {
            if (str.contains(str2)) {
                Boolean bool = (Boolean) this.allNetCollectUrlMap.get(str2);
                if (bool == null || !bool.booleanValue()) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public double getExceptionCollectRate() {
        return this.exceptionCollectRate;
    }

    public void setExceptionCollectRate(double d) {
        this.exceptionCollectRate = d;
    }

    public void clearUploadUrlPath() {
        ConcurrentMap<String, Boolean> concurrentMap = this.allNetCollectUrlMap;
        if (concurrentMap != null && !concurrentMap.isEmpty()) {
            this.allNetCollectUrlMap.clear();
        }
    }
}
