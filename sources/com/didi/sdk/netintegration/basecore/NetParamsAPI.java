package com.didi.sdk.netintegration.basecore;

import android.content.Context;
import didihttpdns.model.DnsParam;
import didihttpdns.security.InterceptorGetter;

public interface NetParamsAPI {
    public static final NetParamsAPI NONE = new NetParamsAPI() {
        public int getCityID(Context context) {
            return 0;
        }

        public DnsParam getDnsParam() {
            return null;
        }

        public int getFlowTag() {
            return 0;
        }

        public InterceptorGetter getSignInterceptorGetter() {
            return null;
        }

        public String getTerminalTag() {
            return null;
        }

        public boolean getTransEnable(Context context) {
            return false;
        }

        public String getUid() {
            return null;
        }

        public boolean manualInitHttpDns() {
            return false;
        }
    };

    int getCityID(Context context);

    DnsParam getDnsParam();

    int getFlowTag();

    InterceptorGetter getSignInterceptorGetter();

    String getTerminalTag();

    boolean getTransEnable(Context context);

    String getUid();

    boolean manualInitHttpDns();
}
