package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class ReqRouteInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ReqRouteInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ReqRouteInfo reqRouteInfo) {
        if (reqRouteInfo == null) {
            return 0;
        }
        return reqRouteInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_ReqRouteInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLastRouteId(BigInteger bigInteger) {
        NaviBusinessJNI.ReqRouteInfo_lastRouteId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getLastRouteId() {
        return NaviBusinessJNI.ReqRouteInfo_lastRouteId_get(this.swigCPtr, this);
    }

    public void setOtherRouteIds(LongList longList) {
        NaviBusinessJNI.ReqRouteInfo_otherRouteIds_set(this.swigCPtr, this, LongList.getCPtr(longList), longList);
    }

    public LongList getOtherRouteIds() {
        long ReqRouteInfo_otherRouteIds_get = NaviBusinessJNI.ReqRouteInfo_otherRouteIds_get(this.swigCPtr, this);
        if (ReqRouteInfo_otherRouteIds_get == 0) {
            return null;
        }
        return new LongList(ReqRouteInfo_otherRouteIds_get, false);
    }

    public void setRouteCount(int i) {
        NaviBusinessJNI.ReqRouteInfo_routeCount_set(this.swigCPtr, this, i);
    }

    public int getRouteCount() {
        return NaviBusinessJNI.ReqRouteInfo_routeCount_get(this.swigCPtr, this);
    }

    public void setPassfork(int i) {
        NaviBusinessJNI.ReqRouteInfo_passfork_set(this.swigCPtr, this, i);
    }

    public int getPassfork() {
        return NaviBusinessJNI.ReqRouteInfo_passfork_get(this.swigCPtr, this);
    }

    public void setRouteScene(String str) {
        NaviBusinessJNI.ReqRouteInfo_routeScene_set(this.swigCPtr, this, str);
    }

    public String getRouteScene() {
        return NaviBusinessJNI.ReqRouteInfo_routeScene_get(this.swigCPtr, this);
    }

    public void setHasMjoEvent(boolean z) {
        NaviBusinessJNI.ReqRouteInfo_hasMjoEvent_set(this.swigCPtr, this, z);
    }

    public boolean getHasMjoEvent() {
        return NaviBusinessJNI.ReqRouteInfo_hasMjoEvent_get(this.swigCPtr, this);
    }

    public ReqRouteInfo() {
        this(NaviBusinessJNI.new_ReqRouteInfo(), true);
    }
}
