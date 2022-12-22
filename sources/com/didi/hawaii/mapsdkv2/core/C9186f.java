package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.log.HwDLog;
import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.MapCanvas;
import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.hawaii.mapsdkv2.jni.BlockInfo;
import com.didi.hawaii.mapsdkv2.jni.BlockInfoArray;
import com.didi.hawaii.mapsdkv2.jni.BlockPoint;
import com.didi.hawaii.mapsdkv2.jni.BlockType;
import com.didi.hawaii.mapsdkv2.jni.DDLocationCoordinate2D;
import com.didi.hawaii.mapsdkv2.jni.DDMapPoint;
import com.didi.hawaii.mapsdkv2.jni.DDMapPointArray;
import com.didi.hawaii.mapsdkv2.jni.DDUINT8_Array;
import com.didi.hawaii.mapsdkv2.jni.DGLMapTappedElement;
import com.didi.hawaii.mapsdkv2.jni.DMapCreateDataDelegate;
import com.didi.hawaii.mapsdkv2.jni.DMapDynamicLayerType;
import com.didi.hawaii.mapsdkv2.jni.DMapLanguage;
import com.didi.hawaii.mapsdkv2.jni.DMapPrimitiveType;
import com.didi.hawaii.mapsdkv2.jni.DMapRouteArrowType;
import com.didi.hawaii.mapsdkv2.jni.DMapTappedETTextAnnoItemType;
import com.didi.hawaii.mapsdkv2.jni.DMapTappedElementType;
import com.didi.hawaii.mapsdkv2.jni.DMapTheme;
import com.didi.hawaii.mapsdkv2.jni.DMapTrafficEventType;
import com.didi.hawaii.mapsdkv2.jni.DMapVector2d;
import com.didi.hawaii.mapsdkv2.jni.DMarkerRenderOrder;
import com.didi.hawaii.mapsdkv2.jni.DiAnimationType;
import com.didi.hawaii.mapsdkv2.jni.DiInterpolatorType;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.HWBSRAManager;
import com.didi.hawaii.mapsdkv2.jni.JniHelper;
import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayMapTappedElement;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRect;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRectArray;
import com.didi.hawaii.mapsdkv2.jni.MapPointArea;
import com.didi.hawaii.mapsdkv2.jni.MapPointSection;
import com.didi.hawaii.mapsdkv2.jni.MapPointSectionArray;
import com.didi.hawaii.mapsdkv2.jni.MapTrafficIconAttrs;
import com.didi.hawaii.mapsdkv2.jni.MapVisibleChangeAnimateAttrs;
import com.didi.hawaii.mapsdkv2.jni.SWIGTYPE_p_unsigned_char;
import com.didi.hawaii.mapsdkv2.jni.SwigBlockEventCallback;
import com.didi.hawaii.mapsdkv2.jni.SwigMJOCallback;
import com.didi.hawaii.mapsdkv2.jni.SwigMapCallback;
import com.didi.map.MapApolloHawaii;
import com.didi.map.MapOmegaUtil;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.AnimationSetting;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.common.utils.MapSerializeUtil;
import com.didi.map.common.utils.TransformUtil;
import com.didi.map.constant.FileNameConstant;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.OutBlockInfo;
import com.didi.sdk.apm.SystemUtils;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.hawaii.mapsdkv2.core.f */
/* compiled from: MapEngineImpl */
final class C9186f implements MapCanvas, MapEngine {

    /* renamed from: a */
    boolean f24024a = MapApolloHawaii.USE_NEW_BLUE_BUBBLE;

    /* renamed from: b */
    private Thread f24025b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MapCanvas.TileCallback f24026c;

    /* renamed from: d */
    private SwigMapCallback f24027d;

    /* renamed from: e */
    private SwigMJOCallback f24028e;

    /* renamed from: f */
    private SwigBlockEventCallback f24029f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MapEngine.MJOCallback f24030g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MapEngine.BlockEventCallback f24031h;

    /* renamed from: i */
    private long f24032i = 0;

    /* renamed from: j */
    private long f24033j;

    /* renamed from: k */
    private boolean f24034k = false;

    /* renamed from: l */
    private boolean f24035l = false;

    /* renamed from: m */
    private final double[] f24036m = new double[4];

    /* renamed from: n */
    private final double[] f24037n = new double[2];

    /* renamed from: o */
    private final double[] f24038o = new double[2];

    /* renamed from: p */
    private final double[] f24039p = new double[4];

    /* renamed from: q */
    private final float[] f24040q = new float[2];

    /* renamed from: r */
    private final float[] f24041r = new float[2];

    /* renamed from: a */
    private void m17088a() {
    }

    public void cleanCache() {
    }

    public void pause() {
    }

    public void setCircleRingWidth(int i, float f) {
    }

    public void setMapParams(byte[] bArr) {
    }

    C9186f() {
    }

    public boolean checkNeedGuard(String str) {
        HashMap<String, Integer> guardConfig = MapApolloHawaii.getGuardConfig();
        if (guardConfig != null) {
            int intValue = guardConfig.get("crashNumMax").intValue();
            int intValue2 = guardConfig.get("timeMax").intValue();
            int intValue3 = guardConfig.get("timeFirst").intValue();
            boolean DGLMapCheckNeedGuard = MapEngineJNI.DGLMapCheckNeedGuard(str, intValue, intValue2, intValue3);
            MapOmegaUtil.trackMapGuard(intValue, intValue2, intValue3, DGLMapCheckNeedGuard);
            return DGLMapCheckNeedGuard;
        }
        MapOmegaUtil.trackMapGuard(0, 0, 0, false);
        return false;
    }

    public void createEngineContext() {
        this.f24033j = MapEngineJNI.createJNIContext();
        this.f24034k = true;
    }

    public void setDynamicConfigProvider(EngineDynamicConfigProvider engineDynamicConfigProvider) {
        if (this.f24033j != 0) {
            MapEngineJNI.DGLGlobalSetApolloCallbacks_Wrap(new MapEngineImpl$1(this, engineDynamicConfigProvider), this.f24033j);
        }
    }

    public void setUseVulkan(boolean z) {
        MapEngineJNI.DGLMapDDApolloSetUseVulkan(z);
    }

    public boolean isUseStyleV2() {
        return MapEngineJNI.DMapIsUseStyleV2();
    }

