package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.location.IOrderPassPoint;
import com.dmap.navigation.jni.swig.OrderPassPointList;
import java.util.List;

public class OrderPassPointListNative extends OrderPassPointList {
    public OrderPassPointListNative(List<IOrderPassPoint> list) {
        if (list != null) {
            for (IOrderPassPoint orderPassPointNative : list) {
                add(new OrderPassPointNative(orderPassPointNative));
            }
        }
    }
}
