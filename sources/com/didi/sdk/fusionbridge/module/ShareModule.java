package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.intercept.IShareDialogIntercept;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.C10429QQ;
import com.didi.onekeyshare.util.QZone;
import com.didi.onekeyshare.util.Wechat;
import com.didi.onekeyshare.util.WechatMoments;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import com.didi.soda.web.config.WebConstant;
import com.didi.travel.psnger.model.response.ScarShareChannel;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareModule extends BaseHybridModule {

    /* renamed from: a */
    private Context f36005a;

    public ShareModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f36005a = hybridableContainer.getActivity();
    }

    @JsInterface({"share_weixin_appmsg", "shareWeixinAppmsg"})
    public void shareWeixinAppmsg(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(Wechat.NAME, jSONObject, callbackFunction);
    }

    @JsInterface({"share_weixin_timeline", "shareWeixinTimeline"})
    public void shareWeixinTimeline(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(WechatMoments.NAME, jSONObject, callbackFunction);
    }

    @JsInterface({"share_qq_appmsg", "shareQqAppmsg"})
    public void shareQqAppmsg(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(C10429QQ.NAME, jSONObject, callbackFunction);
    }

    @JsInterface({"share_qzone", "shareQzone"})
    public void shareQzone(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(QZone.NAME, jSONObject, callbackFunction);
    }

    @JsInterface({"share_alipay_friend", "shareAlipayFriend"})
    public void shareAlipayFriend(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a("ALIPAY_FRIENDS", jSONObject, callbackFunction);
    }

    @JsInterface({"share_alipay_life", "shareAlipayLife"})
    public void shareAlipayLife(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a("ALIPAY_TIMELINE", jSONObject, callbackFunction);
    }

    @JsInterface({"shareFacebook"})
    public void shareFacebook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(SharePlatform.FACEBOOK_PLATFORM.platformName(), jSONObject, callbackFunction);
    }

    @JsInterface({"shareFBMessenger"})
    public void shareFBMessenger(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(SharePlatform.MESSENGER_PLATFORM.platformName(), jSONObject, callbackFunction);
    }

    @JsInterface({"shareWhatsApp"})
    public void shareWhatsApp(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(SharePlatform.WHATSAPP_PLATFORM.platformName(), jSONObject, callbackFunction);
    }

    @JsInterface({"shareLine"})
    public void shareLine(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(SharePlatform.LINE_PLATFORM.platformName(), jSONObject, callbackFunction);
    }

    @JsInterface({"shareTwitter"})
    public void shareTwitter(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(SharePlatform.TWITTER_PLATFORM.platformName(), jSONObject, callbackFunction);
    }

    @JsInterface({"shareEmail"})
    public void shareEmail(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(SharePlatform.EMAIL_PLATFORM.platformName(), jSONObject, callbackFunction);
    }

    @JsInterface({"shareSMS"})
    public void shareSMS(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m25471a(SharePlatform.SYSTEM_MESSAGE.platformName(), jSONObject, callbackFunction);
    }

    @JsInterface({"showSystemEntrance"})
    public void showSystemEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str = "share_url";
        if (TextUtils.isEmpty(jSONObject.optString(str, ""))) {
            str = "url";
        }
        String optString = jSONObject.optString(str, "");
        String str2 = "share_icon_url";
        if (TextUtils.isEmpty(jSONObject.optString(str2, ""))) {
            str2 = "icon";
        }
        String optString2 = jSONObject.optString(str2, "");
        String str3 = "share_img_url";
        if (TextUtils.isEmpty(jSONObject.optString(str3, ""))) {
            str3 = "img";
        }
        String optString3 = jSONObject.optString(str3, "");
        String str4 = "share_title";
        if (TextUtils.isEmpty(jSONObject.optString(str4, ""))) {
            str4 = "title";
        }
        String optString4 = jSONObject.optString(str4, "");
        String str5 = "share_content";
        if (TextUtils.isEmpty(jSONObject.optString(str5, ""))) {
            str5 = "content";
        }
        String optString5 = jSONObject.optString(str5, "");
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.type = IShareDialogIntercept.SYSTEM_SHARE_DIALOG;
        shareInfo.title = optString4;
        shareInfo.content = optString5;
        if (TextUtils.isEmpty(optString2)) {
            optString2 = optString3;
        }
        shareInfo.imageUrl = optString2;
        shareInfo.url = optString;
        ArrayList arrayList = new ArrayList();
        arrayList.add(SharePlatform.SYSTEM_MESSAGE);
        shareInfo.platforms = arrayList;
        ShareBuilder.buildShare((FragmentActivity) this.f36005a, shareInfo, (ICallback.IPlatformShareCallback) null);
    }

    /* renamed from: a */
    private void m25471a(final String str, JSONObject jSONObject, final CallbackFunction callbackFunction) {
        String str2;
        String str3 = "share_url";
        String str4 = "";
        if (TextUtils.isEmpty(jSONObject.optString(str3, str4))) {
            str3 = "url";
        }
        String optString = jSONObject.optString(str3, str4);
        String str5 = "share_icon_url";
        if (TextUtils.isEmpty(jSONObject.optString(str5, str4))) {
            str5 = "icon";
        }
        String optString2 = jSONObject.optString(str5, str4);
        String str6 = "share_img_url";
        if (TextUtils.isEmpty(jSONObject.optString(str6, str4))) {
            str6 = "img";
        }
        String optString3 = jSONObject.optString(str6, str4);
        String str7 = "share_title";
        if (TextUtils.isEmpty(jSONObject.optString(str7, str4))) {
            str7 = "title";
        }
        String optString4 = jSONObject.optString(str7, str4);
        String str8 = "share_content";
        if (TextUtils.isEmpty(jSONObject.optString(str8, str4))) {
            str8 = "content";
        }
        String optString5 = jSONObject.optString(str8, str4);
        try {
            str2 = jSONObject.getString("type");
            try {
                str4 = jSONObject.getString("image");
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            str2 = str4;
        }
        if (!TextUtils.isEmpty(str2) && "image".equals(str2)) {
            if ("ALIPAY_FRIENDS".equals(str) || "ALIPAY_TIMELINE".equals(str)) {
                optString = str4;
                optString2 = optString;
            } else {
                optString2 = str4;
            }
            optString3 = optString2;
        }
        OneKeyShareModel oneKeyShareModel = new OneKeyShareModel(str);
        oneKeyShareModel.title = optString4;
        oneKeyShareModel.content = optString5;
        if (TextUtils.isEmpty(optString2)) {
            optString2 = optString3;
        }
        oneKeyShareModel.imgUrl = optString2;
        oneKeyShareModel.url = optString;
        final JSONObject jSONObject2 = new JSONObject();
        ShareApi.show((Activity) this.f36005a, oneKeyShareModel, (ICallback.IPlatformShareCallback) new ICallback.IPlatformShareCallback() {
            public void onComplete(SharePlatform sharePlatform) {
                ShareModule.this.m25472a(str, jSONObject2, callbackFunction, 0);
            }

            public void onError(SharePlatform sharePlatform) {
                ShareModule.this.m25472a(str, jSONObject2, callbackFunction, 1);
            }

            public void onCancel(SharePlatform sharePlatform) {
                ShareModule.this.m25472a(str, jSONObject2, callbackFunction, 2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25472a(String str, JSONObject jSONObject, CallbackFunction callbackFunction, int i) {
        try {
            jSONObject.put("share_result", i);
            jSONObject.put("channel", getChannelName(str));
        } catch (JSONException unused) {
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject);
        }
    }

    public static String getChannelName(String str) {
        if (WebConstant.WXCHAT_PLATFORM.equals(str)) {
            return "wechat";
        }
        if (WebConstant.WXMOMENTS_PLATFORM.equals(str)) {
            return "wechat_timeline";
        }
        if (WebConstant.QQ_PLATFORM.equals(str)) {
            return "qq";
        }
        if (WebConstant.QZONE_PLATFORM.equals(str)) {
            return "qq_zone";
        }
        if ("ALIPAY_FRIENDS".equals(str)) {
            return "alipay_friends";
        }
        if ("ALIPAY_TIMELINE".equals(str)) {
            return "alipay_timeline";
        }
        if (WebConstant.FACEBOOK_PLATFORM.equals(str)) {
            return "facebook";
        }
        if (WebConstant.MESSENGER_PLATFORM.equals(str)) {
            return "fb_messager";
        }
        if (WebConstant.WHATSAPP_PLATFORM.equals(str)) {
            return "whats_app";
        }
        if (WebConstant.LINE_PLATFORM.equals(str)) {
            return ScarShareChannel.LINE;
        }
        if (WebConstant.TWITTER_PLATFORM.equals(str)) {
            return ScarShareChannel.TWITTER;
        }
        return WebConstant.EMAIL_PLATFORM.equals(str) ? "email" : str;
    }
}
