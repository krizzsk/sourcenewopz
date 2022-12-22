package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class NaviLocation {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviLocation(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviLocation naviLocation) {
        if (naviLocation == null) {
            return 0;
        }
        return naviLocation.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviLocation(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLatLng(NaviLatLng naviLatLng) {
        NaviBusinessJNI.NaviLocation_latLng_set(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng getLatLng() {
        long NaviLocation_latLng_get = NaviBusinessJNI.NaviLocation_latLng_get(this.swigCPtr, this);
        if (NaviLocation_latLng_get == 0) {
            return null;
        }
        return new NaviLatLng(NaviLocation_latLng_get, false);
    }

    public void setAngle(float f) {
        NaviBusinessJNI.NaviLocation_angle_set(this.swigCPtr, this, f);
    }

    public float getAngle() {
        return NaviBusinessJNI.NaviLocation_angle_get(this.swigCPtr, this);
    }

    public void setAccuracy(float f) {
        NaviBusinessJNI.NaviLocation_accuracy_set(this.swigCPtr, this, f);
    }

    public float getAccuracy() {
        return NaviBusinessJNI.NaviLocation_accuracy_get(this.swigCPtr, this);
    }

    public void setVelocity(float f) {
        NaviBusinessJNI.NaviLocation_velocity_set(this.swigCPtr, this, f);
    }

    public float getVelocity() {
        return NaviBusinessJNI.NaviLocation_velocity_get(this.swigCPtr, this);
    }

    public void setFlpBearing(float f) {
        NaviBusinessJNI.NaviLocation_flpBearing_set(this.swigCPtr, this, f);
    }

    public float getFlpBearing() {
        return NaviBusinessJNI.NaviLocation_flpBearing_get(this.swigCPtr, this);
    }

    public void setFlpConfidence(float f) {
        NaviBusinessJNI.NaviLocation_flpConfidence_set(this.swigCPtr, this, f);
    }

    public float getFlpConfidence() {
        return NaviBusinessJNI.NaviLocation_flpConfidence_get(this.swigCPtr, this);
    }

    public void setFlpStatus(int i) {
        NaviBusinessJNI.NaviLocation_flpStatus_set(this.swigCPtr, this, i);
    }

    public int getFlpStatus() {
        return NaviBusinessJNI.NaviLocation_flpStatus_get(this.swigCPtr, this);
    }

    public void setNaviSource(int i) {
        NaviBusinessJNI.NaviLocation_naviSource_set(this.swigCPtr, this, i);
    }

    public int getNaviSource() {
        return NaviBusinessJNI.NaviLocation_naviSource_get(this.swigCPtr, this);
    }

    public void setGpsProvider(int i) {
        NaviBusinessJNI.NaviLocation_gpsProvider_set(this.swigCPtr, this, i);
    }

    public int getGpsProvider() {
        return NaviBusinessJNI.NaviLocation_gpsProvider_get(this.swigCPtr, this);
    }

    public void setVdrConf(int i) {
        NaviBusinessJNI.NaviLocation_vdrConf_set(this.swigCPtr, this, i);
    }

    public int getVdrConf() {
        return NaviBusinessJNI.NaviLocation_vdrConf_get(this.swigCPtr, this);
    }

    public void setFlpExt(String str) {
        NaviBusinessJNI.NaviLocation_flpExt_set(this.swigCPtr, this, str);
    }

    public String getFlpExt() {
        return NaviBusinessJNI.NaviLocation_flpExt_get(this.swigCPtr, this);
    }

    public void setSatellitesNum(int i) {
        NaviBusinessJNI.NaviLocation_satellitesNum_set(this.swigCPtr, this, i);
    }

    public int getSatellitesNum() {
        return NaviBusinessJNI.NaviLocation_satellitesNum_get(this.swigCPtr, this);
    }

    public void setGpsTime(BigInteger bigInteger) {
        NaviBusinessJNI.NaviLocation_gpsTime_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getGpsTime() {
        return NaviBusinessJNI.NaviLocation_gpsTime_get(this.swigCPtr, this);
    }

    public void setPhoneTime(BigInteger bigInteger) {
        NaviBusinessJNI.NaviLocation_phoneTime_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getPhoneTime() {
        return NaviBusinessJNI.NaviLocation_phoneTime_get(this.swigCPtr, this);
    }

    public void setGpsSource(String str) {
        NaviBusinessJNI.NaviLocation_gpsSource_set(this.swigCPtr, this, str);
    }

    public String getGpsSource() {
        return NaviBusinessJNI.NaviLocation_gpsSource_get(this.swigCPtr, this);
    }

    public NaviLocation() {
        this(NaviBusinessJNI.new_NaviLocation(), true);
    }
}
