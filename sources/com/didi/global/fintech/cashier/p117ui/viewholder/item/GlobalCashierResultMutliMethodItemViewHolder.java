package com.didi.global.fintech.cashier.p117ui.viewholder.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.GlobalCashierBaseViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierResultMutliMethodItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "displayTV", "Landroid/widget/TextView;", "iconIV", "Landroid/widget/ImageView;", "priceTV", "initView", "", "layout", "", "setData", "display", "", "icon", "price", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierResultMutliMethodItemViewHolder */
/* compiled from: GlobalCashierResultMutliMethodItemViewHolder.kt */
public final class GlobalCashierResultMutliMethodItemViewHolder extends GlobalCashierBaseViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f21865a;

    /* renamed from: b */
    private ImageView f21866b;

    /* renamed from: c */
    private TextView f21867c;

    public int layout() {
        return R.layout.viewholder_pay_result_mutli_method_item;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierResultMutliMethodItemViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierResultMutliMethodItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierResultMutliMethodItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierResultMutliMethodItemViewHolder$Companion */
    /* compiled from: GlobalCashierResultMutliMethodItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierResultMutliMethodItemViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierResultMutliMethodItemViewHolder(context, viewGroup);
        }
    }

    public void initView() {
        super.initView();
        View findViewById = getMRootView().findViewById(R.id.tv_item_display_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.tv_item_display_name)");
        this.f21865a = (TextView) findViewById;
        View findViewById2 = getMRootView().findViewById(R.id.iv_item_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.iv_item_icon)");
        this.f21866b = (ImageView) findViewById2;
        View findViewById3 = getMRootView().findViewById(R.id.tv_item_price);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.tv_item_price)");
        this.f21867c = (TextView) findViewById3;
    }

    public final void setData(String str, String str2, String str3) {
        ImageView imageView = this.f21866b;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconIV");
            imageView = null;
        }
        ViewKtxKt.load(imageView, str2);
        TextView textView2 = this.f21865a;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayTV");
            textView2 = null;
        }
        ViewKtxKt.content(textView2, str);
        TextView textView3 = this.f21867c;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceTV");
        } else {
            textView = textView3;
        }
        ViewKtxKt.content(textView, str3);
    }
}
