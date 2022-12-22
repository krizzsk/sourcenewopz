package com.didi.onekeyshare.util;

public class Contants {
    public static final int INTENT_SHARE_REQUEST_CODE = 1001;

    public static class SHARE_INTENT_PACKAGE_NAME {
        public static final String PACKAGE_NAME_LINE = "jp.naver.line.android";
        public static final String PACKAGE_NAME_MESSENGER = "com.facebook.orca";
        public static final String PACKAGE_NAME_TWITTER = "com.twitter.android";
        public static final String PACKAGE_NAME_WHATSAPP = "com.whatsapp";
        public static final String PACKAGE_TELEGRAM = "org.telegram.messenger";
        public static final String PACKAGE_VK = "com.vkontakte.android";
    }

    public static class SHARE_INTENT_SENDTYPE {
        public static final String INTENT_TYPE_IMAGE = "image/jpg";
        public static final String INTENT_TYPE_TEXT = "text/plain";
    }
}
