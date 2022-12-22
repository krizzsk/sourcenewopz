package com.dmap.navigation.jni.swig;

public class NaviGetter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviGetter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviGetter naviGetter) {
        if (naviGetter == null) {
            return 0;
        }
        return naviGetter.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviGetter(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        NaviBusinessJNI.NaviGetter_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.NaviGetter_change_ownership(this, this.swigCPtr, true);
    }

    public String getTextByKey(String str) {
        return getClass() == NaviGetter.class ? NaviBusinessJNI.NaviGetter_getTextByKey(this.swigCPtr, this, str) : NaviBusinessJNI.NaviGetter_getTextByKeySwigExplicitNaviGetter(this.swigCPtr, this, str);
    }

    public NaviGetter() {
        this(NaviBusinessJNI.new_NaviGetter(), true);
        NaviBusinessJNI.NaviGetter_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
