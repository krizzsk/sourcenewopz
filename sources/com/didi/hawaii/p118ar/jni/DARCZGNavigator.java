package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavigator */
public class DARCZGNavigator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCZGNavigator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavigator dARCZGNavigator) {
        if (dARCZGNavigator == null) {
            return 0;
        }
        return dARCZGNavigator.swigCPtr;
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

    public double currentTime() {
        return AREngineJNIBridge.DARCZGNavigator_currentTime(this.swigCPtr, this);
    }

    public void active() {
        AREngineJNIBridge.DARCZGNavigator_active(this.swigCPtr, this);
    }

    public void inactive() {
        AREngineJNIBridge.DARCZGNavigator_inactive(this.swigCPtr, this);
    }

    public void update(DARCZGNavUpdateData dARCZGNavUpdateData) {
        AREngineJNIBridge.DARCZGNavigator_update(this.swigCPtr, this, DARCZGNavUpdateData.getCPtr(dARCZGNavUpdateData), dARCZGNavUpdateData);
    }

    public void updateGPS(DARCGPSData dARCGPSData) {
        AREngineJNIBridge.DARCZGNavigator_updateGPS(this.swigCPtr, this, DARCGPSData.getCPtr(dARCGPSData), dARCGPSData);
    }

    public void setEffectiveRect(DARCRectF dARCRectF) {
        AREngineJNIBridge.DARCZGNavigator_setEffectiveRect(this.swigCPtr, this, DARCRectF.getCPtr(dARCRectF), dARCRectF);
    }

    public boolean isShowEndGuidNode() {
        return AREngineJNIBridge.DARCZGNavigator_isShowEndGuidNode(this.swigCPtr, this);
    }

    public boolean isGPSWeak() {
        return AREngineJNIBridge.DARCZGNavigator_isGPSWeak(this.swigCPtr, this);
    }

    public boolean needShowBehindTips() {
        return AREngineJNIBridge.DARCZGNavigator_needShowBehindTips(this.swigCPtr, this);
    }
}
