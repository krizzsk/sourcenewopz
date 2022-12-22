package com.dmap.navigation.jni.swig;

public class TunnelGeoPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TunnelGeoPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TunnelGeoPoint tunnelGeoPoint) {
        if (tunnelGeoPoint == null) {
            return 0;
        }
        return tunnelGeoPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_TunnelGeoPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLat(int i) {
        NaviBusinessJNI.TunnelGeoPoint_lat_set(this.swigCPtr, this, i);
    }

    public int getLat() {
        return NaviBusinessJNI.TunnelGeoPoint_lat_get(this.swigCPtr, this);
    }

    public void setLng(int i) {
        NaviBusinessJNI.TunnelGeoPoint_lng_set(this.swigCPtr, this, i);
    }

    public int getLng() {
        return NaviBusinessJNI.TunnelGeoPoint_lng_get(this.swigCPtr, this);
    }

    public void setIndex(int i) {
        NaviBusinessJNI.TunnelGeoPoint_index_set(this.swigCPtr, this, i);
    }

    public int getIndex() {
        return NaviBusinessJNI.TunnelGeoPoint_index_get(this.swigCPtr, this);
    }

    public void setEnd(int i) {
        NaviBusinessJNI.TunnelGeoPoint_end_set(this.swigCPtr, this, i);
    }

    public int getEnd() {
        return NaviBusinessJNI.TunnelGeoPoint_end_get(this.swigCPtr, this);
    }

    public void setDefaultSpeed(int i) {
        NaviBusinessJNI.TunnelGeoPoint_defaultSpeed_set(this.swigCPtr, this, i);
    }

    public int getDefaultSpeed() {
        return NaviBusinessJNI.TunnelGeoPoint_defaultSpeed_get(this.swigCPtr, this);
    }

    public TunnelGeoPoint() {
        this(NaviBusinessJNI.new_TunnelGeoPoint(), true);
    }
}
