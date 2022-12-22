package com.didi.soda.home.topgun.binder.model;

import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.DebtInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderTipsEntity;
import com.didi.soda.order.model.DebtInfoRvModel;
import java.util.List;

public class HomeOrderCardRvModel implements RecyclerModel {
    public boolean isForClientPay;
    public DebtInfoRvModel mDebtInfoRvModel;
    public boolean mNeedTrackEta;
    public String mOrderId;
    public String mOrderIntlSubDesc;
    public String mOrderStatus;
    public String mOrderSubStatus;
    public String mShopName;
    public int mStatus;
    public String mStatusTimeDescRich;
    public String mTimeDesc;
    public int mTotalNum;
    public int mUserTakeCountDown;
    public int scene;
    public List<OrderTipsEntity> tips;

    public static HomeOrderCardRvModel convertHomeOrderStatus(List<OrderInfoEntity> list, int i) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HomeOrderCardRvModel homeOrderCardRvModel = new HomeOrderCardRvModel();
        homeOrderCardRvModel.mTotalNum = i;
        OrderInfoEntity orderInfoEntity = list.get(0);
        homeOrderCardRvModel.mOrderStatus = orderInfoEntity.statusShortDesc;
        if (TextUtils.isEmpty(orderInfoEntity.statusShortDesc)) {
            homeOrderCardRvModel.mOrderStatus = orderInfoEntity.statusDesc;
        }
        homeOrderCardRvModel.mOrderSubStatus = orderInfoEntity.statusSubShortDesc;
        homeOrderCardRvModel.mTimeDesc = orderInfoEntity.statusTimeDesc;
        homeOrderCardRvModel.mOrderIntlSubDesc = orderInfoEntity.intlSubDesc;
        homeOrderCardRvModel.mShopName = orderInfoEntity.shopInfo.shopName;
        homeOrderCardRvModel.mOrderId = orderInfoEntity.orderId;
        homeOrderCardRvModel.mStatus = orderInfoEntity.status;
        homeOrderCardRvModel.isForClientPay = orderInfoEntity.isForClientPay();
        homeOrderCardRvModel.mUserTakeCountDown = orderInfoEntity.userTakeCountDown;
        homeOrderCardRvModel.tips = orderInfoEntity.tips;
        homeOrderCardRvModel.scene = orderInfoEntity.scene;
        homeOrderCardRvModel.mStatusTimeDescRich = orderInfoEntity.statusTimeDescRich;
        DebtInfoEntity debtInfoEntity = orderInfoEntity.debtInfo;
        if (debtInfoEntity != null && debtInfoEntity.isComplete == 0) {
            DebtInfoRvModel debtInfoRvModel = new DebtInfoRvModel();
            homeOrderCardRvModel.mDebtInfoRvModel = debtInfoRvModel;
            debtInfoRvModel.mDebtId = debtInfoEntity.debtId;
            homeOrderCardRvModel.mDebtInfoRvModel.mIsComplete = debtInfoEntity.isComplete;
            homeOrderCardRvModel.mDebtInfoRvModel.mOrderId = debtInfoEntity.orderId;
            homeOrderCardRvModel.mDebtInfoRvModel.mUnpaidMoneyDisplay = debtInfoEntity.unpaidMoneyDisplay;
            homeOrderCardRvModel.mDebtInfoRvModel.mIsStatusPaying = debtInfoEntity.isStatusPaying;
            if (debtInfoEntity.biData != null) {
                homeOrderCardRvModel.mDebtInfoRvModel.mArrearsOrderStatus = debtInfoEntity.biData.arrearsOrderStatus;
            }
        }
        return homeOrderCardRvModel;
    }

    public void setValue(HomeOrderCardRvModel homeOrderCardRvModel) {
        this.mOrderStatus = homeOrderCardRvModel.mOrderStatus;
        this.mOrderSubStatus = homeOrderCardRvModel.mOrderSubStatus;
        this.mOrderIntlSubDesc = homeOrderCardRvModel.mOrderIntlSubDesc;
        this.mTimeDesc = homeOrderCardRvModel.mTimeDesc;
        this.mShopName = homeOrderCardRvModel.mShopName;
        this.mOrderId = homeOrderCardRvModel.mOrderId;
        this.mStatus = homeOrderCardRvModel.mStatus;
        this.mTotalNum = homeOrderCardRvModel.mTotalNum;
    }
}
