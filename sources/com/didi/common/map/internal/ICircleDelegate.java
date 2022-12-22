package com.didi.common.map.internal;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public interface ICircleDelegate extends IMapElementDelegate {
    boolean contains(LatLng latLng);

    LatLng getBottomTangencyPoint();

    List<LatLng> getBounderPoints();

    LatLng getCenter() throws MapNotExistApiException;

    int getFillColor() throws MapNotExistApiException;

    double getRadius() throws MapNotExistApiException;

    int getStrokeColor() throws MapNotExistApiException;

    float getStrokeWidth() throws MapNotExistApiException;

    void setCenter(LatLng latLng) throws MapNotExistApiException;

    void setFillColor(int i) throws MapNotExistApiException;

    void setRadius(double d) throws MapNotExistApiException;

    void setStrokeColor(int i) throws MapNotExistApiException;

    void setStrokeWidth(float f) throws MapNotExistApiException;
}
