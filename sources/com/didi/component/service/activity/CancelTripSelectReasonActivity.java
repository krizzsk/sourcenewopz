package com.didi.component.service.activity;

import android.os.Bundle;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;

public class CancelTripSelectReasonActivity extends WebActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (getWebView() != null) {
            getWebView().getSettings().setCacheMode(2);
            getWebView().getSettings().setAppCacheEnabled(false);
        }
        GlobalOmegaUtils.trackEvent("gp_cancelOrder_view_sw");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
