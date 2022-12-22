package com.didi.soda.goods.binder.logic;

import com.didi.soda.goods.binder.logic.PurchaseSubItemLogicRepo;
import com.didi.soda.goods.model.GoodsPurchaseSubItemRvModel;

public class PurchaseSubItemLogic extends AbsPurchaseSubItemLogic {
    public void goMultiLevelPage(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        ((PurchaseSubItemLogicRepo) getLogicRepo()).setValue(PurchaseSubItemLogicRepo.PurchaseSubItemLogicModel.newGoMultiLevelModel(goodsPurchaseSubItemRvModel));
    }
}
