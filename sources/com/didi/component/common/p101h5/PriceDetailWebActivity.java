package com.didi.component.common.p101h5;

import android.os.Bundle;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.WebActivity;
import com.taxis99.R;

/* renamed from: com.didi.component.common.h5.PriceDetailWebActivity */
public class PriceDetailWebActivity extends WebActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.common_status_background));
        super.onCreate(bundle);
    }

    public void onBackPressed() {
        m7851b();
    }

    /* renamed from: b */
    private void m7851b() {
        finish();
        overridePendingTransition(R.anim.slide_back_in, R.anim.slide_back_out);
    }
}
