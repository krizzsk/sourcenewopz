package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.AnimationSetting;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.OutBlockInfo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public interface MapEngine {
    public static final int DISPLAY_ID_ERROR = -1;

    public interface BlockEventCallback {
        void onBlockEvent(long j, double d, double d2);
    }

    public interface Callback {
        public static final int BITMAP_TYPE_SAT = 1;

        void onDownload(String str);

        void onDownloadDynamicLayer(boolean z, String str, byte[] bArr, int i);

        PointF onGetTextSize(String str, int i, boolean z);

        void onLabelOnRouteNew(List<TextLableOnRoute> list);

        LoadedImage onLoadBitmap(int i, String str);

        Bitmap onLoadTextBitmap(String str, int i, int i2, int i3, int i4, boolean z);

        void onWriteFile(String str, byte[] bArr);
    }

    public interface MJOCallback {
        void onMJOEvent(long j, int i);
    }

    void SetHWBussThresholdOpen(boolean z, float f);

    void addBubble(long j, int i, int i2, double d, double d2, float f, float f2, int i3, int i4, float f3, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, float f4, boolean z5, boolean z6, boolean z7, String str, List<Bubble.OverlayRect> list, Bubble.PointArea pointArea, Bubble.TrafficIconAttrs trafficIconAttrs, AnimationSetting animationSetting);

    void addMultipleRouteNames(long j, RouteName[] routeNameArr, LatLng[] latLngArr, int i, int i2, String str, String str2, int i3, int i4);

    void addSpecialBubble(RouteName[] routeNameArr, LatLng[] latLngArr, long j, int i);

    LatLng calculateRoute3DArrowFurthestPoint();

    LatLng calculateRoute3DArrowFurthestPointUnsafe();

    float calculateScaleRuler(int i);

    PointF calculateTargetOffset(LatLng latLng, Camera camera, int i, int i2);

    void cancelMapDataDownloadTask(String str);

    void cancelMapDynamicLayerLoadTask(String str);

    boolean checkNeedGuard(String str);

    void cleanCache();

    void clearMJORouteInfo();

    void clearRouteNameSegments();

    void clearTrafficEventData();

    void clearTrafficLocalIcons();

    boolean create(float f, String str, String str2, String str3, String str4, ArrayList<String> arrayList, int[] iArr, float f2, int i, int i2, int i3, Callback callback, EngineLogSwitch engineLogSwitch, boolean z);

    void createEngineContext();

    void deleteSpecialBubbleWithType(int i);

    void destroy();

    void destroyAllVecEnlarge();

    boolean destroyNewVecEnlarge(String str);

    int fetchTrafficBlockData(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    LatLng fromScreenLocation(float f, float f2);

    LatLng fromScreenLocationUnsafe(float f, float f2);

    byte[] genVecEnlargePNGImage(byte[] bArr, long j, float f);

    boolean generateTexture();

    Camera getCamera();

    LatLng getCenter();

    String getCityName(LatLng latLng);

    double getLevelPointPerMeter(float f);

    int getRenderExtendIconNumber();

    float getRotate();

    double getScale();

    float getSkew();

    double getTargetScale(Rect rect);

    TrafficEventRoutePoint[] getTrafficEventRoutePointInfo();

    String getTrafficUpdateUrl();

    void handleBubbleCollision();

    void hibernate();

    void hideMJO(boolean z);

    void hideTrafficEventExcludeClosure(boolean z);

    boolean isSupportStreetRoad(String str);

    boolean isSupportTraffic(String str);

    boolean isUseStyleV2();

    LatLng[] loadMJOAndGetBindRoute(long j, int i, byte[] bArr, long[] jArr, int[] iArr, double[] dArr, int i2, long j2);

    void moveBy(float f, float f2);

    void moveTo(LatLng latLng);

    void pause();

    int refreshTrafficData(byte[] bArr, int i, byte[] bArr2, int i2);

    void removeBubble(long j);

    void removeRemoteBubble(long j);

    void removeRouteName(long j);

    void removeSpecialBubble(long j);

    boolean renderFrame();

    void resetMapPath(int i, String str, String str2, String str3);

    void resetTrafficEventIconCustomSize();

    void restoreMapCameraOnMJOHide(int i, Camera camera);

    void resume();

    void rotateBy(float f);

    void rotateTo(float f);

    void scaleBy(double d);

    void scaleTo(double d);

    Bitmap screenShot(int i, int i2, Bitmap.Config config);

    void setAboardPointJson(String str);

    void setAnnotationShowLight(boolean z);

    void setBlockEventCallback(BlockEventCallback blockEventCallback);

    void setBlockInfo(int i, long j, List<LatLng> list, List<OutBlockInfo> list2);

    void setBubbleEdgePaddingTop(float f);

    void setCenterOffset(float f, float f2);

    void setClipArea(int i, int i2, int i3);

    void setCompassVisible(boolean z);

    void setDrawPillarWith2DStyle(boolean z);

    void setDynamicConfigProvider(EngineDynamicConfigProvider engineDynamicConfigProvider);

    void setEdgePaddingOffset(float f, float f2, float f3, float f4);

    void setExtendEventData(byte[] bArr);

    void setExtendIconVisible(long j, boolean z);

    void setExtendIconVisible(boolean z);

    int setIsInternationalWms(boolean z);

    void setLocatorVisible(boolean z);

    void setMJOCallback(MJOCallback mJOCallback);

    void setMJOEnabled(boolean z);

    void setMapMode(int i);

    void setMapPadding(Rect rect);

    void setMapParams(byte[] bArr);

    void setMapTheme(int i);

    void setMaxScaleLevel(int i);

    void setMinScaleLevel(int i);

    void setNavigationLineMargin(float f, float f2, float f3, float f4);

    void setNeedDisplay();

    void setPoiHidden(int i, LatLng latLng, boolean z);

    void setPoiHidden(BigInteger bigInteger, boolean z);

    void setPoiMarkerRect(Rect[] rectArr);

    void setRenderThread(Thread thread);

    void setRestrictAreaVisible(boolean z);

    void setRouteNameVisible(boolean z);

    void setScaleLevel(int i);

    void setShowDynamicLayer(boolean z);

    boolean setShowStreetRoad(boolean z);

    void setShowTraffic(boolean z);

    void setTrafficColor(int i, int i2, int i3, int i4);

    void setTrafficEventData(byte[] bArr);

    void setTrafficEventIconCustomSize(int i);

    void setUseLowMemoryMode(boolean z);

    void setUseVulkan(boolean z);

    boolean setVecEnlargeData(String str, byte[] bArr, long j, float f);

    boolean setVecEnlargeIsVisible(String str, boolean z);

    void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f);

    void setViewDPI(float f, float f2, int i, int i2);

    void setViewPort(int i, int i2, int i3, int i4);

    void setVioParkingRegionData(byte[] bArr, int i);

    void setZhongYanEventData(byte[] bArr, long j);

    void showFishBoneGrayBubbleOnly(boolean z);

    void showHiddenPoi();

    void showMJO();

    void showTrafficEvent(boolean z);

    void skewBy(float f);

    void skewTo(float f);

    boolean tap(int i, int i2, TapItem tapItem);

    float[] toScreenLocation(LatLng latLng);

    float[] toScreenLocationUnsafe(LatLng latLng);

    void updateBubble(long j, int i, int i2, double d, double d2, float f, float f2, int i3, int i4, float f3, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, float f4, boolean z5, boolean z6, boolean z7, String str, List<Bubble.OverlayRect> list, Bubble.PointArea pointArea);

    void updateRemoteIconBindId(long j, long j2);

    void updateSpecialBubble(RouteName[] routeNameArr, long j);

    void updateTrafficItemState(BigInteger bigInteger, short s, boolean z);

    void updateTrafficLocalIcon(TrafficEventModel[] trafficEventModelArr);

    void writeMapData(String str, byte[] bArr);

    void writeMapDynamicLayerData(String str, byte[] bArr);

    float zoomForNavigation(LatLng latLng);

    Camera zoomToSpan(RectF rectF, Rect rect);

    Camera zoomToSpan4CenterOffset(RectF rectF, Rect rect, float f, float f2, int i, int i2);

    Camera zoomToSpan4CenterOffset2(RectF rectF, Rect rect, float f, float f2, float f3, float f4, int i, int i2);

    public static final class TapItem {
        static final int TAP_CLOSURE_ANNOTATION = 2;
        static final int TAP_COMPASS = 3;
        static final int TAP_EXTEND_ICON = 10;
        static final int TAP_LOCATOR = 6;
        static final int TAP_NONE = 0;
        static final int TAP_OVERLAY = 4;
        static final int TAP_OVERLAY_LINE = 5;
        static final int TAP_POIABOARD = 9;
        static final int TAP_TEXT_ANNOTATION = 1;
        static final int TAP_TRAFFIC = 7;
        static final int TAP_UNKNOWN = 99;
        long bubbleId;
        int displayId;
        final LatLng geo = new LatLng(-1.0d, -1.0d);
        long identity;
        int itemType;
        String name;
        byte[] outArray;
        String poiUrl;
        int subIndex;
        int type;
        boolean updateZIndex;
        int zIndex;

        TapItem() {
        }

        public String toString() {
            return "TapItem:type=" + this.type + ", geo=" + this.geo + ", name=" + this.name + ", itemId=" + this.displayId;
        }
    }
}
