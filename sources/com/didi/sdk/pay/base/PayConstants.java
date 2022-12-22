package com.didi.sdk.pay.base;

@Deprecated
public class PayConstants {
    public static String SIGN_KEY = "*&didi@";

    public static class AppId {
        public static final String WEIXIN_CAR_APP_ID = "wx7e8eef23216bade2";
        public static String WEIXIN_TOUSER_NAME = "gh_fb617b8e284b";
    }

    public static class Net {
        public static final int ACCESS_TOKEN_INVALID = 101;
        public static final int INVALID_TOKEN = 101;

        /* renamed from: OK */
        public static final int f36890OK = 0;
        public static final int SYSTEM_BUSY = 10006;
        public static final int TOKEN_FAILED = 1011;
    }

    public static class Verify {
        public static final int CHANNEL_CASH = 153;
    }
}
