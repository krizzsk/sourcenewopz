package com.didi.hawaii.mapsdkv2.jni;

import com.didi.map.common.lib.MapLibaryLoader;
import com.didi.map.constant.StringConstant;
import java.math.BigInteger;

final class MapEngineJNIBridge {
    public static final native boolean AboardPointInfo_bHidden_get(long j, AboardPointInfo aboardPointInfo);

    public static final native void AboardPointInfo_bHidden_set(long j, AboardPointInfo aboardPointInfo, boolean z);

    public static final native boolean AboardPointInfo_bHighlight_get(long j, AboardPointInfo aboardPointInfo);

    public static final native void AboardPointInfo_bHighlight_set(long j, AboardPointInfo aboardPointInfo, boolean z);

    public static final native BigInteger AboardPointInfo_poiid_get(long j, AboardPointInfo aboardPointInfo);

    public static final native void AboardPointInfo_poiid_set(long j, AboardPointInfo aboardPointInfo, BigInteger bigInteger);

    public static final native int AboardPointInfo_urlLen_get(long j, AboardPointInfo aboardPointInfo);

    public static final native void AboardPointInfo_urlLen_set(long j, AboardPointInfo aboardPointInfo, int i);

    public static final native String AboardPointInfo_url_get(long j, AboardPointInfo aboardPointInfo);

    public static final native void AboardPointInfo_url_set(long j, AboardPointInfo aboardPointInfo, String str);

    public static final native void AddMapOverlay_Wrap(long j, long j2, long j3, MapOverlay mapOverlay);

