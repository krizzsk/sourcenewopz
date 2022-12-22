package com.didi.hawaii.mapsdkv2.jni;

import java.math.BigInteger;

public class DMapLine {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DMapLine(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DMapLine dMapLine) {
        if (dMapLine == null) {
            return 0;
        }
        return dMapLine.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DMapLine(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setRouteId(BigInteger bigInteger) {
        MapEngineJNIBridge.DMapLine_routeId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getRouteId() {
        return MapEngineJNIBridge.DMapLine_routeId_get(this.swigCPtr, this);
    }

    public void setPoints(DDMapPoint dDMapPoint) {
        MapEngineJNIBridge.DMapLine_points_set(this.swigCPtr, this, DDMapPoint.getCPtr(dDMapPoint), dDMapPoint);
    }

    public DDMapPoint getPoints() {
        long DMapLine_points_get = MapEngineJNIBridge.DMapLine_points_get(this.swigCPtr, this);
        if (DMapLine_points_get == 0) {
            return null;
        }
        return new DDMapPoint(DMapLine_points_get, false);
    }

    public void setSize(int i) {
        MapEngineJNIBridge.DMapLine_size_set(this.swigCPtr, this, i);
    }

    public int getSize() {
        return MapEngineJNIBridge.DMapLine_size_get(this.swigCPtr, this);
    }

    public void setWidth(float f) {
        MapEngineJNIBridge.DMapLine_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return MapEngineJNIBridge.DMapLine_width_get(this.swigCPtr, this);
    }

    public DMapLine() {
        this(MapEngineJNIBridge.new_DMapLine(), true);
    }
}
