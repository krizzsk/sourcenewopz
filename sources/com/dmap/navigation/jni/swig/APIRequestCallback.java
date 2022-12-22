package com.dmap.navigation.jni.swig;

public class APIRequestCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected APIRequestCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(APIRequestCallback aPIRequestCallback) {
        if (aPIRequestCallback == null) {
            return 0;
        }
        return aPIRequestCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_APIRequestCallback(this.swigCPtr);
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
        NaviBusinessJNI.APIRequestCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.APIRequestCallback_change_ownership(this, this.swigCPtr, true);
    }

    public APIRequestCallback() {
        this(NaviBusinessJNI.new_APIRequestCallback(), true);
        NaviBusinessJNI.APIRequestCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onBegin() {
        if (getClass() == APIRequestCallback.class) {
            NaviBusinessJNI.APIRequestCallback_onBegin(this.swigCPtr, this);
        } else {
            NaviBusinessJNI.APIRequestCallback_onBeginSwigExplicitAPIRequestCallback(this.swigCPtr, this);
        }
    }

    public void onRetry(int i) {
        if (getClass() == APIRequestCallback.class) {
            NaviBusinessJNI.APIRequestCallback_onRetry(this.swigCPtr, this, i);
        } else {
            NaviBusinessJNI.APIRequestCallback_onRetrySwigExplicitAPIRequestCallback(this.swigCPtr, this, i);
        }
    }

    public void onFinish(NaviResponse naviResponse) {
        if (getClass() == APIRequestCallback.class) {
            NaviBusinessJNI.APIRequestCallback_onFinish(this.swigCPtr, this, NaviResponse.getCPtr(naviResponse), naviResponse);
            return;
        }
        NaviBusinessJNI.APIRequestCallback_onFinishSwigExplicitAPIRequestCallback(this.swigCPtr, this, NaviResponse.getCPtr(naviResponse), naviResponse);
    }
}
