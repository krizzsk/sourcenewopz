package com.didi.component.unenablecity;

import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.component.core.IView;

public interface IUnopenedCityView extends IView<AbsUnableCityPresenter> {
    void setData(GlobalTemplateCardModel globalTemplateCardModel);
}
