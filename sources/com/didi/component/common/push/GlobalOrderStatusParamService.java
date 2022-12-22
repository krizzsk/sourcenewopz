package com.didi.component.common.push;

import com.didi.component.business.util.CarOrderHelper;
import com.didi.sdk.push.fcm.IOrderStatusParamsService;

public class GlobalOrderStatusParamService implements IOrderStatusParamsService {
    public int getLocalStatus() {
        return CarOrderHelper.getOrderStatus();
    }

    public int getLocalSubStatus() {
        return CarOrderHelper.getOrderSubStatus();
    }

    public String getLocalOrderId() {
        return CarOrderHelper.getOrderId();
    }
}
