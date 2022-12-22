package com.didi.hawaii.mapsdkv2.jni;

public class DOverlayLineInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DOverlayLineInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DOverlayLineInfo dOverlayLineInfo) {
        if (dOverlayLineInfo == null) {
            return 0;
        }
        return dOverlayLineInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DOverlayLineInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setStartNum(int i) {
        MapEngineJNIBridge.DOverlayLineInfo_startNum_set(this.swigCPtr, this, i);
    }

    public int getStartNum() {
        return MapEngineJNIBridge.DOverlayLineInfo_startNum_get(this.swigCPtr, this);
    }

    public void setEndNum(int i) {
        MapEngineJNIBridge.DOverlayLineInfo_endNum_set(this.swigCPtr, this, i);
    }

    public int getEndNum() {
        return MapEngineJNIBridge.DOverlayLineInfo_endNum_get(this.swigCPtr, this);
    }

    public void setColor(int i) {
        MapEngineJNIBridge.DOverlayLineInfo_color_set(this.swigCPtr, this, i);
    }

    public int getColor() {
        return MapEngineJNIBridge.DOverlayLineInfo_color_get(this.swigCPtr, this);
    }

    public void setSpeed(int i) {
        MapEngineJNIBridge.DOverlayLineInfo_speed_set(this.swigCPtr, this, i);
    }

    public int getSpeed() {
        return MapEngineJNIBridge.DOverlayLineInfo_speed_get(this.swigCPtr, this);
    }

    public void setRoadName(String str) {
        MapEngineJNIBridge.DOverlayLineInfo_roadName_set(this.swigCPtr, this, str);
    }

    public String getRoadName() {
        return MapEngineJNIBridge.DOverlayLineInfo_roadName_get(this.swigCPtr, this);
    }

    public DOverlayLineInfo() {
        this(MapEngineJNIBridge.new_DOverlayLineInfo(), true);
    }
}
