package com.didi.entrega.order.debt;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.order.debt.Contract;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.taxis99.R;

public class DebtOrderPayView extends Contract.AbsDebtOrderPayView implements IRFFloatingExpand {

    /* renamed from: a */
    RFMainButton f20885a;

    /* renamed from: b */
    TextView f20886b;

    /* renamed from: c */
    ImageView f20887c;

    /* renamed from: d */
    TextView f20888d;

    /* renamed from: e */
    View f20889e;

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

    public void setPayInfo(String str, String str2, PayChannel payChannel) {
        if (!TextUtils.isEmpty(str2)) {
            this.f20886b.setText(str2);
        }
        if (payChannel == null) {
            this.f20887c.setVisibility(8);
            this.f20888d.setVisibility(0);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f20888d, IToolsService.FontType.NORMAL);
            this.f20888d.setText(ResourceHelper.getString(R.string.FoodC_unpaid_Select_NWED));
            this.f20888d.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            return;
        }
        if (!TextUtils.isEmpty(payChannel.getCardOrg())) {
            this.f20887c.setVisibility(0);
            FlyImageLoader.loadImageUnspecified(getContext(), payChannel.getCardOrg()).into(this.f20887c);
        } else {
            this.f20887c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payChannel.getCardSuffix())) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f20888d, IToolsService.FontType.MEDIUM);
            this.f20888d.setVisibility(0);
            this.f20888d.setText(payChannel.getCardSuffix().substring(payChannel.getCardSuffix().length() - 4));
            this.f20888d.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            return;
        }
        this.f20888d.setVisibility(8);
    }

    public void setLoading(boolean z) {
        this.f20885a.setLoading(z);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_component_order_pay_info, viewGroup);
        this.f20885a = (RFMainButton) inflate.findViewById(R.id.customer_custom_common_dialog_confirm);
        this.f20886b = (TextView) inflate.findViewById(R.id.customer_custom_payment_total_money);
        this.f20887c = (ImageView) inflate.findViewById(R.id.customer_iv_payment_card_icon);
        this.f20888d = (TextView) inflate.findViewById(R.id.customer_custom_payment_card_number);
        this.f20889e = inflate.findViewById(R.id.customer_custom_change_payment_method);
        this.f20885a.setText(ResourceHelper.getString(R.string.FoodC_unpaid_Payment_KjvL));
        this.f20889e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m15303c(view);
            }
        });
        this.f20885a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m15302b(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15303c(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).selectPayMethod();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15302b(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).pay();
    }

    public void onCreate() {
        super.onCreate();
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    DebtOrderPayView.this.m15301a(view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_unpaid_Pay_this_zfnM)).build());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15301a(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).closePage();
    }
}
