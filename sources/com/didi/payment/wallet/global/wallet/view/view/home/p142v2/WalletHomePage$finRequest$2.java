package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.content.Context;
import com.didi.payment.base.finResource.FinResourceRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/payment/base/finResource/FinResourceRequest;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage$finRequest$2 */
/* compiled from: WalletHomePage.kt */
final class WalletHomePage$finRequest$2 extends Lambda implements Function0<FinResourceRequest> {
    final /* synthetic */ WalletHomePage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomePage$finRequest$2(WalletHomePage walletHomePage) {
        super(0);
        this.this$0 = walletHomePage;
    }

    public final FinResourceRequest invoke() {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new FinResourceRequest(context);
    }
}
