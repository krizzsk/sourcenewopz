package com.didi.soda.order.component.debtpay;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.didi.soda.bill.widgets.CustomerBottomButton;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.order.component.debtpay.Contract;
import com.taxis99.R;

public class DebtOrderPayView extends Contract.AbsDebtOrderPayView {

    /* renamed from: a */
    private String f43385a;
    @BindView(19187)
    View mBackground;
    @BindView(17950)
    View mChangePaymentMethod;
    @BindView(17953)
    IconTextView mClose;
    @BindView(17954)
    CustomerBottomButton mConfirm;
    @BindView(18019)
    TextView mPaymentCardNum;
    @BindView(18453)
    ImageView mPaymentIcon;
    @BindView(18024)
    TextView mPaymentMoney;

    public void setPayInfo(String str, String str2, PayChannelEntity payChannelEntity) {
        this.f43385a = str;
        if (!TextUtils.isEmpty(str2)) {
            this.mPaymentMoney.setText(str2);
        }
        if (payChannelEntity == null) {
            this.mPaymentIcon.setVisibility(8);
            this.mPaymentCardNum.setVisibility(0);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPaymentCardNum, IToolsService.FontType.NORMAL);
            this.mPaymentCardNum.setText(ResourceHelper.getString(R.string.customer_name_please_select));
            this.mPaymentCardNum.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            return;
        }
        if (!TextUtils.isEmpty(payChannelEntity.cardOrg)) {
            this.mPaymentIcon.setVisibility(0);
            FlyImageLoader.loadImageUnspecified(getContext(), payChannelEntity.cardOrg).into(this.mPaymentIcon);
        } else {
            this.mPaymentIcon.setVisibility(8);
        }
        if (!TextUtils.isEmpty(payChannelEntity.cardSuffix)) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPaymentCardNum, IToolsService.FontType.MEDIUM);
            this.mPaymentCardNum.setVisibility(0);
            this.mPaymentCardNum.setText(payChannelEntity.cardSuffix.substring(payChannelEntity.cardSuffix.length() - 4));
            this.mPaymentCardNum.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            return;
        }
        this.mPaymentCardNum.setVisibility(8);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.mConfirm.loading();
        } else {
            this.mConfirm.hideLoading();
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_order_pay_info, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mConfirm.setMiddleTextText(ResourceHelper.getString(R.string.customer_pay));
        this.mChangePaymentMethod.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m30688d(view);
            }
        });
        this.mClose.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m30687c(view);
            }
        });
        this.mConfirm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m30686b(view);
            }
        });
        this.mBackground.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DebtOrderPayView.this.m30684a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m30688d(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).selectPayMethod();
        m30685a(EventConst.Order.ORDER_DEBT_ARREARS_PAYMETHOD_CK);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m30687c(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).closePage();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30686b(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).pay();
        m30685a(EventConst.Order.ORDER_DEBT_ARREARS_PAY_CK);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30684a(View view) {
        ((Contract.AbsDebtOrderPayPresenter) getPresenter()).closePage();
    }

    /* renamed from: a */
    private void m30685a(String str) {
        OmegaTracker.Builder.create(str, getScopeContext()).addEventParam("order_id", this.f43385a).build().track();
    }
}
