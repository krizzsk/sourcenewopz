package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class NaviEngine {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviEngine(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviEngine naviEngine) {
        if (naviEngine == null) {
            return 0;
        }
        return naviEngine.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviEngine(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviEngine(NaviEventCallback naviEventCallback, NaviGetter naviGetter) {
        this(NaviBusinessJNI.new_NaviEngine(NaviEventCallback.getCPtr(naviEventCallback), naviEventCallback, NaviGetter.getCPtr(naviGetter), naviGetter), true);
    }

    public void init(UserInfo userInfo, OrderInfo orderInfo, NaviOption naviOption) {
        NaviBusinessJNI.NaviEngine_init(this.swigCPtr, this, UserInfo.getCPtr(userInfo), userInfo, OrderInfo.getCPtr(orderInfo), orderInfo, NaviOption.getCPtr(naviOption), naviOption);
    }

    public void startNavi(NaviRoute naviRoute, NaviLocation naviLocation) {
        NaviBusinessJNI.NaviEngine_startNavi(this.swigCPtr, this, NaviRoute.getCPtr(naviRoute), naviRoute, NaviLocation.getCPtr(naviLocation), naviLocation);
    }

    public void stopNavi() {
        NaviBusinessJNI.NaviEngine_stopNavi(this.swigCPtr, this);
    }

    public void selectRoute(BigInteger bigInteger, boolean z) {
        NaviBusinessJNI.NaviEngine_selectRoute(this.swigCPtr, this, bigInteger, z);
    }

    public void updateLocation(NaviLocation naviLocation) {
        NaviBusinessJNI.NaviEngine_updateLocation(this.swigCPtr, this, NaviLocation.getCPtr(naviLocation), naviLocation);
    }

    public BigInteger getCurrentRouteId() {
        return NaviBusinessJNI.NaviEngine_getCurrentRouteId(this.swigCPtr, this);
    }

    public NaviRoute getRouteById(BigInteger bigInteger) {
        long NaviEngine_getRouteById = NaviBusinessJNI.NaviEngine_getRouteById(this.swigCPtr, this, bigInteger);
        if (NaviEngine_getRouteById == 0) {
            return null;
        }
        return new NaviRoute(NaviEngine_getRouteById, false);
    }

    public void addMoreRoutes(SWIGTYPE_p_void sWIGTYPE_p_void) {
        NaviBusinessJNI.NaviEngine_addMoreRoutes(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public void updateTrafficStatus(byte[] bArr, int i, int i2) {
        NaviBusinessJNI.NaviEngine_updateTrafficStatus(this.swigCPtr, this, bArr, i, i2);
    }

    public void updateTrafficEtas(int i, int[] iArr) {
        NaviBusinessJNI.NaviEngine_updateTrafficEtas(this.swigCPtr, this, i, iArr);
    }

    public void forcePassedNext() {
        NaviBusinessJNI.NaviEngine_forcePassedNext(this.swigCPtr, this);
    }

    public void playMannalVoice() {
        NaviBusinessJNI.NaviEngine_playMannalVoice(this.swigCPtr, this);
    }

    public void playOpenningVoice(NaviLocation naviLocation) {
        NaviBusinessJNI.NaviEngine_playOpenningVoice(this.swigCPtr, this, NaviLocation.getCPtr(naviLocation), naviLocation);
    }

    public void updateAppAction(int i) {
        NaviBusinessJNI.NaviEngine_updateAppAction(this.swigCPtr, this, i);
    }

    public String getNGVoiceContent(int i) {
        return NaviBusinessJNI.NaviEngine_getNGVoiceContent(this.swigCPtr, this, i);
    }

    public void setTrafficEventPoints(BigInteger bigInteger, TrafficEventPointList trafficEventPointList) {
        NaviBusinessJNI.NaviEngine_setTrafficEventPoints(this.swigCPtr, this, bigInteger, TrafficEventPointList.getCPtr(trafficEventPointList), trafficEventPointList);
    }

    public void changeNaviModel(int i) {
        NaviBusinessJNI.NaviEngine_changeNaviModel(this.swigCPtr, this, i);
    }

    public void setDayNight(boolean z) {
        NaviBusinessJNI.NaviEngine_setDayNight(this.swigCPtr, this, z);
    }

    public GpsHealthInfo getGpsHealthInfo() {
        return new GpsHealthInfo(NaviBusinessJNI.NaviEngine_getGpsHealthInfo(this.swigCPtr, this), true);
    }

    public void setVoiceAssistantState(int i) {
        NaviBusinessJNI.NaviEngine_setVoiceAssistantState(this.swigCPtr, this, i);
    }

    public void closeCurrentMJO() {
        NaviBusinessJNI.NaviEngine_closeCurrentMJO(this.swigCPtr, this);
    }

    public void setMJOEnable(boolean z) {
        NaviBusinessJNI.NaviEngine_setMJOEnable(this.swigCPtr, this, z);
    }

    public void updateNaviScene() {
        NaviBusinessJNI.NaviEngine_updateNaviScene(this.swigCPtr, this);
    }

    public void addSafeNotifyInfo(SafeNotifyInfo safeNotifyInfo) {
        NaviBusinessJNI.NaviEngine_addSafeNotifyInfo(this.swigCPtr, this, SafeNotifyInfo.getCPtr(safeNotifyInfo), safeNotifyInfo);
    }

    public MatchedRouteInfo getMatchedRouteInfo() {
        return new MatchedRouteInfo(NaviBusinessJNI.NaviEngine_getMatchedRouteInfo(this.swigCPtr, this), true);
    }

    public void setVecEnlargeInfo(int i, int i2) {
        NaviBusinessJNI.NaviEngine_setVecEnlargeInfo(this.swigCPtr, this, i, i2);
    }
}
