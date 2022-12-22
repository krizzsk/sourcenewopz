package com.dmap.navigation.jni.swig;

public class NaviLatLngList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviLatLngList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviLatLngList naviLatLngList) {
        if (naviLatLngList == null) {
            return 0;
        }
        return naviLatLngList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviLatLngList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviLatLngList() {
        this(NaviBusinessJNI.new_NaviLatLngList__SWIG_0(), true);
    }

    public NaviLatLngList(long j) {
        this(NaviBusinessJNI.new_NaviLatLngList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviLatLngList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviLatLngList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviLatLngList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviLatLngList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviLatLngList_clear(this.swigCPtr, this);
    }

    public void add(NaviLatLng naviLatLng) {
        NaviBusinessJNI.NaviLatLngList_add(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng get(int i) {
        return new NaviLatLng(NaviBusinessJNI.NaviLatLngList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviLatLng naviLatLng) {
        NaviBusinessJNI.NaviLatLngList_set(this.swigCPtr, this, i, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }
}
