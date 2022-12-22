package com.didi.hawaii.p118ar.jni;

import com.didi.hawaii.p118ar.jni.DARCAlert;
import com.didi.hawaii.p118ar.jni.DARCAskResponse;

/* renamed from: com.didi.hawaii.ar.jni.AREngineJNIBridge */
final class AREngineJNIBridge {
    public static final native long ARCreate(long j, long j2, DARCNAVCreateData dARCNAVCreateData, Object obj, Object obj2);

    public static final native void ARDestory(long j, long j2);

    public static final native void ARSetCallbacks(long j, long j2, long j3, SwigARCallback swigARCallback);

    public static final native long ARZGCreate(long j, long j2, DARCZGNavCreateData dARCZGNavCreateData, Object obj, Object obj2);

    public static final native void ARZGDestory(long j, long j2);

    public static final native void ARZGSetCallbacks(long j, long j2, long j3, SwigARCallback swigARCallback);

    public static final native int DARCARImage_DetectARPoseState(long j, DARCARImage dARCARImage, long j2, DARCMatrix4F dARCMatrix4F, long j3, DARCMatrix4F dARCMatrix4F2, long j4, DARCPoint3F dARCPoint3F, float f);

    public static final native long DARCARImage_GPSData_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_GPSData_set(long j, DARCARImage dARCARImage, long j2, DARCGPSData dARCGPSData);

    public static final native long DARCARImage_GPSOriginData_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_GPSOriginData_set(long j, DARCARImage dARCARImage, long j2, DARCGPSData dARCGPSData);

    public static final native long DARCARImage_SWIGUpcast(long j);

    public static final native float DARCARImage_airPressure_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_airPressure_set(long j, DARCARImage dARCARImage, float f);

    public static final native long DARCARImage_alloc();

    public static final native float DARCARImage_ambientColorTemperature_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_ambientColorTemperature_set(long j, DARCARImage dARCARImage, float f);

    public static final native float DARCARImage_ambientIntensity_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_ambientIntensity_set(long j, DARCARImage dARCARImage, float f);

    public static final native double DARCARImage_arOriginTimeStamp_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_arOriginTimeStamp_set(long j, DARCARImage dARCARImage, double d);

    public static final native long DARCARImage_attitudeMatrix_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_attitudeMatrix_set(long j, DARCARImage dARCARImage, long j2, DARCMatrix3F dARCMatrix3F);

    public static final native long DARCARImage_eulerAngle_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_eulerAngle_set(long j, DARCARImage dARCARImage, long j2, DARCPoint3F dARCPoint3F);

    public static final native int DARCARImage_featurePointCount_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_featurePointCount_set(long j, DARCARImage dARCARImage, int i);

    public static final native long DARCARImage_getCompressedData(long j, DARCARImage dARCARImage);

    public static final native long DARCARImage_getDib(long j, DARCARImage dARCARImage);

    public static final native int DARCARImage_groupID_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_groupID_set(long j, DARCARImage dARCARImage, int i);

    public static final native int DARCARImage_height_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_height_set(long j, DARCARImage dARCARImage, int i);

    public static final native long DARCARImage_intrinsics_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_intrinsics_set(long j, DARCARImage dARCARImage, long j2, DARCMatrix3F dARCMatrix3F);

    public static final native boolean DARCARImage_isGPSInit_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_isGPSInit_set(long j, DARCARImage dARCARImage, boolean z);

    public static final native boolean DARCARImage_isStartPDRZG_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_isStartPDRZG_set(long j, DARCARImage dARCARImage, boolean z);

    public static final native boolean DARCARImage_isStartPDR_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_isStartPDR_set(long j, DARCARImage dARCARImage, boolean z);

    public static final native int DARCARImage_m_ARDriftNumberInInit_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_m_ARDriftNumberInInit_set(long j, DARCARImage dARCARImage, int i);

    public static final native int DARCARImage_m_ARDriftNumberInNavi_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_m_ARDriftNumberInNavi_set(long j, DARCARImage dARCARImage, int i);

    public static final native long DARCARImage_m_PDRStateReason_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_m_PDRStateReason_set(long j, DARCARImage dARCARImage, long j2);

    public static final native long DARCARImage_m_PDRState_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_m_PDRState_set(long j, DARCARImage dARCARImage, long j2);

    public static final native long DARCARImage_sceneLocation_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_sceneLocation_set(long j, DARCARImage dARCARImage, long j2, DARCLocationInScene dARCLocationInScene);

    public static final native double DARCARImage_score_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_score_set(long j, DARCARImage dARCARImage, double d);

    public static final native void DARCARImage_setCompressedData(long j, DARCARImage dARCARImage, long j2, DARCData dARCData);

    public static final native void DARCARImage_setDib(long j, DARCARImage dARCARImage, long j2, DARCData dARCData);

    public static final native void DARCARImage_setOSImage(long j, DARCARImage dARCARImage, Object obj);

    public static final native double DARCARImage_timestamp_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_timestamp_set(long j, DARCARImage dARCARImage, double d);

    public static final native int DARCARImage_trackStateReason_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_trackStateReason_set(long j, DARCARImage dARCARImage, int i);

    public static final native int DARCARImage_trackState_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_trackState_set(long j, DARCARImage dARCARImage, int i);

    public static final native long DARCARImage_transform_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_transform_set(long j, DARCARImage dARCARImage, long j2, DARCMatrix4F dARCMatrix4F);

    public static final native int DARCARImage_width_get(long j, DARCARImage dARCARImage);

    public static final native void DARCARImage_width_set(long j, DARCARImage dARCARImage, int i);

    public static final native int DARCARTrackState_Limited_get();

    public static final native int DARCARTrackState_Normal_get();

    public static final native int DARCARTrackState_NotAvailable_get();

    public static final native int DARCAlert_AT_Close_get();

    public static final native int DARCAlert_AT_Exit_get();

    public static final native int DARCAlert_AT_NeedReply_get();

    public static final native int DARCAlert_Button_action_get(long j, DARCAlert.Button button);

    public static final native void DARCAlert_Button_action_set(long j, DARCAlert.Button button, int i);

    public static final native int DARCAlert_Button_countDown_get(long j, DARCAlert.Button button);

    public static final native void DARCAlert_Button_countDown_set(long j, DARCAlert.Button button, int i);

