package com.didi.hawaii.mapsdkv2.jni;

public class MapPointSectionArray {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapPointSectionArray(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapPointSectionArray mapPointSectionArray) {
        if (mapPointSectionArray == null) {
            return 0;
        }
        return mapPointSectionArray.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapPointSectionArray(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MapPointSectionArray(int i) {
        this(MapEngineJNIBridge.new_MapPointSectionArray(i), true);
    }

    public MapPointSection getitem(int i) {
        return new MapPointSection(MapEngineJNIBridge.MapPointSectionArray_getitem(this.swigCPtr, this, i), true);
    }

    public void setitem(int i, MapPointSection mapPointSection) {
        MapEngineJNIBridge.MapPointSectionArray_setitem(this.swigCPtr, this, i, MapPointSection.getCPtr(mapPointSection), mapPointSection);
    }

    public MapPointSection cast() {
        long MapPointSectionArray_cast = MapEngineJNIBridge.MapPointSectionArray_cast(this.swigCPtr, this);
        if (MapPointSectionArray_cast == 0) {
            return null;
        }
        return new MapPointSection(MapPointSectionArray_cast, false);
    }

    public static MapPointSectionArray frompointer(MapPointSection mapPointSection) {
        long MapPointSectionArray_frompointer = MapEngineJNIBridge.MapPointSectionArray_frompointer(MapPointSection.getCPtr(mapPointSection), mapPointSection);
        if (MapPointSectionArray_frompointer == 0) {
            return null;
        }
        return new MapPointSectionArray(MapPointSectionArray_frompointer, false);
    }
}
