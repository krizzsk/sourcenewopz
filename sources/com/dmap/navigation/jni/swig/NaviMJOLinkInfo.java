package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class NaviMJOLinkInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviMJOLinkInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviMJOLinkInfo naviMJOLinkInfo) {
        if (naviMJOLinkInfo == null) {
            return 0;
        }
        return naviMJOLinkInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviMJOLinkInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setOriginalinkId(BigInteger bigInteger) {
        NaviBusinessJNI.NaviMJOLinkInfo_originalinkId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getOriginalinkId() {
        return NaviBusinessJNI.NaviMJOLinkInfo_originalinkId_get(this.swigCPtr, this);
    }

    public void setLinkId(BigInteger bigInteger) {
        NaviBusinessJNI.NaviMJOLinkInfo_linkId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getLinkId() {
        return NaviBusinessJNI.NaviMJOLinkInfo_linkId_get(this.swigCPtr, this);
    }

    public void setDirection(int i) {
        NaviBusinessJNI.NaviMJOLinkInfo_direction_set(this.swigCPtr, this, i);
    }

    public int getDirection() {
        return NaviBusinessJNI.NaviMJOLinkInfo_direction_get(this.swigCPtr, this);
    }

    public void setLinkDistance(double d) {
        NaviBusinessJNI.NaviMJOLinkInfo_linkDistance_set(this.swigCPtr, this, d);
    }

    public double getLinkDistance() {
        return NaviBusinessJNI.NaviMJOLinkInfo_linkDistance_get(this.swigCPtr, this);
    }

    public NaviMJOLinkInfo() {
        this(NaviBusinessJNI.new_NaviMJOLinkInfo(), true);
    }
}
