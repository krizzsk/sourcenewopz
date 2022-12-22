package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import com.didi.drouter.api.DRouter;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.payment.wallet.global.prepaidcard.PrepaidSource;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.ResourceStateData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.BannerViewHolder$onBindViewHolder$1$2$1 */
/* compiled from: BannerViewHolder.kt */
final class BannerViewHolder$onBindViewHolder$1$2$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ResourceStateData $this_apply;
    final /* synthetic */ BannerViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BannerViewHolder$onBindViewHolder$1$2$1(ResourceStateData resourceStateData, BannerViewHolder bannerViewHolder) {
        super(1);
        this.$this_apply = resourceStateData;
        this.this$0 = bannerViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        String link = this.$this_apply.getLink();
        boolean z = true;
        if (link == null || !StringsKt.contains$default((CharSequence) link, (CharSequence) PrepaidCardManager.PREPAID_CARD_URL_PATH, false, 2, (Object) null)) {
            z = false;
        }
        if (z) {
            PrepaidCardManager.Companion.start$default(PrepaidCardManager.Companion, this.this$0.itemView.getContext(), PrepaidSource.HOME_BANNER.getValue(), PrepaidConstant.SCENE_APPLY, WalletHomeTrackerManager.Companion.getStatus(), (String) null, (String) null, new BannerViewHolder$onBindViewHolder$1$2$1$listener$1(this.this$0), 48, (Object) null);
            WalletHomeTrackerManager.Companion.trackCardPrepaidApply$default(WalletHomeTrackerManager.Companion, WalletHomeTrackerManager.Companion.getPrepaidType(), "fin_prepaidcard_cardbanner_ck", (Integer) null, 4, (Object) null);
        } else {
            DRouter.build(this.$this_apply.getLink()).start(this.this$0.itemView.getContext());
            EventBus.getDefault().post(new WalletRefreshDataEvent());
        }
        WalletHomeTrackerManager.Companion.trackFinBannerCK(this.$this_apply);
        FinExtAttrBiz.updateActId2FinGlobalAttrs(this.$this_apply.getActivityId());
    }
}
