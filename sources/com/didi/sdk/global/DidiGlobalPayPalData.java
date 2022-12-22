package com.didi.sdk.global;

import java.io.Serializable;

public class DidiGlobalPayPalData {
    public static final int BIND_TYPE_ESTIMATE = 8;
    public static final int BIND_TYPE_GUIDE = 5;
    public static final int BIND_TYPE_HIGH_RISK = 8;
    public static final int BIND_TYPE_SIDEBAR = 1;
    public static final int BIND_TYPE_UNIFIED_PAY = 4;
    public static final String PAYPAL_DEFAULT_CALL_BACK_URL = "https://pay.99taxis.mobi/web_wallet/passenger/withhold/v1/paypal/authentication/callback";
    public static final String PAYPAL_DEFAULT_CALL_CANCEL_URL = "https://pay.99taxis.mobi/web_wallet/passenger/withhold/v1/paypal/cancel/callback";
    public static final int RESP_CODE_CANCEL = 2;
    public static final int RESP_CODE_FAIL = 1;
    public static final int RESP_CODE_SUCCESS = 0;
    public static final String RESP_EXTRA_CODE = "errno";
    public static final String RESP_EXTRA_MESSAGE = "errmsg";

    public static class AddPayPalParam implements Serializable {
        public int bindType;
        public boolean isShowLoading = true;
    }

    public interface PayPalCallback {
        public static final int CODE_CANCEL = -1;
        public static final int CODE_FAILED = -2;
        public static final int CODE_OK = 0;

        void onResult(int i, String str);
    }

    public interface PayPalVerifyCallback {
        void onResult(int i, String str);
    }
}
