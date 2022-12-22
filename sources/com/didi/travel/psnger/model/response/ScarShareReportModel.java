package com.didi.travel.psnger.model.response;

public class ScarShareReportModel {
    public static final String CHANNEL_ALIPAY_CIRCLE = "12";
    public static final String CHANNEL_ALIPAY_FRIEND = "11";
    public static final String CHANNEL_EMAIL = "25";
    public static final String CHANNEL_FACEBOOK = "21";
    public static final String CHANNEL_LINE = "26";
    public static final String CHANNEL_MESSENGER = "24";
    public static final String CHANNEL_QQ = "5";
    public static final String CHANNEL_QZONE = "4";
    public static final String CHANNEL_SINA = "3";
    public static final String CHANNEL_TWITTER = "23";
    public static final String CHANNEL_WCHAR_CIRCLE = "1";
    public static final String CHANNEL_WCHAR_FRIEND = "2";
    public static final String CHANNEL_WHATSAPP = "22";
    public static final String EVENT_PAY_SHARE_SEND_HONGBAO_CK = "pay_share_send_hongbao_ck";
    public static final String EVENT_PAY_SHARE_SHARE_CHANNEL_CK = "pay_share_channel_ck";
    public static final String EVENT_PAY_SHARE_SHARE_SUC_CHANNEL_CK = "pay_share_suc_channel_ck";
    public static final String EVENT_PAY_SHARE_WINDOW_CANCEL_CK = "pay_share_window_cancle_ck";
    public static final String EVENT_PAY_SHARE_WINDOW_OK_CK = "pay_share_window_ok_ck";
    public static final String LOG_G_APP_PUBLIC_LOG = "g_app_public_log";
    public static final String PRODUCT_CAR = "1";
    public static final String PRODUCT_FLIER = "3";
    public String channel = "";
    public String event_id;
    public String isEndCmt = "";
    public String isnewuser = "";
    public String order_id;
    public String phone;
    public String product_id;
    public String system_type = "andriod";
    public String uid = "";

    public String toString() {
        return super.toString();
    }
}
