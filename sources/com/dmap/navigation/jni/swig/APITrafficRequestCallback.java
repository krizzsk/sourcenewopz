package com.dmap.navigation.jni.swig;

public class APITrafficRequestCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected APITrafficRequestCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(APITrafficRequestCallback aPITrafficRequestCallback) {
        if (aPITrafficRequestCallback == null) {
            return 0;
        }
        return aPITrafficRequestCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_APITrafficRequestCallback(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        NaviBusinessJNI.APITrafficRequestCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.APITrafficRequestCallback_change_ownership(this, this.swigCPtr, true);
    }

    public APITrafficRequestCallback() {
        this(NaviBusinessJNI.new_APITrafficRequestCallback(), true);
        NaviBusinessJNI.APITrafficRequestCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onBegin() {
        if (getClass() == APITrafficRequestCallback.class) {
            NaviBusinessJNI.APITrafficRequestCallback_onBegin(this.swigCPtr, this);
        } else {
            NaviBusinessJNI.m37052xa6082f7f(this.swigCPtr, this);
        }
    }

    public void onFinish(TrafficResponse trafficResponse) {
        if (getClass() == APITrafficRequestCallback.class) {
            NaviBusinessJNI.APITrafficRequestCallback_onFinish(this.swigCPtr, this, TrafficResponse.getCPtr(trafficResponse), trafficResponse);
            return;
        }
        NaviBusinessJNI.m37053x3ad48f9b(this.swigCPtr, this, TrafficResponse.getCPtr(trafficResponse), trafficResponse);
    }
}
