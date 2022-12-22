package com.didi.soda.order.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;

public class DebtInfoRvModel implements RecyclerModel {
    public int mArrearsOrderStatus;
    public int mCsLinkStatus;
    public String mDebtId;
    public String mEmphasizedText;
    public int mIsComplete;
    public int mIsStatusPaying;
    public String mOrderId;
    public int mPayBtnStatus;
    public PayChannelEntity mPayChannel;
    public int mUnpaidMoney;
    public String mUnpaidMoneyDisplay;
}
