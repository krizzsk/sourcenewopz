package com.didi.dimina.starbox.module.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.module.jsbridge.scancode.ScanActivity;
import org.json.JSONObject;

public class ScanSubJSBridge {

    /* renamed from: a */
    private final Activity f18019a;

    ScanSubJSBridge(Activity activity) {
        LogUtil.m13411i("ScanSubJSBridge init");
        this.f18019a = activity;
    }

    public void scan(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        ScanActivity.start(this.f18019a, new ScanActivity.ScanResultListener() {
            public void onSuccess(String str) {
                if (TextUtils.isEmpty(str)) {
                    CallBackUtil.onFail("二维码内部不存在", callbackFunction);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONUtil.put(jSONObject, "content", (Object) str);
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }

            public void onCancel() {
                CallBackUtil.onFail("用户取消", callbackFunction);
            }
        });
    }
}
