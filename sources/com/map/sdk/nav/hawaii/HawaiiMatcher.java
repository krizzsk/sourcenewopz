package com.map.sdk.nav.hawaii;

import com.dmap.navigation.jni.swig.NaviBusinessBridge;
import com.dmap.navigation.jni.swig.RGGPSPoint_t;
import com.dmap.navigation.jni.swig.RGGeoPoint_tArray;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_ng_handle;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.MercatorUtil;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;

public class HawaiiMatcher {
    public static SWIGTYPE_p_ng_handle initHawaiiMatcher() {
        return NaviBusinessBridge.RG_DG_CreateHandler();
    }

    public static void destroyHawaiiMatcher(SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle) {
        NaviBusinessBridge.RG_DG_DestroyHandler(sWIGTYPE_p_ng_handle);
    }

    public static HawaiiMatchResult hawaiiMatch(SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle, RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        RGGPSPoint_t convertRouteGuidanceGPSPoint2RGGPSPoint_t = HawaiiConvertor.convertRouteGuidanceGPSPoint2RGGPSPoint_t(routeGuidanceGPSPoint);
        RGGPSPoint_t rGGPSPoint_t = new RGGPSPoint_t();
        boolean RG_DG_Match = NaviBusinessBridge.RG_DG_Match(sWIGTYPE_p_ng_handle, convertRouteGuidanceGPSPoint2RGGPSPoint_t, rGGPSPoint_t);
        RouteGuidanceGPSPoint convertRGGPSPoint_t2RouteGuidanceGPSPoint = HawaiiConvertor.convertRGGPSPoint_t2RouteGuidanceGPSPoint(rGGPSPoint_t);
        HawaiiMatchResult hawaiiMatchResult = new HawaiiMatchResult();
        hawaiiMatchResult.routeGuidanceGPSPoint = convertRGGPSPoint_t2RouteGuidanceGPSPoint;
        hawaiiMatchResult.isYaw = RG_DG_Match;
        return hawaiiMatchResult;
    }

    public static void setHawaiiRoutePoints(SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle, GeoPoint[] geoPointArr) {
        if (geoPointArr != null) {
            int length = geoPointArr.length;
            RGGeoPoint_tArray rGGeoPoint_tArray = new RGGeoPoint_tArray(length);
            for (int i = 0; i < length; i++) {
                rGGeoPoint_tArray.setitem(i, MercatorUtil.latLng2MercatorHawaii(((double) geoPointArr[i].getLongitudeE6()) / 1000000.0d, ((double) geoPointArr[i].getLatitudeE6()) / 1000000.0d));
            }
            NaviBusinessBridge.RG_DG_SetRoute(sWIGTYPE_p_ng_handle, rGGeoPoint_tArray.cast(), (long) geoPointArr.length);
        }
    }
}
