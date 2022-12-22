package com.didi.hawaii.mapsdkv2.jni;

public class SwigBlockEventCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SwigBlockEventCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SwigBlockEventCallback swigBlockEventCallback) {
        if (swigBlockEventCallback == null) {
            return 0;
        }
        return swigBlockEventCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_SwigBlockEventCallback(this.swigCPtr);
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
        MapEngineJNIBridge.SwigBlockEventCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapEngineJNIBridge.SwigBlockEventCallback_change_ownership(this, this.swigCPtr, true);
    }

    public void OnBlockEvent(int i, long j, double d, double d2) {
        if (getClass() == SwigBlockEventCallback.class) {
            MapEngineJNIBridge.SwigBlockEventCallback_OnBlockEvent(this.swigCPtr, this, i, j, d, d2);
        } else {
            MapEngineJNIBridge.m17234x674ddc81(this.swigCPtr, this, i, j, d, d2);
        }
    }

    public SwigBlockEventCallback() {
        this(MapEngineJNIBridge.new_SwigBlockEventCallback(), true);
        MapEngineJNIBridge.SwigBlockEventCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
