package com.didi.onekeyshare.entity;

import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.onekeyshare.ShareConfig;
import com.didi.soda.web.config.WebConstant;
import com.taxis99.R;

public enum SharePlatform implements IPlatformDataCreator {
    WXMINIPRO_PLATFORM(16, "WxMiniPro", R.string.display_info_wechat_session_alias, R.string.display_info_wechat_session_productname, R.id.tone_share_wx_friends_id, R.drawable.tone_share_btn_weixin_friends_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    WXCHAT_PLATFORM(1, WebConstant.WXCHAT_PLATFORM, R.string.display_info_wechat_session_alias, R.string.display_info_wechat_session_productname, R.id.tone_share_wx_friends_id, R.drawable.tone_share_btn_weixin_friends_selector) {
        public PlatformData createPlatformData() {
            if (ShareConfig.getConfig().getNation() == ShareConfig.Nation.GLOBAL) {
                return new PlatformData(R.drawable.tone_share_btn_weixin_friends_gl_selector);
            }
            return null;
        }
    },
    WXMOMENTS_PLATFORM(2, WebConstant.WXMOMENTS_PLATFORM, R.string.display_info_wechat_timeline_alias, R.string.display_info_wechat_timeline_productname, R.id.tone_share_wx_moments_id, R.drawable.tone_share_btn_weixin_moments_selector) {
        public PlatformData createPlatformData() {
            if (ShareConfig.getConfig().getNation() == ShareConfig.Nation.GLOBAL) {
                return new PlatformData(R.drawable.tone_share_btn_weixin_moments_gl_selector);
            }
            return null;
        }
    },
    QQ_PLATFORM(3, WebConstant.QQ_PLATFORM, R.string.display_info_qq_alias, R.string.display_info_qq_productname, R.id.tone_share_qq_id, R.drawable.tone_share_btn_qq_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    QZONE_PLATFORM(4, WebConstant.QZONE_PLATFORM, R.string.display_info_qqzone_alias, R.string.display_info_qqzone_productname, R.id.tone_share_qzone_id, R.drawable.tone_share_btn_qzone_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    ALIPAY_FRIEND_PLAFORM(5, "ALIPAY_FRIENDS", R.string.display_info_alipay_session_alias, R.string.display_info_alipay_session_productname, R.id.tone_share_alipay_friend_id, R.drawable.tone_share_btn_alipay_friends_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    ALIPAY_CIRCLE_PLAFORM(6, "ALIPAY_TIMELINE", R.string.display_info_alipay_timeline_alias, R.string.display_info_alipay_timeline_productname, R.id.tone_share_alipay_circle_id, R.drawable.tone_share_btn_alipay_timeline_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    REFRESH_ICON(8, "page_refresh", R.string.page_refresh, R.string.page_refresh, R.id.tone_share_refresh_id, R.drawable.tone_share_icon_refresh_gl_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    SYSTEM_MESSAGE(7, WebConstant.SYSTEM_MESSAGE, R.string.display_info_sms_alias, R.string.display_info_sms_productname, R.id.tone_share_sys_msg_id, R.drawable.tone_share_btn_message_selector) {
        public PlatformData createPlatformData() {
            if (ShareConfig.getConfig().getNation() == ShareConfig.Nation.GLOBAL) {
                return new PlatformData(R.drawable.tone_share_icon_message_gl_selector);
            }
            return null;
        }
    },
    FACEBOOK_PLATFORM(9, WebConstant.FACEBOOK_PLATFORM, R.string.face_book_alias, R.string.face_book_alias, R.id.tone_share_facebook_id, R.drawable.tone_share_btn_facebook_selector) {
        public PlatformData createPlatformData() {
            if (ShareConfig.getConfig().getNation() == ShareConfig.Nation.GLOBAL) {
                return new PlatformData(R.drawable.tone_share_icon_facebook_gl_selector);
            }
            return null;
        }
    },
    MESSENGER_PLATFORM(10, WebConstant.MESSENGER_PLATFORM, R.string.messenger_alias, R.string.messenger_alias, R.id.tone_share_messenger_id, R.drawable.tone_share_btn_messenger_selector) {
        public PlatformData createPlatformData() {
            if (ShareConfig.getConfig().getNation() == ShareConfig.Nation.GLOBAL) {
                return new PlatformData(R.drawable.tone_share_icon_messenger_gl_selector);
            }
            return null;
        }
    },
    WHATSAPP_PLATFORM(11, WebConstant.WHATSAPP_PLATFORM, R.string.whatsapp_alias, R.string.whatsapp_alias, R.id.tone_share_whatsapp_id, R.drawable.tone_share_btn_whatsapp_selector) {
        public PlatformData createPlatformData() {
            if (ShareConfig.getConfig().getNation() == ShareConfig.Nation.GLOBAL) {
                return new PlatformData(R.drawable.tone_share_icon_whatsapp_gl_selector);
            }
            return null;
        }
    },
    LINE_PLATFORM(12, WebConstant.LINE_PLATFORM, R.string.line_alias, R.string.line_alias, R.id.tone_share_line_id, R.drawable.tone_share_btn_line_selector) {
        public PlatformData createPlatformData() {
            if (ShareConfig.getConfig().getNation() == ShareConfig.Nation.GLOBAL) {
                return new PlatformData(R.drawable.tone_share_icon_line_gl_selector);
            }
            return null;
        }
    },
    TWITTER_PLATFORM(13, WebConstant.TWITTER_PLATFORM, R.string.twitter_alias, R.string.twitter_alias, R.id.tone_share_twitter_id, R.drawable.tone_share_btn_twitter_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    EMAIL_PLATFORM(14, WebConstant.EMAIL_PLATFORM, R.string.email_alias, R.string.email_alias, R.id.tone_share_email_id, R.drawable.tone_share_btn_email_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    DINGD_DING_PLATFORM(15, "DingDing", R.string.dingding_alias, R.string.dingding_alias, R.id.tone_share_dingding_id, R.drawable.tone_share_btn_dinding_selector) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    UNKNOWN(-1, "", R.string.unknow, R.string.unknow, -1, -1) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    COPY_LINK_PLATFORM(16, WebConstant.COPY_LINK_PLATFORM, R.string.copylink_alias, R.string.copylink_alias, R.id.tone_share_copy_link_id, R.drawable.tone_share_icon_copy_link) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    CONTACTS_PLATFORM(17, InvitationPageActivity.CONTACTS, R.string.contacts_alias, R.string.contacts_alias, R.id.tone_share_contact_id, R.drawable.tone_share_icon_contacts_normal) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    WEIBO_PLATFORM(18, "weibo", R.string.display_info_weibo_alias, R.string.display_info_weibo_alias, R.id.tone_share_weibo_id, R.drawable.tone_share_icon_weibo_normal) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    SAVEIMAGE_PLATFORM(19, "saveImage", R.string.GRider_sharing_Save_PrKD, R.string.GRider_sharing_Save_PrKD, R.id.tone_share_download_id, R.drawable.tone_share_icon_download_normal) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    VK_PLATFORM(20, "vkontakte", R.string.display_info_vk, R.string.display_info_vk, R.id.tone_share_vk, R.drawable.tone_share_icon_vk_normal) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    TELEGRAM_PLATFORM(21, WebConstant.TELEGRAM_PLATFORM, R.string.GRider_CAR_Telegram_WpsY, R.string.GRider_CAR_Telegram_WpsY, R.id.tone_share_telegram, R.drawable.tone_share_icon_telegram_normal) {
        public PlatformData createPlatformData() {
            return null;
        }
    },
    SYSTEM_PLATFORM(22, WebConstant.SYSTEM_ENTRANCE_PLATFORM, R.string.GRider_Homepage0714_More_ZFoX, R.string.GRider_Homepage0714_More_ZFoX, R.id.tone_share_system, R.drawable.tone_share_icon_system_normal) {
        public PlatformData createPlatformData() {
            return null;
        }
    };
    
    private int alias;
    private int platformId;
    private String platformName;
    private int productName;
    private int resId;
    private int value;

    private SharePlatform(int i, String str, int i2, int i3, int i4, int i5) {
        this.value = 0;
        PlatformData createPlatformData = createPlatformData();
        if (createPlatformData != null) {
            this.resId = createPlatformData.f29770a;
        } else {
            this.resId = i5;
        }
        this.value = i;
        this.platformName = str;
        this.alias = i2;
        this.productName = i3;
        this.platformId = i4;
    }

    public static SharePlatform valueOf(int i) {
        switch (i) {
            case 1:
                return WXCHAT_PLATFORM;
            case 2:
                return WXMOMENTS_PLATFORM;
            case 3:
                return QQ_PLATFORM;
            case 4:
                return QZONE_PLATFORM;
            case 5:
                return ALIPAY_FRIEND_PLAFORM;
            case 6:
                return ALIPAY_CIRCLE_PLAFORM;
            case 7:
                return SYSTEM_MESSAGE;
            case 8:
                return REFRESH_ICON;
            case 9:
                return FACEBOOK_PLATFORM;
            case 10:
                return MESSENGER_PLATFORM;
            case 11:
                return WHATSAPP_PLATFORM;
            case 12:
                return LINE_PLATFORM;
            case 13:
                return TWITTER_PLATFORM;
            case 14:
                return EMAIL_PLATFORM;
            case 15:
                return DINGD_DING_PLATFORM;
            case 16:
                return COPY_LINK_PLATFORM;
            case 18:
                return WEIBO_PLATFORM;
            case 19:
                return SAVEIMAGE_PLATFORM;
            case 20:
                return VK_PLATFORM;
            case 21:
                return TELEGRAM_PLATFORM;
            case 22:
                return SYSTEM_PLATFORM;
            default:
                return UNKNOWN;
        }
    }

    public static SharePlatform valueName(String str) {
        if (WXCHAT_PLATFORM.platformName.equals(str)) {
            return WXCHAT_PLATFORM;
        }
        if (WXMOMENTS_PLATFORM.platformName.equals(str)) {
            return WXMOMENTS_PLATFORM;
        }
        if (QQ_PLATFORM.platformName.equals(str)) {
            return QQ_PLATFORM;
        }
        if (QZONE_PLATFORM.platformName.equals(str)) {
            return QZONE_PLATFORM;
        }
        if (ALIPAY_FRIEND_PLAFORM.platformName.equals(str)) {
            return ALIPAY_FRIEND_PLAFORM;
        }
        if (ALIPAY_CIRCLE_PLAFORM.platformName.equals(str)) {
            return ALIPAY_CIRCLE_PLAFORM;
        }
        if (SYSTEM_MESSAGE.platformName.equals(str)) {
            return SYSTEM_MESSAGE;
        }
        if (REFRESH_ICON.platformName.equals(str)) {
            return REFRESH_ICON;
        }
        if (TWITTER_PLATFORM.platformName().equals(str)) {
            return TWITTER_PLATFORM;
        }
        if (FACEBOOK_PLATFORM.platformName().equals(str)) {
            return FACEBOOK_PLATFORM;
        }
        if (MESSENGER_PLATFORM.platformName().equals(str)) {
            return MESSENGER_PLATFORM;
        }
        if (LINE_PLATFORM.platformName().equals(str)) {
            return LINE_PLATFORM;
        }
        if (WHATSAPP_PLATFORM.platformName().equals(str)) {
            return WHATSAPP_PLATFORM;
        }
        if (EMAIL_PLATFORM.platformName().equals(str)) {
            return EMAIL_PLATFORM;
        }
        if (DINGD_DING_PLATFORM.platformName().equals(str)) {
            return DINGD_DING_PLATFORM;
        }
        if (WEIBO_PLATFORM.platformName().equals(str)) {
            return WEIBO_PLATFORM;
        }
        if (SAVEIMAGE_PLATFORM.platformName().equals(str)) {
            return SAVEIMAGE_PLATFORM;
        }
        if (VK_PLATFORM.platformName().equals(str)) {
            return VK_PLATFORM;
        }
        if (TELEGRAM_PLATFORM.platformName().equals(str)) {
            return TELEGRAM_PLATFORM;
        }
        if (SYSTEM_PLATFORM.platformName.equals(str)) {
            return SYSTEM_PLATFORM;
        }
        if (COPY_LINK_PLATFORM.platformName.equals(str)) {
            return COPY_LINK_PLATFORM;
        }
        return UNKNOWN;
    }

    public int value() {
        return this.value;
    }

    public String platformName() {
        return this.platformName;
    }

    public int alias() {
        return this.alias;
    }

    public int productName() {
        return this.productName;
    }

    public int platformId() {
        return this.platformId;
    }

    public int resId() {
        return this.resId;
    }
}
