package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class NaviRoute {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRoute(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRoute naviRoute) {
        if (naviRoute == null) {
            return 0;
        }
        return naviRoute.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRoute(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setPbHandle(SWIGTYPE_p_void sWIGTYPE_p_void) {
        NaviBusinessJNI.NaviRoute_pbHandle_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getPbHandle() {
        long NaviRoute_pbHandle_get = NaviBusinessJNI.NaviRoute_pbHandle_get(this.swigCPtr, this);
        if (NaviRoute_pbHandle_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(NaviRoute_pbHandle_get, false);
    }

    public void setReqEventType(int i) {
        NaviBusinessJNI.NaviRoute_reqEventType_set(this.swigCPtr, this, i);
    }

    public int getReqEventType() {
        return NaviBusinessJNI.NaviRoute_reqEventType_get(this.swigCPtr, this);
    }

    public void setRouteId(BigInteger bigInteger) {
        NaviBusinessJNI.NaviRoute_routeId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getRouteId() {
        return NaviBusinessJNI.NaviRoute_routeId_get(this.swigCPtr, this);
    }

    public void setTotalDistance(int i) {
        NaviBusinessJNI.NaviRoute_totalDistance_set(this.swigCPtr, this, i);
    }

    public int getTotalDistance() {
        return NaviBusinessJNI.NaviRoute_totalDistance_get(this.swigCPtr, this);
    }

    public void setTotalTime(int i) {
        NaviBusinessJNI.NaviRoute_totalTime_set(this.swigCPtr, this, i);
    }

    public int getTotalTime() {
        return NaviBusinessJNI.NaviRoute_totalTime_get(this.swigCPtr, this);
    }

    public void setLightCount(int i) {
        NaviBusinessJNI.NaviRoute_lightCount_set(this.swigCPtr, this, i);
    }

    public int getLightCount() {
        return NaviBusinessJNI.NaviRoute_lightCount_get(this.swigCPtr, this);
    }

    public void setPoints(NaviLatLngList naviLatLngList) {
        NaviBusinessJNI.NaviRoute_points_set(this.swigCPtr, this, NaviLatLngList.getCPtr(naviLatLngList), naviLatLngList);
    }

    public NaviLatLngList getPoints() {
        long NaviRoute_points_get = NaviBusinessJNI.NaviRoute_points_get(this.swigCPtr, this);
        if (NaviRoute_points_get == 0) {
            return null;
        }
        return new NaviLatLngList(NaviRoute_points_get, false);
    }

    public void setTrafficIndexs(IntList intList) {
        NaviBusinessJNI.NaviRoute_trafficIndexs_set(this.swigCPtr, this, IntList.getCPtr(intList), intList);
    }

    public IntList getTrafficIndexs() {
        long NaviRoute_trafficIndexs_get = NaviBusinessJNI.NaviRoute_trafficIndexs_get(this.swigCPtr, this);
        if (NaviRoute_trafficIndexs_get == 0) {
            return null;
        }
        return new IntList(NaviRoute_trafficIndexs_get, false);
    }

    public void setTrafficPoints(NaviLatLngList naviLatLngList) {
        NaviBusinessJNI.NaviRoute_trafficPoints_set(this.swigCPtr, this, NaviLatLngList.getCPtr(naviLatLngList), naviLatLngList);
    }

    public NaviLatLngList getTrafficPoints() {
        long NaviRoute_trafficPoints_get = NaviBusinessJNI.NaviRoute_trafficPoints_get(this.swigCPtr, this);
        if (NaviRoute_trafficPoints_get == 0) {
            return null;
        }
        return new NaviLatLngList(NaviRoute_trafficPoints_get, false);
    }

    public void setPassPoints(PassPointList passPointList) {
        NaviBusinessJNI.NaviRoute_passPoints_set(this.swigCPtr, this, PassPointList.getCPtr(passPointList), passPointList);
    }

    public PassPointList getPassPoints() {
        long NaviRoute_passPoints_get = NaviBusinessJNI.NaviRoute_passPoints_get(this.swigCPtr, this);
        if (NaviRoute_passPoints_get == 0) {
            return null;
        }
        return new PassPointList(NaviRoute_passPoints_get, false);
    }

    public void setLights(NaviLatLngList naviLatLngList) {
        NaviBusinessJNI.NaviRoute_lights_set(this.swigCPtr, this, NaviLatLngList.getCPtr(naviLatLngList), naviLatLngList);
    }

    public NaviLatLngList getLights() {
        long NaviRoute_lights_get = NaviBusinessJNI.NaviRoute_lights_get(this.swigCPtr, this);
        if (NaviRoute_lights_get == 0) {
            return null;
        }
        return new NaviLatLngList(NaviRoute_lights_get, false);
    }

    public void setConfidence(double d) {
        NaviBusinessJNI.NaviRoute_confidence_set(this.swigCPtr, this, d);
    }

    public double getConfidence() {
        return NaviBusinessJNI.NaviRoute_confidence_get(this.swigCPtr, this);
    }

    public void setStart(NaviPoi naviPoi) {
        NaviBusinessJNI.NaviRoute_start_set(this.swigCPtr, this, NaviPoi.getCPtr(naviPoi), naviPoi);
    }

    public NaviPoi getStart() {
        long NaviRoute_start_get = NaviBusinessJNI.NaviRoute_start_get(this.swigCPtr, this);
        if (NaviRoute_start_get == 0) {
            return null;
        }
        return new NaviPoi(NaviRoute_start_get, false);
    }

    public void setEnd(NaviPoi naviPoi) {
        NaviBusinessJNI.NaviRoute_end_set(this.swigCPtr, this, NaviPoi.getCPtr(naviPoi), naviPoi);
    }

    public NaviPoi getEnd() {
        long NaviRoute_end_get = NaviBusinessJNI.NaviRoute_end_get(this.swigCPtr, this);
        if (NaviRoute_end_get == 0) {
            return null;
        }
        return new NaviPoi(NaviRoute_end_get, false);
    }

    public void setOriginalPassPoints(NaviPoiList naviPoiList) {
        NaviBusinessJNI.NaviRoute_originalPassPoints_set(this.swigCPtr, this, NaviPoiList.getCPtr(naviPoiList), naviPoiList);
    }

    public NaviPoiList getOriginalPassPoints() {
        long NaviRoute_originalPassPoints_get = NaviBusinessJNI.NaviRoute_originalPassPoints_get(this.swigCPtr, this);
        if (NaviRoute_originalPassPoints_get == 0) {
            return null;
        }
        return new NaviPoiList(NaviRoute_originalPassPoints_get, false);
    }

    public void setTagsMap(NaviRouteTagMap naviRouteTagMap) {
        NaviBusinessJNI.NaviRoute_tagsMap_set(this.swigCPtr, this, NaviRouteTagMap.getCPtr(naviRouteTagMap), naviRouteTagMap);
    }

    public NaviRouteTagMap getTagsMap() {
        long NaviRoute_tagsMap_get = NaviBusinessJNI.NaviRoute_tagsMap_get(this.swigCPtr, this);
        if (NaviRoute_tagsMap_get == 0) {
            return null;
        }
        return new NaviRouteTagMap(NaviRoute_tagsMap_get, false);
    }

    public void setTagsList(NaviRouteTagList naviRouteTagList) {
        NaviBusinessJNI.NaviRoute_tagsList_set(this.swigCPtr, this, NaviRouteTagList.getCPtr(naviRouteTagList), naviRouteTagList);
    }

    public NaviRouteTagList getTagsList() {
        long NaviRoute_tagsList_get = NaviBusinessJNI.NaviRoute_tagsList_get(this.swigCPtr, this);
        if (NaviRoute_tagsList_get == 0) {
            return null;
        }
        return new NaviRouteTagList(NaviRoute_tagsList_get, false);
    }

    public void setRouteCnt(int i) {
        NaviBusinessJNI.NaviRoute_routeCnt_set(this.swigCPtr, this, i);
    }

    public int getRouteCnt() {
        return NaviBusinessJNI.NaviRoute_routeCnt_get(this.swigCPtr, this);
    }

    public void setRoadNames(NaviRoadNameList naviRoadNameList) {
        NaviBusinessJNI.NaviRoute_roadNames_set(this.swigCPtr, this, NaviRoadNameList.getCPtr(naviRoadNameList), naviRoadNameList);
    }

    public NaviRoadNameList getRoadNames() {
        long NaviRoute_roadNames_get = NaviBusinessJNI.NaviRoute_roadNames_get(this.swigCPtr, this);
        if (NaviRoute_roadNames_get == 0) {
            return null;
        }
        return new NaviRoadNameList(NaviRoute_roadNames_get, false);
    }

    public void setFishboneRoadNames(NaviRoadNameList naviRoadNameList) {
        NaviBusinessJNI.NaviRoute_fishboneRoadNames_set(this.swigCPtr, this, NaviRoadNameList.getCPtr(naviRoadNameList), naviRoadNameList);
    }

    public NaviRoadNameList getFishboneRoadNames() {
        long NaviRoute_fishboneRoadNames_get = NaviBusinessJNI.NaviRoute_fishboneRoadNames_get(this.swigCPtr, this);
        if (NaviRoute_fishboneRoadNames_get == 0) {
            return null;
        }
        return new NaviRoadNameList(NaviRoute_fishboneRoadNames_get, false);
    }

    public void setHasMjoEvent(boolean z) {
        NaviBusinessJNI.NaviRoute_hasMjoEvent_set(this.swigCPtr, this, z);
    }

    public boolean getHasMjoEvent() {
        return NaviBusinessJNI.NaviRoute_hasMjoEvent_get(this.swigCPtr, this);
    }

    public void setPassEtasList(IntList intList) {
        NaviBusinessJNI.NaviRoute_passEtasList_set(this.swigCPtr, this, IntList.getCPtr(intList), intList);
    }

    public IntList getPassEtasList() {
        long NaviRoute_passEtasList_get = NaviBusinessJNI.NaviRoute_passEtasList_get(this.swigCPtr, this);
        if (NaviRoute_passEtasList_get == 0) {
            return null;
        }
        return new IntList(NaviRoute_passEtasList_get, false);
    }

    public void setPassEdasList(IntList intList) {
        NaviBusinessJNI.NaviRoute_passEdasList_set(this.swigCPtr, this, IntList.getCPtr(intList), intList);
    }

    public IntList getPassEdasList() {
        long NaviRoute_passEdasList_get = NaviBusinessJNI.NaviRoute_passEdasList_get(this.swigCPtr, this);
        if (NaviRoute_passEdasList_get == 0) {
            return null;
        }
        return new IntList(NaviRoute_passEdasList_get, false);
    }

    public void setTunnelGeoPointList(TunnelGeoPointList tunnelGeoPointList) {
        NaviBusinessJNI.NaviRoute_tunnelGeoPointList_set(this.swigCPtr, this, TunnelGeoPointList.getCPtr(tunnelGeoPointList), tunnelGeoPointList);
    }

    public TunnelGeoPointList getTunnelGeoPointList() {
        long NaviRoute_tunnelGeoPointList_get = NaviBusinessJNI.NaviRoute_tunnelGeoPointList_get(this.swigCPtr, this);
        if (NaviRoute_tunnelGeoPointList_get == 0) {
            return null;
        }
        return new TunnelGeoPointList(NaviRoute_tunnelGeoPointList_get, false);
    }

    public void setMjoLinkList(NaviMJOLinkInfoList naviMJOLinkInfoList) {
        NaviBusinessJNI.NaviRoute_mjoLinkList_set(this.swigCPtr, this, NaviMJOLinkInfoList.getCPtr(naviMJOLinkInfoList), naviMJOLinkInfoList);
    }

    public NaviMJOLinkInfoList getMjoLinkList() {
        long NaviRoute_mjoLinkList_get = NaviBusinessJNI.NaviRoute_mjoLinkList_get(this.swigCPtr, this);
        if (NaviRoute_mjoLinkList_get == 0) {
            return null;
        }
        return new NaviMJOLinkInfoList(NaviRoute_mjoLinkList_get, false);
    }

    public void setSavingTime(int i) {
        NaviBusinessJNI.NaviRoute_savingTime_set(this.swigCPtr, this, i);
    }

    public int getSavingTime() {
        return NaviBusinessJNI.NaviRoute_savingTime_get(this.swigCPtr, this);
    }

    public void setJamCost(int i) {
        NaviBusinessJNI.NaviRoute_jamCost_set(this.swigCPtr, this, i);
    }

    public int getJamCost() {
        return NaviBusinessJNI.NaviRoute_jamCost_get(this.swigCPtr, this);
    }

    public void setSections(MarkerSectionList markerSectionList) {
        NaviBusinessJNI.NaviRoute_sections_set(this.swigCPtr, this, MarkerSectionList.getCPtr(markerSectionList), markerSectionList);
    }

    public MarkerSectionList getSections() {
        long NaviRoute_sections_get = NaviBusinessJNI.NaviRoute_sections_get(this.swigCPtr, this);
        if (NaviRoute_sections_get == 0) {
            return null;
        }
        return new MarkerSectionList(NaviRoute_sections_get, false);
    }

    public NaviRoute() {
        this(NaviBusinessJNI.new_NaviRoute(), true);
    }
}
