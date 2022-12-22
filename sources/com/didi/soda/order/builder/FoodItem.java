package com.didi.soda.order.builder;

public class FoodItem {
    public String mAbnormalDesc;
    public int mAmount;
    public String mCurrentPrice;
    public String mDesc;
    public String mMduId;
    public CharSequence mName;
    public String mOriginalPrice;

    public static class Builder {
        FoodItem mFoodItem = new FoodItem();

        public FoodItem build() {
            return this.mFoodItem;
        }

        public Builder setAmount(int i) {
            this.mFoodItem.mAmount = i;
            return this;
        }

        public Builder setAbnormalDesc(String str) {
            this.mFoodItem.mAbnormalDesc = str;
            return this;
        }

        public Builder setCurrentPrice(String str) {
            this.mFoodItem.mCurrentPrice = str;
            return this;
        }

        public Builder setDesc(String str) {
            this.mFoodItem.mDesc = str;
            return this;
        }

        public Builder setMduId(String str) {
            this.mFoodItem.mMduId = str;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.mFoodItem.mName = charSequence;
            return this;
        }

        public Builder setOriginalPrice(String str) {
            this.mFoodItem.mOriginalPrice = str;
            return this;
        }
    }
}
