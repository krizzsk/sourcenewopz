package com.didi.soda.address.component.selectlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.address.component.feed.view.AddressRecyclerView;
import com.didi.soda.address.component.selectlist.Contract;
import com.didi.soda.address.component.selectlist.binder.SelectedAddressDescBinder;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0014J\b\u0010'\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u00100\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00063"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/SelectedAddressView;", "Lcom/didi/soda/address/component/selectlist/Contract$AbsSelectedAddressView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "mAddressAbnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "getMAddressAbnormalView", "()Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "setMAddressAbnormalView", "(Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;)V", "mConfirmBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "getMConfirmBtn", "()Lcom/didi/rfusion/widget/button/RFMainButton;", "setMConfirmBtn", "(Lcom/didi/rfusion/widget/button/RFMainButton;)V", "mConfirmLayout", "Landroid/view/View;", "getMConfirmLayout", "()Landroid/view/View;", "setMConfirmLayout", "(Landroid/view/View;)V", "mSearchAddressRv", "Lcom/didi/soda/address/component/feed/view/AddressRecyclerView;", "getMSearchAddressRv", "()Lcom/didi/soda/address/component/feed/view/AddressRecyclerView;", "setMSearchAddressRv", "(Lcom/didi/soda/address/component/feed/view/AddressRecyclerView;)V", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "hideLoadError", "", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initData", "initItemBinders", "onCreate", "post", "runnable", "Ljava/lang/Runnable;", "setConfirmEnable", "isEnable", "", "setupNovaRecyclerView", "sodaRecyclerView", "showLoadError", "errorMsg", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressView.kt */
public final class SelectedAddressView extends Contract.AbsSelectedAddressView implements IRFFloatingExpand {
    public TopGunAbnormalView mAddressAbnormalView;
    public RFMainButton mConfirmBtn;
    public View mConfirmLayout;
    public AddressRecyclerView mSearchAddressRv;

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

    public final AddressRecyclerView getMSearchAddressRv() {
        AddressRecyclerView addressRecyclerView = this.mSearchAddressRv;
        if (addressRecyclerView != null) {
            return addressRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSearchAddressRv");
        return null;
    }

    public final void setMSearchAddressRv(AddressRecyclerView addressRecyclerView) {
        Intrinsics.checkNotNullParameter(addressRecyclerView, "<set-?>");
        this.mSearchAddressRv = addressRecyclerView;
    }

    public final RFMainButton getMConfirmBtn() {
        RFMainButton rFMainButton = this.mConfirmBtn;
        if (rFMainButton != null) {
            return rFMainButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBtn");
        return null;
    }

    public final void setMConfirmBtn(RFMainButton rFMainButton) {
        Intrinsics.checkNotNullParameter(rFMainButton, "<set-?>");
        this.mConfirmBtn = rFMainButton;
    }

    public final TopGunAbnormalView getMAddressAbnormalView() {
        TopGunAbnormalView topGunAbnormalView = this.mAddressAbnormalView;
        if (topGunAbnormalView != null) {
            return topGunAbnormalView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAddressAbnormalView");
        return null;
    }

    public final void setMAddressAbnormalView(TopGunAbnormalView topGunAbnormalView) {
        Intrinsics.checkNotNullParameter(topGunAbnormalView, "<set-?>");
        this.mAddressAbnormalView = topGunAbnormalView;
    }

    public final View getMConfirmLayout() {
        View view = this.mConfirmLayout;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmLayout");
        return null;
    }

    public final void setMConfirmLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mConfirmLayout = view;
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return getMSearchAddressRv();
    }

    public void onCreate() {
        super.onCreate();
        m27417a();
    }

    public void showLoadError(String str) {
        getMAddressAbnormalView().setVisibility(0);
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            getMAddressAbnormalView().show(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    SelectedAddressView.m27418a(SelectedAddressView.this, view);
                }
            }));
            return;
        }
        getMAddressAbnormalView().show(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
            public final void onClick(View view) {
                SelectedAddressView.m27419b(SelectedAddressView.this, view);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27418a(SelectedAddressView selectedAddressView, View view) {
        Intrinsics.checkNotNullParameter(selectedAddressView, "this$0");
        ((Contract.AbsSelectedAddressPresenter) selectedAddressView.getPresenter()).onRefreshList();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27419b(SelectedAddressView selectedAddressView, View view) {
        Intrinsics.checkNotNullParameter(selectedAddressView, "this$0");
        ((Contract.AbsSelectedAddressPresenter) selectedAddressView.getPresenter()).onRefreshList();
    }

    public void hideLoadError() {
        getMAddressAbnormalView().setVisibility(8);
    }

    public void post(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getMConfirmLayout().post(runnable);
    }

    public void setConfirmEnable(boolean z) {
        getMConfirmBtn().setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_address_list, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_custom_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.customer_custom_confirm)");
        setMConfirmBtn((RFMainButton) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_confirm_click_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.cus…mer_confirm_click_layout)");
        setMConfirmLayout(findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_rv_address_selection_list);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.cus…v_address_selection_list)");
        setMSearchAddressRv((AddressRecyclerView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.layout_search_abnormal);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.layout_search_abnormal)");
        setMAddressAbnormalView((TopGunAbnormalView) findViewById4);
        getMConfirmLayout().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectedAddressView.m27420c(SelectedAddressView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…)\n            }\n        }");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m27420c(SelectedAddressView selectedAddressView, View view) {
        Intrinsics.checkNotNullParameter(selectedAddressView, "this$0");
        ((Contract.AbsSelectedAddressPresenter) selectedAddressView.getPresenter()).onConfirmClick();
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new SelectedAddressDescBinder());
        registerBinder(new SelectedAddressView$initItemBinders$1(this));
        registerBinder(new SelectedAddressView$initItemBinders$2(this));
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        getMSearchAddressRv().setItemDecorationEnable(true);
        getMSearchAddressRv().setItemTouchControlEnable(true);
        getMSearchAddressRv().setOneOpenToggle(true);
    }

    /* renamed from: a */
    private final void m27417a() {
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    SelectedAddressView.m27421d(SelectedAddressView.this, view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_payment_Change_address_LlEB)).build());
            navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m27421d(SelectedAddressView selectedAddressView, View view) {
        Intrinsics.checkNotNullParameter(selectedAddressView, "this$0");
        ((Contract.AbsSelectedAddressPresenter) selectedAddressView.getPresenter()).finish();
    }
}
