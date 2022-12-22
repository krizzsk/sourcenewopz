package com.dmap.navigation.jni.swig;

import com.didi.hawaii.log.HWLog;
import com.didi.map.constant.StringConstant;
import com.dmap.navigation.engine.p207a.C17406q;
import com.dmap.navigation.engine.p207a.C17407r;
import com.dmap.navigation.engine.p207a.C17411v;
import java.math.BigInteger;

public final class NaviBusinessJNI {
    public static final native void APIRequestCallback_change_ownership(APIRequestCallback aPIRequestCallback, long j, boolean z);

    public static final native void APIRequestCallback_director_connect(APIRequestCallback aPIRequestCallback, long j, boolean z, boolean z2);

    public static final native void APIRequestCallback_onBegin(long j, APIRequestCallback aPIRequestCallback);

    public static final native void APIRequestCallback_onBeginSwigExplicitAPIRequestCallback(long j, APIRequestCallback aPIRequestCallback);

    public static final native void APIRequestCallback_onFinish(long j, APIRequestCallback aPIRequestCallback, long j2, NaviResponse naviResponse);

    public static final native void APIRequestCallback_onFinishSwigExplicitAPIRequestCallback(long j, APIRequestCallback aPIRequestCallback, long j2, NaviResponse naviResponse);

    public static final native void APIRequestCallback_onRetry(long j, APIRequestCallback aPIRequestCallback, int i);

    public static final native void APIRequestCallback_onRetrySwigExplicitAPIRequestCallback(long j, APIRequestCallback aPIRequestCallback, int i);

    public static final native void APIRequestHelper_change_ownership(APIRequestHelper aPIRequestHelper, long j, boolean z);

    public static final native void APIRequestHelper_director_connect(APIRequestHelper aPIRequestHelper, long j, boolean z, boolean z2);

    public static final native long APIRequestHelper_getRequestInfo(long j, APIRequestHelper aPIRequestHelper);

    public static final native long APIRequestHelper_getRequestInfoSwigExplicitAPIRequestHelper(long j, APIRequestHelper aPIRequestHelper);

    public static final native void APIRequestHelper_onPost(long j, APIRequestHelper aPIRequestHelper, int i, String str, long j2, int i2);

    public static final native void APIRequestHelper_onPostSwigExplicitAPIRequestHelper(long j, APIRequestHelper aPIRequestHelper, int i, String str, long j2, int i2);

    public static final native void APITrafficRequestCallback_change_ownership(APITrafficRequestCallback aPITrafficRequestCallback, long j, boolean z);

    public static final native void APITrafficRequestCallback_director_connect(APITrafficRequestCallback aPITrafficRequestCallback, long j, boolean z, boolean z2);

    public static final native void APITrafficRequestCallback_onBegin(long j, APITrafficRequestCallback aPITrafficRequestCallback);

    /* renamed from: APITrafficRequestCallback_onBeginSwigExplicitAPITrafficRequestCallback */
    public static final native void m37052xa6082f7f(long j, APITrafficRequestCallback aPITrafficRequestCallback);

    public static final native void APITrafficRequestCallback_onFinish(long j, APITrafficRequestCallback aPITrafficRequestCallback, long j2, TrafficResponse trafficResponse);

    /* renamed from: APITrafficRequestCallback_onFinishSwigExplicitAPITrafficRequestCallback */
    public static final native void m37053x3ad48f9b(long j, APITrafficRequestCallback aPITrafficRequestCallback, long j2, TrafficResponse trafficResponse);

    public static final native int API_ARRIVED_DESTINATION_get();

    public static final native int API_DRIVER_CHANGED_DESTINATION_get();

    public static final native int API_ELEVATED_ROUTE_get();

    public static final native int API_EXTREME_SPEED_ROUTE_get();

    public static final native int API_FIRST_ROUTE_get();

    public static final native int API_MULTI_ROUTE_get();

    public static final native int API_PARALLEL_ROUTE_get();

    public static final native int API_PASSENGER_CHANGED_DESTINATION_get();

    public static final native int API_PREFERENCE_ROUTE_get();

    public static final native int API_SYNC_PASSENGER_ROUTE_get();

    public static final native int API_YAW_ROUTE_get();

    public static final native int AUTO_PASS_NAVI_MODE_get();

    public static final native void AnalysisLogList_add(long j, AnalysisLogList analysisLogList, long j2, AnalysisLog analysisLog);

    public static final native long AnalysisLogList_capacity(long j, AnalysisLogList analysisLogList);

    public static final native void AnalysisLogList_clear(long j, AnalysisLogList analysisLogList);

    public static final native long AnalysisLogList_get(long j, AnalysisLogList analysisLogList, int i);

    public static final native boolean AnalysisLogList_isEmpty(long j, AnalysisLogList analysisLogList);

    public static final native void AnalysisLogList_reserve(long j, AnalysisLogList analysisLogList, long j2);

    public static final native void AnalysisLogList_set(long j, AnalysisLogList analysisLogList, int i, long j2, AnalysisLog analysisLog);

    public static final native long AnalysisLogList_size(long j, AnalysisLogList analysisLogList);

    public static final native String AnalysisLog_key_get(long j, AnalysisLog analysisLog);

    public static final native void AnalysisLog_key_set(long j, AnalysisLog analysisLog, String str);

    public static final native String AnalysisLog_value_get(long j, AnalysisLog analysisLog);

    public static final native void AnalysisLog_value_set(long j, AnalysisLog analysisLog, String str);

    public static final native void ApolloCallBack_change_ownership(ApolloCallBack apolloCallBack, long j, boolean z);

    public static final native void ApolloCallBack_director_connect(ApolloCallBack apolloCallBack, long j, boolean z, boolean z2);

    public static final native long ApolloCallBack_getToggle(long j, ApolloCallBack apolloCallBack, byte[] bArr);

    public static final native long ApolloCallBack_getToggleSwigExplicitApolloCallBack(long j, ApolloCallBack apolloCallBack, byte[] bArr);

    public static final native void ApolloExperiment_change_ownership(ApolloExperiment apolloExperiment, long j, boolean z);

    public static final native void ApolloExperiment_director_connect(ApolloExperiment apolloExperiment, long j, boolean z, boolean z2);

    public static final native int ApolloExperiment_getParamSwigExplicitApolloExperiment__SWIG_0(long j, ApolloExperiment apolloExperiment, byte[] bArr, int i);

    public static final native float ApolloExperiment_getParamSwigExplicitApolloExperiment__SWIG_1(long j, ApolloExperiment apolloExperiment, byte[] bArr, float f);

    public static final native String ApolloExperiment_getParamSwigExplicitApolloExperiment__SWIG_2(long j, ApolloExperiment apolloExperiment, byte[] bArr, String str);

    public static final native int ApolloExperiment_getParam__SWIG_0(long j, ApolloExperiment apolloExperiment, byte[] bArr, int i);

    public static final native float ApolloExperiment_getParam__SWIG_1(long j, ApolloExperiment apolloExperiment, byte[] bArr, float f);

    public static final native String ApolloExperiment_getParam__SWIG_2(long j, ApolloExperiment apolloExperiment, byte[] bArr, String str);

    public static final native void ApolloInit();

    public static final native boolean ApolloToggle_allow(long j, ApolloToggle apolloToggle);

    public static final native boolean ApolloToggle_allowSwigExplicitApolloToggle(long j, ApolloToggle apolloToggle);

    public static final native void ApolloToggle_change_ownership(ApolloToggle apolloToggle, long j, boolean z);

    public static final native void ApolloToggle_director_connect(ApolloToggle apolloToggle, long j, boolean z, boolean z2);

    public static final native long ApolloToggle_getExperiment(long j, ApolloToggle apolloToggle);

    public static final native long ApolloToggle_getExperimentSwigExplicitApolloToggle(long j, ApolloToggle apolloToggle);

    public static final native String BASE_URL_get();

    public static final native void BaseNaviAPI_cancel(long j, BaseNaviAPI baseNaviAPI);

    public static final native void BaseNaviAPI_execute(long j, BaseNaviAPI baseNaviAPI);

    public static final native void BaseNaviAPI_onResponse(long j, BaseNaviAPI baseNaviAPI, byte[] bArr, int i, int i2);

    public static final native void BaseNaviAPI_setCallback(long j, BaseNaviAPI baseNaviAPI, long j2, APIRequestCallback aPIRequestCallback);

    public static final native void BaseNaviAPI_setHelper(long j, BaseNaviAPI baseNaviAPI, long j2, APIRequestHelper aPIRequestHelper);

    public static final native void BaseNaviAPI_setNaviInfo(long j, BaseNaviAPI baseNaviAPI, long j2, NaviInfo naviInfo);

    public static final native void BaseNaviAPI_setRetryStrategy(long j, BaseNaviAPI baseNaviAPI, long j2, RetryStrategy retryStrategy);

    public static final native long BindNaviLocation_SWIGUpcast(long j);

    public static final native int BindNaviLocation_index_get(long j, BindNaviLocation bindNaviLocation);

    public static final native void BindNaviLocation_index_set(long j, BindNaviLocation bindNaviLocation, int i);

    public static final native long CharArray_cast(long j, CharArray charArray);

    public static final native long CharArray_frompointer(long j);

    public static final native short CharArray_getitem(long j, CharArray charArray, int i);

    public static final native void CharArray_setitem(long j, CharArray charArray, int i, short s);

    public static final native String DYNAMIC_ENLARGE_PATH_get();

    public static final native long DefaultRetryStrategy_SWIGUpcast(long j);

    public static final native int ERROR_BIND_START_ROAD_ERROR_get();

    public static final native int ERROR_DRIVER_NOT_ONROAD_ERROR_get();

    public static final native int ERROR_DRIVER_YAW_ERROR_get();

    public static final native int ERROR_EVENT_TYPE_INVALID_get();

    public static final native int ERROR_EXPIRED_REQUEST_get();

    public static final native int ERROR_GET_TRAFFIC_STATUS_ERROR_get();

    public static final native int ERROR_GET_UID_BY_TOKEN_FAILED_get();

    public static final native int ERROR_NAVI_GUIDE_ERROR_get();

    public static final native int ERROR_NO_NEW_ROUTE_ERROR_get();

    public static final native int ERROR_ONE_WAY_ROAD_ONROAD_ERROR_get();

    public static final native int ERROR_ONE_WAY_ROAD_YAW_get();

    public static final native int ERROR_ORDER_STAGE_ILLEGAL_get();

    public static final native int ERROR_QUERY_PARSE_FAILED_get();

    public static final native int ERROR_QUERY_TIMEOUT_get();

    public static final native int ERROR_QUERY_VALID_FAILED_get();

    public static final native int ERROR_REQUEST_CANCLE_get();

    public static final native int ERROR_REQUEST_TIME_OUT_get();

    public static final native int ERROR_REQUEST_TIME_TOO_MUCH_get();

    public static final native int ERROR_REQ_BODY_LEN_ERROR_get();

    public static final native int ERROR_REQ_SIGN_VERIFY_ERROR_get();

    public static final native int ERROR_REQ_UNMARSHAL_FAILED_get();

    public static final native int ERROR_RETRY_FAIL_get();

    public static final native int ERROR_ROUTEID_NOT_LASTEST_get();

    public static final native int ERROR_ROUTE_PLAN_ERROR_get();

    public static final native int ERROR_ROUTE_SESSION_ERROR_get();

    public static final native int ERROR_SDK_MAP_TYPE_ILLEGAL_get();

    public static final native int ERROR_SRC_DST_TOO_CLOSE_ERROR_get();

    public static final native int ERROR_YAW_RESIDENTIAL_ERROR_get();

    public static final native int ERROR_YAW_RESIDENTIAL_NOROUTE_ERROR_get();

    public static final native long FirstRetryStrategy_SWIGUpcast(long j);

    public static final native BigInteger GpsHealthInfo_all_gps_get(long j, GpsHealthInfo gpsHealthInfo);

    public static final native void GpsHealthInfo_all_gps_set(long j, GpsHealthInfo gpsHealthInfo, BigInteger bigInteger);

    public static final native BigInteger GpsHealthInfo_angle_gps_get(long j, GpsHealthInfo gpsHealthInfo);

    public static final native void GpsHealthInfo_angle_gps_set(long j, GpsHealthInfo gpsHealthInfo, BigInteger bigInteger);

    public static final native BigInteger GpsHealthInfo_av_gps_get(long j, GpsHealthInfo gpsHealthInfo);

    public static final native void GpsHealthInfo_av_gps_set(long j, GpsHealthInfo gpsHealthInfo, BigInteger bigInteger);

    public static final native BigInteger GpsHealthInfo_back_gps_get(long j, GpsHealthInfo gpsHealthInfo);

    public static final native void GpsHealthInfo_back_gps_set(long j, GpsHealthInfo gpsHealthInfo, BigInteger bigInteger);

    public static final native BigInteger GpsHealthInfo_no_gps_get(long j, GpsHealthInfo gpsHealthInfo);

    public static final native void GpsHealthInfo_no_gps_set(long j, GpsHealthInfo gpsHealthInfo, BigInteger bigInteger);

    public static final native void IntList_add(long j, IntList intList, int i);

