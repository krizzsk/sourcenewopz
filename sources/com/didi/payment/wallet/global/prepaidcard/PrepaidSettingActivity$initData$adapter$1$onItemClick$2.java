package com.didi.payment.wallet.global.prepaidcard;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidSettingActivity.kt */
final class PrepaidSettingActivity$initData$adapter$1$onItemClick$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$2 $listener;
    final /* synthetic */ String $source;
    final /* synthetic */ PrepaidSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrepaidSettingActivity$initData$adapter$1$onItemClick$2(PrepaidSettingActivity prepaidSettingActivity, String str, PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$2 prepaidSettingActivity$initData$adapter$1$onItemClick$listener$2) {
        super(1);
        this.this$0 = prepaidSettingActivity;
        this.$source = str;
        this.$listener = prepaidSettingActivity$initData$adapter$1$onItemClick$listener$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        this.this$0.showLoadingDialog();
        PrepaidCardManager.Companion.start(this.this$0, this.$source, PrepaidConstant.SCENE_APPLY, WalletHomeTrackerManager.Companion.getStatus(), "1", this.this$0.getCardId(), this.$listener);
    }
}
