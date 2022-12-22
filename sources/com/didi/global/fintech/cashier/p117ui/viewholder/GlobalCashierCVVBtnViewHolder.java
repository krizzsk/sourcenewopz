package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J(\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150 H\u0016R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCVVBtnViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVBtnViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "ivBrand", "Landroid/widget/ImageView;", "getIvBrand", "()Landroid/widget/ImageView;", "setIvBrand", "(Landroid/widget/ImageView;)V", "payBtn", "Landroid/widget/Button;", "getPayBtn", "()Landroid/widget/Button;", "setPayBtn", "(Landroid/widget/Button;)V", "initView", "", "layout", "", "updateBrandInfo", "url", "", "updateBtn", "enable", "", "content", "click", "Lkotlin/Function0;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCVVBtnViewHolder */
/* compiled from: GlobalCashierCVVBtnViewHolder.kt */
public final class GlobalCashierCVVBtnViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierCVVBtnViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public ImageView ivBrand;
    public Button payBtn;

    public int layout() {
        return R.layout.viewholder_global_cashier_cvv_bottom;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCVVBtnViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCVVBtnViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCVVBtnViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCVVBtnViewHolder$Companion */
    /* compiled from: GlobalCashierCVVBtnViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierCVVBtnViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierCVVBtnViewHolder(context, viewGroup);
        }
    }

    public final Button getPayBtn() {
        Button button = this.payBtn;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payBtn");
        return null;
    }

    public final void setPayBtn(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.payBtn = button;
    }

    public final ImageView getIvBrand() {
        ImageView imageView = this.ivBrand;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivBrand");
        return null;
    }

    public final void setIvBrand(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivBrand = imageView;
    }

    public void initView() {
        super.initView();
        setPayBtn((Button) getView(R.id.btn_pay));
        setIvBrand((ImageView) getView(R.id.iv_brand));
    }

    public void updateBrandInfo(String str) {
        ViewKtxKt.load(getIvBrand(), str);
    }

    public void updateBtn(boolean z, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "click");
        getPayBtn().setEnabled(z);
        getPayBtn().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierCVVBtnViewHolder.m15825a(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15825a(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$click");
        function0.invoke();
    }
}