    public static final native int AddMaskLayer_Wrap(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static final native void AddMultipleRouteNames_Wrap(long j, int i, long j2, Object[] objArr, Object[] objArr2, int i2, int i3, String str, byte[] bArr, int i4, int i5);

    public static final native void AddRouteNames_Wrap(long j, long j2, int i, long j3, Object[] objArr, Object[] objArr2, boolean z);

    public static final native void AddRouteNames_WrapOld(long j, int i, long j2, Object[] objArr, Object[] objArr2, boolean z);

    public static final native int AddRoute_Wrap(long j, long j2, Object[] objArr, int[] iArr, int[] iArr2, String str, float f, int i, float f2, boolean z, boolean z2, int i2, long j3, boolean z3, long j4, boolean z4);

    public static final native void AddSpecialBubble_Wrap(long j, Object[] objArr, Object[] objArr2, long j2, int i);

    public static final native long AnnoTextAtRow(long j, int i);

    public static final native int AnnoTextCountAtRow(long j, int i);

    public static final native int AnnoTextRowNum(long j);

    public static final native int BS_MAX_RECT_CNT_get();

    public static final native int BS_MAX_SECTION_CNT_get();

    public static final native int BS_MAX_SIZE_NAME_get();

    public static final native int BUS_STATION_CODE_get();

    public static final native long BlockInfoArray_cast(long j, BlockInfoArray blockInfoArray);

    public static final native long BlockInfoArray_frompointer(long j, BlockInfo blockInfo);

    public static final native long BlockInfoArray_getitem(long j, BlockInfoArray blockInfoArray, int i);

    public static final native void BlockInfoArray_setitem(long j, BlockInfoArray blockInfoArray, int i, long j2, BlockInfo blockInfo);

    public static final native BigInteger BlockInfo_blockId_get(long j, BlockInfo blockInfo);

    public static final native void BlockInfo_blockId_set(long j, BlockInfo blockInfo, BigInteger bigInteger);

    public static final native int BlockInfo_blockType_get(long j, BlockInfo blockInfo);

    public static final native void BlockInfo_blockType_set(long j, BlockInfo blockInfo, int i);

    public static final native long BlockInfo_endPoint_get(long j, BlockInfo blockInfo);

    public static final native void BlockInfo_endPoint_set(long j, BlockInfo blockInfo, long j2, BlockPoint blockPoint);

    public static final native long BlockInfo_startPoint_get(long j, BlockInfo blockInfo);

    public static final native void BlockInfo_startPoint_set(long j, BlockInfo blockInfo, long j2, BlockPoint blockPoint);

    public static final native int BlockPoint_coorIndex_get(long j, BlockPoint blockPoint);

    public static final native void BlockPoint_coorIndex_set(long j, BlockPoint blockPoint, int i);

    public static final native double BlockPoint_lat_get(long j, BlockPoint blockPoint);

    public static final native void BlockPoint_lat_set(long j, BlockPoint blockPoint, double d);

    public static final native double BlockPoint_lng_get(long j, BlockPoint blockPoint);

    public static final native void BlockPoint_lng_set(long j, BlockPoint blockPoint, double d);

    public static final native double BlockPoint_offsetPercent_get(long j, BlockPoint blockPoint);

    public static final native void BlockPoint_offsetPercent_set(long j, BlockPoint blockPoint, double d);

    public static final native double BlockPoint_shapeOffset_get(long j, BlockPoint blockPoint);

    public static final native void BlockPoint_shapeOffset_set(long j, BlockPoint blockPoint, double d);

    public static final native boolean CaculateScaleRuler(long j, int i, double[] dArr);

    public static final native void ClearMJONaviRouteLink_Wrap(long j);

    public static final native int DDCheckCodeIsSubwayStation(int i);

    public static final native long DDCoordinateForMapPoint(long j, DDMapPoint dDMapPoint);

    public static final native long DDLocationCoordinate2DMake(double d, double d2);

    public static final native double DDLocationCoordinate2D_latitude_get(long j, DDLocationCoordinate2D dDLocationCoordinate2D);

    public static final native void DDLocationCoordinate2D_latitude_set(long j, DDLocationCoordinate2D dDLocationCoordinate2D, double d);

    public static final native double DDLocationCoordinate2D_longitude_get(long j, DDLocationCoordinate2D dDLocationCoordinate2D);

    public static final native void DDLocationCoordinate2D_longitude_set(long j, DDLocationCoordinate2D dDLocationCoordinate2D, double d);

    public static final native float DDMapGPSPoint_accuracy_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_accuracy_set(long j, DDMapGPSPoint dDMapGPSPoint, float f);

    public static final native float DDMapGPSPoint_direction_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_direction_set(long j, DDMapGPSPoint dDMapGPSPoint, float f);

    public static final native int DDMapGPSPoint_idx_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_idx_set(long j, DDMapGPSPoint dDMapGPSPoint, int i);

    public static final native double DDMapGPSPoint_lat_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_lat_set(long j, DDMapGPSPoint dDMapGPSPoint, double d);

    public static final native double DDMapGPSPoint_lng_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_lng_set(long j, DDMapGPSPoint dDMapGPSPoint, double d);

    public static final native double DDMapGPSPoint_offset_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_offset_set(long j, DDMapGPSPoint dDMapGPSPoint, double d);

    public static final native float DDMapGPSPoint_speed_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_speed_set(long j, DDMapGPSPoint dDMapGPSPoint, float f);

    public static final native float DDMapGPSPoint_timestamp_get(long j, DDMapGPSPoint dDMapGPSPoint);

    public static final native void DDMapGPSPoint_timestamp_set(long j, DDMapGPSPoint dDMapGPSPoint, float f);

    public static final native long DDMapPointArray_cast(long j, DDMapPointArray dDMapPointArray);

    public static final native long DDMapPointArray_frompointer(long j, DDMapPoint dDMapPoint);

    public static final native long DDMapPointArray_getitem(long j, DDMapPointArray dDMapPointArray, int i);

    public static final native void DDMapPointArray_setitem(long j, DDMapPointArray dDMapPointArray, int i, long j2, DDMapPoint dDMapPoint);

    public static final native long DDMapPointForCoordinate(long j, DDLocationCoordinate2D dDLocationCoordinate2D);

    public static final native int DDMapPoint_x_get(long j, DDMapPoint dDMapPoint);

    public static final native void DDMapPoint_x_set(long j, DDMapPoint dDMapPoint, int i);

    public static final native int DDMapPoint_y_get(long j, DDMapPoint dDMapPoint);

    public static final native void DDMapPoint_y_set(long j, DDMapPoint dDMapPoint, int i);

    public static final native int DDMapPoint_z_get(long j, DDMapPoint dDMapPoint);

    public static final native void DDMapPoint_z_set(long j, DDMapPoint dDMapPoint, int i);

    public static final native int DDMapRectContainsMapRect(long j, long j2);

    public static final native boolean DDMapRectIsEqual(long j, long j2);

    public static final native boolean DDMapRectIsGood(long j);

    public static final native boolean DDMapRectIsZero(long j);

    public static final native long DDMapRectUnion(long j, long j2);

    public static final native long DDUINT8_Array_cast(long j, DDUINT8_Array dDUINT8_Array);

    public static final native long DDUINT8_Array_frompointer(long j);

    public static final native short DDUINT8_Array_getitem(long j, DDUINT8_Array dDUINT8_Array, int i);

    public static final native void DDUINT8_Array_setitem(long j, DDUINT8_Array dDUINT8_Array, int i, short s);

    public static final native Object[] DGLGetTrafficEventRoutePointInfo_Wrap(long j);

    public static final native void DGLGlobalSetApolloCallbacks_Wrap(long j, SwigApolloCallback swigApolloCallback, long j2);

    public static final native Object[] DGLLoadAndGetMJOBindRouteInfo_Wrap(long j, long j2, int i, byte[] bArr, int i2, long[] jArr, int[] iArr, double[] dArr, int i3, long j3);

    public static final native int DGLMapAddTileOverlay_Wrap(long j, long j2);

    public static final native int DGLMapCancelDownloadData_Wrap(long j, String str);

    public static final native void DGLMapCancelDynamicDownloadData(long j, String str);

    public static final native boolean DGLMapCheckNeedGuard(String str, int i, int i2, int i3);

    public static final native void DGLMapClearAllTappedTextAnnoationHidden(long j);

    public static final native void DGLMapClearCache(long j);

    public static final native void DGLMapClearDynamicMapCache(long j);

    public static final native boolean DGLMapClearExtendEventData_Wrap(long j);

    public static final native void DGLMapClearRouteNameSegments(long j);

    public static final native void DGLMapClearTrafficData(long j);

    public static final native void DGLMapClearTrafficEventData_Wrap(long j);

    public static final native void DGLMapDDApolloSetUseVulkan(boolean z);

    public static final native void DGLMapDDSetUseMJO(boolean z);

    public static final native boolean DGLMapDeleteRouteNameSegments(long j, long j2);

    public static final native void DGLMapDestroy_Wrap(long j, long j2);

    public static final native int DGLMapFetchTrafficBlockData_Wrap(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public static final native byte[] DGLMapGenVecEnlargePNGImage_Wrap(long j, byte[] bArr, long j2, float f);

    public static final native boolean DGLMapGenerateTextures(long j);

    public static final native void DGLMapGetCenterMapPoint_Wrap(long j, double[] dArr);

    public static final native void DGLMapGetCityName(long j, int i, int i2, String str, int i3);

    public static final native int DGLMapGetEnableDynamicLayerType(long j);

    public static final native int DGLMapGetMapMode(long j);

    public static final native int DGLMapGetRenderExtendIcon_Wrap(long j);

    public static final native float DGLMapGetRotate(long j);

    public static final native void DGLMapGetRouteArrowFurthestPt_Wrap(long j, double[] dArr);

    public static final native String DGLMapGetRouteUrl(long j);

    public static final native double DGLMapGetScale(long j);

    public static final native float DGLMapGetSkew(long j);

    public static final native String DGLMapGetStyleUrl(long j);

    public static final native void DGLMapHideMJO_Wrap(long j, boolean z);

    public static final native void DGLMapLoadMJO_Wrap(long j);

    public static final native int DGLMapMarkerBezierCurveCreate_Wrap(long j, double[] dArr, int[] iArr, float f, float f2, float f3);

    public static final native void DGLMapMoveBy_Wrap(long j, float f, float f2);

    public static final native void DGLMapProcessBlockInfo(int i, long j, long j2, long j3, DDMapPoint dDMapPoint, int i2, long j4, BlockInfo blockInfo, int i3);

    public static final native void DGLMapReleaseTappedElementBuffer(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapReloadTileOverlay(long j, int i);

    public static final native void DGLMapRemoveTileOverlay(long j, int i);

    public static final native void DGLMapRenderExtendIconShow(long j, BigInteger bigInteger, boolean z);

    public static final native boolean DGLMapRenderFrameSeconds_Wrap(long j, long j2);

    public static final native void DGLMapRestoreMapOnMJOHide_Wrap(long j, long j2, int i, double d, double d2, double d3, float f, float f2);

    public static final native int DGLMapRouteTrueClearPoint_Wrap(long j, int i, double[] dArr);

    public static final native long DGLMapScreenXY2MapPoint(long j, float f, float f2);

    public static final native void DGLMapSetABTestMode4Json(long j, String str, int i);

    public static final native int DGLMapSetAnnotationLightVisible_Wrap(long j, boolean z);

    public static final native void DGLMapSetAttachDir(long j, String str);

    public static final native void DGLMapSetBezierCurveAnimationState(long j, int i, float f);

    public static final native void DGLMapSetBlockEventCallback_Wrap(long j, long j2, long j3, SwigBlockEventCallback swigBlockEventCallback);

    public static final native void DGLMapSetCallbacks_Wrap(long j, long j2, long j3, SwigMapCallback swigMapCallback, boolean z);

    public static final native void DGLMapSetCenterMapPoint_Wrap(long j, double d, double d2);

    public static final native void DGLMapSetDisplayFishBoneGrayBubbleOnly(long j, boolean z);

    public static final native void DGLMapSetDynamicLayerDataWithResult(long j, String str, long j2, int i, long j3);

    public static final native void DGLMapSetDynamicLayerData_Wrap(long j, String str, byte[] bArr, int i);

    public static final native void DGLMapSetDynamicMapAutoRefresh(long j, boolean z);

    public static final native void DGLMapSetEdgePaddingForRoute(long j, float f, float f2, float f3, float f4);

    public static final native void DGLMapSetEdgePaddingOffset(long j, float f, float f2, float f3, float f4);

    public static final native void DGLMapSetEnableDynamicLayer(long j, int i);

    public static final native boolean DGLMapSetEnableOffScreenRender(long j, boolean z);

    public static final native boolean DGLMapSetExtendEventData_Wrap(long j, byte[] bArr, int i);

    public static final native void DGLMapSetExtendIconVisible_Wrap(long j, boolean z);

    public static final native void DGLMapSetFlagOfZoomToSpanForLocation_Wrap(long j, float f, float f2, float f3, float f4, int i, int i2);

    public static final native int DGLMapSetInternationalWms_Wrap(long j, boolean z);

    public static final native void DGLMapSetLocationFollow(long j, boolean z, boolean z2, boolean z3, boolean z4);

    public static final native void DGLMapSetLocationHeading(long j, float f);

    public static final native void DGLMapSetLocationInfoWithSkewAndScale_Wrap(long j, long j2, double d, double d2, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2);

    public static final native void DGLMapSetLocationInfo_Wrap(long j, long j2, double d, double d2, float f, float f2, float f3, boolean z, boolean z2);

    public static final native void DGLMapSetMJOCallback_Wrap(long j, long j2, long j3, SwigMJOCallback swigMJOCallback);

    public static final native void DGLMapSetMapMode(long j, int i);

    public static final native void DGLMapSetMaxScaleLevel(long j, int i);

    public static final native void DGLMapSetMinScaleLevel(long j, int i);

    public static final native void DGLMapSetNeedsDisplay(long j, boolean z);

    public static final native void DGLMapSetResPackPath(long j, String str, String str2);

    public static final native void DGLMapSetRestrictAreaVisible_Wrap(long j, boolean z);

    public static final native void DGLMapSetRotate_Wrap(long j, long j2, float f);

    public static final native boolean DGLMapSetRouteNameClearPoint(long j, long j2, int i);

    public static final native boolean DGLMapSetRouteNameClearPoint_Wrap(long j, long j2, long j3, int i, boolean z);

    public static final native void DGLMapSetRouteNameVisiable(long j, boolean z);

    public static final native void DGLMapSetRouteNameVisible_Wrap(long j, long j2, boolean z);

    public static final native void DGLMapSetScaleLevel(long j, int i, boolean z);

    public static final native void DGLMapSetScaleLevelWithCallback(long j, int i, boolean z, long j2, long j3);

    public static final native void DGLMapSetScale_Wrap(long j, long j2, double d);

    public static final native void DGLMapSetSkew_Wrap(long j, long j2, float f);

    public static final native void DGLMapSetTappedTextAnnotationHidden(long j, int i, long j2, DDMapPoint dDMapPoint, boolean z);

    public static final native void DGLMapSetTappedTextAnnotationHiddenWithID(long j, BigInteger bigInteger, boolean z);

    public static final native void DGLMapSetTrafficColor_Wrap(long j, int i, int i2, int i3, int i4);

    public static final native int DGLMapSetTrafficData_Wrap(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    public static final native void DGLMapSetTrafficEnabled(long j, boolean z);

    public static final native void DGLMapSetTrafficEventData_Wrap(long j, byte[] bArr, int i);

    public static final native void DGLMapSetTrafficEventIconHiddenWithType(long j, int i, boolean z);

    public static final native void DGLMapShowMJOAndSetCamera_Wrap(long j, long j2);

    public static final native void DGLMapStyleLock();

    public static final native void DGLMapStyleUnlock();

    public static final native int DGLMapTappedElement_aboardPointUrlLen_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_aboardPointUrlLen_set(long j, DGLMapTappedElement dGLMapTappedElement, int i);

    public static final native short[] DGLMapTappedElement_aboardPointUrl_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_aboardPointUrl_set(long j, DGLMapTappedElement dGLMapTappedElement, short[] sArr);

    public static final native int DGLMapTappedElement_busPbBufferLen_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_busPbBufferLen_set(long j, DGLMapTappedElement dGLMapTappedElement, int i);

    public static final native long DGLMapTappedElement_busPbBuffer_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_busPbBuffer_set(long j, DGLMapTappedElement dGLMapTappedElement, long j2);

    public static final native BigInteger DGLMapTappedElement_identity_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_identity_set(long j, DGLMapTappedElement dGLMapTappedElement, BigInteger bigInteger);

    public static final native long DGLMapTappedElement_itemId_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_itemId_set(long j, DGLMapTappedElement dGLMapTappedElement, long j2);

    public static final native int DGLMapTappedElement_itemType_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_itemType_set(long j, DGLMapTappedElement dGLMapTappedElement, int i);

    public static final native int DGLMapTappedElement_nameLen_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_nameLen_set(long j, DGLMapTappedElement dGLMapTappedElement, int i);

    public static final native int[] DGLMapTappedElement_name_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_name_set(long j, DGLMapTappedElement dGLMapTappedElement, int[] iArr);

    public static final native short DGLMapTappedElement_subIndex_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_subIndex_set(long j, DGLMapTappedElement dGLMapTappedElement, short s);

    public static final native int DGLMapTappedElement_type_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_type_set(long j, DGLMapTappedElement dGLMapTappedElement, int i);

    public static final native long DGLMapTappedElement_vioParkingContent_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_vioParkingContent_set(long j, DGLMapTappedElement dGLMapTappedElement, long j2, DGLMapVioParkBizContent dGLMapVioParkBizContent);

    public static final native int DGLMapTappedElement_x_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_x_set(long j, DGLMapTappedElement dGLMapTappedElement, int i);

    public static final native int DGLMapTappedElement_y_get(long j, DGLMapTappedElement dGLMapTappedElement);

    public static final native void DGLMapTappedElement_y_set(long j, DGLMapTappedElement dGLMapTappedElement, int i);

    public static final native void DGLMapUpdateLocalTrafficIcon_Wrap(long j, Object[] objArr);

    public static final native boolean DGLMapVecEnlargeAddData_Wrap(long j, String str, byte[] bArr, long j2, float f);

    public static final native boolean DGLMapVecEnlargeDestroy(long j, String str);

    public static final native void DGLMapVecEnlargeDestroyAll(long j);

    public static final native boolean DGLMapVecEnlargeIsVisible_Wrap(long j, String str, boolean z);

    public static final native void DGLMapVecEnlargeSetVisibleArea(long j, int i, int i2, int i3, int i4, float f);

    public static final native int DGLMapVioParkBizContent_bizType_get(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent);

    public static final native void DGLMapVioParkBizContent_bizType_set(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent, int i);

    public static final native String DGLMapVioParkBizContent_dataVersion_get(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent);

    public static final native void DGLMapVioParkBizContent_dataVersion_set(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent, String str);

    public static final native String DGLMapVioParkBizContent_name_get(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent);

    public static final native void DGLMapVioParkBizContent_name_set(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent, String str);

    public static final native String DGLMapVioParkBizContent_uniqID_get(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent);

    public static final native void DGLMapVioParkBizContent_uniqID_set(long j, DGLMapVioParkBizContent dGLMapVioParkBizContent, String str);

    public static final native int DGLMapWriteDownloadData_Wrap(long j, String str, byte[] bArr, int i);

    public static final native void DGLRemoveAllLocalTrafficIcon(long j);

    public static final native void DGLResetTrafficEventIconCustomSize(long j);

    public static final native void DGLSetAboardPointJson(long j, String str, int i);

    public static final native void DGLSetMarkerRect_Wrap(long j, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i);

    public static final native void DGLSetTrafficEventIconCustomSize(long j, int i, long j2, long j3);

    public static final native boolean DGLShowTrafficEvent(long j, boolean z);

    public static final native void DGLUpdateItemShowState(long j, BigInteger bigInteger, short s, boolean z);

    public static final native int DMapAddMarker_Wrap(long j, double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i, int i2, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, float f8, boolean z7, boolean z8, Object obj, boolean z9);

    public static final native void DMapAddViolationParkingSection(long j, int i, int i2, int i3, float f, int i4, float f2);

    public static final native boolean DMapApolloData_boolValue_get(long j, DMapApolloData dMapApolloData);

    public static final native void DMapApolloData_boolValue_set(long j, DMapApolloData dMapApolloData, boolean z);

    public static final native int DMapApolloData_intValue_get(long j, DMapApolloData dMapApolloData);

    public static final native void DMapApolloData_intValue_set(long j, DMapApolloData dMapApolloData, int i);

    public static final native long DMapApolloData_stringLength_get(long j, DMapApolloData dMapApolloData);

    public static final native void DMapApolloData_stringLength_set(long j, DMapApolloData dMapApolloData, long j2);

    public static final native String DMapApolloData_stringValue_get(long j, DMapApolloData dMapApolloData);

    public static final native void DMapApolloData_stringValue_set(long j, DMapApolloData dMapApolloData, String str);

    public static final native int DMapArrowType_Circle_get();

    public static final native int DMapArrowType_Left_get();

    public static final native int DMapArrowType_Right_get();

    public static final native int DMapArrowType_Straight_get();

    public static final native int DMapArrowType_TurnAround_get();

    public static final native int DMapArrowType_Unknown_get();

    public static final native void DMapAutoScaleWithPoint(long j, long j2, DDMapPoint dDMapPoint, boolean z, long j3, long j4, double d, double d2);

    public static final native void DMapBuildingSetEffect3D(long j, boolean z);

    public static final native int DMapCircleCreate_Wrap(long j, double d, double d2, float f, int i, short[] sArr, int i2, float f2, boolean z, float f3, int i3, boolean z2);

    public static final native void DMapCircleModify_Wrap(long j, int i, double d, double d2, float f, int i2, short[] sArr, int i3, float f2, boolean z, float f3, int i4);

    public static final native boolean DMapCompassIsHidden(long j);

    public static final native void DMapCompassSetHidden(long j, boolean z);

    public static final native long DMapCreateDataDelegate_backContext_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_backContext_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, long j2);

    public static final native float DMapCreateDataDelegate_density_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_density_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, float f);

    public static final native boolean DMapCreateDataDelegate_isRetina_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_isRetina_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, boolean z);

    public static final native boolean DMapCreateDataDelegate_isVectorMap_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_isVectorMap_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, boolean z);

