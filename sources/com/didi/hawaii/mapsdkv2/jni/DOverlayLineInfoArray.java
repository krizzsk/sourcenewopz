package com.didi.hawaii.mapsdkv2.jni;

public class DOverlayLineInfoArray {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DOverlayLineInfoArray(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DOverlayLineInfoArray dOverlayLineInfoArray) {
        if (dOverlayLineInfoArray == null) {
            return 0;
        }
        return dOverlayLineInfoArray.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DOverlayLineInfoArray(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DOverlayLineInfoArray(int i) {
        this(MapEngineJNIBridge.new_DOverlayLineInfoArray(i), true);
    }

    public DOverlayLineInfo getitem(int i) {
        return new DOverlayLineInfo(MapEngineJNIBridge.DOverlayLineInfoArray_getitem(this.swigCPtr, this, i), true);
    }

    public void setitem(int i, DOverlayLineInfo dOverlayLineInfo) {
        MapEngineJNIBridge.DOverlayLineInfoArray_setitem(this.swigCPtr, this, i, DOverlayLineInfo.getCPtr(dOverlayLineInfo), dOverlayLineInfo);
    }

    public DOverlayLineInfo cast() {
        long DOverlayLineInfoArray_cast = MapEngineJNIBridge.DOverlayLineInfoArray_cast(this.swigCPtr, this);
        if (DOverlayLineInfoArray_cast == 0) {
            return null;
        }
        return new DOverlayLineInfo(DOverlayLineInfoArray_cast, false);
    }

    public static DOverlayLineInfoArray frompointer(DOverlayLineInfo dOverlayLineInfo) {
        long DOverlayLineInfoArray_frompointer = MapEngineJNIBridge.DOverlayLineInfoArray_frompointer(DOverlayLineInfo.getCPtr(dOverlayLineInfo), dOverlayLineInfo);
        if (DOverlayLineInfoArray_frompointer == 0) {
            return null;
        }
        return new DOverlayLineInfoArray(DOverlayLineInfoArray_frompointer, false);
    }
}
