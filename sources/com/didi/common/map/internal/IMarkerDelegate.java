package com.didi.common.map.internal;

import android.content.Context;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.animation.Animation;
import com.didi.common.map.model.animation.AnimationListener;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public interface IMarkerDelegate extends IMapElementDelegate {
    float getAlpha();

    List<LatLng> getBounderPoints() throws MapNotExistApiException;

    BitmapDescriptor getIcon();

    LatLng getPosition();

    float getRotation();

    String getSnippet();

    String getTitle();

    boolean isDraggable() throws MapNotExistApiException;

    boolean isFlat() throws MapNotExistApiException;

    void setAlpha(float f) throws MapNotExistApiException;

    void setAnchor(float f, float f2) throws MapNotExistApiException;

    void setAnimationListener(AnimationListener animationListener) throws MapNotExistApiException;

    void setDraggable(boolean z) throws MapNotExistApiException;

    void setFlat(boolean z) throws MapNotExistApiException;

    void setIcon(Context context, BitmapDescriptor bitmapDescriptor) throws MapNotExistApiException;

    void setPosition(LatLng latLng) throws MapNotExistApiException;

    void setRotation(float f) throws MapNotExistApiException;

    void setSnippet(String str) throws MapNotExistApiException;

    void setTitle(String str) throws MapNotExistApiException;

    void startAnimation(Animation animation) throws MapNotExistApiException;
}
