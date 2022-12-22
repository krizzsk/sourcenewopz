package com.didi.soda.goodsV2.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.mark.StickyHeader;

public final class GoodsPurchaseTitleRvModel extends BaseGoodsPurchaseRvModel implements RecyclerModel, StickyHeader {
    public String mTitle;

    private GoodsPurchaseTitleRvModel() {
    }

    public static GoodsPurchaseTitleRvModel newInstance(String str) {
        GoodsPurchaseTitleRvModel goodsPurchaseTitleRvModel = new GoodsPurchaseTitleRvModel();
        goodsPurchaseTitleRvModel.mTitle = str;
        return goodsPurchaseTitleRvModel;
    }
}
