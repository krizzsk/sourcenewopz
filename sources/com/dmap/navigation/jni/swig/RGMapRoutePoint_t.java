package com.dmap.navigation.jni.swig;

public class RGMapRoutePoint_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RGMapRoutePoint_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RGMapRoutePoint_t rGMapRoutePoint_t) {
        if (rGMapRoutePoint_t == null) {
            return 0;
        }
        return rGMapRoutePoint_t.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_RGMapRoutePoint_t(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setCoorIdx(int i) {
        NaviBusinessJNI.RGMapRoutePoint_t_coorIdx_set(this.swigCPtr, this, i);
    }

    public int getCoorIdx() {
        return NaviBusinessJNI.RGMapRoutePoint_t_coorIdx_get(this.swigCPtr, this);
    }

    public void setShapeOffset(double d) {
        NaviBusinessJNI.RGMapRoutePoint_t_shapeOffset_set(this.swigCPtr, this, d);
    }

    public double getShapeOffset() {
        return NaviBusinessJNI.RGMapRoutePoint_t_shapeOffset_get(this.swigCPtr, this);
    }

    public void setGeoPoint(RGGeoPoint_t rGGeoPoint_t) {
        NaviBusinessJNI.RGMapRoutePoint_t_geoPoint_set(this.swigCPtr, this, RGGeoPoint_t.getCPtr(rGGeoPoint_t), rGGeoPoint_t);
    }

    public RGGeoPoint_t getGeoPoint() {
        long RGMapRoutePoint_t_geoPoint_get = NaviBusinessJNI.RGMapRoutePoint_t_geoPoint_get(this.swigCPtr, this);
        if (RGMapRoutePoint_t_geoPoint_get == 0) {
            return null;
        }
        return new RGGeoPoint_t(RGMapRoutePoint_t_geoPoint_get, false);
    }

    public RGMapRoutePoint_t() {
        this(NaviBusinessJNI.new_RGMapRoutePoint_t(), true);
    }
}
