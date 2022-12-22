package com.didi.component.splitfare.view;

import com.didi.component.splitfare.presenter.impl.SplitFareOnServicePresenter;
import com.didi.travel.psnger.model.response.CarOrder;

public interface ISplitFareOnServiceView extends ISplitFareView<SplitFareOnServicePresenter> {
    void hide();

    void loading(boolean z);

    void show(CarOrder carOrder);
}
