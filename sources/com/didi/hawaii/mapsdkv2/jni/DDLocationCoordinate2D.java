package com.didi.hawaii.mapsdkv2.jni;

public class DDLocationCoordinate2D {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DDLocationCoordinate2D(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DDLocationCoordinate2D dDLocationCoordinate2D) {
        if (dDLocationCoordinate2D == null) {
            return 0;
        }
        return dDLocationCoordinate2D.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DDLocationCoordinate2D(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLongitude(double d) {
        MapEngineJNIBridge.DDLocationCoordinate2D_longitude_set(this.swigCPtr, this, d);
    }

    public double getLongitude() {
        return MapEngineJNIBridge.DDLocationCoordinate2D_longitude_get(this.swigCPtr, this);
    }

    public void setLatitude(double d) {
        MapEngineJNIBridge.DDLocationCoordinate2D_latitude_set(this.swigCPtr, this, d);
    }

    public double getLatitude() {
        return MapEngineJNIBridge.DDLocationCoordinate2D_latitude_get(this.swigCPtr, this);
    }

    public DDLocationCoordinate2D() {
        this(MapEngineJNIBridge.new_DDLocationCoordinate2D(), true);
    }
}