    public static final native String DARCAlert_Button_text_get(long j, DARCAlert.Button button);

    public static final native void DARCAlert_Button_text_set(long j, DARCAlert.Button button, String str);

    public static final native long DARCAlert_SWIGUpcast(long j);

    public static final native long DARCAlert_alloc();

    public static final native String DARCAlert_content_get(long j, DARCAlert dARCAlert);

    public static final native void DARCAlert_content_set(long j, DARCAlert dARCAlert, String str);

    public static final native String DARCAlert_title_get(long j, DARCAlert dARCAlert);

    public static final native void DARCAlert_title_set(long j, DARCAlert dARCAlert, String str);

    public static final native long DARCAskRequest_SWIGUpcast(long j);

    public static final native long DARCAskRequest_alloc();

    public static final native String DARCAskRequest_appId_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_appId_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native String DARCAskRequest_appName_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_appName_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native String DARCAskRequest_appVersion_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_appVersion_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native long DARCAskRequest_createHttpRequestWrap(long j, DARCAskRequest dARCAskRequest);

    public static final native long DARCAskRequest_curGPSData_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_curGPSData_set(long j, DARCAskRequest dARCAskRequest, long j2, DARCGPSData dARCGPSData);

    public static final native long DARCAskRequest_destGeoPt_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_destGeoPt_set(long j, DARCAskRequest dARCAskRequest, long j2, DARCGeoPoint dARCGeoPoint);

    public static final native String DARCAskRequest_deviceModel_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_deviceModel_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native String DARCAskRequest_orderID_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_orderID_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native String DARCAskRequest_osKind_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_osKind_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native String DARCAskRequest_osVersion_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_osVersion_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native int DARCAskRequest_scene_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_scene_set(long j, DARCAskRequest dARCAskRequest, int i);

    public static final native String DARCAskRequest_uid_get(long j, DARCAskRequest dARCAskRequest);

    public static final native void DARCAskRequest_uid_set(long j, DARCAskRequest dARCAskRequest, String str);

    public static final native int DARCAskResponse_GeoFence_TimeLimit_end_get(long j, DARCAskResponse.GeoFence.TimeLimit timeLimit);

    public static final native void DARCAskResponse_GeoFence_TimeLimit_end_set(long j, DARCAskResponse.GeoFence.TimeLimit timeLimit, int i);

    public static final native int DARCAskResponse_GeoFence_TimeLimit_start_get(long j, DARCAskResponse.GeoFence.TimeLimit timeLimit);

    public static final native void DARCAskResponse_GeoFence_TimeLimit_start_set(long j, DARCAskResponse.GeoFence.TimeLimit timeLimit, int i);

    public static final native long DARCAskResponse_GeoFence_center_get(long j, DARCAskResponse.GeoFence geoFence);

    public static final native void DARCAskResponse_GeoFence_center_set(long j, DARCAskResponse.GeoFence geoFence, long j2, DARCGeoPoint dARCGeoPoint);

    public static final native boolean DARCAskResponse_GeoFence_hasFenceData(long j, DARCAskResponse.GeoFence geoFence);

    public static final native float DARCAskResponse_GeoFence_radius_get(long j, DARCAskResponse.GeoFence geoFence);

    public static final native void DARCAskResponse_GeoFence_radius_set(long j, DARCAskResponse.GeoFence geoFence, float f);

    public static final native long DARCAskResponse_SWIGUpcast(long j);

    public static final native String DARCAskResponse_alertMessage_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_alertMessage_set(long j, DARCAskResponse dARCAskResponse, String str);

    public static final native long DARCAskResponse_alloc();

    public static final native long DARCAskResponse_createAskResponseWrap(long j, DARCHTTPResponse dARCHTTPResponse);

    public static final native long DARCAskResponse_destLoc_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_destLoc_set(long j, DARCAskResponse dARCAskResponse, long j2, DARCLocationInScene dARCLocationInScene);

    public static final native String DARCAskResponse_destName_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_destName_set(long j, DARCAskResponse dARCAskResponse, String str);

    public static final native int DARCAskResponse_entranceType_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_entranceType_set(long j, DARCAskResponse dARCAskResponse, int i);

    public static final native int DARCAskResponse_errorCode_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_errorCode_set(long j, DARCAskResponse dARCAskResponse, int i);

    public static final native long DARCAskResponse_fence_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_fence_set(long j, DARCAskResponse dARCAskResponse, long j2, DARCAskResponse.GeoFence geoFence);

    public static final native String DARCAskResponse_helpText_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_helpText_set(long j, DARCAskResponse dARCAskResponse, String str);

    public static final native boolean DARCAskResponse_isInGeoFence(long j, DARCAskResponse dARCAskResponse, int i, float f, float f2);

    public static final native boolean DARCAskResponse_isNearbyFence(long j, DARCAskResponse dARCAskResponse, float f, float f2);

    public static final native boolean DARCAskResponse_isSupport_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_isSupport_set(long j, DARCAskResponse dARCAskResponse, boolean z);

    public static final native String DARCAskResponse_locFailMessage_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_locFailMessage_set(long j, DARCAskResponse dARCAskResponse, String str);

    public static final native float DARCAskResponse_locPmMaxRadian(long j, DARCAskResponse dARCAskResponse);

    public static final native float DARCAskResponse_locPmMinRadian(long j, DARCAskResponse dARCAskResponse);

    public static final native String DARCAskResponse_model_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_model_set(long j, DARCAskResponse dARCAskResponse, String str);

    public static final native String DARCAskResponse_motionlessHintMessage_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_motionlessHintMessage_set(long j, DARCAskResponse dARCAskResponse, String str);

    public static final native float DARCAskResponse_quality_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_quality_set(long j, DARCAskResponse dARCAskResponse, float f);

    public static final native int DARCAskResponse_scene_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_scene_set(long j, DARCAskResponse dARCAskResponse, int i);

    public static final native String DARCAskResponse_session_get(long j, DARCAskResponse dARCAskResponse);

    public static final native void DARCAskResponse_session_set(long j, DARCAskResponse dARCAskResponse, String str);

    public static final native byte[] DARCDATA_getDataWrap(long j, DARCData dARCData);

    public static final native long DARCData_SWIGUpcast(long j);

    public static final native long DARCData_alloc();

    public static final native void DARCData_clear(long j, DARCData dARCData);

