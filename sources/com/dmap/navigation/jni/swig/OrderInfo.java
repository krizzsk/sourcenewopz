package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class OrderInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OrderInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OrderInfo orderInfo) {
        if (orderInfo == null) {
            return 0;
        }
        return orderInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_OrderInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setOrderId(String str) {
        NaviBusinessJNI.OrderInfo_orderId_set(this.swigCPtr, this, str);
    }

    public String getOrderId() {
        return NaviBusinessJNI.OrderInfo_orderId_get(this.swigCPtr, this);
    }

    public void setOrderStage(int i) {
        NaviBusinessJNI.OrderInfo_orderStage_set(this.swigCPtr, this, i);
    }

    public int getOrderStage() {
        return NaviBusinessJNI.OrderInfo_orderStage_get(this.swigCPtr, this);
    }

    public void setPassengerId(String str) {
        NaviBusinessJNI.OrderInfo_passengerId_set(this.swigCPtr, this, str);
    }

    public String getPassengerId() {
        return NaviBusinessJNI.OrderInfo_passengerId_get(this.swigCPtr, this);
    }

    public void setTraverId(String str) {
        NaviBusinessJNI.OrderInfo_traverId_set(this.swigCPtr, this, str);
    }

    public String getTraverId() {
        return NaviBusinessJNI.OrderInfo_traverId_get(this.swigCPtr, this);
    }

    public void setPsgMultiRouteTraceId(String str) {
        NaviBusinessJNI.OrderInfo_psgMultiRouteTraceId_set(this.swigCPtr, this, str);
    }

    public String getPsgMultiRouteTraceId() {
        return NaviBusinessJNI.OrderInfo_psgMultiRouteTraceId_get(this.swigCPtr, this);
    }

    public void setPassPoints(OrderPassPointList orderPassPointList) {
        NaviBusinessJNI.OrderInfo_passPoints_set(this.swigCPtr, this, OrderPassPointList.getCPtr(orderPassPointList), orderPassPointList);
    }

    public OrderPassPointList getPassPoints() {
        long OrderInfo_passPoints_get = NaviBusinessJNI.OrderInfo_passPoints_get(this.swigCPtr, this);
        if (OrderInfo_passPoints_get == 0) {
            return null;
        }
        return new OrderPassPointList(OrderInfo_passPoints_get, false);
    }

    public void setOdPointsTimestamp(BigInteger bigInteger) {
        NaviBusinessJNI.OrderInfo_odPointsTimestamp_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getOdPointsTimestamp() {
        return NaviBusinessJNI.OrderInfo_odPointsTimestamp_get(this.swigCPtr, this);
    }

    public OrderInfo() {
        this(NaviBusinessJNI.new_OrderInfo(), true);
    }
}
