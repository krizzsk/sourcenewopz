package com.didi.soda.search.component.result.binder;

import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.search.helper.SearchNewOmegaHelper;

public class SearchBusinessOmegaInterfaceImpl implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {
    public String getBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        return "";
    }

    public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        SearchNewOmegaHelper.getInstance().itemExposure(homeBusinessInfoRvModel, false);
    }

    public void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        SearchNewOmegaHelper.getInstance().trackBusinessClick(homeBusinessInfoRvModel, (SearchFoodItemView.SearchFoodItemModel) null, false);
    }

    public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        SearchNewOmegaHelper.getInstance().setBusinessGuideParam(homeBusinessInfoRvModel);
    }
}
