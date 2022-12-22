package com.dmap.navigation.base.location;

public interface IOrderPassPoint {
    long getOrderId();

    int getOrderType();

    INaviPoi getPoi();

    int getPointType();
}
