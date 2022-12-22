package com.didi.hawaii.mapsdkv2.jni;

public class HWBSRAManager {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected HWBSRAManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(HWBSRAManager hWBSRAManager) {
        if (hWBSRAManager == null) {
            return 0;
        }
        return hWBSRAManager.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_HWBSRAManager(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public HWBSRAManager() {
        this(MapEngineJNIBridge.new_HWBSRAManager(), true);
    }
}
