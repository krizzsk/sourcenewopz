package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.app.Activity;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.view.PayGlobalLoading;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomePage$initLoadingDialog$1", "Lcom/didi/payment/base/proxy/LoadingProxyHolder$ILoadingProxy;", "dismissLoading", "", "showLoading", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage$initLoadingDialog$1 */
/* compiled from: WalletHomePage.kt */
public final class WalletHomePage$initLoadingDialog$1 implements LoadingProxyHolder.ILoadingProxy {
    final /* synthetic */ Activity $context;
    final /* synthetic */ WalletHomePage this$0;

    WalletHomePage$initLoadingDialog$1(Activity activity, WalletHomePage walletHomePage) {
        this.$context = activity;
        this.this$0 = walletHomePage;
    }

    public void showLoading() {
        PayGlobalLoading.show(this.$context, (int) R.id.ll_wallet_page_loading, false);
    }

    public void dismissLoading() {
        PayGlobalLoading.hide(this.this$0.f32647d);
    }
}
