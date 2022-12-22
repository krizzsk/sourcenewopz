package com.didi.component.dispatchfee;

import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;

public interface IDispatchFeeView extends IView<AbsDispatchFeePresenter> {
    void bindDispatchFee(GlobalRichInfo globalRichInfo);

    void setClickable(boolean z);

    void setDispatchFee(String str);

    void setDispatchIcon(String str);

    void setTextColor(int i);
}
