package com.didi.hawaii.mapsdkv2.jni;

public class MapPointSection {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapPointSection(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapPointSection mapPointSection) {
        if (mapPointSection == null) {
            return 0;
        }
        return mapPointSection.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapPointSection(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setStartNum(int i) {
        MapEngineJNIBridge.MapPointSection_startNum_set(this.swigCPtr, this, i);
    }

    public int getStartNum() {
        return MapEngineJNIBridge.MapPointSection_startNum_get(this.swigCPtr, this);
    }

    public void setEndNum(int i) {
        MapEngineJNIBridge.MapPointSection_endNum_set(this.swigCPtr, this, i);
    }

    public int getEndNum() {
        return MapEngineJNIBridge.MapPointSection_endNum_get(this.swigCPtr, this);
    }

    public void setMaxGeoLength(int i) {
        MapEngineJNIBridge.MapPointSection_maxGeoLength_set(this.swigCPtr, this, i);
    }

    public int getMaxGeoLength() {
        return MapEngineJNIBridge.MapPointSection_maxGeoLength_get(this.swigCPtr, this);
    }

    public MapPointSection() {
        this(MapEngineJNIBridge.new_MapPointSection(), true);
    }
}
