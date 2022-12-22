package com.dmap.navigation.jni.swig;

public class RGGeoPoint_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RGGeoPoint_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RGGeoPoint_t rGGeoPoint_t) {
        if (rGGeoPoint_t == null) {
            return 0;
        }
        return rGGeoPoint_t.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_RGGeoPoint_t(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLng(double d) {
        NaviBusinessJNI.RGGeoPoint_t_lng_set(this.swigCPtr, this, d);
    }

    public double getLng() {
        return NaviBusinessJNI.RGGeoPoint_t_lng_get(this.swigCPtr, this);
    }

    public void setLat(double d) {
        NaviBusinessJNI.RGGeoPoint_t_lat_set(this.swigCPtr, this, d);
    }

    public double getLat() {
        return NaviBusinessJNI.RGGeoPoint_t_lat_get(this.swigCPtr, this);
    }

    public RGGeoPoint_t() {
        this(NaviBusinessJNI.new_RGGeoPoint_t(), true);
    }
}
