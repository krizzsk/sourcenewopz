package com.didi.soda.customer.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;

public class CustomerDividerLineRvModel implements RecyclerModel {
    public int mColor;
    public int mHeight;
    public int mHorizontalPadding;
    public int mVerticalPadding;

    public CustomerDividerLineRvModel(int i, int i2, int i3, int i4) {
        this.mHeight = i;
        this.mHorizontalPadding = i2;
        this.mVerticalPadding = i3;
        this.mColor = i4;
    }
}
