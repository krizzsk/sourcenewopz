package com.didi.map.global.component.departure.pin;

import android.content.Context;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.pin.DepartureMarkerView;

public interface IPinDrawer {
    void add();

    void create(Context context, Map map);

    <T extends DepartureBubble> T createDepartureBubble(Class<T> cls);

    void destroy();

    View getDepartureBubbleView();

    int getPinHeight();

    boolean isVisible();

    void onMapVisible(boolean z);

    void remove();

    void removeDepartureBubble(boolean z);

    void setConfigParam(PinStyle pinStyle);

    void setDurationMillis(long j);

    @Deprecated
    void setNoStopZoneStatus();

    void startJumpAnimation(DepartureMarkerView.AnimationFinishListener animationFinishListener);

    void startLoadingAnimation();

    void stopAnimation();

    void visible(boolean z);
}
