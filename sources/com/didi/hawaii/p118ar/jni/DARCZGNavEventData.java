package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavEventData */
public class DARCZGNavEventData extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCZGNavEventData(long j, boolean z) {
        super(AREngineJNIBridge.DARCZGNavEventData_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavEventData dARCZGNavEventData) {
        if (dARCZGNavEventData == null) {
            return 0;
        }
        return dARCZGNavEventData.swigCPtr;
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
        super.delete();
    }

    public static DARCZGNavEventData alloc() {
        long DARCZGNavEventData_alloc = AREngineJNIBridge.DARCZGNavEventData_alloc();
        if (DARCZGNavEventData_alloc == 0) {
            return null;
        }
        return new DARCZGNavEventData(DARCZGNavEventData_alloc, false);
    }
}
