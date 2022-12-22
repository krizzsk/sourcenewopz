package com.dmap.navigation.jni.swig;

public class NaviMJOLinkInfoList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviMJOLinkInfoList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviMJOLinkInfoList naviMJOLinkInfoList) {
        if (naviMJOLinkInfoList == null) {
            return 0;
        }
        return naviMJOLinkInfoList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviMJOLinkInfoList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public NaviMJOLinkInfoList() {
        this(NaviBusinessJNI.new_NaviMJOLinkInfoList__SWIG_0(), true);
    }

    public NaviMJOLinkInfoList(long j) {
        this(NaviBusinessJNI.new_NaviMJOLinkInfoList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.NaviMJOLinkInfoList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.NaviMJOLinkInfoList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.NaviMJOLinkInfoList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.NaviMJOLinkInfoList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.NaviMJOLinkInfoList_clear(this.swigCPtr, this);
    }

    public void add(NaviMJOLinkInfo naviMJOLinkInfo) {
        NaviBusinessJNI.NaviMJOLinkInfoList_add(this.swigCPtr, this, NaviMJOLinkInfo.getCPtr(naviMJOLinkInfo), naviMJOLinkInfo);
    }

    public NaviMJOLinkInfo get(int i) {
        return new NaviMJOLinkInfo(NaviBusinessJNI.NaviMJOLinkInfoList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, NaviMJOLinkInfo naviMJOLinkInfo) {
        NaviBusinessJNI.NaviMJOLinkInfoList_set(this.swigCPtr, this, i, NaviMJOLinkInfo.getCPtr(naviMJOLinkInfo), naviMJOLinkInfo);
    }
}
