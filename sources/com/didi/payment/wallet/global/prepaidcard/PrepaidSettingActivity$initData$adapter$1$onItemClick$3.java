package com.didi.payment.wallet.global.prepaidcard;

import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet.global.prepaidcard.PrepaidSettingActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidSettingActivity.kt */
final class PrepaidSettingActivity$initData$adapter$1$onItemClick$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PrepaidSettingActivity.SettingResp $item;
    final /* synthetic */ PrepaidSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrepaidSettingActivity$initData$adapter$1$onItemClick$3(PrepaidSettingActivity.SettingResp settingResp, PrepaidSettingActivity prepaidSettingActivity) {
        super(0);
        this.$item = settingResp;
        this.this$0 = prepaidSettingActivity;
    }

    public final void invoke() {
        DRouter.build(PrepaidCardManager.Companion.buildWalletUrl(this.$item.getLinkUrl())).start(this.this$0);
    }
}
