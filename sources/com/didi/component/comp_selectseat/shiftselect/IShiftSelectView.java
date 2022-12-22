package com.didi.component.comp_selectseat.shiftselect;

import com.didi.component.comp_selectseat.model.ItemsBean;
import com.didi.component.core.IGroupView;
import java.util.List;

public interface IShiftSelectView extends IGroupView {
    void setDate(List<ItemsBean> list);

    void setHintInfo(String str);

    void setMaxTitle(String str);

    void setMinTitle(String str);

    void showLoadingErrorUi();

    void showNoBusLayout(String str);
}
