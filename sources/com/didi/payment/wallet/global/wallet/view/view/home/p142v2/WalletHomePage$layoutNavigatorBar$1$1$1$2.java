package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.net.Uri;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.wallet.global.wallet.entity.WalletSettingPageInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage$layoutNavigatorBar$1$1$1$2 */
/* compiled from: WalletHomePage.kt */
final class WalletHomePage$layoutNavigatorBar$1$1$1$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ WalletSettingPageInfo $info;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ WalletHomePage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomePage$layoutNavigatorBar$1$1$1$2(Uri uri, WalletSettingPageInfo walletSettingPageInfo, WalletHomePage walletHomePage) {
        super(1);
        this.$uri = uri;
        this.$info = walletSettingPageInfo;
        this.this$0 = walletHomePage;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        ((Request) DRouter.build(this.$uri.toString()).putExtra(WalletExtraConstant.Key.WALLET_SIDEBAR_PAGE_MODEL, (Serializable) this.$info)).start(this.this$0.getContext());
    }
}
