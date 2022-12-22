package com.dmap.navigation.jni.swig;

public class TrafficNaviAPI {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TrafficNaviAPI(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrafficNaviAPI trafficNaviAPI) {
        if (trafficNaviAPI == null) {
            return 0;
        }
        return trafficNaviAPI.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_TrafficNaviAPI(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public TrafficNaviAPI(OrderInfo orderInfo, UserInfo userInfo, NaviOption naviOption) {
        this(NaviBusinessJNI.new_TrafficNaviAPI(OrderInfo.getCPtr(orderInfo), orderInfo, UserInfo.getCPtr(userInfo), userInfo, NaviOption.getCPtr(naviOption), naviOption), true);
    }

    public void setHelper(APIRequestHelper aPIRequestHelper) {
        NaviBusinessJNI.TrafficNaviAPI_setHelper(this.swigCPtr, this, APIRequestHelper.getCPtr(aPIRequestHelper), aPIRequestHelper);
    }

    public void setCallback(APITrafficRequestCallback aPITrafficRequestCallback) {
        NaviBusinessJNI.TrafficNaviAPI_setCallback(this.swigCPtr, this, APITrafficRequestCallback.getCPtr(aPITrafficRequestCallback), aPITrafficRequestCallback);
    }

    public void setNaviInfo(NaviInfo naviInfo) {
        NaviBusinessJNI.TrafficNaviAPI_setNaviInfo(this.swigCPtr, this, NaviInfo.getCPtr(naviInfo), naviInfo);
    }

    public void onResponse(byte[] bArr, int i, int i2) {
        NaviBusinessJNI.TrafficNaviAPI_onResponse(this.swigCPtr, this, bArr, i, i2);
    }

    public void cancel() {
        NaviBusinessJNI.TrafficNaviAPI_cancel(this.swigCPtr, this);
    }

    public void execute() {
        NaviBusinessJNI.TrafficNaviAPI_execute(this.swigCPtr, this);
    }

    public SWIGTYPE_p_unsigned_char getRequestData() {
        long TrafficNaviAPI_getRequestData = NaviBusinessJNI.TrafficNaviAPI_getRequestData(this.swigCPtr, this);
        if (TrafficNaviAPI_getRequestData == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(TrafficNaviAPI_getRequestData, false);
    }

    public int getRequestDataLength() {
        return NaviBusinessJNI.TrafficNaviAPI_getRequestDataLength(this.swigCPtr, this);
    }
}
