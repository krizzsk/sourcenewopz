package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCObject */
public class DARCObject {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCObject(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCObject dARCObject) {
        if (dARCObject == null) {
            return 0;
        }
        return dARCObject.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (!this.swigCMemOwn) {
                this.swigCPtr = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }

    public static void release(DARCObject dARCObject) {
        AREngineJNIBridge.DARCObject_release(getCPtr(dARCObject), dARCObject);
    }

    public static DARCObject gretain(DARCObject dARCObject) {
        long DARCObject_gretain = AREngineJNIBridge.DARCObject_gretain(getCPtr(dARCObject), dARCObject);
        if (DARCObject_gretain == 0) {
            return null;
        }
        return new DARCObject(DARCObject_gretain, false);
    }

    public static DARCObject gautorelease(DARCObject dARCObject) {
        long DARCObject_gautorelease = AREngineJNIBridge.DARCObject_gautorelease(getCPtr(dARCObject), dARCObject);
        if (DARCObject_gautorelease == 0) {
            return null;
        }
        return new DARCObject(DARCObject_gautorelease, false);
    }

    public static DARCObject alloc() {
        long DARCObject_alloc = AREngineJNIBridge.DARCObject_alloc();
        if (DARCObject_alloc == 0) {
            return null;
        }
        return new DARCObject(DARCObject_alloc, false);
    }

    public boolean isEqual(DARCObject dARCObject) {
        return AREngineJNIBridge.DARCObject_isEqual(this.swigCPtr, this, getCPtr(dARCObject), dARCObject);
    }
}
