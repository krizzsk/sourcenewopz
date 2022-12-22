package com.didi.hawaii.mapsdkv2.jni;

public class MapTrafficIconAttrs {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapTrafficIconAttrs(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapTrafficIconAttrs mapTrafficIconAttrs) {
        if (mapTrafficIconAttrs == null) {
            return 0;
        }
        return mapTrafficIconAttrs.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapTrafficIconAttrs(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setFake(boolean z) {
        MapEngineJNIBridge.MapTrafficIconAttrs_fake_set(this.swigCPtr, this, z);
    }

    public boolean getFake() {
        return MapEngineJNIBridge.MapTrafficIconAttrs_fake_get(this.swigCPtr, this);
    }

    public void setRouteID(long j) {
        MapEngineJNIBridge.MapTrafficIconAttrs_routeID_set(this.swigCPtr, this, j);
    }

    public long getRouteID() {
        return MapEngineJNIBridge.MapTrafficIconAttrs_routeID_get(this.swigCPtr, this);
    }

    public MapTrafficIconAttrs() {
        this(MapEngineJNIBridge.new_MapTrafficIconAttrs(), true);
    }
}
