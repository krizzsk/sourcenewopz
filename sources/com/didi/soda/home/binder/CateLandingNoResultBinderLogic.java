package com.didi.soda.home.binder;

import com.didi.soda.home.topgun.binder.HomeFilterNoResultBinder;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;
import com.didi.soda.home.topgun.widget.HomeFilterNoResultView;

public class CateLandingNoResultBinderLogic extends HomeFilterNoResultBinder.HomeFilterNoResultLogic {
    public HomeFilterNoResultView.ResetSizeListener getResetListener() {
        return null;
    }

    public Class<FilterNoResultLogicRepo> bindLogicRepoType() {
        return FilterNoResultLogicRepo.class;
    }

    public void onButtonClick() {
        ((FilterNoResultLogicRepo) getLogicRepo()).setShopLandStatus(1);
        ((FilterNoResultLogicRepo) getLogicRepo()).setValue((Integer) ((FilterNoResultLogicRepo) getLogicRepo()).getValue());
    }
}
