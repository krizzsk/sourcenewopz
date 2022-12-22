package com.didi.sdk.payment.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayPalData;
import com.didi.sdk.webview.OverrideUrlLoader;
import com.didi.sdk.webview.WebActivity;

public class PayPalActivity extends WebActivity {
    public static final String REQ_EXTRA_BACK_URL = "backUrl";
    public static final String REQ_EXTRA_CANCEL_URL = "cancelUrl";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f36903a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f36904b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m26149c();
        m26148b();
    }

    /* renamed from: b */
    private void m26148b() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("backUrl");
            String stringExtra2 = intent.getStringExtra("cancelUrl");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = DidiGlobalPayPalData.PAYPAL_DEFAULT_CALL_BACK_URL;
            }
            this.f36903a = stringExtra;
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = DidiGlobalPayPalData.PAYPAL_DEFAULT_CALL_CANCEL_URL;
            }
            this.f36904b = stringExtra2;
        }
    }

    /* renamed from: c */
    private void m26149c() {
        addOverrideUrlLoader(new OverrideUrlLoader() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(PayPalActivity.this.f36903a)) {
                    DidiGlobalPayApiFactory.createDidiPay().verifyPayPal(PayPalActivity.this, Uri.parse(str).getQueryParameter("token"), new DidiGlobalPayPalData.PayPalVerifyCallback() {
                        public void onResult(int i, String str) {
                            PayPalActivity.this.m26145a(i, str);
                            PayPalActivity.this.finish();
                        }
                    });
                    return true;
                } else if (TextUtils.isEmpty(str) || !str.contains(PayPalActivity.this.f36904b)) {
                    return false;
                } else {
                    PayPalActivity.this.m26145a(2, "cancel");
                    PayPalActivity.this.finish();
                    return true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26145a(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("errno", i);
        intent.putExtra("errmsg", str);
        setResult(-1, intent);
    }
}
