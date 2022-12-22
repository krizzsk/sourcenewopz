package com.didi.soda.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.pay.PayOmegaHelper;
import global.didi.pay.GlobalUniPayActivity;

public class CustomerUniPayEntranceActivity extends GlobalUniPayActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        StatusBarLightingCompat.setStatusBarBgLightning(this, false, 0);
        PayOmegaHelper.openPayUniActivity();
    }

    public void callStartActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void callStartActivity(Intent intent) {
        startActivity(intent);
    }
}
