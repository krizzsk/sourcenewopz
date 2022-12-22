package com.dmap.navigation.engine.core;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.jni.swig.BindNaviLocation;
import java.util.List;

public interface INaviEngineVP {
    void destory();

    BindNaviLocation getMatchLocation(INaviLocation iNaviLocation);

    void init();

    void setRoutePoints(List<LatLng> list);
}
