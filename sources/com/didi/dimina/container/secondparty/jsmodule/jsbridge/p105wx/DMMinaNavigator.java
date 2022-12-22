package com.didi.dimina.container.secondparty.jsmodule.jsbridge.p105wx;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.secondparty.Dimina4Di;
import com.didi.dimina.container.secondparty.route.RouteConfig;
import com.didi.dimina.container.util.CallBackUtil;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.net.URI;
import java.net.URLEncoder;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.secondparty.jsmodule.jsbridge.wx.DMMinaNavigator */
public class DMMinaNavigator {

    /* renamed from: a */
    private final DMMina f17304a;

    /* renamed from: b */
    private final FragmentActivity f17305b;

    public DMMinaNavigator(DMMina dMMina, FragmentActivity fragmentActivity) {
        this.f17304a = dMMina;
        this.f17305b = fragmentActivity;
    }

    public void navigateToDimina(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            String optString = jSONObject.optString("appId");
            if (TextUtils.isEmpty(optString)) {
                CallBackUtil.onFail("appId is null", callbackFunction);
                return;
            }
            String a = m12846a(jSONObject.optString("path"), jSONObject.optString("extraData"));
            RouteConfig.Builder builder = new RouteConfig.Builder();
            builder.setAppId(optString).setEntryPath(a).setHasCapsuleButton(jSONObject.optBoolean("hasCapsuleButton", false)).setRemoteUrl(jSONObject.optString("remoteUrl", ""));
            Dimina4Di.Router.with((Activity) this.f17305b).setRouteConfig(builder.build()).start();
            CallBackUtil.onSuccess(callbackFunction);
        } catch (Exception e) {
            CallBackUtil.onFail("跳转失败:" + e.getMessage(), callbackFunction);
            e.printStackTrace();
        }
    }

    public void navigateToMiniProgram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m12847a(jSONObject, callbackFunction);
    }

    /* renamed from: a */
    private void m12847a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (!TextUtils.isEmpty(((Dimina4Di.Config) Dimina.getConfig()).getWxAppID())) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.f17305b, ((Dimina4Di.Config) Dimina.getConfig()).getWxAppID(), false);
            if (createWXAPI.isWXAppInstalled()) {
                String optString = jSONObject.optString("appId");
                if (((Dimina4Di.Config) Dimina.getConfig()).getWXIDtoAppIDMap().containsKey(optString)) {
                    optString = ((Dimina4Di.Config) Dimina.getConfig()).getWXIDtoAppIDMap().get(optString);
                } else if (!optString.contains("gh_")) {
                    optString = null;
                }
                if (!TextUtils.isEmpty(optString)) {
                    WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                    req.userName = optString;
                    req.path = m12846a(jSONObject.optString("path"), jSONObject.optString("extraData"));
                    String optString2 = jSONObject.optString("envVersion");
                    if (TextUtils.isEmpty(optString2) || "release".equals(optString2)) {
                        req.miniprogramType = 0;
                    } else if ("develop".equals(optString2)) {
                        req.miniprogramType = 1;
                    } else if ("trial".equals(optString2)) {
                        req.miniprogramType = 2;
                    }
                    createWXAPI.sendReq(req);
                    CallBackUtil.onSuccess(callbackFunction);
                    return;
                }
                CallBackUtil.onFail("wxappid到appid未做映射或者未传入", callbackFunction);
                return;
            }
            CallBackUtil.onFail("没有安装微信", callbackFunction);
            return;
        }
        CallBackUtil.onFail("初始化没有设置WxAppID", callbackFunction);
    }

    /* renamed from: a */
    private String m12846a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(new URI(str).getQuery())) {
                return str + "?extraData=" + URLEncoder.encode(str2, "utf-8");
            }
            return str + "&extraData=" + URLEncoder.encode(str2, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