    public static final native long DARCData_getLength(long j, DARCData dARCData);

    public static final native void DARCData_setData(long j, DARCData dARCData, byte[] bArr, long j2);

    public static final native void DARCData_setDataNoCopy(long j, DARCData dARCData, byte[] bArr, long j2, boolean z);

    public static final native void DARCData_zero(long j, DARCData dARCData);

    public static final native double DARCGPSData_altitude_get(long j, DARCGPSData dARCGPSData);

    public static final native void DARCGPSData_altitude_set(long j, DARCGPSData dARCGPSData, double d);

    public static final native boolean DARCGPSData_equal(long j, DARCGPSData dARCGPSData, long j2, DARCGPSData dARCGPSData2);

    public static final native double DARCGPSData_horizontalAccuracy_get(long j, DARCGPSData dARCGPSData);

    public static final native void DARCGPSData_horizontalAccuracy_set(long j, DARCGPSData dARCGPSData, double d);

    public static final native long DARCGPSData_location_get(long j, DARCGPSData dARCGPSData);

    public static final native void DARCGPSData_location_set(long j, DARCGPSData dARCGPSData, long j2, DARCGeoPoint dARCGeoPoint);

    public static final native double DARCGPSData_speed_get(long j, DARCGPSData dARCGPSData);

    public static final native void DARCGPSData_speed_set(long j, DARCGPSData dARCGPSData, double d);

    public static final native double DARCGPSData_timestamp_get(long j, DARCGPSData dARCGPSData);

    public static final native void DARCGPSData_timestamp_set(long j, DARCGPSData dARCGPSData, double d);

    public static final native double DARCGPSData_verticalAccuracy_get(long j, DARCGPSData dARCGPSData);

    public static final native void DARCGPSData_verticalAccuracy_set(long j, DARCGPSData dARCGPSData, double d);

    public static final native boolean DARCGeoPoint_equal(long j, DARCGeoPoint dARCGeoPoint, long j2, DARCGeoPoint dARCGeoPoint2);

    public static final native double DARCGeoPoint_lat_get(long j, DARCGeoPoint dARCGeoPoint);

    public static final native void DARCGeoPoint_lat_set(long j, DARCGeoPoint dARCGeoPoint, double d);

    public static final native double DARCGeoPoint_lon_get(long j, DARCGeoPoint dARCGeoPoint);

    public static final native void DARCGeoPoint_lon_set(long j, DARCGeoPoint dARCGeoPoint, double d);

    public static final native boolean DARCGeoPoint_valid(long j, DARCGeoPoint dARCGeoPoint);

    public static final native long DARCHTTPRequest_SWIGUpcast(long j);

    public static final native String DARCHTTPRequest_URL_get(long j, DARCHTTPRequest dARCHTTPRequest);

    public static final native void DARCHTTPRequest_URL_set(long j, DARCHTTPRequest dARCHTTPRequest, String str);

    public static final native long DARCHTTPRequest_alloc();

    public static final native long DARCHTTPRequest_getBody(long j, DARCHTTPRequest dARCHTTPRequest);

    public static final native int DARCHTTPRequest_method_get(long j, DARCHTTPRequest dARCHTTPRequest);

    public static final native void DARCHTTPRequest_method_set(long j, DARCHTTPRequest dARCHTTPRequest, int i);

    public static final native int DARCHTTPRequest_requestID_get(long j, DARCHTTPRequest dARCHTTPRequest);

    public static final native void DARCHTTPRequest_requestID_set(long j, DARCHTTPRequest dARCHTTPRequest, int i);

    public static final native void DARCHTTPRequest_setBody(long j, DARCHTTPRequest dARCHTTPRequest, long j2, DARCData dARCData);

    public static final native int DARCHTTPRequest_timeout_get(long j, DARCHTTPRequest dARCHTTPRequest);

    public static final native void DARCHTTPRequest_timeout_set(long j, DARCHTTPRequest dARCHTTPRequest, int i);

    public static final native int DARCHTTPRequest_type_get(long j, DARCHTTPRequest dARCHTTPRequest);

    public static final native void DARCHTTPRequest_type_set(long j, DARCHTTPRequest dARCHTTPRequest, int i);

    public static final native long DARCHTTPResponse_SWIGUpcast(long j);

    public static final native long DARCHTTPResponse_alloc();

    public static final native long DARCHTTPResponse_getBody(long j, DARCHTTPResponse dARCHTTPResponse);

    public static final native long DARCHTTPResponse_getOriginalRequest(long j, DARCHTTPResponse dARCHTTPResponse);

    public static final native int DARCHTTPResponse_getStatus(long j, DARCHTTPResponse dARCHTTPResponse);

    public static final native void DARCHTTPResponse_setBody(long j, DARCHTTPResponse dARCHTTPResponse, long j2, DARCData dARCData);

    public static final native void DARCHTTPResponse_setOriginalRequest(long j, DARCHTTPResponse dARCHTTPResponse, long j2, DARCHTTPRequest dARCHTTPRequest);

    public static final native void DARCHTTPResponse_setStatus(long j, DARCHTTPResponse dARCHTTPResponse, int i);

    public static final native int DARCLanguage_ChineseSimplified_get();

    public static final native int DARCLanguage_EnglishAustralia_get();

    public static final native int DARCLanguage_EnglishUS_get();

    public static final native int DARCLanguage_Japanese_get();

    public static final native int DARCLanguage_Portuguese_get();

    public static final native int DARCLanguage_SpanishChile_get();

    public static final native int DARCLanguage_SpanishColombia_get();

    public static final native int DARCLanguage_SpanishMexico_get();

    public static final native int DARCLocationInScene_index_get(long j, DARCLocationInScene dARCLocationInScene);

    public static final native void DARCLocationInScene_index_set(long j, DARCLocationInScene dARCLocationInScene, int i);

    public static final native long DARCLocationInScene_pos_get(long j, DARCLocationInScene dARCLocationInScene);

    public static final native void DARCLocationInScene_pos_set(long j, DARCLocationInScene dARCLocationInScene, long j2, DARCPoint3F dARCPoint3F);

    public static final native long DARCMatrix3F_size();

    public static final native long DARCMatrix3F_x_get(long j, DARCMatrix3F dARCMatrix3F);

