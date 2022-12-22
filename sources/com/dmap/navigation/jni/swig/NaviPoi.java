package com.dmap.navigation.jni.swig;

public class NaviPoi {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviPoi(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviPoi naviPoi) {
        if (naviPoi == null) {
            return 0;
        }
        return naviPoi.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviPoi(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLatLng(NaviLatLng naviLatLng) {
        NaviBusinessJNI.NaviPoi_latLng_set(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng getLatLng() {
        long NaviPoi_latLng_get = NaviBusinessJNI.NaviPoi_latLng_get(this.swigCPtr, this);
        if (NaviPoi_latLng_get == 0) {
            return null;
        }
        return new NaviLatLng(NaviPoi_latLng_get, false);
    }

    public void setName(String str) {
        NaviBusinessJNI.NaviPoi_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return NaviBusinessJNI.NaviPoi_name_get(this.swigCPtr, this);
    }

    public void setUid(String str) {
        NaviBusinessJNI.NaviPoi_uid_set(this.swigCPtr, this, str);
    }

    public String getUid() {
        return NaviBusinessJNI.NaviPoi_uid_get(this.swigCPtr, this);
    }

    public void setChooseFlag(String str) {
        NaviBusinessJNI.NaviPoi_chooseFlag_set(this.swigCPtr, this, str);
    }

    public String getChooseFlag() {
        return NaviBusinessJNI.NaviPoi_chooseFlag_get(this.swigCPtr, this);
    }

    public NaviPoi() {
        this(NaviBusinessJNI.new_NaviPoi(), true);
    }
}
