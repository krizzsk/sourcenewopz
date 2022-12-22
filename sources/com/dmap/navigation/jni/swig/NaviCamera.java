package com.dmap.navigation.jni.swig;

public class NaviCamera {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviCamera(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviCamera naviCamera) {
        if (naviCamera == null) {
            return 0;
        }
        return naviCamera.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviCamera(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setType(int i) {
        NaviBusinessJNI.NaviCamera_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return NaviBusinessJNI.NaviCamera_type_get(this.swigCPtr, this);
    }

    public void setSpeed(int i) {
        NaviBusinessJNI.NaviCamera_speed_set(this.swigCPtr, this, i);
    }

    public int getSpeed() {
        return NaviBusinessJNI.NaviCamera_speed_get(this.swigCPtr, this);
    }

    public void setLatLng(NaviLatLng naviLatLng) {
        NaviBusinessJNI.NaviCamera_latLng_set(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng getLatLng() {
        long NaviCamera_latLng_get = NaviBusinessJNI.NaviCamera_latLng_get(this.swigCPtr, this);
        if (NaviCamera_latLng_get == 0) {
            return null;
        }
        return new NaviLatLng(NaviCamera_latLng_get, false);
    }

    public void setWeight(int i) {
        NaviBusinessJNI.NaviCamera_weight_set(this.swigCPtr, this, i);
    }

    public int getWeight() {
        return NaviBusinessJNI.NaviCamera_weight_get(this.swigCPtr, this);
    }

    public void setGroupId(int i) {
        NaviBusinessJNI.NaviCamera_groupId_set(this.swigCPtr, this, i);
    }

    public int getGroupId() {
        return NaviBusinessJNI.NaviCamera_groupId_get(this.swigCPtr, this);
    }

    public void setBubbleType(int i) {
        NaviBusinessJNI.NaviCamera_bubbleType_set(this.swigCPtr, this, i);
    }

    public int getBubbleType() {
        return NaviBusinessJNI.NaviCamera_bubbleType_get(this.swigCPtr, this);
    }

    public NaviCamera() {
        this(NaviBusinessJNI.new_NaviCamera(), true);
    }
}
