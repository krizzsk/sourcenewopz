package com.didi.soda.goodsV2.binder.logic;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.repo.model.LogicBaseModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;

public class PurchaseSubItemLogicRepo extends Repo<PurchaseSubItemLogicModel> {

    public static class PurchaseSubItemLogicModel extends LogicBaseModel {
        public static final String TYPE_GO_MULTI_LEVEL = "goMultiLevel";
        public GoodsPurchaseSubItemRvModel rvModel;

        public PurchaseSubItemLogicModel(String str) {
            super(str);
        }

        public static PurchaseSubItemLogicModel newGoMultiLevelModel(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
            PurchaseSubItemLogicModel purchaseSubItemLogicModel = new PurchaseSubItemLogicModel("goMultiLevel");
            purchaseSubItemLogicModel.rvModel = goodsPurchaseSubItemRvModel;
            return purchaseSubItemLogicModel;
        }
    }
}
