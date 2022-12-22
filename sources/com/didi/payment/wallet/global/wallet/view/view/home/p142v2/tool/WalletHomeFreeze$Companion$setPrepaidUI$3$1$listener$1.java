package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.content.Context;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.payment.wallet.global.prepaidcard.PrepaidSource;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountStatusMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1", "Lcom/didi/drouter/router/RouterCallback;", "onResult", "", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1 */
/* compiled from: WalletHomeFreeze.kt */
public final class WalletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1 implements RouterCallback {
    final /* synthetic */ Context $context;
    final /* synthetic */ AccountSection $info;

    WalletHomeFreeze$Companion$setPrepaidUI$3$1$listener$1(Context context, AccountSection accountSection) {
        this.$context = context;
        this.$info = accountSection;
    }

    public void onResult(Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int i = result.getInt("result");
        if (i == 1) {
            EventBus.getDefault().post(new WalletRefreshDataEvent());
        } else if (i == 3) {
            PrepaidCardManager.Companion companion = PrepaidCardManager.Companion;
            Context context = this.$context;
            String value = PrepaidSource.HOME_TOP.getValue();
            AccountStatusMessage accountStatusMessage = this.$info.getAccountStatusMessage();
            PrepaidCardManager.Companion.start$default(companion, context, value, PrepaidConstant.SCENE_APPLY, accountStatusMessage == null ? null : accountStatusMessage.getStatus(), "1", (String) null, this, 32, (Object) null);
        }
    }
}
