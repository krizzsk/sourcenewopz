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

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J<\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierResultSingleMethodItemViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "displayTV", "Landroid/widget/TextView;", "iconIV", "Landroid/widget/ImageView;", "installmentAmountTV", "installmentNameTV", "titleTV", "initView", "", "layout", "", "setData", "title", "", "icon", "display", "installmentName", "installmentAmount", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierResultSingleMethodItemViewHolder */
/* compiled from: GlobalCashierResultSingleMethodItemViewHolder.kt */
public final class GlobalCashierResultSingleMethodItemViewHolder extends GlobalCashierBaseViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f21868a;

    /* renamed from: b */
    private ImageView f21869b;

    /* renamed from: c */
    private TextView f21870c;

    /* renamed from: d */
    private TextView f21871d;

    /* renamed from: e */
    private TextView f21872e;

    public int layout() {
        return R.layout.viewholder_pay_result_single_method_item;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierResultSingleMethodItemViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierResultSingleMethodItemViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierResultSingleMethodItemViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.GlobalCashierResultSingleMethodItemViewHolder$Companion */
    /* compiled from: GlobalCashierResultSingleMethodItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierResultSingleMethodItemViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierResultSingleMethodItemViewHolder(context, viewGroup);
        }
    }

    public void initView() {
        super.initView();
        View findViewById = getMRootView().findViewById(R.id.tv_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.tv_item_title)");
        this.f21868a = (TextView) findViewById;
        View findViewById2 = getMRootView().findViewById(R.id.iv_item_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.iv_item_icon)");
        this.f21869b = (ImageView) findViewById2;
        View findViewById3 = getMRootView().findViewById(R.id.tv_item_display_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.tv_item_display_name)");
        this.f21870c = (TextView) findViewById3;
        View findViewById4 = getMRootView().findViewById(R.id.tv_item_installment_name);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R…tv_item_installment_name)");
        this.f21871d = (TextView) findViewById4;
        View findViewById5 = getMRootView().findViewById(R.id.tv_item_installment_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R…_item_installment_amount)");
        this.f21872e = (TextView) findViewById5;
    }

    public static /* synthetic */ void setData$default(GlobalCashierResultSingleMethodItemViewHolder globalCashierResultSingleMethodItemViewHolder, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        globalCashierResultSingleMethodItemViewHolder.setData(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final void setData(String str, String str2, String str3, String str4, String str5) {
        ImageView imageView = this.f21869b;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconIV");
            imageView = null;
        }
        ViewKtxKt.load(imageView, str2);
        TextView textView2 = this.f21870c;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayTV");
            textView2 = null;
        }
        ViewKtxKt.content(textView2, str3);
        TextView textView3 = this.f21871d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("installmentNameTV");
            textView3 = null;
        }
        ViewKtxKt.content(textView3, str4);
        TextView textView4 = this.f21872e;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("installmentAmountTV");
        } else {
            textView = textView4;
        }
        ViewKtxKt.content(textView, str5);
    }
}
