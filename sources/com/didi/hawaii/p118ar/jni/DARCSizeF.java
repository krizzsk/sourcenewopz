package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCSizeF */
public class DARCSizeF {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCSizeF(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCSizeF dARCSizeF) {
        if (dARCSizeF == null) {
            return 0;
        }
        return dARCSizeF.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCSizeF(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setW(float f) {
        AREngineJNIBridge.DARCSizeF_w_set(this.swigCPtr, this, f);
    }

    public float getW() {
        return AREngineJNIBridge.DARCSizeF_w_get(this.swigCPtr, this);
    }

    public void setH(float f) {
        AREngineJNIBridge.DARCSizeF_h_set(this.swigCPtr, this, f);
    }

    public float getH() {
        return AREngineJNIBridge.DARCSizeF_h_get(this.swigCPtr, this);
    }

    public DARCSizeF() {
        this(AREngineJNIBridge.new_DARCSizeF(), true);
    }
}
