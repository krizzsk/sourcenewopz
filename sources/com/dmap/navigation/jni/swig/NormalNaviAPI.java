package com.dmap.navigation.jni.swig;

public class NormalNaviAPI extends BaseNaviAPI {
    private transient long swigCPtr;

    protected NormalNaviAPI(long j, boolean z) {
        super(NaviBusinessJNI.NormalNaviAPI_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(NormalNaviAPI normalNaviAPI) {
        if (normalNaviAPI == null) {
            return 0;
        }
        return normalNaviAPI.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NormalNaviAPI(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public NormalNaviAPI(UserInfo userInfo, NaviOption naviOption) {
        this(NaviBusinessJNI.new_NormalNaviAPI(UserInfo.getCPtr(userInfo), userInfo, NaviOption.getCPtr(naviOption), naviOption), true);
    }
}
