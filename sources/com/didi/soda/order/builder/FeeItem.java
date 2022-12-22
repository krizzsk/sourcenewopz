package com.didi.soda.order.builder;

import android.view.View;

public class FeeItem {
    public String mLeftContent;
    public int mLeftIcon;
    public View.OnClickListener mListener;
    public String mRightIcon;
    public String mRigthContent;

    public static class Builder {
        FeeItem mFoodItem = new FeeItem();

        public FeeItem build() {
            return this.mFoodItem;
        }

        public Builder setLeftContent(String str) {
            this.mFoodItem.mLeftContent = str;
            return this;
        }

        public Builder setLeftIconId(int i) {
            this.mFoodItem.mLeftIcon = i;
            return this;
        }

        public Builder setOnLeftIconClicklistener(View.OnClickListener onClickListener) {
            this.mFoodItem.mListener = onClickListener;
            return this;
        }

        public Builder setRightIcon(String str) {
            this.mFoodItem.mRightIcon = str;
            return this;
        }

        public Builder setRigthContent(String str) {
            this.mFoodItem.mRigthContent = str;
            return this;
        }
    }
}
