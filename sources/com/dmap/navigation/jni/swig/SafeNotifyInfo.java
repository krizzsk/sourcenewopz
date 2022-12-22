package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class SafeNotifyInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SafeNotifyInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SafeNotifyInfo safeNotifyInfo) {
        if (safeNotifyInfo == null) {
            return 0;
        }
        return safeNotifyInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_SafeNotifyInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setAiUsedSpeed(float f) {
        NaviBusinessJNI.SafeNotifyInfo_aiUsedSpeed_set(this.swigCPtr, this, f);
    }

    public float getAiUsedSpeed() {
        return NaviBusinessJNI.SafeNotifyInfo_aiUsedSpeed_get(this.swigCPtr, this);
    }

    public void setLimitSpeed(int i) {
        NaviBusinessJNI.SafeNotifyInfo_limitSpeed_set(this.swigCPtr, this, i);
    }

    public int getLimitSpeed() {
        return NaviBusinessJNI.SafeNotifyInfo_limitSpeed_get(this.swigCPtr, this);
    }

    public void setLinkId(BigInteger bigInteger) {
        NaviBusinessJNI.SafeNotifyInfo_linkId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getLinkId() {
        return NaviBusinessJNI.SafeNotifyInfo_linkId_get(this.swigCPtr, this);
    }

    public void setGeoPoint(NaviLatLng naviLatLng) {
        NaviBusinessJNI.SafeNotifyInfo_geoPoint_set(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng getGeoPoint() {
        long SafeNotifyInfo_geoPoint_get = NaviBusinessJNI.SafeNotifyInfo_geoPoint_get(this.swigCPtr, this);
        if (SafeNotifyInfo_geoPoint_get == 0) {
            return null;
        }
        return new NaviLatLng(SafeNotifyInfo_geoPoint_get, false);
    }

    public void setMapVersion(String str) {
        NaviBusinessJNI.SafeNotifyInfo_mapVersion_set(this.swigCPtr, this, str);
    }

    public String getMapVersion() {
        return NaviBusinessJNI.SafeNotifyInfo_mapVersion_get(this.swigCPtr, this);
    }

    public void setInterveneType(int i) {
        NaviBusinessJNI.SafeNotifyInfo_interveneType_set(this.swigCPtr, this, i);
    }

    public int getInterveneType() {
        return NaviBusinessJNI.SafeNotifyInfo_interveneType_get(this.swigCPtr, this);
    }

    public void setPreFix(int i) {
        NaviBusinessJNI.SafeNotifyInfo_preFix_set(this.swigCPtr, this, i);
    }

    public int getPreFix() {
        return NaviBusinessJNI.SafeNotifyInfo_preFix_get(this.swigCPtr, this);
    }

    public void setDuration(int i) {
        NaviBusinessJNI.SafeNotifyInfo_duration_set(this.swigCPtr, this, i);
    }

    public int getDuration() {
        return NaviBusinessJNI.SafeNotifyInfo_duration_get(this.swigCPtr, this);
    }

    public void setTtsContent(String str) {
        NaviBusinessJNI.SafeNotifyInfo_ttsContent_set(this.swigCPtr, this, str);
    }

    public String getTtsContent() {
        return NaviBusinessJNI.SafeNotifyInfo_ttsContent_get(this.swigCPtr, this);
    }

    public void setTimestamp(int i) {
        NaviBusinessJNI.SafeNotifyInfo_timestamp_set(this.swigCPtr, this, i);
    }

    public int getTimestamp() {
        return NaviBusinessJNI.SafeNotifyInfo_timestamp_get(this.swigCPtr, this);
    }

    public SafeNotifyInfo() {
        this(NaviBusinessJNI.new_SafeNotifyInfo(), true);
    }
}
