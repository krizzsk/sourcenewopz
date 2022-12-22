package com.didi.hawaii.mapsdkv2.jni;

public class MapOverlayRect {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapOverlayRect(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapOverlayRect mapOverlayRect) {
        if (mapOverlayRect == null) {
            return 0;
        }
        return mapOverlayRect.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapOverlayRect(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setWidth(int i) {
        MapEngineJNIBridge.MapOverlayRect_width_set(this.swigCPtr, this, i);
    }

    public int getWidth() {
        return MapEngineJNIBridge.MapOverlayRect_width_get(this.swigCPtr, this);
    }

    public void setHeight(int i) {
        MapEngineJNIBridge.MapOverlayRect_height_set(this.swigCPtr, this, i);
    }

    public int getHeight() {
        return MapEngineJNIBridge.MapOverlayRect_height_get(this.swigCPtr, this);
    }

    public void setAnchorX(float f) {
        MapEngineJNIBridge.MapOverlayRect_anchorX_set(this.swigCPtr, this, f);
    }

    public float getAnchorX() {
        return MapEngineJNIBridge.MapOverlayRect_anchorX_get(this.swigCPtr, this);
    }

    public void setAnchorY(float f) {
        MapEngineJNIBridge.MapOverlayRect_anchorY_set(this.swigCPtr, this, f);
    }

    public float getAnchorY() {
        return MapEngineJNIBridge.MapOverlayRect_anchorY_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        MapEngineJNIBridge.MapOverlayRect_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return MapEngineJNIBridge.MapOverlayRect_name_get(this.swigCPtr, this);
    }

    public void setPaddingLeft(int i) {
        MapEngineJNIBridge.MapOverlayRect_paddingLeft_set(this.swigCPtr, this, i);
    }

    public int getPaddingLeft() {
        return MapEngineJNIBridge.MapOverlayRect_paddingLeft_get(this.swigCPtr, this);
    }

    public void setPaddingRight(int i) {
        MapEngineJNIBridge.MapOverlayRect_paddingRight_set(this.swigCPtr, this, i);
    }

    public int getPaddingRight() {
        return MapEngineJNIBridge.MapOverlayRect_paddingRight_get(this.swigCPtr, this);
    }

    public void setPaddingTop(int i) {
        MapEngineJNIBridge.MapOverlayRect_paddingTop_set(this.swigCPtr, this, i);
    }

    public int getPaddingTop() {
        return MapEngineJNIBridge.MapOverlayRect_paddingTop_get(this.swigCPtr, this);
    }

    public void setPaddingBottom(int i) {
        MapEngineJNIBridge.MapOverlayRect_paddingBottom_set(this.swigCPtr, this, i);
    }

    public int getPaddingBottom() {
        return MapEngineJNIBridge.MapOverlayRect_paddingBottom_get(this.swigCPtr, this);
    }

    public MapOverlayRect() {
        this(MapEngineJNIBridge.new_MapOverlayRect(), true);
    }
}
