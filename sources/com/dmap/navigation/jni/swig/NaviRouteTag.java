package com.dmap.navigation.jni.swig;

public class NaviRouteTag {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRouteTag(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRouteTag naviRouteTag) {
        if (naviRouteTag == null) {
            return 0;
        }
        return naviRouteTag.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRouteTag(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setKey(String str) {
        NaviBusinessJNI.NaviRouteTag_key_set(this.swigCPtr, this, str);
    }

    public String getKey() {
        return NaviBusinessJNI.NaviRouteTag_key_get(this.swigCPtr, this);
    }

    public void setValue(String str) {
        NaviBusinessJNI.NaviRouteTag_value_set(this.swigCPtr, this, str);
    }

    public String getValue() {
        return NaviBusinessJNI.NaviRouteTag_value_get(this.swigCPtr, this);
    }

    public void setPosition(NaviLatLng naviLatLng) {
        NaviBusinessJNI.NaviRouteTag_position_set(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng getPosition() {
        long NaviRouteTag_position_get = NaviBusinessJNI.NaviRouteTag_position_get(this.swigCPtr, this);
        if (NaviRouteTag_position_get == 0) {
            return null;
        }
        return new NaviLatLng(NaviRouteTag_position_get, false);
    }

    public NaviRouteTag() {
        this(NaviBusinessJNI.new_NaviRouteTag(), true);
    }
}
