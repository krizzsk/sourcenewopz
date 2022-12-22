package com.didichuxing.carsliding.api;

import com.didi.common.map.model.BitmapDescriptor;
import com.didichuxing.carsliding.model.RenderParams;
import com.didichuxing.carsliding.model.RenderResult;
import java.util.List;

public interface CarSlidingRender {
    public static final String CAR_SLIDING_MARKER_TAG = "CAR_SLIDING_MARKER_TAG";

    void destroy();

    void hide(boolean z);

    void initIcon(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2);

    List<RenderResult> render(RenderParams renderParams);

    void show(boolean z);
}
