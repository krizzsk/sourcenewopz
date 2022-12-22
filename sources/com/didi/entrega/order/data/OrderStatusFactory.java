package com.didi.entrega.order.data;

import com.didi.entrega.order.data.model.AbstractOrderStatus;
import com.didi.entrega.order.data.model.OrderStatus1100;
import com.didi.entrega.order.data.model.OrderStatus1200;
import com.didi.entrega.order.data.model.OrderStatus1300;
import com.didi.entrega.order.data.model.OrderStatus1400;
import com.didi.entrega.order.data.model.OrderStatus1500;
import com.didi.entrega.order.data.model.OrderStatus1600;
import com.didi.entrega.order.data.model.OrderStatusCommon;

public class OrderStatusFactory {
    OrderStatusFactory() {
    }

    public static AbstractOrderStatus getOrderStatus(int i) {
        if (i == 1100) {
            return new OrderStatus1100();
        }
        if (i == 1200) {
            return new OrderStatus1200();
        }
        if (i == 1300) {
            return new OrderStatus1300();
        }
        if (i == 1400) {
            return new OrderStatus1400();
        }
        if (i == 1500) {
            return new OrderStatus1500();
        }
        if (i != 1600) {
            return new OrderStatusCommon();
        }
        return new OrderStatus1600();
    }
}
