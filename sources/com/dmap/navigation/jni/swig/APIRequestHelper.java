package com.dmap.navigation.jni.swig;

public class APIRequestHelper {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected APIRequestHelper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(APIRequestHelper aPIRequestHelper) {
        if (aPIRequestHelper == null) {
            return 0;
        }
        return aPIRequestHelper.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_APIRequestHelper(this.swigCPtr);
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
        NaviBusinessJNI.APIRequestHelper_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.APIRequestHelper_change_ownership(this, this.swigCPtr, true);
    }

    public APIRequestHelper() {
        this(NaviBusinessJNI.new_APIRequestHelper(), true);
        NaviBusinessJNI.APIRequestHelper_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public RequestInfo getRequestInfo() {
        long APIRequestHelper_getRequestInfo = getClass() == APIRequestHelper.class ? NaviBusinessJNI.APIRequestHelper_getRequestInfo(this.swigCPtr, this) : NaviBusinessJNI.APIRequestHelper_getRequestInfoSwigExplicitAPIRequestHelper(this.swigCPtr, this);
        if (APIRequestHelper_getRequestInfo == 0) {
            return null;
        }
        return new RequestInfo(APIRequestHelper_getRequestInfo, false);
    }

    public void onPost(int i, String str, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i2) {
        if (getClass() == APIRequestHelper.class) {
            NaviBusinessJNI.APIRequestHelper_onPost(this.swigCPtr, this, i, str, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), i2);
            return;
        }
        NaviBusinessJNI.APIRequestHelper_onPostSwigExplicitAPIRequestHelper(this.swigCPtr, this, i, str, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), i2);
    }
}
