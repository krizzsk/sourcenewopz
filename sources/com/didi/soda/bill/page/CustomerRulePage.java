package com.didi.soda.bill.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.bill.component.rule.RuleTraceStrategy;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.MaxHeightScrollView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/bill/page/CustomerRulePage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "confirm", "Lcom/didi/rfusion/widget/button/RFMainButton;", "content", "Lcom/didi/soda/customer/widget/text/RichTextView;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "mContentView", "Landroid/view/View;", "scrollView", "Lcom/didi/soda/customer/widget/MaxHeightScrollView;", "shadowView", "strategy", "Lcom/didi/soda/bill/component/rule/RuleTraceStrategy;", "initContentView", "", "initData", "onCreate", "view", "onDestroy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerRulePage.kt */
public class CustomerRulePage extends FloatingCustomerPage {

    /* renamed from: a */
    private View f39151a;

    /* renamed from: b */
    private RFMainButton f39152b;

    /* renamed from: c */
    private RichTextView f39153c;

    /* renamed from: d */
    private MaxHeightScrollView f39154d;

    /* renamed from: e */
    private View f39155e;

    /* renamed from: f */
    private RuleDescEntity f39156f;

    /* renamed from: g */
    private RuleTraceStrategy f39157g;

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f39151a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        setContentView(view2);
        setType(1);
        m27745b();
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_fee_explain, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f39151a = inflate;
        MaxHeightScrollView maxHeightScrollView = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_tv_common_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…stomer_tv_common_confirm)");
        this.f39152b = (RFMainButton) findViewById;
        View view = this.f39151a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.customer_ll_common_dialog_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI…ll_common_dialog_content)");
        this.f39153c = (RichTextView) findViewById2;
        View view2 = this.f39151a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.customer_sv_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewByI…id.customer_sv_container)");
        this.f39154d = (MaxHeightScrollView) findViewById3;
        View view3 = this.f39151a;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.customer_dialog_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewByI…d.customer_dialog_shadow)");
        this.f39155e = findViewById4;
        RichTextView richTextView = this.f39153c;
        if (richTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("content");
            richTextView = null;
        }
        richTextView.setMinHeight(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_560));
        RFMainButton rFMainButton = this.f39152b;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
            rFMainButton = null;
        }
        rFMainButton.setContentBackground(RFResUtils.getDrawable(getBaseContext(), R.drawable.customer_purchase_cart_add_fillet));
        RFMainButton rFMainButton2 = this.f39152b;
        if (rFMainButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
            rFMainButton2 = null;
        }
        rFMainButton2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerRulePage.m27744a(CustomerRulePage.this, view);
            }
        });
        MaxHeightScrollView maxHeightScrollView2 = this.f39154d;
        if (maxHeightScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            maxHeightScrollView = maxHeightScrollView2;
        }
        maxHeightScrollView.setOnScrollChangeListener(new MaxHeightScrollView.OnScrollChangeListener() {
            public final void onScrollChanged(int i, int i2, int i3, int i4) {
                CustomerRulePage.m27743a(CustomerRulePage.this, i, i2, i3, i4);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27744a(CustomerRulePage customerRulePage, View view) {
        Intrinsics.checkNotNullParameter(customerRulePage, "this$0");
        RuleTraceStrategy ruleTraceStrategy = customerRulePage.f39157g;
        if (ruleTraceStrategy != null) {
            RuleTraceStrategy.traceBtnClick$default(ruleTraceStrategy, 0, 1, (Object) null);
        }
        customerRulePage.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27743a(CustomerRulePage customerRulePage, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(customerRulePage, "this$0");
        View view = null;
        if (i2 > 0) {
            View view2 = customerRulePage.f39155e;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shadowView");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = customerRulePage.f39155e;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadowView");
        } else {
            view = view3;
        }
        view.setVisibility(4);
    }

    public void onDestroy() {
        super.onDestroy();
        RuleTraceStrategy ruleTraceStrategy = this.f39157g;
        if (ruleTraceStrategy != null) {
            ruleTraceStrategy.traceClosed();
        }
    }

    /* renamed from: b */
    private final void m27745b() {
        Serializable serializable;
        ScopeContext scopeContext = getScopeContext();
        RFMainButton rFMainButton = null;
        Bundle bundle = scopeContext == null ? null : scopeContext.getBundle();
        RuleTraceStrategy.Companion companion = RuleTraceStrategy.Companion;
        ScopeContext scopeContext2 = getScopeContext();
        String alias = alias();
        Intrinsics.checkNotNullExpressionValue(alias, "alias()");
        RuleTraceStrategy strategyByType = companion.getStrategyByType(scopeContext2, alias);
        this.f39157g = strategyByType;
        if (strategyByType != null) {
            strategyByType.traceCreate();
        }
        if (bundle == null) {
            serializable = null;
        } else {
            serializable = bundle.getSerializable("entity");
        }
        RuleDescEntity ruleDescEntity = (RuleDescEntity) serializable;
        this.f39156f = ruleDescEntity;
        if (ruleDescEntity != null) {
            if (ruleDescEntity.content != null) {
                RichTextView richTextView = this.f39153c;
                if (richTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("content");
                    richTextView = null;
                }
                richTextView.setText(ruleDescEntity.content);
            }
            if (ruleDescEntity.btnDesc != null) {
                RFMainButton rFMainButton2 = this.f39152b;
                if (rFMainButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
                } else {
                    rFMainButton = rFMainButton2;
                }
                rFMainButton.setText(ruleDescEntity.btnDesc);
            } else {
                RFMainButton rFMainButton3 = this.f39152b;
                if (rFMainButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
                } else {
                    rFMainButton = rFMainButton3;
                }
                rFMainButton.setVisibility(8);
            }
            if (ruleDescEntity.title != null && getNavBar() != null) {
                getNavBar().setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CustomerRulePage.m27746b(CustomerRulePage.this, view);
                    }
                }).build());
                getNavBar().setTitle(new RFFloatingTextAttr.Builder(ruleDescEntity.title).build());
                getNavBar().setBackground(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m27746b(CustomerRulePage customerRulePage, View view) {
        Intrinsics.checkNotNullParameter(customerRulePage, "this$0");
        RuleTraceStrategy ruleTraceStrategy = customerRulePage.f39157g;
        if (ruleTraceStrategy != null) {
            ruleTraceStrategy.traceBackClick();
        }
        customerRulePage.dismiss();
    }
}
