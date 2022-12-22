package com.didi.dimina.container.secondparty.jsmodule.jsbridge.scan;

import android.app.Activity;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.scan.ScanActivity;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

public class ScanSubJSBridge {
    public void scanCode(JSONObject jSONObject, final CallbackFunction callbackFunction, Activity activity) {
        LogUtil.m13411i("ScanSubJSBridge scanCode");
        ScanActivity.start(activity, new ScanActivity.ScanResultListener() {
            public void onSuccess(String str) {
                JSONObject jSONObject = new JSONObject();
                JSONUtil.put(jSONObject, "result", (Object) str);
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }

            public void onCancel() {
                CallBackUtil.onFail("取消扫码", callbackFunction);
            }
        });
    }
}
