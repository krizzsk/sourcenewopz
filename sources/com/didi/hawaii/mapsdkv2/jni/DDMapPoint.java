package com.didi.hawaii.mapsdkv2.jni;

public class DDMapPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DDMapPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DDMapPoint dDMapPoint) {
        if (dDMapPoint == null) {
            return 0;
        }
        return dDMapPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DDMapPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setX(int i) {
        MapEngineJNIBridge.DDMapPoint_x_set(this.swigCPtr, this, i);
    }

    public int getX() {
        return MapEngineJNIBridge.DDMapPoint_x_get(this.swigCPtr, this);
    }

    public void setY(int i) {
        MapEngineJNIBridge.DDMapPoint_y_set(this.swigCPtr, this, i);
    }

    public int getY() {
        return MapEngineJNIBridge.DDMapPoint_y_get(this.swigCPtr, this);
    }

    public void setZ(int i) {
        MapEngineJNIBridge.DDMapPoint_z_set(this.swigCPtr, this, i);
    }

    public int getZ() {
        return MapEngineJNIBridge.DDMapPoint_z_get(this.swigCPtr, this);
    }

    public DDMapPoint() {
        this(MapEngineJNIBridge.new_DDMapPoint(), true);
    }
}
