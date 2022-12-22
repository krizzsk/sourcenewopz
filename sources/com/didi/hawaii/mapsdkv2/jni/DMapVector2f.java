package com.didi.hawaii.mapsdkv2.jni;

public class DMapVector2f {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DMapVector2f(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DMapVector2f dMapVector2f) {
        if (dMapVector2f == null) {
            return 0;
        }
        return dMapVector2f.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DMapVector2f(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(float f) {
        MapEngineJNIBridge.DMapVector2f_x_set(this.swigCPtr, this, f);
    }

    public float getX() {
        return MapEngineJNIBridge.DMapVector2f_x_get(this.swigCPtr, this);
    }

    public void setY(float f) {
        MapEngineJNIBridge.DMapVector2f_y_set(this.swigCPtr, this, f);
    }

    public float getY() {
        return MapEngineJNIBridge.DMapVector2f_y_get(this.swigCPtr, this);
    }

    public void setWidth(float f) {
        MapEngineJNIBridge.DMapVector2f_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return MapEngineJNIBridge.DMapVector2f_width_get(this.swigCPtr, this);
    }

    public void setHeight(float f) {
        MapEngineJNIBridge.DMapVector2f_height_set(this.swigCPtr, this, f);
    }

    public float getHeight() {
        return MapEngineJNIBridge.DMapVector2f_height_get(this.swigCPtr, this);
    }

    public DMapVector2f() {
        this(MapEngineJNIBridge.new_DMapVector2f(), true);
    }
}
