package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TopCardViewHolder;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeFreeze;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion$initFreezeStatus$2$1$1 */
/* compiled from: WalletHomeFreeze.kt */
final class WalletHomeFreeze$Companion$initFreezeStatus$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TopCardViewHolder $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeFreeze$Companion$initFreezeStatus$2$1$1(TopCardViewHolder topCardViewHolder, Context context) {
        super(0);
        this.$this_apply = topCardViewHolder;
        this.$context = context;
    }

    public final void invoke() {
        this.$this_apply.getFlRoot().setBackground(WalletHomeFreeze.Companion.scalePic$default(WalletHomeFreeze.Companion, this.$context, R.drawable.ic_home_top_card_background, 0, (Bitmap.Config) null, 12, (Object) null));
    }
}
