package com.dmap.navigation.jni.swig;

public class NaviLatLng {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviLatLng(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviLatLng naviLatLng) {
        if (naviLatLng == null) {
            return 0;
        }
        return naviLatLng.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviLatLng(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLat(double d) {
        NaviBusinessJNI.NaviLatLng_lat_set(this.swigCPtr, this, d);
    }

    public double getLat() {
        return NaviBusinessJNI.NaviLatLng_lat_get(this.swigCPtr, this);
    }

    public void setLng(double d) {
        NaviBusinessJNI.NaviLatLng_lng_set(this.swigCPtr, this, d);
    }

    public double getLng() {
        return NaviBusinessJNI.NaviLatLng_lng_get(this.swigCPtr, this);
    }

    public NaviLatLng() {
        this(NaviBusinessJNI.new_NaviLatLng(), true);
    }
}
