package com.didi.component.payentrance.activity;

import android.content.Intent;
import android.os.Bundle;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.PassengerProxyWebActivity;
import global.didi.pay.GlobalUniPayActivity;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.newview.NewGlobalPaymentView;

public class UnipayEntranceActivity extends GlobalUniPayActivity {

    /* renamed from: b */
    private static final String f14872b = "UnipayEntranceActivity";

    /* renamed from: a */
    private UniPayManager f14873a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        UniPayManager uniPayManager = new UniPayManager();
        this.f14873a = uniPayManager;
        uniPayManager.registerPushListener(this, f14872b);
        super.onCreate(bundle);
        StatusBarLightingCompat.setStatusBarBgLightning(this, false, 0);
    }

    /* access modifiers changed from: protected */
    public IGlobalPayView createPaymentView() {
        return new NewGlobalPaymentView(this);
    }

    public void callStartActivityForResult(Intent intent, int i) {
        if (intent != null && intent.getClass() == null) {
            intent.setClass(this, PassengerProxyWebActivity.class);
        }
        intent.setPackage(UniPayManager.getPackageName(this));
        startActivityForResult(intent, i);
    }

    public void callStartActivity(Intent intent) {
        if (intent != null && intent.getClass() == null) {
            intent.setClass(this, PassengerProxyWebActivity.class);
        }
        intent.setPackage(UniPayManager.getPackageName(this));
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EndService.EVENT_ENDSERVCIE_TIP_PAYED);
        this.f14873a.unregisterPushListener();
    }
}
