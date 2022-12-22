package com.didi.soda.goodsV2.model;

import android.text.SpannableString;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.goodsV2.contract.GoodsAmountModel;

public class GoodsPurchaseCounterRvModel extends BaseGoodsPurchaseRvModel implements RecyclerModel {
    public int mBusinessStatus;
    public SpannableString mBuyTip;
    public GoodsAmountModel mGoodsAmountModel;
    public boolean mReceviedGiftLimit;

    public static GoodsPurchaseCounterRvModel newInstance(GoodsAmountModel goodsAmountModel, int i, SpannableString spannableString, boolean z) {
        GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel = new GoodsPurchaseCounterRvModel();
        goodsPurchaseCounterRvModel.mGoodsAmountModel = goodsAmountModel;
        goodsPurchaseCounterRvModel.mBuyTip = spannableString;
        goodsPurchaseCounterRvModel.mReceviedGiftLimit = z;
        goodsPurchaseCounterRvModel.mBusinessStatus = i;
        return goodsPurchaseCounterRvModel;
    }

    public boolean hasBuyGiftTip() {
        SpannableString spannableString = this.mBuyTip;
        return spannableString != null && spannableString.length() > 0;
    }
}
