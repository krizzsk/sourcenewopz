package com.didi.soda.globalcart.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.component.feed.decorator.CustomerSimpleDecorator;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.globalcart.component.Contract;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0014J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0018J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020%H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/globalcart/component/GlobalCartView;", "Lcom/didi/soda/globalcart/component/Contract$AbsGlobalCartView;", "()V", "backBtn", "Lcom/didi/soda/customer/widget/text/IconTextView;", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "getRecyclerView", "()Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "setRecyclerView", "(Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;)V", "titleTv", "Landroid/widget/TextView;", "calculateAbnormalHeight", "", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getItemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "context", "Landroid/content/Context;", "hideLoadingView", "", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "initView", "root", "onCreate", "scrollToTop", "showLoadingView", "showNetErrorToast", "useLinearLayout", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartView.kt */
public class GlobalCartView extends Contract.AbsGlobalCartView {

    /* renamed from: a */
    private IconTextView f42288a;

    /* renamed from: b */
    private TextView f42289b;
    public NovaRecyclerView recyclerView;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    public final NovaRecyclerView getRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.recyclerView;
        if (novaRecyclerView != null) {
            return novaRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void setRecyclerView(NovaRecyclerView novaRecyclerView) {
        Intrinsics.checkNotNullParameter(novaRecyclerView, "<set-?>");
        this.recyclerView = novaRecyclerView;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_global_cart, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        initView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…   initView(it)\n        }");
        return inflate;
    }

    public final void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.customer_iv_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_iv_page_back)");
        this.f42288a = (IconTextView) findViewById;
        View findViewById2 = view.findViewById(R.id.customer_tv_title_label);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.customer_tv_title_label)");
        this.f42289b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.customer_global_cart_feed_rv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…omer_global_cart_feed_rv)");
        setRecyclerView((NovaRecyclerView) findViewById3);
    }

    public void onCreate() {
        super.onCreate();
        TextView textView = this.f42289b;
        IconTextView iconTextView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        textView.setText(getText(R.string.customer_title_global_cart));
        IconTextView iconTextView2 = this.f42288a;
        if (iconTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        } else {
            iconTextView = iconTextView2;
        }
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCartView.m29801a(GlobalCartView.this, view);
            }
        });
        getRecyclerView().setItemDecorationEnable(true);
        getRecyclerView().setNestedScrollingEnabled(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29801a(GlobalCartView globalCartView, View view) {
        Intrinsics.checkNotNullParameter(globalCartView, "this$0");
        ((Contract.AbsGlobalCartPresenter) globalCartView.getPresenter()).onClickBack();
    }

    public void hideLoadingView() {
        DialogUtil.hideLoadingDialog();
    }

    public void showLoadingView() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void showNetErrorToast() {
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.customer_net_error_tip));
    }

    public void scrollToTop() {
        getRecyclerView().scrollToPosition(0);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return getRecyclerView();
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        ScopeContext scopeContext = getScopeContext();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        registerBinder(new GlobalCartView$initItemBinders$1(this, scopeContext, m29800a(context)));
        registerBinder(new TopGunAbnormalViewBinder());
    }

    /* renamed from: a */
    private final ItemDecorator m29800a(Context context) {
        CustomerSimpleDecorator customerSimpleDecorator = new CustomerSimpleDecorator(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7), DisplayUtils.dip2px(context, 10.0f));
        customerSimpleDecorator.enablePositionTopDecorator();
        return customerSimpleDecorator;
    }

    public int calculateAbnormalHeight() {
        return (CustomerSystemUtil.getScreenHeight(getContext()) - CustomerSystemUtil.getStatusBarHeight(getContext())) - DisplayUtils.dip2px(getContext(), 120.0f);
    }
}
