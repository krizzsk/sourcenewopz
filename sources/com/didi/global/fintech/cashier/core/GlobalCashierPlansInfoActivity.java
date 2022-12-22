package com.didi.global.fintech.cashier.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.fintech.cashier.core.adapter.PlansAdapter;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierView;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p117ui.omega.PubPageType;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0016J!\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0012\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierPlansInfoActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierView;", "()V", "cardIndex", "", "confirmBtn", "Landroid/widget/Button;", "extraLayout", "Landroid/widget/LinearLayout;", "faqBtn", "Landroid/widget/ImageView;", "number", "", "Ljava/lang/Integer;", "rcv", "Landroidx/recyclerview/widget/RecyclerView;", "taxTV", "Landroid/widget/TextView;", "totalTV", "getPresenter", "getView", "initData", "", "initView", "layoutRes", "omegaBtnCk", "type", "num", "(ILjava/lang/Integer;)V", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPlansInfoActivity.kt */
public final class GlobalCashierPlansInfoActivity extends BaseCashierActivity<IGlobalBizCashierPresenter, IGlobalCashierView> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_CARD_INDEX = "card_index";
    public static final String PARAM_INSTALLMENT_NUMBER = "installment_number";
    public static final String PARAM_INSTALLMENT_PLANS = "installment_plans";

    /* renamed from: a */
    private TextView f21412a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f21413b;

    /* renamed from: c */
    private Button f21414c;

    /* renamed from: d */
    private ImageView f21415d;

    /* renamed from: e */
    private RecyclerView f21416e;

    /* renamed from: f */
    private LinearLayout f21417f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Integer f21418g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f21419h;

    public IGlobalCashierView getView() {
        return null;
    }

    public int layoutRes() {
        return R.layout.activity_global_cashier_plans_info;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierPlansInfoActivity$Companion;", "", "()V", "PARAM_CARD_INDEX", "", "PARAM_INSTALLMENT_NUMBER", "PARAM_INSTALLMENT_PLANS", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierPlansInfoActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m15720a();
        m15723b();
        CashierOmegaUtils.Companion.setPubPage(PubPageType.INSTALLMENT.getType());
        IGlobalBizCashierPresenter iGlobalBizCashierPresenter = (IGlobalBizCashierPresenter) getMPresenter();
        if (iGlobalBizCashierPresenter != null) {
            iGlobalBizCashierPresenter.omegaPlanSw();
        }
    }

    /* renamed from: a */
    private final void m15720a() {
        View findViewById = findViewById(R.id.tv_total_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_total_amount)");
        this.f21412a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tv_tax_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_tax_amount)");
        this.f21413b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.btn_confirm)");
        this.f21414c = (Button) findViewById3;
        View findViewById4 = findViewById(R.id.faq_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.faq_btn)");
        this.f21415d = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.plans_rcv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.plans_rcv)");
        this.f21416e = (RecyclerView) findViewById5;
        View findViewById6 = findViewById(R.id.extra_content_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.extra_content_layout)");
        this.f21417f = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.back_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<ImageView>(R.id.back_btn)");
        ViewKtxKt.click$default(findViewById7, 0, new GlobalCashierPlansInfoActivity$initView$1(this), 1, (Object) null);
        Button button = this.f21414c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            button = null;
        }
        ViewKtxKt.click$default(button, 0, new GlobalCashierPlansInfoActivity$initView$2(this), 1, (Object) null);
    }

    /* renamed from: b */
    private final void m15723b() {
        this.f21419h = getIntent().getStringExtra("card_index");
        InstallmentVo installmentVo = (InstallmentVo) getIntent().getSerializableExtra(PARAM_INSTALLMENT_PLANS);
        if (installmentVo != null) {
            TextView textView = this.f21412a;
            RecyclerView recyclerView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("totalTV");
                textView = null;
            }
            textView.setText(installmentVo.getInstallmentAmount());
            String faqUrl = installmentVo.getFaqUrl();
            CharSequence charSequence = faqUrl;
            if (!(!(charSequence == null || charSequence.length() == 0))) {
                faqUrl = null;
            }
            if (faqUrl != null) {
                ImageView imageView = this.f21415d;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("faqBtn");
                    imageView = null;
                }
                ViewKtxKt.click$default(imageView, 0, new GlobalCashierPlansInfoActivity$initData$1$2$1(this, faqUrl), 1, (Object) null);
            }
            List<InstallmentVo.PlansVo> plans = installmentVo.getPlans();
            if (plans != null) {
                for (InstallmentVo.PlansVo plansVo : plans) {
                    if (plansVo.isSelected()) {
                        this.f21418g = plansVo.getNumber();
                        TextView textView2 = this.f21413b;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("taxTV");
                            textView2 = null;
                        }
                        textView2.setText(plansVo.getAccessoryAmount());
                    }
                }
            }
            List<InstallmentVo.AdditionalInfo> additionalInfo = installmentVo.getAdditionalInfo();
            if (additionalInfo != null) {
                for (InstallmentVo.AdditionalInfo message : additionalInfo) {
                    View inflate = LayoutInflater.from(this).inflate(R.layout.view_installment_additional_info, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.desc_tv)).setText(message.getMessage());
                    LinearLayout linearLayout = this.f21417f;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("extraLayout");
                        linearLayout = null;
                    }
                    linearLayout.addView(inflate);
                }
            }
            PlansAdapter plansAdapter = new PlansAdapter();
            plansAdapter.setOnItemClick(new GlobalCashierPlansInfoActivity$initData$1$5(this, plansAdapter));
            List<InstallmentVo.PlansVo> plans2 = installmentVo.getPlans();
            plansAdapter.updateData(plans2 == null ? null : CollectionsKt.toMutableList(plans2));
            RecyclerView recyclerView2 = this.f21416e;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rcv");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setAdapter(plansAdapter);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m15722a(GlobalCashierPlansInfoActivity globalCashierPlansInfoActivity, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        globalCashierPlansInfoActivity.m15721a(i, num);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15721a(int i, Integer num) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("button_name", Integer.valueOf(i));
        if (num != null) {
            linkedHashMap.put("choose_plan", num);
        }
        IGlobalBizCashierPresenter iGlobalBizCashierPresenter = (IGlobalBizCashierPresenter) getMPresenter();
        if (iGlobalBizCashierPresenter != null) {
            iGlobalBizCashierPresenter.omegaPlanCk(linkedHashMap);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        m15722a(this, 1, (Integer) null, 2, (Object) null);
        CashierOmegaUtils.Companion.setPubPage((String) null);
    }

    public IGlobalBizCashierPresenter getPresenter() {
        return new GlobalCashierBizPresenter(this, getMUniqueId(), (String) null, (IGlobalCashierActionInterceptCallback) null, 12, (DefaultConstructorMarker) null);
    }
}
