package com.didi.component.payentrance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebTitleBar;
import com.didi.unifiedPay.component.model.SignResultModel;
import com.taxis99.R;
import org.json.JSONObject;

public class DDCreditSignActivity extends WebActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f14860a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private WebTitleBar f14861b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SignResultModel f14862c;

    /* renamed from: d */
    private boolean f14863d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f14863d = true;
        this.f14861b = (WebTitleBar) findViewById(R.id.web_title_bar);
        m10672b();
    }

    /* renamed from: b */
    private void m10672b() {
        FusionBridgeModule fusionBridge = getFusionBridge();
        if (fusionBridge != null) {
            fusionBridge.addFunction("sendSignResult", new SignResult());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10674c() {
        Intent intent = new Intent();
        SignResultModel signResultModel = this.f14862c;
        if (signResultModel != null) {
            intent.putExtra("param_ddcredit_bind_result", signResultModel);
        }
        setResult(-1, intent);
        finish();
    }

    class SignResult extends FusionBridgeModule.Function {
        SignResult() {
        }

        public JSONObject execute(JSONObject jSONObject) {
            SignResultModel unused = DDCreditSignActivity.this.f14862c = new SignResultModel();
            if (jSONObject != null) {
                DDCreditSignActivity.this.f14862c.result = jSONObject.optInt("result");
                DDCreditSignActivity.this.f14862c.code = jSONObject.optInt("code");
                DDCreditSignActivity.this.f14862c.message = jSONObject.optString("message");
                Logger b = DDCreditSignActivity.this.f14860a;
                b.info("code:" + DDCreditSignActivity.this.f14862c.code + "result:" + DDCreditSignActivity.this.f14862c.result + " message:" + DDCreditSignActivity.this.f14862c.message, new Object[0]);
            }
            if (DDCreditSignActivity.this.f14862c.result == 5) {
                DDCreditSignActivity.this.m10670a(false);
                return null;
            }
            DDCreditSignActivity.this.m10670a(true);
            DDCreditSignActivity.this.m10674c();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10670a(boolean z) {
        this.f14863d = z;
        m10673b(z);
    }

    /* renamed from: b */
    private void m10673b(boolean z) {
        if (z) {
            this.f14861b.setBackBtnVisibility(0);
        } else {
            this.f14861b.setBackBtnVisibility(8);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f14863d || i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }
}
