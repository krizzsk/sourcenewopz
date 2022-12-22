package com.didi.entrega.bill.component.tip;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.entrega.bill.component.tip.Contract;
import com.didi.entrega.bill.model.BillTipModel;
import com.didi.entrega.bill.widgets.tip.EditTipItemView;
import com.didi.entrega.bill.widgets.tip.ITipItemView;
import com.didi.entrega.bill.widgets.tip.NormalTipItemView;
import com.didi.entrega.customer.foundation.util.AndroidBug5497Workaround;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.DisplayExtensionKt;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.foundation.util.locale.LocalizationUtils;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J \u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0019H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010,\u001a\u00020\u0019H\u0014J\b\u0010-\u001a\u00020\u0019H\u0014J\b\u0010.\u001a\u00020\u0019H\u0016J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/tip/BillTipView;", "Lcom/didi/entrega/bill/component/tip/Contract$AbsBillTipView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "billChoiceRowBottom", "Landroid/widget/LinearLayout;", "billChoiceRowTop", "billTipText", "Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "confirmBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "currency", "", "isManual", "", "orderPrice", "", "selectedFee", "", "singleItemWidth", "tipChoiceView", "Ljava/util/ArrayList;", "Lcom/didi/entrega/bill/widgets/tip/ITipItemView;", "Lkotlin/collections/ArrayList;", "addEditTipItem", "", "model", "Lcom/didi/entrega/bill/model/BillTipModel;", "root", "addNormalTipItem", "item", "calculateSingleItemWidth", "clearSelectedView", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initData", "isIntNumber", "str", "match", "regex", "onCreate", "onPause", "showExceedMaxMessage", "updateTipAmount", "tipFee", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTipView.kt */
public final class BillTipView extends Contract.AbsBillTipView implements IRFFloatingExpand {

    /* renamed from: a */
    private CustomerAppCompatTextView f19477a;

    /* renamed from: b */
    private RFMainButton f19478b;

    /* renamed from: c */
    private LinearLayout f19479c;

    /* renamed from: d */
    private LinearLayout f19480d;

    /* renamed from: e */
    private int f19481e;

    /* renamed from: f */
    private final ArrayList<ITipItemView> f19482f = new ArrayList<>();

    /* renamed from: g */
    private int f19483g;

    /* renamed from: h */
    private String f19484h;

    /* renamed from: i */
    private long f19485i;

    /* renamed from: j */
    private boolean f19486j;

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

