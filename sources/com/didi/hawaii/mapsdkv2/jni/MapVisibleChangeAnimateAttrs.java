package com.didi.hawaii.mapsdkv2.jni;

public class MapVisibleChangeAnimateAttrs {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MapVisibleChangeAnimateAttrs(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs) {
        if (mapVisibleChangeAnimateAttrs == null) {
            return 0;
        }
        return mapVisibleChangeAnimateAttrs.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MapVisibleChangeAnimateAttrs(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setAnimationType(DiAnimationType diAnimationType) {
        MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_animationType_set(this.swigCPtr, this, diAnimationType.swigValue());
    }

    public DiAnimationType getAnimationType() {
        return DiAnimationType.swigToEnum(MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_animationType_get(this.swigCPtr, this));
    }

    public void setInterpolatorType(DiInterpolatorType diInterpolatorType) {
        MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_interpolatorType_set(this.swigCPtr, this, diInterpolatorType.swigValue());
    }

    public DiInterpolatorType getInterpolatorType() {
        return DiInterpolatorType.swigToEnum(MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_interpolatorType_get(this.swigCPtr, this));
    }

    public void setNeedAnimate(boolean z) {
        MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_needAnimate_set(this.swigCPtr, this, z);
    }

    public boolean getNeedAnimate() {
        return MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_needAnimate_get(this.swigCPtr, this);
    }

    public void setDuration(int i) {
        MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_duration_set(this.swigCPtr, this, i);
    }

    public int getDuration() {
        return MapEngineJNIBridge.MapVisibleChangeAnimateAttrs_duration_get(this.swigCPtr, this);
    }

    public MapVisibleChangeAnimateAttrs() {
        this(MapEngineJNIBridge.new_MapVisibleChangeAnimateAttrs(), true);
    }
}
