package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class GpsHealthInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected GpsHealthInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GpsHealthInfo gpsHealthInfo) {
        if (gpsHealthInfo == null) {
            return 0;
        }
        return gpsHealthInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_GpsHealthInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setAll_gps(BigInteger bigInteger) {
        NaviBusinessJNI.GpsHealthInfo_all_gps_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getAll_gps() {
        return NaviBusinessJNI.GpsHealthInfo_all_gps_get(this.swigCPtr, this);
    }

    public void setAv_gps(BigInteger bigInteger) {
        NaviBusinessJNI.GpsHealthInfo_av_gps_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getAv_gps() {
        return NaviBusinessJNI.GpsHealthInfo_av_gps_get(this.swigCPtr, this);
    }

    public void setNo_gps(BigInteger bigInteger) {
        NaviBusinessJNI.GpsHealthInfo_no_gps_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getNo_gps() {
        return NaviBusinessJNI.GpsHealthInfo_no_gps_get(this.swigCPtr, this);
    }

    public void setAngle_gps(BigInteger bigInteger) {
        NaviBusinessJNI.GpsHealthInfo_angle_gps_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getAngle_gps() {
        return NaviBusinessJNI.GpsHealthInfo_angle_gps_get(this.swigCPtr, this);
    }

    public void setBack_gps(BigInteger bigInteger) {
        NaviBusinessJNI.GpsHealthInfo_back_gps_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getBack_gps() {
        return NaviBusinessJNI.GpsHealthInfo_back_gps_get(this.swigCPtr, this);
    }

    public GpsHealthInfo() {
        this(NaviBusinessJNI.new_GpsHealthInfo(), true);
    }
}
