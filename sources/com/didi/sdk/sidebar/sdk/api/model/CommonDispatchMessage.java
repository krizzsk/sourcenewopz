package com.didi.sdk.sidebar.sdk.api.model;

import android.os.Message;

public class CommonDispatchMessage {
    public static final int WHAT_RESPONSE_ERROR = 2;
    public static final int WHAT_RESPONSE_FIRST_NAME_ERROR = 1102;
    public static final int WHAT_RESPONSE_LAST_NAME_ERROR = 1101;
    public static final int WHAT_RESPONSE_NETWORK_ERROR = 3;
    public static final int WHAT_RESPONSE_SUCCESS = 1;

    public static Message getSuccessMessage(Object obj) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        return obtain;
    }

    public static Message getErrorMessage(Object obj) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = obj;
        return obtain;
    }

    public static Message getNetworkErrorMessage() {
        return getNetworkErrorMessage((Object) null);
    }

    public static Message getNetworkErrorMessage(Object obj) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = obj;
        return obtain;
    }

    public static Message getCustomMessage(int i, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    public static Message getCustomMessage(int i, Object obj, int i2, int i3) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        return obtain;
    }
}
