package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCPointF */
public class DARCPointF {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCPointF(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCPointF dARCPointF) {
        if (dARCPointF == null) {
            return 0;
        }
        return dARCPointF.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCPointF(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(float f) {
        AREngineJNIBridge.DARCPointF_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return AREngineJNIBridge.DARCPointF_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        AREngineJNIBridge.DARCPointF_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return AREngineJNIBridge.DARCPointF_y_get(this.swigCPtr, this);
    }

    public static long size() {
        return AREngineJNIBridge.DARCPointF_size();
    }

    public DARCPointF() {
        this(AREngineJNIBridge.new_DARCPointF(), true);
    }
}
