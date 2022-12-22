package com.rider.rlab_im_map_plugin.map;

import com.didi.rlab.uni_im_map.map.IMMapMarkerBubble;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface IMapViewProvider {
    ImMapView getMapView();

    void goToGpsSetting();

    void setHintView(int i, int i2, int i3, int i4);

    void setMapCenterCoordinate();

    void setMapIMDropMarker(IMMapMarkerBubble iMMapMarkerBubble);

    void setMapRecenter();

    void setMapView(ImMapView imMapView);

    void startMapNavigation(double d, double d2);
}
