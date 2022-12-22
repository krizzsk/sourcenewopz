package com.dmap.navigation.jni.swig;

public class NaviRouteTagList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRouteTagList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRouteTagList naviRouteTagList) {
        if (naviRouteTagList == null) {
            return 0;
        }
        return naviRouteTagList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRouteTagList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviRouteTagList() {
        this(NaviBusinessJNI.new_NaviRouteTagList__SWIG_0(), true);
    }

    public NaviRouteTagList(long j) {
        this(NaviBusinessJNI.new_NaviRouteTagList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviRouteTagList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviRouteTagList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviRouteTagList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviRouteTagList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviRouteTagList_clear(this.swigCPtr, this);
    }

    public void add(NaviRouteTag naviRouteTag) {
        NaviBusinessJNI.NaviRouteTagList_add(this.swigCPtr, this, NaviRouteTag.getCPtr(naviRouteTag), naviRouteTag);
    }

    public NaviRouteTag get(int i) {
        return new NaviRouteTag(NaviBusinessJNI.NaviRouteTagList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviRouteTag naviRouteTag) {
        NaviBusinessJNI.NaviRouteTagList_set(this.swigCPtr, this, i, NaviRouteTag.getCPtr(naviRouteTag), naviRouteTag);
    }
}