    public static final native long IntList_capacity(long j, IntList intList);

    public static final native void IntList_clear(long j, IntList intList);

    public static final native int IntList_get(long j, IntList intList, int i);

    public static final native boolean IntList_isEmpty(long j, IntList intList);

    public static final native void IntList_reserve(long j, IntList intList, long j2);

    public static final native void IntList_set(long j, IntList intList, int i, int i2);

    public static final native long IntList_size(long j, IntList intList);

    public static final native void LogJavaInit();

    public static final native void LongList_add(long j, LongList longList, BigInteger bigInteger);

    public static final native long LongList_capacity(long j, LongList longList);

    public static final native void LongList_clear(long j, LongList longList);

    public static final native BigInteger LongList_get(long j, LongList longList, int i);

    public static final native boolean LongList_isEmpty(long j, LongList longList);

    public static final native void LongList_reserve(long j, LongList longList, long j2);

    public static final native void LongList_set(long j, LongList longList, int i, BigInteger bigInteger);

    public static final native long LongList_size(long j, LongList longList);

    public static final native int MANUAL_PASS_NAVI_MODE_get();

    public static final native int MAX_ROUTES_COUNT_get();

    public static final native String MJO_BASE_URL_get();

    public static final native String MJO_CONFIG_get();

    public static final native void MarkerSectionList_add(long j, MarkerSectionList markerSectionList, long j2, MarkerSection markerSection);

    public static final native long MarkerSectionList_capacity(long j, MarkerSectionList markerSectionList);

    public static final native void MarkerSectionList_clear(long j, MarkerSectionList markerSectionList);

    public static final native long MarkerSectionList_get(long j, MarkerSectionList markerSectionList, int i);

    public static final native boolean MarkerSectionList_isEmpty(long j, MarkerSectionList markerSectionList);

    public static final native void MarkerSectionList_reserve(long j, MarkerSectionList markerSectionList, long j2);

    public static final native void MarkerSectionList_set(long j, MarkerSectionList markerSectionList, int i, long j2, MarkerSection markerSection);

    public static final native long MarkerSectionList_size(long j, MarkerSectionList markerSectionList);

    public static final native int MarkerSection_endNum_get(long j, MarkerSection markerSection);

    public static final native void MarkerSection_endNum_set(long j, MarkerSection markerSection, int i);

    public static final native long MarkerSection_endPoint_get(long j, MarkerSection markerSection);

    public static final native void MarkerSection_endPoint_set(long j, MarkerSection markerSection, long j2, NaviLatLng naviLatLng);

    public static final native int MarkerSection_startNum_get(long j, MarkerSection markerSection);

    public static final native void MarkerSection_startNum_set(long j, MarkerSection markerSection, int i);

    public static final native long MarkerSection_startPoint_get(long j, MarkerSection markerSection);

    public static final native void MarkerSection_startPoint_set(long j, MarkerSection markerSection, long j2, NaviLatLng naviLatLng);

    public static final native BigInteger MatchedRouteInfo_linkIdRaw_get(long j, MatchedRouteInfo matchedRouteInfo);

    public static final native void MatchedRouteInfo_linkIdRaw_set(long j, MatchedRouteInfo matchedRouteInfo, BigInteger bigInteger);

    public static final native BigInteger MatchedRouteInfo_linkId_get(long j, MatchedRouteInfo matchedRouteInfo);

    public static final native void MatchedRouteInfo_linkId_set(long j, MatchedRouteInfo matchedRouteInfo, BigInteger bigInteger);

    public static final native String MatchedRouteInfo_mapVersion_get(long j, MatchedRouteInfo matchedRouteInfo);

    public static final native void MatchedRouteInfo_mapVersion_set(long j, MatchedRouteInfo matchedRouteInfo, String str);

    public static final native String MissionButtonInfo_buttonPicUrl_get(long j, MissionButtonInfo missionButtonInfo);

    public static final native void MissionButtonInfo_buttonPicUrl_set(long j, MissionButtonInfo missionButtonInfo, String str);

    public static final native String MissionButtonInfo_buttonTitle_get(long j, MissionButtonInfo missionButtonInfo);

    public static final native void MissionButtonInfo_buttonTitle_set(long j, MissionButtonInfo missionButtonInfo, String str);

    public static final native int MissionButtonInfo_buttonType_get(long j, MissionButtonInfo missionButtonInfo);

    public static final native void MissionButtonInfo_buttonType_set(long j, MissionButtonInfo missionButtonInfo, int i);

    public static final native int MissionButtonInfo_buttonValue_get(long j, MissionButtonInfo missionButtonInfo);

    public static final native void MissionButtonInfo_buttonValue_set(long j, MissionButtonInfo missionButtonInfo, int i);

    public static final native void MissionButtonList_add(long j, MissionButtonList missionButtonList, long j2, MissionButtonInfo missionButtonInfo);

    public static final native long MissionButtonList_capacity(long j, MissionButtonList missionButtonList);

    public static final native void MissionButtonList_clear(long j, MissionButtonList missionButtonList);

    public static final native long MissionButtonList_get(long j, MissionButtonList missionButtonList, int i);

    public static final native boolean MissionButtonList_isEmpty(long j, MissionButtonList missionButtonList);

    public static final native void MissionButtonList_reserve(long j, MissionButtonList missionButtonList, long j2);

    public static final native void MissionButtonList_set(long j, MissionButtonList missionButtonList, int i, long j2, MissionButtonInfo missionButtonInfo);

    public static final native long MissionButtonList_size(long j, MissionButtonList missionButtonList);

    public static final native int NAVI_MODEL_FULL_get();

    public static final native int NAVI_MODEL_LIGHT_get();

    public static final native int NAVI_MODEL_PLAN_get();

    public static final native int NAVI_SCENE_COMMON_FULL_get();

    public static final native int NAVI_SCENE_COMMON_LIGHT_get();

    public static final native int NAVI_SCENE_NORMAL_FULL_get();

    public static final native int NAVI_SCENE_NORMAL_LIGHT_get();

    public static final native int NAVI_SCENE_RAPID_FULL_get();

    public static final native int NAVI_SCENE_RAPID_LIGHT_get();

    public static final native void NaviCameraList_add(long j, NaviCameraList naviCameraList, long j2, NaviCamera naviCamera);

    public static final native long NaviCameraList_capacity(long j, NaviCameraList naviCameraList);

    public static final native void NaviCameraList_clear(long j, NaviCameraList naviCameraList);

    public static final native long NaviCameraList_get(long j, NaviCameraList naviCameraList, int i);

    public static final native boolean NaviCameraList_isEmpty(long j, NaviCameraList naviCameraList);

    public static final native void NaviCameraList_reserve(long j, NaviCameraList naviCameraList, long j2);

    public static final native void NaviCameraList_set(long j, NaviCameraList naviCameraList, int i, long j2, NaviCamera naviCamera);

    public static final native long NaviCameraList_size(long j, NaviCameraList naviCameraList);

    public static final native int NaviCamera_bubbleType_get(long j, NaviCamera naviCamera);

    public static final native void NaviCamera_bubbleType_set(long j, NaviCamera naviCamera, int i);

    public static final native int NaviCamera_groupId_get(long j, NaviCamera naviCamera);

    public static final native void NaviCamera_groupId_set(long j, NaviCamera naviCamera, int i);

    public static final native long NaviCamera_latLng_get(long j, NaviCamera naviCamera);

    public static final native void NaviCamera_latLng_set(long j, NaviCamera naviCamera, long j2, NaviLatLng naviLatLng);

    public static final native int NaviCamera_speed_get(long j, NaviCamera naviCamera);

    public static final native void NaviCamera_speed_set(long j, NaviCamera naviCamera, int i);

    public static final native int NaviCamera_type_get(long j, NaviCamera naviCamera);

    public static final native void NaviCamera_type_set(long j, NaviCamera naviCamera, int i);

    public static final native int NaviCamera_weight_get(long j, NaviCamera naviCamera);

    public static final native void NaviCamera_weight_set(long j, NaviCamera naviCamera, int i);

    public static final native void NaviEngineVP_destory(long j, NaviEngineVP naviEngineVP);

    public static final native long NaviEngineVP_getMatchLocation(long j, NaviEngineVP naviEngineVP, long j2, NaviLocation naviLocation);

    public static final native void NaviEngineVP_init(long j, NaviEngineVP naviEngineVP, long j2, NaviOption naviOption);

    public static final native void NaviEngineVP_setRoutePoints(long j, NaviEngineVP naviEngineVP, long j2, NaviLatLngList naviLatLngList);

    public static final native void NaviEngine_addMoreRoutes(long j, NaviEngine naviEngine, long j2);

    public static final native void NaviEngine_addSafeNotifyInfo(long j, NaviEngine naviEngine, long j2, SafeNotifyInfo safeNotifyInfo);

    public static final native void NaviEngine_changeNaviModel(long j, NaviEngine naviEngine, int i);

    public static final native void NaviEngine_closeCurrentMJO(long j, NaviEngine naviEngine);

    public static final native void NaviEngine_forcePassedNext(long j, NaviEngine naviEngine);

    public static final native BigInteger NaviEngine_getCurrentRouteId(long j, NaviEngine naviEngine);

    public static final native long NaviEngine_getGpsHealthInfo(long j, NaviEngine naviEngine);

    public static final native long NaviEngine_getMatchedRouteInfo(long j, NaviEngine naviEngine);

    public static final native String NaviEngine_getNGVoiceContent(long j, NaviEngine naviEngine, int i);

    public static final native long NaviEngine_getRouteById(long j, NaviEngine naviEngine, BigInteger bigInteger);

    public static final native void NaviEngine_init(long j, NaviEngine naviEngine, long j2, UserInfo userInfo, long j3, OrderInfo orderInfo, long j4, NaviOption naviOption);

    public static final native void NaviEngine_playMannalVoice(long j, NaviEngine naviEngine);

    public static final native void NaviEngine_playOpenningVoice(long j, NaviEngine naviEngine, long j2, NaviLocation naviLocation);

    public static final native void NaviEngine_selectRoute(long j, NaviEngine naviEngine, BigInteger bigInteger, boolean z);

    public static final native void NaviEngine_setDayNight(long j, NaviEngine naviEngine, boolean z);

    public static final native void NaviEngine_setMJOEnable(long j, NaviEngine naviEngine, boolean z);

    public static final native void NaviEngine_setTrafficEventPoints(long j, NaviEngine naviEngine, BigInteger bigInteger, long j2, TrafficEventPointList trafficEventPointList);

    public static final native void NaviEngine_setVecEnlargeInfo(long j, NaviEngine naviEngine, int i, int i2);

    public static final native void NaviEngine_setVoiceAssistantState(long j, NaviEngine naviEngine, int i);

    public static final native void NaviEngine_startNavi(long j, NaviEngine naviEngine, long j2, NaviRoute naviRoute, long j3, NaviLocation naviLocation);

    public static final native void NaviEngine_stopNavi(long j, NaviEngine naviEngine);

    public static final native void NaviEngine_updateAppAction(long j, NaviEngine naviEngine, int i);

    public static final native void NaviEngine_updateLocation(long j, NaviEngine naviEngine, long j2, NaviLocation naviLocation);

    public static final native void NaviEngine_updateNaviScene(long j, NaviEngine naviEngine);

    public static final native void NaviEngine_updateTrafficEtas(long j, NaviEngine naviEngine, int i, int[] iArr);

    public static final native void NaviEngine_updateTrafficStatus(long j, NaviEngine naviEngine, byte[] bArr, int i, int i2);

    public static final native void NaviEventCallback_change_ownership(NaviEventCallback naviEventCallback, long j, boolean z);

    public static final native void NaviEventCallback_director_connect(NaviEventCallback naviEventCallback, long j, boolean z, boolean z2);

    public static final native void NaviEventCallback_onAnalysisEvent(long j, NaviEventCallback naviEventCallback, String str, long j2, AnalysisLogList analysisLogList);

