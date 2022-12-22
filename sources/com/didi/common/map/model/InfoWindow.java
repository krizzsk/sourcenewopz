package com.didi.common.map.model;

import android.view.View;
import com.didi.common.map.listener.OnInfoWindowClickListener;

public interface InfoWindow {

    public enum Position {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        LEFT_TOP,
        RIGHT_TOP,
        RIGHT_BOTTOM,
        LEFT_BOTTOM
    }

    void addOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void destroy();

    Marker getInfoWindowMarker();

    void hideInfoWindow();

    boolean isInfoWindowShown();

    void removeOnInfoWindowClickListener();

    void setPosition(Position position);

    void setPosition(LatLng latLng);

    void showInfoWindow(View view);

    void updateAnchor();
}
