package com.didi.sdk.global.sign.payselect.utils;

import android.app.Activity;
import com.didi.payment.wallet.global.proxy.PayPalProxy;
import com.didi.sdk.global.paypal.activity.PayPalRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/sdk/global/sign/payselect/utils/PaySelRouter$jumpToWalletHomePage$1", "Lcom/didi/payment/wallet/global/proxy/PayPalProxy$IPayPalProxy;", "startPayPalActivity", "", "activity", "Landroid/app/Activity;", "requestCode", "", "startPayPalDetailActivity", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaySelRouter.kt */
public final class PaySelRouter$jumpToWalletHomePage$1 implements PayPalProxy.IPayPalProxy {
    PaySelRouter$jumpToWalletHomePage$1() {
    }

    public void startPayPalActivity(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PayPalRouter.launchAddPayPalActivity(activity, i, true);
    }

    public void startPayPalDetailActivity(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PayPalRouter.launchPayPalDetailActivity(activity, i);
    }
}
