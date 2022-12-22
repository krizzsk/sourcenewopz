package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class TrafficResponse {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected TrafficResponse(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TrafficResponse trafficResponse) {
        if (trafficResponse == null) {
            return 0;
        }
        return trafficResponse.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_TrafficResponse(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setExpireTime(int i) {
        NaviBusinessJNI.TrafficResponse_expireTime_set(this.swigCPtr, this, i);
    }

    public int getExpireTime() {
        return NaviBusinessJNI.TrafficResponse_expireTime_get(this.swigCPtr, this);
    }

    public void setServerTimestamp(BigInteger bigInteger) {
        NaviBusinessJNI.TrafficResponse_serverTimestamp_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getServerTimestamp() {
        return NaviBusinessJNI.TrafficResponse_serverTimestamp_get(this.swigCPtr, this);
    }

    public void setTrafficEvent(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        NaviBusinessJNI.TrafficResponse_trafficEvent_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getTrafficEvent() {
        long TrafficResponse_trafficEvent_get = NaviBusinessJNI.TrafficResponse_trafficEvent_get(this.swigCPtr, this);
        if (TrafficResponse_trafficEvent_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(TrafficResponse_trafficEvent_get, false);
    }

    public void setTrafficEventSize(int i) {
        NaviBusinessJNI.TrafficResponse_trafficEventSize_set(this.swigCPtr, this, i);
    }

    public int getTrafficEventSize() {
        return NaviBusinessJNI.TrafficResponse_trafficEventSize_get(this.swigCPtr, this);
    }

    public void setExtendData(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        NaviBusinessJNI.TrafficResponse_extendData_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getExtendData() {
        long TrafficResponse_extendData_get = NaviBusinessJNI.TrafficResponse_extendData_get(this.swigCPtr, this);
        if (TrafficResponse_extendData_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(TrafficResponse_extendData_get, false);
    }

    public void setExtendDataSize(int i) {
        NaviBusinessJNI.TrafficResponse_extendDataSize_set(this.swigCPtr, this, i);
    }

    public int getExtendDataSize() {
        return NaviBusinessJNI.TrafficResponse_extendDataSize_get(this.swigCPtr, this);
    }

    public void setNaviEvents(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        NaviBusinessJNI.TrafficResponse_naviEvents_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getNaviEvents() {
        long TrafficResponse_naviEvents_get = NaviBusinessJNI.TrafficResponse_naviEvents_get(this.swigCPtr, this);
        if (TrafficResponse_naviEvents_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(TrafficResponse_naviEvents_get, false);
    }

    public void setNaviEventsSize(int i) {
        NaviBusinessJNI.TrafficResponse_naviEventsSize_set(this.swigCPtr, this, i);
    }

    public int getNaviEventsSize() {
        return NaviBusinessJNI.TrafficResponse_naviEventsSize_get(this.swigCPtr, this);
    }

    public void setTrafficIndexs(IntList intList) {
        NaviBusinessJNI.TrafficResponse_trafficIndexs_set(this.swigCPtr, this, IntList.getCPtr(intList), intList);
    }

    public IntList getTrafficIndexs() {
        long TrafficResponse_trafficIndexs_get = NaviBusinessJNI.TrafficResponse_trafficIndexs_get(this.swigCPtr, this);
        if (TrafficResponse_trafficIndexs_get == 0) {
            return null;
        }
        return new IntList(TrafficResponse_trafficIndexs_get, false);
    }

    public void setTrafficPoints(NaviLatLngList naviLatLngList) {
        NaviBusinessJNI.TrafficResponse_trafficPoints_set(this.swigCPtr, this, NaviLatLngList.getCPtr(naviLatLngList), naviLatLngList);
    }

    public NaviLatLngList getTrafficPoints() {
        long TrafficResponse_trafficPoints_get = NaviBusinessJNI.TrafficResponse_trafficPoints_get(this.swigCPtr, this);
        if (TrafficResponse_trafficPoints_get == 0) {
            return null;
        }
        return new NaviLatLngList(TrafficResponse_trafficPoints_get, false);
    }

    public void setEtas(IntList intList) {
        NaviBusinessJNI.TrafficResponse_etas_set(this.swigCPtr, this, IntList.getCPtr(intList), intList);
    }

    public IntList getEtas() {
        long TrafficResponse_etas_get = NaviBusinessJNI.TrafficResponse_etas_get(this.swigCPtr, this);
        if (TrafficResponse_etas_get == 0) {
            return null;
        }
        return new IntList(TrafficResponse_etas_get, false);
    }

    public TrafficResponse() {
        this(NaviBusinessJNI.new_TrafficResponse(), true);
    }
}
