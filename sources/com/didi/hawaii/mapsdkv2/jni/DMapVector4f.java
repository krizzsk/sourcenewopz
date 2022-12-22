package com.didi.hawaii.mapsdkv2.jni;

public class DMapVector4f {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DMapVector4f(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DMapVector4f dMapVector4f) {
        if (dMapVector4f == null) {
            return 0;
        }
        return dMapVector4f.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DMapVector4f(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(float f) {
        MapEngineJNIBridge.DMapVector4f_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return MapEngineJNIBridge.DMapVector4f_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        MapEngineJNIBridge.DMapVector4f_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return MapEngineJNIBridge.DMapVector4f_y_get(this.swigCPtr, this);
    }

    public void setZ(float f) {
        MapEngineJNIBridge.DMapVector4f_z_set(this.swigCPtr, this, f);
    }

    public float getZ() {
        return MapEngineJNIBridge.DMapVector4f_z_get(this.swigCPtr, this);
    }

    public void setW(float f) {
        MapEngineJNIBridge.DMapVector4f_w_set(this.swigCPtr, this, f);
    }

    public float getW() {
        return MapEngineJNIBridge.DMapVector4f_w_get(this.swigCPtr, this);
    }

    public void setR(float f) {
        MapEngineJNIBridge.DMapVector4f_r_set(this.swigCPtr, this, f);
    }

    public float getR() {
        return MapEngineJNIBridge.DMapVector4f_r_get(this.swigCPtr, this);
    }

    public void setG(float f) {
        MapEngineJNIBridge.DMapVector4f_g_set(this.swigCPtr, this, f);
    }

    public float getG() {
        return MapEngineJNIBridge.DMapVector4f_g_get(this.swigCPtr, this);
    }

    public void setB(float f) {
        MapEngineJNIBridge.DMapVector4f_b_set(this.swigCPtr, this, f);
    }

    public float getB() {
        return MapEngineJNIBridge.DMapVector4f_b_get(this.swigCPtr, this);
    }

    public void setA(float f) {
        MapEngineJNIBridge.DMapVector4f_a_set(this.swigCPtr, this, f);
    }

    public float getA() {
        return MapEngineJNIBridge.DMapVector4f_a_get(this.swigCPtr, this);
    }

    public DMapVector4f() {
        this(MapEngineJNIBridge.new_DMapVector4f(), true);
    }
}
