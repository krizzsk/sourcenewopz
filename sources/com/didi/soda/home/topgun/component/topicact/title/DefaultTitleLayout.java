package com.didi.soda.home.topgun.component.topicact.title;

import android.animation.ArgbEvaluator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.widget.scroll.CustomerNavScrollListener;
import com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0002J\b\u00100\u001a\u00020\u0002H\u0016J\n\u00101\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u00020'H\u0016J\u0010\u00106\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0016J\u001c\u00109\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020'H\u0016J\b\u0010A\u001a\u00020'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000b¨\u0006B"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/title/DefaultTitleLayout;", "Lcom/didi/soda/home/topgun/component/topicact/title/ITitleLayout;", "Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener$Callback;", "()V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "backIconView", "Landroid/widget/TextView;", "getBackIconView", "()Landroid/widget/TextView;", "setBackIconView", "(Landroid/widget/TextView;)V", "endColor", "", "lineView", "Landroid/view/View;", "getLineView", "()Landroid/view/View;", "setLineView", "(Landroid/view/View;)V", "navBarView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getNavBarView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setNavBarView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "rulesView", "getRulesView", "setRulesView", "startColor", "statusBarView", "getStatusBarView", "setStatusBarView", "titleLayoutRoot", "Landroid/widget/RelativeLayout;", "titleView", "getTitleView", "setTitleView", "attachTo", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "parent", "Landroid/view/ViewGroup;", "getBgColorByFraction", "fraction", "", "getIconColor", "getScrollCallback", "getTitleLayout", "onProgressChanged", "scrolledView", "progress", "scrollToTop", "setOnBackClickListener", "listener", "Landroid/view/View$OnClickListener;", "setRules", "rule", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "activityId", "", "setTitle", "title", "showNavBarWhenError", "showNavBarWhenNormal", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ITitleLayout.kt */
public final class DefaultTitleLayout implements CustomerNavScrollListener.Callback, ITitleLayout {

    /* renamed from: a */
    private RelativeLayout f42968a;

    /* renamed from: b */
    private final ArgbEvaluator f42969b = new ArgbEvaluator();
    public TextView backIconView;

    /* renamed from: c */
    private int f42970c = CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0);

    /* renamed from: d */
    private int f42971d = CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF);
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

    public final TextView getBackIconView() {
        TextView textView = this.backIconView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backIconView");
        return null;
    }

    public final void setBackIconView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.backIconView = textView;
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

    public void attachTo(ScopeContext scopeContext, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.customer_component_topic_activity_title_d, viewGroup);
        this.f42968a = (RelativeLayout) inflate.findViewById(R.id.customer_rl_title_bar_root);
        View findViewById = inflate.findViewById(R.id.customer_rl_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_rl_title_bar)");
        setNavBarView((ConstraintLayout) findViewById);
        View findViewById2 = inflate.findViewById(R.id.customer_iv_topic_home_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.c…omer_iv_topic_home_close)");
        setBackIconView((TextView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.customer_tv_topic_title_rules);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…mer_tv_topic_title_rules)");
        setRulesView((TextView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.customer_status_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.customer_status_bar)");
        setStatusBarView(findViewById4);
        View findViewById5 = inflate.findViewById(R.id.customer_view_home_topic_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.c…r_view_home_topic_shadow)");
        setLineView(findViewById5);
        View findViewById6 = inflate.findViewById(R.id.customer_tv_topic_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.c…tomer_tv_topic_title_bar)");
        setTitleView((TextView) findViewById6);
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        getBackIconView().setOnClickListener(onClickListener);
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
        CharSequence charSequence = ruleLink.title;
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
                DefaultTitleLayout.m30421a(ActivityInfoEntity.RuleLink.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30421a(ActivityInfoEntity.RuleLink ruleLink, String str, View view) {
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

    public View getTitleLayout() {
        return this.f42968a;
    }

    public CustomerNavScrollListener.Callback getScrollCallback() {
        return this;
    }

    public void onProgressChanged(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "scrolledView");
        if (this.navBarView != null) {
            int b = m30422b(f);
            getNavBarView().setBackgroundColor(b);
            getStatusBarView().setBackgroundColor(b);
            getLineView().setAlpha(f);
            getTitleView().setAlpha(f);
            getBackIconView().setTextColor(m30420a(f));
            getRulesView().setTextColor(m30420a(f));
        }
    }

    public void showNavBarWhenError() {
        if (this.navBarView != null) {
            getBackIconView().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_gery_1_0_000000));
            getRulesView().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_gery_1_0_000000));
            getNavBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getStatusBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getLineView().setAlpha(1.0f);
            getTitleView().setAlpha(1.0f);
        }
    }

    public void showNavBarWhenNormal() {
        if (this.navBarView != null) {
            getBackIconView().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getRulesView().setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF));
            getNavBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0));
            getStatusBarView().setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_white_100_alpha_0));
            getLineView().setAlpha(0.0f);
            getTitleView().setAlpha(0.0f);
        }
    }

    /* renamed from: a */
    private final int m30420a(float f) {
        Object evaluate = this.f42969b.evaluate(f, Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_white_100_FFFFFF)), Integer.valueOf(CustomerExtentionKt.getColor(R.color.rf_color_gery_1_0_000000)));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: b */
    private final int m30422b(float f) {
        Object evaluate = this.f42969b.evaluate(f, Integer.valueOf(this.f42970c), Integer.valueOf(this.f42971d));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public void scrollToTop() {
        if (this.titleView != null) {
            getTitleView().setAlpha(0.0f);
            getLineView().setAlpha(0.0f);
        }
    }
}
