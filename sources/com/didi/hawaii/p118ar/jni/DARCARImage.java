package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCARImage */
public class DARCARImage extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCARImage(long j, boolean z) {
        super(AREngineJNIBridge.DARCARImage_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCARImage dARCARImage) {
        if (dARCARImage == null) {
            return 0;
        }
        return dARCARImage.swigCPtr;
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

    public static DARCARImage alloc() {
        long DARCARImage_alloc = AREngineJNIBridge.DARCARImage_alloc();
        if (DARCARImage_alloc == 0) {
            return null;
        }
        return new DARCARImage(DARCARImage_alloc, false);
    }

    public void setOSImage(Object obj) {
        AREngineJNIBridge.DARCARImage_setOSImage(this.swigCPtr, this, obj);
    }

    public DARCData getCompressedData() {
        long DARCARImage_getCompressedData = AREngineJNIBridge.DARCARImage_getCompressedData(this.swigCPtr, this);
        if (DARCARImage_getCompressedData == 0) {
            return null;
        }
        return new DARCData(DARCARImage_getCompressedData, false);
    }

    public void setCompressedData(DARCData dARCData) {
        AREngineJNIBridge.DARCARImage_setCompressedData(this.swigCPtr, this, DARCData.getCPtr(dARCData), dARCData);
    }

    public DARCData getDib() {
        long DARCARImage_getDib = AREngineJNIBridge.DARCARImage_getDib(this.swigCPtr, this);
        if (DARCARImage_getDib == 0) {
            return null;
        }
        return new DARCData(DARCARImage_getDib, false);
    }

    public void setDib(DARCData dARCData) {
        AREngineJNIBridge.DARCARImage_setDib(this.swigCPtr, this, DARCData.getCPtr(dARCData), dARCData);
    }

    public DARCARPoseState DetectARPoseState(DARCMatrix4F dARCMatrix4F, DARCMatrix4F dARCMatrix4F2, DARCPoint3F dARCPoint3F, float f) {
        return DARCARPoseState.swigToEnum(AREngineJNIBridge.DARCARImage_DetectARPoseState(this.swigCPtr, this, DARCMatrix4F.getCPtr(dARCMatrix4F), dARCMatrix4F, DARCMatrix4F.getCPtr(dARCMatrix4F2), dARCMatrix4F2, DARCPoint3F.getCPtr(dARCPoint3F), dARCPoint3F, f));
    }

    public void setTimestamp(double d) {
        AREngineJNIBridge.DARCARImage_timestamp_set(this.swigCPtr, this, d);
    }

    public double getTimestamp() {
        return AREngineJNIBridge.DARCARImage_timestamp_get(this.swigCPtr, this);
    }

    public void setWidth(int i) {
        AREngineJNIBridge.DARCARImage_width_set(this.swigCPtr, this, i);
    }

    public int getWidth() {
        return AREngineJNIBridge.DARCARImage_width_get(this.swigCPtr, this);
    }

    public void setHeight(int i) {
        AREngineJNIBridge.DARCARImage_height_set(this.swigCPtr, this, i);
    }

    public int getHeight() {
        return AREngineJNIBridge.DARCARImage_height_get(this.swigCPtr, this);
    }

    public void setScore(double d) {
        AREngineJNIBridge.DARCARImage_score_set(this.swigCPtr, this, d);
    }

    public double getScore() {
        return AREngineJNIBridge.DARCARImage_score_get(this.swigCPtr, this);
    }

    public void setArOriginTimeStamp(double d) {
        AREngineJNIBridge.DARCARImage_arOriginTimeStamp_set(this.swigCPtr, this, d);
    }

    public double getArOriginTimeStamp() {
        return AREngineJNIBridge.DARCARImage_arOriginTimeStamp_get(this.swigCPtr, this);
    }

    public void setTrackState(DARCARTrackState dARCARTrackState) {
        AREngineJNIBridge.DARCARImage_trackState_set(this.swigCPtr, this, dARCARTrackState.swigValue());
    }

    public DARCARTrackState getTrackState() {
        return DARCARTrackState.swigToEnum(AREngineJNIBridge.DARCARImage_trackState_get(this.swigCPtr, this));
    }

    public void setTrackStateReason(DARCARTrackStateReason dARCARTrackStateReason) {
        AREngineJNIBridge.DARCARImage_trackStateReason_set(this.swigCPtr, this, dARCARTrackStateReason.swigValue());
    }

    public DARCARTrackStateReason getTrackStateReason() {
        return DARCARTrackStateReason.swigToEnum(AREngineJNIBridge.DARCARImage_trackStateReason_get(this.swigCPtr, this));
    }

    public void setTransform(DARCMatrix4F dARCMatrix4F) {
        AREngineJNIBridge.DARCARImage_transform_set(this.swigCPtr, this, DARCMatrix4F.getCPtr(dARCMatrix4F), dARCMatrix4F);
    }

    public DARCMatrix4F getTransform() {
        long DARCARImage_transform_get = AREngineJNIBridge.DARCARImage_transform_get(this.swigCPtr, this);
        if (DARCARImage_transform_get == 0) {
            return null;
        }
        return new DARCMatrix4F(DARCARImage_transform_get, false);
    }

    public void setEulerAngle(DARCPoint3F dARCPoint3F) {
        AREngineJNIBridge.DARCARImage_eulerAngle_set(this.swigCPtr, this, DARCPoint3F.getCPtr(dARCPoint3F), dARCPoint3F);
    }

    public DARCPoint3F getEulerAngle() {
        long DARCARImage_eulerAngle_get = AREngineJNIBridge.DARCARImage_eulerAngle_get(this.swigCPtr, this);
        if (DARCARImage_eulerAngle_get == 0) {
            return null;
        }
        return new DARCPoint3F(DARCARImage_eulerAngle_get, false);
    }

    public void setIntrinsics(DARCMatrix3F dARCMatrix3F) {
        AREngineJNIBridge.DARCARImage_intrinsics_set(this.swigCPtr, this, DARCMatrix3F.getCPtr(dARCMatrix3F), dARCMatrix3F);
    }

    public DARCMatrix3F getIntrinsics() {
        long DARCARImage_intrinsics_get = AREngineJNIBridge.DARCARImage_intrinsics_get(this.swigCPtr, this);
        if (DARCARImage_intrinsics_get == 0) {
            return null;
        }
        return new DARCMatrix3F(DARCARImage_intrinsics_get, false);
    }

    public void setAmbientIntensity(float f) {
        AREngineJNIBridge.DARCARImage_ambientIntensity_set(this.swigCPtr, this, f);
    }

    public float getAmbientIntensity() {
        return AREngineJNIBridge.DARCARImage_ambientIntensity_get(this.swigCPtr, this);
    }

    public void setAmbientColorTemperature(float f) {
        AREngineJNIBridge.DARCARImage_ambientColorTemperature_set(this.swigCPtr, this, f);
    }

    public float getAmbientColorTemperature() {
        return AREngineJNIBridge.DARCARImage_ambientColorTemperature_get(this.swigCPtr, this);
    }

    public void setAttitudeMatrix(DARCMatrix3F dARCMatrix3F) {
        AREngineJNIBridge.DARCARImage_attitudeMatrix_set(this.swigCPtr, this, DARCMatrix3F.getCPtr(dARCMatrix3F), dARCMatrix3F);
    }

    public DARCMatrix3F getAttitudeMatrix() {
        long DARCARImage_attitudeMatrix_get = AREngineJNIBridge.DARCARImage_attitudeMatrix_get(this.swigCPtr, this);
        if (DARCARImage_attitudeMatrix_get == 0) {
            return null;
        }
        return new DARCMatrix3F(DARCARImage_attitudeMatrix_get, false);
    }

    public void setGPSData(DARCGPSData dARCGPSData) {
        AREngineJNIBridge.DARCARImage_GPSData_set(this.swigCPtr, this, DARCGPSData.getCPtr(dARCGPSData), dARCGPSData);
    }

    public DARCGPSData getGPSData() {
        long DARCARImage_GPSData_get = AREngineJNIBridge.DARCARImage_GPSData_get(this.swigCPtr, this);
        if (DARCARImage_GPSData_get == 0) {
            return null;
        }
        return new DARCGPSData(DARCARImage_GPSData_get, false);
    }

    public void setGPSOriginData(DARCGPSData dARCGPSData) {
        AREngineJNIBridge.DARCARImage_GPSOriginData_set(this.swigCPtr, this, DARCGPSData.getCPtr(dARCGPSData), dARCGPSData);
    }

    public DARCGPSData getGPSOriginData() {
        long DARCARImage_GPSOriginData_get = AREngineJNIBridge.DARCARImage_GPSOriginData_get(this.swigCPtr, this);
        if (DARCARImage_GPSOriginData_get == 0) {
            return null;
        }
        return new DARCGPSData(DARCARImage_GPSOriginData_get, false);
    }

    public void setSceneLocation(DARCLocationInScene dARCLocationInScene) {
        AREngineJNIBridge.DARCARImage_sceneLocation_set(this.swigCPtr, this, DARCLocationInScene.getCPtr(dARCLocationInScene), dARCLocationInScene);
    }

    public DARCLocationInScene getSceneLocation() {
        long DARCARImage_sceneLocation_get = AREngineJNIBridge.DARCARImage_sceneLocation_get(this.swigCPtr, this);
        if (DARCARImage_sceneLocation_get == 0) {
            return null;
        }
        return new DARCLocationInScene(DARCARImage_sceneLocation_get, false);
    }

    public void setAirPressure(float f) {
        AREngineJNIBridge.DARCARImage_airPressure_set(this.swigCPtr, this, f);
    }

    public float getAirPressure() {
        return AREngineJNIBridge.DARCARImage_airPressure_get(this.swigCPtr, this);
    }

    public void setGroupID(int i) {
        AREngineJNIBridge.DARCARImage_groupID_set(this.swigCPtr, this, i);
    }

    public int getGroupID() {
        return AREngineJNIBridge.DARCARImage_groupID_get(this.swigCPtr, this);
    }

    public void setFeaturePointCount(int i) {
        AREngineJNIBridge.DARCARImage_featurePointCount_set(this.swigCPtr, this, i);
    }

    public int getFeaturePointCount() {
        return AREngineJNIBridge.DARCARImage_featurePointCount_get(this.swigCPtr, this);
    }

    public void setIsStartPDR(boolean z) {
        AREngineJNIBridge.DARCARImage_isStartPDR_set(this.swigCPtr, this, z);
    }

    public boolean getIsStartPDR() {
        return AREngineJNIBridge.DARCARImage_isStartPDR_get(this.swigCPtr, this);
    }

    public void setM_PDRState(SWIGTYPE_p_didi__pdrsdk__DARCPDRState sWIGTYPE_p_didi__pdrsdk__DARCPDRState) {
        AREngineJNIBridge.DARCARImage_m_PDRState_set(this.swigCPtr, this, SWIGTYPE_p_didi__pdrsdk__DARCPDRState.getCPtr(sWIGTYPE_p_didi__pdrsdk__DARCPDRState));
    }

    public SWIGTYPE_p_didi__pdrsdk__DARCPDRState getM_PDRState() {
        return new SWIGTYPE_p_didi__pdrsdk__DARCPDRState(AREngineJNIBridge.DARCARImage_m_PDRState_get(this.swigCPtr, this), true);
    }

    public void setM_PDRStateReason(SWIGTYPE_p_didi__pdrsdk__DARCPDRState sWIGTYPE_p_didi__pdrsdk__DARCPDRState) {
        AREngineJNIBridge.DARCARImage_m_PDRStateReason_set(this.swigCPtr, this, SWIGTYPE_p_didi__pdrsdk__DARCPDRState.getCPtr(sWIGTYPE_p_didi__pdrsdk__DARCPDRState));
    }

    public SWIGTYPE_p_didi__pdrsdk__DARCPDRState getM_PDRStateReason() {
        return new SWIGTYPE_p_didi__pdrsdk__DARCPDRState(AREngineJNIBridge.DARCARImage_m_PDRStateReason_get(this.swigCPtr, this), true);
    }

    public void setM_ARDriftNumberInInit(int i) {
        AREngineJNIBridge.DARCARImage_m_ARDriftNumberInInit_set(this.swigCPtr, this, i);
    }

    public int getM_ARDriftNumberInInit() {
        return AREngineJNIBridge.DARCARImage_m_ARDriftNumberInInit_get(this.swigCPtr, this);
    }

    public void setM_ARDriftNumberInNavi(int i) {
        AREngineJNIBridge.DARCARImage_m_ARDriftNumberInNavi_set(this.swigCPtr, this, i);
    }

    public int getM_ARDriftNumberInNavi() {
        return AREngineJNIBridge.DARCARImage_m_ARDriftNumberInNavi_get(this.swigCPtr, this);
    }

    public void setIsStartPDRZG(boolean z) {
        AREngineJNIBridge.DARCARImage_isStartPDRZG_set(this.swigCPtr, this, z);
    }

    public boolean getIsStartPDRZG() {
        return AREngineJNIBridge.DARCARImage_isStartPDRZG_get(this.swigCPtr, this);
    }

    public void setIsGPSInit(boolean z) {
        AREngineJNIBridge.DARCARImage_isGPSInit_set(this.swigCPtr, this, z);
    }

    public boolean getIsGPSInit() {
        return AREngineJNIBridge.DARCARImage_isGPSInit_get(this.swigCPtr, this);
    }
}
