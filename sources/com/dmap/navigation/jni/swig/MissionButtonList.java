package com.dmap.navigation.jni.swig;

public class MissionButtonList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MissionButtonList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MissionButtonList missionButtonList) {
        if (missionButtonList == null) {
            return 0;
        }
        return missionButtonList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_MissionButtonList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MissionButtonList() {
        this(NaviBusinessJNI.new_MissionButtonList__SWIG_0(), true);
    }

    public MissionButtonList(long j) {
        this(NaviBusinessJNI.new_MissionButtonList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.MissionButtonList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.MissionButtonList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.MissionButtonList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.MissionButtonList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.MissionButtonList_clear(this.swigCPtr, this);
    }

    public void add(MissionButtonInfo missionButtonInfo) {
        NaviBusinessJNI.MissionButtonList_add(this.swigCPtr, this, MissionButtonInfo.getCPtr(missionButtonInfo), missionButtonInfo);
    }

    public MissionButtonInfo get(int i) {
        return new MissionButtonInfo(NaviBusinessJNI.MissionButtonList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, MissionButtonInfo missionButtonInfo) {
        NaviBusinessJNI.MissionButtonList_set(this.swigCPtr, this, i, MissionButtonInfo.getCPtr(missionButtonInfo), missionButtonInfo);
    }
}
