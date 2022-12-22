package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavCreateData */
public class DARCZGNavCreateData extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCZGNavCreateData(long j, boolean z) {
        super(AREngineJNIBridge.DARCZGNavCreateData_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavCreateData dARCZGNavCreateData) {
        if (dARCZGNavCreateData == null) {
            return 0;
        }
        return dARCZGNavCreateData.swigCPtr;
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

    public static DARCZGNavCreateData alloc() {
        long DARCZGNavCreateData_alloc = AREngineJNIBridge.DARCZGNavCreateData_alloc();
        if (DARCZGNavCreateData_alloc == 0) {
            return null;
        }
        return new DARCZGNavCreateData(DARCZGNavCreateData_alloc, false);
    }

    public void setTargetPoint(DARCGeoPoint dARCGeoPoint) {
        AREngineJNIBridge.DARCZGNavCreateData_targetPoint_set(this.swigCPtr, this, DARCGeoPoint.getCPtr(dARCGeoPoint), dARCGeoPoint);
    }

    public DARCGeoPoint getTargetPoint() {
        long DARCZGNavCreateData_targetPoint_get = AREngineJNIBridge.DARCZGNavCreateData_targetPoint_get(this.swigCPtr, this);
        if (DARCZGNavCreateData_targetPoint_get == 0) {
            return null;
        }
        return new DARCGeoPoint(DARCZGNavCreateData_targetPoint_get, false);
    }

    public void setTrackSupport(boolean z) {
        AREngineJNIBridge.DARCZGNavCreateData_trackSupport_set(this.swigCPtr, this, z);
    }

    public boolean getTrackSupport() {
        return AREngineJNIBridge.DARCZGNavCreateData_trackSupport_get(this.swigCPtr, this);
    }

    public void setUsePDR(boolean z) {
        AREngineJNIBridge.DARCZGNavCreateData_usePDR_set(this.swigCPtr, this, z);
    }

    public boolean getUsePDR() {
        return AREngineJNIBridge.DARCZGNavCreateData_usePDR_get(this.swigCPtr, this);
    }

    public void setDistanceArrived(int i) {
        AREngineJNIBridge.DARCZGNavCreateData_distanceArrived_set(this.swigCPtr, this, i);
    }

    public int getDistanceArrived() {
        return AREngineJNIBridge.DARCZGNavCreateData_distanceArrived_get(this.swigCPtr, this);
    }
}
