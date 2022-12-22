package com.didi.hawaii.mapsdkv2.jni;

public class MapOverlayMapTappedElement {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapOverlayMapTappedElement(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapOverlayMapTappedElement mapOverlayMapTappedElement) {
        if (mapOverlayMapTappedElement == null) {
            return 0;
        }
        return mapOverlayMapTappedElement.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapOverlayMapTappedElement(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setDglMapTappedElement(DGLMapTappedElement dGLMapTappedElement) {
        MapEngineJNIBridge.MapOverlayMapTappedElement_dglMapTappedElement_set(this.swigCPtr, this, DGLMapTappedElement.getCPtr(dGLMapTappedElement), dGLMapTappedElement);
    }

    public DGLMapTappedElement getDglMapTappedElement() {
        long MapOverlayMapTappedElement_dglMapTappedElement_get = MapEngineJNIBridge.MapOverlayMapTappedElement_dglMapTappedElement_get(this.swigCPtr, this);
        if (MapOverlayMapTappedElement_dglMapTappedElement_get == 0) {
            return null;
        }
        return new DGLMapTappedElement(MapOverlayMapTappedElement_dglMapTappedElement_get, false);
    }

    public void setOverlayId(long j) {
        MapEngineJNIBridge.MapOverlayMapTappedElement_overlayId_set(this.swigCPtr, this, j);
    }

    public long getOverlayId() {
        return MapEngineJNIBridge.MapOverlayMapTappedElement_overlayId_get(this.swigCPtr, this);
    }

    public MapOverlayMapTappedElement() {
        this(MapEngineJNIBridge.new_MapOverlayMapTappedElement(), true);
    }
}
