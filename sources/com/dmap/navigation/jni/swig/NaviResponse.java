package com.dmap.navigation.jni.swig;

public class NaviResponse {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviResponse(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviResponse naviResponse) {
        if (naviResponse == null) {
            return 0;
        }
        return naviResponse.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviResponse(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setErrorCode(int i) {
        NaviBusinessJNI.NaviResponse_errorCode_set(this.swigCPtr, this, i);
    }

    public int getErrorCode() {
        return NaviBusinessJNI.NaviResponse_errorCode_get(this.swigCPtr, this);
    }

    public void setMandatory(boolean z) {
        NaviBusinessJNI.NaviResponse_mandatory_set(this.swigCPtr, this, z);
    }

    public boolean getMandatory() {
        return NaviBusinessJNI.NaviResponse_mandatory_get(this.swigCPtr, this);
    }

    public void setTrafficEvent(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        NaviBusinessJNI.NaviResponse_trafficEvent_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getTrafficEvent() {
        long NaviResponse_trafficEvent_get = NaviBusinessJNI.NaviResponse_trafficEvent_get(this.swigCPtr, this);
        if (NaviResponse_trafficEvent_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(NaviResponse_trafficEvent_get, false);
    }

    public void setTrafficEventSize(int i) {
        NaviBusinessJNI.NaviResponse_trafficEventSize_set(this.swigCPtr, this, i);
    }

    public int getTrafficEventSize() {
        return NaviBusinessJNI.NaviResponse_trafficEventSize_get(this.swigCPtr, this);
    }

    public void setExtendData(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        NaviBusinessJNI.NaviResponse_extendData_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getExtendData() {
        long NaviResponse_extendData_get = NaviBusinessJNI.NaviResponse_extendData_get(this.swigCPtr, this);
        if (NaviResponse_extendData_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(NaviResponse_extendData_get, false);
    }

    public void setExtendDataSize(int i) {
        NaviBusinessJNI.NaviResponse_extendDataSize_set(this.swigCPtr, this, i);
    }

    public int getExtendDataSize() {
        return NaviBusinessJNI.NaviResponse_extendDataSize_get(this.swigCPtr, this);
    }

    public void setRoutes(NaviRouteList naviRouteList) {
        NaviBusinessJNI.NaviResponse_routes_set(this.swigCPtr, this, NaviRouteList.getCPtr(naviRouteList), naviRouteList);
    }

    public NaviRouteList getRoutes() {
        long NaviResponse_routes_get = NaviBusinessJNI.NaviResponse_routes_get(this.swigCPtr, this);
        if (NaviResponse_routes_get == 0) {
            return null;
        }
        return new NaviRouteList(NaviResponse_routes_get, false);
    }

    public void setToastList(NaviToastInfoList naviToastInfoList) {
        NaviBusinessJNI.NaviResponse_toastList_set(this.swigCPtr, this, NaviToastInfoList.getCPtr(naviToastInfoList), naviToastInfoList);
    }

    public NaviToastInfoList getToastList() {
        long NaviResponse_toastList_get = NaviBusinessJNI.NaviResponse_toastList_get(this.swigCPtr, this);
        if (NaviResponse_toastList_get == 0) {
            return null;
        }
        return new NaviToastInfoList(NaviResponse_toastList_get, false);
    }

    public void setIsMultiRoute(int i) {
        NaviBusinessJNI.NaviResponse_isMultiRoute_set(this.swigCPtr, this, i);
    }

    public int getIsMultiRoute() {
        return NaviBusinessJNI.NaviResponse_isMultiRoute_get(this.swigCPtr, this);
    }

    public NaviResponse() {
        this(NaviBusinessJNI.new_NaviResponse(), true);
    }
}