    public static final native void NaviEventCallback_onAnalysisEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, String str, long j2, AnalysisLogList analysisLogList);

    public static final native void NaviEventCallback_onArrivedEvent(long j, NaviEventCallback naviEventCallback, boolean z, long j2, NaviLatLng naviLatLng, long j3, NaviLatLng naviLatLng2, long j4, NaviLatLng naviLatLng3, int i, int i2);

    public static final native void NaviEventCallback_onArrivedEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, boolean z, long j2, NaviLatLng naviLatLng, long j3, NaviLatLng naviLatLng2, long j4, NaviLatLng naviLatLng3, int i, int i2);

    public static final native void NaviEventCallback_onCameraEvent(long j, NaviEventCallback naviEventCallback, int i, long j2, NaviCameraList naviCameraList, int i2);

    public static final native void NaviEventCallback_onCameraEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, long j2, NaviCameraList naviCameraList, int i2);

    public static final native void NaviEventCallback_onCongestionEvent(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5, int i6);

    public static final native void NaviEventCallback_onCongestionEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5, int i6);

    public static final native void NaviEventCallback_onDestinationEvent(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5);

    /* renamed from: NaviEventCallback_onDestinationEventSwigExplicitNaviEventCallback */
    public static final native void m37054x47b71df2(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5);

    public static final native void NaviEventCallback_onDownloadEvent(long j, NaviEventCallback naviEventCallback, long j2, StringList stringList);

    public static final native void NaviEventCallback_onDownloadEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, long j2, StringList stringList);

    public static final native void NaviEventCallback_onDownloadMJOEvent(long j, NaviEventCallback naviEventCallback, long j2, String str, String str2, String str3);

    /* renamed from: NaviEventCallback_onDownloadMJOEventSwigExplicitNaviEventCallback */
    public static final native void m37055xcdb0dfae(long j, NaviEventCallback naviEventCallback, long j2, String str, String str2, String str3);

    public static final native void NaviEventCallback_onDownloadVecEvent(long j, NaviEventCallback naviEventCallback, String str, String str2, long j2, int i);

    /* renamed from: NaviEventCallback_onDownloadVecEventSwigExplicitNaviEventCallback */
    public static final native void m37056xca313c50(long j, NaviEventCallback naviEventCallback, String str, String str2, long j2, int i);

    public static final native void NaviEventCallback_onEnlargeMapEvent(long j, NaviEventCallback naviEventCallback, int i, String str, String str2);

    public static final native void NaviEventCallback_onEnlargeMapEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, String str, String str2);

    public static final native void NaviEventCallback_onIllegalParkEvent(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, String str, String str2, long j2, NaviLatLng naviLatLng, long j3, NaviLatLng naviLatLng2);

    /* renamed from: NaviEventCallback_onIllegalParkEventSwigExplicitNaviEventCallback */
    public static final native void m37057xe6357de4(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, String str, String str2, long j2, NaviLatLng naviLatLng, long j3, NaviLatLng naviLatLng2);

    public static final native void NaviEventCallback_onIntersectionEvent(long j, NaviEventCallback naviEventCallback, int i, String str, String str2, int i2, int i3, int i4, long j2, NaviLatLng naviLatLng, int i5, int i6, String str3, boolean z, int i7);

    /* renamed from: NaviEventCallback_onIntersectionEventSwigExplicitNaviEventCallback */
    public static final native void m37058x68f0ef17(long j, NaviEventCallback naviEventCallback, int i, String str, String str2, int i2, int i3, int i4, long j2, NaviLatLng naviLatLng, int i5, int i6, String str3, boolean z, int i7);

    public static final native void NaviEventCallback_onLaneEvent(long j, NaviEventCallback naviEventCallback, int i, String str, String str2, String str3, int i2, int i3, BigInteger bigInteger, long j2, NaviLatLng naviLatLng, int i4);

    public static final native void NaviEventCallback_onLaneEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, String str, String str2, String str3, int i2, int i3, BigInteger bigInteger, long j2, NaviLatLng naviLatLng, int i4);

    public static final native void NaviEventCallback_onLimitSpeedCameraEvent(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, long j2, NaviLatLng naviLatLng, String str);

    /* renamed from: NaviEventCallback_onLimitSpeedCameraEventSwigExplicitNaviEventCallback */
    public static final native void m37059xcd6e2f9f(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, long j2, NaviLatLng naviLatLng, String str);

    public static final native void NaviEventCallback_onMJOEvent(long j, NaviEventCallback naviEventCallback, int i, long j2, String str, BigInteger bigInteger);

    public static final native void NaviEventCallback_onMJOEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, long j2, String str, BigInteger bigInteger);

    public static final native void NaviEventCallback_onMatchLocationEvent(long j, NaviEventCallback naviEventCallback, BigInteger bigInteger, long j2, NaviLocation naviLocation, int i, int i2, double d, int i3);

    /* renamed from: NaviEventCallback_onMatchLocationEventSwigExplicitNaviEventCallback */
    public static final native void m37060x69fa2cbe(long j, NaviEventCallback naviEventCallback, BigInteger bigInteger, long j2, NaviLocation naviLocation, int i, int i2, double d, int i3);

    public static final native void NaviEventCallback_onMissionEvent(long j, NaviEventCallback naviEventCallback, long j2, int i, String str, String str2, long j3, NaviLatLng naviLatLng, long j4, int i2, BigInteger bigInteger, long j5, MissionButtonList missionButtonList, int i3, String str3);

    public static final native void NaviEventCallback_onMissionEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, long j2, int i, String str, String str2, long j3, NaviLatLng naviLatLng, long j4, int i2, BigInteger bigInteger, long j5, MissionButtonList missionButtonList, int i3, String str3);

    public static final native void NaviEventCallback_onMoreRouteEvent(long j, NaviEventCallback naviEventCallback, int i, String str);

    public static final native void NaviEventCallback_onMoreRouteEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, String str);

    public static final native void NaviEventCallback_onParallelRoadEvent(long j, NaviEventCallback naviEventCallback, int i, int i2);

    /* renamed from: NaviEventCallback_onParallelRoadEventSwigExplicitNaviEventCallback */
    public static final native void m37061xbb7f3ad5(long j, NaviEventCallback naviEventCallback, int i, int i2);

    public static final native void NaviEventCallback_onPassPointVerifyEvent(long j, NaviEventCallback naviEventCallback, int i);

    /* renamed from: NaviEventCallback_onPassPointVerifyEventSwigExplicitNaviEventCallback */
    public static final native void m37062x46ca2f3c(long j, NaviEventCallback naviEventCallback, int i);

    public static final native void NaviEventCallback_onQRPayEvent(long j, NaviEventCallback naviEventCallback, int i, BigInteger bigInteger);

    public static final native void NaviEventCallback_onQRPayEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, BigInteger bigInteger);

    public static final native void NaviEventCallback_onRoutesEvent(long j, NaviEventCallback naviEventCallback, long j2, LongList longList, int i);

    public static final native void NaviEventCallback_onRoutesEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, long j2, LongList longList, int i);

    public static final native void NaviEventCallback_onSlopeInfoEvent(long j, NaviEventCallback naviEventCallback, int i);

    public static final native void NaviEventCallback_onSlopeInfoEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i);

    public static final native void NaviEventCallback_onSpeedIconEvent(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5, float f, int i6);

    public static final native void NaviEventCallback_onSpeedIconEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5, float f, int i6);

    public static final native void NaviEventCallback_onToastText(long j, NaviEventCallback naviEventCallback, int i, String str);

    public static final native void NaviEventCallback_onToastTextSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, int i, String str);

    public static final native void NaviEventCallback_onVDRInfoEvent(long j, NaviEventCallback naviEventCallback, BigInteger bigInteger, double d, double d2, float f, int i, int i2);

    public static final native void NaviEventCallback_onVDRInfoEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, BigInteger bigInteger, double d, double d2, float f, int i, int i2);

    public static final native void NaviEventCallback_onVecEnlargeMapEvent(long j, NaviEventCallback naviEventCallback, int i, String str, String str2);

    /* renamed from: NaviEventCallback_onVecEnlargeMapEventSwigExplicitNaviEventCallback */
    public static final native void m37063x59005da2(long j, NaviEventCallback naviEventCallback, int i, String str, String str2);

    public static final native void NaviEventCallback_onVoiceEvent(long j, NaviEventCallback naviEventCallback, String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static final native void NaviEventCallback_onVoiceEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static final native void NaviEventCallback_onYawEvent(long j, NaviEventCallback naviEventCallback, long j2, BindNaviLocation bindNaviLocation, int i, int i2);

    public static final native void NaviEventCallback_onYawEventSwigExplicitNaviEventCallback(long j, NaviEventCallback naviEventCallback, long j2, BindNaviLocation bindNaviLocation, int i, int i2);

    public static final native void NaviGetter_change_ownership(NaviGetter naviGetter, long j, boolean z);

    public static final native void NaviGetter_director_connect(NaviGetter naviGetter, long j, boolean z, boolean z2);

    public static final native String NaviGetter_getTextByKey(long j, NaviGetter naviGetter, String str);

    public static final native String NaviGetter_getTextByKeySwigExplicitNaviGetter(long j, NaviGetter naviGetter, String str);

    public static final native long NaviInfo_currentBindPoint_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_currentBindPoint_set(long j, NaviInfo naviInfo, long j2, BindNaviLocation bindNaviLocation);

    public static final native long NaviInfo_currentRoute_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_currentRoute_set(long j, NaviInfo naviInfo, long j2, ReqRouteInfo reqRouteInfo);

    public static final native long NaviInfo_end_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_end_set(long j, NaviInfo naviInfo, long j2, NaviPoi naviPoi);

    public static final native int NaviInfo_eventType_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_eventType_set(long j, NaviInfo naviInfo, int i);

    public static final native long NaviInfo_historyPoints_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_historyPoints_set(long j, NaviInfo naviInfo, long j2, NaviLocationList naviLocationList);

    public static final native long NaviInfo_lastBindPoint_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_lastBindPoint_set(long j, NaviInfo naviInfo, long j2, BindNaviLocation bindNaviLocation);

    public static final native long NaviInfo_lastGpsPoint_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_lastGpsPoint_set(long j, NaviInfo naviInfo, long j2, NaviLocation naviLocation);

    public static final native int NaviInfo_naviModel_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_naviModel_set(long j, NaviInfo naviInfo, int i);

    public static final native long NaviInfo_passPoints_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_passPoints_set(long j, NaviInfo naviInfo, long j2, NaviPoiList naviPoiList);

    public static final native long NaviInfo_start_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_start_set(long j, NaviInfo naviInfo, long j2, NaviPoi naviPoi);

    public static final native int NaviInfo_yawType_get(long j, NaviInfo naviInfo);

    public static final native void NaviInfo_yawType_set(long j, NaviInfo naviInfo, int i);

    public static final native void NaviLatLngList_add(long j, NaviLatLngList naviLatLngList, long j2, NaviLatLng naviLatLng);

    public static final native long NaviLatLngList_capacity(long j, NaviLatLngList naviLatLngList);

    public static final native void NaviLatLngList_clear(long j, NaviLatLngList naviLatLngList);

    public static final native long NaviLatLngList_get(long j, NaviLatLngList naviLatLngList, int i);

    public static final native boolean NaviLatLngList_isEmpty(long j, NaviLatLngList naviLatLngList);

    public static final native void NaviLatLngList_reserve(long j, NaviLatLngList naviLatLngList, long j2);

    public static final native void NaviLatLngList_set(long j, NaviLatLngList naviLatLngList, int i, long j2, NaviLatLng naviLatLng);

    public static final native long NaviLatLngList_size(long j, NaviLatLngList naviLatLngList);

    public static final native double NaviLatLng_lat_get(long j, NaviLatLng naviLatLng);

    public static final native void NaviLatLng_lat_set(long j, NaviLatLng naviLatLng, double d);

    public static final native double NaviLatLng_lng_get(long j, NaviLatLng naviLatLng);

    public static final native void NaviLatLng_lng_set(long j, NaviLatLng naviLatLng, double d);

    public static final native void NaviLocationList_add(long j, NaviLocationList naviLocationList, long j2, NaviLocation naviLocation);

    public static final native long NaviLocationList_capacity(long j, NaviLocationList naviLocationList);

    public static final native void NaviLocationList_clear(long j, NaviLocationList naviLocationList);

    public static final native long NaviLocationList_get(long j, NaviLocationList naviLocationList, int i);

    public static final native boolean NaviLocationList_isEmpty(long j, NaviLocationList naviLocationList);

    public static final native void NaviLocationList_reserve(long j, NaviLocationList naviLocationList, long j2);

    public static final native void NaviLocationList_set(long j, NaviLocationList naviLocationList, int i, long j2, NaviLocation naviLocation);

    public static final native long NaviLocationList_size(long j, NaviLocationList naviLocationList);

    public static final native float NaviLocation_accuracy_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_accuracy_set(long j, NaviLocation naviLocation, float f);

    public static final native float NaviLocation_angle_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_angle_set(long j, NaviLocation naviLocation, float f);

    public static final native float NaviLocation_flpBearing_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_flpBearing_set(long j, NaviLocation naviLocation, float f);

    public static final native float NaviLocation_flpConfidence_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_flpConfidence_set(long j, NaviLocation naviLocation, float f);

    public static final native String NaviLocation_flpExt_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_flpExt_set(long j, NaviLocation naviLocation, String str);

    public static final native int NaviLocation_flpStatus_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_flpStatus_set(long j, NaviLocation naviLocation, int i);

    public static final native int NaviLocation_gpsProvider_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_gpsProvider_set(long j, NaviLocation naviLocation, int i);

    public static final native String NaviLocation_gpsSource_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_gpsSource_set(long j, NaviLocation naviLocation, String str);

    public static final native BigInteger NaviLocation_gpsTime_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_gpsTime_set(long j, NaviLocation naviLocation, BigInteger bigInteger);

    public static final native long NaviLocation_latLng_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_latLng_set(long j, NaviLocation naviLocation, long j2, NaviLatLng naviLatLng);

    public static final native int NaviLocation_naviSource_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_naviSource_set(long j, NaviLocation naviLocation, int i);

    public static final native BigInteger NaviLocation_phoneTime_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_phoneTime_set(long j, NaviLocation naviLocation, BigInteger bigInteger);

    public static final native int NaviLocation_satellitesNum_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_satellitesNum_set(long j, NaviLocation naviLocation, int i);

    public static final native int NaviLocation_vdrConf_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_vdrConf_set(long j, NaviLocation naviLocation, int i);

    public static final native float NaviLocation_velocity_get(long j, NaviLocation naviLocation);

    public static final native void NaviLocation_velocity_set(long j, NaviLocation naviLocation, float f);

    public static final native void NaviMJOLinkInfoList_add(long j, NaviMJOLinkInfoList naviMJOLinkInfoList, long j2, NaviMJOLinkInfo naviMJOLinkInfo);

    public static final native long NaviMJOLinkInfoList_capacity(long j, NaviMJOLinkInfoList naviMJOLinkInfoList);

    public static final native void NaviMJOLinkInfoList_clear(long j, NaviMJOLinkInfoList naviMJOLinkInfoList);

    public static final native long NaviMJOLinkInfoList_get(long j, NaviMJOLinkInfoList naviMJOLinkInfoList, int i);

    public static final native boolean NaviMJOLinkInfoList_isEmpty(long j, NaviMJOLinkInfoList naviMJOLinkInfoList);

    public static final native void NaviMJOLinkInfoList_reserve(long j, NaviMJOLinkInfoList naviMJOLinkInfoList, long j2);

    public static final native void NaviMJOLinkInfoList_set(long j, NaviMJOLinkInfoList naviMJOLinkInfoList, int i, long j2, NaviMJOLinkInfo naviMJOLinkInfo);

    public static final native long NaviMJOLinkInfoList_size(long j, NaviMJOLinkInfoList naviMJOLinkInfoList);

    public static final native int NaviMJOLinkInfo_direction_get(long j, NaviMJOLinkInfo naviMJOLinkInfo);

    public static final native void NaviMJOLinkInfo_direction_set(long j, NaviMJOLinkInfo naviMJOLinkInfo, int i);

    public static final native double NaviMJOLinkInfo_linkDistance_get(long j, NaviMJOLinkInfo naviMJOLinkInfo);

    public static final native void NaviMJOLinkInfo_linkDistance_set(long j, NaviMJOLinkInfo naviMJOLinkInfo, double d);

    public static final native BigInteger NaviMJOLinkInfo_linkId_get(long j, NaviMJOLinkInfo naviMJOLinkInfo);

    public static final native void NaviMJOLinkInfo_linkId_set(long j, NaviMJOLinkInfo naviMJOLinkInfo, BigInteger bigInteger);

    public static final native BigInteger NaviMJOLinkInfo_originalinkId_get(long j, NaviMJOLinkInfo naviMJOLinkInfo);

    public static final native void NaviMJOLinkInfo_originalinkId_set(long j, NaviMJOLinkInfo naviMJOLinkInfo, BigInteger bigInteger);

    public static final native boolean NaviOption_autoStartNavi_get(long j, NaviOption naviOption);

    public static final native void NaviOption_autoStartNavi_set(long j, NaviOption naviOption, boolean z);

    public static final native int NaviOption_avoidJamType_get(long j, NaviOption naviOption);

    public static final native void NaviOption_avoidJamType_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_cameraDisplay_get(long j, NaviOption naviOption);

    public static final native void NaviOption_cameraDisplay_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_confidenceHigh_get(long j, NaviOption naviOption);

    public static final native void NaviOption_confidenceHigh_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_confidenceLow_get(long j, NaviOption naviOption);

    public static final native void NaviOption_confidenceLow_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_diaUpgrade_get(long j, NaviOption naviOption);

    public static final native void NaviOption_diaUpgrade_set(long j, NaviOption naviOption, int i);

    public static final native String NaviOption_dispatchId_get(long j, NaviOption naviOption);

    public static final native void NaviOption_dispatchId_set(long j, NaviOption naviOption, String str);

    public static final native int NaviOption_dispatchType_get(long j, NaviOption naviOption);

    public static final native void NaviOption_dispatchType_set(long j, NaviOption naviOption, int i);

    public static final native boolean NaviOption_dynamicRouteEnable_get(long j, NaviOption naviOption);

    public static final native void NaviOption_dynamicRouteEnable_set(long j, NaviOption naviOption, boolean z);

    public static final native int NaviOption_fbRoadName_get(long j, NaviOption naviOption);

    public static final native void NaviOption_fbRoadName_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_fishbone_get(long j, NaviOption naviOption);

    public static final native void NaviOption_fishbone_set(long j, NaviOption naviOption, int i);

    public static final native boolean NaviOption_isForceYaw_get(long j, NaviOption naviOption);

    public static final native void NaviOption_isForceYaw_set(long j, NaviOption naviOption, boolean z);

    public static final native int NaviOption_language_get(long j, NaviOption naviOption);

    public static final native void NaviOption_language_set(long j, NaviOption naviOption, int i);

    public static final native String NaviOption_mapVersion_get(long j, NaviOption naviOption);

    public static final native void NaviOption_mapVersion_set(long j, NaviOption naviOption, String str);

    public static final native boolean NaviOption_multiRouteEnable_get(long j, NaviOption naviOption);

    public static final native void NaviOption_multiRouteEnable_set(long j, NaviOption naviOption, boolean z);

    public static final native String NaviOption_naviEngine_get(long j, NaviOption naviOption);

    public static final native void NaviOption_naviEngine_set(long j, NaviOption naviOption, String str);

    public static final native int NaviOption_naviMode_get(long j, NaviOption naviOption);

    public static final native void NaviOption_naviMode_set(long j, NaviOption naviOption, int i);

    public static final native long NaviOption_naviRouteStrategy_get(long j, NaviOption naviOption);

    public static final native void NaviOption_naviRouteStrategy_set(long j, NaviOption naviOption, long j2, NaviRouteStrategy naviRouteStrategy);

    public static final native boolean NaviOption_needTrafficEvent_get(long j, NaviOption naviOption);

    public static final native void NaviOption_needTrafficEvent_set(long j, NaviOption naviOption, boolean z);

    public static final native boolean NaviOption_needTraffic_get(long j, NaviOption naviOption);

    public static final native void NaviOption_needTraffic_set(long j, NaviOption naviOption, boolean z);

    public static final native boolean NaviOption_needmission_get(long j, NaviOption naviOption);

    public static final native void NaviOption_needmission_set(long j, NaviOption naviOption, boolean z);

    public static final native boolean NaviOption_needmjo_get(long j, NaviOption naviOption);

    public static final native void NaviOption_needmjo_set(long j, NaviOption naviOption, boolean z);

    public static final native int NaviOption_ngFlag_get(long j, NaviOption naviOption);

    public static final native void NaviOption_ngFlag_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_ngVersion_get(long j, NaviOption naviOption);

    public static final native void NaviOption_ngVersion_set(long j, NaviOption naviOption, int i);

    public static final native boolean NaviOption_noNeedRainbow_get(long j, NaviOption naviOption);

    public static final native void NaviOption_noNeedRainbow_set(long j, NaviOption naviOption, boolean z);

    public static final native int NaviOption_passNavMode_get(long j, NaviOption naviOption);

    public static final native void NaviOption_passNavMode_set(long j, NaviOption naviOption, int i);

    public static final native boolean NaviOption_restrictToastEnable_get(long j, NaviOption naviOption);

    public static final native void NaviOption_restrictToastEnable_set(long j, NaviOption naviOption, boolean z);

    public static final native int NaviOption_scene_get(long j, NaviOption naviOption);

    public static final native void NaviOption_scene_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_vector_get(long j, NaviOption naviOption);

    public static final native void NaviOption_vector_set(long j, NaviOption naviOption, int i);

    public static final native int NaviOption_yawVersion_get(long j, NaviOption naviOption);

    public static final native void NaviOption_yawVersion_set(long j, NaviOption naviOption, int i);

    public static final native void NaviPoiList_add(long j, NaviPoiList naviPoiList, long j2, NaviPoi naviPoi);

    public static final native long NaviPoiList_capacity(long j, NaviPoiList naviPoiList);

    public static final native void NaviPoiList_clear(long j, NaviPoiList naviPoiList);

    public static final native long NaviPoiList_get(long j, NaviPoiList naviPoiList, int i);

    public static final native boolean NaviPoiList_isEmpty(long j, NaviPoiList naviPoiList);

    public static final native void NaviPoiList_reserve(long j, NaviPoiList naviPoiList, long j2);

    public static final native void NaviPoiList_set(long j, NaviPoiList naviPoiList, int i, long j2, NaviPoi naviPoi);

    public static final native long NaviPoiList_size(long j, NaviPoiList naviPoiList);

    public static final native String NaviPoi_chooseFlag_get(long j, NaviPoi naviPoi);

    public static final native void NaviPoi_chooseFlag_set(long j, NaviPoi naviPoi, String str);

    public static final native long NaviPoi_latLng_get(long j, NaviPoi naviPoi);

    public static final native void NaviPoi_latLng_set(long j, NaviPoi naviPoi, long j2, NaviLatLng naviLatLng);

    public static final native String NaviPoi_name_get(long j, NaviPoi naviPoi);

    public static final native void NaviPoi_name_set(long j, NaviPoi naviPoi, String str);

    public static final native String NaviPoi_uid_get(long j, NaviPoi naviPoi);

    public static final native void NaviPoi_uid_set(long j, NaviPoi naviPoi, String str);

    public static final native int NaviResponse_errorCode_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_errorCode_set(long j, NaviResponse naviResponse, int i);

    public static final native int NaviResponse_extendDataSize_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_extendDataSize_set(long j, NaviResponse naviResponse, int i);

    public static final native long NaviResponse_extendData_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_extendData_set(long j, NaviResponse naviResponse, long j2);

    public static final native int NaviResponse_isMultiRoute_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_isMultiRoute_set(long j, NaviResponse naviResponse, int i);

    public static final native boolean NaviResponse_mandatory_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_mandatory_set(long j, NaviResponse naviResponse, boolean z);

    public static final native long NaviResponse_routes_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_routes_set(long j, NaviResponse naviResponse, long j2, NaviRouteList naviRouteList);

    public static final native long NaviResponse_toastList_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_toastList_set(long j, NaviResponse naviResponse, long j2, NaviToastInfoList naviToastInfoList);

    public static final native int NaviResponse_trafficEventSize_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_trafficEventSize_set(long j, NaviResponse naviResponse, int i);

    public static final native long NaviResponse_trafficEvent_get(long j, NaviResponse naviResponse);

    public static final native void NaviResponse_trafficEvent_set(long j, NaviResponse naviResponse, long j2);

    public static final native void NaviRoadNameList_add(long j, NaviRoadNameList naviRoadNameList, long j2, NaviRoadName naviRoadName);

    public static final native long NaviRoadNameList_capacity(long j, NaviRoadNameList naviRoadNameList);

    public static final native void NaviRoadNameList_clear(long j, NaviRoadNameList naviRoadNameList);

    public static final native long NaviRoadNameList_get(long j, NaviRoadNameList naviRoadNameList, int i);

    public static final native boolean NaviRoadNameList_isEmpty(long j, NaviRoadNameList naviRoadNameList);

    public static final native void NaviRoadNameList_reserve(long j, NaviRoadNameList naviRoadNameList, long j2);

    public static final native void NaviRoadNameList_set(long j, NaviRoadNameList naviRoadNameList, int i, long j2, NaviRoadName naviRoadName);

    public static final native long NaviRoadNameList_size(long j, NaviRoadNameList naviRoadNameList);

    public static final native int NaviRoadName_endNum_get(long j, NaviRoadName naviRoadName);

    public static final native void NaviRoadName_endNum_set(long j, NaviRoadName naviRoadName, int i);

    public static final native String NaviRoadName_name_get(long j, NaviRoadName naviRoadName);

    public static final native void NaviRoadName_name_set(long j, NaviRoadName naviRoadName, String str);

    public static final native int NaviRoadName_startNum_get(long j, NaviRoadName naviRoadName);

    public static final native void NaviRoadName_startNum_set(long j, NaviRoadName naviRoadName, int i);

    public static final native void NaviRouteList_add(long j, NaviRouteList naviRouteList, long j2, NaviRoute naviRoute);

    public static final native long NaviRouteList_capacity(long j, NaviRouteList naviRouteList);

    public static final native void NaviRouteList_clear(long j, NaviRouteList naviRouteList);

    public static final native long NaviRouteList_get(long j, NaviRouteList naviRouteList, int i);

    public static final native boolean NaviRouteList_isEmpty(long j, NaviRouteList naviRouteList);

    public static final native void NaviRouteList_reserve(long j, NaviRouteList naviRouteList, long j2);

    public static final native void NaviRouteList_set(long j, NaviRouteList naviRouteList, int i, long j2, NaviRoute naviRoute);

    public static final native long NaviRouteList_size(long j, NaviRouteList naviRouteList);

    public static final native boolean NaviRouteStrategy_acceptCharge_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_acceptCharge_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_autoRecommend_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_autoRecommend_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_avoidCharge_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_avoidCharge_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_avoidJam_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_avoidJam_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_avoidRestrict_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_avoidRestrict_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_highwayFirst_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_highwayFirst_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_rapidArrival_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_rapidArrival_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_rejectCharge_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_rejectCharge_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native boolean NaviRouteStrategy_timeFirst_get(long j, NaviRouteStrategy naviRouteStrategy);

    public static final native void NaviRouteStrategy_timeFirst_set(long j, NaviRouteStrategy naviRouteStrategy, boolean z);

    public static final native void NaviRouteTagList_add(long j, NaviRouteTagList naviRouteTagList, long j2, NaviRouteTag naviRouteTag);

    public static final native long NaviRouteTagList_capacity(long j, NaviRouteTagList naviRouteTagList);

    public static final native void NaviRouteTagList_clear(long j, NaviRouteTagList naviRouteTagList);

    public static final native long NaviRouteTagList_get(long j, NaviRouteTagList naviRouteTagList, int i);

    public static final native boolean NaviRouteTagList_isEmpty(long j, NaviRouteTagList naviRouteTagList);

    public static final native void NaviRouteTagList_reserve(long j, NaviRouteTagList naviRouteTagList, long j2);

    public static final native void NaviRouteTagList_set(long j, NaviRouteTagList naviRouteTagList, int i, long j2, NaviRouteTag naviRouteTag);

    public static final native long NaviRouteTagList_size(long j, NaviRouteTagList naviRouteTagList);

    public static final native void NaviRouteTagMap_clear(long j, NaviRouteTagMap naviRouteTagMap);

    public static final native void NaviRouteTagMap_del(long j, NaviRouteTagMap naviRouteTagMap, String str);

    public static final native boolean NaviRouteTagMap_empty(long j, NaviRouteTagMap naviRouteTagMap);

    public static final native long NaviRouteTagMap_get(long j, NaviRouteTagMap naviRouteTagMap, String str);

    public static final native boolean NaviRouteTagMap_has_key(long j, NaviRouteTagMap naviRouteTagMap, String str);

    public static final native void NaviRouteTagMap_set(long j, NaviRouteTagMap naviRouteTagMap, String str, long j2, NaviRouteTag naviRouteTag);

    public static final native long NaviRouteTagMap_size(long j, NaviRouteTagMap naviRouteTagMap);

    public static final native String NaviRouteTag_key_get(long j, NaviRouteTag naviRouteTag);

    public static final native void NaviRouteTag_key_set(long j, NaviRouteTag naviRouteTag, String str);

    public static final native long NaviRouteTag_position_get(long j, NaviRouteTag naviRouteTag);

    public static final native void NaviRouteTag_position_set(long j, NaviRouteTag naviRouteTag, long j2, NaviLatLng naviLatLng);

    public static final native String NaviRouteTag_value_get(long j, NaviRouteTag naviRouteTag);

    public static final native void NaviRouteTag_value_set(long j, NaviRouteTag naviRouteTag, String str);

    public static final native double NaviRoute_confidence_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_confidence_set(long j, NaviRoute naviRoute, double d);

    public static final native long NaviRoute_end_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_end_set(long j, NaviRoute naviRoute, long j2, NaviPoi naviPoi);

    public static final native long NaviRoute_fishboneRoadNames_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_fishboneRoadNames_set(long j, NaviRoute naviRoute, long j2, NaviRoadNameList naviRoadNameList);

    public static final native boolean NaviRoute_hasMjoEvent_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_hasMjoEvent_set(long j, NaviRoute naviRoute, boolean z);

    public static final native int NaviRoute_jamCost_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_jamCost_set(long j, NaviRoute naviRoute, int i);

    public static final native int NaviRoute_lightCount_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_lightCount_set(long j, NaviRoute naviRoute, int i);

    public static final native long NaviRoute_lights_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_lights_set(long j, NaviRoute naviRoute, long j2, NaviLatLngList naviLatLngList);

    public static final native long NaviRoute_mjoLinkList_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_mjoLinkList_set(long j, NaviRoute naviRoute, long j2, NaviMJOLinkInfoList naviMJOLinkInfoList);

    public static final native long NaviRoute_originalPassPoints_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_originalPassPoints_set(long j, NaviRoute naviRoute, long j2, NaviPoiList naviPoiList);

    public static final native long NaviRoute_passEdasList_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_passEdasList_set(long j, NaviRoute naviRoute, long j2, IntList intList);

    public static final native long NaviRoute_passEtasList_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_passEtasList_set(long j, NaviRoute naviRoute, long j2, IntList intList);

    public static final native long NaviRoute_passPoints_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_passPoints_set(long j, NaviRoute naviRoute, long j2, PassPointList passPointList);

    public static final native long NaviRoute_pbHandle_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_pbHandle_set(long j, NaviRoute naviRoute, long j2);

    public static final native long NaviRoute_points_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_points_set(long j, NaviRoute naviRoute, long j2, NaviLatLngList naviLatLngList);

    public static final native int NaviRoute_reqEventType_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_reqEventType_set(long j, NaviRoute naviRoute, int i);

    public static final native long NaviRoute_roadNames_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_roadNames_set(long j, NaviRoute naviRoute, long j2, NaviRoadNameList naviRoadNameList);

    public static final native int NaviRoute_routeCnt_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_routeCnt_set(long j, NaviRoute naviRoute, int i);

    public static final native BigInteger NaviRoute_routeId_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_routeId_set(long j, NaviRoute naviRoute, BigInteger bigInteger);

    public static final native int NaviRoute_savingTime_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_savingTime_set(long j, NaviRoute naviRoute, int i);

    public static final native long NaviRoute_sections_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_sections_set(long j, NaviRoute naviRoute, long j2, MarkerSectionList markerSectionList);

    public static final native long NaviRoute_start_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_start_set(long j, NaviRoute naviRoute, long j2, NaviPoi naviPoi);

    public static final native long NaviRoute_tagsList_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_tagsList_set(long j, NaviRoute naviRoute, long j2, NaviRouteTagList naviRouteTagList);

    public static final native long NaviRoute_tagsMap_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_tagsMap_set(long j, NaviRoute naviRoute, long j2, NaviRouteTagMap naviRouteTagMap);

    public static final native int NaviRoute_totalDistance_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_totalDistance_set(long j, NaviRoute naviRoute, int i);

    public static final native int NaviRoute_totalTime_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_totalTime_set(long j, NaviRoute naviRoute, int i);

    public static final native long NaviRoute_trafficIndexs_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_trafficIndexs_set(long j, NaviRoute naviRoute, long j2, IntList intList);

    public static final native long NaviRoute_trafficPoints_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_trafficPoints_set(long j, NaviRoute naviRoute, long j2, NaviLatLngList naviLatLngList);

    public static final native long NaviRoute_tunnelGeoPointList_get(long j, NaviRoute naviRoute);

    public static final native void NaviRoute_tunnelGeoPointList_set(long j, NaviRoute naviRoute, long j2, TunnelGeoPointList tunnelGeoPointList);

    public static final native void NaviToastInfoList_add(long j, NaviToastInfoList naviToastInfoList, long j2, NaviToastInfo naviToastInfo);

    public static final native long NaviToastInfoList_capacity(long j, NaviToastInfoList naviToastInfoList);

    public static final native void NaviToastInfoList_clear(long j, NaviToastInfoList naviToastInfoList);

    public static final native long NaviToastInfoList_get(long j, NaviToastInfoList naviToastInfoList, int i);

    public static final native boolean NaviToastInfoList_isEmpty(long j, NaviToastInfoList naviToastInfoList);

    public static final native void NaviToastInfoList_reserve(long j, NaviToastInfoList naviToastInfoList, long j2);

    public static final native void NaviToastInfoList_set(long j, NaviToastInfoList naviToastInfoList, int i, long j2, NaviToastInfo naviToastInfo);

    public static final native long NaviToastInfoList_size(long j, NaviToastInfoList naviToastInfoList);

    public static final native String NaviToastInfo_content_get(long j, NaviToastInfo naviToastInfo);

    public static final native void NaviToastInfo_content_set(long j, NaviToastInfo naviToastInfo, String str);

    public static final native int NaviToastInfo_type_get(long j, NaviToastInfo naviToastInfo);

    public static final native void NaviToastInfo_type_set(long j, NaviToastInfo naviToastInfo, int i);

    public static final native long NormalNaviAPI_SWIGUpcast(long j);

    public static final native BigInteger OrderInfo_odPointsTimestamp_get(long j, OrderInfo orderInfo);

    public static final native void OrderInfo_odPointsTimestamp_set(long j, OrderInfo orderInfo, BigInteger bigInteger);

    public static final native String OrderInfo_orderId_get(long j, OrderInfo orderInfo);

    public static final native void OrderInfo_orderId_set(long j, OrderInfo orderInfo, String str);

    public static final native int OrderInfo_orderStage_get(long j, OrderInfo orderInfo);

    public static final native void OrderInfo_orderStage_set(long j, OrderInfo orderInfo, int i);

    public static final native long OrderInfo_passPoints_get(long j, OrderInfo orderInfo);

    public static final native void OrderInfo_passPoints_set(long j, OrderInfo orderInfo, long j2, OrderPassPointList orderPassPointList);

    public static final native String OrderInfo_passengerId_get(long j, OrderInfo orderInfo);

    public static final native void OrderInfo_passengerId_set(long j, OrderInfo orderInfo, String str);

    public static final native String OrderInfo_psgMultiRouteTraceId_get(long j, OrderInfo orderInfo);

    public static final native void OrderInfo_psgMultiRouteTraceId_set(long j, OrderInfo orderInfo, String str);

    public static final native String OrderInfo_traverId_get(long j, OrderInfo orderInfo);

    public static final native void OrderInfo_traverId_set(long j, OrderInfo orderInfo, String str);

    public static final native long OrderNaviAPI_SWIGUpcast(long j);

    public static final native void OrderPassPointList_add(long j, OrderPassPointList orderPassPointList, long j2, OrderPassPoint orderPassPoint);

    public static final native long OrderPassPointList_capacity(long j, OrderPassPointList orderPassPointList);

    public static final native void OrderPassPointList_clear(long j, OrderPassPointList orderPassPointList);

    public static final native long OrderPassPointList_get(long j, OrderPassPointList orderPassPointList, int i);

    public static final native boolean OrderPassPointList_isEmpty(long j, OrderPassPointList orderPassPointList);

    public static final native void OrderPassPointList_reserve(long j, OrderPassPointList orderPassPointList, long j2);

    public static final native void OrderPassPointList_set(long j, OrderPassPointList orderPassPointList, int i, long j2, OrderPassPoint orderPassPoint);

    public static final native long OrderPassPointList_size(long j, OrderPassPointList orderPassPointList);

    public static final native BigInteger OrderPassPoint_orderId_get(long j, OrderPassPoint orderPassPoint);

    public static final native void OrderPassPoint_orderId_set(long j, OrderPassPoint orderPassPoint, BigInteger bigInteger);

    public static final native int OrderPassPoint_orderType_get(long j, OrderPassPoint orderPassPoint);

    public static final native void OrderPassPoint_orderType_set(long j, OrderPassPoint orderPassPoint, int i);

    public static final native long OrderPassPoint_poi_get(long j, OrderPassPoint orderPassPoint);

    public static final native void OrderPassPoint_poi_set(long j, OrderPassPoint orderPassPoint, long j2, NaviPoi naviPoi);

    public static final native int OrderPassPoint_pointType_get(long j, OrderPassPoint orderPassPoint);

    public static final native void OrderPassPoint_pointType_set(long j, OrderPassPoint orderPassPoint, int i);

    public static final native void PassPointList_add(long j, PassPointList passPointList, long j2, PassPoint passPoint);

    public static final native long PassPointList_capacity(long j, PassPointList passPointList);

    public static final native void PassPointList_clear(long j, PassPointList passPointList);

    public static final native long PassPointList_get(long j, PassPointList passPointList, int i);

    public static final native boolean PassPointList_isEmpty(long j, PassPointList passPointList);

    public static final native void PassPointList_reserve(long j, PassPointList passPointList, long j2);

    public static final native void PassPointList_set(long j, PassPointList passPointList, int i, long j2, PassPoint passPoint);

    public static final native long PassPointList_size(long j, PassPointList passPointList);

    public static final native int PassPoint_coorIndex_get(long j, PassPoint passPoint);

    public static final native void PassPoint_coorIndex_set(long j, PassPoint passPoint, int i);

    public static final native long PassPoint_passPoint_get(long j, PassPoint passPoint);

    public static final native void PassPoint_passPoint_set(long j, PassPoint passPoint, long j2, NaviPoi naviPoi);

    public static final native int PassPoint_pointIndex_get(long j, PassPoint passPoint);

    public static final native void PassPoint_pointIndex_set(long j, PassPoint passPoint, int i);

    public static final native float RGGPSPoint_t_flpBearing_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_flpBearing_set(long j, RGGPSPoint_t rGGPSPoint_t, float f);

    public static final native float RGGPSPoint_t_flpConfidence_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_flpConfidence_set(long j, RGGPSPoint_t rGGPSPoint_t, float f);

    public static final native int RGGPSPoint_t_flpStatus_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_flpStatus_set(long j, RGGPSPoint_t rGGPSPoint_t, int i);

    public static final native int RGGPSPoint_t_gpsProvider_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_gpsProvider_set(long j, RGGPSPoint_t rGGPSPoint_t, int i);

    public static final native float RGGPSPoint_t_heading_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_heading_set(long j, RGGPSPoint_t rGGPSPoint_t, float f);

    public static final native float RGGPSPoint_t_locationAccuracy_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_locationAccuracy_set(long j, RGGPSPoint_t rGGPSPoint_t, float f);

    public static final native float RGGPSPoint_t_orgAcc_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_orgAcc_set(long j, RGGPSPoint_t rGGPSPoint_t, float f);

    public static final native float RGGPSPoint_t_orgDir_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_orgDir_set(long j, RGGPSPoint_t rGGPSPoint_t, float f);

    public static final native double RGGPSPoint_t_orgLat_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_orgLat_set(long j, RGGPSPoint_t rGGPSPoint_t, double d);

    public static final native double RGGPSPoint_t_orgLng_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_orgLng_set(long j, RGGPSPoint_t rGGPSPoint_t, double d);

    public static final native long RGGPSPoint_t_routeMapPos_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_routeMapPos_set(long j, RGGPSPoint_t rGGPSPoint_t, long j2, RGMapRoutePoint_t rGMapRoutePoint_t);

    public static final native int RGGPSPoint_t_satNum_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_satNum_set(long j, RGGPSPoint_t rGGPSPoint_t, int i);

    public static final native int RGGPSPoint_t_source_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_source_set(long j, RGGPSPoint_t rGGPSPoint_t, int i);

    public static final native int RGGPSPoint_t_timestamp_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_timestamp_set(long j, RGGPSPoint_t rGGPSPoint_t, int i);

    public static final native int RGGPSPoint_t_vdrConf_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_vdrConf_set(long j, RGGPSPoint_t rGGPSPoint_t, int i);

    public static final native float RGGPSPoint_t_velocity_get(long j, RGGPSPoint_t rGGPSPoint_t);

    public static final native void RGGPSPoint_t_velocity_set(long j, RGGPSPoint_t rGGPSPoint_t, float f);

    public static final native long RGGeoPoint_tArray_cast(long j, RGGeoPoint_tArray rGGeoPoint_tArray);

    public static final native long RGGeoPoint_tArray_frompointer(long j, RGGeoPoint_t rGGeoPoint_t);

    public static final native long RGGeoPoint_tArray_getitem(long j, RGGeoPoint_tArray rGGeoPoint_tArray, int i);

    public static final native void RGGeoPoint_tArray_setitem(long j, RGGeoPoint_tArray rGGeoPoint_tArray, int i, long j2, RGGeoPoint_t rGGeoPoint_t);

    public static final native double RGGeoPoint_t_lat_get(long j, RGGeoPoint_t rGGeoPoint_t);

    public static final native void RGGeoPoint_t_lat_set(long j, RGGeoPoint_t rGGeoPoint_t, double d);

    public static final native double RGGeoPoint_t_lng_get(long j, RGGeoPoint_t rGGeoPoint_t);

    public static final native void RGGeoPoint_t_lng_set(long j, RGGeoPoint_t rGGeoPoint_t, double d);

    public static final native int RGMapRoutePoint_t_coorIdx_get(long j, RGMapRoutePoint_t rGMapRoutePoint_t);

    public static final native void RGMapRoutePoint_t_coorIdx_set(long j, RGMapRoutePoint_t rGMapRoutePoint_t, int i);

    public static final native long RGMapRoutePoint_t_geoPoint_get(long j, RGMapRoutePoint_t rGMapRoutePoint_t);

    public static final native void RGMapRoutePoint_t_geoPoint_set(long j, RGMapRoutePoint_t rGMapRoutePoint_t, long j2, RGGeoPoint_t rGGeoPoint_t);

    public static final native double RGMapRoutePoint_t_shapeOffset_get(long j, RGMapRoutePoint_t rGMapRoutePoint_t);

    public static final native void RGMapRoutePoint_t_shapeOffset_set(long j, RGMapRoutePoint_t rGMapRoutePoint_t, double d);

    public static final native long RG_DG_CreateHandler();

    public static final native void RG_DG_DestroyHandler(long j);

    public static final native boolean RG_DG_Match(long j, long j2, RGGPSPoint_t rGGPSPoint_t, long j3, RGGPSPoint_t rGGPSPoint_t2);

    public static final native void RG_DG_SetRoute(long j, long j2, RGGeoPoint_t rGGeoPoint_t, long j3);

    public static final native boolean ReqRouteInfo_hasMjoEvent_get(long j, ReqRouteInfo reqRouteInfo);

    public static final native void ReqRouteInfo_hasMjoEvent_set(long j, ReqRouteInfo reqRouteInfo, boolean z);

    public static final native BigInteger ReqRouteInfo_lastRouteId_get(long j, ReqRouteInfo reqRouteInfo);

    public static final native void ReqRouteInfo_lastRouteId_set(long j, ReqRouteInfo reqRouteInfo, BigInteger bigInteger);

    public static final native long ReqRouteInfo_otherRouteIds_get(long j, ReqRouteInfo reqRouteInfo);

    public static final native void ReqRouteInfo_otherRouteIds_set(long j, ReqRouteInfo reqRouteInfo, long j2, LongList longList);

    public static final native int ReqRouteInfo_passfork_get(long j, ReqRouteInfo reqRouteInfo);

    public static final native void ReqRouteInfo_passfork_set(long j, ReqRouteInfo reqRouteInfo, int i);

    public static final native int ReqRouteInfo_routeCount_get(long j, ReqRouteInfo reqRouteInfo);

    public static final native void ReqRouteInfo_routeCount_set(long j, ReqRouteInfo reqRouteInfo, int i);

    public static final native String ReqRouteInfo_routeScene_get(long j, ReqRouteInfo reqRouteInfo);

    public static final native void ReqRouteInfo_routeScene_set(long j, ReqRouteInfo reqRouteInfo, String str);

    public static final native BigInteger RequestInfo_currentTime_get(long j, RequestInfo requestInfo);

    public static final native void RequestInfo_currentTime_set(long j, RequestInfo requestInfo, BigInteger bigInteger);

    public static final native String RequestInfo_logId_get(long j, RequestInfo requestInfo);

    public static final native void RequestInfo_logId_set(long j, RequestInfo requestInfo, String str);

    public static final native int RequestInfo_seq_get(long j, RequestInfo requestInfo);

    public static final native void RequestInfo_seq_set(long j, RequestInfo requestInfo, int i);

    public static final native String RequestInfo_sessionId_get(long j, RequestInfo requestInfo);

    public static final native void RequestInfo_sessionId_set(long j, RequestInfo requestInfo, String str);

    public static final native String RequestInfo_spanId_get(long j, RequestInfo requestInfo);

    public static final native void RequestInfo_spanId_set(long j, RequestInfo requestInfo, String str);

    public static final native String RequestInfo_traceId_get(long j, RequestInfo requestInfo);

    public static final native void RequestInfo_traceId_set(long j, RequestInfo requestInfo, String str);

    public static final native String RequestInfo_tripId_get(long j, RequestInfo requestInfo);

    public static final native void RequestInfo_tripId_set(long j, RequestInfo requestInfo, String str);

    public static final native int RetryStrategy_getRetryCount(long j, RetryStrategy retryStrategy);

    public static final native int RetryStrategy_increaseRetryCount(long j, RetryStrategy retryStrategy);

    public static final native int RetryStrategy_retryDelayTime(long j, RetryStrategy retryStrategy, int i);

    public static final native boolean RetryStrategy_retryTimesExceeded(long j, RetryStrategy retryStrategy);

    public static final native boolean RetryStrategy_shouldRetry(long j, RetryStrategy retryStrategy, int i);

    public static final native int SCENE_NORMAL_HEAT_get();

    public static final native int SCENE_NORMAL_MARKET_get();

    public static final native int SCENE_NORMAL_NONE_get();

    public static final native int SCENE_NORMAL_NORMAL_PSG_get();

    public static final native int SCENE_NORMAL_NORMAL_RAPID_PSG_get();

    public static final native int SCENE_NORMAL_NORMAL_get();

    public static final native int SCENE_NORMAL_ORDERCARD_get();

    public static final native int SCENE_NORMAL_TOHOTAREA_get();

    public static final native int SCENE_NORMAL_X_get();

    public static final native int SCENE_NORMAL_get();

    public static final native float SafeNotifyInfo_aiUsedSpeed_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_aiUsedSpeed_set(long j, SafeNotifyInfo safeNotifyInfo, float f);

    public static final native int SafeNotifyInfo_duration_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_duration_set(long j, SafeNotifyInfo safeNotifyInfo, int i);

    public static final native long SafeNotifyInfo_geoPoint_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_geoPoint_set(long j, SafeNotifyInfo safeNotifyInfo, long j2, NaviLatLng naviLatLng);

    public static final native int SafeNotifyInfo_interveneType_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_interveneType_set(long j, SafeNotifyInfo safeNotifyInfo, int i);

    public static final native int SafeNotifyInfo_limitSpeed_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_limitSpeed_set(long j, SafeNotifyInfo safeNotifyInfo, int i);

    public static final native BigInteger SafeNotifyInfo_linkId_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_linkId_set(long j, SafeNotifyInfo safeNotifyInfo, BigInteger bigInteger);

    public static final native String SafeNotifyInfo_mapVersion_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_mapVersion_set(long j, SafeNotifyInfo safeNotifyInfo, String str);

    public static final native int SafeNotifyInfo_preFix_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_preFix_set(long j, SafeNotifyInfo safeNotifyInfo, int i);

    public static final native int SafeNotifyInfo_timestamp_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_timestamp_set(long j, SafeNotifyInfo safeNotifyInfo, int i);

    public static final native String SafeNotifyInfo_ttsContent_get(long j, SafeNotifyInfo safeNotifyInfo);

    public static final native void SafeNotifyInfo_ttsContent_set(long j, SafeNotifyInfo safeNotifyInfo, String str);

    public static final native void SetApolloCallBack(long j);

    public static final native void StringList_add(long j, StringList stringList, String str);

    public static final native long StringList_capacity(long j, StringList stringList);

    public static final native void StringList_clear(long j, StringList stringList);

    public static final native String StringList_get(long j, StringList stringList, int i);

    public static final native boolean StringList_isEmpty(long j, StringList stringList);

    public static final native void StringList_reserve(long j, StringList stringList, long j2);

    public static final native void StringList_set(long j, StringList stringList, int i, String str);

    public static final native long StringList_size(long j, StringList stringList);

    public static final native void StringMap_clear(long j, StringMap stringMap);

    public static final native void StringMap_del(long j, StringMap stringMap, String str);

    public static final native boolean StringMap_empty(long j, StringMap stringMap);

    public static final native String StringMap_get(long j, StringMap stringMap, String str);

    public static final native boolean StringMap_has_key(long j, StringMap stringMap, String str);

    public static final native void StringMap_set(long j, StringMap stringMap, String str, String str2);

    public static final native long StringMap_size(long j, StringMap stringMap);

    public static final native void TrafficEventPointList_add(long j, TrafficEventPointList trafficEventPointList, long j2, TrafficEventPoint trafficEventPoint);

    public static final native long TrafficEventPointList_capacity(long j, TrafficEventPointList trafficEventPointList);

    public static final native void TrafficEventPointList_clear(long j, TrafficEventPointList trafficEventPointList);

    public static final native long TrafficEventPointList_get(long j, TrafficEventPointList trafficEventPointList, int i);

    public static final native boolean TrafficEventPointList_isEmpty(long j, TrafficEventPointList trafficEventPointList);

    public static final native void TrafficEventPointList_reserve(long j, TrafficEventPointList trafficEventPointList, long j2);

    public static final native void TrafficEventPointList_set(long j, TrafficEventPointList trafficEventPointList, int i, long j2, TrafficEventPoint trafficEventPoint);

    public static final native long TrafficEventPointList_size(long j, TrafficEventPointList trafficEventPointList);

    public static final native int TrafficEventPoint_coorIdx_get(long j, TrafficEventPoint trafficEventPoint);

    public static final native void TrafficEventPoint_coorIdx_set(long j, TrafficEventPoint trafficEventPoint, int i);

    public static final native int TrafficEventPoint_shapeOffset_get(long j, TrafficEventPoint trafficEventPoint);

    public static final native void TrafficEventPoint_shapeOffset_set(long j, TrafficEventPoint trafficEventPoint, int i);

    public static final native void TrafficNaviAPI_cancel(long j, TrafficNaviAPI trafficNaviAPI);

    public static final native void TrafficNaviAPI_execute(long j, TrafficNaviAPI trafficNaviAPI);

    public static final native long TrafficNaviAPI_getRequestData(long j, TrafficNaviAPI trafficNaviAPI);

    public static final native int TrafficNaviAPI_getRequestDataLength(long j, TrafficNaviAPI trafficNaviAPI);

    public static final native void TrafficNaviAPI_onResponse(long j, TrafficNaviAPI trafficNaviAPI, byte[] bArr, int i, int i2);

    public static final native void TrafficNaviAPI_setCallback(long j, TrafficNaviAPI trafficNaviAPI, long j2, APITrafficRequestCallback aPITrafficRequestCallback);

    public static final native void TrafficNaviAPI_setHelper(long j, TrafficNaviAPI trafficNaviAPI, long j2, APIRequestHelper aPIRequestHelper);

    public static final native void TrafficNaviAPI_setNaviInfo(long j, TrafficNaviAPI trafficNaviAPI, long j2, NaviInfo naviInfo);

    public static final native long TrafficResponse_etas_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_etas_set(long j, TrafficResponse trafficResponse, long j2, IntList intList);

    public static final native int TrafficResponse_expireTime_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_expireTime_set(long j, TrafficResponse trafficResponse, int i);

    public static final native int TrafficResponse_extendDataSize_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_extendDataSize_set(long j, TrafficResponse trafficResponse, int i);

    public static final native long TrafficResponse_extendData_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_extendData_set(long j, TrafficResponse trafficResponse, long j2);

    public static final native int TrafficResponse_naviEventsSize_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_naviEventsSize_set(long j, TrafficResponse trafficResponse, int i);

    public static final native long TrafficResponse_naviEvents_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_naviEvents_set(long j, TrafficResponse trafficResponse, long j2);

    public static final native BigInteger TrafficResponse_serverTimestamp_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_serverTimestamp_set(long j, TrafficResponse trafficResponse, BigInteger bigInteger);

    public static final native int TrafficResponse_trafficEventSize_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_trafficEventSize_set(long j, TrafficResponse trafficResponse, int i);

    public static final native long TrafficResponse_trafficEvent_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_trafficEvent_set(long j, TrafficResponse trafficResponse, long j2);

    public static final native long TrafficResponse_trafficIndexs_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_trafficIndexs_set(long j, TrafficResponse trafficResponse, long j2, IntList intList);

    public static final native long TrafficResponse_trafficPoints_get(long j, TrafficResponse trafficResponse);

    public static final native void TrafficResponse_trafficPoints_set(long j, TrafficResponse trafficResponse, long j2, NaviLatLngList naviLatLngList);

    public static final native void TunnelGeoPointList_add(long j, TunnelGeoPointList tunnelGeoPointList, long j2, TunnelGeoPoint tunnelGeoPoint);

    public static final native long TunnelGeoPointList_capacity(long j, TunnelGeoPointList tunnelGeoPointList);

    public static final native void TunnelGeoPointList_clear(long j, TunnelGeoPointList tunnelGeoPointList);

    public static final native long TunnelGeoPointList_get(long j, TunnelGeoPointList tunnelGeoPointList, int i);

    public static final native boolean TunnelGeoPointList_isEmpty(long j, TunnelGeoPointList tunnelGeoPointList);

    public static final native void TunnelGeoPointList_reserve(long j, TunnelGeoPointList tunnelGeoPointList, long j2);

    public static final native void TunnelGeoPointList_set(long j, TunnelGeoPointList tunnelGeoPointList, int i, long j2, TunnelGeoPoint tunnelGeoPoint);

    public static final native long TunnelGeoPointList_size(long j, TunnelGeoPointList tunnelGeoPointList);

    public static final native int TunnelGeoPoint_defaultSpeed_get(long j, TunnelGeoPoint tunnelGeoPoint);

    public static final native void TunnelGeoPoint_defaultSpeed_set(long j, TunnelGeoPoint tunnelGeoPoint, int i);

    public static final native int TunnelGeoPoint_end_get(long j, TunnelGeoPoint tunnelGeoPoint);

    public static final native void TunnelGeoPoint_end_set(long j, TunnelGeoPoint tunnelGeoPoint, int i);

    public static final native int TunnelGeoPoint_index_get(long j, TunnelGeoPoint tunnelGeoPoint);

    public static final native void TunnelGeoPoint_index_set(long j, TunnelGeoPoint tunnelGeoPoint, int i);

    public static final native int TunnelGeoPoint_lat_get(long j, TunnelGeoPoint tunnelGeoPoint);

    public static final native void TunnelGeoPoint_lat_set(long j, TunnelGeoPoint tunnelGeoPoint, int i);

    public static final native int TunnelGeoPoint_lng_get(long j, TunnelGeoPoint tunnelGeoPoint);

    public static final native void TunnelGeoPoint_lng_set(long j, TunnelGeoPoint tunnelGeoPoint, int i);

    public static final native int UserInfo_bizType_get(long j, UserInfo userInfo);

    public static final native void UserInfo_bizType_set(long j, UserInfo userInfo, int i);

    public static final native String UserInfo_cityId_get(long j, UserInfo userInfo);

    public static final native void UserInfo_cityId_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_countryId_get(long j, UserInfo userInfo);

    public static final native void UserInfo_countryId_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_deviceId_get(long j, UserInfo userInfo);

    public static final native void UserInfo_deviceId_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_didiVersion_get(long j, UserInfo userInfo);

    public static final native void UserInfo_didiVersion_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_imei_get(long j, UserInfo userInfo);

    public static final native void UserInfo_imei_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_os_get(long j, UserInfo userInfo);

    public static final native void UserInfo_os_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_phone_get(long j, UserInfo userInfo);

    public static final native void UserInfo_phone_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_plateNumber_get(long j, UserInfo userInfo);

    public static final native void UserInfo_plateNumber_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_ticket_get(long j, UserInfo userInfo);

    public static final native void UserInfo_ticket_set(long j, UserInfo userInfo, String str);

    public static final native String UserInfo_userId_get(long j, UserInfo userInfo);

    public static final native void UserInfo_userId_set(long j, UserInfo userInfo, String str);

    public static final native long YawRetryStrategy_SWIGUpcast(long j);

    public static final native String ZIP_FILE_get();

    public static final native void delete_APIRequestCallback(long j);

    public static final native void delete_APIRequestHelper(long j);

    public static final native void delete_APITrafficRequestCallback(long j);

    public static final native void delete_AnalysisLog(long j);

    public static final native void delete_AnalysisLogList(long j);

    public static final native void delete_ApolloCallBack(long j);

    public static final native void delete_ApolloExperiment(long j);

    public static final native void delete_ApolloToggle(long j);

    public static final native void delete_BaseNaviAPI(long j);

    public static final native void delete_BindNaviLocation(long j);

    public static final native void delete_CharArray(long j);

    public static final native void delete_DefaultRetryStrategy(long j);

    public static final native void delete_FirstRetryStrategy(long j);

    public static final native void delete_GpsHealthInfo(long j);

    public static final native void delete_IntList(long j);

    public static final native void delete_LongList(long j);

    public static final native void delete_MarkerSection(long j);

    public static final native void delete_MarkerSectionList(long j);

    public static final native void delete_MatchedRouteInfo(long j);

    public static final native void delete_MissionButtonInfo(long j);

    public static final native void delete_MissionButtonList(long j);

    public static final native void delete_NaviCamera(long j);

    public static final native void delete_NaviCameraList(long j);

    public static final native void delete_NaviEngine(long j);

    public static final native void delete_NaviEngineVP(long j);

    public static final native void delete_NaviEventCallback(long j);

    public static final native void delete_NaviGetter(long j);

    public static final native void delete_NaviInfo(long j);

    public static final native void delete_NaviLatLng(long j);

    public static final native void delete_NaviLatLngList(long j);

    public static final native void delete_NaviLocation(long j);

    public static final native void delete_NaviLocationList(long j);

    public static final native void delete_NaviMJOLinkInfo(long j);

    public static final native void delete_NaviMJOLinkInfoList(long j);

    public static final native void delete_NaviOption(long j);

    public static final native void delete_NaviPoi(long j);

    public static final native void delete_NaviPoiList(long j);

    public static final native void delete_NaviResponse(long j);

    public static final native void delete_NaviRoadName(long j);

    public static final native void delete_NaviRoadNameList(long j);

    public static final native void delete_NaviRoute(long j);

    public static final native void delete_NaviRouteList(long j);

    public static final native void delete_NaviRouteStrategy(long j);

    public static final native void delete_NaviRouteTag(long j);

    public static final native void delete_NaviRouteTagList(long j);

    public static final native void delete_NaviRouteTagMap(long j);

    public static final native void delete_NaviToastInfo(long j);

    public static final native void delete_NaviToastInfoList(long j);

    public static final native void delete_NormalNaviAPI(long j);

    public static final native void delete_OrderInfo(long j);

    public static final native void delete_OrderNaviAPI(long j);

    public static final native void delete_OrderPassPoint(long j);

    public static final native void delete_OrderPassPointList(long j);

    public static final native void delete_PassPoint(long j);

    public static final native void delete_PassPointList(long j);

    public static final native void delete_RGGPSPoint_t(long j);

    public static final native void delete_RGGeoPoint_t(long j);

    public static final native void delete_RGGeoPoint_tArray(long j);

    public static final native void delete_RGMapRoutePoint_t(long j);

    public static final native void delete_ReqRouteInfo(long j);

    public static final native void delete_RequestInfo(long j);

    public static final native void delete_RetryStrategy(long j);

    public static final native void delete_SafeNotifyInfo(long j);

    public static final native void delete_StringList(long j);

    public static final native void delete_StringMap(long j);

    public static final native void delete_TrafficEventPoint(long j);

    public static final native void delete_TrafficEventPointList(long j);

    public static final native void delete_TrafficNaviAPI(long j);

    public static final native void delete_TrafficResponse(long j);

    public static final native void delete_TunnelGeoPoint(long j);

    public static final native void delete_TunnelGeoPointList(long j);

    public static final native void delete_UserInfo(long j);

    public static final native void delete_YawRetryStrategy(long j);

    public static final native long new_APIRequestCallback();

    public static final native long new_APIRequestHelper();

    public static final native long new_APITrafficRequestCallback();

    public static final native long new_AnalysisLog();

    public static final native long new_AnalysisLogList__SWIG_0();

    public static final native long new_AnalysisLogList__SWIG_1(long j);

    public static final native long new_ApolloCallBack();

    public static final native long new_ApolloExperiment();

    public static final native long new_ApolloToggle();

    public static final native long new_BindNaviLocation();

    public static final native long new_CharArray(int i);

    public static final native long new_DefaultRetryStrategy();

    public static final native long new_FirstRetryStrategy();

    public static final native long new_GpsHealthInfo();

    public static final native long new_IntList__SWIG_0();

    public static final native long new_IntList__SWIG_1(long j);

    public static final native long new_LongList__SWIG_0();

    public static final native long new_LongList__SWIG_1(long j);

    public static final native long new_MarkerSection();

    public static final native long new_MarkerSectionList__SWIG_0();

    public static final native long new_MarkerSectionList__SWIG_1(long j);

    public static final native long new_MatchedRouteInfo();

    public static final native long new_MissionButtonInfo();

    public static final native long new_MissionButtonList__SWIG_0();

    public static final native long new_MissionButtonList__SWIG_1(long j);

    public static final native long new_NaviCamera();

    public static final native long new_NaviCameraList__SWIG_0();

    public static final native long new_NaviCameraList__SWIG_1(long j);

    public static final native long new_NaviEngine(long j, NaviEventCallback naviEventCallback, long j2, NaviGetter naviGetter);

    public static final native long new_NaviEngineVP();

    public static final native long new_NaviEventCallback();

    public static final native long new_NaviGetter();

    public static final native long new_NaviInfo();

    public static final native long new_NaviLatLng();

    public static final native long new_NaviLatLngList__SWIG_0();

    public static final native long new_NaviLatLngList__SWIG_1(long j);

    public static final native long new_NaviLocation();

    public static final native long new_NaviLocationList__SWIG_0();

    public static final native long new_NaviLocationList__SWIG_1(long j);

    public static final native long new_NaviMJOLinkInfo();

    public static final native long new_NaviMJOLinkInfoList__SWIG_0();

    public static final native long new_NaviMJOLinkInfoList__SWIG_1(long j);

    public static final native long new_NaviOption();

    public static final native long new_NaviPoi();

    public static final native long new_NaviPoiList__SWIG_0();

    public static final native long new_NaviPoiList__SWIG_1(long j);

    public static final native long new_NaviResponse();

    public static final native long new_NaviRoadName();

    public static final native long new_NaviRoadNameList__SWIG_0();

    public static final native long new_NaviRoadNameList__SWIG_1(long j);

    public static final native long new_NaviRoute();

    public static final native long new_NaviRouteList__SWIG_0();

    public static final native long new_NaviRouteList__SWIG_1(long j);

    public static final native long new_NaviRouteStrategy();

    public static final native long new_NaviRouteTag();

    public static final native long new_NaviRouteTagList__SWIG_0();

    public static final native long new_NaviRouteTagList__SWIG_1(long j);

    public static final native long new_NaviRouteTagMap__SWIG_0();

    public static final native long new_NaviRouteTagMap__SWIG_1(long j, NaviRouteTagMap naviRouteTagMap);

    public static final native long new_NaviToastInfo();

    public static final native long new_NaviToastInfoList__SWIG_0();

    public static final native long new_NaviToastInfoList__SWIG_1(long j);

    public static final native long new_NormalNaviAPI(long j, UserInfo userInfo, long j2, NaviOption naviOption);

    public static final native long new_OrderInfo();

    public static final native long new_OrderNaviAPI(long j, UserInfo userInfo, long j2, OrderInfo orderInfo, long j3, NaviOption naviOption);

    public static final native long new_OrderPassPoint();

    public static final native long new_OrderPassPointList__SWIG_0();

    public static final native long new_OrderPassPointList__SWIG_1(long j);

    public static final native long new_PassPoint();

    public static final native long new_PassPointList__SWIG_0();

    public static final native long new_PassPointList__SWIG_1(long j);

    public static final native long new_RGGPSPoint_t();

    public static final native long new_RGGeoPoint_t();

    public static final native long new_RGGeoPoint_tArray(int i);

    public static final native long new_RGMapRoutePoint_t();

    public static final native long new_ReqRouteInfo();

    public static final native long new_RequestInfo();

    public static final native long new_SafeNotifyInfo();

    public static final native long new_StringList__SWIG_0();

    public static final native long new_StringList__SWIG_1(long j);

    public static final native long new_StringMap__SWIG_0();

    public static final native long new_StringMap__SWIG_1(long j, StringMap stringMap);

    public static final native long new_TrafficEventPoint();

    public static final native long new_TrafficEventPointList__SWIG_0();

    public static final native long new_TrafficEventPointList__SWIG_1(long j);

    public static final native long new_TrafficNaviAPI(long j, OrderInfo orderInfo, long j2, UserInfo userInfo, long j3, NaviOption naviOption);

    public static final native long new_TrafficResponse();

    public static final native long new_TunnelGeoPoint();

    public static final native long new_TunnelGeoPointList__SWIG_0();

    public static final native long new_TunnelGeoPointList__SWIG_1(long j);

    public static final native long new_UserInfo();

    public static final native long new_YawRetryStrategy();

    public static final native void setUseStatisticMalloc(boolean z, int i, int i2);

    private static final native void swig_module_init();

    static {
        try {
            System.loadLibrary(StringConstant.LIB_NAV);
            LogJavaInit();
            ApolloInit();
            setUseStatisticMalloc();
            C17407r.trackLoadSoStatusInfo("libhawiinav.so", "NaviBusinessJNI", "success");
        } catch (Throwable th) {
            th.printStackTrace();
            C17407r.trackLoadSoStatusInfo("libhawiinav.so", "NaviBusinessJNI", "failed");
        }
        swig_module_init();
    }

    public static void printNative(int i, String str) {
        HWLog.printNative(i, str);
    }

    public static void setApolloImpToNav() {
        C17411v.setApolloImpToNav();
    }

    public static void setUseStatisticMalloc() {
        setUseStatisticMalloc(C17406q.m37045h(), C17406q.m37046i(), C17406q.m37047j());
    }

    public static long SwigDirector_APIRequestHelper_getRequestInfo(APIRequestHelper aPIRequestHelper) {
        return RequestInfo.getCPtr(aPIRequestHelper.getRequestInfo());
    }

    public static void SwigDirector_APIRequestHelper_onPost(APIRequestHelper aPIRequestHelper, int i, String str, long j, int i2) {
        aPIRequestHelper.onPost(i, str, j == 0 ? null : new SWIGTYPE_p_unsigned_char(j, false), i2);
    }

    public static void SwigDirector_APIRequestCallback_onBegin(APIRequestCallback aPIRequestCallback) {
        aPIRequestCallback.onBegin();
    }

    public static void SwigDirector_APIRequestCallback_onRetry(APIRequestCallback aPIRequestCallback, int i) {
        aPIRequestCallback.onRetry(i);
    }

    public static void SwigDirector_APIRequestCallback_onFinish(APIRequestCallback aPIRequestCallback, long j) {
        aPIRequestCallback.onFinish(j == 0 ? null : new NaviResponse(j, false));
    }

    public static void SwigDirector_APITrafficRequestCallback_onBegin(APITrafficRequestCallback aPITrafficRequestCallback) {
        aPITrafficRequestCallback.onBegin();
    }

    public static void SwigDirector_APITrafficRequestCallback_onFinish(APITrafficRequestCallback aPITrafficRequestCallback, long j) {
        aPITrafficRequestCallback.onFinish(j == 0 ? null : new TrafficResponse(j, false));
    }

    public static void SwigDirector_NaviEventCallback_onVoiceEvent(NaviEventCallback naviEventCallback, String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        naviEventCallback.onVoiceEvent(str, str2, i, i2, i3, i4, i5, i6, i7);
    }

    public static void SwigDirector_NaviEventCallback_onArrivedEvent(NaviEventCallback naviEventCallback, boolean z, long j, long j2, long j3, int i, int i2) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        NaviLatLng naviLatLng = null;
        NaviLatLng naviLatLng2 = j4 == 0 ? null : new NaviLatLng(j4, false);
        NaviLatLng naviLatLng3 = j5 == 0 ? null : new NaviLatLng(j5, false);
        if (j6 != 0) {
            naviLatLng = new NaviLatLng(j6, false);
        }
        naviEventCallback.onArrivedEvent(z, naviLatLng2, naviLatLng3, naviLatLng, i, i2);
    }

    public static void SwigDirector_NaviEventCallback_onCameraEvent(NaviEventCallback naviEventCallback, int i, long j, int i2) {
        naviEventCallback.onCameraEvent(i, new NaviCameraList(j, true), i2);
    }

    public static void SwigDirector_NaviEventCallback_onCongestionEvent(NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5, int i6) {
        naviEventCallback.onCongestionEvent(i, i2, i3, i4, i5, i6);
    }

    public static void SwigDirector_NaviEventCallback_onDestinationEvent(NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5) {
        naviEventCallback.onDestinationEvent(i, i2, i3, i4, i5);
    }

    public static void SwigDirector_NaviEventCallback_onDownloadEvent(NaviEventCallback naviEventCallback, long j) {
        naviEventCallback.onDownloadEvent(j == 0 ? null : new StringList(j, false));
    }

    public static void SwigDirector_NaviEventCallback_onDownloadVecEvent(NaviEventCallback naviEventCallback, String str, String str2, long j, int i) {
        naviEventCallback.onDownloadVecEvent(str, str2, j == 0 ? null : new SWIGTYPE_p_unsigned_char(j, false), i);
    }

    public static void SwigDirector_NaviEventCallback_onEnlargeMapEvent(NaviEventCallback naviEventCallback, int i, String str, String str2) {
        naviEventCallback.onEnlargeMapEvent(i, str, str2);
    }

    public static void SwigDirector_NaviEventCallback_onIllegalParkEvent(NaviEventCallback naviEventCallback, int i, int i2, int i3, String str, String str2, long j, long j2) {
        long j3 = j;
        long j4 = j2;
        NaviLatLng naviLatLng = null;
        NaviLatLng naviLatLng2 = j3 == 0 ? null : new NaviLatLng(j3, false);
        if (j4 != 0) {
            naviLatLng = new NaviLatLng(j4, false);
        }
        naviEventCallback.onIllegalParkEvent(i, i2, i3, str, str2, naviLatLng2, naviLatLng);
    }

    public static void SwigDirector_NaviEventCallback_onIntersectionEvent(NaviEventCallback naviEventCallback, int i, String str, String str2, int i2, int i3, int i4, long j, int i5, int i6, String str3, boolean z, int i7) {
        naviEventCallback.onIntersectionEvent(i, str, str2, i2, i3, i4, new NaviLatLng(j, true), i5, i6, str3, z, i7);
    }

    public static void SwigDirector_NaviEventCallback_onLaneEvent(NaviEventCallback naviEventCallback, int i, String str, String str2, String str3, int i2, int i3, BigInteger bigInteger, long j, int i4) {
        naviEventCallback.onLaneEvent(i, str, str2, str3, i2, i3, bigInteger, new NaviLatLng(j, true), i4);
    }

    public static void SwigDirector_NaviEventCallback_onLimitSpeedCameraEvent(NaviEventCallback naviEventCallback, int i, int i2, int i3, long j, String str) {
        naviEventCallback.onLimitSpeedCameraEvent(i, i2, i3, j == 0 ? null : new NaviLatLng(j, false), str);
    }

    public static void SwigDirector_NaviEventCallback_onMatchLocationEvent(NaviEventCallback naviEventCallback, BigInteger bigInteger, long j, int i, int i2, double d, int i3) {
        naviEventCallback.onMatchLocationEvent(bigInteger, j == 0 ? null : new NaviLocation(j, false), i, i2, d, i3);
    }

    public static void SwigDirector_NaviEventCallback_onMissionEvent(NaviEventCallback naviEventCallback, long j, int i, String str, String str2, long j2, long j3, int i2, BigInteger bigInteger, long j4, int i3, String str3) {
        long j5 = j3;
        long j6 = j4;
        naviEventCallback.onMissionEvent(j, i, str, str2, new NaviLatLng(j2, true), j5 == 0 ? null : new SWIGTYPE_p_unsigned_char(j5, false), i2, bigInteger, j6 == 0 ? null : new MissionButtonList(j6, false), i3, str3);
    }

    public static void SwigDirector_NaviEventCallback_onDownloadMJOEvent(NaviEventCallback naviEventCallback, long j, String str, String str2, String str3) {
        naviEventCallback.onDownloadMJOEvent(j, str, str2, str3);
    }

    public static void SwigDirector_NaviEventCallback_onMJOEvent(NaviEventCallback naviEventCallback, int i, long j, String str, BigInteger bigInteger) {
        naviEventCallback.onMJOEvent(i, j, str, bigInteger);
    }

    public static void SwigDirector_NaviEventCallback_onYawEvent(NaviEventCallback naviEventCallback, long j, int i, int i2) {
        naviEventCallback.onYawEvent(j == 0 ? null : new BindNaviLocation(j, false), i, i2);
    }

    public static void SwigDirector_NaviEventCallback_onParallelRoadEvent(NaviEventCallback naviEventCallback, int i, int i2) {
        naviEventCallback.onParallelRoadEvent(i, i2);
    }

    public static void SwigDirector_NaviEventCallback_onPassPointVerifyEvent(NaviEventCallback naviEventCallback, int i) {
        naviEventCallback.onPassPointVerifyEvent(i);
    }

    public static void SwigDirector_NaviEventCallback_onQRPayEvent(NaviEventCallback naviEventCallback, int i, BigInteger bigInteger) {
        naviEventCallback.onQRPayEvent(i, bigInteger);
    }

    public static void SwigDirector_NaviEventCallback_onSlopeInfoEvent(NaviEventCallback naviEventCallback, int i) {
        naviEventCallback.onSlopeInfoEvent(i);
    }

    public static void SwigDirector_NaviEventCallback_onSpeedIconEvent(NaviEventCallback naviEventCallback, int i, int i2, int i3, int i4, int i5, float f, int i6) {
        naviEventCallback.onSpeedIconEvent(i, i2, i3, i4, i5, f, i6);
    }

    public static void SwigDirector_NaviEventCallback_onVDRInfoEvent(NaviEventCallback naviEventCallback, BigInteger bigInteger, double d, double d2, float f, int i, int i2) {
        naviEventCallback.onVDRInfoEvent(bigInteger, d, d2, f, i, i2);
    }

    public static void SwigDirector_NaviEventCallback_onVecEnlargeMapEvent(NaviEventCallback naviEventCallback, int i, String str, String str2) {
        naviEventCallback.onVecEnlargeMapEvent(i, str, str2);
    }

    public static void SwigDirector_NaviEventCallback_onRoutesEvent(NaviEventCallback naviEventCallback, long j, int i) {
        naviEventCallback.onRoutesEvent(j == 0 ? null : new LongList(j, false), i);
    }

    public static void SwigDirector_NaviEventCallback_onMoreRouteEvent(NaviEventCallback naviEventCallback, int i, String str) {
        naviEventCallback.onMoreRouteEvent(i, str);
    }

    public static void SwigDirector_NaviEventCallback_onAnalysisEvent(NaviEventCallback naviEventCallback, String str, long j) {
        naviEventCallback.onAnalysisEvent(str, j == 0 ? null : new AnalysisLogList(j, false));
    }

    public static void SwigDirector_NaviEventCallback_onToastText(NaviEventCallback naviEventCallback, int i, String str) {
        naviEventCallback.onToastText(i, str);
    }

    public static String SwigDirector_NaviGetter_getTextByKey(NaviGetter naviGetter, String str) {
        return naviGetter.getTextByKey(str);
    }

    public static long SwigDirector_ApolloCallBack_getToggle(ApolloCallBack apolloCallBack, byte[] bArr) {
        return ApolloToggle.getCPtr(apolloCallBack.getToggle(bArr));
    }

    public static int SwigDirector_ApolloExperiment_getParam__SWIG_0(ApolloExperiment apolloExperiment, byte[] bArr, int i) {
        return apolloExperiment.getParam(bArr, i);
    }

    public static float SwigDirector_ApolloExperiment_getParam__SWIG_1(ApolloExperiment apolloExperiment, byte[] bArr, float f) {
        return apolloExperiment.getParam(bArr, f);
    }

    public static String SwigDirector_ApolloExperiment_getParam__SWIG_2(ApolloExperiment apolloExperiment, byte[] bArr, String str) {
        return apolloExperiment.getParam(bArr, str);
    }

    public static long SwigDirector_ApolloToggle_getExperiment(ApolloToggle apolloToggle) {
        return ApolloExperiment.getCPtr(apolloToggle.getExperiment());
    }

    public static boolean SwigDirector_ApolloToggle_allow(ApolloToggle apolloToggle) {
        return apolloToggle.allow();
    }
}
