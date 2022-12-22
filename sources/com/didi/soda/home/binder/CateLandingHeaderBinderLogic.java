package com.didi.soda.home.binder;

import com.didi.soda.home.topgun.binder.HomeHeaderBinderLogic;
import com.didi.soda.home.topgun.binder.HomeHeaderItemLogicRepo;
import com.didi.soda.home.topgun.model.FilterModel;

public class CateLandingHeaderBinderLogic extends HomeHeaderBinderLogic {
    public void filterItemAction(FilterModel filterModel, boolean z) {
        HomeHeaderItemLogicRepo.LogicModel logicModel = new HomeHeaderItemLogicRepo.LogicModel(HomeHeaderItemLogicRepo.TYPE_SHOP_LAND_ITEM_CLICK);
        logicModel.floatingProgress = z ? 1.0f : 0.0f;
        logicModel.filterModel = filterModel;
        ((HomeHeaderItemLogicRepo) getLogicRepo()).shopLandLogicModel = logicModel;
        ((HomeHeaderItemLogicRepo) getLogicRepo()).setValue((HomeHeaderItemLogicRepo.LogicModel) ((HomeHeaderItemLogicRepo) getLogicRepo()).getValue());
    }
}
