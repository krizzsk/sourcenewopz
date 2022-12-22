package com.dmap.navigation.jni.swig;

public class NaviInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviInfo naviInfo) {
        if (naviInfo == null) {
            return 0;
        }
        return naviInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setStart(NaviPoi naviPoi) {
        NaviBusinessJNI.NaviInfo_start_set(this.swigCPtr, this, NaviPoi.getCPtr(naviPoi), naviPoi);
    }

    public NaviPoi getStart() {
        long NaviInfo_start_get = NaviBusinessJNI.NaviInfo_start_get(this.swigCPtr, this);
        if (NaviInfo_start_get == 0) {
            return null;
        }
        return new NaviPoi(NaviInfo_start_get, false);
    }

    public void setEnd(NaviPoi naviPoi) {
        NaviBusinessJNI.NaviInfo_end_set(this.swigCPtr, this, NaviPoi.getCPtr(naviPoi), naviPoi);
    }

    public NaviPoi getEnd() {
        long NaviInfo_end_get = NaviBusinessJNI.NaviInfo_end_get(this.swigCPtr, this);
        if (NaviInfo_end_get == 0) {
            return null;
        }
        return new NaviPoi(NaviInfo_end_get, false);
    }

    public void setPassPoints(NaviPoiList naviPoiList) {
        NaviBusinessJNI.NaviInfo_passPoints_set(this.swigCPtr, this, NaviPoiList.getCPtr(naviPoiList), naviPoiList);
    }

    public NaviPoiList getPassPoints() {
        long NaviInfo_passPoints_get = NaviBusinessJNI.NaviInfo_passPoints_get(this.swigCPtr, this);
        if (NaviInfo_passPoints_get == 0) {
            return null;
        }
        return new NaviPoiList(NaviInfo_passPoints_get, false);
    }

    public void setCurrentBindPoint(BindNaviLocation bindNaviLocation) {
        NaviBusinessJNI.NaviInfo_currentBindPoint_set(this.swigCPtr, this, BindNaviLocation.getCPtr(bindNaviLocation), bindNaviLocation);
    }

    public BindNaviLocation getCurrentBindPoint() {
        long NaviInfo_currentBindPoint_get = NaviBusinessJNI.NaviInfo_currentBindPoint_get(this.swigCPtr, this);
        if (NaviInfo_currentBindPoint_get == 0) {
            return null;
        }
        return new BindNaviLocation(NaviInfo_currentBindPoint_get, false);
    }

    public void setLastBindPoint(BindNaviLocation bindNaviLocation) {
        NaviBusinessJNI.NaviInfo_lastBindPoint_set(this.swigCPtr, this, BindNaviLocation.getCPtr(bindNaviLocation), bindNaviLocation);
    }

    public BindNaviLocation getLastBindPoint() {
        long NaviInfo_lastBindPoint_get = NaviBusinessJNI.NaviInfo_lastBindPoint_get(this.swigCPtr, this);
        if (NaviInfo_lastBindPoint_get == 0) {
            return null;
        }
        return new BindNaviLocation(NaviInfo_lastBindPoint_get, false);
    }

    public void setLastGpsPoint(NaviLocation naviLocation) {
        NaviBusinessJNI.NaviInfo_lastGpsPoint_set(this.swigCPtr, this, NaviLocation.getCPtr(naviLocation), naviLocation);
    }

    public NaviLocation getLastGpsPoint() {
        long NaviInfo_lastGpsPoint_get = NaviBusinessJNI.NaviInfo_lastGpsPoint_get(this.swigCPtr, this);
        if (NaviInfo_lastGpsPoint_get == 0) {
            return null;
        }
        return new NaviLocation(NaviInfo_lastGpsPoint_get, false);
    }

    public void setEventType(int i) {
        NaviBusinessJNI.NaviInfo_eventType_set(this.swigCPtr, this, i);
    }

    public int getEventType() {
        return NaviBusinessJNI.NaviInfo_eventType_get(this.swigCPtr, this);
    }

    public void setYawType(int i) {
        NaviBusinessJNI.NaviInfo_yawType_set(this.swigCPtr, this, i);
    }

    public int getYawType() {
        return NaviBusinessJNI.NaviInfo_yawType_get(this.swigCPtr, this);
    }

    public void setCurrentRoute(ReqRouteInfo reqRouteInfo) {
        NaviBusinessJNI.NaviInfo_currentRoute_set(this.swigCPtr, this, ReqRouteInfo.getCPtr(reqRouteInfo), reqRouteInfo);
    }

    public ReqRouteInfo getCurrentRoute() {
        long NaviInfo_currentRoute_get = NaviBusinessJNI.NaviInfo_currentRoute_get(this.swigCPtr, this);
        if (NaviInfo_currentRoute_get == 0) {
            return null;
        }
        return new ReqRouteInfo(NaviInfo_currentRoute_get, false);
    }

    public void setHistoryPoints(NaviLocationList naviLocationList) {
        NaviBusinessJNI.NaviInfo_historyPoints_set(this.swigCPtr, this, NaviLocationList.getCPtr(naviLocationList), naviLocationList);
    }

    public NaviLocationList getHistoryPoints() {
        long NaviInfo_historyPoints_get = NaviBusinessJNI.NaviInfo_historyPoints_get(this.swigCPtr, this);
        if (NaviInfo_historyPoints_get == 0) {
            return null;
        }
        return new NaviLocationList(NaviInfo_historyPoints_get, false);
    }

    public void setNaviModel(int i) {
        NaviBusinessJNI.NaviInfo_naviModel_set(this.swigCPtr, this, i);
    }

    public int getNaviModel() {
        return NaviBusinessJNI.NaviInfo_naviModel_get(this.swigCPtr, this);
    }

    public NaviInfo() {
        this(NaviBusinessJNI.new_NaviInfo(), true);
    }
}
