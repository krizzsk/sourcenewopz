package com.didi.component.imentrance;

import com.didi.beatles.p099im.access.msg.IMMsg;
import com.didi.beatles.p099im.module.entity.IMSysChatUnreadCount;
import com.didi.component.core.IView;
import com.didi.component.imentrance.model.DriverOptionModel;

public interface IIMEntranceView extends IView<AbsIMEntrancePresenter> {

    public interface OnIMEntranceClickListener {
        void onIMEntranceClick();
    }

    void hide();

    void nearPickupShow();

    void refreshMessageCount(int i);

    void refreshMessageCount(IMSysChatUnreadCount iMSysChatUnreadCount);

    void setData(DriverOptionModel driverOptionModel);

    void setIMClickable(boolean z);

    void setIMEntranceIcon(int i);

    void setIMLastMsg(IMMsg iMMsg);

    void setOnIMEntranceClickListener(OnIMEntranceClickListener onIMEntranceClickListener);

    void show();
}
