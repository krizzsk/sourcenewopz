package com.didi.map.global.component.departure.view;

import android.view.View;
import com.sdk.poibase.model.poi.FenceInfo;

public interface ITerminalWelcomeView {

    public interface Callback {
        void onClickSelectOtherArea();

        void onClickSetPickupSpot();
    }

    View getView();

    boolean isValid();

    void setCallback(Callback callback);

    void setData(FenceInfo fenceInfo);
}
