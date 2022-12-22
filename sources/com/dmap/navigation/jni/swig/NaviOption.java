package com.dmap.navigation.jni.swig;

public class NaviOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviOption naviOption) {
        if (naviOption == null) {
            return 0;
        }
        return naviOption.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviOption(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setCameraDisplay(int i) {
        NaviBusinessJNI.NaviOption_cameraDisplay_set(this.swigCPtr, this, i);
    }

    public int getCameraDisplay() {
        return NaviBusinessJNI.NaviOption_cameraDisplay_get(this.swigCPtr, this);
    }

    public void setDiaUpgrade(int i) {
        NaviBusinessJNI.NaviOption_diaUpgrade_set(this.swigCPtr, this, i);
    }

    public int getDiaUpgrade() {
        return NaviBusinessJNI.NaviOption_diaUpgrade_get(this.swigCPtr, this);
    }

    public void setFbRoadName(int i) {
        NaviBusinessJNI.NaviOption_fbRoadName_set(this.swigCPtr, this, i);
    }

    public int getFbRoadName() {
        return NaviBusinessJNI.NaviOption_fbRoadName_get(this.swigCPtr, this);
    }

    public void setFishbone(int i) {
        NaviBusinessJNI.NaviOption_fishbone_set(this.swigCPtr, this, i);
    }

    public int getFishbone() {
        return NaviBusinessJNI.NaviOption_fishbone_get(this.swigCPtr, this);
    }

    public void setMultiRouteEnable(boolean z) {
        NaviBusinessJNI.NaviOption_multiRouteEnable_set(this.swigCPtr, this, z);
    }

    public boolean getMultiRouteEnable() {
        return NaviBusinessJNI.NaviOption_multiRouteEnable_get(this.swigCPtr, this);
    }

    public void setNgFlag(int i) {
        NaviBusinessJNI.NaviOption_ngFlag_set(this.swigCPtr, this, i);
    }

    public int getNgFlag() {
        return NaviBusinessJNI.NaviOption_ngFlag_get(this.swigCPtr, this);
    }

    public void setNgVersion(int i) {
        NaviBusinessJNI.NaviOption_ngVersion_set(this.swigCPtr, this, i);
    }

    public int getNgVersion() {
        return NaviBusinessJNI.NaviOption_ngVersion_get(this.swigCPtr, this);
    }

    public void setVector(int i) {
        NaviBusinessJNI.NaviOption_vector_set(this.swigCPtr, this, i);
    }

    public int getVector() {
        return NaviBusinessJNI.NaviOption_vector_get(this.swigCPtr, this);
    }

    public void setNeedTraffic(boolean z) {
        NaviBusinessJNI.NaviOption_needTraffic_set(this.swigCPtr, this, z);
    }

    public boolean getNeedTraffic() {
        return NaviBusinessJNI.NaviOption_needTraffic_get(this.swigCPtr, this);
    }

    public void setNeedTrafficEvent(boolean z) {
        NaviBusinessJNI.NaviOption_needTrafficEvent_set(this.swigCPtr, this, z);
    }

    public boolean getNeedTrafficEvent() {
        return NaviBusinessJNI.NaviOption_needTrafficEvent_get(this.swigCPtr, this);
    }

    public void setNeedmjo(boolean z) {
        NaviBusinessJNI.NaviOption_needmjo_set(this.swigCPtr, this, z);
    }

    public boolean getNeedmjo() {
        return NaviBusinessJNI.NaviOption_needmjo_get(this.swigCPtr, this);
    }

    public void setNeedmission(boolean z) {
        NaviBusinessJNI.NaviOption_needmission_set(this.swigCPtr, this, z);
    }

    public boolean getNeedmission() {
        return NaviBusinessJNI.NaviOption_needmission_get(this.swigCPtr, this);
    }

    public void setYawVersion(int i) {
        NaviBusinessJNI.NaviOption_yawVersion_set(this.swigCPtr, this, i);
    }

    public int getYawVersion() {
        return NaviBusinessJNI.NaviOption_yawVersion_get(this.swigCPtr, this);
    }

    public void setDispatchId(String str) {
        NaviBusinessJNI.NaviOption_dispatchId_set(this.swigCPtr, this, str);
    }

    public String getDispatchId() {
        return NaviBusinessJNI.NaviOption_dispatchId_get(this.swigCPtr, this);
    }

    public void setDispatchType(int i) {
        NaviBusinessJNI.NaviOption_dispatchType_set(this.swigCPtr, this, i);
    }

    public int getDispatchType() {
        return NaviBusinessJNI.NaviOption_dispatchType_get(this.swigCPtr, this);
    }

    public void setScene(int i) {
        NaviBusinessJNI.NaviOption_scene_set(this.swigCPtr, this, i);
    }

    public int getScene() {
        return NaviBusinessJNI.NaviOption_scene_get(this.swigCPtr, this);
    }

    public void setAutoStartNavi(boolean z) {
        NaviBusinessJNI.NaviOption_autoStartNavi_set(this.swigCPtr, this, z);
    }

    public boolean getAutoStartNavi() {
        return NaviBusinessJNI.NaviOption_autoStartNavi_get(this.swigCPtr, this);
    }

    public void setNaviEngine(String str) {
        NaviBusinessJNI.NaviOption_naviEngine_set(this.swigCPtr, this, str);
    }

    public String getNaviEngine() {
        return NaviBusinessJNI.NaviOption_naviEngine_get(this.swigCPtr, this);
    }

    public void setNoNeedRainbow(boolean z) {
        NaviBusinessJNI.NaviOption_noNeedRainbow_set(this.swigCPtr, this, z);
    }

    public boolean getNoNeedRainbow() {
        return NaviBusinessJNI.NaviOption_noNeedRainbow_get(this.swigCPtr, this);
    }

    public void setNaviRouteStrategy(NaviRouteStrategy naviRouteStrategy) {
        NaviBusinessJNI.NaviOption_naviRouteStrategy_set(this.swigCPtr, this, NaviRouteStrategy.getCPtr(naviRouteStrategy), naviRouteStrategy);
    }

    public NaviRouteStrategy getNaviRouteStrategy() {
        long NaviOption_naviRouteStrategy_get = NaviBusinessJNI.NaviOption_naviRouteStrategy_get(this.swigCPtr, this);
        if (NaviOption_naviRouteStrategy_get == 0) {
            return null;
        }
        return new NaviRouteStrategy(NaviOption_naviRouteStrategy_get, false);
    }

    public void setAvoidJamType(int i) {
        NaviBusinessJNI.NaviOption_avoidJamType_set(this.swigCPtr, this, i);
    }

    public int getAvoidJamType() {
        return NaviBusinessJNI.NaviOption_avoidJamType_get(this.swigCPtr, this);
    }

    public void setMapVersion(String str) {
        NaviBusinessJNI.NaviOption_mapVersion_set(this.swigCPtr, this, str);
    }

    public String getMapVersion() {
        return NaviBusinessJNI.NaviOption_mapVersion_get(this.swigCPtr, this);
    }

    public void setPassNavMode(int i) {
        NaviBusinessJNI.NaviOption_passNavMode_set(this.swigCPtr, this, i);
    }

    public int getPassNavMode() {
        return NaviBusinessJNI.NaviOption_passNavMode_get(this.swigCPtr, this);
    }

    public void setDynamicRouteEnable(boolean z) {
        NaviBusinessJNI.NaviOption_dynamicRouteEnable_set(this.swigCPtr, this, z);
    }

    public boolean getDynamicRouteEnable() {
        return NaviBusinessJNI.NaviOption_dynamicRouteEnable_get(this.swigCPtr, this);
    }

    public void setRestrictToastEnable(boolean z) {
        NaviBusinessJNI.NaviOption_restrictToastEnable_set(this.swigCPtr, this, z);
    }

    public boolean getRestrictToastEnable() {
        return NaviBusinessJNI.NaviOption_restrictToastEnable_get(this.swigCPtr, this);
    }

    public void setNaviMode(int i) {
        NaviBusinessJNI.NaviOption_naviMode_set(this.swigCPtr, this, i);
    }

    public int getNaviMode() {
        return NaviBusinessJNI.NaviOption_naviMode_get(this.swigCPtr, this);
    }

    public void setIsForceYaw(boolean z) {
        NaviBusinessJNI.NaviOption_isForceYaw_set(this.swigCPtr, this, z);
    }

    public boolean getIsForceYaw() {
        return NaviBusinessJNI.NaviOption_isForceYaw_get(this.swigCPtr, this);
    }

    public void setConfidenceHigh(int i) {
        NaviBusinessJNI.NaviOption_confidenceHigh_set(this.swigCPtr, this, i);
    }

    public int getConfidenceHigh() {
        return NaviBusinessJNI.NaviOption_confidenceHigh_get(this.swigCPtr, this);
    }

    public void setConfidenceLow(int i) {
        NaviBusinessJNI.NaviOption_confidenceLow_set(this.swigCPtr, this, i);
    }

    public int getConfidenceLow() {
        return NaviBusinessJNI.NaviOption_confidenceLow_get(this.swigCPtr, this);
    }

    public void setLanguage(int i) {
        NaviBusinessJNI.NaviOption_language_set(this.swigCPtr, this, i);
    }

    public int getLanguage() {
        return NaviBusinessJNI.NaviOption_language_get(this.swigCPtr, this);
    }

    public NaviOption() {
        this(NaviBusinessJNI.new_NaviOption(), true);
    }
}
