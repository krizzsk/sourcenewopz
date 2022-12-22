package com.dmap.navigation.jni.swig;

public class NaviLocationList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviLocationList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviLocationList naviLocationList) {
        if (naviLocationList == null) {
            return 0;
        }
        return naviLocationList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviLocationList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviLocationList() {
        this(NaviBusinessJNI.new_NaviLocationList__SWIG_0(), true);
    }

    public NaviLocationList(long j) {
        this(NaviBusinessJNI.new_NaviLocationList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviLocationList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviLocationList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviLocationList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviLocationList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviLocationList_clear(this.swigCPtr, this);
    }

    public void add(NaviLocation naviLocation) {
        NaviBusinessJNI.NaviLocationList_add(this.swigCPtr, this, NaviLocation.getCPtr(naviLocation), naviLocation);
    }

    public NaviLocation get(int i) {
        return new NaviLocation(NaviBusinessJNI.NaviLocationList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviLocation naviLocation) {
        NaviBusinessJNI.NaviLocationList_set(this.swigCPtr, this, i, NaviLocation.getCPtr(naviLocation), naviLocation);
    }
}
