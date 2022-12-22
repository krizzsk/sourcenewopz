package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCLocationInScene */
public class DARCLocationInScene {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCLocationInScene(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCLocationInScene dARCLocationInScene) {
        if (dARCLocationInScene == null) {
            return 0;
        }
        return dARCLocationInScene.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCLocationInScene(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setPos(DARCPoint3F dARCPoint3F) {
        AREngineJNIBridge.DARCLocationInScene_pos_set(this.swigCPtr, this, DARCPoint3F.getCPtr(dARCPoint3F), dARCPoint3F);
    }

    public DARCPoint3F getPos() {
        long DARCLocationInScene_pos_get = AREngineJNIBridge.DARCLocationInScene_pos_get(this.swigCPtr, this);
        if (DARCLocationInScene_pos_get == 0) {
            return null;
        }
        return new DARCPoint3F(DARCLocationInScene_pos_get, false);
    }

    public void setIndex(int i) {
        AREngineJNIBridge.DARCLocationInScene_index_set(this.swigCPtr, this, i);
    }

    public int getIndex() {
        return AREngineJNIBridge.DARCLocationInScene_index_get(this.swigCPtr, this);
    }

    public DARCLocationInScene() {
        this(AREngineJNIBridge.new_DARCLocationInScene(), true);
    }
}
