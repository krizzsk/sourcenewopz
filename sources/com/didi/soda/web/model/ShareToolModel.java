package com.didi.soda.web.model;

import android.graphics.Bitmap;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.soda.web.config.WebConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareToolModel {

    /* renamed from: a */
    private static final Map<String, String> f43879a;
    public String content = "";
    public String customName = "";
    public HashMap<String, String> extra;
    public Bitmap imageData;
    public String imagePath;
    public String imageUrl;
    public String platformStr = "";
    public List<String> recipients;
    public String smsMessage = "";
    public String title = "";
    public String type;
    public String url;

    static {
        HashMap hashMap = new HashMap();
        f43879a = hashMap;
        hashMap.put("share_weixin_timeline", WebConstant.WXMOMENTS_PLATFORM);
        f43879a.put(InternalJSMethod.SHARE_WEIXIN_TIMELINE, WebConstant.WXMOMENTS_PLATFORM);
        f43879a.put("share_weixin_appmsg", WebConstant.WXCHAT_PLATFORM);
        f43879a.put(InternalJSMethod.SHARE_WEIXIN_APPMSG, WebConstant.WXCHAT_PLATFORM);
        f43879a.put("share_qq_appmsg", WebConstant.QQ_PLATFORM);
        f43879a.put(InternalJSMethod.SHARE_QQ_APPMSG, WebConstant.QQ_PLATFORM);
        f43879a.put(InternalJSMethod.SHARE_QZONE, WebConstant.QZONE_PLATFORM);
        f43879a.put("share_qzone", WebConstant.QZONE_PLATFORM);
        f43879a.put("share_alipay_friend", "ALIPAY_FRIENDS");
        f43879a.put(InternalJSMethod.SHARE_ALIPAY_FRIEND, "ALIPAY_FRIENDS");
        f43879a.put("share_alipay_life", "ALIPAY_TIMELINE");
        f43879a.put(InternalJSMethod.SHARE_ALIPAY_LIFE, "ALIPAY_TIMELINE");
        f43879a.put(InternalJSMethod.SHARE_FACEBOOK, WebConstant.FACEBOOK_PLATFORM);
        f43879a.put("shareFBMessenger", WebConstant.MESSENGER_PLATFORM);
        f43879a.put(InternalJSMethod.SHARE_WHATSAPP, WebConstant.WHATSAPP_PLATFORM);
        f43879a.put("shareTelegram", WebConstant.TELEGRAM_PLATFORM);
        f43879a.put("shareLine", WebConstant.LINE_PLATFORM);
        f43879a.put(InternalJSMethod.SHARE_TWITTER, WebConstant.TWITTER_PLATFORM);
        f43879a.put("shareSysMsg", WebConstant.SYSTEM_MESSAGE);
        f43879a.put(InternalJSMethod.SHARE_EMAIL, WebConstant.EMAIL_PLATFORM);
        f43879a.put("shareSystemEntrance", WebConstant.SYSTEM_ENTRANCE_PLATFORM);
        f43879a.put("shareCopyLink", WebConstant.COPY_LINK_PLATFORM);
    }

    public String toString() {
        return "OneKeyShareInfo{platformStr=" + this.platformStr + ", title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", url='" + this.url + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", imagePath='" + this.imagePath + '\'' + ", imageData=" + this.imageData + '\'' + ", smsMessage='" + this.smsMessage + '\'' + ", customName='" + this.customName + '\'' + '}';
    }

    public String getPlatFrom() {
        return f43879a.get(this.type);
    }
}
