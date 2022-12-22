package com.didi.component.timepicker;

import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;

public interface ITimePickerView extends IView<AbsTimePickerPresenter> {
    void bindRichInfo(GlobalRichInfo globalRichInfo);

    void dismissNewBubble();

    void setArrow(boolean z);

    void setEnable(boolean z);

    void setIcon(int i);

    void setIcon(String str);

    void setLabel(CharSequence charSequence);

    void setName(CharSequence charSequence);

    void showBookingGuideTips(BubbleItemModel bubbleItemModel);

    void showTimepickerDialog(TimePickerModel timePickerModel, long j);
}
