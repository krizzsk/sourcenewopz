package com.dmap.navigation.jni.swig;

public class NaviEngineVP {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviEngineVP(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviEngineVP naviEngineVP) {
        if (naviEngineVP == null) {
            return 0;
        }
        return naviEngineVP.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviEngineVP(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviEngineVP() {
        this(NaviBusinessJNI.new_NaviEngineVP(), true);
    }

    public void init(NaviOption naviOption) {
        NaviBusinessJNI.NaviEngineVP_init(this.swigCPtr, this, NaviOption.getCPtr(naviOption), naviOption);
    }

    public void setRoutePoints(NaviLatLngList naviLatLngList) {
        NaviBusinessJNI.NaviEngineVP_setRoutePoints(this.swigCPtr, this, NaviLatLngList.getCPtr(naviLatLngList), naviLatLngList);
    }

    public void destory() {
        NaviBusinessJNI.NaviEngineVP_destory(this.swigCPtr, this);
    }

    public BindNaviLocation getMatchLocation(NaviLocation naviLocation) {
        return new BindNaviLocation(NaviBusinessJNI.NaviEngineVP_getMatchLocation(this.swigCPtr, this, NaviLocation.getCPtr(naviLocation), naviLocation), true);
    }
}
