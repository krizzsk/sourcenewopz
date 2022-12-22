package com.didi.map.global.flow.scene.simple;

import android.view.View;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.flow.scene.ISceneController;

public interface ISimpleMapSceneController extends ISceneController {
    View getDepartureTerminalView();

    void onConfirmClickInBroadOther();

    boolean onDomainChanged();

    void onOrderIntercepted(IOrderInterceptCallbackNew iOrderInterceptCallbackNew);

    void refreshCarIcon();

    void setPadding(Padding padding);

    void updatePositionWhenOutStation(DepartureLocationInfo departureLocationInfo);
}
