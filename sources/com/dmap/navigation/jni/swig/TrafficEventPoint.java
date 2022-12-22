package com.dmap.navigation.jni.swig;

public class TrafficEventPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TrafficEventPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrafficEventPoint trafficEventPoint) {
        if (trafficEventPoint == null) {
            return 0;
        }
        return trafficEventPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_TrafficEventPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setCoorIdx(int i) {
        NaviBusinessJNI.TrafficEventPoint_coorIdx_set(this.swigCPtr, this, i);
    }

    public int getCoorIdx() {
        return NaviBusinessJNI.TrafficEventPoint_coorIdx_get(this.swigCPtr, this);
    }

    public void setShapeOffset(int i) {
        NaviBusinessJNI.TrafficEventPoint_shapeOffset_set(this.swigCPtr, this, i);
    }

    public int getShapeOffset() {
        return NaviBusinessJNI.TrafficEventPoint_shapeOffset_get(this.swigCPtr, this);
    }

    public TrafficEventPoint() {
        this(NaviBusinessJNI.new_TrafficEventPoint(), true);
    }
}
