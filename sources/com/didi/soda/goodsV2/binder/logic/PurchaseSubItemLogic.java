package com.didi.soda.goodsV2.binder.logic;

import com.didi.soda.goodsV2.binder.logic.PurchaseSubItemLogicRepo;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;

public class PurchaseSubItemLogic extends AbsPurchaseSubItemLogic {
    public void goMultiLevelPage(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        ((PurchaseSubItemLogicRepo) getLogicRepo()).setValue(PurchaseSubItemLogicRepo.PurchaseSubItemLogicModel.newGoMultiLevelModel(goodsPurchaseSubItemRvModel));
    }
}
