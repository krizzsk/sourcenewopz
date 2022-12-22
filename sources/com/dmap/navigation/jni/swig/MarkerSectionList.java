package com.dmap.navigation.jni.swig;

public class MarkerSectionList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MarkerSectionList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MarkerSectionList markerSectionList) {
        if (markerSectionList == null) {
            return 0;
        }
        return markerSectionList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_MarkerSectionList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MarkerSectionList() {
        this(NaviBusinessJNI.new_MarkerSectionList__SWIG_0(), true);
    }

    public MarkerSectionList(long j) {
        this(NaviBusinessJNI.new_MarkerSectionList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.MarkerSectionList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.MarkerSectionList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.MarkerSectionList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.MarkerSectionList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.MarkerSectionList_clear(this.swigCPtr, this);
    }

    public void add(MarkerSection markerSection) {
        NaviBusinessJNI.MarkerSectionList_add(this.swigCPtr, this, MarkerSection.getCPtr(markerSection), markerSection);
    }

    public MarkerSection get(int i) {
        return new MarkerSection(NaviBusinessJNI.MarkerSectionList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, MarkerSection markerSection) {
        NaviBusinessJNI.MarkerSectionList_set(this.swigCPtr, this, i, MarkerSection.getCPtr(markerSection), markerSection);
    }
}
