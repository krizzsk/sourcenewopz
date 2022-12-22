package com.didi.hawaii.mapsdkv2.jni;

public class MapOverlayRectArray {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapOverlayRectArray(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapOverlayRectArray mapOverlayRectArray) {
        if (mapOverlayRectArray == null) {
            return 0;
        }
        return mapOverlayRectArray.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapOverlayRectArray(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MapOverlayRectArray(int i) {
        this(MapEngineJNIBridge.new_MapOverlayRectArray(i), true);
    }

    public MapOverlayRect getitem(int i) {
        return new MapOverlayRect(MapEngineJNIBridge.MapOverlayRectArray_getitem(this.swigCPtr, this, i), true);
    }

    public void setitem(int i, MapOverlayRect mapOverlayRect) {
        MapEngineJNIBridge.MapOverlayRectArray_setitem(this.swigCPtr, this, i, MapOverlayRect.getCPtr(mapOverlayRect), mapOverlayRect);
    }

    public MapOverlayRect cast() {
        long MapOverlayRectArray_cast = MapEngineJNIBridge.MapOverlayRectArray_cast(this.swigCPtr, this);
        if (MapOverlayRectArray_cast == 0) {
            return null;
        }
        return new MapOverlayRect(MapOverlayRectArray_cast, false);
    }

    public static MapOverlayRectArray frompointer(MapOverlayRect mapOverlayRect) {
        long MapOverlayRectArray_frompointer = MapEngineJNIBridge.MapOverlayRectArray_frompointer(MapOverlayRect.getCPtr(mapOverlayRect), mapOverlayRect);
        if (MapOverlayRectArray_frompointer == 0) {
            return null;
        }
        return new MapOverlayRectArray(MapOverlayRectArray_frompointer, false);
    }
}
