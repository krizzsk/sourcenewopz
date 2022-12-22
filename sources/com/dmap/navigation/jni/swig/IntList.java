package com.dmap.navigation.jni.swig;

public class IntList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected IntList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IntList intList) {
        if (intList == null) {
            return 0;
        }
        return intList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_IntList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public IntList() {
        this(NaviBusinessJNI.new_IntList__SWIG_0(), true);
    }

    public IntList(long j) {
        this(NaviBusinessJNI.new_IntList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.IntList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.IntList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.IntList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.IntList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.IntList_clear(this.swigCPtr, this);
    }

    public void add(int i) {
        NaviBusinessJNI.IntList_add(this.swigCPtr, this, i);
    }

    public int get(int i) {
        return NaviBusinessJNI.IntList_get(this.swigCPtr, this, i);
    }

    public void set(int i, int i2) {
        NaviBusinessJNI.IntList_set(this.swigCPtr, this, i, i2);
    }
}
