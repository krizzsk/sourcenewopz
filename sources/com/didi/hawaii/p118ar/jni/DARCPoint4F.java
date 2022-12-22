package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCPoint4F */
public class DARCPoint4F {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCPoint4F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCPoint4F dARCPoint4F) {
        if (dARCPoint4F == null) {
            return 0;
        }
        return dARCPoint4F.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCPoint4F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(float f) {
        AREngineJNIBridge.DARCPoint4F_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return AREngineJNIBridge.DARCPoint4F_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        AREngineJNIBridge.DARCPoint4F_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return AREngineJNIBridge.DARCPoint4F_y_get(this.swigCPtr, this);
    }

    public void setZ(float f) {
        AREngineJNIBridge.DARCPoint4F_z_set(this.swigCPtr, this, f);
    }

    public float getZ() {
        return AREngineJNIBridge.DARCPoint4F_z_get(this.swigCPtr, this);
    }

    public void setW(float f) {
        AREngineJNIBridge.DARCPoint4F_w_set(this.swigCPtr, this, f);
    }

    public float getW() {
        return AREngineJNIBridge.DARCPoint4F_w_get(this.swigCPtr, this);
    }

    public void set(float f, float f2, float f3, float f4) {
        AREngineJNIBridge.DARCPoint4F_set(this.swigCPtr, this, f, f2, f3, f4);
    }

    public static long size() {
        return AREngineJNIBridge.DARCPoint4F_size();
    }

    public DARCPoint4F() {
        this(AREngineJNIBridge.new_DARCPoint4F(), true);
    }
}
