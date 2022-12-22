package com.didi.sdk.push;

import android.content.Context;

interface IPush {

    public static class BusinessType {
        public static int BUSINESS_TYPE_DQUIC = 3;
        public static int BUSINESS_TYPE_NORMAL = 1;
        public static int BUSINESS_TYPE_TLS = 2;
    }

    void config(PushConfig pushConfig);

    void configLite(PushConfig pushConfig);

    void destroy();

    void init(Context context);

    boolean isConnected();

    int localIPStackDetect();

    void onAppEvent(int i, int i2);

    int request(PushRequest pushRequest, PushRequestCallback pushRequestCallback);

    void setBusinessType(int i);

    void setDebugMode(int i);

    void setPushCallback(IPushCallback iPushCallback);

    void startConnChannel(PushConnParam pushConnParam);

    void startLoop();

    void stopConnChannel();

    void stopLoop();
}
