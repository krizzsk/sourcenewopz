package com.didi.hawaii.mapsdkv2.jni;

public class DDMapGPSPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DDMapGPSPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DDMapGPSPoint dDMapGPSPoint) {
        if (dDMapGPSPoint == null) {
            return 0;
        }
        return dDMapGPSPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DDMapGPSPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLng(double d) {
        MapEngineJNIBridge.DDMapGPSPoint_lng_set(this.swigCPtr, this, d);
    }

    public double getLng() {
        return MapEngineJNIBridge.DDMapGPSPoint_lng_get(this.swigCPtr, this);
    }

    public void setLat(double d) {
        MapEngineJNIBridge.DDMapGPSPoint_lat_set(this.swigCPtr, this, d);
    }

    public double getLat() {
        return MapEngineJNIBridge.DDMapGPSPoint_lat_get(this.swigCPtr, this);
    }

    public void setDirection(float f) {
        MapEngineJNIBridge.DDMapGPSPoint_direction_set(this.swigCPtr, this, f);
    }

    public float getDirection() {
        return MapEngineJNIBridge.DDMapGPSPoint_direction_get(this.swigCPtr, this);
    }

    public void setAccuracy(float f) {
        MapEngineJNIBridge.DDMapGPSPoint_accuracy_set(this.swigCPtr, this, f);
    }

    public float getAccuracy() {
        return MapEngineJNIBridge.DDMapGPSPoint_accuracy_get(this.swigCPtr, this);
    }

    public void setSpeed(float f) {
        MapEngineJNIBridge.DDMapGPSPoint_speed_set(this.swigCPtr, this, f);
    }

    public float getSpeed() {
        return MapEngineJNIBridge.DDMapGPSPoint_speed_get(this.swigCPtr, this);
    }

    public void setTimestamp(float f) {
        MapEngineJNIBridge.DDMapGPSPoint_timestamp_set(this.swigCPtr, this, f);
    }

    public float getTimestamp() {
        return MapEngineJNIBridge.DDMapGPSPoint_timestamp_get(this.swigCPtr, this);
    }

    public void setIdx(int i) {
        MapEngineJNIBridge.DDMapGPSPoint_idx_set(this.swigCPtr, this, i);
    }

    public int getIdx() {
        return MapEngineJNIBridge.DDMapGPSPoint_idx_get(this.swigCPtr, this);
    }

    public void setOffset(double d) {
        MapEngineJNIBridge.DDMapGPSPoint_offset_set(this.swigCPtr, this, d);
    }

    public double getOffset() {
        return MapEngineJNIBridge.DDMapGPSPoint_offset_get(this.swigCPtr, this);
    }

    public DDMapGPSPoint() {
        this(MapEngineJNIBridge.new_DDMapGPSPoint(), true);
    }
}
