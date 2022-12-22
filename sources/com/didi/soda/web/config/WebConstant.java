package com.didi.soda.web.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface WebConstant {
    public static final int ALBUM = 2;
    public static final String ALIPAY_FRIENDS_NAME = "ALIPAY_FRIENDS";
    public static final String ALIPAY_FRIENDS_TIMELINE = "ALIPAY_TIMELINE";
    public static final int CAMERA = 1;
    public static final String COPY_LINK_PLATFORM = "copyLink";
    public static final String EMAIL_PLATFORM = "Email";
    public static final String FACEBOOK_PLATFORM = "FACEBOOK";
    public static final String FUSION_PACKAGED = "fusion_packaged";
    public static final String LINE_PLATFORM = "LINE";
    public static final String MESSENGER_PLATFORM = "MESSENGER";
    @Deprecated
    public static final String NATIVE_SCHEME = "soda";
    public static final String PARAM_APP_VERSION = "appversion";
    public static final String PARAM_BIZTYPE = "biz_type";
    public static final String PARAM_CHANNEL = "channel";
    public static final String PARAM_COVER_LAT = "lat";
    public static final String PARAM_COVER_LNG = "lng";
    public static final String PARAM_DEVICE_ID = "deviceid";
    public static final String PARAM_LANG = "lang";
    public static final String PARAM_LOCALE = "locale";
    public static final String PARAM_MAP_TYPE = "maptype";
    public static final String PARAM_MODEL = "model";
    public static final String PARAM_OS = "os";
    public static final String PARAM_SUSIGN = "sig";
    public static final String PROGRESSBAR_COLOR = "progressbar_color";
    public static final String QQ_PLATFORM = "QQ";
    public static final String QZONE_PLATFORM = "QZone";
    public static final String READ_TIMEOUT = "read_timeout";
    public static final String SYSTEM_ENTRANCE_PLATFORM = "system";
    public static final String SYSTEM_MESSAGE = "SYSTEM_MESSAGE";
    public static final String TELEGRAM_PLATFORM = "telegram";
    public static final String TITLE_BAR_BACKGROUND_COLOR = "title_bar_background_color";
    public static final String TITLE_BAR_TEXT_COLOR = "title_bar_text_color";
    public static final String TWITTER_PLATFORM = "Twitter";
    public static final String TYPE_ALIPAY = "ali";
    public static final String TYPE_WEIXIN = "weixin";
    public static final String UI_TARGET_HIDE_ENTRANCE = "soda_hide_entrance";
    public static final String UI_TARGET_INIT_ENTRANCE = "soda_init_entrance";
    public static final String UI_TARGET_INVOKE_ENTRANCE = "soda_invoke_entrance";
    public static final String UI_TARGET_SHOW_ENTRANCE = "soda_show_entrance";
    public static final String UI_TARGET_SHOW_SYSTEM_ENTRANCE = "soda_show_system_entrance";
    public static final String UI_TARGET_UPDATA_NAV = "soda_updata_nav";
    public static final String UI_TARGET_WEB_TITLE = "soda_web_title";
    public static final String WEBPAGE = "webPage";
    public static final String WEB_FILE_PATH = ".web.fileprovider";
    public static final String WEB_LOG_TAG = "WebPage";
    public static final String WEB_MODEL = "WebPage.Key.WebConfig";
    public static final String WEB_PARAMS = "params";
    public static final String WEB_TITLE = "title";
    public static final String WEB_URL = "url";
    public static final String WHATSAPP_PLATFORM = "WHATSAPP";
    public static final String WXCHAT_PLATFORM = "Wechat";
    public static final String WXMOMENTS_PLATFORM = "WechatMoments";

    public static final class BridgeMethod {
        public static final String GET_PHOTO = "getPhoto";
    }

    public static final class JsResponse {
        public static final String DATA_KEY = "data";
        public static final String ERROR_MSG_FAILED = "failed";
        public static final String ERROR_MSG_KEY = "errmsg";
        public static final String ERROR_MSG_SUCCESS = "ok";
        public static final int ERROR_NO_AUTHORIZE = -1;
        public static final int ERROR_NO_CANCLE = 2;
        public static final int ERROR_NO_FAILED = 1;
        public static final String ERROR_NO_KEY = "errno";
        public static final int ERROR_NO_SUCCESS = 0;
    }

    public static final class Transfer {
        public static final String TRANSFER_CANERA_PIC_NAME = "web_temp.jpg";
        public static final String TRANSFER_PAGE_DATA = "transfer_page_data";
        public static final String TRANSFER_PAGE_PATH = "WebPage/Transfer_Page";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferType {
    }
}
