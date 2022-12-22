package com.didi.component.unenablecity;

import com.didi.sdk.app.BusinessContext;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;

public interface IUnableCityContainerView extends INoOpenPositionView, IPreheatCityView, IUnopenedCityView {
    void cleanType();

    boolean hideSafetyTrainView();

    void showNoOpenPositionView();

    void showOrderBanView(OrderBanCardInfo orderBanCardInfo, BusinessContext businessContext);

    void showPreheatView();

    boolean showSafetyTrainView(SafetyTrainCardInfo safetyTrainCardInfo);

    void showUnopenedCityView();
}
