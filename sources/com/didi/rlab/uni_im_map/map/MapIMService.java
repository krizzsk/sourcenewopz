package com.didi.rlab.uni_im_map.map;

public interface MapIMService {
    void closeImMapPage();

    double distanceBetween(double d, double d2, double d3, double d4);

    void getCustomerOrderInfo(String str);

    IMLocationResult getLocationInfo();

    void notHandleMapEvents(boolean z);

    void sendMapIMLocation(IMMapMarkerBubble iMMapMarkerBubble);

    void setCamera(double d, double d2);

    void setMapIMDropMarker(IMMapMarkerBubble iMMapMarkerBubble);

    void setMapIMPadding(double d, double d2, double d3, double d4);

    void setMapIMRecenter();

    void startOverView(double d, double d2);

    void startPoiRequest(double d, double d2);
}
