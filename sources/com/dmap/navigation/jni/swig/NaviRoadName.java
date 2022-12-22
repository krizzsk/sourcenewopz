package com.dmap.navigation.jni.swig;

public class NaviRoadName {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviRoadName(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviRoadName naviRoadName) {
        if (naviRoadName == null) {
            return 0;
        }
        return naviRoadName.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviRoadName(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setName(String str) {
        NaviBusinessJNI.NaviRoadName_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return NaviBusinessJNI.NaviRoadName_name_get(this.swigCPtr, this);
    }

    public void setStartNum(int i) {
        NaviBusinessJNI.NaviRoadName_startNum_set(this.swigCPtr, this, i);
    }

    public int getStartNum() {
        return NaviBusinessJNI.NaviRoadName_startNum_get(this.swigCPtr, this);
    }

    public void setEndNum(int i) {
        NaviBusinessJNI.NaviRoadName_endNum_set(this.swigCPtr, this, i);
    }

    public int getEndNum() {
        return NaviBusinessJNI.NaviRoadName_endNum_get(this.swigCPtr, this);
    }

    public NaviRoadName() {
        this(NaviBusinessJNI.new_NaviRoadName(), true);
    }
}
