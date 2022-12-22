package com.dmap.navigation.jni.swig;

public class NaviToastInfoList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviToastInfoList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviToastInfoList naviToastInfoList) {
        if (naviToastInfoList == null) {
            return 0;
        }
        return naviToastInfoList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviToastInfoList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviToastInfoList() {
        this(NaviBusinessJNI.new_NaviToastInfoList__SWIG_0(), true);
    }

    public NaviToastInfoList(long j) {
        this(NaviBusinessJNI.new_NaviToastInfoList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviToastInfoList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviToastInfoList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviToastInfoList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviToastInfoList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviToastInfoList_clear(this.swigCPtr, this);
    }

    public void add(NaviToastInfo naviToastInfo) {
        NaviBusinessJNI.NaviToastInfoList_add(this.swigCPtr, this, NaviToastInfo.getCPtr(naviToastInfo), naviToastInfo);
    }

    public NaviToastInfo get(int i) {
        return new NaviToastInfo(NaviBusinessJNI.NaviToastInfoList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviToastInfo naviToastInfo) {
        NaviBusinessJNI.NaviToastInfoList_set(this.swigCPtr, this, i, NaviToastInfo.getCPtr(naviToastInfo), naviToastInfo);
    }
}
