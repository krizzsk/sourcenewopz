package global.didi.pay.web;

import android.os.Bundle;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class UniPayWebActivity extends PayBaseWebActivity {
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }
}
