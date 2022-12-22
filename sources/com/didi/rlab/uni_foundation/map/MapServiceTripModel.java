package com.didi.rlab.uni_foundation.map;

import com.didi.rlab.uni_foundation.heatmap.MapLineOptions;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapServiceTripModel extends UniModel {

    /* renamed from: a */
    private String f34075a;

    /* renamed from: b */
    private String f34076b;

    /* renamed from: c */
    private boolean f34077c;

    /* renamed from: d */
    private MapLineOptions f34078d;

    /* renamed from: e */
    private MapLineOptions f34079e;

    /* renamed from: f */
    private MapLineOptions f34080f;

    /* renamed from: g */
    private List<MapServiceTripPoiDataModel> f34081g;

    public String getOrderId() {
        return this.f34075a;
    }

    public void setOrderId(String str) {
        this.f34075a = str;
    }

    public String getUid() {
        return this.f34076b;
    }

    public void setUid(String str) {
        this.f34076b = str;
    }

    public boolean getIsShowOtherRoute() {
        return this.f34077c;
    }

    public void setIsShowOtherRoute(boolean z) {
        this.f34077c = z;
    }

    public MapLineOptions getCurrentRouteOptions() {
        return this.f34078d;
    }

    public void setCurrentRouteOptions(MapLineOptions mapLineOptions) {
        this.f34078d = mapLineOptions;
    }

    public MapLineOptions getOtherRouteOptions() {
        return this.f34079e;
    }

    public void setOtherRouteOptions(MapLineOptions mapLineOptions) {
        this.f34079e = mapLineOptions;
    }

    public MapLineOptions getWalkRouteOptions() {
        return this.f34080f;
    }

    public void setWalkRouteOptions(MapLineOptions mapLineOptions) {
        this.f34080f = mapLineOptions;
    }

    public List<MapServiceTripPoiDataModel> getAfterList() {
        return this.f34081g;
    }

    public void setAfterList(List<MapServiceTripPoiDataModel> list) {
        this.f34081g = list;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", this.f34075a);
        hashMap.put("uid", this.f34076b);
        hashMap.put("isShowOtherRoute", Boolean.valueOf(this.f34077c));
        MapLineOptions mapLineOptions = this.f34078d;
        if (mapLineOptions != null) {
            hashMap.put("currentRouteOptions", mapLineOptions.toMap());
        }
        MapLineOptions mapLineOptions2 = this.f34079e;
        if (mapLineOptions2 != null) {
            hashMap.put("otherRouteOptions", mapLineOptions2.toMap());
        }
        MapLineOptions mapLineOptions3 = this.f34080f;
        if (mapLineOptions3 != null) {
            hashMap.put("walkRouteOptions", mapLineOptions3.toMap());
        }
        hashMap.put("afterList", map(this.f34081g, $$Lambda$MapServiceTripModel$ERXzhCi8cBy9i5BU2cRfScS6yWk.INSTANCE));
        return hashMap;
    }

    public static MapServiceTripModel fromMap(Map<String, Object> map) {
        MapServiceTripModel mapServiceTripModel = new MapServiceTripModel();
        String str = "";
        mapServiceTripModel.f34075a = (!map.containsKey("orderId") || map.get("orderId") == null) ? str : (String) map.get("orderId");
        if (map.containsKey("uid") && map.get("uid") != null) {
            str = (String) map.get("uid");
        }
        mapServiceTripModel.f34076b = str;
        mapServiceTripModel.f34077c = (!map.containsKey("isShowOtherRoute") || map.get("isShowOtherRoute") == null) ? false : ((Boolean) map.get("isShowOtherRoute")).booleanValue();
        MapLineOptions mapLineOptions = null;
        mapServiceTripModel.f34078d = (!map.containsKey("currentRouteOptions") || map.get("currentRouteOptions") == null) ? null : MapLineOptions.fromMap((Map) map.get("currentRouteOptions"));
        mapServiceTripModel.f34079e = (!map.containsKey("otherRouteOptions") || map.get("otherRouteOptions") == null) ? null : MapLineOptions.fromMap((Map) map.get("otherRouteOptions"));
        if (map.containsKey("walkRouteOptions") && map.get("walkRouteOptions") != null) {
            mapLineOptions = MapLineOptions.fromMap((Map) map.get("walkRouteOptions"));
        }
        mapServiceTripModel.f34080f = mapLineOptions;
        mapServiceTripModel.f34081g = (!map.containsKey("afterList") || map.get("afterList") == null) ? new ArrayList<>() : map((List) map.get("afterList"), $$Lambda$MapServiceTripModel$x69pL2G613ZkfYvqm8U9k4Zk3dQ.INSTANCE);
        return mapServiceTripModel;
    }
}
