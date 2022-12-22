package com.didi.map.global.component.departure.view;

import android.view.View;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.model.SpecialPois;
import com.sdk.poibase.model.RpcPoi;

public interface ITerminalView {

    public interface Callback {
        void onClickBroadOther();

        void onClickChange(SpecialPois specialPois);

        void onClickConfirmPickup(RpcPoi rpcPoi);

        void onClickNext(SPoi sPoi);

        void onDepartureSelected(RpcPoi rpcPoi, int i);

        void onTerminalAreaSelected(SPoi sPoi, int i);
    }

    RpcPoi getSelectedDeparture();

    SPoi getSelectedTerminalArea();

    View getView();

    boolean isTerminal();

    boolean isValid();

    void performSelectedArea(SPoi sPoi, RpcPoi rpcPoi);

    void setCallback(Callback callback);

    void setCardStyle(int i);

    void setData(SpecialPois specialPois);

    void setPickupPoiNotice(String str);

    void setSelectedDeparture(RpcPoi rpcPoi);

    void setSelectedTerminalArea(SPoi sPoi);

    void setShowBroadOtherInAreaCard(boolean z);
}
