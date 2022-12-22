package com.didi.entrega.bill.component.bill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.bill.binder.CustomerBillBinder;
import com.didi.entrega.bill.component.bill.Contract;
import com.didi.entrega.bill.model.PriceModel;
import com.didi.entrega.bill.view.pay.BillPayCardLayout;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.StatusBarView;
import com.didi.entrega.customer.widget.abnormal.AbnormalView;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModel;
import com.didi.entrega.customer.widget.dialog.SodaWindowFactory;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00105\u001a\u000206H\u0014J\b\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020>H\u0016J\u0018\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020>H\u0014J\b\u0010F\u001a\u00020>H\u0016J\b\u0010G\u001a\u00020>H\u0002J\u0010\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u000206H\u0016J\u0010\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020>2\u0006\u0010Q\u001a\u00020RH\u0016J\u0012\u0010S\u001a\u00020>2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006V"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/bill/BillView;", "Lcom/didi/entrega/bill/component/bill/Contract$AbsBillView;", "()V", "abnormalLayout", "Landroid/widget/RelativeLayout;", "getAbnormalLayout", "()Landroid/widget/RelativeLayout;", "setAbnormalLayout", "(Landroid/widget/RelativeLayout;)V", "abnormalView", "Lcom/didi/entrega/customer/widget/abnormal/AbnormalView;", "getAbnormalView", "()Lcom/didi/entrega/customer/widget/abnormal/AbnormalView;", "setAbnormalView", "(Lcom/didi/entrega/customer/widget/abnormal/AbnormalView;)V", "backIconView", "Lcom/didi/rfusion/widget/RFIconView;", "getBackIconView", "()Lcom/didi/rfusion/widget/RFIconView;", "setBackIconView", "(Lcom/didi/rfusion/widget/RFIconView;)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "setBackgroundView", "(Landroid/view/View;)V", "maskView", "getMaskView", "setMaskView", "navBarView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getNavBarView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setNavBarView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "priceLayout", "Lcom/didi/entrega/bill/view/pay/BillPayCardLayout;", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "recyclerViewParent", "statusBarView", "Lcom/didi/entrega/customer/widget/StatusBarView;", "getStatusBarView", "()Lcom/didi/entrega/customer/widget/StatusBarView;", "setStatusBarView", "(Lcom/didi/entrega/customer/widget/StatusBarView;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getAdapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "getItemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "context", "Landroid/content/Context;", "hideAbnormalView", "", "hindLoadingView", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "onCreate", "setupBackgroundView", "setupNovaRecyclerView", "novaRecyclerView", "showAbnormalView", "model", "Lcom/didi/entrega/customer/widget/abnormal/AbnormalViewModel;", "showLoadingView", "showMask", "", "showPriceLayout", "priceModel", "Lcom/didi/entrega/bill/model/PriceModel;", "updatePriceText", "payBtnText", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillView.kt */
public final class BillView extends Contract.AbsBillView {

    /* renamed from: a */
    private NovaRecyclerView f19470a;
    public RelativeLayout abnormalLayout;
    public AbnormalView abnormalView;

    /* renamed from: b */
    private RelativeLayout f19471b;
    public RFIconView backIconView;
    public View backgroundView;

    /* renamed from: c */
    private BillPayCardLayout f19472c;
    public View maskView;
    public ConstraintLayout navBarView;
    public StatusBarView statusBarView;
    public TextView titleView;

    public final ConstraintLayout getNavBarView() {
        ConstraintLayout constraintLayout = this.navBarView;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navBarView");
        return null;
    }

    public final void setNavBarView(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.navBarView = constraintLayout;
    }

