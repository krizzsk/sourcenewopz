package com.wujie.dimina.bridge.plugin.international.share;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.Email;
import com.didi.onekeyshare.util.FaceBook;
import com.didi.onekeyshare.util.Twitter;
import com.didi.onekeyshare.util.WhatsApp;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import com.didi.sdk.util.TextUtil;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.soda.web.config.WebConstant;
import com.didi.travel.psnger.model.response.ScarShareChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J;\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u0016H\u0007J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016H\u0007J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016H\u0007J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016H\u0007J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016H\u0007J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016H\u0007J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/wujie/dimina/bridge/plugin/international/share/InternationalShareSubJSBridge;", "Lcom/didi/dimina/container/messager/jsmodule/BaseServiceModule;", "mina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "mActivity", "Landroid/app/Activity;", "mShareFragment", "Lcom/didi/onekeyshare/view/fragment/ShareFragment;", "convertShareInfo", "Ljava/util/ArrayList;", "Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "list", "", "Lcom/wujie/dimina/bridge/plugin/international/share/InternationalShareModelHelper;", "createResultJson", "", "platform", "", "result", "Lorg/json/JSONObject;", "jsCallback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "errno", "", "errorCode", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/didi/dimina/container/bridge/base/CallbackFunction;ILjava/lang/Integer;)V", "hideShareEntrance", "paras", "callback", "share2ThirdParty", "platformStr", "shareObj", "shareEmail", "shareFacebook", "shareSavePicture", "shareTwitter", "shareWhatsApp", "showShareEntrance", "Companion", "bridge-international-share_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
@DMServiceSubBridgeModule(level = 0)
/* compiled from: InternationalShareSubJSBridge.kt */
public final class InternationalShareSubJSBridge extends BaseServiceModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "InternationalShareSubJSBridge";
    /* access modifiers changed from: private */
    public final Activity mActivity;
    /* access modifiers changed from: private */
    public ShareFragment mShareFragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternationalShareSubJSBridge(DMMina dMMina) {
        super(dMMina);
        Intrinsics.checkParameterIsNotNull(dMMina, "mina");
        LogUtil.m13412i(TAG, "init 初始化方法");
        FragmentActivity activity = dMMina.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "mina.activity");
        this.mActivity = activity;
    }

    @JsInterface({"showShareEntrance"})
    public final void showShareEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "paras");
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        LogUtil.m13412i(TAG, "showShareEntrance, " + jSONObject);
        UIHandlerUtil.post(new InternationalShareSubJSBridge$showShareEntrance$1(this, jSONObject, callbackFunction));
    }

    @JsInterface({"hideShareEntrance"})
    public final void hideShareEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        LogUtil.m13412i(TAG, "hideShareEntrance, " + jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        if (this.mShareFragment != null) {
            JSONUtil.put(jSONObject2, "success", true);
            ShareFragment shareFragment = this.mShareFragment;
            if (shareFragment == null) {
                Intrinsics.throwNpe();
            }
            shareFragment.dismissAllowingStateLoss();
        } else {
            JSONUtil.put(jSONObject2, "success", false);
        }
        callbackFunction.onCallBack(jSONObject2);
    }

    @JsInterface({"shareFacebook"})
    public final void shareFacebook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "shareObj");
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        LogUtil.m13412i(TAG, "shareFacebook() : " + jSONObject);
        String str = FaceBook.NAME;
        Intrinsics.checkExpressionValueIsNotNull(str, "FaceBook.NAME");
        share2ThirdParty(str, jSONObject, callbackFunction);
    }

    @JsInterface({"shareTwitter"})
    public final void shareTwitter(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "shareObj");
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        LogUtil.m13412i(TAG, "shareTwitter() : " + jSONObject);
        String str = Twitter.NAME;
        Intrinsics.checkExpressionValueIsNotNull(str, "Twitter.NAME");
        share2ThirdParty(str, jSONObject, callbackFunction);
    }

    @JsInterface({"shareWhatsApp"})
    public final void shareWhatsApp(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "shareObj");
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        LogUtil.m13412i(TAG, "shareWhatsApp() : " + jSONObject);
        String str = WhatsApp.NAME;
        Intrinsics.checkExpressionValueIsNotNull(str, "WhatsApp.NAME");
        share2ThirdParty(str, jSONObject, callbackFunction);
    }

    @JsInterface({"shareEmail"})
    public final void shareEmail(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "shareObj");
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        LogUtil.m13412i(TAG, "shareEmail() : " + jSONObject);
        String str = Email.NAME;
        Intrinsics.checkExpressionValueIsNotNull(str, "Email.NAME");
        share2ThirdParty(str, jSONObject, callbackFunction);
    }

    @JsInterface({"shareSavePicture"})
    public final void shareSavePicture(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "shareObj");
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        LogUtil.m13412i(TAG, "shareSavePicture() : " + jSONObject);
        String platformName = SharePlatform.SAVEIMAGE_PLATFORM.platformName();
        Intrinsics.checkExpressionValueIsNotNull(platformName, "SharePlatform.SAVEIMAGE_PLATFORM.platformName()");
        share2ThirdParty(platformName, jSONObject, callbackFunction);
    }

    private final void share2ThirdParty(String str, JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new InternationalShareSubJSBridge$share2ThirdParty$1(this, str, jSONObject, callbackFunction));
    }

    static /* synthetic */ void createResultJson$default(InternationalShareSubJSBridge internationalShareSubJSBridge, String str, JSONObject jSONObject, CallbackFunction callbackFunction, int i, Integer num, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        internationalShareSubJSBridge.createResultJson(str, jSONObject, callbackFunction, i, num);
    }

    /* access modifiers changed from: private */
    public final void createResultJson(String str, JSONObject jSONObject, CallbackFunction callbackFunction, int i, Integer num) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "share_result", i);
        JSONUtil.put(jSONObject2, "channel", (Object) Companion.getChannelName(str));
        if (num != null) {
            JSONUtil.put(jSONObject, "code", num.intValue());
            JSONUtil.put(jSONObject, "success", false);
        } else {
            JSONUtil.put(jSONObject, "success", true);
            JSONUtil.put(jSONObject, "data", (Object) jSONObject2);
        }
        LogUtil.m13412i(TAG, "createResultJson  " + jSONObject);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject);
        }
    }

    /* access modifiers changed from: private */
    public final ArrayList<OneKeyShareInfo> convertShareInfo(List<InternationalShareModelHelper> list) {
        ArrayList<OneKeyShareInfo> arrayList = new ArrayList<>();
        for (InternationalShareModelHelper next : list) {
            OneKeyShareModel onkKeyShareModel = next.getOnkKeyShareModel();
            OneKeyShareInfo oneKeyShareInfo = new OneKeyShareInfo();
            if (onkKeyShareModel != null) {
                oneKeyShareInfo.content = onkKeyShareModel.content;
                oneKeyShareInfo.imageData = onkKeyShareModel.bitmap;
                oneKeyShareInfo.imagePath = onkKeyShareModel.imgPath;
                oneKeyShareInfo.imageUrl = onkKeyShareModel.imgUrl;
                oneKeyShareInfo.url = onkKeyShareModel.url;
                oneKeyShareInfo.title = onkKeyShareModel.title;
                oneKeyShareInfo.customName = next.getName();
                oneKeyShareInfo.smsMessage = onkKeyShareModel.smsMessage;
                oneKeyShareInfo.type = onkKeyShareModel.type;
                oneKeyShareInfo.extra = onkKeyShareModel.extra;
            }
            oneKeyShareInfo.phone = next.getPhone();
            if (!TextUtil.isEmpty(next.getMessage())) {
                oneKeyShareInfo.smsMessage = next.getMessage();
            }
            if (InternationalShareModelHelper.Companion.contains(next.getType())) {
                oneKeyShareInfo.platform = InternationalShareModelHelper.Companion.getPlatform(next.getType());
            }
            arrayList.add(oneKeyShareInfo);
        }
        return arrayList;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/wujie/dimina/bridge/plugin/international/share/InternationalShareSubJSBridge$Companion;", "", "()V", "TAG", "", "addParam2ShareModel", "Lcom/didi/sharesdk/OneKeyShareModel;", "shareObj", "Lorg/json/JSONObject;", "model", "assembleChannel", "", "Lcom/wujie/dimina/bridge/plugin/international/share/InternationalShareModelHelper;", "jsonObject", "getChannelName", "platform", "bridge-international-share_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: InternationalShareSubJSBridge.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
            r4 = r3.optString("type", "");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.wujie.dimina.bridge.plugin.international.share.InternationalShareModelHelper> assembleChannel(org.json.JSONObject r9) {
            /*
                r8 = this;
                java.lang.String r0 = "buttons"
                org.json.JSONArray r9 = r9.optJSONArray(r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.List r0 = (java.util.List) r0
                if (r9 == 0) goto L_0x006d
                r1 = 0
                int r2 = r9.length()
            L_0x0014:
                if (r1 >= r2) goto L_0x006d
                org.json.JSONObject r3 = r9.optJSONObject(r1)
                if (r3 == 0) goto L_0x006a
                java.lang.String r4 = "type"
                java.lang.String r5 = ""
                java.lang.String r4 = r3.optString(r4, r5)
                com.wujie.dimina.bridge.plugin.international.share.InternationalShareModelHelper$Companion r6 = com.wujie.dimina.bridge.plugin.international.share.InternationalShareModelHelper.Companion
                com.wujie.dimina.bridge.plugin.international.share.InternationalShareModelHelper r6 = r6.getH5ShareModel(r4)
                if (r6 == 0) goto L_0x006a
                r6.setType(r4)
                java.lang.String r4 = "name"
                java.lang.String r4 = r3.optString(r4, r5)
                r6.setName(r4)
                java.lang.String r4 = "icon"
                java.lang.String r4 = r3.optString(r4, r5)
                java.lang.String r7 = "temp.optString(\"icon\", \"\")"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r7)
                r6.setIcon(r4)
                java.lang.String r4 = "redirect_url"
                java.lang.String r4 = r3.optString(r4, r5)
                r6.setRedirectUrl(r4)
                java.lang.String r4 = "data"
                org.json.JSONObject r3 = r3.optJSONObject(r4)
                com.didi.sharesdk.OneKeyShareModel r4 = r6.getOnkKeyShareModel()
                if (r3 == 0) goto L_0x0067
                if (r4 == 0) goto L_0x0067
                r5 = r8
                com.wujie.dimina.bridge.plugin.international.share.InternationalShareSubJSBridge$Companion r5 = (com.wujie.dimina.bridge.plugin.international.share.InternationalShareSubJSBridge.Companion) r5
                com.didi.sharesdk.OneKeyShareModel r3 = r5.addParam2ShareModel(r3, r4)
                r6.setOnkKeyShareModel(r3)
            L_0x0067:
                r0.add(r6)
            L_0x006a:
                int r1 = r1 + 1
                goto L_0x0014
            L_0x006d:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r1 = "assembleChannel "
                r9.append(r1)
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                java.lang.String r1 = "InternationalShareSubJSBridge"
                com.didi.dimina.container.util.LogUtil.iRelease(r1, r9)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wujie.dimina.bridge.plugin.international.share.InternationalShareSubJSBridge.Companion.assembleChannel(org.json.JSONObject):java.util.List");
        }

        /* access modifiers changed from: private */
        public final OneKeyShareModel addParam2ShareModel(JSONObject jSONObject, OneKeyShareModel oneKeyShareModel) {
            String optString = jSONObject.optString("url", "");
            String optString2 = jSONObject.optString("icon", "");
            String optString3 = jSONObject.optString("title", "");
            String optString4 = jSONObject.optString("content", "");
            String optString5 = jSONObject.optString("type");
            HashMap<String, String> hashMap = null;
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject != null) {
                hashMap = new HashMap<>();
                Map map = hashMap;
                map.put("appId", optJSONObject.optString("appId"));
                map.put("path", optJSONObject.optString("path"));
                map.put("miniprogramType", optJSONObject.optString("programType"));
                map.put("withShareTicket", optJSONObject.optString("withShareTicket"));
            }
            if (TextUtil.isEmpty(optString2)) {
                optString2 = jSONObject.optString("image", "");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
            List<String> arrayList = new ArrayList<>();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        String optString6 = optJSONArray.optString(i);
                        Intrinsics.checkExpressionValueIsNotNull(optString6, "share_recipients.optString(i)");
                        arrayList.add(optString6);
                    }
                }
            }
            oneKeyShareModel.title = optString3;
            oneKeyShareModel.content = optString4;
            oneKeyShareModel.imgUrl = optString2;
            oneKeyShareModel.url = optString;
            oneKeyShareModel.type = optString5;
            if (!arrayList.isEmpty()) {
                oneKeyShareModel.recipients = arrayList;
            }
            if (optJSONObject != null) {
                oneKeyShareModel.extra = hashMap;
            }
            return oneKeyShareModel;
        }

        public final String getChannelName(String str) {
            Intrinsics.checkParameterIsNotNull(str, "platform");
            if (Intrinsics.areEqual((Object) WebConstant.WXCHAT_PLATFORM, (Object) str)) {
                return "wechat";
            }
            if (Intrinsics.areEqual((Object) WebConstant.WXMOMENTS_PLATFORM, (Object) str)) {
                return "wechat_timeline";
            }
            if (Intrinsics.areEqual((Object) WebConstant.QQ_PLATFORM, (Object) str)) {
                return "qq";
            }
            if (Intrinsics.areEqual((Object) WebConstant.QZONE_PLATFORM, (Object) str)) {
                return "qq_zone";
            }
            if (Intrinsics.areEqual((Object) "ALIPAY_FRIENDS", (Object) str)) {
                return "alipay_friends";
            }
            if (Intrinsics.areEqual((Object) "ALIPAY_TIMELINE", (Object) str)) {
                return "alipay_timeline";
            }
            if (Intrinsics.areEqual((Object) WebConstant.FACEBOOK_PLATFORM, (Object) str)) {
                return "facebook";
            }
            if (Intrinsics.areEqual((Object) WebConstant.MESSENGER_PLATFORM, (Object) str)) {
                return "fb_messager";
            }
            if (Intrinsics.areEqual((Object) WebConstant.WHATSAPP_PLATFORM, (Object) str)) {
                return "whats_app";
            }
            if (Intrinsics.areEqual((Object) WebConstant.LINE_PLATFORM, (Object) str)) {
                return ScarShareChannel.LINE;
            }
            if (Intrinsics.areEqual((Object) WebConstant.TWITTER_PLATFORM, (Object) str)) {
                return ScarShareChannel.TWITTER;
            }
            return Intrinsics.areEqual((Object) WebConstant.EMAIL_PLATFORM, (Object) str) ? "email" : str;
        }
    }
}
