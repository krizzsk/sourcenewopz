package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.location.IOrderPassPoint;
import com.dmap.navigation.jni.swig.OrderPassPoint;
import java.math.BigInteger;

public class OrderPassPointNative extends OrderPassPoint {
    OrderPassPointNative(IOrderPassPoint iOrderPassPoint) {
        setOrderId(BigInteger.valueOf(iOrderPassPoint.getOrderId()));
        setOrderType(iOrderPassPoint.getOrderType());
        setPointType(iOrderPassPoint.getPointType());
        setPoi(new NaviPoiNative(iOrderPassPoint.getPoi()));
    }
}
