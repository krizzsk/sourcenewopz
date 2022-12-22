package com.didi.soda.customer.map;

import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;

public interface IMapLineView {
    Marker addMarker(String str, MarkerOptions markerOptions);

    void centerBestView(LatLng latLng);

    MapView getMapView();

    void hideMyLocationMarker();

    void removeMarker(String str);

    void setMapVendor(MapVendor mapVendor);

    void showMyLocationMarker();
}
