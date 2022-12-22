package com.didi.component.service.activity;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MexicoCurpAuthWebActivity extends WebActivity {
    public static final String SOURCE_KEY = "CPF_AUTH_SOURCE_KEY";

    /* renamed from: a */
    private int f15659a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f15660b = 0;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<JSONObject> f15661c = new BaseEventPublisher.OnEventListener<JSONObject>() {
        public void onEvent(String str, JSONObject jSONObject) {
            GLog.m7964d("event subscribe s = " + str);
            if (BaseEventKeys.Risk.EVENT_SAFETY_AUTH_JS_CALLBACK.equals(str)) {
                GLog.m7964d("event processing...");
                if (!jSONObject.has("action") && jSONObject != null && jSONObject.optInt("status") == 0) {
                    GLog.m7964d("curp auth success...");
                    MexicoCurpAuthWebActivity.this.setResult(-1);
                    int unused = MexicoCurpAuthWebActivity.this.f15660b = 1;
                    MexicoCurpAuthWebActivity.this.finish();
                }
            }
        }
    };

    /* renamed from: b */
    private int m11431b() {
        return getIntent() != null ? getIntent().getIntExtra("CPF_AUTH_SOURCE_KEY", this.f15659a) : this.f15659a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (getWebView() != null) {
            getWebView().getSettings().setCacheMode(2);
            getWebView().getSettings().setAppCacheEnabled(false);
        }
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Risk.EVENT_SAFETY_AUTH_JS_CALLBACK, this.f15661c);
        this.f15659a = m11431b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Risk.EVENT_SAFETY_AUTH_JS_CALLBACK, this.f15661c);
        if (this.f15660b == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("source", Integer.valueOf(this.f15659a));
            OmegaSDKAdapter.trackEvent("ibt_gp_safetycurp_back_ck", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        setResult(0);
        finish();
    }
}
