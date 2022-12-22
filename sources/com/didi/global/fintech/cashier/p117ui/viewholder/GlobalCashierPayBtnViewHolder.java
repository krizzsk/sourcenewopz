package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0016R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierPayBtnViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "payBtn", "Landroid/widget/Button;", "getPayBtn", "()Landroid/widget/Button;", "setPayBtn", "(Landroid/widget/Button;)V", "initView", "", "layout", "", "updateBtn", "enable", "", "content", "", "click", "Lkotlin/Function0;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierPayBtnViewHolder */
/* compiled from: GlobalCashierPayBtnViewHolder.kt */
public final class GlobalCashierPayBtnViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierPayBtnViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Button payBtn;

    public int layout() {
        return R.layout.viewholder_global_cashier_bottom;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPayBtnViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierPayBtnViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierPayBtnViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierPayBtnViewHolder$Companion */
    /* compiled from: GlobalCashierPayBtnViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierPayBtnViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierPayBtnViewHolder(context, viewGroup);
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

    public void initView() {
        super.initView();
        setPayBtn((Button) getView(R.id.btn_pay));
    }

    public void updateBtn(boolean z, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "click");
        getPayBtn().setEnabled(z);
        getPayBtn().setText(str);
        getPayBtn().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierPayBtnViewHolder.m15828a(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15828a(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$click");
        function0.invoke();
    }
}