    public void initData(BillTipModel billTipModel) {
        List<Long> subList;
        List<Long> subList2;
        Intrinsics.checkNotNullParameter(billTipModel, "model");
        updateTipAmount(billTipModel.getTipFeeValue(), false);
        List<Long> tipFeeConfig = billTipModel.getTipFeeConfig();
        int min = Math.min(tipFeeConfig == null ? 0 : tipFeeConfig.size(), 5);
        LinearLayout linearLayout = null;
        if (min <= 0) {
            LinearLayout linearLayout2 = this.f19479c;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowTop");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            LinearLayout linearLayout3 = this.f19480d;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowBottom");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(8);
            LinearLayout linearLayout4 = this.f19479c;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowTop");
            } else {
                linearLayout = linearLayout4;
            }
            m14596a(billTipModel, linearLayout);
        } else if (min < 3) {
            LinearLayout linearLayout5 = this.f19479c;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowTop");
                linearLayout5 = null;
            }
            linearLayout5.setVisibility(0);
            LinearLayout linearLayout6 = this.f19480d;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowBottom");
                linearLayout6 = null;
            }
            linearLayout6.setVisibility(8);
            List<Long> tipFeeConfig2 = billTipModel.getTipFeeConfig();
            if (tipFeeConfig2 != null) {
                for (Number longValue : tipFeeConfig2) {
                    long longValue2 = longValue.longValue();
                    LinearLayout linearLayout7 = this.f19479c;
                    if (linearLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowTop");
                        linearLayout7 = null;
                    }
                    m14592a(longValue2, billTipModel, linearLayout7);
                }
            }
            LinearLayout linearLayout8 = this.f19479c;
            if (linearLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowTop");
            } else {
                linearLayout = linearLayout8;
            }
            m14596a(billTipModel, linearLayout);
        } else {
            LinearLayout linearLayout9 = this.f19479c;
            if (linearLayout9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowTop");
                linearLayout9 = null;
            }
            linearLayout9.setVisibility(0);
            LinearLayout linearLayout10 = this.f19480d;
            if (linearLayout10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowBottom");
                linearLayout10 = null;
            }
            linearLayout10.setVisibility(0);
            List<Long> tipFeeConfig3 = billTipModel.getTipFeeConfig();
            if (!(tipFeeConfig3 == null || (subList2 = tipFeeConfig3.subList(0, 3)) == null)) {
                for (Number longValue3 : subList2) {
                    long longValue4 = longValue3.longValue();
                    LinearLayout linearLayout11 = this.f19479c;
                    if (linearLayout11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowTop");
                        linearLayout11 = null;
                    }
                    m14592a(longValue4, billTipModel, linearLayout11);
                }
            }
            List<Long> tipFeeConfig4 = billTipModel.getTipFeeConfig();
            if (!(tipFeeConfig4 == null || (subList = tipFeeConfig4.subList(3, min)) == null)) {
                for (Number longValue5 : subList) {
                    long longValue6 = longValue5.longValue();
                    LinearLayout linearLayout12 = this.f19480d;
                    if (linearLayout12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowBottom");
                        linearLayout12 = null;
                    }
                    m14592a(longValue6, billTipModel, linearLayout12);
                }
            }
            LinearLayout linearLayout13 = this.f19480d;
            if (linearLayout13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billChoiceRowBottom");
            } else {
                linearLayout = linearLayout13;
            }
            m14596a(billTipModel, linearLayout);
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_component_bill_tip, viewGroup);
        View findViewById = inflate.findViewById(R.id.entrega_custom_tip_fee_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.entrega_custom_tip_fee_text)");
        this.f19477a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_custom_confirm_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.ent…ga_custom_confirm_button)");
        this.f19478b = (RFMainButton) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.entrega_ll_tip_choice_row_top);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.ent…ga_ll_tip_choice_row_top)");
        this.f19479c = (LinearLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.entrega_ll_tip_choice_row_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.ent…ll_tip_choice_row_bottom)");
        this.f19480d = (LinearLayout) findViewById4;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ice_row_bottom)\n        }");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Object obj = getScopeContext().getBundle().get("price");
        if (obj != null) {
            this.f19483g = ((Integer) obj).intValue();
            this.f19484h = (String) getScopeContext().getBundle().get("currency");
            AndroidBug5497Workaround.getInstance((Activity) getContext()).assistComponent(getScopeContext(), getView());
            RFFloatingNavBar navBar = getNavBar(getScopeContext());
            if (navBar != null) {
                navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                    public final void onClick(View view) {
                        BillTipView.m14594a(BillTipView.this, view);
                    }
                }).build());
                navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_order_Tip_xMno)).build());
                navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
            }
            RFMainButton rFMainButton = this.f19478b;
            RFMainButton rFMainButton2 = null;
            if (rFMainButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
                rFMainButton = null;
            }
            rFMainButton.setText(getString(R.string.FoodC_up_Confirmation_hKaf));
            RFMainButton rFMainButton3 = this.f19478b;
            if (rFMainButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            } else {
                rFMainButton2 = rFMainButton3;
            }
            rFMainButton2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BillTipView.m14599b(BillTipView.this, view);
                }
            });
            this.f19481e = m14591a();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14594a(BillTipView billTipView, View view) {
        Intrinsics.checkNotNullParameter(billTipView, "this$0");
        IPresenter presenter = billTipView.getPresenter();
        Intrinsics.checkNotNullExpressionValue(presenter, "presenter");
        Contract.AbsBillTipPresenter.finish$default((Contract.AbsBillTipPresenter) presenter, (Bundle) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m14599b(BillTipView billTipView, View view) {
        Intrinsics.checkNotNullParameter(billTipView, "this$0");
        KeyboardUtils.hideSoftInput(billTipView.getContext(), billTipView.getView());
        ((Contract.AbsBillTipPresenter) billTipView.getPresenter()).confirmTip(billTipView.f19485i, billTipView.f19486j);
    }

    public void updateTipAmount(long j, boolean z) {
        String str;
        this.f19485i = j;
        this.f19486j = z;
        long calculatePrice = ((Contract.AbsBillTipPresenter) getPresenter()).calculatePrice(j);
        if (((int) (calculatePrice % ((long) 100))) == 0) {
            str = LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbol(calculatePrice, this.f19484h);
        } else {
            str = LocalizationUtils.CurrencyUtils.getCurrency(calculatePrice, this.f19484h);
        }
        CustomerAppCompatTextView customerAppCompatTextView = this.f19477a;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billTipText");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setText(ResourceHelper.getString(R.string.FoodC_order_Tip_the_gARb, str));
    }

    /* renamed from: a */
    private final void m14592a(long j, BillTipModel billTipModel, LinearLayout linearLayout) {
        String str;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        NormalTipItemView normalTipItemView = new NormalTipItemView(context);
        int i = this.f19481e;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, DisplayExtensionKt.dip2px(context2, 40.0f));
        layoutParams.gravity = 17;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        layoutParams.leftMargin = DisplayExtensionKt.dip2px(context3, 5.0f);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        layoutParams.rightMargin = DisplayExtensionKt.dip2px(context4, 5.0f);
        linearLayout.addView(normalTipItemView, layoutParams);
        if (billTipModel.isPercent()) {
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append('%');
            str = sb.toString();
        } else if (((int) (j % ((long) 100))) == 0) {
            str = LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbol(j, this.f19484h);
            Intrinsics.checkNotNullExpressionValue(str, "getSimplifiedCurrencyWit…   currency\n            )");
        } else {
            str = LocalizationUtils.CurrencyUtils.getCurrency(j, this.f19484h);
            Intrinsics.checkNotNullExpressionValue(str, "getCurrency(item, currency)");
        }
        normalTipItemView.setData(str, j == billTipModel.getTipFeeValue());
        normalTipItemView.setOnClickListener(new View.OnClickListener(j, normalTipItemView) {
            public final /* synthetic */ long f$1;
            public final /* synthetic */ NormalTipItemView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r4;
            }

            public final void onClick(View view) {
                BillTipView.m14593a(BillTipView.this, this.f$1, this.f$2, view);
            }
        });
        this.f19482f.add(normalTipItemView);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14593a(BillTipView billTipView, long j, NormalTipItemView normalTipItemView, View view) {
        Intrinsics.checkNotNullParameter(billTipView, "this$0");
        Intrinsics.checkNotNullParameter(normalTipItemView, "$itemView");
        billTipView.clearSelectedView();
        billTipView.updateTipAmount(j, false);
        normalTipItemView.setSelectedState(true);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        KeyboardUtils.hideSoftInput(getContext(), getView());
    }

    public void clearSelectedView() {
        for (ITipItemView selectedState : this.f19482f) {
            selectedState.setSelectedState(false);
        }
    }

    public void showExceedMaxMessage() {
        ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_order_Tip_exceeds_WYIA));
    }

    /* renamed from: a */
    private final void m14596a(BillTipModel billTipModel, LinearLayout linearLayout) {
        EditTipItemView editTipItemView = new EditTipItemView(getContext(), (AttributeSet) null, 0, billTipModel, 6, (DefaultConstructorMarker) null);
        editTipItemView.setBillTipEditCallback(this);
        editTipItemView.setData(billTipModel, this.f19484h);
        editTipItemView.setOnClickListener(new View.OnClickListener(editTipItemView) {
            public final /* synthetic */ EditTipItemView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BillTipView.m14595a(BillTipView.this, this.f$1, view);
            }
        });
        int i = this.f19481e;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, DisplayExtensionKt.dip2px(context, 40.0f));
        layoutParams.gravity = 17;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        layoutParams.leftMargin = DisplayExtensionKt.dip2px(context2, 5.0f);
        linearLayout.addView(editTipItemView, layoutParams);
        this.f19482f.add(editTipItemView);
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14595a(BillTipView billTipView, EditTipItemView editTipItemView, View view) {
        Intrinsics.checkNotNullParameter(billTipView, "this$0");
        Intrinsics.checkNotNullParameter(editTipItemView, "$itemView");
        billTipView.clearSelectedView();
        billTipView.updateTipAmount(0, true);
        editTipItemView.setSelectedState(true);
    }

    /* renamed from: a */
    private final boolean m14597a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        return m14598a("^\\+?[1-9][0-9]*$", str);
    }

    /* renamed from: a */
    private final boolean m14598a(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    /* renamed from: a */
    private final int m14591a() {
        int screenWidth = CustomerSystemUtil.getScreenWidth(getContext());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dip2px = screenWidth - (DisplayExtensionKt.dip2px(context, 20.0f) * 2);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        return (dip2px - (DisplayExtensionKt.dip2px(context2, 10.0f) * 2)) / 3;
    }
}
