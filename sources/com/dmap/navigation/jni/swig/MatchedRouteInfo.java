package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class MatchedRouteInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MatchedRouteInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MatchedRouteInfo matchedRouteInfo) {
        if (matchedRouteInfo == null) {
            return 0;
        }
        return matchedRouteInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_MatchedRouteInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setLinkId(BigInteger bigInteger) {
        NaviBusinessJNI.MatchedRouteInfo_linkId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getLinkId() {
        return NaviBusinessJNI.MatchedRouteInfo_linkId_get(this.swigCPtr, this);
    }

    public void setLinkIdRaw(BigInteger bigInteger) {
        NaviBusinessJNI.MatchedRouteInfo_linkIdRaw_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getLinkIdRaw() {
        return NaviBusinessJNI.MatchedRouteInfo_linkIdRaw_get(this.swigCPtr, this);
    }

    public void setMapVersion(String str) {
        NaviBusinessJNI.MatchedRouteInfo_mapVersion_set(this.swigCPtr, this, str);
    }

    public String getMapVersion() {
        return NaviBusinessJNI.MatchedRouteInfo_mapVersion_get(this.swigCPtr, this);
    }

    public MatchedRouteInfo() {
        this(NaviBusinessJNI.new_MatchedRouteInfo(), true);
    }
}
