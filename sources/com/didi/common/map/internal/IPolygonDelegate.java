package com.didi.common.map.internal;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public interface IPolygonDelegate extends IMapElementDelegate {
    List<LatLng> getBounderPoints() throws MapNotExistApiException;

    int getFillColor();

    int getStrokeColor();

    int getStrokeWidth();

    void setFillColor(int i) throws MapNotExistApiException;

    void setStrokeColor(int i) throws MapNotExistApiException;

    void setStrokeWidth(int i) throws MapNotExistApiException;
}
