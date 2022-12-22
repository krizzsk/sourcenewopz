package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavEDDistanceChange */
public class DARCZGNavEDDistanceChange extends DARCZGNavEventData {
    private transient long swigCPtr;

    protected DARCZGNavEDDistanceChange(long j, boolean z) {
        super(AREngineJNIBridge.DARCZGNavEDDistanceChange_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange) {
        if (dARCZGNavEDDistanceChange == null) {
            return 0;
        }
        return dARCZGNavEDDistanceChange.swigCPtr;
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

    public static DARCZGNavEDDistanceChange alloc() {
        long DARCZGNavEDDistanceChange_alloc = AREngineJNIBridge.DARCZGNavEDDistanceChange_alloc();
        if (DARCZGNavEDDistanceChange_alloc == 0) {
            return null;
        }
        return new DARCZGNavEDDistanceChange(DARCZGNavEDDistanceChange_alloc, false);
    }

    public void setDistanceStatusFrom(DARCZGNavDistanceEvent dARCZGNavDistanceEvent) {
        AREngineJNIBridge.DARCZGNavEDDistanceChange_distanceStatusFrom_set(this.swigCPtr, this, dARCZGNavDistanceEvent.swigValue());
    }

    public DARCZGNavDistanceEvent getDistanceStatusFrom() {
        return DARCZGNavDistanceEvent.swigToEnum(AREngineJNIBridge.DARCZGNavEDDistanceChange_distanceStatusFrom_get(this.swigCPtr, this));
    }

    public void setDistanceStatusTo(DARCZGNavDistanceEvent dARCZGNavDistanceEvent) {
        AREngineJNIBridge.DARCZGNavEDDistanceChange_distanceStatusTo_set(this.swigCPtr, this, dARCZGNavDistanceEvent.swigValue());
    }

    public DARCZGNavDistanceEvent getDistanceStatusTo() {
        return DARCZGNavDistanceEvent.swigToEnum(AREngineJNIBridge.DARCZGNavEDDistanceChange_distanceStatusTo_get(this.swigCPtr, this));
    }

    public void setDistanceOfTarget(int i) {
        AREngineJNIBridge.DARCZGNavEDDistanceChange_distanceOfTarget_set(this.swigCPtr, this, i);
    }

    public int getDistanceOfTarget() {
        return AREngineJNIBridge.DARCZGNavEDDistanceChange_distanceOfTarget_get(this.swigCPtr, this);
    }
}
