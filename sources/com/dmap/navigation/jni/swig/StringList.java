package com.dmap.navigation.jni.swig;

public class StringList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StringList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StringList stringList) {
        if (stringList == null) {
            return 0;
        }
        return stringList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_StringList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public StringList() {
        this(NaviBusinessJNI.new_StringList__SWIG_0(), true);
    }

    public StringList(long j) {
        this(NaviBusinessJNI.new_StringList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.StringList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.StringList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.StringList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.StringList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.StringList_clear(this.swigCPtr, this);
    }

    public void add(String str) {
        NaviBusinessJNI.StringList_add(this.swigCPtr, this, str);
    }

    public String get(int i) {
        return NaviBusinessJNI.StringList_get(this.swigCPtr, this, i);
    }

    public void set(int i, String str) {
        NaviBusinessJNI.StringList_set(this.swigCPtr, this, i, str);
    }
}
