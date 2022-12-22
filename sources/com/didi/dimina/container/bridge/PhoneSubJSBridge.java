package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.entrega.customer.app.constant.Const;
import org.json.JSONException;
import org.json.JSONObject;

public class PhoneSubJSBridge {

    /* renamed from: a */
    private final Activity f16628a;

    public PhoneSubJSBridge(Activity activity) {
        LogUtil.m13411i("PhoneSubJSBridge init");
        this.f16628a = activity;
    }

    public void makePhoneCall(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        LogUtil.m13411i("PhoneSubJSBridge makePhoneCall");
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "success", true);
        Intent intent = new Intent("android.intent.action.DIAL");
        try {
            str = jSONObject.getString(Const.PageParams.PHONE_NUMBER);
        } catch (JSONException e) {
            e.printStackTrace();
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            JSONUtil.put(jSONObject2, "success", false);
            if (callbackFunction != null) {
                callbackFunction.onCallBack(jSONObject2);
                return;
            }
            return;
        }
        intent.setData(Uri.parse("tel:" + str));
        this.f16628a.startActivity(intent);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }
}
