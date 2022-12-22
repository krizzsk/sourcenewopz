package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
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
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion$initFreezeStatus$2 */
/* compiled from: WalletHomeFreeze.kt */
final class WalletHomeFreeze$Companion$initFreezeStatus$2 extends Lambda implements Function1<Context, Unit> {
    final /* synthetic */ TopCardViewHolder $holder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeFreeze$Companion$initFreezeStatus$2(TopCardViewHolder topCardViewHolder) {
        super(1);
        this.$holder = topCardViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Context) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        TopCardViewHolder topCardViewHolder = this.$holder;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(WalletHomeController.Companion.findHomePageTheme(context), typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, new int[]{R.attr.wallet_home_header_background, R.attr.wallet_home_header_card_button, R.attr.wallet_home_header_card_button_text_color});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ue.resourceId, attribute)");
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        try {
            i = obtainStyledAttributes.getColor(2, ContextCompat.getColor(context, R.color.wallet_color_000000));
        } catch (Exception unused) {
            i = ContextCompat.getColor(context, R.color.wallet_color_000000);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        topCardViewHolder.getTvTopUp().setBackground(drawable);
        topCardViewHolder.getClTopUp$wallet_globalRelease().setBackgroundResource(resourceId);
        topCardViewHolder.getTvTopUp().setTextColor(i);
        WalletHomeController.Companion.executeForTerminalId(context, new WalletHomeFreeze$Companion$initFreezeStatus$2$1$1(topCardViewHolder, context), new WalletHomeFreeze$Companion$initFreezeStatus$2$1$2(topCardViewHolder, context));
        topCardViewHolder.getIvFreezeIcon().setVisibility(8);
        topCardViewHolder.getClFreeze().setVisibility(8);
        Glide.with(context).load(Integer.valueOf(R.drawable.ic_home_top_card_balance_next)).into(topCardViewHolder.getIvFreeze());
        topCardViewHolder.getIvCardRight().setVisibility(0);
        topCardViewHolder.getClCard().setBackgroundResource(R.drawable.shape_home_top_card);
    }
}
