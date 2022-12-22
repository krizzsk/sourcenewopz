package com.didi.sdk.global;

import java.io.Serializable;

public class DidiGlobalPayPayData {

    public static class AddPayPayParam implements Serializable {
        public static final int BIND_TYPE_ESTIMATE = 8;
        public static final int BIND_TYPE_GUIDE = 5;
        public static final int BIND_TYPE_HIGH_RISK = 8;
        public static final int BIND_TYPE_SIDEBAR = 1;
        public static final int BIND_TYPE_UNIFIED_PAY = 4;
        public int bindType;
    }

    public interface PayPayCallback {
        public static final int CODE_CANCEL = -1;
        public static final int CODE_FAILED = -2;
        public static final int CODE_OK = 0;

        void onResult(int i, String str);
    }
}
