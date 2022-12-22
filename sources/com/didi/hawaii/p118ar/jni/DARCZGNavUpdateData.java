package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavUpdateData */
public class DARCZGNavUpdateData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCZGNavUpdateData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavUpdateData dARCZGNavUpdateData) {
        if (dARCZGNavUpdateData == null) {
            return 0;
        }
        return dARCZGNavUpdateData.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCZGNavUpdateData(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setProjection(DARCMatrix4F dARCMatrix4F) {
        AREngineJNIBridge.DARCZGNavUpdateData_projection_set(this.swigCPtr, this, DARCMatrix4F.getCPtr(dARCMatrix4F), dARCMatrix4F);
    }

    public DARCMatrix4F getProjection() {
        long DARCZGNavUpdateData_projection_get = AREngineJNIBridge.DARCZGNavUpdateData_projection_get(this.swigCPtr, this);
        if (DARCZGNavUpdateData_projection_get == 0) {
            return null;
        }
        return new DARCMatrix4F(DARCZGNavUpdateData_projection_get, false);
    }

    public void setArOriginTimeStamp(double d) {
        AREngineJNIBridge.DARCZGNavUpdateData_arOriginTimeStamp_set(this.swigCPtr, this, d);
    }

    public double getArOriginTimeStamp() {
        return AREngineJNIBridge.DARCZGNavUpdateData_arOriginTimeStamp_get(this.swigCPtr, this);
    }

    public void setTrackState(DARCARTrackState dARCARTrackState) {
        AREngineJNIBridge.DARCZGNavUpdateData_trackState_set(this.swigCPtr, this, dARCARTrackState.swigValue());
    }

    public DARCARTrackState getTrackState() {
        return DARCARTrackState.swigToEnum(AREngineJNIBridge.DARCZGNavUpdateData_trackState_get(this.swigCPtr, this));
    }

    public void setTransform(DARCMatrix4F dARCMatrix4F) {
        AREngineJNIBridge.DARCZGNavUpdateData_transform_set(this.swigCPtr, this, DARCMatrix4F.getCPtr(dARCMatrix4F), dARCMatrix4F);
    }

    public DARCMatrix4F getTransform() {
        long DARCZGNavUpdateData_transform_get = AREngineJNIBridge.DARCZGNavUpdateData_transform_get(this.swigCPtr, this);
        if (DARCZGNavUpdateData_transform_get == 0) {
            return null;
        }
        return new DARCMatrix4F(DARCZGNavUpdateData_transform_get, false);
    }

    public void setLightIntensity(float f) {
        AREngineJNIBridge.DARCZGNavUpdateData_lightIntensity_set(this.swigCPtr, this, f);
    }

    public float getLightIntensity() {
        return AREngineJNIBridge.DARCZGNavUpdateData_lightIntensity_get(this.swigCPtr, this);
    }

    public void setRotationVector(DARCPoint4F dARCPoint4F) {
        AREngineJNIBridge.DARCZGNavUpdateData_rotationVector_set(this.swigCPtr, this, DARCPoint4F.getCPtr(dARCPoint4F), dARCPoint4F);
    }

    public DARCPoint4F getRotationVector() {
        long DARCZGNavUpdateData_rotationVector_get = AREngineJNIBridge.DARCZGNavUpdateData_rotationVector_get(this.swigCPtr, this);
        if (DARCZGNavUpdateData_rotationVector_get == 0) {
            return null;
        }
        return new DARCPoint4F(DARCZGNavUpdateData_rotationVector_get, false);
    }

    public void setGpsData(DARCGPSData dARCGPSData) {
        AREngineJNIBridge.DARCZGNavUpdateData_gpsData_set(this.swigCPtr, this, DARCGPSData.getCPtr(dARCGPSData), dARCGPSData);
    }

    public DARCGPSData getGpsData() {
        long DARCZGNavUpdateData_gpsData_get = AREngineJNIBridge.DARCZGNavUpdateData_gpsData_get(this.swigCPtr, this);
        if (DARCZGNavUpdateData_gpsData_get == 0) {
            return null;
        }
        return new DARCGPSData(DARCZGNavUpdateData_gpsData_get, false);
    }

    public DARCZGNavUpdateData() {
        this(AREngineJNIBridge.new_DARCZGNavUpdateData(), true);
    }
}
