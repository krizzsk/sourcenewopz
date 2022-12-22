package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class LongList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected LongList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(LongList longList) {
        if (longList == null) {
            return 0;
        }
        return longList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_LongList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public LongList() {
        this(NaviBusinessJNI.new_LongList__SWIG_0(), true);
    }

    public LongList(long j) {
        this(NaviBusinessJNI.new_LongList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.LongList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.LongList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.LongList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.LongList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.LongList_clear(this.swigCPtr, this);
    }

    public void add(BigInteger bigInteger) {
        NaviBusinessJNI.LongList_add(this.swigCPtr, this, bigInteger);
    }

    public BigInteger get(int i) {
        return NaviBusinessJNI.LongList_get(this.swigCPtr, this, i);
    }

    public void set(int i, BigInteger bigInteger) {
        NaviBusinessJNI.LongList_set(this.swigCPtr, this, i, bigInteger);
    }
}
