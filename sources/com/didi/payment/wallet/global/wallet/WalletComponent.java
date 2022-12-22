package com.didi.payment.wallet.global.wallet;

import android.app.Application;
import com.didi.payment.base.lifecycle.WalletActivityLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/WalletComponent;", "", "()V", "initSDK", "", "context", "Landroid/app/Application;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletComponent.kt */
public final class WalletComponent {
    public static final WalletComponent INSTANCE = new WalletComponent();

    private WalletComponent() {
    }

    public final void initSDK(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        WalletDiffUI.Companion.init();
        application.registerActivityLifecycleCallbacks(new WalletActivityLifecycle());
    }
}
