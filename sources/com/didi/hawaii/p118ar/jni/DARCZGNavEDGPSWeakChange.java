package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavEDGPSWeakChange */
public class DARCZGNavEDGPSWeakChange extends DARCZGNavEventData {
    private transient long swigCPtr;

    protected DARCZGNavEDGPSWeakChange(long j, boolean z) {
        super(AREngineJNIBridge.DARCZGNavEDGPSWeakChange_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange) {
        if (dARCZGNavEDGPSWeakChange == null) {
            return 0;
        }
        return dARCZGNavEDGPSWeakChange.swigCPtr;
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

    public static DARCZGNavEDGPSWeakChange alloc() {
        long DARCZGNavEDGPSWeakChange_alloc = AREngineJNIBridge.DARCZGNavEDGPSWeakChange_alloc();
        if (DARCZGNavEDGPSWeakChange_alloc == 0) {
            return null;
        }
        return new DARCZGNavEDGPSWeakChange(DARCZGNavEDGPSWeakChange_alloc, false);
    }

    public void setIsWeak(boolean z) {
        AREngineJNIBridge.DARCZGNavEDGPSWeakChange_isWeak_set(this.swigCPtr, this, z);
    }

    public boolean getIsWeak() {
        return AREngineJNIBridge.DARCZGNavEDGPSWeakChange_isWeak_get(this.swigCPtr, this);
    }

    public void setLon(double d) {
        AREngineJNIBridge.DARCZGNavEDGPSWeakChange_lon_set(this.swigCPtr, this, d);
    }

    public double getLon() {
        return AREngineJNIBridge.DARCZGNavEDGPSWeakChange_lon_get(this.swigCPtr, this);
    }

    public void setLat(double d) {
        AREngineJNIBridge.DARCZGNavEDGPSWeakChange_lat_set(this.swigCPtr, this, d);
    }

    public double getLat() {
        return AREngineJNIBridge.DARCZGNavEDGPSWeakChange_lat_get(this.swigCPtr, this);
    }
}
