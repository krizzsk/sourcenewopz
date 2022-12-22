package com.didi.component.matchtogo20.ontrip.view;

import com.didi.component.core.IView;
import com.didi.component.matchtogo20.ontrip.AbsMTGOnTripPresenter;
import com.didi.component.matchtogo20.ontrip.model.MatchOnTripModel;

public interface IMTGOnTripView extends IView<AbsMTGOnTripPresenter> {
    void setOnTripMode(MatchOnTripModel matchOnTripModel, long j);

    void updateWaitTiem(int i);
}
