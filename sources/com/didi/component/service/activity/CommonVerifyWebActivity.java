package com.didi.component.service.activity;

import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.activity.risk.RiskUserActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonVerifyWebActivity extends WebActivity {

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener<JSONObject> f15654a = new BaseEventPublisher.OnEventListener<JSONObject>() {
        public void onEvent(String str, JSONObject jSONObject) {
            if (jSONObject.has("action")) {
                try {
                    int i = jSONObject.getInt("action");
                    if (i == 1) {
                        CommonVerifyWebActivity.this.finish();
                    } else if (i == 2) {
                        Intent intent = new Intent(CommonVerifyWebActivity.this, RiskUserActivity.class);
                        intent.putExtra(RiskUserActivity.EXTRA_KEY_4_FINISH_SELF, true);
                        CommonVerifyWebActivity.this.startActivity(intent);
                        CommonVerifyWebActivity.this.finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (getWebView() != null) {
            getWebView().getSettings().setCacheMode(2);
            getWebView().getSettings().setAppCacheEnabled(false);
        }
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Risk.EVENT_SAFETY_AUTH_JS_CALLBACK, this.f15654a);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Risk.EVENT_SAFETY_AUTH_JS_CALLBACK, this.f15654a);
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        setResult(0);
        finish();
    }
}
