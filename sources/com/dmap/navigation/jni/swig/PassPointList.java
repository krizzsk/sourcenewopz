package com.dmap.navigation.jni.swig;

public class PassPointList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected PassPointList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PassPointList passPointList) {
        if (passPointList == null) {
            return 0;
        }
        return passPointList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_PassPointList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public PassPointList() {
        this(NaviBusinessJNI.new_PassPointList__SWIG_0(), true);
    }

    public PassPointList(long j) {
        this(NaviBusinessJNI.new_PassPointList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.PassPointList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.PassPointList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.PassPointList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.PassPointList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.PassPointList_clear(this.swigCPtr, this);
    }

    public void add(PassPoint passPoint) {
        NaviBusinessJNI.PassPointList_add(this.swigCPtr, this, PassPoint.getCPtr(passPoint), passPoint);
    }

    public PassPoint get(int i) {
        return new PassPoint(NaviBusinessJNI.PassPointList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, PassPoint passPoint) {
        NaviBusinessJNI.PassPointList_set(this.swigCPtr, this, i, PassPoint.getCPtr(passPoint), passPoint);
    }
}
