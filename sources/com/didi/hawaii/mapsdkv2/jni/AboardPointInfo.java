package com.didi.hawaii.mapsdkv2.jni;

import java.math.BigInteger;

public class AboardPointInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AboardPointInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AboardPointInfo aboardPointInfo) {
        if (aboardPointInfo == null) {
            return 0;
        }
        return aboardPointInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_AboardPointInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setPoiid(BigInteger bigInteger) {
        MapEngineJNIBridge.AboardPointInfo_poiid_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getPoiid() {
        return MapEngineJNIBridge.AboardPointInfo_poiid_get(this.swigCPtr, this);
    }

    public void setUrl(String str) {
        MapEngineJNIBridge.AboardPointInfo_url_set(this.swigCPtr, this, str);
    }

    public String getUrl() {
        return MapEngineJNIBridge.AboardPointInfo_url_get(this.swigCPtr, this);
    }

    public void setUrlLen(int i) {
        MapEngineJNIBridge.AboardPointInfo_urlLen_set(this.swigCPtr, this, i);
    }

    public int getUrlLen() {
        return MapEngineJNIBridge.AboardPointInfo_urlLen_get(this.swigCPtr, this);
    }

    public void setBHighlight(boolean z) {
        MapEngineJNIBridge.AboardPointInfo_bHighlight_set(this.swigCPtr, this, z);
    }

    public boolean getBHighlight() {
        return MapEngineJNIBridge.AboardPointInfo_bHighlight_get(this.swigCPtr, this);
    }

    public void setBHidden(boolean z) {
        MapEngineJNIBridge.AboardPointInfo_bHidden_set(this.swigCPtr, this, z);
    }

    public boolean getBHidden() {
        return MapEngineJNIBridge.AboardPointInfo_bHidden_get(this.swigCPtr, this);
    }

    public AboardPointInfo() {
        this(MapEngineJNIBridge.new_AboardPointInfo(), true);
    }
}
