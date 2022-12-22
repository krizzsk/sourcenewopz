package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNavigator */
public class DARCNavigator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCNavigator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCNavigator dARCNavigator) {
        if (dARCNavigator == null) {
            return 0;
        }
        return dARCNavigator.swigCPtr;
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

    public DARCNAVStatus status() {
        return DARCNAVStatus.swigToEnum(AREngineJNIBridge.DARCNavigator_status(this.swigCPtr, this));
    }

    public double currentTime() {
        return AREngineJNIBridge.DARCNavigator_currentTime(this.swigCPtr, this);
    }

    public DARCLocationInScene currentLocation() {
        return new DARCLocationInScene(AREngineJNIBridge.DARCNavigator_currentLocation(this.swigCPtr, this), true);
    }

    public DARCPointF getGuidePosInScreen() {
        return new DARCPointF(AREngineJNIBridge.DARCNavigator_getGuidePosInScreen(this.swigCPtr, this), true);
    }

    public float distanceOfEnd() {
        return AREngineJNIBridge.DARCNavigator_distanceOfEnd(this.swigCPtr, this);
    }

    public void start() {
        AREngineJNIBridge.DARCNavigator_start(this.swigCPtr, this);
    }

    public void stop() {
        AREngineJNIBridge.DARCNavigator_stop(this.swigCPtr, this);
    }

    public void errorAppear() {
        AREngineJNIBridge.DARCNavigator_errorAppear(this.swigCPtr, this);
    }

    public void errorDisappear() {
        AREngineJNIBridge.DARCNavigator_errorDisappear(this.swigCPtr, this);
    }

    public void active() {
        AREngineJNIBridge.DARCNavigator_active(this.swigCPtr, this);
    }

    public void inactive() {
        AREngineJNIBridge.DARCNavigator_inactive(this.swigCPtr, this);
    }

    public void update(DARCNAVUpdateData dARCNAVUpdateData) {
        AREngineJNIBridge.DARCNavigator_update(this.swigCPtr, this, DARCNAVUpdateData.getCPtr(dARCNAVUpdateData), dARCNAVUpdateData);
    }

    public void setCorrectNodeVisible(boolean z) {
        AREngineJNIBridge.DARCNavigator_setCorrectNodeVisible(this.swigCPtr, this, z);
    }

    public boolean getCorrectNodeVisible() {
        return AREngineJNIBridge.DARCNavigator_getCorrectNodeVisible(this.swigCPtr, this);
    }

    public void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse) {
        AREngineJNIBridge.DARCNavigator_recvHTTPResponse(this.swigCPtr, this, DARCHTTPResponse.getCPtr(dARCHTTPResponse), dARCHTTPResponse);
    }

    public void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus) {
        AREngineJNIBridge.DARCNavigator_networkStatusChanged(this.swigCPtr, this, dARCNetworkStatus.swigValue());
    }

    public void eventShowAlertReply(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
        AREngineJNIBridge.DARCNavigator_eventShowAlertReply(this.swigCPtr, this, DARCNAVEDShowAlert.getCPtr(dARCNAVEDShowAlert), dARCNAVEDShowAlert, i);
    }
}
