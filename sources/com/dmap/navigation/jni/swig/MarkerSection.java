package com.dmap.navigation.jni.swig;

public class MarkerSection {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MarkerSection(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MarkerSection markerSection) {
        if (markerSection == null) {
            return 0;
        }
        return markerSection.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_MarkerSection(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setStartNum(int i) {
        NaviBusinessJNI.MarkerSection_startNum_set(this.swigCPtr, this, i);
    }

    public int getStartNum() {
        return NaviBusinessJNI.MarkerSection_startNum_get(this.swigCPtr, this);
    }

    public void setEndNum(int i) {
        NaviBusinessJNI.MarkerSection_endNum_set(this.swigCPtr, this, i);
    }

    public int getEndNum() {
        return NaviBusinessJNI.MarkerSection_endNum_get(this.swigCPtr, this);
    }

    public void setStartPoint(NaviLatLng naviLatLng) {
        NaviBusinessJNI.MarkerSection_startPoint_set(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng getStartPoint() {
        long MarkerSection_startPoint_get = NaviBusinessJNI.MarkerSection_startPoint_get(this.swigCPtr, this);
        if (MarkerSection_startPoint_get == 0) {
            return null;
        }
        return new NaviLatLng(MarkerSection_startPoint_get, false);
    }

    public void setEndPoint(NaviLatLng naviLatLng) {
        NaviBusinessJNI.MarkerSection_endPoint_set(this.swigCPtr, this, NaviLatLng.getCPtr(naviLatLng), naviLatLng);
    }

    public NaviLatLng getEndPoint() {
        long MarkerSection_endPoint_get = NaviBusinessJNI.MarkerSection_endPoint_get(this.swigCPtr, this);
        if (MarkerSection_endPoint_get == 0) {
            return null;
        }
        return new NaviLatLng(MarkerSection_endPoint_get, false);
    }

    public MarkerSection() {
        this(NaviBusinessJNI.new_MarkerSection(), true);
    }
}
