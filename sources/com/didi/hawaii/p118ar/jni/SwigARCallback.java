package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.SwigARCallback */
public class SwigARCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SwigARCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SwigARCallback swigARCallback) {
        if (swigARCallback == null) {
            return 0;
        }
        return swigARCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_SwigARCallback(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        AREngineJNIBridge.SwigARCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        AREngineJNIBridge.SwigARCallback_change_ownership(this, this.swigCPtr, true);
    }

    /* access modifiers changed from: protected */
    public void navigatorSendHTTPRequest(DARCHTTPRequest dARCHTTPRequest) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_navigatorSendHTTPRequest(this.swigCPtr, this, DARCHTTPRequest.getCPtr(dARCHTTPRequest), dARCHTTPRequest);
            return;
        }
        AREngineJNIBridge.m16699x4fa2cf1d(this.swigCPtr, this, DARCHTTPRequest.getCPtr(dARCHTTPRequest), dARCHTTPRequest);
    }

    /* access modifiers changed from: protected */
    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDStatusChange dARCNAVEDStatusChange) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_navigatorEvent__SWIG_0(this.swigCPtr, this, dARCNAVEvent.swigValue(), DARCNAVEDStatusChange.getCPtr(dARCNAVEDStatusChange), dARCNAVEDStatusChange);
            return;
        }
        AREngineJNIBridge.SwigARCallback_navigatorEventSwigExplicitSwigARCallback__SWIG_0(this.swigCPtr, this, dARCNAVEvent.swigValue(), DARCNAVEDStatusChange.getCPtr(dARCNAVEDStatusChange), dARCNAVEDStatusChange);
    }

    /* access modifiers changed from: protected */
    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDShowAlert dARCNAVEDShowAlert) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_navigatorEvent__SWIG_1(this.swigCPtr, this, dARCNAVEvent.swigValue(), DARCNAVEDShowAlert.getCPtr(dARCNAVEDShowAlert), dARCNAVEDShowAlert);
            return;
        }
        AREngineJNIBridge.SwigARCallback_navigatorEventSwigExplicitSwigARCallback__SWIG_1(this.swigCPtr, this, dARCNAVEvent.swigValue(), DARCNAVEDShowAlert.getCPtr(dARCNAVEDShowAlert), dARCNAVEDShowAlert);
    }

    /* access modifiers changed from: protected */
    public void LogHandler(String str) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_LogHandler(this.swigCPtr, this, str);
        } else {
            AREngineJNIBridge.SwigARCallback_LogHandlerSwigExplicitSwigARCallback(this.swigCPtr, this, str);
        }
    }

    /* access modifiers changed from: protected */
    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDStatusChange dARCZGNavEDStatusChange) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_navigatorZGEvent__SWIG_0(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDStatusChange.getCPtr(dARCZGNavEDStatusChange), dARCZGNavEDStatusChange);
            return;
        }
        AREngineJNIBridge.m16700x2c0f4f5e(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDStatusChange.getCPtr(dARCZGNavEDStatusChange), dARCZGNavEDStatusChange);
    }

    /* access modifiers changed from: protected */
    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_navigatorZGEvent__SWIG_1(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDGPSWeakChange.getCPtr(dARCZGNavEDGPSWeakChange), dARCZGNavEDGPSWeakChange);
            return;
        }
        AREngineJNIBridge.m16701x2c0f4f5f(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDGPSWeakChange.getCPtr(dARCZGNavEDGPSWeakChange), dARCZGNavEDGPSWeakChange);
    }

    /* access modifiers changed from: protected */
    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_navigatorZGEvent__SWIG_2(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDDistanceChange.getCPtr(dARCZGNavEDDistanceChange), dARCZGNavEDDistanceChange);
            return;
        }
        AREngineJNIBridge.m16702x2c0f4f60(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDDistanceChange.getCPtr(dARCZGNavEDDistanceChange), dARCZGNavEDDistanceChange);
    }

    /* access modifiers changed from: protected */
    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion) {
        if (getClass() == SwigARCallback.class) {
            AREngineJNIBridge.SwigARCallback_navigatorZGEvent__SWIG_3(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDGPSFusion.getCPtr(dARCZGNavEDGPSFusion), dARCZGNavEDGPSFusion);
            return;
        }
        AREngineJNIBridge.m16703x2c0f4f61(this.swigCPtr, this, dARCZGNavEvent.swigValue(), DARCZGNavEDGPSFusion.getCPtr(dARCZGNavEDGPSFusion), dARCZGNavEDGPSFusion);
    }

    public SwigARCallback() {
        this(AREngineJNIBridge.new_SwigARCallback(), true);
        AREngineJNIBridge.SwigARCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
