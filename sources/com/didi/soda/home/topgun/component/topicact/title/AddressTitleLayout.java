package com.didi.soda.home.topgun.component.topicact.title;

import android.animation.ArgbEvaluator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.widget.scroll.CustomerNavScrollListener;
import com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper;
import com.didi.soda.home.topgun.widget.HeaderAddressLayout;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00109\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002J\b\u0010:\u001a\u00020\u0002H\u0016J\n\u0010;\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u000207H\u0016J\b\u0010?\u001a\u000200H\u0016J\u0010\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020BH\u0016J\u001c\u0010C\u001a\u0002002\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020GH\u0016J\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u000200H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/title/AddressTitleLayout;", "Lcom/didi/soda/home/topgun/component/topicact/title/ITitleLayout;", "Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener$Callback;", "()V", "addressLayout", "Lcom/didi/soda/home/topgun/widget/HeaderAddressLayout;", "getAddressLayout", "()Lcom/didi/soda/home/topgun/widget/HeaderAddressLayout;", "setAddressLayout", "(Lcom/didi/soda/home/topgun/widget/HeaderAddressLayout;)V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "backIconView", "Lcom/didi/rfusion/widget/RFIconView;", "getBackIconView", "()Lcom/didi/rfusion/widget/RFIconView;", "setBackIconView", "(Lcom/didi/rfusion/widget/RFIconView;)V", "lineView", "Landroid/view/View;", "getLineView", "()Landroid/view/View;", "setLineView", "(Landroid/view/View;)V", "navBarView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getNavBarView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setNavBarView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "rulesView", "Landroid/widget/TextView;", "getRulesView", "()Landroid/widget/TextView;", "setRulesView", "(Landroid/widget/TextView;)V", "statusBarView", "getStatusBarView", "setStatusBarView", "titleLayoutRoot", "Landroid/widget/RelativeLayout;", "titleView", "getTitleView", "setTitleView", "whiteAlpha0Color", "", "whiteColor", "attachTo", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "parent", "Landroid/view/ViewGroup;", "getAddrIconColor", "fraction", "", "getBgColorByFraction", "getColorWhiteToBlack", "getScrollCallback", "getTitleLayout", "onProgressChanged", "scrolledView", "progress", "scrollToTop", "setOnBackClickListener", "listener", "Landroid/view/View$OnClickListener;", "setRules", "rule", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "activityId", "", "setTitle", "title", "showNavBarWhenError", "showNavBarWhenNormal", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressTitleLayout.kt */
public final class AddressTitleLayout implements CustomerNavScrollListener.Callback, ITitleLayout {

    /* renamed from: a */
    private RelativeLayout f42964a;
    public HeaderAddressLayout addressLayout;

    /* renamed from: b */
    private final ArgbEvaluator f42965b = new ArgbEvaluator();
    public RFIconView backIconView;

