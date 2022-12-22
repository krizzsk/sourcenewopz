package com.didi.component.payentrance.newui.view;

import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;

public interface INewUIPayEntranceView extends IPayEntranceView {
    void setBtnClickable(boolean z);

    void setPayInfo(BasicPayInfo basicPayInfo);

    void setTitle(String str);
}