    public static final native int DMapCreateDataDelegate_language_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_language_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, int i);

    public static final native long DMapCreateDataDelegate_mainContext_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_mainContext_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, long j2);

    public static final native long DMapCreateDataDelegate_mapEngineVersion_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_mapEngineVersion_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, long j2);

    public static final native int DMapCreateDataDelegate_multiSimple_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_multiSimple_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, int i);

    public static final native float DMapCreateDataDelegate_textScale_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_textScale_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, float f);

    public static final native int DMapCreateDataDelegate_theme_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_theme_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, int i);

    public static final native int DMapCreateDataDelegate_tileSize_get(long j, DMapCreateDataDelegate dMapCreateDataDelegate);

    public static final native void DMapCreateDataDelegate_tileSize_set(long j, DMapCreateDataDelegate dMapCreateDataDelegate, int i);

    public static final native long DMapCreateMap_Wrap(long j, DMapCreateDataDelegate dMapCreateDataDelegate, String str, String str2, String str3, String str4, long j2);

    public static final native int DMapDownload_WMS_get();

    public static final native int DMapDynamicLayerTypeActivity_get();

    public static final native int DMapDynamicLayerTypeCloseAll_get();

    public static final native int DMapDynamicLayerTypeRoadClosure_get();

    public static final native int DMapDynamicLayerTypeTrafficEvent_get();

    public static final native int DMapDynamicLayerTypeVioParking_get();

    public static final native void DMapFlashViolationParkingSection(long j, int i, int i2, boolean z);

    public static final native boolean DMapGetLevelPointPerMeter(long j, double[] dArr);

    public static final native long DMapGetScreenCenterOffset(long j);

    public static final native long DMapGetWorldCoordinate(long j, long j2, DMapVector2f dMapVector2f);

    public static final native void DMapHibernate(long j);

    public static final native boolean DMapIsUseStyleV2();

    public static final native int DMapLanguage_Chinese_get();

    public static final native long DMapLine_points_get(long j, DMapLine dMapLine);

    public static final native void DMapLine_points_set(long j, DMapLine dMapLine, long j2, DDMapPoint dDMapPoint);

    public static final native BigInteger DMapLine_routeId_get(long j, DMapLine dMapLine);

    public static final native void DMapLine_routeId_set(long j, DMapLine dMapLine, BigInteger bigInteger);

    public static final native int DMapLine_size_get(long j, DMapLine dMapLine);

    public static final native void DMapLine_size_set(long j, DMapLine dMapLine, int i);

    public static final native float DMapLine_width_get(long j, DMapLine dMapLine);

    public static final native void DMapLine_width_set(long j, DMapLine dMapLine, float f);

    public static final native void DMapLocatorModiffyZIndex(long j, int i);

    public static final native void DMapLocatorModifyAccuracyAreaColor(long j, long j2);

    public static final native void DMapLocatorModifyCompassImage_Wrap(long j, String str, String str2, String str3, String str4, String str5, float f, float f2);

    public static final native void DMapLocatorModifyIndicatorImage_Wrap(long j, String str, float f, float f2);

    public static final native void DMapLocatorSetAccuracyAreaHidden(long j, boolean z);

    public static final native void DMapLocatorSetCompassHidden(long j, boolean z);

    public static final native void DMapLocatorSetIndicatorHidden(long j, boolean z);

    public static final native void DMapMarkerDelete(long j, int[] iArr, int i);

    public static final native float DMapMarkerGetAlpha(long j, int i);

    public static final native float DMapMarkerGetAngle(long j, int i);

    public static final native long DMapMarkerGetCoordinate(long j, int i);

    public static final native void DMapMarkerGetGeoBound_Wrap(long j, int i, double[] dArr);

    public static final native int DMapMarkerGetPriority(long j, int i);

    public static final native long DMapMarkerGetScale(long j, int i);

    public static final native void DMapMarkerGetScreenArea_Wrap(long j, int i, float[] fArr);

    public static final native void DMapMarkerIconModifyInfo_Wrap(long j, int i, double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i2, int i3, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i4, float f8, boolean z7, Object obj, boolean z8);

    public static final native boolean DMapMarkerIsHidden(long j, int i);

    public static final native int DMapMarkerLocatorGetID_Wrap(long j);

    public static final native void DMapMarkerLocatorSetHidden(long j, boolean z);

    public static final native int DMapMarkerLocator_DefaultAccuracyEdgeColor_get();

    public static final native void DMapMarkerModifyAlpha_Wrap(long j, int i, float f);

    public static final native void DMapMarkerModifyAngle(long j, int i, float f);

    public static final native void DMapMarkerModifyColor(long j, int i, long j2, DMapVector4f dMapVector4f);

    public static final native void DMapMarkerModifyImage(long j, int i, String str, long j2, DMapVector2f dMapVector2f);

    public static final native void DMapMarkerModifyPosition_Wrap(long j, int i, double d, double d2);

    public static final native void DMapMarkerModifyScale_Wrap(long j, int i, float f, float f2);

    public static final native void DMapMarkerModifyScreenOffset_Wrap(long j, int i, float f, float f2);

    public static final native int DMapMarkerRegularPrimitiveCreate_Wrap(long j, double[] dArr, double[] dArr2, int i, float f, short[] sArr, double[] dArr3, int i2, float f2, boolean z, int i3);

    public static final native void DMapMarkerRegularPrimitiveUpdate_Wrap(long j, int i, double[] dArr, double[] dArr2, int i2, float f, short[] sArr, double[] dArr3, int i3, float f2, boolean z, int i4);

    public static final native void DMapMarkerSetForceLoad(long j, int i, boolean z);

    public static final native void DMapMarkerSetHidden(long j, int[] iArr, int i, boolean z);

    public static final native void DMapMarkerSetPriority(long j, int i, int i2);

    public static final native void DMapMarkerSetRenderOrder(long j, int i, int i2);

    public static final native int DMapNewPolygonCreate_Wrap(long j, double[] dArr, double[] dArr2, int i, boolean z, short[] sArr, int i2, float f, boolean z2, float f2, int i3);

    public static final native void DMapPolylineModifyPoints_Wrap(long j, int i, double[] dArr, double[] dArr2, int i2);

    public static final native void DMapPrimitiveDelete(long j, int i);

    public static final native void DMapPrimitiveSetHidden(long j, int i, boolean z);

    public static final native int DMapPrimitiveType_CircleOverPolygon_get();

    public static final native int DMapPrimitiveType_LineLoop_get();

    public static final native int DMapPrimitiveType_Line_get();

    public static final native int DMapPrimitiveType_Polygon_get();

    public static final native long DMapQueryViolationParkingIconPos(long j, int i, int i2, int i3, long j2, DDMapPoint dDMapPoint);

    public static final native void DMapRemoveViolationParkingSection(long j, int i, int i2);

    public static final native void DMapResetPath(long j, int i, String str, String str2, String str3);

    public static final native void DMapRouteDelete(long j, int i);

    public static final native double DMapRouteGetAnimationColorLineCutHeadProgress(long j, int i);

    public static final native double DMapRouteGetAnimationColorLineCutTailProgress(long j, int i);

    public static final native boolean DMapRouteGetAnimationColorLineDisableSimplify(long j, int i);

    public static final native long DMapRouteGetAnimationColorLineScanMixColor(long j, int i);

    public static final native double DMapRouteGetAnimationColorLineScanProgress(long j, int i);

    public static final native void DMapRouteModifyWidth_Wrap(long j, int i, float f);

    public static final native void DMapRouteSetAlpha(long j, int i, float f);

    public static final native void DMapRouteSetAnimationColorLineCutHeadProgress(long j, int i, double d);

    public static final native void DMapRouteSetAnimationColorLineCutTailProgress(long j, int i, double d);

    public static final native void DMapRouteSetAnimationColorLineDisableSimplify(long j, int i, boolean z);

    public static final native void DMapRouteSetAnimationColorLineScanMixColor_Wrap(long j, int i, short[] sArr);

    public static final native void DMapRouteSetAnimationColorLineScanProgress(long j, int i, double d);

    public static final native void DMapRouteSetAnimationColorLineScanTextureName(long j, int i, String str);

    public static final native void DMapRouteSetArrowFlip(long j, int i, boolean z);

    public static final native void DMapRouteSetArrowTextureName(long j, int i, String str);

    public static final native void DMapRouteSetClearPoint_Wrap(long j, int i, int i2, double d, double d2);

    public static final native void DMapRouteSetDrawArrow(long j, int i, boolean z);

    public static final native void DMapRouteSetDrawCap(long j, int i, boolean z);

    public static final native void DMapRouteSetHidden(long j, int i, boolean z);

    public static final native void DMapRouteSetPassedPoint_Wrap(long j, int i, int i2, double d, double d2);

    public static final native void DMapRouteSetSelectedRoutes(long j, int[] iArr, int i);

    public static final native void DMapRouteSetTurnArrowIndex2(long j, int i, int i2, int i3);

    public static final native void DMapRouteSetTurnArrowIndex3(long j, int i, int i2, int i3, int i4);

    public static final native void DMapSetLowMemoryMode(long j, boolean z);

    public static final native void DMapSetScreenCenterOffset_Wrap(long j, float f, float f2);

    public static final native void DMapSetScreenSizeAndDPI(long j, int i, int i2, float f, float f2);

    public static final native void DMapSetTheme(long j, int i);

    public static final native void DMapSetViewport(long j, int i, int i2, int i3, int i4);

    public static final native boolean DMapSetVioParkingRegionData_Wrap(long j, byte[] bArr, int i);

    public static final native void DMapSetVisibleScreenArea_Wrap(long j, int i, int i2, int i3);

    public static final native void DMapSetZhongYanEventData_Wrap(long j, byte[] bArr, long j2);

    public static final native int DMapTappedETTextAnnoITNone_get();

    public static final native int DMapTheme_Bus_Station_get();

    public static final native int DMapTheme_Bus_get();

    public static final native int DMapTheme_Default_get();

    public static final native int DMapTheme_Self_Drive_get();

    public static final native double DMapVector2d_height_get(long j, DMapVector2d dMapVector2d);

    public static final native void DMapVector2d_height_set(long j, DMapVector2d dMapVector2d, double d);

    public static final native double DMapVector2d_width_get(long j, DMapVector2d dMapVector2d);

    public static final native void DMapVector2d_width_set(long j, DMapVector2d dMapVector2d, double d);

    public static final native double DMapVector2d_x_get(long j, DMapVector2d dMapVector2d);

    public static final native void DMapVector2d_x_set(long j, DMapVector2d dMapVector2d, double d);

    public static final native double DMapVector2d_y_get(long j, DMapVector2d dMapVector2d);

    public static final native void DMapVector2d_y_set(long j, DMapVector2d dMapVector2d, double d);

    public static final native long DMapVector2fMake(float f, float f2);

    public static final native float DMapVector2f_height_get(long j, DMapVector2f dMapVector2f);

    public static final native void DMapVector2f_height_set(long j, DMapVector2f dMapVector2f, float f);

    public static final native float DMapVector2f_width_get(long j, DMapVector2f dMapVector2f);

    public static final native void DMapVector2f_width_set(long j, DMapVector2f dMapVector2f, float f);

    public static final native float DMapVector2f_x_get(long j, DMapVector2f dMapVector2f);

    public static final native void DMapVector2f_x_set(long j, DMapVector2f dMapVector2f, float f);

    public static final native float DMapVector2f_y_get(long j, DMapVector2f dMapVector2f);

    public static final native void DMapVector2f_y_set(long j, DMapVector2f dMapVector2f, float f);

    public static final native float DMapVector4f_a_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_a_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native float DMapVector4f_b_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_b_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native float DMapVector4f_g_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_g_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native float DMapVector4f_r_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_r_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native float DMapVector4f_w_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_w_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native float DMapVector4f_x_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_x_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native float DMapVector4f_y_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_y_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native float DMapVector4f_z_get(long j, DMapVector4f dMapVector4f);

    public static final native void DMapVector4f_z_set(long j, DMapVector4f dMapVector4f, float f);

    public static final native void DMapVulkanAcquireImage(long j);

    public static final native void DMapVulkanCleanUpContext(long j);

    public static final native long DMapVulkanCreate();

    public static final native void DMapVulkanCreateContext(long j);

    public static final native void DMapVulkanDestroyContext(long j);

    public static final native boolean DMapVulkanIsSupport(long j);

    public static final native void DMapVulkanPause(long j);

    public static final native void DMapVulkanQueuePresent(long j);

    public static final native void DMapVulkanResume(long j);

    public static final native void DMapVulkanSetWindow_Wrap(long j, Object obj);

    public static final native void DMapVulkanStart(long j);

    public static final native void DMapVulkanStop(long j);

    public static final native void DMapVulkanSurfaceChanged(long j);

    public static final native void DMapVulkanSurfaceCreated(long j);

    public static final native void DMapVulkanSurfaceDestroy(long j);

    public static final native void DMapZoomForNavigation_Wrap(long j, double d, double d2);

    public static final native int DMapZoomStatus_CARPLAY_get();

    public static final native int DMapZoomStatus_HUGE_get();

    public static final native int DMapZoomStatus_INVALID_get();

    public static final native int DMapZoomStatus_LARGE_get();

    public static final native int DMapZoomStatus_NORMAL_get();

    public static final native int DMapZoomStatus_SMALL_get();

    public static final native boolean DMapZoomToSpan_Wrap(long j, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4);

    public static final native int DMarkerRenderOrder_Default_get();

    public static final native long DOverlayLineInfoArray_cast(long j, DOverlayLineInfoArray dOverlayLineInfoArray);

    public static final native long DOverlayLineInfoArray_frompointer(long j, DOverlayLineInfo dOverlayLineInfo);

    public static final native long DOverlayLineInfoArray_getitem(long j, DOverlayLineInfoArray dOverlayLineInfoArray, int i);

    public static final native void DOverlayLineInfoArray_setitem(long j, DOverlayLineInfoArray dOverlayLineInfoArray, int i, long j2, DOverlayLineInfo dOverlayLineInfo);

    public static final native int DOverlayLineInfo_color_get(long j, DOverlayLineInfo dOverlayLineInfo);

    public static final native void DOverlayLineInfo_color_set(long j, DOverlayLineInfo dOverlayLineInfo, int i);

    public static final native int DOverlayLineInfo_endNum_get(long j, DOverlayLineInfo dOverlayLineInfo);

    public static final native void DOverlayLineInfo_endNum_set(long j, DOverlayLineInfo dOverlayLineInfo, int i);

    public static final native String DOverlayLineInfo_roadName_get(long j, DOverlayLineInfo dOverlayLineInfo);

    public static final native void DOverlayLineInfo_roadName_set(long j, DOverlayLineInfo dOverlayLineInfo, String str);

    public static final native int DOverlayLineInfo_speed_get(long j, DOverlayLineInfo dOverlayLineInfo);

    public static final native void DOverlayLineInfo_speed_set(long j, DOverlayLineInfo dOverlayLineInfo, int i);

    public static final native int DOverlayLineInfo_startNum_get(long j, DOverlayLineInfo dOverlayLineInfo);

    public static final native void DOverlayLineInfo_startNum_set(long j, DOverlayLineInfo dOverlayLineInfo, int i);

    public static final native void DeleteRouteNameSegment_Wrap(long j, long j2, long j3);

    public static final native void DeleteSpecialBubbleWithType_Wrap(long j, int i);

    public static final native double DoubleEvaluateSpeedUp(double d, double d2, float f);

    public static final native int EXTEND_RENDER_EVENT_MAX_CODE_get();

    public static final native int EXTEND_RENDER_EVENT_MIN_CODE_get();

    public static final native float FloatEvaluateSpeedUp(float f, float f2, float f3);

    public static final native int GenerateCirclePoint(double d, double d2, float f, int i, double[] dArr, double[] dArr2, int i2);

    public static final native boolean GetMapOverlayRealVisible(long j, long j2, long j3);

    public static final native int GetZIndexStart_Wrap(int i);

    public static final native void HWBSManager_addBlockEvent(long j, HWBSManager hWBSManager, long j2, long j3, DDMapPoint dDMapPoint, int i, long j4, BlockInfo blockInfo, int i2);

    public static final native void HWBSManager_addBlueBubbleRouteName(long j, HWBSManager hWBSManager, long j2, long j3, int i, long j4, DDMapPoint dDMapPoint, int i2);

    public static final native void HWBSManager_addMainRoute4Collision(long j, HWBSManager hWBSManager, long j2, DMapLine dMapLine);

    public static final native void HWBSManager_addOverlay(long j, HWBSManager hWBSManager, long j2, MapOverlay mapOverlay);

    public static final native void HWBSManager_addRemoteIconBindOverlay(long j, HWBSManager hWBSManager, long j2, MapOverlay mapOverlay, long j3);

    public static final native void HWBSManager_addRoute4Collision(long j, HWBSManager hWBSManager, long j2, DMapLine dMapLine);

    public static final native void HWBSManager_changeRemoteIconBindOverlay(long j, HWBSManager hWBSManager, long j2, long j3);

    public static final native void HWBSManager_clearRoute4Collision(long j, HWBSManager hWBSManager);

    public static final native void HWBSManager_deleteBlueBubbleRouteName(long j, HWBSManager hWBSManager, long j2);

    public static final native void HWBSManager_destroy(long j, HWBSManager hWBSManager);

    public static final native void HWBSManager_drawFrame(long j, HWBSManager hWBSManager);

    public static final native long HWBSManager_findBubbleId(long j, HWBSManager hWBSManager, int i);

    public static final native void HWBSManager_getOverlayProperty(long j, HWBSManager hWBSManager, long j2, int[] iArr, int[] iArr2, int[] iArr3);

    public static final native void HWBSManager_handleCollision(long j, HWBSManager hWBSManager);

    public static final native void HWBSManager_handleSpecialBubblePosition(long j, HWBSManager hWBSManager);

    public static final native void HWBSManager_initCollisionRect(long j, HWBSManager hWBSManager, int i, int i2, int i3, int i4);

    public static final native void HWBSManager_refreshRemoteIconPosition(long j, HWBSManager hWBSManager);

    public static final native void HWBSManager_removeBlockEvent(long j, HWBSManager hWBSManager, long j2);

    public static final native void HWBSManager_removeOverlay(long j, HWBSManager hWBSManager, long j2);

    public static final native void HWBSManager_removeRemoteIcon(long j, HWBSManager hWBSManager, long j2);

    public static final native void HWBSManager_set3dPaddingTopOffset(long j, HWBSManager hWBSManager, float f);

    public static final native void HWBSManager_setAnimateSwitch(long j, HWBSManager hWBSManager, boolean z, boolean z2);

    public static final native void HWBSManager_setBarn(long j, HWBSManager hWBSManager, long j2, DMapVector2d dMapVector2d, double d, double d2, long j3, DMapVector2d dMapVector2d2, double d3, double d4, long j4, DMapVector2d dMapVector2d3, long j5, DMapVector2d dMapVector2d4, long j6, DMapVector2d dMapVector2d5);

    public static final native void HWBSManager_setBarnSimple(long j, HWBSManager hWBSManager, double d, double d2, long j2, DMapVector2d dMapVector2d, long j3, DMapVector2d dMapVector2d2, long j4, DMapVector2d dMapVector2d3);

    public static final native void HWBSManager_setBlockEventCallback(long j, HWBSManager hWBSManager, long j2, long j3);

    public static final native void HWBSManager_setBlueBubbleCallback(long j, HWBSManager hWBSManager, long j2, long j3);

    public static final native void HWBSManager_setBlueBubbleVisible(long j, HWBSManager hWBSManager, boolean z);

    public static final native void HWBSManager_setDayNight(long j, HWBSManager hWBSManager, boolean z);

    public static final native void HWBSManager_setIsAreaBubbleEnable(long j, HWBSManager hWBSManager, boolean z);

    public static final native void HWBSManager_setIsOpenDebug(long j, HWBSManager hWBSManager, boolean z);

    public static final native void HWBSManager_setLocatorPosition(long j, HWBSManager hWBSManager, long j2, DDMapPoint dDMapPoint);

    public static final native void HWBSManager_setLogCallback(long j, HWBSManager hWBSManager, long j2, long j3);

    public static final native void HWBSManager_setNavMode(long j, HWBSManager hWBSManager, int i);

    public static final native void HWBSManager_setNewMultiBubbleCollisionEnable(long j, HWBSManager hWBSManager, boolean z);

    public static final native void HWBSManager_setOverlayVisible(long j, HWBSManager hWBSManager, long j2, boolean z);

    public static final native void HWBSManager_setPWorld(long j, HWBSManager hWBSManager, long j2);

    public static final native void HWBSManager_setPadding(long j, HWBSManager hWBSManager, int i, int i2, int i3, int i4);

    public static final native void HWBSManager_setRouteClipIndex__SWIG_0(long j, HWBSManager hWBSManager, int i);

    public static final native void HWBSManager_setRouteClipIndex__SWIG_1(long j, HWBSManager hWBSManager, long j2, int i, boolean z);

    public static final native void HWBSManager_setScreenDensity(long j, HWBSManager hWBSManager, float f);

    public static final native void HWBSManager_setThresholdSwitch(long j, HWBSManager hWBSManager, boolean z, float f);

    public static final native void HWBSManager_updateBlockEvent(long j, HWBSManager hWBSManager, long j2, long j3, BlockInfo blockInfo, int i);

    public static final native void HWBSManager_updateOverlay(long j, HWBSManager hWBSManager, long j2, MapOverlay mapOverlay);

    public static final native void HWBSManager_updateOverlayName(long j, HWBSManager hWBSManager, long j2, String str);

    public static final native void HWBSManager_updateOverlayPointArea(long j, HWBSManager hWBSManager, long j2, long j3, MapPointArea mapPointArea);

    public static final native void HWBSManager_updateOverlayPosition(long j, HWBSManager hWBSManager, long j2, double d, double d2);

    public static final native int HW_TRAFFIC_JAM_ACCIDENT_get();

    public static final native int HW_TRAFFIC_JAM_HOSPITAL_get();

    public static final native int HW_TRAFFIC_JAM_IMAGE_get();

    public static final native int HW_TRAFFIC_JAM_MULTI_get();

    public static final native int HW_TRAFFIC_JAM_NONE_get();

    public static final native int HW_TRAFFIC_JAM_SCHOOL_get();

    public static final native int HW_TRAFFIC_JAM_get();

    public static final native boolean IsPointInDDMapRect(long j, int i, int i2);

    public static final native boolean IsPointInDDMapRectEx(long j, long j2, DDMapPoint dDMapPoint);

    public static final native boolean IsPointInTXMapRect(long j, int i, int i2);

    public static final native boolean LatLng2Screen_Wrap(long j, double d, double d2, float[] fArr);

    public static final native void MapOverlayHandleCollision(long j, long j2);

    public static final native long MapOverlayMapTappedElement_dglMapTappedElement_get(long j, MapOverlayMapTappedElement mapOverlayMapTappedElement);

    public static final native void MapOverlayMapTappedElement_dglMapTappedElement_set(long j, MapOverlayMapTappedElement mapOverlayMapTappedElement, long j2, DGLMapTappedElement dGLMapTappedElement);

    public static final native long MapOverlayMapTappedElement_overlayId_get(long j, MapOverlayMapTappedElement mapOverlayMapTappedElement);

    public static final native void MapOverlayMapTappedElement_overlayId_set(long j, MapOverlayMapTappedElement mapOverlayMapTappedElement, long j2);

    public static final native long MapOverlayRectArray_cast(long j, MapOverlayRectArray mapOverlayRectArray);

    public static final native long MapOverlayRectArray_frompointer(long j, MapOverlayRect mapOverlayRect);

    public static final native long MapOverlayRectArray_getitem(long j, MapOverlayRectArray mapOverlayRectArray, int i);

    public static final native void MapOverlayRectArray_setitem(long j, MapOverlayRectArray mapOverlayRectArray, int i, long j2, MapOverlayRect mapOverlayRect);

    public static final native float MapOverlayRect_anchorX_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_anchorX_set(long j, MapOverlayRect mapOverlayRect, float f);

    public static final native float MapOverlayRect_anchorY_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_anchorY_set(long j, MapOverlayRect mapOverlayRect, float f);

    public static final native int MapOverlayRect_height_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_height_set(long j, MapOverlayRect mapOverlayRect, int i);

    public static final native String MapOverlayRect_name_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_name_set(long j, MapOverlayRect mapOverlayRect, String str);

    public static final native int MapOverlayRect_paddingBottom_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_paddingBottom_set(long j, MapOverlayRect mapOverlayRect, int i);

    public static final native int MapOverlayRect_paddingLeft_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_paddingLeft_set(long j, MapOverlayRect mapOverlayRect, int i);

    public static final native int MapOverlayRect_paddingRight_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_paddingRight_set(long j, MapOverlayRect mapOverlayRect, int i);

    public static final native int MapOverlayRect_paddingTop_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_paddingTop_set(long j, MapOverlayRect mapOverlayRect, int i);

    public static final native int MapOverlayRect_width_get(long j, MapOverlayRect mapOverlayRect);

    public static final native void MapOverlayRect_width_set(long j, MapOverlayRect mapOverlayRect, int i);

    public static final native float MapOverlay_alpha_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_alpha_set(long j, MapOverlay mapOverlay, float f);

    public static final native float MapOverlay_angle_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_angle_set(long j, MapOverlay mapOverlay, float f);

    public static final native int MapOverlay_collisionType_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_collisionType_set(long j, MapOverlay mapOverlay, int i);

    public static final native int MapOverlay_fixPosX_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_fixPosX_set(long j, MapOverlay mapOverlay, int i);

    public static final native int MapOverlay_fixPosY_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_fixPosY_set(long j, MapOverlay mapOverlay, int i);

    public static final native int MapOverlay_groupId_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_groupId_set(long j, MapOverlay mapOverlay, int i);

    public static final native boolean MapOverlay_isAvoidAnno_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isAvoidAnno_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native boolean MapOverlay_isClockwise_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isClockwise_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native boolean MapOverlay_isFastLoad_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isFastLoad_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native boolean MapOverlay_isFixPosition_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isFixPosition_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native boolean MapOverlay_isFlat_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isFlat_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native boolean MapOverlay_isOrthographicProject_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isOrthographicProject_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native boolean MapOverlay_isVirtualOverlay_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isVirtualOverlay_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native boolean MapOverlay_isVirtualScreenOverlay_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_isVirtualScreenOverlay_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native double MapOverlay_latitude_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_latitude_set(long j, MapOverlay mapOverlay, double d);

    public static final native double MapOverlay_longitude_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_longitude_set(long j, MapOverlay mapOverlay, double d);

    public static final native long MapOverlay_overlayId_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_overlayId_set(long j, MapOverlay mapOverlay, long j2);

    public static final native long MapOverlay_pointArea_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_pointArea_set(long j, MapOverlay mapOverlay, long j2, MapPointArea mapPointArea);

    public static final native int MapOverlay_priority_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_priority_set(long j, MapOverlay mapOverlay, int i);

    public static final native int MapOverlay_rectCnt_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_rectCnt_set(long j, MapOverlay mapOverlay, int i);

    public static final native long MapOverlay_rects_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_rects_set(long j, MapOverlay mapOverlay, long j2, MapOverlayRect mapOverlayRect);

    public static final native float MapOverlay_scaleX_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_scaleX_set(long j, MapOverlay mapOverlay, float f);

    public static final native float MapOverlay_scaleY_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_scaleY_set(long j, MapOverlay mapOverlay, float f);

    public static final native boolean MapOverlay_selectBottomRectWhenColliedLocator_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_selectBottomRectWhenColliedLocator_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native String MapOverlay_showInfo_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_showInfo_set(long j, MapOverlay mapOverlay, String str);

    public static final native long MapOverlay_trafficIconAttrs_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_trafficIconAttrs_set(long j, MapOverlay mapOverlay, long j2, MapTrafficIconAttrs mapTrafficIconAttrs);

    public static final native int MapOverlay_type_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_type_set(long j, MapOverlay mapOverlay, int i);

    public static final native long MapOverlay_visibleChangeAnimateAttrs_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_visibleChangeAnimateAttrs_set(long j, MapOverlay mapOverlay, long j2, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs);

    public static final native boolean MapOverlay_visible_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_visible_set(long j, MapOverlay mapOverlay, boolean z);

    public static final native int MapOverlay_zIndex_get(long j, MapOverlay mapOverlay);

    public static final native void MapOverlay_zIndex_set(long j, MapOverlay mapOverlay, int i);

    public static final native int MapPointArea_mapPointCount_get(long j, MapPointArea mapPointArea);

    public static final native void MapPointArea_mapPointCount_set(long j, MapPointArea mapPointArea, int i);

    public static final native long MapPointArea_mapPoint_get(long j, MapPointArea mapPointArea);

    public static final native void MapPointArea_mapPoint_set(long j, MapPointArea mapPointArea, long j2, DDMapPoint dDMapPoint);

    public static final native long MapPointArea_routeID_get(long j, MapPointArea mapPointArea);

    public static final native void MapPointArea_routeID_set(long j, MapPointArea mapPointArea, long j2);

    public static final native int MapPointArea_sectionCount_get(long j, MapPointArea mapPointArea);

    public static final native void MapPointArea_sectionCount_set(long j, MapPointArea mapPointArea, int i);

    public static final native long MapPointArea_sections_get(long j, MapPointArea mapPointArea);

    public static final native void MapPointArea_sections_set(long j, MapPointArea mapPointArea, long j2, MapPointSection mapPointSection);

    public static final native long MapPointSectionArray_cast(long j, MapPointSectionArray mapPointSectionArray);

    public static final native long MapPointSectionArray_frompointer(long j, MapPointSection mapPointSection);

    public static final native long MapPointSectionArray_getitem(long j, MapPointSectionArray mapPointSectionArray, int i);

    public static final native void MapPointSectionArray_setitem(long j, MapPointSectionArray mapPointSectionArray, int i, long j2, MapPointSection mapPointSection);

    public static final native int MapPointSection_endNum_get(long j, MapPointSection mapPointSection);

    public static final native void MapPointSection_endNum_set(long j, MapPointSection mapPointSection, int i);

    public static final native int MapPointSection_maxGeoLength_get(long j, MapPointSection mapPointSection);

    public static final native void MapPointSection_maxGeoLength_set(long j, MapPointSection mapPointSection, int i);

    public static final native int MapPointSection_startNum_get(long j, MapPointSection mapPointSection);

    public static final native void MapPointSection_startNum_set(long j, MapPointSection mapPointSection, int i);

    public static final native boolean MapTrafficIconAttrs_fake_get(long j, MapTrafficIconAttrs mapTrafficIconAttrs);

    public static final native void MapTrafficIconAttrs_fake_set(long j, MapTrafficIconAttrs mapTrafficIconAttrs, boolean z);

    public static final native long MapTrafficIconAttrs_routeID_get(long j, MapTrafficIconAttrs mapTrafficIconAttrs);

    public static final native void MapTrafficIconAttrs_routeID_set(long j, MapTrafficIconAttrs mapTrafficIconAttrs, long j2);

    public static final native int MapVisibleChangeAnimateAttrs_animationType_get(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs);

    public static final native void MapVisibleChangeAnimateAttrs_animationType_set(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs, int i);

    public static final native int MapVisibleChangeAnimateAttrs_duration_get(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs);

    public static final native void MapVisibleChangeAnimateAttrs_duration_set(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs, int i);

    public static final native int MapVisibleChangeAnimateAttrs_interpolatorType_get(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs);

    public static final native void MapVisibleChangeAnimateAttrs_interpolatorType_set(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs, int i);

    public static final native boolean MapVisibleChangeAnimateAttrs_needAnimate_get(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs);

    public static final native void MapVisibleChangeAnimateAttrs_needAnimate_set(long j, MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs, boolean z);

    public static final native float MarginTable_margin1_get(long j, MarginTable marginTable);

    public static final native void MarginTable_margin1_set(long j, MarginTable marginTable, float f);

    public static final native float MarginTable_margin2_get(long j, MarginTable marginTable);

    public static final native void MarginTable_margin2_set(long j, MarginTable marginTable, float f);

    public static final native int MarginTable_maxscale_get(long j, MarginTable marginTable);

    public static final native void MarginTable_maxscale_set(long j, MarginTable marginTable, int i);

    public static final native int MarginTable_minscale_get(long j, MarginTable marginTable);

    public static final native void MarginTable_minscale_set(long j, MarginTable marginTable, int i);

    public static final native void OverlayMapOnTap(long j, long j2, int i, int i2, long j3, MapOverlayMapTappedElement mapOverlayMapTappedElement);

    public static final native Object[] PolygonClipp(int i, double[] dArr, double[] dArr2, int i2, double[] dArr3, double[] dArr4, int i3, int i4);

    public static final native int ROUTE_NAME_V2_RS_EVENT_TAG_get();

    public static final native void RemoveMapOverlay_Wrap(long j, long j2, long j3);

    public static final native void RemoveSpecialBubble_Wrap(long j, long j2);

    public static final native boolean Screen2LatLng_Wrap(long j, float f, float f2, double[] dArr);

    public static final native void SetGuideLineDestination(long j, long j2, double d, double d2);

    public static final native void SetMapOverlayVisible_Wrap(long j, long j2, long j3, boolean z);

    public static final native void SetMaskLayerWidthHeightColor_Wrap(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static final native int SetRouteNaviRouteId_Wrap(int i, long j, long j2, boolean z);

    public static final native int SetRoutePercent_Wrap(int i, long j, String str, float f, long j2);

    public static final native int SetRoutePoints_Wrap(int i, long j, Object[] objArr, int[] iArr, int[] iArr2, String str);

    public static final native int SetRouteTexture_Wrap(int i, long j, String str);

    public static final native void SetScreenRect(long j, long j2, int i, int i2, int i3, int i4);

    public static final native void ShowGuideLine(long j, long j2, boolean z, double d, double d2);

    public static final native Object SwigApolloCallback_OnGetApolloInt(long j, SwigApolloCallback swigApolloCallback, String str, String str2);

    public static final native Object SwigApolloCallback_OnGetApolloIntSwigExplicitSwigApolloCallback(long j, SwigApolloCallback swigApolloCallback, String str, String str2);

    public static final native Object SwigApolloCallback_OnGetApolloString(long j, SwigApolloCallback swigApolloCallback, String str, String str2);

    public static final native Object SwigApolloCallback_OnGetApolloStringLength(long j, SwigApolloCallback swigApolloCallback, String str, String str2);

    /* renamed from: SwigApolloCallback_OnGetApolloStringLengthSwigExplicitSwigApolloCallback */
    public static final native Object m17232xe7a8ee20(long j, SwigApolloCallback swigApolloCallback, String str, String str2);

    /* renamed from: SwigApolloCallback_OnGetApolloStringSwigExplicitSwigApolloCallback */
    public static final native Object m17233x4103701a(long j, SwigApolloCallback swigApolloCallback, String str, String str2);

    public static final native void SwigApolloCallback_change_ownership(SwigApolloCallback swigApolloCallback, long j, boolean z);

    public static final native void SwigApolloCallback_director_connect(SwigApolloCallback swigApolloCallback, long j, boolean z, boolean z2);

    public static final native void SwigBlockEventCallback_OnBlockEvent(long j, SwigBlockEventCallback swigBlockEventCallback, int i, long j2, double d, double d2);

    /* renamed from: SwigBlockEventCallback_OnBlockEventSwigExplicitSwigBlockEventCallback */
    public static final native void m17234x674ddc81(long j, SwigBlockEventCallback swigBlockEventCallback, int i, long j2, double d, double d2);

    public static final native void SwigBlockEventCallback_change_ownership(SwigBlockEventCallback swigBlockEventCallback, long j, boolean z);

    public static final native void SwigBlockEventCallback_director_connect(SwigBlockEventCallback swigBlockEventCallback, long j, boolean z, boolean z2);

    public static final native void SwigMJOCallback_OnMJOEvent(long j, SwigMJOCallback swigMJOCallback, int i, int i2);

    public static final native void SwigMJOCallback_OnMJOEventSwigExplicitSwigMJOCallback(long j, SwigMJOCallback swigMJOCallback, int i, int i2);

    public static final native void SwigMJOCallback_change_ownership(SwigMJOCallback swigMJOCallback, long j, boolean z);

    public static final native void SwigMJOCallback_director_connect(SwigMJOCallback swigMJOCallback, long j, boolean z, boolean z2);

    public static final native void SwigMapCallback_OnDownload(long j, SwigMapCallback swigMapCallback, String str);

    public static final native void SwigMapCallback_OnDownloadSwigExplicitSwigMapCallback(long j, SwigMapCallback swigMapCallback, String str);

    public static final native Object SwigMapCallback_OnGetImage(long j, SwigMapCallback swigMapCallback, int i, String str);

    public static final native Object SwigMapCallback_OnGetImageSwigExplicitSwigMapCallback(long j, SwigMapCallback swigMapCallback, int i, String str);

    public static final native Object SwigMapCallback_OnGetText(long j, SwigMapCallback swigMapCallback, String str, float f, int i, int i2, int i3, int i4, boolean z);

    public static final native Object SwigMapCallback_OnGetTextSize(long j, SwigMapCallback swigMapCallback, String str, int i, boolean z);

    public static final native Object SwigMapCallback_OnGetTextSizeSwigExplicitSwigMapCallback(long j, SwigMapCallback swigMapCallback, String str, int i, boolean z);

    public static final native Object SwigMapCallback_OnGetTextSwigExplicitSwigMapCallback(long j, SwigMapCallback swigMapCallback, String str, float f, int i, int i2, int i3, int i4, boolean z);

    public static final native void SwigMapCallback_OnLabelOnRouteList(long j, SwigMapCallback swigMapCallback, Object obj);

    public static final native void SwigMapCallback_OnLabelOnRouteListSwigExplicitSwigMapCallback(long j, SwigMapCallback swigMapCallback, Object obj);

    public static final native Object SwigMapCallback_OnLoadHeatTile(long j, SwigMapCallback swigMapCallback, int i, int i2, int i3);

    public static final native Object SwigMapCallback_OnLoadHeatTileSwigExplicitSwigMapCallback(long j, SwigMapCallback swigMapCallback, int i, int i2, int i3);

    public static final native void SwigMapCallback_OnMapDynamicLayerDownload(long j, SwigMapCallback swigMapCallback, boolean z, String str, byte[] bArr, int i);

    /* renamed from: SwigMapCallback_OnMapDynamicLayerDownloadSwigExplicitSwigMapCallback */
    public static final native void m17235x371f0ab2(long j, SwigMapCallback swigMapCallback, boolean z, String str, byte[] bArr, int i);

    public static final native void SwigMapCallback_OnWriteFile(long j, SwigMapCallback swigMapCallback, String str, byte[] bArr);

    public static final native void SwigMapCallback_OnWriteFileSwigExplicitSwigMapCallback(long j, SwigMapCallback swigMapCallback, String str, byte[] bArr);

    public static final native void SwigMapCallback_change_ownership(SwigMapCallback swigMapCallback, long j, boolean z);

    public static final native void SwigMapCallback_director_connect(SwigMapCallback swigMapCallback, long j, boolean z, boolean z2);

    public static final native int TRAFFIC_EVENT_ROAD_CLOSURE_CODE_get();

    public static final native int TRAFFIC_EVENT_SUBINDEX_MAX_get();

    public static final native int TXMapRectContainsMapRect(long j, long j2);

    public static final native int TXMapRectIntersectsMapRect(long j, long j2);

    public static final native boolean UpdateMJOLocatorInfo_Wrap(long j, double d, double d2, int i, int i2, long j2, long j3);

    public static final native void UpdateMapOverlayPointArea_Wrap(long j, long j2, long j3, double[] dArr, double[] dArr2, int i, int[] iArr, int[] iArr2, int i2);

    public static final native void UpdateMapOverlayPosition_Wrap(long j, long j2, long j3, double d, double d2);

    public static final native void UpdateMapOverlay_Wrap(long j, long j2, long j3, MapOverlay mapOverlay);

    public static final native void UpdateSpecialBubble_Wrap(long j, Object[] objArr, long j2);

    public static final native int VIOLATION_PARKING_LAYER_CODE1_get();

    public static final native int VIOLATION_PARKING_LAYER_CODE2_get();

    public static final native boolean ZoomToSpan4Offset_Wrap(long j, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, float f5, float f6, int i5, int i6, double[] dArr);

    public static final native void addRemoteIconBindOverlay(long j, long j2, long j3, MapOverlay mapOverlay, long j4);

    public static final native void changeRemoteIconBindOverlay(long j, long j2, long j3, long j4);

    public static final native long createHWBussManager();

    public static final native long createJNIContext();

    public static final native void delete_AboardPointInfo(long j);

    public static final native void delete_BlockInfo(long j);

    public static final native void delete_BlockInfoArray(long j);

    public static final native void delete_BlockPoint(long j);

    public static final native void delete_DDLocationCoordinate2D(long j);

    public static final native void delete_DDMapGPSPoint(long j);

    public static final native void delete_DDMapPoint(long j);

    public static final native void delete_DDMapPointArray(long j);

    public static final native void delete_DDUINT8_Array(long j);

    public static final native void delete_DGLMapTappedElement(long j);

    public static final native void delete_DGLMapVioParkBizContent(long j);

    public static final native void delete_DMapApolloData(long j);

    public static final native void delete_DMapCreateDataDelegate(long j);

    public static final native void delete_DMapLine(long j);

    public static final native void delete_DMapVector2d(long j);

    public static final native void delete_DMapVector2f(long j);

    public static final native void delete_DMapVector4f(long j);

    public static final native void delete_DOverlayLineInfo(long j);

    public static final native void delete_DOverlayLineInfoArray(long j);

    public static final native void delete_HWBSManager(long j);

    public static final native void delete_HWBSRAManager(long j);

    public static final native void delete_MapOverlay(long j);

    public static final native void delete_MapOverlayMapTappedElement(long j);

    public static final native void delete_MapOverlayRect(long j);

    public static final native void delete_MapOverlayRectArray(long j);

    public static final native void delete_MapPointArea(long j);

    public static final native void delete_MapPointSection(long j);

    public static final native void delete_MapPointSectionArray(long j);

    public static final native void delete_MapTrafficIconAttrs(long j);

    public static final native void delete_MapVisibleChangeAnimateAttrs(long j);

    public static final native void delete_MarginTable(long j);

    public static final native void delete_SwigApolloCallback(long j);

    public static final native void delete_SwigBlockEventCallback(long j);

    public static final native void delete_SwigMJOCallback(long j);

    public static final native void delete_SwigMapCallback(long j);

    public static final native void destroyJNIContext(long j);

    public static final native int kDMaxRouteLabelLength_get();

    public static final native long new_AboardPointInfo();

    public static final native long new_BlockInfo();

    public static final native long new_BlockInfoArray(int i);

    public static final native long new_BlockPoint();

    public static final native long new_DDLocationCoordinate2D();

    public static final native long new_DDMapGPSPoint();

    public static final native long new_DDMapPoint();

    public static final native long new_DDMapPointArray(int i);

    public static final native long new_DDUINT8_Array(int i);

    public static final native long new_DGLMapTappedElement();

    public static final native long new_DGLMapVioParkBizContent();

    public static final native long new_DMapApolloData();

    public static final native long new_DMapCreateDataDelegate();

    public static final native long new_DMapLine();

    public static final native long new_DMapVector2d();

    public static final native long new_DMapVector2f();

    public static final native long new_DMapVector4f();

    public static final native long new_DOverlayLineInfo();

    public static final native long new_DOverlayLineInfoArray(int i);

    public static final native long new_HWBSManager();

    public static final native long new_HWBSRAManager();

    public static final native long new_MapOverlay();

    public static final native long new_MapOverlayMapTappedElement();

    public static final native long new_MapOverlayRect();

    public static final native long new_MapOverlayRectArray(int i);

    public static final native long new_MapPointArea();

    public static final native long new_MapPointSection();

    public static final native long new_MapPointSectionArray(int i);

    public static final native long new_MapTrafficIconAttrs();

    public static final native long new_MapVisibleChangeAnimateAttrs();

    public static final native long new_MarginTable();

    public static final native long new_SwigApolloCallback();

    public static final native long new_SwigBlockEventCallback();

    public static final native long new_SwigMJOCallback();

    public static final native long new_SwigMapCallback();

    public static final native void removeRemoteIcon(long j, long j2, long j3);

    public static final native void set3dPaddingTopOffset(long j, long j2, float f);

    public static final native void setHWBussApolloSwitch(long j, long j2, boolean z, boolean z2, boolean z3, boolean z4);

    public static final native void setHWBussBarn(long j, long j2, long j3, DMapVector2d dMapVector2d, double d, double d2, long j4, DMapVector2d dMapVector2d2, double d3, double d4, long j5, DMapVector2d dMapVector2d3, long j6, DMapVector2d dMapVector2d4, long j7, DMapVector2d dMapVector2d5);

    public static final native void setHWBussThresholdOpen(long j, long j2, boolean z, float f);

    private static final native void swig_module_init();

    MapEngineJNIBridge() {
    }

    static {
        try {
            System.loadLibrary(StringConstant.LIB_MAPV2);
        } catch (Throwable th) {
            th.printStackTrace();
            MapLibaryLoader.loadLibary(StringConstant.LIB_MAPV2);
        }
        swig_module_init();
    }

    public static Object SwigDirector_SwigMapCallback_OnGetText(SwigMapCallback swigMapCallback, String str, float f, int i, int i2, int i3, int i4, boolean z) {
        return swigMapCallback.OnGetText(str, f, i, i2, i3, i4, z);
    }

    public static Object SwigDirector_SwigMapCallback_OnGetTextSize(SwigMapCallback swigMapCallback, String str, int i, boolean z) {
        return swigMapCallback.OnGetTextSize(str, i, z);
    }

    public static void SwigDirector_SwigMapCallback_OnDownload(SwigMapCallback swigMapCallback, String str) {
        swigMapCallback.OnDownload(str);
    }

    public static Object SwigDirector_SwigMapCallback_OnGetImage(SwigMapCallback swigMapCallback, int i, String str) {
        return swigMapCallback.OnGetImage(i, str);
    }

    public static void SwigDirector_SwigMapCallback_OnWriteFile(SwigMapCallback swigMapCallback, String str, byte[] bArr) {
        swigMapCallback.OnWriteFile(str, bArr);
    }

    public static Object SwigDirector_SwigMapCallback_OnLoadHeatTile(SwigMapCallback swigMapCallback, int i, int i2, int i3) {
        return swigMapCallback.OnLoadHeatTile(i, i2, i3);
    }

    public static void SwigDirector_SwigMapCallback_OnLabelOnRouteList(SwigMapCallback swigMapCallback, Object obj) {
        swigMapCallback.OnLabelOnRouteList(obj);
    }

    public static void SwigDirector_SwigMapCallback_OnMapDynamicLayerDownload(SwigMapCallback swigMapCallback, boolean z, String str, byte[] bArr, int i) {
        swigMapCallback.OnMapDynamicLayerDownload(z, str, bArr, i);
    }

    public static Object SwigDirector_SwigApolloCallback_OnGetApolloInt(SwigApolloCallback swigApolloCallback, String str, String str2) {
        return swigApolloCallback.OnGetApolloInt(str, str2);
    }

    public static Object SwigDirector_SwigApolloCallback_OnGetApolloString(SwigApolloCallback swigApolloCallback, String str, String str2) {
        return swigApolloCallback.OnGetApolloString(str, str2);
    }

    public static Object SwigDirector_SwigApolloCallback_OnGetApolloStringLength(SwigApolloCallback swigApolloCallback, String str, String str2) {
        return swigApolloCallback.OnGetApolloStringLength(str, str2);
    }

    public static void SwigDirector_SwigMJOCallback_OnMJOEvent(SwigMJOCallback swigMJOCallback, int i, int i2) {
        swigMJOCallback.OnMJOEvent(i, i2);
    }

    public static void SwigDirector_SwigBlockEventCallback_OnBlockEvent(SwigBlockEventCallback swigBlockEventCallback, int i, long j, double d, double d2) {
        swigBlockEventCallback.OnBlockEvent(i, j, d, d2);
    }
}
