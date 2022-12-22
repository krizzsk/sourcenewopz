package com.didi.component.carpool.info.view;

import com.didi.component.carpool.info.model.CarPoolCardInfo;
import com.didi.component.carpool.info.model.CarpoolInfoItem;
import com.didi.component.carpool.info.presenter.AbsCarpoolInfoPresenter;
import com.didi.component.core.IView;
import java.util.List;

public interface ICarpoolInfoView extends IView<AbsCarpoolInfoPresenter> {
    void setData(CarPoolCardInfo carPoolCardInfo);

    void setRealtimeFee(String str, String str2);

    void setTravelDetailData(List<CarpoolInfoItem> list, int i);
}
