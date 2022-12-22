package com.didi.soda.customer.component.flutterordermap.model;

public class OrderStatusFactory {
    OrderStatusFactory() {
    }

    public static AbstractOrderStatus getOrderStatus(int i) {
        if (i == 100) {
            return new OrderStatus100();
        }
        if (i == 120) {
            return new OrderStatus120();
        }
        if (i == 140) {
            return new OrderStatus140();
        }
        if (i == 200 || i == 300) {
            return new OrderStatus200();
        }
        if (i == 400) {
            return new OrderStatus400();
        }
        if (i != 500) {
            return new OrderStatusCommon();
        }
        return new OrderStatus500();
    }
}
