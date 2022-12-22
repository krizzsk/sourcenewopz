package com.didi.soda.home.topgun.binder;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.repo.model.LogicBaseModel;
import com.didi.soda.home.topgun.model.FilterModel;

public class HomeHeaderItemLogicRepo extends Repo<LogicModel> {
    public static final String TYPE_ON_FILTER_ITEM_CLICK = "onFilterItemClick";
    public static final String TYPE_SHOP_LAND_ITEM_CLICK = "onShopLandFilterItemClick";
    public LogicModel shopLandLogicModel;

    public static class LogicModel extends LogicBaseModel {
        public FilterModel filterModel;
        public float floatingProgress;

        public LogicModel(String str) {
            super(str);
        }

        public boolean isFloating() {
            return this.floatingProgress == 1.0f;
        }
    }
}