    /* renamed from: c */
    private int f42966c = CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0);

    /* renamed from: d */
    private int f42967d = CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF);
    public View lineView;
    public ConstraintLayout navBarView;
    public TextView rulesView;
    public View statusBarView;
    public TextView titleView;

    public final View getStatusBarView() {
        View view = this.statusBarView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusBarView");
        return null;
    }

    public final void setStatusBarView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.statusBarView = view;
    }

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

    public final View getLineView() {
        View view = this.lineView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lineView");
        return null;
    }

    public final void setLineView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.lineView = view;
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

    public final TextView getRulesView() {
        TextView textView = this.rulesView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rulesView");
        return null;
    }

    public final void setRulesView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.rulesView = textView;
    }

    public final HeaderAddressLayout getAddressLayout() {
        HeaderAddressLayout headerAddressLayout = this.addressLayout;
        if (headerAddressLayout != null) {
            return headerAddressLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addressLayout");
        return null;
    }

    public final void setAddressLayout(HeaderAddressLayout headerAddressLayout) {
        Intrinsics.checkNotNullParameter(headerAddressLayout, "<set-?>");
        this.addressLayout = headerAddressLayout;
    }

    public void attachTo(ScopeContext scopeContext, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.customer_component_topic_activity_title_add, viewGroup);
        this.f42964a = (RelativeLayout) inflate.findViewById(R.id.customer_rl_title_bar_root);
        View findViewById = inflate.findViewById(R.id.customer_rl_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_rl_title_bar)");
        setNavBarView((ConstraintLayout) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_iv_topic_home_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.c…omer_iv_topic_home_close)");
        setBackIconView((RFIconView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_status_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.customer_status_bar)");
        setStatusBarView(findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_view_home_topic_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.c…r_view_home_topic_shadow)");
        setLineView(findViewById4);
        View findViewById5 = inflate.findViewById(R.id.customer_tv_topic_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.c…tomer_tv_topic_title_bar)");
        setTitleView((TextView) findViewById5);
        View findViewById6 = inflate.findViewById(R.id.customer_tv_topic_title_rules);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.c…mer_tv_topic_title_rules)");
        setRulesView((TextView) findViewById6);
        View findViewById7 = inflate.findViewById(R.id.customer_tv_topic_address_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.c…_tv_topic_address_layout)");
        setAddressLayout((HeaderAddressLayout) findViewById7);
        if (scopeContext != null) {
            getAddressLayout().setAddress(scopeContext, 1);
        }
        HeaderAddressLayout addressLayout2 = getAddressLayout();
        int i = this.f42967d;
        addressLayout2.setAddressColor(i, i);
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        if (this.backIconView != null) {
            getBackIconView().setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        if (this.titleView != null) {
            CharSequence charSequence = str;
            if (charSequence.length() == 0) {
                getTitleView().setVisibility(8);
                return;
            }
            getTitleView().setVisibility(0);
            getTitleView().setText(charSequence);
            return;
        }
        LogUtil.m29104i("ITitleLayout", ">>>> 还没有初始化title <<<<<");
    }

    public void setRules(ActivityInfoEntity.RuleLink ruleLink, String str) {
        if (ruleLink == null) {
            getRulesView().setVisibility(8);
            return;
        }
        CharSequence charSequence = ruleLink.content;
        if (charSequence == null || charSequence.length() == 0) {
            getRulesView().setVisibility(8);
            return;
        }
        getRulesView().setVisibility(0);
        getRulesView().setText(ruleLink.title);
        getRulesView().setOnClickListener(new View.OnClickListener(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AddressTitleLayout.m30417a(ActivityInfoEntity.RuleLink.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30417a(ActivityInfoEntity.RuleLink ruleLink, String str, View view) {
        CharSequence charSequence = ruleLink.details;
        if (!(charSequence == null || charSequence.length() == 0)) {
            RuleDescEntity ruleDescEntity = new RuleDescEntity();
            ruleDescEntity.content = ruleLink.details;
            ruleDescEntity.title = "";
            DiRouter.request().path("priceRuleDescPage").putParcelable("entity", ruleDescEntity).open();
        } else {
            SchemeHelper.dispatchMsg(ruleLink.url);
        }
        TopicActOmegaHelper.Companion.getInstance().trackRulesCK(str);
    }

    public void showNavBarWhenError() {
        if (this.navBarView != null) {
            int color = CustomerExtentionKt.getColor(R.color.rf_color_gery_1_0_000000);
            getAddressLayout().setAddressColor(color, CustomerExtentionKt.getColor(R.color.rf_color_v2_brands_1_100));
            getBackIconView().setTextColor(color);
            getRulesView().setTextColor(color);
            getNavBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getStatusBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getLineView().setAlpha(1.0f);
            getTitleView().setAlpha(1.0f);
        }
    }

    public void showNavBarWhenNormal() {
        if (this.navBarView != null) {
            HeaderAddressLayout addressLayout2 = getAddressLayout();
            int i = this.f42967d;
            addressLayout2.setAddressColor(i, i);
            getBackIconView().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getRulesView().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getNavBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0));
            getStatusBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0));
            getLineView().setAlpha(0.0f);
            getTitleView().setAlpha(0.0f);
        }
    }

    public View getTitleLayout() {
        return this.f42964a;
    }

    public CustomerNavScrollListener.Callback getScrollCallback() {
        return this;
    }

    public void onProgressChanged(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "scrolledView");
        if (this.navBarView != null) {
            int c = m30419c(f);
            getNavBarView().setBackgroundColor(c);
            getStatusBarView().setBackgroundColor(c);
            getLineView().setAlpha(f);
            getTitleView().setAlpha(f);
            int a = m30416a(f);
            getBackIconView().setTextColor(a);
            getRulesView().setTextColor(a);
            getAddressLayout().setAddressColor(a, m30418b(f));
        }
    }

    public void scrollToTop() {
        if (this.titleView != null) {
            getTitleView().setAlpha(0.0f);
            getLineView().setAlpha(0.0f);
        }
    }

    /* renamed from: a */
    private final int m30416a(float f) {
        Object evaluate = this.f42965b.evaluate(f, Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF)), Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_gery_1_0_000000)));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: b */
    private final int m30418b(float f) {
        Object evaluate = this.f42965b.evaluate(f, Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF)), Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_v2_brands_1_100)));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: c */
    private final int m30419c(float f) {
        Object evaluate = this.f42965b.evaluate(f, Integer.valueOf(this.f42966c), Integer.valueOf(this.f42967d));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
