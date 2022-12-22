package com.dmap.navigation.base.ctx;

import com.dmap.navigation.base.location.IOrderPassPoint;
import java.math.BigInteger;
import java.util.List;

public interface IOrderInfo {
    String getOrderId();

    void setOdPointsTimestamp(BigInteger bigInteger);

    void setOrderId(String str);

    void setOrderPassPoints(List<IOrderPassPoint> list);

    void setOrderStage(int i);

    void setPassengerId(String str);

    void setPsgMultiRouteTraceId(String str);

    void setTraverId(String str);
}
