package com.didiglobal.comp.carmodellist.common;

import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import java.util.List;

public interface AnyCarSelectListener {
    void carpoolSeatSelected(AnyCarEstimateItemModel anyCarEstimateItemModel);

    void defaultSelectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel);

    void openDetail(AnyCarEstimateItemModel anyCarEstimateItemModel);

    void selectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel);

    void setAllItems(List<AnyCarEstimateItemModel> list);

    void singleSelected(AnyCarEstimateItemModel anyCarEstimateItemModel);

    void unSelectItem(AnyCarEstimateItemModel anyCarEstimateItemModel);
}
