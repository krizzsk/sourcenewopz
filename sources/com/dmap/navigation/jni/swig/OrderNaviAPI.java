package com.dmap.navigation.jni.swig;

public class OrderNaviAPI extends BaseNaviAPI {
    private transient long swigCPtr;

    protected OrderNaviAPI(long j, boolean z) {
        super(NaviBusinessJNI.OrderNaviAPI_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(OrderNaviAPI orderNaviAPI) {
        if (orderNaviAPI == null) {
            return 0;
        }
        return orderNaviAPI.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_OrderNaviAPI(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public OrderNaviAPI(UserInfo userInfo, OrderInfo orderInfo, NaviOption naviOption) {
        this(NaviBusinessJNI.new_OrderNaviAPI(UserInfo.getCPtr(userInfo), userInfo, OrderInfo.getCPtr(orderInfo), orderInfo, NaviOption.getCPtr(naviOption), naviOption), true);
    }
}