    public static final native void DARCMatrix3F_x_set(long j, DARCMatrix3F dARCMatrix3F, long j2, DARCPoint3F dARCPoint3F);

    public static final native long DARCMatrix3F_y_get(long j, DARCMatrix3F dARCMatrix3F);

    public static final native void DARCMatrix3F_y_set(long j, DARCMatrix3F dARCMatrix3F, long j2, DARCPoint3F dARCPoint3F);

    public static final native long DARCMatrix3F_z_get(long j, DARCMatrix3F dARCMatrix3F);

    public static final native void DARCMatrix3F_z_set(long j, DARCMatrix3F dARCMatrix3F, long j2, DARCPoint3F dARCPoint3F);

    public static final native long DARCMatrix4F_size();

    public static final native long DARCMatrix4F_w_get(long j, DARCMatrix4F dARCMatrix4F);

    public static final native void DARCMatrix4F_w_set(long j, DARCMatrix4F dARCMatrix4F, long j2, DARCPoint4F dARCPoint4F);

    public static final native long DARCMatrix4F_x_get(long j, DARCMatrix4F dARCMatrix4F);

    public static final native void DARCMatrix4F_x_set(long j, DARCMatrix4F dARCMatrix4F, long j2, DARCPoint4F dARCPoint4F);

    public static final native long DARCMatrix4F_y_get(long j, DARCMatrix4F dARCMatrix4F);

    public static final native void DARCMatrix4F_y_set(long j, DARCMatrix4F dARCMatrix4F, long j2, DARCPoint4F dARCPoint4F);

    public static final native long DARCMatrix4F_z_get(long j, DARCMatrix4F dARCMatrix4F);

    public static final native void DARCMatrix4F_z_set(long j, DARCMatrix4F dARCMatrix4F, long j2, DARCPoint4F dARCPoint4F);

    public static final native boolean DARCNAVCreateData_ARDriftDetectionInInitEnable_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_ARDriftDetectionInInitEnable_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native float DARCNAVCreateData_ARDriftDetectionInInitSpeed_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_ARDriftDetectionInInitSpeed_set(long j, DARCNAVCreateData dARCNAVCreateData, float f);

    public static final native boolean DARCNAVCreateData_ARDriftDetectionInNaviEnable_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_ARDriftDetectionInNaviEnable_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native float DARCNAVCreateData_ARDriftDetectionInNaviSpeed_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_ARDriftDetectionInNaviSpeed_set(long j, DARCNAVCreateData dARCNAVCreateData, float f);

    public static final native int DARCNAVCreateData_PDRCoreDuration_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRCoreDuration_set(long j, DARCNAVCreateData dARCNAVCreateData, int i);

    public static final native boolean DARCNAVCreateData_PDREnabled_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDREnabled_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native boolean DARCNAVCreateData_PDRFusionEnable_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRFusionEnable_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native int DARCNAVCreateData_PDRInterLocDistance_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRInterLocDistance_set(long j, DARCNAVCreateData dARCNAVCreateData, int i);

    public static final native int DARCNAVCreateData_PDRInterLocInterval_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRInterLocInterval_set(long j, DARCNAVCreateData dARCNAVCreateData, int i);

    public static final native boolean DARCNAVCreateData_PDRLevelDetectionEnable_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRLevelDetectionEnable_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native boolean DARCNAVCreateData_PDRShadowEnabled_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRShadowEnabled_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native int DARCNAVCreateData_PDRTotalDuration_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRTotalDuration_set(long j, DARCNAVCreateData dARCNAVCreateData, int i);

    public static final native boolean DARCNAVCreateData_PDRZGEnabled_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_PDRZGEnabled_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native long DARCNAVCreateData_SWIGUpcast(long j);

    public static final native long DARCNAVCreateData_alloc();