    public void setMJOEnabled(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapDDSetUseMJO(z);
        }
    }

    public void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f) {
        m17088a();
        if (this.f24035l) {
            HWLog.m16761i("setVecEnlargeVisibleArea", "x = " + i + ", y = " + i2 + ", width = " + i3 + ", height = " + i4 + ", radius = " + f);
            MapEngineJNI.DGLMapVecEnlargeSetVisibleArea(this.f24032i, i, i2, i3, i4, f);
        }
    }

    public void destroyAllVecEnlarge() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapVecEnlargeDestroyAll(this.f24032i);
        }
    }

    public void setTrafficEventIconCustomSize(int i) {
        m17088a();
        if (this.f24035l) {
            long j = 32;
            if (i != 1) {
                if (i == 2) {
                    j = 40;
                } else if (i == 3) {
                    j = 50;
                }
            }
            long j2 = j;
            long j3 = j;
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Congestion, j2, j3);
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Accident, j2, j3);
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Construction, j2, j3);
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Control, j2, j3);
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Closure, 32, 32);
            long j4 = j;
            long j5 = j;
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Stagnation, j4, j5);
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Police, j4, j5);
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Announcement, j4, j5);
            MapEngineJNI.DGLSetTrafficEventIconCustomSize(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Congestion2, j4, j5);
        }
    }

    public void resetTrafficEventIconCustomSize() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLResetTrafficEventIconCustomSize(this.f24032i);
        }
    }

    public void setMJOCallback(MapEngine.MJOCallback mJOCallback) {
        m17088a();
        if (this.f24035l) {
            this.f24030g = mJOCallback;
        }
    }

    public void setBlockEventCallback(MapEngine.BlockEventCallback blockEventCallback) {
        m17088a();
        if (this.f24035l) {
            this.f24031h = blockEventCallback;
        }
    }

    public LatLng[] loadMJOAndGetBindRoute(long j, int i, byte[] bArr, long[] jArr, int[] iArr, double[] dArr, int i2, long j2) {
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        LatLng[] latLngArr = (LatLng[]) MapEngineJNI.DGLLoadAndGetMJOBindRouteInfo_Wrap(this.f24032i, j, i, bArr, bArr.length, jArr, iArr, dArr, i2, j2);
        MapEngineJNI.DGLMapLoadMJO_Wrap(this.f24032i);
        return latLngArr;
    }

    public void showMJO() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapShowMJOAndSetCamera_Wrap(this.f24032i, this.f24033j);
        }
    }

    public void hideMJO(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapHideMJO_Wrap(this.f24032i, z);
        }
    }

    public void restoreMapCameraOnMJOHide(int i, Camera camera) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapRestoreMapOnMJOHide_Wrap(this.f24032i, this.f24033j, i, camera.getCenter().latitude, camera.getCenter().longitude, (double) camera.getScale(), camera.getRotate(), camera.getSkew());
        }
    }

    public void setVioParkingRegionData(byte[] bArr, int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapSetVioParkingRegionData_Wrap(this.f24032i, bArr, i);
        }
    }

    public void clearMJORouteInfo() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.ClearMJONaviRouteLink_Wrap(this.f24032i);
        }
    }

    public int setIsInternationalWms(boolean z) {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DGLMapSetInternationalWms_Wrap(this.f24032i, z);
        }
        return -1;
    }

    public void setAnnotationShowLight(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetAnnotationLightVisible_Wrap(this.f24032i, z);
        }
    }

    public void setAboardPointJson(String str) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLSetAboardPointJson(this.f24032i, str, str.length());
        }
    }

    public void setPoiMarkerRect(Rect[] rectArr) {
        m17088a();
        if (this.f24035l) {
            int length = rectArr.length;
            int[] iArr = new int[length];
            int[] iArr2 = new int[length];
            int[] iArr3 = new int[length];
            int[] iArr4 = new int[length];
            for (int i = 0; i < length; i++) {
                Rect rect = rectArr[i];
                if (rect != null) {
                    iArr[i] = rect.left;
                    iArr2[i] = rect.top;
                    iArr3[i] = rect.right;
                    iArr4[i] = rect.bottom;
                }
            }
            MapEngineJNI.DGLSetMarkerRect_Wrap(this.f24032i, iArr, iArr2, iArr3, iArr4, length);
        }
    }

    public boolean create(float f, String str, String str2, String str3, String str4, ArrayList<String> arrayList, int[] iArr, float f2, int i, int i2, int i3, MapEngine.Callback callback, EngineLogSwitch engineLogSwitch, boolean z) {
        String str5 = str;
        int[] iArr2 = iArr;
        this.f24025b = Thread.currentThread();
        if (iArr2.length == 4) {
            DMapCreateDataDelegate dMapCreateDataDelegate = new DMapCreateDataDelegate();
            dMapCreateDataDelegate.setTheme(m17094b(i3));
            dMapCreateDataDelegate.setIsVectorMap(true);
            dMapCreateDataDelegate.setDensity(f);
            dMapCreateDataDelegate.setIsRetina(false);
            dMapCreateDataDelegate.setTileSize(256);
            dMapCreateDataDelegate.setTextScale(f2);
            dMapCreateDataDelegate.setMainContext(JniHelper.castAsPVoid(1));
            dMapCreateDataDelegate.setBackContext((!C9188h.m17100a() || !z) ? JniHelper.castAsPVoid(0) : JniHelper.castAsPVoid(1));
            dMapCreateDataDelegate.setLanguage(m17087a(i2));
            dMapCreateDataDelegate.setMapEngineVersion((long) i);
            HWLog.m16761i("hwmap", "create simple size=" + MJOConfigHelper.EGL_SAMPLES_SIZE);
            dMapCreateDataDelegate.setMultiSimple(MJOConfigHelper.EGL_SAMPLES_SIZE);
            long DMapCreateMap_Wrap = MapEngineJNI.DMapCreateMap_Wrap(dMapCreateDataDelegate, str2, str3, str, str4, this.f24033j);
            this.f24032i = DMapCreateMap_Wrap;
            MapEngineJNI.setHWBussApolloSwitch(DMapCreateMap_Wrap, this.f24033j, ApolloHawaii.USE_NEWBUBBLE, ApolloHawaii.newMultiBubbleCollision, ApolloHawaii.OPEN_ANIMATE, ApolloHawaii.OPEN_ANIMATE_HAS_DEL_ANIMATE);
            if (this.f24032i == 0) {
                return false;
            }
            this.f24035l = true;
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        MapEngineJNI.DGLMapSetABTestMode4Json(this.f24032i, next, next.length());
                    }
                }
            }
            this.f24027d = new MapEngineImpl$2(this, callback);
            this.f24028e = new MapEngineImpl$3(this);
            this.f24029f = new MapEngineImpl$4(this);
            MapEngineJNI.DGLMapSetCallbacks_Wrap(this.f24032i, this.f24033j, this.f24027d, this.f24024a);
            MapEngineJNI.DGLMapSetMJOCallback_Wrap(this.f24032i, this.f24033j, this.f24028e);
            long j = this.f24032i;
            MapEngineJNI.DGLMapSetResPackPath(j, str5 + FileNameConstant.POI_MAP_PACK, str5);
            MapEngineJNI.DGLMapSetTrafficColor_Wrap(this.f24032i, iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            MapEngineJNI.DGLMapSetAttachDir(this.f24032i, str5);
            MapEngineJNI.DGLMapSetBlockEventCallback_Wrap(this.f24032i, this.f24033j, this.f24029f);
            return true;
        }
        throw new IllegalArgumentException("Traffic color must have 4 elements!");
    }

    public void setMapTheme(int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapSetTheme(this.f24032i, m17094b(i));
        }
    }

    public void setBlockInfo(int i, long j, List<LatLng> list, List<OutBlockInfo> list2) {
        int i2;
        DDMapPointArray dDMapPointArray;
        int i3;
        BlockInfoArray blockInfoArray;
        C9186f fVar;
        DDMapPoint dDMapPoint;
        List<LatLng> list3 = list;
        List<OutBlockInfo> list4 = list2;
        BlockInfo blockInfo = null;
        if (list3 != null) {
            int size = list.size();
            dDMapPointArray = new DDMapPointArray(size);
            for (int i4 = 0; i4 < size; i4++) {
                dDMapPointArray.setitem(i4, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(list3.get(i4).longitude, list3.get(i4).latitude)));
            }
            i2 = size;
        } else {
            dDMapPointArray = null;
            i2 = 0;
        }
        if (list4 != null) {
            int size2 = list2.size();
            blockInfoArray = new BlockInfoArray(size2);
            for (int i5 = 0; i5 < list2.size(); i5++) {
                OutBlockInfo outBlockInfo = list4.get(i5);
                BlockInfo blockInfo2 = new BlockInfo();
                blockInfo2.setBlockId(BigInteger.valueOf(outBlockInfo.blockId));
                blockInfo2.setBlockType(BlockType.swigToEnum(outBlockInfo.blockType));
                BlockPoint blockPoint = new BlockPoint();
                blockPoint.setCoorIndex(outBlockInfo.startPoint.coorIndex);
                blockPoint.setLat(outBlockInfo.startPoint.point.latitude);
                blockPoint.setLng(outBlockInfo.startPoint.point.longitude);
                blockPoint.setOffsetPercent(outBlockInfo.startPoint.offsetRate);
                blockPoint.setShapeOffset(outBlockInfo.startPoint.shapeOffset);
                blockInfo2.setStartPoint(blockPoint);
                BlockPoint blockPoint2 = new BlockPoint();
                blockPoint2.setCoorIndex(outBlockInfo.endPoint.coorIndex);
                blockPoint2.setLat(outBlockInfo.endPoint.point.latitude);
                blockPoint2.setLng(outBlockInfo.endPoint.point.longitude);
                blockPoint2.setOffsetPercent(outBlockInfo.endPoint.offsetRate);
                blockPoint2.setShapeOffset(outBlockInfo.endPoint.shapeOffset);
                blockInfo2.setEndPoint(blockPoint2);
                blockInfoArray.setitem(i5, blockInfo2);
            }
            i3 = size2;
            fVar = this;
        } else {
            i3 = 0;
            fVar = this;
            blockInfoArray = null;
        }
        long j2 = fVar.f24033j;
        if (dDMapPointArray == null) {
            dDMapPoint = null;
        } else {
            dDMapPoint = dDMapPointArray.cast();
        }
        if (blockInfoArray != null) {
            blockInfo = blockInfoArray.cast();
        }
        MapEngineJNI.DGLMapProcessBlockInfo(i, j2, j, dDMapPoint, i2, blockInfo, i3);
    }

    public void resetMapPath(int i, String str, String str2, String str3) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapResetPath(this.f24032i, m17087a(i), str2, str, str3);
        }
    }

    /* renamed from: a */
    private static DMapLanguage m17087a(int i) {
        if (i == 0) {
            return DMapLanguage.DMapLanguage_Chinese;
        }
        if (i == 1) {
            return DMapLanguage.DMapLanguage_English;
        }
        if (i == 2) {
            return DMapLanguage.DMapLanguage_TraditionalChinese;
        }
        return DMapLanguage.DMapLanguage_Chinese;
    }

    /* renamed from: b */
    private static DMapTheme m17094b(int i) {
        DMapTheme dMapTheme = DMapTheme.DMapTheme_Default;
        if (i == 0) {
            return DMapTheme.DMapTheme_Default;
        }
        if (i == 1) {
            return DMapTheme.DMapTheme_Bus;
        }
        if (i == 2) {
            return DMapTheme.DMapTheme_Bus_Station;
        }
        if (i != 11) {
            return dMapTheme;
        }
        return DMapTheme.DMapTheme_Self_Drive;
    }

    /* renamed from: c */
    private static DMapTappedETTextAnnoItemType m17096c(int i) {
        if (i == 0) {
            return DMapTappedETTextAnnoItemType.DMapTappedETTextAnnoITNone;
        }
        if (i == 1) {
            return DMapTappedETTextAnnoItemType.DMapTappedETTextAnnoITBusStation;
        }
        if (i != 2) {
            return null;
        }
        return DMapTappedETTextAnnoItemType.DMapTappedETTextAnnoITSubwayStation;
    }

    public void setMaxScaleLevel(int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetMaxScaleLevel(this.f24032i, i);
        }
    }

    public void setMinScaleLevel(int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetMinScaleLevel(this.f24032i, i);
        }
    }

    public void setMapMode(int i) {
        m17088a();
        MapLog.m16917i("MapEngineImpl", "setMapMode:" + i + " mEngineReady:" + this.f24035l);
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetMapMode(this.f24032i, i);
        }
    }

    public void destroy() {
        if (this.f24035l) {
            this.f24035l = false;
            MapEngineJNI.DGLMapDestroy_Wrap(this.f24033j, this.f24032i);
            this.f24032i = 0;
        }
        MapEngineJNI.destroyJNIContext(this.f24033j);
        this.f24034k = false;
        this.f24027d = null;
    }

    public void resume() {
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetNeedsDisplay(this.f24032i, true);
        }
    }

    public void setNeedDisplay() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetNeedsDisplay(this.f24032i, true);
        }
    }

    public void showFishBoneGrayBubbleOnly(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetDisplayFishBoneGrayBubbleOnly(this.f24032i, z);
        }
    }

    public boolean renderFrame() {
        if (this.f24035l) {
            return MapEngineJNI.DGLMapRenderFrameSeconds_Wrap(this.f24032i, this.f24033j);
        }
        return false;
    }

    public void setViewPort(int i, int i2, int i3, int i4) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapSetViewport(this.f24032i, i, i2, i3, i4);
            MapEngineJNI.SetScreenRect(this.f24032i, this.f24033j, i, i2, i3, i4);
        }
    }

    public void SetHWBussThresholdOpen(boolean z, float f) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.setHWBussThresholdOpen(this.f24032i, this.f24033j, z, f);
        }
    }

    public void setViewDPI(float f, float f2, int i, int i2) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapSetScreenSizeAndDPI(this.f24032i, i, i2, f, f2);
        }
    }

    public double getLevelPointPerMeter(float f) {
        m17088a();
        if (!this.f24035l) {
            return 1.0d;
        }
        double[] dArr = new double[1];
        if (MapEngineJNI.DMapGetLevelPointPerMeter(this.f24032i, dArr)) {
            return ((double) f) / dArr[0];
        }
        return 1.0d;
    }

    public boolean tap(int i, int i2, MapEngine.TapItem tapItem) {
        DDMapPoint dDMapPoint;
        m17088a();
        if (!this.f24035l) {
            return false;
        }
        DGLMapTappedElement dGLMapTappedElement = new DGLMapTappedElement();
        MapOverlayMapTappedElement mapOverlayMapTappedElement = new MapOverlayMapTappedElement();
        mapOverlayMapTappedElement.setDglMapTappedElement(dGLMapTappedElement);
        MapEngineJNI.OverlayMapOnTap(this.f24032i, this.f24033j, i, i2, mapOverlayMapTappedElement);
        if (dGLMapTappedElement.getItemId() == null) {
            tapItem.displayId = -1;
        } else {
            tapItem.displayId = (int) JniHelper.castAsLong(dGLMapTappedElement.getItemId());
        }
        tapItem.bubbleId = mapOverlayMapTappedElement.getOverlayId();
        tapItem.name = DataUtil.intArray2String(dGLMapTappedElement.getName());
        if (tapItem.displayId > 0) {
            int DMapMarkerGetPriority = MapEngineJNI.DMapMarkerGetPriority(this.f24032i, tapItem.displayId);
            tapItem.updateZIndex = false;
            tapItem.zIndex = DMapMarkerGetPriority;
        }
        int x = dGLMapTappedElement.getX();
        int y = dGLMapTappedElement.getY();
        if (x * y == 0) {
            dDMapPoint = MapEngineJNI.DGLMapScreenXY2MapPoint(this.f24032i, (float) i, (float) i2);
        } else {
            dDMapPoint = new DDMapPoint();
            dDMapPoint.setX(x);
            dDMapPoint.setY(y);
        }
        DDLocationCoordinate2D DDCoordinateForMapPoint = MapEngineJNI.DDCoordinateForMapPoint(dDMapPoint);
        tapItem.geo.longitude = DDCoordinateForMapPoint.getLongitude();
        tapItem.geo.latitude = DDCoordinateForMapPoint.getLatitude();
        DMapTappedElementType type = dGLMapTappedElement.getType();
        if (type.equals(DMapTappedElementType.kDGLMapTappedNone)) {
            tapItem.type = 0;
            return false;
        }
        if (type.equals(DMapTappedElementType.kDGLMapTappedTextAnnotation)) {
            tapItem.type = 1;
            tapItem.identity = dGLMapTappedElement.getIdentity().longValue();
            tapItem.itemType = dGLMapTappedElement.getItemType();
        } else if (type.equals(DMapTappedElementType.kDGLMapTappedClosureAnnotation)) {
            tapItem.type = 2;
            tapItem.itemType = dGLMapTappedElement.getItemType();
        } else if (type.equals(DMapTappedElementType.kDGLMapTappedCompass)) {
            tapItem.type = 3;
        } else if (type.equals(DMapTappedElementType.kDGLMapTappedOverlayItem)) {
            tapItem.type = 4;
        } else if (type.equals(DMapTappedElementType.kDGLMapTappedLineOverlayItem)) {
            tapItem.type = 5;
        } else if (type.equals(DMapTappedElementType.kDGLMapTappedLocator)) {
            tapItem.type = 6;
        } else if (type.equals(DMapTappedElementType.kDGLMapTappedTrafficEventIconItem)) {
            tapItem.type = 7;
            tapItem.subIndex = dGLMapTappedElement.getSubIndex();
            tapItem.itemType = dGLMapTappedElement.getItemType();
            tapItem.identity = dGLMapTappedElement.getIdentity().longValue();
        } else if (type.equals(DMapTappedElementType.KDGLMapTappedAboardRelationPointItem)) {
            tapItem.type = 9;
            tapItem.poiUrl = DataUtil.shortArray2String(dGLMapTappedElement.getAboardPointUrl());
        } else if (type.equals(DMapTappedElementType.kDGLMapTappedExtendRenderIconItem)) {
            tapItem.type = 10;
            tapItem.itemType = dGLMapTappedElement.getItemType();
            tapItem.identity = dGLMapTappedElement.getIdentity().longValue();
            SWIGTYPE_p_unsigned_char busPbBuffer = dGLMapTappedElement.getBusPbBuffer();
            if (busPbBuffer != null) {
                int busPbBufferLen = dGLMapTappedElement.getBusPbBufferLen();
                DDUINT8_Array frompointer = DDUINT8_Array.frompointer(busPbBuffer);
                byte[] bArr = new byte[busPbBufferLen];
                for (int i3 = 0; i3 < busPbBufferLen; i3++) {
                    bArr[i3] = (byte) (frompointer.getitem(i3) & 255);
                }
                tapItem.outArray = bArr;
            }
            MapEngineJNI.DGLMapReleaseTappedElementBuffer(dGLMapTappedElement);
        } else {
            tapItem.type = 99;
        }
        return true;
    }

    public boolean generateTexture() {
        return this.f24035l && MapEngineJNI.DGLMapGenerateTextures(this.f24032i);
    }

    public void writeMapData(String str, byte[] bArr) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapWriteDownloadData_Wrap(this.f24032i, str, bArr, bArr.length);
        }
    }

    public void cancelMapDataDownloadTask(String str) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapCancelDownloadData_Wrap(this.f24032i, str);
        }
    }

    public void writeMapDynamicLayerData(String str, byte[] bArr) {
        m17088a();
        if (!this.f24035l) {
            return;
        }
        if (bArr != null) {
            MapEngineJNI.DGLMapSetDynamicLayerData_Wrap(this.f24032i, str, bArr, bArr.length);
            return;
        }
        HwDLog.m16764d("________dynamicdebug_____", "data is null", new Object[0]);
        MapEngineJNI.DGLMapSetDynamicLayerData_Wrap(this.f24032i, str, (byte[]) null, 0);
    }

    public void cancelMapDynamicLayerLoadTask(String str) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapCancelDynamicDownloadData(this.f24032i, str);
        }
    }

    public boolean isSupportStreetRoad(String str) {
        m17088a();
        return false;
    }

    public boolean setShowStreetRoad(boolean z) {
        m17088a();
        return false;
    }

    public boolean isSupportTraffic(String str) {
        m17088a();
        return false;
    }

    public void setShowTraffic(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetTrafficEnabled(this.f24032i, z);
        }
    }

    public void setShowDynamicLayer(boolean z) {
        m17088a();
        if (this.f24035l && z) {
            MapEngineJNI.DGLMapSetEnableDynamicLayer(this.f24032i, DMapDynamicLayerType.DMapDynamicLayerTypeRoadClosure.swigValue());
        }
    }

    public void setTrafficColor(int i, int i2, int i3, int i4) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetTrafficColor_Wrap(this.f24032i, i3, i, i2, i4);
        }
    }

    public void setTrafficEventData(byte[] bArr) {
        m17088a();
        if (!this.f24035l) {
            return;
        }
        if (bArr == null) {
            MapEngineJNI.DGLMapClearTrafficEventData_Wrap(this.f24032i);
        } else {
            MapEngineJNI.DGLMapSetTrafficEventData_Wrap(this.f24032i, bArr, bArr.length);
        }
    }

    public void clearTrafficEventData() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapClearTrafficEventData_Wrap(this.f24032i);
        }
    }

    public void hideTrafficEventExcludeClosure(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Congestion, z);
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Accident, z);
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Construction, z);
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Control, z);
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Stagnation, z);
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Police, z);
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Announcement, z);
            MapEngineJNI.DGLMapSetTrafficEventIconHiddenWithType(this.f24032i, DMapTrafficEventType.DMapTrafficEventType_Congestion2, z);
        }
    }

    public void setExtendEventData(byte[] bArr) {
        m17088a();
        if (!this.f24035l) {
            return;
        }
        if (bArr == null || bArr.length == 0) {
            MapEngineJNI.DGLMapClearExtendEventData_Wrap(this.f24032i);
        } else {
            MapEngineJNI.DGLMapSetExtendEventData_Wrap(this.f24032i, bArr, bArr.length);
        }
    }

    public void setExtendIconVisible(long j, boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapRenderExtendIconShow(this.f24032i, BigInteger.valueOf(j), z);
        }
    }

    public void setExtendIconVisible(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetExtendIconVisible_Wrap(this.f24032i, z);
        }
    }

    public int getRenderExtendIconNumber() {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DGLMapGetRenderExtendIcon_Wrap(this.f24032i);
        }
        return 0;
    }

    public void setPoiHidden(int i, LatLng latLng, boolean z) {
        DMapTappedETTextAnnoItemType c;
        m17088a();
        if (this.f24035l && (c = m17096c(i)) != null && latLng != null) {
            MapEngineJNI.DGLMapSetTappedTextAnnotationHidden(this.f24032i, c, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(latLng.longitude, latLng.latitude)), z);
        }
    }

    public void setPoiHidden(BigInteger bigInteger, boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetTappedTextAnnotationHiddenWithID(this.f24032i, bigInteger, z);
        }
    }

    public void showHiddenPoi() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapClearAllTappedTextAnnoationHidden(this.f24032i);
        }
    }

    public void setRestrictAreaVisible(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetRestrictAreaVisible_Wrap(this.f24032i, z);
        }
    }

    public void updateTrafficLocalIcon(TrafficEventModel[] trafficEventModelArr) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapUpdateLocalTrafficIcon_Wrap(this.f24032i, trafficEventModelArr);
        }
    }

    public void updateTrafficItemState(BigInteger bigInteger, short s, boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLUpdateItemShowState(this.f24032i, bigInteger, s, z);
        }
    }

    public TrafficEventRoutePoint[] getTrafficEventRoutePointInfo() {
        return (TrafficEventRoutePoint[]) MapEngineJNI.DGLGetTrafficEventRoutePointInfo_Wrap(this.f24032i);
    }

    public byte[] genVecEnlargePNGImage(byte[] bArr, long j, float f) {
        if (this.f24035l) {
            return MapEngineJNI.DGLMapGenVecEnlargePNGImage_Wrap(this.f24032i, bArr, j, f);
        }
        return null;
    }

    public boolean setVecEnlargeData(String str, byte[] bArr, long j, float f) {
        if (this.f24035l) {
            return MapEngineJNI.DGLMapVecEnlargeAddData_Wrap(this.f24032i, str, bArr, j, f);
        }
        return false;
    }

    public boolean setVecEnlargeIsVisible(String str, boolean z) {
        if (this.f24035l) {
            return MapEngineJNI.DGLMapVecEnlargeIsVisible_Wrap(this.f24032i, str, z);
        }
        return false;
    }

    public boolean destroyNewVecEnlarge(String str) {
        if (this.f24035l) {
            return MapEngineJNI.DGLMapVecEnlargeDestroy(this.f24032i, str);
        }
        return false;
    }

    public void clearTrafficLocalIcons() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLRemoveAllLocalTrafficIcon(this.f24032i);
        }
    }

    public int refreshTrafficData(byte[] bArr, int i, byte[] bArr2, int i2) {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DGLMapSetTrafficData_Wrap(this.f24032i, bArr, i, bArr2, i2);
        }
        return 0;
    }

    public int fetchTrafficBlockData(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DGLMapFetchTrafficBlockData_Wrap(this.f24032i, bArr, i, i2, i3, i4, i5);
        }
        return 0;
    }

    public float[] toScreenLocation(LatLng latLng) {
        m17088a();
        return (!this.f24035l || !MapEngineJNI.LatLng2Screen_Wrap(this.f24032i, latLng.latitude, latLng.longitude, this.f24040q)) ? new float[]{0.0f, 0.0f} : this.f24040q;
    }

    public float[] toScreenLocationUnsafe(LatLng latLng) {
        return (!this.f24035l || !MapEngineJNI.LatLng2Screen_Wrap(this.f24032i, latLng.latitude, latLng.longitude, this.f24041r)) ? new float[]{0.0f, 0.0f} : this.f24041r;
    }

    public LatLng fromScreenLocation(float f, float f2) {
        m17088a();
        if (!this.f24035l || !MapEngineJNI.Screen2LatLng_Wrap(this.f24032i, f, f2, this.f24037n)) {
            return new LatLng(0.0d, 0.0d);
        }
        double[] dArr = this.f24037n;
        return new LatLng(dArr[1], dArr[0]);
    }

    public LatLng fromScreenLocationUnsafe(float f, float f2) {
        if (!this.f24035l || !MapEngineJNI.Screen2LatLng_Wrap(this.f24032i, f, f2, this.f24038o)) {
            return new LatLng(0.0d, 0.0d);
        }
        double[] dArr = this.f24038o;
        return new LatLng(dArr[1], dArr[0]);
    }

    public String getCityName(LatLng latLng) {
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        DDMapPoint DDMapPointForCoordinate = MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(latLng.longitude, latLng.latitude));
        MapEngineJNI.DGLMapGetCityName(this.f24032i, DDMapPointForCoordinate.getX(), DDMapPointForCoordinate.getY(), "", 100);
        return "";
    }

    public double getTargetScale(Rect rect) {
        m17088a();
        return 0.0d;
    }

    public void moveBy(float f, float f2) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapMoveBy_Wrap(this.f24032i, f, f2);
        }
    }

    public void moveTo(LatLng latLng) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetCenterMapPoint_Wrap(this.f24032i, latLng.longitude, latLng.latitude);
        }
    }

    public void setCenterOffset(float f, float f2) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapSetScreenCenterOffset_Wrap(this.f24032i, f, f2);
        }
    }

    public LatLng getCenter() {
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        MapEngineJNI.DGLMapGetCenterMapPoint_Wrap(this.f24032i, this.f24037n);
        double[] dArr = this.f24037n;
        return new LatLng(dArr[1], dArr[0]);
    }

    public void scaleBy(double d) {
        m17088a();
    }

    public void scaleTo(double d) {
        if (Double.isNaN(d)) {
            SystemUtils.log(5, "MapEngineImpl", "scaleTo: scale is NaN", (Throwable) null, "com.didi.hawaii.mapsdkv2.core.MapEngineImpl", 1362);
            return;
        }
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetScale_Wrap(this.f24032i, this.f24033j, d);
        }
    }

    public void setScaleLevel(int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetScaleLevel(this.f24032i, i, false);
        }
    }

    public double getScale() {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DGLMapGetScale(this.f24032i);
        }
        return 0.0d;
    }

    public void rotateBy(float f) {
        m17088a();
    }

    public void rotateTo(float f) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetRotate_Wrap(this.f24032i, this.f24033j, f);
        }
    }

    public float getRotate() {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DGLMapGetRotate(this.f24032i);
        }
        return 0.0f;
    }

    public void skewBy(float f) {
        m17088a();
    }

    public void skewTo(float f) {
        m17088a();
        if (this.f24035l) {
            if (Float.compare(f, 0.2f) < 0) {
                f = 0.0f;
            }
            MapEngineJNI.DGLMapSetSkew_Wrap(this.f24032i, this.f24033j, f);
        }
    }

    public float getSkew() {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DGLMapGetSkew(this.f24032i);
        }
        return 0.0f;
    }

    public void setCompassVisible(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapCompassSetHidden(this.f24032i, !z);
        }
    }

    public void setLocatorVisible(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapMarkerLocatorSetHidden(this.f24032i, !(!z));
        }
    }

    public void showLocatorGuideLine(boolean z, LatLng latLng) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.ShowGuideLine(this.f24032i, this.f24033j, z, latLng.longitude, latLng.latitude);
        }
    }

    public void setLocatorDestination(LatLng latLng) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.SetGuideLineDestination(this.f24032i, this.f24033j, latLng.longitude, latLng.latitude);
        }
    }

    public void setLocatorZIndex(int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapLocatorModiffyZIndex(this.f24032i, i);
        }
    }

    public void setDrawPillarWith2DStyle(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapBuildingSetEffect3D(this.f24032i, !z);
        }
    }

    public int addMarker(double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i, int i2, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, float f8, boolean z7, boolean z8, LatLngBounds latLngBounds, boolean z9) {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DMapAddMarker_Wrap(this.f24032i, d, d2, str, f, f2, f3, f4, f5, f6, i, i2, f7, z, z2, z3, z4, z5, z6, i3, f8, z7, z8, latLngBounds, z9);
        }
        return -1;
    }

    public void updateMarker(int i, double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i2, int i3, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i4, float f8, boolean z7, LatLngBounds latLngBounds, boolean z8) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapMarkerIconModifyInfo_Wrap(this.f24032i, i, d, d2, str, f, f2, f3, f4, f5, f6, i2, i3, f7, z, z2, z3, z4, z5, z6, i4, f8, z7, latLngBounds, z8);
        }
    }

    public void updateBezierCurve(int i, float f) {
        if (m17098e(i)) {
            MapEngineJNI.DGLMapSetBezierCurveAnimationState(this.f24032i, i, f);
        }
    }

    public int drawBezierCurve(double[] dArr, int[] iArr, float f, float f2, float f3) {
        if (this.f24035l) {
            return MapEngineJNI.DGLMapMarkerBezierCurveCreate_Wrap(this.f24032i, dArr, iArr, f, f2, f3);
        }
        return -1;
    }

    public void calculateMarkerScreenBound(int i, float[] fArr) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerGetScreenArea_Wrap(this.f24032i, i, fArr);
        }
    }

    public LatLngBounds calculateMarkerGeoBound(int i) {
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        MapEngineJNI.DMapMarkerGetGeoBound_Wrap(this.f24032i, i, this.f24036m);
        double[] dArr = this.f24036m;
        LatLng latLng = new LatLng(dArr[1], dArr[0]);
        double[] dArr2 = this.f24036m;
        return new LatLngBounds(latLng, new LatLng(dArr2[3], dArr2[2]));
    }

    public void removeMarker(int i) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerDelete(this.f24032i, new int[]{i}, 1);
        }
    }

    public void setMarkerAlpha(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyAlpha_Wrap(this.f24032i, i, f);
        }
    }

    public void setZIndex(int i, int i2) {
        m17090a(i, i2);
    }

    public void setMarkerVisible(int i, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerSetHidden(this.f24032i, new int[]{i}, 1, !z);
        }
    }

    public void setMarkerRotateAngle(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyAngle(this.f24032i, i, f);
        }
    }

    public void setMarkerScale(int i, float f, float f2) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyScale_Wrap(this.f24032i, i, f, f2);
        }
    }

    public void setMarkerOffset(int i, float f, float f2) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyScreenOffset_Wrap(this.f24032i, i, f, f2);
        }
    }

    public void setMarkerPosition(int i, LatLng latLng) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyPosition_Wrap(this.f24032i, i, latLng.latitude, latLng.longitude);
        }
    }

    public LatLng setMarkerScreenPosition(int i, Point point) {
        m17088a();
        if (!m17098e(i)) {
            return null;
        }
        LatLng fromScreenLocation = fromScreenLocation((float) point.x, (float) point.y);
        setMarkerPosition(i, fromScreenLocation);
        return fromScreenLocation;
    }

    public void setMarkerIconAndAnchor(int i, String str, float f, float f2) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyImage(this.f24032i, i, str, MapEngineJNI.DMapVector2fMake(f, f2));
        }
    }

    public void setLocatorInfo(LatLng latLng, float f, float f2, float f3, boolean z, boolean z2) {
        LatLng latLng2 = latLng;
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetLocationInfo_Wrap(this.f24032i, this.f24033j, latLng2.longitude, latLng2.latitude, f, f2, f3, z, z2);
        }
    }

    public void setLocatorInfoWithSkewAndScale(LatLng latLng, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2) {
        LatLng latLng2 = latLng;
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetLocationInfoWithSkewAndScale_Wrap(this.f24032i, this.f24033j, latLng2.longitude, latLng2.latitude, f, f2, f3, f4, f5, z, z2);
        }
    }

    public boolean setMJOLocatorInfo(LatLng latLng, int i, int i2, long j, long j2) {
        LatLng latLng2 = latLng;
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.UpdateMJOLocatorInfo_Wrap(this.f24032i, latLng2.latitude, latLng2.longitude, i, i2, j, j2);
        }
        return false;
    }

    public int getLocatorId() {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.DMapMarkerLocatorGetID_Wrap(this.f24032i);
        }
        return -1;
    }

    public void calculateLocatorScreenBound(int i, float[] fArr) {
        calculateMarkerScreenBound(i, fArr);
    }

    public LatLngBounds calculateLocatorGeoBound(int i) {
        return calculateMarkerGeoBound(i);
    }

    public Camera setLocatorFollow(boolean z, boolean z2, boolean z3, boolean z4) {
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        MapEngineJNI.DGLMapSetLocationFollow(this.f24032i, z, z2, z3, z4);
        MapEngineJNI.DGLMapSetNeedsDisplay(this.f24032i, true);
        return getCamera();
    }

    public void setLocatorCarImage(String str, float f, float f2) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapLocatorModifyIndicatorImage_Wrap(this.f24032i, str, f, f2);
        }
    }

    public void setLocatorCompassImage(String str, String str2, String str3, String str4, String str5, float f, float f2) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapLocatorModifyCompassImage_Wrap(this.f24032i, str, str2, str3, str4, str5, f, f2);
        }
    }

    public void setLocatorCarVisible(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapLocatorSetIndicatorHidden(this.f24032i, !z);
        }
    }

    public void setLocatorCompassVisible(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapLocatorSetCompassHidden(this.f24032i, !z);
        }
    }

    public void setLocatorAccuracyVisible(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapLocatorSetAccuracyAreaHidden(this.f24032i, !z);
        }
    }

    /* renamed from: a */
    private int m17085a(double[] dArr, double[] dArr2, int i, int i2, float f, int i3, float f2, boolean z, DMapPrimitiveType dMapPrimitiveType, double[] dArr3) {
        m17088a();
        if (!this.f24035l) {
            return -1;
        }
        return MapEngineJNI.DMapMarkerRegularPrimitiveCreate_Wrap(this.f24032i, dArr, dArr2, i, f, JniHelper.color4DMapVector4ub(i2), dArr3, i3, f2, z, dMapPrimitiveType);
    }

    /* renamed from: a */
    private void m17092a(int i, double[] dArr, double[] dArr2, int i2, int i3, float f, int i4, float f2, boolean z, DMapPrimitiveType dMapPrimitiveType, double[] dArr3) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapMarkerRegularPrimitiveUpdate_Wrap(this.f24032i, i, dArr, dArr2, i2, f, JniHelper.color4DMapVector4ub(i3), dArr3, i4, f2, z, dMapPrimitiveType);
        }
    }

    /* renamed from: a */
    private void m17091a(int i, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerSetHidden(this.f24032i, new int[]{i}, 1, !z);
        }
    }

    /* renamed from: a */
    private void m17089a(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyAlpha_Wrap(this.f24032i, i, f);
        }
    }

    /* renamed from: a */
    private void m17090a(int i, int i2) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerSetPriority(this.f24032i, i, i2);
        }
    }

    /* renamed from: d */
    private void m17097d(int i) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerDelete(this.f24032i, new int[]{i}, 1);
        }
    }

    public int addPolyline(LatLng[] latLngArr, int i, float f, int i2, float f2, boolean z, boolean z2) {
        LatLng[] latLngArr2 = latLngArr;
        int length = latLngArr2.length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        for (int i3 = 0; i3 < length; i3++) {
            dArr[i3] = latLngArr2[i3].latitude;
            dArr2[i3] = latLngArr2[i3].longitude;
        }
        return MapEngineJNI.DMapNewPolygonCreate_Wrap(this.f24032i, dArr, dArr2, length, z2, JniHelper.color4DMapVector4ub(i), i2, ((float) Color.alpha(i)) / 255.0f, z, f, DMapPrimitiveType.DMapPrimitiveType_Line);
    }

    public void setPolylineArrowTextureName(int i, String str) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetArrowTextureName(this.f24032i, i, str);
        }
    }

    public void setPolylineVisible(int i, boolean z) {
        m17091a(i, z);
    }

    public void setPolylineAlpha(int i, float f) {
        m17089a(i, f);
    }

    public void setPolylineColor(int i, int i2) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyColor(this.f24032i, i, JniHelper.colorDMapVector4f(i2));
        }
    }

    public void setPolylinePoints(int i, LatLng[] latLngArr) {
        m17088a();
        if (m17098e(i)) {
            int length = latLngArr.length;
            double[] dArr = new double[length];
            double[] dArr2 = new double[length];
            for (int i2 = 0; i2 < length; i2++) {
                dArr[i2] = latLngArr[i2].latitude;
                dArr2[i2] = latLngArr[i2].longitude;
            }
            MapEngineJNI.DMapPolylineModifyPoints_Wrap(this.f24032i, i, dArr, dArr2, length);
        }
    }

    public void setBellowRoute(int i, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerSetRenderOrder(this.f24032i, i, z ? DMarkerRenderOrder.DMarkerRenderOrder_BelowRoute : DMarkerRenderOrder.DMarkerRenderOrder_Default);
        }
    }

    public void setPolylineWidth(int i, float f) {
        m17088a();
        m17098e(i);
    }

    public void removePolyline(int i) {
        m17097d(i);
    }

    public int addPolygon(LatLng[] latLngArr, int i, int i2, float f, boolean z, boolean z2) {
        LatLng[] latLngArr2 = latLngArr;
        int length = latLngArr2.length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        for (int i3 = 0; i3 < length; i3++) {
            dArr[i3] = latLngArr2[i3].latitude;
            dArr2[i3] = latLngArr2[i3].longitude;
        }
        return MapEngineJNI.DMapNewPolygonCreate_Wrap(this.f24032i, dArr, dArr2, length, z2, JniHelper.color4DMapVector4ub(i), i2, f, z, 0.0f, DMapPrimitiveType.DMapPrimitiveType_Polygon);
    }

    public void updatePolygon(int i, LatLng[] latLngArr, int i2, int i3, float f, boolean z) {
        LatLng[] latLngArr2 = latLngArr;
        int length = latLngArr2.length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        for (int i4 = 0; i4 < length; i4++) {
            dArr[i4] = latLngArr2[i4].latitude;
            dArr2[i4] = latLngArr2[i4].longitude;
        }
        m17092a(i, dArr, dArr2, length, i2, 0.0f, i3, f, z, DMapPrimitiveType.DMapPrimitiveType_Polygon, new double[2]);
    }

    public void updatePolyline(int i, LatLng[] latLngArr, int i2, float f, int i3, float f2, boolean z) {
        LatLng[] latLngArr2 = latLngArr;
        int length = latLngArr2.length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        for (int i4 = 0; i4 < length; i4++) {
            dArr[i4] = latLngArr2[i4].latitude;
            dArr2[i4] = latLngArr2[i4].longitude;
        }
        m17092a(i, dArr, dArr2, length, i2, f, i3, f2, z, DMapPrimitiveType.DMapPrimitiveType_Line, new double[2]);
    }

    public void setPolygonVisible(int i, boolean z) {
        m17091a(i, z);
    }

    public void setPolygonAlpha(int i, float f) {
        m17089a(i, f);
    }

    public void setPolygonColor(int i, int i2) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyColor(this.f24032i, i, JniHelper.colorDMapVector4f(i2));
        }
    }

    public void removePolygon(int i) {
        m17097d(i);
    }

    public int addCircle(LatLng latLng, float f, int i, int i2, boolean z, boolean z2, float f2, boolean z3) {
        DMapPrimitiveType dMapPrimitiveType;
        LatLng latLng2 = latLng;
        m17088a();
        if (!this.f24035l) {
            return -1;
        }
        short[] color4DMapVector4ub = JniHelper.color4DMapVector4ub(i);
        long j = this.f24032i;
        double d = latLng2.latitude;
        double d2 = latLng2.longitude;
        float alpha = ((float) Color.alpha(i)) / 255.0f;
        if (z2) {
            dMapPrimitiveType = DMapPrimitiveType.DMapPrimitiveType_LineLoop;
        } else {
            dMapPrimitiveType = DMapPrimitiveType.DMapPrimitiveType_CircleOverPolygon;
        }
        return MapEngineJNI.DMapCircleCreate_Wrap(j, d, d2, f, 128, color4DMapVector4ub, i2, alpha, z, f2, dMapPrimitiveType, z3);
    }

    public void updateCircle(int i, LatLng latLng, float f, int i2, int i3, boolean z, boolean z2, float f2) {
        DMapPrimitiveType dMapPrimitiveType;
        LatLng latLng2 = latLng;
        m17088a();
        if (this.f24035l) {
            short[] color4DMapVector4ub = JniHelper.color4DMapVector4ub(i2);
            long j = this.f24032i;
            double d = latLng2.latitude;
            double d2 = latLng2.longitude;
            float alpha = ((float) Color.alpha(i2)) / 255.0f;
            if (z2) {
                dMapPrimitiveType = DMapPrimitiveType.DMapPrimitiveType_LineLoop;
            } else {
                dMapPrimitiveType = DMapPrimitiveType.DMapPrimitiveType_CircleOverPolygon;
            }
            MapEngineJNI.DMapCircleModify_Wrap(j, i, d, d2, f, 128, color4DMapVector4ub, i3, alpha, z, f2, dMapPrimitiveType);
        }
    }

    public void setCircleVisible(int i, boolean z) {
        m17091a(i, z);
    }

    public void setCircleColor(int i, int i2) {
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyColor(this.f24032i, i, JniHelper.colorDMapVector4f(i2));
        }
    }

    public void setCircleCenter(int i, LatLng latLng) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyPosition_Wrap(this.f24032i, i, latLng.latitude, latLng.longitude);
        }
    }

    public void setCircleScale(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyScale_Wrap(this.f24032i, i, f, f);
        }
    }

    public void removeCircle(int i) {
        if (m17098e(i)) {
            m17097d(i);
        }
    }

    public int addRoute(LatLng[] latLngArr, int[] iArr, int[] iArr2, String str, float f, int i, float f2, boolean z, boolean z2, int i2, long j, boolean z3, HWBSRAManager hWBSRAManager, boolean z4) {
        m17088a();
        if (!this.f24035l) {
            return -1;
        }
        return MapEngineJNI.AddRoute_Wrap(this.f24032i, this.f24033j, latLngArr, iArr2, iArr, str, f, i, f2, z, z2, i2, j, z3, hWBSRAManager == null ? -1 : JniHelper.getRouteAnimateManagerPtr(hWBSRAManager), z4);
    }

    public void setRoutePercent(int i, String str, float f, HWBSRAManager hWBSRAManager) {
        long j;
        m17088a();
        if (m17098e(i)) {
            long j2 = this.f24032i;
            if (hWBSRAManager == null) {
                j = -1;
            } else {
                j = JniHelper.getRouteAnimateManagerPtr(hWBSRAManager);
            }
            MapEngineJNI.SetRoutePercent_Wrap(i, j2, str, f, j);
        }
    }

    public void setRoutePercent(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetAnimationColorLineScanProgress(this.f24032i, i, (double) f);
        }
    }

    public void setRoutePulseTexture(int i, String str) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetAnimationColorLineScanTextureName(this.f24032i, i, str);
        }
    }

    public void setRoutePulseCustomColor(int i, int i2) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetAnimationColorLineScanMixColor_Wrap(this.f24032i, i, JniHelper.color4DMapVector4ub(i2));
        }
    }

    public void setRoutePoints(int i, LatLng[] latLngArr, int[] iArr, int[] iArr2, String str) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.SetRoutePoints_Wrap(i, this.f24032i, latLngArr, iArr2, iArr, str);
        }
    }

    public void setRouteTexture(int i, String str) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.SetRouteTexture_Wrap(i, this.f24032i, str);
        }
    }

    public void setRouteAlpha(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetAlpha(this.f24032i, i, f);
        }
    }

    public void setRouteVisible(int i, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerSetHidden(this.f24032i, new int[]{i}, 1, !z);
        }
    }

    public void setRouteWidth(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteModifyWidth_Wrap(this.f24032i, i, f);
        }
    }

    public void setRouteDrawCap(int i, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetDrawCap(this.f24032i, i, z);
        }
    }

    public void setRouteArrow(int i, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetDrawArrow(this.f24032i, i, z);
        }
    }

    public void setRouteClearPointErase(int i, int i2, LatLng latLng, long j, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetClearPoint_Wrap(this.f24032i, i, i2, latLng.latitude, latLng.longitude);
            if (j != 0) {
                MapEngineJNI.DGLMapSetRouteNameClearPoint_Wrap(this.f24032i, this.f24033j, j, i2, z);
            }
        }
    }

    public void setRouteClearPointGrey(int i, int i2, LatLng latLng, long j, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetPassedPoint_Wrap(this.f24032i, i, i2, latLng.latitude, latLng.longitude);
            if (j != 0) {
                MapEngineJNI.DGLMapSetRouteNameClearPoint_Wrap(this.f24032i, this.f24033j, j, i2, z);
            }
        }
    }

    public void setRouteTurnArrow(int i, int i2, int i3, int i4) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetTurnArrowIndex2(this.f24032i, i2, i3, DMapRouteArrowType.swigToEnum(i4));
        }
    }

    public void setRouteTurnArrow(int i, int i2, int i3, int i4, int i5) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteSetTurnArrowIndex3(this.f24032i, i2, i3, i4, DMapRouteArrowType.swigToEnum(i5));
        }
    }

    public void setRouteColors(int i, int[] iArr, int[] iArr2) {
        m17088a();
        m17098e(i);
    }

    public void setRouteNameKey(int i, long j, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.SetRouteNaviRouteId_Wrap(i, this.f24032i, j, z);
        }
    }

    public void addRouteNames(int i, long j, RouteName[] routeNameArr, LatLng[] latLngArr, boolean z) {
        m17088a();
        if (!m17098e(i)) {
            return;
        }
        if (this.f24024a) {
            MapEngineJNI.AddRouteNames_Wrap(this.f24032i, this.f24033j, i, j, routeNameArr, latLngArr, z);
        } else {
            MapEngineJNI.AddRouteNames_WrapOld(this.f24032i, i, j, routeNameArr, latLngArr, z);
        }
    }

    public void clearRouteNames(long j) {
        m17088a();
        if (!this.f24035l) {
            return;
        }
        if (this.f24024a) {
            MapEngineJNI.DeleteRouteNameSegment_Wrap(this.f24032i, this.f24033j, j);
        } else {
            MapEngineJNI.DGLMapDeleteRouteNameSegments(this.f24032i, j);
        }
    }

    public void addMultipleRouteNames(long j, RouteName[] routeNameArr, LatLng[] latLngArr, int i, int i2, String str, String str2, int i3, int i4) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.AddMultipleRouteNames_Wrap(this.f24032i, 0, j, routeNameArr, latLngArr, i, i2, str, MapSerializeUtil.stringToBytes(str2), i3, i4);
        }
    }

    public void addSpecialBubble(RouteName[] routeNameArr, LatLng[] latLngArr, long j, int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.AddSpecialBubble_Wrap(this.f24032i, routeNameArr, latLngArr, j, i);
        }
    }

    public void updateSpecialBubble(RouteName[] routeNameArr, long j) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.UpdateSpecialBubble_Wrap(this.f24032i, routeNameArr, j);
        }
    }

    public void removeSpecialBubble(long j) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.RemoveSpecialBubble_Wrap(this.f24032i, j);
        }
    }

    public void deleteSpecialBubbleWithType(int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DeleteSpecialBubbleWithType_Wrap(this.f24032i, i);
        }
    }

    public void addBubble(long j, int i, int i2, double d, double d2, float f, float f2, int i3, int i4, float f3, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, float f4, boolean z5, boolean z6, boolean z7, String str, List<Bubble.OverlayRect> list, Bubble.PointArea pointArea, Bubble.TrafficIconAttrs trafficIconAttrs, AnimationSetting animationSetting) {
        Bubble.PointArea pointArea2 = pointArea;
        Bubble.TrafficIconAttrs trafficIconAttrs2 = trafficIconAttrs;
        AnimationSetting animationSetting2 = animationSetting;
        m17088a();
        if (this.f24035l) {
            MapOverlay mapOverlay = new MapOverlay();
            mapOverlay.setOverlayId(j);
            mapOverlay.setType(i);
            mapOverlay.setCollisionType(i2);
            mapOverlay.setLongitude(d);
            mapOverlay.setLatitude(d2);
            mapOverlay.setScaleX(f);
            mapOverlay.setScaleY(f2);
            mapOverlay.setFixPosX(i3);
            mapOverlay.setFixPosY(i4);
            mapOverlay.setAngle(f3);
            mapOverlay.setIsClockwise(z);
            mapOverlay.setIsFastLoad(z2);
            mapOverlay.setIsAvoidAnno(z3);
            mapOverlay.setIsOrthographicProject(z4);
            mapOverlay.setZIndex(i5);
            mapOverlay.setAlpha(f4);
            mapOverlay.setVisible(true);
            mapOverlay.setIsVirtualOverlay(z6);
            mapOverlay.setSelectBottomRectWhenColliedLocator(z7);
            mapOverlay.setPriority(i6);
            mapOverlay.setShowInfo(str);
            mapOverlay.setRectCnt(list.size());
            MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                Bubble.OverlayRect overlayRect = list.get(i7);
                MapOverlayRect mapOverlayRect = new MapOverlayRect();
                mapOverlayRect.setAnchorX(overlayRect.anchorX);
                mapOverlayRect.setAnchorY(overlayRect.anchorY);
                mapOverlayRect.setWidth(overlayRect.width);
                mapOverlayRect.setHeight(overlayRect.height);
                mapOverlayRect.setName(overlayRect.resourcePaths.getResourcePaths() + overlayRect.index);
                if (overlayRect.paddingCollision != null) {
                    mapOverlayRect.setPaddingLeft(overlayRect.paddingCollision.left);
                    mapOverlayRect.setPaddingTop(overlayRect.paddingCollision.top);
                    mapOverlayRect.setPaddingRight(overlayRect.paddingCollision.right);
                    mapOverlayRect.setPaddingBottom(overlayRect.paddingCollision.bottom);
                }
                mapOverlayRectArray.setitem(i7, mapOverlayRect);
            }
            mapOverlay.setRects(mapOverlayRectArray.cast());
            if (!(pointArea2 == null || pointArea2.points == null)) {
                MapPointArea mapPointArea = new MapPointArea();
                int size2 = pointArea2.points.size();
                DDMapPointArray dDMapPointArray = new DDMapPointArray(size2);
                for (int i8 = 0; i8 < size2; i8++) {
                    dDMapPointArray.setitem(i8, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(pointArea2.points.get(i8).longitude, pointArea2.points.get(i8).latitude)));
                }
                mapPointArea.setMapPoint(dDMapPointArray.cast());
                mapPointArea.setMapPointCount(size2);
                mapPointArea.setRouteID(pointArea2.routeID);
                MapPointSectionArray mapPointSectionArray = new MapPointSectionArray(32);
                for (int i9 = 0; i9 < pointArea2.sectionCount; i9++) {
                    MapPointSection mapPointSection = new MapPointSection();
                    mapPointSection.setStartNum(pointArea2.startNums[i9]);
                    mapPointSection.setEndNum(pointArea2.endNums[i9]);
                    mapPointSectionArray.setitem(i9, mapPointSection);
                }
                mapPointArea.setSections(mapPointSectionArray.cast());
                mapPointArea.setSectionCount(pointArea2.sectionCount);
                mapOverlay.setPointArea(mapPointArea);
            }
            if (animationSetting2 != null) {
                MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs = new MapVisibleChangeAnimateAttrs();
                mapVisibleChangeAnimateAttrs.setNeedAnimate(animationSetting2.needAnimation);
                mapVisibleChangeAnimateAttrs.setDuration((int) animationSetting2.duration);
                int i10 = animationSetting2.type;
                if (i10 == 0) {
                    mapVisibleChangeAnimateAttrs.setAnimationType(DiAnimationType.DiAlpha);
                } else if (i10 != 1) {
                    mapVisibleChangeAnimateAttrs.setAnimationType(DiAnimationType.DiAlpha);
                } else {
                    mapVisibleChangeAnimateAttrs.setAnimationType(DiAnimationType.DiScale);
                }
                int i11 = animationSetting2.interpolatorType;
                if (i11 == 0) {
                    mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiLinear);
                } else if (i11 == 1) {
                    mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiDecelerate);
                } else if (i11 == 2) {
                    mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiFastOutSlow);
                } else if (i11 != 3) {
                    mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiLinear);
                } else {
                    mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiLinearOutSlow);
                }
                mapOverlay.setVisibleChangeAnimateAttrs(mapVisibleChangeAnimateAttrs);
            }
            if (trafficIconAttrs2 != null) {
                if (!trafficIconAttrs2.isHintIcon || trafficIconAttrs2.showBarn == null) {
                    MapTrafficIconAttrs mapTrafficIconAttrs = new MapTrafficIconAttrs();
                    mapTrafficIconAttrs.setFake(trafficIconAttrs2.isFake);
                    mapTrafficIconAttrs.setRouteID(trafficIconAttrs2.routeId);
                    mapOverlay.setTrafficIconAttrs(mapTrafficIconAttrs);
                } else {
                    DMapVector2d dMapVector2d = r1;
                    DMapVector2d dMapVector2d2 = new DMapVector2d();
                    dMapVector2d2.setX((double) trafficIconAttrs2.showBarn.topCenter.x);
                    dMapVector2d2.setY((double) trafficIconAttrs2.showBarn.topCenter.y);
                    DMapVector2d dMapVector2d3 = r1;
                    DMapVector2d dMapVector2d4 = new DMapVector2d();
                    dMapVector2d4.setX((double) trafficIconAttrs2.showBarn.bottomCenter.x);
                    dMapVector2d4.setY((double) trafficIconAttrs2.showBarn.bottomCenter.y);
                    DMapVector2d dMapVector2d5 = r1;
                    DMapVector2d dMapVector2d6 = new DMapVector2d();
                    dMapVector2d6.setX((double) trafficIconAttrs2.showBarn.leftTop.x);
                    dMapVector2d6.setY((double) trafficIconAttrs2.showBarn.leftTop.y);
                    DMapVector2d dMapVector2d7 = r1;
                    DMapVector2d dMapVector2d8 = new DMapVector2d();
                    dMapVector2d8.setX((double) trafficIconAttrs2.showBarn.rightBottom.x);
                    dMapVector2d8.setY((double) trafficIconAttrs2.showBarn.rightBottom.y);
                    DMapVector2d dMapVector2d9 = r1;
                    DMapVector2d dMapVector2d10 = new DMapVector2d();
                    dMapVector2d10.setX((double) trafficIconAttrs2.showBarn.targetCenter.x);
                    dMapVector2d10.setY((double) trafficIconAttrs2.showBarn.targetCenter.y);
                    MapEngineJNI.setHWBussBarn(this.f24032i, this.f24033j, dMapVector2d, (double) trafficIconAttrs2.showBarn.topRadius, (double) trafficIconAttrs2.showBarn.topCutlineY, dMapVector2d3, (double) trafficIconAttrs2.showBarn.bottomRadius, (double) trafficIconAttrs2.showBarn.bottomCutLine, dMapVector2d5, dMapVector2d7, dMapVector2d9);
                    MapEngineJNI.addRemoteIconBindOverlay(this.f24032i, this.f24033j, mapOverlay, trafficIconAttrs2.bindId);
                    return;
                }
            }
            MapEngineJNI.AddMapOverlay_Wrap(this.f24032i, this.f24033j, mapOverlay);
        }
    }

    public void removeBubble(long j) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.RemoveMapOverlay_Wrap(this.f24032i, this.f24033j, j);
        }
    }

    public void removeRemoteBubble(long j) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.removeRemoteIcon(this.f24032i, this.f24033j, j);
        }
    }

    public void updateRemoteIconBindId(long j, long j2) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.changeRemoteIconBindOverlay(this.f24032i, this.f24033j, j, j2);
        }
    }

    public void updateBubble(long j, int i, int i2, double d, double d2, float f, float f2, int i3, int i4, float f3, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, float f4, boolean z5, boolean z6, boolean z7, String str, List<Bubble.OverlayRect> list, Bubble.PointArea pointArea) {
        Bubble.PointArea pointArea2 = pointArea;
        m17088a();
        if (this.f24035l) {
            MapOverlay mapOverlay = new MapOverlay();
            mapOverlay.setOverlayId(j);
            mapOverlay.setType(i);
            mapOverlay.setCollisionType(i2);
            mapOverlay.setLongitude(d);
            mapOverlay.setLatitude(d2);
            mapOverlay.setScaleX(f);
            mapOverlay.setScaleY(f2);
            mapOverlay.setFixPosX(i3);
            mapOverlay.setFixPosY(i4);
            mapOverlay.setAngle(f3);
            mapOverlay.setIsClockwise(z);
            mapOverlay.setIsFastLoad(z2);
            mapOverlay.setIsAvoidAnno(z3);
            mapOverlay.setIsOrthographicProject(z4);
            mapOverlay.setZIndex(i5);
            mapOverlay.setAlpha(f4);
            mapOverlay.setVisible(true);
            mapOverlay.setIsVirtualOverlay(z6);
            mapOverlay.setSelectBottomRectWhenColliedLocator(z7);
            mapOverlay.setPriority(i6);
            mapOverlay.setShowInfo(str);
            mapOverlay.setRectCnt(list.size());
            MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                Bubble.OverlayRect overlayRect = list.get(i7);
                MapOverlayRect mapOverlayRect = new MapOverlayRect();
                mapOverlayRect.setAnchorX(overlayRect.anchorX);
                mapOverlayRect.setAnchorY(overlayRect.anchorY);
                mapOverlayRect.setWidth(overlayRect.width);
                mapOverlayRect.setHeight(overlayRect.height);
                mapOverlayRect.setName(overlayRect.resourcePaths.getResourcePaths() + overlayRect.index);
                if (overlayRect.paddingCollision != null) {
                    mapOverlayRect.setPaddingLeft(overlayRect.paddingCollision.left);
                    mapOverlayRect.setPaddingTop(overlayRect.paddingCollision.top);
                    mapOverlayRect.setPaddingRight(overlayRect.paddingCollision.right);
                    mapOverlayRect.setPaddingBottom(overlayRect.paddingCollision.bottom);
                }
                mapOverlayRectArray.setitem(i7, mapOverlayRect);
            }
            mapOverlay.setRects(mapOverlayRectArray.cast());
            if (!(pointArea2 == null || pointArea2.points == null)) {
                MapEngineJNI.UpdateMapOverlayPointArea_Wrap(this.f24032i, this.f24033j, j, new double[0], new double[0], 0, pointArea2.startNums, pointArea2.endNums, pointArea2.sectionCount);
            }
            MapEngineJNI.UpdateMapOverlay_Wrap(this.f24032i, this.f24033j, mapOverlay);
        }
    }

    public void handleBubbleCollision() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.MapOverlayHandleCollision(this.f24032i, this.f24033j);
        }
    }

    public void removeRoute(int i) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapRouteDelete(this.f24032i, i);
        }
    }

    public LatLng calculateRoute3DArrowFurthestPoint() {
        m17088a();
        if (!this.f24035l) {
            return new LatLng(-1.0d, -1.0d);
        }
        MapEngineJNI.DGLMapGetRouteArrowFurthestPt_Wrap(this.f24032i, this.f24037n);
        double[] dArr = this.f24037n;
        return new LatLng(dArr[1], dArr[0]);
    }

    public LatLng calculateRoute3DArrowFurthestPointUnsafe() {
        if (!this.f24035l) {
            return new LatLng(-1.0d, -1.0d);
        }
        MapEngineJNI.DGLMapGetRouteArrowFurthestPt_Wrap(this.f24032i, this.f24037n);
        double[] dArr = this.f24037n;
        return new LatLng(dArr[1], dArr[0]);
    }

    public void getMapRouteTrueClearPoint_Wrap(int i, LatLng latLng) {
        if (this.f24035l && MapEngineJNI.DGLMapRouteTrueClearPoint_Wrap(this.f24032i, i, this.f24037n) == 1) {
            latLng.latitude = this.f24037n[1];
            latLng.longitude = this.f24037n[0];
        }
    }

    public Bitmap screenShot(int i, int i2, Bitmap.Config config) {
        C9186f fVar;
        Bitmap.Config config2;
        int i3 = i;
        int i4 = i2;
        m17088a();
        if (config == null) {
            fVar = this;
            config2 = Bitmap.Config.ARGB_8888;
        } else {
            fVar = this;
            config2 = config;
        }
        if (!fVar.f24035l) {
            return null;
        }
        int i5 = i3 * i4;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i5 * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, allocateDirect);
        int[] iArr = new int[i5];
        allocateDirect.asIntBuffer().get(iArr);
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = (iArr[i6] & -16711936) | ((iArr[i6] & 255) << 16) | ((iArr[i6] & 16711680) >> 16);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config2);
        createBitmap.setPixels(iArr, i5 - i3, -i3, 0, 0, i, i2);
        return createBitmap;
    }

    public void showTrafficEvent(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLShowTrafficEvent(this.f24032i, z);
        }
    }

    public void setZhongYanEventData(byte[] bArr, long j) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapSetZhongYanEventData_Wrap(this.f24032i, bArr, j);
        }
    }

    public void setUseLowMemoryMode(boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapSetLowMemoryMode(this.f24032i, z);
        }
    }

    public void hibernate() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DMapHibernate(this.f24032i);
        }
    }

    public float calculateScaleRuler(int i) {
        m17088a();
        if (!this.f24035l) {
            return 0.0f;
        }
        MapEngineJNI.CaculateScaleRuler(this.f24032i, i, this.f24039p);
        double[] dArr = this.f24039p;
        return (float) TransformUtil.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public String getTrafficUpdateUrl() {
        return MapEngineJNI.DGLMapGetRouteUrl(this.f24032i);
    }

    public int addMaskLayer(int i, int i2, int i3, int i4) {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.AddMaskLayer_Wrap(this.f24032i, Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i), i2, i3, i4);
        }
        return 0;
    }

    public void setMaskLayerVisible(int i, boolean z) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerSetHidden(this.f24032i, new int[]{i}, 1, !z);
        }
    }

    public void setMaskLayerAlpha(int i, float f) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerModifyAlpha_Wrap(this.f24032i, i, f);
        }
    }

    public void setMaskLayerWidthHeightColor(int i, int i2, int i3, int i4) {
        if (m17098e(i)) {
            MapEngineJNI.SetMaskLayerWidthHeightColor_Wrap(this.f24032i, i, Color.red(i4), Color.green(i4), Color.blue(i4), Color.alpha(i4), i2, i3);
        }
    }

    public void removeMaskLayer(int i) {
        m17088a();
        if (m17098e(i)) {
            MapEngineJNI.DMapMarkerDelete(this.f24032i, new int[]{i}, 1);
        }
    }

    public int addTile(MapCanvas.TileCallback tileCallback) {
        m17088a();
        if (!this.f24035l) {
            return 0;
        }
        this.f24026c = tileCallback;
        return MapEngineJNI.DGLMapAddTileOverlay_Wrap(this.f24032i, this.f24033j);
    }

    public void removeTile(int i) {
        if (m17098e(i)) {
            this.f24026c = null;
            MapEngineJNI.DGLMapRemoveTileOverlay(this.f24032i, i);
            MapEngineJNI.DGLMapSetNeedsDisplay(this.f24032i, true);
        }
    }

    public void reloadTile(int i) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapReloadTileOverlay(this.f24032i, i);
        }
    }

    public Camera getCamera() {
        m17088a();
        LatLng center = getCenter();
        if (!this.f24035l || center == null) {
            return null;
        }
        return new Camera(center, (float) getScale(), getRotate(), getSkew());
    }

    public Camera zoomToSpan(RectF rectF, Rect rect) {
        Camera camera;
        RectF rectF2 = rectF;
        Rect rect2 = rect;
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        float scale = (float) getScale();
        LatLng center = getCenter();
        float rotate = getRotate();
        float skew = getSkew();
        rotateTo(0.0f);
        skewTo(0.0f);
        if (MapEngineJNI.DMapZoomToSpan_Wrap(this.f24032i, rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, rect2.left, rect2.top, rect2.right, rect2.bottom)) {
            float scale2 = (float) getScale();
            LatLng center2 = getCenter();
            camera = center2 != null ? new Camera(center2, scale2, 0.0f, 0.0f) : null;
        } else {
            camera = new Camera(center, scale, rotate, scale);
        }
        scaleTo((double) scale);
        moveTo(center);
        rotateTo(rotate);
        skewTo(skew);
        return camera;
    }

    public Camera zoomToSpan4CenterOffset2(RectF rectF, Rect rect, float f, float f2, float f3, float f4, int i, int i2) {
        Camera camera;
        RectF rectF2 = rectF;
        Rect rect2 = rect;
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        float scale = (float) getScale();
        LatLng center = getCenter();
        float rotate = getRotate();
        float skew = getSkew();
        rotateTo(0.0f);
        skewTo(0.0f);
        float f5 = f3 - 0.5f;
        boolean z = ((double) Math.abs(f5)) > 1.0E-4d || ((double) Math.abs(f4 - 0.5f)) > 1.0E-4d;
        if (z) {
            setCenterOffset(0.0f, 0.0f);
        }
        float f6 = f5;
        if (MapEngineJNI.DMapZoomToSpan_Wrap(this.f24032i, rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, rect2.left, rect2.top, rect2.right, rect2.bottom)) {
            MapEngineJNI.Screen2LatLng_Wrap(this.f24032i, ((float) i) * f, ((float) i2) * f2, this.f24037n);
            double[] dArr = this.f24037n;
            camera = new Camera(new LatLng(dArr[1], dArr[0]), (float) getScale(), 0.0f, 0.0f);
        } else {
            camera = new Camera(center, scale, rotate, scale);
        }
        scaleTo((double) scale);
        moveTo(center);
        rotateTo(rotate);
        skewTo(skew);
        if (z) {
            setCenterOffset(f6, f4 - 0.5f);
        }
        return camera;
    }

    public Camera zoomToSpan4CenterOffset(RectF rectF, Rect rect, float f, float f2, int i, int i2) {
        RectF rectF2 = rectF;
        Rect rect2 = rect;
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        double[] dArr = new double[3];
        MapEngineJNI.ZoomToSpan4Offset_Wrap(this.f24032i, rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, rect2.left, rect2.top, rect2.right, rect2.bottom, f, f2, i, i2, dArr);
        return new Camera(new LatLng(dArr[1], dArr[0]), (float) dArr[2], 0.0f, 0.0f);
    }

    public float zoomForNavigation(LatLng latLng) {
        m17088a();
        if (!this.f24035l) {
            return 0.0f;
        }
        MapEngineJNI.DMapZoomForNavigation_Wrap(this.f24032i, latLng.latitude, latLng.longitude);
        return (float) MathsUtils.getScaleLevel(getScale());
    }

    public PointF calculateTargetOffset(LatLng latLng, Camera camera, int i, int i2) {
        m17088a();
        if (!this.f24035l) {
            return null;
        }
        LatLng center = getCenter();
        float rotate = getRotate();
        float skew = getSkew();
        rotateTo(camera.getRotate());
        skewTo(camera.getSkew());
        scaleTo((double) camera.getScale());
        moveTo(camera.getCenter());
        MapEngineJNI.LatLng2Screen_Wrap(this.f24032i, latLng.latitude, latLng.longitude, this.f24040q);
        float[] fArr = this.f24040q;
        float f = fArr[0] / ((float) i);
        float f2 = fArr[1] / ((float) i2);
        scaleTo((double) ((float) getScale()));
        moveTo(center);
        rotateTo(rotate);
        skewTo(skew);
        return new PointF(f, f2);
    }

    public void setEdgePaddingOffset(float f, float f2, float f3, float f4) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetEdgePaddingOffset(this.f24032i, f2, f, f4, f3);
        }
    }

    public void setBubbleEdgePaddingTop(float f) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.set3dPaddingTopOffset(this.f24032i, this.f24033j, f);
        }
    }

    public void setMapPadding(Rect rect) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetFlagOfZoomToSpanForLocation_Wrap(this.f24032i, (float) rect.top, (float) rect.left, (float) rect.bottom, (float) rect.right, 15, 21);
        }
    }

    public void setNavigationLineMargin(float f, float f2, float f3, float f4) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapSetEdgePaddingForRoute(this.f24032i, f, f2, f3, f4);
        }
    }

    public void setRouteNameVisible(boolean z) {
        m17088a();
        if (!this.f24035l) {
            return;
        }
        if (this.f24024a) {
            MapEngineJNI.DGLMapSetRouteNameVisible_Wrap(this.f24032i, this.f24033j, z);
        } else {
            MapEngineJNI.DGLMapSetRouteNameVisiable(this.f24032i, z);
        }
    }

    public void setRenderThread(Thread thread) {
        this.f24025b = thread;
    }

    public void setClipArea(int i, int i2, int i3) {
        m17088a();
        if (this.f24035l) {
            HWLog.m16761i("hwmap", "clipHeight=" + i + ", screenWidth=" + i2 + ", screenHeight=" + i3);
            MapEngineJNI.DMapSetVisibleScreenArea_Wrap(this.f24032i, i, i2, i3);
        }
    }

    public void clearRouteNameSegments() {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapClearRouteNameSegments(this.f24032i);
        }
    }

    public void removeRouteName(long j) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.DGLMapDeleteRouteNameSegments(this.f24032i, j);
        }
    }

    /* renamed from: e */
    private boolean m17098e(int i) {
        return this.f24035l && i > 0;
    }

    public void setBubblePosition(long j, LatLng latLng) {
        m17088a();
        if (this.f24035l) {
            double d = latLng.latitude;
            MapEngineJNI.UpdateMapOverlayPosition_Wrap(this.f24032i, this.f24033j, j, latLng.longitude, d);
        }
    }

    public void setBubbleVisible(long j, boolean z) {
        m17088a();
        if (this.f24035l) {
            MapEngineJNI.SetMapOverlayVisible_Wrap(this.f24032i, this.f24033j, j, z);
        }
    }

    public boolean getBubbleRealVisible(long j) {
        m17088a();
        if (this.f24035l) {
            return MapEngineJNI.GetMapOverlayRealVisible(this.f24032i, this.f24033j, j);
        }
        return false;
    }

    public void addViolationParkingSection(int i, int i2, int i3, float f, int i4, float f2) {
        m17088a();
        if (m17098e(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("IllegalPark--MapEngineImpl--add--Id:");
            int i5 = i;
            sb.append(i);
            sb.append(" section_uid:");
            sb.append(i2);
            sb.append(" startIndex:");
            sb.append(i3);
            sb.append(" startForwardRatio:");
            sb.append(f);
            sb.append(" endIndex:");
            sb.append(i4);
            sb.append(" endForwardRatio:");
            float f3 = f2;
            sb.append(f3);
            HWLog.m16761i("", sb.toString());
            MapEngineJNI.DMapAddViolationParkingSection(this.f24032i, i, i2, i3, f, i4, f3);
            return;
        }
    }

    public LatLng queryViolationParkingIconPosition(int i, int i2, int i3, LatLng latLng) {
        m17088a();
        if (!m17098e(i)) {
            return null;
        }
        DDLocationCoordinate2D DDCoordinateForMapPoint = MapEngineJNI.DDCoordinateForMapPoint(MapEngineJNI.DMapQueryViolationParkingIconPos(this.f24032i, i, i2, i3, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(latLng.longitude, latLng.latitude))));
        return new LatLng(DDCoordinateForMapPoint.getLatitude(), DDCoordinateForMapPoint.getLongitude());
    }

    public void flashViolationParkingSection(int i, int i2, boolean z) {
        m17088a();
        if (m17098e(i)) {
            HWLog.m16761i("", "IllegalPark--MapEngineImpl--flash--Id:" + i + " section_uid:" + i2 + " flash:" + z);
            MapEngineJNI.DMapFlashViolationParkingSection(this.f24032i, i, i2, z);
        }
    }

    public void removeViolationParkingSection(int i, int i2) {
        m17088a();
        if (m17098e(i)) {
            HWLog.m16761i("", "IllegalPark--MapEngineImpl--remove--Id:" + i + " section_uid:" + i2);
            MapEngineJNI.DMapRemoveViolationParkingSection(this.f24032i, i, i2);
        }
    }

    public void attachMapEngine(HWBSManager hWBSManager) {
        m17088a();
        if (hWBSManager != null) {
            hWBSManager.setPWorld(this.f24032i);
        }
    }
}
