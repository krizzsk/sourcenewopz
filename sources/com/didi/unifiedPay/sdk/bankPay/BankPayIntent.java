package com.didi.unifiedPay.sdk.bankPay;

import android.content.Intent;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.unifiedPay.component.activity.WebActivityIntent;
import com.didi.unifiedPay.component.model.PayResult;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import org.json.JSONObject;

@ServiceProvider({AbsPlatformWebPageProxy.class})
public class BankPayIntent extends WebActivityIntent {
    public static final String BANK_PAY_RESULT = "BANK_PAY_RESULT";
    private static final String TAG = "BankPayIntent";

    public HashMap<String, IPlatformWebPageProxy.JsExeCallBack> getJsFunctions() {
        HashMap<String, IPlatformWebPageProxy.JsExeCallBack> hashMap = new HashMap<>();
        hashMap.put("initCmbSignNetPay", new InitCmbSign());
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void finishWithResult(int i) {
        PayResult payResult = new PayResult();
        payResult.result = i;
        Intent intent = new Intent();
        intent.putExtra("BANK_PAY_RESULT", payResult);
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
    }

    class InitCmbSign implements IPlatformWebPageProxy.JsExeCallBack {
        InitCmbSign() {
        }

        public void callback(String str, JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.has("pay_status")) {
                String optString = jSONObject.optString("pay_status");
                LogUtil.m31685fi(BankPayIntent.TAG, "pay_status:" + optString);
                if (!"0".equals(optString)) {
                    if ("1".equals(optString)) {
                        UiThreadHandler.postDelayed(new Runnable() {
                            public void run() {
                                BankPayIntent.this.finishWithResult(2);
                            }
                        }, 2000);
                    } else if ("2".equals(optString)) {
                        UiThreadHandler.postDelayed(new Runnable() {
                            public void run() {
                                BankPayIntent.this.finishWithResult(1);
                            }
                        }, 2000);
                    }
                }
            }
        }
    }
}
