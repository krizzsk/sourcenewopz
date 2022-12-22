package com.dmap.navigation.jni.swig;

public class NaviPoiList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviPoiList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviPoiList naviPoiList) {
        if (naviPoiList == null) {
            return 0;
        }
        return naviPoiList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviPoiList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviPoiList() {
        this(NaviBusinessJNI.new_NaviPoiList__SWIG_0(), true);
    }

    public NaviPoiList(long j) {
        this(NaviBusinessJNI.new_NaviPoiList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviPoiList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviPoiList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviPoiList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviPoiList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviPoiList_clear(this.swigCPtr, this);
    }

    public void add(NaviPoi naviPoi) {
        NaviBusinessJNI.NaviPoiList_add(this.swigCPtr, this, NaviPoi.getCPtr(naviPoi), naviPoi);
    }

    public NaviPoi get(int i) {
        return new NaviPoi(NaviBusinessJNI.NaviPoiList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviPoi naviPoi) {
        NaviBusinessJNI.NaviPoiList_set(this.swigCPtr, this, i, NaviPoi.getCPtr(naviPoi), naviPoi);
    }
}
