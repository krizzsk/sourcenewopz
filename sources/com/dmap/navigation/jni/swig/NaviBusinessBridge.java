package com.dmap.navigation.jni.swig;

public final class NaviBusinessBridge {
    public static void LogJavaInit() {
        NaviBusinessJNI.LogJavaInit();
    }

    public static void ApolloInit() {
        NaviBusinessJNI.ApolloInit();
    }

    public static void SetApolloCallBack(long j) {
        NaviBusinessJNI.SetApolloCallBack(j);
    }

    public static void setUseStatisticMalloc(boolean z, int i, int i2) {
        NaviBusinessJNI.setUseStatisticMalloc(z, i, i2);
    }

    public static String getBASE_URL() {
        return NaviBusinessJNI.BASE_URL_get();
    }

    public static int getAPI_FIRST_ROUTE() {
        return NaviBusinessJNI.API_FIRST_ROUTE_get();
    }

    public static int getAPI_YAW_ROUTE() {
        return NaviBusinessJNI.API_YAW_ROUTE_get();
    }

    public static int getAPI_DRIVER_CHANGED_DESTINATION() {
        return NaviBusinessJNI.API_DRIVER_CHANGED_DESTINATION_get();
    }

    public static int getAPI_PASSENGER_CHANGED_DESTINATION() {
        return NaviBusinessJNI.API_PASSENGER_CHANGED_DESTINATION_get();
    }

    public static int getAPI_ARRIVED_DESTINATION() {
        return NaviBusinessJNI.API_ARRIVED_DESTINATION_get();
    }

    public static int getAPI_MULTI_ROUTE() {
        return NaviBusinessJNI.API_MULTI_ROUTE_get();
    }

    public static int getAPI_PARALLEL_ROUTE() {
        return NaviBusinessJNI.API_PARALLEL_ROUTE_get();
    }

    public static int getAPI_SYNC_PASSENGER_ROUTE() {
        return NaviBusinessJNI.API_SYNC_PASSENGER_ROUTE_get();
    }

    public static int getAPI_ELEVATED_ROUTE() {
        return NaviBusinessJNI.API_ELEVATED_ROUTE_get();
    }

    public static int getAPI_EXTREME_SPEED_ROUTE() {
        return NaviBusinessJNI.API_EXTREME_SPEED_ROUTE_get();
    }

    public static int getAPI_PREFERENCE_ROUTE() {
        return NaviBusinessJNI.API_PREFERENCE_ROUTE_get();
    }

    public static int getSCENE_NORMAL() {
        return NaviBusinessJNI.SCENE_NORMAL_get();
    }

    public static int getSCENE_NORMAL_NONE() {
        return NaviBusinessJNI.SCENE_NORMAL_NONE_get();
    }

    public static int getSCENE_NORMAL_HEAT() {
        return NaviBusinessJNI.SCENE_NORMAL_HEAT_get();
    }

    public static int getSCENE_NORMAL_MARKET() {
        return NaviBusinessJNI.SCENE_NORMAL_MARKET_get();
    }

    public static int getSCENE_NORMAL_ORDERCARD() {
        return NaviBusinessJNI.SCENE_NORMAL_ORDERCARD_get();
    }

    public static int getSCENE_NORMAL_TOHOTAREA() {
        return NaviBusinessJNI.SCENE_NORMAL_TOHOTAREA_get();
    }

    public static int getSCENE_NORMAL_X() {
        return NaviBusinessJNI.SCENE_NORMAL_X_get();
    }

    public static int getSCENE_NORMAL_NORMAL() {
        return NaviBusinessJNI.SCENE_NORMAL_NORMAL_get();
    }

    public static int getSCENE_NORMAL_NORMAL_PSG() {
        return NaviBusinessJNI.SCENE_NORMAL_NORMAL_PSG_get();
    }

    public static int getSCENE_NORMAL_NORMAL_RAPID_PSG() {
        return NaviBusinessJNI.SCENE_NORMAL_NORMAL_RAPID_PSG_get();
    }

    public static int getNAVI_MODEL_LIGHT() {
        return NaviBusinessJNI.NAVI_MODEL_LIGHT_get();
    }

    public static int getNAVI_MODEL_FULL() {
        return NaviBusinessJNI.NAVI_MODEL_FULL_get();
    }

