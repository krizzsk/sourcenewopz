package com.didi.dimina.webview.container;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class FusionWebActivityInternal extends BaseHybridableActivity {
    public static final String KEY_URL = "url";

    /* renamed from: a */
    private FusionWebView f18228a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.hasExtra("url")) {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra)) {
                mo57884a();
                return;
            }
            setContentView((int) R.layout.dimina_fusion_internal_webview_layout);
            FusionWebView fusionWebView = (FusionWebView) findViewById(R.id.webView);
            this.f18228a = fusionWebView;
            fusionWebView.loadUrl(stringExtra);
            return;
        }
        SystemUtils.showToast(Toast.makeText(getApplicationContext(), "WebActivity can not get WebViewModel from extra data, exit.", 0));
        mo57884a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57884a() {
        setResult(0);
        finish();
    }

    public FusionWebView getWebView() {
        return this.f18228a;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        FusionWebView fusionWebView = this.f18228a;
        if (fusionWebView != null) {
            fusionWebView.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        FusionWebView fusionWebView = this.f18228a;
        if (fusionWebView != null) {
            fusionWebView.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        FusionWebView fusionWebView = this.f18228a;
        if (fusionWebView != null) {
            fusionWebView.destroy();
        }
    }
}
