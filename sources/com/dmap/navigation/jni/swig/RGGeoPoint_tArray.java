package com.dmap.navigation.jni.swig;

public class RGGeoPoint_tArray {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RGGeoPoint_tArray(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RGGeoPoint_tArray rGGeoPoint_tArray) {
        if (rGGeoPoint_tArray == null) {
            return 0;
        }
        return rGGeoPoint_tArray.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_RGGeoPoint_tArray(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public RGGeoPoint_tArray(int i) {
        this(NaviBusinessJNI.new_RGGeoPoint_tArray(i), true);
    }

    public RGGeoPoint_t getitem(int i) {
        return new RGGeoPoint_t(NaviBusinessJNI.RGGeoPoint_tArray_getitem(this.swigCPtr, this, i), true);
    }

    public void setitem(int i, RGGeoPoint_t rGGeoPoint_t) {
        NaviBusinessJNI.RGGeoPoint_tArray_setitem(this.swigCPtr, this, i, RGGeoPoint_t.getCPtr(rGGeoPoint_t), rGGeoPoint_t);
    }

    public RGGeoPoint_t cast() {
        long RGGeoPoint_tArray_cast = NaviBusinessJNI.RGGeoPoint_tArray_cast(this.swigCPtr, this);
        if (RGGeoPoint_tArray_cast == 0) {
            return null;
        }
        return new RGGeoPoint_t(RGGeoPoint_tArray_cast, false);
    }

    public static RGGeoPoint_tArray frompointer(RGGeoPoint_t rGGeoPoint_t) {
        long RGGeoPoint_tArray_frompointer = NaviBusinessJNI.RGGeoPoint_tArray_frompointer(RGGeoPoint_t.getCPtr(rGGeoPoint_t), rGGeoPoint_t);
        if (RGGeoPoint_tArray_frompointer == 0) {
            return null;
        }
        return new RGGeoPoint_tArray(RGGeoPoint_tArray_frompointer, false);
    }
}
