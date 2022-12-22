package com.didi.soda.goodsV2.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;

public class BaseGoodsPurchaseRvModel implements RecyclerModel {
    public int mRvIndex;

    public void setRvIndex(int i) {
        this.mRvIndex = i;
    }
}
