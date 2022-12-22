package com.didi.map.sdk.departure.internal.rec;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IUIComponent;

public interface IRecMarker extends IBaseComponent<RecMarkerParam>, IUIComponent, Square {
    float getAlpha();

    LatLng getLocation();

    void hideCircles();

    boolean isInCenter();

    void onMapStable();

    void setAlpha(float f);

    void setNeedShowInfoWindow(boolean z);

    void showCircles();

    void showTransientCircles();
}
