package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.content.Intent;
import com.didi.drouter.router.RouterCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1 */
/* compiled from: WalletHomeV2Presenter.kt */
public final class WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1 extends RouterCallback.ActivityCallback {
    final /* synthetic */ WalletHomeV2Presenter this$0;

    WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1(WalletHomeV2Presenter walletHomeV2Presenter) {
        this.this$0 = walletHomeV2Presenter;
    }

    public void onActivityResult(int i, Intent intent) {
        this.this$0.requestData();
    }
}
