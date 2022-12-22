package com.didi.map.global.component.recmarker.view;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.recmarker.model.RecMarkerParam;

public interface IRecMarker {
    void add();

    void create(Context context, Map map);

    void destroy();

    float getAlpha();

    String getId();

    LatLng getLocation();

    void hideCircles();

    boolean isInCenter();

    boolean isVisible();

    void onMapScroll();

    void onMapStable();

    void onMapVisible(boolean z);

    void remove();

    void setAlpha(float f);

    void setConfigParam(RecMarkerParam recMarkerParam);

    void setLabelDirect(int i);

    void setNeedShowInfoWindow(boolean z);

    void setPined(boolean z);

    void showCircles();

    void showTransientCircles();

    void visible(boolean z);
}
