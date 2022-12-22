package com.rider.rlab_im_map_plugin.map;

import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface IMapView {
    Map getMap();

    void getMapAsync(IMapReadyCallBack iMapReadyCallBack);

    MapView getMapView();

    boolean isDowngradeMap();

    void setHintView(int i, int i2, int i3, int i4);

    void setMapCenterCoordinate();

    void setMapRecenter();
}
