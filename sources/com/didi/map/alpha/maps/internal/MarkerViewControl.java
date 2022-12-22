package com.didi.map.alpha.maps.internal;

import android.view.View;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MarkerView;

public interface MarkerViewControl {
    MarkerView add(View view, LatLng latLng);

    void remove(MarkerView markerView, Object obj);

    void setCenter(MarkerView markerView, Object obj, LatLng latLng);
}
