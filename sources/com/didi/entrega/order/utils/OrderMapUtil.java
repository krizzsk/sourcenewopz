package com.didi.entrega.order.utils;

import com.didi.common.map.model.LatLng;
import com.didi.entrega.order.data.model.OrderMapStatusModel;
import com.didi.sdk.util.TextUtil;
import java.util.Objects;

public class OrderMapUtil {
    public static boolean isOrderIdChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (orderMapStatusModel != null) {
            return !orderMapStatusModel.getOrderId().equals(orderMapStatusModel2.getOrderId());
        }
        return false;
    }

    public static boolean isOrderStatusChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (orderMapStatusModel == null || orderMapStatusModel.getOrderStatus() != orderMapStatusModel2.getOrderStatus()) {
            return true;
        }
        if (orderMapStatusModel2.getOrderStatus() != 1600 || orderMapStatusModel2.getIsShowMap() == orderMapStatusModel.getIsShowMap()) {
            return false;
        }
        return true;
    }

    public static boolean hasNoOrderTip(OrderMapStatusModel orderMapStatusModel) {
        if (orderMapStatusModel.getMapData() == null || orderMapStatusModel.getMapData().getTip() == null || TextUtil.isEmpty(orderMapStatusModel.getMapData().getTip().getStatusDesc()) || orderMapStatusModel.getOrderStatus() <= 0 || orderMapStatusModel.getOrderStatus() >= 1800 || (orderMapStatusModel.getOrderStatus() == 1600 && orderMapStatusModel.getIsShowMap() == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isOrderTipStatusChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (hasNoOrderTip(orderMapStatusModel2)) {
            return false;
        }
        if (orderMapStatusModel != null) {
            return isOrderStatusChange(orderMapStatusModel, orderMapStatusModel2);
        }
        return true;
    }

    public static boolean isOrderTipContentChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (hasNoOrderTip(orderMapStatusModel2)) {
            return false;
        }
        if (orderMapStatusModel == null || orderMapStatusModel.getMapData() == null) {
            return true;
        }
        return !Objects.equals(orderMapStatusModel.getMapData().getTip(), orderMapStatusModel2.getMapData().getTip());
    }

    public static LatLng getLineCenter(LatLng latLng, LatLng latLng2) {
        return new LatLng((latLng.latitude + latLng2.latitude) / 2.0d, (latLng.longitude + latLng2.longitude) / 2.0d);
    }
}
