package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCMatrix3F */
public class DARCMatrix3F {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCMatrix3F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCMatrix3F dARCMatrix3F) {
        if (dARCMatrix3F == null) {
            return 0;
        }
        return dARCMatrix3F.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCMatrix3F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(DARCPoint3F dARCPoint3F) {
        AREngineJNIBridge.DARCMatrix3F_x_set(this.swigCPtr, this, DARCPoint3F.getCPtr(dARCPoint3F), dARCPoint3F);
    }

    public DARCPoint3F getX() {
        long DARCMatrix3F_x_get = AREngineJNIBridge.DARCMatrix3F_x_get(this.swigCPtr, this);
        if (DARCMatrix3F_x_get == 0) {
            return null;
        }
        return new DARCPoint3F(DARCMatrix3F_x_get, false);
    }

    public void setY(DARCPoint3F dARCPoint3F) {
        AREngineJNIBridge.DARCMatrix3F_y_set(this.swigCPtr, this, DARCPoint3F.getCPtr(dARCPoint3F), dARCPoint3F);
    }

    public DARCPoint3F getY() {
        long DARCMatrix3F_y_get = AREngineJNIBridge.DARCMatrix3F_y_get(this.swigCPtr, this);
        if (DARCMatrix3F_y_get == 0) {
            return null;
        }
        return new DARCPoint3F(DARCMatrix3F_y_get, false);
    }

    public void setZ(DARCPoint3F dARCPoint3F) {
        AREngineJNIBridge.DARCMatrix3F_z_set(this.swigCPtr, this, DARCPoint3F.getCPtr(dARCPoint3F), dARCPoint3F);
    }

    public DARCPoint3F getZ() {
        long DARCMatrix3F_z_get = AREngineJNIBridge.DARCMatrix3F_z_get(this.swigCPtr, this);
        if (DARCMatrix3F_z_get == 0) {
            return null;
        }
        return new DARCPoint3F(DARCMatrix3F_z_get, false);
    }

    public static long size() {
        return AREngineJNIBridge.DARCMatrix3F_size();
    }

    public DARCMatrix3F() {
        this(AREngineJNIBridge.new_DARCMatrix3F(), true);
    }
}
