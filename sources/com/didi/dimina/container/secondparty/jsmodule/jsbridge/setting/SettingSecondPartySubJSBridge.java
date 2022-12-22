package com.didi.dimina.container.secondparty.jsmodule.jsbridge.setting;

import android.app.Activity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.permission.PermissionDescInfo;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import org.json.JSONObject;

public class SettingSecondPartySubJSBridge {

    /* renamed from: c */
    private static final String f17275c = "scope";

    /* renamed from: a */
    private final DMMina f17276a;

    /* renamed from: b */
    private final Activity f17277b;

    public SettingSecondPartySubJSBridge(DMMina dMMina, Activity activity) {
        this.f17276a = dMMina;
        this.f17277b = activity;
        LogUtil.m13411i("SecondParty SettingSubJSBridge init");
    }

    public void businessAuthorize(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (jSONObject == null || !jSONObject.has("scope")) {
            CallBackUtil.onFail("fail parameter error: parameter.scope should be String instead of Undefined;", callbackFunction);
            return;
        }
        String optString = jSONObject.optString("scope");
        if (BridgePermission.bridgePermissionSet.contains(optString)) {
            PermissionDescInfo parse = PermissionDescInfo.parse(jSONObject);
            if (parse.getIcon().startsWith("difile")) {
                parse.setIcon(new DMSandboxHelper(this.f17276a.getConfig()).url2filepath(parse.getIcon()));
            }
            PermissionUtil.INSTANCE.checkAndRequestBridgePermission(this.f17277b, optString, parse, new SinglePermissionCallBack() {
                public void onDenied(String str) {
                    CallBackUtil.onFail("onDenied", callbackFunction);
                }

                public void onGranted(String str) {
                    CallBackUtil.onSuccess(callbackFunction);
                }
            });
            return;
        }
        CallBackUtil.onFail("fail parameter error: parameter.scope not need authorize", callbackFunction);
    }
}
