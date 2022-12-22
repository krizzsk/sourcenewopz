package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder.TopCardViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "context", "Landroid/content/Context;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion$initFreezeStatus$freezeCallback$1 */
/* compiled from: WalletHomeFreeze.kt */
final class WalletHomeFreeze$Companion$initFreezeStatus$freezeCallback$1 extends Lambda implements Function1<Context, Unit> {
    final /* synthetic */ TopCardViewHolder $holder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeFreeze$Companion$initFreezeStatus$freezeCallback$1(TopCardViewHolder topCardViewHolder) {
        super(1);
        this.$holder = topCardViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Context) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TopCardViewHolder topCardViewHolder = this.$holder;
        topCardViewHolder.getFlRoot().setBackgroundResource(R.drawable.shape_home_top_background_freeze);
        topCardViewHolder.getIvFreezeIcon().setVisibility(0);
        int color = ContextCompat.getColor(context, R.color.wallet_color_FF4060);
        topCardViewHolder.getTvFreezeTitle().setTextColor(color);
        topCardViewHolder.getTvFreezeDesc().setTextColor(color);
        Glide.with(context).load(Integer.valueOf(R.drawable.ic_home_freeze_next)).into(topCardViewHolder.getIvFreeze());
        topCardViewHolder.getTvTopUp().setBackgroundResource(R.drawable.shape_home_top_card_topup_grey);
        topCardViewHolder.getTvTopUp().setTextColor(ContextCompat.getColor(context, R.color.wallet_color_DADCDE));
        topCardViewHolder.getIvCardRight().setVisibility(8);
        topCardViewHolder.getClCard().setBackgroundResource(R.drawable.shape_home_top_card);
        topCardViewHolder.getViewLine().setVisibility(8);
        topCardViewHolder.getLlPrepaidMsg().setVisibility(8);
    }
}
