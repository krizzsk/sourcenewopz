package com.dmap.navigation.jni.swig;

public class RGGPSPoint_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RGGPSPoint_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RGGPSPoint_t rGGPSPoint_t) {
        if (rGGPSPoint_t == null) {
            return 0;
        }
        return rGGPSPoint_t.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_RGGPSPoint_t(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setRouteMapPos(RGMapRoutePoint_t rGMapRoutePoint_t) {
        NaviBusinessJNI.RGGPSPoint_t_routeMapPos_set(this.swigCPtr, this, RGMapRoutePoint_t.getCPtr(rGMapRoutePoint_t), rGMapRoutePoint_t);
    }

    public RGMapRoutePoint_t getRouteMapPos() {
        long RGGPSPoint_t_routeMapPos_get = NaviBusinessJNI.RGGPSPoint_t_routeMapPos_get(this.swigCPtr, this);
        if (RGGPSPoint_t_routeMapPos_get == 0) {
            return null;
        }
        return new RGMapRoutePoint_t(RGGPSPoint_t_routeMapPos_get, false);
    }

    public void setHeading(float f) {
        NaviBusinessJNI.RGGPSPoint_t_heading_set(this.swigCPtr, this, f);
    }

    public float getHeading() {
        return NaviBusinessJNI.RGGPSPoint_t_heading_get(this.swigCPtr, this);
    }

    public void setLocationAccuracy(float f) {
        NaviBusinessJNI.RGGPSPoint_t_locationAccuracy_set(this.swigCPtr, this, f);
    }

    public float getLocationAccuracy() {
        return NaviBusinessJNI.RGGPSPoint_t_locationAccuracy_get(this.swigCPtr, this);
    }

    public void setVelocity(float f) {
        NaviBusinessJNI.RGGPSPoint_t_velocity_set(this.swigCPtr, this, f);
    }

    public float getVelocity() {
        return NaviBusinessJNI.RGGPSPoint_t_velocity_get(this.swigCPtr, this);
    }

    public void setTimestamp(int i) {
        NaviBusinessJNI.RGGPSPoint_t_timestamp_set(this.swigCPtr, this, i);
    }

    public int getTimestamp() {
        return NaviBusinessJNI.RGGPSPoint_t_timestamp_get(this.swigCPtr, this);
    }

    public void setFlpBearing(float f) {
        NaviBusinessJNI.RGGPSPoint_t_flpBearing_set(this.swigCPtr, this, f);
    }

    public float getFlpBearing() {
        return NaviBusinessJNI.RGGPSPoint_t_flpBearing_get(this.swigCPtr, this);
    }

    public void setFlpConfidence(float f) {
        NaviBusinessJNI.RGGPSPoint_t_flpConfidence_set(this.swigCPtr, this, f);
    }

    public float getFlpConfidence() {
        return NaviBusinessJNI.RGGPSPoint_t_flpConfidence_get(this.swigCPtr, this);
    }

    public void setFlpStatus(int i) {
        NaviBusinessJNI.RGGPSPoint_t_flpStatus_set(this.swigCPtr, this, i);
    }

    public int getFlpStatus() {
        return NaviBusinessJNI.RGGPSPoint_t_flpStatus_get(this.swigCPtr, this);
    }

    public void setSource(int i) {
        NaviBusinessJNI.RGGPSPoint_t_source_set(this.swigCPtr, this, i);
    }

    public int getSource() {
        return NaviBusinessJNI.RGGPSPoint_t_source_get(this.swigCPtr, this);
    }

    public void setGpsProvider(int i) {
        NaviBusinessJNI.RGGPSPoint_t_gpsProvider_set(this.swigCPtr, this, i);
    }

    public int getGpsProvider() {
        return NaviBusinessJNI.RGGPSPoint_t_gpsProvider_get(this.swigCPtr, this);
    }

    public void setVdrConf(int i) {
        NaviBusinessJNI.RGGPSPoint_t_vdrConf_set(this.swigCPtr, this, i);
    }

    public int getVdrConf() {
        return NaviBusinessJNI.RGGPSPoint_t_vdrConf_get(this.swigCPtr, this);
    }

    public void setOrgLng(double d) {
        NaviBusinessJNI.RGGPSPoint_t_orgLng_set(this.swigCPtr, this, d);
    }

    public double getOrgLng() {
        return NaviBusinessJNI.RGGPSPoint_t_orgLng_get(this.swigCPtr, this);
    }

    public void setOrgLat(double d) {
        NaviBusinessJNI.RGGPSPoint_t_orgLat_set(this.swigCPtr, this, d);
    }

    public double getOrgLat() {
        return NaviBusinessJNI.RGGPSPoint_t_orgLat_get(this.swigCPtr, this);
    }

    public void setOrgDir(float f) {
        NaviBusinessJNI.RGGPSPoint_t_orgDir_set(this.swigCPtr, this, f);
    }

    public float getOrgDir() {
        return NaviBusinessJNI.RGGPSPoint_t_orgDir_get(this.swigCPtr, this);
    }

    public void setOrgAcc(float f) {
        NaviBusinessJNI.RGGPSPoint_t_orgAcc_set(this.swigCPtr, this, f);
    }

    public float getOrgAcc() {
        return NaviBusinessJNI.RGGPSPoint_t_orgAcc_get(this.swigCPtr, this);
    }

    public void setSatNum(int i) {
        NaviBusinessJNI.RGGPSPoint_t_satNum_set(this.swigCPtr, this, i);
    }

    public int getSatNum() {
        return NaviBusinessJNI.RGGPSPoint_t_satNum_get(this.swigCPtr, this);
    }

    public RGGPSPoint_t() {
        this(NaviBusinessJNI.new_RGGPSPoint_t(), true);
    }
}
