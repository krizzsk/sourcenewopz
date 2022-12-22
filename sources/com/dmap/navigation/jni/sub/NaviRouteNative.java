package com.dmap.navigation.jni.sub;

import com.dmap.navigation.api.route.IRouteEx;
import com.dmap.navigation.api.route.IRouteTag;
import com.dmap.navigation.jni.swig.NaviRoute;
import com.dmap.navigation.jni.swig.StringMap;
import java.util.Map;
import java.util.Set;

public class NaviRouteNative extends NaviRoute {
    public NaviRouteNative(IRouteEx iRouteEx) {
        setRouteId(iRouteEx.getRouteId());
        setConfidence(iRouteEx.getConfidence());
        setReqEventType(iRouteEx.getReqEventType());
        setPbHandle(iRouteEx.getPbHandle());
        Set<Map.Entry<String, IRouteTag>> entrySet = iRouteEx.getTags().entrySet();
        StringMap stringMap = new StringMap();
        for (Map.Entry next : entrySet) {
            stringMap.set((String) next.getKey(), ((IRouteTag) next.getValue()).getValue());
        }
        setStart(new NaviPoiNative(iRouteEx.getStart()));
        setEnd(new NaviPoiNative(iRouteEx.getEnd()));
        setOriginalPassPoints(new NaviPoiListNative(iRouteEx.getOriginalPassPoints()));
    }
}
