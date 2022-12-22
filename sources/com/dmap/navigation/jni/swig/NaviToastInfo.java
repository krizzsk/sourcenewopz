package com.dmap.navigation.jni.swig;

public class NaviToastInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviToastInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviToastInfo naviToastInfo) {
        if (naviToastInfo == null) {
            return 0;
        }
        return naviToastInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviToastInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setType(int i) {
        NaviBusinessJNI.NaviToastInfo_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return NaviBusinessJNI.NaviToastInfo_type_get(this.swigCPtr, this);
    }

    public void setContent(String str) {
        NaviBusinessJNI.NaviToastInfo_content_set(this.swigCPtr, this, str);
    }

    public String getContent() {
        return NaviBusinessJNI.NaviToastInfo_content_get(this.swigCPtr, this);
    }

    public NaviToastInfo() {
        this(NaviBusinessJNI.new_NaviToastInfo(), true);
    }
}
