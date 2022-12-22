package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.ctx.IOrderInfo;
import com.dmap.navigation.base.location.IOrderPassPoint;
import com.dmap.navigation.jni.swig.OrderInfo;
import java.util.List;

public class OrderInfoNative extends OrderInfo implements IOrderInfo {
    public OrderInfoNative() {
        setTraverId("");
        setOrderId("");
        setOrderStage(0);
        setPassengerId("");
        setPsgMultiRouteTraceId("");
    }

    public void setOrderPassPoints(List<IOrderPassPoint> list) {
        setPassPoints(new OrderPassPointListNative(list));
    }
}
