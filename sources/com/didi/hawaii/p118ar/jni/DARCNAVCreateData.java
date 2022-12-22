package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNAVCreateData */
public class DARCNAVCreateData extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        AREngineJNI.DARCNAVCreateData_containerView_release(this);
        DARCObject.release(this);
    }

    protected DARCNAVCreateData(long j, boolean z) {
        super(AREngineJNIBridge.DARCNAVCreateData_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCNAVCreateData dARCNAVCreateData) {
        if (dARCNAVCreateData == null) {
            return 0;
        }
        return dARCNAVCreateData.swigCPtr;
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

    public static DARCNAVCreateData alloc() {
        long DARCNAVCreateData_alloc = AREngineJNIBridge.DARCNAVCreateData_alloc();
        if (DARCNAVCreateData_alloc == 0) {
            return null;
        }
        return new DARCNAVCreateData(DARCNAVCreateData_alloc, false);
    }

    public void setDataPath(String str) {
        AREngineJNIBridge.DARCNAVCreateData_dataPath_set(this.swigCPtr, this, str);
    }

    public String getDataPath() {
        return AREngineJNIBridge.DARCNAVCreateData_dataPath_get(this.swigCPtr, this);
    }

    public void setDataIsSimple(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_dataIsSimple_set(this.swigCPtr, this, z);
    }

    public boolean getDataIsSimple() {
        return AREngineJNIBridge.DARCNAVCreateData_dataIsSimple_get(this.swigCPtr, this);
    }

    public void setNetworkStatus(DARCNetworkStatus dARCNetworkStatus) {
        AREngineJNIBridge.DARCNAVCreateData_networkStatus_set(this.swigCPtr, this, dARCNetworkStatus.swigValue());
    }

    public DARCNetworkStatus getNetworkStatus() {
        return DARCNetworkStatus.swigToEnum(AREngineJNIBridge.DARCNAVCreateData_networkStatus_get(this.swigCPtr, this));
    }

    public void setUid(String str) {
        AREngineJNIBridge.DARCNAVCreateData_uid_set(this.swigCPtr, this, str);
    }

    public String getUid() {
        return AREngineJNIBridge.DARCNAVCreateData_uid_get(this.swigCPtr, this);
    }

    public void setOrderID(String str) {
        AREngineJNIBridge.DARCNAVCreateData_orderID_set(this.swigCPtr, this, str);
    }

    public String getOrderID() {
        return AREngineJNIBridge.DARCNAVCreateData_orderID_get(this.swigCPtr, this);
    }

    public void setSlideWindow(int i) {
        AREngineJNIBridge.DARCNAVCreateData_slideWindow_set(this.swigCPtr, this, i);
    }

    public int getSlideWindow() {
        return AREngineJNIBridge.DARCNAVCreateData_slideWindow_get(this.swigCPtr, this);
    }

    public DARCAskResponse askData() {
        long DARCNAVCreateData_askData = AREngineJNIBridge.DARCNAVCreateData_askData(this.swigCPtr, this);
        if (DARCNAVCreateData_askData == 0) {
            return null;
        }
        return new DARCAskResponse(DARCNAVCreateData_askData, false);
    }

    public void setAskData(DARCAskResponse dARCAskResponse) {
        AREngineJNIBridge.DARCNAVCreateData_setAskData(this.swigCPtr, this, DARCAskResponse.getCPtr(dARCAskResponse), dARCAskResponse);
    }

    public void setImagePickupInterval(float f) {
        AREngineJNIBridge.DARCNAVCreateData_imagePickupInterval_set(this.swigCPtr, this, f);
    }

    public float getImagePickupInterval() {
        return AREngineJNIBridge.DARCNAVCreateData_imagePickupInterval_get(this.swigCPtr, this);
    }

    public void setPDREnabled(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_PDREnabled_set(this.swigCPtr, this, z);
    }

    public boolean getPDREnabled() {
        return AREngineJNIBridge.DARCNAVCreateData_PDREnabled_get(this.swigCPtr, this);
    }

    public void setPDRShadowEnabled(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_PDRShadowEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getPDRShadowEnabled() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRShadowEnabled_get(this.swigCPtr, this);
    }

    public void setPDRFusionEnable(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_PDRFusionEnable_set(this.swigCPtr, this, z);
    }

    public boolean getPDRFusionEnable() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRFusionEnable_get(this.swigCPtr, this);
    }

    public void setPDRCoreDuration(int i) {
        AREngineJNIBridge.DARCNAVCreateData_PDRCoreDuration_set(this.swigCPtr, this, i);
    }

    public int getPDRCoreDuration() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRCoreDuration_get(this.swigCPtr, this);
    }

    public void setPDRTotalDuration(int i) {
        AREngineJNIBridge.DARCNAVCreateData_PDRTotalDuration_set(this.swigCPtr, this, i);
    }

    public int getPDRTotalDuration() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRTotalDuration_get(this.swigCPtr, this);
    }

    public void setPDRInterLocInterval(int i) {
        AREngineJNIBridge.DARCNAVCreateData_PDRInterLocInterval_set(this.swigCPtr, this, i);
    }

    public int getPDRInterLocInterval() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRInterLocInterval_get(this.swigCPtr, this);
    }

    public void setPDRInterLocDistance(int i) {
        AREngineJNIBridge.DARCNAVCreateData_PDRInterLocDistance_set(this.swigCPtr, this, i);
    }

    public int getPDRInterLocDistance() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRInterLocDistance_get(this.swigCPtr, this);
    }

    public void setPDRLevelDetectionEnable(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_PDRLevelDetectionEnable_set(this.swigCPtr, this, z);
    }

    public boolean getPDRLevelDetectionEnable() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRLevelDetectionEnable_get(this.swigCPtr, this);
    }

    public void setARDriftDetectionInInitEnable(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInInitEnable_set(this.swigCPtr, this, z);
    }

    public boolean getARDriftDetectionInInitEnable() {
        return AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInInitEnable_get(this.swigCPtr, this);
    }

    public void setARDriftDetectionInInitSpeed(float f) {
        AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInInitSpeed_set(this.swigCPtr, this, f);
    }

    public float getARDriftDetectionInInitSpeed() {
        return AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInInitSpeed_get(this.swigCPtr, this);
    }

    public void setARDriftDetectionInNaviEnable(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInNaviEnable_set(this.swigCPtr, this, z);
    }

    public boolean getARDriftDetectionInNaviEnable() {
        return AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInNaviEnable_get(this.swigCPtr, this);
    }

    public void setARDriftDetectionInNaviSpeed(float f) {
        AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInNaviSpeed_set(this.swigCPtr, this, f);
    }

    public float getARDriftDetectionInNaviSpeed() {
        return AREngineJNIBridge.DARCNAVCreateData_ARDriftDetectionInNaviSpeed_get(this.swigCPtr, this);
    }

    public void setLocVersion(int i) {
        AREngineJNIBridge.DARCNAVCreateData_locVersion_set(this.swigCPtr, this, i);
    }

    public int getLocVersion() {
        return AREngineJNIBridge.DARCNAVCreateData_locVersion_get(this.swigCPtr, this);
    }

    public void setUseOldBoard(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_useOldBoard_set(this.swigCPtr, this, z);
    }

    public boolean getUseOldBoard() {
        return AREngineJNIBridge.DARCNAVCreateData_useOldBoard_get(this.swigCPtr, this);
    }

    public void setPDRZGEnabled(boolean z) {
        AREngineJNIBridge.DARCNAVCreateData_PDRZGEnabled_set(this.swigCPtr, this, z);
    }

    public boolean getPDRZGEnabled() {
        return AREngineJNIBridge.DARCNAVCreateData_PDRZGEnabled_get(this.swigCPtr, this);
    }
}
