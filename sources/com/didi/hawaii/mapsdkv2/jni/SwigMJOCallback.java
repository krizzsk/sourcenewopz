package com.didi.hawaii.mapsdkv2.jni;

public class SwigMJOCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SwigMJOCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SwigMJOCallback swigMJOCallback) {
        if (swigMJOCallback == null) {
            return 0;
        }
        return swigMJOCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_SwigMJOCallback(this.swigCPtr);
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
        MapEngineJNIBridge.SwigMJOCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapEngineJNIBridge.SwigMJOCallback_change_ownership(this, this.swigCPtr, true);
    }

    public void OnMJOEvent(int i, int i2) {
        if (getClass() == SwigMJOCallback.class) {
            MapEngineJNIBridge.SwigMJOCallback_OnMJOEvent(this.swigCPtr, this, i, i2);
        } else {
            MapEngineJNIBridge.SwigMJOCallback_OnMJOEventSwigExplicitSwigMJOCallback(this.swigCPtr, this, i, i2);
        }
    }

    public SwigMJOCallback() {
        this(MapEngineJNIBridge.new_SwigMJOCallback(), true);
        MapEngineJNIBridge.SwigMJOCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
