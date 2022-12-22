package com.didichuxing.routesearchsdk;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.LegInfo;
import java.util.ArrayList;
import java.util.List;

public class RouteConverter {
    public static List<LatLng> getLatLngListFromLegInfo(LegInfo legInfo) {
        ArrayList arrayList = new ArrayList();
        if (legInfo != null) {
            for (DoublePoint next : legInfo.geos) {
                if (next != null) {
                    arrayList.add(new LatLng((double) next.lat.floatValue(), (double) next.lng.floatValue()));
                }
            }
        }
        return arrayList;
    }
}
