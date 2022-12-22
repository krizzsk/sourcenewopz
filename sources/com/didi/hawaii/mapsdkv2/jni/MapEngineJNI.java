package com.didi.hawaii.mapsdkv2.jni;

import java.math.BigInteger;

public final class MapEngineJNI implements MapEngineJNIConstants {
    public static void DMapResetPath(long j, DMapLanguage dMapLanguage, String str, String str2, String str3) {
        MapEngineJNIBridge.DMapResetPath(j, dMapLanguage.swigValue(), str, str2, str3);
    }

    public static void DMapSetTheme(long j, DMapTheme dMapTheme) {
        MapEngineJNIBridge.DMapSetTheme(j, dMapTheme.swigValue());
    }

    public static boolean DMapIsUseStyleV2() {
        return MapEngineJNIBridge.DMapIsUseStyleV2();
    }

    public static void DMapSetLowMemoryMode(long j, boolean z) {
        MapEngineJNIBridge.DMapSetLowMemoryMode(j, z);
    }

    public static void DMapSetViewport(long j, int i, int i2, int i3, int i4) {
        MapEngineJNIBridge.DMapSetViewport(j, i, i2, i3, i4);
    }

    public static void DMapSetScreenSizeAndDPI(long j, int i, int i2, float f, float f2) {
        MapEngineJNIBridge.DMapSetScreenSizeAndDPI(j, i, i2, f, f2);
    }

    public static boolean DMapGetLevelPointPerMeter(long j, double[] dArr) {
        return MapEngineJNIBridge.DMapGetLevelPointPerMeter(j, dArr);
    }

    public static void DGLMapSetResPackPath(long j, String str, String str2) {
        MapEngineJNIBridge.DGLMapSetResPackPath(j, str, str2);
    }

    public static boolean DGLMapGenerateTextures(long j) {
        return MapEngineJNIBridge.DGLMapGenerateTextures(j);
    }

    public static void DGLMapSetEnableDynamicLayer(long j, int i) {
        MapEngineJNIBridge.DGLMapSetEnableDynamicLayer(j, i);
    }

    public static int DGLMapGetEnableDynamicLayerType(long j) {
        return MapEngineJNIBridge.DGLMapGetEnableDynamicLayerType(j);
    }

