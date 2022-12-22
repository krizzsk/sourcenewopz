package com.didi.entrega.order.data.model;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class OrderStatusCommon extends AbstractOrderStatus {
    public List<LatLng> getBestViewLocation() {
        return null;
    }

    public LatLng getTipLocation() {
        return null;
    }
}
