package com.dmap.navigation.api.route;

import com.didi.map.base.RouteSectionWithName;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.IPassPoint;
import com.dmap.navigation.base.route.IRoute;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_void;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface IRouteEx extends IRoute {
    double getConfidence();

    byte[] getExtendData();

    Collection<RouteSectionWithName> getFishboneRoadnames();

    int getJamCost();

    List<LatLng> getLights();

    int getMandatory();

    List<IMarkerSection> getMarkerSections();

    List<DidiMapExt.MJOLinkInfo> getMjoLinkInfos();

    SWIGTYPE_p_void getPbHandle();

    int getRemainDistance(int i);

    int getRemainTime(int i);

    List<IPassPoint> getRoutePassPoints();

    int getSavingTime();

    HashMap<String, IRouteTag> getTags();

    List<ITunnelGeoPoint> getTunnelGeoPoints();

    boolean hasMjoEvent();

    void updateEda(int i, int i2);

    void updateEta(int i, int i2);
}
