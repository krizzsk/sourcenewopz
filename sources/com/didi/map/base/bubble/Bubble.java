package com.didi.map.base.bubble;

import android.graphics.Rect;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerOptions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Bubble {
    public static final int OVERLAY_ACCIDENT_BUBBLE = 128;
    public static final int OVERLAY_BLOCK_BUBBLE = 16;
    public static final int OVERLAY_CAMERA_BUBBLE = 4;
    public static final int OVERLAY_CAMERA_ICON = 2;
    public static final int OVERLAY_ILLEGAL_PARK_BUBBLE = 64;
    public static final int OVERLAY_MULTI_BUBBLE = 32;
    public static final int OVERLAY_NORMAL = 1;
    public static final int OVERLAY_ROUTE_BUBBLE = 8;
    public static final int OverlOverlay_Traffic_Icon = 16384;
    public static final int Overlay_Always_Visible_Bubble = 32768;
    public static final int Overlay_Block_Event_Bubble = 8192;
    private static AtomicLong idGen = new AtomicLong(1);
    private AnimationSetting animatiomSetting;
    private int collisionType;

    /* renamed from: id */
    private final long f24582id = idGen.incrementAndGet();
    private int innerType;
    private boolean isNeedSelectBottomRect;
    private boolean isVirtual;
    private Marker marker;
    private MarkerOptions markerOptions;
    private PointArea pointArea;
    private int priority;
    private final List<OverlayRect> rects;
    private final List<OverlayRect> rectsOriginal;
    private long routeId;
    private String showInfo = "";
    private TrafficIconAttrs trafficIconAttrs;
    private int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OverlayType {
    }

    public static class PointArea {
        public int[] endNums;
        public List<LatLng> points;
        public long routeID;
        public int sectionCount;
        public int[] startNums;
    }

    public Bubble(MarkerOptions markerOptions2) {
        ArrayList arrayList = new ArrayList();
        this.rectsOriginal = arrayList;
        this.rects = Collections.synchronizedList(arrayList);
        this.isVirtual = false;
        this.isNeedSelectBottomRect = false;
        init(markerOptions2, false);
    }

    public Bubble(MarkerOptions markerOptions2, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.rectsOriginal = arrayList;
        this.rects = Collections.synchronizedList(arrayList);
        this.isVirtual = false;
        this.isNeedSelectBottomRect = false;
        init(markerOptions2, z);
    }

    private void init(MarkerOptions markerOptions2, boolean z) {
        if (!z) {
            markerOptions2.bubbleId(this.f24582id);
        }
        this.markerOptions = markerOptions2;
    }

    public String getShowInfo() {
        return this.showInfo;
    }

    public void setShowInfo(String str) {
        this.showInfo = str;
    }

    public void setVirtual(boolean z) {
        this.isVirtual = z;
    }

    public boolean isNeedSelectBottomRect() {
        return this.isNeedSelectBottomRect;
    }

    public void setNeedSelectBottomRect(boolean z) {
        this.isNeedSelectBottomRect = z;
    }

    public boolean isVirtual() {
        return this.isVirtual;
    }

    public MarkerOptions getMarkerOptions() {
        return this.markerOptions;
    }

    public void setInnerType(int i) {
        this.innerType = i;
    }

    public int getInnerType() {
        return this.innerType;
    }

    public void setMarker(Marker marker2) {
        this.marker = marker2;
    }

    public void remove() {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.remove();
        }
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public long getId() {
        return this.f24582id;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public double getLongitude() {
        return this.markerOptions.getPosition().longitude;
    }

    public void position(LatLng latLng) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        this.markerOptions.position(latLng);
    }

    public double getLatitude() {
        return this.markerOptions.getPosition().latitude;
    }

    public int getzIndex() {
        return (int) this.markerOptions.getZIndex();
    }

    public void setzIndex(int i) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setZIndex((float) i);
        }
        this.markerOptions.zIndex((float) i);
    }

    public void setVisible(boolean z) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setVisible(z);
        }
        this.markerOptions.visible(z);
    }

    public boolean isVisible() {
        return this.marker.isVisible();
    }

    public void setOnClickListener(DidiMap.OnMarkerClickListener onMarkerClickListener) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setOnClickListener(onMarkerClickListener);
        }
    }

    public void setOnVisibleChangeListener(DidiMap.OnMarkerVisibleChangeListener onMarkerVisibleChangeListener) {
        this.marker.setOnMarkerVisibleChangeListener(onMarkerVisibleChangeListener);
    }

    public void addOverlayRect(OverlayRect overlayRect) {
        if (overlayRect != null) {
            overlayRect.index = this.rects.size();
            this.rects.add(overlayRect);
        }
    }

    public long getRouteId() {
        return this.routeId;
    }

    public void setRouteId(long j) {
        this.routeId = j;
    }

    public void clearOverlayRect() {
        this.rects.clear();
    }

    public int getOverlayRectCnt() {
        return this.rects.size();
    }

    public OverlayRect getOverlayRect(int i) {
        if (i >= this.rects.size()) {
            return null;
        }
        return this.rects.get(i);
    }

    public int getCollisionType() {
        return this.collisionType;
    }

    public void setCollisionType(int i) {
        this.collisionType = i;
    }

    public PointArea getPointArea() {
        return this.pointArea;
    }

    public void setPointArea(PointArea pointArea2) {
        this.pointArea = pointArea2;
    }

    public TrafficIconAttrs getTrafficIconAttrs() {
        return this.trafficIconAttrs;
    }

    public AnimationSetting getAnimatiomSetting() {
        return this.animatiomSetting;
    }

    public void setAnimatiomSetting(int i, long j, int i2) {
        this.animatiomSetting = new AnimationSetting(i, j, i2);
    }

    public void setTrafficIconAttrs(long j, boolean z) {
        this.trafficIconAttrs = new TrafficIconAttrs(j, z);
    }

    public void setTrafficIconAttrs(boolean z, long j, TrafficHintShowBarn trafficHintShowBarn) {
        this.trafficIconAttrs = new TrafficIconAttrs(z, j, trafficHintShowBarn);
    }

    public static class TrafficIconAttrs {
        public long bindId;
        public boolean isFake = false;
        public boolean isHintIcon = false;
        public long routeId;
        public TrafficHintShowBarn showBarn;

        public TrafficIconAttrs(boolean z, long j, TrafficHintShowBarn trafficHintShowBarn) {
            this.isHintIcon = z;
            this.bindId = j;
            this.showBarn = trafficHintShowBarn;
        }

        public TrafficIconAttrs(long j, boolean z) {
            this.routeId = j;
            this.isFake = z;
        }
    }

    public static class OverlayRect {
        public float anchorX;
        public float anchorY;
        public final long bubbleId;
        public int height;
        public int index;
        public Rect paddingCollision;
        public BaseBubbleBitmapOpt resourcePaths;
        public int width;

        public OverlayRect(long j) {
            this.bubbleId = j;
        }
    }
}
