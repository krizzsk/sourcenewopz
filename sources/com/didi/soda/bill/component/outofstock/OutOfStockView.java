package com.didi.soda.bill.component.outofstock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/bill/component/outofstock/OutOfStockView;", "Lcom/didi/soda/bill/component/Contract$AbsOutOfStockView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "cartId", "", "confirmBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "shopId", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "init", "", "initDefaultData", "initItemBinders", "onCreate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OutOfStockView.kt */
public final class OutOfStockView extends Contract.AbsOutOfStockView implements IRFFloatingExpand {

    /* renamed from: a */
    private RFMainButton f38949a;

    /* renamed from: b */
    private NovaRecyclerView f38950b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f38951c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f38952d;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public void onCreate() {
        super.onCreate();
        m27667a();
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f38950b;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new OutOfStockDescBinder());
        registerBinder(new OutOfStockView$initItemBinders$1(this));
    }

    public void initDefaultData(String str, String str2) {
        this.f38951c = str;
        this.f38952d = str2;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_out_of_stock, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_custom_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.customer_custom_confirm)");
        this.f38949a = (RFMainButton) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_rv_out_of_stock);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.customer_rv_out_of_stock)");
        this.f38950b = (NovaRecyclerView) findViewById2;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…v_out_of_stock)\n        }");
        return inflate;
    }

    /* renamed from: a */
    private final void m27667a() {
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    OutOfStockView.m27668a(OutOfStockView.this, view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_demand_Goods_are_usRR)).build());
            navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        }
        RFMainButton rFMainButton = this.f38949a;
        RFMainButton rFMainButton2 = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton = null;
        }
        rFMainButton.setText(ResourceHelper.getString(R.string.FoodC_demand_Determination_wKQX));
        RFMainButton rFMainButton3 = this.f38949a;
        if (rFMainButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        } else {
            rFMainButton2 = rFMainButton3;
        }
        rFMainButton2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OutOfStockView.m27669b(OutOfStockView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27668a(OutOfStockView outOfStockView, View view) {
        Intrinsics.checkNotNullParameter(outOfStockView, "this$0");
        ((Contract.AbsOutOfStockPresenter) outOfStockView.getPresenter()).finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27669b(OutOfStockView outOfStockView, View view) {
        Intrinsics.checkNotNullParameter(outOfStockView, "this$0");
        ((Contract.AbsOutOfStockPresenter) outOfStockView.getPresenter()).confirmUpdate();
        ((Contract.AbsOutOfStockPresenter) outOfStockView.getPresenter()).finish();
    }
}
