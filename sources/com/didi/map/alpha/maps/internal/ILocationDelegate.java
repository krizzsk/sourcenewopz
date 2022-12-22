package com.didi.map.alpha.maps.internal;

import android.location.Location;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.LocationSource;
import com.didi.map.outer.model.MyLocationOption;

public interface ILocationDelegate {
    void disableMylocation();

    boolean enableMylocation();

    boolean enableMylocation(float f, float f2, float f3);

    Location getMyLocation();

    MyLocationOption getMyLocationOption();

    boolean isProviderEnable();

    void release();

    void setLocationSource(LocationSource locationSource);

    void setMyLocationOption(MyLocationOption myLocationOption);

    void setMyLocationOption(MyLocationOption myLocationOption, float f, float f2, float f3);

    void setOnMyLocationChangeListener(DidiMap.OnMyLocationChangeListener onMyLocationChangeListener);
}
