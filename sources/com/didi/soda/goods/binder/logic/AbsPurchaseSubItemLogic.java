package com.didi.soda.goods.binder.logic;

import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.goods.model.GoodsPurchaseSubItemRvModel;

public abstract class AbsPurchaseSubItemLogic extends BinderLogic<PurchaseSubItemLogicRepo> {
    public abstract void goMultiLevelPage(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel);

    public Class<PurchaseSubItemLogicRepo> bindLogicRepoType() {
        return PurchaseSubItemLogicRepo.class;
    }
}
