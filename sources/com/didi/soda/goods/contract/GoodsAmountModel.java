package com.didi.soda.goods.contract;

import com.didi.soda.customer.repo.model.ItemState;

public class GoodsAmountModel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f42410a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f42411b;

    /* renamed from: c */
    private GoodsAmountListener f42412c;
    public int mActivityType;
    public String mBusinessId;
    public String mGoodsId;
    public GoodsItemState mGoodsItemState;
    public int mInitialAmount = 0;
    public String mItemUniKey;
    public int mMaxAmount;
    public int mMaxSaleAmount = 0;
    public int mMinAmount;

    public interface GoodsAmountListener {
        void exceedMaxAmount(int i);

        void exceedMaxSaleAmount(int i);

        void exceedMinAmount();
    }

    public boolean decreaseAmount(int i) {
        if (exceedMinAmount()) {
            GoodsAmountListener goodsAmountListener = this.f42412c;
            if (goodsAmountListener == null) {
                return false;
            }
            goodsAmountListener.exceedMinAmount();
            return false;
        }
        this.f42410a -= i;
        return true;
    }

    public boolean exceedMaxAmount() {
        return this.f42410a >= this.mMaxAmount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = r2.mMaxSaleAmount;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean exceedMaxSaleAmount() {
        /*
            r2 = this;
            int r0 = r2.mActivityType
            boolean r0 = com.didi.soda.goods.helper.GoodsDataHelper.isSpecialPrice(r0)
            if (r0 != 0) goto L_0x0018
            int r0 = r2.mActivityType
            boolean r0 = com.didi.soda.goods.helper.GoodsDataHelper.isRegularCustomer(r0)
            if (r0 != 0) goto L_0x0018
            int r0 = r2.mActivityType
            boolean r0 = com.didi.soda.goods.helper.GoodsDataHelper.isEFO(r0)
            if (r0 == 0) goto L_0x002b
        L_0x0018:
            boolean r0 = r2.f42411b
            if (r0 != 0) goto L_0x002b
            int r0 = r2.mMaxSaleAmount
            if (r0 < 0) goto L_0x002b
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 >= r1) goto L_0x002b
            int r1 = r2.f42410a
            if (r1 < r0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.goods.contract.GoodsAmountModel.exceedMaxSaleAmount():boolean");
    }

    public boolean exceedMinAmount() {
        return this.f42410a <= this.mMinAmount;
    }

    public int getCurrentAmount() {
        return this.f42410a;
    }

    public boolean increaseAmount(int i) {
        if (exceedMaxAmount()) {
            GoodsAmountListener goodsAmountListener = this.f42412c;
            if (goodsAmountListener != null) {
                goodsAmountListener.exceedMaxAmount(this.mMaxAmount);
            }
            return false;
        } else if (exceedMaxSaleAmount() && this.f42412c != null) {
            return false;
        } else {
            this.f42410a += i;
            return true;
        }
    }

    public void setGoodsAmountListener(GoodsAmountListener goodsAmountListener) {
        this.f42412c = goodsAmountListener;
    }

    public void updateGoodsItemAmountModel(ItemState itemState) {
        if (itemState != null && this.mItemUniKey.equals(itemState.itemUniKey)) {
            this.f42410a = itemState.amount;
        }
    }

    public void clearAmount() {
        this.f42410a = 0;
    }

    public static class Builder {
        private GoodsAmountModel mGoodsAmountModel = new GoodsAmountModel();

        public GoodsAmountModel build() {
            return this.mGoodsAmountModel;
        }

        public Builder setBusinessId(String str) {
            this.mGoodsAmountModel.mBusinessId = str;
            return this;
        }

        public Builder setGoodsId(String str) {
            this.mGoodsAmountModel.mGoodsId = str;
            return this;
        }

        public Builder setItemUniKey(String str) {
            this.mGoodsAmountModel.mItemUniKey = str;
            return this;
        }

        public Builder setGoodsItemState(GoodsItemState goodsItemState) {
            this.mGoodsAmountModel.mGoodsItemState = goodsItemState;
            return this;
        }

        public Builder setInitialAmount(int i) {
            this.mGoodsAmountModel.mInitialAmount = i;
            int unused = this.mGoodsAmountModel.f42410a = i;
            return this;
        }

        public Builder setMaxAmount(int i) {
            this.mGoodsAmountModel.mMaxAmount = i;
            return this;
        }

        public Builder setMaxSaleAmount(int i) {
            this.mGoodsAmountModel.mMaxSaleAmount = i;
            return this;
        }

        public Builder setMinAmount(int i) {
            this.mGoodsAmountModel.mMinAmount = i;
            return this;
        }

        public Builder setActivityType(int i) {
            this.mGoodsAmountModel.mActivityType = i;
            return this;
        }

        public Builder setAllowOverAmoun(boolean z) {
            boolean unused = this.mGoodsAmountModel.f42411b = z;
            return this;
        }
    }
}
