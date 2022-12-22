package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNAVUpdateData */
public class DARCNAVUpdateData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCNAVUpdateData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCNAVUpdateData dARCNAVUpdateData) {
        if (dARCNAVUpdateData == null) {
            return 0;
        }
        return dARCNAVUpdateData.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCNAVUpdateData(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DARCNAVUpdateData() {
        this(AREngineJNIBridge.new_DARCNAVUpdateData(), true);
    }

    public void setProjection(DARCMatrix4F dARCMatrix4F) {
        AREngineJNIBridge.DARCNAVUpdateData_projection_set(this.swigCPtr, this, DARCMatrix4F.getCPtr(dARCMatrix4F), dARCMatrix4F);
    }

    public DARCMatrix4F getProjection() {
        long DARCNAVUpdateData_projection_get = AREngineJNIBridge.DARCNAVUpdateData_projection_get(this.swigCPtr, this);
        if (DARCNAVUpdateData_projection_get == 0) {
            return null;
        }
        return new DARCMatrix4F(DARCNAVUpdateData_projection_get, false);
    }

    public DARCARImage arImage() {
        long DARCNAVUpdateData_arImage = AREngineJNIBridge.DARCNAVUpdateData_arImage(this.swigCPtr, this);
        if (DARCNAVUpdateData_arImage == 0) {
            return null;
        }
        return new DARCARImage(DARCNAVUpdateData_arImage, false);
    }

    public void setArImage(DARCARImage dARCARImage) {
        AREngineJNIBridge.DARCNAVUpdateData_setArImage(this.swigCPtr, this, DARCARImage.getCPtr(dARCARImage), dARCARImage);
    }
}
