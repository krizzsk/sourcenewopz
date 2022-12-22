package com.didi.component.service.activity.risk.items;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.service.activity.risk.AbsRiskItem;
import com.didi.component.service.activity.risk.RiskListAdapter;
import com.didi.component.service.activity.risk.RiskViewHolder;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;

public class CreditCardItem extends AbsRiskItem {
    public static final int CREDIT_CARD_REQUEST_CODE = 10010;

    /* renamed from: a */
    private boolean f15719a = true;
    protected IDialog mLoadingDialog;

    /* access modifiers changed from: protected */
    public int getItemIconRes() {
        return R.drawable.cc_icon_selector;
    }

    /* access modifiers changed from: protected */
    public int getItemTitleRes() {
        return R.string.risk_credit_card_label;
    }

    public CreditCardItem(String str, RiskListAdapter riskListAdapter, Activity activity) {
        super(str, riskListAdapter, activity);
    }

    /* access modifiers changed from: protected */
    public void onClick(RiskListAdapter riskListAdapter, View view, RiskViewHolder riskViewHolder, int i) {
        this.mLoadingDialog = showLoading("");
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 15;
        addCardParam.isShowLoading = false;
        addCardParam.resourceId = DiFaceLogger.EVENT_ID_BIOASSAY_EXIT;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(this.mActivity, 10010, addCardParam);
        trackClickEvent(2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10010) {
            dismissLoading(this.mLoadingDialog);
            if (i2 == -1) {
                Intent intent2 = new Intent();
                intent2.putExtra("type", this.mTypeName);
                finishActivity(intent2);
                ToastHelper.showLongCompleted((Context) this.mActivity, this.mActivity.getString(R.string.risk_page_success_toast));
                trackVerifyEvent();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        dismissLoading(this.mLoadingDialog);
    }

    /* access modifiers changed from: protected */
    public boolean isItemEnable() {
        return this.f15719a;
    }
}
