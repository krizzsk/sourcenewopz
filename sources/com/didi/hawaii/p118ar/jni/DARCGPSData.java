package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCGPSData */
public class DARCGPSData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCGPSData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCGPSData dARCGPSData) {
        if (dARCGPSData == null) {
            return 0;
        }
        return dARCGPSData.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCGPSData(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLocation(DARCGeoPoint dARCGeoPoint) {
        AREngineJNIBridge.DARCGPSData_location_set(this.swigCPtr, this, DARCGeoPoint.getCPtr(dARCGeoPoint), dARCGeoPoint);
    }

    public DARCGeoPoint getLocation() {
        long DARCGPSData_location_get = AREngineJNIBridge.DARCGPSData_location_get(this.swigCPtr, this);
        if (DARCGPSData_location_get == 0) {
            return null;
        }
        return new DARCGeoPoint(DARCGPSData_location_get, false);
    }

    public void setAltitude(double d) {
        AREngineJNIBridge.DARCGPSData_altitude_set(this.swigCPtr, this, d);
    }

    public double getAltitude() {
        return AREngineJNIBridge.DARCGPSData_altitude_get(this.swigCPtr, this);
    }

    public void setVerticalAccuracy(double d) {
        AREngineJNIBridge.DARCGPSData_verticalAccuracy_set(this.swigCPtr, this, d);
    }

    public double getVerticalAccuracy() {
        return AREngineJNIBridge.DARCGPSData_verticalAccuracy_get(this.swigCPtr, this);
    }

    public void setHorizontalAccuracy(double d) {
        AREngineJNIBridge.DARCGPSData_horizontalAccuracy_set(this.swigCPtr, this, d);
    }

    public double getHorizontalAccuracy() {
        return AREngineJNIBridge.DARCGPSData_horizontalAccuracy_get(this.swigCPtr, this);
    }

    public void setSpeed(double d) {
        AREngineJNIBridge.DARCGPSData_speed_set(this.swigCPtr, this, d);
    }

    public double getSpeed() {
        return AREngineJNIBridge.DARCGPSData_speed_get(this.swigCPtr, this);
    }

    public void setTimestamp(double d) {
        AREngineJNIBridge.DARCGPSData_timestamp_set(this.swigCPtr, this, d);
    }

    public double getTimestamp() {
        return AREngineJNIBridge.DARCGPSData_timestamp_get(this.swigCPtr, this);
    }

    public boolean equal(DARCGPSData dARCGPSData) {
        return AREngineJNIBridge.DARCGPSData_equal(this.swigCPtr, this, getCPtr(dARCGPSData), dARCGPSData);
    }

    public DARCGPSData() {
        this(AREngineJNIBridge.new_DARCGPSData(), true);
    }
}
