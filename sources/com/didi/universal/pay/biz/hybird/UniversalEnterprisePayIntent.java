package com.didi.universal.pay.biz.hybird;

import android.content.Intent;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.universal.pay.sdk.web.WebActivityIntent;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import org.json.JSONObject;

@ServiceProvider({AbsPlatformWebPageProxy.class})
public class UniversalEnterprisePayIntent extends WebActivityIntent {
    public HashMap<String, IPlatformWebPageProxy.JsExeCallBack> getJsFunctions() {
        HashMap<String, IPlatformWebPageProxy.JsExeCallBack> hashMap = new HashMap<>();
        hashMap.put("rearUseCarReasonBack", new UseCarReasonBack());
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void finishWithResult() {
        this.mActivity.setResult(-1, new Intent());
        this.mActivity.finish();
    }

    class UseCarReasonBack implements IPlatformWebPageProxy.JsExeCallBack {
        UseCarReasonBack() {
        }

        public void callback(String str, JSONObject jSONObject) {
            UniversalEnterprisePayIntent.this.finishWithResult();
        }
    }
}
