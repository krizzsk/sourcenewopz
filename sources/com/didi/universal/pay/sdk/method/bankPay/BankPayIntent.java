package com.didi.universal.pay.sdk.method.bankPay;

import android.content.Intent;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageProxy;
import com.didi.universal.pay.sdk.model.PayResult;
import com.didi.universal.pay.sdk.util.LogUtil;
import com.didi.universal.pay.sdk.util.UiThreadHandler;
import com.didi.universal.pay.sdk.web.WebActivityIntent;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import org.json.JSONObject;

@ServiceProvider({AbsPlatformWebPageProxy.class})
public class BankPayIntent extends WebActivityIntent {
    public static final String BANK_PAY_RESULT = "BANK_PAY_RESULT";

    /* renamed from: a */
    private static final String f45110a = "BankPayIntent";

    public void onFinish() {
    }

    public HashMap<String, IPlatformWebPageProxy.JsExeCallBack> getJsFunctions() {
        HashMap<String, IPlatformWebPageProxy.JsExeCallBack> hashMap = new HashMap<>();
        hashMap.put("initCmbSignNetPay", new InitCmbSign());
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32384a(int i) {
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
                LogUtil.m32410fi(BankPayIntent.f45110a, "pay_status:" + optString);
                if (!"0".equals(optString)) {
                    if ("1".equals(optString)) {
                        UiThreadHandler.postDelayed(new Runnable() {
                            public void run() {
                                BankPayIntent.this.m32384a(2);
                            }
                        }, 2000);
                    } else if ("2".equals(optString)) {
                        UiThreadHandler.postDelayed(new Runnable() {
                            public void run() {
                                BankPayIntent.this.m32384a(1);
                            }
                        }, 2000);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
