package com.didi.hawaii.mapsdkv2.jni;

public class BlockPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected BlockPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BlockPoint blockPoint) {
        if (blockPoint == null) {
            return 0;
        }
        return blockPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_BlockPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setCoorIndex(int i) {
        MapEngineJNIBridge.BlockPoint_coorIndex_set(this.swigCPtr, this, i);
    }

    public int getCoorIndex() {
        return MapEngineJNIBridge.BlockPoint_coorIndex_get(this.swigCPtr, this);
    }

    public void setShapeOffset(double d) {
        MapEngineJNIBridge.BlockPoint_shapeOffset_set(this.swigCPtr, this, d);
    }

    public double getShapeOffset() {
        return MapEngineJNIBridge.BlockPoint_shapeOffset_get(this.swigCPtr, this);
    }

    public void setOffsetPercent(double d) {
        MapEngineJNIBridge.BlockPoint_offsetPercent_set(this.swigCPtr, this, d);
    }

    public double getOffsetPercent() {
        return MapEngineJNIBridge.BlockPoint_offsetPercent_get(this.swigCPtr, this);
    }

    public void setLat(double d) {
        MapEngineJNIBridge.BlockPoint_lat_set(this.swigCPtr, this, d);
    }

    public double getLat() {
        return MapEngineJNIBridge.BlockPoint_lat_get(this.swigCPtr, this);
    }

    public void setLng(double d) {
        MapEngineJNIBridge.BlockPoint_lng_set(this.swigCPtr, this, d);
    }

    public double getLng() {
        return MapEngineJNIBridge.BlockPoint_lng_get(this.swigCPtr, this);
    }

    public BlockPoint() {
        this(MapEngineJNIBridge.new_BlockPoint(), true);
    }
}
