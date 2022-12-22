package com.didi.soda.customer.flutter.plugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.share.ShareHelper;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.travel.psnger.model.response.ScarShareChannel;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.JSONMethodCodec;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class SharePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    Activity f40906a;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29065a(OneKeyShareInfo oneKeyShareInfo) {
    }

    public SharePlugin(Activity activity) {
        this.f40906a = activity;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.rlab/share_plugin", JSONMethodCodec.INSTANCE).setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f40906a = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if ("share".equals(methodCall.method)) {
            m29067b(methodCall);
        } else if ("showSharePlatform".equals(methodCall.method)) {
            m29066a(methodCall);
        }
    }

    /* renamed from: a */
    private void m29066a(MethodCall methodCall) {
        if (methodCall.hasArgument("shareDatas")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = (JSONArray) methodCall.argument("shareDatas");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("type");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (!TextUtils.isEmpty(optString) && optJSONObject2 != null) {
                        String str = null;
                        char c = 65535;
                        switch (optString.hashCode()) {
                            case -1582273421:
                                if (optString.equals("shareLine")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -1334564460:
                                if (optString.equals(InternalJSMethod.SHARE_TWITTER)) {
                                    c = 6;
                                    break;
                                }
                                break;
                            case -916346253:
                                if (optString.equals(ScarShareChannel.TWITTER)) {
                                    c = 7;
                                    break;
                                }
                                break;
                            case -586058226:
                                if (optString.equals("shareCopyLink")) {
                                    c = 8;
                                    break;
                                }
                                break;
                            case 3321844:
                                if (optString.equals(ScarShareChannel.LINE)) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 417267653:
                                if (optString.equals(InternalJSMethod.SHARE_FACEBOOK)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 497130182:
                                if (optString.equals("facebook")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1854887537:
                                if (optString.equals(InternalJSMethod.SHARE_WHATSAPP)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 1934780818:
                                if (optString.equals(ScarShareChannel.WHATS_APP)) {
                                    c = 5;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                                str = WebConstant.FACEBOOK_PLATFORM;
                                break;
                            case 2:
                            case 3:
                                str = WebConstant.LINE_PLATFORM;
                                break;
                            case 4:
                            case 5:
                                str = WebConstant.WHATSAPP_PLATFORM;
                                break;
                            case 6:
                            case 7:
                                str = WebConstant.TWITTER_PLATFORM;
                                break;
                            case 8:
                                str = WebConstant.COPY_LINK_PLATFORM;
                                break;
                        }
                        arrayList.add(m29064a(str, optJSONObject2));
                    }
                }
            }
            ShareHelper.getInstance().showSharePlatform((Context) this.f40906a, (ArrayList<ShareToolModel>) arrayList, (ICallback.IPlatformClickCallback) $$Lambda$SharePlugin$alC3wO577DQmxysAM29zEmzM7rg.INSTANCE);
        }
    }

    /* renamed from: b */
    private void m29067b(MethodCall methodCall) {
        if (methodCall.hasArgument("platform") && methodCall.hasArgument("shareData")) {
            String str = (String) methodCall.argument("platform");
            JSONObject jSONObject = (JSONObject) methodCall.argument("shareData");
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                char c = 65535;
                int hashCode = str.hashCode();
                String str2 = WebConstant.TELEGRAM_PLATFORM;
                switch (hashCode) {
                    case -1582273421:
                        if (str.equals("shareLine")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1360467711:
                        if (str.equals(str2)) {
                            c = 8;
                            break;
                        }
                        break;
                    case -1334564460:
                        if (str.equals(InternalJSMethod.SHARE_TWITTER)) {
                            c = 6;
                            break;
                        }
                        break;
                    case -916346253:
                        if (str.equals(ScarShareChannel.TWITTER)) {
                            c = 7;
                            break;
                        }
                        break;
                    case -586058226:
                        if (str.equals("shareCopyLink")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 3321844:
                        if (str.equals(ScarShareChannel.LINE)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 181358278:
                        if (str.equals("system_entrance")) {
                            c = 10;
                            break;
                        }
                        break;
                    case 417267653:
                        if (str.equals(InternalJSMethod.SHARE_FACEBOOK)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 497130182:
                        if (str.equals("facebook")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1854887537:
                        if (str.equals(InternalJSMethod.SHARE_WHATSAPP)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1934780818:
                        if (str.equals(ScarShareChannel.WHATS_APP)) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                        str2 = WebConstant.FACEBOOK_PLATFORM;
                        break;
                    case 2:
                    case 3:
                        str2 = WebConstant.LINE_PLATFORM;
                        break;
                    case 4:
                    case 5:
                        str2 = WebConstant.WHATSAPP_PLATFORM;
                        break;
                    case 6:
                    case 7:
                        str2 = WebConstant.TWITTER_PLATFORM;
                        break;
                    case 8:
                        break;
                    case 9:
                        str2 = WebConstant.COPY_LINK_PLATFORM;
                        break;
                    case 10:
                        ShareHelper.getInstance().systemShare(GlobalContext.getContext(), m29064a((String) null, jSONObject), (ICallback.IPlatformShareCallback) null);
                        return;
                    default:
                        str2 = null;
                        break;
                }
                ShareHelper.getInstance().shareToPlatform(this.f40906a, m29064a(str2, jSONObject), (ICallback.IPlatformShareCallback) null);
            }
        }
    }

    /* renamed from: a */
    private ShareToolModel m29064a(String str, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (TextUtils.isEmpty(jSONObject.optString("share_url", ""))) {
            str2 = jSONObject.optString("url", "");
        } else {
            str2 = jSONObject.optString("share_url", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_icon_url", ""))) {
            str3 = jSONObject.optString("icon", "");
        } else {
            str3 = jSONObject.optString("share_icon_url", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_img_url", ""))) {
            str4 = jSONObject.optString("img", "");
        } else {
            str4 = jSONObject.optString("share_img_url", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_title", ""))) {
            str5 = jSONObject.optString("title", "");
        } else {
            str5 = jSONObject.optString("share_title", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_content", ""))) {
            str6 = jSONObject.optString("content", "");
        } else {
            str6 = jSONObject.optString("share_content", "");
        }
        HashMap<String, String> hashMap = null;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("image");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject != null) {
            hashMap = new HashMap<>();
            hashMap.put("appId", optJSONObject.optString("appId"));
            hashMap.put("path", optJSONObject.optString("path"));
        }
        if (!TextUtils.isEmpty(optString) && "image".equals(optString)) {
            if ("ALIPAY_FRIENDS".equals(str) || "ALIPAY_TIMELINE".equals(str)) {
                str2 = optString2;
                str7 = str2;
            } else {
                str7 = optString2;
            }
            str4 = str3;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
        ShareToolModel shareToolModel = new ShareToolModel();
        shareToolModel.platformStr = str;
        shareToolModel.title = str5;
        shareToolModel.content = str6;
        if (TextUtils.isEmpty(str3)) {
            str3 = str4;
        }
        shareToolModel.imageUrl = str3;
        shareToolModel.url = str2;
        shareToolModel.type = optString;
        shareToolModel.extra = hashMap;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            shareToolModel.recipients = arrayList;
        }
        return shareToolModel;
    }
}
