package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.didi.global.fintech.cashier.p117ui.IFastPayMainBtnViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J2\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001fH\u0016R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayMainBtnViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IFastPayMainBtnViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "payBtn", "Landroid/widget/Button;", "getPayBtn", "()Landroid/widget/Button;", "setPayBtn", "(Landroid/widget/Button;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "initView", "", "layout", "", "updateBtn", "enable", "", "selected", "content", "", "click", "Lkotlin/Function0;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPayMainBtnViewHolder */
/* compiled from: FastPayMainBtnViewHolder.kt */
public final class FastPayMainBtnViewHolder extends GlobalCashierBaseViewHolder implements IFastPayMainBtnViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Button payBtn;
    public View rootView;

    public int layout() {
        return R.layout.viewholder_fast_pay_bottom;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayMainBtnViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayMainBtnViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayMainBtnViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPayMainBtnViewHolder$Companion */
    /* compiled from: FastPayMainBtnViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPayMainBtnViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new FastPayMainBtnViewHolder(context, viewGroup);
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

    public final View getRootView() {
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final void setRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.rootView = view;
    }

    public void initView() {
        super.initView();
        setPayBtn((Button) getView(R.id.btn_pay));
        setRootView(getView(R.id.layout_bottom_bar));
    }

    public void updateBtn(boolean z, boolean z2, String str, Function0<Unit> function0) {
        getPayBtn().setEnabled(z);
        getPayBtn().setSelected(z2);
        if (str != null) {
            getPayBtn().setText(str);
        }
        if (function0 != null) {
            getPayBtn().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FastPayMainBtnViewHolder.m15822a(Function0.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15822a(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$event");
        function0.invoke();
    }
}
