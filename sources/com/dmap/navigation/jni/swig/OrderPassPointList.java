package com.dmap.navigation.jni.swig;

public class OrderPassPointList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected OrderPassPointList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OrderPassPointList orderPassPointList) {
        if (orderPassPointList == null) {
            return 0;
        }
        return orderPassPointList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_OrderPassPointList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OrderPassPointList() {
        this(NaviBusinessJNI.new_OrderPassPointList__SWIG_0(), true);
    }

    public OrderPassPointList(long j) {
        this(NaviBusinessJNI.new_OrderPassPointList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.OrderPassPointList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.OrderPassPointList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.OrderPassPointList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.OrderPassPointList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.OrderPassPointList_clear(this.swigCPtr, this);
    }

    public void add(OrderPassPoint orderPassPoint) {
        NaviBusinessJNI.OrderPassPointList_add(this.swigCPtr, this, OrderPassPoint.getCPtr(orderPassPoint), orderPassPoint);
    }

    public OrderPassPoint get(int i) {
        return new OrderPassPoint(NaviBusinessJNI.OrderPassPointList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, OrderPassPoint orderPassPoint) {
        NaviBusinessJNI.OrderPassPointList_set(this.swigCPtr, this, i, OrderPassPoint.getCPtr(orderPassPoint), orderPassPoint);
    }
}