    public static void DGLMapSetDynamicLayerDataWithResult(long j, String str, SWIGTYPE_p_void sWIGTYPE_p_void, int i, SWIGTYPE_p_uint64_t sWIGTYPE_p_uint64_t) {
        MapEngineJNIBridge.DGLMapSetDynamicLayerDataWithResult(j, str, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void), i, SWIGTYPE_p_uint64_t.getCPtr(sWIGTYPE_p_uint64_t));
    }

    public static void DGLMapCancelDynamicDownloadData(long j, String str) {
        MapEngineJNIBridge.DGLMapCancelDynamicDownloadData(j, str);
    }

    public static void DGLMapClearDynamicMapCache(long j) {
        MapEngineJNIBridge.DGLMapClearDynamicMapCache(j);
    }

    public static void DGLMapSetDynamicMapAutoRefresh(long j, boolean z) {
        MapEngineJNIBridge.DGLMapSetDynamicMapAutoRefresh(j, z);
    }

    public static void DGLMapReleaseTappedElementBuffer(DGLMapTappedElement dGLMapTappedElement) {
        MapEngineJNIBridge.DGLMapReleaseTappedElementBuffer(DGLMapTappedElement.getCPtr(dGLMapTappedElement), dGLMapTappedElement);
    }

    public static void DGLMapSetTappedTextAnnotationHidden(long j, DMapTappedETTextAnnoItemType dMapTappedETTextAnnoItemType, DDMapPoint dDMapPoint, boolean z) {
        MapEngineJNIBridge.DGLMapSetTappedTextAnnotationHidden(j, dMapTappedETTextAnnoItemType.swigValue(), DDMapPoint.getCPtr(dDMapPoint), dDMapPoint, z);
    }

    public static void DGLMapSetTappedTextAnnotationHiddenWithID(long j, BigInteger bigInteger, boolean z) {
        MapEngineJNIBridge.DGLMapSetTappedTextAnnotationHiddenWithID(j, bigInteger, z);
    }

    public static void DGLMapClearAllTappedTextAnnoationHidden(long j) {
        MapEngineJNIBridge.DGLMapClearAllTappedTextAnnoationHidden(j);
    }

    public static void DGLMapGetCityName(long j, int i, int i2, String str, int i3) {
        MapEngineJNIBridge.DGLMapGetCityName(j, i, i2, str, i3);
    }

    public static void DGLMapClearTrafficData(long j) {
        MapEngineJNIBridge.DGLMapClearTrafficData(j);
    }

    public static void DGLMapSetTrafficEnabled(long j, boolean z) {
        MapEngineJNIBridge.DGLMapSetTrafficEnabled(j, z);
    }

    public static void DMapCompassSetHidden(long j, boolean z) {
        MapEngineJNIBridge.DMapCompassSetHidden(j, z);
    }

    public static boolean DMapCompassIsHidden(long j) {
        return MapEngineJNIBridge.DMapCompassIsHidden(j);
    }

    public static void DGLMapSetNeedsDisplay(long j, boolean z) {
        MapEngineJNIBridge.DGLMapSetNeedsDisplay(j, z);
    }

    public static void DMapHibernate(long j) {
        MapEngineJNIBridge.DMapHibernate(j);
    }

    public static void DGLMapClearCache(long j) {
        MapEngineJNIBridge.DGLMapClearCache(j);
    }

    public static DDMapPoint DGLMapScreenXY2MapPoint(long j, float f, float f2) {
        return new DDMapPoint(MapEngineJNIBridge.DGLMapScreenXY2MapPoint(j, f, f2), true);
    }

    public static double DGLMapGetScale(long j) {
        return MapEngineJNIBridge.DGLMapGetScale(j);
    }

    public static void DGLMapSetScaleLevel(long j, int i, boolean z) {
        MapEngineJNIBridge.DGLMapSetScaleLevel(j, i, z);
    }

    public static void DGLMapSetScaleLevelWithCallback(long j, int i, boolean z, SWIGTYPE_p_f_bool_p_void__void sWIGTYPE_p_f_bool_p_void__void, SWIGTYPE_p_void sWIGTYPE_p_void) {
        MapEngineJNIBridge.DGLMapSetScaleLevelWithCallback(j, i, z, SWIGTYPE_p_f_bool_p_void__void.getCPtr(sWIGTYPE_p_f_bool_p_void__void), SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public static float DGLMapGetSkew(long j) {
        return MapEngineJNIBridge.DGLMapGetSkew(j);
    }

    public static float DGLMapGetRotate(long j) {
        return MapEngineJNIBridge.DGLMapGetRotate(j);
    }

    public static void DGLMapSetMapMode(long j, int i) {
        MapEngineJNIBridge.DGLMapSetMapMode(j, i);
    }

    public static int DGLMapGetMapMode(long j) {
        return MapEngineJNIBridge.DGLMapGetMapMode(j);
    }

    public static void DMapPrimitiveDelete(long j, int i) {
        MapEngineJNIBridge.DMapPrimitiveDelete(j, i);
    }

    public static void DMapPrimitiveSetHidden(long j, int i, boolean z) {
        MapEngineJNIBridge.DMapPrimitiveSetHidden(j, i, z);
    }

    public static DMapVector2f DMapGetScreenCenterOffset(long j) {
        return new DMapVector2f(MapEngineJNIBridge.DMapGetScreenCenterOffset(j), true);
    }

    public static void DMapMarkerLocatorSetHidden(long j, boolean z) {
        MapEngineJNIBridge.DMapMarkerLocatorSetHidden(j, z);
    }

    public static void DMapMarkerDelete(long j, int[] iArr, int i) {
        MapEngineJNIBridge.DMapMarkerDelete(j, iArr, i);
    }

    public static void DMapMarkerModifyImage(long j, int i, String str, DMapVector2f dMapVector2f) {
        MapEngineJNIBridge.DMapMarkerModifyImage(j, i, str, DMapVector2f.getCPtr(dMapVector2f), dMapVector2f);
    }

    public static void DMapMarkerModifyAngle(long j, int i, float f) {
        MapEngineJNIBridge.DMapMarkerModifyAngle(j, i, f);
    }

    public static void DMapMarkerModifyColor(long j, int i, DMapVector4f dMapVector4f) {
        MapEngineJNIBridge.DMapMarkerModifyColor(j, i, DMapVector4f.getCPtr(dMapVector4f), dMapVector4f);
    }

    public static void DMapMarkerSetForceLoad(long j, int i, boolean z) {
        MapEngineJNIBridge.DMapMarkerSetForceLoad(j, i, z);
    }

    public static DMapVector2d DMapMarkerGetCoordinate(long j, int i) {
        return new DMapVector2d(MapEngineJNIBridge.DMapMarkerGetCoordinate(j, i), true);
    }

    public static float DMapMarkerGetAngle(long j, int i) {
        return MapEngineJNIBridge.DMapMarkerGetAngle(j, i);
    }

    public static float DMapMarkerGetAlpha(long j, int i) {
        return MapEngineJNIBridge.DMapMarkerGetAlpha(j, i);
    }

    public static DMapVector2f DMapMarkerGetScale(long j, int i) {
        return new DMapVector2f(MapEngineJNIBridge.DMapMarkerGetScale(j, i), true);
    }

    public static void DGLMapSetBezierCurveAnimationState(long j, int i, float f) {
        MapEngineJNIBridge.DGLMapSetBezierCurveAnimationState(j, i, f);
    }

    public static int DMapMarkerGetPriority(long j, int i) {
        return MapEngineJNIBridge.DMapMarkerGetPriority(j, i);
    }

    public static void DMapMarkerSetPriority(long j, int i, int i2) {
        MapEngineJNIBridge.DMapMarkerSetPriority(j, i, i2);
    }

    public static void DMapMarkerSetRenderOrder(long j, int i, DMarkerRenderOrder dMarkerRenderOrder) {
        MapEngineJNIBridge.DMapMarkerSetRenderOrder(j, i, dMarkerRenderOrder.swigValue());
    }

    public static void DMapMarkerSetHidden(long j, int[] iArr, int i, boolean z) {
        MapEngineJNIBridge.DMapMarkerSetHidden(j, iArr, i, z);
    }

    public static boolean DMapMarkerIsHidden(long j, int i) {
        return MapEngineJNIBridge.DMapMarkerIsHidden(j, i);
    }

    public static void DMapLocatorSetCompassHidden(long j, boolean z) {
        MapEngineJNIBridge.DMapLocatorSetCompassHidden(j, z);
    }

    public static void DMapLocatorSetIndicatorHidden(long j, boolean z) {
        MapEngineJNIBridge.DMapLocatorSetIndicatorHidden(j, z);
    }

    public static void DMapLocatorModifyAccuracyAreaColor(long j, long j2) {
        MapEngineJNIBridge.DMapLocatorModifyAccuracyAreaColor(j, j2);
    }

    public static void DMapLocatorSetAccuracyAreaHidden(long j, boolean z) {
        MapEngineJNIBridge.DMapLocatorSetAccuracyAreaHidden(j, z);
    }

    public static void DGLMapSetLocationFollow(long j, boolean z, boolean z2, boolean z3, boolean z4) {
        MapEngineJNIBridge.DGLMapSetLocationFollow(j, z, z2, z3, z4);
    }

    public static void DGLMapSetLocationHeading(long j, float f) {
        MapEngineJNIBridge.DGLMapSetLocationHeading(j, f);
    }

    public static void DMapBuildingSetEffect3D(long j, boolean z) {
        MapEngineJNIBridge.DMapBuildingSetEffect3D(j, z);
    }

    public static void DMapAutoScaleWithPoint(long j, DDMapPoint dDMapPoint, boolean z, SWIGTYPE_p_f_bool_p_void__void sWIGTYPE_p_f_bool_p_void__void, SWIGTYPE_p_void sWIGTYPE_p_void, double d, double d2) {
        MapEngineJNIBridge.DMapAutoScaleWithPoint(j, DDMapPoint.getCPtr(dDMapPoint), dDMapPoint, z, SWIGTYPE_p_f_bool_p_void__void.getCPtr(sWIGTYPE_p_f_bool_p_void__void), SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void), d, d2);
    }

    public static void DGLMapSetEdgePaddingForRoute(long j, float f, float f2, float f3, float f4) {
        MapEngineJNIBridge.DGLMapSetEdgePaddingForRoute(j, f, f2, f3, f4);
    }

    public static void DGLMapSetEdgePaddingOffset(long j, float f, float f2, float f3, float f4) {
        MapEngineJNIBridge.DGLMapSetEdgePaddingOffset(j, f, f2, f3, f4);
    }

    public static void DGLMapSetMinScaleLevel(long j, int i) {
        MapEngineJNIBridge.DGLMapSetMinScaleLevel(j, i);
    }

    public static void DGLMapSetMaxScaleLevel(long j, int i) {
        MapEngineJNIBridge.DGLMapSetMaxScaleLevel(j, i);
    }

    public static void DMapRouteDelete(long j, int i) {
        MapEngineJNIBridge.DMapRouteDelete(j, i);
    }

    public static void DMapRouteSetTurnArrowIndex2(long j, int i, int i2, DMapRouteArrowType dMapRouteArrowType) {
        MapEngineJNIBridge.DMapRouteSetTurnArrowIndex2(j, i, i2, dMapRouteArrowType.swigValue());
    }

    public static void DMapRouteSetTurnArrowIndex3(long j, int i, int i2, int i3, DMapRouteArrowType dMapRouteArrowType) {
        MapEngineJNIBridge.DMapRouteSetTurnArrowIndex3(j, i, i2, i3, dMapRouteArrowType.swigValue());
    }

    public static void DMapRouteSetDrawArrow(long j, int i, boolean z) {
        MapEngineJNIBridge.DMapRouteSetDrawArrow(j, i, z);
    }

    public static void DMapRouteSetArrowTextureName(long j, int i, String str) {
        MapEngineJNIBridge.DMapRouteSetArrowTextureName(j, i, str);
    }

    public static void DMapRouteSetArrowFlip(long j, int i, boolean z) {
        MapEngineJNIBridge.DMapRouteSetArrowFlip(j, i, z);
    }

    public static void DMapRouteSetDrawCap(long j, int i, boolean z) {
        MapEngineJNIBridge.DMapRouteSetDrawCap(j, i, z);
    }

    public static void DMapRouteSetSelectedRoutes(long j, int[] iArr, int i) {
        MapEngineJNIBridge.DMapRouteSetSelectedRoutes(j, iArr, i);
    }

    public static void DMapRouteSetAlpha(long j, int i, float f) {
        MapEngineJNIBridge.DMapRouteSetAlpha(j, i, f);
    }

    public static void DMapRouteSetHidden(long j, int i, boolean z) {
        MapEngineJNIBridge.DMapRouteSetHidden(j, i, z);
    }

    public static void DMapAddViolationParkingSection(long j, int i, int i2, int i3, float f, int i4, float f2) {
        MapEngineJNIBridge.DMapAddViolationParkingSection(j, i, i2, i3, f, i4, f2);
    }

    public static void DMapRemoveViolationParkingSection(long j, int i, int i2) {
        MapEngineJNIBridge.DMapRemoveViolationParkingSection(j, i, i2);
    }

    public static DDMapPoint DMapQueryViolationParkingIconPos(long j, int i, int i2, int i3, DDMapPoint dDMapPoint) {
        return new DDMapPoint(MapEngineJNIBridge.DMapQueryViolationParkingIconPos(j, i, i2, i3, DDMapPoint.getCPtr(dDMapPoint), dDMapPoint), true);
    }

    public static void DMapFlashViolationParkingSection(long j, int i, int i2, boolean z) {
        MapEngineJNIBridge.DMapFlashViolationParkingSection(j, i, i2, z);
    }

    public static void DMapRouteSetAnimationColorLineScanTextureName(long j, int i, String str) {
        MapEngineJNIBridge.DMapRouteSetAnimationColorLineScanTextureName(j, i, str);
    }

    public static long DMapRouteGetAnimationColorLineScanMixColor(long j, int i) {
        return MapEngineJNIBridge.DMapRouteGetAnimationColorLineScanMixColor(j, i);
    }

    public static void DMapRouteSetAnimationColorLineScanProgress(long j, int i, double d) {
        MapEngineJNIBridge.DMapRouteSetAnimationColorLineScanProgress(j, i, d);
    }

    public static double DMapRouteGetAnimationColorLineScanProgress(long j, int i) {
        return MapEngineJNIBridge.DMapRouteGetAnimationColorLineScanProgress(j, i);
    }

    public static void DMapRouteSetAnimationColorLineCutHeadProgress(long j, int i, double d) {
        MapEngineJNIBridge.DMapRouteSetAnimationColorLineCutHeadProgress(j, i, d);
    }

    public static double DMapRouteGetAnimationColorLineCutHeadProgress(long j, int i) {
        return MapEngineJNIBridge.DMapRouteGetAnimationColorLineCutHeadProgress(j, i);
    }

    public static void DMapRouteSetAnimationColorLineCutTailProgress(long j, int i, double d) {
        MapEngineJNIBridge.DMapRouteSetAnimationColorLineCutTailProgress(j, i, d);
    }

    public static double DMapRouteGetAnimationColorLineCutTailProgress(long j, int i) {
        return MapEngineJNIBridge.DMapRouteGetAnimationColorLineCutTailProgress(j, i);
    }

    public static void DMapRouteSetAnimationColorLineDisableSimplify(long j, int i, boolean z) {
        MapEngineJNIBridge.DMapRouteSetAnimationColorLineDisableSimplify(j, i, z);
    }

    public static boolean DMapRouteGetAnimationColorLineDisableSimplify(long j, int i) {
        return MapEngineJNIBridge.DMapRouteGetAnimationColorLineDisableSimplify(j, i);
    }

    public static DMapVector2f DMapVector2fMake(float f, float f2) {
        return new DMapVector2f(MapEngineJNIBridge.DMapVector2fMake(f, f2), true);
    }

    public static void DGLMapRemoveTileOverlay(long j, int i) {
        MapEngineJNIBridge.DGLMapRemoveTileOverlay(j, i);
    }

    public static void DGLMapReloadTileOverlay(long j, int i) {
        MapEngineJNIBridge.DGLMapReloadTileOverlay(j, i);
    }

    public static void DGLMapClearRouteNameSegments(long j) {
        MapEngineJNIBridge.DGLMapClearRouteNameSegments(j);
    }

    public static boolean DGLMapDeleteRouteNameSegments(long j, long j2) {
        return MapEngineJNIBridge.DGLMapDeleteRouteNameSegments(j, j2);
    }

    public static void DGLMapSetRouteNameVisiable(long j, boolean z) {
        MapEngineJNIBridge.DGLMapSetRouteNameVisiable(j, z);
    }

    public static void DGLMapSetDisplayFishBoneGrayBubbleOnly(long j, boolean z) {
        MapEngineJNIBridge.DGLMapSetDisplayFishBoneGrayBubbleOnly(j, z);
    }

    public static boolean DGLMapSetRouteNameClearPoint(long j, long j2, int i) {
        return MapEngineJNIBridge.DGLMapSetRouteNameClearPoint(j, j2, i);
    }

    public static void DGLMapSetABTestMode4Json(long j, String str, int i) {
        MapEngineJNIBridge.DGLMapSetABTestMode4Json(j, str, i);
    }

    public static void DGLRemoveAllLocalTrafficIcon(long j) {
        MapEngineJNIBridge.DGLRemoveAllLocalTrafficIcon(j);
    }

    public static void DGLUpdateItemShowState(long j, BigInteger bigInteger, short s, boolean z) {
        MapEngineJNIBridge.DGLUpdateItemShowState(j, bigInteger, s, z);
    }

    public static boolean DGLShowTrafficEvent(long j, boolean z) {
        return MapEngineJNIBridge.DGLShowTrafficEvent(j, z);
    }

    public static void DGLMapSetTrafficEventIconHiddenWithType(long j, DMapTrafficEventType dMapTrafficEventType, boolean z) {
        MapEngineJNIBridge.DGLMapSetTrafficEventIconHiddenWithType(j, dMapTrafficEventType.swigValue(), z);
    }

    public static void DGLSetTrafficEventIconCustomSize(long j, DMapTrafficEventType dMapTrafficEventType, long j2, long j3) {
        MapEngineJNIBridge.DGLSetTrafficEventIconCustomSize(j, dMapTrafficEventType.swigValue(), j2, j3);
    }

    public static void DGLResetTrafficEventIconCustomSize(long j) {
        MapEngineJNIBridge.DGLResetTrafficEventIconCustomSize(j);
    }

    public static void DGLMapSetAttachDir(long j, String str) {
        MapEngineJNIBridge.DGLMapSetAttachDir(j, str);
    }

    public static void DGLMapRenderExtendIconShow(long j, BigInteger bigInteger, boolean z) {
        MapEngineJNIBridge.DGLMapRenderExtendIconShow(j, bigInteger, z);
    }

    public static void DGLSetAboardPointJson(long j, String str, int i) {
        MapEngineJNIBridge.DGLSetAboardPointJson(j, str, i);
    }

    public static void DGLMapDDApolloSetUseVulkan(boolean z) {
        MapEngineJNIBridge.DGLMapDDApolloSetUseVulkan(z);
    }

    public static void DGLMapDDSetUseMJO(boolean z) {
        MapEngineJNIBridge.DGLMapDDSetUseMJO(z);
    }

    public static void DGLMapStyleLock() {
        MapEngineJNIBridge.DGLMapStyleLock();
    }

    public static void DGLMapStyleUnlock() {
        MapEngineJNIBridge.DGLMapStyleUnlock();
    }

    public static String DGLMapGetRouteUrl(long j) {
        return MapEngineJNIBridge.DGLMapGetRouteUrl(j);
    }

    public static String DGLMapGetStyleUrl(long j) {
        return MapEngineJNIBridge.DGLMapGetStyleUrl(j);
    }

    public static DMapVector2d DMapGetWorldCoordinate(long j, DMapVector2f dMapVector2f) {
        return new DMapVector2d(MapEngineJNIBridge.DMapGetWorldCoordinate(j, DMapVector2f.getCPtr(dMapVector2f), dMapVector2f), true);
    }

    public static void DGLMapVecEnlargeSetVisibleArea(long j, int i, int i2, int i3, int i4, float f) {
        MapEngineJNIBridge.DGLMapVecEnlargeSetVisibleArea(j, i, i2, i3, i4, f);
    }

    public static boolean DGLMapVecEnlargeDestroy(long j, String str) {
        return MapEngineJNIBridge.DGLMapVecEnlargeDestroy(j, str);
    }

    public static void DGLMapVecEnlargeDestroyAll(long j) {
        MapEngineJNIBridge.DGLMapVecEnlargeDestroyAll(j);
    }

    public static boolean DGLMapSetEnableOffScreenRender(long j, boolean z) {
        return MapEngineJNIBridge.DGLMapSetEnableOffScreenRender(j, z);
    }

    public static boolean DDMapRectIsGood(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect) {
        return MapEngineJNIBridge.DDMapRectIsGood(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect));
    }

    public static boolean IsPointInDDMapRect(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, int i, int i2) {
        return MapEngineJNIBridge.IsPointInDDMapRect(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), i, i2);
    }

    public static boolean IsPointInDDMapRectEx(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, DDMapPoint dDMapPoint) {
        return MapEngineJNIBridge.IsPointInDDMapRectEx(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), DDMapPoint.getCPtr(dDMapPoint), dDMapPoint);
    }

    public static boolean DDMapRectIsZero(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect) {
        return MapEngineJNIBridge.DDMapRectIsZero(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect));
    }

    public static boolean DDMapRectIsEqual(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect2) {
        return MapEngineJNIBridge.DDMapRectIsEqual(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect2));
    }

    public static int DDMapRectContainsMapRect(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect2) {
        return MapEngineJNIBridge.DDMapRectContainsMapRect(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect2));
    }

    public static DDMapPoint DDMapPointForCoordinate(DDLocationCoordinate2D dDLocationCoordinate2D) {
        return new DDMapPoint(MapEngineJNIBridge.DDMapPointForCoordinate(DDLocationCoordinate2D.getCPtr(dDLocationCoordinate2D), dDLocationCoordinate2D), true);
    }

    public static DDLocationCoordinate2D DDLocationCoordinate2DMake(double d, double d2) {
        return new DDLocationCoordinate2D(MapEngineJNIBridge.DDLocationCoordinate2DMake(d, d2), true);
    }

    public static DDLocationCoordinate2D DDCoordinateForMapPoint(DDMapPoint dDMapPoint) {
        return new DDLocationCoordinate2D(MapEngineJNIBridge.DDCoordinateForMapPoint(DDMapPoint.getCPtr(dDMapPoint), dDMapPoint), true);
    }

    public static int TXMapRectContainsMapRect(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect2) {
        return MapEngineJNIBridge.TXMapRectContainsMapRect(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect2));
    }

    public static int TXMapRectIntersectsMapRect(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect2) {
        return MapEngineJNIBridge.TXMapRectIntersectsMapRect(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect2));
    }

    public static boolean IsPointInTXMapRect(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, int i, int i2) {
        return MapEngineJNIBridge.IsPointInTXMapRect(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), i, i2);
    }

    public static SWIGTYPE_p__DDMapRect DDMapRectUnion(SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect, SWIGTYPE_p__DDMapRect sWIGTYPE_p__DDMapRect2) {
        return new SWIGTYPE_p__DDMapRect(MapEngineJNIBridge.DDMapRectUnion(SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect), SWIGTYPE_p__DDMapRect.getCPtr(sWIGTYPE_p__DDMapRect2)), true);
    }

    public static int DDCheckCodeIsSubwayStation(int i) {
        return MapEngineJNIBridge.DDCheckCodeIsSubwayStation(i);
    }

    public static int AnnoTextRowNum(SWIGTYPE_p__DAnnotationObject sWIGTYPE_p__DAnnotationObject) {
        return MapEngineJNIBridge.AnnoTextRowNum(SWIGTYPE_p__DAnnotationObject.getCPtr(sWIGTYPE_p__DAnnotationObject));
    }

    public static int AnnoTextCountAtRow(SWIGTYPE_p__DAnnotationObject sWIGTYPE_p__DAnnotationObject, int i) {
        return MapEngineJNIBridge.AnnoTextCountAtRow(SWIGTYPE_p__DAnnotationObject.getCPtr(sWIGTYPE_p__DAnnotationObject), i);
    }

    public static SWIGTYPE_p_unsigned_short AnnoTextAtRow(SWIGTYPE_p__DAnnotationObject sWIGTYPE_p__DAnnotationObject, int i) {
        long AnnoTextAtRow = MapEngineJNIBridge.AnnoTextAtRow(SWIGTYPE_p__DAnnotationObject.getCPtr(sWIGTYPE_p__DAnnotationObject), i);
        if (AnnoTextAtRow == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_short(AnnoTextAtRow, false);
    }

    public static void DGLMapDestroy_Wrap(long j, long j2) {
        MapEngineJNIBridge.DGLMapDestroy_Wrap(j, j2);
    }

    public static boolean DGLMapCheckNeedGuard(String str, int i, int i2, int i3) {
        return MapEngineJNIBridge.DGLMapCheckNeedGuard(str, i, i2, i3);
    }

    public static void DGLMapSetCallbacks_Wrap(long j, long j2, SwigMapCallback swigMapCallback, boolean z) {
        MapEngineJNIBridge.DGLMapSetCallbacks_Wrap(j, j2, SwigMapCallback.getCPtr(swigMapCallback), swigMapCallback, z);
    }

    public static void DGLMapSetMJOCallback_Wrap(long j, long j2, SwigMJOCallback swigMJOCallback) {
        MapEngineJNIBridge.DGLMapSetMJOCallback_Wrap(j, j2, SwigMJOCallback.getCPtr(swigMJOCallback), swigMJOCallback);
    }

    public static void DGLMapSetBlockEventCallback_Wrap(long j, long j2, SwigBlockEventCallback swigBlockEventCallback) {
        MapEngineJNIBridge.DGLMapSetBlockEventCallback_Wrap(j, j2, SwigBlockEventCallback.getCPtr(swigBlockEventCallback), swigBlockEventCallback);
    }

    public static void DGLMapProcessBlockInfo(int i, long j, long j2, DDMapPoint dDMapPoint, int i2, BlockInfo blockInfo, int i3) {
        MapEngineJNIBridge.DGLMapProcessBlockInfo(i, j, j2, DDMapPoint.getCPtr(dDMapPoint), dDMapPoint, i2, BlockInfo.getCPtr(blockInfo), blockInfo, i3);
    }

    public static int DGLMapAddTileOverlay_Wrap(long j, long j2) {
        return MapEngineJNIBridge.DGLMapAddTileOverlay_Wrap(j, j2);
    }

    public static void DGLMapSetCenterMapPoint_Wrap(long j, double d, double d2) {
        MapEngineJNIBridge.DGLMapSetCenterMapPoint_Wrap(j, d, d2);
    }

    public static int DGLMapSetTrafficData_Wrap(long j, byte[] bArr, int i, byte[] bArr2, int i2) {
        return MapEngineJNIBridge.DGLMapSetTrafficData_Wrap(j, bArr, i, bArr2, i2);
    }

    public static int DGLMapWriteDownloadData_Wrap(long j, String str, byte[] bArr, int i) {
        return MapEngineJNIBridge.DGLMapWriteDownloadData_Wrap(j, str, bArr, i);
    }

    public static int DGLMapCancelDownloadData_Wrap(long j, String str) {
        return MapEngineJNIBridge.DGLMapCancelDownloadData_Wrap(j, str);
    }

    public static void DGLGlobalSetApolloCallbacks_Wrap(SwigApolloCallback swigApolloCallback, long j) {
        MapEngineJNIBridge.DGLGlobalSetApolloCallbacks_Wrap(SwigApolloCallback.getCPtr(swigApolloCallback), swigApolloCallback, j);
    }

    public static void DGLMapSetTrafficEventData_Wrap(long j, byte[] bArr, int i) {
        MapEngineJNIBridge.DGLMapSetTrafficEventData_Wrap(j, bArr, i);
    }

    public static void DGLMapSetDynamicLayerData_Wrap(long j, String str, byte[] bArr, int i) {
        MapEngineJNIBridge.DGLMapSetDynamicLayerData_Wrap(j, str, bArr, i);
    }

    public static void DGLMapClearTrafficEventData_Wrap(long j) {
        MapEngineJNIBridge.DGLMapClearTrafficEventData_Wrap(j);
    }

    public static boolean DGLMapSetExtendEventData_Wrap(long j, byte[] bArr, int i) {
        return MapEngineJNIBridge.DGLMapSetExtendEventData_Wrap(j, bArr, i);
    }

    public static boolean DGLMapClearExtendEventData_Wrap(long j) {
        return MapEngineJNIBridge.DGLMapClearExtendEventData_Wrap(j);
    }

    public static void DGLMapSetRestrictAreaVisible_Wrap(long j, boolean z) {
        MapEngineJNIBridge.DGLMapSetRestrictAreaVisible_Wrap(j, z);
    }

    public static void DGLMapSetExtendIconVisible_Wrap(long j, boolean z) {
        MapEngineJNIBridge.DGLMapSetExtendIconVisible_Wrap(j, z);
    }

    public static int DGLMapGetRenderExtendIcon_Wrap(long j) {
        return MapEngineJNIBridge.DGLMapGetRenderExtendIcon_Wrap(j);
    }

    public static int DGLMapSetInternationalWms_Wrap(long j, boolean z) {
        return MapEngineJNIBridge.DGLMapSetInternationalWms_Wrap(j, z);
    }

    public static int DGLMapSetAnnotationLightVisible_Wrap(long j, boolean z) {
        return MapEngineJNIBridge.DGLMapSetAnnotationLightVisible_Wrap(j, z);
    }

    public static void DGLSetMarkerRect_Wrap(long j, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        MapEngineJNIBridge.DGLSetMarkerRect_Wrap(j, iArr, iArr2, iArr3, iArr4, i);
    }

    public static void DGLMapLoadMJO_Wrap(long j) {
        MapEngineJNIBridge.DGLMapLoadMJO_Wrap(j);
    }

    public static void DGLMapShowMJOAndSetCamera_Wrap(long j, long j2) {
        MapEngineJNIBridge.DGLMapShowMJOAndSetCamera_Wrap(j, j2);
    }

    public static void DGLMapHideMJO_Wrap(long j, boolean z) {
        MapEngineJNIBridge.DGLMapHideMJO_Wrap(j, z);
    }

    public static void DGLMapRestoreMapOnMJOHide_Wrap(long j, long j2, int i, double d, double d2, double d3, float f, float f2) {
        MapEngineJNIBridge.DGLMapRestoreMapOnMJOHide_Wrap(j, j2, i, d, d2, d3, f, f2);
    }

    public static void DMapSetScreenCenterOffset_Wrap(long j, float f, float f2) {
        MapEngineJNIBridge.DMapSetScreenCenterOffset_Wrap(j, f, f2);
    }

    public static int DGLMapFetchTrafficBlockData_Wrap(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return MapEngineJNIBridge.DGLMapFetchTrafficBlockData_Wrap(j, bArr, i, i2, i3, i4, i5);
    }

    public static void DMapRouteModifyWidth_Wrap(long j, int i, float f) {
        MapEngineJNIBridge.DMapRouteModifyWidth_Wrap(j, i, f);
    }

    public static void DMapRouteSetPassedPoint_Wrap(long j, int i, int i2, double d, double d2) {
        MapEngineJNIBridge.DMapRouteSetPassedPoint_Wrap(j, i, i2, d, d2);
    }

    public static void DMapRouteSetClearPoint_Wrap(long j, int i, int i2, double d, double d2) {
        MapEngineJNIBridge.DMapRouteSetClearPoint_Wrap(j, i, i2, d, d2);
    }

    public static void DMapMarkerModifyPosition_Wrap(long j, int i, double d, double d2) {
        MapEngineJNIBridge.DMapMarkerModifyPosition_Wrap(j, i, d, d2);
    }

    public static int DMapMarkerRegularPrimitiveCreate_Wrap(long j, double[] dArr, double[] dArr2, int i, float f, short[] sArr, double[] dArr3, int i2, float f2, boolean z, DMapPrimitiveType dMapPrimitiveType) {
        return MapEngineJNIBridge.DMapMarkerRegularPrimitiveCreate_Wrap(j, dArr, dArr2, i, f, sArr, dArr3, i2, f2, z, dMapPrimitiveType.swigValue());
    }

    public static void DMapMarkerRegularPrimitiveUpdate_Wrap(long j, int i, double[] dArr, double[] dArr2, int i2, float f, short[] sArr, double[] dArr3, int i3, float f2, boolean z, DMapPrimitiveType dMapPrimitiveType) {
        MapEngineJNIBridge.DMapMarkerRegularPrimitiveUpdate_Wrap(j, i, dArr, dArr2, i2, f, sArr, dArr3, i3, f2, z, dMapPrimitiveType.swigValue());
    }

    public static int DMapNewPolygonCreate_Wrap(long j, double[] dArr, double[] dArr2, int i, boolean z, short[] sArr, int i2, float f, boolean z2, float f2, DMapPrimitiveType dMapPrimitiveType) {
        return MapEngineJNIBridge.DMapNewPolygonCreate_Wrap(j, dArr, dArr2, i, z, sArr, i2, f, z2, f2, dMapPrimitiveType.swigValue());
    }

    public static int DMapCircleCreate_Wrap(long j, double d, double d2, float f, int i, short[] sArr, int i2, float f2, boolean z, float f3, DMapPrimitiveType dMapPrimitiveType, boolean z2) {
        return MapEngineJNIBridge.DMapCircleCreate_Wrap(j, d, d2, f, i, sArr, i2, f2, z, f3, dMapPrimitiveType.swigValue(), z2);
    }

    public static void DMapCircleModify_Wrap(long j, int i, double d, double d2, float f, int i2, short[] sArr, int i3, float f2, boolean z, float f3, DMapPrimitiveType dMapPrimitiveType) {
        MapEngineJNIBridge.DMapCircleModify_Wrap(j, i, d, d2, f, i2, sArr, i3, f2, z, f3, dMapPrimitiveType.swigValue());
    }

    public static void DMapPolylineModifyPoints_Wrap(long j, int i, double[] dArr, double[] dArr2, int i2) {
        MapEngineJNIBridge.DMapPolylineModifyPoints_Wrap(j, i, dArr, dArr2, i2);
    }

    public static boolean DMapZoomToSpan_Wrap(long j, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4) {
        return MapEngineJNIBridge.DMapZoomToSpan_Wrap(j, f, f2, f3, f4, i, i2, i3, i4);
    }

    public static void DMapZoomForNavigation_Wrap(long j, double d, double d2) {
        MapEngineJNIBridge.DMapZoomForNavigation_Wrap(j, d, d2);
    }

    public static void DMapLocatorModiffyZIndex(long j, int i) {
        MapEngineJNIBridge.DMapLocatorModiffyZIndex(j, i);
    }

    public static void DMapLocatorModifyIndicatorImage_Wrap(long j, String str, float f, float f2) {
        MapEngineJNIBridge.DMapLocatorModifyIndicatorImage_Wrap(j, str, f, f2);
    }

    public static void DMapLocatorModifyCompassImage_Wrap(long j, String str, String str2, String str3, String str4, String str5, float f, float f2) {
        MapEngineJNIBridge.DMapLocatorModifyCompassImage_Wrap(j, str, str2, str3, str4, str5, f, f2);
    }

    public static void DGLMapSetLocationInfo_Wrap(long j, long j2, double d, double d2, float f, float f2, float f3, boolean z, boolean z2) {
        MapEngineJNIBridge.DGLMapSetLocationInfo_Wrap(j, j2, d, d2, f, f2, f3, z, z2);
    }

    public static void DGLMapSetLocationInfoWithSkewAndScale_Wrap(long j, long j2, double d, double d2, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2) {
        MapEngineJNIBridge.DGLMapSetLocationInfoWithSkewAndScale_Wrap(j, j2, d, d2, f, f2, f3, f4, f5, z, z2);
    }

    public static boolean DGLMapSetRouteNameClearPoint_Wrap(long j, long j2, long j3, int i, boolean z) {
        return MapEngineJNIBridge.DGLMapSetRouteNameClearPoint_Wrap(j, j2, j3, i, z);
    }

    public static void DMapMarkerModifyScreenOffset_Wrap(long j, int i, float f, float f2) {
        MapEngineJNIBridge.DMapMarkerModifyScreenOffset_Wrap(j, i, f, f2);
    }

    public static void DMapRouteSetAnimationColorLineScanMixColor_Wrap(long j, int i, short[] sArr) {
        MapEngineJNIBridge.DMapRouteSetAnimationColorLineScanMixColor_Wrap(j, i, sArr);
    }

    public static void DMapMarkerModifyScale_Wrap(long j, int i, float f, float f2) {
        MapEngineJNIBridge.DMapMarkerModifyScale_Wrap(j, i, f, f2);
    }

    public static boolean DGLMapRenderFrameSeconds_Wrap(long j, long j2) {
        return MapEngineJNIBridge.DGLMapRenderFrameSeconds_Wrap(j, j2);
    }

    public static double DoubleEvaluateSpeedUp(double d, double d2, float f) {
        return MapEngineJNIBridge.DoubleEvaluateSpeedUp(d, d2, f);
    }

    public static float FloatEvaluateSpeedUp(float f, float f2, float f3) {
        return MapEngineJNIBridge.FloatEvaluateSpeedUp(f, f2, f3);
    }

    public static void DGLMapSetRotate_Wrap(long j, long j2, float f) {
        MapEngineJNIBridge.DGLMapSetRotate_Wrap(j, j2, f);
    }

    public static void DGLMapSetScale_Wrap(long j, long j2, double d) {
        MapEngineJNIBridge.DGLMapSetScale_Wrap(j, j2, d);
    }

    public static void DGLMapSetSkew_Wrap(long j, long j2, float f) {
        MapEngineJNIBridge.DGLMapSetSkew_Wrap(j, j2, f);
    }

    public static void DGLMapMoveBy_Wrap(long j, float f, float f2) {
        MapEngineJNIBridge.DGLMapMoveBy_Wrap(j, f, f2);
    }

    public static void DMapMarkerModifyAlpha_Wrap(long j, int i, float f) {
        MapEngineJNIBridge.DMapMarkerModifyAlpha_Wrap(j, i, f);
    }

    public static void ShowGuideLine(long j, long j2, boolean z, double d, double d2) {
        MapEngineJNIBridge.ShowGuideLine(j, j2, z, d, d2);
    }

    public static void SetGuideLineDestination(long j, long j2, double d, double d2) {
        MapEngineJNIBridge.SetGuideLineDestination(j, j2, d, d2);
    }

    public static void DGLMapSetFlagOfZoomToSpanForLocation_Wrap(long j, float f, float f2, float f3, float f4, int i, int i2) {
        MapEngineJNIBridge.DGLMapSetFlagOfZoomToSpanForLocation_Wrap(j, f, f2, f3, f4, i, i2);
    }

    public static int AddMaskLayer_Wrap(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return MapEngineJNIBridge.AddMaskLayer_Wrap(j, i, i2, i3, i4, i5, i6, i7);
    }

    public static void SetMaskLayerWidthHeightColor_Wrap(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        MapEngineJNIBridge.SetMaskLayerWidthHeightColor_Wrap(j, i, i2, i3, i4, i5, i6, i7);
    }

    public static int GetZIndexStart_Wrap(int i) {
        return MapEngineJNIBridge.GetZIndexStart_Wrap(i);
    }

    public static boolean DGLMapVecEnlargeAddData_Wrap(long j, String str, byte[] bArr, long j2, float f) {
        return MapEngineJNIBridge.DGLMapVecEnlargeAddData_Wrap(j, str, bArr, j2, f);
    }

    public static boolean DGLMapVecEnlargeIsVisible_Wrap(long j, String str, boolean z) {
        return MapEngineJNIBridge.DGLMapVecEnlargeIsVisible_Wrap(j, str, z);
    }

    public static void DMapSetVisibleScreenArea_Wrap(long j, int i, int i2, int i3) {
        MapEngineJNIBridge.DMapSetVisibleScreenArea_Wrap(j, i, i2, i3);
    }

    public static void SetScreenRect(long j, long j2, int i, int i2, int i3, int i4) {
        MapEngineJNIBridge.SetScreenRect(j, j2, i, i2, i3, i4);
    }

    public static void MapOverlayHandleCollision(long j, long j2) {
        MapEngineJNIBridge.MapOverlayHandleCollision(j, j2);
    }

    public static void DGLMapSetRouteNameVisible_Wrap(long j, long j2, boolean z) {
        MapEngineJNIBridge.DGLMapSetRouteNameVisible_Wrap(j, j2, z);
    }

    public static void AddMapOverlay_Wrap(long j, long j2, MapOverlay mapOverlay) {
        MapEngineJNIBridge.AddMapOverlay_Wrap(j, j2, MapOverlay.getCPtr(mapOverlay), mapOverlay);
    }

    public static void RemoveMapOverlay_Wrap(long j, long j2, long j3) {
        MapEngineJNIBridge.RemoveMapOverlay_Wrap(j, j2, j3);
    }

    public static void UpdateMapOverlay_Wrap(long j, long j2, MapOverlay mapOverlay) {
        MapEngineJNIBridge.UpdateMapOverlay_Wrap(j, j2, MapOverlay.getCPtr(mapOverlay), mapOverlay);
    }

    public static void UpdateMapOverlayPointArea_Wrap(long j, long j2, long j3, double[] dArr, double[] dArr2, int i, int[] iArr, int[] iArr2, int i2) {
        MapEngineJNIBridge.UpdateMapOverlayPointArea_Wrap(j, j2, j3, dArr, dArr2, i, iArr, iArr2, i2);
    }

    public static void UpdateMapOverlayPosition_Wrap(long j, long j2, long j3, double d, double d2) {
        MapEngineJNIBridge.UpdateMapOverlayPosition_Wrap(j, j2, j3, d, d2);
    }

    public static void SetMapOverlayVisible_Wrap(long j, long j2, long j3, boolean z) {
        MapEngineJNIBridge.SetMapOverlayVisible_Wrap(j, j2, j3, z);
    }

    public static boolean GetMapOverlayRealVisible(long j, long j2, long j3) {
        return MapEngineJNIBridge.GetMapOverlayRealVisible(j, j2, j3);
    }

    public static void OverlayMapOnTap(long j, long j2, int i, int i2, MapOverlayMapTappedElement mapOverlayMapTappedElement) {
        MapEngineJNIBridge.OverlayMapOnTap(j, j2, i, i2, MapOverlayMapTappedElement.getCPtr(mapOverlayMapTappedElement), mapOverlayMapTappedElement);
    }

    public static void setHWBussThresholdOpen(long j, long j2, boolean z, float f) {
        MapEngineJNIBridge.setHWBussThresholdOpen(j, j2, z, f);
    }

    public static void setHWBussApolloSwitch(long j, long j2, boolean z, boolean z2, boolean z3, boolean z4) {
        MapEngineJNIBridge.setHWBussApolloSwitch(j, j2, z, z2, z3, z4);
    }

    public static void set3dPaddingTopOffset(long j, long j2, float f) {
        MapEngineJNIBridge.set3dPaddingTopOffset(j, j2, f);
    }

    public static void setHWBussBarn(long j, long j2, DMapVector2d dMapVector2d, double d, double d2, DMapVector2d dMapVector2d2, double d3, double d4, DMapVector2d dMapVector2d3, DMapVector2d dMapVector2d4, DMapVector2d dMapVector2d5) {
        MapEngineJNIBridge.setHWBussBarn(j, j2, DMapVector2d.getCPtr(dMapVector2d), dMapVector2d, d, d2, DMapVector2d.getCPtr(dMapVector2d2), dMapVector2d2, d3, d4, DMapVector2d.getCPtr(dMapVector2d3), dMapVector2d3, DMapVector2d.getCPtr(dMapVector2d4), dMapVector2d4, DMapVector2d.getCPtr(dMapVector2d5), dMapVector2d5);
    }

    public static void addRemoteIconBindOverlay(long j, long j2, MapOverlay mapOverlay, long j3) {
        MapEngineJNIBridge.addRemoteIconBindOverlay(j, j2, MapOverlay.getCPtr(mapOverlay), mapOverlay, j3);
    }

    public static void changeRemoteIconBindOverlay(long j, long j2, long j3, long j4) {
        MapEngineJNIBridge.changeRemoteIconBindOverlay(j, j2, j3, j4);
    }

    public static void removeRemoteIcon(long j, long j2, long j3) {
        MapEngineJNIBridge.removeRemoteIcon(j, j2, j3);
    }

    public static long DMapCreateMap_Wrap(DMapCreateDataDelegate dMapCreateDataDelegate, String str, String str2, String str3, String str4, long j) {
        return MapEngineJNIBridge.DMapCreateMap_Wrap(DMapCreateDataDelegate.getCPtr(dMapCreateDataDelegate), dMapCreateDataDelegate, str, str2, str3, str4, j);
    }

    public static long createHWBussManager() {
        return MapEngineJNIBridge.createHWBussManager();
    }

    public static int GenerateCirclePoint(double d, double d2, float f, int i, double[] dArr, double[] dArr2, int i2) {
        return MapEngineJNIBridge.GenerateCirclePoint(d, d2, f, i, dArr, dArr2, i2);
    }

    public static SWIGTYPE_p_void DMapVulkanCreate() {
        long DMapVulkanCreate = MapEngineJNIBridge.DMapVulkanCreate();
        if (DMapVulkanCreate == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(DMapVulkanCreate, false);
    }

    public static void DMapVulkanCreateContext(long j) {
        MapEngineJNIBridge.DMapVulkanCreateContext(j);
    }

    public static boolean DMapVulkanIsSupport(long j) {
        return MapEngineJNIBridge.DMapVulkanIsSupport(j);
    }

    public static void DMapVulkanPause(long j) {
        MapEngineJNIBridge.DMapVulkanPause(j);
    }

    public static void DMapVulkanStart(long j) {
        MapEngineJNIBridge.DMapVulkanStart(j);
    }

    public static void DMapVulkanResume(long j) {
        MapEngineJNIBridge.DMapVulkanResume(j);
    }

    public static void DMapVulkanStop(long j) {
        MapEngineJNIBridge.DMapVulkanStop(j);
    }

    public static void DMapVulkanAcquireImage(long j) {
        MapEngineJNIBridge.DMapVulkanAcquireImage(j);
    }

    public static void DMapVulkanQueuePresent(long j) {
        MapEngineJNIBridge.DMapVulkanQueuePresent(j);
    }

    public static void DMapVulkanSurfaceCreated(long j) {
        MapEngineJNIBridge.DMapVulkanSurfaceCreated(j);
    }

    public static void DMapVulkanSurfaceChanged(long j) {
        MapEngineJNIBridge.DMapVulkanSurfaceChanged(j);
    }

    public static void DMapVulkanSurfaceDestroy(long j) {
        MapEngineJNIBridge.DMapVulkanSurfaceDestroy(j);
    }

    public static void DMapVulkanDestroyContext(long j) {
        MapEngineJNIBridge.DMapVulkanDestroyContext(j);
    }

    public static void DMapVulkanCleanUpContext(long j) {
        MapEngineJNIBridge.DMapVulkanCleanUpContext(j);
    }

    public static void DMapVulkanSetWindow_Wrap(long j, Object obj) {
        MapEngineJNIBridge.DMapVulkanSetWindow_Wrap(j, obj);
    }

    public static long createJNIContext() {
        return MapEngineJNIBridge.createJNIContext();
    }

    public static void destroyJNIContext(long j) {
        MapEngineJNIBridge.destroyJNIContext(j);
    }

    public static void DGLMapSetTrafficColor_Wrap(long j, int i, int i2, int i3, int i4) {
        MapEngineJNIBridge.DGLMapSetTrafficColor_Wrap(j, i, i2, i3, i4);
    }

    public static int SetRoutePoints_Wrap(int i, long j, Object[] objArr, int[] iArr, int[] iArr2, String str) {
        return MapEngineJNIBridge.SetRoutePoints_Wrap(i, j, objArr, iArr, iArr2, str);
    }

    public static int SetRouteTexture_Wrap(int i, long j, String str) {
        return MapEngineJNIBridge.SetRouteTexture_Wrap(i, j, str);
    }

    public static int SetRouteNaviRouteId_Wrap(int i, long j, long j2, boolean z) {
        return MapEngineJNIBridge.SetRouteNaviRouteId_Wrap(i, j, j2, z);
    }

    public static void ClearMJONaviRouteLink_Wrap(long j) {
        MapEngineJNIBridge.ClearMJONaviRouteLink_Wrap(j);
    }

    public static boolean UpdateMJOLocatorInfo_Wrap(long j, double d, double d2, int i, int i2, long j2, long j3) {
        return MapEngineJNIBridge.UpdateMJOLocatorInfo_Wrap(j, d, d2, i, i2, j2, j3);
    }

    public static int AddRoute_Wrap(long j, long j2, Object[] objArr, int[] iArr, int[] iArr2, String str, float f, int i, float f2, boolean z, boolean z2, int i2, long j3, boolean z3, long j4, boolean z4) {
        return MapEngineJNIBridge.AddRoute_Wrap(j, j2, objArr, iArr, iArr2, str, f, i, f2, z, z2, i2, j3, z3, j4, z4);
    }

    public static int SetRoutePercent_Wrap(int i, long j, String str, float f, long j2) {
        return MapEngineJNIBridge.SetRoutePercent_Wrap(i, j, str, f, j2);
    }

    public static void DMapMarkerGetScreenArea_Wrap(long j, int i, float[] fArr) {
        MapEngineJNIBridge.DMapMarkerGetScreenArea_Wrap(j, i, fArr);
    }

    public static void DMapMarkerGetGeoBound_Wrap(long j, int i, double[] dArr) {
        MapEngineJNIBridge.DMapMarkerGetGeoBound_Wrap(j, i, dArr);
    }

    public static int DMapMarkerLocatorGetID_Wrap(long j) {
        return MapEngineJNIBridge.DMapMarkerLocatorGetID_Wrap(j);
    }

    public static void DGLMapGetRouteArrowFurthestPt_Wrap(long j, double[] dArr) {
        MapEngineJNIBridge.DGLMapGetRouteArrowFurthestPt_Wrap(j, dArr);
    }

    public static void DGLMapGetCenterMapPoint_Wrap(long j, double[] dArr) {
        MapEngineJNIBridge.DGLMapGetCenterMapPoint_Wrap(j, dArr);
    }

    public static int DGLMapRouteTrueClearPoint_Wrap(long j, int i, double[] dArr) {
        return MapEngineJNIBridge.DGLMapRouteTrueClearPoint_Wrap(j, i, dArr);
    }

    public static boolean LatLng2Screen_Wrap(long j, double d, double d2, float[] fArr) {
        return MapEngineJNIBridge.LatLng2Screen_Wrap(j, d, d2, fArr);
    }

    public static boolean Screen2LatLng_Wrap(long j, float f, float f2, double[] dArr) {
        return MapEngineJNIBridge.Screen2LatLng_Wrap(j, f, f2, dArr);
    }

    public static boolean ZoomToSpan4Offset_Wrap(long j, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4, float f5, float f6, int i5, int i6, double[] dArr) {
        return MapEngineJNIBridge.ZoomToSpan4Offset_Wrap(j, f, f2, f3, f4, i, i2, i3, i4, f5, f6, i5, i6, dArr);
    }

    public static void AddRouteNames_Wrap(long j, long j2, int i, long j3, Object[] objArr, Object[] objArr2, boolean z) {
        MapEngineJNIBridge.AddRouteNames_Wrap(j, j2, i, j3, objArr, objArr2, z);
    }

    public static void AddRouteNames_WrapOld(long j, int i, long j2, Object[] objArr, Object[] objArr2, boolean z) {
        MapEngineJNIBridge.AddRouteNames_WrapOld(j, i, j2, objArr, objArr2, z);
    }

    public static void DeleteRouteNameSegment_Wrap(long j, long j2, long j3) {
        MapEngineJNIBridge.DeleteRouteNameSegment_Wrap(j, j2, j3);
    }

    public static void AddMultipleRouteNames_Wrap(long j, int i, long j2, Object[] objArr, Object[] objArr2, int i2, int i3, String str, byte[] bArr, int i4, int i5) {
        MapEngineJNIBridge.AddMultipleRouteNames_Wrap(j, i, j2, objArr, objArr2, i2, i3, str, bArr, i4, i5);
    }

    public static void DeleteSpecialBubbleWithType_Wrap(long j, int i) {
        MapEngineJNIBridge.DeleteSpecialBubbleWithType_Wrap(j, i);
    }

    public static void AddSpecialBubble_Wrap(long j, Object[] objArr, Object[] objArr2, long j2, int i) {
        MapEngineJNIBridge.AddSpecialBubble_Wrap(j, objArr, objArr2, j2, i);
    }

    public static void UpdateSpecialBubble_Wrap(long j, Object[] objArr, long j2) {
        MapEngineJNIBridge.UpdateSpecialBubble_Wrap(j, objArr, j2);
    }

    public static void RemoveSpecialBubble_Wrap(long j, long j2) {
        MapEngineJNIBridge.RemoveSpecialBubble_Wrap(j, j2);
    }

    public static void DGLMapUpdateLocalTrafficIcon_Wrap(long j, Object[] objArr) {
        MapEngineJNIBridge.DGLMapUpdateLocalTrafficIcon_Wrap(j, objArr);
    }

    public static Object[] DGLGetTrafficEventRoutePointInfo_Wrap(long j) {
        return MapEngineJNIBridge.DGLGetTrafficEventRoutePointInfo_Wrap(j);
    }

    public static Object[] DGLLoadAndGetMJOBindRouteInfo_Wrap(long j, long j2, int i, byte[] bArr, int i2, long[] jArr, int[] iArr, double[] dArr, int i3, long j3) {
        return MapEngineJNIBridge.DGLLoadAndGetMJOBindRouteInfo_Wrap(j, j2, i, bArr, i2, jArr, iArr, dArr, i3, j3);
    }

    public static byte[] DGLMapGenVecEnlargePNGImage_Wrap(long j, byte[] bArr, long j2, float f) {
        return MapEngineJNIBridge.DGLMapGenVecEnlargePNGImage_Wrap(j, bArr, j2, f);
    }

    public static void DMapSetZhongYanEventData_Wrap(long j, byte[] bArr, long j2) {
        MapEngineJNIBridge.DMapSetZhongYanEventData_Wrap(j, bArr, j2);
    }

    public static int DMapAddMarker_Wrap(long j, double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i, int i2, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, float f8, boolean z7, boolean z8, Object obj, boolean z9) {
        return MapEngineJNIBridge.DMapAddMarker_Wrap(j, d, d2, str, f, f2, f3, f4, f5, f6, i, i2, f7, z, z2, z3, z4, z5, z6, i3, f8, z7, z8, obj, z9);
    }

    public static void DMapMarkerIconModifyInfo_Wrap(long j, int i, double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i2, int i3, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i4, float f8, boolean z7, Object obj, boolean z8) {
        MapEngineJNIBridge.DMapMarkerIconModifyInfo_Wrap(j, i, d, d2, str, f, f2, f3, f4, f5, f6, i2, i3, f7, z, z2, z3, z4, z5, z6, i4, f8, z7, obj, z8);
    }

    public static boolean DMapSetVioParkingRegionData_Wrap(long j, byte[] bArr, int i) {
        return MapEngineJNIBridge.DMapSetVioParkingRegionData_Wrap(j, bArr, i);
    }

    public static int DGLMapMarkerBezierCurveCreate_Wrap(long j, double[] dArr, int[] iArr, float f, float f2, float f3) {
        return MapEngineJNIBridge.DGLMapMarkerBezierCurveCreate_Wrap(j, dArr, iArr, f, f2, f3);
    }

    public static boolean CaculateScaleRuler(long j, int i, double[] dArr) {
        return MapEngineJNIBridge.CaculateScaleRuler(j, i, dArr);
    }

    public static Object[] PolygonClipp(int i, double[] dArr, double[] dArr2, int i2, double[] dArr3, double[] dArr4, int i3, int i4) {
        return MapEngineJNIBridge.PolygonClipp(i, dArr, dArr2, i2, dArr3, dArr4, i3, i4);
    }
}