    public static final native long DARCNAVCreateData_askData(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_containerView_release(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_containerView_set(long j, DARCNAVCreateData dARCNAVCreateData, Object obj);

    public static final native boolean DARCNAVCreateData_dataIsSimple_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_dataIsSimple_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native String DARCNAVCreateData_dataPath_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_dataPath_set(long j, DARCNAVCreateData dARCNAVCreateData, String str);

    public static final native float DARCNAVCreateData_imagePickupInterval_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_imagePickupInterval_set(long j, DARCNAVCreateData dARCNAVCreateData, float f);

    public static final native int DARCNAVCreateData_locVersion_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_locVersion_set(long j, DARCNAVCreateData dARCNAVCreateData, int i);

    public static final native int DARCNAVCreateData_networkStatus_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_networkStatus_set(long j, DARCNAVCreateData dARCNAVCreateData, int i);

    public static final native String DARCNAVCreateData_orderID_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_orderID_set(long j, DARCNAVCreateData dARCNAVCreateData, String str);

    public static final native void DARCNAVCreateData_setAskData(long j, DARCNAVCreateData dARCNAVCreateData, long j2, DARCAskResponse dARCAskResponse);

    public static final native int DARCNAVCreateData_slideWindow_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_slideWindow_set(long j, DARCNAVCreateData dARCNAVCreateData, int i);

    public static final native String DARCNAVCreateData_uid_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_uid_set(long j, DARCNAVCreateData dARCNAVCreateData, String str);

    public static final native boolean DARCNAVCreateData_useOldBoard_get(long j, DARCNAVCreateData dARCNAVCreateData);

    public static final native void DARCNAVCreateData_useOldBoard_set(long j, DARCNAVCreateData dARCNAVCreateData, boolean z);

    public static final native long DARCNAVEDShowAlert_SWIGUpcast(long j);

    public static final native long DARCNAVEDShowAlert_alloc();

    public static final native long DARCNAVEDShowAlert_getAlert(long j, DARCNAVEDShowAlert dARCNAVEDShowAlert);

    public static final native void DARCNAVEDShowAlert_setAlert(long j, DARCNAVEDShowAlert dARCNAVEDShowAlert, long j2, DARCAlert dARCAlert);

    public static final native int DARCNAVEDShowAlert_tagInt_get(long j, DARCNAVEDShowAlert dARCNAVEDShowAlert);

    public static final native void DARCNAVEDShowAlert_tagInt_set(long j, DARCNAVEDShowAlert dARCNAVEDShowAlert, int i);

    public static final native long DARCNAVEDStatusChange_SWIGUpcast(long j);

    public static final native long DARCNAVEDStatusChange_alloc();

    public static final native int DARCNAVEDStatusChange_statusFrom_get(long j, DARCNAVEDStatusChange dARCNAVEDStatusChange);

    public static final native void DARCNAVEDStatusChange_statusFrom_set(long j, DARCNAVEDStatusChange dARCNAVEDStatusChange, int i);

    public static final native int DARCNAVEDStatusChange_statusTo_get(long j, DARCNAVEDStatusChange dARCNAVEDStatusChange);

    public static final native void DARCNAVEDStatusChange_statusTo_set(long j, DARCNAVEDStatusChange dARCNAVEDStatusChange, int i);

    public static final native String DARCNAVEDStatusChange_stringObj_get(long j, DARCNAVEDStatusChange dARCNAVEDStatusChange);

    public static final native void DARCNAVEDStatusChange_stringObj_set(long j, DARCNAVEDStatusChange dARCNAVEDStatusChange, String str);

    public static final native long DARCNAVEventData_SWIGUpcast(long j);

    public static final native long DARCNAVEventData_alloc();

    public static final native int DARCNAVEvent_None_get();

    public static final native int DARCNAVStatus_Init_get();

    public static final native long DARCNAVUpdateData_arImage(long j, DARCNAVUpdateData dARCNAVUpdateData);

    public static final native void DARCNAVUpdateData_cameraColorBuffer_set(long j, DARCNAVUpdateData dARCNAVUpdateData, byte[] bArr);

    public static final native void DARCNAVUpdateData_cameraDepthBuffer_set(long j, DARCNAVUpdateData dARCNAVUpdateData, byte[] bArr);

    public static final native long DARCNAVUpdateData_projection_get(long j, DARCNAVUpdateData dARCNAVUpdateData);

    public static final native void DARCNAVUpdateData_projection_set(long j, DARCNAVUpdateData dARCNAVUpdateData, long j2, DARCMatrix4F dARCMatrix4F);

    public static final native void DARCNAVUpdateData_setArImage(long j, DARCNAVUpdateData dARCNAVUpdateData, long j2, DARCARImage dARCARImage);

    public static final native int DARCNaviResponseErrorGPSHorAccurateNotSatisfy_get();

    public static final native int DARCNaviResponseErrorNone_get();

    public static final native int DARCNaviTypeARDirection_get();

    public static final native int DARCNaviTypeAR_get();

    public static final native void DARCNavigator_active(long j, DARCNavigator dARCNavigator);

    public static final native long DARCNavigator_currentLocation(long j, DARCNavigator dARCNavigator);

    public static final native double DARCNavigator_currentTime(long j, DARCNavigator dARCNavigator);

    public static final native float DARCNavigator_distanceOfEnd(long j, DARCNavigator dARCNavigator);

    public static final native void DARCNavigator_errorAppear(long j, DARCNavigator dARCNavigator);

    public static final native void DARCNavigator_errorDisappear(long j, DARCNavigator dARCNavigator);

    public static final native void DARCNavigator_eventShowAlertReply(long j, DARCNavigator dARCNavigator, long j2, DARCNAVEDShowAlert dARCNAVEDShowAlert, int i);

    public static final native boolean DARCNavigator_getCorrectNodeVisible(long j, DARCNavigator dARCNavigator);

    public static final native long DARCNavigator_getGuidePosInScreen(long j, DARCNavigator dARCNavigator);

    public static final native void DARCNavigator_inactive(long j, DARCNavigator dARCNavigator);

    public static final native void DARCNavigator_networkStatusChanged(long j, DARCNavigator dARCNavigator, int i);

    public static final native void DARCNavigator_recvHTTPResponse(long j, DARCNavigator dARCNavigator, long j2, DARCHTTPResponse dARCHTTPResponse);

    public static final native void DARCNavigator_setCorrectNodeVisible(long j, DARCNavigator dARCNavigator, boolean z);

    public static final native void DARCNavigator_start(long j, DARCNavigator dARCNavigator);

    public static final native int DARCNavigator_status(long j, DARCNavigator dARCNavigator);

    public static final native void DARCNavigator_stop(long j, DARCNavigator dARCNavigator);

    public static final native void DARCNavigator_update(long j, DARCNavigator dARCNavigator, long j2, DARCNAVUpdateData dARCNAVUpdateData);

    public static final native int DARCNetworkStatus_NotReachable_get();

    public static final native long DARCObject_alloc();

    public static final native long DARCObject_gautorelease(long j, DARCObject dARCObject);

    public static final native long DARCObject_gretain(long j, DARCObject dARCObject);

    public static final native boolean DARCObject_isEqual(long j, DARCObject dARCObject, long j2, DARCObject dARCObject2);

    public static final native void DARCObject_release(long j, DARCObject dARCObject);

    public static final native long DARCPoint3F_size();

    public static final native float DARCPoint3F_x_get(long j, DARCPoint3F dARCPoint3F);

    public static final native void DARCPoint3F_x_set(long j, DARCPoint3F dARCPoint3F, float f);

    public static final native float DARCPoint3F_y_get(long j, DARCPoint3F dARCPoint3F);

    public static final native void DARCPoint3F_y_set(long j, DARCPoint3F dARCPoint3F, float f);

    public static final native float DARCPoint3F_z_get(long j, DARCPoint3F dARCPoint3F);

    public static final native void DARCPoint3F_z_set(long j, DARCPoint3F dARCPoint3F, float f);

    public static final native void DARCPoint4F_set(long j, DARCPoint4F dARCPoint4F, float f, float f2, float f3, float f4);

    public static final native long DARCPoint4F_size();

    public static final native float DARCPoint4F_w_get(long j, DARCPoint4F dARCPoint4F);

    public static final native void DARCPoint4F_w_set(long j, DARCPoint4F dARCPoint4F, float f);

    public static final native float DARCPoint4F_x_get(long j, DARCPoint4F dARCPoint4F);

    public static final native void DARCPoint4F_x_set(long j, DARCPoint4F dARCPoint4F, float f);

    public static final native float DARCPoint4F_y_get(long j, DARCPoint4F dARCPoint4F);

    public static final native void DARCPoint4F_y_set(long j, DARCPoint4F dARCPoint4F, float f);

    public static final native float DARCPoint4F_z_get(long j, DARCPoint4F dARCPoint4F);

    public static final native void DARCPoint4F_z_set(long j, DARCPoint4F dARCPoint4F, float f);

    public static final native long DARCPointF_size();

    public static final native float DARCPointF_x_get(long j, DARCPointF dARCPointF);

    public static final native void DARCPointF_x_set(long j, DARCPointF dARCPointF, float f);

    public static final native float DARCPointF_y_get(long j, DARCPointF dARCPointF);

    public static final native void DARCPointF_y_set(long j, DARCPointF dARCPointF, float f);

    public static final native long DARCRectF_origin_get(long j, DARCRectF dARCRectF);

    public static final native void DARCRectF_origin_set(long j, DARCRectF dARCRectF, long j2, DARCPointF dARCPointF);

    public static final native long DARCRectF_size_get(long j, DARCRectF dARCRectF);

    public static final native void DARCRectF_size_set(long j, DARCRectF dARCRectF, long j2, DARCSizeF dARCSizeF);

    public static final native float DARCSizeF_h_get(long j, DARCSizeF dARCSizeF);

    public static final native void DARCSizeF_h_set(long j, DARCSizeF dARCSizeF, float f);

    public static final native float DARCSizeF_w_get(long j, DARCSizeF dARCSizeF);

    public static final native void DARCSizeF_w_set(long j, DARCSizeF dARCSizeF, float f);

    public static final native long DARCZGNavCreateData_SWIGUpcast(long j);

    public static final native long DARCZGNavCreateData_alloc();

    public static final native void DARCZGNavCreateData_containerView_release(long j, DARCZGNavCreateData dARCZGNavCreateData);

    public static final native void DARCZGNavCreateData_containerView_set(long j, DARCZGNavCreateData dARCZGNavCreateData, Object obj);

    public static final native int DARCZGNavCreateData_distanceArrived_get(long j, DARCZGNavCreateData dARCZGNavCreateData);

    public static final native void DARCZGNavCreateData_distanceArrived_set(long j, DARCZGNavCreateData dARCZGNavCreateData, int i);

    public static final native long DARCZGNavCreateData_targetPoint_get(long j, DARCZGNavCreateData dARCZGNavCreateData);

    public static final native void DARCZGNavCreateData_targetPoint_set(long j, DARCZGNavCreateData dARCZGNavCreateData, long j2, DARCGeoPoint dARCGeoPoint);

    public static final native boolean DARCZGNavCreateData_trackSupport_get(long j, DARCZGNavCreateData dARCZGNavCreateData);

    public static final native void DARCZGNavCreateData_trackSupport_set(long j, DARCZGNavCreateData dARCZGNavCreateData, boolean z);

    public static final native boolean DARCZGNavCreateData_usePDR_get(long j, DARCZGNavCreateData dARCZGNavCreateData);

    public static final native void DARCZGNavCreateData_usePDR_set(long j, DARCZGNavCreateData dARCZGNavCreateData, boolean z);

    public static final native int DARCZGNavDistanceEvent_Invalid_get();

    public static final native long DARCZGNavEDDistanceChange_SWIGUpcast(long j);

    public static final native long DARCZGNavEDDistanceChange_alloc();

    public static final native int DARCZGNavEDDistanceChange_distanceOfTarget_get(long j, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange);

    public static final native void DARCZGNavEDDistanceChange_distanceOfTarget_set(long j, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange, int i);

    public static final native int DARCZGNavEDDistanceChange_distanceStatusFrom_get(long j, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange);

    public static final native void DARCZGNavEDDistanceChange_distanceStatusFrom_set(long j, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange, int i);

    public static final native int DARCZGNavEDDistanceChange_distanceStatusTo_get(long j, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange);

    public static final native void DARCZGNavEDDistanceChange_distanceStatusTo_set(long j, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange, int i);

    public static final native long DARCZGNavEDGPSFusion_SWIGUpcast(long j);

    public static final native long DARCZGNavEDGPSFusion_alloc();

    public static final native long DARCZGNavEDGPSFusion_gpsFusitionData_get(long j, DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion);

    public static final native void DARCZGNavEDGPSFusion_gpsFusitionData_set(long j, DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion, long j2, DARCGPSData dARCGPSData);

    public static final native long DARCZGNavEDGPSWeakChange_SWIGUpcast(long j);

    public static final native long DARCZGNavEDGPSWeakChange_alloc();

    public static final native boolean DARCZGNavEDGPSWeakChange_isWeak_get(long j, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange);

    public static final native void DARCZGNavEDGPSWeakChange_isWeak_set(long j, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange, boolean z);

    public static final native double DARCZGNavEDGPSWeakChange_lat_get(long j, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange);

    public static final native void DARCZGNavEDGPSWeakChange_lat_set(long j, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange, double d);

    public static final native double DARCZGNavEDGPSWeakChange_lon_get(long j, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange);

    public static final native void DARCZGNavEDGPSWeakChange_lon_set(long j, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange, double d);

    public static final native long DARCZGNavEDStatusChange_SWIGUpcast(long j);

    public static final native long DARCZGNavEDStatusChange_alloc();

    public static final native int DARCZGNavEDStatusChange_statusFrom_get(long j, DARCZGNavEDStatusChange dARCZGNavEDStatusChange);

    public static final native void DARCZGNavEDStatusChange_statusFrom_set(long j, DARCZGNavEDStatusChange dARCZGNavEDStatusChange, int i);

    public static final native int DARCZGNavEDStatusChange_statusTo_get(long j, DARCZGNavEDStatusChange dARCZGNavEDStatusChange);

    public static final native void DARCZGNavEDStatusChange_statusTo_set(long j, DARCZGNavEDStatusChange dARCZGNavEDStatusChange, int i);

    public static final native long DARCZGNavEventData_SWIGUpcast(long j);

    public static final native long DARCZGNavEventData_alloc();

    public static final native int DARCZGNavEvent_None_get();

    public static final native int DARCZGNavStatus_Init_get();

    public static final native double DARCZGNavUpdateData_arOriginTimeStamp_get(long j, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavUpdateData_arOriginTimeStamp_set(long j, DARCZGNavUpdateData dARCZGNavUpdateData, double d);

    public static final native long DARCZGNavUpdateData_gpsData_get(long j, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavUpdateData_gpsData_set(long j, DARCZGNavUpdateData dARCZGNavUpdateData, long j2, DARCGPSData dARCGPSData);

    public static final native float DARCZGNavUpdateData_lightIntensity_get(long j, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavUpdateData_lightIntensity_set(long j, DARCZGNavUpdateData dARCZGNavUpdateData, float f);

    public static final native long DARCZGNavUpdateData_projection_get(long j, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavUpdateData_projection_set(long j, DARCZGNavUpdateData dARCZGNavUpdateData, long j2, DARCMatrix4F dARCMatrix4F);

    public static final native long DARCZGNavUpdateData_rotationVector_get(long j, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavUpdateData_rotationVector_set(long j, DARCZGNavUpdateData dARCZGNavUpdateData, long j2, DARCPoint4F dARCPoint4F);

    public static final native int DARCZGNavUpdateData_trackState_get(long j, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavUpdateData_trackState_set(long j, DARCZGNavUpdateData dARCZGNavUpdateData, int i);

    public static final native long DARCZGNavUpdateData_transform_get(long j, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavUpdateData_transform_set(long j, DARCZGNavUpdateData dARCZGNavUpdateData, long j2, DARCMatrix4F dARCMatrix4F);

    public static final native void DARCZGNavigatorDelegate_ZGNavigatorEvent(long j, DARCZGNavigatorDelegate dARCZGNavigatorDelegate, long j2, DARCZGNavigator dARCZGNavigator, int i, long j3, DARCZGNavEventData dARCZGNavEventData);

    public static final native void DARCZGNavigator_active(long j, DARCZGNavigator dARCZGNavigator);

    public static final native double DARCZGNavigator_currentTime(long j, DARCZGNavigator dARCZGNavigator);

    public static final native void DARCZGNavigator_inactive(long j, DARCZGNavigator dARCZGNavigator);

    public static final native boolean DARCZGNavigator_isGPSWeak(long j, DARCZGNavigator dARCZGNavigator);

    public static final native boolean DARCZGNavigator_isShowEndGuidNode(long j, DARCZGNavigator dARCZGNavigator);

    public static final native boolean DARCZGNavigator_needShowBehindTips(long j, DARCZGNavigator dARCZGNavigator);

    public static final native void DARCZGNavigator_setEffectiveRect(long j, DARCZGNavigator dARCZGNavigator, long j2, DARCRectF dARCRectF);

    public static final native void DARCZGNavigator_update(long j, DARCZGNavigator dARCZGNavigator, long j2, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void DARCZGNavigator_updateGPS(long j, DARCZGNavigator dARCZGNavigator, long j2, DARCGPSData dARCGPSData);

    public static final native int DARCZGZGNavEvent_None_get();

    public static final native int DARCZGZGNavStatus_Init_get();

    public static final native int DARC_ZGNAV_PROJECTION_FAR_get();

    public static final native double DARC_ZGNAV_PROJECTION_NEAR_get();

    public static final native int DiARNavKitGetVersion();

    public static final native void GetDARCAlertButtonList_Wrap(long j, DARCAlert dARCAlert, Object obj);

    public static final native void GetDARCHTTPRequestHeaders_Wrap(long j, DARCHTTPRequest dARCHTTPRequest, Object obj);

    public static final native void SwigARCallback_LogHandler(long j, SwigARCallback swigARCallback, String str);

    public static final native void SwigARCallback_LogHandlerSwigExplicitSwigARCallback(long j, SwigARCallback swigARCallback, String str);

    public static final native void SwigARCallback_change_ownership(SwigARCallback swigARCallback, long j, boolean z);

    public static final native void SwigARCallback_director_connect(SwigARCallback swigARCallback, long j, boolean z, boolean z2);

    public static final native void SwigARCallback_navigatorEventSwigExplicitSwigARCallback__SWIG_0(long j, SwigARCallback swigARCallback, int i, long j2, DARCNAVEDStatusChange dARCNAVEDStatusChange);

    public static final native void SwigARCallback_navigatorEventSwigExplicitSwigARCallback__SWIG_1(long j, SwigARCallback swigARCallback, int i, long j2, DARCNAVEDShowAlert dARCNAVEDShowAlert);

    public static final native void SwigARCallback_navigatorEvent__SWIG_0(long j, SwigARCallback swigARCallback, int i, long j2, DARCNAVEDStatusChange dARCNAVEDStatusChange);

    public static final native void SwigARCallback_navigatorEvent__SWIG_1(long j, SwigARCallback swigARCallback, int i, long j2, DARCNAVEDShowAlert dARCNAVEDShowAlert);

    public static final native void SwigARCallback_navigatorSendHTTPRequest(long j, SwigARCallback swigARCallback, long j2, DARCHTTPRequest dARCHTTPRequest);

    /* renamed from: SwigARCallback_navigatorSendHTTPRequestSwigExplicitSwigARCallback */
    public static final native void m16699x4fa2cf1d(long j, SwigARCallback swigARCallback, long j2, DARCHTTPRequest dARCHTTPRequest);

    /* renamed from: SwigARCallback_navigatorZGEventSwigExplicitSwigARCallback__SWIG_0 */
    public static final native void m16700x2c0f4f5e(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDStatusChange dARCZGNavEDStatusChange);

    /* renamed from: SwigARCallback_navigatorZGEventSwigExplicitSwigARCallback__SWIG_1 */
    public static final native void m16701x2c0f4f5f(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange);

    /* renamed from: SwigARCallback_navigatorZGEventSwigExplicitSwigARCallback__SWIG_2 */
    public static final native void m16702x2c0f4f60(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange);

    /* renamed from: SwigARCallback_navigatorZGEventSwigExplicitSwigARCallback__SWIG_3 */
    public static final native void m16703x2c0f4f61(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion);

    public static final native void SwigARCallback_navigatorZGEvent__SWIG_0(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDStatusChange dARCZGNavEDStatusChange);

    public static final native void SwigARCallback_navigatorZGEvent__SWIG_1(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange);

    public static final native void SwigARCallback_navigatorZGEvent__SWIG_2(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange);

    public static final native void SwigARCallback_navigatorZGEvent__SWIG_3(long j, SwigARCallback swigARCallback, int i, long j2, DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion);

    public static final native long createJNIContext();

    public static final native void currentLocation(long j, long j2, DARCLocationInScene dARCLocationInScene);

    public static final native double currentTime(long j);

    public static final native void delete_DARCAlert_Button(long j);

    public static final native void delete_DARCAskResponse_GeoFence(long j);

    public static final native void delete_DARCAskResponse_GeoFence_TimeLimit(long j);

    public static final native void delete_DARCGPSData(long j);

    public static final native void delete_DARCGeoPoint(long j);

    public static final native void delete_DARCLocationInScene(long j);

    public static final native void delete_DARCMatrix3F(long j);

    public static final native void delete_DARCMatrix4F(long j);

    public static final native void delete_DARCNAVUpdateData(long j);

    public static final native void delete_DARCPoint3F(long j);

    public static final native void delete_DARCPoint4F(long j);

    public static final native void delete_DARCPointF(long j);

    public static final native void delete_DARCRectF(long j);

    public static final native void delete_DARCSizeF(long j);

    public static final native void delete_DARCZGNavUpdateData(long j);

    public static final native void delete_DARCZGNavigatorDelegate(long j);

    public static final native void delete_SwigARCallback(long j);

    public static final native void destroyJNIContext(long j);

    public static final native float distanceOfEnd(long j);

    public static final native double distanceOfGeoPoints(double d, double d2, double d3, double d4);

    public static final native String encryptStringWrap(String str, int i);

    public static final native void errorAppear(long j);

    public static final native void errorDisappear(long j);

    public static final native void eventShowAlertReply(long j, long j2, DARCNAVEDShowAlert dARCNAVEDShowAlert, int i);

    public static final native void getGuidePosInScreen(long j, long j2, DARCPointF dARCPointF);

    public static final native boolean isGPSWeak(long j);

    public static final native boolean isShowEndGuidNode(long j);

    public static final native int languageGet();

    public static final native String languageGetDirName(int i);

    public static final native void languageSet__SWIG_0(int i, int i2);

    public static final native void languageSet__SWIG_1(int i);

    public static final native boolean needShowBehindTips(long j);

    public static final native void networkStatusChanged(long j, int i);

    public static final native long new_DARCAlert_Button();

    public static final native long new_DARCAskResponse_GeoFence();

    public static final native long new_DARCAskResponse_GeoFence_TimeLimit();

    public static final native long new_DARCGPSData();

    public static final native long new_DARCGeoPoint__SWIG_0();

    public static final native long new_DARCGeoPoint__SWIG_1(double d, double d2);

    public static final native long new_DARCLocationInScene();

    public static final native long new_DARCMatrix3F();

    public static final native long new_DARCMatrix4F();

    public static final native long new_DARCNAVUpdateData();

    public static final native long new_DARCPoint3F();

    public static final native long new_DARCPoint4F();

    public static final native long new_DARCPointF();

    public static final native long new_DARCRectF();

    public static final native long new_DARCSizeF();

    public static final native long new_DARCZGNavUpdateData();

    public static final native long new_SwigARCallback();

    public static final native void pause(long j);

    public static final native void pauseZG(long j);

    public static final native long perspectiveFov(float f, float f2, float f3, float f4, float f5);

    public static final native void recvHTTPResponse(long j, long j2, DARCHTTPResponse dARCHTTPResponse);

    public static final native void renderUpdate(long j);

    public static final native void resume(long j);

    public static final native void resumeZG(long j);

    public static final native void setCorrectNodeVisible(long j, boolean z);

    public static final native void setZGEffectiveRect(long j, long j2, DARCRectF dARCRectF);

    public static final native void start(long j);

    public static final native int status(long j);

    public static final native void stop(long j);

    private static final native void swig_module_init();

    public static final native void update(long j, long j2, DARCNAVUpdateData dARCNAVUpdateData);

    public static final native void updateZG(long j, long j2, DARCZGNavUpdateData dARCZGNavUpdateData);

    public static final native void updateZGGPS(long j, long j2, DARCGPSData dARCGPSData);

    AREngineJNIBridge() {
    }

    static {
        try {
            System.loadLibrary("DiARNavKit");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        swig_module_init();
    }

    public static void SwigDirector_SwigARCallback_navigatorSendHTTPRequest(SwigARCallback swigARCallback, long j) {
        swigARCallback.navigatorSendHTTPRequest(j == 0 ? null : new DARCHTTPRequest(j, false));
    }

    public static void SwigDirector_SwigARCallback_navigatorEvent__SWIG_0(SwigARCallback swigARCallback, int i, long j) {
        swigARCallback.navigatorEvent(DARCNAVEvent.swigToEnum(i), j == 0 ? null : new DARCNAVEDStatusChange(j, false));
    }

    public static void SwigDirector_SwigARCallback_navigatorEvent__SWIG_1(SwigARCallback swigARCallback, int i, long j) {
        swigARCallback.navigatorEvent(DARCNAVEvent.swigToEnum(i), j == 0 ? null : new DARCNAVEDShowAlert(j, false));
    }

    public static void SwigDirector_SwigARCallback_LogHandler(SwigARCallback swigARCallback, String str) {
        swigARCallback.LogHandler(str);
    }

    public static void SwigDirector_SwigARCallback_navigatorZGEvent__SWIG_0(SwigARCallback swigARCallback, int i, long j) {
        swigARCallback.navigatorZGEvent(DARCZGNavEvent.swigToEnum(i), j == 0 ? null : new DARCZGNavEDStatusChange(j, false));
    }

    public static void SwigDirector_SwigARCallback_navigatorZGEvent__SWIG_1(SwigARCallback swigARCallback, int i, long j) {
        swigARCallback.navigatorZGEvent(DARCZGNavEvent.swigToEnum(i), j == 0 ? null : new DARCZGNavEDGPSWeakChange(j, false));
    }

    public static void SwigDirector_SwigARCallback_navigatorZGEvent__SWIG_2(SwigARCallback swigARCallback, int i, long j) {
        swigARCallback.navigatorZGEvent(DARCZGNavEvent.swigToEnum(i), j == 0 ? null : new DARCZGNavEDDistanceChange(j, false));
    }

    public static void SwigDirector_SwigARCallback_navigatorZGEvent__SWIG_3(SwigARCallback swigARCallback, int i, long j) {
        swigARCallback.navigatorZGEvent(DARCZGNavEvent.swigToEnum(i), j == 0 ? null : new DARCZGNavEDGPSFusion(j, false));
    }
}
