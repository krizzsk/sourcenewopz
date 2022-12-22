package com.didi.hawaii.mapsdkv2.jni;

public class SwigApolloCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SwigApolloCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SwigApolloCallback swigApolloCallback) {
        if (swigApolloCallback == null) {
            return 0;
        }
        return swigApolloCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_SwigApolloCallback(this.swigCPtr);
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
        MapEngineJNIBridge.SwigApolloCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapEngineJNIBridge.SwigApolloCallback_change_ownership(this, this.swigCPtr, true);
    }

    public Object OnGetApolloInt(String str, String str2) {
        return getClass() == SwigApolloCallback.class ? MapEngineJNIBridge.SwigApolloCallback_OnGetApolloInt(this.swigCPtr, this, str, str2) : MapEngineJNIBridge.SwigApolloCallback_OnGetApolloIntSwigExplicitSwigApolloCallback(this.swigCPtr, this, str, str2);
    }

    public Object OnGetApolloString(String str, String str2) {
        return getClass() == SwigApolloCallback.class ? MapEngineJNIBridge.SwigApolloCallback_OnGetApolloString(this.swigCPtr, this, str, str2) : MapEngineJNIBridge.m17233x4103701a(this.swigCPtr, this, str, str2);
    }

    public Object OnGetApolloStringLength(String str, String str2) {
        return getClass() == SwigApolloCallback.class ? MapEngineJNIBridge.SwigApolloCallback_OnGetApolloStringLength(this.swigCPtr, this, str, str2) : MapEngineJNIBridge.m17232xe7a8ee20(this.swigCPtr, this, str, str2);
    }

    public SwigApolloCallback() {
        this(MapEngineJNIBridge.new_SwigApolloCallback(), true);
        MapEngineJNIBridge.SwigApolloCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
