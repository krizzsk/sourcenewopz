package com.didi.dimina.starbox.module.jsbridge;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.debug.DevModeManager;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.module.StarBoxDockerActivity;
import com.didi.dimina.starbox.module.jsbridge.bean.GiftBean;
import com.didi.dimina.starbox.module.jsbridge.gift.GiftDownLoadExecutor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class DevModeSubJSBridge {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<GiftDownLoadExecutor> f18002a = new ArrayList();

    /* renamed from: b */
    private final DMMina f18003b;

    DevModeSubJSBridge(DMMina dMMina) {
        LogUtil.m13411i("DevModeSubJSBridge init");
        this.f18003b = dMMina;
    }

    public void debugger(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intent intent = new Intent();
        intent.putExtra(StarBoxDockerActivity.KEY_DEV_MODE, StarBoxDockerActivity.VALUE_DEV_MODE_GIFT);
        intent.putExtra("app_id", jSONObject.optString("appId"));
        intent.putExtra(StarBoxDockerActivity.KEY_DEV_MODE_GIFT_URL, jSONObject.optString("giftPath"));
        intent.putExtra(StarBoxDockerActivity.IDE_DEV_MODE_IP, jSONObject.optString(StarBoxDockerActivity.IDE_DEV_MODE_IP));
        intent.putExtra(StarBoxDockerActivity.IDE_DEV_MODE_PORT, jSONObject.optString(StarBoxDockerActivity.IDE_DEV_MODE_PORT));
        intent.setClass(this.f18003b.getActivity(), StarBoxDockerActivity.class);
        this.f18003b.getActivity().startActivity(intent);
        CallBackUtil.onSuccess(callbackFunction);
    }

    public void downloadGiftBundle(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("url 为空", callbackFunction);
            return;
        }
        String optString2 = jSONObject.optString("appId", "");
        if (TextUtils.isEmpty(optString2)) {
            CallBackUtil.onFail("appId 为空", callbackFunction);
            return;
        }
        C77271 r1 = new GiftDownLoadExecutor(this.f18003b.getActivity()) {
            public void onStart() {
            }

            public void onFail(String str) {
                CallBackUtil.onFail(str, callbackFunction);
            }

            public <T> void onSuccess(T t) {
                if (t != null) {
                    GiftBean giftBean = (GiftBean) t;
                    JSONObject jSONObject = new JSONObject();
                    JSONUtil.put(jSONObject, "giftPath", (Object) giftBean.getFilePath());
                    JSONUtil.put(jSONObject, "giftUrl", (Object) giftBean.getdUrl());
                    CallBackUtil.onSuccess(jSONObject, callbackFunction);
                }
            }

            public void onComplete() {
                synchronized (DevModeSubJSBridge.class) {
                    DevModeSubJSBridge.this.f18002a.remove(this);
                }
            }
        };
        synchronized (DevModeSubJSBridge.class) {
            this.f18002a.add(r1);
        }
        if (!optString.contains("newCode")) {
            if (optString.contains("?")) {
                optString = optString + "&realJsAppId=" + optString2;
            } else {
                optString = optString + "?realJsAppId=" + optString2;
            }
        }
        r1.execute(optString);
    }

    public void getDevModeList(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("appId", "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("appId 为空", callbackFunction);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "devModeList", (Object) new DevModeManager(optString).getDevModeList());
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    public void setLaunchInterceptDevMode(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("appId", "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("appId 为空", callbackFunction);
            return;
        }
        DevModeManager devModeManager = new DevModeManager(optString);
        String optString2 = jSONObject.optString("dev", "");
        String optString3 = jSONObject.optString("url", "");
        String optString4 = jSONObject.optString("giftUrl", "");
        if (TextUtils.equals(optString2, StarBoxDockerActivity.VALUE_DEV_MODE_GIFT) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
            devModeManager.setDevMode(DevModeManager.DevMode.DEV_GIFT);
            devModeManager.setDevMode4GIFTURL(optString4);
            devModeManager.setDevMode4GIFT(optString3);
            CallBackUtil.onSuccess(callbackFunction);
        } else if (TextUtils.equals(optString2, "ip") && !TextUtils.isEmpty(optString3)) {
            devModeManager.setDevMode(DevModeManager.DevMode.DEV_IP);
            devModeManager.setDevMode4IP(optString3);
            CallBackUtil.onSuccess(callbackFunction);
        } else if (TextUtils.equals(optString2, "none")) {
            devModeManager.resetDevMode();
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("参数不符合规范", callbackFunction);
        }
    }

    public void launchToDidiMiniProgram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("dev", "");
        String optString2 = jSONObject.optString("url", "");
        String optString3 = jSONObject.optString("appId", "");
        String optString4 = jSONObject.optString("launchParams", "");
        String optString5 = jSONObject.optString("entryPagePath", "");
        if (TextUtils.equals(optString, StarBoxDockerActivity.VALUE_DEV_MODE_GIFT) && !TextUtils.isEmpty(optString2)) {
            Intent intent = new Intent();
            intent.putExtra(StarBoxDockerActivity.KEY_DEV_MODE, StarBoxDockerActivity.VALUE_DEV_MODE_GIFT);
            intent.putExtra(StarBoxDockerActivity.KEY_DEV_MODE_GIFT_URL, optString2);
            intent.putExtra("app_id", optString3);
            intent.putExtra(StarBoxDockerActivity.KEY_DEV_MODE_LAUNCH_PARAMS, optString4);
            intent.putExtra(StarBoxDockerActivity.KEY_DEV_MODE_ENTRY_PAGE_PATH, optString5);
            intent.setClass(this.f18003b.getActivity(), StarBoxDockerActivity.class);
            this.f18003b.getActivity().startActivity(intent);
            CallBackUtil.onSuccess(callbackFunction);
        } else if (TextUtils.equals(optString, "ip") && !TextUtils.isEmpty(optString2)) {
            Intent intent2 = new Intent();
            intent2.putExtra(StarBoxDockerActivity.KEY_DEV_MODE, "ip");
            intent2.putExtra(StarBoxDockerActivity.KEY_DEV_MODE_IP_URL, optString2);
            intent2.putExtra("app_id", optString3);
            intent2.putExtra(StarBoxDockerActivity.KEY_DEV_MODE_LAUNCH_PARAMS, optString4);
            intent2.putExtra(StarBoxDockerActivity.KEY_DEV_MODE_ENTRY_PAGE_PATH, optString5);
            intent2.setClass(this.f18003b.getActivity(), StarBoxDockerActivity.class);
            this.f18003b.getActivity().startActivity(intent2);
            CallBackUtil.onSuccess(callbackFunction);
        } else if (TextUtils.equals(optString, "none")) {
            Intent intent3 = new Intent();
            intent3.putExtra(StarBoxDockerActivity.KEY_DEV_MODE, "none");
            intent3.putExtra("app_id", optString3);
            intent3.setClass(this.f18003b.getActivity(), StarBoxDockerActivity.class);
            this.f18003b.getActivity().startActivity(intent3);
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("参数不符合规范", callbackFunction);
        }
    }

    public void onDestroy() {
        synchronized (DevModeSubJSBridge.class) {
            for (GiftDownLoadExecutor onDestroy : this.f18002a) {
                onDestroy.onDestroy();
            }
            this.f18002a.clear();
        }
    }
}
