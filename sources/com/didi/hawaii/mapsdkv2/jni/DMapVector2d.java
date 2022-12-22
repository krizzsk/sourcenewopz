package com.didi.hawaii.mapsdkv2.jni;

public class DMapVector2d {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DMapVector2d(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DMapVector2d dMapVector2d) {
        if (dMapVector2d == null) {
            return 0;
        }
        return dMapVector2d.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DMapVector2d(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(double d) {
        MapEngineJNIBridge.DMapVector2d_x_set(this.swigCPtr, this, d);
    }

    public double getX() {
        return MapEngineJNIBridge.DMapVector2d_x_get(this.swigCPtr, this);
    }

    public void setY(double d) {
        MapEngineJNIBridge.DMapVector2d_y_set(this.swigCPtr, this, d);
    }

    public double getY() {
        return MapEngineJNIBridge.DMapVector2d_y_get(this.swigCPtr, this);
    }

    public void setWidth(double d) {
        MapEngineJNIBridge.DMapVector2d_width_set(this.swigCPtr, this, d);
    }

    public double getWidth() {
        return MapEngineJNIBridge.DMapVector2d_width_get(this.swigCPtr, this);
    }

    public void setHeight(double d) {
        MapEngineJNIBridge.DMapVector2d_height_set(this.swigCPtr, this, d);
    }

    public double getHeight() {
        return MapEngineJNIBridge.DMapVector2d_height_get(this.swigCPtr, this);
    }

    public DMapVector2d() {
        this(MapEngineJNIBridge.new_DMapVector2d(), true);
    }
}
