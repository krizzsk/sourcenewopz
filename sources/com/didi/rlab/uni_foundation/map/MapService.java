package com.didi.rlab.uni_foundation.map;

public interface MapService {
    void addMapAnnotations(MapServiceAnnotationDataModel mapServiceAnnotationDataModel);

    void addMapSearchRoute(MapServiceTripModel mapServiceTripModel);

    void clearMapAllElement();

    long getMapZoomLevel();

    boolean isDowngradeMap();

    void makeCenterCoordinate();

    void setMapBestView();

    void setMapOverView();

    void setMapPadding(double d, double d2, double d3, double d4);

    void setMapRecenter();

    void updateHeadingAngle(double d);

    void updateUserLocation(double d, double d2);
}
