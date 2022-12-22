package com.didi.soda.goodsV2.binder.logic;

import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;

public abstract class AbsPurchaseSubItemLogic extends BinderLogic<PurchaseSubItemLogicRepo> {
    public abstract void goMultiLevelPage(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel);

    public Class<PurchaseSubItemLogicRepo> bindLogicRepoType() {
        return PurchaseSubItemLogicRepo.class;
    }
}
