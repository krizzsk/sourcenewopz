package com.didi.component.service.activity.risk.items;

import android.app.Activity;
import android.view.View;
import com.didi.component.service.activity.risk.RiskListAdapter;
import com.didi.component.service.activity.risk.RiskViewHolder;
import com.didi.component.service.activity.risk.model.RiskVerifyListItem;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didichuxing.diface.logger.DiFaceLogger;

public class CreditCardCustomItem extends CreditCardItem {

    /* renamed from: a */
    private RiskVerifyListItem f15718a;

    /* access modifiers changed from: protected */
    public boolean isCustomItem() {
        return true;
    }

    public CreditCardCustomItem(String str, RiskListAdapter riskListAdapter, Activity activity, RiskVerifyListItem riskVerifyListItem) {
        super(str, riskListAdapter, activity);
        this.f15718a = riskVerifyListItem;
    }

    /* access modifiers changed from: protected */
    public String getItemTitleStr() {
        return this.f15718a.content;
    }

    /* access modifiers changed from: protected */
    public String getItemIconUrl() {
        return this.f15718a.head;
    }

    /* access modifiers changed from: protected */
    public void onClick(RiskListAdapter riskListAdapter, View view, RiskViewHolder riskViewHolder, int i) {
        int i2;
        this.mLoadingDialog = showLoading("");
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        try {
            i2 = Integer.parseInt(this.f15718a.cell_click_param.from_type);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = -1;
        }
        if (i2 <= 0) {
            i2 = 15;
        }
        addCardParam.bindType = i2;
        addCardParam.isShowLoading = false;
        addCardParam.resourceId = DiFaceLogger.EVENT_ID_BIOASSAY_EXIT;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(this.mActivity, 10010, addCardParam);
        trackClickEvent(2);
    }
}
