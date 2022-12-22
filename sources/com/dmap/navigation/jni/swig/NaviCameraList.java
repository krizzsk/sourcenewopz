package com.dmap.navigation.jni.swig;

public class NaviCameraList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviCameraList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviCameraList naviCameraList) {
        if (naviCameraList == null) {
            return 0;
        }
        return naviCameraList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviCameraList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviCameraList() {
        this(NaviBusinessJNI.new_NaviCameraList__SWIG_0(), true);
    }

    public NaviCameraList(long j) {
        this(NaviBusinessJNI.new_NaviCameraList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviCameraList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviCameraList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviCameraList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviCameraList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviCameraList_clear(this.swigCPtr, this);
    }

    public void add(NaviCamera naviCamera) {
        NaviBusinessJNI.NaviCameraList_add(this.swigCPtr, this, NaviCamera.getCPtr(naviCamera), naviCamera);
    }

    public NaviCamera get(int i) {
        return new NaviCamera(NaviBusinessJNI.NaviCameraList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviCamera naviCamera) {
        NaviBusinessJNI.NaviCameraList_set(this.swigCPtr, this, i, NaviCamera.getCPtr(naviCamera), naviCamera);
    }
}
