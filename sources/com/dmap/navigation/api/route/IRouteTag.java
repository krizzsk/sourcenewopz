package com.dmap.navigation.api.route;

import com.didi.map.outer.model.LatLng;

public interface IRouteTag {
    public static final String DYNAMIC_ROUTE_ABTEST = "ABTest";
    public static final String DYNAMIC_ROUTE_POP = "avoidJamPop";
    public static final String INNER_ROUTE_POS = "innerRoutePos";
    public static final String IS_CHARGE = "charge";
    public static final String IS_DYNAMIC_ROUTE = "IsAvoidJam";
    public static final String IS_MULTI_ROUTE = "IsMultiRoute";
    public static final String KEY_ROAD_NAME = "KeyRoadName";
    public static final String ROUTE_SCENE = "routeScene";
    public static final String ROUTE_TRAIT_NAME = "routeTraitName";
    public static final String TOLL_CHARGE_PRICE = "toll_charge_price";
    public static final String TOLL_POSITION = "tollPos";

    String getKey();

    LatLng getPosition();

    String getValue();
}
