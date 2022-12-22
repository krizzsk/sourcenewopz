package com.didi.map.sdk.departure.internal.pin;

import android.view.View;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IUIComponent;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.internal.pin.DepartureMarkerView;
import com.didi.map.sdk.departure.param.PinStyle;

public interface IPinDrawer extends IBaseComponent<PinStyle>, IUIComponent {
    <T extends DepartureBubble> T createDepartureBubble(Class<T> cls);

    View getDepartureBubbleView();

    int getPinHeight();

    void removeDepartureBubble(boolean z);

    void setDurationMillis(long j);

    @Deprecated
    void setNoStopZoneStatus();

    void startJumpAnimation(DepartureMarkerView.AnimationFinishListener animationFinishListener);

    void startLoadingAnimation();

    void stopAnimation();
}
