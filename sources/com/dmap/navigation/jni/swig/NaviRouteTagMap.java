package com.dmap.navigation.jni.swig;

public class NaviRouteTagMap {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRouteTagMap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRouteTagMap naviRouteTagMap) {
        if (naviRouteTagMap == null) {
            return 0;
        }
        return naviRouteTagMap.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRouteTagMap(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviRouteTagMap() {
        this(NaviBusinessJNI.new_NaviRouteTagMap__SWIG_0(), true);
    }

    public NaviRouteTagMap(NaviRouteTagMap naviRouteTagMap) {
        this(NaviBusinessJNI.new_NaviRouteTagMap__SWIG_1(getCPtr(naviRouteTagMap), naviRouteTagMap), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviRouteTagMap_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return NaviBusinessJNI.NaviRouteTagMap_empty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviRouteTagMap_clear(this.swigCPtr, this);
    }

    public NaviRouteTag get(String str) {
        return new NaviRouteTag(NaviBusinessJNI.NaviRouteTagMap_get(this.swigCPtr, this, str), false);
    }

    public void set(String str, NaviRouteTag naviRouteTag) {
        NaviBusinessJNI.NaviRouteTagMap_set(this.swigCPtr, this, str, NaviRouteTag.getCPtr(naviRouteTag), naviRouteTag);
    }

    public void del(String str) {
        NaviBusinessJNI.NaviRouteTagMap_del(this.swigCPtr, this, str);
    }

    public boolean has_key(String str) {
        return NaviBusinessJNI.NaviRouteTagMap_has_key(this.swigCPtr, this, str);
    }
}
