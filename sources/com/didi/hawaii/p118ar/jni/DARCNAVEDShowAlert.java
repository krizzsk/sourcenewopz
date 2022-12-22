package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNAVEDShowAlert */
public class DARCNAVEDShowAlert extends DARCNAVEventData {
    private transient long swigCPtr;

    protected DARCNAVEDShowAlert(long j, boolean z) {
        super(AREngineJNIBridge.DARCNAVEDShowAlert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCNAVEDShowAlert dARCNAVEDShowAlert) {
        if (dARCNAVEDShowAlert == null) {
            return 0;
        }
        return dARCNAVEDShowAlert.swigCPtr;
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

    public static DARCNAVEDShowAlert alloc() {
        long DARCNAVEDShowAlert_alloc = AREngineJNIBridge.DARCNAVEDShowAlert_alloc();
        if (DARCNAVEDShowAlert_alloc == 0) {
            return null;
        }
        return new DARCNAVEDShowAlert(DARCNAVEDShowAlert_alloc, false);
    }

    public DARCAlert getAlert() {
        long DARCNAVEDShowAlert_getAlert = AREngineJNIBridge.DARCNAVEDShowAlert_getAlert(this.swigCPtr, this);
        if (DARCNAVEDShowAlert_getAlert == 0) {
            return null;
        }
        return new DARCAlert(DARCNAVEDShowAlert_getAlert, false);
    }

    public void setAlert(DARCAlert dARCAlert) {
        AREngineJNIBridge.DARCNAVEDShowAlert_setAlert(this.swigCPtr, this, DARCAlert.getCPtr(dARCAlert), dARCAlert);
    }

    public void setTagInt(int i) {
        AREngineJNIBridge.DARCNAVEDShowAlert_tagInt_set(this.swigCPtr, this, i);
    }

    public int getTagInt() {
        return AREngineJNIBridge.DARCNAVEDShowAlert_tagInt_get(this.swigCPtr, this);
    }
}
