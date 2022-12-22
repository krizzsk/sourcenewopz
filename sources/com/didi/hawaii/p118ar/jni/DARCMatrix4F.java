package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCMatrix4F */
public class DARCMatrix4F {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCMatrix4F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCMatrix4F dARCMatrix4F) {
        if (dARCMatrix4F == null) {
            return 0;
        }
        return dARCMatrix4F.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCMatrix4F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(DARCPoint4F dARCPoint4F) {
        AREngineJNIBridge.DARCMatrix4F_x_set(this.swigCPtr, this, DARCPoint4F.getCPtr(dARCPoint4F), dARCPoint4F);
    }

    public DARCPoint4F getX() {
        long DARCMatrix4F_x_get = AREngineJNIBridge.DARCMatrix4F_x_get(this.swigCPtr, this);
        if (DARCMatrix4F_x_get == 0) {
            return null;
        }
        return new DARCPoint4F(DARCMatrix4F_x_get, false);
    }

    public void setY(DARCPoint4F dARCPoint4F) {
        AREngineJNIBridge.DARCMatrix4F_y_set(this.swigCPtr, this, DARCPoint4F.getCPtr(dARCPoint4F), dARCPoint4F);
    }

    public DARCPoint4F getY() {
        long DARCMatrix4F_y_get = AREngineJNIBridge.DARCMatrix4F_y_get(this.swigCPtr, this);
        if (DARCMatrix4F_y_get == 0) {
            return null;
        }
        return new DARCPoint4F(DARCMatrix4F_y_get, false);
    }

    public void setZ(DARCPoint4F dARCPoint4F) {
        AREngineJNIBridge.DARCMatrix4F_z_set(this.swigCPtr, this, DARCPoint4F.getCPtr(dARCPoint4F), dARCPoint4F);
    }

    public DARCPoint4F getZ() {
        long DARCMatrix4F_z_get = AREngineJNIBridge.DARCMatrix4F_z_get(this.swigCPtr, this);
        if (DARCMatrix4F_z_get == 0) {
            return null;
        }
        return new DARCPoint4F(DARCMatrix4F_z_get, false);
    }

    public void setW(DARCPoint4F dARCPoint4F) {
        AREngineJNIBridge.DARCMatrix4F_w_set(this.swigCPtr, this, DARCPoint4F.getCPtr(dARCPoint4F), dARCPoint4F);
    }

    public DARCPoint4F getW() {
        long DARCMatrix4F_w_get = AREngineJNIBridge.DARCMatrix4F_w_get(this.swigCPtr, this);
        if (DARCMatrix4F_w_get == 0) {
            return null;
        }
        return new DARCPoint4F(DARCMatrix4F_w_get, false);
    }

    public static long size() {
        return AREngineJNIBridge.DARCMatrix4F_size();
    }

    public DARCMatrix4F() {
        this(AREngineJNIBridge.new_DARCMatrix4F(), true);
    }
}
