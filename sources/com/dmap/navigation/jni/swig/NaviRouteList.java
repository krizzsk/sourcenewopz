package com.dmap.navigation.jni.swig;

public class NaviRouteList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRouteList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRouteList naviRouteList) {
        if (naviRouteList == null) {
            return 0;
        }
        return naviRouteList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRouteList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviRouteList() {
        this(NaviBusinessJNI.new_NaviRouteList__SWIG_0(), true);
    }

    public NaviRouteList(long j) {
        this(NaviBusinessJNI.new_NaviRouteList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviRouteList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviRouteList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviRouteList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviRouteList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviRouteList_clear(this.swigCPtr, this);
    }

    public void add(NaviRoute naviRoute) {
        NaviBusinessJNI.NaviRouteList_add(this.swigCPtr, this, NaviRoute.getCPtr(naviRoute), naviRoute);
    }

    public NaviRoute get(int i) {
        return new NaviRoute(NaviBusinessJNI.NaviRouteList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviRoute naviRoute) {
        NaviBusinessJNI.NaviRouteList_set(this.swigCPtr, this, i, NaviRoute.getCPtr(naviRoute), naviRoute);
    }
}
