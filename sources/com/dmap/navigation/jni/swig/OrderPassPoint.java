package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class OrderPassPoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OrderPassPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OrderPassPoint orderPassPoint) {
        if (orderPassPoint == null) {
            return 0;
        }
        return orderPassPoint.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_OrderPassPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setPoi(NaviPoi naviPoi) {
        NaviBusinessJNI.OrderPassPoint_poi_set(this.swigCPtr, this, NaviPoi.getCPtr(naviPoi), naviPoi);
    }

    public NaviPoi getPoi() {
        long OrderPassPoint_poi_get = NaviBusinessJNI.OrderPassPoint_poi_get(this.swigCPtr, this);
        if (OrderPassPoint_poi_get == 0) {
            return null;
        }
        return new NaviPoi(OrderPassPoint_poi_get, false);
    }

    public void setOrderId(BigInteger bigInteger) {
        NaviBusinessJNI.OrderPassPoint_orderId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getOrderId() {
        return NaviBusinessJNI.OrderPassPoint_orderId_get(this.swigCPtr, this);
    }

    public void setOrderType(int i) {
        NaviBusinessJNI.OrderPassPoint_orderType_set(this.swigCPtr, this, i);
    }

    public int getOrderType() {
        return NaviBusinessJNI.OrderPassPoint_orderType_get(this.swigCPtr, this);
    }

    public void setPointType(int i) {
        NaviBusinessJNI.OrderPassPoint_pointType_set(this.swigCPtr, this, i);
    }

    public int getPointType() {
        return NaviBusinessJNI.OrderPassPoint_pointType_get(this.swigCPtr, this);
    }

    public OrderPassPoint() {
        this(NaviBusinessJNI.new_OrderPassPoint(), true);
    }
}
