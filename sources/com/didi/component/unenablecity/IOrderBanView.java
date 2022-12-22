package com.didi.component.unenablecity;

import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;

public interface IOrderBanView extends IView<AbsUnableCityPresenter> {
    void setOrderBanCardInfo(OrderBanCardInfo orderBanCardInfo);
}
