package com.didichuxing.carsliding.anim;

import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.Marker;
import java.util.List;

public interface ISlidingAnimator {
    void bind(MarkerInfo markerInfo, SlidingMeta slidingMeta);

    void destroy(boolean z);

    void dismiss(boolean z, boolean z2);

    void display(boolean z, boolean z2);

    Marker get();

    void insertAnimParamsCollection(List<SlidingMeta> list);

    void updateIcon(BitmapDescriptor bitmapDescriptor);

    void updatePosition(SlidingMeta slidingMeta, boolean z);
}