    public static int getNAVI_MODEL_PLAN() {
        return NaviBusinessJNI.NAVI_MODEL_PLAN_get();
    }

    public static int getERROR_EXPIRED_REQUEST() {
        return NaviBusinessJNI.ERROR_EXPIRED_REQUEST_get();
    }

    public static int getERROR_QUERY_TIMEOUT() {
        return NaviBusinessJNI.ERROR_QUERY_TIMEOUT_get();
    }

    public static int getERROR_QUERY_PARSE_FAILED() {
        return NaviBusinessJNI.ERROR_QUERY_PARSE_FAILED_get();
    }

    public static int getERROR_REQ_BODY_LEN_ERROR() {
        return NaviBusinessJNI.ERROR_REQ_BODY_LEN_ERROR_get();
    }

    public static int getERROR_REQ_UNMARSHAL_FAILED() {
        return NaviBusinessJNI.ERROR_REQ_UNMARSHAL_FAILED_get();
    }

    public static int getERROR_QUERY_VALID_FAILED() {
        return NaviBusinessJNI.ERROR_QUERY_VALID_FAILED_get();
    }

    public static int getERROR_GET_UID_BY_TOKEN_FAILED() {
        return NaviBusinessJNI.ERROR_GET_UID_BY_TOKEN_FAILED_get();
    }

    public static int getERROR_ORDER_STAGE_ILLEGAL() {
        return NaviBusinessJNI.ERROR_ORDER_STAGE_ILLEGAL_get();
    }

    public static int getERROR_EVENT_TYPE_INVALID() {
        return NaviBusinessJNI.ERROR_EVENT_TYPE_INVALID_get();
    }

    public static int getERROR_REQUEST_TIME_TOO_MUCH() {
        return NaviBusinessJNI.ERROR_REQUEST_TIME_TOO_MUCH_get();
    }

    public static int getERROR_SDK_MAP_TYPE_ILLEGAL() {
        return NaviBusinessJNI.ERROR_SDK_MAP_TYPE_ILLEGAL_get();
    }

    public static int getERROR_REQ_SIGN_VERIFY_ERROR() {
        return NaviBusinessJNI.ERROR_REQ_SIGN_VERIFY_ERROR_get();
    }

    public static int getERROR_ROUTE_PLAN_ERROR() {
        return NaviBusinessJNI.ERROR_ROUTE_PLAN_ERROR_get();
    }

    public static int getERROR_GET_TRAFFIC_STATUS_ERROR() {
        return NaviBusinessJNI.ERROR_GET_TRAFFIC_STATUS_ERROR_get();
    }

    public static int getERROR_NAVI_GUIDE_ERROR() {
        return NaviBusinessJNI.ERROR_NAVI_GUIDE_ERROR_get();
    }

    public static int getERROR_BIND_START_ROAD_ERROR() {
        return NaviBusinessJNI.ERROR_BIND_START_ROAD_ERROR_get();
    }

    public static int getERROR_SRC_DST_TOO_CLOSE_ERROR() {
        return NaviBusinessJNI.ERROR_SRC_DST_TOO_CLOSE_ERROR_get();
    }

    public static int getERROR_NO_NEW_ROUTE_ERROR() {
        return NaviBusinessJNI.ERROR_NO_NEW_ROUTE_ERROR_get();
    }

    public static int getERROR_ROUTE_SESSION_ERROR() {
        return NaviBusinessJNI.ERROR_ROUTE_SESSION_ERROR_get();
    }

    public static int getERROR_DRIVER_NOT_ONROAD_ERROR() {
        return NaviBusinessJNI.ERROR_DRIVER_NOT_ONROAD_ERROR_get();
    }

    public static int getERROR_ROUTEID_NOT_LASTEST() {
        return NaviBusinessJNI.ERROR_ROUTEID_NOT_LASTEST_get();
    }

    public static int getERROR_DRIVER_YAW_ERROR() {
        return NaviBusinessJNI.ERROR_DRIVER_YAW_ERROR_get();
    }

    public static int getERROR_ONE_WAY_ROAD_YAW() {
        return NaviBusinessJNI.ERROR_ONE_WAY_ROAD_YAW_get();
    }

    public static int getERROR_ONE_WAY_ROAD_ONROAD_ERROR() {
        return NaviBusinessJNI.ERROR_ONE_WAY_ROAD_ONROAD_ERROR_get();
    }

