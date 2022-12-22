package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCRectF */
public class DARCRectF {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCRectF(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCRectF dARCRectF) {
        if (dARCRectF == null) {
            return 0;
        }
        return dARCRectF.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCRectF(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setOrigin(DARCPointF dARCPointF) {
        AREngineJNIBridge.DARCRectF_origin_set(this.swigCPtr, this, DARCPointF.getCPtr(dARCPointF), dARCPointF);
    }

    public DARCPointF getOrigin() {
        long DARCRectF_origin_get = AREngineJNIBridge.DARCRectF_origin_get(this.swigCPtr, this);
        if (DARCRectF_origin_get == 0) {
            return null;
        }
        return new DARCPointF(DARCRectF_origin_get, false);
    }

    public void setSize(DARCSizeF dARCSizeF) {
        AREngineJNIBridge.DARCRectF_size_set(this.swigCPtr, this, DARCSizeF.getCPtr(dARCSizeF), dARCSizeF);
    }

    public DARCSizeF getSize() {
        long DARCRectF_size_get = AREngineJNIBridge.DARCRectF_size_get(this.swigCPtr, this);
        if (DARCRectF_size_get == 0) {
            return null;
        }
        return new DARCSizeF(DARCRectF_size_get, false);
    }

    public DARCRectF() {
        this(AREngineJNIBridge.new_DARCRectF(), true);
    }
}