    public final StatusBarView getStatusBarView() {
        StatusBarView statusBarView2 = this.statusBarView;
        if (statusBarView2 != null) {
            return statusBarView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusBarView");
        return null;
    }

    public final void setStatusBarView(StatusBarView statusBarView2) {
        Intrinsics.checkNotNullParameter(statusBarView2, "<set-?>");
        this.statusBarView = statusBarView2;
    }

    public final TextView getTitleView() {
        TextView textView = this.titleView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    public final void setTitleView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleView = textView;
    }

    public final RFIconView getBackIconView() {
        RFIconView rFIconView = this.backIconView;
        if (rFIconView != null) {
            return rFIconView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backIconView");
        return null;
    }

    public final void setBackIconView(RFIconView rFIconView) {
        Intrinsics.checkNotNullParameter(rFIconView, "<set-?>");
        this.backIconView = rFIconView;
    }

    public final View getMaskView() {
        View view = this.maskView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("maskView");
        return null;
    }

    public final void setMaskView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.maskView = view;
    }

    public final AbnormalView getAbnormalView() {
        AbnormalView abnormalView2 = this.abnormalView;
        if (abnormalView2 != null) {
            return abnormalView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
        return null;
    }

    public final void setAbnormalView(AbnormalView abnormalView2) {
        Intrinsics.checkNotNullParameter(abnormalView2, "<set-?>");
        this.abnormalView = abnormalView2;
    }

    public final RelativeLayout getAbnormalLayout() {
        RelativeLayout relativeLayout = this.abnormalLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("abnormalLayout");
        return null;
    }

    public final void setAbnormalLayout(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.abnormalLayout = relativeLayout;
    }

    public final View getBackgroundView() {
        View view = this.backgroundView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
        return null;
    }

    public final void setBackgroundView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.backgroundView = view;
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f19470a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        Intrinsics.checkNotNullParameter(iNovaRecyclerView, "novaRecyclerView");
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
    }

    /* renamed from: a */
    private final void m14587a() {
        ViewGroup.LayoutParams layoutParams = getBackgroundView().getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = DisplayUtils.dip2px(getContext(), 290.0f);
            getBackgroundView().setLayoutParams(marginLayoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public void onCreate() {
        super.onCreate();
        BillViewExKt.setUpNavBar(this);
        m14587a();
        getBackIconView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BillView.m14588a(BillView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14588a(BillView billView, View view) {
        Intrinsics.checkNotNullParameter(billView, "this$0");
        if (!((Contract.AbsBillPresenter) billView.getPresenter()).handleBack()) {
            billView.getScopeContext().getNavigator().finish();
        }
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        registerBinder(new CustomerBillBinder(scopeContext, m14586a(context)));
    }

    public void showPriceLayout(PriceModel priceModel) {
        Intrinsics.checkNotNullParameter(priceModel, "priceModel");
        BillPayCardLayout billPayCardLayout = this.f19472c;
        if (billPayCardLayout != null) {
            billPayCardLayout.setDataModel(priceModel);
        }
    }

    public void showAbnormalView(AbnormalViewModel abnormalViewModel) {
        Intrinsics.checkNotNullParameter(abnormalViewModel, "model");
        getAbnormalLayout().setVisibility(0);
        getAbnormalView().show(abnormalViewModel);
    }

    public void hideAbnormalView() {
        getAbnormalLayout().setVisibility(8);
    }

    public void showLoadingView(boolean z) {
        if (z) {
            getMaskView().setVisibility(0);
        }
        DialogUtil.showLoadingDialog(getScopeContext(), true, true, (SodaWindowFactory.DialogKeyBackListener) null);
    }

    public void hindLoadingView() {
        DialogUtil.hideLoadingDialog();
        getMaskView().setVisibility(8);
    }

    public NovaRecyclerAdapter getAdapter() {
        NovaRecyclerView novaRecyclerView = this.f19470a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            novaRecyclerView = null;
        }
        RecyclerView.Adapter adapter = novaRecyclerView.getAdapter();
        if (adapter != null) {
            return (NovaRecyclerAdapter) adapter;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter");
    }

    public void updatePriceText(String str) {
        BillPayCardLayout billPayCardLayout;
        if (str != null && (billPayCardLayout = this.f19472c) != null) {
            billPayCardLayout.updatePriceText(str);
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_bill_view, viewGroup);
        View findViewById = inflate.findViewById(R.id.entrega_custom_bill_rv_view_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.entreg…stom_bill_rv_view_parent)");
        this.f19471b = (RelativeLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_custom_bill_rv_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.entrega_custom_bill_rv_view)");
        this.f19470a = (NovaRecyclerView) findViewById2;
        this.f19472c = (BillPayCardLayout) inflate.findViewById(R.id.entrega_customer_payment_layout);
        View findViewById3 = inflate.findViewById(R.id.customer_bill_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_bill_title_bar)");
        setNavBarView((ConstraintLayout) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.entrega_custom_status_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.entrega_custom_status_bar)");
        setStatusBarView((StatusBarView) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.entrega_tv_title_label);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.entrega_tv_title_label)");
        setTitleView((TextView) findViewById5);
        getTitleView().setAlpha(0.0f);
        View findViewById6 = inflate.findViewById(R.id.entrega_iv_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.entrega_iv_page_back)");
        setBackIconView((RFIconView) findViewById6);
        View findViewById7 = inflate.findViewById(R.id.entrega_bill_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.entrega_bill_mask)");
        setMaskView(findViewById7);
        View findViewById8 = inflate.findViewById(R.id.entrega_bill_abnormal_view);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.entrega_bill_abnormal_view)");
        setAbnormalView((AbnormalView) findViewById8);
        View findViewById9 = inflate.findViewById(R.id.entrega_bill_abnormal_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.entrega_bill_abnormal_layout)");
        setAbnormalLayout((RelativeLayout) findViewById9);
        View findViewById10 = inflate.findViewById(R.id.entrega_bill_bg_view);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.entrega_bill_bg_view)");
        setBackgroundView(findViewById10);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…a_bill_bg_view)\n        }");
        return inflate;
    }

    /* renamed from: a */
    private final ItemDecorator m14586a(Context context) {
        return new C7997a(ResourceHelper.getColor(R.color.rf_color_white_100_alpha_0), DisplayUtils.dip2px(context, 10.0f));
    }
}
