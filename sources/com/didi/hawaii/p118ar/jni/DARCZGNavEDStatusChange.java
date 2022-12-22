package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavEDStatusChange */
public class DARCZGNavEDStatusChange extends DARCZGNavEventData {
    private transient long swigCPtr;

    protected DARCZGNavEDStatusChange(long j, boolean z) {
        super(AREngineJNIBridge.DARCZGNavEDStatusChange_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavEDStatusChange dARCZGNavEDStatusChange) {
        if (dARCZGNavEDStatusChange == null) {
            return 0;
        }
        return dARCZGNavEDStatusChange.swigCPtr;
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

    public static DARCZGNavEDStatusChange alloc() {
        long DARCZGNavEDStatusChange_alloc = AREngineJNIBridge.DARCZGNavEDStatusChange_alloc();
        if (DARCZGNavEDStatusChange_alloc == 0) {
            return null;
        }
        return new DARCZGNavEDStatusChange(DARCZGNavEDStatusChange_alloc, false);
    }

    public void setStatusFrom(DARCZGNavStatus dARCZGNavStatus) {
        AREngineJNIBridge.DARCZGNavEDStatusChange_statusFrom_set(this.swigCPtr, this, dARCZGNavStatus.swigValue());
    }

    public DARCZGNavStatus getStatusFrom() {
        return DARCZGNavStatus.swigToEnum(AREngineJNIBridge.DARCZGNavEDStatusChange_statusFrom_get(this.swigCPtr, this));
    }

    public void setStatusTo(DARCZGNavStatus dARCZGNavStatus) {
        AREngineJNIBridge.DARCZGNavEDStatusChange_statusTo_set(this.swigCPtr, this, dARCZGNavStatus.swigValue());
    }

    public DARCZGNavStatus getStatusTo() {
        return DARCZGNavStatus.swigToEnum(AREngineJNIBridge.DARCZGNavEDStatusChange_statusTo_get(this.swigCPtr, this));
    }
}
