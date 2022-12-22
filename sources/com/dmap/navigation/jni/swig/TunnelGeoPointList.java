package com.dmap.navigation.jni.swig;

public class TunnelGeoPointList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TunnelGeoPointList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TunnelGeoPointList tunnelGeoPointList) {
        if (tunnelGeoPointList == null) {
            return 0;
        }
        return tunnelGeoPointList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_TunnelGeoPointList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public TunnelGeoPointList() {
        this(NaviBusinessJNI.new_TunnelGeoPointList__SWIG_0(), true);
    }

    public TunnelGeoPointList(long j) {
        this(NaviBusinessJNI.new_TunnelGeoPointList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.TunnelGeoPointList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.TunnelGeoPointList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.TunnelGeoPointList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.TunnelGeoPointList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.TunnelGeoPointList_clear(this.swigCPtr, this);
    }

    public void add(TunnelGeoPoint tunnelGeoPoint) {
        NaviBusinessJNI.TunnelGeoPointList_add(this.swigCPtr, this, TunnelGeoPoint.getCPtr(tunnelGeoPoint), tunnelGeoPoint);
    }

    public TunnelGeoPoint get(int i) {
        return new TunnelGeoPoint(NaviBusinessJNI.TunnelGeoPointList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, TunnelGeoPoint tunnelGeoPoint) {
        NaviBusinessJNI.TunnelGeoPointList_set(this.swigCPtr, this, i, TunnelGeoPoint.getCPtr(tunnelGeoPoint), tunnelGeoPoint);
    }
}
