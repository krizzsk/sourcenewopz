package com.didi.sdk.payment.activity;

import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.BaseWebView;
import com.didi.sdk.webview.WebActivity;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;

public class SignIntroActivity extends WebActivity {

    /* renamed from: a */
    private BaseWebView f36905a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.a_sign_intro);
        setResult(2);
        String stringExtra = getIntent().getStringExtra("url");
        if (TextUtil.isEmpty(stringExtra)) {
            finish();
            return;
        }
        m26151b();
        this.f36905a.loadUrl(m26150a(stringExtra));
    }

    /* renamed from: a */
    private String m26150a(String str) {
        String str2;
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        String str3 = "0";
        if (didiLocation != null) {
            str3 = String.valueOf(didiLocation.getLatitude());
            str2 = String.valueOf(didiLocation.getLongitude());
        } else {
            str2 = str3;
        }
        return str + "?lat=" + str3 + "&lon=" + str2;
    }

    /* renamed from: b */
    private void m26151b() {
        BaseWebView baseWebView = (BaseWebView) findViewById(R.id.web_view);
        this.f36905a = baseWebView;
        baseWebView.setBackgroundColor(0);
    }

    public void finish() {
        super.finish();
    }
}
