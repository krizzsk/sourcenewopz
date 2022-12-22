package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavEDGPSFusion */
public class DARCZGNavEDGPSFusion extends DARCZGNavEventData {
    private transient long swigCPtr;

    protected DARCZGNavEDGPSFusion(long j, boolean z) {
        super(AREngineJNIBridge.DARCZGNavEDGPSFusion_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion) {
        if (dARCZGNavEDGPSFusion == null) {
            return 0;
        }
        return dARCZGNavEDGPSFusion.swigCPtr;
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

    public static DARCZGNavEDGPSFusion alloc() {
        long DARCZGNavEDGPSFusion_alloc = AREngineJNIBridge.DARCZGNavEDGPSFusion_alloc();
        if (DARCZGNavEDGPSFusion_alloc == 0) {
            return null;
        }
        return new DARCZGNavEDGPSFusion(DARCZGNavEDGPSFusion_alloc, false);
    }

    public void setGpsFusitionData(DARCGPSData dARCGPSData) {
        AREngineJNIBridge.DARCZGNavEDGPSFusion_gpsFusitionData_set(this.swigCPtr, this, DARCGPSData.getCPtr(dARCGPSData), dARCGPSData);
    }

    public DARCGPSData getGpsFusitionData() {
        long DARCZGNavEDGPSFusion_gpsFusitionData_get = AREngineJNIBridge.DARCZGNavEDGPSFusion_gpsFusitionData_get(this.swigCPtr, this);
        if (DARCZGNavEDGPSFusion_gpsFusitionData_get == 0) {
            return null;
        }
        return new DARCGPSData(DARCZGNavEDGPSFusion_gpsFusitionData_get, false);
    }
}
