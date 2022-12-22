package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNAVEventData */
public class DARCNAVEventData extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCNAVEventData(long j, boolean z) {
        super(AREngineJNIBridge.DARCNAVEventData_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCNAVEventData dARCNAVEventData) {
        if (dARCNAVEventData == null) {
            return 0;
        }
        return dARCNAVEventData.swigCPtr;
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

    public static DARCNAVEventData alloc() {
        long DARCNAVEventData_alloc = AREngineJNIBridge.DARCNAVEventData_alloc();
        if (DARCNAVEventData_alloc == 0) {
            return null;
        }
        return new DARCNAVEventData(DARCNAVEventData_alloc, false);
    }
}
