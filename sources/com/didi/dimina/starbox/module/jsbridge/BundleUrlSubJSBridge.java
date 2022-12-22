package com.didi.dimina.starbox.module.jsbridge;

import android.content.Context;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.secondparty.bundle.http.PmHttpUtil;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.util.ToastUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleUrlSubJSBridge {

    /* renamed from: a */
    private final Context f18000a;

    BundleUrlSubJSBridge(Context context) {
        LogUtil.m13411i("BundleUrlSubJSBridge init");
        this.f18000a = context;
    }

    public void getBundleUrl(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("BundleUrlSubJSBridge getBundleUrl");
        if (jSONObject != null && callbackFunction != null) {
            String str = (String) MMKVUtil.getInstance().get(PmHttpUtil.KEY_PM_IP_HTTP_HOST, "空");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("url", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
        }
    }

    public void setBundleUrl(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("BundleUrlSubJSBridge setBundleUrl");
        if (jSONObject != null && callbackFunction != null && jSONObject.has("url")) {
            MMKVUtil.getInstance().save(PmHttpUtil.KEY_PM_IP_HTTP_HOST, jSONObject.optString("url"));
            ToastUtil.show(this.f18000a, (CharSequence) "保存生效");
        }
    }
}
