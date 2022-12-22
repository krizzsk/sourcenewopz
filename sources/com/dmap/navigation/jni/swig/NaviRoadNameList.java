package com.dmap.navigation.jni.swig;

public class NaviRoadNameList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRoadNameList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRoadNameList naviRoadNameList) {
        if (naviRoadNameList == null) {
            return 0;
        }
        return naviRoadNameList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRoadNameList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviRoadNameList() {
        this(NaviBusinessJNI.new_NaviRoadNameList__SWIG_0(), true);
    }

    public NaviRoadNameList(long j) {
        this(NaviBusinessJNI.new_NaviRoadNameList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviRoadNameList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviRoadNameList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviRoadNameList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviRoadNameList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviRoadNameList_clear(this.swigCPtr, this);
    }

    public void add(NaviRoadName naviRoadName) {
        NaviBusinessJNI.NaviRoadNameList_add(this.swigCPtr, this, NaviRoadName.getCPtr(naviRoadName), naviRoadName);
    }

    public NaviRoadName get(int i) {
        return new NaviRoadName(NaviBusinessJNI.NaviRoadNameList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviRoadName naviRoadName) {
        NaviBusinessJNI.NaviRoadNameList_set(this.swigCPtr, this, i, NaviRoadName.getCPtr(naviRoadName), naviRoadName);
    }
}
