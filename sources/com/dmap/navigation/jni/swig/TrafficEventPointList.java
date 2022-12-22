package com.dmap.navigation.jni.swig;

public class TrafficEventPointList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TrafficEventPointList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrafficEventPointList trafficEventPointList) {
        if (trafficEventPointList == null) {
            return 0;
        }
        return trafficEventPointList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_TrafficEventPointList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public TrafficEventPointList() {
        this(NaviBusinessJNI.new_TrafficEventPointList__SWIG_0(), true);
    }

    public TrafficEventPointList(long j) {
        this(NaviBusinessJNI.new_TrafficEventPointList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.TrafficEventPointList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.TrafficEventPointList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.TrafficEventPointList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.TrafficEventPointList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.TrafficEventPointList_clear(this.swigCPtr, this);
    }

    public void add(TrafficEventPoint trafficEventPoint) {
        NaviBusinessJNI.TrafficEventPointList_add(this.swigCPtr, this, TrafficEventPoint.getCPtr(trafficEventPoint), trafficEventPoint);
    }

    public TrafficEventPoint get(int i) {
        return new TrafficEventPoint(NaviBusinessJNI.TrafficEventPointList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, TrafficEventPoint trafficEventPoint) {
        NaviBusinessJNI.TrafficEventPointList_set(this.swigCPtr, this, i, TrafficEventPoint.getCPtr(trafficEventPoint), trafficEventPoint);
    }
}
