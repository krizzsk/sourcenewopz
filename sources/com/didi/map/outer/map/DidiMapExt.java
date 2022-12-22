package com.didi.map.outer.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.core.base.OnMapScaleChangedListener;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Locator;
import com.didi.map.outer.model.OutBlockInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public interface DidiMapExt extends DidiMap {
    public static final int AVOID_CONGEST_BUBBLE = 1;
    public static final int BASE_BUBBLE = 5;
    public static final int CONEST_ROAD_BUBBLE = 3;
    public static final int DYNAMIC_CHANGE_BUBBLE = 2;
    public static final int MULTI_BUBBLE = 4;
    public static final int NOPARK_BUBBLE = 6;
    public static final int NORMAL_BUBBLE = 0;

    public interface BlockEventListener {
        void onBlockEvent(long j, double d, double d2);
    }

    public interface BubbleLoadBitmapListener {
        Bitmap onBitmapLoader(int i, String str);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleType {
    }

    public interface MJOListener {
        void onMJOHideSuccess();

        void onMJOLoadSuccess();
    }

    public interface OnMapParamChangeCallback {
        void onMapParamChanged();
    }

    public interface RenderPerformance {
        void onFrameFinish(long j);
    }

    void addBubble(Bubble bubble);

    void addOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener);

    void addScaleChangeListener(OnMapScaleChangedListener onMapScaleChangedListener);

    void addSpecialBubble(List<RouteSectionWithName> list, List<LatLng> list2, long j, int i);

    void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, float f4, boolean z, boolean z2);

    void clearMJORouteInfo();

    void deleteSpecialBubbleWithType(int i);

    void destroyAllVecEnlarge();

    boolean destroyNewVecEnlarge(String str);

    byte[] genVecEnlargePNGImage(byte[] bArr, long j);

    BubbleManager getBubbleManager();

    Locator getLocator();

    OnMapElementClickListener getMapElementClickListener();

    LatLng getRouteArrowFurthestPoint();

    List<TrafficEventRoutePoint> getTrafficEventRoutePointInfo();

    List<TrafficEventRoutePoint> getTrafficEventsPointInfo();

    void handleBubbleCollision();

    void hibernate();

    void hideMJO(boolean z);

    boolean isNight();

    ArrayList<LatLng> loadMJOAndGetBindRoute(long j, int i, MJOListener mJOListener, byte[] bArr, List<MJOLinkInfo> list, long j2);

    void refeshTrafficIcon(List<Long> list);

    void removeBubble(long j);

    void removeBubbleListener();

    void removeOnCameraChangedListener(DidiMap.OnCameraChangeListener onCameraChangeListener);

    void removeRemoteBubble(long j);

    void removeScaleChangeListener(OnMapScaleChangedListener onMapScaleChangedListener);

    void removeSpecialBubble(long j);

    boolean removeTrafficIcon(long j, int i, double d);

    void setAllTrafficIconVisible(boolean z);

    void setBlockEventListener(BlockEventListener blockEventListener);

    void setBlockInfo(int i, long j, List<LatLng> list, List<OutBlockInfo> list2);

    void setBubbleEdgePadding(float f);

    void setBubbleLoadBitmapListener(BubbleLoadBitmapListener bubbleLoadBitmapListener);

    void setClipArea(int i);

    void setDisplayFishBoneGrayBubbleOnly(boolean z);

    void setExtendEventData(byte[] bArr);

    void setMJOEnabled(boolean z);

    void setNaviOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener);

    void setNaviOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener);

    void setOnMapChangeCallback(OnMapParamChangeCallback onMapParamChangeCallback);

    void setRenderPerformance(RenderPerformance renderPerformance);

    boolean setVecEnlargeData(String str, byte[] bArr, long j);

    boolean setVecEnlargeIsVisible(String str, boolean z);

    void showMJO();

    void showTrafficIconRadar(long j, MapTrafficIcon mapTrafficIcon, int i);

    void switchTrafficDrawer(boolean z);

    Point toScreenLocation(LatLng latLng);

    void updateBubble(Bubble bubble);

    void updateSpecialBubble(List<RouteSectionWithName> list, long j);

    public static class MJOLinkInfo {
        private final int direction;
        private final double linkDistance;
        private final long linkId;

        public MJOLinkInfo(long j, int i, double d) {
            this.linkId = j;
            this.direction = i;
            this.linkDistance = d;
        }

        public long getLinkId() {
            return this.linkId;
        }

        public int getDirection() {
            return this.direction;
        }

        public double getLinkDistance() {
            return this.linkDistance;
        }
    }
}
