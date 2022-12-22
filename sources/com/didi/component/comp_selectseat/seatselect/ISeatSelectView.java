package com.didi.component.comp_selectseat.seatselect;

import com.didi.component.comp_selectseat.model.SeatOptionsModel;
import com.didi.component.core.IGroupView;
import java.util.List;

public interface ISeatSelectView extends IGroupView {
    void onBackPress();

    void resetSlideBgView();

    void setMainTitle(String str);

    void setSeatsData(List<SeatOptionsModel> list);

    void setSubTitle(String str);

    void showOrHideLoadingTimeoutView(int i);

    void slideItemBg(float f, float f2);
}
