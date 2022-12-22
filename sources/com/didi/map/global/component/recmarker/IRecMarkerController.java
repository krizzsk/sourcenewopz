package com.didi.map.global.component.recmarker;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.recmarker.view.IRecMarker;

public interface IRecMarkerController {
    void add();

    void create(Context context, Map map);

    void destroy();

    IRecMarker findMarker(LatLng latLng);

    void hideCircles();

    boolean isVisible();

    void onMapScroll();

    void onMapStable();

    void onMapVisible(boolean z);

    void remove();

    void remove(int i);

    void setConfigParam(RecMarkerControllerParam recMarkerControllerParam);

    void setLabelDirect(String str, int i);

    void setNeedShowInfoWindow(boolean z);

    void setVisible(String str, boolean z);

    void showCircles();

    void showTransientCircles(LatLng latLng);

    void visible(boolean z);
}
