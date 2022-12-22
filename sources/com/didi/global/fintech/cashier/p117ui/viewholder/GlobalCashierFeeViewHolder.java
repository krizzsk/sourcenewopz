package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierFeeViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.widget.tickerview.TickerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J2\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00140\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u0012\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\"\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010&\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierFeeViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierFeeViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "actuallyReceivedAmountTV", "Lcom/didi/global/fintech/cashier/ui/widget/tickerview/TickerView;", "feeDescLayout", "Landroid/widget/LinearLayout;", "feeDescTV", "Landroid/widget/TextView;", "helpIV", "Landroid/widget/ImageView;", "merchantNameTV", "receivableAmountTV", "symbolTV", "initView", "", "layout", "", "updateAdditionalInfo", "message", "", "helpInfo", "Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "click", "Lkotlin/Function1;", "updateElevation", "e", "updateMerchantName", "name", "updateShouldPayFee", "showPaintFlag", "", "updateTotalFee", "symbol", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierFeeViewHolder */
/* compiled from: GlobalCashierFeeViewHolder.kt */
public final class GlobalCashierFeeViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierFeeViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f21791a;

    /* renamed from: b */
    private TextView f21792b;

    /* renamed from: c */
    private TickerView f21793c;

    /* renamed from: d */
    private TextView f21794d;

    /* renamed from: e */
    private ImageView f21795e;

    /* renamed from: f */
    private TextView f21796f;

    /* renamed from: g */
    private LinearLayout f21797g;

    public int layout() {
        return R.layout.viewholder_global_cashier_fee;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierFeeViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierFeeViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierFeeViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierFeeViewHolder$Companion */
    /* compiled from: GlobalCashierFeeViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierFeeViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierFeeViewHolder(context, viewGroup);
        }
    }

    public void initView() {
        attach(0);
        View findViewById = getMRootView().findViewById(R.id.tv_merchant_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.tv_merchant_name)");
        this.f21791a = (TextView) findViewById;
        View findViewById2 = getMRootView().findViewById(R.id.tv_receivable_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.tv_receivable_amount)");
        this.f21792b = (TextView) findViewById2;
        View findViewById3 = getMRootView().findViewById(R.id.tv_actually_received_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R…actually_received_amount)");
        this.f21793c = (TickerView) findViewById3;
        View findViewById4 = getMRootView().findViewById(R.id.tv_fee_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.tv_fee_desc)");
        this.f21794d = (TextView) findViewById4;
        View findViewById5 = getMRootView().findViewById(R.id.iv_help);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.iv_help)");
        this.f21795e = (ImageView) findViewById5;
        View findViewById6 = getMRootView().findViewById(R.id.tv_actually_received_symbol);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R…actually_received_symbol)");
        this.f21796f = (TextView) findViewById6;
        View findViewById7 = getMRootView().findViewById(R.id.layout_fee_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.layout_fee_desc)");
        this.f21797g = (LinearLayout) findViewById7;
    }

    public void updateElevation(int i) {
        GlobalCashierFeeViewHolder globalCashierFeeViewHolder = this;
        if ((i > 200 ? this : null) == null) {
            float f = (float) (i / 20);
            getMRootView().setElevation(f);
            getMRootView().setTranslationZ(f);
        }
    }

    public void updateMerchantName(String str) {
        TextView textView = this.f21791a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("merchantNameTV");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
    }

    public void updateShouldPayFee(String str, boolean z) {
        TextView textView = this.f21792b;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receivableAmountTV");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
        if (z) {
            TextView textView3 = this.f21792b;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("receivableAmountTV");
            } else {
                textView2 = textView3;
            }
            textView2.setPaintFlags(16);
        }
    }

    public void updateTotalFee(String str, String str2) {
        TextView textView = this.f21796f;
        TickerView tickerView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("symbolTV");
            textView = null;
        }
        ViewKtxKt.content(textView, str2);
        if (TextUtils.isEmpty(str)) {
            TickerView tickerView2 = this.f21793c;
            if (tickerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actuallyReceivedAmountTV");
            } else {
                tickerView = tickerView2;
            }
            tickerView.setVisibility(8);
            return;
        }
        TickerView tickerView3 = this.f21793c;
        if (tickerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actuallyReceivedAmountTV");
            tickerView3 = null;
        }
        tickerView3.setVisibility(0);
        TickerView tickerView4 = this.f21793c;
        if (tickerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actuallyReceivedAmountTV");
            tickerView4 = null;
        }
        tickerView4.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN);
        TickerView tickerView5 = this.f21793c;
        if (tickerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actuallyReceivedAmountTV");
        } else {
            tickerView = tickerView5;
        }
        tickerView.setText(str);
    }

    public void updateAdditionalInfo(String str, FeeHelpInfo feeHelpInfo, Function1<? super FeeHelpInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "click");
        TextView textView = this.f21794d;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feeDescTV");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
        LinearLayout linearLayout = this.f21797g;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feeDescLayout");
            linearLayout = null;
        }
        CharSequence charSequence = str;
        int i = 0;
        linearLayout.setVisibility((charSequence == null || charSequence.length() == 0) ^ true ? 0 : 8);
        ImageView imageView2 = this.f21795e;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpIV");
            imageView2 = null;
        }
        View view = imageView2;
        if (!(!(charSequence == null || charSequence.length() == 0))) {
            i = 8;
        }
        view.setVisibility(i);
        ImageView imageView3 = this.f21795e;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpIV");
        } else {
            imageView = imageView3;
        }
        ViewKtxKt.click$default(imageView, 0, new GlobalCashierFeeViewHolder$updateAdditionalInfo$1(function1, feeHelpInfo), 1, (Object) null);
    }
}
