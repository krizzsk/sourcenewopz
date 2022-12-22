package com.didi.hawaii.mapsdkv2.jni;

public class DDMapPointArray {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DDMapPointArray(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DDMapPointArray dDMapPointArray) {
        if (dDMapPointArray == null) {
            return 0;
        }
        return dDMapPointArray.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DDMapPointArray(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DDMapPointArray(int i) {
        this(MapEngineJNIBridge.new_DDMapPointArray(i), true);
    }

    public DDMapPoint getitem(int i) {
        return new DDMapPoint(MapEngineJNIBridge.DDMapPointArray_getitem(this.swigCPtr, this, i), true);
    }

    public void setitem(int i, DDMapPoint dDMapPoint) {
        MapEngineJNIBridge.DDMapPointArray_setitem(this.swigCPtr, this, i, DDMapPoint.getCPtr(dDMapPoint), dDMapPoint);
    }

    public DDMapPoint cast() {
        long DDMapPointArray_cast = MapEngineJNIBridge.DDMapPointArray_cast(this.swigCPtr, this);
        if (DDMapPointArray_cast == 0) {
            return null;
        }
        return new DDMapPoint(DDMapPointArray_cast, false);
    }

    public static DDMapPointArray frompointer(DDMapPoint dDMapPoint) {
        long DDMapPointArray_frompointer = MapEngineJNIBridge.DDMapPointArray_frompointer(DDMapPoint.getCPtr(dDMapPoint), dDMapPoint);
        if (DDMapPointArray_frompointer == 0) {
            return null;
        }
        return new DDMapPointArray(DDMapPointArray_frompointer, false);
    }
}
