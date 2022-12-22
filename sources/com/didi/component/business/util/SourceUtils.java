package com.didi.component.business.util;

import com.didi.travel.psnger.model.response.CarOrder;

public class SourceUtils {
    private SourceUtils() {
    }

    public static int getSource() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return 3;
        }
        int i = order.orderSource;
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 0;
        }
        if (i != 3) {
            return 3;
        }
        return 2;
    }
}