    public static int getERROR_YAW_RESIDENTIAL_ERROR() {
        return NaviBusinessJNI.ERROR_YAW_RESIDENTIAL_ERROR_get();
    }

    public static int getERROR_YAW_RESIDENTIAL_NOROUTE_ERROR() {
        return NaviBusinessJNI.ERROR_YAW_RESIDENTIAL_NOROUTE_ERROR_get();
    }

    public static int getERROR_REQUEST_CANCLE() {
        return NaviBusinessJNI.ERROR_REQUEST_CANCLE_get();
    }

    public static int getERROR_RETRY_FAIL() {
        return NaviBusinessJNI.ERROR_RETRY_FAIL_get();
    }

    public static int getERROR_REQUEST_TIME_OUT() {
        return NaviBusinessJNI.ERROR_REQUEST_TIME_OUT_get();
    }

    public static int getAUTO_PASS_NAVI_MODE() {
        return NaviBusinessJNI.AUTO_PASS_NAVI_MODE_get();
    }

    public static int getMANUAL_PASS_NAVI_MODE() {
        return NaviBusinessJNI.MANUAL_PASS_NAVI_MODE_get();
    }

    public static int getNAVI_SCENE_NORMAL_LIGHT() {
        return NaviBusinessJNI.NAVI_SCENE_NORMAL_LIGHT_get();
    }

    public static int getNAVI_SCENE_NORMAL_FULL() {
        return NaviBusinessJNI.NAVI_SCENE_NORMAL_FULL_get();
    }

    public static int getNAVI_SCENE_COMMON_LIGHT() {
        return NaviBusinessJNI.NAVI_SCENE_COMMON_LIGHT_get();
    }

    public static int getNAVI_SCENE_COMMON_FULL() {
        return NaviBusinessJNI.NAVI_SCENE_COMMON_FULL_get();
    }

    public static int getNAVI_SCENE_RAPID_LIGHT() {
        return NaviBusinessJNI.NAVI_SCENE_RAPID_LIGHT_get();
    }

    public static int getNAVI_SCENE_RAPID_FULL() {
        return NaviBusinessJNI.NAVI_SCENE_RAPID_FULL_get();
    }

    public static String getMJO_BASE_URL() {
        return NaviBusinessJNI.MJO_BASE_URL_get();
    }

    public static String getMJO_CONFIG() {
        return NaviBusinessJNI.MJO_CONFIG_get();
    }

    public static String getZIP_FILE() {
        return NaviBusinessJNI.ZIP_FILE_get();
    }

    public static String getDYNAMIC_ENLARGE_PATH() {
        return NaviBusinessJNI.DYNAMIC_ENLARGE_PATH_get();
    }

    public static int getMAX_ROUTES_COUNT() {
        return NaviBusinessJNI.MAX_ROUTES_COUNT_get();
    }

    public static SWIGTYPE_p_ng_handle RG_DG_CreateHandler() {
        return new SWIGTYPE_p_ng_handle(NaviBusinessJNI.RG_DG_CreateHandler(), true);
    }

    public static void RG_DG_DestroyHandler(SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle) {
        NaviBusinessJNI.RG_DG_DestroyHandler(SWIGTYPE_p_ng_handle.getCPtr(sWIGTYPE_p_ng_handle));
    }

    public static void RG_DG_SetRoute(SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle, RGGeoPoint_t rGGeoPoint_t, long j) {
        NaviBusinessJNI.RG_DG_SetRoute(SWIGTYPE_p_ng_handle.getCPtr(sWIGTYPE_p_ng_handle), RGGeoPoint_t.getCPtr(rGGeoPoint_t), rGGeoPoint_t, j);
    }

    public static boolean RG_DG_Match(SWIGTYPE_p_ng_handle sWIGTYPE_p_ng_handle, RGGPSPoint_t rGGPSPoint_t, RGGPSPoint_t rGGPSPoint_t2) {
        return NaviBusinessJNI.RG_DG_Match(SWIGTYPE_p_ng_handle.getCPtr(sWIGTYPE_p_ng_handle), RGGPSPoint_t.getCPtr(rGGPSPoint_t), rGGPSPoint_t, RGGPSPoint_t.getCPtr(rGGPSPoint_t2), rGGPSPoint_t2);
    }
}
