package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCGeoPoint */
public class DARCGeoPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCGeoPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCGeoPoint dARCGeoPoint) {
        if (dARCGeoPoint == null) {
            return 0;
        }
        return dARCGeoPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCGeoPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DARCGeoPoint() {
        this(AREngineJNIBridge.new_DARCGeoPoint__SWIG_0(), true);
    }

    public DARCGeoPoint(double d, double d2) {
        this(AREngineJNIBridge.new_DARCGeoPoint__SWIG_1(d, d2), true);
    }

    public void setLon(double d) {
        AREngineJNIBridge.DARCGeoPoint_lon_set(this.swigCPtr, this, d);
    }

    public double getLon() {
        return AREngineJNIBridge.DARCGeoPoint_lon_get(this.swigCPtr, this);
    }

    public void setLat(double d) {
        AREngineJNIBridge.DARCGeoPoint_lat_set(this.swigCPtr, this, d);
    }

    public double getLat() {
        return AREngineJNIBridge.DARCGeoPoint_lat_get(this.swigCPtr, this);
    }

    public boolean valid() {
        return AREngineJNIBridge.DARCGeoPoint_valid(this.swigCPtr, this);
    }

    public boolean equal(DARCGeoPoint dARCGeoPoint) {
        return AREngineJNIBridge.DARCGeoPoint_equal(this.swigCPtr, this, getCPtr(dARCGeoPoint), dARCGeoPoint);
    }
}
