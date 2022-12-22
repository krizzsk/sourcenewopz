package com.dmap.navigation.jni.swig;

public class BindNaviLocation extends NaviLocation {
    private transient long swigCPtr;

    protected BindNaviLocation(long j, boolean z) {
        super(NaviBusinessJNI.BindNaviLocation_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(BindNaviLocation bindNaviLocation) {
        if (bindNaviLocation == null) {
            return 0;
        }
        return bindNaviLocation.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_BindNaviLocation(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public void setIndex(int i) {
        NaviBusinessJNI.BindNaviLocation_index_set(this.swigCPtr, this, i);
    }

    public int getIndex() {
        return NaviBusinessJNI.BindNaviLocation_index_get(this.swigCPtr, this);
    }

    public BindNaviLocation() {
        this(NaviBusinessJNI.new_BindNaviLocation(), true);
    }
}
