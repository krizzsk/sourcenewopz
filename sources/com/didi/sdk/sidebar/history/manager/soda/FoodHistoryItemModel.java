package com.didi.sdk.sidebar.history.manager.soda;

import android.text.TextUtils;
import com.didi.sdk.sidebar.history.model.FoodHistoryOrder;

public class FoodHistoryItemModel extends FoodHistoryOrder {
    public String mCurrency;
    public boolean mIsFinished = false;
    public String mItemCreateTime;
    public String mItemEtc;
    public String mItemName;
    public int mItemNum;
    public String mItemOrderState;
    public int mItemPrice;
    public String mItemPriceDisplay;
    public String mItemShopName;
    public String mOrderId;
    public int mOrderStatus;

    public FoodHistoryItemModel(HistoryItemEntity historyItemEntity) {
        handleOrderStatus(historyItemEntity.status, historyItemEntity.isArrears);
        this.mItemOrderState = historyItemEntity.statusDesc;
        if (isFinished()) {
            this.mItemCreateTime = historyItemEntity.createTime;
            this.mItemEtc = "";
        } else {
            this.mItemCreateTime = "";
            this.mItemEtc = historyItemEntity.statusTimeDesc;
        }
        this.mItemShopName = historyItemEntity.shopName;
        this.mItemName = historyItemEntity.itemName;
        this.mItemNum = historyItemEntity.itemNum;
        this.mItemPrice = historyItemEntity.realPayPrice;
        this.mItemPriceDisplay = historyItemEntity.realPayPriceDisplay;
        this.mOrderId = historyItemEntity.orderId;
        this.mOrderStatus = historyItemEntity.status;
        this.mCurrency = historyItemEntity.currency;
    }

    private void handleOrderStatus(int i, int i2) {
        if (i2 == 1) {
            this.mIsFinished = false;
        } else if (i >= 600) {
            this.mIsFinished = true;
        } else {
            this.mIsFinished = false;
        }
    }

    public void setIsFinished(boolean z) {
        this.mIsFinished = z;
    }

    public boolean isFinished() {
        return this.mIsFinished;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FoodHistoryItemModel)) {
            return false;
        }
        FoodHistoryItemModel foodHistoryItemModel = (FoodHistoryItemModel) obj;
        if (!this.mOrderId.equals(foodHistoryItemModel.mOrderId) || this.mOrderStatus != foodHistoryItemModel.mOrderStatus) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 31;
        int hashCode = TextUtils.isEmpty(this.mOrderId) ? 31 : this.mOrderId.hashCode();
        if (!TextUtils.isEmpty(this.mOrderId)) {
            i = this.mOrderId.hashCode();
        }
        return hashCode + i;
    }
}
