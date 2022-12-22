package com.didi.map.sdk.departure.internal.markers;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IUIComponent;
import com.didi.map.sdk.departure.internal.rec.IRecMarker;

public interface IRecMarkerController extends IBaseComponent<RecMarkerControllerParam>, IUIComponent {
    IRecMarker findMarker(LatLng latLng);

    void hideCircles();

    void onMapStable();

    void onZoomChange(double d);

    void remove(int i);

    void setNeedShowInfoWindow(boolean z);

    void showCircles();

    void showTransientCircles(LatLng latLng);
}
