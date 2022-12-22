package com.dmap.navigation.jni.swig;

public class NaviRouteStrategy {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRouteStrategy(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRouteStrategy naviRouteStrategy) {
        if (naviRouteStrategy == null) {
            return 0;
        }
        return naviRouteStrategy.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRouteStrategy(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setRapidArrival(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_rapidArrival_set(this.swigCPtr, this, z);
    }

    public boolean getRapidArrival() {
        return NaviBusinessJNI.NaviRouteStrategy_rapidArrival_get(this.swigCPtr, this);
    }

    public void setAutoRecommend(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_autoRecommend_set(this.swigCPtr, this, z);
    }

    public boolean getAutoRecommend() {
        return NaviBusinessJNI.NaviRouteStrategy_autoRecommend_get(this.swigCPtr, this);
    }

    public void setTimeFirst(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_timeFirst_set(this.swigCPtr, this, z);
    }

    public boolean getTimeFirst() {
        return NaviBusinessJNI.NaviRouteStrategy_timeFirst_get(this.swigCPtr, this);
    }

    public void setHighwayFirst(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_highwayFirst_set(this.swigCPtr, this, z);
    }

    public boolean getHighwayFirst() {
        return NaviBusinessJNI.NaviRouteStrategy_highwayFirst_get(this.swigCPtr, this);
    }

    public void setAvoidJam(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_avoidJam_set(this.swigCPtr, this, z);
    }

    public boolean getAvoidJam() {
        return NaviBusinessJNI.NaviRouteStrategy_avoidJam_get(this.swigCPtr, this);
    }

    public void setAvoidCharge(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_avoidCharge_set(this.swigCPtr, this, z);
    }

    public boolean getAvoidCharge() {
        return NaviBusinessJNI.NaviRouteStrategy_avoidCharge_get(this.swigCPtr, this);
    }

    public void setAvoidRestrict(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_avoidRestrict_set(this.swigCPtr, this, z);
    }

    public boolean getAvoidRestrict() {
        return NaviBusinessJNI.NaviRouteStrategy_avoidRestrict_get(this.swigCPtr, this);
    }

    public void setRejectCharge(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_rejectCharge_set(this.swigCPtr, this, z);
    }

    public boolean getRejectCharge() {
        return NaviBusinessJNI.NaviRouteStrategy_rejectCharge_get(this.swigCPtr, this);
    }

    public void setAcceptCharge(boolean z) {
        NaviBusinessJNI.NaviRouteStrategy_acceptCharge_set(this.swigCPtr, this, z);
    }

    public boolean getAcceptCharge() {
        return NaviBusinessJNI.NaviRouteStrategy_acceptCharge_get(this.swigCPtr, this);
    }

    public NaviRouteStrategy() {
        this(NaviBusinessJNI.new_NaviRouteStrategy(), true);
    }
}
