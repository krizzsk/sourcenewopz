package com.dmap.navigation.jni.swig;

public class BaseNaviAPI {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected BaseNaviAPI(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BaseNaviAPI baseNaviAPI) {
        if (baseNaviAPI == null) {
            return 0;
        }
        return baseNaviAPI.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_BaseNaviAPI(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setHelper(APIRequestHelper aPIRequestHelper) {
        NaviBusinessJNI.BaseNaviAPI_setHelper(this.swigCPtr, this, APIRequestHelper.getCPtr(aPIRequestHelper), aPIRequestHelper);
    }

    public void setCallback(APIRequestCallback aPIRequestCallback) {
        NaviBusinessJNI.BaseNaviAPI_setCallback(this.swigCPtr, this, APIRequestCallback.getCPtr(aPIRequestCallback), aPIRequestCallback);
    }

    public void setNaviInfo(NaviInfo naviInfo) {
        NaviBusinessJNI.BaseNaviAPI_setNaviInfo(this.swigCPtr, this, NaviInfo.getCPtr(naviInfo), naviInfo);
    }

    public void setRetryStrategy(RetryStrategy retryStrategy) {
        NaviBusinessJNI.BaseNaviAPI_setRetryStrategy(this.swigCPtr, this, RetryStrategy.getCPtr(retryStrategy), retryStrategy);
    }

    public void onResponse(byte[] bArr, int i, int i2) {
        NaviBusinessJNI.BaseNaviAPI_onResponse(this.swigCPtr, this, bArr, i, i2);
    }

    public void cancel() {
        NaviBusinessJNI.BaseNaviAPI_cancel(this.swigCPtr, this);
    }

    public void execute() {
        NaviBusinessJNI.BaseNaviAPI_execute(this.swigCPtr, this);
    }
}
