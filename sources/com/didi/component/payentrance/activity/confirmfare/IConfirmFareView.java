package com.didi.component.payentrance.activity.confirmfare;

import com.didi.component.core.IGroupView;
import com.didi.component.payentrance.model.OrderRecord;

public interface IConfirmFareView extends IGroupView<ConfirmFarePresenter> {
    void finishWithConfirmResult();

    void finishWithNotMeResult();

    void showOrderRecord(OrderRecord orderRecord);
}
