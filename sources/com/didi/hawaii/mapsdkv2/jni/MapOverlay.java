package com.didi.hawaii.mapsdkv2.jni;

public class MapOverlay {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapOverlay(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapOverlay mapOverlay) {
        if (mapOverlay == null) {
            return 0;
        }
        return mapOverlay.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapOverlay(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setOverlayId(long j) {
        MapEngineJNIBridge.MapOverlay_overlayId_set(this.swigCPtr, this, j);
    }

    public long getOverlayId() {
        return MapEngineJNIBridge.MapOverlay_overlayId_get(this.swigCPtr, this);
    }

    public void setType(int i) {
        MapEngineJNIBridge.MapOverlay_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return MapEngineJNIBridge.MapOverlay_type_get(this.swigCPtr, this);
    }

    public void setLongitude(double d) {
        MapEngineJNIBridge.MapOverlay_longitude_set(this.swigCPtr, this, d);
    }

    public double getLongitude() {
        return MapEngineJNIBridge.MapOverlay_longitude_get(this.swigCPtr, this);
    }

    public void setLatitude(double d) {
        MapEngineJNIBridge.MapOverlay_latitude_set(this.swigCPtr, this, d);
    }

    public double getLatitude() {
        return MapEngineJNIBridge.MapOverlay_latitude_get(this.swigCPtr, this);
    }

    public void setScaleX(float f) {
        MapEngineJNIBridge.MapOverlay_scaleX_set(this.swigCPtr, this, f);
    }

    public float getScaleX() {
        return MapEngineJNIBridge.MapOverlay_scaleX_get(this.swigCPtr, this);
    }

    public void setScaleY(float f) {
        MapEngineJNIBridge.MapOverlay_scaleY_set(this.swigCPtr, this, f);
    }

    public float getScaleY() {
        return MapEngineJNIBridge.MapOverlay_scaleY_get(this.swigCPtr, this);
    }

    public void setFixPosX(int i) {
        MapEngineJNIBridge.MapOverlay_fixPosX_set(this.swigCPtr, this, i);
    }

    public int getFixPosX() {
        return MapEngineJNIBridge.MapOverlay_fixPosX_get(this.swigCPtr, this);
    }

    public void setFixPosY(int i) {
        MapEngineJNIBridge.MapOverlay_fixPosY_set(this.swigCPtr, this, i);
    }

    public int getFixPosY() {
        return MapEngineJNIBridge.MapOverlay_fixPosY_get(this.swigCPtr, this);
    }

    public void setAngle(float f) {
        MapEngineJNIBridge.MapOverlay_angle_set(this.swigCPtr, this, f);
    }

    public float getAngle() {
        return MapEngineJNIBridge.MapOverlay_angle_get(this.swigCPtr, this);
    }

    public void setIsClockwise(boolean z) {
        MapEngineJNIBridge.MapOverlay_isClockwise_set(this.swigCPtr, this, z);
    }

    public boolean getIsClockwise() {
        return MapEngineJNIBridge.MapOverlay_isClockwise_get(this.swigCPtr, this);
    }

    public void setIsFlat(boolean z) {
        MapEngineJNIBridge.MapOverlay_isFlat_set(this.swigCPtr, this, z);
    }

    public boolean getIsFlat() {
        return MapEngineJNIBridge.MapOverlay_isFlat_get(this.swigCPtr, this);
    }

    public void setIsFixPosition(boolean z) {
        MapEngineJNIBridge.MapOverlay_isFixPosition_set(this.swigCPtr, this, z);
    }

    public boolean getIsFixPosition() {
        return MapEngineJNIBridge.MapOverlay_isFixPosition_get(this.swigCPtr, this);
    }

    public void setIsFastLoad(boolean z) {
        MapEngineJNIBridge.MapOverlay_isFastLoad_set(this.swigCPtr, this, z);
    }

    public boolean getIsFastLoad() {
        return MapEngineJNIBridge.MapOverlay_isFastLoad_get(this.swigCPtr, this);
    }

    public void setIsAvoidAnno(boolean z) {
        MapEngineJNIBridge.MapOverlay_isAvoidAnno_set(this.swigCPtr, this, z);
    }

    public boolean getIsAvoidAnno() {
        return MapEngineJNIBridge.MapOverlay_isAvoidAnno_get(this.swigCPtr, this);
    }

    public void setIsOrthographicProject(boolean z) {
        MapEngineJNIBridge.MapOverlay_isOrthographicProject_set(this.swigCPtr, this, z);
    }

    public boolean getIsOrthographicProject() {
        return MapEngineJNIBridge.MapOverlay_isOrthographicProject_get(this.swigCPtr, this);
    }

    public void setZIndex(int i) {
        MapEngineJNIBridge.MapOverlay_zIndex_set(this.swigCPtr, this, i);
    }

    public int getZIndex() {
        return MapEngineJNIBridge.MapOverlay_zIndex_get(this.swigCPtr, this);
    }

    public void setAlpha(float f) {
        MapEngineJNIBridge.MapOverlay_alpha_set(this.swigCPtr, this, f);
    }

    public float getAlpha() {
        return MapEngineJNIBridge.MapOverlay_alpha_get(this.swigCPtr, this);
    }

    public void setVisible(boolean z) {
        MapEngineJNIBridge.MapOverlay_visible_set(this.swigCPtr, this, z);
    }

    public boolean getVisible() {
        return MapEngineJNIBridge.MapOverlay_visible_get(this.swigCPtr, this);
    }

    public void setRectCnt(int i) {
        MapEngineJNIBridge.MapOverlay_rectCnt_set(this.swigCPtr, this, i);
    }

    public int getRectCnt() {
        return MapEngineJNIBridge.MapOverlay_rectCnt_get(this.swigCPtr, this);
    }

    public void setCollisionType(int i) {
        MapEngineJNIBridge.MapOverlay_collisionType_set(this.swigCPtr, this, i);
    }

    public int getCollisionType() {
        return MapEngineJNIBridge.MapOverlay_collisionType_get(this.swigCPtr, this);
    }

    public void setPriority(int i) {
        MapEngineJNIBridge.MapOverlay_priority_set(this.swigCPtr, this, i);
    }

    public int getPriority() {
        return MapEngineJNIBridge.MapOverlay_priority_get(this.swigCPtr, this);
    }

    public void setGroupId(int i) {
        MapEngineJNIBridge.MapOverlay_groupId_set(this.swigCPtr, this, i);
    }

    public int getGroupId() {
        return MapEngineJNIBridge.MapOverlay_groupId_get(this.swigCPtr, this);
    }

    public void setIsVirtualScreenOverlay(boolean z) {
        MapEngineJNIBridge.MapOverlay_isVirtualScreenOverlay_set(this.swigCPtr, this, z);
    }

    public boolean getIsVirtualScreenOverlay() {
        return MapEngineJNIBridge.MapOverlay_isVirtualScreenOverlay_get(this.swigCPtr, this);
    }

    public void setIsVirtualOverlay(boolean z) {
        MapEngineJNIBridge.MapOverlay_isVirtualOverlay_set(this.swigCPtr, this, z);
    }

    public boolean getIsVirtualOverlay() {
        return MapEngineJNIBridge.MapOverlay_isVirtualOverlay_get(this.swigCPtr, this);
    }

    public void setSelectBottomRectWhenColliedLocator(boolean z) {
        MapEngineJNIBridge.MapOverlay_selectBottomRectWhenColliedLocator_set(this.swigCPtr, this, z);
    }

    public boolean getSelectBottomRectWhenColliedLocator() {
        return MapEngineJNIBridge.MapOverlay_selectBottomRectWhenColliedLocator_get(this.swigCPtr, this);
    }

    public void setRects(MapOverlayRect mapOverlayRect) {
        MapEngineJNIBridge.MapOverlay_rects_set(this.swigCPtr, this, MapOverlayRect.getCPtr(mapOverlayRect), mapOverlayRect);
    }

    public MapOverlayRect getRects() {
        long MapOverlay_rects_get = MapEngineJNIBridge.MapOverlay_rects_get(this.swigCPtr, this);
        if (MapOverlay_rects_get == 0) {
            return null;
        }
        return new MapOverlayRect(MapOverlay_rects_get, false);
    }

    public void setShowInfo(String str) {
        MapEngineJNIBridge.MapOverlay_showInfo_set(this.swigCPtr, this, str);
    }

    public String getShowInfo() {
        return MapEngineJNIBridge.MapOverlay_showInfo_get(this.swigCPtr, this);
    }

    public void setPointArea(MapPointArea mapPointArea) {
        MapEngineJNIBridge.MapOverlay_pointArea_set(this.swigCPtr, this, MapPointArea.getCPtr(mapPointArea), mapPointArea);
    }

    public MapPointArea getPointArea() {
        long MapOverlay_pointArea_get = MapEngineJNIBridge.MapOverlay_pointArea_get(this.swigCPtr, this);
        if (MapOverlay_pointArea_get == 0) {
            return null;
        }
        return new MapPointArea(MapOverlay_pointArea_get, false);
    }

    public void setTrafficIconAttrs(MapTrafficIconAttrs mapTrafficIconAttrs) {
        MapEngineJNIBridge.MapOverlay_trafficIconAttrs_set(this.swigCPtr, this, MapTrafficIconAttrs.getCPtr(mapTrafficIconAttrs), mapTrafficIconAttrs);
    }

    public MapTrafficIconAttrs getTrafficIconAttrs() {
        long MapOverlay_trafficIconAttrs_get = MapEngineJNIBridge.MapOverlay_trafficIconAttrs_get(this.swigCPtr, this);
        if (MapOverlay_trafficIconAttrs_get == 0) {
            return null;
        }
        return new MapTrafficIconAttrs(MapOverlay_trafficIconAttrs_get, false);
    }

    public void setVisibleChangeAnimateAttrs(MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs) {
        MapEngineJNIBridge.MapOverlay_visibleChangeAnimateAttrs_set(this.swigCPtr, this, MapVisibleChangeAnimateAttrs.getCPtr(mapVisibleChangeAnimateAttrs), mapVisibleChangeAnimateAttrs);
    }

    public MapVisibleChangeAnimateAttrs getVisibleChangeAnimateAttrs() {
        long MapOverlay_visibleChangeAnimateAttrs_get = MapEngineJNIBridge.MapOverlay_visibleChangeAnimateAttrs_get(this.swigCPtr, this);
        if (MapOverlay_visibleChangeAnimateAttrs_get == 0) {
            return null;
        }
        return new MapVisibleChangeAnimateAttrs(MapOverlay_visibleChangeAnimateAttrs_get, false);
    }

    public MapOverlay() {
        this(MapEngineJNIBridge.new_MapOverlay(), true);
    }
}
