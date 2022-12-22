package com.didi.sdk.component.share;

import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShareReportModel {
    public static final String CHANNEL_QQ = "5";
    public static final String CHANNEL_QZONE = "4";
    public static final String CHANNEL_SINA = "3";
    public static final String CHANNEL_WCHAR_CIRCLE = "1";
    public static final String CHANNEL_WCHAR_FRIEND = "2";
    public static final String EVENT_PAY_SHARE_SEND_HONGBAO_CK = "pay_share_send_hongbao_ck";
    public static final String EVENT_PAY_SHARE_SHARE_CHANNEL_CK = "pay_share_channel_ck";
    public static final String EVENT_PAY_SHARE_SHARE_SUC_CHANNEL_CK = "pay_share_suc_channel_ck";
    public static final String EVENT_PAY_SHARE_WINDOW_CANCEL_CK = "pay_share_window_cancle_ck";
    public static final String EVENT_PAY_SHARE_WINDOW_OK_CK = "pay_share_window_ok_ck";
    public static final String LOG_G_APP_PUBLIC_LOG = "g_app_public_log";
    public static final String PRODUCT_CAR = "1";
    public static final String PRODUCT_FLIER = "3";
    public static final String PRODUCT_TAXI = "0";
    public String app_version = SystemUtil.getVersionName();
    public String channel = "";
    public String client_time = formatDate(System.currentTimeMillis());
    public String event_id;
    public String isEndCmt = "";
    public String isnewuser = "";
    public String order_id;
    public String product_id;
    public String system_type = "andriod";
    public String uid = "";

    public String toString() {
        return "[product_id=" + this.product_id + "][event_id=" + this.event_id + "][channel=" + this.channel + "][order_id=" + this.order_id + "][client_time=" + this.client_time + "][system_type=" + this.system_type + "][app_version=" + this.app_version + "][isnew=" + this.isnewuser + "][uid=" + this.uid + "][isendcmt=" + this.isEndCmt + Const.jaRight;
    }

    public static String formatDate(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }
}
