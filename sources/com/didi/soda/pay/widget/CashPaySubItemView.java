package com.didi.soda.pay.widget;

import android.content.Context;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.pay.model.PayMethodInfoModel;
import java.util.List;

public class CashPaySubItemView extends SubItemView {
    public CashPaySubItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void setCashInfo(PayMethodInfoModel payMethodInfoModel) {
        if (payMethodInfoModel.mCombinedChannelList == null || payMethodInfoModel.mCombinedChannelList.isEmpty()) {
            this.mCombinedIcon.setVisibility(4);
            this.mPayIconView.setVisibility(0);
            FlyImageLoader.loadImageUnspecified(getContext(), payMethodInfoModel.mIconUrl).centerCrop().into(this.mPayIconView);
        } else {
            List<PayChannelEntity> list = payMethodInfoModel.mCombinedChannelList;
            if (list.size() >= 2) {
                this.mCombinedIcon.setData(list.get(0).cardOrg, list.get(1).cardOrg);
            } else {
                this.mCombinedIcon.setData(list.get(0).cardOrg, (String) null);
            }
            this.mCombinedIcon.setVisibility(0);
            this.mPayIconView.setVisibility(8);
        }
        this.mPayInfoTitleView.setText(payMethodInfoModel.mChannelName);
        if (StringUtils.isEmpty(payMethodInfoModel.mBalanceMsg)) {
            setSubtitle(payMethodInfoModel.mReason);
        } else {
            setSubtitle(payMethodInfoModel.mBalanceMsg);
            if (StringUtils.isEmpty(payMethodInfoModel.mReason)) {
                this.mMsgLayout.setVisibility(8);
            } else {
                this.mMsgLayout.setVisibility(0);
                this.mMsgTv.setText(payMethodInfoModel.mReason);
            }
        }
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
