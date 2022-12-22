package com.didi.entrega.pay.widget;

import android.content.Context;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.pay.model.PayMethodInfoModel;

public class CashPaySubItemView extends SubItemView {
    public CashPaySubItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void setCashInfo(PayMethodInfoModel payMethodInfoModel) {
        FlyImageLoader.loadImageUnspecified(getContext(), payMethodInfoModel.mIconUrl).centerCrop().into(this.mPayIconView);
        this.mPayInfoTitleView.setText(payMethodInfoModel.mChannelName);
        setSubtitle(payMethodInfoModel.mReason);
        this.mPayRightIconView.setSelected(payMethodInfoModel.mIsSelected);
        if (payMethodInfoModel.mIsDisplay) {
            showOrHideMaskView(false);
            return;
        }
        showOrHideMaskView(true);
        this.mArrowLayout.setVisibility(8);
        this.mPayRightIconView.setVisibility(8);
    }
}
