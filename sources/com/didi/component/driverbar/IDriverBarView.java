package com.didi.component.driverbar;

import android.view.ViewGroup;
import com.didi.component.core.IView;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarStyle;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.map.global.flow.model.EtaEda;

public interface IDriverBarView extends IView<AbsDriverBarPresenter> {
    public static final int CONTAINER_IM = 1;
    public static final int CONTAINER_PHONE = 2;

    ViewGroup getContainer(int i);

    void handleBluetoothMeetEntranceShow(Boolean bool);

    void hideBlueMeetGuide();

    void hideCarUpdateInfo();

    boolean isPhoneVisible();

    void nearPickupShow(EtaEda etaEda);

    void newMessageBubbleShow(boolean z);

    void setData(DriverBarCardInfo driverBarCardInfo);

    void setData(DriverBarV2Model driverBarV2Model);

    void setDriverBarStyle(DriverBarStyle driverBarStyle);

    void setPhoneVisible(boolean z);

    void showCarUpdateInfo(String str, String str2, String str3, String str4);

    void showPhoneGuide(String str);
}
