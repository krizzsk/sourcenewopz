package com.didi.hawaii.mapsdkv2.jni;

public class MapPointArea {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapPointArea(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapPointArea mapPointArea) {
        if (mapPointArea == null) {
            return 0;
        }
        return mapPointArea.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapPointArea(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setSectionCount(int i) {
        MapEngineJNIBridge.MapPointArea_sectionCount_set(this.swigCPtr, this, i);
    }

    public int getSectionCount() {
        return MapEngineJNIBridge.MapPointArea_sectionCount_get(this.swigCPtr, this);
    }

    public void setSections(MapPointSection mapPointSection) {
        MapEngineJNIBridge.MapPointArea_sections_set(this.swigCPtr, this, MapPointSection.getCPtr(mapPointSection), mapPointSection);
    }

    public MapPointSection getSections() {
        long MapPointArea_sections_get = MapEngineJNIBridge.MapPointArea_sections_get(this.swigCPtr, this);
        if (MapPointArea_sections_get == 0) {
            return null;
        }
        return new MapPointSection(MapPointArea_sections_get, false);
    }

    public void setMapPoint(DDMapPoint dDMapPoint) {
        MapEngineJNIBridge.MapPointArea_mapPoint_set(this.swigCPtr, this, DDMapPoint.getCPtr(dDMapPoint), dDMapPoint);
    }

    public DDMapPoint getMapPoint() {
        long MapPointArea_mapPoint_get = MapEngineJNIBridge.MapPointArea_mapPoint_get(this.swigCPtr, this);
        if (MapPointArea_mapPoint_get == 0) {
            return null;
        }
        return new DDMapPoint(MapPointArea_mapPoint_get, false);
    }

    public void setMapPointCount(int i) {
        MapEngineJNIBridge.MapPointArea_mapPointCount_set(this.swigCPtr, this, i);
    }

    public int getMapPointCount() {
        return MapEngineJNIBridge.MapPointArea_mapPointCount_get(this.swigCPtr, this);
    }

    public void setRouteID(long j) {
        MapEngineJNIBridge.MapPointArea_routeID_set(this.swigCPtr, this, j);
    }

    public long getRouteID() {
        return MapEngineJNIBridge.MapPointArea_routeID_get(this.swigCPtr, this);
    }

    public MapPointArea() {
        this(MapEngineJNIBridge.new_MapPointArea(), true);
    }
}
