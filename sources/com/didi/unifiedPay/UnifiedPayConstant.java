package com.didi.unifiedPay;

public class UnifiedPayConstant {
    public static final String LANG_ZH = "zh-CN";

    public static class Extra {
        public static final String CODE = "code";
        public static final String MESSAGE = "message";
    }

    public static class MetaKey {
        public static final String THREE_DS_SDK_VERSION = "global.didi.pay.threeds.sdk.version";
        public static final String VIRTUAL_SDK_VERSION = "global.didi.unifiedPay.virtualSdkVersion";
    }

    public static class PayResult {
        public static final int CODE_METHOD_CHANGE = 5;
        public static final int CODE_PAY_FAILED = 3;
        public static final int CODE_PAY_SUCCESS = 1;
        public static final int CODE_PAY_SUCCESS_HOLD = 7;
        public static final int CODE_PIX_TIMEOUT = 4;
        public static final int CODE_USER_CANCEL = 2;
    }

    public static class Schemes {
        public static final String CASHIER_PAYPAY_99 = "cashierpaypay5";
        public static final String CASHIER_PAYPAY_GLOBAL = "cashierpaypay7";
        public static final String CASHIER_PAYPAY_SODA_USER_99 = "cashierpaypay300106";
        public static final String CASHIER_PAYPAY_SODA_USER_GLOBAL = "cashierpaypay300103";
        public static final String GLOBAL_DIDI_COMMON = "globaldidicommon";
    }

    public static class TerminalId {
        public static final int GLOBAL = 7;
        public static final int MAIN = 1;
    }

    public static class Url {
        public static final String PROTOCOL_URL = "";
        public static final String PROTOCOL_URL_EN = "";
    }
}
