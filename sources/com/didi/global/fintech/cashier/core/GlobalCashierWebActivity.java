package com.didi.global.fintech.cashier.core;

import android.os.Bundle;
import com.didi.global.fintech.cashier.core.utils.ThemeManager;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierWebActivity;", "Lcom/didi/payment/base/view/webview/PayBaseWebActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierWebActivity.kt */
public final class GlobalCashierWebActivity extends PayBaseWebActivity {
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        ThemeManager.INSTANCE.initTheme(this);
        super.onCreate(bundle);
    }
}
