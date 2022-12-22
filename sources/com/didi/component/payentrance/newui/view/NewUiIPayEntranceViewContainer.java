package com.didi.component.payentrance.newui.view;

import com.didi.component.payentrance.view.IPayEntranceViewContainer;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;

public interface NewUiIPayEntranceViewContainer extends IPayEntranceViewContainer {
    void setBtnClickable(boolean z);

    void setPayInfo(BasicPayInfo basicPayInfo);

    void setTitle(String str);
}
