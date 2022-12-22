package com.didi.sdk.webview.tool;

import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.C10429QQ;
import com.didi.onekeyshare.util.QZone;
import com.didi.onekeyshare.util.Wechat;
import com.didi.onekeyshare.util.WechatMoments;
import com.didi.sharesdk.OneKeyShareModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebViewToolModel {

    /* renamed from: a */
    private static final Map<String, WebViewToolModel> f38507a = new HashMap();

    /* renamed from: b */
    private static final Map<String, SharePlatform> f38508b = new HashMap();
    public static List<String> webViewModels;
    public String icon = "";
    public String message = "";
    public String name;
    public OneKeyShareModel onkKeyShareModel;
    public String phone = "";
    public String redirect_url;
    public int resId = -1;
    public String type;

    static {
        m27295a("share_weixin_timeline", WechatMoments.NAME, R.drawable.share_btn_weixincircle_normal);
        m27295a(InternalJSMethod.SHARE_WEIXIN_TIMELINE, WechatMoments.NAME, R.drawable.share_btn_weixincircle_normal);
        m27295a("share_weixin_appmsg", Wechat.NAME, R.drawable.share_btn_weixin_normal);
        m27295a(InternalJSMethod.SHARE_WEIXIN_APPMSG, Wechat.NAME, R.drawable.share_btn_weixin_normal);
        m27295a("share_qq_appmsg", Wechat.NAME, R.drawable.share_btn_qq_normal);
        m27295a(InternalJSMethod.SHARE_QQ_APPMSG, C10429QQ.NAME, R.drawable.share_btn_qq_normal);
        m27295a("share_qzone", QZone.NAME, R.drawable.share_btn_qzone_normal);
        m27295a(InternalJSMethod.SHARE_QZONE, QZone.NAME, R.drawable.share_btn_qzone_normal);
        m27295a("share_alipay_friend", "ALIPAY_FRIENDS", R.drawable.share_btn_alipay_friends);
        m27295a(InternalJSMethod.SHARE_ALIPAY_FRIEND, "ALIPAY_FRIENDS", R.drawable.share_btn_alipay_friends);
        m27295a("share_alipay_life", "ALIPAY_TIMELINE", R.drawable.share_btn_alipay_timeline);
        m27295a(InternalJSMethod.SHARE_ALIPAY_LIFE, "ALIPAY_TIMELINE", R.drawable.share_btn_alipay_timeline);
        m27295a("share_sys_msg", SharePlatform.SYSTEM_MESSAGE.platformName(), SharePlatform.SYSTEM_MESSAGE.resId());
        m27295a("shareSysMsg", SharePlatform.SYSTEM_MESSAGE.platformName(), SharePlatform.SYSTEM_MESSAGE.resId());
        m27295a(InternalJSMethod.SHARE_FACEBOOK, SharePlatform.FACEBOOK_PLATFORM.platformName(), SharePlatform.FACEBOOK_PLATFORM.resId());
        m27295a("shareFBMessenger", SharePlatform.MESSENGER_PLATFORM.platformName(), SharePlatform.MESSENGER_PLATFORM.resId());
        m27295a(InternalJSMethod.SHARE_WHATSAPP, SharePlatform.WHATSAPP_PLATFORM.platformName(), SharePlatform.WHATSAPP_PLATFORM.resId());
        m27295a("shareLine", SharePlatform.LINE_PLATFORM.platformName(), SharePlatform.LINE_PLATFORM.resId());
        m27295a(InternalJSMethod.SHARE_TWITTER, SharePlatform.TWITTER_PLATFORM.platformName(), SharePlatform.TWITTER_PLATFORM.resId());
        m27295a(InternalJSMethod.SHARE_EMAIL, SharePlatform.EMAIL_PLATFORM.platformName(), SharePlatform.EMAIL_PLATFORM.resId());
        m27295a("page_refresh", (String) null, SharePlatform.REFRESH_ICON.resId());
        m27295a("refreshPage", (String) null, SharePlatform.REFRESH_ICON.resId());
        f38508b.put("share_weixin_timeline", SharePlatform.WXMOMENTS_PLATFORM);
        f38508b.put(InternalJSMethod.SHARE_WEIXIN_TIMELINE, SharePlatform.WXMOMENTS_PLATFORM);
        f38508b.put("share_weixin_appmsg", SharePlatform.WXCHAT_PLATFORM);
        f38508b.put(InternalJSMethod.SHARE_WEIXIN_APPMSG, SharePlatform.WXCHAT_PLATFORM);
        f38508b.put("share_qq_appmsg", SharePlatform.QQ_PLATFORM);
        f38508b.put(InternalJSMethod.SHARE_QQ_APPMSG, SharePlatform.QQ_PLATFORM);
        f38508b.put(InternalJSMethod.SHARE_QZONE, SharePlatform.QZONE_PLATFORM);
        f38508b.put("share_qzone", SharePlatform.QZONE_PLATFORM);
        f38508b.put("share_alipay_friend", SharePlatform.ALIPAY_FRIEND_PLAFORM);
        f38508b.put(InternalJSMethod.SHARE_ALIPAY_FRIEND, SharePlatform.ALIPAY_FRIEND_PLAFORM);
        f38508b.put("share_alipay_life", SharePlatform.ALIPAY_CIRCLE_PLAFORM);
        f38508b.put(InternalJSMethod.SHARE_ALIPAY_LIFE, SharePlatform.ALIPAY_CIRCLE_PLAFORM);
        f38508b.put("share_sys_msg", SharePlatform.SYSTEM_MESSAGE);
        f38508b.put("shareSysMsg", SharePlatform.SYSTEM_MESSAGE);
        f38508b.put(InternalJSMethod.SHARE_FACEBOOK, SharePlatform.FACEBOOK_PLATFORM);
        f38508b.put("shareFBMessenger", SharePlatform.MESSENGER_PLATFORM);
        f38508b.put(InternalJSMethod.SHARE_WHATSAPP, SharePlatform.WHATSAPP_PLATFORM);
        f38508b.put("shareLine", SharePlatform.LINE_PLATFORM);
        f38508b.put(InternalJSMethod.SHARE_TWITTER, SharePlatform.TWITTER_PLATFORM);
        f38508b.put(InternalJSMethod.SHARE_EMAIL, SharePlatform.EMAIL_PLATFORM);
        f38508b.put("refreshPage", SharePlatform.REFRESH_ICON);
        f38508b.put("page_refresh", SharePlatform.REFRESH_ICON);
    }

    public static SharePlatform getPlatform(String str) {
        return f38508b.get(str);
    }

    /* renamed from: a */
    private static void m27295a(String str, String str2, int i) {
        WebViewToolModel webViewToolModel = new WebViewToolModel();
        webViewToolModel.resId = i;
        if (str2 != null) {
            webViewToolModel.onkKeyShareModel = new OneKeyShareModel(str2);
        }
        f38507a.put(str, webViewToolModel);
    }

    public static boolean contains(String str) {
        return f38507a.containsKey(str);
    }

    public static WebViewToolModel getH5ShareModel(String str) {
        return f38507a.get(str);
    }

    @Deprecated
    public static List<String> getWebViewModels() {
        List<String> list = webViewModels;
        if (list == null || list.size() < 0) {
            ArrayList arrayList = new ArrayList();
            webViewModels = arrayList;
            arrayList.add("share_weixin_timeline");
            webViewModels.add(InternalJSMethod.SHARE_WEIXIN_TIMELINE);
            webViewModels.add("share_weixin_appmsg");
            webViewModels.add(InternalJSMethod.SHARE_WEIXIN_APPMSG);
            webViewModels.add("share_qq_appmsg");
            webViewModels.add(InternalJSMethod.SHARE_QQ_APPMSG);
            webViewModels.add("share_qzone");
            webViewModels.add(InternalJSMethod.SHARE_QZONE);
            webViewModels.add("share_alipay_friend");
            webViewModels.add(InternalJSMethod.SHARE_ALIPAY_FRIEND);
            webViewModels.add("share_alipay_life");
            webViewModels.add(InternalJSMethod.SHARE_ALIPAY_LIFE);
            webViewModels.add("page_refresh");
            webViewModels.add("refreshPage");
            webViewModels.add("web_redirect");
            webViewModels.add("webRedirect");
            webViewModels.add("share_sys_msg");
            webViewModels.add("shareSysMsg");
            webViewModels.add("page_close");
            webViewModels.add("pageClose");
            webViewModels.add("native_redirect");
            webViewModels.add("nativeRedirect");
            webViewModels.add(InternalJSMethod.SHARE_FACEBOOK);
            webViewModels.add("shareFBMessenger");
            webViewModels.add(InternalJSMethod.SHARE_WHATSAPP);
            webViewModels.add("shareLine");
            webViewModels.add(InternalJSMethod.SHARE_TWITTER);
            webViewModels.add(InternalJSMethod.SHARE_EMAIL);
        }
        return webViewModels;
    }
}
