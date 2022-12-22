package com.didi.map.google.widget;

import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import java.util.List;

public interface ISctxViewDelegate {
    void destroy();

    void destroyInfoWindow();

    CarMarker getCarMarker();

    boolean refresh3DCarIcons(boolean z, List<String> list);

    void removeMarker();

    void set3DCarEnabled(boolean z);

    void set3DCarIcons(List<String> list);

    void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor);

    void setCarMarkerZIndex(int i);

    void setLocationDelegate(IMyLocationDelegate iMyLocationDelegate);

    void showInfoWindow(Map map, View view);

    void updateCarDirection(float f);

    void updateCarMarker(LatLng latLng);
}
