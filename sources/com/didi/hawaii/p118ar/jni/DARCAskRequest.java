package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCAskRequest */
public class DARCAskRequest extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCAskRequest(long j, boolean z) {
        super(AREngineJNIBridge.DARCAskRequest_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCAskRequest dARCAskRequest) {
        if (dARCAskRequest == null) {
            return 0;
        }
        return dARCAskRequest.swigCPtr;
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

    public static DARCAskRequest alloc() {
        long DARCAskRequest_alloc = AREngineJNIBridge.DARCAskRequest_alloc();
        if (DARCAskRequest_alloc == 0) {
            return null;
        }
        return new DARCAskRequest(DARCAskRequest_alloc, false);
    }

    public void setUid(String str) {
        AREngineJNIBridge.DARCAskRequest_uid_set(this.swigCPtr, this, str);
    }

    public String getUid() {
        return AREngineJNIBridge.DARCAskRequest_uid_get(this.swigCPtr, this);
    }

    public void setOsKind(String str) {
        AREngineJNIBridge.DARCAskRequest_osKind_set(this.swigCPtr, this, str);
    }

    public String getOsKind() {
        return AREngineJNIBridge.DARCAskRequest_osKind_get(this.swigCPtr, this);
    }

    public void setOsVersion(String str) {
        AREngineJNIBridge.DARCAskRequest_osVersion_set(this.swigCPtr, this, str);
    }

    public String getOsVersion() {
        return AREngineJNIBridge.DARCAskRequest_osVersion_get(this.swigCPtr, this);
    }

    public void setOrderID(String str) {
        AREngineJNIBridge.DARCAskRequest_orderID_set(this.swigCPtr, this, str);
    }

    public String getOrderID() {
        return AREngineJNIBridge.DARCAskRequest_orderID_get(this.swigCPtr, this);
    }

    public void setAppId(String str) {
        AREngineJNIBridge.DARCAskRequest_appId_set(this.swigCPtr, this, str);
    }

    public String getAppId() {
        return AREngineJNIBridge.DARCAskRequest_appId_get(this.swigCPtr, this);
    }

    public void setAppVersion(String str) {
        AREngineJNIBridge.DARCAskRequest_appVersion_set(this.swigCPtr, this, str);
    }

    public String getAppVersion() {
        return AREngineJNIBridge.DARCAskRequest_appVersion_get(this.swigCPtr, this);
    }

    public void setAppName(String str) {
        AREngineJNIBridge.DARCAskRequest_appName_set(this.swigCPtr, this, str);
    }

    public String getAppName() {
        return AREngineJNIBridge.DARCAskRequest_appName_get(this.swigCPtr, this);
    }

    public void setDeviceModel(String str) {
        AREngineJNIBridge.DARCAskRequest_deviceModel_set(this.swigCPtr, this, str);
    }

    public String getDeviceModel() {
        return AREngineJNIBridge.DARCAskRequest_deviceModel_get(this.swigCPtr, this);
    }

    public void setDestGeoPt(DARCGeoPoint dARCGeoPoint) {
        AREngineJNIBridge.DARCAskRequest_destGeoPt_set(this.swigCPtr, this, DARCGeoPoint.getCPtr(dARCGeoPoint), dARCGeoPoint);
    }

    public DARCGeoPoint getDestGeoPt() {
        long DARCAskRequest_destGeoPt_get = AREngineJNIBridge.DARCAskRequest_destGeoPt_get(this.swigCPtr, this);
        if (DARCAskRequest_destGeoPt_get == 0) {
            return null;
        }
        return new DARCGeoPoint(DARCAskRequest_destGeoPt_get, false);
    }

    public void setCurGPSData(DARCGPSData dARCGPSData) {
        AREngineJNIBridge.DARCAskRequest_curGPSData_set(this.swigCPtr, this, DARCGPSData.getCPtr(dARCGPSData), dARCGPSData);
    }

    public DARCGPSData getCurGPSData() {
        long DARCAskRequest_curGPSData_get = AREngineJNIBridge.DARCAskRequest_curGPSData_get(this.swigCPtr, this);
        if (DARCAskRequest_curGPSData_get == 0) {
            return null;
        }
        return new DARCGPSData(DARCAskRequest_curGPSData_get, false);
    }

    public void setScene(int i) {
        AREngineJNIBridge.DARCAskRequest_scene_set(this.swigCPtr, this, i);
    }

    public int getScene() {
        return AREngineJNIBridge.DARCAskRequest_scene_get(this.swigCPtr, this);
    }
}
