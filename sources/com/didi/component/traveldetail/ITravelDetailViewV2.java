package com.didi.component.traveldetail;

import com.didi.component.core.IView;
import com.didi.component.traveldetail.model.TravelDetailItemV2;
import java.util.List;

public interface ITravelDetailViewV2 extends IView<AbsTravelDetailPresenterV2> {
    void doXPanelStatusChanged(int i);

    void hideGuide();

    void setTravelDetailData(List<TravelDetailItemV2> list);

    void showGuide();
}
