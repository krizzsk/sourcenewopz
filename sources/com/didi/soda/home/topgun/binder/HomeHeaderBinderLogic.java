package com.didi.soda.home.topgun.binder;

import android.text.TextUtils;
import com.didi.soda.customer.animation.transitions.name.SearchTransitionNameSet;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.home.topgun.binder.HomeHeaderItemLogicRepo;
import com.didi.soda.home.topgun.manager.HomeLogTrackerHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.model.HomeSearchHotWordsModel;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.util.HashMap;

public class HomeHeaderBinderLogic extends BinderLogic<HomeHeaderItemLogicRepo> {
    public void filterItemAction(FilterModel filterModel, boolean z) {
        HomeHeaderItemLogicRepo.LogicModel logicModel = new HomeHeaderItemLogicRepo.LogicModel(HomeHeaderItemLogicRepo.TYPE_ON_FILTER_ITEM_CLICK);
        logicModel.floatingProgress = z ? 1.0f : 0.0f;
        logicModel.filterModel = filterModel;
        ((HomeHeaderItemLogicRepo) getLogicRepo()).setValue(logicModel);
        int i = logicModel.filterModel.mShowType;
        HashMap hashMap = new HashMap();
        hashMap.put("showType", Integer.valueOf(i));
        HomeLogTrackerHelper.setLogTracker("onClickFilterItem", "c-act|", hashMap);
    }

    public void onSearchLayoutClick(boolean z, HomeSearchHotWordsModel homeSearchHotWordsModel) {
        if (((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress() != null && !ClickUtils.isFastClick()) {
            Request.Builder path = DiRouter.request().path(RoutePath.SEARCH_HOME);
            int i = 2;
            if (homeSearchHotWordsModel != null) {
                if (!TextUtils.isEmpty(homeSearchHotWordsModel.getWord())) {
                    path.putString("search_word", homeSearchHotWordsModel.getWord());
                }
                if (homeSearchHotWordsModel.getType().intValue() == 2) {
                    path.putString(Const.PageParams.SEARCH_URL, homeSearchHotWordsModel.getUrl());
                }
            }
            path.putString("fromPage", "homePage");
            path.putSerializable(Const.PageParams.SEARCH_HOME_MODEL, homeSearchHotWordsModel);
            path.putSerializable(Const.PageParams.TRANSITION_NAMES, SearchTransitionNameSet.getNormalTransitionName()).open();
            HomeLogTrackerHelper.setLogTracker("onSearchClick", "c-act|");
            HomeOmegaHelper instance = HomeOmegaHelper.getInstance();
            if (z) {
                i = 1;
            }
            instance.trackSearchEditViewClick(i);
        }
    }

    public Class<HomeHeaderItemLogicRepo> bindLogicRepoType() {
        return HomeHeaderItemLogicRepo.class;
    }
}
