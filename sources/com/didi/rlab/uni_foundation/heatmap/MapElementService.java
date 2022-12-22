package com.didi.rlab.uni_foundation.heatmap;

public interface MapElementService {
    void drawLine(LineModel lineModel, String str);

    void drawMarkerBubble(MapMarkerOptions mapMarkerOptions, MapMarkerBubble mapMarkerBubble, double d, double d2, String str);

    void drawPolygon(PolygonModel polygonModel, String str);

    PositionModel getShapePoints(String str);

    void removeAll();

    void removeLine(String str);

    void removeMarker(String str);

    void removePolygon(String str);

    void setFocusCenter(LineModel lineModel);
}
