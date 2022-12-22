package com.didi.sdk.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.router.PageRouter;
import com.didi.sdk.apm.SystemUtils;

public class MainActivityDispatcher extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        PageRouter.getInstance().startMainActivity(this, getIntent());
        finish();
    }
}
