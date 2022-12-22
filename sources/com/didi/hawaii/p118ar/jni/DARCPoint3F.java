package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCPoint3F */
public class DARCPoint3F {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCPoint3F(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCPoint3F dARCPoint3F) {
        if (dARCPoint3F == null) {
            return 0;
        }
        return dARCPoint3F.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCPoint3F(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(float f) {
        AREngineJNIBridge.DARCPoint3F_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return AREngineJNIBridge.DARCPoint3F_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        AREngineJNIBridge.DARCPoint3F_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return AREngineJNIBridge.DARCPoint3F_y_get(this.swigCPtr, this);
    }

    public void setZ(float f) {
        AREngineJNIBridge.DARCPoint3F_z_set(this.swigCPtr, this, f);
    }

    public float getZ() {
        return AREngineJNIBridge.DARCPoint3F_z_get(this.swigCPtr, this);
    }

    public static long size() {
        return AREngineJNIBridge.DARCPoint3F_size();
    }

    public DARCPoint3F() {
        this(AREngineJNIBridge.new_DARCPoint3F(), true);
    }
}
