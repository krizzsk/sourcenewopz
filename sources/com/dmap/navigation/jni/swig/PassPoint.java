package com.dmap.navigation.jni.swig;

public class PassPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected PassPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PassPoint passPoint) {
        if (passPoint == null) {
            return 0;
        }
        return passPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_PassPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setPassPoint(NaviPoi naviPoi) {
        NaviBusinessJNI.PassPoint_passPoint_set(this.swigCPtr, this, NaviPoi.getCPtr(naviPoi), naviPoi);
    }

    public NaviPoi getPassPoint() {
        long PassPoint_passPoint_get = NaviBusinessJNI.PassPoint_passPoint_get(this.swigCPtr, this);
        if (PassPoint_passPoint_get == 0) {
            return null;
        }
        return new NaviPoi(PassPoint_passPoint_get, false);
    }

    public void setCoorIndex(int i) {
        NaviBusinessJNI.PassPoint_coorIndex_set(this.swigCPtr, this, i);
    }

    public int getCoorIndex() {
        return NaviBusinessJNI.PassPoint_coorIndex_get(this.swigCPtr, this);
    }

    public void setPointIndex(int i) {
        NaviBusinessJNI.PassPoint_pointIndex_set(this.swigCPtr, this, i);
    }

    public int getPointIndex() {
        return NaviBusinessJNI.PassPoint_pointIndex_get(this.swigCPtr, this);
    }

    public PassPoint() {
        this(NaviBusinessJNI.new_PassPoint(), true);
    }
}
