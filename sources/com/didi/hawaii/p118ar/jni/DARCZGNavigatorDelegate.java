package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavigatorDelegate */
public class DARCZGNavigatorDelegate {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DARCZGNavigatorDelegate(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCZGNavigatorDelegate dARCZGNavigatorDelegate) {
        if (dARCZGNavigatorDelegate == null) {
            return 0;
        }
        return dARCZGNavigatorDelegate.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                AREngineJNIBridge.delete_DARCZGNavigatorDelegate(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void ZGNavigatorEvent(DARCZGNavigator dARCZGNavigator, DARCZGNavEvent dARCZGNavEvent, DARCZGNavEventData dARCZGNavEventData) {
        AREngineJNIBridge.DARCZGNavigatorDelegate_ZGNavigatorEvent(this.swigCPtr, this, DARCZGNavigator.getCPtr(dARCZGNavigator), dARCZGNavigator, dARCZGNavEvent.swigValue(), DARCZGNavEventData.getCPtr(dARCZGNavEventData), dARCZGNavEventData);
    }
}
