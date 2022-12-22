package com.didi.component.comp_travel_detail_new;

import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.StationModel;
import java.util.List;

public interface ITravelDetailNewView extends IView<AbsTravelDetailNewPresenter> {
    void bindData(List<StationModel> list);
}
