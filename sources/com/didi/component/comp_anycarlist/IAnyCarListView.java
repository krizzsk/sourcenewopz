package com.didi.component.comp_anycarlist;

import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import java.util.List;

public interface IAnyCarListView extends IView<AbsAnyCarListPresenter> {
    void setData(List<AnyCarGroup> list);

    void setInitParam(List<AnyCarEstimateItemModel> list);
}
