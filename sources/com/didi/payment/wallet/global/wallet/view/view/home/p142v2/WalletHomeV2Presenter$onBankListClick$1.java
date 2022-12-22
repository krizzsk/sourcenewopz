package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.content.Intent;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onBankListClick$1 */
/* compiled from: WalletHomeV2Presenter.kt */
final class WalletHomeV2Presenter$onBankListClick$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ String $url;
    final /* synthetic */ WalletHomeV2Presenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeV2Presenter$onBankListClick$1(String str, WalletHomeV2Presenter walletHomeV2Presenter) {
        super(1);
        this.$url = str;
        this.this$0 = walletHomeV2Presenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        final WalletHomeV2Presenter walletHomeV2Presenter = this.this$0;
        ((Request) DRouter.build(this.$url).putExtra("resource_id", this.this$0.getSource())).start(this.this$0.f32658b, new RouterCallback.ActivityCallback() {
            public void onActivityResult(int i, Intent intent) {
                walletHomeV2Presenter.requestData();
            }
        });
    }
}
