package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNAVEDStatusChange */
public class DARCNAVEDStatusChange extends DARCNAVEventData {
    private transient long swigCPtr;

    protected DARCNAVEDStatusChange(long j, boolean z) {
        super(AREngineJNIBridge.DARCNAVEDStatusChange_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCNAVEDStatusChange dARCNAVEDStatusChange) {
        if (dARCNAVEDStatusChange == null) {
            return 0;
        }
        return dARCNAVEDStatusChange.swigCPtr;
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

    public static DARCNAVEDStatusChange alloc() {
        long DARCNAVEDStatusChange_alloc = AREngineJNIBridge.DARCNAVEDStatusChange_alloc();
        if (DARCNAVEDStatusChange_alloc == 0) {
            return null;
        }
        return new DARCNAVEDStatusChange(DARCNAVEDStatusChange_alloc, false);
    }

    public void setStatusFrom(DARCNAVStatus dARCNAVStatus) {
        AREngineJNIBridge.DARCNAVEDStatusChange_statusFrom_set(this.swigCPtr, this, dARCNAVStatus.swigValue());
    }

    public DARCNAVStatus getStatusFrom() {
        return DARCNAVStatus.swigToEnum(AREngineJNIBridge.DARCNAVEDStatusChange_statusFrom_get(this.swigCPtr, this));
    }

    public void setStatusTo(DARCNAVStatus dARCNAVStatus) {
        AREngineJNIBridge.DARCNAVEDStatusChange_statusTo_set(this.swigCPtr, this, dARCNAVStatus.swigValue());
    }

    public DARCNAVStatus getStatusTo() {
        return DARCNAVStatus.swigToEnum(AREngineJNIBridge.DARCNAVEDStatusChange_statusTo_get(this.swigCPtr, this));
    }

    public void setStringObj(String str) {
        AREngineJNIBridge.DARCNAVEDStatusChange_stringObj_set(this.swigCPtr, this, str);
    }

    public String getStringObj() {
        return AREngineJNIBridge.DARCNAVEDStatusChange_stringObj_get(this.swigCPtr, this);
    }
}
